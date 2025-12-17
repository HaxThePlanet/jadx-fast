package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import j.a.a;

/* loaded from: classes2.dex */
public final class RateLimiterClient_Factory implements Factory<com.google.firebase.inappmessaging.internal.RateLimiterClient> {

    private final a<Clock> clockProvider;
    private final a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> storageClientProvider;
    public RateLimiterClient_Factory(a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> a, a<Clock> a2) {
        super();
        this.storageClientProvider = a;
        this.clockProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.RateLimiterClient_Factory create(a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> a, a<Clock> a2) {
        RateLimiterClient_Factory rateLimiterClient_Factory = new RateLimiterClient_Factory(a, a2);
        return rateLimiterClient_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.RateLimiterClient newInstance(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient, Clock clock2) {
        RateLimiterClient rateLimiterClient = new RateLimiterClient(protoStorageClient, clock2);
        return rateLimiterClient;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.RateLimiterClient get() {
        return RateLimiterClient_Factory.newInstance((ProtoStorageClient)this.storageClientProvider.get(), (Clock)this.clockProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
