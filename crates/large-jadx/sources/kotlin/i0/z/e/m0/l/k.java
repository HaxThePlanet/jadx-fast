package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.j1.n;
import kotlin.i0.z.e.m0.l.l1.d;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class k extends kotlin.i0.z.e.m0.l.m implements kotlin.i0.z.e.m0.l.j, d {

    public static final kotlin.i0.z.e.m0.l.k.a v;
    private final kotlin.i0.z.e.m0.l.i0 b;
    private final boolean c;

    public static final class a {
        public a(g g) {
            super();
        }

        private final boolean a(kotlin.i0.z.e.m0.l.g1 g1) {
            int obj2;
            g1.L0();
            if (!hVar instanceof z0) {
                if (g1 instanceof i) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        private final boolean c(kotlin.i0.z.e.m0.l.g1 g1, boolean z2) {
            boolean obj3;
            if (!a(g1)) {
                return 0;
            }
            if (z2 && obj3 instanceof z0) {
                if (obj3 instanceof z0) {
                    return c1.l(g1);
                }
            }
            return obj2 ^= 1;
        }

        public final kotlin.i0.z.e.m0.l.k b(kotlin.i0.z.e.m0.l.g1 g1, boolean z2) {
            boolean kVar;
            boolean z;
            Object i;
            kotlin.i0.z.e.m0.l.t0 t0Var;
            Object obj4;
            n.f(g1, "type");
            if (g1 instanceof k) {
                i = g1;
            } else {
                if (c(g1, z2) && g1 instanceof v) {
                    if (g1 instanceof v) {
                        Object obj = g1;
                        n.b((v)obj.T0().L0(), obj.U0().L0());
                    }
                    kVar = new k(y.c(g1), z2, 0);
                    i = kVar;
                }
            }
            return i;
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.v = aVar;
    }

    private k(kotlin.i0.z.e.m0.l.i0 i0, boolean z2) {
        super();
        this.b = i0;
        this.c = z2;
    }

    public k(kotlin.i0.z.e.m0.l.i0 i0, boolean z2, g g3) {
        super(i0, z2);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public boolean E() {
        int i;
        U0().L0();
        i = hVar instanceof z0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.b0 J(kotlin.i0.z.e.m0.l.b0 b0) {
        n.f(b0, "replacement");
        return l0.e(b0.O0(), this.c);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public boolean M0() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        return Y0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        kotlin.i0.z.e.m0.l.i0 i0Var;
        kotlin.i0.z.e.m0.l.i0 obj2;
        if (z) {
            obj2 = U0().S0(z);
        } else {
            obj2 = this;
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 T0(g g) {
        return Y0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    protected kotlin.i0.z.e.m0.l.i0 U0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.m W0(kotlin.i0.z.e.m0.l.i0 i0) {
        return Z0(i0);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public final kotlin.i0.z.e.m0.l.i0 X0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.k Y0(g g) {
        n.f(g, "newAnnotations");
        k kVar = new k(U0().T0(g), this.c);
        return kVar;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.k Z0(kotlin.i0.z.e.m0.l.i0 i0) {
        n.f(i0, "delegate");
        k kVar = new k(i0, this.c);
        return kVar;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(U0());
        stringBuilder.append("!!");
        return stringBuilder.toString();
    }
}
