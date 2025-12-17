package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zb implements com.google.android.gms.internal.firebase-auth-api.y1 {

    private static final Collection<Integer> c;
    private static final byte[] d;
    private final com.google.android.gms.internal.firebase-auth-api.xc a;
    private final byte[] b;
    static {
        Integer[] arr = new Integer[1];
        zb.c = Arrays.asList(64);
        zb.d = new byte[16];
    }

    public zb(byte[] bArr) {
        super();
        int length = bArr.length;
        if (!zb.c.contains(Integer.valueOf(length))) {
        } else {
            int i = length >> 1;
            this.b = Arrays.copyOfRange(bArr, i, length);
            xc obj4 = new xc(Arrays.copyOfRange(bArr, 0, i));
            this.a = obj4;
        }
        StringBuilder stringBuilder = new StringBuilder(59);
        stringBuilder.append("invalid key size: ");
        stringBuilder.append(length);
        stringBuilder.append(" bytes; key must have 64 bytes");
        obj4 = new InvalidKeyException(stringBuilder.toString());
        throw obj4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        byte[] doFinal;
        byte[] bArr2;
        int i;
        int i2;
        byte[] bArr3;
        SecretKeySpec secretKeySpec;
        IvParameterSpec ivParameterSpec;
        int obj10;
        int obj11;
        int length = bArr.length;
        final int i3 = 16;
        if (length < i3) {
        } else {
            Object obj = mc.e.a("AES/CTR/NoPadding");
            i = 0;
            final byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i3);
            Object clone = copyOfRange.clone();
            int i5 = 8;
            clone[i5] = (byte)i8;
            int i6 = 12;
            clone[i6] = (byte)i9;
            secretKeySpec = new SecretKeySpec(this.b, "AES");
            ivParameterSpec = new IvParameterSpec(clone);
            int i4 = 2;
            (Cipher)obj.init(i4, secretKeySpec, ivParameterSpec);
            obj10 = Arrays.copyOfRange(bArr, i3, length);
            if (obj10.length == 0 && obj.doFinal(obj10) == null && dd.b()) {
                if (obj.doFinal(obj10) == null) {
                    if (dd.b()) {
                        doFinal = new byte[i];
                    }
                }
            }
            obj10 = new byte[i4];
            obj10[i] = b2Arr2;
            obj11 = 1;
            obj10[obj11] = doFinal;
            bArr2 = this.a.a(zb.d, i3);
            i2 = i;
            while (i2 <= 0) {
                if (obj10[i] == null) {
                }
                bArr2 = bc.d(ac.b(bArr2), this.a.a(bArr3, i3));
                i2 = obj11;
                bArr3 = new byte[i];
            }
            obj10 = obj10[obj11];
            obj11 = obj10.length;
            if (obj11 >= i3) {
                int length2 = bArr2.length;
                if (obj11 < length2) {
                } else {
                    obj10 = Arrays.copyOf(obj10, obj11);
                    for (byte ivParameterSpec : obj2) {
                        obj11 = i2 + i;
                        obj10[obj11] = (byte)i7;
                    }
                    if (!bc.b(copyOfRange, this.a.a(obj10, i3))) {
                    } else {
                        return doFinal;
                    }
                    obj10 = new AEADBadTagException("Integrity check failed.");
                    throw obj10;
                }
                obj10 = new IllegalArgumentException("xorEnd requires a.length >= b.length");
                throw obj10;
            }
            obj10 = bc.d(ac.a(obj10), ac.b(bArr2));
        }
        obj10 = new GeneralSecurityException("Ciphertext too short.");
        throw obj10;
    }
}
