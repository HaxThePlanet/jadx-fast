package com.airbnb.lottie.x.k0;

/* loaded from: classes.dex */
final class d {
    static String a(int i, int[] i2Arr2, String[] string3Arr3, int[] i4Arr4) {
        int i4;
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        i4 = 0;
        while (i4 < i) {
            i2 = i2Arr2[i4];
            if (i2 != 1 && i2 != 2) {
            } else {
            }
            stringBuilder.append('[');
            stringBuilder.append(i4Arr4[i4]);
            stringBuilder.append(']');
            i4++;
            if (i2 != 2) {
            } else {
            }
            if (i2 != 3 && i2 != 4 && i2 != 5) {
            } else {
            }
            stringBuilder.append('.');
            if (string3Arr3[i4] != null) {
            }
            stringBuilder.append(string3Arr3[i4]);
            if (i2 != 4) {
            } else {
            }
            if (i2 != 5) {
            } else {
            }
        }
        return stringBuilder.toString();
    }
}
