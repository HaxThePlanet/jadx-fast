package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;

/* loaded from: classes2.dex */
@Component(modules = InflaterModule.class)
public interface InAppMessageComponent {
    public abstract BannerBindingWrapper bannerBindingWrapper();

    public abstract CardBindingWrapper cardBindingWrapper();

    public abstract ImageBindingWrapper imageBindingWrapper();

    public abstract ModalBindingWrapper modalBindingWrapper();
}
