package net.time4j.i1;

import net.time4j.f1.a;
import net.time4j.f1.b;

/* compiled from: TimeScale.java */
/* loaded from: classes3.dex */
public enum f {

    GPS,
    POSIX,
    TAI,
    TT,
    UT,
    UTC;
    public static double deltaT(int i, int i2) {
        int i3 = 1;
        if (i2 < 1) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Month out of range: ";
            i2 = str + i2;
            throw new IllegalArgumentException(i2);
        } else {
            i3 = 12;
            if (i2 <= 12) {
                return f.deltaT(i, (double)i + (double)i2 - 0.5d / 12d);
            }
        }
    }

    public static double deltaT(a aVar) {
        int i = -2000;
        int i2 = 366;
        int i3 = 0;
        int i4 = 1;
        i = aVar.m();
        i2 = 365;
        int r1 = b.e(i) ? 366 : i2;
        i3 = 0;
        i4 = 1;
        while (i4 < aVar.o()) {
            i3 = i3 + (b.d(i, i4));
            i4 = i4 + 1;
        }
        i3 += i7;
        if (i4 > i2) {
            throw new IllegalArgumentException(aVar.toString());
        } else {
            if (i != -2001 || i4 != i2) {
            } else {
                i = -2000;
            }
            return f.deltaT(i, (double)i + (double)i4 - 1d / (double)i2);
        }
    }

    private static double deltaT(int i, double d) {
        double d3;
        double d6;
        double d5;
        double d4;
        int i6 = 2005;
        long l = 4634215275563308810L;
        long l2 = 4634146792701475108L;
        long l5 = 4667044009960328397L;
        long l4 = -4609907096574576558L;
        long l3 = 4634184313315870638L;
        long l6 = 4587842160560237550L;
        long l7 = 4595343968589135171L;
        long l10 = -4571237976313136415L;
        long l9 = 4609407732944294090L;
        long l8 = 4599697436219327644L;
        double d7;
        long l11 = 4579339940924514357L;
        long l14 = 4629951367359731157L;
        long l13 = -4634579595155884872L;
        long l12 = -4634510405454089654L;
        long l15 = -4660529768554357898L;
        long l17 = -4604984602509165543L;
        double d8;
        long l16 = 4565609510495775265L;
        double d10;
        long l19 = -4627724410358605405L;
        long l18 = 4559151146292401915L;
        double d11;
        long l20 = 4582048497109444213L;
        double d12;
        long l21 = 4576360014745162235L;
        int i2 = i;
        int i3 = -2000;
        if (i2 < -2000) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Year out of range: ";
            r0 = str + i2;
            throw new IllegalArgumentException(r0);
        } else {
            i3 = 3000;
            if (i2 <= 3000) {
                int i4 = 2050;
                double d25 = 100d;
                if (i2 <= 2050) {
                    int i5 = 2018;
                    double d9 = 2000d;
                    if (i2 >= 2018) {
                        d = d - d9;
                        l = 4634215275563308810L;
                        l6 = 4587842160560237550L;
                        d7 = 0.012125d * d;
                        return (d7 + l6) * d + l;
                    }
                }
                double d14 = (d - 1820d) / d25;
                return (32d * d14) * d14 - 4597049319638433792L;
            }
        }
    }
}
