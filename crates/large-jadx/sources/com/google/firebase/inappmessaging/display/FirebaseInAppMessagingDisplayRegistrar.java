package com.google.firebase.inappmessaging.display;

import android.app.Application;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.Builder;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent.Builder;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplayRegistrar implements ComponentRegistrar {
    public static com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay a(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar, ComponentContainer componentContainer2) {
        return firebaseInAppMessagingDisplayRegistrar.buildFirebaseInAppMessagingUI(componentContainer2);
    }

    private com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay buildFirebaseInAppMessagingUI(ComponentContainer componentContainer) {
        android.content.Context applicationContext = (FirebaseApp)componentContainer.get(FirebaseApp.class).getApplicationContext();
        ApplicationModule applicationModule2 = new ApplicationModule((Application)applicationContext);
        HeadlessInAppMessagingModule headlessInAppMessagingModule = new HeadlessInAppMessagingModule((FirebaseInAppMessaging)componentContainer.get(FirebaseInAppMessaging.class));
        com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay obj4 = DaggerAppComponent.builder().universalComponent(DaggerUniversalComponent.builder().applicationModule(applicationModule2).build()).headlessInAppMessagingModule(headlessInAppMessagingModule).build().providesFirebaseInAppMessagingUI();
        applicationContext.registerActivityLifecycleCallbacks(obj4);
        return obj4;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        b bVar = new b(this);
        return Arrays.asList(Component.builder(FirebaseInAppMessagingDisplay.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInAppMessaging.class)).factory(bVar).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiamd", "20.1.1"));
    }
}
