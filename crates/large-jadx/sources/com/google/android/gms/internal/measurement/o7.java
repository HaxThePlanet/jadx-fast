package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
final class o7 {
    static int a(byte[] bArr, int i2, com.google.android.gms.internal.measurement.n7 n73) {
        int obj3 = o7.j(bArr, i2, n73);
        final int i = n73.a;
        if (i < 0) {
        } else {
            if (i > length -= obj3) {
            } else {
                if (i == 0) {
                    n73.c = x7.a;
                    return obj3;
                }
                n73.c = x7.t(bArr, obj3, i);
                return obj3 += i;
            }
            throw zzkh.f();
        }
        throw zzkh.d();
    }

    static int b(byte[] bArr, int i2) {
        return obj2 |= i4;
    }

    static int c(com.google.android.gms.internal.measurement.ja ja, byte[] b2Arr2, int i3, int i4, int i5, com.google.android.gms.internal.measurement.n7 n76) {
        final Object obj2 = (ba)ja.a();
        ja.c(obj2);
        n76.c = obj2;
        return ja.D(obj2, b2Arr2, i3, i4, i5, n76);
    }

    static int d(com.google.android.gms.internal.measurement.ja ja, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.n7 n75) {
        int i;
        byte obj8;
        int obj9;
        obj8 = b2Arr2[i3];
        if (obj8 < 0) {
            i = o7.k(obj8, b2Arr2, i3 + 1, n75);
            obj8 = n75.a;
        }
        final int i2 = i;
        if (obj8 < 0) {
        } else {
            if (obj8 > i4 -= i2) {
            } else {
                obj9 = ja.a();
                obj8 += i2;
                ja.g(obj9, b2Arr2, i2, obj8, n75);
                ja.c(obj9);
                n75.c = obj9;
                return obj8;
            }
        }
        throw zzkh.f();
    }

    static int e(com.google.android.gms.internal.measurement.ja<?> ja, int i2, byte[] b3Arr3, int i4, int i5, com.google.android.gms.internal.measurement.c9<?> c96, com.google.android.gms.internal.measurement.n7 n77) {
        Object obj;
        int i;
        int obj5;
        obj5 = o7.d(ja, b3Arr3, i4, i5, n77);
        c96.add(n77.c);
        while (obj5 < i5) {
            if (i2 != n77.a) {
                break;
            } else {
            }
            obj5 = o7.d(ja, b3Arr3, o7.j(b3Arr3, obj5, n77), i5, n77);
            c96.add(n77.c);
        }
        return obj5;
    }

    static int f(byte[] bArr, int i2, com.google.android.gms.internal.measurement.c9<?> c93, com.google.android.gms.internal.measurement.n7 n74) {
        int i;
        int obj3;
        i3 += obj3;
        while (obj3 < i4) {
            obj3 = o7.j(bArr, obj3, n74);
            (x8)c93.h(n74.a);
        }
        if (obj3 != i4) {
        } else {
            return obj3;
        }
        throw zzkh.f();
    }

    static int g(byte[] bArr, int i2, com.google.android.gms.internal.measurement.n7 n73) {
        int obj4 = o7.j(bArr, i2, n73);
        final int i = n73.a;
        if (i < 0) {
        } else {
            if (i == 0) {
                n73.c = "";
                return obj4;
            }
            String string = new String(bArr, obj4, i, d9.a);
            n73.c = string;
            return obj4 += i;
        }
        throw zzkh.d();
    }

    static int h(byte[] bArr, int i2, com.google.android.gms.internal.measurement.n7 n73) {
        int obj2 = o7.j(bArr, i2, n73);
        final int i = n73.a;
        if (i < 0) {
        } else {
            if (i == 0) {
                n73.c = "";
                return obj2;
            }
            n73.c = mb.d(bArr, obj2, i);
            return obj2 += i;
        }
        throw zzkh.d();
    }

    static int i(int i, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.ya ya5, com.google.android.gms.internal.measurement.n7 n76) {
        int i7;
        byte[] bArr;
        int i6;
        int i2;
        com.google.android.gms.internal.measurement.ya yaVar;
        com.google.android.gms.internal.measurement.n7 n7Var;
        int i5;
        com.google.android.gms.internal.measurement.x7 obj10;
        int obj11;
        if (i >>> 3 == 0) {
        } else {
            int i9 = i & 7;
            int i12 = 1;
            if (i9 != 0 && i9 != i12 && i9 != 2 && i9 != 3) {
                i12 = 1;
                if (i9 != i12) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 != 5) {
                            } else {
                                ya5.h(i, Integer.valueOf(o7.b(b2Arr2, i3)));
                                return i3 += 4;
                            }
                            throw zzkh.b();
                        }
                        i10 |= 4;
                        final com.google.android.gms.internal.measurement.ya yaVar2 = ya.e();
                        i7 = 0;
                        while (obj11 < i4) {
                            i6 = o7.j(b2Arr2, obj11, n76);
                            obj11 = n76.a;
                            if (obj11 == i11) {
                                break;
                            } else {
                            }
                            i7 = obj11;
                            obj11 = i5;
                        }
                        if (obj11 > i4) {
                        } else {
                            if (i7 != i11) {
                            } else {
                                ya5.h(i, yaVar2);
                                return obj11;
                            }
                        }
                        throw zzkh.e();
                    }
                    obj11 = o7.j(b2Arr2, i3, n76);
                    int obj12 = n76.a;
                    if (obj12 < 0) {
                    } else {
                        if (obj12 > obj14 -= obj11) {
                        } else {
                            if (obj12 == null) {
                                ya5.h(i, x7.a);
                            } else {
                                ya5.h(i, x7.t(b2Arr2, obj11, obj12));
                            }
                            return obj11 += obj12;
                        }
                        throw zzkh.f();
                    }
                    throw zzkh.d();
                }
                ya5.h(i, Long.valueOf(o7.n(b2Arr2, i3)));
                return i3 += 8;
            }
            ya5.h(i, Long.valueOf(n76.b));
            return o7.m(b2Arr2, i3, n76);
        }
        throw zzkh.b();
    }

    static int j(byte[] bArr, int i2, com.google.android.gms.internal.measurement.n7 n73) {
        final int i = i2 + 1;
        final byte obj2 = bArr[i2];
        if (obj2 >= 0) {
            n73.a = obj2;
            return i;
        }
        return o7.k(obj2, bArr, i, n73);
    }

    static int k(int i, byte[] b2Arr2, int i3, com.google.android.gms.internal.measurement.n7 n74) {
        int i2;
        int obj3;
        i &= 127;
        int i4 = i3 + 1;
        obj3 = b2Arr2[i3];
        if (obj3 >= 0) {
            n74.a = obj1 |= obj2;
            return i4;
        }
        obj1 |= obj3;
        obj3 = i4 + 1;
        byte b = b2Arr2[i4];
        if (b >= 0) {
            n74.a = obj1 |= obj2;
            return obj3;
        }
        obj1 |= i6;
        int i7 = obj3 + 1;
        obj3 = b2Arr2[obj3];
        if (obj3 >= 0) {
            n74.a = obj1 |= obj2;
            return i7;
        }
        obj1 |= obj3;
        byte b2 = b2Arr2[i7];
        if (b2 >= 0) {
            n74.a = obj1 |= obj2;
            return i7 + 1;
        }
        i2 = obj3 + 1;
        while (b2Arr2[obj3] < 0) {
            obj3 = i2;
            i2 = obj3 + 1;
        }
        n74.a = obj1 |= i2;
        return i2;
    }

    static int l(int i, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.c9<?> c95, com.google.android.gms.internal.measurement.n7 n76) {
        int i2;
        int i5;
        int obj4;
        obj4 = o7.j(b2Arr2, i3, n76);
        (x8)c95.h(n76.a);
        while (obj4 < i4) {
            if (i != n76.a) {
                break;
            } else {
            }
            obj4 = o7.j(b2Arr2, o7.j(b2Arr2, obj4, n76), n76);
            c95.h(n76.a);
        }
        return obj4;
    }

    static int m(byte[] bArr, int i2, com.google.android.gms.internal.measurement.n7 n73) {
        byte b;
        int i4;
        int i3;
        int i5;
        int i6;
        int i;
        int obj10;
        int i7 = i2 + 1;
        long l = (long)obj10;
        if (Long.compare(l, i10) >= 0) {
            n73.b = l;
            return i7;
        }
        obj10 = i7 + 1;
        final int i14 = 7;
        i9 |= i13;
        i3 = i14;
        while (b < 0) {
            obj10 = bArr[obj10];
            i4 |= i6;
            b = obj10;
            obj10 = i;
        }
        n73.b = i4;
        return obj10;
    }

    static long n(byte[] bArr, int i2) {
        int i9 = 255;
        return obj7 |= i8;
    }
}
