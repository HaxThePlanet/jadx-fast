package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ka extends com.google.android.gms.internal.firebase-auth-api.ur<com.google.android.gms.internal.firebase-auth-api.na, com.google.android.gms.internal.firebase-auth-api.ka> implements com.google.android.gms.internal.firebase-auth-api.a0 {
    private ka() {
        super(na.D());
    }

    ka(com.google.android.gms.internal.firebase-auth-api.ja ja) {
        super(na.D());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final int j() {
        return (na)this.b.z();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ka m(com.google.android.gms.internal.firebase-auth-api.ma ma) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        na.H((na)this.b, ma);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ka s(int i) {
        boolean z;
        if (this.c) {
            h();
            this.c = false;
        }
        na.G((na)this.b, i);
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ur
    public final com.google.android.gms.internal.firebase-auth-api.ma t(int i) {
        return (na)this.b.C(i);
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.ma> u() {
        return Collections.unmodifiableList((na)this.b.F());
    }
}
