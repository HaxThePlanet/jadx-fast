package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import i.b.k0.a;

/* loaded from: classes2.dex */
@Module
public class ForegroundFlowableModule {
    @Provides
    @AppForeground
    public a<String> providesAppForegroundEventStream(Application application) {
        ForegroundNotifier foregroundNotifier = new ForegroundNotifier();
        final a foregroundFlowable = foregroundNotifier.foregroundFlowable();
        foregroundFlowable.g0();
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        return foregroundFlowable;
    }
}
