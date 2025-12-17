package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import i.b.z;

/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesMainThreadSchedulerFactory implements Factory<z> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule module;
    public SchedulerModule_ProvidesMainThreadSchedulerFactory(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        super();
        this.module = schedulerModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesMainThreadSchedulerFactory create(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        SchedulerModule_ProvidesMainThreadSchedulerFactory schedulerModule_ProvidesMainThreadSchedulerFactory = new SchedulerModule_ProvidesMainThreadSchedulerFactory(schedulerModule);
        return schedulerModule_ProvidesMainThreadSchedulerFactory;
    }

    public static z providesMainThreadScheduler(com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule schedulerModule) {
        return (z)Preconditions.checkNotNull(schedulerModule.providesMainThreadScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public z get() {
        return SchedulerModule_ProvidesMainThreadSchedulerFactory.providesMainThreadScheduler(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
