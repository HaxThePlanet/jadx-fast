package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class p implements Comparable<net.time4j.tz.p>, net.time4j.tz.k, Serializable {

    private static final BigDecimal A = null;
    private static final BigDecimal B = null;
    public static final net.time4j.tz.p C = null;
    private static final long serialVersionUID = -1410512619471503090L;
    private static final ConcurrentMap<Integer, net.time4j.tz.p> v;
    private static final BigDecimal w;
    private static final BigDecimal x;
    private static final BigDecimal y;
    private static final BigDecimal z;
    private final transient int a;
    private final transient int b;
    private final transient String c;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        p.v = concurrentHashMap;
        BigDecimal bigDecimal = new BigDecimal(60);
        p.w = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(3600);
        p.x = bigDecimal2;
        BigDecimal bigDecimal3 = new BigDecimal(-180);
        p.y = bigDecimal3;
        BigDecimal bigDecimal4 = new BigDecimal(180);
        p.z = bigDecimal4;
        BigDecimal bigDecimal5 = new BigDecimal(240);
        p.A = bigDecimal5;
        BigDecimal bigDecimal6 = new BigDecimal(1000000000);
        p.B = bigDecimal6;
        int i7 = 0;
        p pVar = new p(i7, i7);
        p.C = pVar;
        concurrentHashMap.put(Integer.valueOf(i7), pVar);
    }

    private p(int i, int i2) {
        int i6;
        int i4;
        int i5;
        int i8;
        int i3;
        int valueOf;
        int i7;
        super();
        if (i2 == 0) {
            if (i < -64800) {
            } else {
                if (i > 64800) {
                } else {
                    if (i >= 0) {
                        if (i2 < 0) {
                            i8 = 1;
                        } else {
                            i8 = i4;
                        }
                    } else {
                    }
                    StringBuilder stringBuilder5 = new StringBuilder();
                    i3 = i8 != 0 ? 45 : 43;
                    stringBuilder5.append(i3);
                    int i10 = Math.abs(i);
                    int i13 = i10 / 3600;
                    i14 %= 60;
                    i10 %= 60;
                    final int i16 = 10;
                    final int i17 = 48;
                    if (i13 < i16) {
                        stringBuilder5.append(i17);
                    }
                    stringBuilder5.append(i13);
                    i7 = 58;
                    stringBuilder5.append(i7);
                    if (i15 < i16) {
                        stringBuilder5.append(i17);
                    }
                    stringBuilder5.append(i15);
                    if (valueOf == 0) {
                        stringBuilder5.append(i7);
                        if (i2 != 0 && valueOf < i16) {
                            stringBuilder5.append(i7);
                            if (valueOf < i16) {
                                stringBuilder5.append(i17);
                            }
                            stringBuilder5.append(valueOf);
                            if (i2 != 0) {
                                stringBuilder5.append('.');
                                valueOf = String.valueOf(Math.abs(i2));
                                while (i4 < length - 9) {
                                    stringBuilder5.append(i17);
                                    i4++;
                                }
                                stringBuilder5.append(valueOf);
                            }
                        }
                    } else {
                    }
                    this.c = stringBuilder5.toString();
                    this.a = i;
                    this.b = i2;
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Total seconds out of range: ");
            stringBuilder3.append(i);
            IllegalArgumentException obj9 = new IllegalArgumentException(stringBuilder3.toString());
            throw obj9;
        }
        if (Math.abs(i2) > 999999999) {
        } else {
            if (i < -39600) {
            } else {
                if (i > 39600) {
                } else {
                    if (i < 0 && i2 <= 0) {
                        if (i2 > 0) {
                        } else {
                            if (i > 0) {
                                if (i2 < 0) {
                                } else {
                                }
                            }
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Different signs: offset=");
                        stringBuilder4.append(i);
                        stringBuilder4.append(", fraction=");
                        stringBuilder4.append(i2);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder4.toString());
                        throw illegalArgumentException;
                    } else {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Total seconds out of range while fraction is non-zero: ");
            stringBuilder.append(i);
            obj9 = new IllegalArgumentException(stringBuilder.toString());
            throw obj9;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Fraction out of range: ");
        stringBuilder2.append(i2);
        IllegalArgumentException obj8 = new IllegalArgumentException(stringBuilder2.toString());
        throw obj8;
    }

    public static net.time4j.tz.p c(BigDecimal bigDecimal) {
        int compareTo;
        if (bigDecimal.compareTo(p.z) > 0) {
        } else {
            if (bigDecimal.compareTo(p.y) < 0) {
            } else {
                BigDecimal obj3 = bigDecimal.multiply(p.A);
                BigDecimal scale = obj3.setScale(0, RoundingMode.DOWN);
                int intValueExact = scale.intValueExact();
                obj3 = obj3.subtract(scale).setScale(9, RoundingMode.HALF_UP).multiply(p.B).intValueExact();
                if (obj3 == null) {
                    return p.u(intValueExact);
                }
                if (obj3 == 1000000000) {
                    return p.u(intValueExact++);
                }
                if (obj3 == -1000000000) {
                    return p.u(intValueExact--);
                }
                p pVar = new p(intValueExact, obj3);
                return pVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(bigDecimal);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.tz.p e(net.time4j.tz.f f, int i2, int i3, double d4) {
        int str;
        int compare;
        long num;
        long hALF_UP;
        BigDecimal obj6;
        int obj7;
        int obj8;
        double obj9;
        Objects.requireNonNull(f, "Missing sign.");
        if (i2 < 0) {
        } else {
            if (i2 > 180) {
            } else {
                if (i3 < 0) {
                } else {
                    if (i3 > 59) {
                    } else {
                        int i = 0;
                        if (Double.compare(d4, obj9) < 0) {
                        } else {
                            if (Double.compare(d4, obj9) >= 0) {
                            } else {
                                int i4 = 15;
                                if (i3 != 0) {
                                    obj6 = BigDecimal.valueOf((long)i2).add(BigDecimal.valueOf((long)i3).setScale(i4, RoundingMode.UNNECESSARY).divide(p.w, RoundingMode.HALF_UP));
                                }
                                if (Double.compare(d4, i) != 0) {
                                    obj6 = obj6.add(BigDecimal.valueOf(d4).setScale(i4, RoundingMode.FLOOR).divide(p.x, RoundingMode.HALF_UP));
                                }
                                if (f == f.BEHIND_UTC) {
                                    obj6 = obj6.negate();
                                }
                                return p.c(obj6);
                            }
                        }
                        IllegalArgumentException obj5 = new IllegalArgumentException("Arc second out of range (0.0 <= arcSeconds < 60.0).");
                        throw obj5;
                    }
                }
                obj5 = new IllegalArgumentException("Arc minute out of range (0 <= arcMinutes <= 59).");
                throw obj5;
            }
        }
        obj5 = new IllegalArgumentException("Degrees of longitude out of range (0 <= degrees <= 180).");
        throw obj5;
    }

    private static String i(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[hours=");
        stringBuilder.append(i);
        stringBuilder.append(",minutes=");
        stringBuilder.append(i2);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    public static net.time4j.tz.p s(net.time4j.tz.f f, int i2) {
        return p.t(f, i2, 0);
    }

    public static net.time4j.tz.p t(net.time4j.tz.f f, int i2, int i3) {
        String str;
        int i;
        int obj3;
        Objects.requireNonNull(f, "Missing sign.");
        if (i2 < 0) {
        } else {
            str = 18;
            if (i2 > str) {
            } else {
                if (i3 < 0) {
                } else {
                    if (i3 > 59) {
                    } else {
                        if (i2 == str) {
                            if (i3 != 0) {
                            } else {
                            }
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Time zone offset out of range (-18:00:00 <= offset <= 18:00:00) in: ");
                            stringBuilder3.append(p.i(i2, i3));
                            IllegalArgumentException obj2 = new IllegalArgumentException(stringBuilder3.toString());
                            throw obj2;
                        }
                        if (f == f.BEHIND_UTC) {
                            obj3 = -obj3;
                        }
                        return p.u(obj3);
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Minute part out of range (0 <= minutes <= 59) in: ");
                stringBuilder2.append(p.i(i2, i3));
                obj2 = new IllegalArgumentException(stringBuilder2.toString());
                throw obj2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hour part out of range (0 <= hours <= 18) in: ");
        stringBuilder.append(p.i(i2, i3));
        obj2 = new IllegalArgumentException(stringBuilder.toString());
        throw obj2;
    }

    public static net.time4j.tz.p u(int i) {
        return p.v(i, 0);
    }

    public static net.time4j.tz.p v(int i, int i2) {
        Object obj;
        int obj3;
        if (i2 != 0) {
            p pVar = new p(i, i2);
            return pVar;
        }
        if (i == 0) {
            return p.C;
        }
        int i3 = 0;
        Integer obj4 = Integer.valueOf(i);
        final ConcurrentMap map = p.v;
        if (i % 900 == 0 && (p)map.get(obj4) == null) {
            obj4 = Integer.valueOf(i);
            map = p.v;
            if ((p)map.get(obj4) == null) {
                p pVar2 = new p(i, i3);
                map.putIfAbsent(obj4, pVar2);
                obj = obj3;
            }
            return obj;
        }
        obj4 = new p(i, i3);
        return obj4;
    }

    private static int w(String string, int i2, int i3) {
        int i;
        int i5;
        int charAt;
        int i4;
        int i7 = -1;
        i = 0;
        i5 = i7;
        while (i < Math.min(length -= i2, i3)) {
            charAt = string.charAt(i2 + i);
            if (charAt >= 48) {
            }
            if (charAt <= 57) {
            }
            if (i5 == i7) {
            } else {
            }
            i8 += charAt;
            i++;
            i5 = charAt;
        }
        return i5;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 15);
        return spx;
    }

    static net.time4j.tz.p x(String string, boolean z2) {
        int charAt;
        int i5;
        boolean startsWith;
        String substring;
        int bEHIND_UTC;
        net.time4j.tz.f aHEAD_OF_UTC;
        char charAt2;
        int i;
        int i3;
        char charAt3;
        int i4;
        int i2;
        if (string.equals("Z")) {
            return p.C;
        }
        charAt = string.length();
        int i7 = 0;
        i5 = 3;
        if (charAt >= i5) {
            if (string.startsWith("UTC")) {
                substring = string.substring(i5);
                charAt += -3;
            } else {
                if (string.startsWith("GMT")) {
                    if (z2) {
                    } else {
                        return i7;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Use UTC-prefix for canonical offset instead: ");
                    stringBuilder.append(string);
                    IllegalArgumentException obj12 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj12;
                }
                substring = string;
            }
        } else {
        }
        bEHIND_UTC = 2;
        if (charAt >= bEHIND_UTC) {
            int i8 = 0;
            aHEAD_OF_UTC = substring.charAt(i8) == 45 ? f.BEHIND_UTC : charAt4 == charAt2 ? f.AHEAD_OF_UTC : i7;
            i = p.w(substring, 1, bEHIND_UTC);
            if (i >= 0 && charAt <= i5) {
                if (charAt <= i5) {
                    return p.s(aHEAD_OF_UTC, i);
                }
                i4 = 58;
                if (substring.charAt(bEHIND_UTC) == i4) {
                } else {
                    i5 = i12;
                }
                i3 = p.w(substring, i5, bEHIND_UTC);
                charAt3 = i5 + 2;
                if (substring.charAt(i5 + -1) == i4 && i3 >= 0 && charAt == charAt3) {
                    if (i3 >= 0) {
                        charAt3 = i5 + 2;
                        if (charAt == charAt3) {
                            return p.t(aHEAD_OF_UTC, i, i3);
                        }
                        i2 = i5 + 5;
                        bEHIND_UTC = p.w(substring, i5 + 3, bEHIND_UTC);
                        bEHIND_UTC = f.BEHIND_UTC;
                        if (charAt >= i2 && substring.charAt(charAt3) == i4 && bEHIND_UTC >= 0 && aHEAD_OF_UTC == bEHIND_UTC) {
                            if (substring.charAt(charAt3) == i4) {
                                bEHIND_UTC = p.w(substring, i5 + 3, bEHIND_UTC);
                                if (bEHIND_UTC >= 0) {
                                    bEHIND_UTC = f.BEHIND_UTC;
                                    if (aHEAD_OF_UTC == bEHIND_UTC) {
                                        i = -i;
                                    }
                                    if (charAt == i2) {
                                        return p.u(i);
                                    }
                                    charAt = p.w(substring, i5 += 6, 9);
                                    if (charAt == i5 + 15 && substring.charAt(i2) == 46 && charAt >= 0 && aHEAD_OF_UTC == bEHIND_UTC) {
                                        if (substring.charAt(i2) == 46) {
                                            charAt = p.w(substring, i5 += 6, 9);
                                            if (charAt >= 0) {
                                                if (aHEAD_OF_UTC == bEHIND_UTC) {
                                                    charAt = -charAt;
                                                }
                                                return p.v(i, charAt);
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
        if (z2) {
        } else {
            return i7;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("No canonical zonal offset: ");
        stringBuilder2.append(string);
        obj12 = new IllegalArgumentException(stringBuilder2.toString());
        throw obj12;
    }

    @Override // java.lang.Comparable
    public String a() {
        int i;
        if (this.a == 0 && this.b == 0) {
            if (this.b == 0) {
                return "Z";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UTC");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return f((p)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i2;
        int i;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object instanceof p) {
            if (this.a == object.a && this.b == object.b) {
                if (this.b == object.b) {
                } else {
                    i2 = i3;
                }
            } else {
            }
            return i2;
        }
        return i3;
    }

    @Override // java.lang.Comparable
    public int f(net.time4j.tz.p p) {
        int i;
        int i2 = this.a;
        final int i5 = p.a;
        if (i2 < i5) {
            return -1;
        }
        final int i6 = 1;
        if (i2 > i5) {
            return i6;
        }
        i3 -= obj5;
        if (i4 < 0) {
        } else {
            i = i4 == 0 ? 0 : i6;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return i2 += i5;
    }

    @Override // java.lang.Comparable
    public int j() {
        return i2 /= 3600;
    }

    @Override // java.lang.Comparable
    public int k() {
        return i3 %= 60;
    }

    @Override // java.lang.Comparable
    public int m() {
        return i2 %= 60;
    }

    @Override // java.lang.Comparable
    public int n() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int o() {
        return this.a;
    }

    @Override // java.lang.Comparable
    net.time4j.tz.j p() {
        return j.R(this);
    }

    @Override // java.lang.Comparable
    public net.time4j.tz.f q() {
        net.time4j.tz.f aHEAD_OF_UTC;
        int i;
        if (this.a >= 0) {
            if (this.b < 0) {
                aHEAD_OF_UTC = f.BEHIND_UTC;
            } else {
                aHEAD_OF_UTC = f.AHEAD_OF_UTC;
            }
        } else {
        }
        return aHEAD_OF_UTC;
    }

    @Override // java.lang.Comparable
    public String r(Locale locale) {
        int i2;
        int i;
        if (this.a == 0 && this.b == 0) {
            i = this.b == 0 ? 1 : 0;
        } else {
        }
        return l.K.g(i, locale);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return this.c;
    }
}
