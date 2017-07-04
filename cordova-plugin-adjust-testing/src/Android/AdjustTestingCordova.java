package com.adjust.sdktesting;

import com.adjust.testlibrary.TestLibrary;

import android.net.Uri;

import android.util.Log;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult.Status;

public class AdjustTestingCordova extends CordovaPlugin {
    private static final String TAG = "AdjustTestingCordova";
    private static final String COMMAND_INIT_TEST_SESSION   = "initTestSession";
    private static final String COMMAND_ADD_INFO_TO_SEND    = "addInfoToSend";
    private static final String COMMAND_SEND_INFO_TO_SERVER = "sendInfoToServer";
    private static final String COMMAND_SET_TESTS           = "setTests";

    private CallbackContext commandCallbackContext;
    private TestLibrary testLibrary;
    private String selectedTests;

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(COMMAND_INIT_TEST_SESSION)) {
            final String baseUrl = args.getString(0);
            Log.d(TAG, "initTestSession() with baseUrl[" + baseUrl + "]");

            this.commandCallbackContext = callbackContext;

            testLibrary = new TestLibrary(baseUrl, 
                    new CommandListener(
                        this.cordova.getActivity().getApplicationContext(), 
                        this.commandCallbackContext)
                    );
            if(selectedTests != null 
                    && !selectedTests.isEmpty()) {
                testLibrary.setTests(selectedTests);
            }

            testLibrary.initTestSession("cordova4.11.2@android4.11.4");
        } else if (action.equals(COMMAND_ADD_INFO_TO_SEND)) {
            final String key = args.getString(0);
            final String value = args.getString(1);
            Log.d(TAG, "AddInfoToSend() with key[" + key + "] and value[" + value + "]");

            if(testLibrary != null) {
                testLibrary.addInfoToSend(key, value);
            }
        } else if (action.equals(COMMAND_SEND_INFO_TO_SERVER)) {
            Log.d(TAG, "SendInfoToServer() ");

            if(testLibrary != null) {
                testLibrary.sendInfoToServer();
            }
        } else if (action.equals(COMMAND_SET_TESTS)) {
            Log.d(TAG, "setTests() ");
            this.selectedTests = args.getString(0);
        }

        return true;
    }
}
