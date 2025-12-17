package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class k implements Provider {

    public static final com.google.firebase.components.k a;
    static {
        k kVar = new k();
        k.a = kVar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return Collections.emptySet();
    }
}
