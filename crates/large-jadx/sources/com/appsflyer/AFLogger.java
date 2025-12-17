package com.appsflyer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.appsflyer.internal.ah;
import com.appsflyer.internal.an;
import com.appsflyer.internal.bb;

/* loaded from: classes.dex */
public final class AFLogger {

    private static final long AFKeystoreWrapper;

    public static enum LogLevel {

        NONE(false),
        ERROR(true),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);

        private int AFKeystoreWrapper;
        @Override // java.lang.Enum
        public final int getLevel() {
            return this.AFKeystoreWrapper;
        }
    }
    static {
        AFLogger.AFKeystoreWrapper = System.currentTimeMillis();
    }

    public static void AFInAppEventParameterName(String string) {
        boolean z;
        an anVar;
        String str;
        final int i = 0;
        if (AFLogger.AFInAppEventType(AFLogger.LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.5.0", AFLogger.AFInAppEventType(string, i));
        }
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        int i2 = 1;
        String[] strArr = new String[i2];
        strArr[i] = AFLogger.AFInAppEventType(string, i2);
        an.values.AFInAppEventType(0, "W", strArr);
    }

    private static boolean AFInAppEventParameterName() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    private static String AFInAppEventType(String string, boolean z2) {
        int int;
        int level;
        String str;
        String obj4;
        int obj5;
        if (string == null) {
            obj4 = "null";
        }
        if (z2 == 0 && AFLogger.LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", AFLogger.LogLevel.NONE.getLevel())) {
            if (AFLogger.LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", AFLogger.LogLevel.NONE.getLevel())) {
            }
            return obj4;
        }
        obj5 = new StringBuilder("(");
        obj5.append(currentTimeMillis -= aFKeystoreWrapper);
        obj5.append(") [");
        obj5.append(Thread.currentThread().getName());
        obj5.append("] ");
        obj5.append(obj4);
        return obj5.toString();
    }

    public static void AFInAppEventType(String string) {
        AFLogger.valueOf(string, true);
    }

    public static void AFInAppEventType(String string, Throwable throwable2) {
        final int i = 1;
        AFLogger.AFKeystoreWrapper(string, throwable2, i, i);
    }

    public static void AFInAppEventType(Throwable throwable) {
        final int i2 = 0;
        AFLogger.AFKeystoreWrapper(0, throwable, i2, i2);
    }

    private static boolean AFInAppEventType(com.appsflyer.AFLogger.LogLevel aFLogger$LogLevel) {
        if (logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", AFLogger.LogLevel.NONE.getLevel())) {
            return 1;
        }
        return 0;
    }

    public static void AFKeystoreWrapper(String string) {
        boolean z;
        an anVar;
        String str;
        final int i = 0;
        if (AFLogger.AFInAppEventType(AFLogger.LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.5.0", AFLogger.AFInAppEventType(string, i));
        }
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        int i2 = 1;
        String[] strArr = new String[i2];
        strArr[i] = AFLogger.AFInAppEventType(string, i2);
        an.values.AFInAppEventType(0, "V", strArr);
    }

    public static void AFKeystoreWrapper(String string, Throwable throwable2) {
        AFLogger.AFKeystoreWrapper(string, throwable2, true, false);
    }

    private static void AFKeystoreWrapper(String string, Throwable throwable2, boolean z3, boolean z4) {
        boolean str;
        String message;
        int long;
        String string2;
        int i;
        String obj4;
        java.lang.StackTraceElement[] obj5;
        String obj6;
        int i2 = 0;
        if (AFLogger.AFInAppEventType(AFLogger.LogLevel.ERROR) && string == null) {
            i2 = 0;
            if (string == null) {
                obj4 = new StringBuilder();
                obj4.append(throwable2.getClass().getSimpleName());
                obj4.append(" at ");
                obj4.append(throwable2.getStackTrace()[i2].toString());
                obj4 = obj4.toString();
            }
            obj4 = AFLogger.AFInAppEventType(obj4, i2);
            str = "AppsFlyer_6.5.0";
            if (z4) {
                Log.e(str, obj4, throwable2);
            } else {
                if (z3) {
                    Log.d(str, obj4);
                }
            }
        }
        if (an.values == null) {
            obj4 = new an();
            an.values = obj4;
        }
        obj6 = throwable2.getCause();
        if (obj6 == null) {
            message = throwable2.getMessage();
        } else {
            message = obj6.getMessage();
        }
        if (obj6 == null) {
            obj5 = throwable2.getStackTrace();
        } else {
            obj5 = obj6.getStackTrace();
        }
        an.values.AFInAppEventType("exception", throwable2.getClass().getSimpleName(), an.values(message, obj5));
        obj4 = bb.AFKeystoreWrapper;
        if (obj4 != null) {
            obj5 = bb.AFKeystoreWrapper;
            obj6 = "exception_number";
            if (obj5 == null) {
                long = -1;
            } else {
                long = ah.AFKeystoreWrapper(obj5).getLong(obj6, 0);
            }
            ah.AFKeystoreWrapper(obj4).edit().putLong(obj6, long += i).apply();
        }
    }

    public static void init(String string) {
        AFLogger.AFInAppEventParameterName(string);
    }

    public static void valueOf(String string) {
        boolean z;
        an anVar;
        String str;
        final int i = 0;
        if (!AFLogger.AFInAppEventParameterName()) {
            Log.d("AppsFlyer_6.5.0", AFLogger.AFInAppEventType(string, i));
        }
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        strArr[i] = string;
        an.values.AFInAppEventType(0, "F", strArr);
    }

    public static void valueOf(String string, boolean z2) {
        boolean strArr;
        String str;
        String obj3;
        an obj4;
        final int i2 = 0;
        if (AFLogger.AFInAppEventType(AFLogger.LogLevel.INFO)) {
            Log.i("AppsFlyer_6.5.0", AFLogger.AFInAppEventType(string, i2));
        }
        if (z2 != null && an.values == null) {
            if (an.values == null) {
                obj4 = new an();
                an.values = obj4;
            }
            int i = 1;
            strArr = new String[i];
            strArr[i2] = AFLogger.AFInAppEventType(string, i);
            an.values.AFInAppEventType(0, "I", strArr);
        }
    }

    public static void values(String string) {
        boolean z;
        an anVar;
        String str;
        final int i = 0;
        if (AFLogger.AFInAppEventType(AFLogger.LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.5.0", AFLogger.AFInAppEventType(string, i));
        }
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        int i2 = 1;
        String[] strArr = new String[i2];
        strArr[i] = AFLogger.AFInAppEventType(string, i2);
        an.values.AFInAppEventType(0, "D", strArr);
    }
}
