package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class x<TResult>  implements com.google.android.gms.tasks.g0<TResult> {

    private final Executor a;
    private final Object b;
    private com.google.android.gms.tasks.d c;
    public x(Executor executor, com.google.android.gms.tasks.d d2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = d2;
    }

    static Object b(com.google.android.gms.tasks.x x) {
        return x.b;
    }

    static com.google.android.gms.tasks.d c(com.google.android.gms.tasks.x x) {
        return x.c;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        Object obj2 = this.b;
        if (j.isCanceled() && this.c == null) {
            obj2 = this.b;
            synchronized (obj2) {
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
