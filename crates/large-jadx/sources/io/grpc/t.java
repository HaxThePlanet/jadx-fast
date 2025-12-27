package io.grpc;

import com.google.common.base.n;

/* compiled from: Contexts.java */
/* loaded from: classes2.dex */
public final class t {
    public static d1 a(s sVar) {
        n.p(sVar, "context must not be null");
        if (!sVar.m()) {
            return null;
        }
        Throwable th2 = sVar.e();
        if (th2 == null) {
            return d1.g.r("io.grpc.Context was cancelled without error");
        }
        if (th2 instanceof TimeoutException) {
            return d1.i.r(th2.getMessage()).q(th2);
        }
        io.grpc.d1 d1Var = d1.l(th2);
        if (d1.b.UNKNOWN.equals(d1Var.n()) && d1Var.m() == th2) {
            return d1.g.r("Context cancelled").q(th2);
        }
        return d1Var.q(th2);
    }
}
