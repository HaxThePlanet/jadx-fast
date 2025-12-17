package com.google.firebase.perf.injection.modules;

import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory implements b<Provider<RemoteConfigComponent>> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory firebasePerformanceModule_ProvidesRemoteConfigComponentFactory = new FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesRemoteConfigComponentFactory;
    }

    public static Provider<RemoteConfigComponent> providesRemoteConfigComponent(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final Provider obj1 = firebasePerformanceModule.providesRemoteConfigComponent();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Provider)obj1;
    }

    public Provider<RemoteConfigComponent> get() {
        return FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory.providesRemoteConfigComponent(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
