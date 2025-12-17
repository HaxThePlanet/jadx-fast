package kotlin.i0.z.e.m0.i.p.a;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.l1.c;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a extends i0 implements c {

    private final v0 b;
    private final kotlin.i0.z.e.m0.i.p.a.b c;
    private final boolean v;
    private final g w;
    public a(v0 v0, kotlin.i0.z.e.m0.i.p.a.b b2, boolean z3, g g4) {
        n.f(v0, "typeProjection");
        n.f(b2, "constructor");
        n.f(g4, "annotations");
        super();
        this.b = v0;
        this.c = b2;
        this.v = z3;
        this.w = g4;
    }

    public a(v0 v0, kotlin.i0.z.e.m0.i.p.a.b b2, boolean z3, g g4, int i5, g g6) {
        kotlin.i0.z.e.m0.i.p.a.c obj2;
        int obj3;
        g obj4;
        if (i5 & 2 != 0) {
            obj2 = new c(v0);
        }
        obj3 = i5 & 4 != 0 ? 0 : obj3;
        if (i5 &= 8 != 0) {
            obj4 = g.q.b();
        }
        super(v0, obj2, obj3, obj4);
    }

    public List<v0> K0() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public t0 L0() {
        return U0();
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public boolean M0() {
        return this.v;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public b0 N0(g g) {
        return W0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g1 P0(boolean z) {
        return V0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g1 Q0(g g) {
        return W0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g1 R0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public i0 S0(boolean z) {
        return V0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public i0 T0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.i.p.a.b U0() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.i.p.a.a V0(boolean z) {
        if (z == M0()) {
            return this;
        }
        a aVar = new a(this.b, U0(), z, getAnnotations());
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.i.p.a.a W0(g g) {
        n.f(g, "kotlinTypeRefiner");
        final v0 obj5 = this.b.b(g);
        n.e(obj5, "typeProjection.refine(kotlinTypeRefiner)");
        a aVar = new a(obj5, U0(), M0(), getAnnotations());
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.i.p.a.a X0(g g) {
        n.f(g, "newAnnotations");
        a aVar = new a(this.b, U0(), M0(), g);
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g getAnnotations() {
        return this.w;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public h o() {
        h hVar = t.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        n.e(hVar, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return hVar;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Captured(");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        str = M0() ? "?" : "";
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
