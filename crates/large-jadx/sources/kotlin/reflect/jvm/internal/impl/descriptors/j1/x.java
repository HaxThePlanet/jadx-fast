package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.g.a;
import kotlin.i0.z.e.m0.k.g;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.h;
import kotlin.i0.z.e.m0.l.j1.o;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.y.i;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class x extends kotlin.reflect.jvm.internal.impl.descriptors.j1.j implements c0 {

    private final g<b, k0> A;
    private final h B;
    private final n c;
    private final h v;
    private final Map<b0<?>, Object> w;
    private kotlin.reflect.jvm.internal.impl.descriptors.j1.v x;
    private g0 y;
    private boolean z;

    static final class a extends p implements a<kotlin.reflect.jvm.internal.impl.descriptors.j1.i> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.x this$0;
        a(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
            this.this$0 = x;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.reflect.jvm.internal.impl.descriptors.j1.i a() {
            Object next;
            int i;
            kotlin.reflect.jvm.internal.impl.descriptors.j1.v vVar = x.J(this.this$0);
            if (vVar == null) {
            } else {
                List list = vVar.a();
                list.contains(this.this$0);
                Iterator iterator2 = list.iterator();
                for (x next : iterator2) {
                    x.L0(next);
                }
                ArrayList arrayList = new ArrayList(p.r(list, 10));
                Iterator iterator = list.iterator();
                for (x next4 : iterator) {
                    i = x.J0(next4);
                    n.d(i);
                    arrayList.add(i);
                }
                i iVar = new i(arrayList);
                return iVar;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dependencies of module ");
            stringBuilder.append(x.C0(this.this$0));
            stringBuilder.append(" were not set before querying module content");
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class b extends p implements l<b, k0> {

        final kotlin.reflect.jvm.internal.impl.descriptors.j1.x this$0;
        b(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
            this.this$0 = x;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final k0 a(b b) {
            n.f(b, "fqName");
            final kotlin.reflect.jvm.internal.impl.descriptors.j1.x this$0 = this.this$0;
            r rVar = new r(this$0, b, x.K0(this$0));
            return rVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }
    public x(e e, n n2, h h3, a a4) {
        n.f(e, "moduleName");
        n.f(n2, "storageManager");
        n.f(h3, "builtIns");
        super(e, n2, h3, a4, 0, 0, 48, 0);
    }

    public x(e e, n n2, h h3, a a4, Map<b0<?>, ? extends Object> map5, e e6) {
        n.f(e, "moduleName");
        n.f(n2, "storageManager");
        n.f(h3, "builtIns");
        n.f(map5, "capabilities");
        super(g.q.b(), e);
        this.c = n2;
        this.v = h3;
        if (!e.k()) {
        } else {
            Map obj1 = j0.y(map5);
            this.w = obj1;
            o obj4 = new o(0);
            obj1.put(h.a(), obj4);
            this.z = true;
            obj1 = new x.b(this);
            this.A = n2.h(obj1);
            obj1 = new x.a(this);
            this.B = j.b(obj1);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException(n.o("Module name must be special: ", e));
        throw obj2;
    }

    public x(e e, n n2, h h3, a a4, Map map5, e e6, int i7, g g8) {
        int i3;
        int i2;
        Map map;
        int i;
        final int i6 = 0;
        i2 = i7 & 8 != 0 ? i6 : a4;
        if (i7 & 16 != 0) {
            map = i3;
        } else {
            map = map5;
        }
        i = i7 & 32 != 0 ? i6 : e6;
        super(e, n2, h3, i2, map, i);
    }

    public static final String C0(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
        return x.N0();
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.j1.v J(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
        return x.x;
    }

    public static final g0 J0(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
        return x.y;
    }

    public static final n K0(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
        return x.c;
    }

    public static final boolean L0(kotlin.reflect.jvm.internal.impl.descriptors.j1.x x) {
        return x.R0();
    }

    private final String N0() {
        String string = getName().toString();
        n.e(string, "name.toString()");
        return string;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.j1.i P0() {
        return (i)this.B.getValue();
    }

    private final boolean R0() {
        int i;
        i = this.y != null ? 1 : 0;
        return i;
    }

    public <T> T F0(b0<T> b0) {
        n.f(b0, "capability");
        return this.w.get(b0);
    }

    public <R, D> R K(o<R, D> o, D d2) {
        return c0.a.a(this, o, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public k0 M(b b) {
        n.f(b, "fqName");
        M0();
        return (k0)this.A.invoke(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public void M0() {
        if (!S0()) {
        } else {
        }
        InvalidModuleException invalidModuleException = new InvalidModuleException(n.o("Accessing invalid module descriptor ", this));
        throw invalidModuleException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public final g0 O0() {
        M0();
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public final void Q0(g0 g0) {
        n.f(g0, "providerForModuleContent");
        R0();
        this.y = g0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public boolean S0() {
        return this.z;
    }

    public final void T0(List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> list) {
        n.f(list, "descriptors");
        U0(list, q0.b());
    }

    public final void U0(List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> list, Set<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> set2) {
        n.f(list, "descriptors");
        n.f(set2, "friends");
        w wVar = new w(list, set2, p.g(), q0.b());
        V0(wVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public final void V0(kotlin.reflect.jvm.internal.impl.descriptors.j1.v v) {
        n.f(v, "dependencies");
        kotlin.reflect.jvm.internal.impl.descriptors.j1.v vVar = this.x;
        this.x = v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public final void W0(kotlin.reflect.jvm.internal.impl.descriptors.j1.x... xArr) {
        n.f(xArr, "descriptors");
        T0(i.a0(xArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public m b() {
        return c0.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public boolean e0(c0 c0) {
        n.f(c0, "targetModule");
        final int i = 1;
        if (n.b(this, c0)) {
            return i;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.j1.v vVar = this.x;
        n.d(vVar);
        if (p.N(vVar.b(), c0)) {
            return i;
        }
        if (s0().contains(c0)) {
            return i;
        }
        if (c0.s0().contains(this)) {
            return i;
        }
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.j
    public h m() {
        return this.v;
    }

    public Collection<b> n(b b, l<? super e, Boolean> l2) {
        n.f(b, "fqName");
        n.f(l2, "nameFilter");
        M0();
        return O0().n(b, l2);
    }

    public List<c0> s0() {
        kotlin.reflect.jvm.internal.impl.descriptors.j1.v vVar = this.x;
        if (vVar == null) {
        } else {
            return vVar.c();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dependencies of module ");
        stringBuilder.append(N0());
        stringBuilder.append(" were not set");
        AssertionError assertionError = new AssertionError(stringBuilder.toString());
        throw assertionError;
    }
}
