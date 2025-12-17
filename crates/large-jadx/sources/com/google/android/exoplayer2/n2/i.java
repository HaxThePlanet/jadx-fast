package com.google.android.exoplayer2.n2;

import android.util.Pair;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class i extends com.google.android.exoplayer2.n2.n {

    public static final class a {

        private final int a;
        private final int[] b;
        private final l0[] c;
        private final int[] d;
        private final int[][][] e;
        a(String[] stringArr, int[] i2Arr2, l0[] l03Arr3, int[] i4Arr4, int[][][] i5Arr5Arr5Arr5, l0 l06) {
            super();
            this.b = i2Arr2;
            this.c = l03Arr3;
            this.e = i5Arr5Arr5Arr5;
            this.d = i4Arr4;
            this.a = i2Arr2.length;
        }

        public int a(int i, int i2, boolean z3) {
            int i4;
            int i5;
            int i6;
            int i3;
            int i7 = k0Var.a;
            final int[] iArr = new int[i7];
            i5 = i4;
            while (i4 < i7) {
                i6 = f(i, i2, i4);
                if (i6 != 4) {
                } else {
                }
                iArr[i5] = i4;
                i5 = i6;
                i4++;
                if (z3 && i6 == 3) {
                }
                if (i6 == 3) {
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i5));
        }

        public int b(int i, int i2, int[] i3Arr3) {
            int i3;
            int i7;
            int i5;
            int i4;
            int i8;
            String str;
            int i6;
            int obj8;
            int obj9;
            i4 = i9;
            i8 = i10;
            i5 = i7;
            while (i3 < i3Arr3.length) {
                str = i1Var.D;
                if (i5 == 0) {
                } else {
                }
                i7 |= i5;
                i4 = Math.min(i4, a2.q(this.e[i][i2][i3]));
                i3++;
                i5 = i6;
                i8 = str;
            }
            if (i7 != 0) {
                i4 = Math.min(i4, this.d[i]);
            }
            return i4;
        }

        public int c() {
            return this.a;
        }

        public int d(int i) {
            return this.b[i];
        }

        public l0 e(int i) {
            return this.c[i];
        }

        public int f(int i, int i2, int i3) {
            return a2.B(this.e[i][i2][i3]);
        }
    }
    private static int e(a2[] a2Arr, k0 k02, int[] i3Arr3, boolean z4) {
        int length;
        int i6;
        int i4;
        int i7;
        int i3;
        int i5;
        int i2;
        int i;
        length = a2Arr.length;
        final int i8 = 1;
        final int i9 = 0;
        i7 = i8;
        i4 = i6;
        for (Object obj : a2Arr) {
            i2 = i5;
            while (i5 < k02.a) {
                i2 = Math.max(i2, a2.B(obj.b(k02.a(i5))));
                i5++;
            }
            if (i3Arr3[i6] == 0) {
            } else {
            }
            i3 = i9;
            if (i2 <= i4) {
            } else {
            }
            length = i6;
            i7 = i3;
            i4 = i2;
            if (i2 == i4 && z4 && i7 == 0 && i3 != 0) {
            }
            if (z4) {
            }
            if (i7 == 0) {
            }
            if (i3 != 0) {
            }
            i3 = i8;
            i2 = Math.max(i2, a2.B(obj.b(k02.a(i5))));
            i5++;
        }
        return length;
    }

    private static int[] f(a2 a2, k0 k02) {
        int i;
        int i2;
        int[] iArr = new int[k02.a];
        i = 0;
        while (i < k02.a) {
            iArr[i] = a2.b(k02.a(i));
            i++;
        }
        return iArr;
    }

    private static int[] g(a2[] a2Arr) {
        int i;
        int i2;
        final int length = a2Arr.length;
        final int[] iArr = new int[length];
        i = 0;
        while (i < length) {
            iArr[i] = a2Arr[i].t();
            i++;
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.n2.n
    public final void c(Object object) {
    }

    @Override // com.google.android.exoplayer2.n2.n
    public final com.google.android.exoplayer2.n2.o d(a2[] a2Arr, l0 l02, y.a y$a3, g2 g24) {
        int length;
        int i6;
        int i4;
        int i2;
        int i3;
        int[][] iArr;
        k0[] arr;
        int i5;
        int[] iArr2;
        int i;
        k0[] objArr;
        a2[] objArr2 = a2Arr;
        Object obj = l02;
        i6 = 1;
        int[] iArr3 = new int[length7 += i6];
        length8 += i6;
        final k0[][] arr2 = new k0[i10];
        int[][][] iArr5 = new int[length9 += i6];
        i4 = 0;
        i2 = i4;
        while (i2 < i10) {
            int i14 = obj.a;
            arr2[i2] = new k0[i14];
            iArr5[i2] = new int[i14];
            i2++;
        }
        int[] iArr4 = i.g(a2Arr);
        i3 = i4;
        while (i3 < obj.a) {
            k0 k0Var = obj.a(i3);
            if (z.k(i1Var.D) == 5) {
            } else {
            }
            i5 = i4;
            arr = i.e(a2Arr, k0Var, iArr3, i5);
            if (arr == objArr2.length) {
            } else {
            }
            iArr2 = i.f(objArr2[arr], k0Var);
            i = iArr3[arr];
            arr2[arr][i] = k0Var;
            iArr5[arr][i] = iArr2;
            iArr3[arr] = i13 += i6;
            i3++;
            iArr2 = new int[k0Var.a];
            i5 = i6;
        }
        l0[] arr5 = new l0[objArr2.length];
        String[] strArr = new String[objArr2.length];
        int[] iArr6 = new int[objArr2.length];
        for (Object obj3 : obj0) {
            int i7 = iArr3[i4];
            l0 l0Var = new l0((k0[])p0.s0(arr2[i4], i7));
            arr5[i4] = l0Var;
            iArr5[i4] = (int[][])p0.s0(iArr5[i4], i7);
            strArr[i4] = objArr2[i4].getName();
            iArr6[i4] = obj3.i();
        }
        l0 l0Var2 = new l0((k0[])p0.s0(arr2[objArr2.length], iArr3[objArr2.length]));
        super(strArr, iArr6, arr5, iArr4, iArr5, l0Var2);
        Pair pair = this.h(aVar, iArr5, iArr4, a3, g24);
        o oVar = new o((b2[])pair.first, (g[])pair.second, aVar);
        return oVar;
    }

    protected abstract Pair<b2[], com.google.android.exoplayer2.n2.g[]> h(com.google.android.exoplayer2.n2.i.a i$a, int[][][] i2Arr2Arr2Arr2, int[] i3Arr3, y.a y$a4, g2 g25);
}
