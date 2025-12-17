package f.c.c.a;

import com.google.common.base.n;
import f.c.c.b.b;
import java.math.RoundingMode;

/* loaded from: classes2.dex */
public final class a {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            a.a.a[RoundingMode.DOWN.ordinal()] = 2;
            a.a.a[RoundingMode.FLOOR.ordinal()] = 3;
            a.a.a[RoundingMode.UP.ordinal()] = 4;
            a.a.a[RoundingMode.CEILING.ordinal()] = 5;
            a.a.a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            a.a.a[RoundingMode.HALF_UP.ordinal()] = 7;
            a.a.a[RoundingMode.HALF_EVEN.ordinal()] = 8;
        }
    }
    static {
    }

    public static int a(int i, int i2, RoundingMode roundingMode3) {
        int i4;
        int i5;
        int i6;
        int obj6;
        Object obj7;
        n.o(roundingMode3);
        if (i2 == 0) {
        } else {
            i4 = i / i2;
            i5 = i - i7;
            if (i5 == 0) {
                return i4;
            }
            i6 = 1;
            obj5 |= i6;
            int i10 = 0;
            switch (i9) {
                case 1:
                    i6 = i10;
                    c.c(i6);
                    i6 = i10;
                    return i4;
                case 2:
                    i6 = i10;
                    return i4;
                case 3:
                    i6 = i10;
                    return i4;
                case 4:
                    return i4;
                case 5:
                    i6 = i10;
                    return i4;
                case 6:
                    int i8 = Math.abs(i5);
                    i8 -= obj6;
                    obj6 = i6;
                    obj6 = i10;
                    obj7 = i6;
                    obj7 = i10;
                    i6 = i10;
                    return i4;
                default:
                    AssertionError obj5 = new AssertionError();
                    throw obj5;
            }
            i4 += obj5;
        }
        obj5 = new ArithmeticException("/ by zero");
        throw obj5;
    }

    public static boolean b(int i) {
        int i2;
        int i3;
        final int i4 = 1;
        i3 = i > 0 ? i4 : i2;
        if (i &= i5 == 0) {
            i2 = i4;
        }
        return i3 & i2;
    }

    static int c(int i, int i2) {
        return obj0 >>>= 31;
    }

    public static int d(int i, RoundingMode roundingMode2) {
        c.b("x", i);
        switch (obj2) {
            case 1:
                c.c(a.b(i));
                return obj1 - 31;
            case 2:
                return obj1 - 32;
            case 3:
                int obj2 = Integer.numberOfLeadingZeros(i);
                return obj2 += obj1;
            default:
                AssertionError obj1 = new AssertionError();
                throw obj1;
        }
    }

    public static int e(int i, int i2) {
        return b.j(l *= obj2);
    }
}
