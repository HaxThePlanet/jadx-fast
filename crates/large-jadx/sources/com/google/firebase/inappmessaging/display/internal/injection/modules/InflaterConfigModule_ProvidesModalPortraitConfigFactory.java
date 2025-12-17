package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import j.a.a;

/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesModalPortraitConfigFactory implements Factory<InAppMessageLayoutConfig> {

    private final a<DisplayMetrics> displayMetricsProvider;
    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule module;
    public InflaterConfigModule_ProvidesModalPortraitConfigFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        super();
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = a2;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalPortraitConfigFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, a<DisplayMetrics> a2) {
        InflaterConfigModule_ProvidesModalPortraitConfigFactory inflaterConfigModule_ProvidesModalPortraitConfigFactory = new InflaterConfigModule_ProvidesModalPortraitConfigFactory(inflaterConfigModule, a2);
        return inflaterConfigModule_ProvidesModalPortraitConfigFactory;
    }

    public static InAppMessageLayoutConfig providesModalPortraitConfig(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics2) {
        return (InAppMessageLayoutConfig)Preconditions.checkNotNull(inflaterConfigModule.providesModalPortraitConfig(displayMetrics2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public InAppMessageLayoutConfig get() {
        return InflaterConfigModule_ProvidesModalPortraitConfigFactory.providesModalPortraitConfig(this.module, (DisplayMetrics)this.displayMetricsProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
