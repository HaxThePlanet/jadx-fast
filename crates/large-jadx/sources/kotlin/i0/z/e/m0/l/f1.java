package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;

/* loaded from: classes3.dex */
public final class f1 extends kotlin.i0.z.e.m0.l.s {

    private final String y;
    public f1(String string, kotlin.i0.z.e.m0.l.t0 t02, h h3, List<? extends kotlin.i0.z.e.m0.l.v0> list4, boolean z5) {
        n.f(string, "presentableName");
        n.f(t02, "constructor");
        n.f(h3, "memberScope");
        n.f(list4, "arguments");
        super(t02, h3, list4, z5, 0, 16, 0);
        this.y = string;
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        W0(g);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
        return S0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        W0(g);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        super(U0(), L0(), o(), K0(), z);
        return f1Var2;
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public String U0() {
        return this.y;
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public kotlin.i0.z.e.m0.l.s V0(g g) {
        W0(g);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.s
    public kotlin.i0.z.e.m0.l.f1 W0(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }
}
