package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.k;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class i implements Runnable {

    public final Callable a;
    public final Executor b;
    public final k c;
    public i(Callable callable, Executor executor2, k k3) {
        super();
        this.a = callable;
        this.b = executor2;
        this.c = k3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsyncQueue.b(this.a, this.b, this.c);
    }
}
