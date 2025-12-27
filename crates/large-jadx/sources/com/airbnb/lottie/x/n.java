package com.airbnb.lottie.x;

import com.airbnb.lottie.v.k.e;
import com.airbnb.lottie.v.k.f;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
class n {

    private static c.a a;
    private static final c.a b;
    private static final c.a c;
    static {
        n.a = c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
        n.b = c.a.a("p", "k");
        n.c = c.a.a("n", "v");
    }

    static e a(c cVar, com.airbnb.lottie.d dVar) {
        p.c[] values = null;
        int i = -1;
        int size;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i11 = 0;
        int i10;
        int i12 = 0;
        int i13 = 0;
        boolean z2;
        cVar2 = cVar;
        dVar22 = dVar;
        final ArrayList arrayList = new ArrayList();
        i10 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        i9 = 0;
        i11 = 0;
        i4 = 0;
        i12 = 0;
        i13 = 0;
        while (cVar.j()) {
            cVar.F();
            cVar.H();
            cVar.c();
            while (cVar.j()) {
                cVar.e();
                size = 0;
                i4 = 0;
                while (cVar.j()) {
                    int i18 = cVar2.E(n.c);
                }
                cVar.i();
                i18 = cVar2.E(n.c);
            }
            cVar.f();
            cVar.e();
            size = 0;
            i4 = 0;
            while (cVar.j()) {
                i18 = cVar2.E(n.c);
            }
            cVar.i();
            i18 = cVar2.E(n.c);
            values = null;
            boolean z7 = cVar.k();
            i10 = (float)cVar.m();
            size = cVar.n() - 1;
            i11 = p.c.values()[size];
            values = 1;
            i9 = p.b.values()[cVar.n() - values];
            com.airbnb.lottie.v.j.b bVar3 = d.e(cVar, dVar);
            com.airbnb.lottie.v.j.f fVar5 = d.i(cVar, dVar);
            com.airbnb.lottie.v.j.f fVar4 = d.i(cVar, dVar);
            f r2 = cVar.n() == 1 ? f.LINEAR : f.RADIAL;
            com.airbnb.lottie.v.j.d dVar4 = d.h(cVar, dVar);
            i = -1;
            cVar.e();
            while (cVar.j()) {
                size = cVar2.E(n.b);
            }
            cVar.i();
            size = cVar2.E(n.b);
            String str6 = cVar.q();
            i3 = (cVar.n() == 1 ? f.LINEAR : f.RADIAL);
        }
        if (i13 == 0) {
        }
        e eVar = new e(i2, i3, i4, i13, i6, i7, i8, i9, i11, i10, arrayList, i4, i12);
        return eVar;
    }
}
