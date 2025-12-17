package kotlin.i0.z.e.m0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.f.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a {

    public static final kotlin.i0.z.e.m0.a a;
    private static final Set<a> b;
    static {
        int i;
        a aVar = new a();
        a.a = aVar;
        kotlin.i0.z.e.m0.f.b[] arr = new b[6];
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator = p.j(y.a, y.h, y.i, y.c, y.d, y.f).iterator();
        for (b next2 : iterator) {
            linkedHashSet.add(a.m(next2));
        }
        a.b = linkedHashSet;
    }

    public final Set<a> a() {
        return a.b;
    }
}
