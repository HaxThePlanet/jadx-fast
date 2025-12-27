package net.time4j.calendar.s;

import android.app.ActivityManager.MemoryInfo;
import java.util.concurrent.TimeUnit;
import kotlin.i0.z.e.m0.d.a.g0.l.j.c;
import kotlin.i0.z.e.m0.e.h.c;
import kotlin.i0.z.e.m0.i.v.h;
import net.time4j.b0;
import net.time4j.engine.q;
import net.time4j.f1.c;
import zendesk.core.ZendeskApplicationModule_ProvideDeviceInfoFactory;
import zendesk.support.guide.HelpCenterPresenter;
import zendesk.support.guide.ViewArticleActionHandler.ActionPayload;
import zendesk.support.request.AdapterAttachmentCarousel.ImageAttachmentViewHolder;
import zendesk.support.request.CellAgentMessage;

/* compiled from: MoonPhase.java */
/* loaded from: classes3.dex */
public enum d {

    FIRST_QUARTER(90),
    FULL_MOON(180),
    LAST_QUARTER(270);

    private final transient int phase;
    private static double corrQuarter(double d, double d2, double d3, double d4) {
        double d11 = 0.00002d;
        return (0.00306d - (d * 0.00038d) * d.cos(d2)) + (d.cos(d3) * 0.00026d) - (d.cos(d3 - d2)) * d11 + (d.cos(d3 + d2)) * d11 + (d.cos(d4 * 2d)) * d11;
    }

    private static double cos(double d) {
        return Math.cos((d * 3.141592653589793d) / 180d);
    }

    private int getEstimatedLunations(b0 b0Var) {
        final TimeUnit dAYS2 = TimeUnit.DAYS;
        return c.g(Math.round((double)(d.ZERO_REF.N(b0Var, dAYS2)) / 29.530588861d - (double)this.phase / 360d));
    }

    public static double getIllumination(b0 b0Var) {
        return d.getIllumination(b0Var, 0);
    }

    private double periodic24(double d, double d2, double d3, double d4) {
        int[] z_QUARTER2;
        double[] v_FULL2;
        int[] w_QUARTER2;
        int[] x_QUARTER2;
        int[] y_QUARTER2;
        int i = 0;
        int i2 = 23;
        double d6;
        int i3;
        int i4 = 1;
        final net.time4j.calendar.s.d d9 = this;
        nEW_MOON2 = d.NEW_MOON;
        if (d9 == d.NEW_MOON) {
            v_FULL2 = d.V_NEW;
        } else {
            double[] r2 = d9 == d.FULL_MOON ? d.V_FULL : d.V_QUARTER;
        }
        if (d9 == d.NEW_MOON || d9 == d.FULL_MOON) {
            w_QUARTER2 = d.W_NEW_FULL;
        }
        if (d9 == d.NEW_MOON || d9 == d.FULL_MOON) {
            x_QUARTER2 = d.X_NEW_FULL;
        }
        if (d9 == d.NEW_MOON || d9 == d.FULL_MOON) {
            y_QUARTER2 = d.Y_NEW_FULL;
        }
        if (d9 == d.NEW_MOON || d9 == d.FULL_MOON) {
            z_QUARTER2 = d.Z_NEW_FULL;
        }
        i = 0;
        i2 = 23;
        while (i2 >= 0) {
            i4 = 1;
            double r9 = d6 * d;
            d8 = (double)z_QUARTER2[i2] * d4;
            d5 = (d6 * d) * (d.sin((double)x_QUARTER2[i2] * d2 + (double)y_QUARTER2[i2] * d3 + (double)z_QUARTER2[i2] * d4, i4));
            i = i + (d6 * d);
            i2 = i2 - 1;
        }
        return i;
    }

    private static double sin(double d) {
        return Math.sin((d * 3.141592653589793d) / 180d);
    }

    @Override // java.lang.Enum
    public b0 after(b0 b0Var) {
        b0 atLunation;
        int estimatedLunations;
        estimatedLunations = getEstimatedLunations(b0Var);
        atLunation = atLunation(estimatedLunations);
        while (!atLunation.k0(b0Var)) {
            estimatedLunations = estimatedLunations + 1;
            atLunation = atLunation(estimatedLunations);
        }
        if (estimatedLunations <= estimatedLunations) {
            estimatedLunations = estimatedLunations - 1;
            atLunation = atLunation(estimatedLunations);
            while (atLunation.k0(b0Var)) {
                estimatedLunations = estimatedLunations - 1;
                atLunation = atLunation(estimatedLunations - 1);
            }
        }
        return atLunation;
    }

    @Override // java.lang.Enum
    public b0 atLunation(int i) {
        int i2 = 0;
        double d5;
        final Object i4 = this;
        double d79 = (double)i + (double)i4.phase / 360d;
        double d7 = d79 / 1236.85d;
        double d82 = d7 * d7;
        final double d = 1d - (0.0000074d * d7) + 0.002516d * d7;
        final double d2 = (29.1053567d * d79) + 2.5534d - (0.00000011d * d7) + 0.0000014d * d82;
        final double d3 = (385.81693528d * d79) + 201.5643d + (0.00001238d - (0.000000058d * d7)) * d7 + 0.0107582d * d82;
        double d21 = (390.67050284d * d79) + 160.7108d;
        double d54 = -0.00000227d;
        double d41 = (0.000000011d * d7) + d54 * d7 - 4658296098431332592L * d82;
        final double d4 = d21 + d41;
        d5 = (29.530588861d * d79) + 2451550.09766d + (0.00000000073d * d7) - 4718609169332206730L * d7 + 0.00015437d * d82 - (Math.sin(Math.toRadians((124.7746d - (1.56375588d * d79)) + (0.00000215d * d7) + 0.0020672d * d82))) * 0.00017d + (this.periodic24(d, d2, d3, d4));
        if (i4 == d.FIRST_QUARTER) {
            d5 = d5 + (d.corrQuarter(d, d2, d3, d4));
        } else {
            if (i4 == d.LAST_QUARTER) {
                d5 = d5 - (d.corrQuarter(d, d2, d3, d4));
            }
        }
        int i5 = 28;
        double[] dArr = new double[i5];
        i2 = 0;
        dArr[i2] = (0.107408d * d79) + 299.77d - (d82 * 0.009173d);
        dArr[1] = 4554630815468156564L;
        sin = (0.016321d * d79) + 251.88d;
        dArr[2] = sin;
        dArr[3] = 4550219449561154616L;
        dArr[4] = (26.651886d * d79) + 251.83d;
        dArr[5] = 4550182556073007197L;
        dArr[6] = (36.412478d * d79) + 349.42d;
        dArr[7] = 4548780603523405271L;
        dArr[8] = (18.206239d * d79) + 84.66d;
        dArr[9] = 4547744991781892171L;
        dArr[10] = (53.303771d * d79) + 141.74d;
        dArr[11] = 4544203216919739937L;
        dArr[12] = (2.453732d * d79) + 207.14d;
        dArr[13] = 4543979261917470057L;
        dArr[14] = (7.30686d * d79) + 154.84d;
        dArr[15] = 4543388966107111351L;
        dArr[16] = (27.261239d * d79) + 34.52d;
        dArr[17] = 4542060800533804263L;
        dArr[18] = (0.121824d * d79) + 207.19d;
        dArr[19] = 4541322930770855881L;
        dArr[20] = (1.844379d * d79) + 291.34d;
        dArr[21] = 4541027782865676529L;
        dArr[22] = (24.198154d * d79) + 161.72d;
        dArr[23] = 4540585061007907499L;
        dArr[24] = (25.513099d * d79) + 239.56d;
        dArr[25] = 4540289913102728146L;
        double d77 = 3.592518d;
        dArr[26] = (d79 * d77) + 331.55d;
        int i3 = 27;
        dArr[i3] = 4537409626953844091L;
        while (i4.phase < d.LAST_QUARTER) {
            i3 = (dArr[i2 + 1]) * Math.sin(Math.toRadians(dArr[i2]));
            d5 = d5 + i3;
            i2 = i2 + 2;
        }
        return (b0)c.g(d5).i().G(b0.C, TimeUnit.SECONDS);
    }

    @Override // java.lang.Enum
    public b0 atOrAfter(b0 b0Var) {
        b0 atLunation;
        int estimatedLunations;
        estimatedLunations = getEstimatedLunations(b0Var);
        atLunation = atLunation(estimatedLunations);
        while (atLunation.l0(b0Var)) {
            estimatedLunations = estimatedLunations + 1;
            atLunation = atLunation(estimatedLunations);
        }
        if (estimatedLunations <= estimatedLunations) {
            estimatedLunations = estimatedLunations - 1;
            atLunation = atLunation(estimatedLunations);
            while (!atLunation.l0(b0Var)) {
                estimatedLunations = estimatedLunations - 1;
                atLunation = atLunation(estimatedLunations - 1);
            }
        }
        return atLunation;
    }

    @Override // java.lang.Enum
    public b0 before(b0 b0Var) {
        b0 atLunation;
        int estimatedLunations;
        estimatedLunations = getEstimatedLunations(b0Var);
        atLunation = atLunation(estimatedLunations);
        while (!atLunation.l0(b0Var)) {
            estimatedLunations = estimatedLunations - 1;
            atLunation = atLunation(estimatedLunations);
        }
        if (estimatedLunations >= estimatedLunations) {
            while ((b0)atLunation.M(29L, TimeUnit.DAYS).l0(b0Var)) {
                estimatedLunations = estimatedLunations + 1;
                atLunation = atLunation(estimatedLunations);
            }
        }
        return atLunation;
    }

    public static double getIllumination(b0 b0Var, int i) {
        double d = c.h(b0Var).b();
        double d14 = e.c(d);
        double d2 = e.a(d);
        double d20 = 2d;
        double d33 = d14 * d20;
        double d15 = 1d;
        double d41 = (double)d.FACTORS[i];
        double d11 = (d.cos((180d - d14) - (d.sin(d2) * 6.289d) + (d.sin(e.b(d)) * 2.1d) - (d.sin(d33 - d2)) * 1.274d - (d.sin(d33) * 0.658d) - (d.sin(d2 * d20)) * 0.214d - (d.sin(d14) * 0.11d))) + d15 / d20 * d41;
        double d21 = d41 - d11;
        if (d21 <= 4602678819172646912L) {
            return d15;
        }
        return Math.floor(d11) / d41;
    }

    public static int maxLunation() {
        return 12379;
    }

    public static int minLunation() {
        return -49473;
    }
}
