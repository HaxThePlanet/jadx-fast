package com.google.android.play.core.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class h {

    private final String a;
    public h(String string) {
        String obj5;
        super();
        StringBuilder stringBuilder = new StringBuilder(39);
        stringBuilder.append("UID: [");
        stringBuilder.append(Process.myUid());
        stringBuilder.append("]  PID: [");
        stringBuilder.append(Process.myPid());
        stringBuilder.append("] ");
        String valueOf = String.valueOf(stringBuilder.toString());
        obj5 = String.valueOf(string);
        if (obj5.length() != 0) {
            obj5 = valueOf.concat(obj5);
        } else {
            obj5 = new String(valueOf);
        }
        this.a = obj5;
    }

    private static String f(String string, String string2, Object... object3Arr3) {
        int length;
        String length2;
        String stringBuilder;
        String obj5;
        Object[] obj6;
        if (object3Arr3.length > 0) {
            obj5 = String.format(Locale.US, string2, object3Arr3);
        }
        StringBuilder stringBuilder2 = new StringBuilder(obj6 += length3);
        stringBuilder2.append(string);
        stringBuilder2.append(" : ");
        stringBuilder2.append(obj5);
        return stringBuilder2.toString();
    }

    public final int a(String string, Object... object2Arr2) {
        final String str = "PlayCore";
        if (Log.isLoggable(str, 3)) {
            return Log.d(str, h.f(this.a, string, object2Arr2));
        }
        return 0;
    }

    public final int b(String string, Object... object2Arr2) {
        final String str = "PlayCore";
        if (Log.isLoggable(str, 6)) {
            return Log.e(str, h.f(this.a, string, object2Arr2));
        }
        return 0;
    }

    public final int c(Throwable throwable, String string2, Object... object3Arr3) {
        final String str = "PlayCore";
        if (Log.isLoggable(str, 6)) {
            return Log.e(str, h.f(this.a, string2, object3Arr3), throwable);
        }
        return 0;
    }

    public final int d(String string, Object... object2Arr2) {
        final String str = "PlayCore";
        if (Log.isLoggable(str, 4)) {
            return Log.i(str, h.f(this.a, string, object2Arr2));
        }
        return 0;
    }

    public final int e(String string, Object... object2Arr2) {
        final String str = "PlayCore";
        if (Log.isLoggable(str, 5)) {
            return Log.w(str, h.f(this.a, string, object2Arr2));
        }
        return 0;
    }
}
