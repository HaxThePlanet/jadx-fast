package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class z implements com.google.android.gms.internal.firebase-auth-api.r1 {

    final com.google.android.gms.internal.firebase-auth-api.ak a;
    z(com.google.android.gms.internal.firebase-auth-api.ak ak) {
        this.a = ak;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.r1
    public final Iterator a(com.google.android.gms.internal.firebase-auth-api.s1 s1, java.lang.CharSequence charSequence2) {
        b bVar = new b(this, s1, charSequence2, this.a.a(charSequence2));
        return bVar;
    }
}
