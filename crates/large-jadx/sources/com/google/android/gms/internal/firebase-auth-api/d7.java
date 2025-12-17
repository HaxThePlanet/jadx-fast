package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class d7 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.e7, com.google.android.gms.internal.firebase-auth-api.d7> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private d7() {
        super(e7.B());
    }

    d7(com.google.android.gms.internal.firebase-auth-api.c7 c7) {
        super(e7.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.d7 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        e7.H((e7)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.d7 m(com.google.android.gms.internal.firebase-auth-api.k7 k7) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        e7.G((e7)this.b, k7);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.d7 s(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        e7.F((e7)this.b, i2);
        return this;
    }
}
