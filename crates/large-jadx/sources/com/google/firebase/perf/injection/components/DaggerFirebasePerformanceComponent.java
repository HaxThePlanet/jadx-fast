package com.google.firebase.perf.injection.components;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.FirebasePerformance_Factory;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesGaugeManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import f.c.a.b.g;
import g.b.a;
import g.b.d;
import j.a.a;

/* loaded from: classes2.dex */
public final class DaggerFirebasePerformanceComponent implements com.google.firebase.perf.injection.components.FirebasePerformanceComponent {

    private a<FirebasePerformance> firebasePerformanceProvider;
    private a<ConfigResolver> providesConfigResolverProvider;
    private a<FirebaseApp> providesFirebaseAppProvider;
    private a<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private a<GaugeManager> providesGaugeManagerProvider;
    private a<Provider<RemoteConfigComponent>> providesRemoteConfigComponentProvider;
    private a<RemoteConfigManager> providesRemoteConfigManagerProvider;
    private a<Provider<g>> providesTransportFactoryProvider;

    public static final class Builder {

        private FirebasePerformanceModule firebasePerformanceModule;
        Builder(com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent.1 daggerFirebasePerformanceComponent$1) {
            super();
        }

        public com.google.firebase.perf.injection.components.FirebasePerformanceComponent build() {
            d.a(this.firebasePerformanceModule, FirebasePerformanceModule.class);
            DaggerFirebasePerformanceComponent daggerFirebasePerformanceComponent = new DaggerFirebasePerformanceComponent(this.firebasePerformanceModule, 0);
            return daggerFirebasePerformanceComponent;
        }

        public com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent.Builder firebasePerformanceModule(FirebasePerformanceModule firebasePerformanceModule) {
            d.b(firebasePerformanceModule);
            this.firebasePerformanceModule = (FirebasePerformanceModule)firebasePerformanceModule;
            return this;
        }
    }
    private DaggerFirebasePerformanceComponent(FirebasePerformanceModule firebasePerformanceModule) {
        super();
        initialize(firebasePerformanceModule);
    }

    DaggerFirebasePerformanceComponent(FirebasePerformanceModule firebasePerformanceModule, com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent.1 daggerFirebasePerformanceComponent$12) {
        super(firebasePerformanceModule);
    }

    public static com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent.Builder builder() {
        DaggerFirebasePerformanceComponent.Builder builder = new DaggerFirebasePerformanceComponent.Builder(0);
        return builder;
    }

    private void initialize(FirebasePerformanceModule firebasePerformanceModule) {
        this.providesFirebaseAppProvider = FirebasePerformanceModule_ProvidesFirebaseAppFactory.create(firebasePerformanceModule);
        this.providesRemoteConfigComponentProvider = FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory.create(firebasePerformanceModule);
        this.providesFirebaseInstallationsProvider = FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory.create(firebasePerformanceModule);
        this.providesTransportFactoryProvider = FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory.create(firebasePerformanceModule);
        this.providesRemoteConfigManagerProvider = FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory.create(firebasePerformanceModule);
        this.providesConfigResolverProvider = FirebasePerformanceModule_ProvidesConfigResolverFactory.create(firebasePerformanceModule);
        final FirebasePerformanceModule_ProvidesGaugeManagerFactory create7 = FirebasePerformanceModule_ProvidesGaugeManagerFactory.create(firebasePerformanceModule);
        this.providesGaugeManagerProvider = create7;
        this.firebasePerformanceProvider = a.a(FirebasePerformance_Factory.create(this.providesFirebaseAppProvider, this.providesRemoteConfigComponentProvider, this.providesFirebaseInstallationsProvider, this.providesTransportFactoryProvider, this.providesRemoteConfigManagerProvider, this.providesConfigResolverProvider, create7));
    }

    @Override // com.google.firebase.perf.injection.components.FirebasePerformanceComponent
    public FirebasePerformance getFirebasePerformance() {
        return (FirebasePerformance)this.firebasePerformanceProvider.get();
    }
}
