package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import i.b.i0.b.a;
import i.b.s0.a;
import i.b.z;

/* loaded from: classes2.dex */
@Module
public class SchedulerModule {
    @Provides
    public z providesComputeScheduler() {
        return a.a();
    }

    @Provides
    public z providesIOScheduler() {
        return a.b();
    }

    @Provides
    public z providesMainThreadScheduler() {
        return a.a();
    }
}
