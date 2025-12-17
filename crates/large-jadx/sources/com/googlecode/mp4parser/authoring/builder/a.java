package com.googlecode.mp4parser.authoring.builder;

import com.googlecode.mp4parser.e.f;
import com.googlecode.mp4parser.e.g;
import com.googlecode.mp4parser.h.i;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class a implements com.googlecode.mp4parser.authoring.builder.c {

    private double a;
    public a(double d) {
        super();
        this.a = d;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.c
    public long[] a(f f) {
        int lArr2;
        int i7;
        int i6;
        int binarySearch;
        int length2;
        long[] lArr5;
        int i8;
        int i3;
        long[] lArr3;
        long[] lArr4;
        int lArr;
        long l;
        int i4;
        int length;
        int length3;
        long[] lArr6;
        int i;
        int i5;
        int i2;
        final Object obj = this;
        double d = (double)l2;
        long l4 = (long)i11;
        i3 = 0;
        lArr3 = new long[i3];
        final long[] lArr7 = f.q0();
        lArr4 = f.F0();
        lArr = 2;
        i4 = 1;
        final int i17 = 1;
        if (lArr7 != null) {
            length3 = lArr7.length;
            lArr6 = new long[length3];
            i7 = i3;
            i2 = i5;
            for (long l8 : obj8) {
                binarySearch = Arrays.binarySearch(lArr7, l7 += i4);
                if (binarySearch >= 0) {
                }
                i2 += l8;
                lArr = 2;
                lArr6[binarySearch] = i2;
            }
            i6 = i3;
            binarySearch = length3 + -1;
            while (i6 >= binarySearch) {
                length2 = i6 + 1;
                i2 = lArr6[length2];
                if (Long.compare(i5, i2) <= 0 && Long.compare(i4, i2) < 0) {
                }
                i6 = length2;
                binarySearch = length3 + -1;
                if (Long.compare(i4, i2) < 0) {
                }
                lArr4 = new long[i17];
                lArr4[i3] = lArr7[i6];
                lArr3 = i.a(lArr3, lArr4);
                i5 = i4;
            }
            if (Long.compare(i, lArr5) > 0) {
                lArr2 = new long[i17];
                lArr2[i3] = lArr7[binarySearch];
                lArr3 = i.a(lArr3, lArr2);
            }
        } else {
            new long[i17][i3] = i4;
            int i14 = 0;
            lArr = i14;
            i8 = i17;
            while (i8 >= lArr4.length) {
                i4 = 2;
                if (Double.compare(lArr, d5) >= 0 && i8 > 0) {
                }
                i8++;
                if (i8 > 0) {
                }
                lArr = i14;
                lArr = new long[i17];
                lArr[i3] = (long)l;
                lArr5 = i.a(lArr5, lArr);
            }
            if (Double.compare(lArr, d2) < 0 && lArr5.length > i17) {
                if (lArr5.length > i17) {
                    lArr5[length6 -= i17] = l6 += lArr2;
                }
            }
            lArr3 = lArr5;
        }
        return lArr3;
    }
}
