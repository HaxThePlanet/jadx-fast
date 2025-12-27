package io.grpc.k1.r.j;

/* compiled from: Settings.java */
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
        int i = -1;
        if (this.a & 2 != 0) {
            int i2 = 1;
            i = this.d[i2];
        } else {
            i = -1;
        }
        return i;
    }

    int c(int i) {
        int i3;
        i2 = this.a & 32;
        if (this.a & 32 != 0) {
            int i2 = 5;
            i3 = this.d[i2];
        }
        return i3;
    }

    public boolean d(int i) {
        boolean z = true;
        if ((1 << i) & this.a == 0) {
            int i3 = 0;
        }
        return z;
    }

    public i e(int i, int i2, int i3) {
        if (i >= iArr.length) {
            return this;
        }
        i4 = 1 << i;
        this.a |= i4;
        if (i2 & 1 != 0) {
            this.b |= i4;
        } else {
            i6 = ~i4;
            this.b &= i6;
        }
        if (i2 & 2 != 0) {
            this.c |= i4;
        } else {
            i4 = ~i4;
            this.c &= i4;
        }
        this.d[i] = i3;
        return this;
    }

    int f() {
        return Integer.bitCount(this.a);
    }
}
