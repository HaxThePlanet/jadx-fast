package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class k0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.l0 implements c1 {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.j1.k0.a D;
    private final boolean A;
    private final b0 B;
    private final c1 C;
    private final int x;
    private final boolean y;
    private final boolean z;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 a(a a, c1 c12, int i3, g g4, e e5, b0 b06, boolean z7, boolean z8, boolean z9, b0 b010, u0 u011, a<? extends List<? extends d1>> a12) {
            kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 k0Var2;
            kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 k0Var;
            Object obj;
            c1 c1Var;
            int i;
            g gVar;
            e eVar;
            b0 b0Var2;
            boolean z3;
            boolean z;
            boolean z2;
            b0 b0Var;
            u0 u0Var;
            a aVar;
            Object obj2 = a;
            n.f(a, "containingDeclaration");
            n.f(g4, "annotations");
            n.f(e5, "name");
            n.f(b06, "outType");
            n.f(u011, "source");
            if (a12 == null) {
                super(a, c12, i3, g4, e5, b06, z7, z8, z9, b010, u011);
            } else {
                super(a, c12, i3, g4, e5, b06, z7, z8, z9, b010, u011, a12);
            }
            return k0Var2;
        }
    }

    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 {

        private final h E;
        public b(a a, c1 c12, int i3, g g4, e e5, b0 b06, boolean z7, boolean z8, boolean z9, b0 b010, u0 u011, a<? extends List<? extends d1>> a12) {
            n.f(a, "containingDeclaration");
            n.f(g4, "annotations");
            n.f(e5, "name");
            n.f(b06, "outType");
            n.f(u011, "source");
            n.f(a12, "destructuringVariables");
            super(a, c12, i3, g4, e5, b06, z7, z8, z9, b010, u011);
            this.E = j.b(a12);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k0
        public c1 D0(a a, e e2, int i3) {
            final Object obj = a;
            n.f(obj, "newOwner");
            final Object obj2 = e2;
            n.f(obj2, "newName");
            final g annotations = getAnnotations();
            n.e(annotations, "annotations");
            final b0 type = getType();
            n.e(type, "type");
            final u0 u0Var = u0.a;
            n.e(u0Var, "NO_SOURCE");
            final kotlin.reflect.jvm.internal.impl.descriptors.j1.k0.b bVar3 = this;
            k0.b.a aVar = new k0.b.a(this);
            super(obj, 0, i3, annotations, obj2, type, t0(), b0(), X(), l0(), u0Var, aVar);
            return bVar;
        }

        public final List<d1> M0() {
            return (List)this.E.getValue();
        }
    }
    static {
        k0.a aVar = new k0.a(0);
        k0.D = aVar;
    }

    public k0(a a, c1 c12, int i3, g g4, e e5, b0 b06, boolean z7, boolean z8, boolean z9, b0 b010, u0 u011) {
        Object obj;
        final Object obj4 = this;
        n.f(a, "containingDeclaration");
        n.f(g4, "annotations");
        n.f(e5, "name");
        n.f(b06, "outType");
        final Object obj3 = u011;
        n.f(obj3, "source");
        super(a, g4, e5, b06, obj3);
        obj4.x = i3;
        obj4.y = z7;
        obj4.z = z8;
        obj4.A = z9;
        obj4.B = b010;
        obj = c12 == null ? obj4 : c12;
        obj4.C = obj;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.j1.k0 J0(a a, c1 c12, int i3, g g4, e e5, b0 b06, boolean z7, boolean z8, boolean z9, b0 b010, u0 u011, a<? extends List<? extends d1>> a12) {
        return k0.D.a(a, c12, i3, g4, e5, b06, z7, z8, z9, b010, u011, a12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public c1 D0(a a, e e2, int i3) {
        n.f(a, "newOwner");
        n.f(e2, "newName");
        final g annotations = getAnnotations();
        n.e(annotations, "annotations");
        final b0 type = getType();
        n.e(type, "type");
        final u0 u0Var = u0.a;
        n.e(u0Var, "NO_SOURCE");
        super(a, 0, i3, annotations, e2, type, t0(), b0(), X(), l0(), u0Var);
        return k0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public p J() {
        return a();
    }

    public <R, D> R K(o<R, D> o, D d2) {
        n.f(o, "visitor");
        return o.k(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public Void K0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public c1 L0(a1 a1) {
        n.f(a1, "substitutor");
        if (!a1.k()) {
        } else {
            return this;
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException();
        throw obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public g W() {
        return (g)K0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public boolean X() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public a a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public c1 a() {
        Object obj;
        c1 c1Var = this.C;
        if (c1Var == this) {
            obj = this;
        } else {
            obj = c1Var.a();
        }
        return obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public m a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public a b() {
        return (a)super.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public m b() {
        return b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public boolean b0() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public n c(a1 a1) {
        L0(a1);
        return this;
    }

    public Collection<c1> e() {
        int i;
        int index;
        Collection collection = b().e();
        n.e(collection, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(p.r(collection, 10));
        Iterator iterator = collection.iterator();
        for (a next2 : iterator) {
            arrayList.add((c1)next2.h().get(getIndex()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public int getIndex() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public u getVisibility() {
        final u uVar = t.f;
        n.e(uVar, "LOCAL");
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public boolean j0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public b0 l0() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l0
    public boolean t0() {
        boolean real;
        int i;
        if (this.y && (b)b().f().isReal()) {
            i = (b)b().f().isReal() ? 1 : 0;
        } else {
        }
        return i;
    }
}
