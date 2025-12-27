package com.airbnb.lottie.x;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {

    private static final c.a a;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[c.b.values().length];
            p.a.a = iArr;
            try {
                iArr[c.b.NUMBER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        p.a = c.a.a("x", "y");
    }

    private static PointF a(c cVar, float f) {
        cVar.c();
        while (cVar.w() != c.b.END_ARRAY) {
            cVar.H();
        }
        cVar.f();
        return new PointF((float)cVar.m() * f, (float)cVar.m() * f);
    }

    private static PointF b(c cVar, float f) {
        while (cVar.j()) {
            cVar.H();
        }
        return new PointF((float)cVar.m() * f, (float)cVar.m() * f);
    }

    private static PointF c(c cVar, float f) {
        int i = 0;
        int i3 = 1;
        cVar.e();
        i = 0;
        while (cVar.j()) {
            int i2 = cVar.E(p.a);
        }
        cVar.i();
        return new PointF(i * f, i * f);
    }

    static int d(c cVar) {
        cVar.c();
        double d3 = 255d;
        while (cVar.j()) {
            cVar.H();
        }
        cVar.f();
        return Color.argb(255, (int)(cVar.m() * d3), (int)(cVar.m() * d3), (int)(cVar.m() * d3));
    }

    static PointF e(c cVar, float f) {
        int i = p.a.a[cVar.w().ordinal()];
        if (p.a.a != 1 && p.a.a != 2) {
            if (p.a.a != 3) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Unknown point starts with ";
                c.b bVar2 = cVar.w();
                cVar = str + bVar2;
                throw new IllegalArgumentException(cVar);
            } else {
                return p.c(cVar, f);
            }
        }
        return p.b(cVar, f);
    }

    static List<PointF> f(c cVar, float f) {
        final ArrayList arrayList = new ArrayList();
        cVar.c();
        while (cVar.w() == c.b.BEGIN_ARRAY) {
            cVar.c();
            arrayList.add(p.e(cVar, f));
            cVar.f();
        }
        cVar.f();
        return arrayList;
    }

    static float g(c cVar) {
        c.b bVar = cVar.w();
        int i = p.a.a[bVar.ordinal()];
        if (p.a.a != 1 && p.a.a == 2) {
            cVar.c();
            while (cVar.j()) {
                cVar.H();
            }
            cVar.f();
            return (float)cVar.m();
        }
        return (float)cVar.m();
    }
}
