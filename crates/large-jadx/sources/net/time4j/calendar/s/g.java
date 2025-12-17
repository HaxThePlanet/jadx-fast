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
import net.time4j.f1.d;
import net.time4j.g0;
import net.time4j.i1.d;
import net.time4j.i1.f;
import net.time4j.tz.k;

/* loaded from: classes3.dex */
public final class g implements Serializable {

    private static final net.time4j.calendar.s.g.b a = null;
    private static final ConcurrentMap<String, net.time4j.calendar.s.g.b> b = null;
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
        private a() {
            super();
            long l = 9221120237041090560L;
            this.a = l;
            this.b = l;
            this.c = 0;
            this.d = g.a().name();
            this.e = 0;
        }

        a(net.time4j.calendar.s.f f) {
            super();
        }

        private static void c(int i, int i2, double d3, int i4) {
            int i3;
            int i5;
            int obj6;
            int obj10;
            long l = 4633641066610819072L;
            if (i < 0) {
            } else {
                if (i > obj10) {
                } else {
                    i3 = 0;
                    if (i == obj10 && obj10 != 179) {
                        if (obj10 != 179) {
                            if (i2 > 0) {
                            } else {
                                if (Double.compare(d3, i4) > 0) {
                                } else {
                                    if (i2 < 0) {
                                    } else {
                                        if (i2 >= 60) {
                                        } else {
                                            if (Double.isNaN(d3)) {
                                            } else {
                                                if (Double.isInfinite(d3)) {
                                                } else {
                                                    if (Double.compare(d3, i4) < 0) {
                                                    } else {
                                                        if (Double.compare(d3, i4) >= 0) {
                                                        } else {
                                                        }
                                                    }
                                                    StringBuilder obj7 = new StringBuilder();
                                                    obj7.append("Arc seconds out of range: ");
                                                    obj7.append(d3);
                                                    obj6 = new IllegalArgumentException(obj7.toString());
                                                    throw obj6;
                                                }
                                            }
                                            obj6 = new IllegalArgumentException("Arc seconds must be finite.");
                                            throw obj6;
                                        }
                                    }
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    StringBuilder obj8 = new StringBuilder();
                    obj8.append("Arc minutes out of range: ");
                    obj8.append(i2);
                    obj6 = new IllegalArgumentException(obj8.toString());
                    throw obj6;
                }
            }
            obj8 = new StringBuilder();
            obj8.append("Degrees out of range: ");
            obj8.append(i);
            obj8.append(" (decimal=");
            obj8.append(i6 += obj8);
            obj8.append(")");
            obj7 = new IllegalArgumentException(obj8.toString());
            throw obj7;
        }

        public net.time4j.calendar.s.g.a a(int i) {
            boolean naN;
            naN = (double)i;
            if (Double.isInfinite(naN)) {
            } else {
                if (Double.isNaN(naN)) {
                } else {
                    if (i < 0) {
                    } else {
                        if (i >= 11000) {
                        } else {
                            this.c = i;
                            return this;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Meters out of range 0 <= altitude < +11,000: ");
                    stringBuilder.append(i);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Altitude must be finite: ");
            stringBuilder2.append(i);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException2;
        }

        public net.time4j.calendar.s.g b() {
            if (Double.isNaN(this.a)) {
            } else {
                if (Double.isNaN(this.b)) {
                } else {
                    super(this.a, obj3, this.b, obj5, this.c, this.d, this.e, 0);
                    return gVar;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Longitude was not yet set.");
                throw illegalStateException;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("Latitude was not yet set.");
            throw illegalStateException2;
        }

        public net.time4j.calendar.s.g.a d(int i, int i2, double d3) {
            g.a.c(i, i2, d3, obj8);
            if (!Double.isNaN(this.b)) {
            } else {
                this.b = i4 += obj7;
                return this;
            }
            IllegalStateException obj5 = new IllegalStateException("Longitude has already been set.");
            throw obj5;
        }

        public net.time4j.calendar.s.g.a e(int i, int i2, double d3) {
            g.a.c(i, i2, d3, obj8);
            if (!Double.isNaN(this.a)) {
            } else {
                this.a = i4 += obj7;
                return this;
            }
            IllegalStateException obj5 = new IllegalStateException("Latitude has already been set.");
            throw obj5;
        }

        public net.time4j.calendar.s.g.a f(net.time4j.calendar.s.g.b g$b) {
            g.b().putIfAbsent(b.name(), b);
            this.d = b.name();
            return this;
        }
    }

    public interface b {
        public abstract double equationOfTime(double d);

        public abstract String name();
    }
    static {
        int nOAA;
        Class<net.time4j.calendar.s.g.b> name;
        int i;
        net.time4j.calendar.s.h hVar;
        String name2;
        Class<net.time4j.calendar.s.g> obj = g.class;
        nOAA = 0;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator iterator = d.c().g(g.b.class).iterator();
        for (g.b nOAA : iterator) {
            concurrentHashMap.put(nOAA.name(), nOAA);
        }
        net.time4j.calendar.s.h[] values = h.values();
        i = 0;
        while (i < values.length) {
            hVar = values[i];
            concurrentHashMap.put(hVar.name(), hVar);
            i++;
        }
        g.b = concurrentHashMap;
        if (nOAA == 0) {
            nOAA = h.NOAA;
        }
        g.a = nOAA;
        net.time4j.calendar.s.g.a aVar = g.f();
        aVar.d(35, 14, 4617315517961601024L);
        aVar.e(31, 46, 4631389266797133824L);
        aVar.a(721);
        net.time4j.calendar.s.h tIME4J = h.TIME4J;
        aVar.f(tIME4J);
        aVar.b();
        net.time4j.calendar.s.g.a aVar2 = g.f();
        aVar2.d(39, 49, 4629990336162881864L);
        aVar2.e(21, 25, 4626666116687929016L);
        aVar2.a(298);
        aVar2.f(tIME4J);
        aVar2.b();
    }

    private g(double d, double d2, int i3, String string4, k k5) {
        super();
        this.latitude = d;
        this.longitude = i3;
        this.altitude = k5;
        this.calculator = obj6;
        this.observerZoneID = obj7;
    }

    g(double d, double d2, int i3, String string4, k k5, net.time4j.calendar.s.f f6) {
        super(d, d2, i3, string4, k5, f6, obj7);
    }

    static net.time4j.calendar.s.g.b a() {
        return g.a;
    }

    static ConcurrentMap b() {
        return g.b;
    }

    private static void c(double d, double d2, int i3, String string4) {
        boolean naN2;
        int compare;
        boolean naN;
        boolean obj2;
        if (Double.isNaN(d)) {
        } else {
            if (Double.isInfinite(d)) {
            } else {
                if (Double.isNaN(i3)) {
                } else {
                    if (Double.isInfinite(i3)) {
                    } else {
                        if (Double.compare(d, d2) > 0) {
                        } else {
                            if (Double.compare(d, d2) < 0) {
                            } else {
                                if (Double.compare(i3, string4) >= 0) {
                                } else {
                                    if (Double.compare(i3, string4) < 0) {
                                    } else {
                                        obj2 = (double)obj6;
                                        if (Double.isNaN(obj2)) {
                                        } else {
                                            if (Double.isInfinite(obj2)) {
                                            } else {
                                                if (obj6 < 0) {
                                                } else {
                                                    if (obj6 >= 11000) {
                                                    } else {
                                                        if (obj7.isEmpty()) {
                                                        } else {
                                                            if (!g.b.containsKey(obj7)) {
                                                            } else {
                                                            }
                                                            StringBuilder obj3 = new StringBuilder();
                                                            obj3.append("Unknown calculator: ");
                                                            obj3.append(obj7);
                                                            obj2 = new IllegalArgumentException(obj3.toString());
                                                            throw obj2;
                                                        }
                                                        obj2 = new IllegalArgumentException("Missing calculator.");
                                                        throw obj2;
                                                    }
                                                }
                                                obj3 = new StringBuilder();
                                                obj3.append("Meters out of range 0 <= altitude < +11,000: ");
                                                obj3.append(obj6);
                                                obj2 = new IllegalArgumentException(obj3.toString());
                                                throw obj2;
                                            }
                                        }
                                        obj3 = new StringBuilder();
                                        obj3.append("Altitude must be finite: ");
                                        obj3.append(obj6);
                                        obj2 = new IllegalArgumentException(obj3.toString());
                                        throw obj2;
                                    }
                                }
                                obj3 = new StringBuilder();
                                obj3.append("Degrees out of range -180.0 <= longitude < +180.0: ");
                                obj3.append(i3);
                                obj2 = new IllegalArgumentException(obj3.toString());
                                throw obj2;
                            }
                        }
                        StringBuilder obj5 = new StringBuilder();
                        obj5.append("Degrees out of range -90.0 <= latitude <= +90.0: ");
                        obj5.append(d);
                        IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString());
                        throw obj4;
                    }
                }
                obj3 = new StringBuilder();
                obj3.append("Longitude must be a finite value: ");
                obj3.append(i3);
                obj2 = new IllegalArgumentException(obj3.toString());
                throw obj2;
            }
        }
        obj5 = new StringBuilder();
        obj5.append("Latitude must be a finite value: ");
        obj5.append(d);
        obj4 = new IllegalArgumentException(obj5.toString());
        throw obj4;
    }

    private static boolean d(k k, k k2) {
        int i;
        if (k == null && k2 == null) {
            if (k2 == null) {
                i = 1;
            }
            return i;
        }
        if (k2 == null) {
            return 0;
        }
        return k.a().equals(k2.a());
    }

    static b0 e(g g, int i2, double d3, String string4) {
        boolean z;
        f obj9;
        long obj10;
        final Object obj12 = g.b.get(obj12);
        i2 *= 3600;
        obj8 -= obj10;
        obj10 = (long)obj10;
        long l3 = 4741671816366391296L;
        obj9 = f.UT;
        if (!d.w().A()) {
            obj10 += z;
            obj9 = f.POSIX;
        }
        b0 obj8 = b0.o0(obj10, string4, (int)obj8);
        obj9 = f.TT;
        obj10 = (g.b)obj12.equationOfTime(c.e(obj8, obj9));
        long l4 = (long)floor;
        double d4 = (double)l4;
        TimeUnit obj11 = TimeUnit.SECONDS;
        final long l5 = (long)obj10;
        obj10 = TimeUnit.NANOSECONDS;
        double equationOfTime = obj12.equationOfTime(c.e((b0)(b0)obj8.L(l4, obj3).L(l5, d4), obj9));
        long l6 = (long)floor2;
        return (b0)(b0)obj8.L(l6, obj5).L((long)obj9, obj12);
    }

    public static net.time4j.calendar.s.g.a f() {
        g.a aVar = new g.a(0);
        return aVar;
    }

    static g0 g(g g) {
        if (g instanceof g0) {
            return (g0)g;
        }
        return g0.P0(g.c(), obj1);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        g.c(this.latitude, obj1, this.longitude, obj3);
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        boolean observerZoneID;
        String calculator;
        double longitude;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof g) {
            if (this.calculator.equals(object.calculator) && Double.compare(this.latitude, obj4) == 0 && Double.compare(this.longitude, obj4) == 0 && this.altitude == object.altitude && g.d(this.observerZoneID, object.observerZoneID)) {
                if (Double.compare(this.latitude, obj4) == 0) {
                    if (Double.compare(this.longitude, obj4) == 0) {
                        if (this.altitude == object.altitude) {
                            if (g.d(this.observerZoneID, object.observerZoneID)) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return i3 += i9;
    }

    @Override // java.io.Serializable
    public String toString() {
        int altitude;
        boolean calculator;
        Object observerZoneID;
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
}
