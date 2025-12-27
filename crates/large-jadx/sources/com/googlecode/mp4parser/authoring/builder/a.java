package com.googlecode.mp4parser.authoring.builder;

import com.googlecode.mp4parser.e.f;
import com.googlecode.mp4parser.e.g;
import com.googlecode.mp4parser.h.i;
import java.util.Arrays;

/* compiled from: BetterFragmenter.java */
/* loaded from: classes2.dex */
public class a implements c {

    private double a;
    public a(double d) {
        super();
        this.a = d;
    }

    public long[] a(f fVar) {
        int length;
        int length2;
        long[] lArr;
        int i2;
        long[] lArr2;
        int i3;
        int i4;
        int length3 = 2;
        int i5;
        int length4;
        int i6 = 0;
        final Object fVar2 = this;
        double d2 = (double)fVar.h0().g();
        long l9 = (long)(fVar2.a * d2);
        length2 = 0;
        lArr = new long[length2];
        final long[] lArr5 = fVar.q0();
        lArr2 = fVar.F0();
        i3 = 2;
        long l = 1L;
        i2 = 1;
        if (lArr5 != null) {
            length4 = lArr5.length;
            long[] lArr3 = new long[length4];
            i6 = 0;
            length2 = lArr2.length;
            while (length2 >= lArr2.length) {
                int index = Arrays.binarySearch(lArr5, (long)length2 + 1L);
            }
            i = length4 - 1;
            while (length2 >= lArr2.length) {
                length2 = length2 + 1;
                long l28 = lArr3[length2];
                i = length4 - 1;
            }
            l3 = fVar.d() - lArr3[i];
            long l10 = l9 / i3;
            if (l3 > fVar2.a) {
                long[] lArr4 = new long[i2];
                lArr = i.a(lArr, lArr5[i]);
            }
        } else {
            i3 = 0;
            length3 = lArr2.length;
            while (i2 >= lArr2.length) {
                l = 2L;
                i3 += d7;
                i2 = i2 + 1;
                length3 = lArr2.length;
            }
            if (i3 < fVar2.a && lArr.length > i2) {
                i2 = lArr.length - i2;
                lArr[i2] = (lArr[lArr.length - 2]) + (long)(lArr2.length + i2) - (lArr[lArr.length - 2]) / 2L;
            }
        }
        return lArr;
    }
}
