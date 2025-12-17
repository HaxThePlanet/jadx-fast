package com.google.zxing.j.b;

import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.zxing.WriterException;
import com.google.zxing.g.c;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class g {

    private static final byte[] a;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final Charset e;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            g.a.a = iArr;
            iArr[c.TEXT.ordinal()] = 1;
            g.a.a[c.BYTE.ordinal()] = 2;
            g.a.a[c.NUMERIC.ordinal()] = 3;
        }
    }
    static {
        int i3;
        int i2;
        int i;
        byte[] length;
        byte b;
        byte[] bArr;
        int length2;
        Object obj;
        int i4 = 30;
        byte[] bArr5 = new byte[i4];
        bArr5 = new byte[]{
            48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
            38, 13, 9, 44, 58, 35, 45, 46, 36, 47,
            43, 37, 42, 61, 94, 0, 32, 0, 0, 0
        };
        g.a = bArr5;
        byte[] bArr2 = new byte[i4];
        bArr2 = new byte[]{
            59, 60, 62, 64, 91, 92, 93, 95, 96, 126,
            33, 13, 9, 44, 58, 10, 45, 46, 36, 47,
            34, 124, 42, 40, 41, 63, 123, 125, 39, 0
        };
        g.b = bArr2;
        int i5 = 128;
        byte[] bArr6 = new byte[i5];
        g.c = bArr6;
        g.d = new byte[i5];
        g.e = StandardCharsets.ISO_8859_1;
        i3 = -1;
        Arrays.fill(bArr6, i3);
        i = i2;
        bArr = g.a;
        while (i < bArr.length) {
            b = bArr[i];
            if (b > 0) {
            }
            i++;
            bArr = g.a;
            g.c[b] = (byte)i;
        }
        Arrays.fill(g.d, i3);
        byte[] bArr4 = g.b;
        while (i2 < bArr4.length) {
            i3 = bArr4[i2];
            if (i3 > 0) {
            }
            i2++;
            bArr4 = g.b;
            g.d[i3] = (byte)i2;
        }
    }

    private static int a(String string, int i2, Charset charset3) {
        int i;
        char charAt2;
        char charAt;
        boolean encode;
        int i4;
        int i3;
        final int length = string.length();
        i = i2;
        while (i < length) {
            charAt = string.charAt(i);
            i4 = 0;
            i3 = 13;
            while (i4 < i3) {
                if (g.k(charAt)) {
                }
                charAt = i + i4;
                if (charAt < length) {
                }
                charAt = string.charAt(charAt);
                i3 = 13;
            }
            charAt2 = string.charAt(i);
            i++;
            if (g.k(charAt)) {
            }
            charAt = i + i4;
            if (charAt < length) {
            }
            charAt = string.charAt(charAt);
        }
        return i -= i2;
    }

    private static int b(java.lang.CharSequence charSequence, int i2) {
        int i;
        char charAt;
        boolean z;
        int obj5;
        final int length = charSequence.length();
        i = 0;
        if (i2 < length) {
            charAt = charSequence.charAt(i2);
            while (g.k(charAt)) {
                if (obj5 < length) {
                }
                i++;
                obj5++;
                if (obj5 < length) {
                }
                charAt = charSequence.charAt(obj5);
            }
        }
        return i;
    }

    private static int c(java.lang.CharSequence charSequence, int i2) {
        int i4;
        char charAt;
        int i;
        int i3;
        boolean z;
        final int length = charSequence.length();
        i4 = i2;
        while (i4 < length) {
            charAt = charSequence.charAt(i4);
            i = 0;
            i3 = 13;
            while (i < i3) {
                if (g.k(charAt)) {
                }
                if (i4 < length) {
                }
                i++;
                i4++;
                if (i4 < length) {
                }
                i3 = 13;
                charAt = charSequence.charAt(i4);
            }
            if (i <= 0) {
            } else {
            }
            if (g.n(charSequence.charAt(i4))) {
            }
            i4++;
            if (g.k(charAt)) {
            }
            if (i4 < length) {
            }
            i++;
            i4++;
            if (i4 < length) {
            }
            charAt = charSequence.charAt(i4);
        }
        return i4 -= i2;
    }

    private static void d(byte[] bArr, int i2, int i3, int i4, StringBuilder stringBuilder5) {
        int i8;
        char[] cArr;
        int i9;
        int i;
        int i5;
        char c2;
        int i6;
        int i7;
        long l;
        char c;
        int obj13;
        if (i3 == 1 && i4 == 0) {
            if (i4 == 0) {
                stringBuilder5.append('\u0391');
            } else {
                if (i3 % 6 == 0) {
                    stringBuilder5.append('\u039c');
                } else {
                    stringBuilder5.append('\u0385');
                }
            }
        } else {
        }
        obj13 = 6;
        if (i3 >= obj13) {
            i8 = 5;
            cArr = new char[i8];
            i9 = i2;
            while (i10 -= i9 >= obj13) {
                i5 = 0;
                i7 = i6;
                while (i7 < obj13) {
                    i11 += l;
                    i7++;
                }
                while (i6 < i8) {
                    i7 = 900;
                    cArr[i6] = (char)i16;
                    i5 /= i7;
                    i6++;
                }
                i = 4;
                while (i >= 0) {
                    stringBuilder5.append(cArr[i]);
                    i--;
                }
                i9 += 6;
                stringBuilder5.append(cArr[i]);
                i--;
                i7 = 900;
                cArr[i6] = (char)i16;
                i5 /= i7;
                i6++;
                i11 += l;
                i7++;
            }
        } else {
            i9 = i2;
        }
        while (i9 < i2 + i3) {
            stringBuilder5.append((char)obj13);
            i9++;
        }
    }

    static String e(String string, com.google.zxing.j.b.c c2, Charset charset3) {
        boolean characterSetECIByName;
        int i2;
        int i4;
        int i7;
        int i6;
        int i;
        int i3;
        int length;
        int i5;
        byte[] obj11;
        int obj12;
        Object obj13;
        StringBuilder stringBuilder = new StringBuilder(string.length());
        if (charset3 == null) {
            obj13 = g.e;
        } else {
            characterSetECIByName = c.getCharacterSetECIByName(charset3.name());
            if (!g.e.equals(charset3) && characterSetECIByName != null) {
                characterSetECIByName = c.getCharacterSetECIByName(charset3.name());
                if (characterSetECIByName != null) {
                    g.h(characterSetECIByName.getValue(), stringBuilder);
                }
            }
        }
        int length2 = string.length();
        obj12 = g.a.a[c2.ordinal()];
        int i8 = 1;
        final int i9 = 0;
        if (obj12 != i8) {
            i2 = 2;
            if (obj12 != i2) {
                i7 = 902;
                if (obj12 != 3) {
                    i6 = i4;
                    while (obj12 < length2) {
                        i = g.b(string, obj12);
                        if (i >= 13) {
                        } else {
                        }
                        length = g.c(string, obj12);
                        if (length < 5) {
                        } else {
                        }
                        if (i6 != 0) {
                        }
                        i4 = g.g(string, obj12, length, stringBuilder, i4);
                        obj12 += length;
                        stringBuilder.append('\u0384');
                        i6 = i4;
                        if (i == length2) {
                        } else {
                        }
                        if (g.a(string, obj12, obj13) == 0) {
                        }
                        i3 += obj12;
                        obj12 = string.substring(obj12, i).getBytes(obj13);
                        if (obj12.length == i8 && i6 == 0) {
                        } else {
                        }
                        g.d(obj12, i9, obj12.length, i6, stringBuilder);
                        i6 = i8;
                        i4 = i9;
                        obj12 = i;
                        if (i6 == 0) {
                        } else {
                        }
                        g.d(obj12, i9, i8, i9, stringBuilder);
                        i3 = i8;
                        stringBuilder.append(i7);
                        g.f(string, obj12, i, stringBuilder);
                        obj12 += i;
                        i4 = i9;
                        i6 = i2;
                    }
                } else {
                    stringBuilder.append(i7);
                    g.f(string, i9, length2, stringBuilder);
                }
            } else {
                obj11 = string.getBytes(obj13);
                g.d(obj11, i9, obj11.length, i8, stringBuilder);
            }
        } else {
            g.g(string, i9, length2, stringBuilder, i9);
        }
        return stringBuilder.toString();
    }

    private static void f(String string, int i2, int i3, StringBuilder stringBuilder4) {
        int i;
        int i5;
        int i6;
        String string2;
        BigInteger bigInteger;
        int i4;
        StringBuilder stringBuilder = new StringBuilder(i7++);
        BigInteger valueOf = BigInteger.valueOf(900);
        final int i11 = 0;
        i = i11;
        while (i < i3) {
            stringBuilder.setLength(i11);
            i5 = Math.min(44, i3 - i);
            StringBuilder stringBuilder2 = new StringBuilder("1");
            int i14 = i2 + i;
            stringBuilder2.append(string.substring(i14, i14 + i5));
            bigInteger = new BigInteger(stringBuilder2.toString());
            stringBuilder.append((char)intValue);
            while (bigInteger.divide(valueOf).equals(BigInteger.valueOf(0)) != null) {
                stringBuilder.append((char)intValue);
            }
            length--;
            while (i6 >= 0) {
                stringBuilder4.append(stringBuilder.charAt(i6));
                i6--;
            }
            i += i5;
            stringBuilder4.append(stringBuilder.charAt(i6));
            i6--;
        }
    }

    private static int g(java.lang.CharSequence charSequence, int i2, int i3, StringBuilder stringBuilder4, int i5) {
        int i6;
        int i11;
        int i10;
        int i9;
        int charAt3;
        int charAt2;
        int i12;
        char charAt;
        boolean z;
        int i7;
        int i4;
        int i8;
        int i;
        Object obj = charSequence;
        int i13 = i3;
        final Object obj2 = stringBuilder4;
        StringBuilder stringBuilder = new StringBuilder(i13);
        final int i14 = 2;
        final int i15 = 0;
        final int i16 = 1;
        i10 = i5;
        i9 = i15;
        charAt2 = i2 + i9;
        charAt = obj.charAt(charAt2);
        z = 26;
        i7 = 32;
        i4 = 28;
        i8 = 27;
        i = 29;
        do {
            charAt2 = i2 + i9;
            charAt = obj.charAt(charAt2);
            z = 26;
            i7 = 32;
            i4 = 28;
            i8 = 27;
            i = 29;
            if (g.j(charAt)) {
            } else {
            }
            if (g.i(charAt)) {
            } else {
            }
            if (g.l(charAt)) {
            } else {
            }
            stringBuilder.append(i);
            stringBuilder.append((char)b5);
            if (i9++ < i13) {
            }
            stringBuilder.append(i4);
            i10 = i14;
            stringBuilder.append(i8);
            i10 = i16;
            if (charAt == i7) {
            } else {
            }
            stringBuilder.append((char)charAt);
            stringBuilder.append(z);
            if (i10 != i16) {
            } else {
            }
            if (g.i(charAt)) {
            } else {
            }
            if (g.j(charAt)) {
            } else {
            }
            if (g.l(charAt)) {
            } else {
            }
            stringBuilder.append(i);
            stringBuilder.append((char)b4);
            stringBuilder.append(i4);
            stringBuilder.append(i8);
            stringBuilder.append((char)charAt);
            if (charAt == i7) {
            } else {
            }
            stringBuilder.append((char)charAt);
            stringBuilder.append(z);
            if (i10 != i14) {
            } else {
            }
            if (g.l(charAt)) {
            } else {
            }
            if (g.j(charAt)) {
            } else {
            }
            if (g.i(charAt)) {
            } else {
            }
            charAt2++;
            if (i12 < i13) {
            } else {
            }
            stringBuilder.append(i);
            stringBuilder.append((char)b2);
            if (g.m(obj.charAt(i12))) {
            } else {
            }
            i10 = 3;
            stringBuilder.append('\u0019');
            stringBuilder.append(i8);
            stringBuilder.append(i4);
            i10 = i15;
            stringBuilder.append((char)b);
            if (g.m(charAt)) {
            } else {
            }
            stringBuilder.append(i);
            stringBuilder.append((char)b3);
        } while (i10 != 0);
        int length = stringBuilder.length();
        charAt3 = i11;
        while (i11 < length) {
            if (i11 % 2 != 0) {
            } else {
            }
            charAt2 = i15;
            if (charAt2 != 0) {
            } else {
            }
            charAt3 = stringBuilder.charAt(i11);
            i11++;
            obj2.append((char)i19);
            charAt2 = i16;
        }
        if (length %= i14 != 0) {
            obj2.append((char)charAt3);
        }
        return i10;
    }

    private static void h(int i, StringBuilder stringBuilder2) {
        int i2 = 900;
        if (i >= 0 && i < i2) {
            if (i < i2) {
                stringBuilder2.append('\u039f');
                stringBuilder2.append((char)i);
            }
        }
        int i6 = 810900;
        if (i < i6) {
            stringBuilder2.append('\u039e');
            stringBuilder2.append((char)i10);
            stringBuilder2.append((char)obj2);
        }
        if (i >= 811800) {
        } else {
            stringBuilder2.append('\u039d');
            stringBuilder2.append((char)i7);
        }
        WriterException obj3 = new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
        throw obj3;
    }

    private static boolean i(char c) {
        int i;
        if (c != 32 && c >= 97 && c <= 122) {
            if (c >= 97) {
                if (c <= 122) {
                }
            }
            return 0;
        }
        return 1;
    }

    private static boolean j(char c) {
        int i;
        if (c != 32 && c >= 65 && c <= 90) {
            if (c >= 65) {
                if (c <= 90) {
                }
            }
            return 0;
        }
        return 1;
    }

    private static boolean k(char c) {
        int i;
        if (c >= 48 && c <= 57) {
            if (c <= 57) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean l(char c) {
        if (g.c[c] != -1) {
            return 1;
        }
        return 0;
    }

    private static boolean m(char c) {
        if (g.d[c] != -1) {
            return 1;
        }
        return 0;
    }

    private static boolean n(char c) {
        int i;
        if (c != 9 && c != 10 && c != 13 && c >= 32 && c <= 126) {
            if (c != 10) {
                if (c != 13) {
                    if (c >= 32) {
                        if (c <= 126) {
                        }
                    }
                    return 0;
                }
            }
        }
        return 1;
    }
}
