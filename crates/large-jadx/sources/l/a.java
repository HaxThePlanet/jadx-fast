package l;

import java.util.Arrays;
import kotlin.d0.d.n;

/* compiled from: -Base64.kt */
/* loaded from: classes3.dex */
public final class a {

    private static final byte[] a;
    static {
        l.i.a aVar = i.v;
        a.a = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").k();
        aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").k();
    }

    public static final byte[] a(String str) {
        int length;
        char charAt;
        char c5 = 61;
        int i = 63;
        char charAt2;
        char c6 = 47;
        char c7 = 97;
        n.f(str, "$this$decodeBase64ToArray");
        length = str.length();
        char c = '\t';
        char c2 = ' ';
        char c3 = '\r';
        char c4 = '\n';
        while (length > 0) {
            charAt = str.charAt(length - 1);
            c5 = '=';
            if (charAt != '=' && charAt != c4 && charAt != c3 && charAt != c2 && charAt != c) {
                break;
            }
        }
        int i3 = (int)(long)length * 6L / 8L;
        byte[] bArr = new byte[i3];
        length = 0;
        length = 0;
        while (length < length) {
            charAt2 = str.charAt(length);
            c6 = 'Z';
            c7 = 'A';
            if (c6 < charAt2) {
                c6 = 'z';
                c7 = 'a';
            }
        }
        length %= 4;
        if (i7 != 1 && i7 != 2) {
            if (i7 == 3) {
                int i16 = length << 6;
                length = length + 1;
                b = (byte)(i16 >> 16);
                bArr[length] = b;
                length = length + 1;
                b2 = (byte)(i16 >> 8);
                bArr[length] = b2;
            }
            if (length == i3) {
                return bArr;
            }
            byte[] copy = Arrays.copyOf(bArr, length);
            n.e(copy, "java.util.Arrays.copyOf(this, newSize)");
            return copy;
        }
        return null;
    }

    public static final String b(byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        n.f(bArr, "$this$encodeBase64");
        n.f(bArr2, "map");
        int i = 2;
        byte[] bArr3 = new byte[(bArr.length + i) / 3 * 4];
        int i12 = bArr.length - (bArr.length % 3);
        i2 = 0;
        while (i2 < i12) {
            int i24 = i2 + 1;
            byte b7 = bArr[i2];
            int i32 = i24 + 1;
            byte b9 = bArr[i24];
            i2 = i32 + 1;
            byte b2 = bArr[i32];
            int i33 = i2 + 1;
            bArr3[i2] = bArr2[(b7 & 255) >> i];
            int i22 = i33 + 1;
            i6 = (b9 & 255) >> 4;
            bArr3[i33] = bArr2[(b7 & 3) << 4 | i6];
            int i21 = i22 + 1;
            i5 = (b2 & 255) >> 6;
            bArr3[i22] = bArr2[(b9 & 15) << i | i5];
            i2 = i21 + 1;
            bArr3[i21] = bArr2[b2 & 63];
        }
        i3 = bArr.length - i12;
        int i13 = 61;
        int i4 = 1;
        if (bArr.length == 1) {
            byte b13 = bArr[i2];
            i2 = i2 + 1;
            i3 = b13 & 255;
            bArr3[i2] = bArr2[i3 >> 2];
            i = i2 + 1;
            bArr3[i2] = bArr2[(b13 & 3) << 4];
            i7 = i + 1;
            b3 = (byte)i13;
            bArr3[i] = b3;
            bArr3[i7] = b3;
        } else {
            if (bArr.length == i) {
                byte b5 = bArr[i2];
                byte b15 = bArr[i2 + 1];
                i3 = i2 + 1;
                bArr3[i2] = bArr2[(b5 & 255) >> i];
                i2 = i3 + 1;
                i4 = (b15 & 255) >> 4;
                bArr3[i3] = bArr2[(b5 & 3) << 4 | i4];
                i2 = i2 + 1;
                bArr3[i2] = bArr2[(b15 & 15) << i];
                bArr3[i2] = (byte)i13;
            }
        }
        return b.b(bArr3);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i, Object object) {
        byte[] bArr3;
        if (i & 1 != 0) {
            bArr3 = a.a;
        }
        return a.b(bArr, bArr3);
    }
}
