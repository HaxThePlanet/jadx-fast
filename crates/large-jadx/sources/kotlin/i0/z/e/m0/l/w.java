package kotlin.i0.z.e.m0.l;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.h.f;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class w extends kotlin.i0.z.e.m0.l.v implements kotlin.i0.z.e.m0.l.j {

    public static boolean w;
    private boolean v;
    static {
    }

    public w(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.i0 i02) {
        n.f(i0, "lowerBound");
        n.f(i02, "upperBound");
        super(i0, i02);
    }

    private final void X0() {
        boolean z;
        kotlin.i0.z.e.m0.l.i0 i0Var;
        kotlin.i0.z.e.m0.l.i0 i0Var2;
        if (w.w) {
            if (this.v) {
            } else {
                this.v = true;
                y.b(T0());
                y.b(U0());
                n.b(T0(), U0());
                f.a.d(T0(), U0());
            }
        }
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public boolean E() {
        boolean z;
        int i;
        kotlin.i0.z.e.m0.l.t0 t0Var;
        if (hVar instanceof z0 && n.b(T0().L0(), U0().L0())) {
            i = n.b(T0().L0(), U0().L0()) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.b0 J(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.g1 g1Var;
        kotlin.i0.z.e.m0.l.i0 i0Var;
        n.f(b0, "replacement");
        kotlin.i0.z.e.m0.l.g1 obj3 = b0.O0();
        if (obj3 instanceof v) {
            g1Var = obj3;
            return e1.b(g1Var, obj3);
        } else {
            if (!obj3 instanceof i0) {
            } else {
                kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
                kotlin.i0.z.e.m0.l.g1 g1Var2 = obj3;
                g1Var = c0.d(g1Var2, (i0)g1Var2.S0(true));
            }
        }
        obj3 = new NoWhenBranchMatchedException();
        throw obj3;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return W0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
        kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
        return c0.d(T0().S0(z), U0().S0(z));
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        return W0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        n.f(g, "newAnnotations");
        kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
        return c0.d(T0().T0(g), U0().T0(g));
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.i0 S0() {
        X0();
        return T0();
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public String V0(c c, f f2) {
        n.f(c, "renderer");
        n.f(f2, "options");
        if (f2.o()) {
            StringBuilder obj4 = new StringBuilder();
            obj4.append('(');
            obj4.append(c.x(T0()));
            obj4.append("..");
            obj4.append(c.x(U0()));
            obj4.append(')');
            return obj4.toString();
        }
        return c.u(c.x(T0()), c.x(U0()), a.e(this));
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.v W0(g g) {
        n.f(g, "kotlinTypeRefiner");
        w wVar = new w((i0)g.g(T0()), (i0)g.g(U0()));
        return wVar;
    }
}
