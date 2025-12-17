package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class o0 implements Runnable {

    public final com.android.billingclient.api.i a;
    public final com.android.billingclient.api.h b;
    public o0(com.android.billingclient.api.i i, com.android.billingclient.api.h h2) {
        super();
        this.a = i;
        this.b = h2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onConsumeResponse(w.n, this.b.a());
    }
}
