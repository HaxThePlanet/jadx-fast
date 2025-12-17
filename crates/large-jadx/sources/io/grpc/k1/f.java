package io.grpc.k1;

import io.grpc.ManagedChannelProvider;
import io.grpc.k0;
import io.grpc.s0;

/* loaded from: classes3.dex */
public final class f extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public s0 a(String string) {
        return e(string);
    }

    @Override // io.grpc.ManagedChannelProvider
    public boolean b() {
        return 1;
    }

    @Override // io.grpc.ManagedChannelProvider
    public int c() {
        int i;
        i = k0.a(f.class.getClassLoader()) ? 8 : 3;
        return i;
    }

    @Override // io.grpc.ManagedChannelProvider
    public io.grpc.k1.e e(String string) {
        return e.forTarget(string);
    }
}
