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
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.p;
import net.time4j.engine.w;
import net.time4j.h1.e;

/* compiled from: CalendarText.java */
/* loaded from: classes3.dex */
public final class b {

    private static final Set<String> l;
    private static final f m = new b$c();
    private static final u n = new b$d(0);
    private static final u o = new b$b(0);
    private static final ConcurrentMap<String, b> p = new ConcurrentHashMap<>();
    private final String a;
    private final Map<v, Map<m, s>> b;
    private final Map<v, Map<m, s>> c;
    private final Map<v, Map<m, s>> d;
    private final Map<v, Map<m, s>> e;
    private final Map<v, Map<m, s>> f;
    private final Map<v, s> g;
    private final Map<String, String> h;
    private final String i;
    private final Locale j;
    private final MissingResourceException k;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[e.values().length];
            b.a.b = iArr;
            int i2 = 1;
            try {
                iArr[e.FULL.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i4 = 4;
                int[] iArr8 = new int[v.values().length];
                b.a.a = iArr8;
                return;
            }
            int i = 2;
            try {
                b.a.b[e.LONG.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class b implements u {
        private b() {
            super();
        }

        public String[] b(String str, Locale locale, v vVar) {
            if (vVar == v.NARROW) {
                return new String[] { "B", "A" };
            }
            return new String[] { "BC", "AD" };
        }

        public String[] c(String str, Locale locale, v vVar, m mVar) {
            return new String[] { "1", "2", "3", "4", "5", "6", "7" };
        }

        public String[] d(String str, Locale locale, v vVar, m mVar) {
            if (vVar == v.NARROW) {
                return new String[] { "A", "P" };
            }
            return new String[] { "AM", "PM" };
        }

        public String[] i(String str, Locale locale, v vVar, m mVar) {
            if (vVar == v.NARROW) {
                return new String[] { "1", "2", "3", "4" };
            }
            return new String[] { "Q1", "Q2", "Q3", "Q4" };
        }

        public String[] j(String str, Locale locale, v vVar, m mVar, boolean z) {
            if (vVar == v.WIDE) {
                return new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13" };
            }
            return new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
        }

        /* synthetic */ b(b.a aVar) {
            this();
        }

        public boolean f(Locale locale) {
            return true;
        }

        public boolean h(String str) {
            return true;
        }

        @Override // java.lang.Object
        public String toString() {
            return "FallbackProvider";
        }
    }

    private static class c implements f {

        private final f a;
        c(f fVar) {
            super();
            this.a = fVar;
        }

        private static String b(DateFormat dateFormat) {
            if (!(dateFormat instanceof SimpleDateFormat)) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Cannot retrieve format pattern: ";
                dateFormat = str + dateFormat;
                throw new IllegalStateException(dateFormat);
            } else {
                return (SimpleDateFormat)SimpleDateFormat.class.cast(dateFormat).toPattern();
            }
        }

        private static int c(e eVar) {
            int i = b.a.b[eVar.ordinal()];
            int i2 = 1;
            if (b.a.b != i2 && b.a.b != i4) {
                int i3 = 3;
                if (b.a.b != i3 && b.a.b == 4) {
                    return i3;
                }
                return i4;
            }
            return 0;
        }

        public String a(e eVar, Locale locale) {
            if (this.a == null) {
                return b.c.b(DateFormat.getDateInstance(b.c.c(eVar), locale));
            }
            return this.a.a(eVar, locale);
        }

        public String e(e eVar, Locale locale) {
            String str;
            if (this.a == null) {
                str = b.c.b(DateFormat.getTimeInstance(b.c.c(eVar), locale));
            } else {
                z = fVar instanceof c;
                if (fVar instanceof c) {
                    boolean z = true;
                    str = (c)c.class.cast(this.a).g(eVar, locale, z);
                } else {
                    str = this.a.e(eVar, locale);
                }
            }
            return d.a(str);
        }

        public String k(e eVar, e eVar2, Locale locale) {
            if (this.a == null) {
                return b.c.b(DateFormat.getDateTimeInstance(b.c.c(eVar), b.c.c(eVar2), locale));
            }
            return this.a.k(eVar, eVar2, locale).replace("{1}", this.a.a(eVar, locale)).replace("{0}", this.a.e(eVar2, locale));
        }
    }

    private static class d implements u {
        private d() {
            super();
        }

        private static String[] a(String[] strArr, int i) {
            String str;
            final String[] strArr2 = new String[i];
            i = 0;
            while (i < i) {
                i = i + 1;
            }
            return strArr2;
        }

        private static String e(String str) {
            String str2;
            char charAt = Normalizer.normalize(str, Normalizer.Form.NFD).charAt(0);
            char c = 'A';
            if (charAt >= 'A' && charAt <= 'Z') {
                return String.valueOf(charAt);
            }
            char c2 = 'a';
            if (charAt >= 'a' && charAt <= 'z') {
                return String.valueOf((char)(charAt - 32));
            }
            char c3 = '\u0410';
            if (charAt >= '\u0410' && charAt <= '\u042f') {
                return String.valueOf(charAt);
            }
            char c4 = '\u0430';
            if (charAt >= '\u0430' && charAt <= '\u044f') {
                str2 = String.valueOf((char)(charAt - 32));
            }
            return str2;
        }

        public String[] b(String str, Locale locale, v vVar) {
            String str2;
            int length;
            int i = 0;
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            if (vVar == v.NARROW) {
                String[] eras2 = dateFormatSymbols.getEras();
                String[] strArr = new String[eras2.length];
                i = 0;
                for (String str3 : eras2) {
                }
                return strArr;
            }
            return dateFormatSymbols.getEras();
        }

        public String[] c(String str, Locale locale, v vVar, m mVar) {
            int i2 = 3;
            String[] vVar32;
            String str2;
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            int i = b.a.a[vVar.ordinal()];
            int i4 = 2;
            final int i5 = 1;
            final int i6 = 7;
            if (b.a.a != i5) {
                if (b.a.a != i4 && b.a.a != 3) {
                    if (b.a.a != 4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str4 = "Unknown text width: ";
                        locale = str4 + vVar;
                        throw new UnsupportedOperationException(locale);
                    } else {
                        str2 = "";
                        vVar32 = b.d.a(c(str2, locale, v.SHORT, mVar), i6);
                    }
                }
                vVar32 = dateFormatSymbols.getShortWeekdays();
            } else {
                vVar32 = dateFormatSymbols.getWeekdays();
            }
            length = vVar32.length;
            if (vVar32.length > i6) {
                vVar32 = new String[i6];
                int i3 = 0;
                i = 6;
                System.arraycopy(vVar32, i4, vVar32, i3, i);
                vVar32[i] = vVar32[i5];
            }
            return vVar32;
        }

        public String[] d(String str, Locale locale, v vVar, m mVar) {
            if (vVar == v.NARROW) {
                return new String[] { "A", "P" };
            }
            return DateFormatSymbols.getInstance(locale).getAmPmStrings();
        }

        public boolean f(Locale locale) {
            int i;
            final Locale[] availableLocales = DateFormatSymbols.getAvailableLocales();
            i = 0;
            for (Locale locale2 : availableLocales) {
                if (locale2.getLanguage().equals(locale.getLanguage())) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(String str) {
            return "iso8601".equals(str);
        }

        public String[] i(String str, Locale locale, v vVar, m mVar) {
            return new String[] { "Q1", "Q2", "Q3", "Q4" };
        }

        public String[] j(String str, Locale locale, v vVar, m mVar, boolean z) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            int i2 = b.a.a[vVar.ordinal()];
            if (b.a.a != 1 && b.a.a != 2) {
                int i = 3;
                if (b.a.a != 3 && b.a.a == 4) {
                    return b.d.a(dateFormatSymbols.getShortMonths(), 12);
                }
                return dateFormatSymbols.getShortMonths();
            }
            return dateFormatSymbols.getMonths();
        }

        /* synthetic */ d(b.a aVar) {
            this();
        }

        @Override // java.lang.Object
        public String toString() {
            return "JDKTextProvider";
        }
    }
    static {
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
        Iterator it = d.c().g(f.class).iterator();
        if (it.hasNext()) {
        }
        net.time4j.h1.c cVar = new c();
    }

    private b(String str, Locale locale, u uVar) {
        int i = 0;
        Class obj;
        boolean z = false;
        net.time4j.g1.v[] values;
        int length2;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        net.time4j.g1.v vVar;
        EnumMap enumMap;
        net.time4j.g1.m[] length3;
        int length4;
        net.time4j.g1.m mVar;
        net.time4j.g1.s sVar;
        net.time4j.g1.m mVar2;
        final Object str3 = this;
        final String str2 = str;
        final Locale locale22 = locale;
        net.time4j.g1.u uVar32 = uVar;
        obj = m.class;
        Class<net.time4j.g1.v> obj2 = v.class;
        super();
        str3.a = uVar.toString();
        z = false;
        Map unmodifiable = Collections.unmodifiableMap(b.i(str2, locale22, uVar32, z));
        str3.b = unmodifiable;
        Map map2 = b.i(str2, locale22, uVar32, true);
        if (map2 == null) {
            str3.c = unmodifiable;
        } else {
            str3.c = Collections.unmodifiableMap(map2);
        }
        EnumMap enumMap5 = new EnumMap(obj2);
        length2 = v.values().length;
        for (net.time4j.g1.v vVar : values) {
            enumMap = new EnumMap(obj);
            length3 = m.values();
            length4 = length3.length;
            for (net.time4j.g1.m mVar3 : length3) {
                enumMap.put(mVar3, new s(uVar32.i(str2, locale22, vVar, mVar3)));
                z = false;
            }
            enumMap5.put(vVar, enumMap);
            z = false;
            net.time4j.g1.m mVar3 = length3[z];
            enumMap.put(mVar3, new s(uVar32.i(str2, locale22, vVar, mVar3)));
            z = z + 1;
            z = false;
        }
        str3.d = Collections.unmodifiableMap(enumMap5);
        EnumMap enumMap2 = new EnumMap(obj2);
        length2 = v.values().length;
        i3 = 0;
        for (net.time4j.g1.v vVar4 : values3) {
            Object enumMap7 = new EnumMap(obj);
            net.time4j.g1.m[] values5 = m.values();
            length3 = values5.length;
            length4 = 0;
            for (net.time4j.g1.m mVar2 : values5) {
                enumMap7.put(mVar2, new s(uVar32.c(str2, locale22, vVar4, mVar2)));
            }
            enumMap2.put(vVar4, enumMap7);
            mVar2 = values5[length4];
            enumMap7.put(mVar2, new s(uVar32.c(str2, locale22, vVar4, mVar2)));
            length4 = length4 + 1;
        }
        str3.e = Collections.unmodifiableMap(enumMap2);
        EnumMap enumMap3 = new EnumMap(obj2);
        net.time4j.g1.v[] values3 = v.values();
        i4 = 0;
        for (net.time4j.g1.v vVar3 : values3) {
            enumMap3.put(vVar3, new s(uVar32.b(str2, locale22, vVar3)));
        }
        str3.g = Collections.unmodifiableMap(enumMap3);
        EnumMap enumMap4 = new EnumMap(obj2);
        net.time4j.g1.v[] values2 = v.values();
        length = values2.length;
        i2 = 0;
        for (net.time4j.g1.v vVar2 : values2) {
            EnumMap enumMap6 = new EnumMap(obj);
            net.time4j.g1.m[] values4 = m.values();
            enumMap = values4.length;
            for (net.time4j.g1.m mVar : values4) {
                enumMap6.put(mVar, new s(uVar32.d(str2, locale22, vVar2, mVar)));
            }
            enumMap4.put(vVar2, enumMap6);
            mVar = values4[length3];
            enumMap6.put(mVar, new s(uVar32.d(str2, locale22, vVar2, mVar)));
            length3 = length3 + 1;
        }
        str3.f = Collections.unmodifiableMap(enumMap4);
        HashMap hashMap = new HashMap();
        i = 0;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "calendar/names/";
            String str6 = "/";
            str4 = str5 + str2 + str6 + str2;
            e eVar = e.h(str4, locale22);
            Iterator it = eVar.g().iterator();
            Object item = it.next();
            hashMap.put(item, eVar.f(item));
        } catch (java.util.MissingResourceException missingResource) {
        }
        str3.h = Collections.unmodifiableMap(hashMap);
        str3.i = str2;
        str3.j = locale22;
        str3.k = i;
    }

    static String a(w<?> wVar) {
        String value;
        java.lang.annotation.Annotation annotation = wVar.l().getAnnotation(c.class);
        if (annotation == null) {
            value = "iso8601";
        } else {
            value = annotation.value();
        }
        return value;
    }

    public static b c(String str, Locale locale) {
        int i = 0;
        net.time4j.g1.u uVar;
        Object str2;
        boolean empty;
        boolean hasNext;
        boolean z;
        Objects.requireNonNull(str, "Missing calendar type.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(':');
        stringBuilder.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!country.isEmpty()) {
            stringBuilder.append('-');
            stringBuilder.append(country);
        }
        String str4 = stringBuilder.toString();
        if ((b)b.p.get(str4) == null) {
            i = 0;
            if (locale.getLanguage().isEmpty()) {
                if (!str.equals("iso8601")) {
                    item = u.class;
                    Iterator it = d.c().g(item).iterator();
                    while (it.hasNext()) {
                        Class<net.time4j.g1.u> item = it.next();
                        if (item.h(str) && item.f(locale)) {
                            break;
                        }
                    }
                    if (b.p == 0) {
                        net.time4j.g1.u uVar2 = b.n;
                        if (uVar2.h(str) && b.n.f(locale)) {
                        }
                        if (b.p == 0) {
                            uVar = b.o;
                        }
                    }
                } else {
                    uVar = b.o;
                }
            }
            net.time4j.g1.b bVar = new b(str, locale, uVar);
            if ((b)str2 == null) {
            }
        }
        return str2;
    }

    public static b d(Locale locale) {
        return b.c("iso8601", locale);
    }

    private String e(String str) {
        String substring;
        str2 = "useShortKeys";
        if (this.h.containsKey(str2)) {
            str2 = "true";
            if (str2.equals(this.h.get(str2))) {
                if (!str.equals("MONTH_OF_YEAR")) {
                    if (!str.equals("DAY_OF_WEEK")) {
                        if (!str.equals("QUARTER_OF_YEAR")) {
                            if (!str.equals("ERA")) {
                                if (str.equals("EVANGELIST")) {
                                    return "EV";
                                }
                                if (str.equals("SANSCULOTTIDES")) {
                                    return "S";
                                }
                                if (str.equals("DAY_OF_DECADE")) {
                                    return "D";
                                }
                            } else {
                                substring = str.substring(0, 1);
                            }
                        }
                    }
                }
            }
        }
        return substring;
    }

    private static String f(String str, int i, String... strArr) {
        int str2 = 1;
        i = 0;
        if (strArr != null && strArr.length > 0) {
            if (strArr.length < i) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(str);
            str2 = 0;
            str2 = 1;
            i3 = strArr.length - i;
            for (Object obj : strArr) {
                stringBuilder.append(obj);
            }
            if (strArr.length == 0) {
                stringBuilder.append(')');
            }
            return stringBuilder.toString();
        }
        if (i > 0) {
        }
        return i;
    }

    private static Map<v, Map<m, s>> i(String str, Locale locale, u uVar, boolean z) {
        int i;
        Class<net.time4j.g1.m> obj;
        net.time4j.g1.m[] values;
        Object obj2;
        Object obj3;
        EnumMap enumMap2 = null;
        int length;
        EnumMap enumMap;
        net.time4j.g1.v vVar;
        net.time4j.g1.m mVar;
        final net.time4j.g1.v[] values2 = v.values();
        i = 0;
        for (net.time4j.g1.v vVar : values2) {
            obj = m.class;
            enumMap = new EnumMap(obj);
            length = m.values().length;
            while (i < length) {
                mVar = values[i];
                String[] strArr = uVar.j(str, locale, vVar, mVar, z);
                obj2.put(mVar, new s(strArr));
                i = i + 1;
                length = obj;
                enumMap = obj2;
                vVar = obj3;
            }
            new EnumMap(v.class).put(vVar, enumMap);
            mVar = values[i];
            strArr = uVar.j(str, locale, vVar, mVar, z);
            obj2.put(mVar, new s(strArr));
            i = i + 1;
            length = obj;
            enumMap = obj2;
            vVar = obj3;
        }
        return enumMap2;
    }

    private s j(v vVar, m mVar, boolean z) {
        if (z) {
            return (s)(Map)this.c.get(vVar).get(mVar);
        }
        return (s)(Map)this.b.get(vVar).get(mVar);
    }

    public static boolean q(Locale locale) {
        return b.l.contains(locale.getLanguage());
    }

    public static String r(e eVar, Locale locale) {
        return b.m.a(eVar, locale);
    }

    public static String s(e eVar, e eVar2, Locale locale) {
        return b.m.k(eVar, eVar2, locale);
    }

    public static String t(e eVar, Locale locale) {
        return b.m.e(eVar, locale);
    }

    public static String u(e eVar, e eVar2, Locale locale) {
        return d.a(b.m.k(eVar, eVar2, locale));
    }

    private static String v(String str, int i, int i2) {
        final StringBuilder stringBuilder = new StringBuilder(str);
        i += i2;
        str2 = str + 95 + i4;
        return str2;
    }

    public s b(v vVar) {
        return (s)this.g.get(vVar);
    }

    public s g(v vVar, m mVar) {
        return j(vVar, mVar, true);
    }

    public s h(v vVar, m mVar) {
        return (s)(Map)this.f.get(vVar).get(mVar);
    }

    public s k(v vVar, m mVar) {
        return (s)(Map)this.d.get(vVar).get(mVar);
    }

    public s l(v vVar, m mVar) {
        return j(vVar, mVar, false);
    }

    public Map<String, String> m() {
        return this.h;
    }

    public <V extends Enum<V>> s n(String str, Class<V> cls, String... strArr) {
        int i;
        String str2 = null;
        String name;
        boolean key;
        if (this.k != null) {
            throw new MissingResourceException(this.k.getMessage(), this.k.getClassName(), this.k.getKey());
        } else {
            Object[] enumConstants = cls.getEnumConstants();
            final int length = enumConstants.length;
            strArr = new String[length];
            i = 0;
            while (i < length) {
                int i2 = 0;
                str2 = b.f(e(str), i, strArr);
                while (str2 != null) {
                    str2 = b.v(str2, i, !i.class.isAssignableFrom(cls));
                    if (this.h.containsKey(str2)) {
                        break loop_4;
                    }
                }
                str2 = b.v(str2, i, i3);
                i = i + 1;
            }
            return new s(strArr);
        }
    }

    public <V extends Enum<V>> s o(p<V> pVar, String... strArr) {
        return n(pVar.name(), pVar.getType(), strArr);
    }

    public s p(v vVar, m mVar) {
        return (s)(Map)this.e.get(vVar).get(mVar);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "(";
        String str5 = "/";
        String str6 = ")";
        str = this.a + str3 + this.i + str5 + this.j + str6;
        return str;
    }
}
