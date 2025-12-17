package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class z0 {
    public static final kotlin.i0.z.e.m0.l.i0 a(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.g1 g1Var;
        n.f(b0, "<this>");
        if (g1Var instanceof i0) {
        } else {
            g1Var = 0;
        }
        if (g1Var == null) {
        } else {
            return g1Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("This is should be simple type: ", b0).toString());
        throw illegalStateException;
    }

    public static final kotlin.i0.z.e.m0.l.b0 b(kotlin.i0.z.e.m0.l.b0 b0, List<? extends kotlin.i0.z.e.m0.l.v0> list2, g g3) {
        n.f(b0, "<this>");
        n.f(list2, "newArguments");
        n.f(g3, "newAnnotations");
        return z0.e(b0, list2, g3, 0, 4, 0);
    }

    public static final kotlin.i0.z.e.m0.l.b0 c(kotlin.i0.z.e.m0.l.b0 b0, List<? extends kotlin.i0.z.e.m0.l.v0> list2, g g3, List<? extends kotlin.i0.z.e.m0.l.v0> list4) {
        boolean annotations;
        boolean i0Var;
        kotlin.i0.z.e.m0.l.g1 obj1;
        Object obj2;
        boolean obj4;
        n.f(b0, "<this>");
        n.f(list2, "newArguments");
        n.f(g3, "newAnnotations");
        n.f(list4, "newArgumentsForUpperBound");
        if (!list2.isEmpty()) {
            if (list2 == b0.K0() && g3 == b0.getAnnotations()) {
                if (g3 == b0.getAnnotations()) {
                    return b0;
                }
            }
        } else {
        }
        obj1 = b0.O0();
        if (obj1 instanceof v) {
            kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
            obj1 = c0.d(z0.d((v)obj1.T0(), list2, g3), z0.d(obj1.U0(), list4, g3));
            return obj1;
        } else {
            if (!obj1 instanceof i0) {
            } else {
                obj1 = z0.d((i0)obj1, list2, g3);
            }
        }
        obj1 = new NoWhenBranchMatchedException();
        throw obj1;
    }

    public static final kotlin.i0.z.e.m0.l.i0 d(kotlin.i0.z.e.m0.l.i0 i0, List<? extends kotlin.i0.z.e.m0.l.v0> list2, g g3) {
        boolean annotations;
        n.f(i0, "<this>");
        n.f(list2, "newArguments");
        n.f(g3, "newAnnotations");
        if (list2.isEmpty() && g3 == i0.getAnnotations()) {
            if (g3 == i0.getAnnotations()) {
                return i0;
            }
        }
        if (list2.isEmpty()) {
            return i0.T0(g3);
        }
        kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
        return c0.i(g3, i0.L0(), list2, i0.M0(), 0, 16, 0);
    }

    public static kotlin.i0.z.e.m0.l.b0 e(kotlin.i0.z.e.m0.l.b0 b0, List list2, g g3, List list4, int i5, Object object6) {
        List obj1;
        g obj2;
        List obj3;
        if (i5 & 1 != 0) {
            obj1 = b0.K0();
        }
        if (i5 & 2 != 0) {
            obj2 = b0.getAnnotations();
        }
        if (i5 &= 4 != 0) {
            obj3 = obj1;
        }
        return z0.c(b0, obj1, obj2, obj3);
    }

    public static kotlin.i0.z.e.m0.l.i0 f(kotlin.i0.z.e.m0.l.i0 i0, List list2, g g3, int i4, Object object5) {
        List obj1;
        g obj2;
        if (i4 & 1 != 0) {
            obj1 = i0.K0();
        }
        if (i4 &= 2 != 0) {
            obj2 = i0.getAnnotations();
        }
        return z0.d(i0, obj1, obj2);
    }
}
