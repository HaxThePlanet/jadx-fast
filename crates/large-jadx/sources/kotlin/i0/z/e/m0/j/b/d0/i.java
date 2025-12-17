package kotlin.i0.z.e.m0.j.b.d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.a;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.e.l;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.e.z.i.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.l;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public class i extends kotlin.i0.z.e.m0.j.b.d0.h {

    private final f0 g;
    private final b h;
    public i(f0 f0, l l2, c c3, a a4, kotlin.i0.z.e.m0.j.b.d0.f f5, j j6, a<? extends Collection<e>> a7) {
        final Object obj7 = this;
        final Object obj9 = f0;
        n.f(obj9, "packageDescriptor");
        n.f(l2, "proto");
        n.f(c3, "nameResolver");
        n.f(a4, "metadataVersion");
        n.f(j6, "components");
        final Object obj6 = a7;
        n.f(obj6, "classNames");
        kotlin.i0.z.e.m0.e.t tVar = l2.P();
        n.e(tVar, "proto.typeTable");
        g gVar = new g(tVar);
        kotlin.i0.z.e.m0.e.w wVar = l2.Q();
        n.e(wVar, "proto.versionRequirementTable");
        List list2 = l2.I();
        n.e(list2, "proto.functionList");
        List list4 = l2.L();
        n.e(list4, "proto.propertyList");
        List list6 = l2.O();
        n.e(list6, "proto.typeAliasList");
        super(j6.a(f0, c3, gVar, i.b.a(wVar), a4, f5), list2, list4, list6, obj6);
        obj7.g = obj9;
        obj7.h = f0.d();
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.h
    public void A(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        a.b(q().c().o(), b2, this.g, e);
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.h
    public h f(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        A(e, b2);
        return super.f(e, b2);
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.h
    public Collection g(d d, l l2) {
        return z(d, l2);
    }

    protected void j(Collection<m> collection, l<? super e, Boolean> l2) {
        n.f(collection, "result");
        n.f(l2, "nameFilter");
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.h
    protected a n(e e) {
        n.f(e, "name");
        a aVar = new a(this.h, e);
        return aVar;
    }

    protected Set<e> t() {
        return q0.b();
    }

    protected Set<e> u() {
        return q0.b();
    }

    protected Set<e> v() {
        return q0.b();
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.h
    protected boolean x(e e) {
        boolean iterator;
        int i;
        boolean empty;
        b bVar;
        Object obj6;
        n.f(e, "name");
        final int i2 = 0;
        if (!super.x(e)) {
            iterator = q().c().k();
            if (iterator instanceof Collection != null && (Collection)iterator.isEmpty()) {
                if ((Collection)iterator.isEmpty()) {
                    obj6 = i2;
                } else {
                    iterator = iterator.iterator();
                    for (b next : iterator) {
                    }
                }
            } else {
            }
            if (obj6 != null) {
            } else {
                i = i2;
            }
        }
        return i;
    }

    public List<m> z(d d, l<? super e, Boolean> l2) {
        Collection collection;
        b bVar;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        ArrayList arrayList = new ArrayList();
        Iterator obj5 = q().c().k().iterator();
        for (b next2 : obj5) {
            p.y(arrayList, next2.a(this.h));
        }
        return p.t0(k(d, l2, d.WHEN_GET_ALL_DESCRIPTORS), arrayList);
    }
}
