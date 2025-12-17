package kotlin.i0.z.e.m0.j.b.d0;

import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.r;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.h;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.z0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.d;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* loaded from: classes3.dex */
public final class l extends d implements kotlin.i0.z.e.m0.j.b.d0.g {

    private final r A;
    private final c B;
    private final g C;
    private final i D;
    private final kotlin.i0.z.e.m0.j.b.d0.f E;
    private Collection<? extends h0> F;
    private i0 G;
    private i0 H;
    private List<? extends z0> I;
    private i0 J;
    private kotlin.i0.z.e.m0.j.b.d0.g.a K;
    private final n z;
    public l(n n, m m2, g g3, e e4, u u5, r r6, c c7, g g8, i i9, kotlin.i0.z.e.m0.j.b.d0.f f10) {
        final Object obj4 = this;
        final Object obj5 = r6;
        final Object obj6 = c7;
        final Object obj7 = g8;
        final Object obj8 = i9;
        n.f(n, "storageManager");
        n.f(m2, "containingDeclaration");
        n.f(g3, "annotations");
        final Object obj2 = e4;
        n.f(obj2, "name");
        final Object obj3 = u5;
        n.f(obj3, "visibility");
        n.f(obj5, "proto");
        n.f(obj6, "nameResolver");
        n.f(obj7, "typeTable");
        n.f(obj8, "versionRequirementTable");
        final u0 u0Var = u0.a;
        n.e(u0Var, "NO_SOURCE");
        super(m2, g3, obj2, u0Var, obj3);
        obj4.z = n;
        obj4.A = obj5;
        obj4.B = obj6;
        obj4.C = obj7;
        obj4.D = obj8;
        obj4.E = f10;
        obj4.K = g.a.COMPATIBLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public o B() {
        return O0();
    }

    public List<h> H0() {
        return g.b.a(this);
    }

    protected List<z0> L0() {
        List list = this.I;
        if (list == null) {
        } else {
            return list;
        }
        n.w("typeConstructorParameters");
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public kotlin.i0.z.e.m0.j.b.d0.g.a N0() {
        return this.K;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public r O0() {
        return this.A;
    }

    public final void P0(List<? extends z0> list, i0 i02, i0 i03, kotlin.i0.z.e.m0.j.b.d0.g.a g$a4) {
        n.f(list, "declaredTypeParameters");
        n.f(i02, "underlyingType");
        n.f(i03, "expandedType");
        n.f(a4, "isExperimentalCoroutineInReleaseEnvironment");
        M0(list);
        this.G = i02;
        this.H = i03;
        this.I = a1.d(this);
        this.J = C0();
        this.F = K0();
        this.K = a4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public y0 Q0(a1 a1) {
        n.f(a1, "substitutor");
        if (a1.k()) {
            return this;
        }
        m mVar = b();
        n.e(mVar, "containingDeclaration");
        g annotations = getAnnotations();
        n.e(annotations, "annotations");
        final e name = getName();
        n.e(name, "name");
        super(h0(), mVar, annotations, name, getVisibility(), O0(), Z(), S(), Y(), c0());
        h1 iNVARIANT = h1.INVARIANT;
        b0 b0Var = a1.n(g0(), iNVARIANT);
        n.e(b0Var, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        b0 obj13 = a1.n(V(), iNVARIANT);
        n.e(obj13, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        lVar.P0(t(), z0.a(b0Var), z0.a(obj13), N0());
        return lVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public g S() {
        return this.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public i0 V() {
        i0 i0Var = this.H;
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        n.w("expandedType");
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public i Y() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public c Z() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public n c(a1 a1) {
        return Q0(a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public kotlin.i0.z.e.m0.j.b.d0.f c0() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public i0 g0() {
        i0 i0Var = this.G;
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        n.w("underlyingType");
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    protected n h0() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public e p() {
        boolean z2;
        int i;
        boolean z;
        i = 0;
        if (d0.a(V())) {
        } else {
            z2 = V().L0().c();
            if (z2 instanceof e) {
                i = z2;
            }
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.d
    public i0 q() {
        i0 i0Var = this.J;
        if (i0Var == null) {
        } else {
            return i0Var;
        }
        n.w("defaultTypeImpl");
        throw 0;
    }
}
