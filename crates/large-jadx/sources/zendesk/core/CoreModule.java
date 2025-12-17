package zendesk.core;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public class CoreModule {

    private final zendesk.core.ActionHandlerRegistry actionHandlerRegistry;
    private final zendesk.core.ApplicationConfiguration applicationConfiguration;
    private final Context applicationContext;
    private final zendesk.core.AuthenticationProvider authenticationProvider;
    private final zendesk.core.BlipsProvider blipsProvider;
    private final ScheduledExecutorService executor;
    private final zendesk.core.MemoryCache memoryCache;
    private final zendesk.core.NetworkInfoProvider networkInfoProvider;
    private final zendesk.core.PushRegistrationProvider pushRegistrationProvider;
    private final zendesk.core.RestServiceProvider restServiceProvider;
    private final zendesk.core.SessionStorage sessionStorage;
    private final zendesk.core.SettingsProvider settingsProvider;
    CoreModule(zendesk.core.SettingsProvider settingsProvider, zendesk.core.RestServiceProvider restServiceProvider2, zendesk.core.BlipsProvider blipsProvider3, zendesk.core.SessionStorage sessionStorage4, zendesk.core.NetworkInfoProvider networkInfoProvider5, Context context6, zendesk.core.ActionHandlerRegistry actionHandlerRegistry7, zendesk.core.MemoryCache memoryCache8, ScheduledExecutorService scheduledExecutorService9, zendesk.core.AuthenticationProvider authenticationProvider10, zendesk.core.ApplicationConfiguration applicationConfiguration11, zendesk.core.PushRegistrationProvider pushRegistrationProvider12) {
        super();
        this.settingsProvider = settingsProvider;
        this.restServiceProvider = restServiceProvider2;
        this.blipsProvider = blipsProvider3;
        this.sessionStorage = sessionStorage4;
        this.networkInfoProvider = networkInfoProvider5;
        this.applicationContext = context6;
        this.actionHandlerRegistry = actionHandlerRegistry7;
        this.memoryCache = memoryCache8;
        this.executor = scheduledExecutorService9;
        this.authenticationProvider = authenticationProvider10;
        this.applicationConfiguration = applicationConfiguration11;
        this.pushRegistrationProvider = pushRegistrationProvider12;
    }

    zendesk.core.ActionHandlerRegistry actionHandlerRegistry() {
        return this.actionHandlerRegistry;
    }

    zendesk.core.ApplicationConfiguration getApplicationConfiguration() {
        return this.applicationConfiguration;
    }

    Context getApplicationContext() {
        return this.applicationContext;
    }

    zendesk.core.AuthenticationProvider getAuthenticationProvider() {
        return this.authenticationProvider;
    }

    zendesk.core.BlipsProvider getBlipsProvider() {
        return this.blipsProvider;
    }

    Executor getExecutor() {
        return this.executor;
    }

    ExecutorService getExecutorService() {
        return this.executor;
    }

    zendesk.core.MemoryCache getMemoryCache() {
        return this.memoryCache;
    }

    zendesk.core.NetworkInfoProvider getNetworkInfoProvider() {
        return this.networkInfoProvider;
    }

    zendesk.core.PushRegistrationProvider getPushRegistrationProvider() {
        return this.pushRegistrationProvider;
    }

    zendesk.core.RestServiceProvider getRestServiceProvider() {
        return this.restServiceProvider;
    }

    ScheduledExecutorService getScheduledExecutorService() {
        return this.executor;
    }

    zendesk.core.SessionStorage getSessionStorage() {
        return this.sessionStorage;
    }

    zendesk.core.SettingsProvider getSettingsProvider() {
        return this.settingsProvider;
    }
}
