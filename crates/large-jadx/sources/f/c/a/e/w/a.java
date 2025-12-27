package f.c.a.e.w;

/* compiled from: MathUtils.java */
/* loaded from: classes2.dex */
public final class a {
    public static float a(float f, float f2, float f3, float f4) {
        f4 -= f2;
        return (float)(Math.hypot((double)(f3 - f), (double)f7));
    }

    public static float b(float f, float f2, float f3, float f4, float f5, float f6) {
        return a.d(a.a(f, f2, f3, f4), a.a(f, f2, f5, f4), a.a(f, f2, f5, f6), a.a(f, f2, f3, f6));
    }

    public static float c(float f, float f2, float f3) {
        return (1f - f3) * f + (f3 * f2);
    }

    private static float d(float f, float f2, float f3, float f4) {
        int cmp;
        float f42;
        if (f > f2) {
            if (f > f3) {
                if (f <= f4) {
                    if (f2 > f3) {
                        if (f2 > f4) {
                            f42 = f2;
                        } else {
                            f = f3 > f4 ? f3 : f4;
                        }
                    }
                }
            }
        }
        return (f3 > f4 ? f3 : f4);
    }
}
