package com.google.firebase.auth;

import androidx.annotation.Keep;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    static com.google.firebase.auth.FirebaseAuth lambda$getComponents$0(ComponentContainer componentContainer) {
        zzv zzv = new zzv((FirebaseApp)componentContainer.get(FirebaseApp.class));
        return zzv;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        final int i2 = 1;
        Class[] arr2 = new Class[i2];
        final int i3 = 0;
        arr2[i3] = InternalAuthProvider.class;
        arr[i3] = Component.builder(FirebaseAuth.class, arr2).add(Dependency.required(FirebaseApp.class)).factory(zzv.zza).eagerInDefaultApp().build();
        arr[i2] = LibraryVersionComponent.create("fire-auth", "21.0.1");
        return Arrays.asList(arr);
    }
}
