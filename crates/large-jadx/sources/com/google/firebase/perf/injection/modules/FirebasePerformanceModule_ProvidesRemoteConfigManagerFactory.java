package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.RemoteConfigManager;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory implements b<RemoteConfigManager> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory firebasePerformanceModule_ProvidesRemoteConfigManagerFactory = new FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesRemoteConfigManagerFactory;
    }

    public static RemoteConfigManager providesRemoteConfigManager(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final RemoteConfigManager obj1 = firebasePerformanceModule.providesRemoteConfigManager();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (RemoteConfigManager)obj1;
    }

    @Override // g.b.b
    public RemoteConfigManager get() {
        return FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory.providesRemoteConfigManager(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
