package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class ua extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.va, com.google.android.gms.internal.firebase-auth-api.ua> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private ua() {
        super(va.B());
    }

    ua(com.google.android.gms.internal.firebase-auth-api.ta ta) {
        super(va.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ua j(com.google.android.gms.internal.firebase-auth-api.za za) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        va.F((va)this.b, za);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ua m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        va.E((va)this.b, i2);
        return this;
    }
}
