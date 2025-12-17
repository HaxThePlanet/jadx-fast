package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.installations.FirebaseInstallationsApi;
import i.b.k0.a;
import j.a.a;

/* loaded from: classes2.dex */
public final class InAppMessageStreamManager_Factory implements Factory<com.google.firebase.inappmessaging.internal.InAppMessageStreamManager> {

    private final a<com.google.firebase.inappmessaging.internal.AbtIntegrationHelper> abtIntegrationHelperProvider;
    private final a<com.google.firebase.inappmessaging.internal.AnalyticsEventsManager> analyticsEventsManagerProvider;
    private final a<com.google.firebase.inappmessaging.internal.ApiClient> apiClientProvider;
    private final a<a<String>> appForegroundEventFlowableProvider;
    private final a<RateLimit> appForegroundRateLimitProvider;
    private final a<com.google.firebase.inappmessaging.internal.CampaignCacheClient> campaignCacheClientProvider;
    private final a<Clock> clockProvider;
    private final a<com.google.firebase.inappmessaging.internal.DataCollectionHelper> dataCollectionHelperProvider;
    private final a<FirebaseInstallationsApi> firebaseInstallationsProvider;
    private final a<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> impressionStorageClientProvider;
    private final a<a<String>> programmaticTriggerEventFlowableProvider;
    private final a<com.google.firebase.inappmessaging.internal.RateLimiterClient> rateLimiterClientProvider;
    private final a<com.google.firebase.inappmessaging.internal.Schedulers> schedulersProvider;
    private final a<com.google.firebase.inappmessaging.internal.TestDeviceHelper> testDeviceHelperProvider;
    public InAppMessageStreamManager_Factory(a<a<String>> a, a<a<String>> a2, a<com.google.firebase.inappmessaging.internal.CampaignCacheClient> a3, a<Clock> a4, a<com.google.firebase.inappmessaging.internal.ApiClient> a5, a<com.google.firebase.inappmessaging.internal.AnalyticsEventsManager> a6, a<com.google.firebase.inappmessaging.internal.Schedulers> a7, a<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> a8, a<com.google.firebase.inappmessaging.internal.RateLimiterClient> a9, a<RateLimit> a10, a<com.google.firebase.inappmessaging.internal.TestDeviceHelper> a11, a<FirebaseInstallationsApi> a12, a<com.google.firebase.inappmessaging.internal.DataCollectionHelper> a13, a<com.google.firebase.inappmessaging.internal.AbtIntegrationHelper> a14) {
        super();
        this.appForegroundEventFlowableProvider = a;
        this.programmaticTriggerEventFlowableProvider = a2;
        this.campaignCacheClientProvider = a3;
        this.clockProvider = a4;
        this.apiClientProvider = a5;
        this.analyticsEventsManagerProvider = a6;
        this.schedulersProvider = a7;
        this.impressionStorageClientProvider = a8;
        this.rateLimiterClientProvider = a9;
        this.appForegroundRateLimitProvider = a10;
        this.testDeviceHelperProvider = a11;
        this.firebaseInstallationsProvider = a12;
        this.dataCollectionHelperProvider = a13;
        this.abtIntegrationHelperProvider = a14;
    }

    public static com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory create(a<a<String>> a, a<a<String>> a2, a<com.google.firebase.inappmessaging.internal.CampaignCacheClient> a3, a<Clock> a4, a<com.google.firebase.inappmessaging.internal.ApiClient> a5, a<com.google.firebase.inappmessaging.internal.AnalyticsEventsManager> a6, a<com.google.firebase.inappmessaging.internal.Schedulers> a7, a<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> a8, a<com.google.firebase.inappmessaging.internal.RateLimiterClient> a9, a<RateLimit> a10, a<com.google.firebase.inappmessaging.internal.TestDeviceHelper> a11, a<FirebaseInstallationsApi> a12, a<com.google.firebase.inappmessaging.internal.DataCollectionHelper> a13, a<com.google.firebase.inappmessaging.internal.AbtIntegrationHelper> a14) {
        super(a, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
        return inAppMessageStreamManager_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.InAppMessageStreamManager newInstance(a<String> a, a<String> a2, com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient3, Clock clock4, com.google.firebase.inappmessaging.internal.ApiClient apiClient5, com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager6, com.google.firebase.inappmessaging.internal.Schedulers schedulers7, com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient8, com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient9, RateLimit rateLimit10, com.google.firebase.inappmessaging.internal.TestDeviceHelper testDeviceHelper11, FirebaseInstallationsApi firebaseInstallationsApi12, com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper13, com.google.firebase.inappmessaging.internal.AbtIntegrationHelper abtIntegrationHelper14) {
        super(a, a2, campaignCacheClient3, clock4, apiClient5, analyticsEventsManager6, schedulers7, impressionStorageClient8, rateLimiterClient9, rateLimit10, testDeviceHelper11, firebaseInstallationsApi12, dataCollectionHelper13, abtIntegrationHelper14);
        return inAppMessageStreamManager;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.InAppMessageStreamManager get() {
        return InAppMessageStreamManager_Factory.newInstance((a)this.appForegroundEventFlowableProvider.get(), (a)this.programmaticTriggerEventFlowableProvider.get(), (CampaignCacheClient)this.campaignCacheClientProvider.get(), (Clock)this.clockProvider.get(), (ApiClient)this.apiClientProvider.get(), (AnalyticsEventsManager)this.analyticsEventsManagerProvider.get(), (Schedulers)this.schedulersProvider.get(), (ImpressionStorageClient)this.impressionStorageClientProvider.get(), (RateLimiterClient)this.rateLimiterClientProvider.get(), (RateLimit)this.appForegroundRateLimitProvider.get(), (TestDeviceHelper)this.testDeviceHelperProvider.get(), (FirebaseInstallationsApi)this.firebaseInstallationsProvider.get(), (DataCollectionHelper)this.dataCollectionHelperProvider.get(), (AbtIntegrationHelper)this.abtIntegrationHelperProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
