package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class vb implements com.google.android.gms.internal.firebase-auth-api.u1 {

    private static final java.lang.ThreadLocal<Cipher> e;
    private static final java.lang.ThreadLocal<Cipher> f;
    private final byte[] a;
    private final byte[] b;
    private final SecretKeySpec c;
    private final int d;
    static {
        tb tbVar = new tb();
        vb.e = tbVar;
        ub ubVar = new ub();
        vb.f = ubVar;
    }

    public vb(byte[] bArr, int i2) {
        super();
        final int i = 16;
        if (i2 != 12) {
            if (i2 != i) {
            } else {
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("IV size should be either 12 or 16 bytes");
            throw obj3;
        }
        this.d = i2;
        ed.b(bArr.length);
        SecretKeySpec obj4 = new SecretKeySpec(bArr, "AES");
        this.c = obj4;
        obj3 = vb.e.get();
        (Cipher)obj3.init(1, obj4);
        obj3 = vb.c(obj3.doFinal(new byte[i]));
        this.a = obj3;
        this.b = vb.c(obj3);
    }

    private static byte[] c(byte[] bArr) {
        int i2;
        byte b;
        int i;
        int i3;
        byte[] bArr2 = new byte[16];
        final int i5 = 0;
        i2 = i5;
        int i7 = 15;
        while (i2 < i7) {
            byte b3 = bArr[i2];
            i = i2 + 1;
            bArr2[i2] = (byte)i10;
            i2 = i;
            i7 = 15;
        }
        byte b2 = bArr[i7];
        bArr2[i7] = (byte)obj6;
        return bArr2;
    }

    private final byte[] d(Cipher cipher, int i2, byte[] b3Arr3, int i4, int i5) {
        int i6;
        int i3;
        int i7;
        int i;
        byte b;
        byte b2;
        byte[] obj8;
        byte[] obj9;
        byte[] obj10;
        int obj11;
        i6 = 16;
        byte[] bArr = new byte[i6];
        bArr[15] = (byte)i2;
        if (i5 == 0) {
            return cipher.doFinal(vb.e(bArr, this.a));
        }
        obj8 = cipher.doFinal(bArr);
        i3 = 0;
        i7 = i3;
        while (i5 - i7 > i6) {
            i = i3;
            while (i < i6) {
                obj8[i] = (byte)i11;
                i++;
            }
            obj8 = cipher.doFinal(obj8);
            i7 += 16;
            obj8[i] = (byte)i11;
            i++;
        }
        obj9 = Arrays.copyOfRange(b3Arr3, i7 += i4, i4 += i5);
        if (obj9.length == i6) {
            obj9 = vb.e(obj9, this.a);
        } else {
            obj10 = Arrays.copyOf(this.b, i6);
            obj11 = obj9.length;
            for (byte i6 : b3Arr3) {
                obj10[i3] = (byte)obj11;
                obj11 = obj9.length;
            }
            obj10[obj11] = (byte)obj9;
            obj9 = obj10;
        }
        return cipher.doFinal(vb.e(obj8, obj9));
    }

    private static byte[] e(byte[] bArr, byte[] b2Arr2) {
        int i;
        byte b;
        byte b2;
        final int length = bArr.length;
        final byte[] bArr2 = new byte[length];
        i = 0;
        while (i < length) {
            bArr2[i] = (byte)i2;
            i++;
        }
        return bArr2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] a(byte[] bArr, byte[] b2Arr2) {
        int i2;
        int i;
        byte[] bArr2;
        int i3;
        int length = bArr.length;
        i7 += -16;
        if (i8 < 0) {
        } else {
            final Object obj6 = obj;
            final int i20 = 1;
            (Cipher)obj6.init(i20, this.c);
            int i17 = 0;
            Object obj3 = this;
            Object obj5 = obj6;
            final byte[] bArr6 = obj3.d(obj5, 0, bArr, i17, this.d);
            i = i2;
            while (i2 < 16) {
                i = (byte)i10;
                i2++;
            }
            if (i != 0) {
            } else {
                Object obj14 = vb.f.get();
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr6);
                (Cipher)obj14.init(i20, this.c, ivParameterSpec);
                return obj14.doFinal(bArr, this.d, i8);
            }
            AEADBadTagException obj13 = new AEADBadTagException("tag mismatch");
            throw obj13;
        }
        obj13 = new GeneralSecurityException("ciphertext too short");
        throw obj13;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.u1
    public final byte[] b(byte[] bArr, byte[] b2Arr2) {
        throw 0;
    }
}
