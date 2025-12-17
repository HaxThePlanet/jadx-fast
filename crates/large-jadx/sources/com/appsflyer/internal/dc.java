package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class dc {
    public static char[] AFInAppEventType(long l, char[] c2Arr2) {
        int i;
        int i3;
        int i2;
        char c;
        int i4;
        final int length = obj12.length;
        final char[] cArr = new char[length];
        final int i5 = 4;
        i2 = i5;
        i3 = i;
        for (char c : obj12) {
            i4 = 1;
            if (Long.compare(i7, i4) == 0) {
            } else {
            }
            if (i2 < length) {
            } else {
            }
            cArr[i3] = obj12[i];
            i3++;
            cArr[i2] = c;
            i2++;
            if (i3 >= i5 && i2 < length) {
            } else {
            }
        }
        return cArr;
    }
}
