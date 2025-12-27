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

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class d0 implements j0<l> {

    public static final d0 a = new d0();
    private static final c.a b;
    static {
        d0.b = c.a.a("c", "v", "i", "o");
    }

    private d0() {
        super();
    }

    public l b(c cVar, float f) {
        int i = 0;
        boolean z2;
        int i3;
        if (cVar.w() == c.b.BEGIN_ARRAY) {
            cVar.c();
        }
        cVar.e();
        i = 0;
        boolean z = false;
        int i4 = z;
        i3 = 1;
        while (cVar.j()) {
            int i2 = cVar.E(d0.b);
        }
        cVar.i();
        if (cVar.w() == c.b.END_ARRAY) {
            cVar.f();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else {
            if (i != 0) {
                if (i != 0) {
                    if (i.isEmpty()) {
                        return new l(new PointF(), z, Collections.emptyList());
                    }
                    int size = i.size();
                    ArrayList arrayList = new ArrayList(size);
                    while (i3 < size) {
                        Object item = i.get(i3);
                        int i5 = i3 - 1;
                        arrayList.add(new a(g.a((PointF)i.get(i5), (PointF)i.get(i5)), g.a(item, (PointF)i.get(i3)), item));
                        i3 = i3 + 1;
                    }
                    if (z2) {
                        Object item4 = i.get(z);
                        size -= i3;
                        arrayList.add(new a(g.a((PointF)i.get(i6), (PointF)i.get(i6)), g.a(item4, (PointF)i.get(z)), item4));
                    }
                    return new l((PointF)i.get(z), z2, arrayList);
                }
            }
        }
    }
}
