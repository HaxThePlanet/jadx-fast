package com.android.billingclient.api;

import f.c.a.d.b.i.a;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class r0 implements Runnable {

    public final Future a;
    public final Runnable b;
    public r0(Future future, Runnable runnable2) {
        super();
        this.a = future;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object str;
        boolean cancelled;
        str = this.a;
        final Runnable runnable = this.b;
        str.cancel(true);
        a.k("BillingClient", "Async task is taking too long, cancel it!");
        if (!str.isDone() && !str.isCancelled() && runnable != null) {
            if (!str.isCancelled()) {
                str.cancel(true);
                a.k("BillingClient", "Async task is taking too long, cancel it!");
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}
