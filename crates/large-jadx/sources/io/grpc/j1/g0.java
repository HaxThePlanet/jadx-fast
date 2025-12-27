package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.i0;
import io.grpc.l;
import io.grpc.t0;
import io.grpc.u0;

/* compiled from: FailingClientTransport.java */
/* loaded from: classes3.dex */
class g0 implements s {

    final d1 a;
    private final r.a b;
    g0(d1 d1Var, r.a aVar) {
        super();
        n.e(!d1Var.p(), "error must not be OK");
        this.a = d1Var;
        this.b = aVar;
    }

    public q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr) {
        return new f0(this.a, this.b, lVarArr);
    }

    public i0 f() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
