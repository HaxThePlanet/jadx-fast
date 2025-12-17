package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.n;
import kotlin.i0.z.e.m0.i.v.n.a;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.l1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;
import kotlin.z.a;

/* loaded from: classes3.dex */
public final class a0 implements kotlin.i0.z.e.m0.l.t0, g {

    private kotlin.i0.z.e.m0.l.b0 a;
    private final LinkedHashSet<kotlin.i0.z.e.m0.l.b0> b;
    private final int c;

    public static final class b implements Comparator<T> {
        public final int compare(T t, T t2) {
            return a.c((b0)t.toString(), (b0)t2.toString());
        }
    }

    static final class a extends p implements l<g, kotlin.i0.z.e.m0.l.i0> {

        final kotlin.i0.z.e.m0.l.a0 this$0;
        a(kotlin.i0.z.e.m0.l.a0 a0) {
            this.this$0 = a0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.i0 a(g g) {
            n.f(g, "kotlinTypeRefiner");
            return this.this$0.j(g).g();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }
    public a0(Collection<? extends kotlin.i0.z.e.m0.l.b0> collection) {
        n.f(collection, "typesToIntersect");
        super();
        collection.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    private a0(Collection<? extends kotlin.i0.z.e.m0.l.b0> collection, kotlin.i0.z.e.m0.l.b0 b02) {
        super(collection);
        this.a = b02;
    }

    private final String i(Iterable<? extends kotlin.i0.z.e.m0.l.b0> iterable) {
        a0.b bVar = new a0.b();
        return p.h0(p.D0(iterable, bVar), " & ", "{", "}", 0, 0, 0, 56, 0);
    }

    public Collection<kotlin.i0.z.e.m0.l.b0> a() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public kotlin.i0.z.e.m0.l.t0 b(g g) {
        return j(g);
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public h c() {
        return null;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public boolean d() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof a0) {
            return 0;
        }
        return n.b(this.b, object.b);
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public final h f() {
        return n.c.a("member scope for intersection type", this.b);
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public final kotlin.i0.z.e.m0.l.i0 g() {
        kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
        a0.a aVar2 = new a0.a(this);
        return c0.k(g.q.b(), this, p.g(), false, f(), aVar2);
    }

    public List<z0> getParameters() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public final kotlin.i0.z.e.m0.l.b0 h() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public int hashCode() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public kotlin.i0.z.e.m0.l.a0 j(g g) {
        kotlin.i0.z.e.m0.l.a0 i3;
        int i2;
        int i;
        Object obj5;
        n.f(g, "kotlinTypeRefiner");
        Collection collection = a();
        ArrayList arrayList = new ArrayList(p.r(collection, 10));
        Iterator iterator = collection.iterator();
        i2 = 0;
        for (b0 next : iterator) {
            arrayList.add(next.N0(g));
            i2 = i;
        }
        i3 = 0;
        if (i2 == 0) {
        } else {
            i2 = h();
            if (i2 == null) {
            } else {
                i3 = i2.N0(g);
            }
            obj5 = new a0(arrayList);
            i3 = obj5.k(i3);
        }
        if (i3 == null) {
            i3 = this;
        }
        return i3;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public final kotlin.i0.z.e.m0.l.a0 k(kotlin.i0.z.e.m0.l.b0 b0) {
        a0 a0Var = new a0(this.b, b0);
        return a0Var;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public h m() {
        h hVar = (b0)this.b.iterator().next().L0().m();
        n.e(hVar, "intersectedTypes.iterator().next().constructor.builtIns");
        return hVar;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public String toString() {
        return i(this.b);
    }
}
