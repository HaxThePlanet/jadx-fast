package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
public final class v implements Runnable {

    public final com.google.firebase.firestore.local.LruGarbageCollector.GCScheduler a;
    public v(com.google.firebase.firestore.local.LruGarbageCollector.GCScheduler lruGarbageCollector$GCScheduler) {
        super();
        this.a = gCScheduler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
