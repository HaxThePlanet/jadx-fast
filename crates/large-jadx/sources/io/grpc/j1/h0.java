package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.a;
import io.grpc.d1;
import io.grpc.o;
import io.grpc.u;
import io.grpc.w;
import java.io.InputStream;

/* loaded from: classes3.dex */
abstract class h0 implements io.grpc.j1.q {
    @Override // io.grpc.j1.q
    public boolean a() {
        return p().a();
    }

    @Override // io.grpc.j1.q
    public void b(boolean z) {
        p().b(z);
    }

    @Override // io.grpc.j1.q
    public void c(d1 d1) {
        p().c(d1);
    }

    @Override // io.grpc.j1.q
    public void d(o o) {
        p().d(o);
    }

    @Override // io.grpc.j1.q
    public void e(int i) {
        p().e(i);
    }

    @Override // io.grpc.j1.q
    public void f(int i) {
        p().f(i);
    }

    @Override // io.grpc.j1.q
    public void flush() {
        p().flush();
    }

    @Override // io.grpc.j1.q
    public void g(int i) {
        p().g(i);
    }

    @Override // io.grpc.j1.q
    public a getAttributes() {
        return p().getAttributes();
    }

    @Override // io.grpc.j1.q
    public void h(w w) {
        p().h(w);
    }

    @Override // io.grpc.j1.q
    public void i(String string) {
        p().i(string);
    }

    @Override // io.grpc.j1.q
    public void j(io.grpc.j1.x0 x0) {
        p().j(x0);
    }

    @Override // io.grpc.j1.q
    public void k() {
        p().k();
    }

    @Override // io.grpc.j1.q
    public void l(u u) {
        p().l(u);
    }

    @Override // io.grpc.j1.q
    public void m(io.grpc.j1.r r) {
        p().m(r);
    }

    @Override // io.grpc.j1.q
    public void n(InputStream inputStream) {
        p().n(inputStream);
    }

    @Override // io.grpc.j1.q
    public void o() {
        p().o();
    }

    @Override // io.grpc.j1.q
    protected abstract io.grpc.j1.q p();

    @Override // io.grpc.j1.q
    public void q(boolean z) {
        p().q(z);
    }

    @Override // io.grpc.j1.q
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", p());
        return bVar.toString();
    }
}
