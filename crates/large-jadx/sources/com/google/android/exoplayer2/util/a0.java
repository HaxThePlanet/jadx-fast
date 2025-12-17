package com.google.android.exoplayer2.util;

import com.google.firebase.firestore.ktx.R.styleable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a0 {

    public static final byte[] a;
    public static final float[] b;
    private static final Object c;
    private static int[] d;

    public static final class a {

        public final int a;
        public final int b;
        public final boolean c;
        public a(int i, int i2, boolean z3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = z3;
        }
    }

    public static final class b {

        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final float g;
        public final boolean h;
        public final boolean i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;
        public b(int i, int i2, int i3, int i4, int i5, int i6, float f7, boolean z8, boolean z9, int i10, int i11, int i12, boolean z13) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = f7;
            this.h = z8;
            this.i = z9;
            this.j = i10;
            this.k = i11;
            this.l = i12;
            this.m = z13;
        }
    }
    static {
        byte[] bArr = new byte[4];
        bArr = new byte[]{0, 0, 0, 1};
        a0.a = bArr;
        float[] fArr = new float[17];
        fArr = new int[]{
            1065353216, 1065353216, 1066115817, 1063828015, 1069166220, 1067132618, 1074504425, 1072216623, 1077554828, 1075521226,
            1070691421, 1068403619, 1073233424, 1070521954, 1068149419, 1069547520, 1073741824
        };
        a0.b = fArr;
        Object object = new Object();
        a0.c = object;
        a0.d = new int[10];
    }

    public static void a(boolean[] zArr) {
        final int i = 0;
        zArr[i] = i;
        zArr[1] = i;
        zArr[2] = i;
    }

    public static void b(ByteBuffer byteBuffer) {
        int i7;
        int i5;
        int i4;
        int i6;
        int i;
        int i2;
        int i3;
        final int position = byteBuffer.position();
        final int i8 = 0;
        i5 = i7;
        i4 = i7 + 1;
        while (i4 < position) {
            b &= 255;
            i = 3;
            if (i6 == 0) {
            }
            if (i6 != 0) {
            }
            i7 = i4;
            i4 = i7 + 1;
            i5 = i8;
            i5++;
        }
        byteBuffer.clear();
    }

    public static int c(byte[] bArr, int i2, int i3, boolean[] z4Arr4) {
        int i5;
        int i4;
        boolean z;
        int i;
        byte b;
        int obj8;
        final int i6 = i3 - i2;
        i5 = 0;
        final int i7 = 1;
        i4 = i6 >= 0 ? i7 : i5;
        g.f(i4);
        if (i6 == 0) {
            return i3;
        }
        if (z4Arr4[i5]) {
            a0.a(z4Arr4);
            return i2 += -3;
        }
        int i8 = 2;
        if (i6 > i7 && z4Arr4[i7] && bArr[i2] == i7) {
            if (z4Arr4[i7]) {
                if (bArr[i2] == i7) {
                    a0.a(z4Arr4);
                    return i2 -= i8;
                }
            }
        }
        if (i6 > i8 && z4Arr4[i8] && bArr[i2] == 0 && bArr[i2 + 1] == i7) {
            if (z4Arr4[i8]) {
                if (bArr[i2] == 0) {
                    if (bArr[i2 + 1] == i7) {
                        a0.a(z4Arr4);
                        return i2 -= i7;
                    }
                }
            }
        }
        int i10 = i3 + -1;
        i2 += i8;
        while (obj8 < i10) {
            i = obj8 + -2;
            obj8 += -2;
            obj8 += 3;
        }
        if (i6 > i8 && bArr[i3 + -3] == 0 && bArr[i3 + -2] == 0 && bArr[i10] == i7) {
            if (bArr[i3 + -3] == 0) {
                if (bArr[i3 + -2] == 0) {
                    if (bArr[i10] == i7) {
                        obj8 = i7;
                    } else {
                        obj8 = i5;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        z4Arr4[i5] = obj8;
        if (i6 > i7) {
            if (bArr[i3 + -2] == 0 && bArr[i10] == 0) {
                if (bArr[i10] == 0) {
                    obj8 = i7;
                } else {
                    obj8 = i5;
                }
            } else {
            }
        } else {
            if (z4Arr4[i8] && bArr[i10] == 0) {
                if (bArr[i10] == 0) {
                } else {
                }
            } else {
            }
        }
        z4Arr4[i7] = obj8;
        if (bArr[i10] == 0) {
            i5 = i7;
        }
        z4Arr4[i8] = i5;
        return i3;
    }

    private static int d(byte[] bArr, int i2, int i3) {
        byte b;
        int i;
        while (i2 < i3 + -2) {
            i2++;
        }
        return i3;
    }

    public static int e(byte[] bArr, int i2) {
        return obj0 >>= 1;
    }

    public static int f(byte[] bArr, int i2) {
        return obj0 &= 31;
    }

    public static boolean g(String string, byte b2) {
        int equals;
        int i2;
        int i;
        Object obj3;
        int obj4;
        if ("video/avc".equals(string)) {
            if (b2 & 31 != 6) {
                if ("video/hevc".equals(string) && obj3 >>= i2 == 39) {
                    if (obj3 >>= i2 == 39) {
                    } else {
                        i2 = 0;
                    }
                } else {
                }
            }
        } else {
        }
        return i2;
    }

    public static com.google.android.exoplayer2.util.a0.a h(byte[] bArr, int i2, int i3) {
        e0 e0Var = new e0(bArr, i2, i3);
        e0Var.l(8);
        e0Var.k();
        a0.a aVar = new a0.a(e0Var.h(), e0Var.h(), e0Var.d());
        return aVar;
    }

    public static com.google.android.exoplayer2.util.a0.b i(byte[] bArr, int i2, int i3) {
        float e0Var;
        long i4;
        int i5;
        int i6;
        boolean z3;
        int str;
        int cmp;
        int i13;
        int i14;
        int stringBuilder;
        float f;
        int i;
        int i18;
        int i7;
        int i17;
        int z4;
        int i16;
        boolean z;
        int i9;
        boolean z2;
        int i8;
        int i12;
        int i10;
        int i11;
        int i15;
        e0Var = new e0(bArr, i2, i3);
        i4 = 8;
        e0Var.l(i4);
        int i31 = e0Var.e(i4);
        int i23 = 3;
        stringBuilder = 1;
        if (i31 != 100 && i31 != 110 && i31 != 122 && i31 != 244 && i31 != 44 && i31 != 83 && i31 != 86 && i31 != 118 && i31 != 128) {
            if (i31 != 110) {
                if (i31 != 122) {
                    if (i31 != 244) {
                        if (i31 != 44) {
                            if (i31 != 83) {
                                if (i31 != 86) {
                                    if (i31 != 118) {
                                        if (i31 != 128) {
                                            if (i31 == 138) {
                                                i7 = e0Var.h();
                                                if (i7 == i23) {
                                                    i17 = e0Var.d();
                                                } else {
                                                    i17 = 0;
                                                }
                                                e0Var.h();
                                                e0Var.h();
                                                e0Var.k();
                                                if (e0Var.d()) {
                                                    z4 = i7 != i23 ? i4 : 12;
                                                    i16 = 0;
                                                    while (i16 < z4) {
                                                        if (e0Var.d()) {
                                                        }
                                                        i16++;
                                                        if (i16 < 6) {
                                                        } else {
                                                        }
                                                        z = 64;
                                                        a0.j(e0Var, z);
                                                        z = 16;
                                                    }
                                                }
                                            } else {
                                                i7 = stringBuilder;
                                                i17 = 0;
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int i45 = e0Var.h();
        if (i45 == 0) {
            i47 += 4;
            z2 = 0;
        } else {
            if (i45 == stringBuilder) {
                e0Var.g();
                e0Var.g();
                i8 = 0;
                while (Long.compare(l, i4) < 0) {
                    e0Var.h();
                    i8++;
                }
                z2 = z6;
                i9 = 0;
            } else {
                i9 = 0;
            }
        }
        e0Var.h();
        e0Var.k();
        final boolean z7 = e0Var.d();
        if (!z7) {
            e0Var.k();
        }
        e0Var.k();
        int i26 = 16;
        if (e0Var.d()) {
            if (i7 == 0) {
                i7 = z7 - 2;
            } else {
                i11 = 2;
                if (i7 == 3) {
                    i = 1;
                    i15 = 1;
                } else {
                    i15 = i11;
                    i = 1;
                }
                if (i7 == i) {
                    i = i11;
                }
                i42 *= i;
                stringBuilder = i15;
            }
            i5 -= z3;
            i13 -= i12;
        }
        i6 = 1065353216;
        if (e0Var.d() && e0Var.d()) {
            if (e0Var.d()) {
                str = e0Var.e(8);
                if (str == 255) {
                    stringBuilder = 16;
                    str = e0Var.e(stringBuilder);
                    e0Var = e0Var.e(stringBuilder);
                    if (str != null && e0Var != 0) {
                        if (e0Var != 0) {
                            f2 /= e0Var;
                        }
                    }
                    f = i6;
                } else {
                    float[] fArr = a0.b;
                    if (str < fArr.length) {
                        f = e0Var;
                    } else {
                        stringBuilder = new StringBuilder(46);
                        stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                        stringBuilder.append(str);
                        v.h("NalUnitUtil", stringBuilder.toString());
                    }
                }
            } else {
            }
        } else {
        }
        super(i31, e0Var.e(i4), e0Var.e(i4), e0Var.h(), i5, i13, f, i17, z7, i43 += 4, i45, i9, z2);
        return bVar;
    }

    private static void j(com.google.android.exoplayer2.util.e0 e0, int i2) {
        int i;
        int i3;
        int i4;
        i4 = i8;
        i3 = i;
        while (i4 < i2) {
            if (i != 0) {
            }
            if (i == 0) {
            } else {
            }
            i3 = i;
            i4++;
            i7 %= 256;
        }
    }

    public static int k(byte[] bArr, int i2) {
        int i3;
        int i6;
        int i;
        int[] iArr;
        int i4;
        int[] copyOf;
        int i9;
        int i8;
        int length;
        int i7;
        int i5;
        final Object obj = a0.c;
        int i10 = 0;
        i = i3;
        synchronized (obj) {
            while (i3 < i2) {
                i3 = a0.d(bArr, i3, i2);
                copyOf = a0.d;
                if (i3 < i2 && copyOf.length <= i) {
                }
                copyOf = a0.d;
                if (copyOf.length <= i) {
                }
                a0.d[i] = i3;
                i3 += 3;
                i = i9;
                a0.d = Arrays.copyOf(copyOf, length2 *= 2);
            }
            i2 -= i;
            i8 = i4;
            try {
                while (i6 < i) {
                    i13 -= i8;
                    System.arraycopy(bArr, i8, bArr, i4, i14);
                    i4 += i14;
                    i5 = i12 + 1;
                    bArr[i12] = i10;
                    i4 = i5 + 1;
                    bArr[i5] = i10;
                    i8 += i7;
                    i6++;
                }
                i13 -= i8;
                System.arraycopy(bArr, i8, bArr, i4, i14);
                i4 += i14;
                i5 = i12 + 1;
                bArr[i12] = i10;
                i4 = i5 + 1;
                bArr[i5] = i10;
                i8 += i7;
                i6++;
                System.arraycopy(bArr, i8, bArr, i4, obj9 - i4);
                return obj9;
                throw bArr;
            }
        }
    }
}
