package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class m7 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.n7, com.google.android.gms.internal.firebase-auth-api.m7> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private m7() {
        super(n7.B());
    }

    m7(com.google.android.gms.internal.firebase-auth-api.l7 l7) {
        super(n7.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.m7 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        n7.F((n7)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.m7 m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        n7.E((n7)this.b, i2);
        return this;
    }
}
