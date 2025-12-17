package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class p implements Runnable {

    public final RuntimeException a;
    public p(RuntimeException runtimeException) {
        super();
        this.a = runtimeException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Util.a(this.a);
        throw 0;
    }
}
