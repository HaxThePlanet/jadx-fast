package net.time4j;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.d;
import net.time4j.g1.n;
import net.time4j.g1.r;
import net.time4j.g1.v;
import net.time4j.g1.x;

/* compiled from: UnitPatterns.java */
/* loaded from: classes3.dex */
final class s0 {

    private static final ConcurrentMap<Locale, s0> i = new ConcurrentHashMap<>();
    private static final x[] j;
    private static final x k;
    private static final x l = new s0$b(0);
    private final Map<x, Map<v, Map<n, String>>> a;
    private final Map<x, Map<n, String>> b;
    private final Map<x, Map<n, String>> c;
    private final Map<x, Map<n, String>> d;
    private final Map<x, Map<n, String>> e;
    private final Map<Integer, Map<v, String>> f;
    private final Map<x0, String> g;
    private final Map<x0, String> h;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[v.values().length];
            s0.a.a = iArr;
            try {
                iArr[v.WIDE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[v.ABBREVIATED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[v.SHORT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[v.NARROW.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class b implements x {
        private b() {
            super();
        }

        private static String F(String str, String str2, String str3, v vVar, n nVar) {
            int i2 = s0.a.a[vVar.ordinal()];
            if (s0.a.a != 1 && s0.a.a != 2) {
                int i = 3;
                if (s0.a.a != 3 && s0.a.a == 4) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str7 = "{0}";
                    str6 = str7 + str3;
                    return str6;
                }
                return s0.b.G(str2, nVar);
            }
            return s0.b.G(str, nVar);
        }

        private static String G(String str, n nVar) {
            String str2;
            nVar = nVar == n.ONE ? "" : "s";
            StringBuilder stringBuilder = new StringBuilder();
            final String str3 = "{0} ";
            str4 = str3 + str + nVar;
            return str3 + str + (nVar == n.ONE ? "" : "s");
        }

        private static String H(String str, boolean z, n nVar) {
            String str2;
            nVar = nVar == n.ONE ? "" : "s";
            if (z) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = "in {0} ";
                str7 = str4 + str + str2;
                return str7;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "{0} ";
            String str5 = " ago";
            str6 = str3 + str + str2 + str5;
            return str6;
        }

        private static String I(String str, boolean z) {
            String str2;
            final StringBuilder stringBuilder = new StringBuilder();
            z = z ? "+" : "-";
            stringBuilder.append((z ? "+" : "-"));
            stringBuilder.append((z ? "+" : "-"));
            stringBuilder.append(str);
            return stringBuilder.toString();
        }

        private static String J(String str) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "{0} ";
            str3 = str2 + str;
            return str3;
        }

        public String A(Locale locale, v vVar, n nVar) {
            String str2 = "µs";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("microsecond", "µsec", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String B(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("minute", z, nVar);
            }
            return s0.b.I("min", z);
        }

        public String C(Locale locale, v vVar, n nVar) {
            String str2 = "y";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("year", "yr", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String a(Locale locale, v vVar, n nVar) {
            String str2 = "s";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("second", "sec", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String c(Locale locale, v vVar, n nVar) {
            String str2 = "m";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("month", "mth", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String f(Locale locale, v vVar, n nVar) {
            String str2 = "ns";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("nanosecond", "nsec", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String g(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("second", z, nVar);
            }
            return s0.b.I("s", z);
        }

        public String h(Locale locale, v vVar, n nVar) {
            String str2 = "min";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("minute", str2, "m", vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String i(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("month", z, nVar);
            }
            return s0.b.I("m", z);
        }

        public String j(Locale locale, v vVar, n nVar) {
            String str2 = "h";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("hour", "hr", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String l(Locale locale, v vVar, n nVar) {
            String str2 = "ms";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("millisecond", "msec", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String o(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("hour", z, nVar);
            }
            return s0.b.I("h", z);
        }

        public String p(Locale locale, v vVar, n nVar) {
            String str2 = "d";
            if (locale.getLanguage().equals("en")) {
                String str3 = "day";
                return s0.b.F(str3, str3, str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String q(Locale locale, v vVar, int i) {
            int i2 = 0;
            if (i < 2) {
                throw new IllegalArgumentException("Size must be greater than 1.");
            } else {
                StringBuilder stringBuilder = new StringBuilder(i * 5);
                i2 = 0;
                while (i2 < i) {
                    stringBuilder.append('{');
                    stringBuilder.append(i2);
                    stringBuilder.append('}');
                    i = i - 1;
                    i2 = i2 + 1;
                }
                return stringBuilder.toString();
            }
        }

        public String r(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("day", z, nVar);
            }
            return s0.b.I("d", z);
        }

        public String s(Locale locale, v vVar, n nVar) {
            String str2 = "w";
            if (locale.getLanguage().equals("en")) {
                return s0.b.F("week", "wk", str2, vVar, nVar);
            }
            return s0.b.J(str2);
        }

        public String t(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("week", z, nVar);
            }
            return s0.b.I("w", z);
        }

        public String x(Locale locale, boolean z, n nVar) {
            if (locale.getLanguage().equals("en")) {
                return s0.b.H("year", z, nVar);
            }
            return s0.b.I("y", z);
        }

        /* synthetic */ b(s0.a aVar) {
            this();
        }

        public String e(Locale locale) {
            return "now";
        }
    }
    static {
        net.time4j.x[] arr;
        int i = 0;
        arr = new x[10];
        s0.j = new x[] { f.YEARS, f.MONTHS, f.WEEKS, f.DAYS, h.HOURS, h.MINUTES, h.SECONDS, h.MILLIS, h.MICROS, h.NANOS };
        i = 0;
        Iterator it = d.c().g(x.class).iterator();
        if (it.hasNext()) {
            Object item = it.next();
        }
        if (h.NANOS != 0) {
        }
        s0.k = arr;
    }

    private s0(Locale locale) {
        Object obj;
        n[] values;
        int i = 2;
        Class<net.time4j.x0> num;
        int i2 = 0;
        n[] values2;
        Class obj2;
        int i3 = 0;
        net.time4j.x[] objArr;
        v[] values3;
        int i4 = 0;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        int length;
        int length2;
        int length3;
        int i5 = 0;
        int i6 = 0;
        int i8 = 0;
        EnumMap enumMap;
        v vVar;
        int i9 = 0;
        int i10 = 0;
        obj = this;
        final Locale locale2 = locale;
        num = x0.class;
        obj2 = v.class;
        obj2 = n.class;
        super();
        int i12 = 10;
        HashMap hashMap4 = new HashMap(i12);
        hashMap2 = new HashMap(i12);
        hashMap3 = new HashMap(i12);
        final HashMap hashMap5 = new HashMap(i12);
        final HashMap hashMap6 = new HashMap(i12);
        hashMap = new HashMap(i12);
        length2 = s0.j.length;
        i10 = 0;
        for (net.time4j.x xVar2 : values3) {
            enumMap = new EnumMap(obj2);
            length3 = v.values().length;
            for (v vVar2 : values3) {
                EnumMap enumMap9 = new EnumMap(obj2);
                length = n.values().length;
                while (i3 < length) {
                    n nVar = values[i3];
                    enumMap9.put(nVar, s0.e(locale2, xVar2, vVar2, nVar));
                    i3 = i3 + 1;
                }
                enumMap.put(vVar2, Collections.unmodifiableMap(enumMap9));
                obj = this;
                nVar = values[i3];
                enumMap9.put(nVar, s0.e(locale2, xVar2, vVar2, nVar));
                i3 = i3 + 1;
            }
            hashMap4.put(xVar2, Collections.unmodifiableMap(enumMap));
            obj = this;
            v vVar2 = values3[i2];
            enumMap9 = new EnumMap(obj2);
            length = n.values().length;
            i3 = 0;
            while (i3 < length) {
                nVar = values[i3];
                enumMap9.put(nVar, s0.e(locale2, xVar2, vVar2, nVar));
                i3 = i3 + 1;
            }
            enumMap.put(vVar2, Collections.unmodifiableMap(enumMap9));
            i2 = i2 + 1;
            obj = this;
            nVar = values[i3];
            enumMap9.put(nVar, s0.e(locale2, xVar2, vVar2, nVar));
            i3 = i3 + 1;
        }
        i = 2;
        while (i <= 7) {
            num = Integer.valueOf(i);
            EnumMap enumMap7 = new EnumMap(obj2);
            v[] values9 = v.values();
            hashMap = values9.length;
            length2 = 0;
            for (v vVar : values9) {
                enumMap7.put(vVar, s0.g(locale2, vVar, num.intValue()));
            }
            hashMap.put(num, Collections.unmodifiableMap(enumMap7));
            i = i + 1;
            vVar = values9[length2];
            enumMap7.put(vVar, s0.g(locale2, vVar, num.intValue()));
            length2 = length2 + 1;
        }
        obj = this;
        obj.a = Collections.unmodifiableMap(hashMap4);
        obj.b = Collections.unmodifiableMap(hashMap2);
        obj.c = Collections.unmodifiableMap(hashMap3);
        obj.d = Collections.unmodifiableMap(hashMap5);
        obj.e = Collections.unmodifiableMap(hashMap6);
        obj.f = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap6 = new EnumMap(num);
        EnumMap enumMap8 = new EnumMap(num);
        net.time4j.x0[] values7 = x0.values();
        i8 = 0;
        for (HashMap hashMap : values7) {
            hashMap2 = "";
            enumMap6.put(hashMap, hashMap2);
            enumMap8.put(hashMap, hashMap2);
        }
        try {
            xVar = s0.k;
            xVar.e(locale2);
            z = xVar instanceof r;
            Object cast = r.class.cast(xVar);
            cast.d(locale2);
            cast.k(locale2);
            cast.n(locale2);
            net.time4j.x0[] values8 = x0.values();
            i9 = 0;
            Object obj4 = values8[i9];
            enumMap6.put(obj4, cast.z(obj4, locale2));
            enumMap8.put(obj4, cast.y(obj4, locale2));
        } catch (java.util.MissingResourceException unused) {
            s0.l.e(locale3);
        }
        obj.g = Collections.unmodifiableMap(enumMap6);
        obj.h = Collections.unmodifiableMap(enumMap8);
    }

    private static void a(n nVar) {
        Objects.requireNonNull(nVar, "Missing plural category.");
    }

    private static void b(v vVar, n nVar) {
        Objects.requireNonNull(vVar, "Missing text width.");
        s0.a(nVar);
    }

    private static char c(x xVar) {
        if (xVar == h.MINUTES) {
            return 78;
        }
        return xVar.getSymbol();
    }

    private static String e(Locale locale, x xVar, v vVar, n nVar) {
        try {
        } catch (java.util.MissingResourceException unused) {
            xVar = s0.c(xVar);
            locale = s0.h(s0.l, locale, xVar, vVar, nVar);
            return locale;
        }
        return s0.h(s0.k, locale, s0.c(xVar), vVar, nVar);
    }

    private static String f(Locale locale, x xVar, boolean z, boolean z2, n nVar) {
        try {
        } catch (java.util.MissingResourceException unused) {
            locale = s0.i(s0.l, locale, s0.c(xVar), z, z2, nVar);
            return locale;
        }
        return s0.i(s0.k, locale, s0.c(xVar), z, z2, nVar);
    }

    private static String g(Locale locale, v vVar, int i) {
        try {
        } catch (java.util.MissingResourceException unused) {
            locale = s0.l.q(locale, vVar, i);
            return locale;
        }
        return s0.k.q(locale, vVar, i);
    }

    private static String h(x xVar, Locale locale, char c, v vVar, n nVar) {
        if (c != 51 && c != 54) {
            if (c != 57 && c != 68) {
                if (c != 72 && c != 83) {
                    if (c != 87 && c != 89) {
                        if (c != 77 && c == 78) {
                            return xVar.h(locale, vVar, nVar);
                        }
                        return xVar.c(locale, vVar, nVar);
                    }
                    return xVar.s(locale, vVar, nVar);
                }
                return xVar.j(locale, vVar, nVar);
            }
            return xVar.f(locale, vVar, nVar);
        }
        return xVar.l(locale, vVar, nVar);
    }

    private static String i(x xVar, Locale locale, char c, boolean z, boolean z2, n nVar) {
        final String str = "Unit-ID: ";
        c = 'N';
        final char c2 = 'M';
        final char c4 = 'Y';
        final char c5 = 'W';
        final char c6 = 'S';
        final char c7 = 'H';
        final char c8 = 'D';
        if (z2 && xVar instanceof r) {
            Object cast = r.class.cast(xVar);
            if (c != c8 && c != c7) {
                if (c != c6 && c != c5) {
                    if (c != c4 && c != c2) {
                        if (c != c) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            locale = str + c;
                            throw new UnsupportedOperationException(locale);
                        } else {
                            return cast.E(locale, z, nVar);
                        }
                    }
                    return cast.m(locale, z, nVar);
                }
                return cast.w(locale, z, nVar);
            }
            return cast.u(locale, z, nVar);
        }
        if (c != c8 && c != c7) {
            if (c != c6 && c != c5) {
                if (c != c4 && c != c2) {
                    if (c != c) {
                        StringBuilder stringBuilder = new StringBuilder();
                        locale = str + c;
                        throw new UnsupportedOperationException(locale);
                    } else {
                        return xVar.B(locale, z, nVar);
                    }
                }
                return xVar.x(locale, z, nVar);
            }
            return xVar.g(locale, z, nVar);
        }
        return xVar.r(locale, z, nVar);
    }

    static s0 j(Locale locale) {
        Object locale2;
        Objects.requireNonNull(locale, "Missing language.");
        ConcurrentMap concurrentMap = s0.i;
        if ((s0)concurrentMap.get(locale) == null) {
            locale2 = s0.i.putIfAbsent(locale, new s0(locale));
            if (locale2 != null) {
            }
        }
        return locale2;
    }

    String d(v vVar, n nVar, x xVar) {
        s0.b(vVar, nVar);
        return (String)(Map)(Map)this.a.get(xVar).get(vVar).get(nVar);
    }
}
