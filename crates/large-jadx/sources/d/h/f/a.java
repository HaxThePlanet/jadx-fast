package d.h.f;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    private static final java.lang.ThreadLocal<double[]> a;
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        a.a = threadLocal;
    }

    public static void a(int i, int i2, int i3, double[] d4Arr4) {
        double d2;
        long cmp;
        double d3;
        long l;
        double d;
        int[] iArr = d4Arr4;
        final int i11 = 3;
        if (iArr.length != i11) {
        } else {
            long l2 = 4643176031446892544L;
            d4 /= l2;
            final long l9 = 4585990280393462802L;
            long l13 = 4623462931452961751L;
            l = 4607430116779522785L;
            final long l17 = 4588087156379966505L;
            if (Double.compare(i4, l9) < 0) {
                i4 /= l13;
            } else {
                d2 = Math.pow(i5 /= l, i11);
            }
            d5 /= l2;
            if (Double.compare(i27, l9) < 0) {
                i27 /= l13;
            } else {
                d3 = Math.pow(i29 /= l, obj11);
            }
            d6 /= l2;
            if (Double.compare(i31, l9) < 0) {
                i31 /= l13;
            } else {
                d = Math.pow(i33 /= l3, obj13);
            }
            long l12 = 4636737291354636288L;
            iArr[0] = i17 *= l12;
            iArr[1] = i21 *= l12;
            iArr[2] = i9 *= l12;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("outXyz must have a length of 3.");
        throw illegalArgumentException;
    }

    public static int b(int i, int i2, float f3) {
        i3 -= f3;
        return Color.argb((int)i7, (int)i11, (int)i15, (int)obj5);
    }

    public static double c(int i) {
        final double[] dArr = a.h();
        a.d(i, dArr);
        return d /= l;
    }

    public static void d(int i, double[] d2Arr2) {
        a.a(Color.red(i), Color.green(i), Color.blue(i), d2Arr2);
    }

    private static int e(int i, int i2) {
        return obj1 - 255;
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
        return obj0 /= obj4;
    }

    private static double[] h() {
        Object dArr;
        final java.lang.ThreadLocal threadLocal = a.a;
        if ((double[])threadLocal.get() == null) {
            threadLocal.set(new double[3]);
        }
        return dArr;
    }

    public static int i(int i, int i2) {
        int i3;
        if (i2 < 0) {
        } else {
            if (i2 > 255) {
            } else {
                return obj1 |= obj2;
            }
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("alpha must be between 0 and 255.");
        throw obj1;
    }
}
