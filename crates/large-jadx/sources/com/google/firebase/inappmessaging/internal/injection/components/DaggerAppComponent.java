package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory;
import com.google.firebase.inappmessaging.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.dagger.internal.InstanceFactory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.GrpcClient_Factory;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseAppFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule_ProvidesMetricsLoggerClientFactory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.installations.FirebaseInstallationsApi;
import f.c.a.b.g;
import f.c.f.a.a.a.e.g.b;
import i.b.k0.a;
import io.grpc.e;
import io.grpc.t0;
import j.a.a;

/* loaded from: classes2.dex */
public final class DaggerAppComponent implements com.google.firebase.inappmessaging.internal.injection.components.AppComponent {

    private a<AbtIntegrationHelper> abtIntegrationHelperProvider;
    private a<AnalyticsConnector> analyticsConnectorProvider;
    private a<AnalyticsEventsManager> analyticsEventsManagerProvider;
    private final ApiClientModule apiClientModule;
    private a<a<String>> appForegroundEventFlowableProvider;
    private a<RateLimit> appForegroundRateLimitProvider;
    private a<Application> applicationProvider;
    private a<CampaignCacheClient> campaignCacheClientProvider;
    private a<Clock> clockProvider;
    private a<DeveloperListenerManager> developerListenerManagerProvider;
    private a<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
    private a<Subscriber> firebaseEventsSubscriberProvider;
    private a<FirebaseInAppMessaging> firebaseInAppMessagingProvider;
    private a<e> gRPCChannelProvider;
    private a<GrpcClient> grpcClientProvider;
    private a<ImpressionStorageClient> impressionStorageClientProvider;
    private a<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
    private a<ProviderInstaller> probiderInstallerProvider;
    private a<a<String>> programmaticContextualTriggerFlowableProvider;
    private a<ProgramaticContextualTriggers> programmaticContextualTriggersProvider;
    private a<ApiClient> providesApiClientProvider;
    private a<t0> providesApiKeyHeadersProvider;
    private a<DataCollectionHelper> providesDataCollectionHelperProvider;
    private a<FirebaseApp> providesFirebaseAppProvider;
    private a<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private a<g.b> providesInAppMessagingSdkServingStubProvider;
    private a<MetricsLoggerClient> providesMetricsLoggerClientProvider;
    private a<SharedPreferencesUtils> providesSharedPreferencesUtilsProvider;
    private a<TestDeviceHelper> providesTestDeviceHelperProvider;
    private a<RateLimiterClient> rateLimiterClientProvider;
    private a<Schedulers> schedulersProvider;
    private a<g> transportFactoryProvider;
    private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;

    private static final class Builder implements com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder {

        private AbtIntegrationHelper abtIntegrationHelper;
        private ApiClientModule apiClientModule;
        private GrpcClientModule grpcClientModule;
        private g transportFactory;
        private com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        Builder(com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.1 daggerAppComponent$1) {
            super();
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper) {
            return abtIntegrationHelper(abtIntegrationHelper);
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper) {
            this.abtIntegrationHelper = (AbtIntegrationHelper)Preconditions.checkNotNull(abtIntegrationHelper);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder apiClientModule(ApiClientModule apiClientModule) {
            return apiClientModule(apiClientModule);
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.Builder apiClientModule(ApiClientModule apiClientModule) {
            this.apiClientModule = (ApiClientModule)Preconditions.checkNotNull(apiClientModule);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.AppComponent build() {
            Preconditions.checkBuilderRequirement(this.abtIntegrationHelper, AbtIntegrationHelper.class);
            Preconditions.checkBuilderRequirement(this.apiClientModule, ApiClientModule.class);
            Preconditions.checkBuilderRequirement(this.grpcClientModule, GrpcClientModule.class);
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            Preconditions.checkBuilderRequirement(this.transportFactory, g.class);
            super(this.apiClientModule, this.grpcClientModule, this.universalComponent, this.abtIntegrationHelper, this.transportFactory, 0);
            return daggerAppComponent;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder grpcClientModule(GrpcClientModule grpcClientModule) {
            return grpcClientModule(grpcClientModule);
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.Builder grpcClientModule(GrpcClientModule grpcClientModule) {
            this.grpcClientModule = (GrpcClientModule)Preconditions.checkNotNull(grpcClientModule);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder transportFactory(g g) {
            return transportFactory(g);
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.Builder transportFactory(g g) {
            this.transportFactory = (g)Preconditions.checkNotNull(g);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder universalComponent(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            return universalComponent(universalComponent);
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent$Builder
        public com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.Builder universalComponent(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            this.universalComponent = (UniversalComponent)Preconditions.checkNotNull(universalComponent);
            return this;
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector implements a<AnalyticsConnector> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public AnalyticsConnector get() {
            return (AnalyticsConnector)Preconditions.checkNotNull(this.universalComponent.analyticsConnector(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager implements a<AnalyticsEventsManager> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public AnalyticsEventsManager get() {
            return (AnalyticsEventsManager)Preconditions.checkNotNull(this.universalComponent.analyticsEventsManager(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable implements a<a<String>> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        public a<String> get() {
            return (a)Preconditions.checkNotNull(this.universalComponent.appForegroundEventFlowable(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit implements a<RateLimit> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public RateLimit get() {
            return (RateLimit)Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application implements a<Application> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public Application get() {
            return (Application)Preconditions.checkNotNull(this.universalComponent.application(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient implements a<CampaignCacheClient> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public CampaignCacheClient get() {
            return (CampaignCacheClient)Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock implements a<Clock> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public Clock get() {
            return (Clock)Preconditions.checkNotNull(this.universalComponent.clock(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager implements a<DeveloperListenerManager> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public DeveloperListenerManager get() {
            return (DeveloperListenerManager)Preconditions.checkNotNull(this.universalComponent.developerListenerManager(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber implements a<Subscriber> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public Subscriber get() {
            return (Subscriber)Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel implements a<e> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public e get() {
            return (e)Preconditions.checkNotNull(this.universalComponent.gRPCChannel(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient implements a<ImpressionStorageClient> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public ImpressionStorageClient get() {
            return (ImpressionStorageClient)Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller implements a<ProviderInstaller> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public ProviderInstaller get() {
            return (ProviderInstaller)Preconditions.checkNotNull(this.universalComponent.probiderInstaller(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable implements a<a<String>> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        public a<String> get() {
            return (a)Preconditions.checkNotNull(this.universalComponent.programmaticContextualTriggerFlowable(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers implements a<ProgramaticContextualTriggers> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public ProgramaticContextualTriggers get() {
            return (ProgramaticContextualTriggers)Preconditions.checkNotNull(this.universalComponent.programmaticContextualTriggers(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient implements a<RateLimiterClient> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public RateLimiterClient get() {
            return (RateLimiterClient)Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers implements a<Schedulers> {

        private final com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public Schedulers get() {
            return (Schedulers)Preconditions.checkNotNull(this.universalComponent.schedulers(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }
    private DaggerAppComponent(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule2, com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent3, AbtIntegrationHelper abtIntegrationHelper4, g g5) {
        super();
        this.universalComponent = universalComponent3;
        this.apiClientModule = apiClientModule;
        initialize(apiClientModule, grpcClientModule2, universalComponent3, abtIntegrationHelper4, g5);
    }

    DaggerAppComponent(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule2, com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent3, AbtIntegrationHelper abtIntegrationHelper4, g g5, com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent.1 daggerAppComponent$16) {
        super(apiClientModule, grpcClientModule2, universalComponent3, abtIntegrationHelper4, g5);
    }

    public static com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder builder() {
        DaggerAppComponent.Builder builder = new DaggerAppComponent.Builder(0);
        return builder;
    }

    private DataCollectionHelper getDataCollectionHelper() {
        ApiClientModule apiClientModule = this.apiClientModule;
        return ApiClientModule_ProvidesDataCollectionHelperFactory.providesDataCollectionHelper(apiClientModule, ApiClientModule_ProvidesSharedPreferencesUtilsFactory.providesSharedPreferencesUtils(apiClientModule), (Subscriber)Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method"));
    }

    private void initialize(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule2, com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent3, AbtIntegrationHelper abtIntegrationHelper4, g g5) {
        final Object obj = this;
        ApiClientModule client = apiClientModule;
        com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent = universalComponent3;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable(universalComponent);
        obj.appForegroundEventFlowableProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable(universalComponent);
        obj.programmaticContextualTriggerFlowableProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient(universalComponent);
        obj.campaignCacheClientProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock(universalComponent);
        obj.clockProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel(universalComponent);
        obj.gRPCChannelProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel;
        GrpcClientModule_ProvidesApiKeyHeadersFactory create6 = GrpcClientModule_ProvidesApiKeyHeadersFactory.create(grpcClientModule2);
        obj.providesApiKeyHeadersProvider = create6;
        a provider3 = DoubleCheck.provider(GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.create(grpcClientModule2, obj.gRPCChannelProvider, create6));
        obj.providesInAppMessagingSdkServingStubProvider = provider3;
        obj.grpcClientProvider = DoubleCheck.provider(GrpcClient_Factory.create(provider3));
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application(universalComponent);
        obj.applicationProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller(universalComponent);
        obj.probiderInstallerProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller;
        obj.providesApiClientProvider = DoubleCheck.provider(ApiClientModule_ProvidesApiClientFactory.create(client, obj.grpcClientProvider, obj.applicationProvider, com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller));
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager(universalComponent);
        obj.analyticsEventsManagerProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers(universalComponent);
        obj.schedulersProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient(universalComponent);
        obj.impressionStorageClientProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient(universalComponent);
        obj.rateLimiterClientProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit(universalComponent);
        obj.appForegroundRateLimitProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit;
        ApiClientModule_ProvidesSharedPreferencesUtilsFactory create10 = ApiClientModule_ProvidesSharedPreferencesUtilsFactory.create(apiClientModule);
        obj.providesSharedPreferencesUtilsProvider = create10;
        obj.providesTestDeviceHelperProvider = ApiClientModule_ProvidesTestDeviceHelperFactory.create(client, create10);
        obj.providesFirebaseInstallationsProvider = ApiClientModule_ProvidesFirebaseInstallationsFactory.create(apiClientModule);
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber(universalComponent);
        obj.firebaseEventsSubscriberProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber;
        obj.providesDataCollectionHelperProvider = ApiClientModule_ProvidesDataCollectionHelperFactory.create(client, obj.providesSharedPreferencesUtilsProvider, com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber);
        com.google.firebase.inappmessaging.dagger.internal.Factory create14 = InstanceFactory.create(abtIntegrationHelper4);
        obj.abtIntegrationHelperProvider = create14;
        obj.inAppMessageStreamManagerProvider = DoubleCheck.provider(InAppMessageStreamManager_Factory.create(obj.appForegroundEventFlowableProvider, obj.programmaticContextualTriggerFlowableProvider, obj.campaignCacheClientProvider, obj.clockProvider, obj.providesApiClientProvider, obj.analyticsEventsManagerProvider, obj.schedulersProvider, obj.impressionStorageClientProvider, obj.rateLimiterClientProvider, obj.appForegroundRateLimitProvider, obj.providesTestDeviceHelperProvider, obj.providesFirebaseInstallationsProvider, obj.providesDataCollectionHelperProvider, create14));
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers(universalComponent);
        obj.programmaticContextualTriggersProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers;
        obj.providesFirebaseAppProvider = ApiClientModule_ProvidesFirebaseAppFactory.create(apiClientModule);
        obj.transportFactoryProvider = InstanceFactory.create(g5);
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector(universalComponent);
        obj.analyticsConnectorProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector;
        DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager = new DaggerAppComponent.com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager(universalComponent);
        obj.developerListenerManagerProvider = com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager;
        a provider6 = DoubleCheck.provider(TransportClientModule_ProvidesMetricsLoggerClientFactory.create(obj.providesFirebaseAppProvider, obj.transportFactoryProvider, obj.analyticsConnectorProvider, obj.providesFirebaseInstallationsProvider, obj.clockProvider, com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager));
        obj.providesMetricsLoggerClientProvider = provider6;
        DisplayCallbacksFactory_Factory create15 = DisplayCallbacksFactory_Factory.create(obj.impressionStorageClientProvider, obj.clockProvider, obj.schedulersProvider, obj.rateLimiterClientProvider, obj.campaignCacheClientProvider, obj.appForegroundRateLimitProvider, provider6, obj.providesDataCollectionHelperProvider);
        obj.displayCallbacksFactoryProvider = create15;
        obj.firebaseInAppMessagingProvider = DoubleCheck.provider(FirebaseInAppMessaging_Factory.create(obj.inAppMessageStreamManagerProvider, obj.programmaticContextualTriggersProvider, obj.providesDataCollectionHelperProvider, obj.providesFirebaseInstallationsProvider, create15, obj.developerListenerManagerProvider));
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent
    public DisplayCallbacksFactory displayCallbacksFactory() {
        String str = "Cannot return null from a non-@Nullable component method";
        super((ImpressionStorageClient)Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), str), (Clock)Preconditions.checkNotNull(this.universalComponent.clock(), str), (Schedulers)Preconditions.checkNotNull(this.universalComponent.schedulers(), str), (RateLimiterClient)Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), str), (CampaignCacheClient)Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), str), (RateLimit)Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), str), (MetricsLoggerClient)this.providesMetricsLoggerClientProvider.get(), getDataCollectionHelper());
        return displayCallbacksFactory;
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent
    public FirebaseInAppMessaging providesFirebaseInAppMessaging() {
        return (FirebaseInAppMessaging)this.firebaseInAppMessagingProvider.get();
    }
}
