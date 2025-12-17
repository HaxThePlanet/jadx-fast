package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class ProviderInstaller_Factory implements Factory<com.google.firebase.inappmessaging.internal.ProviderInstaller> {

    private final a<Application> applicationProvider;
    public ProviderInstaller_Factory(a<Application> a) {
        super();
        this.applicationProvider = a;
    }

    public static com.google.firebase.inappmessaging.internal.ProviderInstaller_Factory create(a<Application> a) {
        ProviderInstaller_Factory providerInstaller_Factory = new ProviderInstaller_Factory(a);
        return providerInstaller_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.ProviderInstaller newInstance(Application application) {
        ProviderInstaller providerInstaller = new ProviderInstaller(application);
        return providerInstaller;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.ProviderInstaller get() {
        return ProviderInstaller_Factory.newInstance((Application)this.applicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
