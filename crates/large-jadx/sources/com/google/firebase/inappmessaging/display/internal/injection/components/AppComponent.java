package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

/* loaded from: classes2.dex */
@Component(dependencies = UniversalComponent.class, modules = {HeadlessInAppMessagingModule.class, GlideModule.class})
public interface AppComponent {
    public abstract FiamImageLoader fiamImageLoader();

    public abstract GlideErrorListener glideErrorListener();

    public abstract FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI();
}
