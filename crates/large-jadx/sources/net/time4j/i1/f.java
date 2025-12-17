package net.time4j.i1;

import net.time4j.f1.a;
import net.time4j.f1.b;

/* loaded from: classes3.dex */
public enum f {

    POSIX,
    UTC,
    TAI,
    GPS,
    TT,
    UT;
    private static double deltaT(int i, double d2) {
        int i4;
        int i11;
        int i8;
        int i2;
        int i5;
        int i7;
        int i15;
        int i12;
        int i9;
        int i17;
        int i3;
        long l10;
        long l12;
        long l15;
        long l6;
        long l13;
        long l20;
        long l7;
        long l17;
        long l19;
        long l;
        int i13;
        long l3;
        long l14;
        long l21;
        long l2;
        long l9;
        long l5;
        int i6;
        long l11;
        long l22;
        int i10;
        long l18;
        long l16;
        int i16;
        long l8;
        int i14;
        long l4;
        int i18 = i;
        if (i18 < -2000) {
        } else {
            if (i18 > 3000) {
            } else {
                l9 = 4636737291354636288L;
                if (i18 <= 2050) {
                    l22 = 4656510908468559872L;
                    if (i18 >= 2018) {
                        l10 = 4634215275563308810L;
                        l20 = 4587842160560237550L;
                        l37 *= i4;
                        return i28 += l10;
                    } else {
                    }
                }
                i19 /= l9;
                return i25 += l34;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Year out of range: ");
        stringBuilder.append(i18);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static double deltaT(int i, int i2) {
        int i3;
        if (i2 < 1) {
        } else {
            if (i2 > 12) {
            } else {
                return f.deltaT(i, d += i6);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Month out of range: ");
        stringBuilder.append(i2);
        IllegalArgumentException obj6 = new IllegalArgumentException(stringBuilder.toString());
        throw obj6;
    }

    public static double deltaT(a a) {
        int i2;
        int i;
        int i5;
        int i6;
        int i3;
        int i4;
        i2 = a.m();
        int i7 = 365;
        i = b.e(i2) ? 366 : i7;
        i5 = 0;
        i3 = i6;
        while (i3 < a.o()) {
            i5 += i4;
            i3++;
        }
        i5 += i11;
        if (i9 > i) {
        } else {
            if (i2 == -2001 && i9 == i7) {
                if (i9 == i7) {
                    i2 = -2000;
                } else {
                    i6 = i9;
                }
            } else {
            }
            return f.deltaT(i2, d += i13);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(a.toString());
        throw illegalArgumentException;
    }
}
