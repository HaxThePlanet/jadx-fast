package com.google.firebase.perf.logging;

import android.util.Log;

/* loaded from: classes2.dex */
class LogWrapper {

    private static final String LOG_TAG = "FirebasePerformance";
    private static com.google.firebase.perf.logging.LogWrapper instance;
    public static com.google.firebase.perf.logging.LogWrapper getInstance() {
        com.google.firebase.perf.logging.LogWrapper logWrapper;
        final Class<com.google.firebase.perf.logging.LogWrapper> obj = LogWrapper.class;
        synchronized (obj) {
            logWrapper = new LogWrapper();
            LogWrapper.instance = logWrapper;
            return LogWrapper.instance;
        }
    }

    void d(String string) {
        Log.d("FirebasePerformance", string);
    }

    void e(String string) {
        Log.e("FirebasePerformance", string);
    }

    void i(String string) {
        Log.i("FirebasePerformance", string);
    }

    void v(String string) {
        Log.v("FirebasePerformance", string);
    }

    void w(String string) {
        Log.w("FirebasePerformance", string);
    }
}
