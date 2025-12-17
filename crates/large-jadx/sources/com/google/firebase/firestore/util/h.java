package com.google.firebase.firestore.util;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class h implements Callable {

    public final Runnable a;
    public h(Runnable runnable) {
        super();
        this.a = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return AsyncQueue.c(this.a);
    }
}
