package com.airbnb.lottie.x;

import com.airbnb.lottie.d;
import com.airbnb.lottie.t.c.h;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
class r {

    static c.a a;
    static {
        r.a = c.a.a("k");
    }

    static <T> List<a<T>> a(c cVar, d dVar, float f, j0<T> j0Var, boolean z) {
        c.b bVar;
        c.b sTRING2;
        d dVar22;
        float f32;
        com.airbnb.lottie.x.j0 j0Var42;
        boolean z52;
        final ArrayList arrayList = new ArrayList();
        if (cVar.w() == c.b.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.e();
        while (cVar.j()) {
        }
        cVar.i();
        r.b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends a<T>> list) {
        int i = 0;
        i = 0;
        int i3 = list.size() - 1;
        while (i < i3) {
            Object item = list.get(i);
            i = i + 1;
            Object item2 = list.get(i);
            item.h = Float.valueOf(item2.g);
        }
        Object item3 = list.get(i3);
        if (item3.b == null || item3.c == null) {
            if (list.size() > 1) {
                list.remove(item3);
            }
        }
    }
}
