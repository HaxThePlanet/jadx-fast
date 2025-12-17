package com.google.firebase.installations;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class e implements ComponentFactory {

    public static final com.google.firebase.installations.e a;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FirebaseInstallationsRegistrar.a(componentContainer);
    }
}
