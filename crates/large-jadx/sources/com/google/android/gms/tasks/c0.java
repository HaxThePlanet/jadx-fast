package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class c0 implements Runnable {

    final com.google.android.gms.tasks.j a;
    final com.google.android.gms.tasks.d0 b;
    c0(com.google.android.gms.tasks.d0 d0, com.google.android.gms.tasks.j j2) {
        this.b = d0;
        this.a = j2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.g gVar;
        Object result;
        Object obj = d0.b(this.b);
        synchronized (obj) {
            d0.c(this.b).onSuccess(this.a.getResult());
        }
    }
}
