package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class g implements Provider {

    public final com.google.firebase.components.ComponentRegistrar a;
    public g(com.google.firebase.components.ComponentRegistrar componentRegistrar) {
        super();
        this.a = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        final com.google.firebase.components.ComponentRegistrar componentRegistrar = this.a;
        ComponentRuntime.Builder.a(componentRegistrar);
        return componentRegistrar;
    }
}
