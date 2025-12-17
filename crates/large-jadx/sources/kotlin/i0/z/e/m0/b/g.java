package kotlin.i0.z.e.m0.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.p.c;
import kotlin.i0.z.e.m0.b.p.c.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.v;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.j;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class g {
    public static final i0 a(kotlin.i0.z.e.m0.b.h h, g g2, b0 b03, List<? extends b0> list4, List<e> list5, b0 b06, boolean z7) {
        Object obj2;
        int obj4;
        n.f(h, "builtIns");
        n.f(g2, "annotations");
        n.f(list4, "parameterTypes");
        n.f(b06, "returnType");
        if (b03 == null) {
        } else {
            obj4++;
        }
        if (b03 != null) {
            obj2 = g.q(g2, h);
        }
        c0 obj1 = c0.a;
        return c0.g(obj2, g.d(h, obj4, z7), g.e(b03, list4, list5, b06, h));
    }

    public static i0 b(kotlin.i0.z.e.m0.b.h h, g g2, b0 b03, List list4, List list5, b0 b06, boolean z7, int i8, Object object9) {
        int obj13;
        if (i8 &= 64 != 0) {
            obj13 = 0;
        }
        return g.a(h, g2, b03, list4, list5, b06, obj13);
    }

    public static final e c(b0 b0) {
        boolean z;
        Object obj2;
        n.f(b0, "<this>");
        obj2 = b0.getAnnotations().o(k.a.y);
        int i = 0;
        if (obj2 == null) {
            return i;
        }
        if (obj2 instanceof v) {
        } else {
            obj2 = i;
        }
        if (obj2 == null) {
            obj2 = i;
        } else {
        }
        if (obj2 == null) {
            return i;
        }
        return e.j(obj2);
    }

    public static final e d(kotlin.i0.z.e.m0.b.h h, int i2, boolean z3) {
        e obj1;
        n.f(h, "builtIns");
        if (z3) {
            obj1 = h.W(i2);
        } else {
            obj1 = h.C(i2);
        }
        n.e(obj1, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return obj1;
    }

    public static final List<v0> e(b0 b0, List<? extends b0> list2, List<e> list3, b0 b04, kotlin.i0.z.e.m0.b.h h5) {
        int i3;
        int i;
        int i2;
        g annotations;
        e eVar;
        v vVar;
        String str;
        int obj9;
        Object obj10;
        n.f(list2, "parameterTypes");
        n.f(b04, "returnType");
        n.f(h5, "builtIns");
        i = 1;
        i2 = b0 != null ? i : i3;
        ArrayList arrayList = new ArrayList(i4 += i);
        int i6 = 0;
        if (b0 == null) {
            obj9 = i6;
        } else {
            obj9 = a.a(b0);
        }
        a.a(arrayList, obj9);
        obj9 = list2.iterator();
        for (Object obj10 : obj9) {
            if (list3 == null) {
            } else {
            }
            i3 = list3.get(i3);
            if ((e)i3 == 0) {
            } else {
            }
            if ((e)i3.k() != 0) {
            }
            i3 = i6;
            if (i3 != 0) {
            }
            arrayList.add(a.a(obj10));
            i3 = i;
            String str5 = i3.c();
            n.e(str5, "name.asString()");
            vVar = new v(str5);
            j jVar = new j(h5, k.a.y, j0.e(u.a(e.j("name"), vVar)));
            obj10 = a.l(obj10, g.q.a(p.s0((b0)obj10.getAnnotations(), jVar)));
        }
        arrayList.add(a.a(b04));
        return arrayList;
    }

    public static final c f(m m) {
        n.f(m, "<this>");
        final int i = 0;
        if (!m instanceof e) {
            return i;
        }
        if (!h.I0(m)) {
            return i;
        }
        return g.g(a.j(m));
    }

    private static final c g(c c) {
        boolean z;
        if (c.f() && c.e()) {
            if (c.e()) {
            }
            String str = c.i().c();
            n.e(str, "shortName().asString()");
            b obj3 = c.l().e();
            n.e(obj3, "toSafe().parent()");
            return c.Companion.b(str, obj3);
        }
        return null;
    }

    public static final b0 h(b0 b0) {
        b0 obj1;
        n.f(b0, "<this>");
        g.m(b0);
        if (g.p(b0)) {
            obj1 = (v0)p.X(b0.K0()).getType();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final b0 i(b0 b0) {
        n.f(b0, "<this>");
        g.m(b0);
        b0 obj1 = (v0)p.j0(b0.K0()).getType();
        n.e(obj1, "arguments.last().type");
        return obj1;
    }

    public static final List<v0> j(b0 b0) {
        n.f(b0, "<this>");
        g.m(b0);
        List list = b0.K0();
        return list.subList(g.k(b0), size--);
    }

    public static final boolean k(b0 b0) {
        Object obj1;
        n.f(b0, "<this>");
        if (g.m(b0) && g.p(b0)) {
            obj1 = g.p(b0) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static final boolean l(m m) {
        c suspendFunction;
        int obj1;
        n.f(m, "<this>");
        obj1 = g.f(m);
        if (obj1 != c.Function) {
            if (obj1 == c.SuspendFunction) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static final boolean m(b0 b0) {
        int obj1;
        n.f(b0, "<this>");
        obj1 = b0.L0().c();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = Boolean.valueOf(g.l(obj1));
        }
        return n.b(obj1, Boolean.TRUE);
    }

    public static final boolean n(b0 b0) {
        int obj1;
        n.f(b0, "<this>");
        obj1 = b0.L0().c();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = g.f(obj1);
        }
        obj1 = obj1 == c.Function ? 1 : 0;
        return obj1;
    }

    public static final boolean o(b0 b0) {
        int obj1;
        n.f(b0, "<this>");
        obj1 = b0.L0().c();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = g.f(obj1);
        }
        obj1 = obj1 == c.SuspendFunction ? 1 : 0;
        return obj1;
    }

    private static final boolean p(b0 b0) {
        int obj1;
        obj1 = b0.getAnnotations().o(k.a.x) != null ? 1 : 0;
        return obj1;
    }

    public static final g q(g g, kotlin.i0.z.e.m0.b.h h2) {
        boolean z;
        j jVar;
        Map map;
        Object obj4;
        n.f(g, "<this>");
        n.f(h2, "builtIns");
        b bVar = k.a.x;
        if (g.u1(bVar)) {
        } else {
            jVar = new j(h2, bVar, j0.h());
            obj4 = g.q.a(p.s0(g, jVar));
        }
        return obj4;
    }
}
