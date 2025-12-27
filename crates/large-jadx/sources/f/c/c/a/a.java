package f.c.c.a;

import com.google.common.base.n;
import f.c.c.b.b;
import java.math.RoundingMode;

/* compiled from: IntMath.java */
/* loaded from: classes2.dex */
public final class a {

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[RoundingMode.values().length];
            a.a.a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.UP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public static int a(int i, int i2, RoundingMode roundingMode) {
        int i4;
        int i5;
        boolean z = true;
        int i6 = 1;
        int i7;
        n.o(roundingMode);
        if (i2 == 0) {
            throw new ArithmeticException("/ by zero");
        } else {
            i4 = i / i2;
            i5 = i - (i2 * i4);
            if (i5 == 0) {
                return i4;
            }
            i6 = 1;
            int i12 = (i ^ i2) >> 31 | i6;
            i6 = 0;
            switch (a.a.a[roundingMode.ordinal()]) {
                case 1: /* ordinal */
                    c.c(z);
                    return i4;
                case 2: /* ordinal */
                    return i4;
                case 3: /* ordinal */
                    return i4;
                case 4: /* ordinal */
                    return i4;
                case 5: /* ordinal */
                    return i4;
                case 6: /* ordinal */
                    int abs = Math.abs(i5);
                    i7 = Math.abs(i2) - abs;
                    i5 = abs - (Math.abs(i2) - abs);
                    i7 = i6 & i6;
                    return i4;
                default:
                    throw new AssertionError();
            }
            i4 = i4 + i12;
        }
    }

    public static int d(int i, RoundingMode roundingMode) {
        c.b("x", i);
        switch (a.a.a[roundingMode.ordinal()]) {
            case 1: /* ordinal */
                c.c(a.b(i));
                return Integer.numberOfLeadingZeros(i) - 31;
            case 2: /* ordinal */
                return Integer.numberOfLeadingZeros(i - 1) - 32;
            case 3: /* ordinal */
                int numberOfLeadingZeros3 = Integer.numberOfLeadingZeros(i);
                return numberOfLeadingZeros3 - 31 + a.c(-1257966797 >>> numberOfLeadingZeros3, i);
            default:
                throw new AssertionError();
        }
    }

    public static int e(int i, int i2) {
        return b.j((long)i * (long)i2);
    }


    public static boolean b(int i) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        int r2 = i > 0 ? i2 : 0;
        if (i & i - 1 == 0) {
        }
        return i2 & i2;
    }

    static int c(int i, int i2) {
        i -= i2;
        return i3 >>> 31;
    }
}
