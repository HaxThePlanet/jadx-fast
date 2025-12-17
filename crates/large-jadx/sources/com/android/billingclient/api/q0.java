package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class q0 implements Runnable {

    public final com.android.billingclient.api.m a;
    public q0(com.android.billingclient.api.m m) {
        super();
        this.a = m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSkuDetailsResponse(w.n, 0);
    }
}
