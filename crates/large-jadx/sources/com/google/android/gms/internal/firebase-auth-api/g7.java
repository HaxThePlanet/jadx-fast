package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class g7 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.h7, com.google.android.gms.internal.firebase-auth-api.g7> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private g7() {
        super(h7.B());
    }

    g7(com.google.android.gms.internal.firebase-auth-api.f7 f7) {
        super(h7.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.g7 j(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        h7.F((h7)this.b, i);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.g7 m(com.google.android.gms.internal.firebase-auth-api.k7 k7) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        h7.E((h7)this.b, k7);
        return this;
    }
}
