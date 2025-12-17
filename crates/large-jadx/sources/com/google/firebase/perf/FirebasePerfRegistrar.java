package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent;
import com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent.Builder;
import com.google.firebase.perf.injection.components.FirebasePerformanceComponent;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FirebasePerfRegistrar implements ComponentRegistrar {
    public static com.google.firebase.perf.FirebasePerformance a(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
    }

    private static com.google.firebase.perf.FirebasePerformance providesFirebasePerformance(ComponentContainer componentContainer) {
        FirebasePerformanceModule firebasePerformanceModule = new FirebasePerformanceModule((FirebaseApp)componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi)componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(RemoteConfigComponent.class), componentContainer.getProvider(g.class));
        return DaggerFirebasePerformanceComponent.builder().firebasePerformanceModule(firebasePerformanceModule).build().getFirebasePerformance();
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(FirebasePerformance.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.requiredProvider(RemoteConfigComponent.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.requiredProvider(g.class)).factory(a.a).build(), LibraryVersionComponent.create("fire-perf", "20.0.3"));
    }
}
