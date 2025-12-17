package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideSettingsInterceptorFactory implements b<zendesk.core.ZendeskSettingsInterceptor> {

    private final a<zendesk.core.SdkSettingsProviderInternal> sdkSettingsProvider;
    private final a<zendesk.core.SettingsStorage> settingsStorageProvider;
    public ZendeskNetworkModule_ProvideSettingsInterceptorFactory(a<zendesk.core.SdkSettingsProviderInternal> a, a<zendesk.core.SettingsStorage> a2) {
        super();
        this.sdkSettingsProvider = a;
        this.settingsStorageProvider = a2;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideSettingsInterceptorFactory create(a<zendesk.core.SdkSettingsProviderInternal> a, a<zendesk.core.SettingsStorage> a2) {
        ZendeskNetworkModule_ProvideSettingsInterceptorFactory zendeskNetworkModule_ProvideSettingsInterceptorFactory = new ZendeskNetworkModule_ProvideSettingsInterceptorFactory(a, a2);
        return zendeskNetworkModule_ProvideSettingsInterceptorFactory;
    }

    public static zendesk.core.ZendeskSettingsInterceptor provideSettingsInterceptor(Object object, Object object2) {
        final zendesk.core.ZendeskSettingsInterceptor obj0 = ZendeskNetworkModule.provideSettingsInterceptor((SdkSettingsProviderInternal)object, (SettingsStorage)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskSettingsInterceptor)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskSettingsInterceptor get() {
        return ZendeskNetworkModule_ProvideSettingsInterceptorFactory.provideSettingsInterceptor(this.sdkSettingsProvider.get(), this.settingsStorageProvider.get());
    }
}
