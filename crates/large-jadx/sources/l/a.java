package l;

import java.util.Arrays;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class a {

    private static final byte[] a;
    static {
        l.i.a aVar = i.v;
        a.a = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").k();
        aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").k();
    }

    public static final byte[] a(String string) {
        int length;
        int i8;
        int i4;
        int i9;
        int i2;
        char charAt;
        int i10;
        int i;
        int i6;
        int i3;
        int i5;
        int i11;
        char charAt2;
        int i12;
        int i7;
        byte obj15;
        n.f(string, "$this$decodeBase64ToArray");
        length = string.length();
        i8 = 9;
        i4 = 32;
        i9 = 13;
        i2 = 10;
        while (length > 0) {
            charAt = string.charAt(length + -1);
            if (charAt != 61) {
                break;
            } else {
            }
            length--;
            i8 = 9;
            i4 = 32;
            i9 = 13;
            i2 = 10;
            if (charAt != i2) {
                break;
            } else {
            }
            if (charAt != i9) {
                break;
            } else {
            }
            if (charAt != i4) {
                break;
            } else {
            }
            if (charAt != i8) {
                break;
            } else {
            }
        }
        int i16 = (int)i15;
        byte[] bArr = new byte[i16];
        i5 = i3;
        i11 = 0;
        while (i < length) {
            charAt2 = string.charAt(i);
            charAt2 = 62;
            i21 |= charAt2;
            if (i6 % 4 == 0) {
            }
            i++;
            i11 = 0;
            int i23 = i5 + 1;
            bArr[i5] = (byte)i24;
            int i22 = i23 + 1;
            bArr[i23] = (byte)i25;
            bArr[i22] = (byte)i3;
            i5 = i11;
            charAt2 = 63;
            charAt2 += 4;
            charAt2 += -71;
            charAt2 += -65;
        }
        i6 %= 4;
        if (i20 != 1) {
            if (i20 != 2) {
                if (i20 != 3) {
                } else {
                    obj15 = i3 << 6;
                    length = i5 + 1;
                    bArr[i5] = (byte)i13;
                    i5 = length + 1;
                    bArr[length] = (byte)obj15;
                }
            } else {
                bArr[i5] = (byte)obj15;
                i5 = length;
            }
            if (i5 == i16) {
                return bArr;
            }
            obj15 = Arrays.copyOf(bArr, i5);
            n.e(obj15, "java.util.Arrays.copyOf(this, newSize)");
            return obj15;
        }
        return i11;
    }

    public static final String b(byte[] bArr, byte[] b2Arr2) {
        int i4;
        int i;
        int i3;
        byte b2;
        int i5;
        byte b;
        int i7;
        int i6;
        int i2;
        int i8;
        int obj10;
        byte obj11;
        n.f(bArr, "$this$encodeBase64");
        n.f(b2Arr2, "map");
        i4 = 2;
        byte[] bArr2 = new byte[i10 *= 4];
        length2 -= i15;
        i3 = i;
        while (i < i13) {
            int i25 = i + 1;
            byte b6 = bArr[i];
            int i33 = i25 + 1;
            byte b8 = bArr[i25];
            b = bArr[i33];
            int i34 = i3 + 1;
            bArr2[i3] = b2Arr2[i36 >>= i4];
            int i23 = i34 + 1;
            bArr2[i34] = b2Arr2[i20 |= i8];
            int i22 = i23 + 1;
            bArr2[i23] = b2Arr2[i27 |= i2];
            i3 = i22 + 1;
            bArr2[i22] = b2Arr2[b & 63];
            i = i6;
        }
        length4 -= i13;
        int i14 = 61;
        if (i5 != 1) {
            if (i5 != i4) {
            } else {
                byte b4 = bArr[i];
                obj10 = bArr[i + 1];
                i5 = i3 + 1;
                bArr2[i3] = b2Arr2[i30 >>= i4];
                i3 = i5 + 1;
                bArr2[i5] = b2Arr2[i17 |= i7];
                bArr2[i3] = b2Arr2[obj10 <<= i4];
                bArr2[i3 + 1] = (byte)i14;
            }
        } else {
            obj10 = bArr[i];
            i = i3 + 1;
            bArr2[i3] = b2Arr2[i5 >> 2];
            i4 = i + 1;
            bArr2[i] = b2Arr2[obj10 <<= 4];
            obj11 = (byte)i14;
            bArr2[i4] = obj11;
            bArr2[i4 + 1] = obj11;
        }
        return b.b(bArr2);
    }

    public static String c(byte[] bArr, byte[] b2Arr2, int i3, Object object4) {
        byte[] obj1;
        if (i3 &= 1 != 0) {
            obj1 = a.a;
        }
        return a.b(bArr, obj1);
    }
}
