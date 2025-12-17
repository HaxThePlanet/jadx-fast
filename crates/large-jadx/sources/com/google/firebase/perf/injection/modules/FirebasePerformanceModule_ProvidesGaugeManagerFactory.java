package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.gauges.GaugeManager;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesGaugeManagerFactory implements b<GaugeManager> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesGaugeManagerFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesGaugeManagerFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesGaugeManagerFactory firebasePerformanceModule_ProvidesGaugeManagerFactory = new FirebasePerformanceModule_ProvidesGaugeManagerFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesGaugeManagerFactory;
    }

    public static GaugeManager providesGaugeManager(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final GaugeManager obj1 = firebasePerformanceModule.providesGaugeManager();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (GaugeManager)obj1;
    }

    @Override // g.b.b
    public GaugeManager get() {
        return FirebasePerformanceModule_ProvidesGaugeManagerFactory.providesGaugeManager(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
