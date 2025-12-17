package androidx.startup;

import android.util.Log;

/* loaded from: classes5.dex */
public final class StartupLogger {

    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";
    public static void e(String message, Throwable throwable) {
        Log.e("StartupLogger", message, throwable);
    }

    public static void i(String message) {
        Log.i("StartupLogger", message);
    }

    public static void w(String message) {
        Log.w("StartupLogger", message);
    }
}
