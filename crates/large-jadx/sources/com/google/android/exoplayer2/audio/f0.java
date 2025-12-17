package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.g;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class f0 {

    private final int a;
    private final int b;
    private final float c;
    private final float d;
    private final float e;
    private final int f;
    private final int g;
    private final int h;
    private final short[] i;
    private short[] j;
    private int k;
    private short[] l;
    private int m;
    private short[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    public f0(int i, int i2, float f3, float f4, int i5) {
        super();
        this.a = i;
        this.b = i2;
        this.c = f3;
        this.d = f4;
        this.e = obj3 /= obj4;
        this.f = i / 400;
        i /= 65;
        this.g = obj1;
        obj1 *= 2;
        this.h = obj1;
        this.i = new short[obj1];
        this.j = new short[obj1 * i2];
        this.l = new short[obj1 * i2];
        this.n = new short[obj1 *= i2];
    }

    private void a(float f, int i2) {
        int i8;
        int i7;
        int i11;
        int i5;
        int i13;
        int i9;
        int i10;
        int i4;
        int i;
        int i12;
        int i6;
        int i3;
        short[] sArr;
        int obj9;
        if (this.m == i2) {
        }
        obj9 = (int)i7;
        i7 = 16384;
        while (obj9 <= i7) {
            if (i8 > i7) {
            }
            obj9 /= 2;
            i8 /= 2;
            i7 = 16384;
        }
        o(i2);
        final int obj10 = 0;
        i11 = obj10;
        i13 = this.o;
        i12 = 1;
        while (i11 < i13 + -1) {
            int i16 = this.p;
            i6 = this.q;
            while (i20 *= obj9 > i6 * i8) {
                this.l = f(this.l, this.m, i12);
                i9 = obj10;
                i4 = this.b;
                while (i9 < i4) {
                    this.l[i24 += i9] = n(this.n, i21 += i9, i8, obj9);
                    i9++;
                    i4 = this.b;
                }
                this.q = i17 += i12;
                this.m = i19 += i12;
                i16 = this.p;
                i6 = this.q;
                this.l[i24 += i9] = n(this.n, i21 += i9, i8, obj9);
                i9++;
            }
            i16++;
            this.p = i5;
            if (i5 == i8) {
            }
            i11++;
            i13 = this.o;
            i12 = 1;
            this.p = obj10;
            if (i6 == obj9) {
            } else {
            }
            i12 = obj10;
            g.f(i12);
            this.q = obj10;
            this.l = f(this.l, this.m, i12);
            i9 = obj10;
            i4 = this.b;
            while (i9 < i4) {
                this.l[i24 += i9] = n(this.n, i21 += i9, i8, obj9);
                i9++;
                i4 = this.b;
            }
            this.q = i17 += i12;
            this.m = i19 += i12;
            this.l[i24 += i9] = n(this.n, i21 += i9, i8, obj9);
            i9++;
        }
        u(i13 -= i12);
    }

    private void b(float f) {
        int i;
        int i2;
        int i3;
        int i4;
        long l;
        final int i5 = this.k;
        if (i5 < this.h) {
        }
        i = 0;
        do {
            int i8 = g(this.j, i);
            if (Double.compare(d, l) > 0) {
            } else {
            }
            i3 = m(this.j, i, f, i8);
            i += i3;
            if (i9 += i <= i5) {
            }
            i8 += i4;
            i3 = c(i);
        } while (this.r > 0);
        v(i);
    }

    private int c(int i) {
        int i3 = Math.min(this.h, this.r);
        d(this.j, i, i3);
        this.r = obj3 -= i3;
        return i3;
    }

    private void d(short[] sArr, int i2, int i3) {
        short[] sArr3 = f(this.l, this.m, i3);
        this.l = sArr3;
        int i4 = this.b;
        System.arraycopy(sArr, i2 *= i4, sArr3, i6 *= i4, i4 *= i3);
        this.m = obj4 += i3;
    }

    private void e(short[] sArr, int i2, int i3) {
        int i4;
        short[] sArr2;
        int i;
        short s;
        int i5;
        short s2;
        int i8 = this.b;
        i3 *= i8;
        int i9 = 0;
        i4 = i9;
        while (i4 < i6 /= i3) {
            i5 = i;
            while (i < obj9) {
                i5 += s2;
                i++;
            }
            this.i[i4] = (short)i10;
            i4++;
            i5 += s2;
            i++;
        }
    }

    private short[] f(short[] sArr, int i2, int i3) {
        final int i8 = this.b;
        length /= i8;
        if (i2 += i3 <= i) {
            return sArr;
        }
        return Arrays.copyOf(sArr, i6 *= i8);
    }

    private int g(short[] sArr, int i2) {
        int i5;
        int i3;
        int i4;
        int i;
        int i6;
        int obj7;
        int obj8;
        int i7 = this.a;
        int i13 = 4000;
        final int i16 = 1;
        i5 = i7 > i13 ? i7 / i13 : i16;
        if (this.b == i16 && i5 == i16) {
            if (i5 == i16) {
                obj7 = h(sArr, i2, this.f, this.g);
            } else {
                e(sArr, i2, i5);
                i6 = 0;
                i3 = h(this.i, i6, i17 /= i5, i18 /= i5);
                if (i5 != i16) {
                    i3 *= i5;
                    i5 *= 4;
                    int i9 = this.f;
                    if (i15 - i8 < i9) {
                        i4 = i9;
                    }
                    int i10 = this.g;
                    if (i15 += i8 > i10) {
                        i3 = i10;
                    }
                    if (this.b == i16) {
                        obj7 = h(sArr, i2, i4, i3);
                    } else {
                        e(sArr, i2, i16);
                        obj7 = h(this.i, i6, i4, i3);
                    }
                } else {
                    obj7 = i3;
                }
            }
        } else {
        }
        obj8 = q(this.u, this.v) ? this.s : obj7;
        this.t = this.u;
        this.s = obj7;
        return obj8;
    }

    private int h(short[] sArr, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i11;
        int i;
        int i10;
        int i7;
        int i8;
        int i9;
        short s;
        int obj12;
        i2 *= i12;
        i5 = 1;
        final int i14 = 0;
        i6 = 255;
        i = i11;
        while (obj12 <= i4) {
            i8 = i7;
            while (i7 < obj12) {
                i8 += i9;
                i7++;
            }
            if (i8 * i11 < i5 * obj12) {
            }
            if (i8 * i6 > i * obj12) {
            }
            obj12++;
            i6 = obj12;
            i = i8;
            i11 = obj12;
            i5 = i8;
            i8 += i9;
            i7++;
        }
        this.u = i5 /= i11;
        this.v = i /= i6;
        return i11;
    }

    private int m(short[] sArr, int i2, float f3, int i4) {
        int i5;
        int i3;
        int i;
        int obj12;
        int i11 = 1065353216;
        if (Float.compare(f3, i6) < 0) {
            obj12 = (int)i5;
        } else {
            this.r = (int)i5;
            obj12 = i4;
        }
        final int i24 = i4 + obj12;
        short[] sArr3 = f(this.l, this.m, i24);
        this.l = sArr3;
        int i13 = this.b;
        System.arraycopy(sArr, i2 * i13, sArr3, i19 *= i13, i13 *= i4);
        f0.p(obj12, this.b, this.l, i7 + i4, sArr, i2 + i4, sArr, i2);
        this.m = obj10 += i24;
        return obj12;
    }

    private short n(short[] sArr, int i2, int i3, int i4) {
        int obj5 = this.p;
        obj5 *= i4;
        int obj4 = obj5 - obj4;
        obj5 -= i8;
        return (short)i6;
    }

    private void o(int i) {
        i2 -= i;
        short[] sArr2 = f(this.n, this.o, i3);
        this.n = sArr2;
        int i5 = this.b;
        System.arraycopy(this.l, i * i5, sArr2, i8 *= i5, i5 *= i3);
        this.m = i;
        this.o = obj7 += i3;
    }

    private static void p(int i, int i2, short[] s3Arr3, int i4, short[] s5Arr5, int i6, short[] s7Arr7, int i8) {
        int i5;
        int i7;
        int i9;
        int i10;
        int i11;
        short s;
        int i3;
        final int i12 = 0;
        i5 = i12;
        while (i5 < i2) {
            i13 += i5;
            i14 += i5;
            i15 += i5;
            i11 = i12;
            while (i11 < i) {
                s3Arr3[i7] = (short)i18;
                i7 += i2;
                i10 += i2;
                i9 += i2;
                i11++;
            }
            i5++;
            s3Arr3[i7] = (short)i18;
            i7 += i2;
            i10 += i2;
            i9 += i2;
            i11++;
        }
    }

    private boolean q(int i, int i2) {
        int i3;
        final int i4 = 0;
        if (i != 0) {
            if (this.s == 0) {
            } else {
                if (i2 > i * 3) {
                    return i4;
                }
                if (i *= 2 <= obj4 *= 3) {
                    return i4;
                }
            }
            return 1;
        }
        return i4;
    }

    private void r() {
        short[] i;
        int cmp;
        int i2;
        long l;
        float f2 = this.d;
        f /= f2;
        f3 *= f2;
        i2 = (double)i;
        if (Double.compare(i2, l) <= 0) {
            if (Double.compare(i2, l) < 0) {
                b(i);
            } else {
                i2 = 0;
                d(this.j, i2, this.k);
                this.k = i2;
            }
        } else {
        }
        if (Float.compare(i5, i4) != 0) {
            a(i5, this.m);
        }
    }

    private void u(int i) {
        if (i == 0) {
        }
        short[] sArr = this.n;
        final int i4 = this.b;
        System.arraycopy(sArr, i * i4, sArr, 0, i8 *= i4);
        this.o = i2 -= i;
    }

    private void v(int i) {
        i2 -= i;
        final short[] sArr = this.j;
        int i4 = this.b;
        System.arraycopy(sArr, i *= i4, sArr, 0, i4 *= i3);
        this.k = i3;
    }

    private int w(short[] sArr, int i2, float f3, int i4) {
        int i;
        int cmp;
        int obj11;
        int i3 = 1073741824;
        int i9 = 1065353216;
        if (Float.compare(f3, i3) >= 0) {
            obj11 = (int)i;
        } else {
            this.r = (int)cmp;
            obj11 = i4;
        }
        short[] sArr3 = f(this.l, this.m, obj11);
        this.l = sArr3;
        f0.p(obj11, this.b, sArr3, this.m, sArr, i2, sArr, i2 + i4);
        this.m = obj9 += obj11;
        return obj11;
    }

    public void i() {
        final int i = 0;
        this.k = i;
        this.m = i;
        this.o = i;
        this.p = i;
        this.q = i;
        this.r = i;
        this.s = i;
        this.t = i;
        this.u = i;
        this.v = i;
    }

    public void j(ShortBuffer shortBuffer) {
        int i2 = Math.min(remaining /= i4, this.m);
        final int i9 = 0;
        shortBuffer.put(this.l, i9, i6 *= i2);
        obj5 -= i2;
        this.m = obj5;
        short[] sArr2 = this.l;
        int i8 = this.b;
        System.arraycopy(sArr2, i2 *= i8, sArr2, i9, obj5 *= i8);
    }

    public int k() {
        return i2 *= 2;
    }

    public int l() {
        return i2 *= 2;
    }

    public void s() {
        int i4;
        int i3;
        int i;
        int i2;
        int i5 = this.k;
        float f3 = this.d;
        i14 += i12;
        this.j = f(this.j, i5, i18 += i5);
        int i13 = 0;
        i4 = i13;
        int i23 = this.h;
        int i26 = this.b;
        while (i4 < i25 *= i26) {
            this.j[i27 += i4] = i13;
            i4++;
            i23 = this.h;
            i26 = this.b;
        }
        this.k = i6 += i24;
        r();
        if (this.m > i15) {
            this.m = i15;
        }
        this.k = i13;
        this.r = i13;
        this.o = i13;
    }

    public void t(ShortBuffer shortBuffer) {
        int i2 = this.b;
        remaining /= i2;
        short[] sArr2 = f(this.j, this.k, i);
        this.j = sArr2;
        shortBuffer.get(sArr2, i7 *= i9, i4 /= 2);
        this.k = obj6 += i;
        r();
    }
}
