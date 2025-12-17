package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class j0 implements Callable {

    public final com.android.billingclient.api.d a;
    public final com.android.billingclient.api.h b;
    public final com.android.billingclient.api.i c;
    public j0(com.android.billingclient.api.d d, com.android.billingclient.api.h h2, com.android.billingclient.api.i i3) {
        super();
        this.a = d;
        this.b = h2;
        this.c = i3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.I(this.b, this.c);
        return null;
    }
}
