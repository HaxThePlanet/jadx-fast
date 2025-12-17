package com.google.firebase.storage;

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
public class StorageRegistrar implements ComponentRegistrar {
    static com.google.firebase.storage.FirebaseStorageComponent a(ComponentContainer componentContainer) {
        FirebaseStorageComponent firebaseStorageComponent = new FirebaseStorageComponent((FirebaseApp)componentContainer.get(FirebaseApp.class), componentContainer.getProvider(InternalAuthProvider.class), componentContainer.getProvider(InternalAppCheckTokenProvider.class));
        return firebaseStorageComponent;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(FirebaseStorageComponent.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(InternalAuthProvider.class)).add(Dependency.optionalProvider(InternalAppCheckTokenProvider.class)).factory(d.a).build(), LibraryVersionComponent.create("fire-gcs", "20.0.0"));
    }
}
