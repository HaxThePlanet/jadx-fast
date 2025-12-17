package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class x6 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.y6, com.google.android.gms.internal.firebase-auth-api.x6> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private x6() {
        super(y6.B());
    }

    x6(com.google.android.gms.internal.firebase-auth-api.w6 w6) {
        super(y6.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x6 j(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        y6.G((y6)this.b, i);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.x6 m(com.google.android.gms.internal.firebase-auth-api.b7 b7) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        y6.F((y6)this.b, b7);
        return this;
    }
}
