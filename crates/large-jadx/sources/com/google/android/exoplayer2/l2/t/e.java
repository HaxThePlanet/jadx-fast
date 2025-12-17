package com.google.android.exoplayer2.l2.t;

import android.util.Pair;
import com.google.android.exoplayer2.m2.k.k;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;

/* loaded from: classes2.dex */
final class e implements com.google.android.exoplayer2.l2.t.g {

    private final long[] a;
    private final long[] b;
    private final long c;
    private e(long[] lArr, long[] l2Arr2, long l3) {
        int obj3;
        long obj5;
        super();
        this.a = lArr;
        this.b = l2Arr2;
        if (Long.compare(l3, l) != 0) {
        } else {
            obj5 = w0.d(l2Arr2[obj3--]);
        }
        this.c = obj5;
    }

    public static com.google.android.exoplayer2.l2.t.e d(long l, k k2, long l3) {
        int i4;
        int i;
        long l2;
        int i3;
        int i2;
        long obj9;
        int length = iArr.length;
        int i5 = length + 1;
        final long[] lArr2 = new long[i5];
        long[] lArr = new long[i5];
        int i6 = 0;
        lArr2[i6] = l;
        lArr[i6] = 0;
        i4 = 1;
        while (i4 <= length) {
            i2 = i4 + -1;
            lArr2[i4] = obj9 += l4;
            lArr[i4] = i += l2;
            i4++;
        }
        obj9 = new e(lArr2, lArr, obj12, obj13);
        return obj9;
    }

    private static Pair<Long, Long> e(long l, long[] l2Arr2, long[] l3Arr3) {
        int i;
        long l2;
        long l3;
        double d;
        int i2 = 1;
        int i5 = p0.h(l3Arr3, l, l2Arr2, i2);
        l2 = l3Arr3[i5];
        final long l4 = obj13[i5];
        i5 += i2;
        if (i6 == l3Arr3.length) {
            return Pair.create(Long.valueOf(l2), Long.valueOf(l4));
        }
        l3 = l3Arr3[i6];
        if (Long.compare(l3, l2) == 0) {
            i = 0;
        } else {
            i4 /= l2;
        }
        return Pair.create(Long.valueOf(l), Long.valueOf(obj12 += l4));
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long a() {
        return -1;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public boolean b() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long c(long l) {
        return w0.d((Long)obj3.second.longValue());
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long getDurationUs() {
        return this.c;
    }
}
