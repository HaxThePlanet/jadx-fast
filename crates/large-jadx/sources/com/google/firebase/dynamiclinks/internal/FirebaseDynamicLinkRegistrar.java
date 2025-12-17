package com.google.firebase.dynamiclinks.internal;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class FirebaseDynamicLinkRegistrar implements ComponentRegistrar {
    static FirebaseDynamicLinks a(ComponentContainer componentContainer) {
        FirebaseDynamicLinksImpl firebaseDynamicLinksImpl = new FirebaseDynamicLinksImpl((FirebaseApp)componentContainer.get(FirebaseApp.class), componentContainer.getProvider(AnalyticsConnector.class));
        return firebaseDynamicLinksImpl;
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[1];
        return Arrays.asList(Component.builder(FirebaseDynamicLinks.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(AnalyticsConnector.class)).factory(a.a).build());
    }
}
