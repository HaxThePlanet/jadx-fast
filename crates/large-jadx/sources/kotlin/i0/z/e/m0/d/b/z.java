package kotlin.i0.z.e.m0.d.b;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.q.c;
import kotlin.i0.z.e.m0.b.q.c.a;
import kotlin.i0.z.e.m0.d.a.j0.r;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.i0.z.e.m0.l.b1;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.n;

/* loaded from: classes3.dex */
public final class z {
    public static final <T> T a(kotlin.i0.z.e.m0.d.b.k<T> k, T t2, boolean z3) {
        Object obj2;
        n.f(k, "<this>");
        n.f(t2, "possiblyPrimitiveType");
        if (z3) {
            obj2 = k.d(t2);
        }
        return obj2;
    }

    public static final <T> T b(b1 b1, h h2, kotlin.i0.z.e.m0.d.b.k<T> k3, kotlin.i0.z.e.m0.d.b.y y4) {
        int i;
        Object obj5;
        boolean obj6;
        Object obj8;
        n.f(b1, "<this>");
        n.f(h2, "type");
        n.f(k3, "typeFactory");
        n.f(y4, "mode");
        kotlin.i0.z.e.m0.l.l1.l lVar = b1.q(h2);
        final int i2 = 0;
        if (!b1.H(lVar)) {
            return i2;
        }
        kotlin.i0.z.e.m0.b.i iVar = b1.R(lVar);
        i = 1;
        final int i3 = 0;
        if (iVar != null && !b1.X(h2)) {
            if (!b1.X(h2)) {
                if (r.b(b1, h2)) {
                } else {
                    i = i3;
                }
            }
            return z.a(k3, k3.f(iVar), i);
        }
        obj6 = b1.j(lVar);
        if (obj6 != null) {
            return k3.b(n.o("[", d.get(obj6).getDesc()));
        }
        if (b1.g(lVar)) {
            obj5 = b1.x(lVar);
            if (obj5 == null) {
                obj5 = i2;
            } else {
                obj5 = c.a.o(obj5);
            }
            if (obj5 != null && !y4.a()) {
                if (!y4.a()) {
                    obj6 = c.a.j();
                    if (obj6 instanceof Collection != null && obj6.isEmpty()) {
                        if (obj6.isEmpty()) {
                            i = i3;
                        } else {
                            obj6 = obj6.iterator();
                            while (obj6.hasNext()) {
                                if (!n.b((c.a)obj6.next().d(), obj5)) {
                                    break;
                                }
                            }
                        }
                    } else {
                    }
                    if (i != 0) {
                        return i2;
                    }
                }
                obj5 = c.b(obj5).f();
                n.e(obj5, "byClassId(classId).internalName");
                return k3.c(obj5);
            }
        }
        return i2;
    }
}
