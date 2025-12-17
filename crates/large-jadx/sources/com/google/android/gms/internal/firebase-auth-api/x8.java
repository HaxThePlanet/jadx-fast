package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class x8 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.y8, com.google.android.gms.internal.firebase-auth-api.x8> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private x8() {
        super(y8.B());
    }

    x8(com.google.android.gms.internal.firebase-auth-api.w8 w8) {
        super(y8.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x8 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        y8.H((y8)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x8 m(com.google.android.gms.internal.firebase-auth-api.b9 b9) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        y8.G((y8)this.b, b9);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x8 s(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        y8.F((y8)this.b, i2);
        return this;
    }
}
