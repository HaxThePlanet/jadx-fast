package com.bumptech.glide.r;

import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.f;

/* loaded from: classes.dex */
public class g extends com.bumptech.glide.r.a<com.bumptech.glide.r.g> {

    private static com.bumptech.glide.r.g S;
    public static com.bumptech.glide.r.g q0() {
        com.bumptech.glide.r.a gVar;
        if (g.S == null) {
            g gVar3 = new g();
            g.S = (g)(g)gVar3.c().b();
        }
        return g.S;
    }

    public static com.bumptech.glide.r.g r0(Class<?> class) {
        g gVar = new g();
        return (g)gVar.e(class);
    }

    public static com.bumptech.glide.r.g s0(j j) {
        g gVar = new g();
        return (g)gVar.f(j);
    }

    public static com.bumptech.glide.r.g u0(f f) {
        g gVar = new g();
        return (g)gVar.g0(f);
    }
}
