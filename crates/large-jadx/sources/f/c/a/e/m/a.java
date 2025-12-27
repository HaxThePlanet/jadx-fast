package f.c.a.e.m;

import android.animation.TimeInterpolator;

/* compiled from: AnimationUtils.java */
/* loaded from: classes2.dex */
public class a {

    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new b();
    public static final TimeInterpolator c = new a();
    public static final TimeInterpolator d = new c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float b(float f, float f2, float f3, float f4, float f5) {
        if (f5 < f3) {
            return f;
        }
        if (f5 > f4) {
            return f2;
        }
        return a.a(f, f2, (f5 - f3) / (f4 - f3));
    }

    public static int c(int i, int i2, float f) {
        return i + (Math.round(f * (float)(i2 - i)));
    }

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
