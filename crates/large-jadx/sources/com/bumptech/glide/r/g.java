package com.bumptech.glide.r;

import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.f;

/* compiled from: RequestOptions.java */
/* loaded from: classes.dex */
public class g extends a<g> {

    private static g S;
    public static g q0() {
        if (g.S == null) {
            g.S = (g)(g)new g().c().b();
        }
        return g.S;
    }

    public static g r0(Class<?> cls) {
        return (g)new g().e(cls);
    }

    public static g s0(j jVar) {
        return (g)new g().f(jVar);
    }

    public static g u0(f fVar) {
        return (g)new g().g0(fVar);
    }
}
