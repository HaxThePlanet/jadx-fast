package com.google.firebase.crashlytics;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    public static com.google.firebase.crashlytics.FirebaseCrashlytics a(com.google.firebase.crashlytics.CrashlyticsRegistrar crashlyticsRegistrar, ComponentContainer componentContainer2) {
        return crashlyticsRegistrar.buildCrashlytics(componentContainer2);
    }

    private com.google.firebase.crashlytics.FirebaseCrashlytics buildCrashlytics(ComponentContainer componentContainer) {
        return FirebaseCrashlytics.init((FirebaseApp)componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi)componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getDeferred(CrashlyticsNativeComponent.class), componentContainer.getDeferred(AnalyticsConnector.class));
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        d dVar = new d(this);
        return Arrays.asList(Component.builder(FirebaseCrashlytics.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.deferred(CrashlyticsNativeComponent.class)).add(Dependency.deferred(AnalyticsConnector.class)).factory(dVar).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls", "18.2.4"));
    }
}
