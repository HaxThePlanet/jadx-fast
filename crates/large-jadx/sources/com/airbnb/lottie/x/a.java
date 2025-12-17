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

/* loaded from: classes.dex */
public class a {

    private static final c.a a;
    static {
        a.a = c.a.a(/* result */);
    }

    public static e a(c c, d d2) {
        c.b bVar;
        float f;
        Object obj3;
        Object obj4;
        ArrayList arrayList = new ArrayList();
        if (c.w() == c.b.BEGIN_ARRAY) {
            c.c();
            while (c.j()) {
                arrayList.add(w.a(c, d2));
            }
            c.f();
            r.b(arrayList);
        } else {
            obj4 = new a(p.e(c, h.e()));
            arrayList.add(obj4);
        }
        obj3 = new e(arrayList);
        return obj3;
    }

    static m<PointF, PointF> b(c c, d d2) {
        int i4;
        int i;
        int i3;
        int i2;
        c.b bVar;
        c.b eND_OBJECT;
        Object obj7;
        c.e();
        final int i5 = 1;
        i2 = i6;
        i = i3;
        while (c.w() != c.b.END_OBJECT) {
            bVar = c.E(a.a);
            if (bVar != 0) {
            } else {
            }
            i4 = a.a(c, d2);
            if (bVar != i5) {
            } else {
            }
            if (c.w() == c.b.STRING) {
            } else {
            }
            i = d.e(c, d2);
            c.H();
            i2 = i5;
            if (bVar != 2) {
            } else {
            }
            if (c.w() == c.b.STRING) {
            } else {
            }
            i3 = d.e(c, d2);
            c.H();
            c.F();
            c.H();
        }
        c.i();
        if (i2 != 0) {
            d2.a("Lottie doesn't support expressions.");
        }
        if (i4 != 0) {
            return i4;
        }
        obj7 = new i(i, i3);
        return obj7;
    }
}
