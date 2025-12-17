package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class i implements Runnable {

    public final com.google.firebase.components.OptionalProvider a;
    public final Provider b;
    public i(com.google.firebase.components.OptionalProvider optionalProvider, Provider provider2) {
        super();
        this.a = optionalProvider;
        this.b = provider2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentRuntime.c(this.a, this.b);
    }
}
