package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class a extends kotlin.i0.z.e.m0.l.m {

    private final kotlin.i0.z.e.m0.l.i0 b;
    private final kotlin.i0.z.e.m0.l.i0 c;
    public a(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.i0 i02) {
        n.f(i0, "delegate");
        n.f(i02, "abbreviation");
        super();
        this.b = i0;
        this.c = i02;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return Z0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
        return Y0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        return Z0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        return a1(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        return Y0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 T0(g g) {
        return a1(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    protected kotlin.i0.z.e.m0.l.i0 U0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public final kotlin.i0.z.e.m0.l.i0 V() {
        return U0();
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 V0(g g) {
        return Z0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.m W0(kotlin.i0.z.e.m0.l.i0 i0) {
        return b1(i0);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public final kotlin.i0.z.e.m0.l.i0 X0() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.a Y0(boolean z) {
        a aVar = new a(U0().S0(z), this.c.S0(z));
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.a Z0(g g) {
        n.f(g, "kotlinTypeRefiner");
        a aVar = new a((i0)g.g(U0()), (i0)g.g(this.c));
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.a a1(g g) {
        n.f(g, "newAnnotations");
        a aVar = new a(U0().T0(g), this.c);
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.a b1(kotlin.i0.z.e.m0.l.i0 i0) {
        n.f(i0, "delegate");
        a aVar = new a(i0, this.c);
        return aVar;
    }
}
