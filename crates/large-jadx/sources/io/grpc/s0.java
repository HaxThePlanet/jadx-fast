package io.grpc;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class s0<T extends io.grpc.s0<T>>  {
    public static io.grpc.s0<?> b(String string) {
        return ManagedChannelProvider.d().a(string);
    }

    public abstract io.grpc.r0 a();

    public T c(long l, TimeUnit timeUnit2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public T d() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
