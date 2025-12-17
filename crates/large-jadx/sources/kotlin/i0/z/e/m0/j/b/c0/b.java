package kotlin.i0.z.e.m0.j.b.c0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.b.a;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.c.b.c.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.u.b;
import kotlin.i0.z.e.m0.j.a;
import kotlin.i0.z.e.m0.j.b.d;
import kotlin.i0.z.e.m0.j.b.i;
import kotlin.i0.z.e.m0.j.b.i.a;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.k.a;
import kotlin.i0.z.e.m0.j.b.m;
import kotlin.i0.z.e.m0.j.b.o;
import kotlin.i0.z.e.m0.j.b.p;
import kotlin.i0.z.e.m0.j.b.q.a;
import kotlin.i0.z.e.m0.j.b.t.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b implements a {

    private final kotlin.i0.z.e.m0.j.b.c0.d b;

    class a extends j implements l<String, InputStream> {
        a(kotlin.i0.z.e.m0.j.b.c0.d d) {
            super(1, d);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "loadResource";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(d.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((String)object);
        }

        @Override // kotlin.d0.d.j
        public final InputStream l(String string) {
            n.f(string, "p0");
            return (d)this.receiver.a(string);
        }
    }
    public b() {
        super();
        d dVar = new d();
        this.b = dVar;
    }

    public g0 a(n n, c0 c02, Iterable<? extends b> iterable3, c c4, a a5, boolean z6) {
        n.f(n, "storageManager");
        n.f(c02, "builtInsModule");
        n.f(iterable3, "classDescriptorFactories");
        n.f(c4, "platformDependentDeclarationFilter");
        n.f(a5, "additionalClassPartsProvider");
        b.a aVar2 = new b.a(obj.b);
        return this.b(n, c02, k.p, iterable3, c4, a5, z6, aVar2);
    }

    public final g0 b(n n, c0 c02, Set<b> set3, Iterable<? extends b> iterable4, c c5, a a6, boolean z7, l<? super String, ? extends InputStream> l8) {
        Object obj;
        int i;
        n next;
        n nVar;
        c0 c0Var;
        c0 c0Var2;
        Object obj2;
        boolean z;
        Object obj5 = n;
        Object obj7 = c02;
        obj = set3;
        Object obj3 = l8;
        n.f(obj5, "storageManager");
        n.f(obj7, "module");
        n.f(obj, "packageFqNames");
        n.f(iterable4, "classDescriptorFactories");
        n.f(c5, "platformDependentDeclarationFilter");
        n.f(a6, "additionalClassPartsProvider");
        n.f(obj3, "loadResource");
        ArrayList arrayList = new ArrayList(p.r(obj, 10));
        Iterator iterator2 = set3.iterator();
        for (Object next3 : iterator2) {
            i = next3;
            String str = a.m.n((b)i);
            obj2 = invoke;
            arrayList.add(c.E.a(i, n, c02, (InputStream)obj2, z7));
        }
        h0 h0Var = new h0(arrayList);
        e0 e0Var = new e0(obj5, obj7);
        m mVar2 = new m(h0Var);
        kotlin.i0.z.e.m0.j.b.c0.a aVar5 = a.m;
        d dVar2 = new d(obj7, e0Var, aVar5);
        p pVar = p.a;
        n.e(pVar, "DO_NOTHING");
        b bVar = new b(obj5, p.g());
        super(n, c02, k.a.a, mVar2, dVar2, h0Var, t.a.a, pVar, c.a.a, q.a.a, iterable4, e0Var, i.a.a(), a6, c5, aVar5.e(), 0, bVar, 0, 327680, 0);
        Iterator iterator = arrayList.iterator();
        for (c next : iterator) {
            next.K0(jVar2);
        }
        return h0Var;
    }
}
