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

/* compiled from: WeekdataProviderSPI.java */
/* loaded from: classes3.dex */
public class i implements y {

    private final String a = "@STATIC";
    private final Set<String> b;
    private final Map<String, x0> c;
    private final Map<String, x0> d;
    private final Map<String, x0> e;
    public i() {
        PrintStream printStream;
        java.lang.IllegalStateException err22;
        InputStream inputStream;
        d dVar;
        String length;
        String substring;
        int i;
        Object obj;
        String trimmed;
        x0 sATURDAY2;
        boolean empty;
        HashMap hashMap;
        boolean equals;
        boolean empty2;
        str = "Unexpected format: ";
        Class<net.time4j.h1.i> obj2 = i.class;
        super();
        String str8 = "data/week.data";
        java.net.URI uri = d.c().f("i18n", obj2, str8);
        boolean z = true;
        if (d.c().e(uri, z) == null) {
            try {
                inputStream = d.c().d(obj2, "data/week.data", z);
            } catch (Throwable th) {
            } catch (Exception e1) {
            } catch (java.io.UnsupportedEncodingException unused) {
            }
        }
        if (inputStream != null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str9 = "@";
            str3 = str9 + uri;
            this.a = str3;
            HashSet hashSet = new HashSet();
            hashMap = new HashMap();
            hashMap = new HashMap();
            hashMap = new HashMap();
            try {
                length = "US-ASCII";
                Object line = new BufferedReader(new InputStreamReader(inputStream, length)).readLine();
                while (line != null) {
                    if (line.startsWith("#")) {
                        line = bufferedReader.readLine();
                        while (line != null) {
                        }
                        this.b = Collections.unmodifiableSet(hashSet);
                        this.c = Collections.unmodifiableMap(hashMap);
                        this.d = Collections.unmodifiableMap(hashMap);
                        this.e = Collections.unmodifiableMap(hashMap);
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                r2 = str + this.a;
                throw new IllegalStateException(r2);
            } catch (Throwable th) {
            } catch (Exception e1) {
            } catch (java.io.UnsupportedEncodingException unused) {
            }
            try {
                inputStream.close();
            } catch (java.io.IOException ioException) {
                e1 = System.err;
                ioException.printStackTrace(e1);
            }
        } else {
            this.b = Collections.emptySet();
            this.c = Collections.emptyMap();
            this.d = Collections.emptyMap();
            this.e = Collections.emptyMap();
            StringBuilder stringBuilder2 = new StringBuilder();
            String str5 = "Warning: File \"";
            String str6 = "\" not found.";
            str4 = str5 + "data/week.data" + str6;
            System.err.println(str4);
        }
    }

    public int a(Locale locale) {
        x0 sUNDAY2;
        String country = locale.getCountry();
        sUNDAY2 = x0.SUNDAY;
        if (this.e.containsKey(country)) {
        }
        return sUNDAY2.getValue();
    }

    public int b(Locale locale) {
        int i = 1;
        boolean contains;
        if (this.b.isEmpty()) {
            return new GregorianCalendar(locale).getMinimalDaysInFirstWeek();
        }
        String country = locale.getCountry();
        i = 1;
        if (country.isEmpty()) {
            if (locale.getLanguage().isEmpty()) {
                i = 4;
            }
        }
        return i;
    }

    public int c(Locale locale) {
        x0 sATURDAY2;
        String country = locale.getCountry();
        sATURDAY2 = x0.SATURDAY;
        if (this.d.containsKey(country)) {
        }
        return sATURDAY2.getValue();
    }

    public int d(Locale locale) {
        x0 mONDAY2;
        int i = 7;
        if (this.c.isEmpty()) {
            int firstDayOfWeek = new GregorianCalendar(locale).getFirstDayOfWeek();
            int i2 = 1;
            locale = firstDayOfWeek == i2 ? 7 : firstDayOfWeek - i2;
            return (firstDayOfWeek == i2 ? 7 : firstDayOfWeek - i2);
        }
        String country = locale.getCountry();
        mONDAY2 = x0.MONDAY;
        if (this.c.containsKey(country)) {
        }
        return mONDAY2.getValue();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = i.class.getName();
        str = name + this.a;
        return str;
    }
}
