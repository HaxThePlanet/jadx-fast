package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.j1.g;

/* loaded from: classes3.dex */
public final class m0 extends kotlin.i0.z.e.m0.l.w0 {

    private final kotlin.i0.z.e.m0.l.b0 a;
    public m0(h h) {
        n.f(h, "kotlinBuiltIns");
        super();
        final kotlin.i0.z.e.m0.l.i0 obj2 = h.I();
        n.e(obj2, "kotlinBuiltIns.nullableAnyType");
        this.a = obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.h1 a() {
        return h1.OUT_VARIANCE;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.v0 b(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public boolean c() {
        return 1;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.b0 getType() {
        return this.a;
    }
}
