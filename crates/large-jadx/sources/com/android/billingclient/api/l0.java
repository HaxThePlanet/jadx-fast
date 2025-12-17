package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class l0 implements Callable {

    public final com.android.billingclient.api.d a;
    public final String b;
    public l0(com.android.billingclient.api.d d, String string2) {
        super();
        this.a = d;
        this.b = string2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.G(this.b);
    }
}
