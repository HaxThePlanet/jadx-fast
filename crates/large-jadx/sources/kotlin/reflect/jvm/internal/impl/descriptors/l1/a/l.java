package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.j;
import kotlin.i0.z.e.m0.c.b.c.a;
import kotlin.i0.z.e.m0.d.a.c;
import kotlin.i0.z.e.m0.d.a.e0.f.a;
import kotlin.i0.z.e.m0.d.a.e0.g;
import kotlin.i0.z.e.m0.d.a.e0.j;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.c.b;
import kotlin.i0.z.e.m0.d.a.g0.f;
import kotlin.i0.z.e.m0.d.a.g0.i;
import kotlin.i0.z.e.m0.d.a.j0.d;
import kotlin.i0.z.e.m0.d.a.j0.l;
import kotlin.i0.z.e.m0.d.a.r.a;
import kotlin.i0.z.e.m0.d.b.b;
import kotlin.i0.z.e.m0.d.b.d;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.d.b.f;
import kotlin.i0.z.e.m0.d.b.m;
import kotlin.i0.z.e.m0.d.b.u;
import kotlin.i0.z.e.m0.d.b.u.a;
import kotlin.i0.z.e.m0.i.u.b;
import kotlin.i0.z.e.m0.j.b.i;
import kotlin.i0.z.e.m0.j.b.i.a;
import kotlin.i0.z.e.m0.j.b.k.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.l;
import kotlin.i0.z.e.m0.l.j1.l.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0.a;
import kotlin.reflect.jvm.internal.impl.utils.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class l {
    public static final d a(c0 c0, n n2, e0 e03, f f4, m m5, e e6) {
        Object obj = m5;
        Object obj2 = e6;
        n.f(c0, "module");
        n.f(n2, "storageManager");
        n.f(e03, "notFoundClasses");
        final Object obj3 = f4;
        n.f(obj3, "lazyJavaPackageFragmentProvider");
        n.f(obj, "reflectKotlinClassFinder");
        n.f(obj2, "deserializedDescriptorResolver");
        f fVar = new f(obj, obj2);
        b bVar = new b(c0, e03, n2, obj);
        super(n2, c0, k.a.a, fVar, bVar, obj3, e03, j.b, c.a.a, i.a.a(), l.b.a());
        return dVar2;
    }

    public static final f b(java.lang.ClassLoader classLoader, c0 c02, n n3, e0 e04, m m5, e e6, i i7, u u8) {
        Object obj = classLoader;
        Object obj8 = n3;
        n.f(obj, "classLoader");
        n.f(c02, "module");
        n.f(obj8, "storageManager");
        n.f(e04, "notFoundClasses");
        n.f(m5, "reflectKotlinClassFinder");
        n.f(e6, "deserializedDescriptorResolver");
        n.f(i7, "singleModuleClassResolver");
        n.f(u8, "packagePartProvider");
        e eVar3 = e.j;
        c cVar2 = new c(obj8, eVar3);
        d dVar4 = new d(obj);
        j jVar = j.a;
        n.e(jVar, "DO_NOTHING");
        g gVar = g.a;
        n.e(gVar, "EMPTY");
        b bVar7 = new b(obj8, p.g());
        j jVar2 = new j(c02, e04);
        c.b bVar4 = c.b.a;
        d dVar2 = new d(bVar4);
        l lVar = new l(cVar2, eVar3, dVar2);
        super(n3, dVar4, m5, e6, jVar, j.b, gVar, f.a.a, bVar7, m.a, i7, u8, x0.a.a, c.a.a, c02, jVar2, cVar2, lVar, r.a.a, bVar4, l.b.a(), eVar3);
        f fVar = new f(bVar5);
        return fVar;
    }

    public static f c(java.lang.ClassLoader classLoader, c0 c02, n n3, e0 e04, m m5, e e6, i i7, u u8, int i9, Object object10) {
        u.a i;
        u.a aVar;
        aVar = i2 &= 128 != 0 ? i : u8;
        return l.b(classLoader, c02, n3, e04, m5, e6, i7, aVar);
    }
}
