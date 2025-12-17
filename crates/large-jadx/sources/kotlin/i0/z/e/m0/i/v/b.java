package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.m.n.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.utils.i;
import kotlin.y.i;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class b implements kotlin.i0.z.e.m0.i.v.h {

    public static final kotlin.i0.z.e.m0.i.v.b.a d;
    private final String b;
    private final kotlin.i0.z.e.m0.i.v.h[] c;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.i.v.h a(String string, Iterable<? extends kotlin.i0.z.e.m0.i.v.h> iterable2) {
            Object next;
            kotlin.i0.z.e.m0.i.v.h.b bVar;
            n.f(string, "debugName");
            n.f(iterable2, "scopes");
            i iVar = new i();
            final Iterator obj5 = iterable2.iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                if ((h)next == h.b.b) {
                } else {
                }
                if (next instanceof b) {
                } else {
                }
                iVar.add((h)next);
                p.z(iVar, b.h((b)next));
            }
            return b(string, iVar);
        }

        public final kotlin.i0.z.e.m0.i.v.h b(String string, List<? extends kotlin.i0.z.e.m0.i.v.h> list2) {
            Object bVar;
            int i2;
            int i;
            Object obj4;
            Object obj5;
            n.f(string, "debugName");
            n.f(list2, "scopes");
            int size = list2.size();
            if (size != 0) {
                i = 0;
                if (size != 1) {
                    obj5 = list2.toArray(new h[i]);
                    Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.Array<T>");
                    bVar = new b(string, (h[])obj5, 0);
                } else {
                    bVar = obj4;
                }
            } else {
                bVar = h.b.b;
            }
            return bVar;
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.d = aVar;
    }

    private b(String string, kotlin.i0.z.e.m0.i.v.h[] h2Arr2) {
        super();
        this.b = string;
        this.c = h2Arr2;
    }

    public b(String string, kotlin.i0.z.e.m0.i.v.h[] h2Arr2, g g3) {
        super(string, h2Arr2);
    }

    public static final kotlin.i0.z.e.m0.i.v.h[] h(kotlin.i0.z.e.m0.i.v.b b) {
        return b.c;
    }

    public Collection<t0> a(e e, b b2) {
        kotlin.i0.z.e.m0.i.v.h objArr;
        Collection collection;
        int i;
        int length;
        Collection collection2;
        n.f(e, "name");
        n.f(b2, "location");
        objArr = this.c;
        int length2 = objArr.length;
        if (length2 != 0) {
            if (length2 != 1) {
                collection = 0;
                while (i < objArr.length) {
                    i++;
                    collection = a.a(collection, objArr[i].a(e, b2));
                }
                if (collection == null) {
                    collection = q0.b();
                }
            } else {
                collection = objArr[0].a(e, b2);
            }
        } else {
            collection = p.g();
        }
        return collection;
    }

    public Set<e> b() {
        int i;
        Set set;
        final kotlin.i0.z.e.m0.i.v.h[] objArr = this.c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i = 0;
        while (i < objArr.length) {
            p.y(linkedHashSet, objArr[i].b());
            i++;
        }
        return linkedHashSet;
    }

    public Collection<o0> c(e e, b b2) {
        kotlin.i0.z.e.m0.i.v.h objArr;
        Collection collection;
        int i;
        int length;
        Collection collection2;
        n.f(e, "name");
        n.f(b2, "location");
        objArr = this.c;
        int length2 = objArr.length;
        if (length2 != 0) {
            if (length2 != 1) {
                collection = 0;
                while (i < objArr.length) {
                    i++;
                    collection = a.a(collection, objArr[i].c(e, b2));
                }
                if (collection == null) {
                    collection = q0.b();
                }
            } else {
                collection = objArr[0].c(e, b2);
            }
        } else {
            collection = p.g();
        }
        return collection;
    }

    public Set<e> d() {
        int i;
        Set set;
        final kotlin.i0.z.e.m0.i.v.h[] objArr = this.c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i = 0;
        while (i < objArr.length) {
            p.y(linkedHashSet, objArr[i].d());
            i++;
        }
        return linkedHashSet;
    }

    public Set<e> e() {
        return j.a(i.q(this.c));
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public h f(e e, b b2) {
        int i2;
        int i;
        h hVar;
        boolean z;
        n.f(e, "name");
        n.f(b2, "location");
        kotlin.i0.z.e.m0.i.v.h[] objArr = this.c;
        i2 = 0;
        i = 0;
        while (i < objArr.length) {
            i++;
            hVar = objArr[i].f(e, b2);
            if (hVar != null) {
                break;
            } else {
            }
            if (i2 == 0) {
            }
            i2 = hVar;
        }
        return i2;
    }

    public Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        kotlin.i0.z.e.m0.i.v.h objArr;
        Collection collection;
        int i;
        int length;
        Collection collection2;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        objArr = this.c;
        int length2 = objArr.length;
        if (length2 != 0) {
            if (length2 != 1) {
                collection = 0;
                while (i < objArr.length) {
                    i++;
                    collection = a.a(collection, objArr[i].g(d, l2));
                }
                if (collection == null) {
                    collection = q0.b();
                }
            } else {
                collection = objArr[0].g(d, l2);
            }
        } else {
            collection = p.g();
        }
        return collection;
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public String toString() {
        return this.b;
    }
}
