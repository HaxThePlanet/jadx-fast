package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class o0 implements Runnable {

    public final /* synthetic */ i a;
    public final /* synthetic */ h b;
    @Override // java.lang.Runnable
    public final void run() {
        this.a.onConsumeResponse(w.n, this.b.a());
    }

    public /* synthetic */ o0(i iVar, h hVar) {
        super();
        this.a = iVar;
        this.b = hVar;
    }
}
