package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
final class q implements com.google.android.gms.tasks.p {

    private final Object a;
    private final int b;
    private final com.google.android.gms.tasks.m0<Void> c;
    private int d;
    private int e;
    private int f;
    private Exception g;
    private boolean h;
    public q(int i, com.google.android.gms.tasks.m0<Void> m02) {
        super();
        Object object = new Object();
        this.a = object;
        this.b = i;
        this.c = m02;
    }

    private final void a() {
        int i;
        int i2;
        i2 = this.e;
        int i6 = this.b;
        if (i4 += i5 == i6 && this.g != null) {
            if (this.g != null) {
                StringBuilder stringBuilder = new StringBuilder(54);
                stringBuilder.append(i2);
                stringBuilder.append(" out of ");
                stringBuilder.append(i6);
                stringBuilder.append(" underlying tasks failed");
                ExecutionException executionException = new ExecutionException(stringBuilder.toString(), this.g);
                this.c.c(executionException);
            }
            if (this.h) {
                this.c.e();
            }
            this.c.a(0);
        }
    }

    @Override // com.google.android.gms.tasks.p
    public final void onCanceled() {
        final Object obj = this.a;
        final int i3 = 1;
        this.f = i += i3;
        this.h = i3;
        a();
        return;
        synchronized (obj) {
            obj = this.a;
            i3 = 1;
            this.f = i += i3;
            this.h = i3;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.p
    public final void onFailure(Exception exception) {
        final Object obj = this.a;
        this.e = i++;
        this.g = exception;
        a();
        return;
        synchronized (obj) {
            obj = this.a;
            this.e = i++;
            this.g = exception;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.p
    public final void onSuccess(Object object) {
        final Object obj2 = this.a;
        this.d = i++;
        a();
        return;
        synchronized (obj2) {
            obj2 = this.a;
            this.d = i++;
            a();
        }
    }
}
