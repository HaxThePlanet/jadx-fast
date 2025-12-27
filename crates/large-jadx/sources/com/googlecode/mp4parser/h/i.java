package com.googlecode.mp4parser.h;

/* compiled from: Mp4Arrays.java */
/* loaded from: classes2.dex */
public final class i {
    public static long[] a(long[] jArr, long... jArr2) {
        long[] lArr;
        long[] lArr2;
        final int i = 0;
        if (jArr == null) {
            lArr = new long[i];
        }
        if (jArr2 == null) {
            lArr2 = new long[i];
        }
        long[] lArr3 = new long[lArr.length + lArr2.length];
        System.arraycopy(lArr, i, lArr3, i, lArr.length);
        System.arraycopy(lArr2, i, lArr3, lArr.length, lArr2.length);
        return lArr3;
    }
}
