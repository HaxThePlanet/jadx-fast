package kotlin.i0.z.e.m0.d.a.j0;

import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.l.b1;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class r {
    public static final kotlin.i0.z.e.m0.d.a.j0.e a(kotlin.i0.z.e.m0.d.a.j0.h h, kotlin.i0.z.e.m0.d.a.j0.f f2, boolean z3, boolean z4) {
        kotlin.i0.z.e.m0.d.a.j0.h obj4;
        if (z4 != null && h != h.NOT_NULL) {
            if (h != h.NOT_NULL) {
            }
            obj4 = new e(h, f2, 1, z3);
            return obj4;
        }
        obj4 = new e(h, f2, 0, z3);
        return obj4;
    }

    public static final boolean b(b1 b1, h h2) {
        n.f(b1, "<this>");
        n.f(h2, "type");
        kotlin.i0.z.e.m0.f.b bVar = y.o;
        n.e(bVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return b1.U(h2, bVar);
    }

    public static final <T> T c(Set<? extends T> set, T t2, T t3, T t4, boolean z5) {
        Object obj1;
        Object obj2;
        Object obj4;
        n.f(set, "<this>");
        n.f(t2, "low");
        n.f(t3, "high");
        if (z5) {
            int i = 0;
            obj1 = set.contains(t2) ? t2 : obj1 != null ? t3 : i;
            if (n.b(obj1, t2) && n.b(t4, t3)) {
                if (n.b(t4, t3)) {
                    obj4 = i;
                } else {
                    if (t4 == null) {
                        obj4 = obj1;
                    }
                }
            } else {
            }
            return obj4;
        }
        if (t4 == null) {
        } else {
            obj2 = p.P0(q0.j(set, t4));
            if (obj2 == null) {
            } else {
                obj1 = obj2;
            }
        }
        return p.A0(obj1);
    }

    public static final kotlin.i0.z.e.m0.d.a.j0.h d(Set<? extends kotlin.i0.z.e.m0.d.a.j0.h> set, kotlin.i0.z.e.m0.d.a.j0.h h2, boolean z3) {
        Object fORCE_FLEXIBILITY;
        kotlin.i0.z.e.m0.d.a.j0.h nULLABLE;
        Object obj2;
        n.f(set, "<this>");
        if (h2 == h.FORCE_FLEXIBILITY) {
        } else {
            fORCE_FLEXIBILITY = obj2;
        }
        return fORCE_FLEXIBILITY;
    }
}
