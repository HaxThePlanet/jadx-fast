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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.d;
import net.time4j.h1.e;
import net.time4j.tz.d;
import net.time4j.tz.s;

/* loaded from: classes3.dex */
public class b implements s {

    private static final ConcurrentMap<Locale, Map<String, Map<d, String>>> a;
    private static final Set<String> b;
    private static final Map<String, Set<String>> c;
    private static final Map<String, String> d;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b.a = concurrentHashMap;
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

    private static void b(Map<String, String> map, String string2, String string3) {
        map.put(string2, string3);
    }

    private static void c(Map<String, Set<String>> map, String string2, String string3) {
        Object linkedHashSet;
        if ((Set)map.get(string2) == null) {
            linkedHashSet = new LinkedHashSet();
            map.put(string2, linkedHashSet);
        }
        linkedHashSet.add(string3);
    }

    private static e d(Locale locale) {
        return e.h("olson/zones/tzname", locale);
    }

    static void e(Map<String, Set<String>> map, String string2) {
        Class<net.time4j.tz.t.b> classLoader;
        InputStreamReader inputStreamReader;
        InputStream resourceAsStream;
        String startsWith;
        int split;
        int length;
        Object obj;
        Object obj2;
        Object obj7;
        Object obj8;
        classLoader = b.class;
        if (d.c().e(d.c().f("olson", classLoader, string2), true) == null) {
            resourceAsStream = classLoader.getClassLoader().getResourceAsStream(string2);
        }
        if (resourceAsStream != null) {
            inputStreamReader = new InputStreamReader(resourceAsStream, "UTF-8");
            obj8 = new BufferedReader(inputStreamReader);
            inputStreamReader = obj8.readLine();
            while (inputStreamReader != null) {
                if (inputStreamReader.startsWith("#") == null) {
                }
                inputStreamReader = obj8.readLine();
                if (inputStreamReader.isEmpty() != null) {
                } else {
                }
                inputStreamReader = inputStreamReader.split("\t");
                if (inputStreamReader.length >= 3) {
                }
                split = inputStreamReader[0].split(",");
                while (startsWith < split.length) {
                    b.c(map, split[startsWith], inputStreamReader[2]);
                    startsWith++;
                }
                b.c(map, split[startsWith], inputStreamReader[2]);
                startsWith++;
            }
            resourceAsStream.close();
        } else {
            inputStreamReader = new StringBuilder();
            inputStreamReader.append("Warning: File \"");
            inputStreamReader.append(string2);
            inputStreamReader.append("\" not found.");
            System.err.println(inputStreamReader.toString());
        }
    }

    @Override // net.time4j.tz.s
    public String a(String string, d d2, Locale locale3) {
        Object obj;
        HashMap hashMap;
        int length;
        int i;
        int i2;
        String str2;
        EnumMap enumMap;
        d sHORT_DAYLIGHT_TIME;
        String str;
        Object obj13;
        final String str3 = "";
        if (b.b.contains(string)) {
            return str3;
        }
        if ((Map)b.a.get(locale3) == null) {
            String[][] zoneStrings = DateFormatSymbols.getInstance(locale3).getZoneStrings();
            hashMap = new HashMap();
            i = 0;
            i2 = i;
            while (i2 < zoneStrings.length) {
                String[] strArr = zoneStrings[i2];
                enumMap = new EnumMap(d.class);
                enumMap.put(d.LONG_STANDARD_TIME, strArr[1]);
                enumMap.put(d.SHORT_STANDARD_TIME, strArr[2]);
                enumMap.put(d.LONG_DAYLIGHT_TIME, strArr[3]);
                enumMap.put(d.SHORT_DAYLIGHT_TIME, strArr[4]);
                hashMap.put(strArr[i], enumMap);
                i2++;
            }
            if ((Map)b.a.putIfAbsent(locale3, hashMap) != null) {
            } else {
                obj = hashMap;
            }
        }
        Object obj11 = obj.get(string);
        if ((Map)obj11 != null) {
            return (String)(Map)obj11.get(d2);
        }
        return str3;
    }

    public Set<String> f(Locale locale, boolean z2) {
        Object obj1;
        Object obj2;
        obj1 = locale.getCountry();
        if (z2 != null && obj1.equals("US")) {
            if (obj1.equals("US")) {
                obj1 = new LinkedHashSet();
                obj1.add("America/New_York");
                obj1.add("America/Chicago");
                obj1.add("America/Denver");
                obj1.add("America/Los_Angeles");
                obj1.add("America/Anchorage");
                obj1.add("Pacific/Honolulu");
                return Collections.unmodifiableSet(obj1);
            }
            obj2 = b.d.get(obj1);
            if ((String)obj2 != null) {
                return Collections.singleton((String)obj2);
            }
        }
        if ((Set)b.c.get(obj1) == null) {
            obj1 = Collections.emptySet();
        }
        return obj1;
    }

    @Override // net.time4j.tz.s
    public String g(boolean z, Locale locale2) {
        String obj1;
        obj1 = z ? "utc-literal" : "offset-pattern";
        return b.d(locale2).f(obj1);
    }
}
