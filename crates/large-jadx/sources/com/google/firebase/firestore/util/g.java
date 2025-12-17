package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.k;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final k a;
    public final Callable b;
    public g(k k, Callable callable2) {
        super();
        this.a = k;
        this.b = callable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsyncQueue.SynchronizedShutdownAwareExecutor.b(this.a, this.b);
    }
}
