package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class s implements Runnable {

    final com.google.android.gms.tasks.j a;
    final com.google.android.gms.tasks.t b;
    s(com.google.android.gms.tasks.t t, com.google.android.gms.tasks.j j2) {
        this.b = t;
        this.a = j2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.isCanceled()) {
            t.b(this.b).e();
        }
        t.b(this.b).a(t.c(this.b).then(this.a));
    }
}
