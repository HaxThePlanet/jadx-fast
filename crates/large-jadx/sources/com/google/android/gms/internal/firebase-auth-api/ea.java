package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class ea extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.fa, com.google.android.gms.internal.firebase-auth-api.ea> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private ea() {
        super(fa.A());
    }

    ea(com.google.android.gms.internal.firebase-auth-api.da da) {
        super(fa.A());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ea j(com.google.android.gms.internal.firebase-auth-api.hb hb) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        fa.H((fa)this.b, hb);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ea m(String string) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        fa.F((fa)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ea s(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        fa.G((fa)this.b, wq);
        return this;
    }
}
