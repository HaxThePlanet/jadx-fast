package com.google.zxing.h.b;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class e {

    private final java.lang.CharSequence a;
    private final int b;
    private final int c;
    private final byte[] d;
    public e(java.lang.CharSequence charSequence, int i2, int i3) {
        super();
        this.a = charSequence;
        this.c = i2;
        this.b = i3;
        final byte[] obj1 = new byte[i2 *= i3];
        this.d = obj1;
        Arrays.fill(obj1, -1);
    }

    private void a(int i) {
        int i18 = 1;
        int i20 = 0;
        g(i2 -= i18, i20, i, i18);
        final int i23 = 2;
        g(i4 -= i18, i18, i, i23);
        final int i24 = 3;
        g(i6 -= i18, i23, i, i24);
        g(i20, i8 -= i23, i, 4);
        g(i20, i10 -= i18, i, 5);
        g(i18, i12 -= i18, i, 6);
        g(i23, i14 -= i18, i, 7);
        g(i24, i16 -= i18, i, 8);
    }

    private void b(int i) {
        int i18 = 3;
        final int i23 = 0;
        final int i24 = 1;
        g(i2 -= i18, i23, i, i24);
        final int i25 = 2;
        g(i4 -= i25, i23, i, i25);
        g(i6 -= i24, i23, i, i18);
        final int i26 = 4;
        g(i23, i8 -= i26, i, i26);
        g(i23, i10 -= i18, i, 5);
        g(i23, i12 -= i25, i, 6);
        g(i23, i14 -= i24, i, 7);
        g(i24, i16 -= i24, i, 8);
    }

    private void c(int i) {
        final int i18 = 3;
        int i19 = 0;
        final int i23 = 1;
        g(i2 -= i18, i19, i, i23);
        final int i24 = 2;
        g(i4 -= i24, i19, i, i24);
        g(i6 -= i23, i19, i, i18);
        g(i19, i8 -= i24, i, 4);
        g(i19, i10 -= i23, i, 5);
        g(i23, i12 -= i23, i, 6);
        g(i24, i14 -= i23, i, 7);
        g(i18, i16 -= i23, i, 8);
    }

    private void d(int i) {
        final int i18 = 1;
        int i19 = 0;
        g(i2 -= i18, i19, i, i18);
        final int i26 = 2;
        g(i4 -= i18, i23 -= i18, i, i26);
        int i25 = 3;
        g(i19, i6 -= i25, i, i25);
        g(i19, i8 -= i26, i, 4);
        g(i19, i10 -= i18, i, 5);
        g(i18, i12 -= i25, i, 6);
        g(i18, i14 -= i26, i, 7);
        g(i18, i16 -= i18, i, 8);
    }

    private boolean f(int i, int i2) {
        if (this.d[obj4 += i] >= 0) {
            return 1;
        }
        return 0;
    }

    private void g(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int obj2;
        int obj3;
        if (i < 0) {
            int i10 = this.b;
            i += i10;
            i2 += i5;
        }
        if (obj3 < 0) {
            int i7 = this.c;
            obj3 += i7;
            obj2 += i5;
        }
        if (obj4 &= obj5 != 0) {
        } else {
            i6 = 0;
        }
        i(obj3, obj2, i6);
    }

    private void i(int i, int i2, boolean z3) {
        this.d[obj4 += i] = (byte)z3;
    }

    private void j(int i, int i2, int i3) {
        int i4 = i + -2;
        final int i9 = i2 + -2;
        g(i4, i9, i3, 1);
        int i11 = i2 + -1;
        g(i4, i11, i3, 2);
        int i5 = i + -1;
        g(i5, i9, i3, 3);
        g(i5, i11, i3, 4);
        g(i5, i2, i3, 5);
        g(i, i9, i3, 6);
        g(i, i11, i3, 7);
        g(i, i2, i3, 8);
    }

    public final boolean e(int i, int i2) {
        int obj4 = 1;
        if (this.d[obj4 += i] == obj4) {
            return obj4;
        }
        return 0;
    }

    public final void h() {
        int i10;
        int i4;
        boolean z;
        int i5;
        int i9;
        int i11;
        int i;
        int i3;
        int i8;
        int i2;
        int i6;
        int i7;
        int i13 = 4;
        i5 = i10;
        i9 = i13;
        do {
            i6 = 2;
            if (i9 == i20 -= i6 && i10 == 0 && i21 %= i13 != 0) {
            }
            if (i9 == i22 -= i6 && i10 == 0 && i23 %= 8 == i13) {
            }
            if (i9 == i24 += i13 && i10 == i6 && i25 %= 8 == 0) {
            }
            while (i9 < this.b) {
                if (i10 >= 0 && !f(i10, i9)) {
                }
                i9 += -2;
                i10 += 2;
                if (i9 >= 0) {
                }
                if (i10 < this.c) {
                }
                if (!f(i10, i9)) {
                }
                j(i9, i10, i5);
                i5 = i;
            }
            i9 += -2;
            i10 += 2;
            if (i9 >= 0) {
            }
            i9++;
            i10 += 3;
            while (i11 >= 0) {
                if (i4 < this.c && !f(i4, i11)) {
                }
                i11 += 2;
                i4 += -2;
                i = this.b;
                if (i11 < i) {
                }
                if (i4 >= 0) {
                }
                if (!f(i4, i11)) {
                }
                j(i11, i4, i5);
                i5 = i;
            }
            i11 += 2;
            i4 += -2;
            i = this.b;
            if (i11 < i) {
            }
            if (i11 += 3 < i) {
            }
            i7 = this.c;
            if (i4++ < i7) {
            }
            if (i4 >= 0) {
            }
            if (i4 < this.c && !f(i4, i11)) {
            }
            if (!f(i4, i11)) {
            }
            j(i11, i4, i5);
            i5 = i;
            if (i10 < this.c) {
            }
            if (i10 >= 0 && !f(i10, i9)) {
            }
            if (!f(i10, i9)) {
            }
            j(i9, i10, i5);
            i5 = i;
            if (i10 == i6) {
            }
            if (i25 %= 8 == 0) {
            }
            d(i5);
            i5 = i;
            if (i10 == 0) {
            }
            if (i23 %= 8 == i13) {
            }
            c(i5);
            i5 = i2;
            if (i10 == 0) {
            }
            if (i21 %= i13 != 0) {
            }
            b(i5);
            i5 = i8;
            if (i10 == 0) {
            }
            a(i5);
            i5 = i3;
        } while (i9 == this.b);
        int i12 = 1;
        if (!f(i7 -= i12, i -= i12)) {
            i(i14 -= i12, i17 -= i12, i12);
            i(i16 -= i6, i19 -= i6, i12);
        }
    }
}
