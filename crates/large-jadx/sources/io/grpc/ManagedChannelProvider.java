package io.grpc;

/* compiled from: ManagedChannelProvider.java */
/* loaded from: classes2.dex */
public abstract class ManagedChannelProvider {

    public static final class ProviderNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        public ProviderNotFoundException(String str) {
            super(str);
        }
    }
    public static ManagedChannelProvider d() throws ManagedChannelProvider.ProviderNotFoundException {
        io.grpc.ManagedChannelProvider managedChannelProvider = ManagedChannelRegistry.b().d();
        if (managedChannelProvider == null) {
            throw new ManagedChannelProvider.ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        } else {
            return managedChannelProvider;
        }
    }

    protected abstract s0<?> a(String str);

    protected abstract boolean b();

    protected abstract int c();
}
