package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class i9 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.j9, com.google.android.gms.internal.firebase-auth-api.i9> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private i9() {
        super(j9.A());
    }

    i9(com.google.android.gms.internal.firebase-auth-api.h9 h9) {
        super(j9.A());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.i9 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        j9.D((j9)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.i9 m(com.google.android.gms.internal.firebase-auth-api.sa sa) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        j9.E((j9)this.b, sa);
        return this;
    }
}
