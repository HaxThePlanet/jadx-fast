package com.airbnb.lottie.x;

import com.airbnb.lottie.d;
import com.airbnb.lottie.t.c.h;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class r {

    static c.a a;
    static {
        r.a = c.a.a(/* result */);
    }

    static <T> List<a<T>> a(c c, d d2, float f3, com.airbnb.lottie.x.j0<T> j04, boolean z5) {
        c.b bVar2;
        c.b bVar;
        c.b sTRING;
        Object obj;
        d dVar;
        float f;
        com.airbnb.lottie.x.j0 j0Var;
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (c.w() == c.b.STRING) {
            d2.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        c.e();
        while (c.j()) {
            if (c.E(r.a) != null) {
            } else {
            }
            if (c.w() == c.b.BEGIN_ARRAY) {
            } else {
            }
            arrayList.add(q.c(c, d2, f3, j04, false, z5));
            c.c();
            if (c.w() == c.b.NUMBER) {
            }
            while (c.j()) {
                arrayList.add(q.c(c, d2, f3, j04, true, z5));
            }
            c.f();
            arrayList.add(q.c(c, d2, f3, j04, true, z5));
            arrayList.add(q.c(c, d2, f3, j04, false, z5));
            c.H();
        }
        c.i();
        r.b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends a<T>> list) {
        int i;
        Object size;
        Object obj2;
        Object obj3;
        Object obj;
        i = 0;
        int i3 = size2 + -1;
        while (i < i3) {
            obj2 = list.get(i);
            obj3 = list.get(i++);
            obj2.h = Float.valueOf(obj3.g);
            obj3 = obj3.b;
            obj2.c = obj3;
            if (obj2.c == null && obj3 != null && obj2 instanceof h) {
            }
            i3 = size2 + -1;
            obj3 = obj3.b;
            if (obj3 != null) {
            }
            obj2.c = obj3;
            if (obj2 instanceof h) {
            }
            (h)(a)obj2.i();
        }
        Object obj4 = list.get(i3);
        if (obj4.b != null) {
            if (obj4.c == null && list.size() > 1) {
                if (list.size() > 1) {
                    list.remove((a)obj4);
                }
            }
        } else {
        }
    }
}
