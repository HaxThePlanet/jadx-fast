package kotlin.i0.z.e.m0.l;

import java.util.HashSet;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.l;
import kotlin.i0.z.e.m0.l.l1.n;

/* loaded from: classes3.dex */
public final class u {
    public static final h a(kotlin.i0.z.e.m0.l.b1 b1, h h2) {
        n.f(b1, "<this>");
        n.f(h2, "inlineClassType");
        HashSet hashSet = new HashSet();
        return u.b(b1, h2, hashSet);
    }

    private static final h b(kotlin.i0.z.e.m0.l.b1 b1, h h2, HashSet<l> hashSet3) {
        h hVar;
        Object obj3;
        int obj4;
        Object obj5;
        l lVar = b1.q(h2);
        final int i = 0;
        if (!hashSet3.add(lVar)) {
            return i;
        }
        kotlin.i0.z.e.m0.l.l1.m mVar = b1.u(lVar);
        if (mVar != null) {
            obj5 = u.b(b1, b1.k(mVar), hashSet3);
            if (obj5 == null) {
                obj4 = i;
            } else {
                if (!b1.X(obj5)) {
                    if (!b1.W(h2)) {
                        obj4 = obj5;
                    } else {
                        obj4 = obj3;
                    }
                } else {
                }
            }
        } else {
            h hVar2 = b1.M(h2);
            if (b1.L(lVar) && hVar2 == null) {
                hVar2 = b1.M(h2);
                if (hVar2 == null) {
                    return i;
                }
                obj5 = u.b(b1, hVar2, hashSet3);
                if (obj5 == null) {
                    return i;
                }
                if (!b1.X(h2)) {
                } else {
                    if (b1.X(obj5)) {
                    } else {
                        if (obj5 instanceof i && b1.h0((i)obj5)) {
                            if (b1.h0((i)obj5)) {
                            } else {
                                obj4 = b1.g0(obj5);
                            }
                        } else {
                        }
                    }
                }
            }
        }
        return obj4;
    }
}
