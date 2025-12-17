package com.google.firebase.functions;

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
public class FunctionsRegistrar implements ComponentRegistrar {
    static com.google.firebase.functions.ContextProvider a(ComponentContainer componentContainer) {
        FirebaseContextProvider firebaseContextProvider = new FirebaseContextProvider(componentContainer.getProvider(InternalAuthProvider.class), componentContainer.getProvider(FirebaseInstanceIdInternal.class), componentContainer.getDeferred(InternalAppCheckTokenProvider.class));
        return firebaseContextProvider;
    }

    static com.google.firebase.functions.FunctionsMultiResourceComponent b(ComponentContainer componentContainer) {
        FunctionsMultiResourceComponent functionsMultiResourceComponent = new FunctionsMultiResourceComponent((Context)componentContainer.get(Context.class), (ContextProvider)componentContainer.get(ContextProvider.class), (FirebaseApp)componentContainer.get(FirebaseApp.class));
        return functionsMultiResourceComponent;
    }

    public List<Component<?>> getComponents() {
        Class<com.google.firebase.functions.ContextProvider> obj = ContextProvider.class;
        Component[] arr = new Component[3];
        return Arrays.asList(Component.builder(obj).add(Dependency.optionalProvider(InternalAuthProvider.class)).add(Dependency.requiredProvider(FirebaseInstanceIdInternal.class)).add(Dependency.deferred(InternalAppCheckTokenProvider.class)).factory(i.a).build(), Component.builder(FunctionsMultiResourceComponent.class).add(Dependency.required(Context.class)).add(Dependency.required(obj)).add(Dependency.required(FirebaseApp.class)).factory(j.a).build(), LibraryVersionComponent.create("fire-fn", "20.0.1"));
    }
}
