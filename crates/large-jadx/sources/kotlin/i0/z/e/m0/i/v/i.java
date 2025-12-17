package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.utils.d;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class i implements kotlin.i0.z.e.m0.i.v.h {
    public Collection<? extends t0> a(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return p.g();
    }

    public Set<e> b() {
        Object next;
        boolean str;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = g(d.r, d.a()).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof t0) {
            }
            next = (t0)next.getName();
            n.e(next, "it.name");
            linkedHashSet.add(next);
        }
        return linkedHashSet;
    }

    public Collection<? extends o0> c(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return p.g();
    }

    public Set<e> d() {
        Object next;
        boolean str;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = g(d.s, d.a()).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof t0) {
            }
            next = (t0)next.getName();
            n.e(next, "it.name");
            linkedHashSet.add(next);
        }
        return linkedHashSet;
    }

    public Set<e> e() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public h f(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return null;
    }

    public Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        return p.g();
    }
}
