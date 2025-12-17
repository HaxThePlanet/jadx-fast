package com.airbnb.lottie.v;

import com.airbnb.lottie.d;
import d.e.e;

/* loaded from: classes.dex */
public class g {

    private static final com.airbnb.lottie.v.g b;
    private final e<String, d> a;
    static {
        g gVar = new g();
        g.b = gVar;
    }

    g() {
        super();
        e eVar = new e(20);
        this.a = eVar;
    }

    public static com.airbnb.lottie.v.g b() {
        return g.b;
    }

    public d a(String string) {
        if (string == null) {
            return null;
        }
        return (d)this.a.c(string);
    }

    public void c(String string, d d2) {
        if (string == null) {
        }
        this.a.d(string, d2);
    }
}
