package io.grpc.k1.r.j;

/* loaded from: classes3.dex */
public final class i {

    private int a;
    private int b;
    private int c;
    private final int[] d;
    public i() {
        super();
        this.d = new int[10];
    }

    public int a(int i) {
        return this.d[i];
    }

    int b() {
        int i2;
        int i;
        if (i3 &= 2 != 0) {
            i2 = this.d[1];
        } else {
            i2 = -1;
        }
        return i2;
    }

    int c(int i) {
        int i2;
        int obj2;
        if (i3 &= 32 != 0) {
            obj2 = this.d[5];
        }
        return obj2;
    }

    public boolean d(int i) {
        int i2;
        if (obj3 &= i3 != 0) {
        } else {
            i2 = 0;
        }
        return i2;
    }

    public io.grpc.k1.r.j.i e(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int obj6;
        final int[] iArr = this.d;
        if (i >= iArr.length) {
            return this;
        }
        i7 <<= i;
        this.a = i8 |= i4;
        if (i2 & 1 != 0) {
            this.b = i11 |= i4;
        } else {
            this.b = i12 &= i6;
        }
        if (i2 &= 2 != 0) {
            this.c = obj6 |= i4;
        } else {
            this.c = obj6 &= i4;
        }
        iArr[i] = i3;
        return this;
    }

    int f() {
        return Integer.bitCount(this.a);
    }
}
