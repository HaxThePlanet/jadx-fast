package net.time4j.calendar.s;

import android.app.ActivityManager.MemoryInfo;
import i.b.j0.d;
import i.b.m0.e.b.e0.c;
import i.b.m0.e.c.w.b;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.e.l;
import kotlinx.coroutines.y1.a;
import net.time4j.b0;
import net.time4j.engine.g;
import net.time4j.engine.i0;
import net.time4j.engine.q;
import net.time4j.engine.z;
import net.time4j.g0;
import net.time4j.h0;
import net.time4j.i0;
import net.time4j.i1.d;
import net.time4j.i1.f;
import net.time4j.tz.p;
import okhttp3.internal.concurrent.TaskQueue.execute.1;
import zendesk.belvedere.g;
import zendesk.support.GuideModule;
import zendesk.support.request.ComponentPersistence;
import zendesk.support.request.ComponentRequestAdapter.RequestViewHolder;
import zendesk.support.request.ComponentRequestRouter;
import zendesk.support.request.ComponentRequestRouter.RequestScreen;
import zendesk.support.request.ComponentToolbar.ToolbarModel;

/* loaded from: classes3.dex */
public enum h implements net.time4j.calendar.s.g.b {

    SIMPLE,
    NOAA,
    CC,
    TIME4J;

    static enum a extends net.time4j.calendar.s.h {
        private b0 event(g g, double d2, double d3, double d4, boolean z5) {
            f pOSIX;
            int i2;
            int compare2;
            int i;
            long l;
            double degrees;
            int i3;
            int compare;
            g0 g0Var = g.g(g);
            long l2 = 4624633867356078080L;
            int i11 = d4 / l2;
            i2 = obj30 != null ? 6 : 18;
            final long l7 = 4627448617123184640L;
            d5 += i17;
            double trueLongitudeOfSunInDegrees = this.trueLongitudeOfSunInDegrees(i14);
            double d9 = a.c(Math.toDegrees(Math.atan(d10 *= l8)));
            long l9 = 4636033603912859648L;
            d7 *= l10;
            double radians3 = Math.toRadians(d2);
            int i20 = i35 / i29;
            if (Double.compare(i20, obj9) <= 0) {
                if (Double.compare(i20, obj9) < 0) {
                } else {
                    if (obj30 != null) {
                        degrees = compare - degrees;
                    }
                    i23 -= l4;
                    if (Double.compare(0, obj3) > 0) {
                        i3 += l7;
                    } else {
                        if (Double.compare(l7, obj11) <= 0) {
                            i3 -= l7;
                        }
                    }
                    pOSIX = f.UT;
                    if (!d.w().A()) {
                        i += l;
                        pOSIX = f.POSIX;
                    }
                }
                return (b0)b0.p0(round *= i12, i).G(b0.C, TimeUnit.MINUTES);
            }
            return null;
        }

        private double time0(double d) {
            i0 obj5 = c.g(d).i().w0(p.C);
            return d2 += obj5;
        }

        private double trueLongitudeOfSunInDegrees(double d) {
            obj5 -= l2;
            return a.c(i3 += obj5);
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return Math.toDegrees(Math.asin(obj3 *= l));
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            double obj5 = time0(d);
            return i4 *= obj5;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i2) {
            return 0;
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i2) {
            return obj3 += l;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            double obj7 = trueLongitudeOfSunInDegrees(time0(d));
            double d3 = a.c(Math.toDegrees(Math.atan(d2 *= l)));
            long l2 = 4636033603912859648L;
            return i2 -= i5;
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(g g, double d2, double d3, double d4) {
            return this.event(g, d2, obj3, d4, obj5);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(g g, double d2, double d3, double d4) {
            return this.event(g, d2, obj3, d4, obj5);
        }
    }

    static enum b extends net.time4j.calendar.s.h {
        private double declinationRad(double d) {
            return Math.asin(d2 *= obj3);
        }

        private double equationOfCenter(double d) {
            double radians = Math.toRadians(meanAnomaly(d));
            return i3 += obj9;
        }

        private b0 event(boolean z, g g2, double d3, double d4, double d5) {
            b0 b0Var = g.e(g2, 12, d5, obj4);
            final double d8 = c.e(b0Var, f.TT);
            double d = this;
            double localHourAngle = d.localHourAngle(z, d8, obj5, d3);
            int i7 = 0;
            if (Double.isNaN(localHourAngle)) {
                return i7;
            }
            double localHourAngle2 = this.localHourAngle(z, d8 + i2, obj15, d3);
            if (Double.isNaN(localHourAngle2)) {
                return i7;
            }
            long l = (long)floor;
            TimeUnit sECONDS = TimeUnit.SECONDS;
            return (b0)(b0)(b0)b0Var.M(l, i7).M((long)i5, i7).G(b0.C, sECONDS);
        }

        private double excentricity(double d) {
            return obj5 -= i3;
        }

        private double localHourAngle(double d, double d2, double d3) {
            int obj5;
            double obj7 = Math.toRadians(d3);
            obj5 = declinationRad(d);
            obj9 /= obj5;
            if (Double.compare(obj9, obj10) <= 0 && Double.compare(obj9, obj10) < 0) {
                if (Double.compare(obj9, obj10) < 0) {
                }
                return obj5 *= obj7;
            }
            return 9221120237041090560L;
        }

        private double localHourAngle(boolean z, double d2, double d3, double d4) {
            double obj9;
            obj9 = this.localHourAngle(h.access$100(d2), obj2, d4);
            if (Double.isNaN(obj9)) {
                return 9221120237041090560L;
            }
            if (z) {
                obj9 = -obj9;
            }
            return obj9;
        }

        private double meanAnomaly(double d) {
            return i3 += obj5;
        }

        private double meanLongitude(double d) {
            return i4 %= obj5;
        }

        private double obliquity(double d) {
            return i8 += obj5;
        }

        private double solarLongitude(double d) {
            return i2 -= obj5;
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return Math.toDegrees(declinationRad(h.access$100(d)));
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            final Object obj = this;
            double d2 = h.access$100(d);
            final long l3 = 4611686018427387904L;
            double d4 = Math.tan(Math.toRadians(obliquity /= l3));
            d4 *= d4;
            double radians3 = Math.toRadians(meanLongitude *= l3);
            final double excentricity = obj.excentricity(d2);
            double radians = Math.toRadians(obj.meanAnomaly(d2));
            double d6 = Math.sin(radians);
            long l4 = 4616189618054758400L;
            return degrees *= l2;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i2) {
            return 0;
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i2) {
            return obj3 += l;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            double obj5 = h.access$100(d);
            double radians = Math.toRadians(solarLongitude(obj5));
            return a.c(Math.toDegrees(Math.atan2(obj5 *= d3, obj6)));
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(g g, double d2, double d3, double d4) {
            return this.event(true, g, d2, obj4, d4);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(g g, double d2, double d3, double d4) {
            return this.event(false, g, d2, obj4, d4);
        }
    }

    static enum c extends net.time4j.calendar.s.h {
        private double approxMomentOfDepression(double d, double d2, double d3, double d4, boolean z5) {
            double sineOffset;
            int i4;
            int i3;
            int i2;
            int cmp;
            int i;
            double d5;
            int i5;
            long l = (long)floor;
            final int i15 = d - z5;
            final long l6 = 4602678819172646912L;
            if (Double.compare(obj24, i16) >= 0) {
                i2 = obj26 != null ? l : i21 + l;
                i4 = (double)i2;
            } else {
                d9 += l6;
            }
            final long l7 = 4607182418800017408L;
            if (Double.compare(d11, l7) > 0) {
                sineOffset = this.sineOffset(i4 - z5, obj8, d3);
            }
            if (Double.compare(d7, l7) <= 0) {
                i3 = obj26 != null ? -1 : 1;
                i18 += l6;
                return i19 -= i7;
            }
            int i9 = this;
            return 9221120237041090560L;
        }

        private double declinationRad(double d) {
            return Math.asin(d2 *= obj5);
        }

        private b0 event(boolean z, g g2, double d3, double d4, double d5) {
            long l;
            l = z ? 4598175219545276416L : 4604930618986332160L;
            double d = (double)transform;
            int i4 = d + l;
            BigDecimal bigDecimal = new BigDecimal(d5, obj6);
            final int i9 = i6 / l3;
            double momentOfDepression = this.momentOfDepression(i4, d, d3, obj4, i9);
            if (Double.isNaN(momentOfDepression)) {
                return null;
            }
            return (b0)c.g(momentOfDepression -= i9).i().G(b0.C, TimeUnit.SECONDS);
        }

        private double excentricity(double d) {
            return obj5 -= i3;
        }

        private double meanAnomaly(double d) {
            return i5 += obj5;
        }

        private double meanLongitude(double d) {
            return i4 %= obj5;
        }

        private double momentOfDepression(double d, double d2, double d3, double d4, boolean z5) {
            final double approxMomentOfDepression = approxMomentOfDepression(d, d2, d3, d4, z5);
            if (Double.isNaN(approxMomentOfDepression)) {
                return 9221120237041090560L;
            }
            if (Double.compare(i2, l3) < 0) {
                return approxMomentOfDepression;
            }
            return this.momentOfDepression(approxMomentOfDepression, obj2, d3, obj4, z5);
        }

        private double nutation(double d) {
            return i5 -= obj7;
        }

        private double obliquity(double d) {
            return i7 += obj5;
        }

        private double sineOffset(double d, double d2, double d3) {
            double obj7 = Math.toRadians(d3);
            double obj5 = declinationRad(h.access$100(d));
            return i += obj9;
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return getFeature(d, obj3);
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            final Object obj = this;
            double d2 = h.access$100(d);
            final long l3 = 4611686018427387904L;
            double d4 = Math.tan(Math.toRadians(obliquity /= l3));
            d4 *= d4;
            double radians3 = Math.toRadians(meanLongitude *= l3);
            final double excentricity = obj.excentricity(d2);
            double radians = Math.toRadians(obj.meanAnomaly(d2));
            double d6 = Math.sin(radians);
            long l4 = 4616189618054758400L;
            return degrees *= l2;
        }

        @Override // net.time4j.calendar.s.h
        public double getFeature(double d, String string2) {
            double obj5 = h.access$100(d);
            if (obj7.equals("declination")) {
                return Math.toDegrees(declinationRad(obj5));
            }
            if (obj7.equals("right-ascension")) {
                double radians = Math.toRadians(h.access$200(obj5, string2));
                return a.c(Math.toDegrees(Math.atan2(obj5 *= d4, string2)));
            }
            if (obj7.equals("nutation")) {
                return nutation(obj5);
            }
            if (obj7.equals("obliquity")) {
                return obliquity(obj5);
            }
            if (obj7.equals("mean-anomaly")) {
                return meanAnomaly(obj5);
            }
            if (obj7.equals("solar-longitude")) {
                return h.access$200(obj5, string2);
            }
            if (obj7.equals("solar-latitude")) {
                return 0;
            }
            return 9221120237041090560L;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i2) {
            if (obj7 == null) {
                return 0;
            }
            long obj5 = 4708599893877325824L;
            double d2 = (double)obj7;
            return obj5 += i;
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i2) {
            return obj3 += l;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            return getFeature(d, obj3);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(g g, double d2, double d3, double d4) {
            return this.event(true, g, d2, obj4, d4);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(g g, double d2, double d3, double d4) {
            return this.event(false, g, d2, obj4, d4);
        }
    }

    static enum d extends net.time4j.calendar.s.h {
        private double declinationRad(double d) {
            double[] dArr = new double[2];
            h.nutations(d, obj7);
            return Math.asin(d2 *= obj6);
        }

        private b0 event(boolean z, g g2, double d3, double d4, double d5) {
            int i2;
            double localHourAngle;
            long l;
            boolean z2;
            int i;
            double d;
            Object obj3;
            final Object obj = g2;
            b0 b0Var = g.e(obj, 12, d5, obj4);
            i2 = 0;
            localHourAngle = this.localHourAngle(z, d2 + i8, obj10, d3);
            while (Double.isNaN(localHourAngle)) {
                i2 = localHourAngle;
                localHourAngle = this.localHourAngle(z, d2 + i8, obj10, d3);
            }
            return null;
        }

        private double excentricity(double d) {
            return obj5 -= i3;
        }

        private double localHourAngle(boolean z, double d2, double d3, double d4) {
            int obj6;
            double obj8 = Math.toRadians(d4);
            obj6 = declinationRad(h.access$100(d2));
            obj10 /= obj6;
            if (Double.compare(obj10, obj11) <= 0) {
                if (Double.compare(obj10, obj11) < 0) {
                } else {
                    if (z) {
                        obj6 = -obj6;
                    }
                }
                return obj6;
            }
            return 9221120237041090560L;
        }

        private double meanAnomaly(double d) {
            return i3 += obj5;
        }

        private double meanLongitude(double d) {
            return i4 %= obj5;
        }

        private double trueObliquity(double d) {
            return meanObliquity += obj5;
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return getFeature(d, obj3);
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            final Object obj = this;
            double d2 = h.access$100(d);
            final long l3 = 4611686018427387904L;
            double d4 = Math.tan(Math.toRadians(trueObliquity /= l3));
            d4 *= d4;
            double radians3 = Math.toRadians(meanLongitude *= l3);
            final double excentricity = obj.excentricity(d2);
            double radians = Math.toRadians(obj.meanAnomaly(d2));
            double d6 = Math.sin(radians);
            long l4 = 4616189618054758400L;
            return degrees *= l2;
        }

        @Override // net.time4j.calendar.s.h
        public double getFeature(double d, String string2) {
            double obj5 = h.access$100(d);
            if (obj7.equals("declination")) {
                return Math.toDegrees(declinationRad(obj5));
            }
            final int i = 1;
            int i2 = 0;
            final int i3 = 2;
            if (obj7.equals("right-ascension")) {
                double[] obj7 = new double[i3];
                h.nutations(obj5, string2);
                double radians = Math.toRadians(h.access$200(obj5, string2));
                return a.c(Math.toDegrees(Math.atan2(obj5 *= d3, string2)));
            }
            if (obj7.equals("nutation")) {
                obj7 = new double[i3];
                h.nutations(obj5, string2);
                return obj7[i2];
            }
            if (obj7.equals("obliquity")) {
                obj7 = new double[i3];
                h.nutations(obj5, string2);
                return obj5 += d5;
            }
            if (obj7.equals("mean-anomaly")) {
                return meanAnomaly(obj5);
            }
            if (obj7.equals("solar-longitude")) {
                obj7 = new double[i3];
                h.nutations(obj5, string2);
                return h.access$200(obj5, string2);
            }
            if (obj7.equals("solar-latitude")) {
                return 0;
            }
            return 9221120237041090560L;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i2) {
            if (obj7 == null) {
                return 0;
            }
            double obj5 = Math.toRadians(d);
            d2 *= l;
            obj5 *= l2;
            l3 /= obj5;
            return Math.toDegrees(Math.acos(i /= obj5));
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i2) {
            if (obj7 == null) {
                return 4636092244533007701L;
            }
            return obj5 += i4;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            return getFeature(d, obj3);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(g g, double d2, double d3, double d4) {
            return this.event(true, g, d2, obj4, d4);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(g g, double d2, double d3, double d4) {
            return this.event(false, g, d2, obj4, d4);
        }
    }
    private static double aberration(double d) {
        return obj2 -= l4;
    }

    static double access$100(double d) {
        return h.toJulianCenturies(d);
    }

    static double access$200(double d, double d2) {
        return h.apparentSolarLongitude(d, d2);
    }

    private static double apparentSolarLongitude(double d, double d2) {
        int i;
        int i3;
        int i4;
        double d4;
        double d3;
        int i2;
        length--;
        i3 = 0;
        while (i >= 0) {
            d6 += i2;
            i3 += i4;
            i--;
        }
        long obj10 = 4645040803167600640L;
        i12 /= obj10;
        return i14 *= obj10;
    }

    static double meanObliquity(double d) {
        return i7 += obj4;
    }

    static void nutations(double d, double[] d2Arr2) {
        int i8;
        int i7;
        int i4;
        int i2;
        double[] dArr;
        int i3;
        int i;
        int i5;
        int i6;
        final int i39 = 1;
        length -= i39;
        i4 = i7;
        int i44 = 0;
        while (i8 >= 0) {
            dArr = h.TABLE_22A[i8];
            i55 += i60;
            i7 += i61;
            i4 += i3;
            i8--;
            i44 = 0;
        }
        long l2 = 4547007122018943789L;
        long l7 = 4660134898793709568L;
        obj28[i44] = i40 /= l7;
        obj28[i39] = i42 /= l7;
    }

    private static double toJulianCenturies(double d) {
        return obj2 /= l2;
    }

    @Override // java.lang.Enum
    public double declination(double d) {
        AbstractMethodError obj1 = new AbstractMethodError();
        throw obj1;
    }

    @Override // java.lang.Enum
    public abstract double equationOfTime(double d);

    @Override // java.lang.Enum
    public double getFeature(double d, String string2) {
        if (obj4.equals("declination")) {
            return declination(d);
        }
        if (obj4.equals("right-ascension")) {
            return rightAscension(d);
        }
        return 9221120237041090560L;
    }

    @Override // java.lang.Enum
    public abstract double getGeodeticAngle(double d, int i2);

    @Override // java.lang.Enum
    public abstract double getZenithAngle(double d, int i2);

    @Override // java.lang.Enum
    public double rightAscension(double d) {
        AbstractMethodError obj1 = new AbstractMethodError();
        throw obj1;
    }

    @Override // java.lang.Enum
    public abstract b0 sunrise(g g, double d2, double d3, double d4);

    @Override // java.lang.Enum
    public abstract b0 sunset(g g, double d2, double d3, double d4);
}
