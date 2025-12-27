package com.airbnb.lottie.v;

import com.airbnb.lottie.d;
import d.e.e;

/* compiled from: LottieCompositionCache.java */
/* loaded from: classes.dex */
public class g {

    private static final g b = new g();
    private final e<String, d> a = new e<>(20);

    g() {
        super();
        final e eVar = new e(20);
    }

    public static g b() {
        return g.b;
    }

    public d a(String str) {
        if (str == null) {
            return null;
        }
        return (d)this.a.c(str);
    }

    public void c(String str, d dVar) {
        if (str == null) {
            return;
        }
        this.a.d(str, dVar);
    }
}
