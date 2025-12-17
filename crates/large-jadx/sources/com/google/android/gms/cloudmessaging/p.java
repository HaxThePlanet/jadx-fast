package com.google.android.gms.cloudmessaging;

/* loaded from: classes2.dex */
public final class p implements Runnable {

    public final com.google.android.gms.cloudmessaging.r a;
    public final com.google.android.gms.cloudmessaging.u b;
    public p(com.google.android.gms.cloudmessaging.r r, com.google.android.gms.cloudmessaging.u u2) {
        super();
        this.a = r;
        this.b = u2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e(uVar.a);
    }
}
