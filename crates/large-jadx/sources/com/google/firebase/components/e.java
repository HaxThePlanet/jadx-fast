package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class e implements Provider {

    public final com.google.firebase.components.ComponentRuntime a;
    public final com.google.firebase.components.Component b;
    public e(com.google.firebase.components.ComponentRuntime componentRuntime, com.google.firebase.components.Component component2) {
        super();
        this.a = componentRuntime;
        this.b = component2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.a.b(this.b);
    }
}
