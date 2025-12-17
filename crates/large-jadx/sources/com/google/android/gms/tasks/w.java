package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class w implements Runnable {

    final com.google.android.gms.tasks.x a;
    w(com.google.android.gms.tasks.x x) {
        this.a = x;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.d dVar;
        Object obj = x.b(this.a);
        synchronized (obj) {
            x.c(this.a).onCanceled();
        }
    }
}
