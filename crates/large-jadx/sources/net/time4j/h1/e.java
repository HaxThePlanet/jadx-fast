package net.time4j.h1;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.d;

/* compiled from: PropertyBundle.java */
/* loaded from: classes3.dex */
public final class e {

    private static final ConcurrentMap<e.b, e.a> e = new ConcurrentHashMap<>(32);
    private static final ReferenceQueue<Object> f = new ReferenceQueue<>();
    private final e a;
    private final Map<String, String> b;
    private final String c;
    private final Locale d;

    private static class a extends SoftReference<e> {

        private e.b a;
        a(e.b bVar) {
            super(eVar, e.f);
            this.a = bVar;
        }

        static /* synthetic */ e.b a(e.a aVar) {
            return aVar.a;
        }
    }

    private static class b {

        private final String a;
        private final Locale b;
        b(String str, Locale locale) {
            super();
            this.a = str;
            this.b = locale;
        }

        public boolean equals(Object object) {
            boolean z = true;
            boolean equals;
            boolean equals2;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (object instanceof e.b) {
                if (this.a.equals(object.a)) {
                    if (!(this.b.equals(object.b))) {
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() << 3) ^ this.b.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "/";
            str = this.a + str3 + this.b;
            return str;
        }
    }

    private e(g gVar, String str, Locale locale) {
        int length;
        int i = 35;
        int i2;
        char c = 61;
        super();
        net.time4j.h1.e eVar = null;
        this.a = eVar;
        this.c = str;
        this.d = locale;
        final HashMap hashMap = new HashMap();
        str = gVar.c();
        while (str != null) {
            String substring = str.trim();
            str = gVar.c();
        }
        this.b = Collections.unmodifiableMap(hashMap);
    }

    static /* synthetic */ ReferenceQueue a() {
        return e.f;
    }

    public static List<Locale> c(Locale locale) {
        String alias = d.getAlias(locale);
        final String country = locale.getCountry();
        String variant = locale.getVariant();
        final LinkedList linkedList = new LinkedList();
        if (!variant.isEmpty()) {
            linkedList.add(new Locale(alias, country, variant));
        }
        String str = "";
        if (!country.isEmpty()) {
            linkedList.add(new Locale(alias, country, str));
        }
        if (!alias.isEmpty()) {
            linkedList.add(new Locale(alias, str, str));
            if (alias.equals("nn")) {
                alias = "nb";
                linkedList.add(new Locale(alias, str, str));
            }
        }
        linkedList.add(Locale.ROOT);
        return linkedList;
    }

    public static e h(String str, Locale locale) {
        int i;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Base name must not be empty.");
        } else {
            Objects.requireNonNull(locale, "Missing locale.");
            net.time4j.h1.e.b bVar = new e.b(str, locale);
            Object value = e.e.get(bVar);
            if (value != null && value != null) {
                return value;
            }
            java.lang.ref.Reference poll = e.f.poll();
            while (poll != null) {
                e.e.remove(poll.a);
                poll = e.f.poll();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = e.c(locale).iterator();
            while (it.hasNext()) {
                try {
                    net.time4j.h1.e eVar = e.i(str, (Locale)it.next());
                    arrayList.add(eVar);
                } catch (java.io.IOException ioException) {
                    locale = new IllegalStateException(ioException);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) locale;
                }
            }
            if (arrayList.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Cannot find resource bundle for: ";
                String str5 = e.j(ioException, locale);
                ioException = str4 + str5;
                throw new MissingResourceException(ioException, e.class.getName(), "");
            } else {
                int i4 = 1;
                i = arrayList.size() - i4;
                while (i >= e.class) {
                    int i2 = i - 1;
                    arrayList.set(i2, (e)arrayList.get(i2).k((e)arrayList.get(i)));
                    i = i - 1;
                }
                Object item4 = arrayList.get(0);
                e.e.putIfAbsent(bVar, new e.a(item4, bVar));
                return item4;
            }
        }
    }

    private static e i(String str, Locale locale) {
        java.io.InputStream inputStream;
        Object obj2;
        int i = 0;
        gVar = e.class;
        int indexOf = str.indexOf(47);
        final int i5 = 1;
        String str2 = e.j(str.substring(indexOf + i5), locale);
        i = 0;
        if (d.c().e(d.c().f(str.substring(0, indexOf), gVar, str2), true) == null) {
            try {
                inputStream = d.c().d(gVar, str2, true);
            } catch (Throwable th) {
            }
        }
        if (inputStream != null) {
            try {
                net.time4j.h1.g gVar = new g(inputStream);
            } catch (Throwable th) {
            }
            try {
                net.time4j.h1.e eVar = new e(gVar, th, locale);
            } catch (Throwable th) {
                obj2 = obj;
            }
            gVar.close();
        }
        return i;
    }

    private static String j(String str, Locale locale) {
        String alias = d.getAlias(locale);
        final String country = locale.getCountry();
        String variant = locale.getVariant();
        final StringBuilder stringBuilder = new StringBuilder(str.length() + 20);
        stringBuilder.append(str.replace('.', '/'));
        if (!alias.isEmpty()) {
            char c = '_';
            stringBuilder.append(c);
            stringBuilder.append(alias);
            if (!variant.isEmpty()) {
                stringBuilder.append(c);
                stringBuilder.append(country);
                stringBuilder.append(c);
                stringBuilder.append(variant);
            } else {
                if (!country.isEmpty()) {
                    stringBuilder.append(c);
                    stringBuilder.append(country);
                }
            }
        }
        stringBuilder.append(".properties");
        return stringBuilder.toString();
    }

    private e k(e eVar) {
        if (eVar == null) {
            return this;
        }
        return new e(this, eVar);
    }

    public boolean b(String str) {
        net.time4j.h1.e eVar;
        Objects.requireNonNull(str, "Missing resource key.");
        eVar = this;
        while ((String)eVar.b.get(str) != null) {
            if (eVar.a == null) {
                return false;
            }
        }
        return true;
    }

    public Set<String> d() {
        return this.b.keySet();
    }

    public Locale e() {
        return this.d;
    }

    public String f(String str) {
        net.time4j.h1.e eVar;
        Objects.requireNonNull(str, "Missing resource key.");
        Object str3 = this;
        Object value = eVar.b.get(str);
        while (value != null) {
            if (eVar.a == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Cannot find property resource for: ";
                String str6 = e.j(this.c, this.d);
                String str7 = "=>";
                r1 = str4 + str6 + str7 + str;
                throw new MissingResourceException(r1, e.class.getName(), str);
            }
        }
        return value;
    }

    public Set<String> g() {
        Object obj;
        HashSet hashSet = new HashSet(this.b.keySet());
        obj = this;
        while (obj.a != null) {
            hashSet.addAll(eVar.b.keySet());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private e(e eVar, e eVar2) {
        super();
        this.a = eVar2;
        this.c = eVar.c;
        this.d = eVar.d;
        this.b = eVar.b;
    }
}
