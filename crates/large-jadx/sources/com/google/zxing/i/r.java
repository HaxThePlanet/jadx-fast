package com.google.zxing.i;

/* loaded from: classes2.dex */
public final class r extends com.google.zxing.i.p {

    static final int[][] f;
    static {
        int[][] iArr = new int[2];
        int i2 = 10;
        int[] iArr3 = new int[i2];
        iArr3 = new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
        int[] iArr2 = new int[i2];
        iArr2 = new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26};
        r.f = iArr;
    }

    public static String c(String string) {
        char[] cArr;
        int i;
        char obj10;
        cArr = new char[6];
        final int i4 = 7;
        int i5 = 0;
        string.getChars(1, i4, cArr, i5);
        StringBuilder stringBuilder = new StringBuilder(12);
        stringBuilder.append(string.charAt(i5));
        i = 5;
        final char c = cArr[i];
        final String str = "00000";
        final String str2 = "0000";
        final int i8 = 3;
        final int i9 = 2;
        switch (c) {
            case 48:
                stringBuilder.append(cArr, i5, i9);
                stringBuilder.append(c);
                stringBuilder.append(str2);
                stringBuilder.append(cArr, i9, i8);
                break;
            case 49:
                stringBuilder.append(cArr, i5, i8);
                stringBuilder.append(str);
                stringBuilder.append(cArr, i8, i9);
                break;
            case 50:
                i = 4;
                stringBuilder.append(cArr, i5, i);
                stringBuilder.append(str);
                stringBuilder.append(cArr[i]);
                break;
            default:
                stringBuilder.append(cArr, i5, i);
                stringBuilder.append(str2);
                stringBuilder.append(c);
        }
        if (string.length() >= 8) {
            stringBuilder.append(string.charAt(i4));
        }
        return stringBuilder.toString();
    }
}
