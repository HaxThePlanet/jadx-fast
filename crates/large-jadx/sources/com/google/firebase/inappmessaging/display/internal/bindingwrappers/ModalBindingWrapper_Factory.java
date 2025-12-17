package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import j.a.a;

/* loaded from: classes2.dex */
public final class ModalBindingWrapper_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper> {

    private final a<InAppMessageLayoutConfig> configProvider;
    private final a<LayoutInflater> inflaterProvider;
    private final a<InAppMessage> messageProvider;
    public ModalBindingWrapper_Factory(a<InAppMessageLayoutConfig> a, a<LayoutInflater> a2, a<InAppMessage> a3) {
        super();
        this.configProvider = a;
        this.inflaterProvider = a2;
        this.messageProvider = a3;
    }

    public static com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper_Factory create(a<InAppMessageLayoutConfig> a, a<LayoutInflater> a2, a<InAppMessage> a3) {
        ModalBindingWrapper_Factory modalBindingWrapper_Factory = new ModalBindingWrapper_Factory(a, a2, a3);
        return modalBindingWrapper_Factory;
    }

    public static com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper newInstance(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater2, InAppMessage inAppMessage3) {
        ModalBindingWrapper modalBindingWrapper = new ModalBindingWrapper(inAppMessageLayoutConfig, layoutInflater2, inAppMessage3);
        return modalBindingWrapper;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper get() {
        return ModalBindingWrapper_Factory.newInstance((InAppMessageLayoutConfig)this.configProvider.get(), (LayoutInflater)this.inflaterProvider.get(), (InAppMessage)this.messageProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
