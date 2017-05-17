package com.adjust.sdktesting;

import android.content.Context;
import android.util.Log;

import com.adjust.testlibrary.ICommandRawJsonListener;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult.Status;

public class CommandListener implements ICommandRawJsonListener {
    private Context mContext;
    private CallbackContext mCommandCallbackContext;

    public CommandListener(Context context, CallbackContext commandCallbackContext) {
        mContext = context;
        mCommandCallbackContext = commandCallbackContext;
    }

    @Override
    public void executeCommand(String json) {
        PluginResult pluginResult = new PluginResult(Status.OK, json);
        pluginResult.setKeepCallback(true);

        this.mCommandCallbackContext.sendPluginResult(pluginResult);
    }
}
