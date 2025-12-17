package io.grpc;

import com.google.common.base.n;

/* loaded from: classes2.dex */
public final class t {
    public static io.grpc.d1 a(io.grpc.s s) {
        boolean equals;
        n.p(s, "context must not be null");
        if (!s.m()) {
            return null;
        }
        Throwable obj3 = s.e();
        if (obj3 == null) {
            return d1.g.r("io.grpc.Context was cancelled without error");
        }
        if (obj3 instanceof TimeoutException != null) {
            return d1.i.r(obj3.getMessage()).q(obj3);
        }
        io.grpc.d1 d1Var = d1.l(obj3);
        if (d1.b.UNKNOWN.equals(d1Var.n()) && d1Var.m() == obj3) {
            if (d1Var.m() == obj3) {
                return d1.g.r("Context cancelled").q(obj3);
            }
        }
        return d1Var.q(obj3);
    }
}
