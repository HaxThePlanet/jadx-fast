package com.airbnb.lottie.x;

import android.graphics.PointF;
import com.airbnb.lottie.v.a;
import com.airbnb.lottie.v.k.l;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class d0 implements com.airbnb.lottie.x.j0<l> {

    public static final com.airbnb.lottie.x.d0 a;
    private static final c.a b;
    static {
        d0 d0Var = new d0();
        d0.a = d0Var;
        d0.b = c.a.a(/* result */);
    }

    @Override // com.airbnb.lottie.x.j0
    public Object a(c c, float f2) {
        return b(c, f2);
    }

    @Override // com.airbnb.lottie.x.j0
    public l b(c c, float f2) {
        int i2;
        int aVar2;
        int i3;
        int i6;
        int i;
        int i4;
        int i7;
        int i5;
        Object obj;
        PointF pointF2;
        PointF pointF;
        a aVar;
        int obj13;
        if (c.w() == c.b.BEGIN_ARRAY) {
            c.c();
        }
        c.e();
        aVar2 = 0;
        i6 = i3;
        i = aVar2;
        i7 = 1;
        while (c.j()) {
            i4 = c.E(d0.b);
            if (i4 != 0) {
            } else {
            }
            i = c.k();
            i7 = 1;
            if (i4 != i7) {
            } else {
            }
            i2 = p.f(c, f2);
            if (i4 != 2) {
            } else {
            }
            i3 = p.f(c, f2);
            if (i4 != 3) {
            } else {
            }
            i6 = p.f(c, f2);
            c.F();
            c.H();
        }
        c.i();
        if (c.w() == c.b.END_ARRAY) {
            c.f();
        }
        if (i2 == 0) {
        } else {
            if (i3 == 0) {
            } else {
                if (i6 == 0) {
                } else {
                    if (i2.isEmpty()) {
                        PointF obj14 = new PointF();
                        obj13 = new l(obj14, aVar2, Collections.emptyList());
                        return obj13;
                    }
                    obj13 = i2.size();
                    ArrayList arrayList = new ArrayList(obj13);
                    i5 = i7;
                    while (i5 < obj13) {
                        obj = i2.get(i5);
                        int i8 = i5 + -1;
                        aVar = new a(g.a((PointF)i2.get(i8), (PointF)i6.get(i8)), g.a((PointF)obj, (PointF)i3.get(i5)), obj);
                        arrayList.add(aVar);
                        i5++;
                    }
                    if (i != 0) {
                        i5 = i2.get(aVar2);
                        obj13 -= i7;
                        aVar2 = new a(g.a((PointF)i2.get(obj13), (PointF)i6.get(obj13)), g.a((PointF)i5, (PointF)i3.get(aVar2)), i5);
                        arrayList.add(aVar2);
                    }
                    obj13 = new l((PointF)i2.get(aVar2), i, arrayList);
                    return obj13;
                }
            }
        }
        obj13 = new IllegalArgumentException("Shape data was missing information.");
        throw obj13;
    }
}
