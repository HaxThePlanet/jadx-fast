package com.amplitude.api;

import android.util.Log;

/* compiled from: AmplitudeLog.java */
/* loaded from: classes.dex */
public class g {

    protected static g c;
    private volatile boolean a = true;
    private volatile int b = 4;
    static {
        g.c = new g();
    }

    private g() {
        super();
    }

    public static g d() {
        return g.c;
    }

    int a(String str, String str2) {
        if (this.a) {
            int i = 3;
            if (this.b <= 3) {
                return Log.d(str, str2);
            }
        }
        return 0;
    }

    int b(String str, String str2) {
        if (this.a) {
            int i = 6;
            if (this.b <= 6) {
                return Log.e(str, str2);
            }
        }
        return 0;
    }

    int c(String str, String str2, Throwable th) {
        if (this.a) {
            int i = 6;
            if (this.b <= 6) {
                return Log.e(str, str2, th);
            }
        }
        return 0;
    }

    int e(String str, String str2) {
        if (this.a) {
            int i = 5;
            if (this.b <= 5) {
                return Log.w(str, str2);
            }
        }
        return 0;
    }

    int f(String str, Throwable th) {
        if (this.a) {
            int i = 5;
            if (this.b <= 5) {
                return Log.w(str, th);
            }
        }
        return 0;
    }
}
