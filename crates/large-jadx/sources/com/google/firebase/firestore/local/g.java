package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Target;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final com.google.firebase.firestore.local.LocalStore.AllocateQueryHolder b;
    public final Target c;
    public g(com.google.firebase.firestore.local.LocalStore localStore, com.google.firebase.firestore.local.LocalStore.AllocateQueryHolder localStore$AllocateQueryHolder2, Target target3) {
        super();
        this.a = localStore;
        this.b = allocateQueryHolder2;
        this.c = target3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b, this.c);
    }
}
