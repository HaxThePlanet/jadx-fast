package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import i.b.k0.a;
import j.a.a;

/* loaded from: classes2.dex */
public final class ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory implements Factory<a<String>> {

    private final a<Application> applicationProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule module;
    public ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule foregroundFlowableModule, a<Application> a2) {
        super();
        this.module = foregroundFlowableModule;
        this.applicationProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule foregroundFlowableModule, a<Application> a2) {
        ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory foregroundFlowableModule_ProvidesAppForegroundEventStreamFactory = new ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(foregroundFlowableModule, a2);
        return foregroundFlowableModule_ProvidesAppForegroundEventStreamFactory;
    }

    public static a<String> providesAppForegroundEventStream(com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule foregroundFlowableModule, Application application2) {
        return (a)Preconditions.checkNotNull(foregroundFlowableModule.providesAppForegroundEventStream(application2), "Cannot return null from a non-@Nullable @Provides method");
    }

    public a<String> get() {
        return ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory.providesAppForegroundEventStream(this.module, (Application)this.applicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
