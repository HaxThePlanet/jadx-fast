package com.google.android.gms.internal.firebase-auth-api;

import java.util.regex.Matcher;

/* loaded from: classes2.dex */
final class b extends com.google.android.gms.internal.firebase-auth-api.z0 {

    final com.google.android.gms.internal.firebase-auth-api.zi x;
    b(com.google.android.gms.internal.firebase-auth-api.z z, com.google.android.gms.internal.firebase-auth-api.s1 s12, java.lang.CharSequence charSequence3, com.google.android.gms.internal.firebase-auth-api.zi zi4) {
        this.x = zi4;
        super(s12, charSequence3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.z0
    public final int d(int i) {
        return obj1.a.end();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.z0
    public final int e(int i) {
        if (ziVar.a.find(i)) {
            return obj2.a.start();
        }
        return -1;
    }
}
