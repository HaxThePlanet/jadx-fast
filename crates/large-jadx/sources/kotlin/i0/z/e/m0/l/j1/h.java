package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.b0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h {

    private static final b0<kotlin.i0.z.e.m0.l.j1.o<kotlin.i0.z.e.m0.l.j1.g>> a;
    static {
        b0 b0Var = new b0("KotlinTypeRefiner");
        h.a = b0Var;
    }

    public static final b0<kotlin.i0.z.e.m0.l.j1.o<kotlin.i0.z.e.m0.l.j1.g>> a() {
        return h.a;
    }

    public static final List<b0> b(kotlin.i0.z.e.m0.l.j1.g g, Iterable<? extends b0> iterable2) {
        int i;
        n.f(g, "<this>");
        n.f(iterable2, "types");
        ArrayList arrayList = new ArrayList(p.r(iterable2, 10));
        final Iterator obj3 = iterable2.iterator();
        for (b0 next2 : obj3) {
            arrayList.add(g.g(next2));
        }
        return arrayList;
    }
}
