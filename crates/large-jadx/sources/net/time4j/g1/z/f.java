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

/* loaded from: classes3.dex */
final class f<V>  implements net.time4j.g1.z.h<V> {

    private static final s<o, Void> z;
    private final p<V> a;
    private final net.time4j.g1.z.e<V> b;
    private final net.time4j.g1.z.d<V> c;
    private final boolean v;
    private boolean w;
    private boolean x;
    private boolean y;

    static class a implements s<o, Void> {
        @Override // net.time4j.engine.s
        public Void a(o o) {
            return null;
        }

        @Override // net.time4j.engine.s
        public Object apply(Object object) {
            return a((o)object);
        }
    }
    static {
        f.a aVar = new f.a();
        f.z = aVar;
    }

    f(p<V> p, net.time4j.g1.z.e<V> e2, net.time4j.g1.z.d<V> d3) {
        super(p, e2, d3, 0, 0, 0);
    }

    private f(p<V> p, net.time4j.g1.z.e<V> e2, net.time4j.g1.z.d<V> d3, boolean z4, boolean z5, boolean z6) {
        Object obj2;
        boolean obj3;
        super();
        Objects.requireNonNull(p, "Missing element.");
        Objects.requireNonNull(e2, "Missing printer.");
        Objects.requireNonNull(d3, "Missing parser.");
        this.a = p;
        this.b = e2;
        this.c = d3;
        if (e2 instanceof c && p.getType() == b0.class) {
            obj2 = p.getType() == b0.class ? 1 : 0;
        } else {
        }
        this.v = obj2;
        this.w = z4;
        this.x = z5;
        this.y = z6;
    }

    private static Map<p<?>, Object> a(Map<p<?>, Object> map, net.time4j.g1.z.c<?> c2) {
        Object next;
        boolean z;
        HashMap hashMap = new HashMap();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (c2.q().x((p)next)) {
            }
            hashMap.put(next, map.get(next));
        }
        return hashMap;
    }

    private static <T> Set<net.time4j.g1.z.g> c(net.time4j.g1.z.c<T> c, Object object2, StringBuilder stringBuilder3, d d4) {
        return c.J(c.q().l().cast(object2), stringBuilder3, d4);
    }

    @Override // net.time4j.g1.z.h
    boolean b() {
        return this.y;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object pVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof f) {
            if (this.a.equals(object.a) && this.b.equals(object.b) && this.c.equals(object.c)) {
                if (this.b.equals(object.b)) {
                    if (this.c.equals(object.c)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return i3 += i8;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        boolean next;
        int i;
        Class<Integer> obj;
        Object obj5;
        d obj7;
        boolean obj9;
        if (z5 && this.x) {
            if (this.x) {
                obj7 = (c)c.class.cast(this.c).o();
            }
        }
        obj5 = this.c.b(charSequence, s2, obj7);
        if (obj5 == null) {
            s2.k(s2.f(), s2.d());
        } else {
            if (this.y && t4 instanceof u) {
                try {
                    if (t4 instanceof u) {
                    } else {
                    }
                    t4.L(obj5);
                    obj7 = s2.g();
                    obj9 = obj7.A().iterator();
                    while (obj9.hasNext()) {
                        next = obj9.next();
                        if ((p)next.getType() == Integer.class) {
                        } else {
                        }
                        t4.K(next, obj7.p(next));
                        t4.J(next, obj7.e(next));
                    }
                    next = obj9.next();
                    if ((p)next.getType() == Integer.class) {
                    } else {
                    }
                    t4.J(next, obj7.e(next));
                    t4.K(next, obj7.p(next));
                    t4.K(this.a, obj5);
                    charSequence = charSequence.getMessage();
                    s2.k(obj0, charSequence);
                }
            } else {
            }
        }
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        s sVar;
        s next;
        Object cast;
        boolean length;
        net.time4j.g1.z.e gVar;
        boolean z;
        int i;
        Object obj6;
        d obj8;
        net.time4j.g1.z.e obj9;
        boolean obj10;
        Class<net.time4j.g1.z.c> obj = c.class;
        if (z5 && this.w) {
            if (this.w) {
                obj8 = (c)obj.cast(this.b).o();
            }
        }
        if (this.v && o instanceof b1 && set4 == null) {
            if (o instanceof b1) {
                if (set4 == null) {
                    (c)this.b.K(o, appendable2, obj8, false);
                    return Integer.MAX_VALUE;
                }
            }
        }
        obj6 = o.p(this.a);
        obj10 = new StringBuilder();
        if (appendable2 instanceof CharSequence && set4 != null) {
            if (set4 != null) {
                length = (CharSequence)appendable2.length();
                gVar = this.b;
                if (gVar instanceof c) {
                    obj8 = new LinkedHashSet();
                    obj6 = f.c((c)obj.cast(gVar), obj6, obj10, obj8).iterator();
                    for (g next2 : obj6) {
                        gVar = new g(next2.a(), i3 += length, i2 += length);
                        obj8.add(gVar);
                    }
                    set4.addAll(obj8);
                } else {
                    gVar.a(obj6, obj10, obj8, f.z);
                }
                obj6 = new g(this.a, length, length2 += length);
                set4.add(obj6);
            } else {
                this.b.a(obj6, obj10, obj8, f.z);
            }
        } else {
        }
        appendable2.append(obj10);
        return obj10.length();
    }

    public net.time4j.g1.z.h<V> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        boolean equals;
        net.time4j.g1.z.e eVar;
        Class cls;
        Object eVar2;
        net.time4j.g1.z.e cVar;
        net.time4j.g1.z.d dVar;
        int i;
        int i2;
        int i4;
        boolean obj11;
        Object obj13;
        obj13 = c.class;
        final int i5 = 1;
        final int i6 = 0;
        if (c.z() && this.a.getType().equals(c.q().l())) {
            i4 = this.a.getType().equals(c.q().l()) ? i5 : i6;
        } else {
        }
        if (d2 instanceof b) {
            obj11 = c.r();
            eVar2 = this.b;
            if (eVar2 instanceof c) {
                Object cast = obj13.cast(eVar2);
                cVar = eVar;
                i = i5;
            } else {
                cVar = eVar;
                i = i6;
            }
            net.time4j.g1.z.d dVar3 = this.c;
            if (dVar3 instanceof c) {
                obj13 = obj13.cast(dVar3);
                dVar = obj11;
                i2 = i5;
            } else {
                i2 = i6;
                dVar = dVar4;
            }
            super(this.a, cVar, dVar, i, i2, i4);
            return obj11;
        }
        if (!this.w && this.x) {
            if (this.x) {
            }
            return this;
        }
        obj11 = new f(this.a, this.b, this.c);
        return obj11;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(f.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.a.name());
        stringBuilder.append(", printer=");
        stringBuilder.append(this.b);
        stringBuilder.append(", parser=");
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<V> withElement(p<V> p) {
        if (this.a == p) {
            return this;
        }
        f fVar = new f(p, this.b, this.c);
        return fVar;
    }
}
