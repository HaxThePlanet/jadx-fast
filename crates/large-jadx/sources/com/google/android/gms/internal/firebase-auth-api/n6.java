package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class n6 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.o6, com.google.android.gms.internal.firebase-auth-api.n6> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private n6() {
        super(o6.B());
    }

    n6(com.google.android.gms.internal.firebase-auth-api.m6 m6) {
        super(o6.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.n6 j(com.google.android.gms.internal.firebase-auth-api.v6 v6) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        o6.G((o6)this.b, v6);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.n6 m(com.google.android.gms.internal.firebase-auth-api.o9 o9) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        o6.H((o6)this.b, o9);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.n6 s(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        o6.F((o6)this.b, i);
        return this;
    }
}
