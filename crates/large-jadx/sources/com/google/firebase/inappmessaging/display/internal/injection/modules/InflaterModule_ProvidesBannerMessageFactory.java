package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class InflaterModule_ProvidesBannerMessageFactory implements Factory<InAppMessage> {

    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule module;
    public InflaterModule_ProvidesBannerMessageFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        super();
        this.module = inflaterModule;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesBannerMessageFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        InflaterModule_ProvidesBannerMessageFactory inflaterModule_ProvidesBannerMessageFactory = new InflaterModule_ProvidesBannerMessageFactory(inflaterModule);
        return inflaterModule_ProvidesBannerMessageFactory;
    }

    public static InAppMessage providesBannerMessage(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        return (InAppMessage)Preconditions.checkNotNull(inflaterModule.providesBannerMessage(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public InAppMessage get() {
        return InflaterModule_ProvidesBannerMessageFactory.providesBannerMessage(this.module);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
