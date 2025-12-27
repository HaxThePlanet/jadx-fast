package net.time4j.g1.z;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import net.time4j.engine.c;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.w;
import net.time4j.g1.a;
import net.time4j.g1.a.b;
import net.time4j.g1.g;
import net.time4j.g1.i;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.v;
import net.time4j.h1.f;

/* compiled from: AttributeSet.java */
/* loaded from: classes3.dex */
final class b implements net.time4j.engine.d {

    static final c<String> g;
    static final c<String> h;
    private static final i i;
    private static final char j = 44;
    private static final ConcurrentMap<String, b.a> k = new ConcurrentHashMap<>();
    private static final b.a l;
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
        a(j jVar, char c, char c2, String str, String str2) {
            super();
            this.a = jVar;
            this.b = c;
            this.c = c2;
            this.d = str;
            this.e = str2;
        }

        static /* synthetic */ j a(b.a aVar) {
            return aVar.a;
        }

        static /* synthetic */ char b(b.a aVar) {
            return aVar.b;
        }

        static /* synthetic */ char c(b.a aVar) {
            return aVar.c;
        }

        static /* synthetic */ String d(b.a aVar) {
            return aVar.d;
        }

        static /* synthetic */ String e(b.a aVar) {
            return aVar.e;
        }
    }
    static {
        int i = 46;
        int i2 = 0;
        int length = 0;
        Class<String> obj = String.class;
        b.g = a.e("PLUS_SIGN", obj);
        b.h = a.e("MINUS_SIGN", obj);
        Iterator it = d.c().g(i.class).iterator();
        i2 = 0;
        length = 0;
        while (it.hasNext()) {
            Object item = it.next();
            length = item.c().length;
        }
        if (i.class == 0) {
            f fVar = f.d;
        }
        b.i = i2;
        int r0 = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44;
        b.a aVar = new b.a(j.ARABIC, '0', (Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44), "+", "-");
        b.l = r0;
    }

    b(a aVar, Locale locale) {
        this(aVar, locale, 0, 0, null);
    }

    static b d(w<?> wVar, a aVar, Locale locale) {
        final a.b bVar = new a.b(wVar);
        bVar.d(a.f, g.SMART);
        bVar.d(a.g, v.WIDE);
        bVar.d(a.h, m.FORMAT);
        bVar.b(a.p, ' ');
        bVar.f(aVar);
        return new b(bVar.a(), locale).n(locale);
    }

    private static boolean j(Object object, Object object2) {
        boolean equals = false;
        if (object == null) {
            object = object2 == null ? 1 : 0;
        } else {
            object = object.equals(object2);
        }
        return (object2 == null ? 1 : 0);
    }

    static b k(b bVar, b bVar2) {
        final HashMap hashMap = new HashMap();
        hashMap.putAll(bVar2.a);
        hashMap.putAll(bVar.a);
        a.b bVar3 = new a.b();
        bVar3.f(bVar2.b);
        bVar3.f(bVar.b);
        b bVar22 = new b(bVar3.a(), Locale.ROOT, 0, 0, null, hashMap);
        return bVar22.n(bVar.c);
    }

    public <A> A a(c<A> cVar, A a) {
        if (this.a.containsKey(cVar.name())) {
            return cVar.a().cast(this.a.get(cVar.name()));
        }
        return this.b.a(cVar, a);
    }

    public <A> A b(c<A> cVar) {
        if (this.a.containsKey(cVar.name())) {
            return cVar.a().cast(this.a.get(cVar.name()));
        }
        return this.b.b(cVar);
    }

    public boolean c(c<?> cVar) {
        if (this.a.containsKey(cVar.name())) {
            return true;
        }
        return this.b.c(cVar);
    }

    a e() {
        return this.b;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        a aVar;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof b) {
            if (this.b.equals(object.b)) {
                if (this.c.equals(object.c)) {
                    if (this.d == object.d) {
                        if (this.e == object.e) {
                            if (b.j(this.f, object.f)) {
                                if (!(this.a.equals(object.a))) {
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    n<o> f() {
        return this.f;
    }

    int g() {
        return this.d;
    }

    Locale h() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.b.hashCode() * 7) + (this.a.hashCode() * 37);
    }

    int i() {
        return this.e;
    }

    b l(a aVar) {
        b bVar = new b(aVar, this.c, this.d, this.e, this.f, this.a);
        return bVar;
    }

    <A> b m(c<A> cVar, A a) {
        final HashMap hashMap = new HashMap(this.a);
        if (a == null) {
            hashMap.remove(cVar.name());
        } else {
            hashMap.put(cVar.name(), a);
        }
        b cVar2 = new b(this.b, this.c, this.d, this.e, this.f, hashMap);
        return cVar2;
    }

    b n(Locale locale) {
        String str;
        String alias;
        String str2;
        net.time4j.g1.z.b.a aVar;
        boolean empty2;
        j jVar;
        char c;
        char c2;
        String str3;
        String str4;
        Locale locale3;
        final a.b bVar = new a.b();
        bVar.f(this.b);
        alias = d.getAlias(locale);
        String country = locale.getCountry();
        if (!alias.isEmpty() || !country.isEmpty()) {
            if (!country.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "_";
                alias = alias + str5 + country;
            }
            if ((b.a)b.k.get(alias) == null) {
                try {
                    i iVar = b.i;
                    aVar = new b.a(iVar.a(locale), iVar.f(locale), iVar.d(locale), iVar.e(locale), iVar.b(locale));
                } catch (RuntimeException unused) {
                }
                Object ifAbsent = b.k.putIfAbsent(alias, aVar);
                if (ifAbsent != null) {
                }
            }
            bVar.d(a.l, aVar.a);
            bVar.b(a.m, aVar.b);
            bVar.b(a.o, aVar.c);
            str = aVar.d;
            str2 = aVar.e;
        } else {
            locale3 = Locale.ROOT;
            bVar.d(a.l, j.ARABIC);
            bVar.b(a.o, b.j);
            str = "+";
            str2 = "-";
        }
        bVar.h(locale3);
        final HashMap hashMap = new HashMap(this.a);
        hashMap.put(b.g.name(), str);
        hashMap.put(b.h.name(), str2);
        b locale2 = new b(bVar.a(), locale3, this.d, this.e, this.f, hashMap);
        return locale2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = b.class.getName();
        String str2 = "[attributes=";
        String str3 = ",locale=";
        String str4 = ",level=";
        String str5 = ",section=";
        String str6 = ",print-condition=";
        String str7 = ",other=";
        str = name + str2 + this.b + str3 + this.c + str4 + this.d + str5 + this.e + str6 + this.f + str7 + this.a + 93;
        return str;
    }

    b(a aVar, Locale locale, int i, int i2, n<o> nVar) {
        Locale rOOT2;
        super();
        Objects.requireNonNull(aVar, "Missing format attributes.");
        this.b = aVar;
        rOOT2 = locale == null ? Locale.ROOT : rOOT2;
        this.c = rOOT2;
        this.d = i;
        this.e = i2;
        this.f = nVar;
        this.a = Collections.emptyMap();
    }

    private b(a aVar, Locale locale, int i, int i2, n<o> nVar, Map<String, Object> map) {
        Locale rOOT2;
        super();
        Objects.requireNonNull(aVar, "Missing format attributes.");
        this.b = aVar;
        rOOT2 = locale == null ? Locale.ROOT : rOOT2;
        this.c = rOOT2;
        this.d = i;
        this.e = i2;
        this.f = nVar;
        this.a = Collections.unmodifiableMap(map);
    }
}
