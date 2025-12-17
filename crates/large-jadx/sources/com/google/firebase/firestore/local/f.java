package com.google.firebase.firestore.local;

import java.util.List;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final List b;
    public f(com.google.firebase.firestore.local.LocalStore localStore, List list2) {
        super();
        this.a = localStore;
        this.b = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.m(this.b);
    }
}
