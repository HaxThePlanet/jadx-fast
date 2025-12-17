package net.time4j.h1;

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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.d;

/* loaded from: classes3.dex */
public final class e {

    private static final ConcurrentMap<net.time4j.h1.e.b, net.time4j.h1.e.a> e;
    private static final ReferenceQueue<Object> f;
    private final net.time4j.h1.e a;
    private final Map<String, String> b;
    private final String c;
    private final Locale d;

    private static class a extends SoftReference<net.time4j.h1.e> {

        private net.time4j.h1.e.b a;
        a(net.time4j.h1.e e, net.time4j.h1.e.b e$b2) {
            super(e, e.a());
            this.a = b2;
        }

        static net.time4j.h1.e.b a(net.time4j.h1.e.a e$a) {
            return a.a;
        }
    }

    private static class b {

        private final String a;
        private final Locale b;
        b(String string, Locale locale2) {
            super();
            this.a = string;
            this.b = locale2;
        }

        public boolean equals(Object object) {
            int i;
            boolean equals;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object instanceof e.b) {
                if (this.a.equals(object.a) && this.b.equals(object.b)) {
                    if (this.b.equals(object.b)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return i2 ^= i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("/");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(32);
        e.e = concurrentHashMap;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        e.f = referenceQueue;
    }

    private e(net.time4j.h1.e e, net.time4j.h1.e e2) {
        super();
        this.a = e2;
        this.c = e.c;
        this.d = e.d;
        this.b = e.b;
    }

    private e(net.time4j.h1.g g, String string2, Locale locale3) {
        int substring;
        int charAt2;
        int i;
        int charAt;
        int i2;
        Locale obj8;
        super();
        this.a = 0;
        this.c = string2;
        this.d = locale3;
        HashMap obj7 = new HashMap();
        obj8 = g.c();
        while (obj8 != null) {
            obj8 = obj8.trim();
            if (obj8.isEmpty() == 0) {
            }
            obj8 = g.c();
            substring = 0;
            if (obj8.charAt(substring) == 35) {
            } else {
            }
            charAt2 = obj8.length();
            i = substring;
            while (i < charAt2) {
                if (obj8.charAt(i) == 61) {
                    break loop_6;
                } else {
                }
                i++;
                charAt = i + 1;
                if (charAt < charAt2) {
                    break loop_6;
                } else {
                }
            }
            if (obj8.charAt(i) == 61) {
            } else {
            }
            i++;
            charAt = i + 1;
            if (charAt < charAt2) {
            } else {
            }
            obj7.put(obj8.substring(substring, i), obj8.substring(charAt));
        }
        this.b = Collections.unmodifiableMap(obj7);
    }

    static ReferenceQueue a() {
        return e.f;
    }

    public static List<Locale> c(Locale locale) {
        String alias;
        boolean locale2;
        boolean obj4;
        alias = d.getAlias(locale);
        final String country = locale.getCountry();
        obj4 = locale.getVariant();
        LinkedList linkedList = new LinkedList();
        if (!obj4.isEmpty()) {
            locale2 = new Locale(alias, country, obj4);
            linkedList.add(locale2);
        }
        String str = "";
        if (!country.isEmpty()) {
            obj4 = new Locale(alias, country, str);
            linkedList.add(obj4);
        }
        obj4 = new Locale(alias, str, str);
        linkedList.add(obj4);
        if (!alias.isEmpty() && alias.equals("nn")) {
            obj4 = new Locale(alias, str, str);
            linkedList.add(obj4);
            if (alias.equals("nn")) {
                obj4 = new Locale("nb", str, str);
                linkedList.add(obj4);
            }
        }
        linkedList.add(Locale.ROOT);
        return linkedList;
    }

    public static net.time4j.h1.e h(String string, Locale locale2) {
        Object obj2;
        ConcurrentMap map;
        boolean empty;
        net.time4j.h1.e eVar;
        boolean next;
        Object obj;
        int obj5;
        if (string.isEmpty()) {
        } else {
            Objects.requireNonNull(locale2, "Missing locale.");
            e.b bVar = new e.b(string, locale2);
            obj2 = e.e.get(bVar);
            obj2 = (e.a)obj2.get();
            if (obj2 != null && (e)obj2 != null) {
                obj2 = obj2.get();
                if ((e)(e)obj2 != null) {
                    return (e)(e)obj2;
                }
            }
            java.lang.ref.Reference poll = e.f.poll();
            while (poll != null) {
                e.e.remove(e.a.a((e.a)poll));
                poll = e.f.poll();
            }
            ArrayList arrayList = new ArrayList();
            Iterator iterator = e.c(locale2).iterator();
            while (iterator.hasNext()) {
                eVar = e.i(string, (Locale)iterator.next());
                if (eVar != null) {
                }
                arrayList.add(eVar);
            }
            if (arrayList.isEmpty()) {
            } else {
                int obj6 = 1;
                obj5 -= obj6;
                while (obj5 >= obj6) {
                    empty = obj5 + -1;
                    arrayList.set(empty, (e)arrayList.get(empty).k((e)arrayList.get(obj5)));
                    obj5--;
                }
                obj5 = arrayList.get(0);
                e.a aVar = new e.a((e)obj5, bVar);
                e.e.putIfAbsent(bVar, aVar);
                return obj5;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot find resource bundle for: ");
            stringBuilder.append(e.j(string, locale2));
            MissingResourceException missingResourceException = new MissingResourceException(stringBuilder.toString(), e.class.getName(), "");
            throw missingResourceException;
        }
        obj5 = new IllegalArgumentException("Base name must not be empty.");
        throw obj5;
    }

    private static net.time4j.h1.e i(String string, Locale locale2) {
        Class<net.time4j.h1.e> gVar;
        java.io.InputStream inputStream;
        Object obj;
        int eVar;
        gVar = e.class;
        int indexOf = string.indexOf(47);
        final int i4 = 1;
        String str = e.j(string.substring(indexOf += i4), locale2);
        eVar = 0;
        if (d.c().e(d.c().f(string.substring(0, indexOf), gVar, str), i4) == null) {
            inputStream = d.c().d(gVar, str, i4);
        }
        if (inputStream != null) {
            gVar = new g(inputStream);
            eVar = new e(gVar, string, locale2);
            gVar.close();
        }
        return eVar;
    }

    private static String j(String string, Locale locale2) {
        String alias;
        boolean obj5;
        String obj6;
        alias = d.getAlias(locale2);
        final String country = locale2.getCountry();
        obj6 = locale2.getVariant();
        StringBuilder stringBuilder = new StringBuilder(length += 20);
        stringBuilder.append(string.replace('.', '/'));
        if (!alias.isEmpty()) {
            obj5 = 95;
            stringBuilder.append(obj5);
            stringBuilder.append(alias);
            if (!obj6.isEmpty()) {
                stringBuilder.append(obj5);
                stringBuilder.append(country);
                stringBuilder.append(obj5);
                stringBuilder.append(obj6);
            } else {
                if (!country.isEmpty()) {
                    stringBuilder.append(obj5);
                    stringBuilder.append(country);
                }
            }
        }
        stringBuilder.append(".properties");
        return stringBuilder.toString();
    }

    private net.time4j.h1.e k(net.time4j.h1.e e) {
        if (e == null) {
            return this;
        }
        e eVar = new e(this, e);
        return eVar;
    }

    public boolean b(String string) {
        Object obj2;
        Object obj;
        Objects.requireNonNull(string, "Missing resource key.");
        obj2 = this;
        while ((String)obj2.b.get(string) != null) {
        }
        return 1;
    }

    public Set<String> d() {
        return this.b.keySet();
    }

    public Locale e() {
        return this.d;
    }

    public String f(String string) {
        Object obj2;
        Object obj;
        Objects.requireNonNull(string, "Missing resource key.");
        obj2 = this;
        obj = obj2.b.get(string);
        while ((String)obj != null) {
            obj = obj2.b.get(string);
        }
        return (String)(String)obj;
    }

    public Set<String> g() {
        Object obj;
        Set keySet;
        HashSet hashSet = new HashSet(this.b.keySet());
        obj = this;
        obj = obj.a;
        while (obj != null) {
            hashSet.addAll(obj.b.keySet());
            obj = obj.a;
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
