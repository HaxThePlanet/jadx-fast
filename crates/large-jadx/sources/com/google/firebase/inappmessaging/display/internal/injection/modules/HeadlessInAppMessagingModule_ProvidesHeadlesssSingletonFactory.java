package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory implements Factory<FirebaseInAppMessaging> {

    private final com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule module;
    public HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        super();
        this.module = headlessInAppMessagingModule;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory headlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory = new HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(headlessInAppMessagingModule);
        return headlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory;
    }

    public static FirebaseInAppMessaging providesHeadlesssSingleton(com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        return (FirebaseInAppMessaging)Preconditions.checkNotNull(headlessInAppMessagingModule.providesHeadlesssSingleton(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public FirebaseInAppMessaging get() {
        return HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.providesHeadlesssSingleton(this.module);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
