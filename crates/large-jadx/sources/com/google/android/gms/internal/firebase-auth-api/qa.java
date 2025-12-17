package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class qa extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.ra, com.google.android.gms.internal.firebase-auth-api.qa> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private qa() {
        super(ra.B());
    }

    qa(com.google.android.gms.internal.firebase-auth-api.oa oa) {
        super(ra.B());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.qa j(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        ra.F((ra)this.b, i);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.qa m(com.google.android.gms.internal.firebase-auth-api.hb hb) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        ra.D((ra)this.b, hb);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.qa s(com.google.android.gms.internal.firebase-auth-api.ca ca) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        ra.E((ra)this.b, ca);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.qa t(String string) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        ra.C((ra)this.b, string);
        return this;
    }
}
