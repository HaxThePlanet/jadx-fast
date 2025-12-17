package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.firebase.components.LazySet a;
    public final Provider b;
    public h(com.google.firebase.components.LazySet lazySet, Provider provider2) {
        super();
        this.a = lazySet;
        this.b = provider2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentRuntime.d(this.a, this.b);
    }
}
