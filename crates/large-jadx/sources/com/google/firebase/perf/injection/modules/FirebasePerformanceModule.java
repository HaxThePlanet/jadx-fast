package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import f.c.a.b.g;

/* loaded from: classes2.dex */
public class FirebasePerformanceModule {

    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<RemoteConfigComponent> remoteConfigComponentProvider;
    private final Provider<g> transportFactoryProvider;
    public FirebasePerformanceModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi2, Provider<RemoteConfigComponent> provider3, Provider<g> provider4) {
        super();
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi2;
        this.remoteConfigComponentProvider = provider3;
        this.transportFactoryProvider = provider4;
    }

    ConfigResolver providesConfigResolver() {
        return ConfigResolver.getInstance();
    }

    FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    GaugeManager providesGaugeManager() {
        return GaugeManager.getInstance();
    }

    Provider<RemoteConfigComponent> providesRemoteConfigComponent() {
        return this.remoteConfigComponentProvider;
    }

    RemoteConfigManager providesRemoteConfigManager() {
        return RemoteConfigManager.getInstance();
    }

    Provider<g> providesTransportFactoryProvider() {
        return this.transportFactoryProvider;
    }
}
