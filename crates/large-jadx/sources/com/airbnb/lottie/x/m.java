package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Path.FillType;
import com.airbnb.lottie.v.k.f;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.Collections;

/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
class m {

    private static final c.a a;
    private static final c.a b;
    static {
        m.a = c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");
        m.b = c.a.a("p", "k");
    }

    static com.airbnb.lottie.v.k.d a(c cVar, com.airbnb.lottie.d dVar) {
        Path.FillType wINDING2;
        int i2 = -1;
        int i3 = 0;
        boolean z2;
        String str;
        f fVar;
        com.airbnb.lottie.v.j.c cVar3;
        com.airbnb.lottie.v.j.d cVar4;
        com.airbnb.lottie.v.j.f fVar2;
        com.airbnb.lottie.v.j.f fVar3;
        boolean z3;
        i3 = 0;
        int i4 = 0;
        while (cVar.j()) {
            i4 = 1;
            cVar.F();
            cVar.H();
            z3 = cVar.k();
            int i = cVar.n() == i4 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            fVar3 = d.i(cVar, dVar);
            fVar2 = d.i(cVar, dVar);
            i = cVar.n() == i4 ? f.LINEAR : f.RADIAL;
            com.airbnb.lottie.v.j.d dVar2 = d.h(cVar, dVar);
            i2 = -1;
            cVar.e();
            while (cVar.j()) {
                int i9 = cVar.E(m.b);
            }
            cVar.i();
            i9 = cVar.E(m.b);
            str = cVar.q();
            wINDING2 = (cVar.n() == i4 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
            fVar = (cVar.n() == i4 ? f.LINEAR : f.RADIAL);
        }
        if (i3 == 0) {
        } else {
        }
        d cVar2 = new d(str, fVar, wINDING2, cVar3, cVar4, fVar2, fVar3, null, null, z3);
        return cVar2;
    }
}
