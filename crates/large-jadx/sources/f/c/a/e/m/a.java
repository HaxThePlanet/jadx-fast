package f.c.a.e.m;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import d.n.a.a.a;
import d.n.a.a.b;
import d.n.a.a.c;

/* loaded from: classes2.dex */
public class a {

    public static final TimeInterpolator a;
    public static final TimeInterpolator b;
    public static final TimeInterpolator c;
    public static final TimeInterpolator d;
    public static final TimeInterpolator e;
    static {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        a.a = linearInterpolator;
        b bVar = new b();
        a.b = bVar;
        a aVar = new a();
        a.c = aVar;
        c cVar = new c();
        a.d = cVar;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        a.e = decelerateInterpolator;
    }

    public static float a(float f, float f2, float f3) {
        return f += obj2;
    }

    public static float b(float f, float f2, float f3, float f4, float f5) {
        if (Float.compare(f5, f3) < 0) {
            return f;
        }
        if (Float.compare(f5, f4) > 0) {
            return f2;
        }
        return a.a(f, f2, obj5 /= obj4);
    }

    public static int c(int i, int i2, float f3) {
        return i += obj1;
    }
}
