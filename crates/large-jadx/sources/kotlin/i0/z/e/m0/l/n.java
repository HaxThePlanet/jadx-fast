package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public abstract class n extends kotlin.i0.z.e.m0.l.m {

    private final kotlin.i0.z.e.m0.l.i0 b;
    public n(kotlin.i0.z.e.m0.l.i0 i0) {
        n.f(i0, "delegate");
        super();
        this.b = i0;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        if (z == M0()) {
            return this;
        }
        return U0().S0(z).T0(getAnnotations());
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.i0 T0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.m
    protected kotlin.i0.z.e.m0.l.i0 U0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.m
    public kotlin.i0.z.e.m0.l.n X0(g g) {
        kotlin.i0.z.e.m0.l.i0 hVar;
        n.f(g, "newAnnotations");
        if (g != getAnnotations()) {
            hVar = new h(this, g);
        } else {
            hVar = this;
        }
        return hVar;
    }
}
