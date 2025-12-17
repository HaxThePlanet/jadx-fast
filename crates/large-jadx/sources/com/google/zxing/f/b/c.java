package com.google.zxing.f.b;

import com.google.zxing.common.reedsolomon.a;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.g.a;
import com.google.zxing.g.b;

/* loaded from: classes2.dex */
public final class c {

    private static final int[] a;
    static {
        int[] iArr = new int[33];
        iArr = new int[]{
            4, 6, 6, 8, 8, 8, 8, 8, 8, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 12, 12, 12, 12, 12, 12, 12,
            12, 12, 12
        };
        c.a = iArr;
    }

    private static int[] a(a a, int i2, int i3) {
        int i5;
        int i4;
        int i;
        int i6;
        int i7;
        final int[] obj9 = new int[i3];
        final int i10 = 0;
        i5 = i10;
        while (i5 < i8 /= i2) {
            i = i4;
            while (i4 < i2) {
                if (a.f(i11 += i4)) {
                } else {
                }
                i6 = i10;
                i |= i6;
                i4++;
                i7 = 1;
                i6 = i7 << i14;
            }
            obj9[i5] = i;
            i5++;
            if (a.f(i11 += i4)) {
            } else {
            }
            i6 = i10;
            i |= i6;
            i4++;
            i7 = 1;
            i6 = i7 << i14;
        }
        return obj9;
    }

    private static void b(b b, int i2, int i3) {
        int i;
        int i4;
        int i5;
        int i6;
        i = 0;
        while (i < i3) {
            i4 = i2 - i;
            i5 = i4;
            i6 = i2 + i;
            while (i5 <= i6) {
                b.g(i5, i4);
                b.g(i5, i6);
                b.g(i4, i5);
                b.g(i6, i5);
                i5++;
                i6 = i2 + i;
            }
            i += 2;
            b.g(i5, i4);
            b.g(i5, i6);
            b.g(i4, i5);
            b.g(i6, i5);
            i5++;
        }
        int i7 = i2 - i3;
        b.g(i7, i7);
        int i8 = i7 + 1;
        b.g(i8, i7);
        b.g(i7, i8);
        i2 += i3;
        b.g(obj5, i7);
        b.g(obj5, i8);
        b.g(obj5, obj5 + -1);
    }

    private static void c(b b, boolean z2, int i3, a a4) {
        int i;
        boolean z8;
        boolean z;
        boolean z7;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int obj3;
        i3 /= 2;
        i = 0;
        if (z2 != 0) {
        }
        while (i < 10) {
            obj3 += i2;
            if (a4.f(i)) {
            }
            if (a4.f(i + 10)) {
            }
            if (a4.f(i - 29)) {
            }
            if (a4.f(i - 39)) {
            }
            i++;
            b.g(obj4 + -7, obj3);
            b.g(obj3, obj4 + 7);
            b.g(obj4 + 7, obj3);
            b.g(obj3, obj4 + -7);
        }
    }

    public static com.google.zxing.f.b.a d(byte[] bArr, int i2, int i3) {
        a aVar3;
        int str;
        int i13;
        int i17;
        int i18;
        int i20;
        int i11;
        int aVar;
        int i24;
        int i8;
        int i26;
        boolean z;
        boolean z4;
        boolean z2;
        boolean z3;
        int i25;
        int i15;
        int i28;
        int[] iArr;
        int i10;
        int i4;
        int i5;
        int i6;
        int i27;
        int i12;
        int i23;
        int i22;
        int i21;
        int i16;
        int i29;
        int i;
        int i19;
        int i7;
        int i14;
        int i9;
        a aVar2;
        d dVar = new d(bArr);
        a aVar4 = dVar.a();
        i34 += i17;
        i8 = 0;
        i26 = 1;
        if (i3 != 0) {
            i20 = i3 < 0 ? i26 : i8;
            i25 = Math.abs(i3);
            if (i20 != 0) {
                i24 = 4;
            }
            if (i25 > i24) {
            } else {
                i11 = c.i(i25, i20);
                i28 = c.a[i25];
                aVar3 = c.h(aVar4, i28);
                str = "Data to large for user specified layer";
                if (i72 += str > i11 - i69) {
                } else {
                    if (i20 != 0) {
                        if (aVar3.g() > i28 << 6) {
                        } else {
                        }
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(str);
                        throw illegalArgumentException3;
                    }
                    a aVar5 = c.e(aVar3, i11, i28);
                    i30 /= i28;
                    if (i20 != 0) {
                    } else {
                        i17 = 14;
                    }
                    i17 += i62;
                    iArr = new int[i18];
                    if (i20 != 0) {
                        i12 = i8;
                        while (i12 < i18) {
                            iArr[i12] = i12;
                            i12++;
                        }
                        i27 = i18;
                    } else {
                        i23 = i18 / 2;
                        i22 = i27 / 2;
                        i16 = i8;
                        while (i16 < i23) {
                            i79 += i16;
                            iArr[i83 -= i26] = i85--;
                            iArr[i23 + i16] = i81 += i26;
                            i16++;
                        }
                    }
                    b bVar = new b(i27);
                    i29 = i21;
                    while (i21 < i25) {
                        if (i20 != 0) {
                        } else {
                        }
                        i7 = 12;
                        i78 += i7;
                        i19 = i8;
                        while (i19 < i) {
                            i14 = i19 << 1;
                            while (i8 < i5) {
                                if (aVar5.f(i9 + i8)) {
                                }
                                if (aVar5.f(i42 += i8)) {
                                }
                                if (aVar5.f(i46 += i8)) {
                                }
                                if (aVar5.f(i53 += i8)) {
                                }
                                i8++;
                                i26 = 1;
                                i5 = 2;
                                int i66 = i21 << 1;
                                bVar.g(iArr[i56 -= i19], iArr[i66 += i8]);
                                i48 -= i64;
                                bVar.g(iArr[i49 - i8], iArr[i49 -= i19]);
                                int i58 = i21 << 1;
                                bVar.g(iArr[i58 + i19], iArr[i87 -= i8]);
                                int i59 = i21 << 1;
                                bVar.g(iArr[i59 + i8], iArr[i59 += i19]);
                            }
                            i19++;
                            i8 = 0;
                            i26 = 1;
                            i5 = 2;
                            if (aVar5.f(i9 + i8)) {
                            }
                            if (aVar5.f(i42 += i8)) {
                            }
                            if (aVar5.f(i46 += i8)) {
                            }
                            if (aVar5.f(i53 += i8)) {
                            }
                            i8++;
                            i26 = 1;
                            i5 = 2;
                            i66 = i21 << 1;
                            bVar.g(iArr[i56 -= i19], iArr[i66 += i8]);
                            i48 -= i64;
                            bVar.g(iArr[i49 - i8], iArr[i49 -= i19]);
                            i58 = i21 << 1;
                            bVar.g(iArr[i58 + i19], iArr[i87 -= i8]);
                            i59 = i21 << 1;
                            bVar.g(iArr[i59 + i8], iArr[i59 += i19]);
                        }
                        i29 += i38;
                        i21++;
                        i8 = 0;
                        i26 = 1;
                        i5 = 2;
                        i14 = i19 << 1;
                        while (i8 < i5) {
                            if (aVar5.f(i9 + i8)) {
                            }
                            if (aVar5.f(i42 += i8)) {
                            }
                            if (aVar5.f(i46 += i8)) {
                            }
                            if (aVar5.f(i53 += i8)) {
                            }
                            i8++;
                            i26 = 1;
                            i5 = 2;
                            i66 = i21 << 1;
                            bVar.g(iArr[i56 -= i19], iArr[i66 += i8]);
                            i48 -= i64;
                            bVar.g(iArr[i49 - i8], iArr[i49 -= i19]);
                            i58 = i21 << 1;
                            bVar.g(iArr[i58 + i19], iArr[i87 -= i8]);
                            i59 = i21 << 1;
                            bVar.g(iArr[i59 + i8], iArr[i59 += i19]);
                        }
                        i19++;
                        i8 = 0;
                        i26 = 1;
                        i5 = 2;
                        if (aVar5.f(i9 + i8)) {
                        }
                        if (aVar5.f(i42 += i8)) {
                        }
                        if (aVar5.f(i46 += i8)) {
                        }
                        if (aVar5.f(i53 += i8)) {
                        }
                        i8++;
                        i26 = 1;
                        i5 = 2;
                        i66 = i21 << 1;
                        bVar.g(iArr[i56 -= i19], iArr[i66 += i8]);
                        i48 -= i64;
                        bVar.g(iArr[i49 - i8], iArr[i49 -= i19]);
                        i58 = i21 << 1;
                        bVar.g(iArr[i58 + i19], iArr[i87 -= i8]);
                        i59 = i21 << 1;
                        bVar.g(iArr[i59 + i8], iArr[i59 += i19]);
                        i7 = 9;
                    }
                    c.c(bVar, i20, i27, c.f(i20, i25, i31));
                    if (i20 != 0) {
                        c.b(bVar, i27 / 2, 5);
                    } else {
                        i13 = i27 / 2;
                        c.b(bVar, i13, 7);
                        aVar = 0;
                        i8 = 0;
                        i26 = 2;
                        while (i8 < i63 -= i21) {
                            iArr = i13 & 1;
                            while (iArr < i27) {
                                i5 = i13 - aVar;
                                bVar.g(i5, iArr);
                                i29 = i13 + aVar;
                                bVar.g(i29, iArr);
                                bVar.g(iArr, i5);
                                bVar.g(iArr, i29);
                                iArr += 2;
                            }
                            i8 += 15;
                            aVar += 16;
                            i5 = i13 - aVar;
                            bVar.g(i5, iArr);
                            i29 = i13 + aVar;
                            bVar.g(i29, iArr);
                            bVar.g(iArr, i5);
                            bVar.g(iArr, i29);
                            iArr += 2;
                        }
                    }
                    a aVar6 = new a();
                    aVar6.c(i20);
                    aVar6.f(i27);
                    aVar6.d(i25);
                    aVar6.b(i31);
                    aVar6.e(bVar);
                    return aVar6;
                }
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(str);
                throw illegalArgumentException2;
            }
            Object[] arr = new Object[i26];
            arr[i8] = Integer.valueOf(i3);
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(String.format("Illegal value %s for layers", arr));
            throw illegalArgumentException4;
        }
        i15 = 0;
        i4 = i10;
        while (i10 <= 32) {
            if (i10 <= 3) {
            } else {
            }
            i6 = i8;
            if (i6 != 0) {
            } else {
            }
            i23 = i10;
            i22 = c.i(i23, i6);
            if (i35 += str <= i22) {
                break;
            } else {
            }
            i10++;
            i26 = i22;
            i8 = 0;
            if (i15 != 0) {
            } else {
            }
            int i61 = c.a[i23];
            i4 = i61;
            i15 = aVar2;
            if (i4 != c.a[i23]) {
            }
            i23 = i10 + 1;
            i6 = i26;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Data too large for an Aztec code");
        throw illegalArgumentException;
    }

    private static a e(a a, int i2, int i3) {
        int i;
        int i4;
        c cVar = new c(c.g(i3));
        int i7 = i2 / i3;
        final int[] obj3 = c.a(a, i3, i7);
        cVar.b(obj3, i7 -= i6);
        a aVar = new a();
        aVar.c(0, i2 %= i3);
        while (i < obj3.length) {
            aVar.c(obj3[i], i3);
            i++;
        }
        return aVar;
    }

    static a f(boolean z, int i2, int i3) {
        a obj2;
        int obj3;
        int obj4;
        a aVar = new a();
        final int i = 4;
        if (z) {
            aVar.c(i2--, 2);
            aVar.c(i3--, 6);
            obj2 = c.e(aVar, 28, i);
        } else {
            aVar.c(i2--, 5);
            aVar.c(i3--, 11);
            obj2 = c.e(aVar, 40, i);
        }
        return obj2;
    }

    private static a g(int i) {
        if (i != 4 && i != 6 && i != 8 && i != 10) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 10) {
                        if (i != 12) {
                        } else {
                            return a.g;
                        }
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
                        throw illegalArgumentException;
                    }
                    return a.h;
                }
                return a.l;
            }
            return a.i;
        }
        return a.j;
    }

    static a h(a a, int i2) {
        int i4;
        int i5;
        int i6;
        int i;
        int i3;
        a aVar = new a();
        final int i7 = a.g();
        final int i8 = 1;
        i9 += -2;
        final int i11 = 0;
        i4 = i11;
        while (i4 < i7) {
            i = i6;
            while (i6 < i2) {
                i3 = i4 + i6;
                if (i3 < i7) {
                } else {
                }
                i |= i3;
                i6++;
                if (a.f(i3)) {
                }
            }
            i5 = i & i10;
            if (i5 == i10) {
            } else {
            }
            if (i5 == 0) {
            } else {
            }
            aVar.c(i, i2);
            i4 += i2;
            aVar.c(i | 1, i2);
            i4--;
            aVar.c(i5, i2);
            i3 = i4 + i6;
            if (i3 < i7) {
            } else {
            }
            i |= i3;
            i6++;
            if (a.f(i3)) {
            }
        }
        return aVar;
    }

    private static int i(int i, boolean z2) {
        int obj2;
        obj2 = z2 ? 88 : 112;
        return obj2 *= i;
    }
}
