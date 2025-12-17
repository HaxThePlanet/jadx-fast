package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class e6 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.f6, com.google.android.gms.internal.firebase-auth-api.e6> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private e6() {
        super(f6.B());
    }

    e6(com.google.android.gms.internal.firebase-auth-api.d6 d6) {
        super(f6.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.e6 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        f6.G((f6)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.e6 m(com.google.android.gms.internal.firebase-auth-api.l6 l6) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        f6.H((f6)this.b, l6);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.e6 s(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        f6.F((f6)this.b, i2);
        return this;
    }
}
