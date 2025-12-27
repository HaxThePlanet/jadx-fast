package net.time4j.calendar.s;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import net.time4j.b0;
import net.time4j.engine.g;
import net.time4j.engine.i0;
import net.time4j.engine.z;
import net.time4j.g0;
import net.time4j.i1.f;
import net.time4j.tz.k;

/* compiled from: SolarTime.java */
/* loaded from: classes3.dex */
public final class g implements Serializable {

    private static final g.b a;
    private static final ConcurrentMap<String, g.b> b = null;
    private static final long serialVersionUID = -4816619838743247977L;
    private final int altitude;
    private final String calculator;
    private final double latitude;
    private final double longitude;
    private final k observerZoneID;

    public static class a {

        private double a;
        private double b;
        private int c;
        private String d;
        private k e;
        /* synthetic */ a(f fVar) {
            this();
        }

        private static void c(int i, int i2, double d, int i3) {
            double d2 = 60d;
            if (i < 0) {
                double d6 = (double)i + (double)i2 / d2 + (d / 3600d);
                StringBuilder stringBuilder3 = new StringBuilder();
                String str5 = "Degrees out of range: ";
                String str = " (decimal=";
                String str2 = ")";
                i = str5 + i + str + d6 + str2;
                throw new IllegalArgumentException(i);
            } else {
                if (i <= i3) {
                    d = 0.0d;
                    if (i != i3 || i3 != 179 || i2 <= 0) {
                        if (i2 >= 0) {
                            int i5 = 60;
                            if (i2 < 60) {
                                if (Double.isNaN(d)) {
                                    throw new IllegalArgumentException("Arc seconds must be finite.");
                                } else {
                                    if (!Double.isInfinite(d)) {
                                        if (Double.compare(d, 0.0d) < 0) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            String str6 = "Arc seconds out of range: ";
                                            i2 = str6 + d;
                                            throw new IllegalArgumentException(i2);
                                        } else {
                                            if (Double.compare(d, d2) < 0) {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str4 = "Arc minutes out of range: ";
                    i2 = str4 + i2;
                    throw new IllegalArgumentException(i2);
                }
            }
        }

        public g.a a(int i) {
            d = (double)i;
            if (Double.isInfinite(d)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str2 = "Altitude must be finite: ";
                i = str2 + i;
                throw new IllegalArgumentException(i);
            } else {
                if (!Double.isNaN(d)) {
                    if (i < 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "Meters out of range 0 <= altitude < +11,000: ";
                        i = str + i;
                        throw new IllegalArgumentException(i);
                    } else {
                        if (i < 11000) {
                            this.c = i;
                            return this;
                        }
                    }
                }
            }
        }

        public g b() {
            if (Double.isNaN(this.a)) {
                throw new IllegalStateException("Latitude was not yet set.");
            } else {
                if (Double.isNaN(this.b)) {
                    throw new IllegalStateException("Longitude was not yet set.");
                } else {
                    g gVar = new g(this.a, d5, this.b, str3, this.c, this.d, this.e, 0);
                    return gVar;
                }
            }
        }

        public g.a d(int i, int i2, double d) {
            g.a.c(i, i2, d, 179);
            if (!Double.isNaN(this.b)) {
                throw new IllegalStateException("Longitude has already been set.");
            } else {
                this.b = (double)i + (double)i2 / 60d + (d / 3600d);
                return this;
            }
        }

        public g.a e(int i, int i2, double d) {
            g.a.c(i, i2, d, 90);
            if (!Double.isNaN(this.a)) {
                throw new IllegalStateException("Latitude has already been set.");
            } else {
                this.a = (double)i + (double)i2 / 60d + (d / 3600d);
                return this;
            }
        }

        public g.a f(g.b bVar) {
            g.b.putIfAbsent(bVar.name(), bVar);
            this.d = bVar.name();
            return this;
        }

        private a() {
            super();
            double d = Double.NaN;
            this.a = d;
            this.b = d;
            this.c = 0;
            this.d = g.a.name();
            this.e = null;
        }
    }

    public interface b {
        double equationOfTime(double d);

        String name();
    }
    static {
        int i = 0;
        int i2 = 0;
        Object obj2;
        i = 0;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        name = g.b.class;
        Iterator it = d.c().g(name).iterator();
        while (it.hasNext()) {
            Object item = it.next();
            concurrentHashMap.put(item.name(), item);
        }
        net.time4j.calendar.s.h[] values = h.values();
        i2 = 0;
        for (net.time4j.calendar.s.h hVar : values) {
            concurrentHashMap.put(hVar.name(), hVar);
        }
        g.b = concurrentHashMap;
        if (i == 0) {
            net.time4j.calendar.s.h nOAA2 = h.NOAA;
        }
        g.a = i;
        net.time4j.calendar.s.g.a aVar = g.f();
        aVar.d(35, 14, 5d);
        aVar.e(31, 46, 44d);
        aVar.a(721);
        net.time4j.calendar.s.h tIME4J2 = h.TIME4J;
        aVar.f(tIME4J2);
        aVar.b();
        net.time4j.calendar.s.g.a aVar2 = g.f();
        aVar2.d(39, 49, 34.06d);
        aVar2.e(21, 25, 21.22d);
        aVar2.a(298);
        aVar2.f(tIME4J2);
        aVar2.b();
    }

    /* synthetic */ g(double d, double d2, int i, String str, k kVar, f fVar) {
        this(d, r2, d2, r4, i, str, kVar);
    }

    static /* synthetic */ g.b a() {
        return g.a;
    }

    static /* synthetic */ ConcurrentMap b() {
        return g.b;
    }

    private static void c(double d, double d2, int i, String str) {
        if (Double.isNaN(d)) {
            StringBuilder stringBuilder6 = new StringBuilder();
            String str6 = "Latitude must be a finite value: ";
            d = str6 + d;
            throw new IllegalArgumentException(d);
        } else {
            if (!Double.isInfinite(d)) {
                if (Double.isNaN(d2)) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    String str9 = "Longitude must be a finite value: ";
                    r3 = str9 + d2;
                    throw new IllegalArgumentException(r3);
                } else {
                    if (!Double.isInfinite(d2)) {
                        if (Double.compare(d, 90d) > 0) {
                            StringBuilder stringBuilder7 = new StringBuilder();
                            String str7 = "Degrees out of range -90.0 <= latitude <= +90.0: ";
                            d = str7 + d;
                            throw new IllegalArgumentException(d);
                        } else {
                            if (Double.compare(d, -90d) >= 0) {
                                if (Double.compare(d2, 180d) >= 0) {
                                    StringBuilder stringBuilder4 = new StringBuilder();
                                    String str8 = "Degrees out of range -180.0 <= longitude < +180.0: ";
                                    r3 = str8 + d2;
                                    throw new IllegalArgumentException(r3);
                                } else {
                                    if (Double.compare(d2, -180d) >= 0) {
                                        d3 = (double)i;
                                        if (Double.isNaN(d3)) {
                                            StringBuilder stringBuilder3 = new StringBuilder();
                                            String str5 = "Altitude must be finite: ";
                                            r3 = str5 + i;
                                            throw new IllegalArgumentException(r3);
                                        } else {
                                            if (!Double.isInfinite(d3)) {
                                                if (i < 0) {
                                                    StringBuilder stringBuilder2 = new StringBuilder();
                                                    String str3 = "Meters out of range 0 <= altitude < +11,000: ";
                                                    r3 = str3 + i;
                                                    throw new IllegalArgumentException(r3);
                                                } else {
                                                    if (i < 11000) {
                                                        if (str.isEmpty()) {
                                                            throw new IllegalArgumentException("Missing calculator.");
                                                        } else {
                                                            if (!g.b.containsKey(str)) {
                                                                StringBuilder stringBuilder = new StringBuilder();
                                                                String str2 = "Unknown calculator: ";
                                                                r3 = str2 + str;
                                                                throw new IllegalArgumentException(r3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean d(k kVar, k kVar2) {
        boolean z = false;
        z = false;
        if (kVar == null && kVar2 == null) {
            int i = 1;
            return z;
        }
        if (kVar2 == null) {
            return false;
        }
        return kVar.a().equals(kVar2.a());
    }

    static b0 e(g gVar, int i, double d, String str) {
        f uT2;
        long l;
        final Object value = g.b.get(str);
        i *= 3600;
        double d7 = (double)(gVar.c() * 86400L) + (long)i4 - (d * 240d);
        double d32 = Math.floor(d7);
        l = (long)d32;
        d = 1000000000d;
        uT2 = f.UT;
        if (!d.w().A()) {
            l = (long)d32 + 63072000L;
            uT2 = f.POSIX;
        }
        b0 b0Var = b0.o0(l, (int)(d7 - d32) * d, uT2);
        f tT2 = f.TT;
        double equationOfTime2 = value.equationOfTime(c.e(b0Var, tT2));
        double floored = Math.floor(equationOfTime2);
        double d13 = (equationOfTime2 - floored) * d;
        TimeUnit sECONDS2 = TimeUnit.SECONDS;
        final long l8 = (long)d13;
        TimeUnit nANOSECONDS2 = TimeUnit.NANOSECONDS;
        double equationOfTime = value.equationOfTime(c.e((b0)(b0)b0Var.L((long)floored, sECONDS2).L(l8, nANOSECONDS2), tT2));
        double floored2 = Math.floor(equationOfTime);
        double d5 = (equationOfTime - floored2) * d;
        return (b0)(b0)b0Var.L((long)floored2, sECONDS2).L((long)d5, nANOSECONDS2);
    }

    public static g.a f() {
        return new g.a(null);
    }

    static g0 g(g gVar) {
        if (gVar instanceof g0) {
            return gVar;
        }
        return g0.P0(gVar.c(), z.UTC);
    }

    private void readObject(ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        g.c(this.latitude, this.longitude, this.altitude, this.calculator);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        String calculator2;
        double latitude2;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof g) {
            if (this.calculator.equals(object.calculator)) {
                if (Double.compare(this.latitude, object.latitude) == 0) {
                    if (Double.compare(this.longitude, object.longitude) == 0) {
                        if (this.altitude == object.altitude) {
                            if (!(g.d(this.observerZoneID, object.observerZoneID))) {
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.calculator.hashCode() + (a.a(this.latitude) * 7)) + (a.a(this.longitude) * 31) + (this.altitude * 37);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SolarTime[latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(",longitude=");
        stringBuilder.append(this.longitude);
        if (this.altitude != 0) {
            stringBuilder.append(",altitude=");
            stringBuilder.append(this.altitude);
        }
        if (!this.calculator.equals(g.a.name())) {
            stringBuilder.append(",calculator=");
            stringBuilder.append(this.calculator);
        }
        if (this.observerZoneID != null) {
            stringBuilder.append(",observerZoneID=");
            stringBuilder.append(this.observerZoneID.a());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private g(double d, double d2, int i, String str, k kVar) {
        super();
        this.latitude = d;
        this.longitude = d2;
        this.altitude = i;
        this.calculator = str;
        this.observerZoneID = kVar;
    }
}
