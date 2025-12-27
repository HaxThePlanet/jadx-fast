package net.time4j.g1.z;

import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.tz.f;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* compiled from: LocalizedGMTProcessor.java */
/* loaded from: classes3.dex */
final class n implements h<k> {

    private static final net.time4j.tz.p A;
    private static final ConcurrentMap<Locale, String> B = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Locale, n.a> C = new ConcurrentHashMap<>();
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
        a(String str, String str2, int i, int i2) {
            super();
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
        }

        static /* synthetic */ String a(n.a aVar) {
            return aVar.a;
        }

        static /* synthetic */ int b(n.a aVar) {
            return aVar.c;
        }

        static /* synthetic */ int c(n.a aVar) {
            return aVar.d;
        }

        static /* synthetic */ String d(n.a aVar) {
            return aVar.b;
        }
    }
    static {
        n.A = p.u(64800);
    }

    n(boolean z) {
        this(z, true, false, Locale.ROOT, "+", "-", '0', g.SMART);
    }

    private static boolean a(char c, char c2) {
        char upperCase;
        char upperCase2;
        boolean z = false;
        char lowerCase2;
        if (c != c2) {
            if (Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z;
    }

    private static String b(Locale locale) {
        Object locale2;
        final ConcurrentMap concurrentMap = n.B;
        if ((String)concurrentMap.get(locale) == null) {
            locale2 = n.B.putIfAbsent(locale, p.C.r(locale));
            if (locale2 != null) {
            }
        }
        return locale2;
    }

    private static net.time4j.tz.p c(o oVar, d dVar) {
        cVar = a.d;
        if (!dVar.c(cVar)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot extract timezone offset from format attributes for: ";
            oVar = str + oVar;
            throw new IllegalArgumentException(oVar);
        } else {
            Object obj = dVar.b(a.d);
            if (obj instanceof p) {
                return obj;
            }
        }
    }

    private static n.a d(Locale locale) {
        Object locale2;
        int i = 0;
        char charAt;
        char c = 177;
        if ((n.a)n.C.get(locale) == null) {
            String str = n.A.r(locale);
            i = 0;
            while (i < str.length()) {
                c = '\u00b1';
                if (str.charAt(i) == '\u00b1') {
                    int i2 = (str.indexOf("hh", i)) + 2;
                    int indexOf2 = str.indexOf("mm", i2);
                    length = indexOf2 + 2;
                    net.time4j.g1.z.n.a aVar = new n.a(str, str.substring(i2, indexOf2), i, length);
                }
            }
        }
        return locale2;
    }

    private static int e(java.lang.CharSequence charSequence, int i, char c) {
        i = 0;
        while (i < 2) {
            int i7 = i + i;
            int i4 = -1000;
            i3 = charSequence.charAt(i7) - c;
            if (i3 >= 0 && i3 <= 9) {
            }
        }
        return i;
    }

    private static int f(java.lang.CharSequence charSequence, int i, char c) {
        i = 0;
        while (i < 2) {
            int i7 = i + i;
            int i4 = -1000;
            if (i7 >= charSequence.length()) {
                return i4;
            }
        }
        return i;
    }

    private static int g(java.lang.CharSequence charSequence, int i, int i2, Locale locale, boolean z) {
        String str;
        int i4;
        boolean equalsIgnoreCase;
        final int i5 = 4;
        final String[] strArr = new String[i5];
        i = 0;
        strArr[i] = "GMT";
        strArr[1] = n.b(locale);
        strArr[2] = "UTC";
        str = "UT";
        strArr[3] = str;
        while (i < i5) {
            str = strArr[i];
            int length = str.length();
            i4 = i - i2;
            if (i - i2 >= length) {
                String charSequence2 = charSequence.subSequence(i2, i2 + length).toString();
            }
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof n) {
            if (this.a != object.a) {
            }
            return z;
        }
        return false;
    }

    public net.time4j.engine.p<k> getElement() {
        return b0.TIMEZONE_OFFSET;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        net.time4j.tz.p pVar;
        int i5;
        char charAt;
        Locale locale;
        int i7;
        int i8 = -1000;
        boolean booleanValue;
        boolean booleanValue2;
        char charValue;
        Object obj3;
        java.lang.CharSequence charSequence3;
        String str5;
        Object obj4;
        Object obj2;
        int length;
        int i9;
        f aHEAD_OF_UTC2;
        Object obj = this;
        charSequence2 = charSequence;
        final Object dVar32 = sVar;
        Object tVar42 = dVar;
        final Object z52 = tVar;
        final int length2 = charSequence.length();
        i = sVar.f();
        if (i >= length2) {
            dVar32.k(i, "Missing localized time zone offset.");
            return;
        }
        if (z) {
        } else {
            Object obj7 = tVar42.a(a.c, Locale.ROOT);
        }
        z = b.q(locale);
        if (z) {
        } else {
            booleanValue = (Boolean)tVar42.a(a.n, Boolean.FALSE).booleanValue();
        }
        if (z) {
        } else {
            booleanValue2 = (Boolean)tVar42.a(a.i, Boolean.TRUE).booleanValue();
        }
        if (z) {
        } else {
            charValue = (Character)tVar42.a(a.m, '0').charValue();
        }
        if (z) {
        } else {
            str4 = "+";
            obj3 = tVar42.a(b.g, str4);
        }
        if (z) {
        } else {
            str6 = "-";
            Object obj11 = tVar42.a(b.h, str6);
        }
        net.time4j.g1.z.n.a aVar = n.d(locale);
        length = aVar.a.length();
        length = 0;
        i = 0;
        while (i < aVar.a) {
            obj = this;
            if (!obj.c) {
            }
            int i23 = -1;
            aHEAD_OF_UTC2 = f.AHEAD_OF_UTC;
            i += i3;
            i4 = n.e(charSequence2, i10, charValue);
            aHEAD_OF_UTC2 = f.BEHIND_UTC;
            obj = this;
            int i15 = m.h(charSequence2, i2, aVar.b, booleanValue2, z);
            i2 = i2 + i15;
            int i6 = n.f(charSequence2, i2, charValue);
            i7 = -1000;
            if (i6 == -1000) {
                dVar32.k(i2, "Minute part in localized time zone offset does not match expected pattern mm.");
                return;
            }
        }
        Object obj5 = length;
        if (obj5 == null) {
            dVar32.k(i, "Unable to determine localized time zone offset.");
        } else {
            z52.K(b0.TIMEZONE_OFFSET, obj5);
            dVar32.l(i);
        }
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        net.time4j.tz.p pVar;
        int length;
        boolean booleanValue;
        int length3 = -1;
        int i2;
        int length4;
        k kVar = null;
        Locale locale;
        char c = 48;
        int length5 = 0;
        char charValue;
        Object obj;
        java.lang.CharSequence charSequence;
        String str4;
        int i4;
        int i5 = 0;
        final Object oVar3 = this;
        o oVar2 = oVar;
        Object appendable22 = appendable;
        d dVar32 = dVar;
        Object z52 = set;
        if (appendable22 instanceof CharSequence) {
            length3 = (CharSequence)appendable22.length();
        } else {
            length3 = -1;
        }
        int i12 = 0;
        if (oVar.j()) {
            kVar = oVar.t();
        }
        if (kVar == null) {
            pVar = n.c(oVar2, dVar32);
            if (z) {
            } else {
                Object obj3 = dVar32.a(a.c, Locale.ROOT);
            }
            c = '0';
            if (z) {
            } else {
                charValue = (Character)dVar32.a(a.m, Character.valueOf('0')).charValue();
            }
            if (z) {
            } else {
                str3 = "+";
                obj = dVar32.a(b.g, str3);
            }
            if (z) {
            } else {
                str4 = "-";
                Object obj5 = dVar32.a(b.h, str4);
            }
            if (z) {
            } else {
                booleanValue = (Boolean)dVar32.a(a.n, Boolean.FALSE).booleanValue();
            }
            if (oVar3.c || pVar.o() != 0 || pVar.n() != 0) {
                net.time4j.g1.z.n.a aVar = n.d(locale);
                length = 0;
                i5 = 0;
                while (i5 < aVar.a.length()) {
                    i5 = i5 + 1;
                }
            } else {
                String str9 = n.b(locale);
                appendable22.append(str9);
                length = str9.length();
            }
            int i = -1;
            if (length3 != -1 && length > 0 && z52 != 0) {
                i2 = length3 + length;
                z52.add(new g(b0.TIMEZONE_ID, length3, i2));
            }
            return length;
        } else {
            z = kVar instanceof p;
            if (kVar instanceof p) {
            } else {
                z = oVar2 instanceof f;
                if (oVar2 instanceof f) {
                    pVar = l.N(kVar).B(oVar2);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str10 = "Cannot extract timezone offset from: ";
        r1 = str10 + oVar2;
        throw new IllegalArgumentException(r1);
    }

    public h<k> quickPath(c<?> cVar, d dVar, int i) {
        n cVar2 = new n(this.a, (Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue(), (Boolean)dVar.a(a.n, Boolean.FALSE).booleanValue(), (Locale)dVar.a(a.c, Locale.ROOT), (String)dVar.a(b.g, "+"), (String)dVar.a(b.h, "-"), (Character)dVar.a(a.m, '0').charValue(), (g)dVar.a(a.f, g.SMART));
        return cVar2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = n.class.getName();
        String str2 = "[abbreviated=";
        str = 64 + name + str2 + this.a + 93;
        return str;
    }

    private n(boolean z, boolean z2, boolean z3, Locale locale, String str, String str2, char c, g gVar) {
        super();
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.v = locale;
        this.w = str;
        this.x = str2;
        this.y = c;
        this.z = gVar;
    }

    public boolean isNumerical() {
        return false;
    }

    public h<k> withElement(net.time4j.engine.p<k> pVar) {
        return this;
    }
}
