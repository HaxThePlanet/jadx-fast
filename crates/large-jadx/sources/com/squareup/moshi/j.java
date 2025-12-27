package com.squareup.moshi;

/* compiled from: JsonScope.java */
/* loaded from: classes2.dex */
final class j {
    static String a(int i, int[] iArr, String[] strArr, int[] iArr2) {
        int i2 = 0;
        int i3 = 93;
        int i4 = 3;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        i2 = 0;
        while (i2 < i) {
            i3 = iArr[i2];
            i4 = 1;
            i2 = i2 + 1;
        }
        return stringBuilder.toString();
    }
}
