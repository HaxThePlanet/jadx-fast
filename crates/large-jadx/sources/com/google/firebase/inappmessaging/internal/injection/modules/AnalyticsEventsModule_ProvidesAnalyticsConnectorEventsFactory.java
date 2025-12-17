package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import i.b.k0.a;
import j.a.a;

/* loaded from: classes2.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory implements Factory<a<String>> {

    private final a<AnalyticsEventsManager> analyticsEventsManagerProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule module;
    public AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule analyticsEventsModule, a<AnalyticsEventsManager> a2) {
        super();
        this.module = analyticsEventsModule;
        this.analyticsEventsManagerProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory create(com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule analyticsEventsModule, a<AnalyticsEventsManager> a2) {
        AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory analyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory = new AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(analyticsEventsModule, a2);
        return analyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory;
    }

    public static a<String> providesAnalyticsConnectorEvents(com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule analyticsEventsModule, AnalyticsEventsManager analyticsEventsManager2) {
        return (a)Preconditions.checkNotNull(analyticsEventsModule.providesAnalyticsConnectorEvents(analyticsEventsManager2), "Cannot return null from a non-@Nullable @Provides method");
    }

    public a<String> get() {
        return AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory.providesAnalyticsConnectorEvents(this.module, (AnalyticsEventsManager)this.analyticsEventsManagerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
