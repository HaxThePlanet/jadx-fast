package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import f.c.f.a.a.a.e.g.b;
import io.grpc.e;
import io.grpc.t0;
import j.a.a;

/* loaded from: classes2.dex */
public final class GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory implements Factory<g.b> {

    private final a<e> channelProvider;
    private final a<t0> metadataProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule module;
    public GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule grpcClientModule, a<e> a2, a<t0> a3) {
        super();
        this.module = grpcClientModule;
        this.channelProvider = a2;
        this.metadataProvider = a3;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory create(com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule grpcClientModule, a<e> a2, a<t0> a3) {
        GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory grpcClientModule_ProvidesInAppMessagingSdkServingStubFactory = new GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(grpcClientModule, a2, a3);
        return grpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
    }

    public static g.b providesInAppMessagingSdkServingStub(com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule grpcClientModule, e e2, t0 t03) {
        return (g.b)Preconditions.checkNotNull(grpcClientModule.providesInAppMessagingSdkServingStub(e2, t03), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public g.b get() {
        return GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.providesInAppMessagingSdkServingStub(this.module, (e)this.channelProvider.get(), (t0)this.metadataProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
