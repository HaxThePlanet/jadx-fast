package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class DataCollectionHelper_Factory implements Factory<com.google.firebase.inappmessaging.internal.DataCollectionHelper> {

    private final a<FirebaseApp> firebaseAppProvider;
    private final a<Subscriber> firebaseEventsSubscriberProvider;
    private final a<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> sharedPreferencesUtilsProvider;
    public DataCollectionHelper_Factory(a<FirebaseApp> a, a<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> a2, a<Subscriber> a3) {
        super();
        this.firebaseAppProvider = a;
        this.sharedPreferencesUtilsProvider = a2;
        this.firebaseEventsSubscriberProvider = a3;
    }

    public static com.google.firebase.inappmessaging.internal.DataCollectionHelper_Factory create(a<FirebaseApp> a, a<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> a2, a<Subscriber> a3) {
        DataCollectionHelper_Factory dataCollectionHelper_Factory = new DataCollectionHelper_Factory(a, a2, a3);
        return dataCollectionHelper_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.DataCollectionHelper newInstance(FirebaseApp firebaseApp, com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils2, Subscriber subscriber3) {
        DataCollectionHelper dataCollectionHelper = new DataCollectionHelper(firebaseApp, sharedPreferencesUtils2, subscriber3);
        return dataCollectionHelper;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.DataCollectionHelper get() {
        return DataCollectionHelper_Factory.newInstance((FirebaseApp)this.firebaseAppProvider.get(), (SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get(), (Subscriber)this.firebaseEventsSubscriberProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
