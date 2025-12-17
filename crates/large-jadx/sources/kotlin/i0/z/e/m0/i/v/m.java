package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.p.a.d;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.utils.a;

/* loaded from: classes3.dex */
public final class m implements kotlin.i0.z.e.m0.i.v.h {

    private final kotlin.i0.z.e.m0.i.v.h b;
    private final a1 c;
    private Map<m, m> d;
    private final h e;

    static final class a extends p implements a<Collection<? extends m>> {

        final kotlin.i0.z.e.m0.i.v.m this$0;
        a(kotlin.i0.z.e.m0.i.v.m m) {
            this.this$0 = m;
            super(0);
        }

        public final Collection<m> a() {
            kotlin.i0.z.e.m0.i.v.m this$0 = this.this$0;
            final int i = 0;
            return m.i(this$0, k.a.a(m.h(this$0), i, i, 3, i));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public m(kotlin.i0.z.e.m0.i.v.h h, a1 a12) {
        n.f(h, "workerScope");
        n.f(a12, "givenSubstitutor");
        super();
        this.b = h;
        y0 obj3 = a12.j();
        n.e(obj3, "givenSubstitutor.substitution");
        this.c = d.f(obj3, false, 1, 0).c();
        obj3 = new m.a(this);
        this.e = j.b(obj3);
    }

    public static final kotlin.i0.z.e.m0.i.v.h h(kotlin.i0.z.e.m0.i.v.m m) {
        return m.b;
    }

    public static final Collection i(kotlin.i0.z.e.m0.i.v.m m, Collection collection2) {
        return m.k(collection2);
    }

    private final Collection<m> j() {
        return (Collection)this.e.getValue();
    }

    private final <D extends m> Collection<D> k(Collection<? extends D> collection) {
        m mVar;
        if (this.c.k()) {
            return collection;
        }
        if (collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet set = a.g(collection.size());
        final Iterator obj3 = collection.iterator();
        for (m next2 : obj3) {
            set.add(l(next2));
        }
        return set;
    }

    private final <D extends m> D l(D d) {
        Object hashMap;
        Object obj;
        a1 a1Var;
        if (this.c.k()) {
            return d;
        }
        if (this.d == null) {
            hashMap = new HashMap();
            this.d = hashMap;
        }
        Map map = this.d;
        n.d(map);
        if (map.get(d) == null) {
            if (!d instanceof w0) {
            } else {
                obj = (w0)d.c(this.c);
                if (obj == null) {
                } else {
                    map.put(d, obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but ");
                stringBuilder.append(d);
                stringBuilder.append(" substitution fails");
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o("Unknown descriptor in scope: ", d).toString());
            throw illegalStateException;
        }
        return (m)obj;
    }

    public Collection<? extends t0> a(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return k(this.b.a(e, b2));
    }

    public Set<e> b() {
        return this.b.b();
    }

    public Collection<? extends o0> c(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return k(this.b.c(e, b2));
    }

    public Set<e> d() {
        return this.b.d();
    }

    public Set<e> e() {
        return this.b.e();
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public h f(e e, b b2) {
        int obj2;
        n.f(e, "name");
        n.f(b2, "location");
        obj2 = this.b.f(e, b2);
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = l(obj2);
        }
        return obj2;
    }

    public Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        return j();
    }
}
