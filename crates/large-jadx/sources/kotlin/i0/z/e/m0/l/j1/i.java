package kotlin.i0.z.e.m0.l.j1;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.l1.b;
import kotlin.i0.z.e.m0.l.l1.c;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i extends i0 implements c {

    private final b b;
    private final kotlin.i0.z.e.m0.l.j1.j c;
    private final g1 v;
    private final g w;
    private final boolean x;
    private final boolean y;
    public i(b b, g1 g12, v0 v03, z0 z04) {
        n.f(b, "captureStatus");
        n.f(v03, "projection");
        n.f(z04, "typeParameter");
        super(v03, 0, 0, z04, 6, 0);
        super(b, jVar, g12, 0, 0, 0, 56, 0);
    }

    public i(b b, kotlin.i0.z.e.m0.l.j1.j j2, g1 g13, g g4, boolean z5, boolean z6) {
        n.f(b, "captureStatus");
        n.f(j2, "constructor");
        n.f(g4, "annotations");
        super();
        this.b = b;
        this.c = j2;
        this.v = g13;
        this.w = g4;
        this.x = z5;
        this.y = z6;
    }

    public i(b b, kotlin.i0.z.e.m0.l.j1.j j2, g1 g13, g g4, boolean z5, boolean z6, int i7, g g8) {
        int i2;
        int i;
        g obj11;
        if (i7 & 8 != 0) {
            obj11 = g.q.b();
        }
        int obj15 = 0;
        i2 = i7 & 16 != 0 ? obj15 : z5;
        i = i7 & 32 != 0 ? obj15 : z6;
        super(b, j2, g13, obj11, i2, i);
    }

    public List<v0> K0() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public t0 L0() {
        return V0();
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public boolean M0() {
        return this.x;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public b0 N0(kotlin.i0.z.e.m0.l.j1.g g) {
        return Z0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g1 P0(boolean z) {
        return Y0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g1 Q0(kotlin.i0.z.e.m0.l.j1.g g) {
        return Z0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g1 R0(g g) {
        return a1(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public i0 S0(boolean z) {
        return Y0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public i0 T0(g g) {
        return a1(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public final b U0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.j1.j V0() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public final g1 W0() {
        return this.v;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public final boolean X0() {
        return this.y;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.j1.i Y0(boolean z) {
        super(this.b, V0(), this.v, getAnnotations(), z, 0, 32, 0);
        return iVar2;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.j1.i Z0(kotlin.i0.z.e.m0.l.j1.g g) {
        int obj11;
        n.f(g, "kotlinTypeRefiner");
        g1 g1Var = this.v;
        if (g1Var == null) {
            obj11 = 0;
        } else {
            obj11 = g.g(g1Var).O0();
        }
        super(this.b, V0().j(g), obj11, getAnnotations(), M0(), 0, 32, 0);
        return obj11;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.j1.i a1(g g) {
        n.f(g, "newAnnotations");
        super(this.b, V0(), this.v, g, M0(), 0, 32, 0);
        return iVar;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g getAnnotations() {
        return this.w;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public h o() {
        h hVar = t.i("No member resolution should be done on captured type!", true);
        n.e(hVar, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return hVar;
    }
}
