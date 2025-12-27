package net.time4j.calendar.s;

import kotlin.i0.z.e.m0.e.a0.a.e.c;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import net.time4j.b0;
import net.time4j.engine.z;
import net.time4j.history.o;
import net.time4j.i0;
import net.time4j.i1.d;
import net.time4j.i1.f;
import net.time4j.tz.p;
import zendesk.support.ZendeskSupportBlipsProvider;
import zendesk.support.request.ComponentMessageComposer;
import zendesk.support.request.ComponentRequestRouter;
import zendesk.support.request.ComponentToolbar;
import zendesk.support.request.DocumentRenderer.Style.Li;
import zendesk.support.request.RequestConfiguration.Builder;
import zendesk.support.request.ViewAlmostRealProgressBar.Step.AnonymousClass1;

/* compiled from: AstronomicalSeason.java */
/* loaded from: classes3.dex */
public enum b {

    AUTUMNAL_EQUINOX,
    SUMMER_SOLSTICE,
    VERNAL_EQUINOX,
    WINTER_SOLSTICE;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[b.values().length];
            b.a.a = iArr;
            try {
                iArr[b.VERNAL_EQUINOX.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.SUMMER_SOLSTICE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.AUTUMNAL_EQUINOX.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.WINTER_SOLSTICE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    private static void checkYear(int i) {
        int i2 = -2000;
        if (i < -2000) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Year out of supported range: -2000 <= ";
            String str2 = " <= +3000";
            i = str + i + str2;
            throw new IllegalArgumentException(i);
        } else {
            i2 = 3000;
            if (i <= 3000) {
                return;
            }
        }
    }

    private static double cos(double d) {
        return Math.cos((d * 3.141592653589793d) / 180d);
    }

    private double jdEphemerisDays(int i) {
        double jdMean = jdMean(i);
        double d3 = (jdMean - 2451545d) / 36525d;
        double d8 = (35999.373d * d3) - 2.47d;
        return jdMean + (b.periodic24(d3) * 0.00001d) / (b.cos(d8) * 0.0334d) + 1d + (b.cos(d8 * 2d)) * 0.0007d;
    }

    private double jdMean(int i) {
        long l = 4702519233390106189L;
        long l2 = 4702519826631776755L;
        long l3 = 4690018428671776638L;
        long l4 = 4690018434967339700L;
        long l5 = 4587610135107435422L;
        long l6 = -4634242927665020865L;
        double d;
        long l7 = -4651983507317158723L;
        long l8 = -4647474143082265193L;
        long l9 = 4558396545332578678L;
        long l10 = 4554538581747788017L;
        int i3 = 4;
        final int i4 = 3;
        int i5 = 2;
        final int i6 = 1;
        double d2 = 1000d;
        if (i < 1000) {
            d = (double)i / d2;
            int i2 = b.a.a[ordinal()];
            if (b.a.a != i6) {
                if (b.a.a != i5) {
                    if (b.a.a != i4 && b.a.a == i3) {
                        l = 4700144230270361949L;
                        l3 = 4690018437408255514L;
                        l5 = -4647856048330666211L;
                        l7 = -4646840036254731427L;
                        l9 = 4543979261917470057L;
                    }
                    l2 = 4700143849326863240L;
                    l4 = 4690018430759817938L;
                    l6 = -4630293450935802035L;
                    l8 = -4654377260591098689L;
                    l10 = 4559964518578843990L;
                } else {
                    l2 = 4700143452254817443L;
                    l4 = 4690018417532005861L;
                    l6 = -4635539964357703568L;
                    l8 = 4576382120804445491L;
                    l10 = 4553247309662628348L;
                }
                return (l10 * d) + l8 * d + l6 * d + l4 * d + l2;
            } else {
                l = 4700143048690584980L;
                l3 = 4690018424606332394L;
                l5 = 4589000846672367431L;
                l7 = 4562761794379396353L;
                l9 = 4559687817417738347L;
            }
        }
        return (l7 - (l9 * d)) * d + l5 * d + l3 * d + l;
    }

    public static b of(b0 b0Var) {
        int i = b0Var.w0(p.C).m();
        b.checkYear(i);
        net.time4j.calendar.s.b vERNAL_EQUINOX2 = b.VERNAL_EQUINOX;
        if (b0Var.l0(vERNAL_EQUINOX2.inYear(i))) {
            return b.WINTER_SOLSTICE;
        }
        net.time4j.calendar.s.b sUMMER_SOLSTICE2 = b.SUMMER_SOLSTICE;
        if (b0Var.l0(sUMMER_SOLSTICE2.inYear(i))) {
            return b.VERNAL_EQUINOX;
        }
        net.time4j.calendar.s.b aUTUMNAL_EQUINOX2 = b.AUTUMNAL_EQUINOX;
        if (b0Var.l0(aUTUMNAL_EQUINOX2.inYear(i))) {
            return b.SUMMER_SOLSTICE;
        }
        net.time4j.calendar.s.b wINTER_SOLSTICE2 = b.WINTER_SOLSTICE;
        return b0Var.l0(wINTER_SOLSTICE2.inYear(i)) ? b.AUTUMNAL_EQUINOX : b.WINTER_SOLSTICE;
    }

    private static double periodic24(double d) {
        int i = 0;
        int i2 = 0;
        i = 0;
        i2 = 0;
        while (i2 < 24) {
            d5 = b.C[i2] * d;
            d4 = b.B[i2] + d5;
            d2 = (double)b.A[i2] * b.cos(d4);
            i = i + d2;
            i2 = i2 + 1;
        }
        return i;
    }

    @Override // java.lang.Enum
    public b0 inYear(int i) {
        double d;
        long l2;
        f pOSIX2;
        b.checkYear(i);
        double d3 = (jdEphemerisDays(i) - 2441317.5d) * 86400d;
        boolean z = d.w().A();
        if (!z || i < 1972) {
            d = d3 - (f.deltaT(i, (ordinal() + 1) * 3));
            pOSIX2 = f.UT;
        }
        double floored = Math.floor(d);
        l2 = (long)floored;
        if (!z) {
            long l = 63072000L;
            l2 = (long)floored + l;
            pOSIX2 = f.POSIX;
        }
        return b0.o0(l2, (int)(d - floored) * 1000000000d, pOSIX2);
    }

    @Override // java.lang.Enum
    public c julianDay(int i) {
        b.checkYear(i);
        return c.g(jdEphemerisDays(i));
    }

    @Override // java.lang.Enum
    public b onSouthernHemisphere() {
        return b.values()[(ordinal() + 2) % 4];
    }

    @Override // java.lang.Enum
    public b onNorthernHemisphere() {
        return this;
    }
}
