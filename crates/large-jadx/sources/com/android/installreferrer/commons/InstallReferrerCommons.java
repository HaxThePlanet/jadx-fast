package com.android.installreferrer.commons;

import android.util.Log;

/* loaded from: classes.dex */
public final class InstallReferrerCommons {
    public static void logVerbose(String string, String string2) {
        if (Log.isLoggable(string, 2)) {
            Log.v(string, string2);
        }
    }

    public static void logWarn(String string, String string2) {
        if (Log.isLoggable(string, 5)) {
            Log.w(string, string2);
        }
    }
}
