package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h0.g;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.k.g;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.m;
import kotlin.y.h0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class e0 {

    private final n a;
    private final kotlin.reflect.jvm.internal.impl.descriptors.c0 b;
    private final g<b, kotlin.reflect.jvm.internal.impl.descriptors.f0> c;
    private final g<kotlin.reflect.jvm.internal.impl.descriptors.e0.a, kotlin.reflect.jvm.internal.impl.descriptors.e> d;

    private static final class a {

        private final a a;
        private final List<Integer> b;
        public a(a a, List<Integer> list2) {
            n.f(a, "classId");
            n.f(list2, "typeParametersCount");
            super();
            this.a = a;
            this.b = list2;
        }

        public final a a() {
            return this.a;
        }

        public final List<Integer> b() {
            return this.b;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof e0.a) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClassRequest(classId=");
            stringBuilder.append(this.a);
            stringBuilder.append(", typeParametersCount=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    static final class c extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.e0.a, kotlin.reflect.jvm.internal.impl.descriptors.e> {

        final kotlin.reflect.jvm.internal.impl.descriptors.e0 this$0;
        c(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0) {
            this.this$0 = e0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.reflect.jvm.internal.impl.descriptors.e a(kotlin.reflect.jvm.internal.impl.descriptors.e0.a e0$a) {
            kotlin.reflect.jvm.internal.impl.descriptors.e invoke;
            kotlin.reflect.jvm.internal.impl.descriptors.e0 this$0;
            List str;
            int obj9;
            n.f(a, "$dstr$classId$typeParametersCount");
            a aVar = a.a();
            obj9 = a.b();
            if (aVar.k()) {
            } else {
                a aVar2 = aVar.g();
                if (aVar2 == null) {
                    invoke = 0;
                } else {
                    invoke = this.this$0.d(aVar2, p.P(obj9, 1));
                }
                if (invoke == null) {
                    this$0 = aVar.h();
                    n.e(this$0, "classId.packageFqName");
                    invoke = e0.b(this.this$0).invoke(this$0);
                }
                final e eVar2 = aVar.j();
                n.e(eVar2, "classId.shortClassName");
                obj9 = p.Z(obj9);
                if ((Integer)obj9 == null) {
                    obj9 = 0;
                } else {
                    obj9 = (Integer)obj9.intValue();
                }
                super(e0.c(this.this$0), invoke, eVar2, aVar.l(), obj9);
                return bVar;
            }
            obj9 = new UnsupportedOperationException(n.o("Unresolved local class: ", aVar));
            throw obj9;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((e0.a)object);
        }
    }

    static final class d extends p implements l<b, kotlin.reflect.jvm.internal.impl.descriptors.f0> {

        final kotlin.reflect.jvm.internal.impl.descriptors.e0 this$0;
        d(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0) {
            this.this$0 = e0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.reflect.jvm.internal.impl.descriptors.f0 a(b b) {
            n.f(b, "fqName");
            m mVar = new m(e0.a(this.this$0), b);
            return mVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    public static final class b extends g {

        private final boolean A;
        private final List<kotlin.reflect.jvm.internal.impl.descriptors.z0> B;
        private final i C;
        public b(n n, kotlin.reflect.jvm.internal.impl.descriptors.m m2, e e3, boolean z4, int i5) {
            String str;
            Object obj3;
            Object obj2;
            Object iNVARIANT;
            Object obj;
            kotlin.reflect.jvm.internal.impl.descriptors.u0 u0Var;
            int i;
            int obj11;
            int obj12;
            n.f(n, "storageManager");
            n.f(m2, "container");
            n.f(e3, "name");
            super(n, m2, e3, u0.a, 0);
            this.A = z4;
            kotlin.h0.f obj9 = g.l(0, i5);
            ArrayList obj10 = new ArrayList(p.r(obj9, 10));
            obj9 = obj9.iterator();
            while (obj9.hasNext()) {
                u0Var = (h0)obj9.d();
                obj10.add(j0.Q0(this, g.q.b(), null, h1.INVARIANT, e.j(n.o("T", Integer.valueOf(u0Var))), u0Var, n));
            }
            this.B = obj10;
            obj9 = new i(this, a1.d(this), q0.a(a.l(this).m().i()), n);
            this.C = obj9;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean A() {
            return 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean B0() {
            return 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        protected h F(g g) {
            return L0(g);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean G0() {
            return 0;
        }

        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> H() {
            return p.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean I() {
            return 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public h.b J0() {
            return h.b.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public i K0() {
            return this.C;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean L() {
            return 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        protected h.b L0(g g) {
            n.f(g, "kotlinTypeRefiner");
            return h.b.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public kotlin.reflect.jvm.internal.impl.descriptors.d Q() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public h R() {
            return J0();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public kotlin.reflect.jvm.internal.impl.descriptors.e T() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public kotlin.reflect.jvm.internal.impl.descriptors.f f() {
            return f.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public t0 g() {
            return K0();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public g getAnnotations() {
            return g.q.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
            final kotlin.reflect.jvm.internal.impl.descriptors.u uVar = t.e;
            n.e(uVar, "PUBLIC");
            return uVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public kotlin.reflect.jvm.internal.impl.descriptors.z i() {
            return z.FINAL;
        }

        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> j() {
            return q0.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean k() {
            return this.A;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean r() {
            return 0;
        }

        public List<kotlin.reflect.jvm.internal.impl.descriptors.z0> t() {
            return this.B;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("class ");
            stringBuilder.append(getName());
            stringBuilder.append(" (not found)");
            return stringBuilder.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean w() {
            return 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.g
        public boolean x() {
            return 0;
        }
    }
    public e0(n n, kotlin.reflect.jvm.internal.impl.descriptors.c0 c02) {
        n.f(n, "storageManager");
        n.f(c02, "module");
        super();
        this.a = n;
        this.b = c02;
        e0.d obj3 = new e0.d(this);
        this.c = n.h(obj3);
        obj3 = new e0.c(this);
        this.d = n.h(obj3);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.c0 a(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0) {
        return e0.b;
    }

    public static final g b(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0) {
        return e0.c;
    }

    public static final n c(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0) {
        return e0.a;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e d(a a, List<Integer> list2) {
        n.f(a, "classId");
        n.f(list2, "typeParametersCount");
        e0.a aVar = new e0.a(a, list2);
        return (e)this.d.invoke(aVar);
    }
}
