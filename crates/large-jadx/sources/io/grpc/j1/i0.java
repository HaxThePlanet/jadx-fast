package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.d1;
import io.grpc.t0;

/* compiled from: ForwardingClientStreamListener.java */
/* loaded from: classes3.dex */
abstract class i0 implements r {
    i0() {
        super();
    }

    public void a(k2.a aVar) {
        e().a(aVar);
    }

    public void b(t0 t0Var) {
        e().b(t0Var);
    }

    public void c() {
        e().c();
    }

    public void d(d1 d1Var, r.a aVar, t0 t0Var) {
        e().d(d1Var, aVar, t0Var);
    }

    @Override // java.lang.Object
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", e());
        return bVar.toString();
    }

    protected abstract r e();
}
