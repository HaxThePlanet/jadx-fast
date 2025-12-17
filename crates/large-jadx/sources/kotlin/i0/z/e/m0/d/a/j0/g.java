package kotlin.i0.z.e.m0.d.a.j0;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.e1;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j;
import kotlin.i0.z.e.m0.l.m;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.v;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class g extends m implements j {

    private final i0 b;
    public g(i0 i0) {
        n.f(i0, "delegate");
        super();
        this.b = i0;
    }

    private final i0 X0(i0 i0) {
        i0 i0Var = i0.S0(false);
        if (!a.i(i0)) {
            return i0Var;
        }
        g obj2 = new g(i0Var);
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public boolean E() {
        return 1;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public b0 J(b0 b0) {
        boolean z;
        g1 g1Var;
        i0 i0Var;
        g1 obj3;
        n.f(b0, "replacement");
        obj3 = b0.O0();
        if (!a.i(obj3) && !c1.l(obj3)) {
            if (!c1.l(obj3)) {
                return obj3;
            }
        }
        if (obj3 instanceof i0) {
            obj3 = X0((i0)obj3);
            return obj3;
        } else {
            if (!obj3 instanceof v) {
            } else {
                c0 c0Var = c0.a;
                g1 g1Var2 = obj3;
                obj3 = e1.d(c0.d(X0((v)g1Var2.T0()), X0(g1Var2.U0())), e1.a(obj3));
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Incorrect type: ", obj3).toString());
        throw illegalStateException;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public boolean M0() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public g1 R0(g g) {
        return Y0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public i0 S0(boolean z) {
        int i;
        i0 obj2;
        if (z) {
            obj2 = U0().S0(true);
        } else {
            obj2 = this;
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public i0 T0(g g) {
        return Y0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    protected i0 U0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public m W0(i0 i0) {
        return Z0(i0);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.d.a.j0.g Y0(g g) {
        n.f(g, "newAnnotations");
        g gVar = new g(U0().T0(g));
        return gVar;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.d.a.j0.g Z0(i0 i0) {
        n.f(i0, "delegate");
        g gVar = new g(i0);
        return gVar;
    }
}
