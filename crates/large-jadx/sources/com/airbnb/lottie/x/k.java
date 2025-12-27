package com.airbnb.lottie.x;

import com.airbnb.lottie.x.k0.c.a;

/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k {

    private static final c.a a;
    static {
        k.a = c.a.a("fFamily", "fName", "fStyle", "ascent");
    }

    static com.airbnb.lottie.v.c a(com.airbnb.lottie.x.k0.c cVar) {
        String str = null;
        String str2;
        String str3;
        int i2;
        int i4 = 1;
        cVar.e();
        i2 = 0;
        while (cVar.j()) {
            int i3 = cVar.E(k.a);
        }
        cVar.i();
        return new c(str, str2, str3, i2);
    }
}
