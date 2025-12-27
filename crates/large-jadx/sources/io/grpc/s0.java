package io.grpc;

import java.util.concurrent.TimeUnit;

/* compiled from: ManagedChannelBuilder.java */
/* loaded from: classes2.dex */
public abstract class s0<T extends s0<T>> {
    public static s0<?> b(String str) {
        return ManagedChannelProvider.d().a(str);
    }

    public T c(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T d() {
        throw new UnsupportedOperationException();
    }

    public abstract r0 a();
}
