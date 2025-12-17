package io.grpc;

/* loaded from: classes2.dex */
public abstract class ManagedChannelProvider {

    public static final class ProviderNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        public ProviderNotFoundException(String string) {
            super(string);
        }
    }
    public static io.grpc.ManagedChannelProvider d() {
        io.grpc.ManagedChannelProvider managedChannelProvider = ManagedChannelRegistry.b().d();
        if (managedChannelProvider == null) {
        } else {
            return managedChannelProvider;
        }
        ManagedChannelProvider.ProviderNotFoundException providerNotFoundException = new ManagedChannelProvider.ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        throw providerNotFoundException;
    }

    protected abstract io.grpc.s0<?> a(String string);

    protected abstract boolean b();

    protected abstract int c();
}
