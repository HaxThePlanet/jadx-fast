package net.time4j;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.d;
import net.time4j.g1.n;
import net.time4j.g1.r;
import net.time4j.g1.v;
import net.time4j.g1.x;

/* loaded from: classes3.dex */
final class s0 {

    private static final ConcurrentMap<Locale, net.time4j.s0> i;
    private static final net.time4j.x[] j;
    private static final x k;
    private static final x l;
    private final Map<net.time4j.x, Map<v, Map<n, String>>> a;
    private final Map<net.time4j.x, Map<n, String>> b;
    private final Map<net.time4j.x, Map<n, String>> c;
    private final Map<net.time4j.x, Map<n, String>> d;
    private final Map<net.time4j.x, Map<n, String>> e;
    private final Map<Integer, Map<v, String>> f;
    private final Map<net.time4j.x0, String> g;
    private final Map<net.time4j.x0, String> h;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            s0.a.a = iArr;
            iArr[v.WIDE.ordinal()] = 1;
            s0.a.a[v.ABBREVIATED.ordinal()] = 2;
            s0.a.a[v.SHORT.ordinal()] = 3;
            s0.a.a[v.NARROW.ordinal()] = 4;
        }
    }

    private static class b implements x {
        b(net.time4j.s0.a s0$a) {
            super();
        }

        private static String F(String string, String string2, String string3, v v4, n n5) {
            int obj2;
            int i = s0.a.a[v4.ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                        } else {
                            obj2 = new StringBuilder();
                            obj2.append("{0}");
                            obj2.append(string3);
                            return obj2.toString();
                        }
                        obj2 = new UnsupportedOperationException(v4.name());
                        throw obj2;
                    }
                }
                return s0.b.G(string2, n5);
            }
            return s0.b.G(string, n5);
        }

        private static String G(String string, n n2) {
            String obj3;
            obj3 = n2 == n.ONE ? "" : "s";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{0} ");
            stringBuilder.append(string);
            stringBuilder.append(obj3);
            return stringBuilder.toString();
        }

        private static String H(String string, boolean z2, n n3) {
            String obj3;
            obj3 = n3 == n.ONE ? "" : "s";
            if (z2) {
                StringBuilder obj2 = new StringBuilder();
                obj2.append("in {0} ");
                obj2.append(string);
                obj2.append(obj3);
                return obj2.toString();
            }
            obj2 = new StringBuilder();
            obj2.append("{0} ");
            obj2.append(string);
            obj2.append(obj3);
            obj2.append(" ago");
            return obj2.toString();
        }

        private static String I(String string, boolean z2) {
            String obj2;
            StringBuilder stringBuilder = new StringBuilder();
            obj2 = z2 ? "+" : "-";
            stringBuilder.append(obj2);
            stringBuilder.append("{0} ");
            stringBuilder.append(string);
            return stringBuilder.toString();
        }

        private static String J(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{0} ");
            stringBuilder.append(string);
            return stringBuilder.toString();
        }

        @Override // net.time4j.g1.x
        public String A(Locale locale, v v2, n n3) {
            String str2 = "µs";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("microsecond", "µsec", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String B(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("minute", z2, n3);
            }
            return s0.b.I("min", z2);
        }

        @Override // net.time4j.g1.x
        public String C(Locale locale, v v2, n n3) {
            String str2 = "y";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("year", "yr", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String a(Locale locale, v v2, n n3) {
            String str2 = "s";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("second", "sec", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String c(Locale locale, v v2, n n3) {
            String str2 = "m";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("month", "mth", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String e(Locale locale) {
            return "now";
        }

        @Override // net.time4j.g1.x
        public String f(Locale locale, v v2, n n3) {
            String str2 = "ns";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("nanosecond", "nsec", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String g(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("second", z2, n3);
            }
            return s0.b.I("s", z2);
        }

        @Override // net.time4j.g1.x
        public String h(Locale locale, v v2, n n3) {
            String str2 = "min";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("minute", str2, "m", v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String i(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("month", z2, n3);
            }
            return s0.b.I("m", z2);
        }

        @Override // net.time4j.g1.x
        public String j(Locale locale, v v2, n n3) {
            String str2 = "h";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("hour", "hr", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String l(Locale locale, v v2, n n3) {
            String str2 = "ms";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("millisecond", "msec", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String o(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("hour", z2, n3);
            }
            return s0.b.I("h", z2);
        }

        @Override // net.time4j.g1.x
        public String p(Locale locale, v v2, n n3) {
            String str2 = "d";
            if (locale.getLanguage().equals("en")) {
                String obj2 = "day";
                return s0.b.F(obj2, obj2, str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String q(Locale locale, v v2, int i3) {
            int str;
            int obj3;
            if (i3 < 2) {
            } else {
                StringBuilder obj2 = new StringBuilder(i3 * 5);
                obj3 = 0;
                while (obj3 < i3) {
                    obj2.append('{');
                    obj2.append(obj3);
                    obj2.append('}');
                    if (obj3 < i3 + -1) {
                    }
                    obj3++;
                    obj2.append(", ");
                }
                return obj2.toString();
            }
            obj2 = new IllegalArgumentException("Size must be greater than 1.");
            throw obj2;
        }

        @Override // net.time4j.g1.x
        public String r(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("day", z2, n3);
            }
            return s0.b.I("d", z2);
        }

        @Override // net.time4j.g1.x
        public String s(Locale locale, v v2, n n3) {
            String str2 = "w";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("week", "wk", str2, v2, n3);
            }
            return s0.b.J(str2);
        }

        @Override // net.time4j.g1.x
        public String t(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("week", z2, n3);
            }
            return s0.b.I("w", z2);
        }

        @Override // net.time4j.g1.x
        public String x(Locale locale, boolean z2, n n3) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("year", z2, n3);
            }
            return s0.b.I("y", z2);
        }
    }
    static {
        net.time4j.s0.b bVar;
        int next;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        s0.i = concurrentHashMap;
        net.time4j.x[] arr = new x[10];
        s0.j = arr;
        bVar = new s0.b(0);
        s0.l = bVar;
        Iterator iterator = d.c().g(x.class).iterator();
        if (iterator.hasNext()) {
            next = iterator.next();
        }
        if (next == 0) {
        } else {
            bVar = next;
        }
        s0.k = bVar;
    }

    private s0(Locale locale) {
        Object obj;
        boolean unmodifiableMap;
        n[] values2;
        int i9;
        Class<net.time4j.x0> valueOf;
        int values;
        n[] values3;
        Class<v> unmodifiableMap2;
        int i;
        Object cast;
        Class<n> obj3;
        boolean values5;
        net.time4j.x[] objArr5;
        v[] values4;
        int i3;
        HashMap length3;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap;
        int length4;
        int length;
        int length2;
        int i10;
        int i6;
        int i8;
        EnumMap enumMap;
        int i7;
        net.time4j.x xVar;
        n[] objArr3;
        net.time4j.x[] objArr4;
        int i2;
        Class<net.time4j.x0> obj2;
        int i4;
        v[] objArr2;
        HashMap map;
        Class<v> obj5;
        Class<v> obj4;
        int i5;
        n[] objArr;
        obj = this;
        final Locale locale2 = locale;
        valueOf = x0.class;
        unmodifiableMap2 = v.class;
        obj3 = n.class;
        super();
        int i12 = 10;
        HashMap hashMap4 = new HashMap(i12);
        hashMap2 = new HashMap(i12);
        hashMap3 = new HashMap(i12);
        HashMap hashMap5 = new HashMap(i12);
        HashMap hashMap6 = new HashMap(i12);
        hashMap = new HashMap(i12);
        length = objArr5.length;
        i7 = 0;
        while (i7 < length) {
            xVar = objArr5[i7];
            enumMap = new EnumMap(unmodifiableMap2);
            length2 = values4.length;
            values = 0;
            while (values < length2) {
                v vVar = values4[values];
                EnumMap enumMap9 = new EnumMap(obj3);
                length4 = values2.length;
                i = 0;
                while (i < length4) {
                    n nVar = values2[i];
                    enumMap9.put(nVar, s0.e(locale2, xVar, vVar, nVar));
                    i++;
                    length4 = i5;
                    values2 = objArr;
                }
                enumMap.put(vVar, Collections.unmodifiableMap(enumMap9));
                values++;
                obj = this;
                length2 = i4;
                values4 = objArr2;
                hashMap = map;
                unmodifiableMap2 = obj5;
                nVar = values2[i];
                enumMap9.put(nVar, s0.e(locale2, xVar, vVar, nVar));
                i++;
                length4 = i5;
                values2 = objArr;
            }
            hashMap4.put(xVar, Collections.unmodifiableMap(enumMap));
            if (!Character.isDigit(xVar.getSymbol())) {
            }
            i7++;
            obj = this;
            objArr5 = objArr4;
            length = i2;
            valueOf = obj2;
            hashMap = map;
            unmodifiableMap2 = obj5;
            EnumMap enumMap2 = new EnumMap(obj3);
            n[] values6 = n.values();
            i3 = 0;
            while (i3 < values6.length) {
                hashMap = values6[i3];
                length2 = 0;
                enumMap2.put(hashMap, s0.f(locale2, xVar, length2, length2, hashMap));
                i3++;
            }
            hashMap2.put(xVar, Collections.unmodifiableMap(enumMap2));
            EnumMap enumMap3 = new EnumMap(obj3);
            n[] values7 = n.values();
            i10 = 0;
            values4 = 1;
            while (i10 < values7.length) {
                hashMap = values7[i10];
                enumMap3.put(hashMap, s0.f(locale2, xVar, null, values4, hashMap));
                i10++;
                values4 = 1;
            }
            hashMap5.put(xVar, Collections.unmodifiableMap(enumMap3));
            EnumMap enumMap4 = new EnumMap(obj3);
            i6 = 0;
            while (i6 < values3.length) {
                hashMap = values3[i6];
                enumMap4.put(hashMap, s0.f(locale2, xVar, values4, null, hashMap));
                i6++;
                values3 = objArr3;
            }
            hashMap3.put(xVar, Collections.unmodifiableMap(enumMap4));
            EnumMap enumMap5 = new EnumMap(obj3);
            values = n.values();
            length2 = enumMap;
            while (length2 < values.length) {
                hashMap = values[length2];
                enumMap5.put(hashMap, s0.f(locale2, xVar, values4, values4, hashMap));
                length2++;
                enumMap = 0;
            }
            hashMap6.put(xVar, Collections.unmodifiableMap(enumMap5));
            hashMap = values[length2];
            enumMap5.put(hashMap, s0.f(locale2, xVar, values4, values4, hashMap));
            length2++;
            enumMap = 0;
            hashMap = values3[i6];
            enumMap4.put(hashMap, s0.f(locale2, xVar, values4, null, hashMap));
            i6++;
            values3 = objArr3;
            hashMap = values7[i10];
            enumMap3.put(hashMap, s0.f(locale2, xVar, null, values4, hashMap));
            i10++;
            hashMap = values6[i3];
            length2 = 0;
            enumMap2.put(hashMap, s0.f(locale2, xVar, length2, length2, hashMap));
            i3++;
            vVar = values4[values];
            enumMap9 = new EnumMap(obj3);
            length4 = values2.length;
            i = 0;
            while (i < length4) {
                nVar = values2[i];
                enumMap9.put(nVar, s0.e(locale2, xVar, vVar, nVar));
                i++;
                length4 = i5;
                values2 = objArr;
            }
            enumMap.put(vVar, Collections.unmodifiableMap(enumMap9));
            values++;
            obj = this;
            length2 = i4;
            values4 = objArr2;
            hashMap = map;
            unmodifiableMap2 = obj5;
            nVar = values2[i];
            enumMap9.put(nVar, s0.e(locale2, xVar, vVar, nVar));
            i++;
            length4 = i5;
            values2 = objArr;
        }
        obj4 = unmodifiableMap2;
        HashMap map2 = hashMap;
        i9 = 2;
        while (i9 <= 7) {
            valueOf = Integer.valueOf(i9);
            obj3 = obj4;
            EnumMap enumMap7 = new EnumMap(obj3);
            v[] values9 = v.values();
            length = 0;
            while (length < values9.length) {
                enumMap = values9[length];
                enumMap7.put(enumMap, s0.g(locale2, enumMap, valueOf.intValue()));
                length++;
            }
            map2.put(valueOf, Collections.unmodifiableMap(enumMap7));
            i9++;
            obj4 = obj3;
            enumMap = values9[length];
            enumMap7.put(enumMap, s0.g(locale2, enumMap, valueOf.intValue()));
            length++;
        }
        Object obj6 = this;
        obj6.a = Collections.unmodifiableMap(hashMap4);
        obj6.b = Collections.unmodifiableMap(hashMap2);
        obj6.c = Collections.unmodifiableMap(hashMap3);
        obj6.d = Collections.unmodifiableMap(hashMap5);
        obj6.e = Collections.unmodifiableMap(hashMap6);
        obj6.f = Collections.unmodifiableMap(map2);
        Class<net.time4j.x0> obj7 = obj9;
        EnumMap enumMap6 = new EnumMap(obj7);
        EnumMap enumMap8 = new EnumMap(obj7);
        net.time4j.x0[] values8 = x0.values();
        i8 = 0;
        while (i8 < values8.length) {
            length3 = values8[i8];
            hashMap2 = "";
            enumMap6.put(length3, hashMap2);
            enumMap8.put(length3, hashMap2);
            i8++;
        }
        cast = s0.k;
        cast.e(locale2);
        if (cast instanceof r) {
            cast = r.class.cast(cast);
            (r)cast.d(locale2);
            cast.k(locale2);
            cast.n(locale2);
            values5 = x0.values();
            enumMap = 0;
            while (enumMap < values5.length) {
                hashMap2 = values5[enumMap];
                enumMap6.put(hashMap2, cast.z(hashMap2, locale2));
                enumMap8.put(hashMap2, cast.y(hashMap2, locale2));
                enumMap++;
            }
        }
        obj6.g = Collections.unmodifiableMap(enumMap6);
        obj6.h = Collections.unmodifiableMap(enumMap8);
    }

    private static void a(n n) {
        Objects.requireNonNull(n, "Missing plural category.");
    }

    private static void b(v v, n n2) {
        Objects.requireNonNull(v, "Missing text width.");
        s0.a(n2);
    }

    private static char c(net.time4j.x x) {
        if (x == h.MINUTES) {
            return 78;
        }
        return x.getSymbol();
    }

    private static String e(Locale locale, net.time4j.x x2, v v3, n n4) {
        try {
            return s0.h(s0.k, locale, s0.c(x2), v3, n4);
            x2 = s0.c(x2);
            locale = s0.h(s0.l, locale, x2, v3, n4);
            return locale;
        }
    }

    private static String f(Locale locale, net.time4j.x x2, boolean z3, boolean z4, n n5) {
        try {
            return s0.i(s0.k, locale, s0.c(x2), z3, z4, n5);
            locale = s0.i(s0.l, locale, s0.c(x2), z3, z4, n5);
            return locale;
        }
    }

    private static String g(Locale locale, v v2, int i3) {
        try {
            return s0.k.q(locale, v2, i3);
            locale = s0.l.q(locale, v2, i3);
            return locale;
        }
    }

    private static String h(x x, Locale locale2, char c3, v v4, n n5) {
        if (c3 != 51 && c3 != 54 && c3 != 57 && c3 != 68 && c3 != 72 && c3 != 83 && c3 != 87 && c3 != 89 && c3 != 77) {
            if (c3 != 54) {
                if (c3 != 57) {
                    if (c3 != 68) {
                        if (c3 != 72) {
                            if (c3 != 83) {
                                if (c3 != 87) {
                                    if (c3 != 89) {
                                        if (c3 != 77) {
                                            if (c3 != 78) {
                                            } else {
                                                return x.h(locale2, v4, n5);
                                            }
                                            StringBuilder obj2 = new StringBuilder();
                                            obj2.append("Unit-ID: ");
                                            obj2.append(c3);
                                            UnsupportedOperationException obj1 = new UnsupportedOperationException(obj2.toString());
                                            throw obj1;
                                        }
                                        return x.c(locale2, v4, n5);
                                    }
                                    return x.C(locale2, v4, n5);
                                }
                                return x.s(locale2, v4, n5);
                            }
                            return x.a(locale2, v4, n5);
                        }
                        return x.j(locale2, v4, n5);
                    }
                    return x.p(locale2, v4, n5);
                }
                return x.f(locale2, v4, n5);
            }
            return x.A(locale2, v4, n5);
        }
        return x.l(locale2, v4, n5);
    }

    private static String i(x x, Locale locale2, char c3, boolean z4, boolean z5, n n6) {
        boolean obj12;
        final String str = "Unit-ID: ";
        final int i = 78;
        final int i2 = 77;
        final int i3 = 89;
        final int i4 = 87;
        final int i5 = 83;
        final int i6 = 72;
        final int i7 = 68;
        Object obj8 = r.class.cast(x);
        if (z5 && x instanceof r && c3 != i7 && c3 != i6 && c3 != i5 && c3 != i4 && c3 != i3 && c3 != i2) {
            if (x instanceof r) {
                obj8 = r.class.cast(x);
                if (c3 != i7) {
                    if (c3 != i6) {
                        if (c3 != i5) {
                            if (c3 != i4) {
                                if (c3 != i3) {
                                    if (c3 != i2) {
                                        if (c3 != i) {
                                        } else {
                                            return (r)(r)obj8.E(locale2, z4, n6);
                                        }
                                        StringBuilder obj9 = new StringBuilder();
                                        obj9.append(str);
                                        obj9.append(c3);
                                        obj8 = new UnsupportedOperationException(obj9.toString());
                                        throw obj8;
                                    }
                                    return obj8.D(locale2, z4, n6);
                                }
                                return obj8.m(locale2, z4, n6);
                            }
                            return obj8.v(locale2, z4, n6);
                        }
                        return obj8.w(locale2, z4, n6);
                    }
                    return obj8.b(locale2, z4, n6);
                }
                return obj8.u(locale2, z4, n6);
            }
        }
        if (c3 != i7 && c3 != i6 && c3 != i5 && c3 != i4 && c3 != i3 && c3 != i2) {
            if (c3 != i6) {
                if (c3 != i5) {
                    if (c3 != i4) {
                        if (c3 != i3) {
                            if (c3 != i2) {
                                if (c3 != i) {
                                } else {
                                    return x.B(locale2, z4, n6);
                                }
                                obj9 = new StringBuilder();
                                obj9.append(str);
                                obj9.append(c3);
                                obj8 = new UnsupportedOperationException(obj9.toString());
                                throw obj8;
                            }
                            return x.i(locale2, z4, n6);
                        }
                        return x.x(locale2, z4, n6);
                    }
                    return x.t(locale2, z4, n6);
                }
                return x.g(locale2, z4, n6);
            }
            return x.o(locale2, z4, n6);
        }
        return x.r(locale2, z4, n6);
    }

    static net.time4j.s0 j(Locale locale) {
        Object s0Var;
        Object obj2;
        Objects.requireNonNull(locale, "Missing language.");
        ConcurrentMap map = s0.i;
        s0Var = new s0(locale);
        obj2 = map.putIfAbsent(locale, s0Var);
        if ((s0)map.get(locale) == null && (s0)obj2 != null) {
            s0Var = new s0(locale);
            obj2 = map.putIfAbsent(locale, s0Var);
            if ((s0)(s0)obj2 != null) {
                s0Var = obj2;
            }
        }
        return s0Var;
    }

    String d(v v, n n2, net.time4j.x x3) {
        s0.b(v, n2);
        return (String)(Map)(Map)this.a.get(x3).get(v).get(n2);
    }
}
