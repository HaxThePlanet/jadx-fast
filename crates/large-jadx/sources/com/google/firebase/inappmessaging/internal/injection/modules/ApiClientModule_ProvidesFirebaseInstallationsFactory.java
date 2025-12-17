package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.installations.FirebaseInstallationsApi;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule module;
    public ApiClientModule_ProvidesFirebaseInstallationsFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        super();
        this.module = apiClientModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstallationsFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        ApiClientModule_ProvidesFirebaseInstallationsFactory apiClientModule_ProvidesFirebaseInstallationsFactory = new ApiClientModule_ProvidesFirebaseInstallationsFactory(apiClientModule);
        return apiClientModule_ProvidesFirebaseInstallationsFactory;
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        return (FirebaseInstallationsApi)Preconditions.checkNotNull(apiClientModule.providesFirebaseInstallations(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public FirebaseInstallationsApi get() {
        return ApiClientModule_ProvidesFirebaseInstallationsFactory.providesFirebaseInstallations(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
