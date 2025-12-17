package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Lazy;
import com.google.firebase.inappmessaging.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import j.a.a;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesApiClientFactory implements Factory<ApiClient> {

    private final a<Application> applicationProvider;
    private final a<GrpcClient> grpcClientProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule module;
    private final a<ProviderInstaller> providerInstallerProvider;
    public ApiClientModule_ProvidesApiClientFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, a<GrpcClient> a2, a<Application> a3, a<ProviderInstaller> a4) {
        super();
        this.module = apiClientModule;
        this.grpcClientProvider = a2;
        this.applicationProvider = a3;
        this.providerInstallerProvider = a4;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, a<GrpcClient> a2, a<Application> a3, a<ProviderInstaller> a4) {
        ApiClientModule_ProvidesApiClientFactory apiClientModule_ProvidesApiClientFactory = new ApiClientModule_ProvidesApiClientFactory(apiClientModule, a2, a3, a4);
        return apiClientModule_ProvidesApiClientFactory;
    }

    public static ApiClient providesApiClient(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, Lazy<GrpcClient> lazy2, Application application3, ProviderInstaller providerInstaller4) {
        return (ApiClient)Preconditions.checkNotNull(apiClientModule.providesApiClient(lazy2, application3, providerInstaller4), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public ApiClient get() {
        return ApiClientModule_ProvidesApiClientFactory.providesApiClient(this.module, DoubleCheck.lazy(this.grpcClientProvider), (Application)this.applicationProvider.get(), (ProviderInstaller)this.providerInstallerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
