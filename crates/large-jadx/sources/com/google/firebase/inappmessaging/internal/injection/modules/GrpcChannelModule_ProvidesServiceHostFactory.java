package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class GrpcChannelModule_ProvidesServiceHostFactory implements Factory<String> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule module;
    public GrpcChannelModule_ProvidesServiceHostFactory(com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule grpcChannelModule) {
        super();
        this.module = grpcChannelModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesServiceHostFactory create(com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule grpcChannelModule) {
        GrpcChannelModule_ProvidesServiceHostFactory grpcChannelModule_ProvidesServiceHostFactory = new GrpcChannelModule_ProvidesServiceHostFactory(grpcChannelModule);
        return grpcChannelModule_ProvidesServiceHostFactory;
    }

    public static String providesServiceHost(com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule grpcChannelModule) {
        return (String)Preconditions.checkNotNull(grpcChannelModule.providesServiceHost(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public String get() {
        return GrpcChannelModule_ProvidesServiceHostFactory.providesServiceHost(this.module);
    }
}
