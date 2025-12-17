package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;

/* loaded from: classes2.dex */
@Module
public class ApplicationModule {

    private final Application application;
    public ApplicationModule(Application application) {
        super();
        this.application = application;
    }

    @Provides
    public Application providesApplication() {
        return this.application;
    }
}
