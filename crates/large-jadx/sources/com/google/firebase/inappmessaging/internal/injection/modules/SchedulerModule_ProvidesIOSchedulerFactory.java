package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import i.b.z;

/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesIOSchedulerFactory implements Factory<z> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule module;
    public SchedulerModule_ProvidesIOSchedulerFactory(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        super();
        this.module = schedulerModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesIOSchedulerFactory create(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        SchedulerModule_ProvidesIOSchedulerFactory schedulerModule_ProvidesIOSchedulerFactory = new SchedulerModule_ProvidesIOSchedulerFactory(schedulerModule);
        return schedulerModule_ProvidesIOSchedulerFactory;
    }

    public static z providesIOScheduler(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        return (z)Preconditions.checkNotNull(schedulerModule.providesIOScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public z get() {
        return SchedulerModule_ProvidesIOSchedulerFactory.providesIOScheduler(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
