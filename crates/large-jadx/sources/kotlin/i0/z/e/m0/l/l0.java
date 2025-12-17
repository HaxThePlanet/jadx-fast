package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.j1.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class l0 {
    public static final kotlin.i0.z.e.m0.l.a a(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.g1 obj1;
        n.f(b0, "<this>");
        if (obj1 instanceof a) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final kotlin.i0.z.e.m0.l.i0 b(kotlin.i0.z.e.m0.l.b0 b0) {
        int obj1;
        n.f(b0, "<this>");
        obj1 = l0.a(b0);
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.X0();
        }
        return obj1;
    }

    public static final boolean c(kotlin.i0.z.e.m0.l.b0 b0) {
        n.f(b0, "<this>");
        return obj1 instanceof k;
    }

    private static final kotlin.i0.z.e.m0.l.a0 d(kotlin.i0.z.e.m0.l.a0 a0) {
        boolean iterator;
        int i;
        Object next;
        int i2;
        int i3;
        boolean z;
        kotlin.i0.z.e.m0.l.b0 obj8;
        Collection collection = a0.a();
        ArrayList arrayList = new ArrayList(p.r(collection, 10));
        iterator = collection.iterator();
        int i6 = 0;
        i = i6;
        i2 = 1;
        i3 = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (c1.l((b0)next)) {
            }
            arrayList.add(next);
            i2 = 1;
            i3 = 0;
            next = l0.f(next.O0(), i6, i2, i3);
            i = i2;
        }
        if (i == 0) {
        } else {
            obj8 = a0.h();
            if (obj8 == null) {
            } else {
                if (c1.l(obj8)) {
                    obj8 = l0.f(obj8.O0(), i6, i2, i3);
                }
                i3 = obj8;
            }
            obj8 = new a0(arrayList);
            i3 = obj8.k(i3);
        }
        return i3;
    }

    public static final kotlin.i0.z.e.m0.l.g1 e(kotlin.i0.z.e.m0.l.g1 g1, boolean z2) {
        kotlin.i0.z.e.m0.l.g1 obj2;
        n.f(g1, "<this>");
        if (k.v.b(g1, z2) == null && l0.g(g1) == null) {
            if (l0.g(g1) == null) {
                obj2 = g1.P0(false);
            }
        }
        return obj2;
    }

    public static kotlin.i0.z.e.m0.l.g1 f(kotlin.i0.z.e.m0.l.g1 g1, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return l0.e(g1, obj1);
    }

    private static final kotlin.i0.z.e.m0.l.i0 g(kotlin.i0.z.e.m0.l.b0 b0) {
        int obj2;
        final int i = 0;
        if (obj2 instanceof a0) {
        } else {
            obj2 = i;
        }
        if (obj2 == null) {
            return i;
        }
        obj2 = l0.d(obj2);
        if (obj2 == null) {
            return i;
        }
        return obj2.g();
    }

    public static final kotlin.i0.z.e.m0.l.i0 h(kotlin.i0.z.e.m0.l.i0 i0, boolean z2) {
        kotlin.i0.z.e.m0.l.i0 obj2;
        n.f(i0, "<this>");
        if (k.v.b(i0, z2) == null && l0.g(i0) == null) {
            if (l0.g(i0) == null) {
                obj2 = i0.S0(false);
            }
        }
        return obj2;
    }

    public static kotlin.i0.z.e.m0.l.i0 i(kotlin.i0.z.e.m0.l.i0 i0, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return l0.h(i0, obj1);
    }

    public static final kotlin.i0.z.e.m0.l.i0 j(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.i0 i02) {
        n.f(i0, "<this>");
        n.f(i02, "abbreviatedType");
        if (d0.a(i0)) {
            return i0;
        }
        a aVar = new a(i0, i02);
        return aVar;
    }

    public static final i k(i i) {
        n.f(i, "<this>");
        super(i.U0(), i.V0(), i.W0(), i.getAnnotations(), i.M0(), 1);
        return iVar;
    }
}
