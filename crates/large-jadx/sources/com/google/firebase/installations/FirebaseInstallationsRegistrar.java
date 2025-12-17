package com.google.firebase.installations;

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
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    static com.google.firebase.installations.FirebaseInstallationsApi a(ComponentContainer componentContainer) {
        FirebaseInstallations firebaseInstallations = new FirebaseInstallations((FirebaseApp)componentContainer.get(FirebaseApp.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class));
        return firebaseInstallations;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(FirebaseInstallationsApi.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).factory(e.a).build(), LibraryVersionComponent.create("fire-installations", "17.0.0"));
    }
}
