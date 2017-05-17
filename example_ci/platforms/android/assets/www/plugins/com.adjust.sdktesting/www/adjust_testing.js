cordova.define("com.adjust.sdktesting.AdjustTesting", function(require, exports, module) {
function callCordovaCallback(action, callback) {
    var args = Array.prototype.slice.call(arguments, 2);

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
    }
};

module.exports = AdjustTesting;

});
