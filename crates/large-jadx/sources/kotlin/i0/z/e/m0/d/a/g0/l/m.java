package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.a.e0.k;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.d;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.g0.m.c;
import kotlin.i0.z.e.m0.d.a.g0.m.d;
import kotlin.i0.z.e.m0.d.a.i0.t;
import kotlin.i0.z.e.m0.d.a.i0.y;
import kotlin.i0.z.e.m0.d.a.j0.l;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class m extends b {

    private final g C;
    private final y D;
    private final d E;
    public m(g g, y y2, int i3, m m4) {
        final Object obj5 = this;
        n.f(g, "c");
        n.f(y2, "javaTypeParameter");
        Object obj3 = m4;
        n.f(obj3, "containingDeclaration");
        super(g.e(), obj3, y2.getName(), h1.INVARIANT, 0, i3, u0.a, g.a().u());
        obj5.C = g;
        obj5.D = y2;
        super(g, y2, 0, 4, 0);
        obj5.E = dVar2;
    }

    private final List<b0> L0() {
        int i2;
        c cVar;
        kotlin.i0.z.e.m0.d.a.g0.m.a aVar;
        int i4;
        int i;
        int i3;
        Collection upperBounds = this.D.getUpperBounds();
        if (upperBounds.isEmpty()) {
            c0 c0Var = c0.a;
            kotlin.i0.z.e.m0.l.i0 i0Var = this.C.d().m().i();
            n.e(i0Var, "c.module.builtIns.anyType");
            kotlin.i0.z.e.m0.l.i0 i0Var2 = this.C.d().m().I();
            n.e(i0Var2, "c.module.builtIns.nullableAnyType");
            return p.b(c0.d(i0Var, i0Var2));
        }
        ArrayList arrayList = new ArrayList(p.r(upperBounds, 10));
        Iterator iterator = upperBounds.iterator();
        for (j next2 : iterator) {
            arrayList.add(this.C.g().n(next2, d.f(k.COMMON, false, this, 1, 0)));
        }
        return arrayList;
    }

    protected List<b0> C0(List<? extends b0> list) {
        n.f(list, "bounds");
        return this.C.a().q().g(this, list, this.C);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    protected void J0(b0 b0) {
        n.f(b0, "type");
    }

    protected List<b0> K0() {
        return L0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    public d M0() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    public g getAnnotations() {
        return M0();
    }
}
