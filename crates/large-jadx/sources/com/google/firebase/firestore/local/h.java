package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final int b;
    public h(com.google.firebase.firestore.local.LocalStore localStore, int i2) {
        super();
        this.a = localStore;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.w(this.b);
    }
}
