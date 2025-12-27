package com.airbnb.lottie.x;

import android.graphics.PointF;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.e;
import com.airbnb.lottie.v.j.g;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.z.a;
import java.util.List;

/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public class c {

    private static final c.a a;
    private static final c.a b;
    static {
        c.a = c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
        c.b = c.a.a("k");
    }

    private static boolean a(e eVar) {
        boolean z = true;
        float f = 0;
        boolean equals;
        if (eVar == null || eVar.i()) {
            int i2 = 1;
        }
        return z;
    }

    private static boolean b(m<PointF, PointF> mVar) {
        boolean z2 = false;
        float f = 0;
        boolean equals;
        if (mVar != null) {
            z = mVar instanceof i;
            if (!(mVar instanceof i) && mVar.i()) {
                f = 0.0f;
                if ((PointF)(a)mVar.q().get(0).b.equals(f, f)) {
                    int i2 = 1;
                }
            }
        }
        return z2;
    }

    private static boolean c(b bVar) {
        boolean z = true;
        float f = 0;
        int cmp;
        if (bVar == null || bVar.i()) {
            int i2 = 1;
        }
        return z;
    }

    private static boolean d(g gVar) {
        boolean z2 = true;
        float f = 1065353216;
        boolean z;
        if (gVar == null || gVar.i()) {
            int i2 = 1;
        }
        return z2;
    }

    private static boolean e(b bVar) {
        boolean z = true;
        float f = 0;
        int cmp;
        if (bVar == null || bVar.i()) {
            int i2 = 1;
        }
        return z;
    }

    private static boolean f(b bVar) {
        boolean z = true;
        float f = 0;
        int cmp;
        if (bVar == null || bVar.i()) {
            int i2 = 1;
        }
        return z;
    }

    public static l g(c cVar, com.airbnb.lottie.d dVar) {
        b bVar2 = null;
        a aVar;
        c.b bEGIN_OBJECT2 = null;
        boolean z;
        Float num = null;
        Float num2;
        android.view.animation.Interpolator interpolator;
        int i2;
        Float num3;
        boolean z2 = false;
        List list;
        int i;
        e eVar = null;
        m mVar = null;
        g gVar = null;
        b bVar3 = null;
        b bVar4 = null;
        com.airbnb.lottie.v.j.d dVar2 = null;
        b bVar5 = null;
        b bVar6 = null;
        c cVar2 = cVar;
        final com.airbnb.lottie.d dVar22 = dVar;
        i = cVar.w() == c.b.BEGIN_OBJECT ? i : i;
        if (i != 0) {
            cVar.e();
        }
        int i3 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i13 = 0;
        int i14 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (cVar.j()) {
            bEGIN_OBJECT2 = z2;
            cVar.F();
            cVar.H();
            bVar4 = d.f(cVar2, dVar22, z2);
            bVar3 = d.f(cVar2, dVar22, z2);
            bVar6 = d.f(cVar2, dVar22, z2);
            bVar5 = d.f(cVar2, dVar22, z2);
            dVar2 = d.h(cVar, dVar);
            dVar22.a("Lottie doesn't support 3D layers.");
            bVar2 = d.f(cVar2, dVar22, z2);
            float f3 = 0.0f;
            bEGIN_OBJECT2 = z2;
            gVar = d.j(cVar, dVar);
            bEGIN_OBJECT2 = z2;
            mVar = a.b(cVar, dVar);
            cVar.e();
            while (cVar.j()) {
            }
            cVar.i();
            z2 = z2;
            z2 = bEGIN_OBJECT2;
        }
        if (i != 0) {
            cVar.i();
        }
        int r18 = c.a(eVar) ? 0 : eVar;
        int r19 = c.b(mVar) ? 0 : mVar;
        int r21 = c.c("Lottie doesn't support 3D layers.") ? 0 : bVar2;
        if (c.d(gVar)) {
            int i12 = 0;
        }
        int r25 = c.f(bVar3) ? 0 : bVar3;
        int r26 = c.e(bVar4) ? 0 : bVar4;
        l lVar = new l(eVar, mVar, gVar, bVar2, dVar2, bVar5, bVar6, bVar3, (c.e(bVar4) ? 0 : bVar4));
        return lVar;
    }
}
