package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;

/* loaded from: classes2.dex */
@Module
public class ApplicationModule {

    private final Application application;
    public ApplicationModule(Application application) {
        super();
        this.application = application;
    }

    @Provides
    public DeveloperListenerManager developerListenerManager() {
        DeveloperListenerManager developerListenerManager = new DeveloperListenerManager();
        return developerListenerManager;
    }

    @Provides
    public Application providesApplication() {
        return this.application;
    }
}
