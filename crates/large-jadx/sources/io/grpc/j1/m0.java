package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.d;
import io.grpc.e;
import io.grpc.h;
import io.grpc.q;
import io.grpc.r0;
import io.grpc.u0;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingManagedChannel.java */
/* loaded from: classes3.dex */
abstract class m0 extends r0 {

    private final r0 a;
    m0(r0 r0Var) {
        super();
        this.a = r0Var;
    }

    @Override // io.grpc.r0
    public String a() {
        return this.a.a();
    }

    @Override // io.grpc.r0
    public <RequestT, ResponseT> h<RequestT, ResponseT> h(u0<RequestT, ResponseT> u0Var, d dVar) {
        return this.a.h(u0Var, dVar);
    }

    @Override // io.grpc.r0
    public boolean i(long j, TimeUnit timeUnit) {
        return this.a.i(j, timeUnit);
    }

    @Override // io.grpc.r0
    public void j() {
        this.a.j();
    }

    @Override // io.grpc.r0
    public q k(boolean z) {
        return this.a.k(z);
    }

    @Override // io.grpc.r0
    public void l(q qVar, Runnable runnable) {
        this.a.l(qVar, runnable);
    }

    @Override // io.grpc.r0
    public r0 m() {
        return this.a.m();
    }

    @Override // io.grpc.r0
    public r0 n() {
        return this.a.n();
    }

    @Override // io.grpc.r0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", this.a);
        return bVar.toString();
    }
}
