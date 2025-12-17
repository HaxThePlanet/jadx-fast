package com.google.firebase.firestore.util;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logger {

    private static com.google.firebase.firestore.util.Logger.Level logLevel;

    public static enum Level {

        DEBUG,
        WARN,
        NONE;
    }
    static {
        Logger.logLevel = Logger.Level.WARN;
    }

    public static void debug(String string, String string2, Object... object3Arr3) {
        Logger.doLog(Logger.Level.DEBUG, string, string2, object3Arr3);
    }

    private static void doLog(com.google.firebase.firestore.util.Logger.Level logger$Level, String string2, String string3, Object... object4Arr4) {
        int stringBuilder;
        int ordinal;
        Object[] arr;
        int i;
        String str;
        int obj5;
        Object obj6;
        String obj7;
        stringBuilder = new StringBuilder();
        ordinal = 2;
        arr = new Object[ordinal];
        arr[0] = "24.0.0";
        i = 1;
        arr[i] = string2;
        stringBuilder.append(String.format("(%s) [%s]: ", arr));
        stringBuilder.append(String.format(string3, object4Arr4));
        obj6 = stringBuilder.toString();
        obj5 = Logger.1.$SwitchMap$com$google$firebase$firestore$util$Logger$Level[level.ordinal()];
        obj7 = "Firestore";
        if (level.ordinal() >= Logger.logLevel.ordinal() && obj5 != i && obj5 != ordinal) {
            stringBuilder = new StringBuilder();
            ordinal = 2;
            arr = new Object[ordinal];
            arr[0] = "24.0.0";
            i = 1;
            arr[i] = string2;
            stringBuilder.append(String.format("(%s) [%s]: ", arr));
            stringBuilder.append(String.format(string3, object4Arr4));
            obj6 = stringBuilder.toString();
            obj5 = Logger.1.$SwitchMap$com$google$firebase$firestore$util$Logger$Level[level.ordinal()];
            obj7 = "Firestore";
            if (obj5 != i) {
                if (obj5 != ordinal) {
                    if (obj5 == 3) {
                    } else {
                    }
                    obj5 = new IllegalStateException("Trying to log something on level NONE");
                    throw obj5;
                }
                Log.w(obj7, obj6);
            }
            Log.i(obj7, obj6);
        }
    }

    public static boolean isDebugEnabled() {
        int i;
        i = Logger.logLevel.ordinal() >= Logger.Level.DEBUG.ordinal() ? 1 : 0;
        return i;
    }

    public static void setLogLevel(com.google.firebase.firestore.util.Logger.Level logger$Level) {
        Logger.logLevel = level;
    }

    public static void warn(String string, String string2, Object... object3Arr3) {
        Logger.doLog(Logger.Level.WARN, string, string2, object3Arr3);
    }
}
