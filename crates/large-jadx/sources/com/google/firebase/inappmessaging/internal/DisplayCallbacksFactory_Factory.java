package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import j.a.a;

/* loaded from: classes2.dex */
public final class DisplayCallbacksFactory_Factory implements Factory<com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory> {

    private final a<RateLimit> appForegroundRateLimitProvider;
    private final a<com.google.firebase.inappmessaging.internal.CampaignCacheClient> campaignCacheClientProvider;
    private final a<Clock> clockProvider;
    private final a<com.google.firebase.inappmessaging.internal.DataCollectionHelper> dataCollectionHelperProvider;
    private final a<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> impressionStorageClientProvider;
    private final a<com.google.firebase.inappmessaging.internal.MetricsLoggerClient> metricsLoggerClientProvider;
    private final a<com.google.firebase.inappmessaging.internal.RateLimiterClient> rateLimiterClientProvider;
    private final a<com.google.firebase.inappmessaging.internal.Schedulers> schedulersProvider;
    public DisplayCallbacksFactory_Factory(a<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> a, a<Clock> a2, a<com.google.firebase.inappmessaging.internal.Schedulers> a3, a<com.google.firebase.inappmessaging.internal.RateLimiterClient> a4, a<com.google.firebase.inappmessaging.internal.CampaignCacheClient> a5, a<RateLimit> a6, a<com.google.firebase.inappmessaging.internal.MetricsLoggerClient> a7, a<com.google.firebase.inappmessaging.internal.DataCollectionHelper> a8) {
        super();
        this.impressionStorageClientProvider = a;
        this.clockProvider = a2;
        this.schedulersProvider = a3;
        this.rateLimiterClientProvider = a4;
        this.campaignCacheClientProvider = a5;
        this.appForegroundRateLimitProvider = a6;
        this.metricsLoggerClientProvider = a7;
        this.dataCollectionHelperProvider = a8;
    }

    public static com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory create(a<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> a, a<Clock> a2, a<com.google.firebase.inappmessaging.internal.Schedulers> a3, a<com.google.firebase.inappmessaging.internal.RateLimiterClient> a4, a<com.google.firebase.inappmessaging.internal.CampaignCacheClient> a5, a<RateLimit> a6, a<com.google.firebase.inappmessaging.internal.MetricsLoggerClient> a7, a<com.google.firebase.inappmessaging.internal.DataCollectionHelper> a8) {
        super(a, a2, a3, a4, a5, a6, a7, a8);
        return displayCallbacksFactory_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory newInstance(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, Clock clock2, com.google.firebase.inappmessaging.internal.Schedulers schedulers3, com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient4, com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient5, RateLimit rateLimit6, com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient7, com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper8) {
        super(impressionStorageClient, clock2, schedulers3, rateLimiterClient4, campaignCacheClient5, rateLimit6, metricsLoggerClient7, dataCollectionHelper8);
        return displayCallbacksFactory;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory get() {
        return DisplayCallbacksFactory_Factory.newInstance((ImpressionStorageClient)this.impressionStorageClientProvider.get(), (Clock)this.clockProvider.get(), (Schedulers)this.schedulersProvider.get(), (RateLimiterClient)this.rateLimiterClientProvider.get(), (CampaignCacheClient)this.campaignCacheClientProvider.get(), (RateLimit)this.appForegroundRateLimitProvider.get(), (MetricsLoggerClient)this.metricsLoggerClientProvider.get(), (DataCollectionHelper)this.dataCollectionHelperProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
