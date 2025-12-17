package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class f0<TResult, TContinuationResult>  implements com.google.android.gms.tasks.g<TContinuationResult>, com.google.android.gms.tasks.f, com.google.android.gms.tasks.d, com.google.android.gms.tasks.g0 {

    private final Executor a;
    private final com.google.android.gms.tasks.i<TResult, TContinuationResult> b;
    private final com.google.android.gms.tasks.m0<TContinuationResult> c;
    public f0(Executor executor, com.google.android.gms.tasks.i<TResult, TContinuationResult> i2, com.google.android.gms.tasks.m0<TContinuationResult> m03) {
        super();
        this.a = executor;
        this.b = i2;
        this.c = m03;
    }

    static com.google.android.gms.tasks.i b(com.google.android.gms.tasks.f0 f0) {
        return f0.b;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        e0 e0Var = new e0(this, j);
        this.a.execute(e0Var);
    }

    @Override // com.google.android.gms.tasks.g
    public final void onCanceled() {
        this.c.e();
    }

    @Override // com.google.android.gms.tasks.g
    public final void onFailure(Exception exception) {
        this.c.c(exception);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.a(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.g
    public final void zzb() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
