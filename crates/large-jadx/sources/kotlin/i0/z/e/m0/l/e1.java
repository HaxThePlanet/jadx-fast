package kotlin.i0.z.e.m0.l;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class e1 {
    public static final kotlin.i0.z.e.m0.l.b0 a(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.b0 obj1;
        n.f(b0, "<this>");
        if (b0 instanceof d1) {
            obj1 = (d1)b0.F();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final kotlin.i0.z.e.m0.l.g1 b(kotlin.i0.z.e.m0.l.g1 g1, kotlin.i0.z.e.m0.l.b0 b02) {
        n.f(g1, "<this>");
        n.f(b02, "origin");
        return e1.d(g1, e1.a(b02));
    }

    public static final kotlin.i0.z.e.m0.l.b0 c(kotlin.i0.z.e.m0.l.b0 b0) {
        Object obj1;
        n.f(b0, "<this>");
        kotlin.i0.z.e.m0.l.b0 b0Var = e1.a(b0);
        if (b0Var == null) {
        } else {
            obj1 = b0Var;
        }
        return obj1;
    }

    public static final kotlin.i0.z.e.m0.l.g1 d(kotlin.i0.z.e.m0.l.g1 g1, kotlin.i0.z.e.m0.l.b0 b02) {
        kotlin.i0.z.e.m0.l.g1 k0Var;
        n.f(g1, "<this>");
        if (b02 == null) {
            return g1;
        }
        if (g1 instanceof i0) {
            k0Var = new k0((i0)g1, b02);
            return k0Var;
        } else {
            if (!g1 instanceof v) {
            } else {
                k0Var = new x((v)g1, b02);
            }
        }
        NoWhenBranchMatchedException obj1 = new NoWhenBranchMatchedException();
        throw obj1;
    }
}
