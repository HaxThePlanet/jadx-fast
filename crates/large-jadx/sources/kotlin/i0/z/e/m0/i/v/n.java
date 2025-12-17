package kotlin.i0.z.e.m0.i.v;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.k;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.m.n.a;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.utils.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class n extends kotlin.i0.z.e.m0.i.v.a {

    public static final kotlin.i0.z.e.m0.i.v.n.a c;
    private final kotlin.i0.z.e.m0.i.v.h b;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.i.v.h a(String string, Collection<? extends b0> collection2) {
            int i;
            n.f(string, "message");
            n.f(collection2, "types");
            ArrayList arrayList = new ArrayList(p.r(collection2, 10));
            Iterator obj4 = collection2.iterator();
            for (b0 next2 : obj4) {
                arrayList.add(next2.o());
            }
            obj4 = a.b(arrayList);
            kotlin.i0.z.e.m0.i.v.h hVar = b.d.b(string, obj4);
            if (obj4.size() <= 1) {
                return hVar;
            }
            obj4 = new n(string, hVar, 0);
            return obj4;
        }
    }

    static final class b extends p implements l<a, a> {

        public static final kotlin.i0.z.e.m0.i.v.n.b a;
        static {
            n.b bVar = new n.b();
            n.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final a a(a a) {
            n.f(a, "<this>");
            return a;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((a)object);
            return object;
        }
    }

    static final class c extends p implements l<t0, a> {

        public static final kotlin.i0.z.e.m0.i.v.n.c a;
        static {
            n.c cVar = new n.c();
            n.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final a a(t0 t0) {
            n.f(t0, "<this>");
            return t0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((t0)object);
            return object;
        }
    }

    static final class d extends p implements l<o0, a> {

        public static final kotlin.i0.z.e.m0.i.v.n.d a;
        static {
            n.d dVar = new n.d();
            n.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final a a(o0 o0) {
            n.f(o0, "<this>");
            return o0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((o0)object);
            return object;
        }
    }
    static {
        n.a aVar = new n.a(0);
        n.c = aVar;
    }

    private n(String string, kotlin.i0.z.e.m0.i.v.h h2) {
        super();
        this.b = h2;
    }

    public n(String string, kotlin.i0.z.e.m0.i.v.h h2, g g3) {
        super(string, h2);
    }

    public static final kotlin.i0.z.e.m0.i.v.h j(String string, Collection<? extends b0> collection2) {
        return n.c.a(string, collection2);
    }

    public Collection<t0> a(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return k.a(super.a(e, b2), n.c.a);
    }

    public Collection<o0> c(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return k.a(super.c(e, b2), n.d.a);
    }

    public Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        Object next;
        boolean z;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        ArrayList obj5 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = super.g(d, l2).iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            if (obj instanceof a) {
            } else {
            }
            arrayList.add(next);
            obj5.add(next);
        }
        obj4 = new o(obj5, arrayList);
        return p.t0(k.a((List)obj4.a(), n.b.a), (List)obj4.b());
    }

    @Override // kotlin.i0.z.e.m0.i.v.a
    protected kotlin.i0.z.e.m0.i.v.h i() {
        return this.b;
    }
}
