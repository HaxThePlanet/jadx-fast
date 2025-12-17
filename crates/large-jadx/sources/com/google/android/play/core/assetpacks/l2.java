package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class l2 {

    private byte[] a;
    private int b;
    private long c;
    private long d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private String i;
    public l2() {
        super();
        this.a = new byte[4096];
        d();
    }

    private final int e(int i, byte[] b2Arr2, int i3, int i4) {
        int i2 = this.b;
        final int obj6 = Math.min(i4, i - i2);
        System.arraycopy(b2Arr2, i3, this.a, this.b, obj6);
        obj4 += obj6;
        this.b = obj4;
        if (i2 < i && obj4 < i) {
            obj6 = Math.min(i4, i - i2);
            System.arraycopy(b2Arr2, i3, this.a, this.b, obj6);
            obj4 += obj6;
            this.b = obj4;
            if (obj4 < i) {
                return -1;
            }
            return obj6;
        }
        return 0;
    }

    public final int a() {
        return this.f;
    }

    public final int b(byte[] bArr, int i2, int i3) {
        int copyOf;
        int i5;
        int i4;
        int i;
        boolean obj10;
        int obj11;
        int obj12;
        final int i6 = 30;
        int i7 = e(i6, bArr, i2, i3);
        final int i9 = -1;
        if (i7 != i9 && Long.compare(l, i4) == 0) {
            if (Long.compare(l, i4) == 0) {
                i5 = 0;
                i4 = o0.b(this.a, i5);
                this.c = i4;
                if (Long.compare(i4, i) == 0) {
                    this.h = i5;
                    this.d = o0.b(this.a, 18);
                    this.g = o0.a(this.a, 8);
                    this.e = o0.a(this.a, 26);
                    i19 += i12;
                    this.f = i5;
                    if (bArr7.length < i5) {
                    }
                } else {
                    this.h = true;
                }
            }
            obj10 = e(this.f, bArr, i2 += i7, i3 -= i7);
            if (obj10 == i9) {
                return i9;
            }
            if (!this.h && this.i == null) {
                if (this.i == null) {
                    obj10 = new String(this.a, i6, this.e);
                    this.i = obj10;
                }
            }
            return i7 += obj10;
        }
        return i9;
    }

    public final com.google.android.play.core.assetpacks.m3 c() {
        final Object obj = this;
        int i = obj.b;
        int i2 = obj.f;
        if (i < i2) {
            super(obj.i, obj.d, obj6, obj.g, 1, obj.h, Arrays.copyOf(obj.a, i));
            return n0Var;
        }
        super(obj.i, obj.d, obj14, obj.g, 0, obj.h, Arrays.copyOf(obj.a, i2));
        d();
        return n0Var2;
    }

    public final void d() {
        int i = 0;
        this.b = i;
        final int i4 = -1;
        this.e = i4;
        final int i5 = -1;
        this.c = i5;
        this.h = i;
        this.f = 30;
        this.d = i5;
        this.g = i4;
        this.i = 0;
    }
}
