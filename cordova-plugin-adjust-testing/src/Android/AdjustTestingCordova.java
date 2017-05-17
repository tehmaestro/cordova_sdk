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
    private static final String KEY_BASE_URL              = "baseUrl";
    private static final String COMMAND_INIT_TEST_SESSION = "initTestSession";

    private CallbackContext commandCallbackContext;

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(COMMAND_INIT_TEST_SESSION)) {
            final String baseUrl = args.getString(0);
            Log.d(TAG, "initTestSession() with baseUrl[" + baseUrl + "]");

            this.commandCallbackContext = callbackContext;

            TestLibrary testLibrary = new TestLibrary(baseUrl, 
                    new CommandListener(this.cordova.getActivity().getApplicationContext(), 
                        this.commandCallbackContext));
            testLibrary.initTestSession("cordova4.11.2@android4.11.4");
        }

        return true;
    }
}
