package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.c.b;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.d.a;
import kotlin.i0.z.e.m0.i.v.i;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public class g0 extends i {

    private final c0 b;
    private final b c;
    public g0(c0 c0, b b2) {
        n.f(c0, "moduleDescriptor");
        n.f(b2, "fqName");
        super();
        this.b = c0;
        this.c = b2;
    }

    public Set<e> e() {
        return q0.b();
    }

    public Collection<m> g(d d, l<? super e, Boolean> l2) {
        boolean z;
        int size;
        boolean booleanValue;
        Object obj4;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        if (!d.a(d.c.g())) {
            return p.g();
        }
        if (this.c.d() && d.n().contains(c.b.a)) {
            if (d.n().contains(c.b.a)) {
                return p.g();
            }
        }
        obj4 = this.b.n(this.c, l2);
        ArrayList arrayList = new ArrayList(obj4.size());
        obj4 = obj4.iterator();
        while (obj4.hasNext()) {
            size = (b)obj4.next().g();
            n.e(size, "subFqName.shortName()");
            if ((Boolean)l2.invoke(size).booleanValue()) {
            }
            a.a(arrayList, h(size));
        }
        return arrayList;
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    protected final k0 h(e e) {
        n.f(e, "name");
        final int i = 0;
        if (e.k()) {
            return i;
        }
        b obj4 = this.c.c(e);
        n.e(obj4, "fqName.child(name)");
        obj4 = this.b.M(obj4);
        if (obj4.isEmpty()) {
            return i;
        }
        return obj4;
    }
}
