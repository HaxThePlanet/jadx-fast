package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class AppMeasurementModule_ProvidesAnalyticsConnectorFactory implements Factory<AnalyticsConnector> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule module;
    public AppMeasurementModule_ProvidesAnalyticsConnectorFactory(com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule appMeasurementModule) {
        super();
        this.module = appMeasurementModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesAnalyticsConnectorFactory create(com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule appMeasurementModule) {
        AppMeasurementModule_ProvidesAnalyticsConnectorFactory appMeasurementModule_ProvidesAnalyticsConnectorFactory = new AppMeasurementModule_ProvidesAnalyticsConnectorFactory(appMeasurementModule);
        return appMeasurementModule_ProvidesAnalyticsConnectorFactory;
    }

    public static AnalyticsConnector providesAnalyticsConnector(com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule appMeasurementModule) {
        return (AnalyticsConnector)Preconditions.checkNotNull(appMeasurementModule.providesAnalyticsConnector(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public AnalyticsConnector get() {
        return AppMeasurementModule_ProvidesAnalyticsConnectorFactory.providesAnalyticsConnector(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
