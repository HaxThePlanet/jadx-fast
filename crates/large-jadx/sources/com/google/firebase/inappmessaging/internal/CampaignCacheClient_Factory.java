package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import j.a.a;

/* loaded from: classes2.dex */
public final class CampaignCacheClient_Factory implements Factory<com.google.firebase.inappmessaging.internal.CampaignCacheClient> {

    private final a<Application> applicationProvider;
    private final a<Clock> clockProvider;
    private final a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> storageClientProvider;
    public CampaignCacheClient_Factory(a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> a, a<Application> a2, a<Clock> a3) {
        super();
        this.storageClientProvider = a;
        this.applicationProvider = a2;
        this.clockProvider = a3;
    }

    public static com.google.firebase.inappmessaging.internal.CampaignCacheClient_Factory create(a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> a, a<Application> a2, a<Clock> a3) {
        CampaignCacheClient_Factory campaignCacheClient_Factory = new CampaignCacheClient_Factory(a, a2, a3);
        return campaignCacheClient_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.CampaignCacheClient newInstance(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient, Application application2, Clock clock3) {
        CampaignCacheClient campaignCacheClient = new CampaignCacheClient(protoStorageClient, application2, clock3);
        return campaignCacheClient;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.CampaignCacheClient get() {
        return CampaignCacheClient_Factory.newInstance((ProtoStorageClient)this.storageClientProvider.get(), (Application)this.applicationProvider.get(), (Clock)this.clockProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
