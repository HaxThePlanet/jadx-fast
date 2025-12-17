package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class hc implements com.google.android.gms.internal.firebase-auth-api.z1 {

    private static final byte[] g;
    private final ECPrivateKey a;
    private final com.google.android.gms.internal.firebase-auth-api.jc b;
    private final String c;
    private final byte[] d;
    private final com.google.android.gms.internal.firebase-auth-api.gc e;
    private final int f;
    static {
        hc.g = new byte[0];
    }

    public hc(ECPrivateKey eCPrivateKey, byte[] b2Arr2, String string3, int i4, com.google.android.gms.internal.firebase-auth-api.gc gc5) {
        super();
        this.a = eCPrivateKey;
        jc jcVar = new jc(eCPrivateKey);
        this.b = jcVar;
        this.d = b2Arr2;
        this.c = string3;
        this.f = i4;
        this.e = gc5;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.z1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        int i;
        int obj11;
        obj11 = kc.a(this.a.getParams().getCurve());
        i2--;
        if (i3 != 0) {
            if (i3 != 2) {
                obj11++;
            } else {
                obj11 += obj11;
            }
        } else {
            obj11 += obj11;
        }
        int length = bArr.length;
        if (length < obj11) {
        } else {
            return this.e.a(this.b.a(Arrays.copyOfRange(bArr, 0, obj11), this.c, this.d, 0, this.e.zza(), this.f)).a(Arrays.copyOfRange(bArr, obj11, length), hc.g);
        }
        GeneralSecurityException obj10 = new GeneralSecurityException("ciphertext too short");
        throw obj10;
    }
}
