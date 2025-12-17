package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
public final class b0 implements Runnable {

    public final com.google.firebase.firestore.core.TransactionRunner a;
    public b0(com.google.firebase.firestore.core.TransactionRunner transactionRunner) {
        super();
        this.a = transactionRunner;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f();
    }
}
