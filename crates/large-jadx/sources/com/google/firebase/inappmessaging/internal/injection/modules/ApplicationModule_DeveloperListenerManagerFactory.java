package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;

/* loaded from: classes2.dex */
public final class ApplicationModule_DeveloperListenerManagerFactory implements Factory<DeveloperListenerManager> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule module;
    public ApplicationModule_DeveloperListenerManagerFactory(com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule applicationModule) {
        super();
        this.module = applicationModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_DeveloperListenerManagerFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule applicationModule) {
        ApplicationModule_DeveloperListenerManagerFactory applicationModule_DeveloperListenerManagerFactory = new ApplicationModule_DeveloperListenerManagerFactory(applicationModule);
        return applicationModule_DeveloperListenerManagerFactory;
    }

    public static DeveloperListenerManager developerListenerManager(com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule applicationModule) {
        return (DeveloperListenerManager)Preconditions.checkNotNull(applicationModule.developerListenerManager(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public DeveloperListenerManager get() {
        return ApplicationModule_DeveloperListenerManagerFactory.developerListenerManager(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
