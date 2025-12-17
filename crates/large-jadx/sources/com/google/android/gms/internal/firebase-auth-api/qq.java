package com.google.android.gms.internal.firebase-auth-api;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class qq extends com.google.android.gms.internal.firebase-auth-api.rq {

    private int a = 0;
    private final int b;
    final com.google.android.gms.internal.firebase-auth-api.wq c;
    qq(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        this.c = wq;
        super();
        final int i = 0;
        this.b = wq.g();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.rq
    public final boolean hasNext() {
        if (this.a < this.b) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.rq
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
        } else {
            this.a = i + 1;
            return this.c.d(i);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
