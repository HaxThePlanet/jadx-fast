package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class u0 implements Callable<com.android.billingclient.api.Purchase.a> {

    final String a;
    final com.android.billingclient.api.d b;
    u0(com.android.billingclient.api.d d, String string2) {
        this.b = d;
        this.a = string2;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return d.D(this.b, this.a);
    }
}
