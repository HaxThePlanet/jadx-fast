package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import i.b.z;

/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesComputeSchedulerFactory implements Factory<z> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule module;
    public SchedulerModule_ProvidesComputeSchedulerFactory(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        super();
        this.module = schedulerModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesComputeSchedulerFactory create(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        SchedulerModule_ProvidesComputeSchedulerFactory schedulerModule_ProvidesComputeSchedulerFactory = new SchedulerModule_ProvidesComputeSchedulerFactory(schedulerModule);
        return schedulerModule_ProvidesComputeSchedulerFactory;
    }

    public static z providesComputeScheduler(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        return (z)Preconditions.checkNotNull(schedulerModule.providesComputeScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public z get() {
        return SchedulerModule_ProvidesComputeSchedulerFactory.providesComputeScheduler(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
