package com.google.firebase.firestore;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.firestore.remote.FirebaseClientGrpcMetadataProvider;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FirestoreRegistrar implements ComponentRegistrar {
    static com.google.firebase.firestore.FirestoreMultiDbComponent a(ComponentContainer componentContainer) {
        FirebaseClientGrpcMetadataProvider firebaseClientGrpcMetadataProvider = new FirebaseClientGrpcMetadataProvider(componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseOptions)componentContainer.get(FirebaseOptions.class));
        super((Context)componentContainer.get(Context.class), (FirebaseApp)componentContainer.get(FirebaseApp.class), componentContainer.getDeferred(InternalAuthProvider.class), componentContainer.getDeferred(InternalAppCheckTokenProvider.class), firebaseClientGrpcMetadataProvider);
        return firestoreMultiDbComponent2;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(FirestoreMultiDbComponent.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Context.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).add(Dependency.deferred(InternalAuthProvider.class)).add(Dependency.deferred(InternalAppCheckTokenProvider.class)).add(Dependency.optional(FirebaseOptions.class)).factory(k.a).build(), LibraryVersionComponent.create("fire-fst", "24.0.0"));
    }
}
