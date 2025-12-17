package com.google.firebase.perf.injection.modules;

import com.google.firebase.inject.Provider;
import f.c.a.b.g;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory implements b<Provider<g>> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory firebasePerformanceModule_ProvidesTransportFactoryProviderFactory = new FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesTransportFactoryProviderFactory;
    }

    public static Provider<g> providesTransportFactoryProvider(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final Provider obj1 = firebasePerformanceModule.providesTransportFactoryProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Provider)obj1;
    }

    public Provider<g> get() {
        return FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory.providesTransportFactoryProvider(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
