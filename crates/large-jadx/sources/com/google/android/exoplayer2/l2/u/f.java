package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
final class f {

    static class a {
    }

    public static final class b {

        public final long[] a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;
        private b(long[] lArr, int[] i2Arr2, int i3, long[] l4Arr4, int[] i5Arr5, long l6) {
            super();
            this.a = lArr;
            this.b = i2Arr2;
            this.c = i3;
            this.d = l4Arr4;
            this.e = i5Arr5;
            this.f = l6;
        }

        b(long[] lArr, int[] i2Arr2, int i3, long[] l4Arr4, int[] i5Arr5, long l6, com.google.android.exoplayer2.l2.u.f.a f$a7) {
            super(lArr, i2Arr2, i3, l4Arr4, i5Arr5, l6, a7);
        }
    }
    public static com.google.android.exoplayer2.l2.u.f.b a(int i, long[] l2Arr2, int[] i3Arr3, long l4) {
        int i2;
        int i5;
        int i8;
        int i4;
        int i3;
        int i6;
        int i7;
        long l;
        long l2;
        int[] iArr = i3Arr3;
        i9 /= i;
        i5 = 0;
        i3 = i8;
        while (i8 < iArr.length) {
            i3 += i6;
            i8++;
        }
        final long[] lArr = new long[i3];
        final int[] iArr2 = new int[i3];
        final long[] lArr2 = new long[i3];
        final int[] iArr3 = new int[i3];
        i7 = i4;
        for (int i3 : obj0) {
            l = l2Arr2[i5];
            while (i3 > 0) {
                i6 = Math.min(i10, i3);
                lArr[i4] = l;
                iArr2[i4] = i * i6;
                i7 = Math.max(i7, iArr2[i4]);
                lArr2[i4] = l5 *= l4;
                iArr3[i4] = 1;
                l += l2;
                i2 += i6;
                i3 -= i6;
                i4++;
            }
            i6 = Math.min(i10, i3);
            lArr[i4] = l;
            iArr2[i4] = i * i6;
            i7 = Math.max(i7, iArr2[i4]);
            lArr2[i4] = l5 *= l4;
            iArr3[i4] = 1;
            l += l2;
            i2 += i6;
            i3 -= i6;
            i4++;
        }
        super(lArr, iArr2, i7, lArr2, iArr3, l4 * l3, obj13, 0);
        return bVar;
    }
}
