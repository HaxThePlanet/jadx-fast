package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class h0 implements Runnable {

    public final /* synthetic */ b a;
    @Override // java.lang.Runnable
    public final void run() {
        this.a.onAcknowledgePurchaseResponse(w.n);
    }

    public /* synthetic */ h0(b bVar) {
        super();
        this.a = bVar;
    }
}
