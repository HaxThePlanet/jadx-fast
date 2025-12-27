package io.grpc;

import java.util.concurrent.TimeUnit;

/* compiled from: ManagedChannel.java */
/* loaded from: classes2.dex */
public abstract class r0 extends e {
    @Override // io.grpc.e
    public q k(boolean z) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // io.grpc.e
    public void l(q qVar, Runnable runnable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // io.grpc.e
    public abstract boolean i(long j, TimeUnit timeUnit);

    @Override // io.grpc.e
    public void j() {
    }

    @Override // io.grpc.e
    public abstract r0 m();

    @Override // io.grpc.e
    public abstract r0 n();
}
