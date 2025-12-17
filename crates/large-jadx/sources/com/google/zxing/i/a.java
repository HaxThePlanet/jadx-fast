package com.google.zxing.i;

import android.accounts.Account;

/* loaded from: classes2.dex */
public final class a extends com.google.zxing.i.m {

    static final char[] a;
    static final int[] b;
    static {
        a.a = "0123456789-$:/.+ABCD".toCharArray();
        int[] iArr = new int[20];
        iArr = new int[]{
            3, 6, 9, 96, 18, 66, 33, 36, 48, 72,
            12, 24, 69, 81, 84, 21, 26, 41, 11, 14
        };
        a.b = iArr;
    }

    static boolean a(char[] cArr, char c2) {
        int length;
        int i;
        char c;
        final int i2 = 0;
        if (cArr != null) {
            i = i2;
            while (i < cArr.length) {
                i++;
            }
        }
        return i2;
    }
}
