package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Component;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import i.b.k0.a;
import io.grpc.e;

/* loaded from: classes2.dex */
@Component(modules = {GrpcChannelModule.class, SchedulerModule.class, ApplicationModule.class, ForegroundFlowableModule.class, ProgrammaticContextualTriggerFlowableModule.class, AnalyticsEventsModule.class, ProtoStorageClientModule.class, SystemClockModule.class, RateLimitModule.class, AppMeasurementModule.class})
public interface UniversalComponent {
    public abstract AnalyticsConnector analyticsConnector();

    @AnalyticsListener
    public abstract a<String> analyticsEventsFlowable();

    public abstract AnalyticsEventsManager analyticsEventsManager();

    @AppForeground
    public abstract a<String> appForegroundEventFlowable();

    @AppForeground
    public abstract RateLimit appForegroundRateLimit();

    public abstract Application application();

    public abstract CampaignCacheClient campaignCacheClient();

    public abstract Clock clock();

    public abstract DeveloperListenerManager developerListenerManager();

    public abstract Subscriber firebaseEventsSubscriber();

    public abstract e gRPCChannel();

    public abstract ImpressionStorageClient impressionStorageClient();

    public abstract ProviderInstaller probiderInstaller();

    @ProgrammaticTrigger
    public abstract a<String> programmaticContextualTriggerFlowable();

    @ProgrammaticTrigger
    public abstract ProgramaticContextualTriggers programmaticContextualTriggers();

    public abstract ProtoMarshallerClient protoMarshallerClient();

    public abstract RateLimiterClient rateLimiterClient();

    public abstract Schedulers schedulers();
}
