package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class d0<TResult>  implements com.google.android.gms.tasks.g0<TResult> {

    private final Executor a;
    private final Object b;
    private com.google.android.gms.tasks.g<? super TResult> c;
    public d0(Executor executor, com.google.android.gms.tasks.g<? super TResult> g2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = g2;
    }

    static Object b(com.google.android.gms.tasks.d0 d0) {
        return d0.b;
    }

    static com.google.android.gms.tasks.g c(com.google.android.gms.tasks.d0 d0) {
        return d0.c;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        Object obj = this.b;
        if (j.isSuccessful() && this.c == null) {
            obj = this.b;
            synchronized (obj) {
            }
        }
    }

    @Override // com.google.android.gms.tasks.g0
    public final void zzb() {
        final Object obj = this.b;
        this.c = 0;
        return;
        synchronized (obj) {
            obj = this.b;
            this.c = 0;
        }
    }
}
