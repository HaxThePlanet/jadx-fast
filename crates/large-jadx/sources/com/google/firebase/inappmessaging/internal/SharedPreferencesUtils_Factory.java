package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class SharedPreferencesUtils_Factory implements Factory<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> {

    private final a<FirebaseApp> firebaseAppProvider;
    public SharedPreferencesUtils_Factory(a<FirebaseApp> a) {
        super();
        this.firebaseAppProvider = a;
    }

    public static com.google.firebase.inappmessaging.internal.SharedPreferencesUtils_Factory create(a<FirebaseApp> a) {
        SharedPreferencesUtils_Factory sharedPreferencesUtils_Factory = new SharedPreferencesUtils_Factory(a);
        return sharedPreferencesUtils_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.SharedPreferencesUtils newInstance(FirebaseApp firebaseApp) {
        SharedPreferencesUtils sharedPreferencesUtils = new SharedPreferencesUtils(firebaseApp);
        return sharedPreferencesUtils;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.SharedPreferencesUtils get() {
        return SharedPreferencesUtils_Factory.newInstance((FirebaseApp)this.firebaseAppProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
