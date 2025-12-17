package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;

/* loaded from: classes2.dex */
public final class InflaterModule_InAppMessageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {

    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule module;
    public InflaterModule_InAppMessageLayoutConfigFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        super();
        this.module = inflaterModule;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_InAppMessageLayoutConfigFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        InflaterModule_InAppMessageLayoutConfigFactory inflaterModule_InAppMessageLayoutConfigFactory = new InflaterModule_InAppMessageLayoutConfigFactory(inflaterModule);
        return inflaterModule_InAppMessageLayoutConfigFactory;
    }

    public static InAppMessageLayoutConfig inAppMessageLayoutConfig(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        return (InAppMessageLayoutConfig)Preconditions.checkNotNull(inflaterModule.inAppMessageLayoutConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public InAppMessageLayoutConfig get() {
        return InflaterModule_InAppMessageLayoutConfigFactory.inAppMessageLayoutConfig(this.module);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
