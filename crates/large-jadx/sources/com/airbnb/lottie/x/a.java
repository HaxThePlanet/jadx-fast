package com.airbnb.lottie.x;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.e;
import com.airbnb.lottie.v.j.i;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {

    private static final c.a a;
    static {
        a.a = c.a.a("k", "x", "y");
    }

    public static e a(c cVar, d dVar) {
        final ArrayList arrayList = new ArrayList();
        if (cVar.w() == c.b.BEGIN_ARRAY) {
            cVar.c();
            while (cVar.j()) {
                arrayList.add(w.a(cVar, dVar));
            }
            cVar.f();
            r.b(arrayList);
        } else {
            arrayList.add(new a(p.e(cVar, h.e())));
        }
        return new e(arrayList);
    }

    static m<PointF, PointF> b(c cVar, d dVar) {
        int i2 = 0;
        com.airbnb.lottie.v.j.b bVar;
        com.airbnb.lottie.v.j.b bVar2;
        int i;
        c.b bVar3;
        c.b eND_OBJECT2;
        cVar.e();
        i = 1;
        i2 = 0;
        i = 0;
        while (cVar.w() != c.b.END_OBJECT) {
            int i4 = cVar.E(a.a);
        }
        cVar.i();
        if (i != 0) {
            str = "Lottie doesn't support expressions.";
            dVar.a(str);
        }
        if (i2 != 0) {
            return i2;
        }
        return new i(bVar, bVar2);
    }
}
