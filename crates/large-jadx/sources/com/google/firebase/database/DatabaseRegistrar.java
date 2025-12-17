package com.google.firebase.database;

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
public class DatabaseRegistrar implements ComponentRegistrar {
    static com.google.firebase.database.FirebaseDatabaseComponent a(ComponentContainer componentContainer) {
        FirebaseDatabaseComponent firebaseDatabaseComponent = new FirebaseDatabaseComponent((FirebaseApp)componentContainer.get(FirebaseApp.class), componentContainer.getDeferred(InternalAuthProvider.class), componentContainer.getDeferred(InternalAppCheckTokenProvider.class));
        return firebaseDatabaseComponent;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(FirebaseDatabaseComponent.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.deferred(InternalAuthProvider.class)).add(Dependency.deferred(InternalAppCheckTokenProvider.class)).factory(a.a).build(), LibraryVersionComponent.create("fire-rtdb", "20.0.2"));
    }
}
