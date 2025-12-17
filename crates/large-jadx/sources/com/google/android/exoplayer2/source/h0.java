package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes2.dex */
public interface h0 {

    public static class a implements com.google.android.exoplayer2.source.h0 {

        private final Random a;
        private final int[] b;
        private final int[] c;
        public a(int i) {
            Random random = new Random();
            super(i, random);
        }

        private a(int i, Random random2) {
            super(h0.a.h(i, random2), random2);
        }

        private a(int[] iArr, Random random2) {
            int[] iArr2;
            int i;
            int obj4;
            super();
            this.b = iArr;
            this.a = random2;
            this.c = new int[iArr.length];
            obj4 = 0;
            for (int i : iArr) {
                this.c[i] = obj4;
            }
        }

        private static int[] h(int i, Random random2) {
            int i4;
            int i2;
            int nextInt;
            int i3;
            final int[] iArr = new int[i];
            i4 = 0;
            while (i4 < i) {
                i2 = i4 + 1;
                nextInt = random2.nextInt(i2);
                iArr[i4] = iArr[nextInt];
                iArr[nextInt] = i4;
                i4 = i2;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public com.google.android.exoplayer2.source.h0 a(int i, int i2) {
            int i6;
            int i4;
            int[] iArr;
            int i5;
            int i3;
            int i7 = i2 - i;
            int[] iArr3 = new int[length -= i7];
            i4 = i6;
            iArr = this.b;
            for (int i9 : obj4) {
                if (iArr[i6] >= i && iArr[i6] < i2) {
                } else {
                }
                if (iArr[i6] >= i) {
                } else {
                }
                iArr = iArr[i6];
                iArr3[i6 - i4] = iArr;
                iArr = this.b;
                i9 -= i7;
                if (iArr[i6] < i2) {
                } else {
                }
                i4++;
            }
            Random obj9 = new Random(this.a.nextLong(), i4);
            h0.a obj8 = new h0.a(iArr3, obj9);
            return obj8;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public int b() {
            int i;
            int length;
            int[] iArr = this.b;
            i = iArr.length > 0 ? iArr[length] : -1;
            return i;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public int c(int i) {
            int i2;
            obj2 += i2;
            if (obj2 >= 0) {
                i2 = this.b[obj2];
            }
            return i2;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public int d(int i) {
            int obj3;
            obj3++;
            int[] iArr2 = this.b;
            obj3 = obj3 < iArr2.length ? iArr2[obj3] : -1;
            return obj3;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public com.google.android.exoplayer2.source.h0 e(int i, int i2) {
            int i10;
            int i7;
            int nextInt;
            int i8;
            int i5;
            int i9;
            int i4;
            int i6;
            int i3;
            int[] iArr = new int[i2];
            final int[] iArr2 = new int[i2];
            i10 = 0;
            i7 = i10;
            while (i7 < i2) {
                iArr[i7] = this.a.nextInt(length2++);
                i5 = i7 + 1;
                nextInt = this.a.nextInt(i5);
                iArr2[i7] = iArr2[nextInt];
                iArr2[nextInt] = i7 += i;
                i7 = i5;
            }
            Arrays.sort(iArr);
            int[] iArr4 = new int[length += i2];
            i9 = i8;
            i6 = this.b;
            while (i10 < length3 += i2) {
                if (i8 < i2 && i9 == iArr[i8]) {
                } else {
                }
                iArr4[i10] = i6[i9];
                if (iArr4[i10] >= i) {
                }
                i9 = i3;
                i10++;
                i6 = this.b;
                iArr4[i10] = i15 += i2;
                if (i9 == iArr[i8]) {
                } else {
                }
                iArr4[i10] = iArr2[i8];
                i8 = i6;
            }
            Random obj10 = new Random(this.a.nextLong(), iArr2);
            h0.a obj9 = new h0.a(iArr4, obj10);
            return obj9;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public int f() {
            int i;
            int length;
            int[] iArr = this.b;
            if (iArr.length > 0) {
                i = iArr[length2--];
            } else {
                i = -1;
            }
            return i;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public com.google.android.exoplayer2.source.h0 g() {
            Random random = new Random(this.a.nextLong(), obj3);
            h0.a aVar = new h0.a(0, random);
            return aVar;
        }

        @Override // com.google.android.exoplayer2.source.h0
        public int getLength() {
            return iArr.length;
        }
    }
    public abstract com.google.android.exoplayer2.source.h0 a(int i, int i2);

    public abstract int b();

    public abstract int c(int i);

    public abstract int d(int i);

    public abstract com.google.android.exoplayer2.source.h0 e(int i, int i2);

    public abstract int f();

    public abstract com.google.android.exoplayer2.source.h0 g();

    public abstract int getLength();
}
