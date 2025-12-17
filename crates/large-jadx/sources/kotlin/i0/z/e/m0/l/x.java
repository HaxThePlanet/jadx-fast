package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.h.f;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class x extends kotlin.i0.z.e.m0.l.v implements kotlin.i0.z.e.m0.l.d1 {

    private final kotlin.i0.z.e.m0.l.v v;
    private final kotlin.i0.z.e.m0.l.b0 w;
    public x(kotlin.i0.z.e.m0.l.v v, kotlin.i0.z.e.m0.l.b0 b02) {
        n.f(v, "origin");
        n.f(b02, "enhancement");
        super(v.T0(), v.U0());
        this.v = v;
        this.w = b02;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 C0() {
        return W0();
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.b0 F() {
        return this.w;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
        return e1.d(W0().P0(z), F().O0().P0(z));
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        n.f(g, "newAnnotations");
        return e1.d(W0().R0(g), F());
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.i0 S0() {
        return W0().S0();
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public String V0(c c, f f2) {
        n.f(c, "renderer");
        n.f(f2, "options");
        if (f2.f()) {
            return c.x(F());
        }
        return W0().V0(c, f2);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.v W0() {
        return this.v;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.l.x X0(g g) {
        n.f(g, "kotlinTypeRefiner");
        x xVar = new x((v)g.g(W0()), g.g(F()));
        return xVar;
    }
}
