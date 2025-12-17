package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideCoreSdkModuleFactory implements b<zendesk.core.CoreModule> {

    private final a<zendesk.core.ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<zendesk.core.AuthenticationProvider> authenticationProvider;
    private final a<zendesk.core.BlipsProvider> blipsProvider;
    private final a<Context> contextProvider;
    private final a<ScheduledExecutorService> executorProvider;
    private final a<zendesk.core.MemoryCache> memoryCacheProvider;
    private final a<zendesk.core.NetworkInfoProvider> networkInfoProvider;
    private final a<zendesk.core.PushRegistrationProvider> pushRegistrationProvider;
    private final a<zendesk.core.RestServiceProvider> restServiceProvider;
    private final a<zendesk.core.SessionStorage> sessionStorageProvider;
    private final a<zendesk.core.SettingsProvider> settingsProvider;
    private final a<zendesk.core.ApplicationConfiguration> zendeskConfigurationProvider;
    public ZendeskProvidersModule_ProvideCoreSdkModuleFactory(a<zendesk.core.SettingsProvider> a, a<zendesk.core.RestServiceProvider> a2, a<zendesk.core.BlipsProvider> a3, a<zendesk.core.SessionStorage> a4, a<zendesk.core.NetworkInfoProvider> a5, a<zendesk.core.MemoryCache> a6, a<zendesk.core.ActionHandlerRegistry> a7, a<ScheduledExecutorService> a8, a<Context> a9, a<zendesk.core.AuthenticationProvider> a10, a<zendesk.core.ApplicationConfiguration> a11, a<zendesk.core.PushRegistrationProvider> a12) {
        super();
        this.settingsProvider = a;
        this.restServiceProvider = a2;
        this.blipsProvider = a3;
        this.sessionStorageProvider = a4;
        this.networkInfoProvider = a5;
        this.memoryCacheProvider = a6;
        this.actionHandlerRegistryProvider = a7;
        this.executorProvider = a8;
        this.contextProvider = a9;
        this.authenticationProvider = a10;
        this.zendeskConfigurationProvider = a11;
        this.pushRegistrationProvider = a12;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideCoreSdkModuleFactory create(a<zendesk.core.SettingsProvider> a, a<zendesk.core.RestServiceProvider> a2, a<zendesk.core.BlipsProvider> a3, a<zendesk.core.SessionStorage> a4, a<zendesk.core.NetworkInfoProvider> a5, a<zendesk.core.MemoryCache> a6, a<zendesk.core.ActionHandlerRegistry> a7, a<ScheduledExecutorService> a8, a<Context> a9, a<zendesk.core.AuthenticationProvider> a10, a<zendesk.core.ApplicationConfiguration> a11, a<zendesk.core.PushRegistrationProvider> a12) {
        super(a, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
        return zendeskProvidersModule_ProvideCoreSdkModuleFactory;
    }

    public static zendesk.core.CoreModule provideCoreSdkModule(zendesk.core.SettingsProvider settingsProvider, zendesk.core.RestServiceProvider restServiceProvider2, zendesk.core.BlipsProvider blipsProvider3, zendesk.core.SessionStorage sessionStorage4, zendesk.core.NetworkInfoProvider networkInfoProvider5, zendesk.core.MemoryCache memoryCache6, zendesk.core.ActionHandlerRegistry actionHandlerRegistry7, ScheduledExecutorService scheduledExecutorService8, Context context9, zendesk.core.AuthenticationProvider authenticationProvider10, zendesk.core.ApplicationConfiguration applicationConfiguration11, zendesk.core.PushRegistrationProvider pushRegistrationProvider12) {
        final zendesk.core.CoreModule obj0 = ZendeskProvidersModule.provideCoreSdkModule(settingsProvider, restServiceProvider2, blipsProvider3, sessionStorage4, networkInfoProvider5, memoryCache6, actionHandlerRegistry7, scheduledExecutorService8, context9, authenticationProvider10, applicationConfiguration11, pushRegistrationProvider12);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (CoreModule)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.CoreModule get() {
        return ZendeskProvidersModule_ProvideCoreSdkModuleFactory.provideCoreSdkModule((SettingsProvider)this.settingsProvider.get(), (RestServiceProvider)this.restServiceProvider.get(), (BlipsProvider)this.blipsProvider.get(), (SessionStorage)this.sessionStorageProvider.get(), (NetworkInfoProvider)this.networkInfoProvider.get(), (MemoryCache)this.memoryCacheProvider.get(), (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get(), (ScheduledExecutorService)this.executorProvider.get(), (Context)this.contextProvider.get(), (AuthenticationProvider)this.authenticationProvider.get(), (ApplicationConfiguration)this.zendeskConfigurationProvider.get(), (PushRegistrationProvider)this.pushRegistrationProvider.get());
    }
}
