package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import j.a.a;

/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesDataCollectionHelperFactory implements Factory<DataCollectionHelper> {

    private final a<Subscriber> firebaseEventSubscriberProvider;
    private final com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule module;
    private final a<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
    public ApiClientModule_ProvidesDataCollectionHelperFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, a<SharedPreferencesUtils> a2, a<Subscriber> a3) {
        super();
        this.module = apiClientModule;
        this.sharedPreferencesUtilsProvider = a2;
        this.firebaseEventSubscriberProvider = a3;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, a<SharedPreferencesUtils> a2, a<Subscriber> a3) {
        ApiClientModule_ProvidesDataCollectionHelperFactory apiClientModule_ProvidesDataCollectionHelperFactory = new ApiClientModule_ProvidesDataCollectionHelperFactory(apiClientModule, a2, a3);
        return apiClientModule_ProvidesDataCollectionHelperFactory;
    }

    public static DataCollectionHelper providesDataCollectionHelper(com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule apiClientModule, SharedPreferencesUtils sharedPreferencesUtils2, Subscriber subscriber3) {
        return (DataCollectionHelper)Preconditions.checkNotNull(apiClientModule.providesDataCollectionHelper(sharedPreferencesUtils2, subscriber3), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public DataCollectionHelper get() {
        return ApiClientModule_ProvidesDataCollectionHelperFactory.providesDataCollectionHelper(this.module, (SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get(), (Subscriber)this.firebaseEventSubscriberProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
