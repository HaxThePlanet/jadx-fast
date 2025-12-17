package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;

/* loaded from: classes2.dex */
@Module
public class ProtoStorageClientModule {

    public static final String CAMPAIGN_CACHE_FILE = "fiam_eligible_campaigns_cache_file";
    public static final String IMPRESSIONS_STORE_FILE = "fiam_impressions_store_file";
    public static final String RATE_LIMIT_STORE_FILE = "rate_limit_store_file";
    @Provides
    @CampaignCache
    public ProtoStorageClient providesProtoStorageClientForCampaign(Application application) {
        ProtoStorageClient protoStorageClient = new ProtoStorageClient(application, "fiam_eligible_campaigns_cache_file");
        return protoStorageClient;
    }

    @Provides
    @ImpressionStore
    public ProtoStorageClient providesProtoStorageClientForImpressionStore(Application application) {
        ProtoStorageClient protoStorageClient = new ProtoStorageClient(application, "fiam_impressions_store_file");
        return protoStorageClient;
    }

    @Provides
    @RateLimit
    public ProtoStorageClient providesProtoStorageClientForLimiterStore(Application application) {
        ProtoStorageClient protoStorageClient = new ProtoStorageClient(application, "rate_limit_store_file");
        return protoStorageClient;
    }
}
