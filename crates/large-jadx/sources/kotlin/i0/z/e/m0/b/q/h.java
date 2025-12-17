package kotlin.i0.z.e.m0.b.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.p.a;
import kotlin.i0.z.e.m0.c.b.c.a;
import kotlin.i0.z.e.m0.d.b.m;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.u.a;
import kotlin.i0.z.e.m0.j.a;
import kotlin.i0.z.e.m0.j.b.a;
import kotlin.i0.z.e.m0.j.b.c0.a;
import kotlin.i0.z.e.m0.j.b.c0.c;
import kotlin.i0.z.e.m0.j.b.c0.c.a;
import kotlin.i0.z.e.m0.j.b.d;
import kotlin.i0.z.e.m0.j.b.i;
import kotlin.i0.z.e.m0.j.b.i.a;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.k;
import kotlin.i0.z.e.m0.j.b.m;
import kotlin.i0.z.e.m0.j.b.n;
import kotlin.i0.z.e.m0.j.b.p;
import kotlin.i0.z.e.m0.j.b.q.a;
import kotlin.i0.z.e.m0.j.b.s;
import kotlin.i0.z.e.m0.j.b.t.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.l;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h extends a {
    public h(n n, m m2, c0 c03, e0 e04, a a5, c c6, k k7, l l8, a a9) {
        Object obj9 = n;
        Object obj8 = c03;
        Object obj7 = e04;
        n.f(obj9, "storageManager");
        n.f(m2, "finder");
        n.f(obj8, "moduleDescriptor");
        n.f(obj7, "notFoundClasses");
        n.f(a5, "additionalClassPartsProvider");
        n.f(c6, "platformDependentDeclarationFilter");
        n.f(k7, "deserializationConfiguration");
        n.f(l8, "kotlinTypeChecker");
        n.f(a9, "samConversionResolver");
        super(n, m2, c03);
        m mVar2 = new m(this);
        a aVar = a.m;
        d dVar2 = new d(obj8, obj7, aVar);
        p pVar = p.a;
        n.e(pVar, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.descriptors.i1.b[] arr = new b[2];
        a aVar3 = new a(obj9, c03);
        super(n, c03, 0, 4, 0);
        kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var2 = this;
        super(n, c03, k7, mVar2, dVar2, this, t.a.a, pVar, c.a.a, q.a.a, p.j(aVar3, eVar), e04, i.a.a(), a5, c6, aVar.e(), l8, a9, 0, 262144, 0);
        this.h(jVar4);
    }

    @Override // kotlin.i0.z.e.m0.j.b.a
    protected n c(b b) {
        c.a aVar;
        Object obj;
        n nVar;
        c0 c0Var;
        int i;
        int obj8;
        n.f(b, "fqName");
        final java.io.InputStream inputStream = e().b(b);
        if (inputStream == null) {
            obj8 = 0;
        } else {
            obj8 = c.E.a(b, g(), f(), inputStream, false);
        }
        return obj8;
    }
}
