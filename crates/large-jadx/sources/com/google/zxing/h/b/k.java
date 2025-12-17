package com.google.zxing.h.b;

import com.google.zxing.b;

/* loaded from: classes2.dex */
public class k {

    private static com.google.zxing.h.b.k[] i;
    private final boolean a;
    private final int b;
    private final int c;
    public final int d;
    public final int e;
    private final int f;
    private final int g;
    private final int h;
    static {
        com.google.zxing.h.b.k[] arr = new k[30];
        super(0, 3, 5, 8, 8, 1);
        super(0, 5, 7, 10, 10, 1);
        int i151 = 1;
        super(1, 5, 7, 16, 6, i151);
        super(0, 8, 10, 12, 12, i151);
        int i101 = 14;
        super(1, 10, 11, i101, 6, 2);
        int i153 = 1;
        super(0, 12, 12, i101, 14, i153);
        int i79 = 14;
        super(1, 16, i79, 24, 10, i153);
        int i40 = 0;
        super(i40, 18, i79, 16, 16, i153);
        int i54 = 22;
        int i80 = 18;
        super(i40, i54, i80, 18, 18, i153);
        super(1, i54, i80, 16, 10, 2);
        super(0, 30, 20, 20, 20, 1);
        int i82 = 24;
        super(1, 32, i82, 16, 14, 2);
        int i44 = 0;
        int i157 = 1;
        super(i44, 36, i82, 22, 22, i157);
        int i83 = 28;
        super(i44, 44, i83, 24, 24, i157);
        int i137 = 14;
        super(1, 49, i83, 22, i137, 2);
        int i46 = 0;
        int i159 = 4;
        super(i46, 62, 36, 14, i137, i159);
        super(i46, 86, 42, 16, 16, i159);
        super(i46, 114, 48, 18, 18, i159);
        super(i46, 144, 56, 20, 20, i159);
        super(i46, 174, 68, 22, 22, i159);
        super(i46, 204, 84, 24, 24, i159, 102, 42);
        int i160 = 16;
        super(i46, 280, 112, 14, 14, i160, 140, 56);
        super(i46, 368, 144, 16, 16, i160, 92, 36);
        super(i46, 456, 192, 18, 18, i160, 114, 48);
        super(i46, 576, 224, 20, 20, i160, 144, 56);
        super(i46, 696, 272, 22, 22, i160, 174, 68);
        super(i46, 816, 336, 24, 24, i160, 136, 56);
        int i161 = 36;
        super(i46, 1050, 408, 18, 18, i161, 175, 68);
        super(i46, 1304, 496, 20, 20, i161, 163, 62);
        d dVar = new d();
        k.i = arr;
    }

    public k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        super(z, i2, i3, i4, i5, i6, i2, i3);
    }

    k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super();
        this.a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    private int e() {
        int i2;
        int i;
        int i3 = this.f;
        i = 4;
        if (i3 != 1 && i3 != 2 && i3 != i && i3 != 16) {
            if (i3 != 2) {
                i = 4;
                if (i3 != i) {
                    if (i3 != 16) {
                        if (i3 != 36) {
                        } else {
                            return 6;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                        throw illegalStateException;
                    }
                    return i;
                }
            }
        }
        return i2;
    }

    private int k() {
        int i;
        int i2 = this.f;
        int i4 = 1;
        i = 2;
        int i5 = 4;
        if (i2 != i4 && i2 != i && i2 != i5 && i2 != 16) {
            i = 2;
            if (i2 != i) {
                i5 = 4;
                if (i2 != i5) {
                    if (i2 != 16) {
                        if (i2 != 36) {
                        } else {
                            return 6;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                        throw illegalStateException;
                    }
                    return i5;
                }
                return i;
            }
        }
        return i4;
    }

    public static com.google.zxing.h.b.k l(int i, com.google.zxing.h.b.l l2, b b3, b b4, boolean z5) {
        int i3;
        com.google.zxing.h.b.k kVar;
        boolean fORCE_RECTANGLE;
        int i2;
        final com.google.zxing.h.b.k[] objArr = k.i;
        i3 = 0;
        while (i3 < objArr.length) {
            kVar = objArr[i3];
            i3++;
        }
        if (z5) {
        } else {
            return null;
        }
        IllegalArgumentException obj7 = new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
        throw obj7;
    }

    public final int a() {
        return this.b;
    }

    public int b(int i) {
        return this.g;
    }

    public final int c() {
        return this.c;
    }

    public final int d(int i) {
        return this.h;
    }

    public int f() {
        return i /= i3;
    }

    public final int g() {
        return i *= i3;
    }

    public final int h() {
        return i *= i3;
    }

    public final int i() {
        return i += i4;
    }

    public final int j() {
        return i += i4;
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        str = this.a ? "Rectangular Symbol:" : "Square Symbol:";
        stringBuilder.append(str);
        stringBuilder.append(" data region ");
        stringBuilder.append(this.d);
        int i2 = 120;
        stringBuilder.append(i2);
        stringBuilder.append(this.e);
        stringBuilder.append(", symbol size ");
        stringBuilder.append(j());
        stringBuilder.append(i2);
        stringBuilder.append(i());
        stringBuilder.append(", symbol data size ");
        stringBuilder.append(h());
        stringBuilder.append(i2);
        stringBuilder.append(g());
        stringBuilder.append(", codewords ");
        stringBuilder.append(this.b);
        stringBuilder.append('+');
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
