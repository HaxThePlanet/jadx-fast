package kotlin.i0.z.e.m0.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.c;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c {

    public static final kotlin.i0.z.e.m0.b.c a;
    private static final Set<a> b;
    static {
        int i;
        String str;
        c cVar = new c();
        c.a = cVar;
        Set nUMBER_TYPES = i.NUMBER_TYPES;
        kotlin.i0.z.e.m0.b.k kVar = k.a;
        ArrayList arrayList = new ArrayList(p.r(nUMBER_TYPES, 10));
        Iterator iterator = nUMBER_TYPES.iterator();
        for (i next4 : iterator) {
            arrayList.add(k.c(next4));
        }
        kotlin.i0.z.e.m0.f.b bVar = k.a.g.l();
        n.e(bVar, "string.toSafe()");
        kotlin.i0.z.e.m0.f.b bVar2 = k.a.i.l();
        n.e(bVar2, "_boolean.toSafe()");
        kotlin.i0.z.e.m0.f.b bVar3 = k.a.r.l();
        n.e(bVar3, "_enum.toSafe()");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator2 = p.u0(p.u0(p.u0(arrayList, bVar), bVar2), bVar3).iterator();
        for (b next3 : iterator2) {
            linkedHashSet.add(a.m(next3));
        }
        c.b = linkedHashSet;
    }

    public final Set<a> a() {
        return c.b;
    }

    public final Set<a> b() {
        return c.b;
    }
}
