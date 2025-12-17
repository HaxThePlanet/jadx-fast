package com.google.firebase.functions;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class j implements ComponentFactory {

    public static final com.google.firebase.functions.j a;
    static {
        j jVar = new j();
        j.a = jVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FunctionsRegistrar.b(componentContainer);
    }
}
