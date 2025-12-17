package kotlin.i0.z.e.m0.j.b.d0;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.d;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.h;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* loaded from: classes3.dex */
public final class c extends f implements kotlin.i0.z.e.m0.j.b.d0.b {

    private final d X;
    private final c Y;
    private final g Z;
    private final i a0;
    private final kotlin.i0.z.e.m0.j.b.d0.f b0;
    private kotlin.i0.z.e.m0.j.b.d0.g.a c0;
    public c(e e, l l2, g g3, boolean z4, b.a b$a5, d d6, c c7, g g8, i i9, kotlin.i0.z.e.m0.j.b.d0.f f10, u0 u011) {
        Object str;
        u0 u0Var;
        final Object obj7 = this;
        final Object obj8 = d6;
        final Object obj9 = c7;
        final Object obj10 = g8;
        final Object obj11 = i9;
        Object obj2 = e;
        n.f(e, "containingDeclaration");
        Object obj4 = g3;
        n.f(g3, "annotations");
        n.f(a5, "kind");
        n.f(obj8, "proto");
        n.f(obj9, "nameResolver");
        n.f(obj10, "typeTable");
        n.f(obj11, "versionRequirementTable");
        u0Var = u011 == null ? str : u011;
        super(e, l2, g3, z4, a5, u0Var);
        obj7.X = obj8;
        obj7.Y = obj9;
        obj7.Z = obj10;
        obj7.a0 = obj11;
        obj7.b0 = f10;
        obj7.c0 = g.a.COMPATIBLE;
    }

    public c(e e, l l2, g g3, boolean z4, b.a b$a5, d d6, c c7, g g8, i i9, kotlin.i0.z.e.m0.j.b.d0.f f10, u0 u011, int i12, g g13) {
        int i;
        int i2;
        i2 = i3 &= 1024 != 0 ? i : u011;
        super(e, l2, g3, z4, a5, d6, c7, g8, i9, f10, i2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public o B() {
        return s1();
    }

    public List<h> H0() {
        return b.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return q1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public boolean O() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public g S() {
        return this.Z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public i Y() {
        return this.a0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public c Z() {
        return this.Y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public kotlin.i0.z.e.m0.j.b.d0.f c0() {
        return this.b0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public boolean isSuspend() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected f m1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        return q1(m, x2, a3, e4, g5, u06);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    protected kotlin.i0.z.e.m0.j.b.d0.c q1(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        n.f(m, "newOwner");
        final Object obj4 = a3;
        n.f(obj4, "kind");
        final Object obj3 = g5;
        n.f(obj3, "annotations");
        final Object obj5 = u06;
        n.f(obj5, "source");
        super((e)m, (l)x2, obj3, obj2.V, obj4, s1(), Z(), S(), Y(), c0(), obj5);
        cVar.X0(P0());
        cVar.t1(r1());
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public boolean r() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public kotlin.i0.z.e.m0.j.b.d0.g.a r1() {
        return this.c0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public d s1() {
        return this.X;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public void t1(kotlin.i0.z.e.m0.j.b.d0.g.a g$a) {
        n.f(a, "<set-?>");
        this.c0 = a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f
    public boolean w() {
        return 0;
    }
}
