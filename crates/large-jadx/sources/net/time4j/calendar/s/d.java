package net.time4j.calendar.s;

import android.app.ActivityManager.MemoryInfo;
import java.util.concurrent.TimeUnit;
import kotlin.i0.z.e.m0.d.a.g0.l.j.c;
import kotlin.i0.z.e.m0.e.h.c;
import kotlin.i0.z.e.m0.i.v.h;
import net.time4j.b0;
import net.time4j.engine.i0;
import net.time4j.engine.q;
import net.time4j.f1.c;
import net.time4j.i0;
import zendesk.core.ZendeskApplicationModule_ProvideDeviceInfoFactory;
import zendesk.support.guide.HelpCenterPresenter;

/* loaded from: classes3.dex */
public enum d {

    NEW_MOON(false),
    FIRST_QUARTER(90),
    FULL_MOON(180),
    LAST_QUARTER(270);

    private final transient int phase;
    private static double corrQuarter(double d, double d2, double d3, double d4) {
        long l4 = 4536524183238306033L;
        return i4 += obj4;
    }

    private static double cos(double d) {
        return Math.cos(obj2 /= l2);
    }

    private int getEstimatedLunations(b0 b0) {
        final TimeUnit dAYS = TimeUnit.DAYS;
        return c.g(Math.round(i -= i3));
    }

    public static double getIllumination(b0 b0) {
        return d.getIllumination(b0, 0);
    }

    public static double getIllumination(b0 b0, int i2) {
        double d = c.h(b0).b();
        double d6 = e.c(d);
        double d2 = e.a(d);
        long l3 = 4611686018427387904L;
        int i19 = d6 * l3;
        long l2 = 4607182418800017408L;
        double obj14 = (double)obj14;
        i6 *= obj14;
        if (Double.compare(i10, l5) <= 0) {
            return l2;
        }
        return floor /= obj14;
    }

    public static int maxLunation() {
        return 12379;
    }

    public static int minLunation() {
        return -49473;
    }

    private double periodic24(double d, double d2, double d3, double d4) {
        int[] z_NEW_FULL;
        net.time4j.calendar.s.d fULL_MOON2;
        double[] v_QUARTER;
        net.time4j.calendar.s.d fULL_MOON3;
        int[] w_NEW_FULL;
        int[] x_NEW_FULL;
        net.time4j.calendar.s.d fULL_MOON;
        int[] y_NEW_FULL;
        net.time4j.calendar.s.d fULL_MOON4;
        int i5;
        int i6;
        int i2;
        double d6;
        double d5;
        int i4;
        int i3;
        int i;
        final net.time4j.calendar.s.d dVar = this;
        fULL_MOON2 = d.NEW_MOON;
        v_QUARTER = dVar == fULL_MOON2 ? d.V_NEW : dVar == fULL_MOON5 ? d.V_FULL : d.V_QUARTER;
        if (dVar != fULL_MOON2) {
            if (dVar == d.FULL_MOON) {
                w_NEW_FULL = d.W_NEW_FULL;
            } else {
                w_NEW_FULL = d.W_QUARTER;
            }
        } else {
        }
        if (dVar != fULL_MOON2) {
            if (dVar == d.FULL_MOON) {
                x_NEW_FULL = d.X_NEW_FULL;
            } else {
                x_NEW_FULL = d.X_QUARTER;
            }
        } else {
        }
        if (dVar != fULL_MOON2) {
            if (dVar == d.FULL_MOON) {
                y_NEW_FULL = d.Y_NEW_FULL;
            } else {
                y_NEW_FULL = d.Y_QUARTER;
            }
        } else {
        }
        if (dVar != fULL_MOON2) {
            if (dVar == d.FULL_MOON) {
                z_NEW_FULL = d.Z_NEW_FULL;
            } else {
                z_NEW_FULL = d.Z_QUARTER;
            }
        } else {
        }
        i5 = 0;
        i6 = 23;
        while (i6 >= 0) {
            if (w_NEW_FULL[i6] == 1) {
            } else {
            }
            if (w_NEW_FULL[i6] == 2) {
            }
            i5 += i2;
            i6--;
            d6 *= d;
            d6 *= d;
        }
        return i5;
    }

    private static double sin(double d) {
        return Math.sin(obj2 /= l2);
    }

    @Override // java.lang.Enum
    public b0 after(b0 b0) {
        int estimatedLunations;
        b0 atLunation;
        int i;
        boolean z;
        estimatedLunations = getEstimatedLunations(b0);
        atLunation = atLunation(estimatedLunations);
        i = estimatedLunations;
        while (!atLunation.k0(b0)) {
            atLunation = atLunation(i++);
        }
        if (i <= estimatedLunations) {
        }
        return atLunation;
    }

    @Override // java.lang.Enum
    public b0 atLunation(int i) {
        net.time4j.calendar.s.d lAST_QUARTER;
        int i2;
        int i3;
        int i4;
        int i5;
        final Object obj3 = this;
        int i103 = d + i9;
        int i6 = i103 / l;
        int i106 = i6 * i6;
        final int i109 = l18 - i15;
        final int i110 = i17 - i61;
        final int i111 = i19 + i79;
        i20 += l24;
        long l59 = -4700901724644111273L;
        i66 *= i106;
        final int i112 = i21 + i67;
        i108 += periodic24;
        if (obj3 == d.FIRST_QUARTER) {
            i5 += lAST_QUARTER;
        } else {
            if (obj3 == d.LAST_QUARTER) {
                i5 -= lAST_QUARTER;
            }
        }
        int i7 = 28;
        double[] dArr = new double[i7];
        dArr[0] = i69 -= i107;
        dArr[1] = 4554630815468156564L;
        dArr[2] = i73 += l11;
        dArr[3] = 4550219449561154616L;
        dArr[4] = i80 += l28;
        dArr[5] = 4550182556073007197L;
        dArr[6] = i82 += l30;
        dArr[7] = 4548780603523405271L;
        dArr[8] = i84 += l32;
        dArr[9] = 4547744991781892171L;
        dArr[10] = i86 += l34;
        dArr[11] = 4544203216919739937L;
        dArr[12] = i88 += l36;
        dArr[13] = 4543979261917470057L;
        dArr[14] = i90 += l38;
        dArr[15] = 4543388966107111351L;
        dArr[16] = i92 += l40;
        dArr[17] = 4542060800533804263L;
        dArr[18] = i94 += l42;
        dArr[19] = 4541322930770855881L;
        dArr[20] = i96 += l44;
        dArr[21] = 4541027782865676529L;
        dArr[22] = i98 += l46;
        dArr[23] = 4540585061007907499L;
        dArr[24] = i100 += l48;
        dArr[25] = 4540289913102728146L;
        long l71 = 4615272050163078308L;
        dArr[26] = i104 += l50;
        dArr[27] = 4537409626953844091L;
        while (i2 < i7) {
            i5 += i3;
            i2 += 2;
        }
        return (b0)c.g(i5).i().G(b0.C, TimeUnit.SECONDS);
    }

    @Override // java.lang.Enum
    public b0 atOrAfter(b0 b0) {
        int estimatedLunations;
        b0 atLunation;
        int i;
        boolean z;
        estimatedLunations = getEstimatedLunations(b0);
        atLunation = atLunation(estimatedLunations);
        i = estimatedLunations;
        while (atLunation.l0(b0)) {
            atLunation = atLunation(i++);
        }
        if (i <= estimatedLunations) {
        }
        return atLunation;
    }

    @Override // java.lang.Enum
    public b0 before(b0 b0) {
        int estimatedLunations;
        b0 atLunation;
        int i;
        boolean z;
        estimatedLunations = getEstimatedLunations(b0);
        atLunation = atLunation(estimatedLunations);
        i = estimatedLunations;
        while (!atLunation.l0(b0)) {
            atLunation = atLunation(i--);
        }
        if (i >= estimatedLunations) {
        }
        return atLunation;
    }
}
