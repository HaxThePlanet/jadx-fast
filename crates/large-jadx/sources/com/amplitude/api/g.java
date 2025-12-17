package com.amplitude.api;

import android.util.Log;

/* loaded from: classes.dex */
public class g {

    protected static com.amplitude.api.g c;
    private volatile boolean a = true;
    private volatile int b = 4;
    static {
        g gVar = new g();
        g.c = gVar;
    }

    private g() {
        super();
        int i = 1;
        int i2 = 4;
    }

    public static com.amplitude.api.g d() {
        return g.c;
    }

    int a(String string, String string2) {
        boolean z;
        int i;
        if (this.a && this.b <= 3) {
            if (this.b <= 3) {
                return Log.d(string, string2);
            }
        }
        return 0;
    }

    int b(String string, String string2) {
        boolean z;
        int i;
        if (this.a && this.b <= 6) {
            if (this.b <= 6) {
                return Log.e(string, string2);
            }
        }
        return 0;
    }

    int c(String string, String string2, Throwable throwable3) {
        boolean z;
        int i;
        if (this.a && this.b <= 6) {
            if (this.b <= 6) {
                return Log.e(string, string2, throwable3);
            }
        }
        return 0;
    }

    int e(String string, String string2) {
        boolean z;
        int i;
        if (this.a && this.b <= 5) {
            if (this.b <= 5) {
                return Log.w(string, string2);
            }
        }
        return 0;
    }

    int f(String string, Throwable throwable2) {
        boolean z;
        int i;
        if (this.a && this.b <= 5) {
            if (this.b <= 5) {
                return Log.w(string, throwable2);
            }
        }
        return 0;
    }
}
