package com.google.firebase.abt.component;

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
public class AbtRegistrar implements ComponentRegistrar {
    static com.google.firebase.abt.component.AbtComponent a(ComponentContainer componentContainer) {
        AbtComponent abtComponent = new AbtComponent((Context)componentContainer.get(Context.class), componentContainer.getProvider(AnalyticsConnector.class));
        return abtComponent;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        return Arrays.asList(Component.builder(AbtComponent.class).add(Dependency.required(Context.class)).add(Dependency.optionalProvider(AnalyticsConnector.class)).factory(a.a).build(), LibraryVersionComponent.create("fire-abt", "21.0.0"));
    }
}
