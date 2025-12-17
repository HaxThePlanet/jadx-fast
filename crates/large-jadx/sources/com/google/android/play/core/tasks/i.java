package com.google.android.play.core.tasks;

/* loaded from: classes2.dex */
final class i implements Runnable {

    final com.google.android.play.core.tasks.d a;
    final com.google.android.play.core.tasks.j b;
    i(com.google.android.play.core.tasks.j j, com.google.android.play.core.tasks.d d2) {
        this.b = j;
        this.a = d2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.play.core.tasks.b bVar;
        Exception exc;
        Object obj = j.c(this.b);
        synchronized (obj) {
            j.b(this.b).onFailure(this.a.f());
        }
    }
}
