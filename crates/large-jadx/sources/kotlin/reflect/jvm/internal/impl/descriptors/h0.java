package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.j0.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h0 implements kotlin.reflect.jvm.internal.impl.descriptors.j0 {

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.f0> a;

    static final class a extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.f0, b> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.h0.a a;
        static {
            h0.a aVar = new h0.a();
            h0.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b a(kotlin.reflect.jvm.internal.impl.descriptors.f0 f0) {
            n.f(f0, "it");
            return f0.d();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((f0)object);
        }
    }

    static final class b extends p implements l<b, Boolean> {

        final b $fqName;
        b(b b) {
            this.$fqName = b;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            boolean $fqName;
            Object obj2;
            n.f(b, "it");
            if (!b.d() && n.b(b.e(), this.$fqName)) {
                obj2 = n.b(b.e(), this.$fqName) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }
    public h0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.f0> collection) {
        n.f(collection, "packageFragments");
        super();
        this.a = collection;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.f0> a(b b) {
        Object next;
        boolean z;
        n.f(b, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (n.b((f0)next.d(), b)) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public void b(b b, Collection<kotlin.reflect.jvm.internal.impl.descriptors.f0> collection2) {
        Object next;
        boolean z;
        n.f(b, "fqName");
        n.f(collection2, "packageFragments");
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (n.b((f0)next.d(), b)) {
            }
            collection2.add(next);
        }
    }

    public Collection<b> n(b b, l<? super e, Boolean> l2) {
        n.f(b, "fqName");
        n.f(l2, "nameFilter");
        h0.b bVar = new h0.b(b);
        return i.A(i.l(i.u(p.M(this.a), h0.a.a), bVar));
    }
}
