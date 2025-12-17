package com.airbnb.lottie.x;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class p {

    private static final c.a a;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            p.a.a = iArr;
            iArr[c.b.NUMBER.ordinal()] = 1;
            p.a.a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            p.a.a[c.b.BEGIN_OBJECT.ordinal()] = 3;
        }
    }
    static {
        p.a = c.a.a(/* result */);
    }

    private static PointF a(c c, float f2) {
        c.b bVar;
        c.b eND_ARRAY;
        c.c();
        while (c.w() != c.b.END_ARRAY) {
            c.H();
        }
        c.f();
        PointF obj4 = new PointF(f *= f2, f3 *= f2);
        return obj4;
    }

    private static PointF b(c c, float f2) {
        boolean z;
        while (c.j()) {
            c.H();
        }
        PointF obj3 = new PointF(f *= f2, f3 *= f2);
        return obj3;
    }

    private static PointF c(c c, float f2) {
        int i;
        int i2;
        int i3;
        int i4;
        c.e();
        i2 = i;
        while (c.j()) {
            i3 = c.E(p.a);
            if (i3 != 0) {
            } else {
            }
            i = p.g(c);
            if (i3 != 1) {
            } else {
            }
            i2 = p.g(c);
            c.F();
            c.H();
        }
        c.i();
        PointF obj4 = new PointF(i *= f2, i2 *= f2);
        return obj4;
    }

    static int d(c c) {
        boolean z;
        c.c();
        long l = 4643176031446892544L;
        while (c.j()) {
            c.H();
        }
        c.f();
        return Color.argb(255, (int)i, (int)i5, (int)i6);
    }

    static PointF e(c c, float f2) {
        int i = p.a.a[c.w().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return p.c(c, f2);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown point starts with ");
                stringBuilder.append(c.w());
                IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
                throw obj3;
            }
            return p.a(c, f2);
        }
        return p.b(c, f2);
    }

    static List<PointF> f(c c, float f2) {
        PointF pointF;
        c.b bEGIN_ARRAY;
        ArrayList arrayList = new ArrayList();
        c.c();
        while (c.w() == c.b.BEGIN_ARRAY) {
            c.c();
            arrayList.add(p.e(c, f2));
            c.f();
        }
        c.f();
        return arrayList;
    }

    static float g(c c) {
        int i;
        c.b bVar = c.w();
        i = p.a.a[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
            } else {
                c.c();
                while (c.j() != 0) {
                    c.H();
                }
                c.f();
                return (float)d2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown value for token of type ");
            stringBuilder.append(bVar);
            IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
            throw obj3;
        }
        return (float)d;
    }
}
