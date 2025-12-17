package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvidePushInterceptorFactory implements b<zendesk.core.ZendeskPushInterceptor> {

    private final a<zendesk.core.IdentityStorage> identityStorageProvider;
    private final a<zendesk.core.PushDeviceIdStorage> pushDeviceIdStorageProvider;
    private final a<zendesk.core.PushRegistrationProviderInternal> pushProvider;
    public ZendeskNetworkModule_ProvidePushInterceptorFactory(a<zendesk.core.PushRegistrationProviderInternal> a, a<zendesk.core.PushDeviceIdStorage> a2, a<zendesk.core.IdentityStorage> a3) {
        super();
        this.pushProvider = a;
        this.pushDeviceIdStorageProvider = a2;
        this.identityStorageProvider = a3;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvidePushInterceptorFactory create(a<zendesk.core.PushRegistrationProviderInternal> a, a<zendesk.core.PushDeviceIdStorage> a2, a<zendesk.core.IdentityStorage> a3) {
        ZendeskNetworkModule_ProvidePushInterceptorFactory zendeskNetworkModule_ProvidePushInterceptorFactory = new ZendeskNetworkModule_ProvidePushInterceptorFactory(a, a2, a3);
        return zendeskNetworkModule_ProvidePushInterceptorFactory;
    }

    public static zendesk.core.ZendeskPushInterceptor providePushInterceptor(Object object, Object object2, Object object3) {
        final zendesk.core.ZendeskPushInterceptor obj0 = ZendeskNetworkModule.providePushInterceptor((PushRegistrationProviderInternal)object, (PushDeviceIdStorage)object2, (IdentityStorage)object3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskPushInterceptor)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskPushInterceptor get() {
        return ZendeskNetworkModule_ProvidePushInterceptorFactory.providePushInterceptor(this.pushProvider.get(), this.pushDeviceIdStorageProvider.get(), this.identityStorageProvider.get());
    }
}
