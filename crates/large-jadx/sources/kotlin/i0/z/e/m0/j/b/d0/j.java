package kotlin.i0.z.e.m0.j.b.d0;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.z.b;
import kotlin.i0.z.e.m0.e.z.b.b;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.h;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.w;

/* loaded from: classes3.dex */
public final class j extends b0 implements kotlin.i0.z.e.m0.j.b.d0.b {

    private final n S;
    private final c T;
    private final g U;
    private final i V;
    private final kotlin.i0.z.e.m0.j.b.d0.f W;
    public j(m m, o0 o02, g g3, z z4, u u5, boolean z6, e e7, b.a b$a8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, n n14, c c15, g g16, i i17, kotlin.i0.z.e.m0.j.b.d0.f f18) {
        Object obj12 = this;
        Object obj2 = m;
        n.f(obj2, "containingDeclaration");
        final Object obj3 = g3;
        n.f(obj3, "annotations");
        final Object obj4 = z4;
        n.f(obj4, "modality");
        final Object obj5 = u5;
        n.f(obj5, "visibility");
        final Object obj6 = e7;
        n.f(obj6, "name");
        final Object obj7 = a8;
        n.f(obj7, "kind");
        n.f(n14, "proto");
        n.f(c15, "nameResolver");
        n.f(g16, "typeTable");
        n.f(i17, "versionRequirementTable");
        Object obj = this;
        super(obj2, o02, obj3, obj4, obj5, z6, obj6, obj7, u0.a, z9, z10, z13, 0, z11, z12);
        obj.S = n14;
        obj.T = c15;
        obj.U = g16;
        obj.V = i17;
        obj.W = f18;
        kotlin.i0.z.e.m0.j.b.d0.g.a cOMPATIBLE = g.a.COMPATIBLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public o B() {
        return a1();
    }

    public List<h> H0() {
        return b.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    protected b0 N0(m m, z z2, u u3, o0 o04, b.a b$a5, e e6, u0 u07) {
        n.f(m, "newOwner");
        n.f(z2, "newModality");
        n.f(u3, "newVisibility");
        n.f(a5, "kind");
        n.f(e6, "newName");
        n.f(u07, "source");
        super(m, o04, getAnnotations(), z2, u3, j0(), e6, a5, r0(), isConst(), w(), N(), L(), a1(), Z(), S(), Y(), c0());
        return jVar2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public g S() {
        return this.U;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public i Y() {
        return this.V;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public c Z() {
        return this.T;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public n a1() {
        return this.S;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public final void b1(c0 c0, q0 q02, v v3, v v4, kotlin.i0.z.e.m0.j.b.d0.g.a g$a5) {
        n.f(a5, "isExperimentalCoroutineInReleaseEnvironment");
        super.T0(c0, q02, v3, v4);
        final w obj2 = w.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public kotlin.i0.z.e.m0.j.b.d0.f c0() {
        return this.W;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b0
    public boolean w() {
        Boolean bool = b.C.g(a1().M());
        n.e(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }
}
