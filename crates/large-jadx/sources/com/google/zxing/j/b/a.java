package com.google.zxing.j.b;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class a {

    private final com.google.zxing.j.b.b[] a;
    private int b = -1;
    private final int c;
    private final int d;
    a(int i, int i2) {
        int i3;
        com.google.zxing.j.b.b[] objArr;
        com.google.zxing.j.b.b bVar;
        int i4;
        super();
        com.google.zxing.j.b.b[] arr = new b[i];
        this.a = arr;
        i3 = 0;
        while (i3 < arr.length) {
            bVar = new b(i6++);
            this.a[i3] = bVar;
            i3++;
        }
        this.d = i2 *= 17;
        this.c = i;
        final int obj6 = -1;
    }

    com.google.zxing.j.b.b a() {
        return this.a[this.b];
    }

    public byte[][] b(int i, int i2) {
        int i4;
        int i5;
        byte[] bArr;
        int i3;
        int[] iArr = new int[2];
        final int i13 = 1;
        iArr[i13] = i8 *= i;
        iArr[0] = i6 *= i2;
        Object instance = Array.newInstance(byte.class, iArr);
        i11 *= i2;
        while (i4 < i12) {
            (byte[][])instance[i14 -= i13] = this.a[i4 / i2].b(i);
            i4++;
        }
        return instance;
    }

    void c() {
        this.b = i++;
    }
}
