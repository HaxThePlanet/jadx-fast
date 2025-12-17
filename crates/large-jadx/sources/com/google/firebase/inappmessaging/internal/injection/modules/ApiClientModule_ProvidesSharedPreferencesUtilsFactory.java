package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesSharedPreferencesUtilsFactory implements Factory<SharedPreferencesUtils> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule module;
    public ApiClientModule_ProvidesSharedPreferencesUtilsFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        super();
        this.module = apiClientModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        ApiClientModule_ProvidesSharedPreferencesUtilsFactory apiClientModule_ProvidesSharedPreferencesUtilsFactory = new ApiClientModule_ProvidesSharedPreferencesUtilsFactory(apiClientModule);
        return apiClientModule_ProvidesSharedPreferencesUtilsFactory;
    }

    public static SharedPreferencesUtils providesSharedPreferencesUtils(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule) {
        return (SharedPreferencesUtils)Preconditions.checkNotNull(apiClientModule.providesSharedPreferencesUtils(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public SharedPreferencesUtils get() {
        return ApiClientModule_ProvidesSharedPreferencesUtilsFactory.providesSharedPreferencesUtils(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
