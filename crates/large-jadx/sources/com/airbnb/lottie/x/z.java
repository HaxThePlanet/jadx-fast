package com.airbnb.lottie.x;

import com.airbnb.lottie.d;
import com.airbnb.lottie.v.k.i;
import com.airbnb.lottie.v.k.i.a;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;

/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
class z {

    private static final c.a a;
    static {
        z.a = c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");
    }

    static i a(c cVar, d dVar) {
        String str;
        i.a forValue;
        com.airbnb.lottie.v.j.b bVar;
        com.airbnb.lottie.v.j.m mVar;
        com.airbnb.lottie.v.j.b bVar2;
        com.airbnb.lottie.v.j.b bVar3;
        com.airbnb.lottie.v.j.b bVar4;
        com.airbnb.lottie.v.j.b bVar5;
        com.airbnb.lottie.v.j.b bVar6;
        boolean z;
        final boolean z2 = false;
        int i = 0;
        int i2 = z2;
        while (cVar.j()) {
            cVar.F();
            cVar.H();
            z = cVar.k();
            bVar5 = d.f(cVar, dVar, z2);
            bVar3 = d.e(cVar, dVar);
            bVar6 = d.f(cVar, dVar, z2);
            bVar4 = d.e(cVar, dVar);
            bVar2 = d.f(cVar, dVar, z2);
            mVar = a.b(cVar, dVar);
            bVar = d.f(cVar, dVar, z2);
            forValue = i.a.forValue(cVar.n());
            str = cVar.q();
        }
        i cVar2 = new i(str, forValue, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
        return cVar2;
    }
}
