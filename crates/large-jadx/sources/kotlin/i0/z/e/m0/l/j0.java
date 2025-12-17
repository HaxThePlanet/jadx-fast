package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;

/* loaded from: classes3.dex */
final class j0 extends kotlin.i0.z.e.m0.l.i0 {

    private final kotlin.i0.z.e.m0.l.t0 b;
    private final List<kotlin.i0.z.e.m0.l.v0> c;
    private final boolean v;
    private final h w;
    private final l<g, kotlin.i0.z.e.m0.l.i0> x;
    public j0(kotlin.i0.z.e.m0.l.t0 t0, List<? extends kotlin.i0.z.e.m0.l.v0> list2, boolean z3, h h4, l<? super g, ? extends kotlin.i0.z.e.m0.l.i0> l5) {
        n.f(t0, "constructor");
        n.f(list2, "arguments");
        n.f(h4, "memberScope");
        n.f(l5, "refinedTypeFactory");
        super();
        this.b = t0;
        this.c = list2;
        this.v = z3;
        this.w = h4;
        this.x = l5;
        if (obj2 instanceof t.d) {
        } else {
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("SimpleTypeImpl should not be created for error type: ");
        obj3.append(o());
        obj3.append('\n');
        obj3.append(L0());
        IllegalStateException obj2 = new IllegalStateException(obj3.toString());
        throw obj2;
    }

    public List<kotlin.i0.z.e.m0.l.v0> K0() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.t0 L0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public boolean M0() {
        return this.v;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return U0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        return U0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        return T0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        kotlin.i0.z.e.m0.l.i0 obj2;
        if (z == M0()) {
            obj2 = this;
        } else {
            if (z) {
                obj2 = new g0(this);
            } else {
                obj2 = new f0(this);
            }
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.i0 T0(g g) {
        kotlin.i0.z.e.m0.l.i0 hVar;
        n.f(g, "newAnnotations");
        if (g.isEmpty()) {
            hVar = this;
        } else {
            hVar = new h(this, g);
        }
        return hVar;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.i0 U0(g g) {
        Object obj2;
        n.f(g, "kotlinTypeRefiner");
        if ((i0)this.x.invoke(g) == null) {
            obj2 = this;
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g getAnnotations() {
        return g.q.b();
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public h o() {
        return this.w;
    }
}
