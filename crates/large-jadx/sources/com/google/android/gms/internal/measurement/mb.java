package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class mb {

    private static final com.google.android.gms.internal.measurement.jb a;
    static {
        boolean z;
        if (hb.C() && hb.D()) {
            if (hb.D()) {
                z = m7.a;
            }
        }
        kb kbVar = new kb();
        mb.a = kbVar;
    }

    static int a(byte[] bArr, int i2, int i3) {
        int b;
        int i4;
        int i5;
        int i;
        byte obj6;
        int obj7;
        int obj8;
        b = bArr[i2 + -1];
        i3 -= i2;
        final int i7 = -12;
        if (obj8 != null) {
            i4 = 1;
            i5 = -65;
            if (obj8 != i4) {
                if (obj8 != 2) {
                } else {
                    obj8 = bArr[i2];
                    obj6 = bArr[i2 += i4];
                    if (b <= i7 && obj8 <= i5) {
                        if (obj8 <= i5) {
                            if (obj6 > i5) {
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
                if (obj6 > i5) {
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
        int i5;
        byte b2;
        int i;
        char charAt;
        int i2;
        byte b;
        int surrogatePair;
        int i6;
        boolean obj7;
        byte[] obj8;
        int obj9;
        int obj10;
        final int length = charSequence.length();
        i4 += i3;
        i5 = 0;
        int i10 = 128;
        while (i5 < length) {
            i = i5 + i3;
            if (i < obj10) {
            }
            charAt = charSequence.charAt(i5);
            if (charAt < i10) {
            }
            b2Arr2[i] = (byte)charAt;
            i5++;
            i10 = 128;
        }
        if (i5 == length) {
            i3 += length;
        } else {
            i3 += i5;
            while (i5 < length) {
                char charAt3 = charSequence.charAt(i5);
                int i16 = 57343;
                int i20 = 55296;
                charAt = i5 + 1;
                char charAt2 = charSequence.charAt(charAt);
                int codePoint = Character.toCodePoint(charAt3, charAt2);
                int i15 = obj9 + 1;
                b2Arr2[obj9] = (byte)i27;
                obj9 = i15 + 1;
                b2Arr2[i15] = (byte)i30;
                i = obj9 + 1;
                b2Arr2[obj9] = (byte)i33;
                obj9 = i + 1;
                b2Arr2[i] = (byte)i8;
                i5 = charAt;
                i5++;
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
        int i5;
        int i3;
        char charAt;
        int i2;
        int length;
        int i4;
        int codePointAt;
        int i;
        int length2 = charSequence.length();
        i3 = i5;
        while (i3 < length2) {
            if (charSequence.charAt(i3) < 128) {
            }
            i3++;
        }
        i2 = length2;
        while (i3 < length2) {
            char charAt2 = charSequence.charAt(i3);
            i4 = 2048;
            if (charAt2 >= i4) {
                break;
            } else {
            }
            i2 += length;
            i3++;
        }
        if (i2 < length2) {
        } else {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("UTF-8 length does not fit in int: ");
        stringBuilder.append(l += l2);
        IllegalArgumentException obj8 = new IllegalArgumentException(stringBuilder.toString());
        throw obj8;
    }

    static String d(byte[] bArr, int i2, int i3) {
        int i7;
        char c;
        int i5;
        int i;
        int i6;
        char[] cArr;
        int i8;
        int i4;
        int obj11;
        int length = bArr.length;
        int i16 = 0;
        if (i11 |= i15 < 0) {
        } else {
            int i10 = i2 + i3;
            char[] obj12 = new char[i3];
            i7 = i16;
            while (obj11 < i10) {
                c = bArr[obj11];
                if (!ib.d(c)) {
                    break;
                } else {
                }
                obj11++;
                obj12[i7] = (char)c;
                i7 = i5;
            }
            while (obj11 < i10) {
                c = obj11 + 1;
                obj11 = bArr[obj11];
                int i22 = c + 1;
                int i23 = i22 + 1;
                ib.a(obj11, bArr[c], bArr[i22], bArr[i23], obj12, i7);
                i7 += 2;
                obj11 = i4;
                int i20 = c + 1;
                ib.c(obj11, bArr[c], bArr[i20], obj12, i7);
                obj11 = i;
                i7 = i6;
                ib.b(obj11, bArr[c], obj12, i7);
                obj11 = i5;
                i7 = i;
                i5 = i7 + 1;
                obj12[i7] = (char)obj11;
                obj11 = c;
                i7 = i5;
                while (obj11 < i10) {
                    c = bArr[obj11];
                    if (!ib.d(c)) {
                        break loop_9;
                    } else {
                    }
                    obj11++;
                    i5 = i7 + 1;
                    obj12[i7] = (char)c;
                    i7 = i5;
                }
                c = bArr[obj11];
                if (!ib.d(c)) {
                } else {
                }
                obj11++;
                i5 = i7 + 1;
                obj12[i7] = (char)c;
            }
            String obj10 = new String(obj12, i16, i7);
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
        return mb.a.b(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i2, int i3) {
        return mb.a.b(bArr, i2, i3);
    }
}
