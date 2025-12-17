package com.google.firebase.perf.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory implements b<FirebaseInstallationsApi> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory firebasePerformanceModule_ProvidesFirebaseInstallationsFactory = new FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesFirebaseInstallationsFactory;
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final FirebaseInstallationsApi obj1 = firebasePerformanceModule.providesFirebaseInstallations();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (FirebaseInstallationsApi)obj1;
    }

    @Override // g.b.b
    public FirebaseInstallationsApi get() {
        return FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory.providesFirebaseInstallations(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
