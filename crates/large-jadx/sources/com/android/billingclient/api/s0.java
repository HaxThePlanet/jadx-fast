package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class s0 implements Callable {

    public final com.android.billingclient.api.d a;
    public final int b;
    public final com.android.billingclient.api.SkuDetails c;
    public final String v;
    public final com.android.billingclient.api.f w;
    public final Bundle x;
    public s0(com.android.billingclient.api.d d, int i2, com.android.billingclient.api.SkuDetails skuDetails3, String string4, com.android.billingclient.api.f f5, Bundle bundle6) {
        super();
        this.a = d;
        this.b = i2;
        this.c = skuDetails3;
        this.v = string4;
        this.w = f5;
        this.x = bundle6;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.y(this.b, this.c, this.v, this.w, this.x);
    }
}
