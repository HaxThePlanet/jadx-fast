package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class a0 implements Runnable {

    final com.google.android.gms.tasks.j a;
    final com.google.android.gms.tasks.b0 b;
    a0(com.google.android.gms.tasks.b0 b0, com.google.android.gms.tasks.j j2) {
        this.b = b0;
        this.a = j2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.tasks.f fVar;
        Exception exception;
        Object obj = b0.b(this.b);
        synchronized (obj) {
            exception = this.a.getException();
            r.j(exception);
            b0.c(this.b).onFailure((Exception)exception);
        }
    }
}
