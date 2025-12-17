package io.grpc;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class r0 extends io.grpc.e {
    @Override // io.grpc.e
    public abstract boolean i(long l, TimeUnit timeUnit2);

    @Override // io.grpc.e
    public void j() {
    }

    @Override // io.grpc.e
    public io.grpc.q k(boolean z) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Not implemented");
        throw obj2;
    }

    @Override // io.grpc.e
    public void l(io.grpc.q q, Runnable runnable2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Not implemented");
        throw obj1;
    }

    @Override // io.grpc.e
    public abstract io.grpc.r0 m();

    @Override // io.grpc.e
    public abstract io.grpc.r0 n();
}
