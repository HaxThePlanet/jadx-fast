package io.jsonwebtoken.io;

import java.util.Arrays;

/* compiled from: Base64.java */
/* loaded from: classes3.dex */
final class Base64 {

    private static final char[] BASE64URL_ALPHABET;
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    static final Base64 DEFAULT = new Base64(0);
    private static final int IALPHABET_MAX_INDEX = 0;
    static final Base64 URL_SAFE = new Base64(1);
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;
    static {
        int i;
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        Base64.BASE64_ALPHABET = charArray;
        Base64.BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
        int i2 = 256;
        int[] iArr = new int[i2];
        Base64.BASE64_IALPHABET = iArr;
        int[] iArr2 = new int[i2];
        Base64.BASE64URL_IALPHABET = iArr2;
        Base64.IALPHABET_MAX_INDEX = iArr.length - 1;
        Arrays.fill(iArr, -1);
        length = iArr.length;
        i = 0;
        System.arraycopy(iArr, i, iArr2, i, length);
        while (i < charArray.length) {
            Base64.BASE64_IALPHABET[Base64.BASE64_ALPHABET[i]] = i;
            Base64.BASE64URL_IALPHABET[Base64.BASE64URL_ALPHABET[i]] = i;
            i = i + 1;
        }
        int i3 = 61;
        Base64.BASE64_IALPHABET[i3] = i;
        Base64.BASE64URL_IALPHABET[i3] = i;
    }

    private Base64(boolean z) {
        char[] bASE64URL_ALPHABET2;
        int[] bASE64_IALPHABET2;
        super();
        this.urlsafe = z;
        char[] r0 = z ? Base64.BASE64URL_ALPHABET : Base64.BASE64_ALPHABET;
        this.ALPHABET = (z ? Base64.BASE64URL_ALPHABET : Base64.BASE64_ALPHABET);
        z = z ? Base64.BASE64URL_IALPHABET : Base64.BASE64_IALPHABET;
        this.IALPHABET = (z ? Base64.BASE64URL_IALPHABET : Base64.BASE64_IALPHABET);
    }

    private int ctoi(char c) throws DecodingException {
        int i = -1;
        i = c > Base64.IALPHABET_MAX_INDEX ? -1 : iALPHABET2[c];
        if (Base64.IALPHABET_MAX_INDEX < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Illegal ";
            String name = getName();
            String str2 = " character: '";
            String str3 = "'";
            c = str + name + str2 + c + str3;
            throw new DecodingException(c);
        } else {
            return i;
        }
    }

    private char[] encodeToChar(byte[] bArr, boolean z) {
        int length = 0;
        int i2;
        int i3;
        int bArr2 = 0;
        final Object bArr3 = this;
        bArr2 = bArr;
        length = 0;
        int r3 = bArr2 != 0 ? bArr2.length : length;
        if (length == 0) {
            return new char[length];
        }
        i2 = (length / 3) * 3;
        final int i20 = length - i2;
        length = 1;
        i = length - length;
        length = 2;
        int i23 = (i / 3) + length << length;
        if (z) {
            length = (i23 - 1) / 76 << length;
        } else {
        }
        i3 = i23 + length;
        if (i20 == length) {
        } else {
            int r9 = length;
        }
        r9 = bArr3.urlsafe ? i3 - length : i3;
        char[] cArr2 = new char[i3];
        char c3 = '\n';
        while (bArr3.urlsafe < i2) {
            int i32 = length + 1;
            int i35 = i32 + 1;
            length = i35 + 1;
            int i29 = (bArr2[length] & 255) << 16 | (bArr2[i32] & 255) << 8 | (bArr2[i35] & 255);
            int i37 = length + 1;
            cArr2[length] = aLPHABET2[(i29 >>> 18) & 63];
            int i31 = i37 + 1;
            cArr2[i37] = aLPHABET2[(i29 >>> 12) & 63];
            i4 = i31 + 1;
            cArr2[i31] = aLPHABET2[(i29 >>> 6) & 63];
            length = i4 + 1;
            length = i29 & 63;
            cArr2[i4] = aLPHABET2[length];
        }
        if (i20 > 0) {
            if (i20 == length) {
                bArr2 = (bArr2[i] & 255) << length;
            } else {
                bArr2 = 0;
            }
            int i6 = (bArr2[i2] & 255) << c3 | bArr2;
            cArr2[i3 - 4] = aLPHABET22[i6 >> 12];
            cArr2[i3 - 3] = aLPHABET22[(i6 >>> 6) & 63];
            char c5 = '=';
            if (i20 == length) {
                i2 = i3 - 2;
                cArr2[i2] = aLPHABET22[i6 & 63];
            } else {
                if (!bArr3.urlsafe) {
                    cArr2[i3 - 2] = c5;
                }
            }
            if (!bArr3.urlsafe) {
                i3 = i3 - length;
                cArr2[i3] = c5;
            }
        }
        return cArr2;
    }

    private String getName() {
        String str;
        String r0 = this.urlsafe ? "base64url" : "base64";
        return (this.urlsafe ? "base64url" : "base64");
    }

    final byte[] decodeFast(char[] cArr) {
        int length = 0;
        int i;
        int i2;
        char c;
        int i4 = 16;
        length = 0;
        int r1 = cArr != null ? cArr.length : length;
        if (length == 0) {
            return new byte[length];
        }
        i = length - 1;
        while (length < i) {
        }
        while (i > 0) {
            if (this.IALPHABET[cArr[i]] >= 0) {
                break;
            }
        }
        char c7 = '=';
        length = 1;
        if (cArr[i] == c7) {
            int r4 = cArr[i - 1] == c7 ? 2 : length;
        } else {
        }
        int i14 = (i - length) + length;
        int i3 = 76;
        if (length > i3) {
            r1 = cArr[i3] == '\r' ? i14 / 78 : length;
            length = (cArr[i3] == '\r' ? i14 / 78 : length) << length;
        } else {
        }
        int i18 = (i14 - length) * 6 >> 3 - length;
        byte[] bArr = new byte[i18];
        length = (i18 / 3) * 3;
        while (length < length) {
            int i22 = length + 1;
            int i26 = i22 + 1;
            int i24 = i26 + 1;
            length = i24 + 1;
            int i9 = (ctoi(cArr[length]) << 18) | (ctoi(cArr[i22]) << 12) | (ctoi(cArr[i26]) << 6) | ctoi(cArr[i24]);
            int i25 = length + 1;
            bArr[length] = (byte)(i9 >> 16);
            int i20 = i25 + 1;
            b2 = (byte)(i9 >> 8);
            bArr[i25] = b2;
            length = i20 + 1;
            b = (byte)i9;
            bArr[i20] = b;
        }
        if (length < i18) {
            length = i - length;
            while (length <= i - length) {
                length = length + 1;
                length = (length * 6) - 18;
                length = length | (ctoi(cArr[length]) << length);
                length = length + length;
                length = i - length;
            }
            i4 = 16;
            while (length < i18) {
                length = length + 1;
                i = (byte)(length >> i4);
                bArr[length] = i;
                i4 = i4 - 8;
            }
        }
        return bArr;
    }

    final String encodeToString(byte[] bArr, boolean z) throws java.io.UnsupportedEncodingException {
        return new String(encodeToChar(bArr, z));
    }
}
