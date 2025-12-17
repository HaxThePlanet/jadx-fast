package kotlin.i0.z.e.m0.d.a.g0;

import java.util.Collection;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.d.a.g0.l.h;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.d.a.q;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f implements j0 {

    private final kotlin.i0.z.e.m0.d.a.g0.g a;
    private final a<b, h> b;

    static final class a extends p implements a<h> {

        final u $jPackage;
        final kotlin.i0.z.e.m0.d.a.g0.f this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.f f, u u2) {
            this.this$0 = f;
            this.$jPackage = u2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final h a() {
            h hVar = new h(f.c(this.this$0), this.$jPackage);
            return hVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public f(kotlin.i0.z.e.m0.d.a.g0.b b) {
        n.f(b, "components");
        super();
        g gVar = new g(b, k.a.a, j.c(0));
        this.a = gVar;
        this.b = gVar.e().b();
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g c(kotlin.i0.z.e.m0.d.a.g0.f f) {
        return f.a;
    }

    private final h d(b b) {
        u uVar = this.a.a().d().b(b);
        if (uVar == null) {
            return null;
        }
        f.a aVar2 = new f.a(this, uVar);
        return (h)this.b.a(b, aVar2);
    }

    public List<h> a(b b) {
        n.f(b, "fqName");
        return p.k(d(b));
    }

    public void b(b b, Collection<f0> collection2) {
        n.f(b, "fqName");
        n.f(collection2, "packageFragments");
        a.a(collection2, d(b));
    }

    public List<b> e(b b, l<? super e, Boolean> l2) {
        int obj2;
        n.f(b, "fqName");
        n.f(l2, "nameFilter");
        obj2 = d(b);
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.N0();
        }
        if (obj2 != null) {
        } else {
            obj2 = p.g();
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    public Collection n(b b, l l2) {
        return e(b, l2);
    }
}
