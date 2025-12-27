package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.i0;
import io.grpc.l;
import io.grpc.m0;
import io.grpc.t0;
import io.grpc.u0;
import java.util.concurrent.Executor;

/* compiled from: ForwardingConnectionClientTransport.java */
/* loaded from: classes3.dex */
abstract class k0 implements v {
    k0() {
        super();
    }

    public q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr) {
        return a().b(u0Var, t0Var, dVar, lVarArr);
    }

    public void c(d1 d1Var) {
        a().c(d1Var);
    }

    public void d(d1 d1Var) {
        a().d(d1Var);
    }

    public Runnable e(k1.a aVar) {
        return a().e(aVar);
    }

    public i0 f() {
        return a().f();
    }

    public void g(s.a aVar, Executor executor) {
        a().g(aVar, executor);
    }

    @Override // java.lang.Object
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", a());
        return bVar.toString();
    }

    protected abstract v a();
}
