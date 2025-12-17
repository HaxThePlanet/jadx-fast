package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import j.a.a;

/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesModalLandscapeConfigFactory implements Factory<InAppMessageLayoutConfig> {

    private final a<DisplayMetrics> displayMetricsProvider;
    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule module;
    public InflaterConfigModule_ProvidesModalLandscapeConfigFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        super();
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = a2;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalLandscapeConfigFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        InflaterConfigModule_ProvidesModalLandscapeConfigFactory inflaterConfigModule_ProvidesModalLandscapeConfigFactory = new InflaterConfigModule_ProvidesModalLandscapeConfigFactory(inflaterConfigModule, a2);
        return inflaterConfigModule_ProvidesModalLandscapeConfigFactory;
    }

    public static InAppMessageLayoutConfig providesModalLandscapeConfig(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics2) {
        return (InAppMessageLayoutConfig)Preconditions.checkNotNull(inflaterConfigModule.providesModalLandscapeConfig(displayMetrics2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public InAppMessageLayoutConfig get() {
        return InflaterConfigModule_ProvidesModalLandscapeConfigFactory.providesModalLandscapeConfig(this.module, (DisplayMetrics)this.displayMetricsProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
