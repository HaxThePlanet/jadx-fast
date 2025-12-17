package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class z7 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.a8, com.google.android.gms.internal.firebase-auth-api.z7> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private z7() {
        super(a8.B());
    }

    z7(com.google.android.gms.internal.firebase-auth-api.y7 y7) {
        super(a8.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.z7 j(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        a8.F((a8)this.b, wq);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.z7 m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        a8.E((a8)this.b, i2);
        return this;
    }
}
