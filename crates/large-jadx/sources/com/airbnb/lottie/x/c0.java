package com.airbnb.lottie.x;

import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.z.d;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class c0 implements j0<d> {

    public static final c0 a = new c0();

    private c0() {
        super();
    }

    public d b(c cVar, float f) {
        int i = 0;
        int r0 = cVar.w() == c.b.BEGIN_ARRAY ? 1 : 0;
        if (i != 0) {
            cVar.c();
        }
        while (cVar.j()) {
            cVar.H();
        }
        if (i != 0) {
            cVar.f();
        }
        f = 100f;
        return new d((float)cVar.m() / f * f, (float)cVar.m() / f * f);
    }
}
