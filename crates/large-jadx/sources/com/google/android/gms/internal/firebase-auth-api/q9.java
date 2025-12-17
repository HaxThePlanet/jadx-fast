package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class q9 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.r9, com.google.android.gms.internal.firebase-auth-api.q9> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private q9() {
        super(r9.B());
    }

    q9(com.google.android.gms.internal.firebase-auth-api.p9 p9) {
        super(r9.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.q9 j(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        r9.G((r9)this.b, i);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.q9 m(com.google.android.gms.internal.firebase-auth-api.u9 u9) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        r9.F((r9)this.b, u9);
        return this;
    }
}
