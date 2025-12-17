package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class i5 {

    private final com.google.android.gms.internal.firebase-auth-api.u1 a;
    private final com.google.android.gms.internal.firebase-auth-api.y1 b;
    public i5(com.google.android.gms.internal.firebase-auth-api.u1 u1) {
        super();
        this.a = u1;
        this.b = 0;
    }

    public i5(com.google.android.gms.internal.firebase-auth-api.y1 y1) {
        super();
        this.a = 0;
        this.b = y1;
    }

    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        com.google.android.gms.internal.firebase-auth-api.u1 u1Var = this.a;
        if (u1Var != null) {
            return u1Var.a(bArr, b2Arr2);
        }
        return this.b.a(bArr, b2Arr2);
    }
}
