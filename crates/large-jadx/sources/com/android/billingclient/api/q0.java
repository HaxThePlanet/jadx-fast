package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class q0 implements Runnable {

    public final /* synthetic */ m a;
    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSkuDetailsResponse(w.n, null);
    }

    public /* synthetic */ q0(m mVar) {
        super();
        this.a = mVar;
    }
}
