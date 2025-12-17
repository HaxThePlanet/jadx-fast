package com.google.zxing.g;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements java.lang.Cloneable {

    private int[] a;
    private int b;
    public a() {
        super();
        this.b = 0;
        this.a = new int[1];
    }

    a(int[] iArr, int i2) {
        super();
        this.a = iArr;
        this.b = i2;
    }

    private void e(int i) {
        int i2;
        int length;
        int i3;
        int obj4;
        if (i > length2 <<= 5) {
            obj4 = a.j(i);
            i2 = this.a;
            i3 = 0;
            System.arraycopy(i2, i3, obj4, i3, i2.length);
            this.a = obj4;
        }
    }

    private static int[] j(int i) {
        return new int[obj0 /= 32];
    }

    @Override // java.lang.Cloneable
    public void a(boolean z) {
        int i3;
        int i2;
        int i;
        int[] obj5;
        final int i8 = 1;
        e(i4 += i8);
        if (z != null) {
            obj5 = this.a;
            int i5 = this.b;
            i2 = i5 / 32;
            obj5[i2] = i7 |= i;
        }
        this.b = obj5 += i8;
    }

    @Override // java.lang.Cloneable
    public void b(com.google.zxing.g.a a) {
        int i;
        boolean z;
        final int i2 = a.b;
        e(i3 += i2);
        i = 0;
        while (i < i2) {
            a(a.f(i));
            i++;
        }
    }

    @Override // java.lang.Cloneable
    public void c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int obj4;
        if (i2 < 0) {
        } else {
            if (i2 > 32) {
            } else {
                e(i6 += i2);
                while (obj4 > 0) {
                    i5 = 1;
                    if (i8 &= i5 == i5) {
                    } else {
                    }
                    i5 = 0;
                    a(i5);
                    obj4--;
                }
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Num bits must be between 0 and 32");
        throw obj3;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return d();
    }

    @Override // java.lang.Cloneable
    public com.google.zxing.g.a d() {
        a aVar = new a((int[])this.a.clone(), this.b);
        return aVar;
    }

    @Override // java.lang.Cloneable
    public boolean equals(Object object) {
        int i;
        Object obj4;
        final int i2 = 0;
        if (!object instanceof a) {
            return i2;
        }
        if (this.b == object.b && Arrays.equals(this.a, object.a)) {
            if (Arrays.equals(this.a, object.a)) {
                return 1;
            }
        }
        return i2;
    }

    @Override // java.lang.Cloneable
    public boolean f(int i) {
        int i4 = 1;
        if (obj3 &= i2 != 0) {
            return i4;
        }
        return 0;
    }

    @Override // java.lang.Cloneable
    public int g() {
        return this.b;
    }

    @Override // java.lang.Cloneable
    public int h() {
        return i2 /= 8;
    }

    @Override // java.lang.Cloneable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // java.lang.Cloneable
    public void k(int i, byte[] b2Arr2, int i3, int i4) {
        int i7;
        int i8;
        int i6;
        byte b;
        int i9;
        int i2;
        int i5;
        int obj7;
        final int i10 = 0;
        i7 = i10;
        while (i7 < i4) {
            i9 = i6;
            while (i6 < 8) {
                if (f(obj7)) {
                }
                obj7++;
                i6++;
                i9 |= i2;
            }
            b2Arr2[i3 + i7] = (byte)i9;
            i7++;
            if (f(obj7)) {
            }
            obj7++;
            i6++;
            i9 |= i2;
        }
    }

    @Override // java.lang.Cloneable
    public void l(com.google.zxing.g.a a) {
        int i;
        int i4;
        int i3;
        int i2;
        if (this.b != a.b) {
        } else {
            i = 0;
            i4 = this.a;
            for (int i6 : obj1) {
                i4[i] = i6 ^= i2;
                i4 = this.a;
            }
        }
        IllegalArgumentException obj5 = new IllegalArgumentException("Sizes don't match");
        throw obj5;
    }

    @Override // java.lang.Cloneable
    public String toString() {
        int i2;
        int i;
        int i3;
        int i4 = this.b;
        StringBuilder stringBuilder = new StringBuilder(i5++);
        i2 = 0;
        while (i2 < this.b) {
            if (i2 & 7 == 0) {
            }
            if (f(i2)) {
            } else {
            }
            i = 46;
            stringBuilder.append(i);
            i2++;
            i = 88;
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}
