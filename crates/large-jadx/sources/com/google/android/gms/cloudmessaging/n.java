package com.google.android.gms.cloudmessaging;

/* loaded from: classes2.dex */
public final class n implements Runnable {

    public final com.google.android.gms.cloudmessaging.r a;
    public n(com.google.android.gms.cloudmessaging.r r) {
        super();
        this.a = r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
