package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class f8 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.g8, com.google.android.gms.internal.firebase-auth-api.f8> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private f8() {
        super(g8.B());
    }

    f8(com.google.android.gms.internal.firebase-auth-api.e8 e8) {
        super(g8.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.f8 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        g8.F((g8)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.f8 m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        g8.E((g8)this.b, i2);
        return this;
    }
}
