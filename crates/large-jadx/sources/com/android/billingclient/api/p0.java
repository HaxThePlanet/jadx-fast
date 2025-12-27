package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class p0 implements Runnable {

    public final /* synthetic */ j a;
    @Override // java.lang.Runnable
    public final void run() {
        this.a.onPurchaseHistoryResponse(w.n, null);
    }

    public /* synthetic */ p0(j jVar) {
        super();
        this.a = jVar;
    }
}
