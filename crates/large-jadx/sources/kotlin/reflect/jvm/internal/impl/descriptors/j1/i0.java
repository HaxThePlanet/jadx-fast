package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.Objects;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.l0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public final class i0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.p implements kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.j1.i0.a Y;
    static final l<Object>[] Z;
    private final n V;
    private final y0 W;
    private d X;

    public static final class a {
        public a(g g) {
            super();
        }

        public static final a1 a(kotlin.reflect.jvm.internal.impl.descriptors.j1.i0.a i0$a, y0 y02) {
            return a.c(y02);
        }

        private final a1 c(y0 y0) {
            if (y0.p() == null) {
                return null;
            }
            return a1.f(y0.V());
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 b(n n, y0 y02, d d3) {
            Object r0Var;
            Object i0Var;
            int i;
            final Object obj2 = y02;
            final Object obj3 = d3;
            n.f(n, "storageManager");
            n.f(obj2, "typeAliasDescriptor");
            n.f(obj3, "constructor");
            final a1 a1Var = this.c(obj2);
            i = 0;
            if (a1Var == null) {
                return i;
            }
            final d dVar2 = obj3.c(a1Var);
            if (dVar2 == null) {
                return i;
            }
            b.a aVar2 = d3.f();
            n.e(aVar2, "constructor.kind");
            u0 source = y02.getSource();
            n.e(source, "typeAliasDescriptor.source");
            super(n, y02, dVar2, 0, d3.getAnnotations(), aVar2, source, 0);
            java.util.List list3 = p.N0(i0Var6, d3.h(), a1Var);
            if (list3 == null) {
                return i;
            }
            i0Var = y02.q();
            n.e(i0Var, "typeAliasDescriptor.defaultType");
            r0Var = d3.f0();
            if (r0Var == null) {
            } else {
                i = c.f(i0Var6, a1Var.n(r0Var.getType(), h1.INVARIANT), g.q.b());
            }
            i0Var6.Q0(i, 0, y02.t(), list3, l0.j(y.c(dVar2.getReturnType().O0()), i0Var), z.FINAL, y02.getVisibility());
            return i0Var6;
        }
    }

    static final class b extends p implements a<kotlin.reflect.jvm.internal.impl.descriptors.j1.i0> {

        final d $underlyingConstructorDescriptor;
        final kotlin.reflect.jvm.internal.impl.descriptors.j1.i0 this$0;
        b(kotlin.reflect.jvm.internal.impl.descriptors.j1.i0 i0, d d2) {
            this.this$0 = i0;
            this.$underlyingConstructorDescriptor = d2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.reflect.jvm.internal.impl.descriptors.j1.i0 a() {
            r0 r0Var;
            int i;
            d $underlyingConstructorDescriptor3 = this.$underlyingConstructorDescriptor;
            b.a aVar2 = this.$underlyingConstructorDescriptor.f();
            n.e(aVar2, "underlyingConstructorDescriptor.kind");
            u0 source = this.this$0.n1().getSource();
            n.e(source, "typeAliasDescriptor.source");
            super(this.this$0.h0(), this.this$0.n1(), $underlyingConstructorDescriptor3, this.this$0, $underlyingConstructorDescriptor3.getAnnotations(), aVar2, source, 0);
            kotlin.reflect.jvm.internal.impl.descriptors.j1.i0 this$04 = this.this$0;
            a1 a1Var = i0.a.a(i0.Y, this$04.n1());
            int i3 = 0;
            if (a1Var == null) {
                return i3;
            }
            r0Var = this.$underlyingConstructorDescriptor.f0();
            if (r0Var == null) {
                i = i3;
            } else {
                i = r0Var;
            }
            i0Var3.Q0(0, i, this$04.n1().t(), this$04.h(), this$04.getReturnType(), z.FINAL, this$04.n1().getVisibility());
            return i0Var3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        i0.a aVar = new i0.a(0);
        i0.Y = aVar;
        l[] arr = new l[1];
        x xVar = new x(c0.b(i0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;");
        i0.Z = arr;
    }

    private i0(n n, y0 y02, d d3, kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 h04, g g5, b.a b$a6, u0 u07) {
        super(y02, h04, g5, e.n("<init>"), a6, u07);
        this.V = n;
        this.W = y02;
        U0(n1().B0());
        i0.b obj10 = new i0.b(this, d3);
        n.f(obj10);
        this.X = d3;
    }

    public i0(n n, y0 y02, d d3, kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 h04, g g5, b.a b$a6, u0 u07, g g8) {
        super(n, y02, d3, h04, g5, a6, u07);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public p J() {
        return m1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x J0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return j1(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return k1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public a a() {
        return m1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b a() {
        return m1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public m a() {
        return m1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x a() {
        return m1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public i b() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public m b() {
        return l1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public l c(a1 a1) {
        return o1(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public n c(a1 a1) {
        return o1(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public x c(a1 a1) {
        return o1(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b0 getReturnType() {
        final b0 returnType = super.getReturnType();
        n.d(returnType);
        return returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public final n h0() {
        return this.V;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 j1(m m, z z2, u u3, b.a b$a4, boolean z5) {
        n.f(m, "newOwner");
        n.f(z2, "modality");
        n.f(u3, "visibility");
        n.f(a4, "kind");
        x obj2 = s().n(m).c(z2).m(u3).p(a4).i(z5).build();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (h0)obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public b k0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        return j1(m, z2, u3, a4, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    protected kotlin.reflect.jvm.internal.impl.descriptors.j1.i0 k1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        Object obj9;
        n.f(m, "newOwner");
        n.f(a3, "kind");
        n.f(g5, "annotations");
        n.f(u06, "source");
        final b.a dECLARATION = b.a.DECLARATION;
        if (a3 != dECLARATION) {
            obj9 = b.a.SYNTHESIZED;
        }
        super(this.V, n1(), p0(), this, g5, dECLARATION, u06);
        return obj9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public y0 l1() {
        return n1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 m1() {
        return (h0)super.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public y0 n1() {
        return this.W;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public kotlin.reflect.jvm.internal.impl.descriptors.j1.h0 o1(a1 a1) {
        n.f(a1, "substitutor");
        x obj3 = super.c(a1);
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        a1 a1Var = a1.f((i0)obj3.getReturnType());
        n.e(a1Var, "create(substitutedTypeAliasConstructor.returnType)");
        d dVar = p0().a().c(a1Var);
        if (dVar == null) {
            return null;
        }
        obj3.X = dVar;
        return obj3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public d p0() {
        return this.X;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public boolean y() {
        return p0().y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.p
    public e z() {
        e eVar = p0().z();
        n.e(eVar, "underlyingConstructorDescriptor.constructedClass");
        return eVar;
    }
}
