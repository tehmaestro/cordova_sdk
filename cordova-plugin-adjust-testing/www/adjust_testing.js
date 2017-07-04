'use strict';

function callCordova(action) {
    var args = Array.prototype.slice.call(arguments, 1);

    cordova.exec(function callback(data) { },
        function errorHandler(err) { },
        'AdjustTesting',
        action,
        args
    );
}

function callCordovaCallback(action, callback) {
    var args = Array.prototype.slice.call(arguments, 2);

    console.log("CordovaCallback: action: " + action + " callback: " + callback);
    cordova.exec(callback,
        function errorHandler(err) { },
        'AdjustTesting',
        action,
        args
    );
}

var AdjustTesting = {
    initTestSession: function(baseUrl, callback) {
        callCordovaCallback('initTestSession', callback, baseUrl);
    },

    addInfoToSend: function(key, value) {
        callCordova('addInfoToSend', key, value);
    },

    sendInfoToServer: function() {
        callCordova('sendInfoToServer');
    },

    setTests: function(tests) {
        callCordova('setTests', tests);
    }
};

module.exports = AdjustTesting;
