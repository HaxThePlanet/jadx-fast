package net.time4j.h1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.f1.d;
import net.time4j.g1.y;
import net.time4j.x0;

/* loaded from: classes3.dex */
public class i implements y {

    private final String a;
    private final Set<String> b;
    private final Map<String, x0> c;
    private final Map<String, x0> d;
    private final Map<String, x0> e;
    public i() {
        Object str;
        PrintStream stream;
        Object unmodifiableMap;
        java.lang.IllegalStateException err;
        Object hashMap3;
        InputStream inputStream;
        Object hashMap;
        HashMap hashMap2;
        d bufferedReader;
        InputStreamReader inputStreamReader;
        String startsWith;
        String substring;
        int i;
        Object upperCase;
        HashMap empty2;
        boolean upperCase2;
        boolean empty;
        Class<net.time4j.h1.i> obj = i.class;
        super();
        hashMap = "data/week.data";
        java.net.URI uri = d.c().f("i18n", obj, hashMap);
        hashMap2 = 1;
        if (d.c().e(uri, hashMap2) == null) {
            inputStream = d.c().d(obj, hashMap, hashMap2);
        }
        if (inputStream != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("@");
            stringBuilder.append(uri);
            this.a = stringBuilder.toString();
            HashSet hashSet = new HashSet();
            hashMap3 = new HashMap();
            hashMap = new HashMap();
            hashMap2 = new HashMap();
            inputStreamReader = new InputStreamReader(inputStream, "US-ASCII");
            bufferedReader = new BufferedReader(inputStreamReader);
            inputStreamReader = bufferedReader.readLine();
            while (inputStreamReader != null) {
                int indexOf = inputStreamReader.indexOf(61);
                upperCase = inputStreamReader.substring(0, indexOf).trim();
                inputStreamReader = inputStreamReader.substring(indexOf++).split(" ");
                if (upperCase.equals("minDays-4")) {
                } else {
                }
                int i5 = 6;
                if (upperCase.startsWith("start-")) {
                } else {
                }
                if (upperCase.startsWith("end-")) {
                } else {
                }
                substring = upperCase.substring(i5);
                upperCase = x0.MONDAY;
                empty2 = hashMap3;
                if (substring.equals("sun")) {
                } else {
                }
                if (substring.equals("sat")) {
                } else {
                }
                if (substring.equals("fri")) {
                } else {
                }
                if (substring.equals("thu")) {
                } else {
                }
                if (substring.equals("wed")) {
                } else {
                }
                if (substring.equals("tue")) {
                } else {
                }
                if (substring.equals("mon")) {
                }
                while (i < inputStreamReader.length) {
                    upperCase2 = inputStreamReader[i].trim().toUpperCase(Locale.US);
                    if (!upperCase2.isEmpty()) {
                    }
                    i++;
                    empty2.put(upperCase2, upperCase);
                }
                inputStreamReader = bufferedReader.readLine();
                upperCase2 = inputStreamReader[i].trim().toUpperCase(Locale.US);
                if (!upperCase2.isEmpty()) {
                }
                i++;
                empty2.put(upperCase2, upperCase);
                upperCase = x0.MONDAY;
                upperCase = x0.TUESDAY;
                upperCase = x0.WEDNESDAY;
                upperCase = x0.THURSDAY;
                upperCase = x0.FRIDAY;
                upperCase = x0.SATURDAY;
                upperCase = x0.SUNDAY;
                substring = upperCase.substring(4);
                upperCase = x0.SUNDAY;
                empty2 = hashMap2;
                substring = upperCase.substring(i5);
                upperCase = x0.SATURDAY;
                empty2 = hashMap;
                while (i < inputStreamReader.length) {
                    upperCase = inputStreamReader[i].trim().toUpperCase(Locale.US);
                    if (!upperCase.isEmpty()) {
                    }
                    i++;
                    hashSet.add(upperCase);
                }
                upperCase = inputStreamReader[i].trim().toUpperCase(Locale.US);
                if (!upperCase.isEmpty()) {
                }
                i++;
                hashSet.add(upperCase);
            }
            this.b = Collections.unmodifiableSet(hashSet);
            this.c = Collections.unmodifiableMap(hashMap3);
            this.d = Collections.unmodifiableMap(hashMap);
            this.e = Collections.unmodifiableMap(hashMap2);
            inputStream.close();
        } else {
            this.a = "@STATIC";
            this.b = Collections.emptySet();
            this.c = Collections.emptyMap();
            this.d = Collections.emptyMap();
            this.e = Collections.emptyMap();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Warning: File \"");
            stringBuilder2.append(hashMap);
            stringBuilder2.append("\" not found.");
            System.err.println(stringBuilder2.toString());
        }
    }

    @Override // net.time4j.g1.y
    public int a(Locale locale) {
        Object sUNDAY;
        Object obj3;
        obj3 = locale.getCountry();
        sUNDAY = x0.SUNDAY;
        if (this.e.containsKey(obj3)) {
            sUNDAY = obj3;
        }
        return sUNDAY.getValue();
    }

    @Override // net.time4j.g1.y
    public int b(Locale locale) {
        int i;
        boolean obj5;
        if (this.b.isEmpty()) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(locale);
            return gregorianCalendar.getMinimalDaysInFirstWeek();
        }
        String country = locale.getCountry();
        i = 1;
        if (country.isEmpty() && locale.getLanguage().isEmpty()) {
            if (locale.getLanguage().isEmpty()) {
                i = i2;
            } else {
                if (this.b.contains(country)) {
                }
            }
        } else {
        }
        return i;
    }

    @Override // net.time4j.g1.y
    public int c(Locale locale) {
        Object sATURDAY;
        Object obj3;
        obj3 = locale.getCountry();
        sATURDAY = x0.SATURDAY;
        if (this.d.containsKey(obj3)) {
            sATURDAY = obj3;
        }
        return sATURDAY.getValue();
    }

    @Override // net.time4j.g1.y
    public int d(Locale locale) {
        Object mONDAY;
        Object obj3;
        if (this.c.isEmpty()) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(locale);
            obj3 = gregorianCalendar.getFirstDayOfWeek();
            int i = 1;
            obj3 = obj3 == i ? 7 : obj3 - i;
            return obj3;
        }
        obj3 = locale.getCountry();
        mONDAY = x0.MONDAY;
        if (this.c.containsKey(obj3)) {
            mONDAY = obj3;
        }
        return mONDAY.getValue();
    }

    @Override // net.time4j.g1.y
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.class.getName());
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
