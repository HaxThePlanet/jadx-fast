package d.h.k;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class k {

    private static final Object a;
    private static char[] b;
    static {
        Object object = new Object();
        k.a = object;
        k.b = new char[24];
    }

    private static int a(int i, int i2, boolean z3, int i4) {
        int i3 = 3;
        if (i <= 99) {
            if (z3 && i4 >= i3) {
                if (i4 >= i3) {
                } else {
                    int i7 = 2;
                    if (i <= 9) {
                        if (z3 && i4 >= i7) {
                            if (i4 >= i7) {
                            } else {
                                if (!z3 && i > 0) {
                                    if (i > 0) {
                                    }
                                    return 0;
                                }
                            }
                        } else {
                        }
                        return i2++;
                    }
                }
            } else {
            }
            return i2 += i7;
        }
        return i2 += i3;
    }

    public static void b(long l, long l2, PrintWriter printWriter3) {
        if (Long.compare(l, i) == 0) {
            obj6.print("--");
        }
        k.d(l -= printWriter3, l2, obj6);
    }

    public static void c(long l, PrintWriter printWriter2) {
        k.d(l, printWriter2, obj3);
    }

    public static void d(long l, PrintWriter printWriter2, int i3) {
        final Object obj = k.a;
        String obj3 = new String(k.b, 0, k.e(l, printWriter2));
        i3.print(obj3);
        return;
        synchronized (obj) {
            obj = k.a;
            obj3 = new String(k.b, 0, k.e(l, printWriter2));
            i3.print(obj3);
        }
    }

    private static int e(long l, int i2) {
        int i7;
        int i21;
        int i23;
        int i12;
        int i;
        int i13;
        int cArr;
        int i20;
        int i22;
        int i16;
        int i24;
        int i3;
        int i9;
        int i15;
        int i5;
        int i11;
        int i8;
        int i4;
        int i25;
        int i6;
        int i19;
        int i10;
        int i18;
        int i17;
        int i14;
        i7 = l;
        int i34 = obj19;
        if (cArr2.length < i34) {
            k.b = new char[i34];
        }
        char[] cArr3 = k.b;
        int cmp = Long.compare(i7, i35);
        int i36 = 32;
        final int i67 = 1;
        int i68 = 0;
        if (cmp == 0) {
            while (i34 + -1 > 0) {
                cArr3[i68] = i36;
            }
            cArr3[i68] = 48;
            return i67;
        }
        if (cmp > 0) {
            i20 = 43;
        } else {
            i20 = 45;
            i7 = -i7;
        }
        int i42 = 1000;
        final int i70 = (int)i3;
        i21 = (int)floor;
        i12 = 86400;
        if (i21 > i12) {
            i21 -= i12;
        } else {
            i22 = i68;
        }
        if (i21 > 3600) {
            i21 -= i16;
        } else {
            i = i68;
        }
        if (i21 > 60) {
            i24 = i21 / 60;
            i14 = i29;
            i23 = i24;
        } else {
            i14 = i21;
            i23 = i68;
        }
        final int i71 = 3;
        final int i72 = 2;
        if (i34 != 0) {
            int i54 = k.a(i22, i67, i68, i68);
            i8 = i54 > 0 ? i67 : i68;
            i54 += i60;
            i4 = i55 > 0 ? i67 : i68;
            i55 += i61;
            i25 = i56 > 0 ? i67 : i68;
            i56 += i62;
            i6 = i57 > 0 ? i71 : i68;
            i57 += i64;
            i9 = i68;
            while (i24 < i34) {
                cArr3[i9] = i36;
                i9++;
                i24++;
            }
        } else {
            i9 = i68;
        }
        cArr3[i9] = i20;
        int i65 = i9 + 1;
        i13 = i34 != 0 ? i67 : i68;
        int i69 = i65;
        int i50 = k.f(cArr3, i22, 'd', i65, false, 0);
        i15 = i50 != i69 ? i67 : 0;
        i19 = i13 != 0 ? i72 : 0;
        int i51 = k.f(cArr3, i, 'h', i50, i15, i19);
        i5 = i51 != i69 ? i67 : 0;
        i10 = i13 != 0 ? i72 : 0;
        int i52 = k.f(cArr3, i23, 'm', i51, i5, i10);
        i11 = i52 != i69 ? i67 : 0;
        i18 = i13 != 0 ? i72 : 0;
        int i53 = k.f(cArr3, i14, 's', i52, i11, i18);
        if (i13 != 0 && i53 != i69) {
            i17 = i53 != i69 ? i71 : 0;
        } else {
        }
        int i30 = k.f(cArr3, i70, 'm', i53, true, i17);
        cArr3[i30] = 115;
        return i30 += i67;
    }

    private static int f(char[] cArr, int i2, char c3, int i4, boolean z5, int i6) {
        int i;
        int i5;
        int i3;
        int obj3;
        int obj5;
        int obj6;
        if (z5 == 0) {
            if (i2 > 0) {
                if (z5 != 0) {
                    if (i6 < 3) {
                        if (i2 > 99) {
                            int i7 = i2 / 100;
                            cArr[i4] = (char)i8;
                            i5 = i4 + 1;
                            i2 -= i;
                        } else {
                            i5 = i4;
                        }
                    } else {
                    }
                } else {
                }
                if (z5 != 0) {
                    if (i6 < 2 && obj3 <= 9) {
                        if (obj3 <= 9) {
                            if (i4 != i5) {
                                obj5 = obj3 / 10;
                                cArr[i5] = (char)obj6;
                                i5++;
                                obj3 -= obj5;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                cArr[i5] = (char)obj3;
                i5++;
                cArr[i3] = c3;
                obj5 = i3 + 1;
            }
        } else {
        }
        return obj5;
    }
}
