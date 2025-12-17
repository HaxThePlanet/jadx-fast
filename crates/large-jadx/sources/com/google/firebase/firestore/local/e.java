package com.google.firebase.firestore.local;

import com.google.protobuf.j;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final j b;
    public e(com.google.firebase.firestore.local.LocalStore localStore, j j2) {
        super();
        this.a = localStore;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.C(this.b);
    }
}
