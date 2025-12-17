package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
final class h extends kotlin.i0.z.e.m0.l.n {

    private final g c;
    public h(kotlin.i0.z.e.m0.l.i0 i0, g g2) {
        n.f(i0, "delegate");
        n.f(g2, "annotations");
        super(i0);
        this.c = g2;
    }

    @Override // kotlin.i0.z.e.m0.l.n
    public kotlin.i0.z.e.m0.l.m W0(kotlin.i0.z.e.m0.l.i0 i0) {
        return Y0(i0);
    }

    @Override // kotlin.i0.z.e.m0.l.n
    public kotlin.i0.z.e.m0.l.h Y0(kotlin.i0.z.e.m0.l.i0 i0) {
        n.f(i0, "delegate");
        h hVar = new h(i0, getAnnotations());
        return hVar;
    }

    @Override // kotlin.i0.z.e.m0.l.n
    public g getAnnotations() {
        return this.c;
    }
}
