package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidesApplicationFactory implements Factory<Application> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule module;
    public ApplicationModule_ProvidesApplicationFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule applicationModule) {
        super();
        this.module = applicationModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule applicationModule) {
        ApplicationModule_ProvidesApplicationFactory applicationModule_ProvidesApplicationFactory = new ApplicationModule_ProvidesApplicationFactory(applicationModule);
        return applicationModule_ProvidesApplicationFactory;
    }

    public static Application providesApplication(com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule applicationModule) {
        return (Application)Preconditions.checkNotNull(applicationModule.providesApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Application get() {
        return ApplicationModule_ProvidesApplicationFactory.providesApplication(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
