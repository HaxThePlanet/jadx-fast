package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerInAppMessageComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerInAppMessageComponent.Builder;
import com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public class BindingWrapperFactory {

    private final Application application;
    BindingWrapperFactory(Application application) {
        super();
        this.application = application;
    }

    public BindingWrapper createBannerBindingWrapper(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage2) {
        InflaterModule inflaterModule = new InflaterModule(inAppMessage2, inAppMessageLayoutConfig, this.application);
        return DaggerInAppMessageComponent.builder().inflaterModule(inflaterModule).build().bannerBindingWrapper();
    }

    public BindingWrapper createCardBindingWrapper(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage2) {
        InflaterModule inflaterModule = new InflaterModule(inAppMessage2, inAppMessageLayoutConfig, this.application);
        return DaggerInAppMessageComponent.builder().inflaterModule(inflaterModule).build().cardBindingWrapper();
    }

    public BindingWrapper createImageBindingWrapper(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage2) {
        InflaterModule inflaterModule = new InflaterModule(inAppMessage2, inAppMessageLayoutConfig, this.application);
        return DaggerInAppMessageComponent.builder().inflaterModule(inflaterModule).build().imageBindingWrapper();
    }

    public BindingWrapper createModalBindingWrapper(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage2) {
        InflaterModule inflaterModule = new InflaterModule(inAppMessage2, inAppMessageLayoutConfig, this.application);
        return DaggerInAppMessageComponent.builder().inflaterModule(inflaterModule).build().modalBindingWrapper();
    }
}
