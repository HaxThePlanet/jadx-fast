package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory implements b<zendesk.core.SdkSettingsProviderInternal> {

    private final a<zendesk.core.ZendeskSettingsProvider> sdkSettingsProvider;
    public ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory(a<zendesk.core.ZendeskSettingsProvider> a) {
        super();
        this.sdkSettingsProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory create(a<zendesk.core.ZendeskSettingsProvider> a) {
        ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory zendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory = new ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory(a);
        return zendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory;
    }

    public static zendesk.core.SdkSettingsProviderInternal provideSdkSettingsProviderInternal(Object object) {
        final zendesk.core.SdkSettingsProviderInternal obj1 = ZendeskProvidersModule.provideSdkSettingsProviderInternal((ZendeskSettingsProvider)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SdkSettingsProviderInternal)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SdkSettingsProviderInternal get() {
        return ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory.provideSdkSettingsProviderInternal(this.sdkSettingsProvider.get());
    }
}
