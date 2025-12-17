package com.google.firebase.storage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class d implements ComponentFactory {

    public static final com.google.firebase.storage.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return StorageRegistrar.a(componentContainer);
    }
}
