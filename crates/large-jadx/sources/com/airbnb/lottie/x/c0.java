package com.airbnb.lottie.x;

import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.z.d;

/* loaded from: classes.dex */
public class c0 implements com.airbnb.lottie.x.j0<d> {

    public static final com.airbnb.lottie.x.c0 a;
    static {
        c0 c0Var = new c0();
        c0.a = c0Var;
    }

    @Override // com.airbnb.lottie.x.j0
    public Object a(c c, float f2) {
        return b(c, f2);
    }

    @Override // com.airbnb.lottie.x.j0
    public d b(c c, float f2) {
        int i;
        boolean z;
        i = c.w() == c.b.BEGIN_ARRAY ? 1 : 0;
        if (i != 0) {
            c.c();
        }
        while (c.j()) {
            c.H();
        }
        if (i != 0) {
            c.f();
        }
        int i2 = 1120403456;
        d obj5 = new d(i3 *= f2, i5 *= f2);
        return obj5;
    }
}
