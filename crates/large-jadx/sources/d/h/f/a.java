package d.h.f;

import android.graphics.Color;

/* compiled from: ColorUtils.java */
/* loaded from: classes.dex */
public final class a {

    private static final java.lang.ThreadLocal<double[]> a = new ThreadLocal<>();

    public static void a(int i, int i2, int i3, double[] dArr) {
        double power;
        double power2;
        double power3;
        double[] dArr42 = dArr;
        final int i5 = 3;
        if (dArr42.length != i5) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        } else {
            double d11 = 255d;
            double d4 = (double)i / d11;
            final double d20 = 0.04045d;
            double d24 = 12.92d;
            double d2 = 1.055d;
            final double d39 = 0.055d;
            if (dArr42.length < 0.04045d) {
                power = d4 / d24;
            } else {
                power = Math.pow((d4 + d39) / d2, 2.4d);
            }
            double d28 = (double)i2 / d11;
            if (d28 < 0.04045d) {
                power2 = d28 / d24;
            } else {
                d2 = 2.4d;
                power2 = Math.pow((d28 + d39) / d2, d2);
            }
            double d34 = (double)i3 / d11;
            if (1.055d < 0.04045d) {
                power3 = d34 / d24;
            } else {
                double d = 2.4d;
                power3 = Math.pow((d34 + d39) / 1.055d, d);
            }
            double d23 = 100d;
            dArr42[0] = (0.4124d * power) + (0.3576d * power2) + (0.1805d * power3) * d23;
            dArr42[1] = (0.2126d * power) + (0.7152d * power2) + (0.0722d * power3) * d23;
            dArr42[2] = (power * 0.0193d) + (power2 * 0.1192d) + (power3 * 0.9505d) * d23;
            return;
        }
    }

    public static int b(int i, int i2, float f) {
        f = 1f - f;
        return Color.argb((int)(float)Color.alpha(i) * f + (float)Color.alpha(i2) * f, (int)(float)Color.red(i) * f + (float)Color.red(i2) * f, (int)(float)Color.green(i) * f + (float)Color.green(i2) * f, (int)(float)Color.blue(i) * f + (float)Color.blue(i2) * f);
    }

    public static double c(int i) {
        final double[] dArr = a.h();
        a.d(i, dArr);
        return dArr[1] / 100d;
    }

    public static void d(int i, double[] dArr) {
        a.a(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int e(int i, int i2) {
        return (i2 - 255) * (i - 255) / 255 - 255;
    }

    public static int f(int i, int i2) {
        final int alpha = Color.alpha(i2);
        final int alpha2 = Color.alpha(i);
        final int i3 = a.e(alpha2, alpha);
        return Color.argb(i3, a.g(Color.red(i), alpha2, Color.red(i2), alpha, i3), a.g(Color.green(i), alpha2, Color.green(i2), alpha, i3), a.g(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    private static int g(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (i * 255) * i2 + (i3 * i4) * (i2 - 255) / (i5 * 255);
    }

    private static double[] h() {
        Object obj;
        final java.lang.ThreadLocal threadLocal = a.a;
        if ((double[])threadLocal.get() == null) {
            a.a.set(new double[3]);
        }
        return obj;
    }

    public static int i(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        } else {
            int i3 = 255;
            if (i2 <= 255) {
                return (i & 16777215) | (i2 << 24);
            }
        }
    }
}
