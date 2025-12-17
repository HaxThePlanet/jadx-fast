package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class InflaterModule_ProvidesInflaterserviceFactory implements Factory<LayoutInflater> {

    private final com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule module;
    public InflaterModule_ProvidesInflaterserviceFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        super();
        this.module = inflaterModule;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesInflaterserviceFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        InflaterModule_ProvidesInflaterserviceFactory inflaterModule_ProvidesInflaterserviceFactory = new InflaterModule_ProvidesInflaterserviceFactory(inflaterModule);
        return inflaterModule_ProvidesInflaterserviceFactory;
    }

    public static LayoutInflater providesInflaterservice(com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule inflaterModule) {
        return (LayoutInflater)Preconditions.checkNotNull(inflaterModule.providesInflaterservice(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public LayoutInflater get() {
        return InflaterModule_ProvidesInflaterserviceFactory.providesInflaterservice(this.module);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
