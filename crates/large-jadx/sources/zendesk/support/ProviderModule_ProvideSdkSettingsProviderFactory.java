package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.Locale;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideSdkSettingsProviderFactory implements b<zendesk.support.SupportSettingsProvider> {

    private final a<ZendeskLocaleConverter> helpCenterLocaleConverterProvider;
    private final a<Locale> localeProvider;
    private final zendesk.support.ProviderModule module;
    private final a<SettingsProvider> sdkSettingsProvider;
    public ProviderModule_ProvideSdkSettingsProviderFactory(zendesk.support.ProviderModule providerModule, a<SettingsProvider> a2, a<Locale> a3, a<ZendeskLocaleConverter> a4) {
        super();
        this.module = providerModule;
        this.sdkSettingsProvider = a2;
        this.localeProvider = a3;
        this.helpCenterLocaleConverterProvider = a4;
    }

    public static zendesk.support.ProviderModule_ProvideSdkSettingsProviderFactory create(zendesk.support.ProviderModule providerModule, a<SettingsProvider> a2, a<Locale> a3, a<ZendeskLocaleConverter> a4) {
        ProviderModule_ProvideSdkSettingsProviderFactory providerModule_ProvideSdkSettingsProviderFactory = new ProviderModule_ProvideSdkSettingsProviderFactory(providerModule, a2, a3, a4);
        return providerModule_ProvideSdkSettingsProviderFactory;
    }

    public static zendesk.support.SupportSettingsProvider provideSdkSettingsProvider(zendesk.support.ProviderModule providerModule, SettingsProvider settingsProvider2, Locale locale3, ZendeskLocaleConverter zendeskLocaleConverter4) {
        final zendesk.support.SupportSettingsProvider obj0 = providerModule.provideSdkSettingsProvider(settingsProvider2, locale3, zendeskLocaleConverter4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportSettingsProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportSettingsProvider get() {
        return ProviderModule_ProvideSdkSettingsProviderFactory.provideSdkSettingsProvider(this.module, (SettingsProvider)this.sdkSettingsProvider.get(), (Locale)this.localeProvider.get(), (ZendeskLocaleConverter)this.helpCenterLocaleConverterProvider.get());
    }
}
