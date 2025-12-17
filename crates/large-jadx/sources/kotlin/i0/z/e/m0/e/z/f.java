package kotlin.i0.z.e.m0.e.z;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.q.b;
import kotlin.i0.z.e.m0.e.r;
import kotlin.i0.z.e.m0.e.s;
import kotlin.i0.z.e.m0.e.u;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f {
    public static final q a(q q, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(q, "<this>");
        n.f(g2, "typeTable");
        if (q.d0()) {
            obj1 = q.L();
        } else {
            if (q.e0()) {
                obj1 = g2.a(q.M());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }

    public static final q b(r r, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        Object obj2;
        n.f(r, "<this>");
        n.f(g2, "typeTable");
        if (r.X()) {
            n.e(r.N(), "expandedType");
            return obj1;
        } else {
            if (!r.Y()) {
            } else {
                obj1 = g2.a(r.O());
            }
        }
        obj1 = new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        throw obj1;
    }

    public static final q c(q q, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(q, "<this>");
        n.f(g2, "typeTable");
        if (q.i0()) {
            obj1 = q.V();
        } else {
            if (q.k0()) {
                obj1 = g2.a(q.W());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }

    public static final boolean d(i i) {
        int obj1;
        n.f(i, "<this>");
        if (!i.h0()) {
            if (i.i0()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static final boolean e(n n) {
        int obj1;
        n.f(n, "<this>");
        if (!n.e0()) {
            if (n.f0()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static final q f(q q, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(q, "<this>");
        n.f(g2, "typeTable");
        if (q.m0()) {
            obj1 = q.Y();
        } else {
            if (q.n0()) {
                obj1 = g2.a(q.Z());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }

    public static final q g(i i, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(i, "<this>");
        n.f(g2, "typeTable");
        if (i.h0()) {
            obj1 = i.R();
        } else {
            if (i.i0()) {
                obj1 = g2.a(i.S());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }

    public static final q h(n n, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(n, "<this>");
        n.f(g2, "typeTable");
        if (n.e0()) {
            obj1 = n.Q();
        } else {
            if (n.f0()) {
                obj1 = g2.a(n.R());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }

    public static final q i(i i, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        Object obj2;
        n.f(i, "<this>");
        n.f(g2, "typeTable");
        if (i.k0()) {
            n.e(i.T(), "returnType");
            return obj1;
        } else {
            if (!i.l0()) {
            } else {
                obj1 = g2.a(i.U());
            }
        }
        obj1 = new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        throw obj1;
    }

    public static final q j(n n, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        Object obj2;
        n.f(n, "<this>");
        n.f(g2, "typeTable");
        if (n.g0()) {
            n.e(n.S(), "returnType");
            return obj1;
        } else {
            if (!n.h0()) {
            } else {
                obj1 = g2.a(n.T());
            }
        }
        obj1 = new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        throw obj1;
    }

    public static final List<q> k(c c, kotlin.i0.z.e.m0.e.z.g g2) {
        int arrayList;
        int next;
        int i;
        String str;
        Object obj3;
        n.f(c, "<this>");
        n.f(g2, "typeTable");
        if (empty ^= 1 != 0) {
        } else {
            arrayList = 0;
        }
        if (arrayList == null) {
            obj3 = c.t0();
            n.e(obj3, "supertypeIdList");
            arrayList = new ArrayList(p.r(obj3, 10));
            obj3 = obj3.iterator();
            for (Integer next2 : obj3) {
                n.e(next2, "it");
                arrayList.add(g2.a(next2.intValue()));
            }
        }
        return arrayList;
    }

    public static final q l(q.b q$b, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(b, "<this>");
        n.f(g2, "typeTable");
        if (b.v()) {
            obj1 = b.s();
        } else {
            if (b.w()) {
                obj1 = g2.a(b.t());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }

    public static final q m(u u, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        Object obj2;
        n.f(u, "<this>");
        n.f(g2, "typeTable");
        if (u.M()) {
            n.e(u.G(), "type");
            return obj1;
        } else {
            if (!u.N()) {
            } else {
                obj1 = g2.a(u.H());
            }
        }
        obj1 = new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        throw obj1;
    }

    public static final q n(r r, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        Object obj2;
        n.f(r, "<this>");
        n.f(g2, "typeTable");
        if (r.b0()) {
            n.e(r.U(), "underlyingType");
            return obj1;
        } else {
            if (!r.c0()) {
            } else {
                obj1 = g2.a(r.V());
            }
        }
        obj1 = new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        throw obj1;
    }

    public static final List<q> o(s s, kotlin.i0.z.e.m0.e.z.g g2) {
        int arrayList;
        int next;
        int i;
        String str;
        Object obj3;
        n.f(s, "<this>");
        n.f(g2, "typeTable");
        if (empty ^= 1 != 0) {
        } else {
            arrayList = 0;
        }
        if (arrayList == null) {
            obj3 = s.L();
            n.e(obj3, "upperBoundIdList");
            arrayList = new ArrayList(p.r(obj3, 10));
            obj3 = obj3.iterator();
            for (Integer next2 : obj3) {
                n.e(next2, "it");
                arrayList.add(g2.a(next2.intValue()));
            }
        }
        return arrayList;
    }

    public static final q p(u u, kotlin.i0.z.e.m0.e.z.g g2) {
        boolean z;
        q obj1;
        n.f(u, "<this>");
        n.f(g2, "typeTable");
        if (u.O()) {
            obj1 = u.I();
        } else {
            if (u.P()) {
                obj1 = g2.a(u.J());
            } else {
                obj1 = 0;
            }
        }
        return obj1;
    }
}
