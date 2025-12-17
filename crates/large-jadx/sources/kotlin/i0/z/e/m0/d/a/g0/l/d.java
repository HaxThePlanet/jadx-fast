package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.c.a;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.j;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.m.n.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.y.i;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class d implements h {

    static final l<Object>[] f;
    private final g b;
    private final kotlin.i0.z.e.m0.d.a.g0.l.h c;
    private final kotlin.i0.z.e.m0.d.a.g0.l.i d;
    private final i e;

    static final class a extends p implements a<h[]> {

        final kotlin.i0.z.e.m0.d.a.g0.l.d this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.l.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final h[] a() {
            h hVar;
            e eVar;
            kotlin.i0.z.e.m0.d.a.g0.l.h hVar2;
            kotlin.i0.z.e.m0.d.a.g0.l.d this$02 = this.this$0;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = d.i(this.this$0).L0().values().iterator();
            while (iterator.hasNext()) {
                hVar = d.h(this$02).a().b().d(d.i(this$02), (o)iterator.next());
                if (hVar != null) {
                }
                arrayList.add(hVar);
            }
            Object[] array = a.b(arrayList).toArray(new h[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (h[])array;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;");
        d.f = arr;
    }

    public d(g g, u u2, kotlin.i0.z.e.m0.d.a.g0.l.h h3) {
        n.f(g, "c");
        n.f(u2, "jPackage");
        n.f(h3, "packageFragment");
        super();
        this.b = g;
        this.c = h3;
        i iVar = new i(g, u2, h3);
        this.d = iVar;
        d.a obj3 = new d.a(this);
        this.e = g.e().d(obj3);
    }

    public static final g h(kotlin.i0.z.e.m0.d.a.g0.l.d d) {
        return d.b;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.l.h i(kotlin.i0.z.e.m0.d.a.g0.l.d d) {
        return d.c;
    }

    private final h[] k() {
        return (h[])m.a(this.e, this, d.f[0]);
    }

    public Collection<t0> a(e e, b b2) {
        Collection collection2;
        int i;
        Collection collection;
        n.f(e, "name");
        n.f(b2, "location");
        l(e, b2);
        final h[] objArr = k();
        collection2 = this.d.a(e, b2);
        i = 0;
        while (i < objArr.length) {
            i++;
            collection2 = a.a(collection2, objArr[i].a(e, b2));
        }
        if (collection2 == null) {
            collection2 = q0.b();
        }
        return collection2;
    }

    public Set<e> b() {
        int i;
        Set set;
        h[] objArr = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i = 0;
        while (i < objArr.length) {
            p.y(linkedHashSet, objArr[i].b());
            i++;
        }
        linkedHashSet.addAll(j().b());
        return linkedHashSet;
    }

    public Collection<o0> c(e e, b b2) {
        Collection collection;
        int i;
        Collection collection2;
        n.f(e, "name");
        n.f(b2, "location");
        l(e, b2);
        final h[] objArr = k();
        collection = this.d.c(e, b2);
        i = 0;
        while (i < objArr.length) {
            i++;
            collection = a.a(collection, objArr[i].c(e, b2));
        }
        if (collection == null) {
            collection = q0.b();
        }
        return collection;
    }

    public Set<e> d() {
        int i;
        Set set;
        h[] objArr = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i = 0;
        while (i < objArr.length) {
            p.y(linkedHashSet, objArr[i].d());
            i++;
        }
        linkedHashSet.addAll(j().d());
        return linkedHashSet;
    }

    public Set<e> e() {
        int set;
        Set set2;
        set = j.a(i.q(k()));
        if (set == null) {
            set = 0;
        } else {
            set.addAll(j().e());
        }
        return set;
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public h f(e e, b b2) {
        int i2;
        int i;
        h hVar;
        boolean z;
        n.f(e, "name");
        n.f(b2, "location");
        l(e, b2);
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.d.P(e, b2);
        if (eVar != null) {
            return eVar;
        }
        h[] objArr = k();
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

    public Collection<m> g(d d, l<? super e, Boolean> l2) {
        Collection collection2;
        int i;
        Collection collection;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        final h[] objArr = k();
        collection2 = this.d.g(d, l2);
        i = 0;
        while (i < objArr.length) {
            i++;
            collection2 = a.a(collection2, objArr[i].g(d, l2));
        }
        if (collection2 == null) {
            collection2 = q0.b();
        }
        return collection2;
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public final kotlin.i0.z.e.m0.d.a.g0.l.i j() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public void l(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        a.b(this.b.a().k(), b2, this.c, e);
    }
}
