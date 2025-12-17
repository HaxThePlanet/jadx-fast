package net.time4j.calendar.s;

import kotlin.i0.z.e.m0.e.a0.a.e.c;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import net.time4j.b0;
import net.time4j.engine.z;
import net.time4j.i0;
import net.time4j.i1.d;
import net.time4j.i1.f;
import net.time4j.tz.p;
import zendesk.support.ZendeskSupportBlipsProvider;
import zendesk.support.request.ComponentMessageComposer;
import zendesk.support.request.ComponentToolbar;
import zendesk.support.request.DocumentRenderer.Style.Li;
import zendesk.support.request.RequestConfiguration.Builder;
import zendesk.support.request.ViewAlmostRealProgressBar.Step.1;

/* loaded from: classes3.dex */
public enum b {

    VERNAL_EQUINOX,
    SUMMER_SOLSTICE,
    AUTUMNAL_EQUINOX,
    WINTER_SOLSTICE;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[b.VERNAL_EQUINOX.ordinal()] = 1;
            b.a.a[b.SUMMER_SOLSTICE.ordinal()] = 2;
            b.a.a[b.AUTUMNAL_EQUINOX.ordinal()] = 3;
            b.a.a[b.WINTER_SOLSTICE.ordinal()] = 4;
        }
    }
    private static void checkYear(int i) {
        int i2;
        if (i < -2000) {
        } else {
            if (i > 3000) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Year out of supported range: -2000 <= ");
        stringBuilder.append(i);
        stringBuilder.append(" <= +3000");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static double cos(double d) {
        return Math.cos(obj2 /= l2);
    }

    private double jdEphemerisDays(int i) {
        double jdMean = jdMean(i);
        i3 /= l2;
        i7 -= l5;
        return jdMean += i6;
    }

    private double jdMean(int i) {
        long l7;
        long l2;
        long l;
        long l10;
        long l6;
        long l5;
        int i2;
        long l8;
        long l4;
        long l9;
        long l3;
        int obj13;
        int i3 = 4;
        final int i4 = 3;
        int i5 = 2;
        final int i6 = 1;
        long l11 = 4652007308841189376L;
        if (i < 1000) {
            d2 /= l11;
            obj13 = b.a.a[ordinal()];
            if (obj13 != i6) {
                if (obj13 != i5) {
                    if (obj13 != i4) {
                        if (obj13 != i3) {
                        } else {
                            l7 = 4700144230270361949L;
                            l = 4690018437408255514L;
                            l6 = -4647856048330666211L;
                            l8 = -4646840036254731427L;
                            l9 = 4543979261917470057L;
                        }
                        obj13 = new AssertionError(this);
                        throw obj13;
                    }
                    l2 = 4700143849326863240L;
                    l10 = 4690018430759817938L;
                    l5 = -4630293450935802035L;
                    l4 = -4654377260591098689L;
                    l3 = 4559964518578843990L;
                } else {
                    l2 = 4700143452254817443L;
                    l10 = 4690018417532005861L;
                    l5 = -4635539964357703568L;
                    l4 = 4576382120804445491L;
                    l3 = 4553247309662628348L;
                }
                return i22 += l2;
            } else {
                l7 = 4700143048690584980L;
                l = 4690018424606332394L;
                l6 = 4589000846672367431L;
                l8 = 4562761794379396353L;
                l9 = 4559687817417738347L;
            }
        } else {
        }
        return i13 += l7;
    }

    public static net.time4j.calendar.s.b of(b0 b0) {
        int i = b0.w0(p.C).m();
        b.checkYear(i);
        net.time4j.calendar.s.b vERNAL_EQUINOX = b.VERNAL_EQUINOX;
        if (b0.l0(vERNAL_EQUINOX.inYear(i))) {
            return b.WINTER_SOLSTICE;
        }
        net.time4j.calendar.s.b sUMMER_SOLSTICE = b.SUMMER_SOLSTICE;
        if (b0.l0(sUMMER_SOLSTICE.inYear(i))) {
            return vERNAL_EQUINOX;
        }
        net.time4j.calendar.s.b aUTUMNAL_EQUINOX = b.AUTUMNAL_EQUINOX;
        if (b0.l0(aUTUMNAL_EQUINOX.inYear(i))) {
            return sUMMER_SOLSTICE;
        }
        net.time4j.calendar.s.b wINTER_SOLSTICE = b.WINTER_SOLSTICE;
        if (b0.l0(wINTER_SOLSTICE.inYear(i))) {
            return aUTUMNAL_EQUINOX;
        }
        return wINTER_SOLSTICE;
    }

    private static double periodic24(double d) {
        int i4;
        int i;
        int i5;
        double d2;
        int i2;
        int i3;
        i4 = 0;
        i = 0;
        while (i < 24) {
            i4 += i5;
            i++;
        }
        return i4;
    }

    @Override // java.lang.Enum
    public b0 inYear(int i) {
        int i3;
        double d;
        long deltaT;
        long l;
        int i2;
        f obj8;
        b.checkYear(i);
        i4 *= l3;
        boolean z = d.w().A();
        if (z) {
            if (i < 1972) {
                i5 -= deltaT;
                obj8 = f.UT;
            } else {
                i5 -= deltaT;
                obj8 = f.UTC;
            }
        } else {
        }
        l = (long)floor;
        if (!z) {
            l += d;
            obj8 = f.POSIX;
        }
        return b0.o0(l, obj4, (int)i7);
    }

    @Override // java.lang.Enum
    public net.time4j.calendar.s.c julianDay(int i) {
        b.checkYear(i);
        return c.g(jdEphemerisDays(i));
    }

    @Override // java.lang.Enum
    public net.time4j.calendar.s.b onNorthernHemisphere() {
        return this;
    }

    @Override // java.lang.Enum
    public net.time4j.calendar.s.b onSouthernHemisphere() {
        return b.values()[i %= 4];
    }
}
