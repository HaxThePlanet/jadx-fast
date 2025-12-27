package io.grpc.k1;

import io.grpc.ManagedChannelProvider;
import io.grpc.k0;
import io.grpc.s0;

/* compiled from: OkHttpChannelProvider.java */
/* loaded from: classes3.dex */
public final class f extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public int c() {
        int i = 8;
        int r0 = k0.a(f.class.getClassLoader()) ? 8 : 3;
        return (k0.a(f.class.getClassLoader()) ? 8 : 3);
    }

    @Override // io.grpc.ManagedChannelProvider
    public e e(String str) {
        return e.forTarget(str);
    }

    @Override // io.grpc.ManagedChannelProvider
    public boolean b() {
        return true;
    }
}
