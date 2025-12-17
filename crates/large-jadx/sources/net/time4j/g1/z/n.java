package net.time4j.g1.z;

import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.tz.f;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
final class n implements net.time4j.g1.z.h<k> {

    private static final p A;
    private static final ConcurrentMap<Locale, String> B;
    private static final ConcurrentMap<Locale, net.time4j.g1.z.n.a> C;
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final Locale v;
    private final String w;
    private final String x;
    private final char y;
    private final g z;

    private static class a {

        private final String a;
        private final String b;
        private final int c;
        private final int d;
        a(String string, String string2, int i3, int i4) {
            super();
            this.a = string;
            this.b = string2;
            this.c = i3;
            this.d = i4;
        }

        static String a(net.time4j.g1.z.n.a n$a) {
            return a.a;
        }

        static int b(net.time4j.g1.z.n.a n$a) {
            return a.c;
        }

        static int c(net.time4j.g1.z.n.a n$a) {
            return a.d;
        }

        static String d(net.time4j.g1.z.n.a n$a) {
            return a.b;
        }
    }
    static {
        n.A = p.u(64800);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        n.B = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        n.C = concurrentHashMap2;
    }

    n(boolean z) {
        super(z, 1, 0, Locale.ROOT, "+", "-", 48, g.SMART);
    }

    private n(boolean z, boolean z2, boolean z3, Locale locale4, String string5, String string6, char c7, g g8) {
        super();
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.v = locale4;
        this.w = string5;
        this.x = string6;
        this.y = c7;
        this.z = g8;
    }

    private static boolean a(char c, char c2) {
        char upperCase;
        char upperCase2;
        char obj2;
        char obj3;
        if (c != c2 && Character.toUpperCase(c) != Character.toUpperCase(c2)) {
            if (Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static String b(Locale locale) {
        Object obj;
        Object obj2;
        final ConcurrentMap map = n.B;
        obj2 = map.putIfAbsent(locale, p.C.r(locale));
        if ((String)map.get(locale) == null && (String)obj2 != null) {
            obj2 = map.putIfAbsent(locale, p.C.r(locale));
            if ((String)(String)obj2 != null) {
                obj = obj2;
            }
        }
        return obj;
    }

    private static p c(o o, d d2) {
        net.time4j.engine.c cVar;
        Object obj3;
        cVar = a.d;
        if (!d2.c(cVar)) {
        } else {
            obj3 = d2.b(cVar);
            if (!obj3 instanceof p) {
            } else {
                return (p)(k)obj3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot extract timezone offset from format attributes for: ");
        stringBuilder.append(o);
        obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private static net.time4j.g1.z.n.a d(Locale locale) {
        Object obj;
        String str;
        int i;
        int length;
        char charAt;
        int i2;
        Object obj6;
        if ((n.a)n.C.get(locale) == null) {
            str = n.A.r(locale);
            i = 0;
            while (i < str.length()) {
                if (str.charAt(i) == 177) {
                    break;
                } else {
                }
                i++;
            }
        }
        return obj;
    }

    private static int e(java.lang.CharSequence charSequence, int i2, char c3) {
        int i4;
        int i;
        int i5;
        int length;
        int i3;
        i = i4;
        while (i4 < 2) {
            int i8 = i2 + i4;
            i3 = -1000;
            charAt -= c3;
            i6 += i5;
            i4++;
        }
        return i;
    }

    private static int f(java.lang.CharSequence charSequence, int i2, char c3) {
        int i4;
        int i;
        int i3;
        int length;
        int i5;
        i = i4;
        while (i4 < 2) {
            int i8 = i2 + i4;
            i5 = -1000;
            charAt -= c3;
            i6 += i3;
            i4++;
        }
        return i;
    }

    private static int g(java.lang.CharSequence charSequence, int i2, int i3, Locale locale4, boolean z5) {
        String equals;
        int length;
        int string;
        boolean equalsIgnoreCase;
        int obj10;
        final int i = 4;
        final String[] strArr = new String[i];
        final int i5 = 0;
        strArr[i5] = "GMT";
        strArr[1] = n.b(locale4);
        strArr[2] = "UTC";
        strArr[3] = "UT";
        obj10 = i5;
        while (obj10 < i) {
            equals = strArr[obj10];
            length = equals.length();
            obj10++;
            string = charSequence.subSequence(i3, i3 + length).toString();
        }
        return i5;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof n) {
            if (this.a == object.a) {
            } else {
                i = i2;
            }
            return i;
        }
        return i2;
    }

    public p<k> getElement() {
        return b0.TIMEZONE_OFFSET;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return this.a;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int i2;
        int i10;
        String str2;
        Object tIMEZONE_OFFSET;
        Object tIMEZONE_OFFSET3;
        Object tIMEZONE_OFFSET2;
        int i3;
        int i11;
        int i4;
        p pVar;
        int i7;
        int charAt;
        boolean strict;
        int bEHIND_UTC;
        int i9;
        Object obj;
        Object obj11;
        Locale rOOT;
        boolean z;
        boolean booleanValue;
        Boolean fALSE;
        boolean booleanValue2;
        Boolean tRUE;
        char charValue;
        Character valueOf;
        Object obj3;
        Object obj5;
        String str3;
        Object str5;
        Object obj2;
        String str4;
        int length;
        f i;
        int i5;
        int i6;
        int i8;
        f aHEAD_OF_UTC;
        char c;
        Object obj4;
        String str;
        int i12;
        Object obj6;
        boolean z2;
        Object obj7 = this;
        tIMEZONE_OFFSET3 = charSequence;
        final Object obj8 = s2;
        Object obj9 = d3;
        final Object obj10 = t4;
        final int length2 = charSequence.length();
        charAt = s2.f();
        if (charAt >= length2) {
            obj8.k(charAt, "Missing localized time zone offset.");
        }
        if (z5) {
            obj = obj7.v;
        } else {
            obj = obj9.a(a.c, Locale.ROOT);
        }
        z = b.q(obj);
        if (z5) {
            booleanValue = obj7.c;
        } else {
            booleanValue = (Boolean)obj9.a(a.n, Boolean.FALSE).booleanValue();
        }
        if (z5) {
            booleanValue2 = obj7.b;
        } else {
            booleanValue2 = (Boolean)obj9.a(a.i, Boolean.TRUE).booleanValue();
        }
        if (z5) {
            charValue = obj7.y;
        } else {
            charValue = (Character)obj9.a(a.m, '0').charValue();
        }
        if (z5) {
            obj3 = obj7.w;
        } else {
            obj3 = obj9.a(b.g, "+");
        }
        if (z5) {
            str5 = obj7.x;
        } else {
            str5 = obj9.a(b.h, "-");
        }
        net.time4j.g1.z.n.a aVar = n.d(obj);
        length = n.a.a(aVar).length();
        i6 = 0;
        i2 = charAt;
        i8 = i5;
        i3 = i6;
        while (i3 < length) {
            z2 = z;
            obj4 = obj3;
            str = str5;
            obj5 = this;
            charAt = i12;
            obj = obj6;
            i3++;
            length = i5;
            obj3 = obj4;
            str5 = str;
            z = z2;
            if (i2 < length2) {
            } else {
            }
            charAt = i6;
            obj = c;
            i2++;
            charAt = tIMEZONE_OFFSET3.charAt(i2);
            int i24 = -1;
            aHEAD_OF_UTC = f.AHEAD_OF_UTC;
            i = aHEAD_OF_UTC;
            i2 += i11;
            i4 = n.e(tIMEZONE_OFFSET3, i13, charValue);
            obj4 = obj3;
            if (i4 < 0) {
            } else {
            }
            i13 += 2;
            obj5 = this;
            str = str5;
            if (z5) {
            } else {
            }
            i12 = charAt;
            obj6 = obj;
            obj2 = charAt;
            strict = m.h(tIMEZONE_OFFSET3, i10, n.a.d(aVar), booleanValue2, z);
            bEHIND_UTC = n.f(tIMEZONE_OFFSET3, i10, charValue);
            i10 += 2;
            obj = m.h(tIMEZONE_OFFSET3, i2, n.a.d(aVar), booleanValue2, z);
            if (i2 < length2 && obj != -1) {
            } else {
            }
            z2 = z;
            z = -1000;
            str5 = i6;
            if (str5 != null) {
            } else {
            }
            pVar = p.t(i, i4, bEHIND_UTC);
            i8 = pVar;
            i3 = charAt;
            if (str5 == z) {
            } else {
            }
            if (i == f.BEHIND_UTC) {
            }
            pVar = p.u(i7);
            i7 = -i7;
            obj = m.h(tIMEZONE_OFFSET3, i2, n.a.d(aVar), booleanValue2, z);
            if (obj != -1) {
            } else {
            }
            i2 += obj;
            z2 = z;
            if (n.f(tIMEZONE_OFFSET3, i14, charValue) == -1000) {
            } else {
            }
            i14 += 2;
            i14 -= obj;
            i10 += strict;
            obj2 = obj5.z;
            i12 = charAt;
            obj6 = obj;
            obj11 = d3;
            i4 = ~i4;
            i13++;
            aHEAD_OF_UTC = f.BEHIND_UTC;
        }
        Object obj17 = this;
        int i17 = i8;
        if (i17 == 0) {
            obj8.k(i2, "Unable to determine localized time zone offset.");
        } else {
            obj10.K(b0.TIMEZONE_OFFSET, i17);
            obj8.l(i2);
        }
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        p pVar2;
        int valueOf3;
        int length;
        int gVar;
        boolean booleanValue;
        int length2;
        int valueOf2;
        int length5;
        int i4;
        Object locale;
        boolean rOOT;
        int length4;
        int i5;
        char charValue;
        Character valueOf;
        Object str;
        String str2;
        Object obj;
        String str3;
        int length3;
        Boolean fALSE;
        int charAt;
        int i;
        int i3;
        int i2;
        p pVar;
        final Object obj2 = this;
        o oVar = o;
        Object obj3 = appendable2;
        d dVar = d3;
        Object obj5 = set4;
        if (obj3 instanceof CharSequence) {
            length2 = (CharSequence)obj3.length();
        } else {
            length2 = -1;
        }
        i4 = 0;
        if (o.j()) {
            i4 = o.t();
        }
        if (i4 == 0) {
            pVar2 = n.c(oVar, dVar);
            if (z5) {
                locale = obj2.v;
            } else {
                locale = dVar.a(a.c, Locale.ROOT);
            }
            if (z5) {
                charValue = obj2.y;
            } else {
                charValue = (Character)dVar.a(a.m, '0').charValue();
            }
            if (z5) {
                str = obj2.w;
            } else {
                str = dVar.a(b.g, "+");
            }
            if (z5) {
                obj = obj2.x;
            } else {
                obj = dVar.a(b.h, "-");
            }
            if (z5) {
                booleanValue = obj2.c;
            } else {
                booleanValue = (Boolean)dVar.a(a.n, Boolean.FALSE).booleanValue();
            }
            if (!booleanValue && pVar2.o() == 0 && pVar2.n() == 0) {
                if (pVar2.o() == 0) {
                    if (pVar2.n() == 0) {
                        String str8 = n.b(locale);
                        obj3.append(str8);
                        length = str8.length();
                    } else {
                        locale = n.d(locale);
                        i = 0;
                        i3 = 0;
                        while (i3 < n.a.a(locale).length()) {
                            if (n.a.b(locale) <= i3) {
                            } else {
                            }
                            pVar = pVar2;
                            i2 = length4;
                            if (!booleanValue) {
                            }
                            i3++;
                            length4 = i2;
                            pVar2 = pVar;
                            obj3.append(n.a.a(locale).charAt(i3));
                            i++;
                            if (n.a.c(locale) <= i3) {
                            } else {
                            }
                            if (pVar2.q() == f.BEHIND_UTC) {
                            } else {
                            }
                            obj3.append(str);
                            length5 = str.length();
                            int i10 = pVar2.j();
                            charAt = pVar2.k();
                            int i15 = pVar2.m();
                            if (i10 < 10 && !obj2.a) {
                            }
                            valueOf2 = String.valueOf(i10);
                            pVar = pVar2;
                            length4 = 0;
                            while (length4 < valueOf2.length()) {
                                i2 = 48;
                                obj3.append((char)i9);
                                i++;
                                length4++;
                            }
                            if (charAt == 0 && i15 == 0) {
                            } else {
                            }
                            obj3.append(n.a.d(locale));
                            if (charAt < 10) {
                            }
                            valueOf3 = String.valueOf(charAt);
                            valueOf2 = 0;
                            while (valueOf2 < valueOf3.length()) {
                                obj3.append((char)i14);
                                i++;
                                valueOf2++;
                            }
                            obj3.append(n.a.d(locale));
                            if (i15 != 0 && i15 < 10) {
                            }
                            i2 = 48;
                            i3 = pVar2 + -1;
                            obj3.append(n.a.d(locale));
                            if (i15 < 10) {
                            }
                            valueOf3 = String.valueOf(i15);
                            valueOf2 = 0;
                            while (valueOf2 < valueOf3.length()) {
                                i2 = 48;
                                obj3.append((char)i12);
                                i++;
                                valueOf2++;
                            }
                            i2 = 48;
                            obj3.append((char)i12);
                            i++;
                            valueOf2++;
                            obj3.append(charValue);
                            i++;
                            obj3.append((char)i14);
                            i++;
                            valueOf2++;
                            obj3.append(charValue);
                            i++;
                            if (i15 == 0) {
                            } else {
                            }
                            if (!obj2.a) {
                            }
                            i2 = 48;
                            obj3.append((char)i9);
                            i++;
                            length4++;
                            if (!obj2.a) {
                            }
                            obj3.append(charValue);
                            i++;
                            obj3.append(obj);
                            length5 = obj.length();
                        }
                        length = i;
                    }
                } else {
                }
            } else {
            }
            if (length2 != -1 && length > 0 && obj5 != null) {
                if (length > 0) {
                    if (obj5 != null) {
                        gVar = new g(b0.TIMEZONE_ID, length2, length2 + length);
                        obj5.add(gVar);
                    }
                }
            }
            return length;
        } else {
            if (i4 instanceof p) {
                pVar2 = i4;
            } else {
                if (!oVar instanceof f) {
                } else {
                    pVar2 = l.N(i4).B((f)oVar);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot extract timezone offset from: ");
        stringBuilder.append(oVar);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public net.time4j.g1.z.h<k> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        super(this.a, (Boolean)d2.a(a.i, Boolean.TRUE).booleanValue(), (Boolean)d2.a(a.n, Boolean.FALSE).booleanValue(), (Locale)d2.a(a.c, Locale.ROOT), (String)d2.a(b.g, "+"), (String)d2.a(b.h, "-"), (Character)d2.a(a.m, '0').charValue(), (g)d2.a(a.f, g.SMART));
        return obj10;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(n.class.getName());
        stringBuilder.append("[abbreviated=");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<k> withElement(p<k> p) {
        return this;
    }
}
