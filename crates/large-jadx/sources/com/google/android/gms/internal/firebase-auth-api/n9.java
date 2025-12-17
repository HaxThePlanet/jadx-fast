package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class n9 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.o9, com.google.android.gms.internal.firebase-auth-api.n9> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private n9() {
        super(o9.B());
    }

    n9(com.google.android.gms.internal.firebase-auth-api.m9 m9) {
        super(o9.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.n9 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        o9.I((o9)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.n9 m(com.google.android.gms.internal.firebase-auth-api.u9 u9) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        o9.H((o9)this.b, u9);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.n9 s(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        o9.G((o9)this.b, i2);
        return this;
    }
}
