package com.google.firebase.remoteconfig;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class l implements ComponentFactory {

    public static final com.google.firebase.remoteconfig.l a;
    static {
        l lVar = new l();
        l.a = lVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.a(componentContainer);
    }
}
