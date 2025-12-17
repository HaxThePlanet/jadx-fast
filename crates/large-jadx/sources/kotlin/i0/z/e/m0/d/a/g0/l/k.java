package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.d.a.e0.a;
import kotlin.i0.z.e.m0.d.a.f0.k;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.q;
import kotlin.i0.z.e.m0.d.a.i0.s;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.l;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.impl.utils.b.b;
import kotlin.reflect.jvm.internal.impl.utils.b.c;
import kotlin.w;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class k extends kotlin.i0.z.e.m0.d.a.g0.l.l {

    private final g n;
    private final kotlin.i0.z.e.m0.d.a.g0.l.f o;

    static final class d implements b.c<e> {

        public static final kotlin.i0.z.e.m0.d.a.g0.l.k.d a;
        static {
            k.d dVar = new k.d();
            k.d.a = dVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$c
        public Iterable a(Object object) {
            return b((e)object);
        }

        public final Iterable<e> b(e e) {
            Collection obj2 = e.g().a();
            n.e(obj2, "it.typeConstructor.supertypes");
            return i.i(i.v(p.M(obj2), k.d.a.a));
        }
    }

    public static final class e extends b.b<e, w> {

        final e a;
        final Set<R> b;
        final l<h, Collection<R>> c;
        e(e e, Set<R> set2, l<? super h, ? extends Collection<? extends R>> l3) {
            this.a = e;
            this.b = set2;
            this.c = l3;
            super();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public Object a() {
            e();
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public boolean c(Object object) {
            return d((e)object);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public boolean d(e e) {
            n.f(e, "current");
            int i = 1;
            if (e == this.a) {
                return i;
            }
            h obj3 = e.R();
            n.e(obj3, "current.staticScope");
            if (obj3 instanceof l) {
                this.b.addAll((Collection)this.c.invoke(obj3));
                return 0;
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public void e() {
        }
    }

    static final class a extends p implements l<q, Boolean> {

        public static final kotlin.i0.z.e.m0.d.a.g0.l.k.a a;
        static {
            k.a aVar = new k.a();
            k.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(q q) {
            n.f(q, "it");
            return q.i();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((q)object));
        }
    }

    static final class b extends p implements l<h, Collection<? extends o0>> {

        final e $name;
        b(e e) {
            this.$name = e;
            super(1);
        }

        public final Collection<? extends o0> a(h h) {
            n.f(h, "it");
            return h.c(this.$name, d.WHEN_GET_SUPER_MEMBERS);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((h)object);
        }
    }

    static final class c extends p implements l<h, Collection<? extends e>> {

        public static final kotlin.i0.z.e.m0.d.a.g0.l.k.c a;
        static {
            k.c cVar = new k.c();
            k.c.a = cVar;
        }

        c() {
            super(1);
        }

        public final Collection<e> a(h h) {
            n.f(h, "it");
            return h.d();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((h)object);
        }
    }
    public k(g g, g g2, kotlin.i0.z.e.m0.d.a.g0.l.f f3) {
        n.f(g, "c");
        n.f(g2, "jClass");
        n.f(f3, "ownerDescriptor");
        super(g);
        this.n = g2;
        this.o = f3;
    }

    private final <R> Set<R> N(e e, Set<R> set2, l<? super h, ? extends Collection<? extends R>> l3) {
        k.e eVar = new k.e(e, set2, l3);
        b.b(p.b(e), k.d.a, eVar);
        return set2;
    }

    private final o0 P(o0 o0) {
        int i;
        String str;
        if (o0.f().isReal()) {
            return o0;
        }
        Collection obj4 = o0.e();
        n.e(obj4, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(p.r(obj4, 10));
        obj4 = obj4.iterator();
        for (o0 next2 : obj4) {
            n.e(next2, "it");
            arrayList.add(P(next2));
        }
        return (o0)p.z0(p.O(arrayList));
    }

    private final Set<t0> Q(e e, e e2) {
        final kotlin.i0.z.e.m0.d.a.g0.l.k obj3 = k.c(e2);
        if (obj3 == null) {
            return q0.b();
        }
        return p.P0(obj3.a(e, d.WHEN_GET_SUPER_MEMBERS));
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected m C() {
        return O();
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected kotlin.i0.z.e.m0.d.a.g0.l.a M() {
        a aVar = new a(this.n, k.a.a);
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected kotlin.i0.z.e.m0.d.a.g0.l.f O() {
        return this.o;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    public h f(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return null;
    }

    protected Set<e> l(d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        return q0.b();
    }

    protected Set<e> n(d d, l<? super e, Boolean> l2) {
        int i;
        e eVar;
        Set obj4;
        n.f(d, "kindFilter");
        Set obj3 = p.O0((b)y().invoke().a());
        obj4 = k.c(O());
        if (obj4 == null) {
            obj4 = 0;
        } else {
            obj4 = obj4.b();
        }
        if (obj4 != null) {
        } else {
            obj4 = q0.b();
        }
        obj3.addAll(obj4);
        if (this.n.B()) {
            obj4 = new e[2];
            obj3.addAll(p.j(k.c, k.b));
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected kotlin.i0.z.e.m0.d.a.g0.l.b p() {
        return M();
    }

    protected void r(Collection<t0> collection, e e2) {
        boolean str;
        Object obj9;
        n.f(collection, "result");
        n.f(e2, "name");
        Collection collection2 = a.e(e2, Q(e2, O()), collection, O(), w().a().c(), w().a().j().a());
        n.e(collection2, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(collection2);
        if (this.n.B()) {
            if (n.b(e2, k.c)) {
                obj9 = c.d(O());
                n.e(obj9, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(obj9);
            } else {
                if (n.b(e2, k.b)) {
                    obj9 = c.e(O());
                    n.e(obj9, "createEnumValuesMethod(ownerDescriptor)");
                    collection.add(obj9);
                }
            }
        }
    }

    protected void s(e e, Collection<o0> collection2) {
        Object iterator;
        Object arrayList2;
        boolean linkedHashSet;
        boolean next;
        Object str;
        Object arrayList;
        Object obj;
        Object obj2;
        kotlin.i0.z.e.m0.j.b.p pVar;
        kotlin.i0.z.e.m0.i.j jVar;
        Object obj10;
        n.f(e, "name");
        n.f(collection2, "result");
        linkedHashSet = new LinkedHashSet();
        k.b bVar3 = new k.b(e);
        N(O(), linkedHashSet, bVar3);
        if (empty ^= 1 != 0) {
            obj10 = a.e(e, linkedHashSet, collection2, O(), w().a().c(), w().a().j().a());
            n.e(obj10, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection2.addAll(obj10);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator iterator2 = linkedHashSet.iterator();
            while (iterator2.hasNext()) {
                linkedHashSet = iterator2.next();
                str = P((o0)linkedHashSet);
                if (linkedHashMap.get(str) == null) {
                }
                (List)arrayList.add(linkedHashSet);
                arrayList = new ArrayList();
                linkedHashMap.put(str, arrayList);
            }
            arrayList2 = new ArrayList();
            iterator = linkedHashMap.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                next = a.e(e, (Collection)next2.getValue(), collection2, O(), w().a().c(), w().a().j().a());
                n.e(next, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
                p.y(arrayList2, next);
            }
            collection2.addAll(arrayList2);
        }
    }

    protected Set<e> t(d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        Set obj2 = p.O0((b)y().invoke().e());
        N(O(), obj2, k.c.a);
        return obj2;
    }
}
