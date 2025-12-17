package io.jsonwebtoken.io;

import java.util.Arrays;

/* loaded from: classes3.dex */
final class Base64 {

    private static final char[] BASE64URL_ALPHABET;
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    static final io.jsonwebtoken.io.Base64 DEFAULT;
    private static final int IALPHABET_MAX_INDEX;
    static final io.jsonwebtoken.io.Base64 URL_SAFE;
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;
    static {
        int i;
        int[] bASE64URL_IALPHABET;
        int length;
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        Base64.BASE64_ALPHABET = charArray;
        Base64.BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
        int i2 = 256;
        bASE64URL_IALPHABET = new int[i2];
        Base64.BASE64_IALPHABET = bASE64URL_IALPHABET;
        int[] iArr = new int[i2];
        Base64.BASE64URL_IALPHABET = iArr;
        final int i6 = 1;
        Base64.IALPHABET_MAX_INDEX = length3 -= i6;
        Arrays.fill(bASE64URL_IALPHABET, -1);
        final int i7 = 0;
        System.arraycopy(bASE64URL_IALPHABET, i7, iArr, i7, bASE64URL_IALPHABET.length);
        i = i7;
        while (i < charArray.length) {
            Base64.BASE64_IALPHABET[Base64.BASE64_ALPHABET[i]] = i;
            Base64.BASE64URL_IALPHABET[Base64.BASE64URL_ALPHABET[i]] = i;
            i++;
        }
        int i3 = 61;
        Base64.BASE64_IALPHABET[i3] = i7;
        Base64.BASE64URL_IALPHABET[i3] = i7;
        Base64 base64 = new Base64(i7);
        Base64.DEFAULT = base64;
        Base64 base642 = new Base64(i6);
        Base64.URL_SAFE = base642;
    }

    private Base64(boolean z) {
        char[] bASE64URL_ALPHABET;
        int[] obj2;
        super();
        this.urlsafe = z;
        bASE64URL_ALPHABET = z ? Base64.BASE64URL_ALPHABET : Base64.BASE64_ALPHABET;
        this.ALPHABET = bASE64URL_ALPHABET;
        obj2 = z ? Base64.BASE64URL_IALPHABET : Base64.BASE64_IALPHABET;
        this.IALPHABET = obj2;
    }

    private int ctoi(char c) {
        int i;
        i = c > Base64.IALPHABET_MAX_INDEX ? -1 : iALPHABET[c];
        if (i < 0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal ");
        stringBuilder.append(getName());
        stringBuilder.append(" character: '");
        stringBuilder.append(c);
        stringBuilder.append("'");
        DecodingException decodingException = new DecodingException(stringBuilder.toString());
        throw decodingException;
    }

    private char[] encodeToChar(byte[] bArr, boolean z2) {
        int urlsafe;
        char urlsafe2;
        int i12;
        char c;
        int length;
        int aLPHABET;
        int i7;
        int i9;
        int i10;
        int i14;
        int i13;
        int i4;
        int i2;
        int i8;
        int i;
        int i11;
        int i3;
        int i6;
        int i5;
        char c2;
        final Object obj = this;
        urlsafe = bArr;
        i12 = 0;
        length = urlsafe != 0 ? urlsafe.length : i12;
        if (length == 0) {
            return new char[i12];
        }
        i22 *= 3;
        final int i26 = length - i7;
        final int i27 = 1;
        length -= i27;
        final int i31 = 2;
        i29 <<= i31;
        if (z2) {
            i33 <<= i27;
        } else {
            i10 = i12;
        }
        i30 += i10;
        i14 = i26 == i31 ? i27 : i26 == i27 ? i31 : i12;
        i13 = obj.urlsafe ? i9 - i14 : i9;
        char[] cArr2 = new char[i13];
        i = i8;
        i11 = 10;
        while (i4 < i7) {
            int i40 = i4 + 1;
            int i43 = i40 + 1;
            i36 |= i44;
            int i45 = i8 + 1;
            char[] aLPHABET2 = obj.ALPHABET;
            cArr2[i8] = aLPHABET2[i46 &= 63];
            int i39 = i45 + 1;
            cArr2[i45] = aLPHABET2[i48 &= 63];
            i6 = i39 + 1;
            cArr2[i39] = aLPHABET2[i50 &= 63];
            i8 = i6 + 1;
            cArr2[i6] = aLPHABET2[i37 &= 63];
            if (z2 && i++ == 19 && i8 < i9 + -2) {
            }
            i4 = i3;
            i12 = 0;
            i11 = 10;
            if (i++ == 19) {
            }
            if (i8 < i9 + -2) {
            }
            c = i8 + 1;
            cArr2[i8] = 13;
            cArr2[c] = i11;
            i8 = i2;
            i = 0;
        }
        if (i26 > 0) {
            if (i26 == i31) {
                i5 = urlsafe;
            } else {
                i5 = 0;
            }
            int i16 = i19 | i5;
            aLPHABET = obj.ALPHABET;
            cArr2[i9 + -4] = aLPHABET[i16 >> 12];
            cArr2[i9 + -3] = aLPHABET[i24 &= 63];
            i12 = 61;
            if (i26 == i31) {
                cArr2[i9 + -2] = aLPHABET[i16 &= 63];
            } else {
                if (!obj.urlsafe) {
                    cArr2[i9 + -2] = i12;
                }
            }
            if (!obj.urlsafe) {
                cArr2[i9 -= i27] = i12;
            }
        }
        return cArr2;
    }

    private String getName() {
        String str;
        str = this.urlsafe ? "base64url" : "base64";
        return str;
    }

    final byte[] decodeFast(char[] cArr) {
        int i8;
        int length;
        int i11;
        int i2;
        int i4;
        int i;
        byte b;
        int i12;
        int i7;
        char c;
        int i6;
        int i13;
        int i9;
        int i3;
        int i10;
        int i5;
        byte b2;
        int obj15;
        i8 = 0;
        length = cArr != null ? cArr.length : i8;
        if (length == 0) {
            return new byte[i8];
        }
        i = i8;
        while (i < length + -1) {
            if (this.IALPHABET[cArr[i]] < 0) {
            }
            i++;
        }
        while (i4 > 0) {
            if (this.IALPHABET[cArr[i4]] < 0) {
            }
            i4--;
        }
        int i21 = 61;
        final int i28 = 1;
        if (cArr[i4] == i21) {
            i7 = cArr[i4 + -1] == i21 ? 2 : i28;
        } else {
            i7 = i8;
        }
        i22 += i28;
        i6 = 76;
        if (length > i6) {
            i11 = cArr[i6] == 13 ? i23 / 78 : i8;
            i11 <<= i28;
        } else {
            i2 = i8;
        }
        i26 -= i7;
        byte[] bArr = new byte[i27];
        i3 = i9;
        while (i9 < i29 *= 3) {
            int i32 = i + 1;
            int i36 = i32 + 1;
            int i34 = i36 + 1;
            i17 |= ctoi4;
            int i35 = i9 + 1;
            bArr[i9] = (byte)i38;
            int i30 = i35 + 1;
            bArr[i35] = (byte)i39;
            bArr[i30] = (byte)i18;
            if (i2 > 0 && i3++ == 19) {
            }
            i = i5;
            i9 = i10;
            if (i3++ == 19) {
            }
            i5 += 2;
            i3 = i8;
        }
        if (i9 < i27) {
            i2 = i8;
            while (i <= i4 - i7) {
                i8 |= i19;
                i2 += i28;
                i = i13;
            }
            obj15 = 16;
            while (i9 < i27) {
                bArr[i9] = (byte)i14;
                obj15 += -8;
                i9 = i2;
            }
        }
        return bArr;
    }

    final String encodeToString(byte[] bArr, boolean z2) {
        String string = new String(encodeToChar(bArr, z2));
        return string;
    }
}
