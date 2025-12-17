package kotlin.i0.z.e.m0.i.v;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f extends kotlin.i0.z.e.m0.i.v.i {

    private final kotlin.i0.z.e.m0.i.v.h b;
    public f(kotlin.i0.z.e.m0.i.v.h h) {
        n.f(h, "workerScope");
        super();
        this.b = h;
    }

    public Set<e> b() {
        return this.b.b();
    }

    public Set<e> d() {
        return this.b.d();
    }

    public Set<e> e() {
        return this.b.e();
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public h f(e e, b b2) {
        h hVar;
        int obj3;
        n.f(e, "name");
        n.f(b2, "location");
        final h obj2 = this.b.f(e, b2);
        if (obj2 == null) {
        } else {
            if (obj2 instanceof e) {
                hVar = obj2;
            } else {
                hVar = obj3;
            }
            if (hVar == null) {
                if (obj2 instanceof y0) {
                    obj3 = obj2;
                }
            } else {
                obj3 = hVar;
            }
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public Collection g(kotlin.i0.z.e.m0.i.v.d d, l l2) {
        return h(d, l2);
    }

    public List<h> h(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        kotlin.i0.z.e.m0.i.v.h next;
        boolean z;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        kotlin.i0.z.e.m0.i.v.d obj3 = d.p(d.c.d());
        if (obj3 == null) {
            return p.g();
        }
        ArrayList obj4 = new ArrayList();
        obj3 = this.b.g(obj3, l2).iterator();
        while (obj3.hasNext()) {
            next = obj3.next();
            if (next instanceof i) {
            }
            obj4.add(next);
        }
        return obj4;
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public String toString() {
        return n.o("Classes from ", this.b);
    }
}
