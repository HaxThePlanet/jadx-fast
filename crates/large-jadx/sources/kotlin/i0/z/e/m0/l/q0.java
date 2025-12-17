package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class q0 {

    public static final kotlin.i0.z.e.m0.l.q0.a e;
    private final kotlin.i0.z.e.m0.l.q0 a;
    private final y0 b;
    private final List<kotlin.i0.z.e.m0.l.v0> c;
    private final Map<z0, kotlin.i0.z.e.m0.l.v0> d;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.l.q0 a(kotlin.i0.z.e.m0.l.q0 q0, y0 y02, List<? extends kotlin.i0.z.e.m0.l.v0> list3) {
            int i;
            n.f(y02, "typeAliasDescriptor");
            n.f(list3, "arguments");
            List parameters = y02.g().getParameters();
            n.e(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(p.r(parameters, 10));
            Iterator iterator = parameters.iterator();
            for (z0 next2 : iterator) {
                arrayList.add(next2.a());
            }
            super(q0, y02, list3, j0.s(p.S0(arrayList, list3)), 0);
            return q0Var;
        }
    }
    static {
        q0.a aVar = new q0.a(0);
        q0.e = aVar;
    }

    private q0(kotlin.i0.z.e.m0.l.q0 q0, y0 y02, List<? extends kotlin.i0.z.e.m0.l.v0> list3, Map<z0, ? extends kotlin.i0.z.e.m0.l.v0> map4) {
        super();
        this.a = q0;
        this.b = y02;
        this.c = list3;
        this.d = map4;
    }

    public q0(kotlin.i0.z.e.m0.l.q0 q0, y0 y02, List list3, Map map4, g g5) {
        super(q0, y02, list3, map4);
    }

    public final List<kotlin.i0.z.e.m0.l.v0> a() {
        return this.c;
    }

    public final y0 b() {
        return this.b;
    }

    public final kotlin.i0.z.e.m0.l.v0 c(kotlin.i0.z.e.m0.l.t0 t0) {
        Map map;
        Object obj2;
        n.f(t0, "constructor");
        obj2 = t0.c();
        if (obj2 instanceof z0) {
            obj2 = this.d.get(obj2);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public final boolean d(y0 y0) {
        boolean z;
        int i;
        boolean obj3;
        n.f(y0, "descriptor");
        if (!n.b(this.b, y0)) {
            z = this.a;
            if (z == null) {
                obj3 = i;
            } else {
                obj3 = z.d(y0);
            }
            if (obj3 != null) {
                i = 1;
            }
        } else {
        }
        return i;
    }
}
