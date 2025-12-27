package net.time4j.tz.t;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import net.time4j.h1.e;
import net.time4j.tz.s;

/* compiled from: ZoneNameProviderSPI.java */
/* loaded from: classes3.dex */
public class b implements s {

    private static final ConcurrentMap<Locale, Map<String, Map<net.time4j.tz.d, String>>> a = new ConcurrentHashMap<>();
    private static final Set<String> b;
    private static final Map<String, Set<String>> c;
    private static final Map<String, String> d;
    static {
        HashSet hashSet = new HashSet();
        hashSet.add("Z");
        hashSet.add("GMT");
        hashSet.add("GMT0");
        hashSet.add("Greenwich");
        hashSet.add("UCT");
        hashSet.add("UTC");
        hashSet.add("UTC0");
        hashSet.add("Universal");
        hashSet.add("Zulu");
        b.b = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap();
        b.e(hashMap, "data/zone1970.tab");
        b.c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        b.b(hashMap2, "CL", "America/Santiago");
        b.b(hashMap2, "CN", "Asia/Shanghai");
        b.b(hashMap2, "DE", "Europe/Berlin");
        b.b(hashMap2, "EC", "America/Guayaquil");
        b.b(hashMap2, "ES", "Europe/Madrid");
        b.b(hashMap2, "MH", "Pacific/Majuro");
        b.b(hashMap2, "MY", "Asia/Kuala_Lumpur");
        b.b(hashMap2, "NZ", "Pacific/Auckland");
        b.b(hashMap2, "PT", "Europe/Lisbon");
        b.b(hashMap2, "UA", "Europe/Kiev");
        b.b(hashMap2, "UZ", "Asia/Tashkent");
        b.d = Collections.unmodifiableMap(hashMap2);
    }

    private static void b(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    private static void c(Map<String, Set<String>> map, String str, String str2) {
        Object value;
        if ((Set)map.get(str) == null) {
            map.put(str, new LinkedHashSet());
        }
        value.add(str2);
    }

    private static e d(Locale locale) {
        return e.h("olson/zones/tzname", locale);
    }

    static void e(Map<String, Set<String>> map, String str) {
        InputStream resourceAsStream;
        String length;
        boolean z = true;
        int length2;
        String str3;
        String str4;
        classLoader = b.class;
        z = true;
        if (d.c().e(d.c().f("olson", classLoader, str), z) == null) {
            resourceAsStream = classLoader.getClassLoader().getResourceAsStream(str);
        }
        if (resourceAsStream != null) {
            try {
                length = "UTF-8";
                Object line = new BufferedReader(new InputStreamReader(resourceAsStream, length)).readLine();
                String[] parts = line.split("\t");
                length = parts.length;
                z = 3;
                String[] parts2 = parts[0].split(",");
                length2 = parts2.length;
                b.c(map, parts2[length], parts[2]);
            } catch (java.io.IOException ioException) {
                str = System.err;
                ioException.printStackTrace(str);
            }
            try {
                resourceAsStream.close();
            } catch (java.io.IOException ioException) {
                str = System.err;
                ioException.printStackTrace(str);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Warning: File \"";
            String str11 = "\" not found.";
            str12 = str5 + str + str11;
            System.err.println(str12);
        }
    }

    public String a(String str, net.time4j.tz.d dVar, Locale locale) {
        Object locale32;
        int i;
        Object obj;
        EnumMap enumMap;
        net.time4j.tz.d sHORT_DAYLIGHT_TIME2;
        Object obj2;
        final String str2 = "";
        if (b.b.contains(str)) {
            return str2;
        }
        if ((Map)b.a.get(locale) == null) {
            String[][] zoneStrings = DateFormatSymbols.getInstance(locale).getZoneStrings();
            HashMap hashMap = new HashMap();
            length = zoneStrings.length;
            i = 0;
            for (String[] strArr : zoneStrings) {
                enumMap = new EnumMap(d.class);
                enumMap.put(d.LONG_STANDARD_TIME, strArr[1]);
                enumMap.put(d.SHORT_STANDARD_TIME, strArr[2]);
                enumMap.put(d.LONG_DAYLIGHT_TIME, strArr[3]);
                enumMap.put(d.SHORT_DAYLIGHT_TIME, strArr[4]);
                hashMap.put(strArr[i], enumMap);
            }
            if ((Map)locale32 == null) {
            }
        }
        Object value = locale32.get(str);
        if (value != null) {
            return (String)value.get(dVar);
        }
        return str2;
    }

    public Set<String> f(Locale locale, boolean z) {
        Object value;
        String country = locale.getCountry();
        if (z) {
            if (country.equals("US")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add("America/New_York");
                linkedHashSet.add("America/Chicago");
                linkedHashSet.add("America/Denver");
                linkedHashSet.add("America/Los_Angeles");
                linkedHashSet.add("America/Anchorage");
                linkedHashSet.add("Pacific/Honolulu");
                return Collections.unmodifiableSet(linkedHashSet);
            }
            Object value2 = b.d.get(country);
            if (value2 != null) {
                return Collections.singleton(value2);
            }
        }
        if ((Set)b.c.get(country) == null) {
            Set emptySet = Collections.emptySet();
        }
        return value;
    }

    public String g(boolean z, Locale locale) {
        String str;
        z = z ? "utc-literal" : "offset-pattern";
        return (z ? "utc-literal" : "offset-pattern");
    }
}
