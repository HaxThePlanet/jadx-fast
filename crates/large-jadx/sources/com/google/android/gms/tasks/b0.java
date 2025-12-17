package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class b0<TResult>  implements com.google.android.gms.tasks.g0<TResult> {

    private final Executor a;
    private final Object b;
    private com.google.android.gms.tasks.f c;
    public b0(Executor executor, com.google.android.gms.tasks.f f2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = f2;
    }

    static Object b(com.google.android.gms.tasks.b0 b0) {
        return b0.b;
    }

    static com.google.android.gms.tasks.f c(com.google.android.gms.tasks.b0 b0) {
        return b0.c;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        boolean successful;
        Object obj = this.b;
        if (!j.isSuccessful() && !j.isCanceled() && this.c == null) {
            if (!j.isCanceled()) {
                obj = this.b;
                synchronized (obj) {
                }
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
