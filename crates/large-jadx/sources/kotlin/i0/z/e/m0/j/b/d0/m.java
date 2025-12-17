package kotlin.i0.z.e.m0.j.b.d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.e.s;
import kotlin.i0.z.e.m0.e.z.f;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.j.b.b0;
import kotlin.i0.z.e.m0.j.b.c;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.l;
import kotlin.i0.z.e.m0.j.b.v;
import kotlin.i0.z.e.m0.j.b.y;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class m extends b {

    private final l C;
    private final s D;
    private final kotlin.i0.z.e.m0.j.b.d0.a E;

    static final class a extends p implements a<List<? extends c>> {

        final kotlin.i0.z.e.m0.j.b.d0.m this$0;
        a(kotlin.i0.z.e.m0.j.b.d0.m m) {
            this.this$0 = m;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<c> invoke() {
            return p.L0(m.L0(this.this$0).c().d().a(this.this$0.N0(), m.L0(this.this$0).g()));
        }
    }
    public m(l l, s s2, int i3) {
        n.f(l, "c");
        n.f(s2, "proto");
        kotlin.i0.z.e.m0.e.s.c cVar2 = s2.N();
        n.e(cVar2, "proto.variance");
        super(l.h(), l.e(), v.b(l.g(), s2.H()), y.a.d(cVar2), s2.I(), i3, u0.a, x0.a.a);
        this.C = l;
        this.D = s2;
        m.a obj13 = new m.a(this);
        a obj12 = new a(l.h(), obj13);
        this.E = obj12;
    }

    public static final l L0(kotlin.i0.z.e.m0.j.b.d0.m m) {
        return m.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    protected void J0(b0 b0) {
        O0(b0);
        throw 0;
    }

    protected List<b0> K0() {
        int i;
        List list = f.o(this.D, this.C.j());
        if (list.isEmpty()) {
            return p.b(a.g(this).y());
        }
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (q next2 : iterator) {
            arrayList.add(this.C.i().p(next2));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    public kotlin.i0.z.e.m0.j.b.d0.a M0() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    public final s N0() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    protected Void O0(b0 b0) {
        n.f(b0, "type");
        IllegalStateException obj2 = new IllegalStateException(n.o("There should be no cycles for deserialized type parameters, but found for: ", this));
        throw obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.b
    public g getAnnotations() {
        return M0();
    }
}
