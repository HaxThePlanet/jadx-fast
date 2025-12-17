package com.google.firebase.inappmessaging.display;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import j.a.a;
import java.util.Map;

/* loaded from: classes2.dex */
public final class FirebaseInAppMessagingDisplay_Factory implements Factory<com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay> {

    private final a<FiamAnimator> animatorProvider;
    private final a<Application> applicationProvider;
    private final a<RenewableTimer> autoDismissTimerProvider;
    private final a<BindingWrapperFactory> bindingWrapperFactoryProvider;
    private final a<FirebaseInAppMessaging> headlessInAppMessagingProvider;
    private final a<FiamImageLoader> imageLoaderProvider;
    private final a<RenewableTimer> impressionTimerProvider;
    private final a<Map<String, a<InAppMessageLayoutConfig>>> layoutConfigsProvider;
    private final a<FiamWindowManager> windowManagerProvider;
    public FirebaseInAppMessagingDisplay_Factory(a<FirebaseInAppMessaging> a, a<Map<String, a<InAppMessageLayoutConfig>>> a2, a<FiamImageLoader> a3, a<RenewableTimer> a4, a<RenewableTimer> a5, a<FiamWindowManager> a6, a<Application> a7, a<BindingWrapperFactory> a8, a<FiamAnimator> a9) {
        super();
        this.headlessInAppMessagingProvider = a;
        this.layoutConfigsProvider = a2;
        this.imageLoaderProvider = a3;
        this.impressionTimerProvider = a4;
        this.autoDismissTimerProvider = a5;
        this.windowManagerProvider = a6;
        this.applicationProvider = a7;
        this.bindingWrapperFactoryProvider = a8;
        this.animatorProvider = a9;
    }

    public static com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay_Factory create(a<FirebaseInAppMessaging> a, a<Map<String, a<InAppMessageLayoutConfig>>> a2, a<FiamImageLoader> a3, a<RenewableTimer> a4, a<RenewableTimer> a5, a<FiamWindowManager> a6, a<Application> a7, a<BindingWrapperFactory> a8, a<FiamAnimator> a9) {
        super(a, a2, a3, a4, a5, a6, a7, a8, a9);
        return firebaseInAppMessagingDisplay_Factory;
    }

    public static com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay newInstance(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, a<InAppMessageLayoutConfig>> map2, FiamImageLoader fiamImageLoader3, RenewableTimer renewableTimer4, RenewableTimer renewableTimer5, FiamWindowManager fiamWindowManager6, Application application7, BindingWrapperFactory bindingWrapperFactory8, FiamAnimator fiamAnimator9) {
        super(firebaseInAppMessaging, map2, fiamImageLoader3, renewableTimer4, renewableTimer5, fiamWindowManager6, application7, bindingWrapperFactory8, fiamAnimator9);
        return firebaseInAppMessagingDisplay2;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay get() {
        return FirebaseInAppMessagingDisplay_Factory.newInstance((FirebaseInAppMessaging)this.headlessInAppMessagingProvider.get(), (Map)this.layoutConfigsProvider.get(), (FiamImageLoader)this.imageLoaderProvider.get(), (RenewableTimer)this.impressionTimerProvider.get(), (RenewableTimer)this.autoDismissTimerProvider.get(), (FiamWindowManager)this.windowManagerProvider.get(), (Application)this.applicationProvider.get(), (BindingWrapperFactory)this.bindingWrapperFactoryProvider.get(), (FiamAnimator)this.animatorProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
