package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Lazy;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;

/* loaded from: classes2.dex */
@Module
public class ApiClientModule {

    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    public ApiClientModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi2, Clock clock3) {
        super();
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi2;
        this.clock = clock3;
    }

    @Provides
    ApiClient providesApiClient(Lazy<GrpcClient> lazy, Application application2, ProviderInstaller providerInstaller3) {
        super(lazy, this.firebaseApp, application2, this.clock, providerInstaller3);
        return apiClient;
    }

    @Provides
    DataCollectionHelper providesDataCollectionHelper(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber2) {
        DataCollectionHelper dataCollectionHelper = new DataCollectionHelper(this.firebaseApp, sharedPreferencesUtils, subscriber2);
        return dataCollectionHelper;
    }

    @Provides
    FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    @Provides
    FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    @Provides
    SharedPreferencesUtils providesSharedPreferencesUtils() {
        SharedPreferencesUtils sharedPreferencesUtils = new SharedPreferencesUtils(this.firebaseApp);
        return sharedPreferencesUtils;
    }

    @Provides
    TestDeviceHelper providesTestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        TestDeviceHelper testDeviceHelper = new TestDeviceHelper(sharedPreferencesUtils);
        return testDeviceHelper;
    }
}
