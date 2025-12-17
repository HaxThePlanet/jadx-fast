package kotlin.i0.z.e.m0.j.b.d0;

import java.util.List;
import java.util.Map;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.h;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* loaded from: classes3.dex */
public final class k extends f0 implements kotlin.i0.z.e.m0.j.b.d0.b {

    private final i V;
    private final c W;
    private final g X;
    private final i Y;
    private final kotlin.i0.z.e.m0.j.b.d0.f Z;
    private kotlin.i0.z.e.m0.j.b.d0.g.a a0;
    public k(m m, t0 t02, g g3, e e4, b.a b$a5, i i6, c c7, g g8, i i9, kotlin.i0.z.e.m0.j.b.d0.f f10, u0 u011) {
        Object str;
        u0 u0Var;
        final Object obj8 = this;
        final Object obj9 = i6;
        final Object obj10 = c7;
        final Object obj11 = g8;
        final Object obj12 = i9;
        Object obj2 = m;
        n.f(m, "containingDeclaration");
        Object obj4 = g3;
        n.f(g3, "annotations");
        n.f(e4, "name");
        n.f(a5, "kind");
        n.f(obj9, "proto");
        n.f(obj10, "nameResolver");
        n.f(obj11, "typeTable");
        n.f(obj12, "versionRequirementTable");
        u0Var = u011 == null ? str : u011;
        super(m, t02, g3, e4, a5, u0Var);
        obj8.V = obj9;
        obj8.W = obj10;
        obj8.X = obj11;
        obj8.Y = obj12;
        obj8.Z = f10;
        obj8.a0 = g.a.COMPATIBLE;
    }

    public k(m m, t0 t02, g g3, e e4, b.a b$a5, i i6, c c7, g g8, i i9, kotlin.i0.z.e.m0.j.b.d0.f f10, u0 u011, int i12, g g13) {
        int i2;
        int i;
        i = i3 &= 1024 != 0 ? i2 : u011;
        super(m, t02, g3, e4, a5, i6, c7, g8, i9, f10, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public o B() {
        return p1();
    }

    public List<h> H0() {
        return b.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    protected p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        e name;
        e eVar;
        Object obj = m;
        n.f(m, "newOwner");
        n.f(a3, "kind");
        n.f(g5, "annotations");
        n.f(u06, "source");
        if (e4 == null) {
            name = getName();
            n.e(name, "name");
            eVar = name;
        } else {
            eVar = e4;
        }
        super(m, (t0)x2, g5, eVar, a3, p1(), Z(), S(), Y(), c0(), u06);
        kVar.X0(P0());
        kVar.a0 = o1();
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public g S() {
        return this.X;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public i Y() {
        return this.Y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public c Z() {
        return this.W;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public kotlin.i0.z.e.m0.j.b.d0.f c0() {
        return this.Z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public kotlin.i0.z.e.m0.j.b.d0.g.a o1() {
        return this.a0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public i p1() {
        return this.V;
    }

    public final f0 q1(r0 r0, r0 r02, List<? extends z0> list3, List<? extends c1> list4, b0 b05, z z6, u u7, Map<? extends a.a<?>, ?> map8, kotlin.i0.z.e.m0.j.b.d0.g.a g$a9) {
        n.f(list3, "typeParameters");
        n.f(list4, "unsubstitutedValueParameters");
        n.f(u7, "visibility");
        n.f(map8, "userDataMap");
        n.f(a9, "isExperimentalCoroutineInReleaseEnvironment");
        super.n1(r0, r02, list3, list4, b05, z6, u7, map8);
        n.e(this, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.a0 = a9;
        return this;
    }
}
