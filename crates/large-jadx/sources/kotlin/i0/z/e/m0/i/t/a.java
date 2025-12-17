package kotlin.i0.z.e.m0.i.t;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* loaded from: classes3.dex */
public final class a {
    private static final boolean a(e e) {
        return n.b(a.i(e), k.h);
    }

    public static final boolean b(m m) {
        Object obj1;
        n.f(m, "<this>");
        if (f.b(m) && !a.a((e)m)) {
            obj1 = !a.a((e)m) ? 1 : 0;
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
            obj1 = Boolean.valueOf(a.b(obj1));
        }
        return n.b(obj1, Boolean.TRUE);
    }

    private static final boolean d(b0 b0) {
        kotlin.reflect.jvm.internal.impl.descriptors.h obj1;
        if (obj1 instanceof z0) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            return 0;
        }
        return a.e(a.f(obj1));
    }

    private static final boolean e(b0 b0) {
        int obj1;
        if (!a.c(b0)) {
            if (a.d(b0)) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static final boolean f(b b) {
        int i;
        boolean empty;
        String str;
        Object obj3;
        n.f(b, "descriptor");
        if (b instanceof d) {
        } else {
            obj3 = 0;
        }
        i = 0;
        if (obj3 == null) {
            return i;
        }
        if (t.g(obj3.getVisibility())) {
            return i;
        }
        e eVar = obj3.z();
        n.e(eVar, "constructorDescriptor.constructedClass");
        if (f.b(eVar)) {
            return i;
        }
        if (d.G(obj3.z())) {
            return i;
        }
        obj3 = obj3.h();
        n.e(obj3, "constructorDescriptor.valueParameters");
        if (obj3 instanceof Collection != null && obj3.isEmpty()) {
            if (obj3.isEmpty()) {
            } else {
                obj3 = obj3.iterator();
                while (obj3.hasNext()) {
                    b0 type = (c1)obj3.next().getType();
                    n.e(type, "it.type");
                    if (a.e(type)) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }
}
