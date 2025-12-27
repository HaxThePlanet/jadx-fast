package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ZonalOffset.java */
/* loaded from: classes3.dex */
public final class p implements Comparable<p>, k, Serializable {

    private static final BigDecimal A = null;
    private static final BigDecimal B = null;
    public static final p C = null;
    private static final long serialVersionUID = -1410512619471503090L;
    private static final ConcurrentMap<Integer, p> v = new ConcurrentHashMap<>();
    private static final BigDecimal w = new BigDecimal(60);
    private static final BigDecimal x = new BigDecimal(3600);
    private static final BigDecimal y = new BigDecimal(-180);
    private static final BigDecimal z = new BigDecimal(180);
    private final transient int a;
    private final transient int b = new IllegalArgumentException();
    private final transient String c;
    static {
        p.A = new BigDecimal(240);
        p.B = new BigDecimal(1000000000);
        int i7 = 0;
        net.time4j.tz.p pVar = new p(i7, i7);
        p.C = pVar;
        obj.put(Integer.valueOf(i7), pVar);
    }

    private p(int i, int i2) {
        int i4 = 0;
        char c = 43;
        super();
        if (i2 == 0 && i >= -64800) {
            int i3 = 64800;
            if (i > 64800) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str5 = "Total seconds out of range: ";
                i = str5 + i;
                throw new IllegalArgumentException(i);
            } else {
                i4 = 0;
                if (i < 0 || i2 < 0) {
                    i4 = 1;
                }
                StringBuilder stringBuilder5 = new StringBuilder();
                int r1 = i4 != 0 ? 45 : 43;
                stringBuilder5.append((i4 != 0 ? 45 : 43));
                r1 = Math.abs(i);
                int i8 = (i4 != 0 ? 45 : 43) / 3600;
                int i11 = (r1 / 60) % 60;
                i6 = r1 % 60;
                final int i12 = 10;
                final char c3 = '0';
                if (i8 < i12) {
                    stringBuilder5.append(c3);
                }
                stringBuilder5.append(i8);
                char c2 = ':';
                stringBuilder5.append(c2);
                if (i11 < i12) {
                    stringBuilder5.append(c3);
                }
                stringBuilder5.append(i11);
                if (i6 != 0 || i2 != 0) {
                    stringBuilder5.append(c2);
                    if (i6 < i12) {
                        stringBuilder5.append(c3);
                    }
                    stringBuilder5.append(i6);
                    if (i2 != 0) {
                        stringBuilder5.append('.');
                        String str4 = String.valueOf(Math.abs(i2));
                        while (i4 < str4.length() - 9) {
                            stringBuilder5.append(c3);
                            i4 = i4 + 1;
                        }
                        stringBuilder5.append(str4);
                    }
                }
                this.c = stringBuilder5.toString();
                this.a = i;
                return;
            }
        }
        int i5 = 999999999;
        if (Math.abs(i2) > 999999999) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str3 = "Fraction out of range: ";
            i2 = str3 + i2;
            throw new IllegalArgumentException(i2);
        } else {
            i3 = -39600;
            if (i < -39600) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Total seconds out of range while fraction is non-zero: ";
                i = str2 + i;
                throw new IllegalArgumentException(i);
            } else {
                i3 = 39600;
                if (i <= 39600) {
                    if (i >= 0 || i2 <= 0) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        String str6 = "Different signs: offset=";
                        String str7 = ", fraction=";
                        i = str6 + i + str7 + i2;
                        throw new IllegalArgumentException(i);
                    }
                }
            }
        }
    }

    public static p c(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(p.z) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Out of range: ";
            bigDecimal = str + bigDecimal;
            throw new IllegalArgumentException(bigDecimal);
        } else {
            if (bigDecimal.compareTo(p.y) >= 0) {
                BigDecimal multiply = bigDecimal.multiply(p.A);
                BigDecimal scale = multiply.setScale(0, RoundingMode.DOWN);
                int intValueExact = scale.intValueExact();
                int intValueExact2 = multiply.subtract(scale).setScale(9, RoundingMode.HALF_UP).multiply(p.B).intValueExact();
                if (intValueExact2 == 0) {
                    return p.u(intValueExact);
                }
                if (intValueExact2 == 1000000000) {
                    return p.u(intValueExact + 1);
                }
                if (intValueExact2 == -1000000000) {
                    return p.u(intValueExact - 1);
                }
                return new p(intValueExact, intValueExact2);
            }
        }
    }

    public static p e(f fVar, int i, int i2, double d) {
        BigDecimal negate;
        str = "Missing sign.";
        Objects.requireNonNull(fVar, str);
        if (i < 0) {
            throw new IllegalArgumentException("Degrees of longitude out of range (0 <= degrees <= 180).");
        } else {
            if (i <= 180) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("Arc minute out of range (0 <= arcMinutes <= 59).");
                } else {
                    i = 59;
                    if (i2 <= 59) {
                        d = 0.0d;
                        if (Double.compare(d, d) < 0) {
                            throw new IllegalArgumentException("Arc second out of range (0.0 <= arcSeconds < 60.0).");
                        } else {
                            if (Double.compare(d, 60d) < 0) {
                                int i4 = 15;
                                if (i2 != 0) {
                                    negate = BigDecimal.valueOf((long)i).add(BigDecimal.valueOf((long)i2).setScale(i4, RoundingMode.UNNECESSARY).divide(p.w, RoundingMode.HALF_UP));
                                }
                                if (d != 0.0d) {
                                    negate = negate.add(BigDecimal.valueOf(d).setScale(i4, RoundingMode.FLOOR).divide(p.x, RoundingMode.HALF_UP));
                                }
                                if (fVar == f.BEHIND_UTC) {
                                    negate = negate.negate();
                                }
                                return p.c(negate);
                            }
                        }
                    }
                }
            }
        }
    }

    private static String i(int i, int i2) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "[hours=";
        String str2 = ",minutes=";
        str3 = str + i + str2 + i2 + 93;
        return str3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public static p s(f fVar, int i) {
        return p.t(fVar, i, 0);
    }

    public static p t(f fVar, int i, int i2) {
        int i4;
        str = "Missing sign.";
        Objects.requireNonNull(fVar, str);
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Hour part out of range (0 <= hours <= 18) in: ";
            String str5 = p.i(i, i2);
            i = str2 + str5;
            throw new IllegalArgumentException(i);
        } else {
            int i5 = 18;
            if (i <= i5) {
                if (i2 < 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str3 = "Minute part out of range (0 <= minutes <= 59) in: ";
                    String str6 = p.i(i, i2);
                    i = str3 + str6;
                    throw new IllegalArgumentException(i);
                } else {
                    i = 59;
                    if (i2 <= 59) {
                        if (i == i5) {
                            if (i2 != 0) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                String str4 = "Time zone offset out of range (-18:00:00 <= offset <= 18:00:00) in: ";
                                String str7 = p.i(i, i2);
                                i = str4 + str7;
                                throw new IllegalArgumentException(i);
                            }
                        }
                        i4 = (i * 3600) + (i2 * 60);
                        if (fVar == f.BEHIND_UTC) {
                            i4 = -(i * 3600 + i2 * 60);
                        }
                        return p.u(i4);
                    }
                }
            }
        }
    }

    public static p u(int i) {
        return p.v(i, 0);
    }

    public static p v(int i, int i2) {
        Object i3;
        if (i2 != 0) {
            return new p(i, i2);
        }
        if (i == 0) {
            return p.C;
        }
        int i4 = 0;
        if (i % 900 == 0) {
            Integer num = Integer.valueOf(i);
            final ConcurrentMap concurrentMap = p.v;
            if ((p)concurrentMap.get(num) == null) {
                p.v.putIfAbsent(num, new p(i, i4));
            }
            return i3;
        }
        return new p(i, i4);
    }

    private static int w(String str, int i, int i2) {
        int i4 = 0;
        char c = 57;
        i = -1;
        i4 = 0;
        while (i4 < Math.min(str.length() - i, i2)) {
            char charAt = str.charAt(i + i4);
            c = '0';
            if (charAt >= '0' && charAt <= '9' && i == i) {
                return i;
            }
        }
        return i;
    }

    private Object writeReplace() {
        return new SPX(this, 15);
    }

    static p x(String str, boolean z) {
        int length;
        int i2 = 3;
        String str2;
        net.time4j.tz.f bEHIND_UTC2;
        int i4;
        if (str.equals("Z")) {
            return p.C;
        }
        length = str.length();
        int i = 0;
        i2 = 3;
        if (length >= i2) {
            if (!str.startsWith("UTC")) {
                if (str.startsWith("GMT")) {
                    if (z) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str4 = "Use UTC-prefix for canonical offset instead: ";
                        str = str4 + str;
                        throw new IllegalArgumentException(str);
                    } else {
                        return null;
                    }
                }
                str2 = str;
            } else {
                str2 = str.substring(i2);
                length = length - 3;
            }
        }
        int i3 = 2;
        if (length >= i3) {
            int i7 = 0;
            char c = '-';
            if (str2.charAt(i7) == '-') {
                bEHIND_UTC2 = f.BEHIND_UTC;
            } else {
                char charAt = '+';
                net.time4j.tz.f r5 = str2.charAt(i7) == '+' ? f.AHEAD_OF_UTC : i;
            }
            i4 = p.w(str2, 1, i3);
            if (i4 >= 0) {
                if (length <= i2) {
                    return p.s(bEHIND_UTC2, i4);
                }
                char c2 = ':';
                if (str2.charAt(i3) != c2) {
                    i2 = 4;
                }
                int i12 = p.w(str2, i2, i3);
                if (str2.charAt(i2 - 1) == c2 && i12 >= 0) {
                    int i16 = i2 + 2;
                    if (length == i16) {
                        return p.t(bEHIND_UTC2, i4, i12);
                    }
                    i5 = i2 + 5;
                    if (length >= i5 && str2.charAt(i16) == c2 && i3 >= 0) {
                        i4 = (i4 * 3600) + (i12 * 60) + i3;
                        net.time4j.tz.f bEHIND_UTC22 = f.BEHIND_UTC;
                        if (bEHIND_UTC2 == f.BEHIND_UTC) {
                            i4 = -(i4 * 3600 + i12 * 60 + i3);
                        }
                        if (length == i5) {
                            return p.u(i4);
                        }
                        if (length == i2 + 15 && str2.charAt(i5) == '.' && length >= 0 && bEHIND_UTC2 == f.BEHIND_UTC) {
                            length = -length;
                            return p.v(i4, length);
                        }
                    }
                }
            }
        }
        if (z) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str5 = "No canonical zonal offset: ";
            str = str5 + str;
            throw new IllegalArgumentException(str);
        } else {
            return i;
        }
    }

    public String a() {
        if (this.a == 0 && this.b == 0) {
            return "Z";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "UTC";
        str = str3 + this.c;
        return str;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int i2;
        int i3;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof p) {
            if (this.a == object.a) {
                if (this.b != object.b) {
                }
            }
            return z;
        }
        return false;
    }

    public int f(p pVar) {
        int i = 0;
        i = -1;
        if (this.a < pVar.a) {
            return -1;
        }
        i = 1;
        if (this.a > pVar.a) {
            return i;
        }
        int i4 = this.b - pVar.b;
        if (this.a >= 0) {
            int r2 = this.a == 0 ? 0 : i;
        }
        return (this.a == 0 ? 0 : i);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ~this.a + (this.b % 64000);
    }

    public int j() {
        return Math.abs(this.a) / 3600;
    }

    public int k() {
        return (Math.abs(this.a) / 60) % 60;
    }

    public int m() {
        return Math.abs(this.a) % 60;
    }

    public int n() {
        return this.b;
    }

    public int o() {
        return this.a;
    }

    j p() {
        return j.R(this);
    }

    public f q() {
        net.time4j.tz.f aHEAD_OF_UTC2;
        if (this.a < 0 || this.b < 0) {
            aHEAD_OF_UTC2 = f.BEHIND_UTC;
        }
        return aHEAD_OF_UTC2;
    }

    public String r(Locale locale) {
        boolean z = false;
        int obj = this.a == 0 && this.b == 0 ? 1 : 0;
        try {
        } catch (Throwable unused) {
        }
        return l.K.g((this.a == 0 && this.b == 0 ? 1 : 0), locale);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c;
    }
}
