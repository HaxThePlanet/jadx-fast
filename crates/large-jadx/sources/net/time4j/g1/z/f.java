package net.time4j.g1.z;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.s;
import net.time4j.engine.w;

/* compiled from: CustomizedProcessor.java */
/* loaded from: classes3.dex */
final class f<V> implements h<V> {

    private static final s<o, Void> z = new f$a<>();
    private final p<V> a;
    private final e<V> b;
    private final d<V> c;
    private final boolean v;
    private boolean w;
    private boolean x;
    private boolean y;

    static class a implements s<o, Void> {
        a() {
            super();
        }

        public Void a(o oVar) {
            return null;
        }
    }

    f(p<V> pVar, e<V> eVar, d<V> dVar) {
        this(pVar, eVar, dVar, false, false, false);
    }

    private static Map<p<?>, Object> a(Map<p<?>, Object> map, c<?> cVar) {
        final HashMap hashMap = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return hashMap;
    }

    private static <T> Set<g> c(c<T> cVar, Object object, StringBuilder sb, d dVar) {
        return cVar.J(cVar.q().l().cast(object), sb, dVar);
    }

    boolean b() {
        return this.y;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        p pVar;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof f) {
            if (this.a.equals(object.a)) {
                if (this.b.equals(object.b)) {
                    if (!(this.c.equals(object.c))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 7) + (this.b.hashCode() * 31) + (this.c.hashCode() * 37);
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int i;
        Class<Integer> obj;
        if (this.x && this.x) {
            dVar = (c)c.class.cast(this.c).o();
        }
        Object obj3 = this.c.b(charSequence, sVar, dVar);
        if (obj3 == null) {
            sVar.k(sVar.f(), sVar.d());
        } else {
            if (this.y) {
                if (tVar instanceof u) {
                    tVar.L(obj3);
                } else {
                    q qVar = sVar.g();
                    Iterator it = qVar.A().iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                        obj = Integer.class;
                    }
                    tVar.K(this.a, obj3);
                }
            }
        }
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        net.time4j.g1.z.e eVar;
        boolean z2;
        int i;
        Class<net.time4j.g1.z.c> obj2 = c.class;
        if (this.w && this.w) {
            dVar = (c)obj2.cast(this.b).o();
        }
        if (this.v && oVar instanceof b1 && set == null) {
            (c)this.b.K(oVar, appendable, dVar, false);
            return 0x7fffffff /* Unknown resource */;
        }
        Object obj = oVar.p(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        z = appendable instanceof CharSequence;
        if (!(appendable instanceof CharSequence) || set == null) {
            this.b.a(obj, stringBuilder, dVar, f.z);
        } else {
            int length2 = (CharSequence)appendable.length();
            z2 = eVar instanceof c;
            if (eVar instanceof c) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = f.c((c)obj2.cast(this.b), obj, stringBuilder, dVar).iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    i = item.c() + length2;
                    linkedHashSet.add(new g(item.a(), i, item.b() + length2));
                }
                set.addAll(linkedHashSet);
            } else {
                this.b.a(obj, stringBuilder, dVar, f.z);
            }
            set.add(new g(this.a, length2, stringBuilder.length() + length2));
        }
        appendable.append(stringBuilder);
        return stringBuilder.length();
    }

    public h<V> quickPath(c<?> cVar, d dVar, int i) {
        boolean equals;
        Class cls;
        net.time4j.g1.z.c cVar2;
        net.time4j.g1.z.c cVar4;
        boolean z5;
        boolean z6;
        boolean z7;
        cast = c.class;
        i = 1;
        final int i2 = 0;
        if (cVar.z()) {
            int r9 = this.a.getType().equals(cVar.q().l()) ? i : i2;
        }
        if (dVar instanceof b) {
            Map map2 = cVar.r();
            if (eVar2 instanceof c) {
                Object cast2 = cast.cast(this.b);
            } else {
            }
            if (dVar4 instanceof c) {
                Object cast = cast.cast(this.c);
            } else {
            }
            f cVar3 = new f(this.a, cVar2, cVar4, z5, z6, z7);
            return cVar3;
        }
        return new f(this.a, this.b, this.c);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = f.class.getName();
        String str2 = "[element=";
        String name2 = this.a.name();
        String str3 = ", printer=";
        String str4 = ", parser=";
        str = 64 + name + str2 + name2 + str3 + this.b + str4 + this.c + 93;
        return str;
    }

    public h<V> withElement(p<V> pVar) {
        if (this.a == pVar) {
            return this;
        }
        return new f(pVar, this.b, this.c);
    }

    private f(p<V> pVar, e<V> eVar, d<V> dVar, boolean z, boolean z2, boolean z3) {
        int i = 0;
        super();
        Objects.requireNonNull(pVar, "Missing element.");
        Objects.requireNonNull(eVar, "Missing printer.");
        Objects.requireNonNull(dVar, "Missing parser.");
        this.a = pVar;
        this.b = eVar;
        this.c = dVar;
        z = eVar instanceof c;
        if (eVar instanceof c) {
            pVar = pVar.getType() == b0.class ? 1 : 0;
        }
        this.v = (pVar.getType() == b0.class ? 1 : 0);
        this.w = z;
        this.x = z2;
        this.y = z3;
    }

    public boolean isNumerical() {
        return false;
    }
}
