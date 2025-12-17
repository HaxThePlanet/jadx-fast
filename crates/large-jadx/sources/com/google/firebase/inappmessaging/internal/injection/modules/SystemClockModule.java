package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.internal.time.SystemClock;

/* loaded from: classes2.dex */
@Module
public class SystemClockModule {
    @Provides
    public Clock providesSystemClockModule() {
        SystemClock systemClock = new SystemClock();
        return systemClock;
    }
}
