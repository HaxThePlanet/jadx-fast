package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import j.a.a;

/* loaded from: classes2.dex */
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory implements Factory<ProtoStorageClient> {

    private final a<Application> applicationProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule module;
    public ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule protoStorageClientModule, a<Application> a2) {
        super();
        this.module = protoStorageClientModule;
        this.applicationProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule protoStorageClientModule, a<Application> a2) {
        ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory protoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory = new ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(protoStorageClientModule, a2);
        return protoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory;
    }

    public static ProtoStorageClient providesProtoStorageClientForLimiterStore(com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule protoStorageClientModule, Application application2) {
        return (ProtoStorageClient)Preconditions.checkNotNull(protoStorageClientModule.providesProtoStorageClientForLimiterStore(application2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public ProtoStorageClient get() {
        return ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory.providesProtoStorageClientForLimiterStore(this.module, (Application)this.applicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
