package net.time4j.g1.z;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.w;
import net.time4j.f1.d;
import net.time4j.g1.a;
import net.time4j.g1.a.b;
import net.time4j.g1.g;
import net.time4j.g1.i;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.v;
import net.time4j.h1.d;
import net.time4j.h1.f;

/* loaded from: classes3.dex */
final class b implements d {

    static final c<String> g;
    static final c<String> h;
    private static final i i;
    private static final char j = 44;
    private static final ConcurrentMap<String, net.time4j.g1.z.b.a> k;
    private static final net.time4j.g1.z.b.a l;
    private final Map<String, Object> a;
    private final a b;
    private final Locale c;
    private final int d;
    private final int e;
    private final n<o> f;

    private static class a {

        private final j a;
        private final char b;
        private final char c;
        private final String d;
        private final String e;
        a(j j, char c2, char c3, String string4, String string5) {
            super();
            this.a = j;
            this.b = c2;
            this.c = c3;
            this.d = string4;
            this.e = string5;
        }

        static j a(net.time4j.g1.z.b.a b$a) {
            return a.a;
        }

        static char b(net.time4j.g1.z.b.a b$a) {
            return a.b;
        }

        static char c(net.time4j.g1.z.b.a b$a) {
            return a.c;
        }

        static String d(net.time4j.g1.z.b.a b$a) {
            return a.d;
        }

        static String e(net.time4j.g1.z.b.a b$a) {
            return a.e;
        }
    }
    static {
        int i;
        int i2;
        int i3;
        Object next;
        int length;
        Class<String> obj = String.class;
        b.g = a.e("PLUS_SIGN", obj);
        b.h = a.e("MINUS_SIGN", obj);
        Iterator iterator = d.c().g(i.class).iterator();
        i2 = 0;
        i3 = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            length = objArr.length;
            if (length > i3) {
            }
            i2 = next;
            i3 = length;
        }
        if (i2 == 0) {
            i2 = f.d;
        }
        b.i = i2;
        i = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b.k = concurrentHashMap;
        super(j.ARABIC, 48, i, "+", "-");
        b.l = aVar;
    }

    b(a a, Locale locale2) {
        super(a, locale2, 0, 0, 0);
    }

    b(a a, Locale locale2, int i3, int i4, n<o> n5) {
        Locale obj3;
        super();
        Objects.requireNonNull(a, "Missing format attributes.");
        this.b = a;
        obj3 = locale2 == null ? Locale.ROOT : obj3;
        this.c = obj3;
        this.d = i3;
        this.e = i4;
        this.f = n5;
        this.a = Collections.emptyMap();
    }

    private b(a a, Locale locale2, int i3, int i4, n<o> n5, Map<String, Object> map6) {
        Locale obj3;
        super();
        Objects.requireNonNull(a, "Missing format attributes.");
        this.b = a;
        obj3 = locale2 == null ? Locale.ROOT : obj3;
        this.c = obj3;
        this.d = i3;
        this.e = i4;
        this.f = n5;
        this.a = Collections.unmodifiableMap(map6);
    }

    static net.time4j.g1.z.b d(w<?> w, a a2, Locale locale3) {
        a.b bVar = new a.b(w);
        bVar.d(a.f, g.SMART);
        bVar.d(a.g, v.WIDE);
        bVar.d(a.h, m.FORMAT);
        bVar.b(a.p, ' ');
        bVar.f(a2);
        b obj2 = new b(bVar.a(), locale3);
        return obj2.n(locale3);
    }

    private static boolean j(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    static net.time4j.g1.z.b k(net.time4j.g1.z.b b, net.time4j.g1.z.b b2) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(b2.a);
        hashMap.putAll(b.a);
        a.b bVar = new a.b();
        bVar.f(b2.b);
        bVar.f(b.b);
        super(bVar.a(), Locale.ROOT, 0, 0, 0, hashMap);
        return obj8.n(b.c);
    }

    public <A> A a(c<A> c, A a2) {
        if (this.a.containsKey(c.name())) {
            return c.a().cast(this.a.get(c.name()));
        }
        return this.b.a(c, a2);
    }

    public <A> A b(c<A> c) {
        if (this.a.containsKey(c.name())) {
            return c.a().cast(this.a.get(c.name()));
        }
        return this.b.b(c);
    }

    public boolean c(c<?> c) {
        if (this.a.containsKey(c.name())) {
            return 1;
        }
        return this.b.c(c);
    }

    @Override // net.time4j.engine.d
    a e() {
        return this.b;
    }

    @Override // net.time4j.engine.d
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object aVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof b) {
            if (this.b.equals(object.b) && this.c.equals(object.c) && this.d == object.d && this.e == object.e && b.j(this.f, object.f) && this.a.equals(object.a)) {
                if (this.c.equals(object.c)) {
                    if (this.d == object.d) {
                        if (this.e == object.e) {
                            if (b.j(this.f, object.f)) {
                                if (this.a.equals(object.a)) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    n<o> f() {
        return this.f;
    }

    @Override // net.time4j.engine.d
    int g() {
        return this.d;
    }

    @Override // net.time4j.engine.d
    Locale h() {
        return this.c;
    }

    @Override // net.time4j.engine.d
    public int hashCode() {
        return i2 += i5;
    }

    @Override // net.time4j.engine.d
    int i() {
        return this.e;
    }

    @Override // net.time4j.engine.d
    net.time4j.g1.z.b l(a a) {
        super(a, this.c, this.d, this.e, this.f, this.a);
        return bVar2;
    }

    <A> net.time4j.g1.z.b m(c<A> c, A a2) {
        String obj8;
        HashMap hashMap = new HashMap(this.a);
        if (a2 == null) {
            hashMap.remove(c.name());
        } else {
            hashMap.put(c.name(), a2);
        }
        super(this.b, this.c, this.d, this.e, this.f, hashMap);
        return obj8;
    }

    @Override // net.time4j.engine.d
    net.time4j.g1.z.b n(Locale locale) {
        String str2;
        String ifAbsent;
        String str3;
        net.time4j.g1.z.b.a aVar;
        boolean empty;
        boolean stringBuilder;
        j jVar;
        char c2;
        char c;
        String str4;
        String str;
        Locale obj11;
        a.b bVar = new a.b();
        bVar.f(this.b);
        ifAbsent = d.getAlias(locale);
        String country = locale.getCountry();
        if (ifAbsent.isEmpty() && country.isEmpty()) {
            if (country.isEmpty()) {
                obj11 = Locale.ROOT;
                bVar.d(a.l, j.ARABIC);
                bVar.b(a.o, b.j);
                str2 = "+";
                str3 = "-";
            } else {
                if (!country.isEmpty()) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(ifAbsent);
                    stringBuilder.append("_");
                    stringBuilder.append(country);
                    ifAbsent = stringBuilder.toString();
                }
                if ((b.a)b.k.get(ifAbsent) == null) {
                    i iVar = b.i;
                    super(iVar.a(locale), iVar.f(locale), iVar.d(locale), iVar.e(locale), iVar.b(locale));
                    ifAbsent = b.k.putIfAbsent(ifAbsent, aVar);
                    if ((b.a)ifAbsent != null) {
                        aVar = ifAbsent;
                    }
                }
                bVar.d(a.l, b.a.a(aVar));
                bVar.b(a.m, b.a.b(aVar));
                bVar.b(a.o, b.a.c(aVar));
                str2 = b.a.d(aVar);
                str3 = b.a.e(aVar);
            }
        } else {
        }
        Locale locale2 = obj11;
        bVar.h(locale2);
        HashMap hashMap = new HashMap(this.a);
        hashMap.put(b.g.name(), str2);
        hashMap.put(b.h.name(), str3);
        super(bVar.a(), locale2, this.d, this.e, this.f, hashMap);
        return obj11;
    }

    @Override // net.time4j.engine.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.class.getName());
        stringBuilder.append("[attributes=");
        stringBuilder.append(this.b);
        stringBuilder.append(",locale=");
        stringBuilder.append(this.c);
        stringBuilder.append(",level=");
        stringBuilder.append(this.d);
        stringBuilder.append(",section=");
        stringBuilder.append(this.e);
        stringBuilder.append(",print-condition=");
        stringBuilder.append(this.f);
        stringBuilder.append(",other=");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
