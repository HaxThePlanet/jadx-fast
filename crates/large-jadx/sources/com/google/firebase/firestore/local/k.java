package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public k(com.google.firebase.firestore.local.LocalStore localStore) {
        super();
        this.a = localStore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.E();
    }
}
