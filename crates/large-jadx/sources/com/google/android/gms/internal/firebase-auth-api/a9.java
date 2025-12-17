package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class a9 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.b9, com.google.android.gms.internal.firebase-auth-api.a9> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private a9() {
        super(b9.C());
    }

    a9(com.google.android.gms.internal.firebase-auth-api.z8 z8) {
        super(b9.C());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.a9 j(com.google.android.gms.internal.firebase-auth-api.v8 v8) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        b9.I((b9)this.b, v8);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.a9 m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        b9.H((b9)this.b, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.a9 s(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        b9.J((b9)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.a9 t(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        b9.K((b9)this.b, wq);
        return this;
    }
}
