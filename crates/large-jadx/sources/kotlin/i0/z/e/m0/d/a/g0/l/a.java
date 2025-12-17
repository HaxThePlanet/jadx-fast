package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h0.g;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.n;
import kotlin.i0.z.e.m0.d.a.i0.p;
import kotlin.i0.z.e.m0.d.a.i0.q;
import kotlin.i0.z.e.m0.d.a.i0.r;
import kotlin.i0.z.e.m0.d.a.i0.t;
import kotlin.i0.z.e.m0.d.a.i0.w;
import kotlin.i0.z.e.m0.f.e;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class a implements kotlin.i0.z.e.m0.d.a.g0.l.b {

    private final g a;
    private final l<q, Boolean> b;
    private final l<r, Boolean> c;
    private final Map<e, List<r>> d;
    private final Map<e, n> e;
    private final Map<e, w> f;

    static final class a extends p implements l<r, Boolean> {

        final kotlin.i0.z.e.m0.d.a.g0.l.a this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.l.a a) {
            this.this$0 = a;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(r r) {
            Object obj2;
            n.f(r, "m");
            if ((Boolean)a.g(this.this$0).invoke(r).booleanValue() && !p.c(r)) {
                obj2 = !p.c(r) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((r)object));
        }
    }
    public a(g g, l<? super q, Boolean> l2) {
        String next3;
        boolean next;
        ArrayList arrayList;
        e name;
        boolean next2;
        Object booleanValue;
        n.f(g, "jClass");
        n.f(l2, "memberFilter");
        super();
        this.a = g;
        this.b = l2;
        a.a obj5 = new a.a(this);
        this.c = obj5;
        obj5 = new LinkedHashMap();
        Iterator obj4 = i.l(p.M(g.M()), obj5).iterator();
        while (obj4.hasNext()) {
            next3 = obj4.next();
            name = (r)next3.getName();
            if (obj5.get(name) == null) {
            }
            (List)booleanValue.add(next3);
            booleanValue = new ArrayList();
            obj5.put(name, booleanValue);
        }
        this.d = obj5;
        obj5 = new LinkedHashMap();
        obj4 = i.l(p.M(this.a.D()), this.b).iterator();
        for (Object next : obj4) {
            obj5.put((n)next.getName(), next);
        }
        this.e = obj5;
        arrayList = new ArrayList();
        obj4 = this.a.l().iterator();
        while (obj4.hasNext()) {
            name = obj4.next();
            if ((Boolean)this.b.invoke(name).booleanValue()) {
            }
            arrayList.add(name);
        }
        obj5 = new LinkedHashMap(g.b(j0.d(p.r(arrayList, 10)), 16));
        obj4 = arrayList.iterator();
        for (Object arrayList : obj4) {
            obj5.put((w)arrayList.getName(), arrayList);
        }
        this.f = obj5;
    }

    public static final l g(kotlin.i0.z.e.m0.d.a.g0.l.a a) {
        return a.b;
    }

    public Set<e> a() {
        e name;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = i.l(p.M(this.a.M()), this.c).iterator();
        for (t next2 : iterator) {
            linkedHashSet.add(next2.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.b
    public w b(e e) {
        n.f(e, "name");
        return (w)this.f.get(e);
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.b
    public n c(e e) {
        n.f(e, "name");
        return (n)this.e.get(e);
    }

    public Set<e> d() {
        return this.f.keySet();
    }

    public Set<e> e() {
        e name;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = i.l(p.M(this.a.D()), this.b).iterator();
        for (t next2 : iterator) {
            linkedHashSet.add(next2.getName());
        }
        return linkedHashSet;
    }

    public Collection<r> f(e e) {
        Object obj2;
        n.f(e, "name");
        if ((List)this.d.get(e) == null) {
            obj2 = p.g();
        }
        return obj2;
    }
}
