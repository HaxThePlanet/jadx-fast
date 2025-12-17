package com.google.android.gms.cloudmessaging;

/* loaded from: classes2.dex */
public final class l implements Runnable {

    public final com.google.android.gms.cloudmessaging.r a;
    public l(com.google.android.gms.cloudmessaging.r r) {
        super();
        this.a = r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(2, "Service disconnected");
    }
}
