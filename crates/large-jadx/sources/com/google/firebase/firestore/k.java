package com.google.firebase.firestore;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class k implements ComponentFactory {

    public static final com.google.firebase.firestore.k a;
    static {
        k kVar = new k();
        k.a = kVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FirestoreRegistrar.a(componentContainer);
    }
}
