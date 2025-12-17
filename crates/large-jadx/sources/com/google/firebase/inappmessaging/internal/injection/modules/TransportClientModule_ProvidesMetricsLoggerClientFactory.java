package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import f.c.a.b.g;
import j.a.a;

/* loaded from: classes2.dex */
public final class TransportClientModule_ProvidesMetricsLoggerClientFactory implements Factory<MetricsLoggerClient> {

    private final a<AnalyticsConnector> analyticsConnectorProvider;
    private final a<FirebaseApp> appProvider;
    private final a<Clock> clockProvider;
    private final a<DeveloperListenerManager> developerListenerManagerProvider;
    private final a<FirebaseInstallationsApi> firebaseInstallationsProvider;
    private final a<g> transportFactoryProvider;
    public TransportClientModule_ProvidesMetricsLoggerClientFactory(a<FirebaseApp> a, a<g> a2, a<AnalyticsConnector> a3, a<FirebaseInstallationsApi> a4, a<Clock> a5, a<DeveloperListenerManager> a6) {
        super();
        this.appProvider = a;
        this.transportFactoryProvider = a2;
        this.analyticsConnectorProvider = a3;
        this.firebaseInstallationsProvider = a4;
        this.clockProvider = a5;
        this.developerListenerManagerProvider = a6;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule_ProvidesMetricsLoggerClientFactory create(a<FirebaseApp> a, a<g> a2, a<AnalyticsConnector> a3, a<FirebaseInstallationsApi> a4, a<Clock> a5, a<DeveloperListenerManager> a6) {
        super(a, a2, a3, a4, a5, a6);
        return transportClientModule_ProvidesMetricsLoggerClientFactory;
    }

    public static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, g g2, AnalyticsConnector analyticsConnector3, FirebaseInstallationsApi firebaseInstallationsApi4, Clock clock5, DeveloperListenerManager developerListenerManager6) {
        return (MetricsLoggerClient)Preconditions.checkNotNull(TransportClientModule.providesMetricsLoggerClient(firebaseApp, g2, analyticsConnector3, firebaseInstallationsApi4, clock5, developerListenerManager6), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public MetricsLoggerClient get() {
        return TransportClientModule_ProvidesMetricsLoggerClientFactory.providesMetricsLoggerClient((FirebaseApp)this.appProvider.get(), (g)this.transportFactoryProvider.get(), (AnalyticsConnector)this.analyticsConnectorProvider.get(), (FirebaseInstallationsApi)this.firebaseInstallationsProvider.get(), (Clock)this.clockProvider.get(), (DeveloperListenerManager)this.developerListenerManagerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
