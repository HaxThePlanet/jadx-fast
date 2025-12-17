package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class BindingWrapperFactory_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory> {

    private final a<Application> applicationProvider;
    public BindingWrapperFactory_Factory(a<Application> a) {
        super();
        this.applicationProvider = a;
    }

    public static com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory_Factory create(a<Application> a) {
        BindingWrapperFactory_Factory bindingWrapperFactory_Factory = new BindingWrapperFactory_Factory(a);
        return bindingWrapperFactory_Factory;
    }

    public static com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory newInstance(Application application) {
        BindingWrapperFactory bindingWrapperFactory = new BindingWrapperFactory(application);
        return bindingWrapperFactory;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory get() {
        return BindingWrapperFactory_Factory.newInstance((Application)this.applicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
