package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import com.airbnb.lottie.v.k.p;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeStrokeParser.java */
/* loaded from: classes.dex */
class h0 {

    private static c.a a;
    private static final c.a b;
    static {
        h0.a = c.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
        h0.b = c.a.a("n", "v");
    }

    static p a(c cVar, com.airbnb.lottie.d dVar) {
        com.airbnb.lottie.d dVar22;
        int i2;
        int i = 2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9;
        int i10 = 0;
        int size = 0;
        Object obj;
        boolean z;
        int i11;
        cVar2 = cVar;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        i9 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        i10 = 0;
        while (cVar.j()) {
            i = 1;
            dVar22 = dVar;
            cVar.H();
            cVar.c();
            while (cVar.j()) {
                cVar.e();
                size = 0;
                int i16 = 0;
                while (cVar.j()) {
                    i2 = cVar2.E(h0.b);
                }
                cVar.i();
                size.hashCode();
                i = -1;
                dVar22 = dVar;
                dVar22 = dVar;
                i4 = obj;
                dVar.t(true);
                arrayList.add(obj);
                int r2 = !size.equals("o") ? -1 : 2;
                r2 = !size.equals("g") ? -1 : i;
                r2 = !size.equals("d") ? -1 : i;
                i2 = cVar2.E(h0.b);
            }
            dVar22 = dVar;
            cVar.f();
            cVar.e();
            size = 0;
            i16 = 0;
            while (cVar.j()) {
                i2 = cVar2.E(h0.b);
            }
            cVar.i();
            size.hashCode();
            i = -1;
            dVar22 = dVar;
            dVar22 = dVar;
            i4 = obj;
            dVar.t(true);
            arrayList.add(obj);
            r2 = !size.equals("o") ? -1 : 2;
            r2 = !size.equals("g") ? -1 : i;
            r2 = !size.equals("d") ? -1 : i;
            i2 = cVar2.E(h0.b);
            dVar22 = dVar;
            boolean z3 = cVar.k();
            dVar22 = dVar;
            i9 = (float)cVar.m();
            dVar22 = dVar;
            size = cVar.n() - i;
            i8 = p.c.values()[size];
            dVar22 = dVar;
            size = cVar.n() - i;
            i7 = p.b.values()[size];
            dVar22 = dVar;
            com.airbnb.lottie.v.j.d dVar4 = d.h(cVar, dVar);
            dVar22 = dVar;
            com.airbnb.lottie.v.j.b bVar3 = d.e(cVar, dVar);
            dVar22 = dVar;
            com.airbnb.lottie.v.j.a aVar4 = d.c(cVar, dVar);
            dVar22 = dVar;
            String str5 = cVar.q();
        }
        if (i10 == 0) {
        }
        p pVar = new p(i3, i4, arrayList, i5, i10, i6, i7, i8, i9, i);
        return pVar;
    }
}
