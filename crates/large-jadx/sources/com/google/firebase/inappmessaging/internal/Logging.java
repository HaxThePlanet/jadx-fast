package com.google.firebase.inappmessaging.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logging {

    public static final String TAG = "FIAM.Headless";
    public static void logd(String string) {
        final String str = "FIAM.Headless";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, string);
        }
    }

    public static void loge(String string) {
        Log.e("FIAM.Headless", string);
    }

    public static void logi(String string) {
        final String str = "FIAM.Headless";
        if (Log.isLoggable(str, 4)) {
            Log.i(str, string);
        }
    }

    public static void logw(String string) {
        Log.w("FIAM.Headless", string);
    }
}
