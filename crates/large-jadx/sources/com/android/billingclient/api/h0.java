package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class h0 implements Runnable {

    public final com.android.billingclient.api.b a;
    public h0(com.android.billingclient.api.b b) {
        super();
        this.a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onAcknowledgePurchaseResponse(w.n);
    }
}
