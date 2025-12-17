package kotlin.i0.z.e.m0.d.a.g0;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.d.a.e0.c;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.d;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.k.h;
import kotlin.i0.z.e.m0.k.n;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.b;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d implements g {

    private final kotlin.i0.z.e.m0.d.a.g0.g a;
    private final d b;
    private final boolean c;
    private final h<a, c> v;

    static final class a extends p implements l<a, c> {

        final kotlin.i0.z.e.m0.d.a.g0.d this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final c a(a a) {
            n.f(a, "annotation");
            return c.a.e(a, d.g(this.this$0), d.d(this.this$0));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((a)object);
        }
    }
    public d(kotlin.i0.z.e.m0.d.a.g0.g g, d d2, boolean z3) {
        n.f(g, "c");
        n.f(d2, "annotationOwner");
        super();
        this.a = g;
        this.b = d2;
        this.c = z3;
        d.a obj3 = new d.a(this);
        this.v = g.a().t().i(obj3);
    }

    public d(kotlin.i0.z.e.m0.d.a.g0.g g, d d2, boolean z3, int i4, g g5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(g, d2, obj3);
    }

    public static final boolean d(kotlin.i0.z.e.m0.d.a.g0.d d) {
        return d.c;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g g(kotlin.i0.z.e.m0.d.a.g0.d d) {
        return d.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean isEmpty() {
        boolean empty;
        int i;
        if (this.b.getAnnotations().isEmpty() && !this.b.n()) {
            i = !this.b.n() ? 1 : 0;
        } else {
        }
        return i;
    }

    public Iterator<c> iterator() {
        return i.n(i.x(i.u(p.M(this.b.getAnnotations()), this.v), c.a.a(k.a.u, this.b, this.a))).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public c o(b b) {
        int invoke;
        h hVar;
        kotlin.i0.z.e.m0.d.a.g0.g gVar;
        n.f(b, "fqName");
        a aVar = this.b.o(b);
        if (aVar == null) {
            invoke = 0;
        } else {
            invoke = this.v.invoke(aVar);
        }
        if (invoke == 0) {
            invoke = c.a.a(b, this.b, this.a);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean u1(b b) {
        return g.b.b(this, b);
    }
}
