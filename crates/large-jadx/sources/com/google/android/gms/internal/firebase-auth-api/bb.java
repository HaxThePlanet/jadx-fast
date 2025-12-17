package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class bb extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.cb, com.google.android.gms.internal.firebase-auth-api.bb> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private bb() {
        super(cb.B());
    }

    bb(com.google.android.gms.internal.firebase-auth-api.ab ab) {
        super(cb.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.bb j(com.google.android.gms.internal.firebase-auth-api.fb fb) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        cb.F((cb)this.b, fb);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.bb m(int i) {
        final int i2 = 0;
        if (this.c) {
            h();
            this.c = i2;
        }
        cb.E((cb)this.b, i2);
        return this;
    }
}
