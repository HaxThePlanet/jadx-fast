package com.android.billingclient.api;

import f.c.a.d.b.i.a;
import java.util.concurrent.Future;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class r0 implements Runnable {

    public final /* synthetic */ Future a;
    public final /* synthetic */ Runnable b;
    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.isDone() && !this.a.isCancelled()) {
            this.a.cancel(true);
            a.k("BillingClient", "Async task is taking too long, cancel it!");
            if (this.b != null) {
                this.b.run();
            }
        }
    }

    public /* synthetic */ r0(Future future, Runnable runnable) {
        super();
        this.a = future;
        this.b = runnable;
    }
}
