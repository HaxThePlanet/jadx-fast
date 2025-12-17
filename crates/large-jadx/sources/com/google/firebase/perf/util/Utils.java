package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;

/* loaded from: classes2.dex */
public class Utils {

    private static Boolean isDebugLoggingEnabled;
    static {
    }

    public static int bufferToInt(byte[] bArr) {
        int i4;
        int i2;
        int i3;
        int length;
        int i;
        i2 = i4;
        while (i4 < 4) {
            if (i4 < bArr.length) {
            }
            i2 |= i3;
            i4++;
        }
        return i2;
    }

    public static void checkArgument(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static boolean isDebugLoggingEnabled(Context context) {
        Boolean isDebugLoggingEnabled = Utils.isDebugLoggingEnabled;
        if (isDebugLoggingEnabled != null) {
            return isDebugLoggingEnabled.booleanValue();
        }
        Boolean obj4 = Boolean.valueOf(obj4.metaData.getBoolean("firebase_performance_logcat_enabled", false));
        Utils.isDebugLoggingEnabled = obj4;
        return obj4.booleanValue();
    }

    public static int saturatedIntCast(long l) {
        if (Long.compare(l, i) > 0) {
            return Integer.MAX_VALUE;
        }
        if (Long.compare(l, i2) < 0) {
            return Integer.MIN_VALUE;
        }
        return (int)l;
    }

    public static String stripSensitiveInfo(String string) {
        HttpUrl parse;
        String obj1;
        parse = HttpUrl.parse(string);
        if (parse != null) {
            String str = "";
            parse = 0;
            obj1 = parse.newBuilder().username(str).password(str).query(parse).fragment(parse).toString();
        }
        return obj1;
    }

    public static String truncateURL(String string, int i2) {
        int lastIndexOf;
        if (string.length() <= i2) {
            return string;
        }
        final int i3 = 47;
        final int i4 = 0;
        if (string.charAt(i2) == i3) {
            return string.substring(i4, i2);
        }
        HttpUrl parse = HttpUrl.parse(string);
        if (parse == null) {
            return string.substring(i4, i2);
        }
        lastIndexOf = string.lastIndexOf(i3, i2 + -1);
        if (parse.encodedPath().lastIndexOf(i3) >= 0 && lastIndexOf >= 0) {
            lastIndexOf = string.lastIndexOf(i3, i2 + -1);
            if (lastIndexOf >= 0) {
                return string.substring(i4, lastIndexOf);
            }
        }
        return string.substring(i4, i2);
    }
}
