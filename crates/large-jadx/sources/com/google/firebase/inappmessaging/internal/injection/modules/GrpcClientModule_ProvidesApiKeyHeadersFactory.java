package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.grpc.t0;

/* loaded from: classes2.dex */
public final class GrpcClientModule_ProvidesApiKeyHeadersFactory implements Factory<t0> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule module;
    public GrpcClientModule_ProvidesApiKeyHeadersFactory(com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule grpcClientModule) {
        super();
        this.module = grpcClientModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory create(com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule grpcClientModule) {
        GrpcClientModule_ProvidesApiKeyHeadersFactory grpcClientModule_ProvidesApiKeyHeadersFactory = new GrpcClientModule_ProvidesApiKeyHeadersFactory(grpcClientModule);
        return grpcClientModule_ProvidesApiKeyHeadersFactory;
    }

    public static t0 providesApiKeyHeaders(com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule grpcClientModule) {
        return (t0)Preconditions.checkNotNull(grpcClientModule.providesApiKeyHeaders(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public t0 get() {
        return GrpcClientModule_ProvidesApiKeyHeadersFactory.providesApiKeyHeaders(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
