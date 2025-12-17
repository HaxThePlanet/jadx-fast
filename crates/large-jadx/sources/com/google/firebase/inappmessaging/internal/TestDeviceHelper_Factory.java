package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class TestDeviceHelper_Factory implements Factory<com.google.firebase.inappmessaging.internal.TestDeviceHelper> {

    private final a<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> sharedPreferencesUtilsProvider;
    public TestDeviceHelper_Factory(a<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> a) {
        super();
        this.sharedPreferencesUtilsProvider = a;
    }

    public static com.google.firebase.inappmessaging.internal.TestDeviceHelper_Factory create(a<com.google.firebase.inappmessaging.internal.SharedPreferencesUtils> a) {
        TestDeviceHelper_Factory testDeviceHelper_Factory = new TestDeviceHelper_Factory(a);
        return testDeviceHelper_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.TestDeviceHelper newInstance(com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils) {
        TestDeviceHelper testDeviceHelper = new TestDeviceHelper(sharedPreferencesUtils);
        return testDeviceHelper;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.TestDeviceHelper get() {
        return TestDeviceHelper_Factory.newInstance((SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
