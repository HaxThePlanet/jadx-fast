package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.d1;
import io.grpc.t0;

/* loaded from: classes3.dex */
abstract class i0 implements io.grpc.j1.r {
    @Override // io.grpc.j1.r
    public void a(io.grpc.j1.k2.a k2$a) {
        e().a(a);
    }

    @Override // io.grpc.j1.r
    public void b(t0 t0) {
        e().b(t0);
    }

    @Override // io.grpc.j1.r
    public void c() {
        e().c();
    }

    @Override // io.grpc.j1.r
    public void d(d1 d1, io.grpc.j1.r.a r$a2, t0 t03) {
        e().d(d1, a2, t03);
    }

    @Override // io.grpc.j1.r
    protected abstract io.grpc.j1.r e();

    @Override // io.grpc.j1.r
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", e());
        return bVar.toString();
    }
}
