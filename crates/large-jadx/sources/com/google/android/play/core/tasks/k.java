package com.google.android.play.core.tasks;

/* loaded from: classes2.dex */
final class k implements Runnable {

    final com.google.android.play.core.tasks.d a;
    final com.google.android.play.core.tasks.l b;
    k(com.google.android.play.core.tasks.l l, com.google.android.play.core.tasks.d d2) {
        this.b = l;
        this.a = d2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.play.core.tasks.c cVar;
        Object obj;
        Object obj2 = l.c(this.b);
        synchronized (obj2) {
            l.b(this.b).onSuccess(this.a.g());
        }
    }
}
