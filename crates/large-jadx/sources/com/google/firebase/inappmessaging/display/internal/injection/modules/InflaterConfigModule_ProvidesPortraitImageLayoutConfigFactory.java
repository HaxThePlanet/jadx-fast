package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import j.a.a;

/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {

    private final a<DisplayMetrics> displayMetricsProvider;
    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule module;
    public InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        super();
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = a2;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory inflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory = new InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(inflaterConfigModule, a2);
        return inflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory;
    }

    public static InAppMessageLayoutConfig providesPortraitImageLayoutConfig(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics2) {
        return (InAppMessageLayoutConfig)Preconditions.checkNotNull(inflaterConfigModule.providesPortraitImageLayoutConfig(displayMetrics2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public InAppMessageLayoutConfig get() {
        return InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory.providesPortraitImageLayoutConfig(this.module, (DisplayMetrics)this.displayMetricsProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
