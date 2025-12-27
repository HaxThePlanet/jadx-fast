package com.airbnb.lottie.y;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.k;
import com.airbnb.lottie.v.a;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.k.l;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g {

    private static PointF a;
    static {
        g.a = new PointF();
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    private static int f(int i, int i2) {
        int i3;
        int i4 = 1;
        i3 = i / i2;
        int r1 = i ^ i2 >= 0 ? 1 : 0;
        if (i4 == 0 && i % i2 != 0) {
            i3 = (i / i2) - 1;
        }
        return i3;
    }

    static int g(float f, float f2) {
        return g.h((int)f, (int)f2);
    }

    private static int h(int i, int i2) {
        return i - (i2 * (g.f(i, i2)));
    }

    public static void i(l lVar, Path path) {
        int i = 0;
        boolean path22;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        path.reset();
        PointF pointF2 = lVar.b();
        path.moveTo(pointF2.x, pointF2.y);
        g.a.set(pointF2.x, pointF2.y);
        i = 0;
        while (pointF2.y < lVar.a().size()) {
            Object item = lVar.a().get(i);
            PointF pointF4 = item.a();
            PointF pointF6 = item.b();
            PointF pointF3 = item.c();
            g.a.set(pointF3.x, pointF3.y);
            i = i + 1;
        }
        if (lVar.d()) {
            path.close();
        }
    }

    public static void m(e eVar, int i, List<e> list, e eVar2, k kVar) {
        if (eVar.c(kVar.getName(), i)) {
            list.add(eVar2.a(kVar.getName()).i(kVar));
        }
    }

    public static boolean e(float f, float f2, float f3) {
        boolean z = false;
        if (f >= f2) {
            f = f <= f3 ? 1 : 0;
        }
        return (f <= f3 ? 1 : 0);
    }

    public static double j(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float k(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int l(int i, int i2, float f) {
        return (int)(float)i + (f * (float)(i2 - i));
    }
}
