package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* loaded from: classes2.dex */
public final class SystemClockModule_ProvidesSystemClockModuleFactory implements Factory<Clock> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule module;
    public SystemClockModule_ProvidesSystemClockModuleFactory(com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule systemClockModule) {
        super();
        this.module = systemClockModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule_ProvidesSystemClockModuleFactory create(com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule systemClockModule) {
        SystemClockModule_ProvidesSystemClockModuleFactory systemClockModule_ProvidesSystemClockModuleFactory = new SystemClockModule_ProvidesSystemClockModuleFactory(systemClockModule);
        return systemClockModule_ProvidesSystemClockModuleFactory;
    }

    public static Clock providesSystemClockModule(com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule systemClockModule) {
        return (Clock)Preconditions.checkNotNull(systemClockModule.providesSystemClockModule(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Clock get() {
        return SystemClockModule_ProvidesSystemClockModuleFactory.providesSystemClockModule(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
