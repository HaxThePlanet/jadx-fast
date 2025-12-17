package com.google.firebase.perf;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import f.c.a.b.g;
import g.b.b;
import j.a.a;

/* loaded from: classes2.dex */
public final class FirebasePerformance_Factory implements b<com.google.firebase.perf.FirebasePerformance> {

    private final a<ConfigResolver> configResolverProvider;
    private final a<FirebaseApp> firebaseAppProvider;
    private final a<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
    private final a<Provider<RemoteConfigComponent>> firebaseRemoteConfigProvider;
    private final a<GaugeManager> gaugeManagerProvider;
    private final a<RemoteConfigManager> remoteConfigManagerProvider;
    private final a<Provider<g>> transportFactoryProvider;
    public FirebasePerformance_Factory(a<FirebaseApp> a, a<Provider<RemoteConfigComponent>> a2, a<FirebaseInstallationsApi> a3, a<Provider<g>> a4, a<RemoteConfigManager> a5, a<ConfigResolver> a6, a<GaugeManager> a7) {
        super();
        this.firebaseAppProvider = a;
        this.firebaseRemoteConfigProvider = a2;
        this.firebaseInstallationsApiProvider = a3;
        this.transportFactoryProvider = a4;
        this.remoteConfigManagerProvider = a5;
        this.configResolverProvider = a6;
        this.gaugeManagerProvider = a7;
    }

    public static com.google.firebase.perf.FirebasePerformance_Factory create(a<FirebaseApp> a, a<Provider<RemoteConfigComponent>> a2, a<FirebaseInstallationsApi> a3, a<Provider<g>> a4, a<RemoteConfigManager> a5, a<ConfigResolver> a6, a<GaugeManager> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return firebasePerformance_Factory;
    }

    public static com.google.firebase.perf.FirebasePerformance newInstance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider2, FirebaseInstallationsApi firebaseInstallationsApi3, Provider<g> provider4, RemoteConfigManager remoteConfigManager5, ConfigResolver configResolver6, GaugeManager gaugeManager7) {
        super(firebaseApp, provider2, firebaseInstallationsApi3, provider4, remoteConfigManager5, configResolver6, gaugeManager7);
        return firebasePerformance2;
    }

    @Override // g.b.b
    public com.google.firebase.perf.FirebasePerformance get() {
        return FirebasePerformance_Factory.newInstance((FirebaseApp)this.firebaseAppProvider.get(), (Provider)this.firebaseRemoteConfigProvider.get(), (FirebaseInstallationsApi)this.firebaseInstallationsApiProvider.get(), (Provider)this.transportFactoryProvider.get(), (RemoteConfigManager)this.remoteConfigManagerProvider.get(), (ConfigResolver)this.configResolverProvider.get(), (GaugeManager)this.gaugeManagerProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
