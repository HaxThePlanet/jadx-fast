package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class AppMeasurementModule_ProvidesSubsriberFactory implements Factory<Subscriber> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule module;
    public AppMeasurementModule_ProvidesSubsriberFactory(com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule appMeasurementModule) {
        super();
        this.module = appMeasurementModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesSubsriberFactory create(com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule appMeasurementModule) {
        AppMeasurementModule_ProvidesSubsriberFactory appMeasurementModule_ProvidesSubsriberFactory = new AppMeasurementModule_ProvidesSubsriberFactory(appMeasurementModule);
        return appMeasurementModule_ProvidesSubsriberFactory;
    }

    public static Subscriber providesSubsriber(com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule appMeasurementModule) {
        return (Subscriber)Preconditions.checkNotNull(appMeasurementModule.providesSubsriber(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Subscriber get() {
        return AppMeasurementModule_ProvidesSubsriberFactory.providesSubsriber(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
