package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import j.a.a;

/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesDisplayMetricsFactory implements Factory<DisplayMetrics> {

    private final a<Application> applicationProvider;
    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule module;
    public InflaterConfigModule_ProvidesDisplayMetricsFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<Application> a2) {
        super();
        this.module = inflaterConfigModule;
        this.applicationProvider = a2;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesDisplayMetricsFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<Application> a2) {
        InflaterConfigModule_ProvidesDisplayMetricsFactory inflaterConfigModule_ProvidesDisplayMetricsFactory = new InflaterConfigModule_ProvidesDisplayMetricsFactory(inflaterConfigModule, a2);
        return inflaterConfigModule_ProvidesDisplayMetricsFactory;
    }

    public static DisplayMetrics providesDisplayMetrics(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, Application application2) {
        return (DisplayMetrics)Preconditions.checkNotNull(inflaterConfigModule.providesDisplayMetrics(application2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public DisplayMetrics get() {
        return InflaterConfigModule_ProvidesDisplayMetricsFactory.providesDisplayMetrics(this.module, (Application)this.applicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
