package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import j.a.a;

/* loaded from: classes2.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory implements Factory<AnalyticsEventsManager> {

    private final a<AnalyticsConnector> analyticsConnectorProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule module;
    public AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule analyticsEventsModule, a<AnalyticsConnector> a2) {
        super();
        this.module = analyticsEventsModule;
        this.analyticsConnectorProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory create(com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule analyticsEventsModule, a<AnalyticsConnector> a2) {
        AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory analyticsEventsModule_ProvidesAnalyticsEventsManagerFactory = new AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(analyticsEventsModule, a2);
        return analyticsEventsModule_ProvidesAnalyticsEventsManagerFactory;
    }

    public static AnalyticsEventsManager providesAnalyticsEventsManager(com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule analyticsEventsModule, AnalyticsConnector analyticsConnector2) {
        return (AnalyticsEventsManager)Preconditions.checkNotNull(analyticsEventsModule.providesAnalyticsEventsManager(analyticsConnector2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public AnalyticsEventsManager get() {
        return AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory.providesAnalyticsEventsManager(this.module, (AnalyticsConnector)this.analyticsConnectorProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
