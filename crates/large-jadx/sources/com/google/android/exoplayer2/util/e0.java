package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class e0 {

    private byte[] a;
    private int b;
    private int c;
    private int d;
    public e0(byte[] bArr, int i2, int i3) {
        super();
        i(bArr, i2, i3);
    }

    private void a() {
        int i;
        int i2;
        int i3;
        i = this.c;
        if (i >= 0) {
            i3 = this.b;
            if (i >= i3) {
                if (i == i3 && this.d == 0) {
                    i2 = this.d == 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        g.f(i2);
    }

    private int f() {
        int i;
        int i2;
        boolean z;
        i2 = i;
        while (!d()) {
            i2++;
        }
        int i3 = 1;
        if (i2 > 0) {
            i = e(i2);
        }
        return i5 += i;
    }

    private boolean j(int i) {
        int i4;
        int i3;
        byte b;
        int i2;
        int obj5;
        i3 = this.a;
        if (2 <= i && i < this.b && i3[i] == 3 && i3[i + -2] == 0 && i3[i -= i4] == 0) {
            if (i < this.b) {
                i3 = this.a;
                if (i3[i] == 3) {
                    if (i3[i + -2] == 0) {
                        if (i3[i -= i4] == 0) {
                        } else {
                            i4 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i4;
    }

    public boolean b(int i) {
        int i5;
        int i2;
        int i3;
        int i4;
        int obj5;
        int i7 = i / 8;
        i9 -= i2;
        if (i4 > 7) {
            i3++;
            i4 += -8;
        }
        i5 += obj5;
        while (i5 <= i3) {
            if (i3 < this.b) {
            }
            if (j(i5) != 0) {
            }
            i5 += obj5;
            i3++;
            i5 += 2;
        }
        int i6 = this.b;
        if (i3 >= i6) {
            if (i3 == i6 && i4 == 0) {
                if (i4 == 0) {
                } else {
                    obj5 = 0;
                }
            } else {
            }
        }
        return obj5;
    }

    public boolean c() {
        int i;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i2;
        i3 = 0;
        i4 = i3;
        while (this.c < this.b) {
            if (!d()) {
            }
            i4++;
        }
        final int i10 = 1;
        i5 = this.c == this.b ? i10 : i3;
        this.c = this.c;
        this.d = this.d;
        if (i5 == 0 && b(i7 += i10)) {
            if (b(i7 += i10)) {
                i3 = i10;
            }
        }
        return i3;
    }

    public boolean d() {
        int i;
        i = b &= i5 != 0 ? 1 : 0;
        k();
        return i;
    }

    public int e(int i) {
        int i4;
        int i2;
        boolean z;
        int i7;
        int i8;
        int i6;
        int i5;
        int i3;
        this.d = i9 += i;
        i4 = 0;
        i2 = i4;
        int i13 = this.d;
        i7 = 2;
        i8 = 1;
        int i17 = 8;
        while (i13 > i17) {
            i13 += -8;
            this.d = i14;
            int i21 = this.c;
            i2 |= i15;
            if (j(i21 + 1)) {
            } else {
            }
            i7 = i8;
            this.c = i21 += i7;
            i13 = this.d;
            i7 = 2;
            i8 = 1;
            i17 = 8;
        }
        i3 = this.c;
        if (i13 == i17) {
            this.d = i4;
            if (j(i3 + 1)) {
            } else {
                i7 = i8;
            }
            this.c = i3 += i7;
        }
        a();
        return obj10 &= i12;
    }

    public int g() {
        int i;
        int i2 = f();
        final int i7 = 1;
        i = i2 % 2 == 0 ? -1 : i7;
        return i *= i4;
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.c = i2;
        this.b = i3;
        this.d = 0;
        a();
    }

    public void k() {
        int i;
        int i3;
        int i2;
        i4 += i3;
        this.d = i;
        this.d = 0;
        int i6 = this.c;
        if (i == 8 && j(i6 + 1)) {
            this.d = 0;
            i6 = this.c;
            if (j(i6 + 1)) {
                i3 = 2;
            }
            this.c = i6 += i3;
        }
        a();
    }

    public void l(int i) {
        int i4;
        int i3;
        int i2;
        int obj5;
        int i5 = i / 8;
        i3 = i4 + i5;
        this.c = i3;
        i7 += obj5;
        this.d = i2;
        if (i2 > 7) {
            this.c = i3++;
            this.d = i2 += -8;
        }
        i4++;
        while (i4 <= this.c) {
            if (j(i4) != 0) {
            }
            i4++;
            this.c = obj5++;
            i4 += 2;
        }
        a();
    }
}
