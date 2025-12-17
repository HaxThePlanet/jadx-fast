package kotlin.i0.z.e.m0.i.p.a;

import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.j1.j;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c implements kotlin.i0.z.e.m0.i.p.a.b {

    private final v0 a;
    private j b;
    public c(v0 v0) {
        n.f(v0, "projection");
        super();
        this.a = v0;
        h1 obj2 = e().a();
        h1 iNVARIANT = h1.INVARIANT;
    }

    public Collection<b0> a() {
        b0 type;
        if (e().a() == h1.OUT_VARIANCE) {
            type = e().getType();
        } else {
            type = m().I();
        }
        n.e(type, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return p.b(type);
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public t0 b(g g) {
        return h(g);
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public h c() {
        return (h)f();
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public boolean d() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public v0 e() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public Void f() {
        return null;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public final j g() {
        return this.b;
    }

    public List<z0> getParameters() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public kotlin.i0.z.e.m0.i.p.a.c h(g g) {
        n.f(g, "kotlinTypeRefiner");
        final v0 obj3 = e().b(g);
        n.e(obj3, "projection.refine(kotlinTypeRefiner)");
        c cVar = new c(obj3);
        return cVar;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public final void i(j j) {
        this.b = j;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public h m() {
        h hVar = e().getType().L0().m();
        n.e(hVar, "projection.type.constructor.builtIns");
        return hVar;
    }

    @Override // kotlin.i0.z.e.m0.i.p.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CapturedTypeConstructor(");
        stringBuilder.append(e());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
