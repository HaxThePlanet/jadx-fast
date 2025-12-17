package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public final class j {

    private final String a;
    private final String b;
    public j(String string) {
        super(string, 0);
    }

    public j(String string, String string2) {
        int i;
        Object obj6;
        super();
        r.k(string, "log tag cannot be null");
        int i2 = 1;
        int i3 = 0;
        final int i4 = 23;
        i = string.length() <= i4 ? i2 : i3;
        Object[] arr = new Object[2];
        arr[i3] = string;
        arr[i2] = Integer.valueOf(i4);
        r.c(i, "tag \"%s\" is longer than the %d character maximum", arr);
        this.a = string;
        if (string2 != null && string2.length() <= 0) {
            if (string2.length() <= 0) {
            }
            this.b = string2;
        }
        this.b = 0;
    }

    private final String f(String string) {
        final String str = this.b;
        if (str == null) {
            return string;
        }
        return str.concat(string);
    }

    public boolean a(int i) {
        return Log.isLoggable(this.a, i);
    }

    public void b(String string, String string2) {
        String obj3;
        if (a(3)) {
            Log.d(string, f(string2));
        }
    }

    public void c(String string, String string2, Throwable throwable3) {
        String obj3;
        if (a(6)) {
            Log.e(string, f(string2), throwable3);
        }
    }

    public void d(String string, String string2) {
        String obj3;
        if (a(2)) {
            Log.v(string, f(string2));
        }
    }

    public void e(String string, String string2) {
        String obj3;
        if (a(5)) {
            Log.w(string, f(string2));
        }
    }
}
