package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class u6 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.v6, com.google.android.gms.internal.firebase-auth-api.u6> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private u6() {
        super(v6.B());
    }

    u6(com.google.android.gms.internal.firebase-auth-api.t6 t6) {
        super(v6.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.u6 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        v6.I((v6)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.u6 m(com.google.android.gms.internal.firebase-auth-api.b7 b7) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        v6.H((v6)this.b, b7);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.u6 s(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        v6.G((v6)this.b, i2);
        return this;
    }
}
