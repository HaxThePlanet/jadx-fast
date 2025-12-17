package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class q implements Runnable {

    public final com.android.billingclient.api.s a;
    public q(com.android.billingclient.api.s s) {
        super();
        this.a = s;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
