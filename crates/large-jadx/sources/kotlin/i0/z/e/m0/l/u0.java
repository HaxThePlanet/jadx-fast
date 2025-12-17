package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class u0 extends kotlin.i0.z.e.m0.l.y0 {

    public static final kotlin.i0.z.e.m0.l.u0.a b;

    public static final class a {
        public a(g g) {
            super();
        }

        public static kotlin.i0.z.e.m0.l.u0 e(kotlin.i0.z.e.m0.l.u0.a u0$a, Map map2, boolean z3, int i4, Object object5) {
            int obj2;
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            return a.d(map2, obj2);
        }

        public final kotlin.i0.z.e.m0.l.y0 a(kotlin.i0.z.e.m0.l.b0 b0) {
            n.f(b0, "kotlinType");
            return b(b0.L0(), b0.K0());
        }

        public final kotlin.i0.z.e.m0.l.y0 b(kotlin.i0.z.e.m0.l.t0 t0, List<? extends kotlin.i0.z.e.m0.l.v0> list2) {
            int i;
            Boolean valueOf;
            n.f(t0, "typeConstructor");
            n.f(list2, "arguments");
            List parameters = t0.getParameters();
            String str3 = "typeConstructor.parameters";
            n.e(parameters, str3);
            Object obj = p.l0(parameters);
            final int i4 = 0;
            if ((z0)obj == null) {
                valueOf = i4;
            } else {
                valueOf = Boolean.valueOf((z0)obj.o0());
            }
            if (n.b(valueOf, Boolean.TRUE)) {
                List obj6 = t0.getParameters();
                n.e(obj6, str3);
                ArrayList arrayList = new ArrayList(p.r(obj6, 10));
                obj6 = obj6.iterator();
                for (z0 next2 : obj6) {
                    arrayList.add(next2.g());
                }
                return u0.a.e(this, j0.s(p.S0(arrayList, list2)), false, 2, i4);
            }
            obj6 = new z(parameters, list2);
            return obj6;
        }

        public final kotlin.i0.z.e.m0.l.u0 c(Map<kotlin.i0.z.e.m0.l.t0, ? extends kotlin.i0.z.e.m0.l.v0> map) {
            n.f(map, "map");
            return u0.a.e(this, map, false, 2, 0);
        }

        public final kotlin.i0.z.e.m0.l.u0 d(Map<kotlin.i0.z.e.m0.l.t0, ? extends kotlin.i0.z.e.m0.l.v0> map, boolean z2) {
            n.f(map, "map");
            u0.a.a aVar = new u0.a.a(map, z2);
            return aVar;
        }
    }
    static {
        u0.a aVar = new u0.a(0);
        u0.b = aVar;
    }

    public static final kotlin.i0.z.e.m0.l.y0 h(kotlin.i0.z.e.m0.l.t0 t0, List<? extends kotlin.i0.z.e.m0.l.v0> list2) {
        return u0.b.b(t0, list2);
    }

    public static final kotlin.i0.z.e.m0.l.u0 i(Map<kotlin.i0.z.e.m0.l.t0, ? extends kotlin.i0.z.e.m0.l.v0> map) {
        return u0.b.c(map);
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public kotlin.i0.z.e.m0.l.v0 e(kotlin.i0.z.e.m0.l.b0 b0) {
        n.f(b0, "key");
        return j(b0.L0());
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public abstract kotlin.i0.z.e.m0.l.v0 j(kotlin.i0.z.e.m0.l.t0 t0);
}
