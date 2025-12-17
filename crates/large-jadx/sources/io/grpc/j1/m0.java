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

/* loaded from: classes3.dex */
abstract class m0 extends r0 {

    private final r0 a;
    m0(r0 r0) {
        super();
        this.a = r0;
    }

    @Override // io.grpc.r0
    public String a() {
        return this.a.a();
    }

    public <RequestT, ResponseT> h<RequestT, ResponseT> h(u0<RequestT, ResponseT> u0, d d2) {
        return this.a.h(u0, d2);
    }

    @Override // io.grpc.r0
    public boolean i(long l, TimeUnit timeUnit2) {
        return this.a.i(l, timeUnit2);
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
    public void l(q q, Runnable runnable2) {
        this.a.l(q, runnable2);
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
