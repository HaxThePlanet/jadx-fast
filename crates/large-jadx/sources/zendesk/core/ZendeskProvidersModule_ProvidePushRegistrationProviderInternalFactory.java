package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory implements b<zendesk.core.PushRegistrationProviderInternal> {

    private final a<zendesk.core.PushRegistrationProvider> pushRegistrationProvider;
    public ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory(a<zendesk.core.PushRegistrationProvider> a) {
        super();
        this.pushRegistrationProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory create(a<zendesk.core.PushRegistrationProvider> a) {
        ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory zendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory = new ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory(a);
        return zendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory;
    }

    public static zendesk.core.PushRegistrationProviderInternal providePushRegistrationProviderInternal(zendesk.core.PushRegistrationProvider pushRegistrationProvider) {
        final zendesk.core.PushRegistrationProviderInternal obj1 = ZendeskProvidersModule.providePushRegistrationProviderInternal(pushRegistrationProvider);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (PushRegistrationProviderInternal)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.PushRegistrationProviderInternal get() {
        return ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory.providePushRegistrationProviderInternal((PushRegistrationProvider)this.pushRegistrationProvider.get());
    }
}
