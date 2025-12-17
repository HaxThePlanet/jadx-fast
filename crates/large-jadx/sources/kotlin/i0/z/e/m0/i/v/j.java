package kotlin.i0.z.e.m0.i.v;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j {
    public static final Set<e> a(Iterable<? extends kotlin.i0.z.e.m0.i.v.h> iterable) {
        HashSet hashSet;
        Set next;
        n.f(iterable, "<this>");
        hashSet = new HashSet();
        final Iterator obj2 = iterable.iterator();
        while (obj2.hasNext()) {
            next = (h)obj2.next().e();
            if (next == null) {
                break;
            } else {
            }
            p.y(hashSet, next);
        }
        return hashSet;
    }
}
