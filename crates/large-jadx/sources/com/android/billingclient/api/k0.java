package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class k0 implements Callable {

    public final com.android.billingclient.api.d a;
    public final com.android.billingclient.api.SkuDetails b;
    public final String c;
    public k0(com.android.billingclient.api.d d, com.android.billingclient.api.SkuDetails skuDetails2, String string3) {
        super();
        this.a = d;
        this.b = skuDetails2;
        this.c = string3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.z(this.b, this.c);
    }
}
