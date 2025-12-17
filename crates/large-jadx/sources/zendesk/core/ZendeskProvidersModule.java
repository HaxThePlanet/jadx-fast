package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
class ZendeskProvidersModule {
    static zendesk.core.ActionHandlerRegistry actionHandlerRegistry() {
        return Zendesk.INSTANCE.actionHandlerRegistry();
    }

    static zendesk.core.AccessProvider provideAccessProvider(zendesk.core.IdentityManager identityManager, zendesk.core.AccessService accessService2) {
        ZendeskAccessProvider zendeskAccessProvider = new ZendeskAccessProvider(identityManager, accessService2);
        return zendeskAccessProvider;
    }

    static zendesk.core.AccessService provideAccessService(Retrofit retrofit) {
        return (AccessService)retrofit.create(AccessService.class);
    }

    static zendesk.core.BlipsService provideBlipsService(Retrofit retrofit) {
        return (BlipsService)retrofit.create(BlipsService.class);
    }

    static zendesk.core.CoreModule provideCoreSdkModule(zendesk.core.SettingsProvider settingsProvider, zendesk.core.RestServiceProvider restServiceProvider2, zendesk.core.BlipsProvider blipsProvider3, zendesk.core.SessionStorage sessionStorage4, zendesk.core.NetworkInfoProvider networkInfoProvider5, zendesk.core.MemoryCache memoryCache6, zendesk.core.ActionHandlerRegistry actionHandlerRegistry7, ScheduledExecutorService scheduledExecutorService8, Context context9, zendesk.core.AuthenticationProvider authenticationProvider10, zendesk.core.ApplicationConfiguration applicationConfiguration11, zendesk.core.PushRegistrationProvider pushRegistrationProvider12) {
        super(settingsProvider, restServiceProvider2, blipsProvider3, sessionStorage4, networkInfoProvider5, context9, actionHandlerRegistry7, memoryCache6, scheduledExecutorService8, authenticationProvider10, applicationConfiguration11, pushRegistrationProvider12);
        return coreModule2;
    }

    static zendesk.core.ProviderStore provideProviderStore(zendesk.core.UserProvider userProvider, zendesk.core.PushRegistrationProvider pushRegistrationProvider2) {
        ZendeskProviderStore zendeskProviderStore = new ZendeskProviderStore(userProvider, pushRegistrationProvider2);
        return zendeskProviderStore;
    }

    static zendesk.core.PushRegistrationProvider providePushRegistrationProvider(zendesk.core.PushRegistrationService pushRegistrationService, zendesk.core.IdentityManager identityManager2, zendesk.core.SettingsProvider settingsProvider3, zendesk.core.BlipsCoreProvider blipsCoreProvider4, zendesk.core.PushDeviceIdStorage pushDeviceIdStorage5, Context context6) {
        super(pushRegistrationService, identityManager2, settingsProvider3, blipsCoreProvider4, pushDeviceIdStorage5, DeviceInfo.getCurrentLocale(context6));
        return zendeskPushRegistrationProvider2;
    }

    static zendesk.core.PushRegistrationProviderInternal providePushRegistrationProviderInternal(zendesk.core.PushRegistrationProvider pushRegistrationProvider) {
        return (ZendeskPushRegistrationProvider)pushRegistrationProvider;
    }

    static zendesk.core.PushRegistrationService providePushRegistrationService(Retrofit retrofit) {
        return (PushRegistrationService)retrofit.create(PushRegistrationService.class);
    }

    static zendesk.core.SettingsProvider provideSdkSettingsProvider(zendesk.core.ZendeskSettingsProvider zendeskSettingsProvider) {
        return zendeskSettingsProvider;
    }

    static zendesk.core.SdkSettingsProviderInternal provideSdkSettingsProviderInternal(zendesk.core.ZendeskSettingsProvider zendeskSettingsProvider) {
        return zendeskSettingsProvider;
    }

    static zendesk.core.SdkSettingsService provideSdkSettingsService(Retrofit retrofit) {
        return (SdkSettingsService)retrofit.create(SdkSettingsService.class);
    }

    static zendesk.core.UserProvider provideUserProvider(zendesk.core.UserService userService) {
        ZendeskUserProvider zendeskUserProvider = new ZendeskUserProvider(userService);
        return zendeskUserProvider;
    }

    static zendesk.core.UserService provideUserService(Retrofit retrofit) {
        return (UserService)retrofit.create(UserService.class);
    }

    static zendesk.core.ZendeskSettingsProvider provideZendeskSdkSettingsProvider(zendesk.core.SdkSettingsService sdkSettingsService, zendesk.core.SettingsStorage settingsStorage2, zendesk.core.CoreSettingsStorage coreSettingsStorage3, zendesk.core.ActionHandlerRegistry actionHandlerRegistry4, zendesk.core.Serializer serializer5, zendesk.core.ZendeskLocaleConverter zendeskLocaleConverter6, zendesk.core.ApplicationConfiguration applicationConfiguration7, Context context8) {
        super(sdkSettingsService, settingsStorage2, coreSettingsStorage3, actionHandlerRegistry4, serializer5, zendeskLocaleConverter6, applicationConfiguration7.getApplicationId(), context8);
        return zendeskSettingsProvider;
    }

    static zendesk.core.BlipsCoreProvider providerBlipsCoreProvider(zendesk.core.ZendeskBlipsProvider zendeskBlipsProvider) {
        return zendeskBlipsProvider;
    }

    static zendesk.core.BlipsProvider providerBlipsProvider(zendesk.core.ZendeskBlipsProvider zendeskBlipsProvider) {
        return zendeskBlipsProvider;
    }

    static ConnectivityManager providerConnectivityManager(Context context) {
        return (ConnectivityManager)context.getSystemService("connectivity");
    }

    static zendesk.core.NetworkInfoProvider providerNetworkInfoProvider(Context context, ConnectivityManager connectivityManager2) {
        ZendeskNetworkInfoProvider zendeskNetworkInfoProvider = new ZendeskNetworkInfoProvider(context, connectivityManager2);
        return zendeskNetworkInfoProvider;
    }

    static zendesk.core.ZendeskBlipsProvider providerZendeskBlipsProvider(zendesk.core.BlipsService blipsService, zendesk.core.DeviceInfo deviceInfo2, zendesk.core.Serializer serializer3, zendesk.core.IdentityManager identityManager4, zendesk.core.ApplicationConfiguration applicationConfiguration5, zendesk.core.CoreSettingsStorage coreSettingsStorage6, ExecutorService executorService7) {
        super(blipsService, deviceInfo2, serializer3, identityManager4, applicationConfiguration5.getApplicationId(), coreSettingsStorage6, executorService7);
        return zendeskBlipsProvider2;
    }
}
