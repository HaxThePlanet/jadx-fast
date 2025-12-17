package com.google.zxing.k.c;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b {

    private final byte[][] a;
    private final int b;
    private final int c;
    public b(int i, int i2) {
        super();
        int[] iArr = new int[2];
        this.a = (byte[][])Array.newInstance(byte.class, i2, i);
        this.b = i;
        this.c = i2;
    }

    public void a(byte b) {
        int i;
        byte[] bArr;
        final byte[][] arr = this.a;
        i = 0;
        while (i < arr.length) {
            Arrays.fill(arr[i], b);
            i++;
        }
    }

    public byte b(int i, int i2) {
        return this.a[i2][i];
    }

    public byte[][] c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public void f(int i, int i2, int i3) {
        this.a[i2][i] = (byte)i3;
    }

    public void g(int i, int i2, boolean z3) {
        this.a[i2][i] = (byte)z3;
    }

    public String toString() {
        int i2;
        int i4;
        int i3;
        int str;
        int i;
        StringBuilder stringBuilder = new StringBuilder(i7 += 2);
        int i9 = 0;
        i2 = i9;
        while (i2 < this.c) {
            i3 = i9;
            while (i3 < this.b) {
                byte b = this.a[i2][i3];
                if (b != 0) {
                } else {
                }
                stringBuilder.append(" 0");
                i3++;
                if (b != 1) {
                } else {
                }
                stringBuilder.append(" 1");
                stringBuilder.append("  ");
            }
            stringBuilder.append('\n');
            i2++;
            b = bArr[i3];
            if (b != 0) {
            } else {
            }
            stringBuilder.append(" 0");
            i3++;
            if (b != 1) {
            } else {
            }
            stringBuilder.append(" 1");
            stringBuilder.append("  ");
        }
        return stringBuilder.toString();
    }
}
