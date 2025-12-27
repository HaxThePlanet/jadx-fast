package net.time4j.calendar.s;

import android.app.ActivityManager.MemoryInfo;
import i.b.m0.e.b.e0.c;
import i.b.m0.e.c.w.b;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.e.l;
import kotlinx.coroutines.y1.a;
import net.time4j.b0;
import net.time4j.engine.q;
import net.time4j.engine.z;
import net.time4j.g0;
import net.time4j.h0;
import net.time4j.i1.f;
import net.time4j.tz.p;
import okhttp3.internal.concurrent.TaskQueue.execute.AnonymousClass1;
import zendesk.support.GuideModule;
import zendesk.support.request.ComponentPersistence;
import zendesk.support.request.ComponentRequestAdapter.RequestViewHolder;
import zendesk.support.request.ComponentRequestRouter;
import zendesk.support.request.ComponentRequestRouter.RequestScreen;
import zendesk.support.request.ComponentToolbar.ToolbarModel;
import zendesk.support.request.RequestConfiguration.Builder;

/* compiled from: StdSolarCalculator.java */
/* loaded from: classes3.dex */
public enum h implements g.b {

    NOAA {
        private double declinationRad(double d) {
            return Math.asin(Math.sin(Math.toRadians(obliquity(d))) * Math.sin(Math.toRadians(solarLongitude(d))));
        }

        private double equationOfCenter(double d) {
            double radians = Math.toRadians(meanAnomaly(d));
            return (Math.sin(radians) * (1.914602d - (0.000014d * d) + 0.004817d * d)) + (Math.sin(2d * radians)) * (0.019993d - (d * 0.000101d)) + (Math.sin(radians * 3d)) * 0.000289d;
        }

        private b0 event(boolean z, net.time4j.engine.g gVar, double d, double d2, double d3) {
            b0 b0Var = g.e(gVar, 12, d2, name());
            d = c.e(b0Var, f.TT);
            double z3 = this;
            double localHourAngle = z3.localHourAngle(z, d, d, d3);
            Object obj = null;
            if (Double.isNaN(localHourAngle)) {
                return obj;
            }
            double localHourAngle2 = this.localHourAngle(z, d + (localHourAngle / 86400d), d, d3);
            if (Double.isNaN(localHourAngle2)) {
                return obj;
            }
            double floored = Math.floor(localHourAngle2);
            double d7 = (localHourAngle2 - floored) * 1000000000d;
            TimeUnit sECONDS2 = TimeUnit.SECONDS;
            return (b0)(b0)(b0)b0Var.M((long)floored, sECONDS2).M((long)d7, TimeUnit.NANOSECONDS).G(b0.C, sECONDS2);
        }

        private double excentricity(double d) {
            return 0.016708634d - (0.0000001267d * d) + 0.000042037d * d;
        }

        private double localHourAngle(double d, double d2, double d3) {
            double radians = Math.toRadians(d2);
            double declinationRad = declinationRad(d);
            double d8 = (Math.cos(Math.toRadians(d3)) - (Math.sin(declinationRad) * Math.sin(radians))) / (Math.cos(declinationRad) * Math.cos(radians));
            if (Double.compare(d8, 1d) <= 0) {
                return Math.toDegrees(Math.acos(d8)) * 240d;
            }
            return 9221120237041090560L;
        }

        private double localHourAngle(boolean z, double d, double d2, double d3) {
            double localHourAngle;
            localHourAngle = this.localHourAngle(d.toJulianCenturies(r10), d2, d3);
            if (Double.isNaN(localHourAngle)) {
                return 9221120237041090560L;
            }
            if (z) {
                int i = -localHourAngle;
            }
            return localHourAngle;
        }

        private double meanAnomaly(double d) {
            return (35999.05029d - (0.0001537d * d)) * d + 357.52911d;
        }

        private double meanLongitude(double d) {
            return (0.0003032d * d) + 36000.76983d * d + 280.46646d % 360d;
        }

        private double obliquity(double d) {
            return (0.001813d * d) - 4664791024081460034L * d - 4591586594027921736L * d + 21.448d / 3600d + 23.433333333333334d + (Math.cos(Math.toRadians(125.04d - (d * 1934.136d)))) * 0.00256d;
        }

        private double solarLongitude(double d) {
            return (meanLongitude(d) + equationOfCenter(d)) - 0.00569d - (Math.sin(Math.toRadians(125.04d - (d * 1934.136d)))) * 0.00478d;
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return Math.toDegrees(declinationRad(d.toJulianCenturies(r2)));
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            final Object d2 = this;
            double d3 = d.toJulianCenturies(r21);
            final double d17 = 2d;
            double tan = Math.tan(Math.toRadians(d2.obliquity(d3) / d17));
            tan *= tan;
            double radians3 = Math.toRadians(d2.meanLongitude(d3) * d17);
            final double excentricity = d2.excentricity(d3);
            double radians = Math.toRadians(d2.meanAnomaly(d3));
            double sin3 = Math.sin(radians);
            double d29 = 4d;
            return (Math.toDegrees((Math.sin(radians3) * d8) - (excentricity * d17) * sin3 + (excentricity * d29) * d8 * sin3 * Math.cos(radians3) - (d8 * d8) * (Math.sin(radians3 * d17)) / d17 - (5d * excentricity) * excentricity * (Math.sin(radians * d17)) / d29)) * 240d;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i) {
            return 0;
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i) {
            return (getGeodeticAngle(d, i)) + 90.83333333333333d;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            double d3 = d.toJulianCenturies(r6);
            double radians = Math.toRadians(solarLongitude(d3));
            return a.c(Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(obliquity(d3))) * Math.sin(radians), Math.cos(radians))));
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(true, gVar, d, d2, d3);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(false, gVar, d, d2, d3);
        }
    },
    CC {
        private double approxMomentOfDepression(double d, double d2, double d3, double d4, boolean z) {
            double sineOffset;
            double d5;
            int i = 1;
            long l;
            double floored = Math.floor(d);
            l = (long)floored;
            final double d13 = d - d3;
            final double d21 = 0.5d;
            if (d4 >= 0) {
                l = z ? l : 1 + l;
                d5 = (double)l;
            } else {
                d5 = floored + d21;
            }
            double abs2 = Math.abs(this.sineOffset(d13, d2, d4));
            final double d22 = 1d;
            if (abs2 > d22) {
                d6 = d5 - d3;
                sineOffset = this.sineOffset(d6, d2, d4);
            }
            double abs = Math.abs(sineOffset);
            if (abs <= d22 && z) {
                i = -1;
                double d18 = (double)i * (Math.toDegrees(Math.asin(sineOffset)) / 360d) + d21 % d22 - 0.25d + floored + d21;
                return d18 - (this.equationOfTime(d18 - d3)) / 86400d;
            }
            return 9221120237041090560L;
        }

        private double declinationRad(double d) {
            return Math.asin(Math.sin(Math.toRadians(obliquity(d))) * (Math.sin(Math.toRadians(d.apparentSolarLongitude(r6, nutation(d), obj)))));
        }

        private b0 event(boolean z, net.time4j.engine.g gVar, double d, double d2, double d3) {
            long l = 4598175219545276416L;
            int r0 = z ? 4598175219545276416L : 4604930618986332160L;
            double d6 = (double)(z.JULIAN_DAY_NUMBER.transform(gVar.c(), zVar, z.UTC));
            d2 = d6 + (z ? 4598175219545276416L : 4604930618986332160L);
            final double d11 = (double)(z ? 4598175219545276416L : 4604930618986332160L) - (f.deltaT((z ? 4598175219545276416L : 4604930618986332160L))) - 43200d / 86400d;
            r0 = (z ? 4598175219545276416L : 4604930618986332160L).momentOfDepression(d2, d, d11, d3 - 90d, z);
            if (Double.isNaN(r0)) {
                return null;
            }
            return (b0)c.g((z ? 4598175219545276416L : 4604930618986332160L) - d11).i().G(b0.C, TimeUnit.SECONDS);
        }

        private double excentricity(double d) {
            return 0.016708617d - (0.0000001236d * d) + 0.000042037d * d;
        }

        private double meanAnomaly(double d) {
            return (0.00000048d * d) - 4673488318035762706L * d + 35999.0503d * d + 357.5291d;
        }

        private double meanLongitude(double d) {
            return (0.0003032d * d) + 36000.76983d * d + 280.46645d % 360d;
        }

        private double momentOfDepression(double d, double d2, double d3, double d4, boolean z) {
            final double approxMomentOfDepression = approxMomentOfDepression(d, d2, d3, d4, z);
            if (Double.isNaN(approxMomentOfDepression)) {
                return 9221120237041090560L;
            }
            double d8 = (Math.abs(d - approxMomentOfDepression)) * 86400d;
            if (d8 < 4629137466983448576L) {
                return approxMomentOfDepression;
            }
            return this.momentOfDepression(approxMomentOfDepression, d2, d3, d4, z);
        }

        private double nutation(double d) {
            return (Math.sin(Math.toRadians((0.002063d * d) - 4567150810117716312L * d + 124.9d))) * (-0.004778d) - (Math.sin(Math.toRadians((0.00057d * d) + 72001.5377d * d + 201.11d))) * 0.0003667d;
        }

        private double obliquity(double d) {
            return (0.001813d * d) - 4664791024081460034L * d - 4591586594027921736L * d + 21.448d / 3600d + 23.433333333333334d;
        }

        private double sineOffset(double d, double d2, double d3) {
            double radians = Math.toRadians(d2);
            double declinationRad = declinationRad(d.toJulianCenturies(r6));
            return (Math.tan(radians) * Math.tan(declinationRad)) + (Math.sin(Math.toRadians(d3)) / (Math.cos(declinationRad) * Math.cos(radians)));
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return getFeature(d, "declination");
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            final Object d2 = this;
            double d3 = d.toJulianCenturies(r21);
            final double d17 = 2d;
            double tan = Math.tan(Math.toRadians(d2.obliquity(d3) / d17));
            tan *= tan;
            double radians3 = Math.toRadians(d2.meanLongitude(d3) * d17);
            final double excentricity = d2.excentricity(d3);
            double radians = Math.toRadians(d2.meanAnomaly(d3));
            double sin3 = Math.sin(radians);
            double d29 = 4d;
            return (Math.toDegrees((Math.sin(radians3) * d8) - (excentricity * d17) * sin3 + (excentricity * d29) * d8 * sin3 * Math.cos(radians3) - (d8 * d8) * (Math.sin(radians3 * d17)) / d17 - (5d * excentricity) * excentricity * (Math.sin(radians * d17)) / d29)) * 240d;
        }

        @Override // net.time4j.calendar.s.h
        public double getFeature(double d, String str) {
            double d4 = d.toJulianCenturies(r6);
            if (str.equals("declination")) {
                return Math.toDegrees(declinationRad(d4));
            }
            if (str.equals("right-ascension")) {
                double radians = Math.toRadians(d4.apparentSolarLongitude(r6, nutation(d4), d3));
                return a.c(Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(obliquity(d4))) * Math.sin(radians), Math.cos(radians))));
            }
            if (str.equals("nutation")) {
                return nutation(d4);
            }
            if (str.equals("obliquity")) {
                return obliquity(d4);
            }
            if (str.equals("mean-anomaly")) {
                return meanAnomaly(d4);
            }
            if (str.equals("solar-longitude")) {
                return d4.apparentSolarLongitude(r6, nutation(d4), d3);
            }
            if (str.equals("solar-latitude")) {
                return 0;
            }
            return 9221120237041090560L;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i) {
            if (i == 0) {
                return 0;
            }
            double d6 = 6372000d;
            double d2 = (double)i;
            return (Math.toDegrees(Math.acos(d6 / (d2 + d6)))) + (Math.sqrt(d2) * 0.005277777777777778d);
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i) {
            return (getGeodeticAngle(d, i)) + 90.83333333333333d;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            return getFeature(d, "right-ascension");
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(true, gVar, d, d2, d3);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(false, gVar, d, d2, d3);
        }
    };

    enum a extends h {
        private b0 event(net.time4j.engine.g gVar, double d, double d2, double d3, boolean z) {
            f uT2;
            int i = 6;
            long l;
            double degrees;
            g0 g0Var = g.g(gVar);
            double d5 = 15d;
            double d9 = d2 / d5;
            int r1 = z ? 6 : 18;
            final double d25 = 24d;
            double d11 = (double)g0Var.D0() + (double)(z ? 6 : 18) - d9 / d25;
            double trueLongitudeOfSunInDegrees = (z ? 6 : 18).trueLongitudeOfSunInDegrees(d11);
            double d27 = a.c(Math.toDegrees(Math.atan(Math.tan(Math.toRadians(trueLongitudeOfSunInDegrees)) * 0.91764d)));
            double d32 = 90d;
            double d16 = Math.sin(Math.toRadians(trueLongitudeOfSunInDegrees)) * 0.39782d;
            double radians3 = Math.toRadians(d);
            double d18 = (Math.cos(Math.toRadians(d3)) - (d16 * Math.sin(radians3))) / (Math.cos(Math.asin(d16)) * Math.cos(radians3));
            if (Double.compare(d18, 1d) <= 0) {
                if (Double.compare(d18, -1d) >= 0) {
                    if (z) {
                        degrees = 360d - Math.toDegrees(Math.acos(d18));
                    }
                    d = (degrees / d5) + (d27 + (Math.floor(trueLongitudeOfSunInDegrees / d32)) * d32 - (Math.floor(d27 / d32)) * d32) / d5 - (d11 * 0.06571d) - 6.622d;
                    if (Double.compare(0.0d, d) > 0) {
                        d = d + d25;
                    } else {
                        if (Double.compare(d25, d) <= 0) {
                            d = d - d25;
                        }
                    }
                    double floored = Math.floor((d - d9) * 3600d);
                    l2 = (long)floored;
                    l = (Long)g0Var.p(z.UTC).longValue() * 86400L + l2;
                    uT2 = f.UT;
                    if (!d.w().A()) {
                        long l2 = 63072000L;
                        l = (g0Var.p(z.UTC).longValue() * 86400 + (long)floored) + l2;
                        uT2 = f.POSIX;
                    }
                }
                return (b0)b0.p0((Math.round((double)l / 60d)) * 60L, uT2).G(b0.C, TimeUnit.MINUTES);
            }
            return null;
        }

        private double time0(double d) {
            net.time4j.i0 i0Var = c.g(d).i().w0(p.C);
            return (double)i0Var.X().D0() + (double)(Integer)i0Var.Z().p(h0.R).intValue() / 86400d;
        }

        private double trueLongitudeOfSunInDegrees(double d) {
            double d8 = (d * 0.9856d) - 3.289d;
            return a.c((Math.sin(Math.toRadians(d8)) * 1.916d) + d8 + (Math.sin(Math.toRadians(d8) * 2d)) * 0.02d + 282.634d);
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return Math.toDegrees(Math.asin(Math.sin(Math.toRadians(trueLongitudeOfSunInDegrees(time0(d)))) * 0.39782d));
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            double time0 = time0(d);
            return (Math.sin(Math.toRadians((0.9856d * time0) - 3.8d))) * (-7.66d) - (Math.sin(Math.toRadians((time0 * 1.9712d) + 17.96d))) * 9.78d * 60d;
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i) {
            return (getGeodeticAngle(d, i)) + 90.83333333333333d;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            double trueLongitudeOfSunInDegrees = trueLongitudeOfSunInDegrees(time0(d));
            double d3 = a.c(Math.toDegrees(Math.atan(Math.tan(Math.toRadians(trueLongitudeOfSunInDegrees)) * 0.91764d)));
            double d7 = 90d;
            return (d3 + (Math.floor(trueLongitudeOfSunInDegrees / d7)) * d7) - (Math.floor(d3 / d7)) * d7;
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(gVar, d, d2, d3, true);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(gVar, d, d2, d3, false);
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i) {
            return 0;
        }
    }

    enum d extends h {
        private double declinationRad(double d) {
            double[] dArr = new double[2];
            h.nutations(d, dArr);
            return Math.asin((Math.sin(Math.toRadians(h.meanObliquity(d) + dArr[1]))) * (Math.sin(Math.toRadians(d.apparentSolarLongitude(r7, dArr[0], obj)))));
        }

        private b0 event(boolean z, net.time4j.engine.g gVar, double d, double d2, double d3) {
            int i = 0;
            final Object gVar22 = gVar;
            b0 b0Var = g.e(gVar22, 12, d2, name());
            i = 0;
            d2 = (c.e(b0Var, f.TT)) + (i / 86400d);
            double localHourAngle = this.localHourAngle(z, d2, d, d3);
            while (Double.isNaN(localHourAngle)) {
                double abs = Math.abs(localHourAngle - i);
                d = 15d;
                if (abs < d) {
                    double floored = Math.floor(localHourAngle);
                    double d11 = (localHourAngle - floored) * 1000000000d;
                    final TimeUnit sECONDS2 = TimeUnit.SECONDS;
                    return (b0)(b0)(b0)b0Var.M((long)floored, sECONDS2).M((long)d11, TimeUnit.NANOSECONDS).G(b0.C, sECONDS2);
                }
            }
            return null;
        }

        private double localHourAngle(boolean z, double d, double d2, double d3) {
            double radians = Math.toRadians(d2);
            double declinationRad = declinationRad(d.toJulianCenturies(r7));
            double d9 = (Math.cos(Math.toRadians(d3)) - (Math.sin(declinationRad) * Math.sin(radians))) / (Math.cos(declinationRad) * Math.cos(radians));
            if (Double.compare(d9, 1d) <= 0) {
                if (Double.compare(d9, -1d) >= 0) {
                    d = Math.toDegrees(Math.acos(d9)) * 240d;
                    if (z) {
                        int i = -(Math.toDegrees(Math.acos(d9, r11), r7) * 4642648265865560064L);
                    }
                }
                return d;
            }
            return 9221120237041090560L;
        }

        private double trueObliquity(double d) {
            return h.meanObliquity(d) + (Math.cos(Math.toRadians(125.04d - (d * 1934.136d)))) * 0.00256d;
        }

        @Override // net.time4j.calendar.s.h
        public double declination(double d) {
            return getFeature(d, "declination");
        }

        @Override // net.time4j.calendar.s.h
        public double equationOfTime(double d) {
            final Object d2 = this;
            double d3 = d.toJulianCenturies(r21);
            final double d17 = 2d;
            double tan = Math.tan(Math.toRadians(d2.trueObliquity(d3) / d17));
            tan *= tan;
            double radians3 = Math.toRadians(d2.meanLongitude(d3) * d17);
            final double excentricity = d2.excentricity(d3);
            double radians = Math.toRadians(d2.meanAnomaly(d3));
            double sin3 = Math.sin(radians);
            double d29 = 4d;
            return (Math.toDegrees((Math.sin(radians3) * d8) - (excentricity * d17) * sin3 + (excentricity * d29) * d8 * sin3 * Math.cos(radians3) - (d8 * d8) * (Math.sin(radians3 * d17)) / d17 - (5d * excentricity) * excentricity * (Math.sin(radians * d17)) / d29)) * 240d;
        }

        @Override // net.time4j.calendar.s.h
        public double getFeature(double d, String str) {
            double d7 = d.toJulianCenturies(r6);
            if (str.equals("declination")) {
                return Math.toDegrees(declinationRad(d7));
            }
            final int i = 1;
            int i2 = 0;
            final int i3 = 2;
            if (str.equals("right-ascension")) {
                double[] dArr = new double[i3];
                h.nutations(d7, dArr);
                double radians = Math.toRadians(d7.apparentSolarLongitude(r6, dArr[i2], i3));
                return a.c(Math.toDegrees(Math.atan2((Math.cos(Math.toRadians(h.meanObliquity(d7) + dArr[i]))) * Math.sin(radians), Math.cos(radians))));
            }
            if (str.equals("nutation")) {
                double[] dArr4 = new double[i3];
                h.nutations(d7, dArr4);
                return dArr4[i2];
            }
            if (str.equals("obliquity")) {
                double[] dArr2 = new double[i3];
                h.nutations(d7, dArr2);
                return h.meanObliquity(d7) + dArr2[i];
            }
            if (str.equals("mean-anomaly")) {
                return meanAnomaly(d7);
            }
            if (str.equals("solar-longitude")) {
                double[] dArr3 = new double[i3];
                h.nutations(d7, dArr3);
                return d7.apparentSolarLongitude(r6, dArr3[i2], i);
            }
            if (str.equals("solar-latitude")) {
                return 0;
            }
            return 9221120237041090560L;
        }

        @Override // net.time4j.calendar.s.h
        public double getGeodeticAngle(double d, int i) {
            if (i == 0) {
                return 0;
            }
            double radians = Math.toRadians(d);
            double d5 = Math.cos(radians) * 6378137d;
            double d9 = Math.sin(radians) * 6356752.3d;
            double d2 = 40680631590769d / (Math.sqrt((d5 * d5) + (d9 * d9)));
            return Math.toDegrees(Math.acos(d2 / (double)i + d2));
        }

        @Override // net.time4j.calendar.s.h
        public double getZenithAngle(double d, int i) {
            if (i == 0) {
                return 4636092244533007701L;
            }
            return (getGeodeticAngle(d, i)) + 90d + (a.b(i) * 34d) + 16d / 60d;
        }

        @Override // net.time4j.calendar.s.h
        public double rightAscension(double d) {
            return getFeature(d, "right-ascension");
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunrise(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(true, gVar, d, d2, d3);
        }

        @Override // net.time4j.calendar.s.h
        public b0 sunset(net.time4j.engine.g gVar, double d, double d2, double d3) {
            return this.event(false, gVar, d, d2, d3);
        }

        private double excentricity(double d) {
            return 0.016708634d - (0.0000001267d * d) + 0.000042037d * d;
        }

        private double meanAnomaly(double d) {
            return (35999.05029d - (0.0001537d * d)) * d + 357.52911d;
        }

        private double meanLongitude(double d) {
            return (0.0003032d * d) + 36000.76983d * d + 280.46646d % 360d;
        }
    }
    private static double aberration(double d) {
        return (Math.cos(Math.toRadians((d * 35999.01848d) + 177.63d))) * 0.0000974d - 0.005575d;
    }

    static /* synthetic */ double access$100(double d) {
        return h.toJulianCenturies(d);
    }

    static /* synthetic */ double access$200(double d, double d2) {
        return h.apparentSolarLongitude(d, d2);
    }

    private static double apparentSolarLongitude(double d, double d2) {
        int i;
        int i2 = 0;
        double d4;
        i = h.DG_X.length - 1;
        i2 = 0;
        while (i >= 0) {
            d5 = h.DG_Z[i] * d;
            d4 = h.DG_Y[i] + d5;
            d3 = (double)h.DG_X[i] * Math.sin(Math.toRadians(d4));
            i2 = i2 + d3;
            i = i - 1;
        }
        double d20 = 360d;
        double d14 = (36000.76953744d * d) + 282.7771834d + (i2 * 5.729577951308232d) / 1000000d + h.aberration(d) + d2 / d20;
        return (d14 - Math.floor(d14)) * d20;
    }

    static void nutations(double d, double[] dArr) {
        int i;
        int i2 = 0;
        final int i3 = 1;
        i = h.TABLE_22A.length - i3;
        i2 = 0;
        int i4 = 0;
        while (i >= 0) {
            dArr = h.TABLE_22A[i];
            double d54 = (dArr[i4] * (Math.toRadians((0.000005277768981496142d * d) - 4656901524579360150L * d + 445267.11148d * d + 297.85036d))) + (dArr[i3] * (Math.toRadians((-0.0000033333333333333333d * d) - 4673325986687914062L * d + 35999.05034d * d + 357.52772d))) + (dArr[2] * (Math.toRadians((0.00017777777777777779d * d) + 0.0086972d * d + 477198.867398d * d + 134.96298d))) + (dArr[3] * (Math.toRadians((0.0000030555810187307116d * d) - 4652734347447033932L * d + 483202.017538d * d + 93.27191d))) + (dArr[4] * (Math.toRadians((0.000002222222222222222d * d) + 0.0020708d * d - 4567150800173733150L * d + 125.04452d)));
            d6 = dArr[6] * d;
            d5 = dArr[5] + d6;
            i2 = i2 + (Math.sin(d54) * d5);
            d2 = dArr[8] * d;
            d4 = dArr[7] + d2;
            d3 = Math.cos(d54) * d4;
            i2 = i2 + d3;
            i = i - 1;
            i4 = 0;
        }
        double d13 = 0.0001d;
        double d21 = 3600d;
        dArr[i4] = (i2 * d13) / d21;
        dArr[i3] = (i2 * d13) / d21;
    }

    @Override // java.lang.Enum
    public double declination(double d) throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }

    @Override // java.lang.Enum
    public double getFeature(double d, String str) {
        if (str.equals("declination")) {
            return declination(d);
        }
        if (str.equals("right-ascension")) {
            return rightAscension(d);
        }
        return 9221120237041090560L;
    }

    @Override // java.lang.Enum
    public double rightAscension(double d) throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }

    static double meanObliquity(double d) {
        return (0.001813d * d) - 4664791024081460034L * d - 4591586594027921736L * d + 21.448d / 3600d + 23.433333333333334d;
    }

    private static double toJulianCenturies(double d) {
        return (d - 2451545d) / 36525d;
    }

    @Override // java.lang.Enum
    public abstract /* synthetic */ double equationOfTime(double d);

    @Override // java.lang.Enum
    public abstract /* synthetic */ double getGeodeticAngle(double d, int i);

    @Override // java.lang.Enum
    public abstract /* synthetic */ double getZenithAngle(double d, int i);

    @Override // java.lang.Enum
    public abstract /* synthetic */ b0 sunrise(net.time4j.engine.g gVar, double d, double d2, double d3);

    @Override // java.lang.Enum
    public abstract /* synthetic */ b0 sunset(net.time4j.engine.g gVar, double d, double d2, double d3);
}
