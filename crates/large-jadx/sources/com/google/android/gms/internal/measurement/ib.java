package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class ib {
    static void a(byte b, byte b2, byte b3, byte b4, char[] c5Arr5, int i6) {
        boolean z;
        int i;
        if (ib.e(b2)) {
        } else {
            if (i3 >>= 30 != 0) {
            } else {
                if (ib.e(b3)) {
                } else {
                    if (ib.e(b4)) {
                    } else {
                        obj2 |= obj3;
                        c5Arr5[i6] = (char)obj3;
                        c5Arr5[i6++] = (char)obj2;
                    }
                }
            }
        }
        throw zzkh.c();
    }

    static void b(byte b, byte b2, char[] c3Arr3, int i4) {
        int i;
        if (b < -62) {
        } else {
            if (ib.e(b2)) {
            } else {
                c3Arr3[i4] = (char)obj1;
            }
        }
        throw zzkh.c();
    }

    static void c(byte b, byte b2, byte b3, char[] c4Arr4, int i5) {
        boolean z;
        int i;
        int obj2;
        if (ib.e(b2)) {
        } else {
            z = -96;
            i = -32;
            if (b == i) {
                if (b2 < z) {
                } else {
                    obj2 = i;
                    i = -19;
                    if (obj2 == i) {
                        if (b2 >= z) {
                        } else {
                            obj2 = i;
                            if (ib.e(b3)) {
                            } else {
                                c4Arr4[i5] = (char)obj2;
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        throw zzkh.c();
    }

    static boolean d(byte b) {
        if (b >= 0) {
            return 1;
        }
        return 0;
    }

    private static boolean e(byte b) {
        if (b > -65) {
            return 1;
        }
        return 0;
    }
}
