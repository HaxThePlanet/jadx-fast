package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    static com.google.firebase.messaging.FirebaseMessaging lambda$getComponents$0(ComponentContainer componentContainer) {
        super((FirebaseApp)componentContainer.get(FirebaseApp.class), (FirebaseInstanceIdInternal)componentContainer.get(FirebaseInstanceIdInternal.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi)componentContainer.get(FirebaseInstallationsApi.class), (g)componentContainer.get(g.class), (Subscriber)componentContainer.get(Subscriber.class));
        return firebaseMessaging2;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(FirebaseMessaging.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optional(FirebaseInstanceIdInternal.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optional(g.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(Subscriber.class)).factory(FirebaseMessagingRegistrar$$ExternalSyntheticLambda0.INSTANCE).alwaysEager().build(), LibraryVersionComponent.create("fire-fcm", "23.0.0"));
    }
}
