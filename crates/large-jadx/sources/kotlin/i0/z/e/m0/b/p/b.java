package kotlin.i0.z.e.m0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b extends a {

    private static final a E;
    private static final a F;
    private final int A;
    private final kotlin.i0.z.e.m0.b.p.b.a B;
    private final kotlin.i0.z.e.m0.b.p.d C;
    private final List<z0> D;
    private final n x;
    private final f0 y;
    private final kotlin.i0.z.e.m0.b.p.c z;

    private final class a extends b {

        final kotlin.i0.z.e.m0.b.p.b d;
        public a(kotlin.i0.z.e.m0.b.p.b b) {
            n.f(b, "this$0");
            this.d = b;
            super(b.O0(b));
        }

        @Override // kotlin.i0.z.e.m0.l.b
        public h c() {
            return v();
        }

        @Override // kotlin.i0.z.e.m0.l.b
        public boolean d() {
            return 1;
        }

        public List<z0> getParameters() {
            return b.N0(this.d);
        }

        protected Collection<b0> h() {
            List list;
            a aVar;
            kotlin.i0.z.e.m0.f.b bVar;
            e numberedClassName;
            int i3;
            int i;
            ArrayList arrayList;
            boolean next;
            int i2;
            x0 x0Var;
            int i4 = b.a.a.a[this.d.T0().ordinal()];
            int i5 = 1;
            if (i4 != i5) {
                aVar = 0;
                bVar = 2;
                if (i4 != bVar) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                        } else {
                            a[] arr2 = new a[bVar];
                            arr2[aVar] = b.M0();
                            aVar = new a(k.d, c.SuspendFunction.numberedClassName(this.d.P0()));
                            arr2[i5] = aVar;
                            list = p.j(arr2);
                        }
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                    }
                    list = p.b(b.L0());
                } else {
                    a[] arr = new a[bVar];
                    arr[aVar] = b.M0();
                    aVar = new a(k.l, c.Function.numberedClassName(this.d.P0()));
                    arr[i5] = aVar;
                    list = p.j(arr);
                }
            } else {
                list = p.b(b.L0());
            }
            int i6 = 10;
            ArrayList arrayList2 = new ArrayList(p.r(list, i6));
            Iterator iterator = list.iterator();
            for (a next3 : iterator) {
                i = w.a(b.K0(this.d).b(), next3);
                List list3 = p.G0(getParameters(), i.g().getParameters().size());
                arrayList = new ArrayList(p.r(list3, i6));
                Iterator iterator2 = list3.iterator();
                for (z0 next4 : iterator2) {
                    x0Var = new x0(next4.q());
                    arrayList.add(x0Var);
                }
                c0 c0Var2 = c0.a;
                arrayList2.add(c0.g(g.q.b(), i, arrayList));
                x0Var = new x0((z0)iterator2.next().q());
                arrayList.add(x0Var);
            }
            return p.L0(arrayList2);
        }

        @Override // kotlin.i0.z.e.m0.l.b
        protected x0 l() {
            return x0.a.a;
        }

        @Override // kotlin.i0.z.e.m0.l.b
        public e t() {
            return v();
        }

        @Override // kotlin.i0.z.e.m0.l.b
        public String toString() {
            return v().toString();
        }

        @Override // kotlin.i0.z.e.m0.l.b
        public kotlin.i0.z.e.m0.b.p.b v() {
            return this.d;
        }
    }
    static {
        a aVar = new a(k.l, e.j("Function"));
        b.E = aVar;
        a aVar2 = new a(k.i, e.j("KFunction"));
        b.F = aVar2;
    }

    public b(n n, f0 f02, kotlin.i0.z.e.m0.b.p.c c3, int i4) {
        e numberedClassName;
        String str;
        int obj6;
        n.f(n, "storageManager");
        n.f(f02, "containingDeclaration");
        n.f(c3, "functionKind");
        super(n, c3.numberedClassName(i4));
        this.x = n;
        this.y = f02;
        this.z = c3;
        this.A = i4;
        b.a obj4 = new b.a(this);
        this.B = obj4;
        obj4 = new d(n, this);
        this.C = obj4;
        ArrayList obj3 = new ArrayList();
        obj4 = new f(1, i4);
        ArrayList obj5 = new ArrayList(p.r(obj4, 10));
        obj4 = obj4.iterator();
        while (obj4.hasNext()) {
            b.J0(obj3, this, h1.IN_VARIANCE, n.o("P", Integer.valueOf((h0)obj4.d())));
            obj5.add(w.a);
        }
        b.J0(obj3, this, h1.OUT_VARIANCE, "R");
        this.D = p.L0(obj3);
    }

    private static final void J0(ArrayList<z0> arrayList, kotlin.i0.z.e.m0.b.p.b b2, h1 h13, String string4) {
        arrayList.add(j0.Q0(b2, g.q.b(), false, h13, e.j(string4), arrayList.size(), b2.x));
    }

    public static final f0 K0(kotlin.i0.z.e.m0.b.p.b b) {
        return b.y;
    }

    public static final a L0() {
        return b.E;
    }

    public static final a M0() {
        return b.F;
    }

    public static final List N0(kotlin.i0.z.e.m0.b.p.b b) {
        return b.D;
    }

    public static final n O0(kotlin.i0.z.e.m0.b.p.b b) {
        return b.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean A() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean B0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    protected h F(g g) {
        return W0(g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean G0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public Collection H() {
        return U0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean I() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean L() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public final int P0() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public d Q() {
        return (d)X0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public Void Q0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public h R() {
        return V0();
    }

    public List<d> R0() {
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public f0 S0() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public e T() {
        return (e)Q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public final kotlin.i0.z.e.m0.b.p.c T0() {
        return this.z;
    }

    public List<e> U0() {
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public h.b V0() {
        return h.b.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    protected kotlin.i0.z.e.m0.b.p.d W0(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public Void X0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public m b() {
        return S0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public f f() {
        return f.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public t0 g() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public g getAnnotations() {
        return g.q.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public u0 getSource() {
        final u0 u0Var = u0.a;
        n.e(u0Var, "NO_SOURCE");
        return u0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public u getVisibility() {
        final u uVar = t.e;
        n.e(uVar, "PUBLIC");
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public z i() {
        return z.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public Collection j() {
        return R0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean k() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean r() {
        return 0;
    }

    public List<z0> t() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public String toString() {
        String str = getName().c();
        n.e(str, "name.asString()");
        return str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean w() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.a
    public boolean x() {
        return 0;
    }
}
