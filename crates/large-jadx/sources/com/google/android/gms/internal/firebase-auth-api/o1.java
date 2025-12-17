package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class o1 {

    private static final com.google.android.gms.internal.firebase-auth-api.l1 a;
    static {
        boolean z;
        if (j1.C() && j1.D()) {
            if (j1.D()) {
                z = lq.a;
            }
        }
        m1 m1Var = new m1();
        o1.a = m1Var;
    }

    static int a(byte[] bArr, int i2, int i3) {
        int b;
        int i;
        int i4;
        int i5;
        byte obj6;
        int obj7;
        int obj8;
        b = bArr[i2 + -1];
        i3 -= i2;
        final int i7 = -12;
        if (obj8 != null) {
            i = 1;
            i4 = -65;
            if (obj8 != i) {
                if (obj8 != 2) {
                } else {
                    obj8 = bArr[i2];
                    obj6 = bArr[i2 += i];
                    if (b <= i7 && obj8 <= i4) {
                        if (obj8 <= i4) {
                            if (obj6 > i4) {
                                b = i8;
                            } else {
                                b = obj7 ^ obj6;
                            }
                        } else {
                        }
                    } else {
                    }
                }
                obj6 = new AssertionError();
                throw obj6;
            }
            obj6 = bArr[i2];
            if (b <= i7) {
                if (obj6 > i4) {
                } else {
                    b ^= obj6;
                }
            } else {
            }
        } else {
            if (b > i7) {
            }
        }
        return b;
    }

    static int b(java.lang.CharSequence charSequence, byte[] b2Arr2, int i3, int i4) {
        int i2;
        byte b2;
        int i6;
        char charAt;
        int i5;
        byte b;
        int surrogatePair;
        int i;
        boolean obj7;
        byte[] obj8;
        int obj9;
        int obj10;
        final int length = charSequence.length();
        i4 += i3;
        i2 = 0;
        int i10 = 128;
        while (i2 < length) {
            i6 = i2 + i3;
            if (i6 < obj10) {
            }
            charAt = charSequence.charAt(i2);
            if (charAt < i10) {
            }
            b2Arr2[i6] = (byte)charAt;
            i2++;
            i10 = 128;
        }
        if (i2 == length) {
            i3 += length;
        } else {
            i3 += i2;
            while (i2 < length) {
                char charAt3 = charSequence.charAt(i2);
                int i16 = 57343;
                int i20 = 55296;
                charAt = i2 + 1;
                char charAt2 = charSequence.charAt(charAt);
                int codePoint = Character.toCodePoint(charAt3, charAt2);
                int i15 = obj9 + 1;
                b2Arr2[obj9] = (byte)i27;
                obj9 = i15 + 1;
                b2Arr2[i15] = (byte)i30;
                i6 = obj9 + 1;
                b2Arr2[obj9] = (byte)i33;
                obj9 = i6 + 1;
                b2Arr2[i6] = (byte)i8;
                i2 = charAt;
                i2++;
                int i17 = obj9 + 1;
                b2Arr2[obj9] = (byte)i22;
                obj9 = i17 + 1;
                b2Arr2[i17] = (byte)i25;
                charAt = obj9 + 1;
                b2Arr2[obj9] = (byte)i14;
                obj9 = charAt;
                charAt = obj9 + 1;
                b2Arr2[obj9] = (byte)i19;
                obj9 = charAt + 1;
                b2Arr2[charAt] = (byte)i12;
                charAt = obj9 + 1;
                b2Arr2[obj9] = (byte)charAt3;
            }
        }
        return obj9;
    }

    static int c(java.lang.CharSequence charSequence) {
        int i3;
        int i4;
        char charAt;
        int i;
        int length;
        int i2;
        int codePointAt;
        int i5;
        int length2 = charSequence.length();
        i4 = i3;
        while (i4 < length2) {
            if (charSequence.charAt(i4) < 128) {
            }
            i4++;
        }
        i = length2;
        while (i4 < length2) {
            char charAt2 = charSequence.charAt(i4);
            i2 = 2048;
            if (charAt2 >= i2) {
                break;
            } else {
            }
            i += length;
            i4++;
        }
        if (i < length2) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("UTF-8 length does not fit in int: ");
        stringBuilder.append(l += l2);
        IllegalArgumentException obj8 = new IllegalArgumentException(stringBuilder.toString());
        throw obj8;
    }

    static String d(byte[] bArr, int i2, int i3) {
        int i4;
        char c;
        int i7;
        int i;
        int i6;
        char[] cArr;
        int i8;
        int i5;
        int obj11;
        int length = bArr.length;
        int i16 = 0;
        if (i11 |= i15 < 0) {
        } else {
            int i10 = i2 + i3;
            char[] obj12 = new char[i3];
            i4 = i16;
            while (obj11 < i10) {
                c = bArr[obj11];
                if (!k1.d(c)) {
                    break;
                } else {
                }
                obj11++;
                obj12[i4] = (char)c;
                i4 = i7;
            }
            while (obj11 < i10) {
                c = obj11 + 1;
                obj11 = bArr[obj11];
                int i22 = c + 1;
                int i23 = i22 + 1;
                k1.a(obj11, bArr[c], bArr[i22], bArr[i23], obj12, i4);
                i4 += 2;
                obj11 = i5;
                int i20 = c + 1;
                k1.c(obj11, bArr[c], bArr[i20], obj12, i4);
                obj11 = i;
                i4 = i6;
                k1.b(obj11, bArr[c], obj12, i4);
                obj11 = i7;
                i4 = i;
                i7 = i4 + 1;
                obj12[i4] = (char)obj11;
                obj11 = c;
                i4 = i7;
                while (obj11 < i10) {
                    c = bArr[obj11];
                    if (!k1.d(c)) {
                        break loop_9;
                    } else {
                    }
                    obj11++;
                    i7 = i4 + 1;
                    obj12[i4] = (char)c;
                    i4 = i7;
                }
                c = bArr[obj11];
                if (!k1.d(c)) {
                } else {
                }
                obj11++;
                i7 = i4 + 1;
                obj12[i4] = (char)c;
            }
            String obj10 = new String(obj12, i16, i4);
            return obj10;
        }
        Object[] arr = new Object[3];
        arr[i16] = Integer.valueOf(length);
        arr[1] = Integer.valueOf(i2);
        arr[2] = Integer.valueOf(i3);
        obj10 = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", arr));
        throw obj10;
    }

    public static boolean e(byte[] bArr) {
        return o1.a.b(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i2, int i3) {
        return o1.a.b(bArr, i2, i3);
    }
}
