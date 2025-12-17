package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import j.a.a;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesTestDeviceHelperFactory implements Factory<TestDeviceHelper> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule module;
    private final a<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
    public ApiClientModule_ProvidesTestDeviceHelperFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, a<SharedPreferencesUtils> a2) {
        super();
        this.module = apiClientModule;
        this.sharedPreferencesUtilsProvider = a2;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, a<SharedPreferencesUtils> a2) {
        ApiClientModule_ProvidesTestDeviceHelperFactory apiClientModule_ProvidesTestDeviceHelperFactory = new ApiClientModule_ProvidesTestDeviceHelperFactory(apiClientModule, a2);
        return apiClientModule_ProvidesTestDeviceHelperFactory;
    }

    public static TestDeviceHelper providesTestDeviceHelper(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, SharedPreferencesUtils sharedPreferencesUtils2) {
        return (TestDeviceHelper)Preconditions.checkNotNull(apiClientModule.providesTestDeviceHelper(sharedPreferencesUtils2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public TestDeviceHelper get() {
        return ApiClientModule_ProvidesTestDeviceHelperFactory.providesTestDeviceHelper(this.module, (SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
