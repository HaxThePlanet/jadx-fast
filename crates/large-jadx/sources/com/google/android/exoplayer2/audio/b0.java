package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class b0 {

    private static final String[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;

    public static final class a {

        public int a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean a(int i) {
            int i2;
            int i4;
            int i3;
            int i5;
            int i8;
            int i7;
            int i6;
            int i9;
            int i18 = 0;
            if (!b0.a(i)) {
                return i18;
            }
            final int i21 = 3;
            i10 &= i21;
            final int i22 = 1;
            if (i11 == i22) {
                return i18;
            }
            i23 &= i21;
            if (i8 == 0) {
                return i18;
            }
            int i26 = 15;
            i24 &= i26;
            if (i25 != 0) {
                if (i25 == i26) {
                } else {
                    i27 &= i21;
                    if (i28 == i21) {
                        return i18;
                    }
                    this.a = i11;
                    this.b = b0.b()[i8 - 3];
                    i5 = b0.c()[i28];
                    this.d = i5;
                    i6 = 2;
                    if (i11 == i6) {
                        this.d = i5 /= i6;
                    } else {
                        if (i11 == 0) {
                            this.d = i5 /= 4;
                        }
                    }
                    i19 &= i22;
                    this.g = b0.d(i11, i8);
                    if (i8 == i21) {
                        if (i11 == i21) {
                            i3 = b0.e()[i25 -= i22];
                        } else {
                            i3 = b0.f()[i25 -= i22];
                        }
                        this.f = i3;
                        this.c = i17 *= 4;
                    } else {
                        if (i11 == i21) {
                            if (i8 == i6) {
                                i4 = b0.g()[i25 -= i22];
                            } else {
                                i4 = b0.h()[i25 -= i22];
                            }
                            this.f = i4;
                            this.c = i14 += i20;
                        } else {
                            int i12 = b0.i()[i25 -= i22];
                            this.f = i12;
                            if (i8 == i22) {
                                i9 = 72;
                            }
                            this.c = i31 += i20;
                        }
                    }
                    if (obj9 &= i21 == i21) {
                        i6 = i22;
                    }
                }
                this.e = i6;
                return i22;
            }
            return i18;
        }
    }
    static {
        b0.a = /* result */;
        int[] iArr = new int[3];
        iArr = new int[]{44100, 48000, 32000};
        b0.b = iArr;
        int i2 = 14;
        int[] iArr3 = new int[i2];
        iArr3 = new int[]{32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
        b0.c = iArr3;
        int[] iArr4 = new int[i2];
        iArr4 = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
        b0.d = iArr4;
        int[] iArr5 = new int[i2];
        iArr5 = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
        b0.e = iArr5;
        int[] iArr6 = new int[i2];
        iArr6 = new int[]{32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
        b0.f = iArr6;
        int[] iArr2 = new int[i2];
        iArr2 = new int[]{8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};
        b0.g = iArr2;
    }

    static boolean a(int i) {
        return b0.l(i);
    }

    static String[] b() {
        return b0.a;
    }

    static int[] c() {
        return b0.b;
    }

    static int d(int i, int i2) {
        return b0.k(i, i2);
    }

    static int[] e() {
        return b0.c;
    }

    static int[] f() {
        return b0.d;
    }

    static int[] g() {
        return b0.e;
    }

    static int[] h() {
        return b0.f;
    }

    static int[] i() {
        return b0.g;
    }

    public static int j(int i) {
        int i2;
        int i5;
        int i3;
        int i4;
        int[] iArr;
        int i6;
        int i13 = -1;
        if (!b0.l(i)) {
            return i13;
        }
        final int i14 = 3;
        i7 &= i14;
        final int i15 = 1;
        if (i8 == i15) {
            return i13;
        }
        i16 &= i14;
        if (i17 == 0) {
            return i13;
        }
        int i26 = 15;
        i18 &= i26;
        if (i19 != 0) {
            if (i19 == i26) {
            } else {
                i27 &= i14;
                if (i28 == i14) {
                    return i13;
                }
                i5 = b0.b[i28];
                int i29 = 2;
                if (i8 == i29) {
                    i5 /= 2;
                } else {
                    if (i8 == 0) {
                        i5 /= 4;
                    }
                }
                obj7 &= i15;
                if (i17 == i14) {
                    if (i8 == i14) {
                        i2 = b0.c[i19 -= i15];
                    } else {
                        i2 = b0.d[i19 -= i15];
                    }
                    return i11 *= 4;
                }
                if (i8 == i14) {
                    if (i17 == i29) {
                        i3 = b0.e[i19 -= i15];
                    } else {
                        i3 = b0.f[i19 -= i15];
                    }
                } else {
                    i3 = b0.g[i19 -= i15];
                }
                if (i8 == i14) {
                    return i21 += obj7;
                }
                if (i17 == i15) {
                    i6 = 72;
                }
            }
            return i31 += obj7;
        }
        return i13;
    }

    private static int k(int i, int i2) {
        int i3;
        final int i5 = 3;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                if (i2 != i5) {
                } else {
                    return 384;
                }
                IllegalArgumentException obj3 = new IllegalArgumentException();
                throw obj3;
            }
            return 1152;
        }
        if (i == i5) {
        } else {
            i3 = 576;
        }
        return i3;
    }

    private static boolean l(int i) {
        int obj1;
        final int i2 = -2097152;
        obj1 = i &= i2 == i2 ? 1 : 0;
        return obj1;
    }

    public static int m(int i) {
        final int i4 = -1;
        if (!b0.l(i)) {
            return i4;
        }
        final int i5 = 3;
        i2 &= i5;
        if (i3 == 1) {
            return i4;
        }
        i7 &= i5;
        if (i8 == 0) {
            return i4;
        }
        final int i11 = 15;
        i9 &= i11;
        if (i10 != 0 && i10 != i11 && obj6 &= i5 == i5) {
            if (i10 != i11) {
                if (obj6 &= i5 == i5) {
                }
                return b0.k(i3, i8);
            }
        }
        return i4;
    }
}
