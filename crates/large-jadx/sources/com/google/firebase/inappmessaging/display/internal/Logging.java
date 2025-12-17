package com.google.firebase.inappmessaging.display.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logging {

    private static final String TAG = "FIAM.Display";
    public static void logd(String string) {
        final String str = "FIAM.Display";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, string);
        }
    }

    public static void logdHeader(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============ ");
        stringBuilder.append(string);
        stringBuilder.append(" ============");
        Logging.logd(stringBuilder.toString());
    }

    public static void logdNumber(String string, float f2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(": ");
        stringBuilder.append(f2);
        Logging.logd(stringBuilder.toString());
    }

    public static void logdPair(String string, float f2, float f3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(": (");
        stringBuilder.append(f2);
        stringBuilder.append(", ");
        stringBuilder.append(f3);
        stringBuilder.append(")");
        Logging.logd(stringBuilder.toString());
    }

    public static void loge(String string) {
        Log.e("FIAM.Display", string);
    }

    public static void logi(String string) {
        final String str = "FIAM.Display";
        if (Log.isLoggable(str, 4)) {
            Log.i(str, string);
        }
    }
}
