package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class d implements Provider {

    public final String a;
    public d(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return ComponentDiscovery.a(this.a);
    }
}
