package com.google.android.exoplayer2.l2.t;

import com.google.android.exoplayer2.audio.b0.a;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
final class h implements com.google.android.exoplayer2.l2.t.g {

    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;
    private h(long[] lArr, long[] l2Arr2, long l3, long l4) {
        super();
        this.a = lArr;
        this.b = l2Arr2;
        this.c = l3;
        this.d = obj5;
    }

    public static com.google.android.exoplayer2.l2.t.h d(long l, long l2, b0.a b0$a3, d0 d04) {
        int string;
        String str;
        int i4;
        int cmp;
        StringBuilder stringBuilder;
        int i6;
        int i9;
        int i12;
        int i10;
        int i2;
        int i8;
        int i7;
        long l3;
        int i;
        int i3;
        int i5;
        int i11;
        string = l;
        Object obj = obj26;
        stringBuilder = obj27;
        stringBuilder.J(10);
        int i17 = obj27.n();
        if (i17 <= 0) {
            return null;
        }
        int i23 = obj.d;
        i6 = i23 >= 32000 ? 1152 : 576;
        final long l12 = p0.y0((long)i17, obj8, i26 *= l10);
        int i19 = obj27.D();
        i12 = obj27.D();
        int i24 = obj27.D();
        stringBuilder.J(2);
        l9 += a3;
        final long[] lArr = new long[i19];
        final long[] lArr2 = new long[i19];
        i4 = 0;
        i3 = a3;
        while (i4 < i19) {
            i5 = i12;
            lArr[i4] = i20 /= l6;
            int i22 = i11;
            lArr2[i4] = Math.max(i3, obj12);
            i2 = 2;
            i7 = 0;
            i = obj27.x();
            i3 += l8;
            i4++;
            i8 = i22;
            i12 = i5;
            i9 = 0;
            i10 = 2;
            i7 = 0;
            i = obj27.D();
            i7 = 0;
            i = obj27.A();
            i7 = 0;
            i = obj27.B();
        }
        if (Long.compare(string, i14) != 0 && Long.compare(string, i3) != 0) {
            if (Long.compare(string, i3) != 0) {
                stringBuilder = new StringBuilder(67);
                stringBuilder.append("VBRI data size mismatch: ");
                stringBuilder.append(string);
                stringBuilder.append(", ");
                stringBuilder.append(i3);
                v.h("VbriSeeker", stringBuilder.toString());
            }
        }
        super(lArr, lArr2, l12, obj17, i3, obj19);
        return hVar;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long a() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public boolean b() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long c(long l) {
        final int i = 1;
        return this.a[p0.h(this.b, l, obj5, i)];
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long getDurationUs() {
        return this.c;
    }
}
