package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logger {

    static final com.google.firebase.crashlytics.internal.Logger DEFAULT_LOGGER = null;
    public static final String TAG = "FirebaseCrashlytics";
    private int logLevel = 4;
    private final String tag;
    static {
        Logger logger = new Logger("FirebaseCrashlytics");
        Logger.DEFAULT_LOGGER = logger;
    }

    public Logger(String string) {
        super();
        this.tag = string;
        final int obj1 = 4;
    }

    private boolean canLog(int i) {
        String logLevel;
        int obj2;
        if (this.logLevel > i) {
            if (Log.isLoggable(this.tag, i)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public static com.google.firebase.crashlytics.internal.Logger getLogger() {
        return Logger.DEFAULT_LOGGER;
    }

    public void d(String string) {
        d(string, 0);
    }

    public void d(String string, Throwable throwable2) {
        boolean log;
        if (canLog(3)) {
            Log.d(this.tag, string, throwable2);
        }
    }

    public void e(String string) {
        e(string, 0);
    }

    public void e(String string, Throwable throwable2) {
        boolean log;
        if (canLog(6)) {
            Log.e(this.tag, string, throwable2);
        }
    }

    public void i(String string) {
        i(string, 0);
    }

    public void i(String string, Throwable throwable2) {
        boolean log;
        if (canLog(4)) {
            Log.i(this.tag, string, throwable2);
        }
    }

    public void log(int i, String string2) {
        log(i, string2, false);
    }

    public void log(int i, String string2, boolean z3) {
        boolean obj3;
        if (!z3) {
            if (canLog(i)) {
                Log.println(i, this.tag, string2);
            }
        } else {
        }
    }

    public void v(String string) {
        v(string, 0);
    }

    public void v(String string, Throwable throwable2) {
        boolean log;
        if (canLog(2)) {
            Log.v(this.tag, string, throwable2);
        }
    }

    public void w(String string) {
        w(string, 0);
    }

    public void w(String string, Throwable throwable2) {
        boolean log;
        if (canLog(5)) {
            Log.w(this.tag, string, throwable2);
        }
    }
}
