package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class v<TResult, TContinuationResult>  implements com.google.android.gms.tasks.g<TContinuationResult>, com.google.android.gms.tasks.f, com.google.android.gms.tasks.d, com.google.android.gms.tasks.g0 {

    private final Executor a;
    private final com.google.android.gms.tasks.c<TResult, com.google.android.gms.tasks.j<TContinuationResult>> b;
    private final com.google.android.gms.tasks.m0<TContinuationResult> c;
    public v(Executor executor, com.google.android.gms.tasks.c<TResult, com.google.android.gms.tasks.j<TContinuationResult>> c2, com.google.android.gms.tasks.m0<TContinuationResult> m03) {
        super();
        this.a = executor;
        this.b = c2;
        this.c = m03;
    }

    static com.google.android.gms.tasks.c b(com.google.android.gms.tasks.v v) {
        return v.b;
    }

    static com.google.android.gms.tasks.m0 c(com.google.android.gms.tasks.v v) {
        return v.c;
    }

    public final void a(com.google.android.gms.tasks.j<TResult> j) {
        u uVar = new u(this, j);
        this.a.execute(uVar);
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
