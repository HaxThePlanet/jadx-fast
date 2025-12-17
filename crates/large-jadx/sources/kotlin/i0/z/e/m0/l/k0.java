package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class k0 extends kotlin.i0.z.e.m0.l.m implements kotlin.i0.z.e.m0.l.d1 {

    private final kotlin.i0.z.e.m0.l.i0 b;
    private final kotlin.i0.z.e.m0.l.b0 c;
    public k0(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.b0 b02) {
        n.f(i0, "delegate");
        n.f(b02, "enhancement");
        super();
        this.b = i0;
        this.c = b02;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 C0() {
        return U0();
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.b0 F() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        return T0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        return (i0)e1.d(C0().P0(z), F().O0().P0(z));
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 T0(g g) {
        n.f(g, "newAnnotations");
        return (i0)e1.d(C0().R0(g), F());
    }

    @Override // kotlin.i0.z.e.m0.l.m
    protected kotlin.i0.z.e.m0.l.i0 U0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 V0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.m W0(kotlin.i0.z.e.m0.l.i0 i0) {
        return Y0(i0);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.k0 X0(g g) {
        n.f(g, "kotlinTypeRefiner");
        k0 k0Var = new k0((i0)g.g(U0()), g.g(F()));
        return k0Var;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.k0 Y0(kotlin.i0.z.e.m0.l.i0 i0) {
        n.f(i0, "delegate");
        k0 k0Var = new k0(i0, F());
        return k0Var;
    }
}
