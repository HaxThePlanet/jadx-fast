package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.e1;
import io.grpc.l;
import io.grpc.t0;

/* compiled from: ForwardingClientStreamTracer.java */
/* loaded from: classes3.dex */
public abstract class j0 extends l {
    @Override // io.grpc.l
    public void a(int i) {
        n().a(i);
    }

    @Override // io.grpc.l
    public void b(int i, long j, long j2) {
        n().b(i, j, j2);
    }

    @Override // io.grpc.l
    public void c(long j) {
        n().c(j);
    }

    @Override // io.grpc.l
    public void d(long j) {
        n().d(j);
    }

    @Override // io.grpc.l
    public void e(int i) {
        n().e(i);
    }

    @Override // io.grpc.l
    public void f(int i, long j, long j2) {
        n().f(i, j, j2);
    }

    @Override // io.grpc.l
    public void g(long j) {
        n().g(j);
    }

    @Override // io.grpc.l
    public void h(long j) {
        n().h(j);
    }

    @Override // io.grpc.l
    public void j() {
        n().j();
    }

    @Override // io.grpc.l
    public void k(t0 t0Var) {
        n().k(t0Var);
    }

    @Override // io.grpc.l
    public void l() {
        n().l();
    }

    @Override // io.grpc.l
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", n());
        return bVar.toString();
    }

    @Override // io.grpc.l
    protected abstract l n();
}
