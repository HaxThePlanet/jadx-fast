package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class p0 implements Runnable {

    public final com.android.billingclient.api.j a;
    public p0(com.android.billingclient.api.j j) {
        super();
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onPurchaseHistoryResponse(w.n, 0);
    }
}
