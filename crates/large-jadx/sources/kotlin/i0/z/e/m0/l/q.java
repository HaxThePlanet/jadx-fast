package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.h.f;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.l1.e;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class q extends kotlin.i0.z.e.m0.l.v implements e {

    private final g v;
    public q(h h, g g2) {
        n.f(h, "builtIns");
        n.f(g2, "annotations");
        kotlin.i0.z.e.m0.l.i0 i0Var = h.H();
        n.e(i0Var, "builtIns.nothingType");
        final kotlin.i0.z.e.m0.l.i0 obj3 = h.I();
        n.e(obj3, "builtIns.nullableAnyType");
        super(i0Var, obj3);
        this.v = g2;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public boolean M0() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        X0(g);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
        W0(z);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        X0(g);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        return Y0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.i0 S0() {
        return U0();
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public String V0(c c, f f2) {
        n.f(c, "renderer");
        n.f(f2, "options");
        return "dynamic";
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.q W0(boolean z) {
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.q X0(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.q Y0(g g) {
        n.f(g, "newAnnotations");
        q qVar = new q(a.e(S0()), g);
        return qVar;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public g getAnnotations() {
        return this.v;
    }
}
