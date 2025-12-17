package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;

/* loaded from: classes2.dex */
public class DisplayCallbacksFactory {

    private final RateLimit appForegroundRateLimit;
    private final com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper;
    private final com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient;
    private final com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient;
    private final com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient;
    private final com.google.firebase.inappmessaging.internal.Schedulers schedulers;
    public DisplayCallbacksFactory(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, Clock clock2, com.google.firebase.inappmessaging.internal.Schedulers schedulers3, com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient4, com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient5, RateLimit rateLimit6, com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient7, com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper8) {
        super();
        this.impressionStorageClient = impressionStorageClient;
        this.clock = clock2;
        this.schedulers = schedulers3;
        this.rateLimiterClient = rateLimiterClient4;
        this.campaignCacheClient = campaignCacheClient5;
        this.appForegroundRateLimit = rateLimit6;
        this.metricsLoggerClient = metricsLoggerClient7;
        this.dataCollectionHelper = dataCollectionHelper8;
    }

    public FirebaseInAppMessagingDisplayCallbacks generateDisplayCallback(InAppMessage inAppMessage, String string2) {
        super(this.impressionStorageClient, this.clock, this.schedulers, this.rateLimiterClient, this.campaignCacheClient, this.appForegroundRateLimit, this.metricsLoggerClient, this.dataCollectionHelper, inAppMessage, string2);
        return displayCallbacksImpl2;
    }
}
