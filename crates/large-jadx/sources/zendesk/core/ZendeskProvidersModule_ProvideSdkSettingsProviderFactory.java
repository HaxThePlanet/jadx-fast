package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideSdkSettingsProviderFactory implements b<zendesk.core.SettingsProvider> {

    private final a<zendesk.core.ZendeskSettingsProvider> sdkSettingsProvider;
    public ZendeskProvidersModule_ProvideSdkSettingsProviderFactory(a<zendesk.core.ZendeskSettingsProvider> a) {
        super();
        this.sdkSettingsProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideSdkSettingsProviderFactory create(a<zendesk.core.ZendeskSettingsProvider> a) {
        ZendeskProvidersModule_ProvideSdkSettingsProviderFactory zendeskProvidersModule_ProvideSdkSettingsProviderFactory = new ZendeskProvidersModule_ProvideSdkSettingsProviderFactory(a);
        return zendeskProvidersModule_ProvideSdkSettingsProviderFactory;
    }

    public static zendesk.core.SettingsProvider provideSdkSettingsProvider(Object object) {
        final zendesk.core.SettingsProvider obj1 = ZendeskProvidersModule.provideSdkSettingsProvider((ZendeskSettingsProvider)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SettingsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SettingsProvider get() {
        return ZendeskProvidersModule_ProvideSdkSettingsProviderFactory.provideSdkSettingsProvider(this.sdkSettingsProvider.get());
    }
}
