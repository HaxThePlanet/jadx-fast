package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class s extends kotlin.i0.z.e.m0.l.i0 {

    private final kotlin.i0.z.e.m0.l.t0 b;
    private final h c;
    private final List<kotlin.i0.z.e.m0.l.v0> v;
    private final boolean w;
    private final String x;
    public s(kotlin.i0.z.e.m0.l.t0 t0, h h2) {
        n.f(t0, "constructor");
        n.f(h2, "memberScope");
        super(t0, h2, 0, 0, 0, 28, 0);
    }

    public s(kotlin.i0.z.e.m0.l.t0 t0, h h2, List<? extends kotlin.i0.z.e.m0.l.v0> list3, boolean z4) {
        n.f(t0, "constructor");
        n.f(h2, "memberScope");
        n.f(list3, "arguments");
        super(t0, h2, list3, z4, 0, 16, 0);
    }

    public s(kotlin.i0.z.e.m0.l.t0 t0, h h2, List<? extends kotlin.i0.z.e.m0.l.v0> list3, boolean z4, String string5) {
        n.f(t0, "constructor");
        n.f(h2, "memberScope");
        n.f(list3, "arguments");
        n.f(string5, "presentableName");
        super();
        this.b = t0;
        this.c = h2;
        this.v = list3;
        this.w = z4;
        this.x = string5;
    }

    public s(kotlin.i0.z.e.m0.l.t0 t0, h h2, List list3, boolean z4, String string5, int i6, g g7) {
        List obj9;
        int obj10;
        String obj11;
        if (i6 & 4 != 0) {
            obj9 = p.g();
        }
        obj10 = i6 & 8 != 0 ? 0 : obj10;
        obj11 = i6 & 16 != 0 ? "???" : obj11;
        super(t0, h2, obj9, obj10, obj11);
    }

    public List<kotlin.i0.z.e.m0.l.v0> K0() {
        return this.v;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.t0 L0() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public boolean M0() {
        return this.w;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return V0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.g1 Q0(g g) {
        return V0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.g1 R0(g g) {
        T0(g);
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.i0 S0(boolean z) {
        super(L0(), o(), K0(), z, 0, 16, 0);
        return sVar2;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.i0 T0(g g) {
        n.f(g, "newAnnotations");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public String U0() {
        return this.x;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public kotlin.i0.z.e.m0.l.s V0(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public g getAnnotations() {
        return g.q.b();
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public h o() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.i0
    public String toString() {
        String str;
        List list;
        String str2;
        String str3;
        String str5;
        int i2;
        String str4;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(L0());
        if (K0().isEmpty()) {
            str = "";
        } else {
            str = p.g0(K0(), ", ", "<", ">", -1, "...", 0);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
