package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import j.a.a;

/* loaded from: classes2.dex */
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory implements Factory<ProtoStorageClient> {

    private final a<Application> applicationProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule module;
    public ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory(com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule protoStorageClientModule, a<Application> a2) {
        super();
        this.module = protoStorageClientModule;
        this.applicationProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule protoStorageClientModule, a<Application> a2) {
        ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory protoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory = new ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory(protoStorageClientModule, a2);
        return protoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory;
    }

    public static ProtoStorageClient providesProtoStorageClientForImpressionStore(com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule protoStorageClientModule, Application application2) {
        return (ProtoStorageClient)Preconditions.checkNotNull(protoStorageClientModule.providesProtoStorageClientForImpressionStore(application2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public ProtoStorageClient get() {
        return ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory.providesProtoStorageClientForImpressionStore(this.module, (Application)this.applicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
