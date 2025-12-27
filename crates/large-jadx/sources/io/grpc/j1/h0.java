package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.a;
import io.grpc.d1;
import io.grpc.o;
import io.grpc.u;
import io.grpc.w;
import java.io.InputStream;

/* compiled from: ForwardingClientStream.java */
/* loaded from: classes3.dex */
abstract class h0 implements q {
    h0() {
        super();
    }

    public boolean a() {
        return p().a();
    }

    public void b(boolean z) {
        p().b(z);
    }

    public void c(d1 d1Var) {
        p().c(d1Var);
    }

    public void d(o oVar) {
        p().d(oVar);
    }

    public void e(int i) {
        p().e(i);
    }

    public void f(int i) {
        p().f(i);
    }

    public void flush() {
        p().flush();
    }

    public void g(int i) {
        p().g(i);
    }

    public a getAttributes() {
        return p().getAttributes();
    }

    public void h(w wVar) {
        p().h(wVar);
    }

    public void i(String str) {
        p().i(str);
    }

    public void j(x0 x0Var) {
        p().j(x0Var);
    }

    public void k() {
        p().k();
    }

    public void l(u uVar) {
        p().l(uVar);
    }

    public void m(r rVar) {
        p().m(rVar);
    }

    public void n(InputStream inputStream) {
        p().n(inputStream);
    }

    public void o() {
        p().o();
    }

    public void q(boolean z) {
        p().q(z);
    }

    @Override // java.lang.Object
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", p());
        return bVar.toString();
    }

    protected abstract q p();
}
