package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class n0 implements Runnable {

    public final com.android.billingclient.api.d a;
    public final com.android.billingclient.api.g b;
    public n0(com.android.billingclient.api.d d, com.android.billingclient.api.g g2) {
        super();
        this.a = d;
        this.b = g2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.L(this.b);
    }
}
