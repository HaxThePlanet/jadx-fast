package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final Throwable a;
    public j(Throwable throwable) {
        super();
        this.a = throwable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsyncQueue.d(this.a);
        throw 0;
    }
}
