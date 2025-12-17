package com.google.android.play.core.tasks;

/* loaded from: classes2.dex */
final class g implements Runnable {

    final com.google.android.play.core.tasks.d a;
    final com.google.android.play.core.tasks.h b;
    g(com.google.android.play.core.tasks.h h, com.google.android.play.core.tasks.d d2) {
        this.b = h;
        this.a = d2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.play.core.tasks.a aVar;
        com.google.android.play.core.tasks.d dVar;
        Object obj = h.c(this.b);
        synchronized (obj) {
            h.b(this.b).a(this.a);
        }
    }
}
