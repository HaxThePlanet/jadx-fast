package com.google.firebase.perf.logging;

import java.util.Locale;

/* loaded from: classes2.dex */
public class AndroidLogger {

    private static volatile com.google.firebase.perf.logging.AndroidLogger instance;
    private boolean isLogcatEnabled;
    private final com.google.firebase.perf.logging.LogWrapper logWrapper;
    private AndroidLogger() {
        super(0);
    }

    public AndroidLogger(com.google.firebase.perf.logging.LogWrapper logWrapper) {
        com.google.firebase.perf.logging.LogWrapper obj2;
        super();
        this.isLogcatEnabled = false;
        if (logWrapper == null) {
            obj2 = LogWrapper.getInstance();
        }
        this.logWrapper = obj2;
    }

    public static com.google.firebase.perf.logging.AndroidLogger getInstance() {
        com.google.firebase.perf.logging.AndroidLogger instance;
        com.google.firebase.perf.logging.AndroidLogger androidLogger;
        instance = AndroidLogger.class;
        if (AndroidLogger.instance == null && AndroidLogger.instance == null) {
            instance = AndroidLogger.class;
            synchronized (instance) {
                androidLogger = new AndroidLogger();
                AndroidLogger.instance = androidLogger;
            }
        }
        return AndroidLogger.instance;
    }

    public void debug(String string) {
        boolean isLogcatEnabled;
        if (this.isLogcatEnabled) {
            this.logWrapper.d(string);
        }
    }

    public void debug(String string, Object... object2Arr2) {
        boolean isLogcatEnabled;
        Locale eNGLISH;
        String obj3;
        if (this.isLogcatEnabled) {
            this.logWrapper.d(String.format(Locale.ENGLISH, string, object2Arr2));
        }
    }

    public void error(String string) {
        boolean isLogcatEnabled;
        if (this.isLogcatEnabled) {
            this.logWrapper.e(string);
        }
    }

    public void error(String string, Object... object2Arr2) {
        boolean isLogcatEnabled;
        Locale eNGLISH;
        String obj3;
        if (this.isLogcatEnabled) {
            this.logWrapper.e(String.format(Locale.ENGLISH, string, object2Arr2));
        }
    }

    public void info(String string) {
        boolean isLogcatEnabled;
        if (this.isLogcatEnabled) {
            this.logWrapper.i(string);
        }
    }

    public void info(String string, Object... object2Arr2) {
        boolean isLogcatEnabled;
        Locale eNGLISH;
        String obj3;
        if (this.isLogcatEnabled) {
            this.logWrapper.i(String.format(Locale.ENGLISH, string, object2Arr2));
        }
    }

    public boolean isLogcatEnabled() {
        return this.isLogcatEnabled;
    }

    public void setLogcatEnabled(boolean z) {
        this.isLogcatEnabled = z;
    }

    public void verbose(String string) {
        boolean isLogcatEnabled;
        if (this.isLogcatEnabled) {
            this.logWrapper.v(string);
        }
    }

    public void verbose(String string, Object... object2Arr2) {
        boolean isLogcatEnabled;
        Locale eNGLISH;
        String obj3;
        if (this.isLogcatEnabled) {
            this.logWrapper.v(String.format(Locale.ENGLISH, string, object2Arr2));
        }
    }

    public void warn(String string) {
        boolean isLogcatEnabled;
        if (this.isLogcatEnabled) {
            this.logWrapper.w(string);
        }
    }

    public void warn(String string, Object... object2Arr2) {
        boolean isLogcatEnabled;
        Locale eNGLISH;
        String obj3;
        if (this.isLogcatEnabled) {
            this.logWrapper.w(String.format(Locale.ENGLISH, string, object2Arr2));
        }
    }
}
