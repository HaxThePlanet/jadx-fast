package com.google.android.gms.common.util;

import android.graphics.RectF;
import android.graphics.Region.Op;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public class j {

    private static final char[] a;
    private static final char[] b;
    static {
        int i = 16;
        final char[] cArr2 = new char[i];
        cArr2 = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        j.a = cArr2;
        char[] cArr = new char[i];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        j.b = cArr;
    }

    public static String a(byte[] bArr) {
        int i;
        int i3;
        char c;
        int i2;
        char[] cArr;
        char c2;
        int length = bArr.length;
        char[] cArr2 = new char[length += length];
        i3 = i;
        for (byte b : bArr) {
            b &= 255;
            i2 = i3 + 1;
            cArr = j.b;
            cArr2[i3] = cArr[i5 >>> 4];
            i3 = i2 + 1;
            cArr2[i2] = cArr[i5 &= 15];
        }
        String obj7 = new String(cArr2);
        return obj7;
    }

    public static String b(byte[] bArr) {
        return j.c(bArr, false);
    }

    public static String c(byte[] bArr, boolean z2) {
        int i2;
        char c;
        int i;
        final int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length + length);
        i2 = 0;
        while (i2 < length) {
            if (z2) {
            } else {
            }
            char[] cArr = j.a;
            stringBuilder.append(cArr[i4 >>>= 4]);
            stringBuilder.append(cArr[b3 &= 15]);
            i2++;
            if (i2 == length + -1) {
            } else {
            }
            if (b &= 255 != 0) {
            }
        }
        return stringBuilder.toString();
    }
}
