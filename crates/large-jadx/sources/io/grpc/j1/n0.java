package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import io.grpc.v0;
import io.grpc.v0.e;
import io.grpc.v0.f;

/* loaded from: classes3.dex */
abstract class n0 extends v0 {

    private final v0 a;
    n0(v0 v0) {
        super();
        n.p(v0, "delegate can not be null");
        this.a = v0;
    }

    @Override // io.grpc.v0
    public void b() {
        this.a.b();
    }

    @Override // io.grpc.v0
    public void c() {
        this.a.c();
    }

    @Override // io.grpc.v0
    public void d(v0.e v0$e) {
        this.a.d(e);
    }

    @Deprecated
    public void e(v0.f v0$f) {
        this.a.e(f);
    }

    @Override // io.grpc.v0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", this.a);
        return bVar.toString();
    }
}
