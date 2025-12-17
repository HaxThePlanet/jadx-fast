package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class pa extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.sa, com.google.android.gms.internal.firebase-auth-api.pa> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private pa() {
        super(sa.B());
    }

    pa(com.google.android.gms.internal.firebase-auth-api.oa oa) {
        super(sa.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.pa j(com.google.android.gms.internal.firebase-auth-api.ra ra) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        sa.D((sa)this.b, ra);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.pa m(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        sa.C((sa)this.b, i);
        return this;
    }
}
