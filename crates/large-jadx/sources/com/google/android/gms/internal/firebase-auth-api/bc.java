package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class bc {
    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i4) {
        int i;
        int remaining;
        byte b2;
        byte b;
        if (i4 < 0) {
        } else {
            if (byteBuffer2.remaining() < i4) {
            } else {
                if (byteBuffer3.remaining() < i4) {
                } else {
                    if (byteBuffer.remaining() < i4) {
                    } else {
                        i = 0;
                        while (i < i4) {
                            byteBuffer.put((byte)i2);
                            i++;
                        }
                    }
                }
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        throw obj3;
    }

    public static final boolean b(byte[] bArr, byte[] b2Arr2) {
        int length;
        int length2;
        int length3;
        byte b;
        final int i = 0;
        if (bArr != null) {
            if (b2Arr2 == null) {
            } else {
                if (bArr.length == b2Arr2.length) {
                    length2 = length;
                    for (byte b2 : bArr) {
                        length2 |= length3;
                    }
                    if (length2 == 0) {
                        return 1;
                    }
                }
            }
        }
        return i;
    }

    public static byte[] c(byte[]... bArrArr) {
        int i;
        int i3;
        int i4;
        int length;
        int i5;
        int i2;
        int length2;
        final int i6 = 0;
        i3 = i;
        while (i < bArrArr.length) {
            length = obj.length;
            i3 += length;
            i++;
        }
        byte[] bArr = new byte[i3];
        i5 = i4;
        while (i4 < bArrArr.length) {
            i2 = bArrArr[i4];
            length2 = i2.length;
            System.arraycopy(i2, i6, bArr, i5, length2);
            i5 += length2;
            i4++;
        }
        return bArr;
    }

    public static final byte[] d(byte[] bArr, byte[] b2Arr2) {
        final int length = bArr.length;
        if (length != b2Arr2.length) {
        } else {
            int i = 0;
            return bc.e(bArr, i, b2Arr2, i, length);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("The lengths of x and y should match.");
        throw obj2;
    }

    public static final byte[] e(byte[] bArr, int i2, byte[] b3Arr3, int i4, int i5) {
        int i3;
        int i;
        byte b;
        byte b2;
        if (length -= i5 < i2) {
        } else {
            if (length2 -= i5 < i4) {
            } else {
                byte[] bArr2 = new byte[i5];
                i = 0;
                while (i < i5) {
                    bArr2[i] = (byte)i7;
                    i++;
                }
                return bArr2;
            }
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        throw obj4;
    }
}
