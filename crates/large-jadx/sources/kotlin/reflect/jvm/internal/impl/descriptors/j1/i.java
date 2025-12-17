package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i implements j0 {

    private final List<g0> a;
    public i(List<? extends g0> list) {
        n.f(list, "providers");
        super();
        this.a = list;
        int size = list.size();
        int obj2 = p.P0(list).size();
    }

    public List<f0> a(b b) {
        Object next;
        n.f(b, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        for (g0 next : iterator) {
            i0.a(next, b, arrayList);
        }
        return p.L0(arrayList);
    }

    public void b(b b, Collection<f0> collection2) {
        Object next;
        n.f(b, "fqName");
        n.f(collection2, "packageFragments");
        Iterator iterator = this.a.iterator();
        for (g0 next : iterator) {
            i0.a(next, b, collection2);
        }
    }

    public Collection<b> n(b b, l<? super e, Boolean> l2) {
        Collection collection;
        n.f(b, "fqName");
        n.f(l2, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator iterator = this.a.iterator();
        for (g0 next2 : iterator) {
            hashSet.addAll(next2.n(b, l2));
        }
        return hashSet;
    }
}
