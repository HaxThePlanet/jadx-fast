package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.r;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.y;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e {
    public static final g1 a(List<? extends g1> list) {
        int i3;
        int i;
        int i2;
        kotlin.i0.z.e.m0.l.i0 next;
        boolean z;
        n.f(list, "types");
        int size = list.size();
        if (size == 0) {
        } else {
            int i4 = 1;
            if (size != i4) {
                int i5 = 10;
                ArrayList arrayList = new ArrayList(p.r(list, i5));
                Iterator iterator = list.iterator();
                final int i7 = 0;
                i2 = i;
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (i == 0) {
                    } else {
                    }
                    i = i4;
                    next = (v)next.T0();
                    i2 = i4;
                    arrayList.add(next);
                    if (d0.a((i0)next)) {
                    } else {
                    }
                    i = i7;
                }
                if (i != 0) {
                    kotlin.i0.z.e.m0.l.i0 obj9 = t.j(n.o("Intersection of error types: ", list));
                    n.e(obj9, "createErrorType(\"Intersection of error types: $types\")");
                    return obj9;
                }
                if (i2 == 0) {
                    return v.a.c(arrayList);
                }
                ArrayList arrayList2 = new ArrayList(p.r(list, i5));
                obj9 = list.iterator();
                for (g1 next3 : obj9) {
                    arrayList2.add(y.d(next3));
                }
                obj9 = c0.a;
                obj9 = v.a;
                return c0.d(obj9.c(arrayList), obj9.c(arrayList2));
            }
            return (g1)p.z0(list);
        }
        obj9 = new IllegalStateException("Expected some types".toString());
        throw obj9;
    }
}
