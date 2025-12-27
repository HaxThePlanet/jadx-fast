package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class q implements Runnable {

    public final /* synthetic */ s a;
    public /* synthetic */ q(s sVar) {
        super();
        this.a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
