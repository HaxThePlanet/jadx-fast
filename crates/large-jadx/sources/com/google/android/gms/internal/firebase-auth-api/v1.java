package com.google.android.gms.internal.firebase-auth-api;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class v1 implements com.google.android.gms.internal.firebase-auth-api.m2 {

    private final OutputStream a;
    private v1(OutputStream outputStream) {
        super();
        this.a = outputStream;
    }

    public static com.google.android.gms.internal.firebase-auth-api.m2 c(OutputStream outputStream) {
        v1 v1Var = new v1(outputStream);
        return v1Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.m2
    public final void a(com.google.android.gms.internal.firebase-auth-api.na na) {
        try {
            na.c(this.a);
            this.a.close();
            this.a.close();
            throw na;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.m2
    public final void b(com.google.android.gms.internal.firebase-auth-api.j9 j9) {
        throw 0;
    }
}
