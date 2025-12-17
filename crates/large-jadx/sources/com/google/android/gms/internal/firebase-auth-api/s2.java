package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class s2<P>  {

    private final P a;
    private final byte[] b;
    private final com.google.android.gms.internal.firebase-auth-api.ca c;
    private final com.google.android.gms.internal.firebase-auth-api.hb d;
    s2(P p, byte[] b2Arr2, com.google.android.gms.internal.firebase-auth-api.ca ca3, com.google.android.gms.internal.firebase-auth-api.hb hb4, int i5) {
        super();
        this.a = p;
        this.b = Arrays.copyOf(b2Arr2, b2Arr2.length);
        this.c = ca3;
        this.d = hb4;
    }

    public final com.google.android.gms.internal.firebase-auth-api.ca a() {
        return this.c;
    }

    public final com.google.android.gms.internal.firebase-auth-api.hb b() {
        return this.d;
    }

    public final P c() {
        return this.a;
    }

    public final byte[] d() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
