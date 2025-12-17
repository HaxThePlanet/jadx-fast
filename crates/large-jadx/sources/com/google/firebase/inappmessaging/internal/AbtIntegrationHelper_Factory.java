package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class AbtIntegrationHelper_Factory implements Factory<com.google.firebase.inappmessaging.internal.AbtIntegrationHelper> {

    private final a<FirebaseABTesting> abTestingProvider;
    public AbtIntegrationHelper_Factory(a<FirebaseABTesting> a) {
        super();
        this.abTestingProvider = a;
    }

    public static com.google.firebase.inappmessaging.internal.AbtIntegrationHelper_Factory create(a<FirebaseABTesting> a) {
        AbtIntegrationHelper_Factory abtIntegrationHelper_Factory = new AbtIntegrationHelper_Factory(a);
        return abtIntegrationHelper_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.AbtIntegrationHelper newInstance(FirebaseABTesting firebaseABTesting) {
        AbtIntegrationHelper abtIntegrationHelper = new AbtIntegrationHelper(firebaseABTesting);
        return abtIntegrationHelper;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.AbtIntegrationHelper get() {
        return AbtIntegrationHelper_Factory.newInstance((FirebaseABTesting)this.abTestingProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
