package com.airbnb.lottie.y;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.k;
import com.airbnb.lottie.v.a;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.k.l;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    private static PointF a;
    static {
        PointF pointF = new PointF();
        g.a = pointF;
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF(f += f2, obj3 += obj4);
        return pointF3;
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d3, obj3);
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean e(float f, float f2, float f3) {
        float obj0;
        if (Float.compare(f, f2) >= 0 && Float.compare(f, f3) <= 0) {
            obj0 = Float.compare(f, f3) <= 0 ? 1 : 0;
        } else {
        }
        return obj0;
    }

    private static int f(int i, int i2) {
        int i4;
        int i3;
        i3 = i ^ i2 >= 0 ? 1 : 0;
        if (i3 == 0 && i %= i2 != 0) {
            if (i %= i2 != 0) {
                i4--;
            }
        }
        return i4;
    }

    static int g(float f, float f2) {
        return g.h((int)f, (int)f2);
    }

    private static int h(int i, int i2) {
        return i -= obj2;
    }

    public static void i(l l, Path path2) {
        int i;
        PointF pointF;
        float f;
        float pointF2;
        float f5;
        float pointF3;
        boolean equals;
        float f2;
        float f6;
        float f7;
        float f4;
        float f8;
        float f3;
        path2.reset();
        PointF pointF4 = l.b();
        path2.moveTo(pointF4.x, pointF4.y);
        g.a.set(pointF4.x, pointF4.y);
        i = 0;
        while (i < l.a().size()) {
            Object obj = l.a().get(i);
            pointF2 = (a)obj.a();
            pointF3 = obj.b();
            PointF pointF5 = obj.c();
            if (pointF2.equals(g.a) && pointF3.equals(pointF5)) {
            } else {
            }
            path2.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF5.x, pointF5.y);
            g.a.set(pointF5.x, pointF5.y);
            i++;
            if (pointF3.equals(pointF5)) {
            } else {
            }
            path2.lineTo(pointF5.x, pointF5.y);
        }
        if (l.d()) {
            path2.close();
        }
    }

    public static double j(double d, double d2, double d3) {
        return d += obj4;
    }

    public static float k(float f, float f2, float f3) {
        return f += obj2;
    }

    public static int l(int i, int i2, float f3) {
        return (int)i3;
    }

    public static void m(e e, int i2, List<e> list3, e e4, k k5) {
        boolean obj1;
        if (e.c(k5.getName(), i2)) {
            list3.add(e4.a(k5.getName()).i(k5));
        }
    }
}
