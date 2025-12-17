package kotlin.i0.z.e.m0.d.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.q.f;
import kotlin.i0.z.e.m0.c.b.c;
import kotlin.i0.z.e.m0.d.a.g0.f;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.i.u.b;
import kotlin.i0.z.e.m0.j.b.i;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.k;
import kotlin.i0.z.e.m0.j.b.p;
import kotlin.i0.z.e.m0.j.b.t.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.l;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.c.b;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d {

    private final j a;
    public d(n n, c0 c02, k k3, kotlin.i0.z.e.m0.d.b.f f4, kotlin.i0.z.e.m0.d.b.b b5, f f6, e0 e07, p p8, c c9, i i10, l l11) {
        kotlin.i0.z.e.m0.b.h hVar;
        int i2;
        int i;
        c.b bVar;
        Object obj2 = n;
        n.f(obj2, "storageManager");
        n.f(c02, "moduleDescriptor");
        n.f(k3, "configuration");
        n.f(f4, "classDataFinder");
        n.f(b5, "annotationAndConstantLoader");
        n.f(f6, "packageFragmentProvider");
        n.f(e07, "notFoundClasses");
        n.f(p8, "errorReporter");
        n.f(c9, "lookupTracker");
        n.f(i10, "contractDeserializer");
        n.f(l11, "kotlinTypeChecker");
        super();
        i2 = 0;
        if (hVar instanceof f) {
        } else {
            hVar = i2;
        }
        if (hVar == null) {
            i = i2;
        } else {
            i = hVar.P0();
        }
        i = i == 0 ? a.a.a : i;
        if (hVar == null) {
        } else {
            i2 = hVar.P0();
        }
        bVar = i2 == 0 ? hVar : i2;
        b bVar2 = new b(obj2, p.g());
        super(n, c02, k3, f4, b5, f6, t.a.a, p8, c9, g.a, p.g(), e07, i10, i, bVar, h.a.a(), l11, bVar2, 0, 262144, 0);
        obj.a = jVar3;
    }

    public final j a() {
        return this.a;
    }
}
