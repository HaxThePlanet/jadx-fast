package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
final class m {

    public final com.google.android.exoplayer2.l2.u.j a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final long[] e;
    public final int[] f;
    public final long g;
    public m(com.google.android.exoplayer2.l2.u.j j, long[] l2Arr2, int[] i3Arr3, int i4, long[] l5Arr5, int[] i6Arr6, long l7) {
        int i;
        int obj4;
        long[] obj5;
        int[] obj6;
        int obj7;
        super();
        i = 0;
        final int i2 = 1;
        obj7 = i3Arr3.length == l5Arr5.length ? i2 : i;
        g.a(obj7);
        obj7 = l2Arr2.length == l5Arr5.length ? i2 : i;
        g.a(obj7);
        i = i6Arr6.length == l5Arr5.length ? i2 : i;
        g.a(i);
        this.a = j;
        this.c = l2Arr2;
        this.d = i3Arr3;
        this.e = l5Arr5;
        this.f = i6Arr6;
        this.g = l7;
        this.b = l2Arr2.length;
        if (i6Arr6.length > 0) {
            obj4 -= i2;
            i6Arr6[obj4] = obj5 |= obj6;
        }
    }
}
