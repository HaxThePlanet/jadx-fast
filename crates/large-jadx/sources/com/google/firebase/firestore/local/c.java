package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.firestore.local.IndexBackfiller.BackfillScheduler a;
    public c(com.google.firebase.firestore.local.IndexBackfiller.BackfillScheduler indexBackfiller$BackfillScheduler) {
        super();
        this.a = backfillScheduler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
