package com.google.firebase.remoteconfig;

import androidx.annotation.Keep;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class RemoteConfigRegistrar implements ComponentRegistrar {
    static com.google.firebase.remoteconfig.RemoteConfigComponent a(ComponentContainer componentContainer) {
        super((Context)componentContainer.get(Context.class), (FirebaseApp)componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi)componentContainer.get(FirebaseInstallationsApi.class), (AbtComponent)componentContainer.get(AbtComponent.class).get("frc"), componentContainer.getProvider(AnalyticsConnector.class));
        return remoteConfigComponent2;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(RemoteConfigComponent.class).add(Dependency.required(Context.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(AbtComponent.class)).add(Dependency.optionalProvider(AnalyticsConnector.class)).factory(l.a).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-rc", "21.0.1"));
    }
}
