package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class i0 implements Callable {

    public final com.android.billingclient.api.d a;
    public final com.android.billingclient.api.a b;
    public final com.android.billingclient.api.b c;
    public i0(com.android.billingclient.api.d d, com.android.billingclient.api.a a2, com.android.billingclient.api.b b3) {
        super();
        this.a = d;
        this.b = a2;
        this.c = b3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.H(this.b, this.c);
        return null;
    }
}
