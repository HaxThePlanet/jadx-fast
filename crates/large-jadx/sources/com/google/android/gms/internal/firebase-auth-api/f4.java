package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class f4 implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private static final byte[] c;
    private final com.google.android.gms.internal.firebase-auth-api.fa a;
    private final com.google.android.gms.internal.firebase-auth-api.u1 b;
    static {
        f4.c = new byte[0];
    }

    public f4(com.google.android.gms.internal.firebase-auth-api.fa fa, com.google.android.gms.internal.firebase-auth-api.u1 u12) {
        super();
        this.a = fa;
        this.b = u12;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        byte[] obj6;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int int = wrap.getInt();
        if (int <= 0) {
        } else {
            if (int > obj6 += -4) {
            } else {
                try {
                    obj6 = new byte[int];
                    int i = 0;
                    wrap.get(obj6, i, int);
                    byte[] bArr2 = new byte[wrap.remaining()];
                    wrap.get(bArr2, i, wrap.remaining());
                    return (u1)c3.i(this.a.E(), this.b.a(obj6, f4.c), u1.class).a(bArr2, b2Arr2);
                    obj6 = new GeneralSecurityException("invalid ciphertext");
                    throw obj6;
                    b2Arr2 = new GeneralSecurityException(obj0, bArr);
                    throw b2Arr2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }
}
