package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.e1;
import io.grpc.l;
import io.grpc.t0;

/* loaded from: classes3.dex */
public abstract class j0 extends l {
    @Override // io.grpc.l
    public void a(int i) {
        n().a(i);
    }

    @Override // io.grpc.l
    public void b(int i, long l2, long l3) {
        n().b(i, l2, obj3);
    }

    @Override // io.grpc.l
    public void c(long l) {
        n().c(l);
    }

    @Override // io.grpc.l
    public void d(long l) {
        n().d(l);
    }

    @Override // io.grpc.l
    public void e(int i) {
        n().e(i);
    }

    @Override // io.grpc.l
    public void f(int i, long l2, long l3) {
        n().f(i, l2, obj3);
    }

    @Override // io.grpc.l
    public void g(long l) {
        n().g(l);
    }

    @Override // io.grpc.l
    public void h(long l) {
        n().h(l);
    }

    @Override // io.grpc.l
    public void j() {
        n().j();
    }

    @Override // io.grpc.l
    public void k(t0 t0) {
        n().k(t0);
    }

    @Override // io.grpc.l
    public void l() {
        n().l();
    }

    @Override // io.grpc.l
    protected abstract l n();

    @Override // io.grpc.l
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", n());
        return bVar.toString();
    }
}
