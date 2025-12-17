package com.google.firebase.abt.component;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class a implements ComponentFactory {

    public static final com.google.firebase.abt.component.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return AbtRegistrar.a(componentContainer);
    }
}
