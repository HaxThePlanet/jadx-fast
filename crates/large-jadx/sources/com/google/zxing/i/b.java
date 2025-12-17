package com.google.zxing.i;

/* loaded from: classes2.dex */
public final class b extends com.google.zxing.i.n {

    private static final char[] a;
    private static final char[] b;
    private static final char[] c;
    private static final char d = 0;
    static {
        int i = 4;
        final char[] cArr2 = new char[i];
        cArr2 = new short[]{'A', 'B', 'C', 'D'};
        b.a = cArr2;
        final char[] cArr3 = new char[i];
        cArr3 = new short[]{'T', 'N', '*', 'E'};
        b.b = cArr3;
        char[] cArr = new char[i];
        cArr = new short[]{'/', ':', '+', '.'};
        b.c = cArr;
        char c = cArr2[0];
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String string) {
        boolean stringBuilder;
        int i4;
        boolean z;
        int i5;
        int i3;
        boolean charAt2;
        int i2;
        boolean charAt;
        int upperCase;
        int i8;
        String str;
        int i6;
        int i;
        int length;
        int i7;
        String obj11;
        int i10 = 0;
        int i11 = 1;
        if (string.length() < 2) {
            stringBuilder = new StringBuilder();
            z = b.d;
            stringBuilder.append(z);
            stringBuilder.append(string);
            stringBuilder.append(z);
            obj11 = stringBuilder.toString();
            i4 = 20;
            i5 = i11;
            while (i5 < length5 -= i11) {
                i4 += 9;
                i5++;
                i4 += 10;
            }
            boolean[] zArr = new boolean[i4 += i14];
            i2 = i3;
            while (i3 < obj11.length()) {
                upperCase = Character.toUpperCase(obj11.charAt(i3));
                if (i3 != 0) {
                } else {
                }
                if (upperCase != 42) {
                } else {
                }
                upperCase = 67;
                i6 = i10;
                i = a.a;
                for (char i : obj7) {
                    i = a.a;
                }
                i8 = i10;
                length = str;
                i = i11;
                while (str < 7) {
                    zArr[i2] = i;
                    i2++;
                    if (i17 &= i11 != 0) {
                    } else {
                    }
                    i ^= 1;
                    str++;
                    length = i10;
                    if (length == i11) {
                    } else {
                    }
                    length++;
                }
                if (i3 < length7 -= i11) {
                }
                i3++;
                zArr[i2] = i10;
                i2++;
                zArr[i2] = i;
                i2++;
                if (i17 &= i11 != 0) {
                } else {
                }
                i ^= 1;
                str++;
                length = i10;
                if (length == i11) {
                } else {
                }
                length++;
                if (upperCase == i[i6]) {
                } else {
                }
                i6++;
                i8 = a.b[i6];
                if (upperCase != 69) {
                } else {
                }
                upperCase = 68;
                if (upperCase != 78) {
                } else {
                }
                upperCase = 66;
                if (upperCase != 84) {
                } else {
                }
                upperCase = 65;
                if (i3 == length8 -= i11) {
                }
            }
            return zArr;
        } else {
            char upperCase2 = Character.toUpperCase(string.charAt(i10));
            char upperCase3 = Character.toUpperCase(string.charAt(length3 -= i11));
            char[] cArr = b.a;
            charAt2 = a.a(cArr, upperCase3);
            char[] cArr3 = b.b;
            z = a.a(cArr3, upperCase3);
            str = "Invalid start/end guards: ";
            if (a.a(cArr, upperCase2)) {
                if (!charAt2) {
                } else {
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str.concat(String.valueOf(string)));
                throw illegalArgumentException;
            }
            if (a.a(cArr3, upperCase2)) {
                if (!z) {
                } else {
                }
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(str.concat(String.valueOf(string)));
                throw illegalArgumentException2;
            }
            if (charAt2) {
            } else {
                if (z) {
                } else {
                    stringBuilder = new StringBuilder();
                    z = b.d;
                    stringBuilder.append(z);
                    stringBuilder.append(string);
                    stringBuilder.append(z);
                    obj11 = stringBuilder.toString();
                }
            }
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(str.concat(String.valueOf(string)));
        throw illegalArgumentException3;
    }
}
