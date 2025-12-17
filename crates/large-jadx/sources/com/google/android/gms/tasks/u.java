package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class u implements Runnable {

    final com.google.android.gms.tasks.j a;
    final com.google.android.gms.tasks.v b;
    u(com.google.android.gms.tasks.v v, com.google.android.gms.tasks.j j2) {
        this.b = v;
        this.a = j2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object then = v.b(this.b).then(this.a);
            if ((j)then == null) {
            }
            NullPointerException nullPointerException = new NullPointerException("Continuation returned null");
            this.b.onFailure(nullPointerException);
            java.util.concurrent.Executor executor = l.b;
            (j)then.addOnSuccessListener(executor, this.b);
            then.addOnFailureListener(executor, this.b);
            then.addOnCanceledListener(executor, this.b);
            com.google.android.gms.tasks.v vVar3 = this.b;
            vVar3 = v.c(vVar3);
            vVar3.c(cause);
            vVar3 = cause.getCause();
            vVar3 = vVar3 instanceof Exception;
            if (vVar3 != null) {
            }
            vVar3 = this.b;
            vVar3 = v.c(vVar3);
            Throwable cause = cause.getCause();
            vVar3.c((Exception)cause);
            vVar3 = this.b;
            vVar3 = v.c(vVar3);
            vVar3.c(cause);
        }
    }
}
