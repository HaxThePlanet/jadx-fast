package com.google.firebase.functions;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class i implements ComponentFactory {

    public static final com.google.firebase.functions.i a;
    static {
        i iVar = new i();
        i.a = iVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FunctionsRegistrar.a(componentContainer);
    }
}
