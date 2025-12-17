package com.google.android.exoplayer2.l2;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class d implements com.google.android.exoplayer2.l2.q {

    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public d(int[] iArr, long[] l2Arr2, long[] l3Arr3, long[] l4Arr4) {
        int obj1;
        long[] obj2;
        super();
        this.b = iArr;
        this.c = l2Arr2;
        this.d = l3Arr3;
        this.e = l4Arr4;
        obj1 = iArr.length;
        this.a = obj1;
        if (obj1 > 0) {
            obj2 = l3Arr3[obj1 + -1];
            obj1 = l4Arr4[obj1--];
        }
    }

    @Override // com.google.android.exoplayer2.l2.q
    public String toString() {
        String string2 = Arrays.toString(this.b);
        String string3 = Arrays.toString(this.c);
        String string4 = Arrays.toString(this.e);
        String string5 = Arrays.toString(this.d);
        StringBuilder stringBuilder = new StringBuilder(i4 += length4);
        stringBuilder.append("ChunkIndex(length=");
        stringBuilder.append(this.a);
        stringBuilder.append(", sizes=");
        stringBuilder.append(string2);
        stringBuilder.append(", offsets=");
        stringBuilder.append(string3);
        stringBuilder.append(", timeUs=");
        stringBuilder.append(string4);
        stringBuilder.append(", durationsUs=");
        stringBuilder.append(string5);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
