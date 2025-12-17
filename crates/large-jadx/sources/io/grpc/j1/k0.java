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

/* loaded from: classes3.dex */
abstract class k0 implements io.grpc.j1.v {
    @Override // io.grpc.j1.v
    protected abstract io.grpc.j1.v a();

    public io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
        return a().b(u0, t02, d3, l4Arr4);
    }

    @Override // io.grpc.j1.v
    public void c(d1 d1) {
        a().c(d1);
    }

    @Override // io.grpc.j1.v
    public void d(d1 d1) {
        a().d(d1);
    }

    @Override // io.grpc.j1.v
    public Runnable e(io.grpc.j1.k1.a k1$a) {
        return a().e(a);
    }

    @Override // io.grpc.j1.v
    public i0 f() {
        return a().f();
    }

    @Override // io.grpc.j1.v
    public void g(io.grpc.j1.s.a s$a, Executor executor2) {
        a().g(a, executor2);
    }

    @Override // io.grpc.j1.v
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", a());
        return bVar.toString();
    }
}
