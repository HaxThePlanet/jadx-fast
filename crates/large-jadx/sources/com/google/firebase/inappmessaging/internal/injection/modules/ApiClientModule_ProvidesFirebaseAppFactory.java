package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule module;
    public ApiClientModule_ProvidesFirebaseAppFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        super();
        this.module = apiClientModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseAppFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        ApiClientModule_ProvidesFirebaseAppFactory apiClientModule_ProvidesFirebaseAppFactory = new ApiClientModule_ProvidesFirebaseAppFactory(apiClientModule);
        return apiClientModule_ProvidesFirebaseAppFactory;
    }

    public static FirebaseApp providesFirebaseApp(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        return (FirebaseApp)Preconditions.checkNotNull(apiClientModule.providesFirebaseApp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public FirebaseApp get() {
        return ApiClientModule_ProvidesFirebaseAppFactory.providesFirebaseApp(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
