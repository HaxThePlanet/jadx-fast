package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class mb extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.nb, com.google.android.gms.internal.firebase-auth-api.mb> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private mb() {
        super(nb.B());
    }

    mb(com.google.android.gms.internal.firebase-auth-api.lb lb) {
        super(nb.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.mb j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        nb.F((nb)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.mb m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        nb.E((nb)this.b, i2);
        return this;
    }
}
