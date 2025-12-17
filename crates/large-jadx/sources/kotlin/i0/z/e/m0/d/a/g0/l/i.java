package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.i0.c0;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.t;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.d.a.q;
import kotlin.i0.z.e.m0.d.a.q.a;
import kotlin.i0.z.e.m0.d.a.r;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.d.b.a0.a.a;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.d.b.m;
import kotlin.i0.z.e.m0.d.b.m.a;
import kotlin.i0.z.e.m0.d.b.m.a.a;
import kotlin.i0.z.e.m0.d.b.n;
import kotlin.i0.z.e.m0.d.b.o;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.g;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.d.a;
import kotlin.i0.z.e.m0.k.h;
import kotlin.i0.z.e.m0.k.j;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.z;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.utils.d;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class i extends kotlin.i0.z.e.m0.d.a.g0.l.l {

    private final u n;
    private final kotlin.i0.z.e.m0.d.a.g0.l.h o;
    private final j<Set<String>> p;
    private final h<kotlin.i0.z.e.m0.d.a.g0.l.i.a, e> q;

    private static final class a {

        private final e a;
        private final g b;
        public a(e e, g g2) {
            n.f(e, "name");
            super();
            this.a = e;
            this.b = g2;
        }

        public final g a() {
            return this.b;
        }

        public final e b() {
            return this.a;
        }

        public boolean equals(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof i.a && n.b(this.a, object.a)) {
                obj2 = n.b(this.a, object.a) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private static abstract class b {
        public b(g g) {
            super();
        }
    }

    static final class c extends p implements l<kotlin.i0.z.e.m0.d.a.g0.l.i.a, e> {

        final g $c;
        final kotlin.i0.z.e.m0.d.a.g0.l.i this$0;
        c(kotlin.i0.z.e.m0.d.a.g0.l.i i, g g2) {
            this.this$0 = i;
            this.$c = g2;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final e a(kotlin.i0.z.e.m0.d.a.g0.l.i.a i$a) {
            b aVar;
            g gVar;
            int obj;
            b bVar;
            m.a bINARY;
            Object eVar;
            o oVar;
            boolean bVar2;
            a aVar2;
            boolean z;
            boolean z2;
            int i5;
            int i4;
            q qVar;
            q.a aVar3;
            kotlin.i0.z.e.m0.d.a.g0.l.h hVar;
            g gVar2;
            int i;
            int i2;
            int i3;
            final Object obj2 = this;
            n.f(a, "request");
            aVar = new a(obj2.this$0.Q().d(), a.b());
            if (a.a() != null) {
                bINARY = obj2.$c.a().i().a(a.a());
            } else {
                bINARY = obj2.$c.a().i().c(aVar);
            }
            i4 = 0;
            if (bINARY == null) {
                oVar = i4;
            } else {
                oVar = bINARY.a();
            }
            if (oVar == null) {
                aVar2 = i4;
            } else {
                aVar2 = oVar.e();
            }
            if (aVar2 != null && !aVar2.l() && aVar2.k()) {
                if (!aVar2.l()) {
                    if (aVar2.k()) {
                    }
                }
                return i4;
            }
            bVar2 = i.M(obj2.this$0, oVar);
            if (bVar2 instanceof i.b.a) {
                i4 = (i.b.a)bVar2.a();
                return i4;
            } else {
                if (bVar2 instanceof i.b.c) {
                } else {
                    if (!bVar2 instanceof i.b.b) {
                    } else {
                        if (a.a() == null) {
                            if (bINARY == null) {
                                bVar2 = i4;
                            } else {
                            }
                            super(aVar, bVar2, 0, 4, 0);
                            gVar = obj2.$c.a().d().a(aVar3);
                        }
                        gVar2 = gVar;
                        if (gVar2 == null) {
                            obj = i4;
                        } else {
                            obj = gVar2.I();
                        }
                        if (obj == c0.BINARY) {
                        } else {
                            if (gVar2 == null) {
                                aVar = i4;
                            } else {
                                aVar = gVar2.d();
                            }
                            if (aVar != null && !aVar.d()) {
                                if (!aVar.d()) {
                                    if (!n.b(aVar.e(), obj2.this$0.Q().d())) {
                                    } else {
                                        super(obj2.$c, obj2.this$0.Q(), gVar2, 0, 8, 0);
                                        obj2.$c.a().e().a(aVar);
                                        i4 = aVar;
                                    }
                                }
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: ");
                        stringBuilder.append(gVar2);
                        stringBuilder.append("\nClassId: ");
                        stringBuilder.append(aVar);
                        stringBuilder.append("\nfindKotlinClass(JavaClass) = ");
                        stringBuilder.append(n.a(obj2.$c.a().i(), gVar2));
                        stringBuilder.append("\nfindKotlinClass(ClassId) = ");
                        stringBuilder.append(n.b(obj2.$c.a().i(), aVar));
                        stringBuilder.append('\n');
                        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                        throw illegalStateException;
                    }
                }
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((i.a)object);
        }
    }

    static final class d extends p implements a<Set<? extends String>> {

        final g $c;
        final kotlin.i0.z.e.m0.d.a.g0.l.i this$0;
        d(g g, kotlin.i0.z.e.m0.d.a.g0.l.i i2) {
            this.$c = g;
            this.this$0 = i2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final Set<String> invoke() {
            return this.$c.a().d().c(this.this$0.Q().d());
        }
    }
    public i(g g, u u2, kotlin.i0.z.e.m0.d.a.g0.l.h h3) {
        n.f(g, "c");
        n.f(u2, "jPackage");
        n.f(h3, "ownerDescriptor");
        super(g);
        this.n = u2;
        this.o = h3;
        i.d obj4 = new i.d(g, this);
        this.p = g.e().f(obj4);
        obj4 = new i.c(this, g);
        this.q = g.e().i(obj4);
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.l.i.b M(kotlin.i0.z.e.m0.d.a.g0.l.i i, o o2) {
        return i.R(o2);
    }

    private final e N(e e, g g2) {
        Object contains;
        String str;
        int i = 0;
        if (!g.b(e)) {
            return i;
        }
        contains = this.p.invoke();
        if (g2 == null && contains != null && !(Set)contains.contains(e.c())) {
            if (contains != null) {
                if (!contains.contains(e.c())) {
                    return i;
                }
            }
        }
        i.a aVar = new i.a(e, g2);
        return (e)this.q.invoke(aVar);
    }

    private final kotlin.i0.z.e.m0.d.a.g0.l.i.b R(o o) {
        Object aVar;
        a.a cLASS;
        kotlin.i0.z.e.m0.d.a.g0.l.i.b obj3;
        if (o == null) {
            obj3 = i.b.b.a;
        } else {
            if (o.a().c() == a.a.CLASS) {
                obj3 = w().a().b().m(o);
                if (obj3 != null) {
                    aVar = new i.b.a(obj3);
                    obj3 = aVar;
                } else {
                    obj3 = i.b.b.a;
                }
            } else {
                obj3 = i.b.c.a;
            }
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected m C() {
        return Q();
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    public final e O(g g) {
        n.f(g, "javaClass");
        return N(g.getName(), g);
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    public e P(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return N(e, 0);
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected kotlin.i0.z.e.m0.d.a.g0.l.h Q() {
        return this.o;
    }

    public Collection<o0> c(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    public h f(e e, b b2) {
        return P(e, b2);
    }

    public Collection<m> g(d d, l<? super e, Boolean> l2) {
        ArrayList arrayList;
        boolean next;
        int i;
        int booleanValue;
        boolean str;
        Object obj5;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        d.a aVar = d.c;
        if (!d.a(i2 |= next)) {
            obj5 = p.g();
        } else {
            arrayList = new ArrayList();
            obj5 = (Iterable)v().invoke().iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                booleanValue = next;
                e name = (e)(m)booleanValue.getName();
                n.e(name, "it.name");
                if (booleanValue instanceof e && (Boolean)l2.invoke(name).booleanValue()) {
                } else {
                }
                i = 0;
                if (i != 0) {
                }
                arrayList.add(next);
                name = (e)booleanValue.getName();
                n.e(name, "it.name");
                if ((Boolean)l2.invoke(name).booleanValue()) {
                } else {
                }
                i = 1;
            }
            obj5 = arrayList;
        }
        return obj5;
    }

    protected Set<e> l(d d, l<? super e, Boolean> l2) {
        int name;
        c0 c0Var;
        c0 sOURCE;
        l obj5;
        n.f(d, "kindFilter");
        if (!d.a(d.c.f())) {
            return q0.b();
        }
        Object obj4 = this.p.invoke();
        if ((Set)obj4 != null) {
            obj5 = new HashSet();
            obj4 = (Set)obj4.iterator();
            for (String next2 : obj4) {
                obj5.add(e.j(next2));
            }
            return obj5;
        }
        if (l2 == null) {
            obj5 = d.a();
        }
        obj5 = new LinkedHashSet();
        obj4 = this.n.r(obj5).iterator();
        while (obj4.hasNext()) {
            Object next4 = obj4.next();
            if ((g)next4.I() == c0.SOURCE) {
            } else {
            }
            name = next4.getName();
            if (name != null) {
            }
            obj5.add(name);
            name = 0;
        }
        return obj5;
    }

    protected Set<e> n(d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        return q0.b();
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.l.l
    protected kotlin.i0.z.e.m0.d.a.g0.l.b p() {
        return b.a.a;
    }

    protected void r(Collection<t0> collection, e e2) {
        n.f(collection, "result");
        n.f(e2, "name");
    }

    protected Set<e> t(d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        return q0.b();
    }
}
