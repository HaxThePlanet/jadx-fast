package com.google.zxing.common.reedsolomon;

/* loaded from: classes2.dex */
public final class a {

    public static final com.google.zxing.common.reedsolomon.a g;
    public static final com.google.zxing.common.reedsolomon.a h;
    public static final com.google.zxing.common.reedsolomon.a i;
    public static final com.google.zxing.common.reedsolomon.a j;
    public static final com.google.zxing.common.reedsolomon.a k;
    public static final com.google.zxing.common.reedsolomon.a l;
    private final int[] a;
    private final int[] b;
    private final com.google.zxing.common.reedsolomon.b c;
    private final int d;
    private final int e;
    private final int f;
    static {
        final int i12 = 1;
        a aVar = new a(4201, 4096, i12);
        a.g = aVar;
        a aVar2 = new a(1033, 1024, i12);
        a.h = aVar2;
        a aVar3 = new a(67, 64, i12);
        a.i = aVar3;
        a aVar4 = new a(19, 16, i12);
        a.j = aVar4;
        int i11 = 256;
        a aVar5 = new a(285, i11, 0);
        a.k = aVar5;
        a aVar6 = new a(301, i11, i12);
        a.l = aVar6;
    }

    public a(int i, int i2, int i3) {
        int i5;
        int i4;
        int[] iArr;
        int obj5;
        super();
        this.e = i;
        this.d = i2;
        this.f = i3;
        this.a = new int[i2];
        this.b = new int[i2];
        int obj7 = 0;
        final int i6 = 1;
        i5 = obj7;
        i4 = i6;
        while (i5 < i2) {
            this.a[i5] = i4;
            i4 <<= i6;
            if (i4 >= i2) {
            }
            i5++;
            i8 &= iArr;
        }
        obj5 = obj7;
        while (obj5 < i2 + -1) {
            this.b[this.a[obj5]] = obj5;
            obj5++;
        }
        int[] obj6 = new int[i6];
        obj6[obj7] = obj7;
        obj5 = new b(this, obj6);
        this.c = obj5;
        obj6 = new int[i6];
        obj6[obj7] = i6;
        obj5 = new b(this, obj6);
    }

    static int a(int i, int i2) {
        return i ^= i2;
    }

    com.google.zxing.common.reedsolomon.b b(int i, int i2) {
        if (i < 0) {
        } else {
            if (i2 == 0) {
                return this.c;
            }
            int[] obj2 = new int[i++];
            obj2[0] = i2;
            b obj3 = new b(this, obj2);
            return obj3;
        }
        obj2 = new IllegalArgumentException();
        throw obj2;
    }

    int c(int i) {
        return this.a[i];
    }

    public int d() {
        return this.f;
    }

    com.google.zxing.common.reedsolomon.b e() {
        return this.c;
    }

    int f(int i) {
        if (i == 0) {
        } else {
            return this.a[i3--];
        }
        ArithmeticException obj4 = new ArithmeticException();
        throw obj4;
    }

    int g(int i) {
        if (i == 0) {
        } else {
            return this.b[i];
        }
        IllegalArgumentException obj2 = new IllegalArgumentException();
        throw obj2;
    }

    int h(int i, int i2) {
        if (i != 0 && i2 == 0) {
            if (i2 == 0) {
            }
            final int[] iArr2 = this.b;
            return this.a[obj3 %= obj4];
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GF(0x");
        stringBuilder.append(Integer.toHexString(this.e));
        stringBuilder.append(',');
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
