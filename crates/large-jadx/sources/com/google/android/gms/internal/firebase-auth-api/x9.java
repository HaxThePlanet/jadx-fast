package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class x9 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.aa, com.google.android.gms.internal.firebase-auth-api.x9> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private x9() {
        super(aa.B());
    }

    x9(com.google.android.gms.internal.firebase-auth-api.w9 w9) {
        super(aa.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x9 j(com.google.android.gms.internal.firebase-auth-api.z9 z9) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        aa.H((aa)this.b, z9);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x9 m(String string) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        aa.F((aa)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x9 s(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        aa.G((aa)this.b, wq);
        return this;
    }
}
