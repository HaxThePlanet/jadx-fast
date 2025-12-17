package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class t<TResult, TContinuationResult>  implements com.google.android.gms.tasks.g0<TResult> {

    private final Executor a;
    private final com.google.android.gms.tasks.c<TResult, TContinuationResult> b;
    private final com.google.android.gms.tasks.m0<TContinuationResult> c;
    public t(Executor executor, com.google.android.gms.tasks.c<TResult, TContinuationResult> c2, com.google.android.gms.tasks.m0<TContinuationResult> m03) {
        super();
        this.a = executor;
        this.b = c2;
        this.c = m03;
    }

    static com.google.android.gms.tasks.m0 b(com.google.android.gms.tasks.t t) {
        return t.c;
    }

    static com.google.android.gms.tasks.c c(com.google.android.gms.tasks.t t) {
        return t.b;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        s sVar = new s(this, j);
        this.a.execute(sVar);
    }

    @Override // com.google.android.gms.tasks.g0
    public final void zzb() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
