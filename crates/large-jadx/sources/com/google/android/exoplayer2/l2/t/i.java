package com.google.android.exoplayer2.l2.t;

import com.google.android.exoplayer2.audio.b0.a;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
final class i implements com.google.android.exoplayer2.l2.t.g {

    private final long a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;
    private i(long l, int i2, long l3) {
        super(l, obj2, l3, obj13, obj5, -1, obj7, 0);
    }

    private i(long l, int i2, long l3, long l4, long[] l5Arr5) {
        int obj3;
        super();
        this.a = l;
        this.b = l3;
        this.c = l4;
        this.f = obj8;
        this.d = obj6;
        if (Long.compare(obj6, obj3) == 0) {
        } else {
            obj3 = l + obj6;
        }
        this.e = obj3;
    }

    public static com.google.android.exoplayer2.l2.t.i d(long l, long l2, b0.a b0$a3, d0 d04) {
        int string;
        String str;
        int cmp;
        int i2;
        int i3;
        int i;
        long stringBuilder;
        string = l;
        final Object obj = obj26;
        int i13 = obj27.n();
        if (i13 & 1 == 1) {
            i = obj27.B();
            if (i == 0) {
            } else {
                final long l6 = p0.y0((long)i, obj8, l3 *= i17);
                if (i13 & 6 != 6) {
                    super(a3, obj15, obj.c, l6, obj18);
                    return iVar2;
                }
                final long l7 = obj27.z();
                int i9 = 100;
                long[] lArr = new long[i9];
                i2 = 0;
                while (i2 < i9) {
                    lArr[i2] = (long)i14;
                    i2++;
                }
                i3 = a3 + l7;
                if (Long.compare(string, i3) != 0 && Long.compare(string, i3) != 0) {
                    i3 = a3 + l7;
                    if (Long.compare(string, i3) != 0) {
                        stringBuilder = new StringBuilder(67);
                        stringBuilder.append("XING data size mismatch: ");
                        stringBuilder.append(string);
                        stringBuilder.append(", ");
                        stringBuilder.append(i3);
                        v.h("XingSeeker", stringBuilder.toString());
                    }
                }
            }
            super(a3, obj15, obj.c, l6, obj18, l7, obj20, lArr);
            return iVar;
        }
        return null;
    }

    private long e(int i) {
        return i2 /= i4;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long a() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public boolean b() {
        int i;
        i = this.f != null ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long c(long l) {
        boolean cmp;
        long l2;
        long i;
        int obj12;
        l -= l3;
        if (b()) {
            if (Long.compare(obj12, l4) <= 0) {
            } else {
                long[] lArr = this.f;
                g.h(lArr);
                obj12 /= d2;
                final int i6 = 1;
                int i4 = p0.h((long[])lArr, (long)obj12, obj2, i6);
                long l8 = e(i4);
                final long l9 = lArr[i4];
                int i7 = i4 + 1;
                l2 = i4 == 99 ? 256 : i;
                if (Long.compare(l9, l2) == 0) {
                    obj12 = 0;
                } else {
                    obj12 /= l2;
                }
            }
            return l8 += obj12;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long getDurationUs() {
        return this.c;
    }
}
