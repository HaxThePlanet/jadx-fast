package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import g.b.b;
import g.b.d;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesFirebaseAppFactory implements b<FirebaseApp> {

    private final com.google.firebase.perf.injection.modules.FirebasePerformanceModule module;
    public FirebasePerformanceModule_ProvidesFirebaseAppFactory(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        super();
        this.module = firebasePerformanceModule;
    }

    public static com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory create(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        FirebasePerformanceModule_ProvidesFirebaseAppFactory firebasePerformanceModule_ProvidesFirebaseAppFactory = new FirebasePerformanceModule_ProvidesFirebaseAppFactory(firebasePerformanceModule);
        return firebasePerformanceModule_ProvidesFirebaseAppFactory;
    }

    public static FirebaseApp providesFirebaseApp(com.google.firebase.perf.injection.modules.FirebasePerformanceModule firebasePerformanceModule) {
        final FirebaseApp obj1 = firebasePerformanceModule.providesFirebaseApp();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (FirebaseApp)obj1;
    }

    @Override // g.b.b
    public FirebaseApp get() {
        return FirebasePerformanceModule_ProvidesFirebaseAppFactory.providesFirebaseApp(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
