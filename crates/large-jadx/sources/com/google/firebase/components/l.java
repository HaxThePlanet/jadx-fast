package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class l implements Provider {

    public static final com.google.firebase.components.l a;
    static {
        l lVar = new l();
        l.a = lVar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return OptionalProvider.b();
    }
}
