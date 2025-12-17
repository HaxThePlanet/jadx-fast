package net.time4j.g1;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.p;
import net.time4j.engine.w;
import net.time4j.f1.d;
import net.time4j.g1.a0.c;
import net.time4j.g1.a0.d;
import net.time4j.h1.c;
import net.time4j.h1.e;

/* loaded from: classes3.dex */
public final class b {

    private static final Set<String> l;
    private static final net.time4j.g1.f m;
    private static final net.time4j.g1.u n;
    private static final net.time4j.g1.u o;
    private static final ConcurrentMap<String, net.time4j.g1.b> p;
    private final String a;
    private final Map<net.time4j.g1.v, Map<net.time4j.g1.m, net.time4j.g1.s>> b;
    private final Map<net.time4j.g1.v, Map<net.time4j.g1.m, net.time4j.g1.s>> c;
    private final Map<net.time4j.g1.v, Map<net.time4j.g1.m, net.time4j.g1.s>> d;
    private final Map<net.time4j.g1.v, Map<net.time4j.g1.m, net.time4j.g1.s>> e;
    private final Map<net.time4j.g1.v, Map<net.time4j.g1.m, net.time4j.g1.s>> f;
    private final Map<net.time4j.g1.v, net.time4j.g1.s> g;
    private final Map<String, String> h;
    private final String i;
    private final Locale j;
    private final MissingResourceException k;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            b.a.b = iArr;
            int i2 = 1;
            iArr[e.FULL.ordinal()] = i2;
            int i = 2;
            b.a.b[e.LONG.ordinal()] = i;
            int i3 = 3;
            b.a.b[e.MEDIUM.ordinal()] = i3;
            int i4 = 4;
            b.a.b[e.SHORT.ordinal()] = i4;
            int[] iArr8 = new int[values2.length];
            b.a.a = iArr8;
            iArr8[v.WIDE.ordinal()] = i2;
            b.a.a[v.ABBREVIATED.ordinal()] = i;
            b.a.a[v.SHORT.ordinal()] = i3;
            b.a.a[v.NARROW.ordinal()] = i4;
        }
    }

    private static class b implements net.time4j.g1.u {
        b(net.time4j.g1.b.a b$a) {
            super();
        }

        @Override // net.time4j.g1.u
        public String[] b(String string, Locale locale2, net.time4j.g1.v v3) {
            if (v3 == v.NARROW) {
                return /* result */;
            }
            return /* result */;
        }

        @Override // net.time4j.g1.u
        public String[] c(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4) {
            return /* result */;
        }

        @Override // net.time4j.g1.u
        public String[] d(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4) {
            if (v3 == v.NARROW) {
                return /* result */;
            }
            return /* result */;
        }

        @Override // net.time4j.g1.u
        public boolean f(Locale locale) {
            return 1;
        }

        @Override // net.time4j.g1.u
        public boolean h(String string) {
            return 1;
        }

        @Override // net.time4j.g1.u
        public String[] i(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4) {
            if (v3 == v.NARROW) {
                return /* result */;
            }
            return /* result */;
        }

        @Override // net.time4j.g1.u
        public String[] j(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4, boolean z5) {
            if (v3 == v.WIDE) {
                return /* result */;
            }
            return /* result */;
        }

        @Override // net.time4j.g1.u
        public String toString() {
            return "FallbackProvider";
        }
    }

    private static class c implements net.time4j.g1.f {

        private final net.time4j.g1.f a;
        c(net.time4j.g1.f f) {
            super();
            this.a = f;
        }

        private static String b(DateFormat dateFormat) {
            if (!dateFormat instanceof SimpleDateFormat) {
            } else {
                return (SimpleDateFormat)SimpleDateFormat.class.cast(dateFormat).toPattern();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot retrieve format pattern: ");
            stringBuilder.append(dateFormat);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        private static int c(net.time4j.g1.e e) {
            int i = b.a.b[e.ordinal()];
            int i2 = 1;
            int i4 = 2;
            int i3 = 3;
            if (i != i2 && i != i4 && i != i3) {
                i4 = 2;
                if (i != i4) {
                    i3 = 3;
                    if (i != i3) {
                        if (i != 4) {
                        } else {
                            return i3;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown: ");
                        stringBuilder.append(e);
                        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
                        throw unsupportedOperationException;
                    }
                    return i4;
                }
                return i2;
            }
            return 0;
        }

        @Override // net.time4j.g1.f
        public String a(net.time4j.g1.e e, Locale locale2) {
            final net.time4j.g1.f fVar = this.a;
            if (fVar == null) {
                return b.c.b(DateFormat.getDateInstance(b.c.c(e), locale2));
            }
            return fVar.a(e, locale2);
        }

        @Override // net.time4j.g1.f
        public String e(net.time4j.g1.e e, Locale locale2) {
            Object cast;
            int i;
            String obj3;
            cast = this.a;
            if (cast == null) {
                obj3 = b.c.b(DateFormat.getTimeInstance(b.c.c(e), locale2));
            } else {
                if (cast instanceof c) {
                    obj3 = (c)c.class.cast(cast).g(e, locale2, true);
                } else {
                    obj3 = cast.e(e, locale2);
                }
            }
            return d.a(obj3);
        }

        @Override // net.time4j.g1.f
        public String k(net.time4j.g1.e e, net.time4j.g1.e e2, Locale locale3) {
            net.time4j.g1.f fVar = this.a;
            if (fVar == null) {
                return b.c.b(DateFormat.getDateTimeInstance(b.c.c(e), b.c.c(e2), locale3));
            }
            return this.a.k(e, e2, locale3).replace("{1}", this.a.a(e, locale3)).replace("{0}", fVar.e(e2, locale3));
        }
    }

    private static class d implements net.time4j.g1.u {
        d(net.time4j.g1.b.a b$a) {
            super();
        }

        private static String[] a(String[] stringArr, int i2) {
            int i;
            String valueOf;
            final String[] strArr = new String[i2];
            i = 0;
            while (i < i2) {
                if (!stringArr[i].isEmpty()) {
                } else {
                }
                strArr[i] = String.valueOf(i + 1);
                i++;
                strArr[i] = b.d.e(stringArr[i]);
            }
            return strArr;
        }

        private static String e(String string) {
            char charAt;
            int i3;
            int i4;
            int i2;
            int i;
            Object obj2;
            charAt = Normalizer.normalize(string, Normalizer.Form.NFD).charAt(0);
            if (charAt >= 65 && charAt <= 90) {
                if (charAt <= 90) {
                    return String.valueOf(charAt);
                }
            }
            if (charAt >= 97 && charAt <= 122) {
                if (charAt <= 122) {
                    return String.valueOf((char)i5);
                }
            }
            if (charAt >= 1040 && charAt <= 1071) {
                if (charAt <= 1071) {
                    return String.valueOf(charAt);
                }
            }
            if (charAt >= 1072 && charAt <= 1103) {
                if (charAt <= 1103) {
                    obj2 = String.valueOf((char)charAt);
                }
            }
            return obj2;
        }

        @Override // net.time4j.g1.u
        public String[] b(String string, Locale locale2, net.time4j.g1.v v3) {
            String valueOf;
            int length;
            int obj6;
            DateFormatSymbols obj4 = DateFormatSymbols.getInstance(locale2);
            if (v3 == v.NARROW) {
                obj4 = obj4.getEras();
                String[] obj5 = new String[obj4.length];
                obj6 = 0;
                while (obj6 < obj4.length) {
                    if (!obj4[obj6].isEmpty()) {
                    } else {
                    }
                    int i = 2;
                    if (obj6 == null && obj4.length == i) {
                    } else {
                    }
                    if (obj6 == 1 && obj4.length == i) {
                    } else {
                    }
                    obj5[obj6] = String.valueOf(obj6);
                    obj6++;
                    if (obj4.length == i) {
                    } else {
                    }
                    obj5[obj6] = "A";
                    if (obj4.length == i) {
                    } else {
                    }
                    obj5[obj6] = "B";
                    obj5[obj6] = b.d.e(obj4[obj6]);
                }
                return obj5;
            }
            return obj4.getEras();
        }

        @Override // net.time4j.g1.u
        public String[] c(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4) {
            int i;
            int i2;
            String[] obj6;
            int obj7;
            Object obj8;
            net.time4j.g1.m obj9;
            obj6 = DateFormatSymbols.getInstance(locale2);
            i = b.a.a[v3.ordinal()];
            int i3 = 2;
            final int i4 = 1;
            final int i5 = 7;
            if (i != i4) {
                if (i != i3 && i != 3) {
                    if (i != 3) {
                        if (i != 4) {
                        } else {
                            obj6 = b.d.a(c("", locale2, v.SHORT, m4), i5);
                        }
                        obj7 = new StringBuilder();
                        obj7.append("Unknown text width: ");
                        obj7.append(v3);
                        obj6 = new UnsupportedOperationException(obj7.toString());
                        throw obj6;
                    }
                }
                obj6 = obj6.getShortWeekdays();
            } else {
                obj6 = obj6.getWeekdays();
            }
            if (obj6.length > i5) {
                obj8 = new String[i5];
                i = 6;
                System.arraycopy(obj6, i3, obj8, 0, i);
                obj8[i] = obj6[i4];
                obj6 = obj8;
            }
            return obj6;
        }

        @Override // net.time4j.g1.u
        public String[] d(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4) {
            if (v3 == v.NARROW) {
                return /* result */;
            }
            return DateFormatSymbols.getInstance(locale2).getAmPmStrings();
        }

        @Override // net.time4j.g1.u
        public boolean f(Locale locale) {
            int i;
            boolean equals;
            final Locale[] availableLocales = DateFormatSymbols.getAvailableLocales();
            final int i2 = 0;
            i = i2;
            while (i < availableLocales.length) {
                i++;
            }
            return i2;
        }

        @Override // net.time4j.g1.u
        public boolean h(String string) {
            return "iso8601".equals(string);
        }

        @Override // net.time4j.g1.u
        public String[] i(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4) {
            return /* result */;
        }

        @Override // net.time4j.g1.u
        public String[] j(String string, Locale locale2, net.time4j.g1.v v3, net.time4j.g1.m m4, boolean z5) {
            int obj4;
            DateFormatSymbols obj1 = DateFormatSymbols.getInstance(locale2);
            int obj2 = b.a.a[v3.ordinal()];
            if (obj2 != 1 && obj2 != 2 && obj2 != 3) {
                if (obj2 != 2) {
                    if (obj2 != 3) {
                        if (obj2 != 4) {
                        } else {
                            return b.d.a(obj1.getShortMonths(), 12);
                        }
                        obj1 = new UnsupportedOperationException(v3.name());
                        throw obj1;
                    }
                }
                return obj1.getShortMonths();
            }
            return obj1.getMonths();
        }

        @Override // net.time4j.g1.u
        public String toString() {
            return "JDKTextProvider";
        }
    }
    static {
        Object cVar;
        HashSet hashSet = new HashSet();
        hashSet.add("ar");
        hashSet.add("dv");
        hashSet.add("fa");
        hashSet.add("ha");
        hashSet.add("he");
        hashSet.add("iw");
        hashSet.add("ji");
        hashSet.add("ps");
        hashSet.add("sd");
        hashSet.add("ug");
        hashSet.add("ur");
        hashSet.add("yi");
        b.l = Collections.unmodifiableSet(hashSet);
        Iterator iterator = d.c().g(f.class).iterator();
        if (iterator.hasNext()) {
            cVar = iterator.next();
        } else {
            cVar = new c();
        }
        b.c cVar2 = new b.c(cVar);
        b.m = cVar2;
        int i = 0;
        b.d dVar2 = new b.d(i);
        b.n = dVar2;
        b.b bVar = new b.b(i);
        b.o = bVar;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b.p = concurrentHashMap;
    }

    private b(String string, Locale locale2, net.time4j.g1.u u3) {
        int i5;
        Class<net.time4j.g1.m> obj;
        int i6;
        Map unmodifiableMap;
        net.time4j.g1.v[] values2;
        int length2;
        net.time4j.g1.v[] values;
        int length5;
        int i3;
        int length;
        int i;
        int i2;
        int enumMap3;
        net.time4j.g1.v enumMap;
        EnumMap enumMap2;
        net.time4j.g1.m[] length4;
        int length3;
        int sVar;
        net.time4j.g1.v[] objArr;
        int i4;
        final Object obj2 = this;
        final String str = string;
        final Locale locale = locale2;
        net.time4j.g1.u uVar = u3;
        obj = m.class;
        Class<net.time4j.g1.v> obj3 = v.class;
        super();
        obj2.a = u3.toString();
        i6 = 0;
        unmodifiableMap = Collections.unmodifiableMap(b.i(str, locale, uVar, i6));
        obj2.b = unmodifiableMap;
        Map map2 = b.i(str, locale, uVar, true);
        if (map2 == null) {
            obj2.c = unmodifiableMap;
        } else {
            obj2.c = Collections.unmodifiableMap(map2);
        }
        EnumMap enumMap7 = new EnumMap(obj3);
        length = values.length;
        enumMap3 = i6;
        while (enumMap3 < length) {
            enumMap = values[enumMap3];
            enumMap2 = new EnumMap(obj);
            length4 = m.values();
            sVar = i6;
            while (sVar < length4.length) {
                net.time4j.g1.m mVar = length4[sVar];
                s sVar3 = new s(uVar.i(str, locale, enumMap, mVar));
                enumMap2.put(mVar, sVar3);
                sVar++;
                values = objArr;
                length = i4;
                i6 = 0;
            }
            objArr = values;
            i4 = length;
            enumMap7.put(enumMap, enumMap2);
            enumMap3++;
            i6 = 0;
            mVar = length4[sVar];
            sVar3 = new s(uVar.i(str, locale, enumMap, mVar));
            enumMap2.put(mVar, sVar3);
            sVar++;
            values = objArr;
            length = i4;
            i6 = 0;
        }
        obj2.d = Collections.unmodifiableMap(enumMap7);
        EnumMap enumMap4 = new EnumMap(obj3);
        length5 = values2.length;
        i = 0;
        while (i < length5) {
            enumMap3 = values2[i];
            enumMap = new EnumMap(obj);
            enumMap2 = m.values();
            length3 = 0;
            while (length3 < enumMap2.length) {
                sVar = enumMap2[length3];
                s sVar2 = new s(uVar.c(str, locale, enumMap3, sVar));
                enumMap.put(sVar, sVar2);
                length3++;
                values2 = objArr;
                length5 = i4;
            }
            objArr = values2;
            i4 = length5;
            enumMap4.put(enumMap3, enumMap);
            i++;
            sVar = enumMap2[length3];
            sVar2 = new s(uVar.c(str, locale, enumMap3, sVar));
            enumMap.put(sVar, sVar2);
            length3++;
            values2 = objArr;
            length5 = i4;
        }
        obj2.e = Collections.unmodifiableMap(enumMap4);
        EnumMap enumMap5 = new EnumMap(obj3);
        net.time4j.g1.v[] values4 = v.values();
        i2 = 0;
        while (i2 < values4.length) {
            enumMap3 = values4[i2];
            enumMap = new s(uVar.b(str, locale, enumMap3));
            enumMap5.put(enumMap3, enumMap);
            i2++;
        }
        obj2.g = Collections.unmodifiableMap(enumMap5);
        EnumMap enumMap6 = new EnumMap(obj3);
        net.time4j.g1.v[] values3 = v.values();
        i3 = 0;
        while (i3 < values3.length) {
            i2 = values3[i3];
            enumMap3 = new EnumMap(obj);
            enumMap = m.values();
            length4 = 0;
            while (length4 < enumMap.length) {
                length3 = enumMap[length4];
                sVar = new s(uVar.d(str, locale, i2, length3));
                enumMap3.put(length3, sVar);
                length4++;
                obj = objArr;
            }
            objArr = obj;
            enumMap6.put(i2, enumMap3);
            i3++;
            length3 = enumMap[length4];
            sVar = new s(uVar.d(str, locale, i2, length3));
            enumMap3.put(length3, sVar);
            length4++;
            obj = objArr;
        }
        obj2.f = Collections.unmodifiableMap(enumMap6);
        HashMap hashMap = new HashMap();
        i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("calendar/names/");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(str);
        e eVar = e.h(stringBuilder.toString(), locale);
        Iterator iterator = eVar.g().iterator();
        for (String length2 : iterator) {
            hashMap.put(length2, eVar.f(length2));
        }
        obj2.h = Collections.unmodifiableMap(hashMap);
        obj2.i = str;
        obj2.j = locale;
        obj2.k = i5;
    }

    static String a(w<?> w) {
        String obj1;
        obj1 = w.l().getAnnotation(c.class);
        if ((c)obj1 == null) {
            obj1 = "iso8601";
        } else {
            obj1 = (c)obj1.value();
        }
        return obj1;
    }

    public static net.time4j.g1.b c(String string, Locale locale2) {
        int i;
        Object obj;
        boolean bVar;
        boolean iterator;
        Class<net.time4j.g1.u> next;
        boolean z;
        Object obj5;
        Objects.requireNonNull(string, "Missing calendar type.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(':');
        stringBuilder.append(locale2.getLanguage());
        String country = locale2.getCountry();
        if (!country.isEmpty()) {
            stringBuilder.append('-');
            stringBuilder.append(country);
        }
        String string2 = stringBuilder.toString();
        if ((b)b.p.get(string2) == null) {
            i = 0;
            if (locale2.getLanguage().isEmpty() && string.equals("iso8601")) {
                if (string.equals("iso8601")) {
                    i = b.o;
                } else {
                    iterator = d.c().g(u.class).iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((u)next.h(string)) {
                            break;
                        } else {
                        }
                        if (next.f(locale2)) {
                            break;
                        } else {
                        }
                    }
                    iterator = b.n;
                    if (i == 0 && iterator.h(string) && iterator.f(locale2)) {
                        iterator = b.n;
                        if (iterator.h(string)) {
                            if (iterator.f(locale2)) {
                                i = iterator;
                            }
                        }
                        if (i == 0) {
                            i = b.o;
                        }
                    }
                }
            } else {
            }
            bVar = new b(string, locale2, i);
            if ((b)b.p.putIfAbsent(string2, bVar) != null) {
            } else {
                obj = bVar;
            }
        }
        return obj;
    }

    public static net.time4j.g1.b d(Locale locale) {
        return b.c("iso8601", locale);
    }

    private String e(String string) {
        boolean equals;
        boolean equals2;
        String str;
        String obj3;
        str = "useShortKeys";
        if (this.h.containsKey(str) && "true".equals(this.h.get(str))) {
            if ("true".equals(this.h.get(str))) {
                if (!string.equals("MONTH_OF_YEAR") && !string.equals("DAY_OF_WEEK") && !string.equals("QUARTER_OF_YEAR")) {
                    if (!string.equals("DAY_OF_WEEK")) {
                        if (!string.equals("QUARTER_OF_YEAR")) {
                            if (string.equals("ERA")) {
                                obj3 = string.substring(0, 1);
                            } else {
                                if (string.equals("EVANGELIST")) {
                                    return "EV";
                                }
                                if (string.equals("SANSCULOTTIDES")) {
                                    return "S";
                                }
                                if (string.equals("DAY_OF_DECADE")) {
                                    return "D";
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        return obj3;
    }

    private static String f(String string, int i2, String... string3Arr3) {
        int i;
        int length;
        int i3;
        Object obj;
        int i4;
        int obj4;
        int i5 = 0;
        if (string3Arr3 != null && string3Arr3.length > 0 && string3Arr3.length < i2) {
            if (string3Arr3.length > 0) {
                if (string3Arr3.length < i2) {
                    return i5;
                }
                StringBuilder stringBuilder = new StringBuilder(string);
                obj4 = 0;
                i = 1;
                i3 = obj4;
                for (Object obj : string3Arr3) {
                    if (i != 0) {
                    } else {
                    }
                    stringBuilder.append('|');
                    stringBuilder.append(obj);
                    stringBuilder.append('(');
                    i = obj4;
                }
                if (i == 0) {
                    stringBuilder.append(')');
                }
                return stringBuilder.toString();
            }
        }
        if (i2 > 0) {
            obj4 = i5;
        }
        return obj4;
    }

    private static Map<net.time4j.g1.v, Map<net.time4j.g1.m, net.time4j.g1.s>> i(String string, Locale locale2, net.time4j.g1.u u3, boolean z4) {
        int i4;
        Class<net.time4j.g1.m> obj;
        net.time4j.g1.m[] objArr;
        EnumMap map;
        net.time4j.g1.v vVar2;
        int i;
        boolean z;
        EnumMap enumMap2;
        int i5;
        int i6;
        int length;
        net.time4j.g1.m[] values;
        EnumMap enumMap;
        net.time4j.g1.v vVar;
        int i3;
        net.time4j.g1.m mVar;
        int i2;
        enumMap2 = new EnumMap(v.class);
        final net.time4j.g1.v[] values2 = v.values();
        final int i7 = 0;
        i5 = i4;
        while (i5 < values2.length) {
            vVar = values2[i5];
            enumMap = new EnumMap(m.class);
            length = values.length;
            i6 = i4;
            i = i7;
            while (i < length) {
                net.time4j.g1.m mVar2 = values[i];
                mVar = mVar2;
                String[] strArr = u3.j(string, locale2, vVar, mVar2, z4);
                if (z4 && i6 == 0) {
                } else {
                }
                obj = length;
                objArr = values;
                map = enumMap;
                vVar2 = vVar;
                s sVar = new s(strArr);
                map.put(mVar, sVar);
                i = i2 + 1;
                length = obj;
                values = objArr;
                enumMap = map;
                vVar = vVar2;
                if (i6 == 0) {
                } else {
                }
                obj = length;
                objArr = values;
                map = enumMap;
                vVar2 = vVar;
                i6 = z;
            }
            enumMap2.put(vVar, enumMap);
            i5++;
            i4 = i6;
            mVar2 = values[i];
            mVar = mVar2;
            strArr = u3.j(string, locale2, vVar, mVar2, z4);
            if (z4 && i6 == 0) {
            } else {
            }
            obj = length;
            objArr = values;
            map = enumMap;
            vVar2 = vVar;
            sVar = new s(strArr);
            map.put(mVar, sVar);
            i = i2 + 1;
            length = obj;
            values = objArr;
            enumMap = map;
            vVar = vVar2;
            if (i6 == 0) {
            } else {
            }
            obj = length;
            objArr = values;
            map = enumMap;
            vVar2 = vVar;
            i6 = z;
        }
        if (z4) {
            if (i4 != 0) {
            } else {
                enumMap2 = 0;
            }
        }
        return enumMap2;
    }

    private net.time4j.g1.s j(net.time4j.g1.v v, net.time4j.g1.m m2, boolean z3) {
        if (z3) {
            return (s)(Map)this.c.get(v).get(m2);
        }
        return (s)(Map)this.b.get(v).get(m2);
    }

    public static boolean q(Locale locale) {
        return b.l.contains(locale.getLanguage());
    }

    public static String r(net.time4j.g1.e e, Locale locale2) {
        return b.m.a(e, locale2);
    }

    public static String s(net.time4j.g1.e e, net.time4j.g1.e e2, Locale locale3) {
        return b.m.k(e, e2, locale3);
    }

    public static String t(net.time4j.g1.e e, Locale locale2) {
        return b.m.e(e, locale2);
    }

    public static String u(net.time4j.g1.e e, net.time4j.g1.e e2, Locale locale3) {
        return d.a(b.m.k(e, e2, locale3));
    }

    private static String v(String string, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append('_');
        stringBuilder.append(i2 += i3);
        return stringBuilder.toString();
    }

    public net.time4j.g1.s b(net.time4j.g1.v v) {
        return (s)this.g.get(v);
    }

    public net.time4j.g1.s g(net.time4j.g1.v v, net.time4j.g1.m m2) {
        return j(v, m2, true);
    }

    public net.time4j.g1.s h(net.time4j.g1.v v, net.time4j.g1.m m2) {
        return (s)(Map)this.f.get(v).get(m2);
    }

    public net.time4j.g1.s k(net.time4j.g1.v v, net.time4j.g1.m m2) {
        return (s)(Map)this.d.get(v).get(m2);
    }

    public net.time4j.g1.s l(net.time4j.g1.v v, net.time4j.g1.m m2) {
        return j(v, m2, false);
    }

    public Map<String, String> m() {
        return this.h;
    }

    public <V extends Enum<V>> net.time4j.g1.s n(String string, Class<V> class2, String... string3Arr3) {
        int i3;
        String name;
        int i2;
        int i;
        String str;
        boolean key;
        if (this.k != null) {
        } else {
            Object[] enumConstants = class2.getEnumConstants();
            final int length = enumConstants.length;
            final String[] strArr = new String[length];
            int i4 = 0;
            i3 = i4;
            while (i3 < length) {
                i2 = 0;
                i = i4;
                str = b.f(e(string), i, string3Arr3);
                while (str != null) {
                    str = b.v(str, i3, obj12 ^= 1);
                    if (this.h.containsKey(str)) {
                        break loop_4;
                    } else {
                    }
                    i++;
                    str = b.f(str2, i, string3Arr3);
                }
                if (i2 == 0) {
                } else {
                }
                strArr[i3] = (String)this.h.get(i2);
                i3++;
                if (this.h.containsKey(string)) {
                } else {
                }
                strArr[i3] = (Enum[])enumConstants[i3].name();
                strArr[i3] = (String)this.h.get(string);
                str = b.v(str, i3, obj12);
                if (this.h.containsKey(str)) {
                } else {
                }
                i++;
                i2 = str;
            }
            s obj11 = new s(strArr);
            return obj11;
        }
        obj11 = new MissingResourceException(this.k.getMessage(), this.k.getClassName(), this.k.getKey());
        throw obj11;
    }

    public <V extends Enum<V>> net.time4j.g1.s o(p<V> p, String... string2Arr2) {
        return n(p.name(), p.getType(), string2Arr2);
    }

    public net.time4j.g1.s p(net.time4j.g1.v v, net.time4j.g1.m m2) {
        return (s)(Map)this.e.get(v).get(m2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("(");
        stringBuilder.append(this.i);
        stringBuilder.append("/");
        stringBuilder.append(this.j);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
