package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class z<T extends io.grpc.z<T>>  extends io.grpc.s0<T> {
    @Override // io.grpc.s0
    public io.grpc.s0 c(long l, TimeUnit timeUnit2) {
        f(l, timeUnit2);
        return this;
    }

    @Override // io.grpc.s0
    public io.grpc.s0 d() {
        h();
        return this;
    }

    protected abstract io.grpc.s0<?> e();

    public T f(long l, TimeUnit timeUnit2) {
        e().c(l, timeUnit2);
        g();
        return this;
    }

    protected final T g() {
        return this;
    }

    public T h() {
        e().d();
        g();
        return this;
    }

    @Override // io.grpc.s0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", e());
        return bVar.toString();
    }
}
