package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class t9 extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.u9, com.google.android.gms.internal.firebase-auth-api.t9> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private t9() {
        super(u9.C());
    }

    t9(com.google.android.gms.internal.firebase-auth-api.s9 s9) {
        super(u9.C());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.t9 j(com.google.android.gms.internal.firebase-auth-api.l9 l9) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        u9.E((u9)this.b, l9);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.t9 m(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        u9.F((u9)this.b, i);
        return this;
    }
}
