package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class e0 implements Runnable {

    final com.google.android.gms.tasks.j a;
    final com.google.android.gms.tasks.f0 b;
    e0(com.google.android.gms.tasks.f0 f0, com.google.android.gms.tasks.j j2) {
        this.b = f0;
        this.a = j2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.google.android.gms.tasks.j then = f0.b(this.b).then(this.a.getResult());
            if (then == null) {
            }
            NullPointerException nullPointerException = new NullPointerException("Continuation returned null");
            this.b.onFailure(nullPointerException);
            java.util.concurrent.Executor executor = l.b;
            then.addOnSuccessListener(executor, this.b);
            then.addOnFailureListener(executor, this.b);
            then.addOnCanceledListener(executor, this.b);
            com.google.android.gms.tasks.f0 f0Var3 = this.b;
            f0Var3.onFailure(cause);
            Throwable cause = this.b;
            cause.onCanceled();
            f0Var3 = cause.getCause();
            f0Var3 = f0Var3 instanceof Exception;
            if (f0Var3 != null) {
            }
            f0Var3 = this.b;
            cause = cause.getCause();
            f0Var3.onFailure((Exception)cause);
            f0Var3 = this.b;
            f0Var3.onFailure(cause);
        }
    }
}
