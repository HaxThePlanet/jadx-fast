package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import j.a.a;

/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {

    private final a<DisplayMetrics> displayMetricsProvider;
    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule module;
    public InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        super();
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = a2;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory inflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory = new InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory(inflaterConfigModule, a2);
        return inflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory;
    }

    public static InAppMessageLayoutConfig providesBannerLandscapeLayoutConfig(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics2) {
        return (InAppMessageLayoutConfig)Preconditions.checkNotNull(inflaterConfigModule.providesBannerLandscapeLayoutConfig(displayMetrics2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public InAppMessageLayoutConfig get() {
        return InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory.providesBannerLandscapeLayoutConfig(this.module, (DisplayMetrics)this.displayMetricsProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
