package com.google.android.exoplayer2.video.b0;

import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
final class h {

    public final com.google.android.exoplayer2.video.b0.h.a a;
    public final com.google.android.exoplayer2.video.b0.h.a b;
    public final int c;
    public final boolean d;

    public static final class a {

        private final com.google.android.exoplayer2.video.b0.h.b[] a;
        public a(com.google.android.exoplayer2.video.b0.h.b... h$bArr) {
            super();
            this.a = bArr;
        }

        public com.google.android.exoplayer2.video.b0.h.b a(int i) {
            return this.a[i];
        }

        public int b() {
            return objArr.length;
        }
    }

    public static final class b {

        public final int a;
        public final int b;
        public final float[] c;
        public final float[] d;
        public b(int i, float[] f2Arr2, float[] f3Arr3, int i4) {
            int obj7;
            super();
            this.a = i;
            obj7 = Long.compare(i2, i5) == 0 ? 1 : 0;
            g.a(obj7);
            this.c = f2Arr2;
            this.d = f3Arr3;
            this.b = i4;
        }

        public int a() {
            return length /= 3;
        }
    }
    public h(com.google.android.exoplayer2.video.b0.h.a h$a, int i2) {
        super(a, a, i2);
    }

    public h(com.google.android.exoplayer2.video.b0.h.a h$a, com.google.android.exoplayer2.video.b0.h.a h$a2, int i3) {
        int obj1;
        super();
        this.a = a;
        this.b = a2;
        this.c = i3;
        obj1 = a == a2 ? 1 : 0;
        this.d = obj1;
    }

    public static com.google.android.exoplayer2.video.b0.h a(float f, int i2, int i3, float f4, float f5, int i6) {
        int i16;
        int i20;
        int i32;
        int i34;
        int i5;
        int i26;
        int i23;
        int i25;
        int cmp2;
        int i41;
        int i;
        int i30;
        int cmp;
        int i33;
        int i21;
        int i4;
        int i7;
        int i15;
        double d2;
        int i24;
        int i42;
        int i31;
        int i12;
        float[] fArr2;
        int i19;
        int i22;
        float[] fArr;
        int i27;
        int i8;
        int i40;
        int i11;
        int i28;
        int i35;
        int i38;
        int i17;
        int i13;
        int i36;
        int i29;
        int i14;
        int i18;
        int i37;
        double d;
        int i9;
        double d3;
        float[] fArr3;
        int i10;
        int i39;
        int obj35;
        int i43 = f;
        i16 = i2;
        i34 = i3;
        int i52 = f4;
        int i53 = f5;
        int i54 = 0;
        i24 = 1;
        i41 = Float.compare(i43, i54) > 0 ? i24 : 0;
        g.a(i41);
        i = i16 >= i24 ? i24 : 0;
        g.a(i);
        i30 = i34 >= i24 ? i24 : 0;
        g.a(i30);
        if (Float.compare(i52, i54) > 0 && Float.compare(i52, i60) <= 0) {
            i33 = Float.compare(i52, i60) <= 0 ? i24 : 0;
        } else {
        }
        g.a(i33);
        if (Float.compare(i53, i54) > 0 && Float.compare(i53, i55) <= 0) {
            i26 = Float.compare(i53, i55) <= 0 ? i24 : 0;
        } else {
        }
        g.a(i26);
        double radians2 = Math.toRadians((double)i52);
        float f3 = (float)radians2;
        float f6 = (float)radians;
        i23 = f3 / f7;
        i21 = f6 / f9;
        i27 = 2;
        i69 *= i16;
        float[] fArr6 = new float[i70 * 3];
        fArr = new float[i70 *= i27];
        i40 = 0;
        i28 = 0;
        i35 = 0;
        while (i40 < i16) {
            i38 = 1073741824;
            i13 = f3 / i38;
            i62 -= i13;
            i75 -= i13;
            i20 = 0;
            while (i20 < i19) {
                obj35 = i7;
                i15 = 0;
                i31 = 2;
                while (i15 < i31) {
                    if (i15 == 0) {
                    } else {
                    }
                    i36 = i19;
                    i12 = i8;
                    f11 *= i21;
                    int i61 = i81 - i82;
                    i29 = i28 + 1;
                    i14 = i20;
                    double d4 = (double)i43;
                    i37 = i23;
                    double d7 = (double)i61;
                    i9 = i15;
                    d2 = (double)i12;
                    fArr3 = fArr;
                    fArr6[i28] = -f12;
                    int i74 = i29 + 1;
                    int i76 = i40;
                    fArr6[i29] = (float)i79;
                    i11 = i74 + 1;
                    fArr6[i74] = (float)i47;
                    int i48 = i35 + 1;
                    fArr3[i35] = i65 /= f6;
                    i5 = i48 + 1;
                    fArr3[i48] = i57 /= f3;
                    if (i14 == 0) {
                    } else {
                    }
                    if (i14 == i3 && i9 == 1) {
                    } else {
                    }
                    fArr2 = fArr3;
                    i22 = 2;
                    i35 = i5;
                    i28 = i11;
                    i15 = i4 + 1;
                    i34 = i32;
                    i20 = i25;
                    fArr = fArr2;
                    i31 = i22;
                    i40 = i76;
                    i19 = i36;
                    i21 = i18;
                    i23 = i37;
                    i8 = i10;
                    if (i9 == 1) {
                    } else {
                    }
                    System.arraycopy(fArr6, i11 + -3, fArr6, i11, 3);
                    i11 += 3;
                    fArr2 = fArr3;
                    System.arraycopy(fArr2, i5 + -2, fArr2, i5, 2);
                    i5 += 2;
                    if (i9 != 0) {
                    } else {
                    }
                    i32 = i3;
                    i25 = i14;
                    i4 = i9;
                    i12 = obj35;
                    i36 = i19;
                }
                i18 = i21;
                int i77 = i40;
                int i67 = i31;
                float[] fArr5 = fArr;
                i7 = obj35;
                i42 = i13;
                i19 = i36;
                i23 = i37;
                i8 = i10;
                i34 = i49;
                i20 = i39;
                if (i15 == 0) {
                } else {
                }
                i36 = i19;
                i12 = i8;
                f11 *= i21;
                i61 = i81 - i82;
                i29 = i28 + 1;
                i14 = i20;
                d4 = (double)i43;
                i37 = i23;
                d7 = (double)i61;
                i9 = i15;
                d2 = (double)i12;
                fArr3 = fArr;
                fArr6[i28] = -f12;
                i74 = i29 + 1;
                i76 = i40;
                fArr6[i29] = (float)i79;
                i11 = i74 + 1;
                fArr6[i74] = (float)i47;
                i48 = i35 + 1;
                fArr3[i35] = i65 /= f6;
                i5 = i48 + 1;
                fArr3[i48] = i57 /= f3;
                if (i14 == 0) {
                } else {
                }
                if (i14 == i3 && i9 == 1) {
                } else {
                }
                fArr2 = fArr3;
                i22 = 2;
                i35 = i5;
                i28 = i11;
                i15 = i4 + 1;
                i34 = i32;
                i20 = i25;
                fArr = fArr2;
                i31 = i22;
                i40 = i76;
                i19 = i36;
                i21 = i18;
                i23 = i37;
                i8 = i10;
                if (i9 == 1) {
                } else {
                }
                System.arraycopy(fArr6, i11 + -3, fArr6, i11, 3);
                i11 += 3;
                fArr2 = fArr3;
                System.arraycopy(fArr2, i5 + -2, fArr2, i5, 2);
                i5 += 2;
                if (i9 != 0) {
                } else {
                }
                i32 = i3;
                i25 = i14;
                i4 = i9;
                i12 = obj35;
                i36 = i19;
            }
            i16 = i2;
            i40 = i17;
            i24 = 1;
            i27 = 2;
            obj35 = i7;
            i15 = 0;
            i31 = 2;
            while (i15 < i31) {
                if (i15 == 0) {
                } else {
                }
                i36 = i19;
                i12 = i8;
                f11 *= i21;
                i61 = i81 - i82;
                i29 = i28 + 1;
                i14 = i20;
                d4 = (double)i43;
                i37 = i23;
                d7 = (double)i61;
                i9 = i15;
                d2 = (double)i12;
                fArr3 = fArr;
                fArr6[i28] = -f12;
                i74 = i29 + 1;
                i76 = i40;
                fArr6[i29] = (float)i79;
                i11 = i74 + 1;
                fArr6[i74] = (float)i47;
                i48 = i35 + 1;
                fArr3[i35] = i65 /= f6;
                i5 = i48 + 1;
                fArr3[i48] = i57 /= f3;
                if (i14 == 0) {
                } else {
                }
                if (i14 == i3 && i9 == 1) {
                } else {
                }
                fArr2 = fArr3;
                i22 = 2;
                i35 = i5;
                i28 = i11;
                i15 = i4 + 1;
                i34 = i32;
                i20 = i25;
                fArr = fArr2;
                i31 = i22;
                i40 = i76;
                i19 = i36;
                i21 = i18;
                i23 = i37;
                i8 = i10;
                if (i9 == 1) {
                } else {
                }
                System.arraycopy(fArr6, i11 + -3, fArr6, i11, 3);
                i11 += 3;
                fArr2 = fArr3;
                System.arraycopy(fArr2, i5 + -2, fArr2, i5, 2);
                i5 += 2;
                if (i9 != 0) {
                } else {
                }
                i32 = i3;
                i25 = i14;
                i4 = i9;
                i12 = obj35;
                i36 = i19;
            }
            i18 = i21;
            i77 = i40;
            i67 = i31;
            fArr5 = fArr;
            i7 = obj35;
            i42 = i13;
            i19 = i36;
            i23 = i37;
            i8 = i10;
            i34 = i49;
            i20 = i39;
            if (i15 == 0) {
            } else {
            }
            i36 = i19;
            i12 = i8;
            f11 *= i21;
            i61 = i81 - i82;
            i29 = i28 + 1;
            i14 = i20;
            d4 = (double)i43;
            i37 = i23;
            d7 = (double)i61;
            i9 = i15;
            d2 = (double)i12;
            fArr3 = fArr;
            fArr6[i28] = -f12;
            i74 = i29 + 1;
            i76 = i40;
            fArr6[i29] = (float)i79;
            i11 = i74 + 1;
            fArr6[i74] = (float)i47;
            i48 = i35 + 1;
            fArr3[i35] = i65 /= f6;
            i5 = i48 + 1;
            fArr3[i48] = i57 /= f3;
            if (i14 == 0) {
            } else {
            }
            if (i14 == i3 && i9 == 1) {
            } else {
            }
            fArr2 = fArr3;
            i22 = 2;
            i35 = i5;
            i28 = i11;
            i15 = i4 + 1;
            i34 = i32;
            i20 = i25;
            fArr = fArr2;
            i31 = i22;
            i40 = i76;
            i19 = i36;
            i21 = i18;
            i23 = i37;
            i8 = i10;
            if (i9 == 1) {
            } else {
            }
            System.arraycopy(fArr6, i11 + -3, fArr6, i11, 3);
            i11 += 3;
            fArr2 = fArr3;
            System.arraycopy(fArr2, i5 + -2, fArr2, i5, 2);
            i5 += 2;
            if (i9 != 0) {
            } else {
            }
            i32 = i3;
            i25 = i14;
            i4 = i9;
            i12 = obj35;
            i36 = i19;
        }
        int i45 = 0;
        int i50 = 1;
        h.b bVar = new h.b(i45, fArr6, fArr, i50);
        com.google.android.exoplayer2.video.b0.h.b[] arr = new h.b[i50];
        arr[i45] = bVar;
        h.a aVar = new h.a(arr);
        h hVar = new h(aVar, i6);
        return hVar;
    }

    public static com.google.android.exoplayer2.video.b0.h b(int i) {
        return h.a(1112014848, 36, 72, 1127481344, 1135869952, i);
    }
}
