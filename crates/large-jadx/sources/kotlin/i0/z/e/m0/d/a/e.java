package kotlin.i0.z.e.m0.d.a;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.b.t;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e extends kotlin.i0.z.e.m0.d.a.c0 {

    public static final kotlin.i0.z.e.m0.d.a.e m;

    static final class a extends p implements l<b, Boolean> {

        final t0 $functionDescriptor;
        a(t0 t0) {
            this.$functionDescriptor = t0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            n.f(b, "it");
            Map obj3 = c0.a.i();
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            return obj3.containsKey(t.d(this.$functionDescriptor));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }
    static {
        e eVar = new e();
        e.m = eVar;
    }

    public final List<e> i(e e) {
        Object obj2;
        n.f(e, "name");
        if ((List)c0.a.e().get(e) == null) {
            obj2 = p.g();
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.d.a.c0
    public final e j(t0 t0) {
        n.f(t0, "functionDescriptor");
        String obj2 = t.d(t0);
        if (obj2 == null) {
            return null;
        }
        return (e)c0.a.i().get(obj2);
    }

    @Override // kotlin.i0.z.e.m0.d.a.c0
    public final boolean k(e e) {
        n.f(e, "<this>");
        return c0.a.f().contains(e);
    }

    @Override // kotlin.i0.z.e.m0.d.a.c0
    public final boolean l(t0 t0) {
        boolean aVar;
        int i;
        int i2;
        Object obj5;
        n.f(t0, "functionDescriptor");
        final int i3 = 0;
        aVar = new e.a(t0);
        if (h.e0(t0) && a.d(t0, i3, aVar, 1, 0) != null) {
            aVar = new e.a(t0);
            if (a.d(t0, i3, aVar, i, 0) != null) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.d.a.c0
    public final boolean m(t0 t0) {
        boolean z;
        Object obj3;
        n.f(t0, "<this>");
        if (n.b(t0.getName().c(), "removeAt") && n.b(t.d(t0), c0.a.g().b())) {
            obj3 = n.b(t.d(t0), c0.a.g().b()) ? 1 : 0;
        } else {
        }
        return obj3;
    }
}
