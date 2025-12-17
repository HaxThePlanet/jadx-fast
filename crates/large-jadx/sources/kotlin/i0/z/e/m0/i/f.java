package kotlin.i0.z.e.m0.i;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f {
    static {
        b bVar = new b("kotlin.jvm.JvmInline");
    }

    public static final boolean a(a a) {
        boolean str;
        Object obj1;
        n.f(a, "<this>");
        obj1 = (p0)a.y0();
        n.e(obj1, "correspondingProperty");
        if (a instanceof p0 && f.d(obj1)) {
            obj1 = (p0)a.y0();
            n.e(obj1, "correspondingProperty");
            obj1 = f.d(obj1) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static final boolean b(m m) {
        boolean z;
        Object obj1;
        n.f(m, "<this>");
        if (m instanceof e) {
            if (!(e)m.r()) {
                obj1 = m.I() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static final boolean c(b0 b0) {
        int obj1;
        n.f(b0, "<this>");
        obj1 = b0.L0().c();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = f.b(obj1);
        }
        return obj1;
    }

    public static final boolean d(d1 d1) {
        kotlin.i0.z.e.m0.f.e name;
        n.f(d1, "<this>");
        final int i = 0;
        if (d1.m0() != null) {
            return i;
        }
        m mVar = d1.b();
        n.e(mVar, "this.containingDeclaration");
        if (!f.b(mVar)) {
            return i;
        }
        c1 c1Var = f.f((e)mVar);
        if (c1Var == null) {
            name = 0;
        } else {
            name = c1Var.getName();
        }
        return n.b(name, d1.getName());
    }

    public static final b0 e(b0 b0) {
        n.f(b0, "<this>");
        c1 c1Var = f.g(b0);
        if (c1Var == null) {
            return null;
        }
        return a1.f(b0).p(c1Var.getType(), h1.INVARIANT);
    }

    public static final c1 f(e e) {
        int i;
        Object obj2;
        n.f(e, "<this>");
        if (!f.b(e)) {
            return null;
        }
        obj2 = e.Q();
        if (obj2 == null) {
        } else {
            obj2 = obj2.h();
            if (obj2 == null) {
            } else {
                i = obj2;
            }
        }
        return i;
    }

    public static final c1 g(b0 b0) {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.h obj2;
        n.f(b0, "<this>");
        if (!obj2 instanceof e) {
            obj2 = i;
        }
        if ((e)obj2 == null) {
        } else {
            i = f.f((e)obj2);
        }
        return i;
    }
}
