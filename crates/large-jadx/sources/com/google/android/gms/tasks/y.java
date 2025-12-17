package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class y implements Runnable {

    final com.google.android.gms.tasks.j a;
    final com.google.android.gms.tasks.z b;
    y(com.google.android.gms.tasks.z z, com.google.android.gms.tasks.j j2) {
        this.b = z;
        this.a = j2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.e eVar;
        com.google.android.gms.tasks.j jVar;
        Object obj = z.b(this.b);
        synchronized (obj) {
            z.c(this.b).onComplete(this.a);
        }
    }
}
