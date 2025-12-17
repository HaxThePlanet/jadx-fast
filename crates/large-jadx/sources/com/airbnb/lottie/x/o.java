package com.airbnb.lottie.x;

import com.airbnb.lottie.x.k0.c;

/* loaded from: classes.dex */
public class o implements com.airbnb.lottie.x.j0<Integer> {

    public static final com.airbnb.lottie.x.o a;
    static {
        o oVar = new o();
        o.a = oVar;
    }

    @Override // com.airbnb.lottie.x.j0
    public Object a(c c, float f2) {
        return b(c, f2);
    }

    @Override // com.airbnb.lottie.x.j0
    public Integer b(c c, float f2) {
        return Integer.valueOf(Math.round(obj1 *= f2));
    }
}
