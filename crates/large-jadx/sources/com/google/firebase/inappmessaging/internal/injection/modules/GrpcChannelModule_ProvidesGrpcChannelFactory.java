package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.grpc.e;
import j.a.a;

/* loaded from: classes2.dex */
public final class GrpcChannelModule_ProvidesGrpcChannelFactory implements Factory<e> {

    private final a<String> hostProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule module;
    public GrpcChannelModule_ProvidesGrpcChannelFactory(com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule grpcChannelModule, a<String> a2) {
        super();
        this.module = grpcChannelModule;
        this.hostProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesGrpcChannelFactory create(com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule grpcChannelModule, a<String> a2) {
        GrpcChannelModule_ProvidesGrpcChannelFactory grpcChannelModule_ProvidesGrpcChannelFactory = new GrpcChannelModule_ProvidesGrpcChannelFactory(grpcChannelModule, a2);
        return grpcChannelModule_ProvidesGrpcChannelFactory;
    }

    public static e providesGrpcChannel(com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule grpcChannelModule, String string2) {
        return (e)Preconditions.checkNotNull(grpcChannelModule.providesGrpcChannel(string2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public e get() {
        return GrpcChannelModule_ProvidesGrpcChannelFactory.providesGrpcChannel(this.module, (String)this.hostProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
