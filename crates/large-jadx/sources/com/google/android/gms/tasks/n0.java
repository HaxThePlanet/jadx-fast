package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class n0 implements Runnable {

    final com.google.android.gms.tasks.m0 a;
    final Callable b;
    n0(com.google.android.gms.tasks.m0 m0, Callable callable2) {
        this.a = m0;
        this.b = callable2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a(this.b.call());
            com.google.android.gms.tasks.m0 m0Var2 = this.a;
            RuntimeException runtimeException = new RuntimeException(th);
            m0Var2.c(runtimeException);
            m0Var2 = this.a;
            m0Var2.c(th);
        }
    }
}
