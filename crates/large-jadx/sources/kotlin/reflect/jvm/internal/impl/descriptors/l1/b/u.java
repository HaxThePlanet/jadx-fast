package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.util.Collection;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class u extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n implements u {

    private final b a;
    public u(b b) {
        n.f(b, "fqName");
        super();
        this.a = b;
    }

    public Collection<u> A() {
        return p.g();
    }

    public List<a> Q() {
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public b d() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof u && n.b(d(), (u)object.d())) {
            obj2 = n.b(d(), (u)object.d()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection getAnnotations() {
        return Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean n() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public a o(b b) {
        n.f(b, "fqName");
        return null;
    }

    public Collection<g> r(l<? super e, Boolean> l) {
        n.f(l, "nameFilter");
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(u.class.getName());
        stringBuilder.append(": ");
        stringBuilder.append(d());
        return stringBuilder.toString();
    }
}
