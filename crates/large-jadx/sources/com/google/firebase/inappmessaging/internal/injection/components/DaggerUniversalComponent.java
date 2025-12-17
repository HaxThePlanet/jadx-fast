package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient_Factory;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient_Factory;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.ProviderInstaller_Factory;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient_Factory;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.Schedulers_Factory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesAnalyticsConnectorFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesSubsriberFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_DeveloperListenerManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesGrpcChannelFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesServiceHostFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule_ProvidesAppForegroundRateLimitFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesComputeSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesIOSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesMainThreadSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule_ProvidesSystemClockModuleFactory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory;
import com.google.firebase.inappmessaging.model.RateLimit;
import i.b.k0.a;
import i.b.z;
import io.grpc.e;
import j.a.a;

/* loaded from: classes2.dex */
public final class DaggerUniversalComponent implements com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent {

    private a<CampaignCacheClient> campaignCacheClientProvider;
    private a<DeveloperListenerManager> developerListenerManagerProvider;
    private a<ImpressionStorageClient> impressionStorageClientProvider;
    private a<ProtoMarshallerClient> protoMarshallerClientProvider;
    private a<ProviderInstaller> providerInstallerProvider;
    private a<a<String>> providesAnalyticsConnectorEventsProvider;
    private a<AnalyticsConnector> providesAnalyticsConnectorProvider;
    private a<AnalyticsEventsManager> providesAnalyticsEventsManagerProvider;
    private a<a<String>> providesAppForegroundEventStreamProvider;
    private a<Application> providesApplicationProvider;
    private a<z> providesComputeSchedulerProvider;
    private a<e> providesGrpcChannelProvider;
    private a<z> providesIOSchedulerProvider;
    private a<z> providesMainThreadSchedulerProvider;
    private a<a<String>> providesProgramaticContextualTriggerStreamProvider;
    private a<ProgramaticContextualTriggers> providesProgramaticContextualTriggersProvider;
    private a<ProtoStorageClient> providesProtoStorageClientForCampaignProvider;
    private a<ProtoStorageClient> providesProtoStorageClientForImpressionStoreProvider;
    private a<ProtoStorageClient> providesProtoStorageClientForLimiterStoreProvider;
    private a<String> providesServiceHostProvider;
    private a<Subscriber> providesSubsriberProvider;
    private a<Clock> providesSystemClockModuleProvider;
    private final RateLimitModule rateLimitModule;
    private a<RateLimiterClient> rateLimiterClientProvider;
    private a<Schedulers> schedulersProvider;
    private final SystemClockModule systemClockModule;

    public static final class Builder {

        private AnalyticsEventsModule analyticsEventsModule;
        private AppMeasurementModule appMeasurementModule;
        private ApplicationModule applicationModule;
        private ForegroundFlowableModule foregroundFlowableModule;
        private GrpcChannelModule grpcChannelModule;
        private ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule;
        private ProtoStorageClientModule protoStorageClientModule;
        private RateLimitModule rateLimitModule;
        private SchedulerModule schedulerModule;
        private SystemClockModule systemClockModule;
        Builder(com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.1 daggerUniversalComponent$1) {
            super();
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder analyticsEventsModule(AnalyticsEventsModule analyticsEventsModule) {
            this.analyticsEventsModule = (AnalyticsEventsModule)Preconditions.checkNotNull(analyticsEventsModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder appMeasurementModule(AppMeasurementModule appMeasurementModule) {
            this.appMeasurementModule = (AppMeasurementModule)Preconditions.checkNotNull(appMeasurementModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder applicationModule(ApplicationModule applicationModule) {
            this.applicationModule = (ApplicationModule)Preconditions.checkNotNull(applicationModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent build() {
            GrpcChannelModule grpcChannelModule;
            SchedulerModule schedulerModule;
            ForegroundFlowableModule foregroundFlowableModule;
            AnalyticsEventsModule analyticsEventsModule;
            ProtoStorageClientModule protoStorageClientModule;
            SystemClockModule systemClockModule;
            RateLimitModule rateLimitModule;
            if (this.grpcChannelModule == null) {
                grpcChannelModule = new GrpcChannelModule();
                this.grpcChannelModule = grpcChannelModule;
            }
            if (this.schedulerModule == null) {
                schedulerModule = new SchedulerModule();
                this.schedulerModule = schedulerModule;
            }
            Preconditions.checkBuilderRequirement(this.applicationModule, ApplicationModule.class);
            if (this.foregroundFlowableModule == null) {
                foregroundFlowableModule = new ForegroundFlowableModule();
                this.foregroundFlowableModule = foregroundFlowableModule;
            }
            Preconditions.checkBuilderRequirement(this.programmaticContextualTriggerFlowableModule, ProgrammaticContextualTriggerFlowableModule.class);
            if (this.analyticsEventsModule == null) {
                analyticsEventsModule = new AnalyticsEventsModule();
                this.analyticsEventsModule = analyticsEventsModule;
            }
            if (this.protoStorageClientModule == null) {
                protoStorageClientModule = new ProtoStorageClientModule();
                this.protoStorageClientModule = protoStorageClientModule;
            }
            if (this.systemClockModule == null) {
                systemClockModule = new SystemClockModule();
                this.systemClockModule = systemClockModule;
            }
            if (this.rateLimitModule == null) {
                rateLimitModule = new RateLimitModule();
                this.rateLimitModule = rateLimitModule;
            }
            Preconditions.checkBuilderRequirement(this.appMeasurementModule, AppMeasurementModule.class);
            super(this.grpcChannelModule, this.schedulerModule, this.applicationModule, this.foregroundFlowableModule, this.programmaticContextualTriggerFlowableModule, this.analyticsEventsModule, this.protoStorageClientModule, this.systemClockModule, this.rateLimitModule, this.appMeasurementModule, 0);
            return daggerUniversalComponent;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder foregroundFlowableModule(ForegroundFlowableModule foregroundFlowableModule) {
            this.foregroundFlowableModule = (ForegroundFlowableModule)Preconditions.checkNotNull(foregroundFlowableModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder grpcChannelModule(GrpcChannelModule grpcChannelModule) {
            this.grpcChannelModule = (GrpcChannelModule)Preconditions.checkNotNull(grpcChannelModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder programmaticContextualTriggerFlowableModule(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
            this.programmaticContextualTriggerFlowableModule = (ProgrammaticContextualTriggerFlowableModule)Preconditions.checkNotNull(programmaticContextualTriggerFlowableModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder protoStorageClientModule(ProtoStorageClientModule protoStorageClientModule) {
            this.protoStorageClientModule = (ProtoStorageClientModule)Preconditions.checkNotNull(protoStorageClientModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder rateLimitModule(RateLimitModule rateLimitModule) {
            this.rateLimitModule = (RateLimitModule)Preconditions.checkNotNull(rateLimitModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder schedulerModule(SchedulerModule schedulerModule) {
            this.schedulerModule = (SchedulerModule)Preconditions.checkNotNull(schedulerModule);
            return this;
        }

        public com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder systemClockModule(SystemClockModule systemClockModule) {
            this.systemClockModule = (SystemClockModule)Preconditions.checkNotNull(systemClockModule);
            return this;
        }
    }
    private DaggerUniversalComponent(GrpcChannelModule grpcChannelModule, SchedulerModule schedulerModule2, ApplicationModule applicationModule3, ForegroundFlowableModule foregroundFlowableModule4, ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule5, AnalyticsEventsModule analyticsEventsModule6, ProtoStorageClientModule protoStorageClientModule7, SystemClockModule systemClockModule8, RateLimitModule rateLimitModule9, AppMeasurementModule appMeasurementModule10) {
        super();
        this.systemClockModule = systemClockModule8;
        this.rateLimitModule = rateLimitModule9;
        initialize(grpcChannelModule, schedulerModule2, applicationModule3, foregroundFlowableModule4, programmaticContextualTriggerFlowableModule5, analyticsEventsModule6, protoStorageClientModule7, systemClockModule8, rateLimitModule9, appMeasurementModule10);
    }

    DaggerUniversalComponent(GrpcChannelModule grpcChannelModule, SchedulerModule schedulerModule2, ApplicationModule applicationModule3, ForegroundFlowableModule foregroundFlowableModule4, ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule5, AnalyticsEventsModule analyticsEventsModule6, ProtoStorageClientModule protoStorageClientModule7, SystemClockModule systemClockModule8, RateLimitModule rateLimitModule9, AppMeasurementModule appMeasurementModule10, com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.1 daggerUniversalComponent$111) {
        super(grpcChannelModule, schedulerModule2, applicationModule3, foregroundFlowableModule4, programmaticContextualTriggerFlowableModule5, analyticsEventsModule6, protoStorageClientModule7, systemClockModule8, rateLimitModule9, appMeasurementModule10);
    }

    public static com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder builder() {
        DaggerUniversalComponent.Builder builder = new DaggerUniversalComponent.Builder(0);
        return builder;
    }

    private void initialize(GrpcChannelModule grpcChannelModule, SchedulerModule schedulerModule2, ApplicationModule applicationModule3, ForegroundFlowableModule foregroundFlowableModule4, ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule5, AnalyticsEventsModule analyticsEventsModule6, ProtoStorageClientModule protoStorageClientModule7, SystemClockModule systemClockModule8, RateLimitModule rateLimitModule9, AppMeasurementModule appMeasurementModule10) {
        a obj9 = DoubleCheck.provider(ApplicationModule_ProvidesApplicationFactory.create(applicationModule3));
        this.providesApplicationProvider = obj9;
        this.providerInstallerProvider = DoubleCheck.provider(ProviderInstaller_Factory.create(obj9));
        obj9 = DoubleCheck.provider(GrpcChannelModule_ProvidesServiceHostFactory.create(grpcChannelModule));
        this.providesServiceHostProvider = obj9;
        this.providesGrpcChannelProvider = DoubleCheck.provider(GrpcChannelModule_ProvidesGrpcChannelFactory.create(grpcChannelModule, obj9));
        this.providesIOSchedulerProvider = DoubleCheck.provider(SchedulerModule_ProvidesIOSchedulerFactory.create(schedulerModule2));
        this.providesComputeSchedulerProvider = DoubleCheck.provider(SchedulerModule_ProvidesComputeSchedulerFactory.create(schedulerModule2));
        a obj1 = DoubleCheck.provider(SchedulerModule_ProvidesMainThreadSchedulerFactory.create(schedulerModule2));
        this.providesMainThreadSchedulerProvider = obj1;
        this.schedulersProvider = DoubleCheck.provider(Schedulers_Factory.create(this.providesIOSchedulerProvider, this.providesComputeSchedulerProvider, obj1));
        this.providesAppForegroundEventStreamProvider = DoubleCheck.provider(ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory.create(foregroundFlowableModule4, this.providesApplicationProvider));
        this.providesProgramaticContextualTriggerStreamProvider = DoubleCheck.provider(ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory.create(programmaticContextualTriggerFlowableModule5));
        this.providesProgramaticContextualTriggersProvider = DoubleCheck.provider(ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory.create(programmaticContextualTriggerFlowableModule5));
        obj1 = DoubleCheck.provider(AppMeasurementModule_ProvidesAnalyticsConnectorFactory.create(appMeasurementModule10));
        this.providesAnalyticsConnectorProvider = obj1;
        obj1 = DoubleCheck.provider(AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory.create(analyticsEventsModule6, obj1));
        this.providesAnalyticsEventsManagerProvider = obj1;
        this.providesAnalyticsConnectorEventsProvider = DoubleCheck.provider(AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory.create(analyticsEventsModule6, obj1));
        this.providesSubsriberProvider = DoubleCheck.provider(AppMeasurementModule_ProvidesSubsriberFactory.create(appMeasurementModule10));
        this.providesProtoStorageClientForCampaignProvider = DoubleCheck.provider(ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory.create(protoStorageClientModule7, this.providesApplicationProvider));
        obj1 = SystemClockModule_ProvidesSystemClockModuleFactory.create(systemClockModule8);
        this.providesSystemClockModuleProvider = obj1;
        this.campaignCacheClientProvider = DoubleCheck.provider(CampaignCacheClient_Factory.create(this.providesProtoStorageClientForCampaignProvider, this.providesApplicationProvider, obj1));
        obj1 = DoubleCheck.provider(ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory.create(protoStorageClientModule7, this.providesApplicationProvider));
        this.providesProtoStorageClientForImpressionStoreProvider = obj1;
        this.impressionStorageClientProvider = DoubleCheck.provider(ImpressionStorageClient_Factory.create(obj1));
        this.protoMarshallerClientProvider = DoubleCheck.provider(ProtoMarshallerClient_Factory.create());
        obj1 = DoubleCheck.provider(ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory.create(protoStorageClientModule7, this.providesApplicationProvider));
        this.providesProtoStorageClientForLimiterStoreProvider = obj1;
        this.rateLimiterClientProvider = DoubleCheck.provider(RateLimiterClient_Factory.create(obj1, this.providesSystemClockModuleProvider));
        this.developerListenerManagerProvider = DoubleCheck.provider(ApplicationModule_DeveloperListenerManagerFactory.create(applicationModule3));
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AnalyticsConnector analyticsConnector() {
        return (AnalyticsConnector)this.providesAnalyticsConnectorProvider.get();
    }

    public a<String> analyticsEventsFlowable() {
        return (a)this.providesAnalyticsConnectorEventsProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AnalyticsEventsManager analyticsEventsManager() {
        return (AnalyticsEventsManager)this.providesAnalyticsEventsManagerProvider.get();
    }

    public a<String> appForegroundEventFlowable() {
        return (a)this.providesAppForegroundEventStreamProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public RateLimit appForegroundRateLimit() {
        return RateLimitModule_ProvidesAppForegroundRateLimitFactory.providesAppForegroundRateLimit(this.rateLimitModule);
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Application application() {
        return (Application)this.providesApplicationProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public CampaignCacheClient campaignCacheClient() {
        return (CampaignCacheClient)this.campaignCacheClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Clock clock() {
        return SystemClockModule_ProvidesSystemClockModuleFactory.providesSystemClockModule(this.systemClockModule);
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public DeveloperListenerManager developerListenerManager() {
        return (DeveloperListenerManager)this.developerListenerManagerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Subscriber firebaseEventsSubscriber() {
        return (Subscriber)this.providesSubsriberProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public e gRPCChannel() {
        return (e)this.providesGrpcChannelProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ImpressionStorageClient impressionStorageClient() {
        return (ImpressionStorageClient)this.impressionStorageClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ProviderInstaller probiderInstaller() {
        return (ProviderInstaller)this.providerInstallerProvider.get();
    }

    public a<String> programmaticContextualTriggerFlowable() {
        return (a)this.providesProgramaticContextualTriggerStreamProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ProgramaticContextualTriggers programmaticContextualTriggers() {
        return (ProgramaticContextualTriggers)this.providesProgramaticContextualTriggersProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ProtoMarshallerClient protoMarshallerClient() {
        return (ProtoMarshallerClient)this.protoMarshallerClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public RateLimiterClient rateLimiterClient() {
        return (RateLimiterClient)this.rateLimiterClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Schedulers schedulers() {
        return (Schedulers)this.schedulersProvider.get();
    }
}
