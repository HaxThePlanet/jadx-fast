package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class d extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k implements y0 {

    private final u w;
    private List<? extends z0> x;
    private final kotlin.reflect.jvm.internal.impl.descriptors.j1.d.c y;

    public static final class c implements t0 {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.d a;
        c(kotlin.reflect.jvm.internal.impl.descriptors.j1.d d) {
            this.a = d;
            super();
        }

        public Collection<b0> a() {
            Collection collection = f().g0().L0().a();
            n.e(collection, "declarationDescriptor.underlyingType.constructor.supertypes");
            return collection;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public t0 b(g g) {
            n.f(g, "kotlinTypeRefiner");
            return this;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h c() {
            return f();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public boolean d() {
            return 1;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public y0 f() {
            return this.a;
        }

        public List<z0> getParameters() {
            return this.a.L0();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h m() {
            return a.g(f());
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[typealias ");
            stringBuilder.append(f().getName().c());
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    static final class a extends p implements l<g, i0> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.d this$0;
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final i0 a(g g) {
            int obj2;
            obj2 = g.e(this.this$0);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = obj2.q();
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }

    static final class b extends p implements l<g1, Boolean> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.d this$0;
        b(kotlin.reflect.jvm.internal.impl.descriptors.j1.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Boolean a(g1 g1) {
            boolean this$0;
            int i;
            boolean z;
            Object obj5;
            n.e(g1, "type");
            final int i2 = 0;
            if (!d0.a(g1)) {
                obj5 = g1.L0().c();
                if (obj5 instanceof z0 && !n.b((z0)obj5.b(), this.this$0)) {
                    obj5 = !n.b((z0)obj5.b(), this$0) ? i : i2;
                } else {
                }
                if (obj5 != null) {
                } else {
                    i = i2;
                }
            } else {
            }
            return Boolean.valueOf(i);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g1)object);
        }
    }
    public d(m m, g g2, e e3, u0 u04, u u5) {
        n.f(m, "containingDeclaration");
        n.f(g2, "annotations");
        n.f(e3, "name");
        n.f(u04, "sourceElement");
        n.f(u5, "visibilityImpl");
        super(m, g2, e3, u04);
        this.w = u5;
        d.c obj2 = new d.c(this);
        this.y = obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean B0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    protected final i0 C0() {
        int i;
        e eVar = p();
        if (eVar == null) {
            i = 0;
        } else {
            i = eVar.A0();
        }
        if (i == 0) {
            i = h.b.b;
        }
        d.a aVar = new d.a(this);
        i0 i0Var = c1.t(this, i, aVar);
        n.e(i0Var, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        return i0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public p J() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public y0 J0() {
        return (y0)super.J();
    }

    public <R, D> R K(o<R, D> o, D d2) {
        n.f(o, "visitor");
        return o.e(this, d2);
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.j1.h0> K0() {
        kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 h0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.j1.i0.a aVar;
        n nVar;
        String str;
        e eVar = p();
        if (eVar == null) {
            return p.g();
        }
        Collection collection = eVar.j();
        n.e(collection, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            n.e((d)next2, "it");
            h0Var = i0.Y.b(h0(), this, next2);
            if (h0Var != null) {
            }
            arrayList.add(h0Var);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean L() {
        return 0;
    }

    protected abstract List<z0> L0();

    public final void M0(List<? extends z0> list) {
        n.f(list, "declaredTypeParameters");
        this.x = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public h a() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public m a() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public t0 g() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public u getVisibility() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    protected abstract n h0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean k() {
        d.b bVar = new d.b(this);
        return c1.c(g0(), bVar);
    }

    public List<z0> t() {
        List list = this.x;
        if (list == null) {
        } else {
            return list;
        }
        n.w("declaredTypeParametersImpl");
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public String toString() {
        return n.o("typealias ", getName().c());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean w() {
        return 0;
    }
}
