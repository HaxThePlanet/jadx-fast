package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory implements b<zendesk.core.ZendeskSettingsProvider> {

    private final a<zendesk.core.ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<zendesk.core.ApplicationConfiguration> configurationProvider;
    private final a<Context> contextProvider;
    private final a<zendesk.core.CoreSettingsStorage> coreSettingsStorageProvider;
    private final a<zendesk.core.SdkSettingsService> sdkSettingsServiceProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    private final a<zendesk.core.SettingsStorage> settingsStorageProvider;
    private final a<zendesk.core.ZendeskLocaleConverter> zendeskLocaleConverterProvider;
    public ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory(a<zendesk.core.SdkSettingsService> a, a<zendesk.core.SettingsStorage> a2, a<zendesk.core.CoreSettingsStorage> a3, a<zendesk.core.ActionHandlerRegistry> a4, a<zendesk.core.Serializer> a5, a<zendesk.core.ZendeskLocaleConverter> a6, a<zendesk.core.ApplicationConfiguration> a7, a<Context> a8) {
        super();
        this.sdkSettingsServiceProvider = a;
        this.settingsStorageProvider = a2;
        this.coreSettingsStorageProvider = a3;
        this.actionHandlerRegistryProvider = a4;
        this.serializerProvider = a5;
        this.zendeskLocaleConverterProvider = a6;
        this.configurationProvider = a7;
        this.contextProvider = a8;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory create(a<zendesk.core.SdkSettingsService> a, a<zendesk.core.SettingsStorage> a2, a<zendesk.core.CoreSettingsStorage> a3, a<zendesk.core.ActionHandlerRegistry> a4, a<zendesk.core.Serializer> a5, a<zendesk.core.ZendeskLocaleConverter> a6, a<zendesk.core.ApplicationConfiguration> a7, a<Context> a8) {
        super(a, a2, a3, a4, a5, a6, a7, a8);
        return zendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory;
    }

    public static zendesk.core.ZendeskSettingsProvider provideZendeskSdkSettingsProvider(Object object, Object object2, Object object3, zendesk.core.ActionHandlerRegistry actionHandlerRegistry4, Object object5, zendesk.core.ZendeskLocaleConverter zendeskLocaleConverter6, zendesk.core.ApplicationConfiguration applicationConfiguration7, Context context8) {
        final zendesk.core.ZendeskSettingsProvider obj8 = ZendeskProvidersModule.provideZendeskSdkSettingsProvider((SdkSettingsService)object, (SettingsStorage)object2, (CoreSettingsStorage)object3, actionHandlerRegistry4, (Serializer)object5, zendeskLocaleConverter6, applicationConfiguration7, context8);
        d.c(obj8, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskSettingsProvider)obj8;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskSettingsProvider get() {
        return ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory.provideZendeskSdkSettingsProvider(this.sdkSettingsServiceProvider.get(), this.settingsStorageProvider.get(), this.coreSettingsStorageProvider.get(), (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get(), this.serializerProvider.get(), (ZendeskLocaleConverter)this.zendeskLocaleConverterProvider.get(), (ApplicationConfiguration)this.configurationProvider.get(), (Context)this.contextProvider.get());
    }
}
