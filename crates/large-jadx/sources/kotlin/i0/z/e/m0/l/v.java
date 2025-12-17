package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.h.f;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.l1.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public abstract class v extends kotlin.i0.z.e.m0.l.g1 implements f {

    private final kotlin.i0.z.e.m0.l.i0 b;
    private final kotlin.i0.z.e.m0.l.i0 c;
    public v(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.i0 i02) {
        n.f(i0, "lowerBound");
        n.f(i02, "upperBound");
        super(0);
        this.b = i0;
        this.c = i02;
    }

    public List<kotlin.i0.z.e.m0.l.v0> K0() {
        return S0().K0();
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public kotlin.i0.z.e.m0.l.t0 L0() {
        return S0().L0();
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public boolean M0() {
        return S0().M0();
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public abstract kotlin.i0.z.e.m0.l.i0 S0();

    @Override // kotlin.i0.z.e.m0.l.g1
    public final kotlin.i0.z.e.m0.l.i0 T0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public final kotlin.i0.z.e.m0.l.i0 U0() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public abstract String V0(c c, f f2);

    @Override // kotlin.i0.z.e.m0.l.g1
    public g getAnnotations() {
        return S0().getAnnotations();
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public h o() {
        return S0().o();
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public String toString() {
        return c.c.x(this);
    }
}
