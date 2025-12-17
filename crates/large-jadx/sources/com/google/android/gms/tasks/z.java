package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class z<TResult>  implements com.google.android.gms.tasks.g0<TResult> {

    private final Executor a;
    private final Object b;
    private com.google.android.gms.tasks.e<TResult> c;
    public z(Executor executor, com.google.android.gms.tasks.e<TResult> e2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = e2;
    }

    static Object b(com.google.android.gms.tasks.z z) {
        return z.b;
    }

    static com.google.android.gms.tasks.e c(com.google.android.gms.tasks.z z) {
        return z.c;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        Object obj = this.b;
        synchronized (obj) {
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
