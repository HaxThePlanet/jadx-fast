package com.squareup.moshi;

/* loaded from: classes2.dex */
final class j {
    static String a(int i, int[] i2Arr2, String[] string3Arr3, int[] i4Arr4) {
        int i2;
        int i4;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        i2 = 0;
        while (i2 < i) {
            i4 = i2Arr2[i2];
            if (i4 != 1 && i4 != 2) {
            } else {
            }
            stringBuilder.append('[');
            stringBuilder.append(i4Arr4[i2]);
            stringBuilder.append(']');
            i2++;
            if (i4 != 2) {
            } else {
            }
            if (i4 != 3 && i4 != 4 && i4 != 5) {
            } else {
            }
            stringBuilder.append('.');
            if (string3Arr3[i2] != null) {
            }
            stringBuilder.append(string3Arr3[i2]);
            if (i4 != 4) {
            } else {
            }
            if (i4 != 5) {
            } else {
            }
        }
        return stringBuilder.toString();
    }
}
