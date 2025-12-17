package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class ImpressionStorageClient_Factory implements Factory<com.google.firebase.inappmessaging.internal.ImpressionStorageClient> {

    private final a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> storageClientProvider;
    public ImpressionStorageClient_Factory(a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> a) {
        super();
        this.storageClientProvider = a;
    }

    public static com.google.firebase.inappmessaging.internal.ImpressionStorageClient_Factory create(a<com.google.firebase.inappmessaging.internal.ProtoStorageClient> a) {
        ImpressionStorageClient_Factory impressionStorageClient_Factory = new ImpressionStorageClient_Factory(a);
        return impressionStorageClient_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.ImpressionStorageClient newInstance(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient) {
        ImpressionStorageClient impressionStorageClient = new ImpressionStorageClient(protoStorageClient);
        return impressionStorageClient;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.ImpressionStorageClient get() {
        return ImpressionStorageClient_Factory.newInstance((ProtoStorageClient)this.storageClientProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
