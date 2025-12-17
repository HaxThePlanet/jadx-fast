package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.ConfigResolver;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesConfigResolverFactory implements b<ConfigResolver> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesConfigResolverFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesConfigResolverFactory firebasePerformanceModule_ProvidesConfigResolverFactory = new FirebasePerformanceModule_ProvidesConfigResolverFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesConfigResolverFactory;
    }

    public static ConfigResolver providesConfigResolver(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final ConfigResolver obj1 = firebasePerformanceModule.providesConfigResolver();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ConfigResolver)obj1;
    }

    @Override // g.b.b
    public ConfigResolver get() {
        return FirebasePerformanceModule_ProvidesConfigResolverFactory.providesConfigResolver(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
