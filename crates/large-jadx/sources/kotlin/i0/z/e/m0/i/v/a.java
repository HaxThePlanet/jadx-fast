package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;

/* loaded from: classes3.dex */
public abstract class a implements kotlin.i0.z.e.m0.i.v.h {
    public Collection<t0> a(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return i().a(e, b2);
    }

    public Set<e> b() {
        return i().b();
    }

    public Collection<o0> c(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return i().c(e, b2);
    }

    public Set<e> d() {
        return i().d();
    }

    public Set<e> e() {
        return i().e();
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public h f(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return i().f(e, b2);
    }

    public Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        return i().g(d, l2);
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    public final kotlin.i0.z.e.m0.i.v.h h() {
        kotlin.i0.z.e.m0.i.v.h hVar;
        if (hVar2 instanceof a) {
            hVar = (a)i().h();
        } else {
            hVar = i();
        }
        return hVar;
    }

    @Override // kotlin.i0.z.e.m0.i.v.h
    protected abstract kotlin.i0.z.e.m0.i.v.h i();
}
