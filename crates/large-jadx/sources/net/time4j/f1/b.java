package net.time4j.f1;

/* loaded from: classes3.dex */
public final class b {
    public static void a(int i, int i2, int i3) {
        int i4;
        int i6;
        int i5;
        if (i < -999999999) {
        } else {
            if (i > 999999999) {
            } else {
                i6 = 1;
                if (i2 < i6) {
                } else {
                    if (i2 > 12) {
                    } else {
                        if (i3 < i6) {
                        } else {
                            if (i3 > 31) {
                            } else {
                                if (i3 > b.d(i, i2)) {
                                } else {
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("DAY_OF_MONTH exceeds month length in given year: ");
                                stringBuilder.append(b.m(i, i2, i3));
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                                throw illegalArgumentException;
                            }
                        }
                        StringBuilder obj4 = new StringBuilder();
                        obj4.append("DAY_OF_MONTH out of range: ");
                        obj4.append(i3);
                        IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
                        throw obj3;
                    }
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("MONTH out of range: ");
                obj5.append(i2);
                obj3 = new IllegalArgumentException(obj5.toString());
                throw obj3;
            }
        }
        obj5 = new StringBuilder();
        obj5.append("YEAR out of range: ");
        obj5.append(i);
        obj4 = new IllegalArgumentException(obj5.toString());
        throw obj4;
    }

    private static int b(int i) {
        switch (i) {
            case 1:
                return 28;
            case 2:
                return 31;
            case 3:
                return 2;
            case 4:
                return 5;
            case 5:
                return 7;
            case 6:
                return 10;
            case 7:
                return 12;
            case 8:
                return 15;
            case 9:
                return 18;
            case 10:
                return 20;
            case 11:
                return 23;
            case 12:
                return 25;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Month out of range: ");
                stringBuilder.append(i);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
        }
    }

    public static int c(int i, int i2, int i3) {
        int i4;
        int i5;
        int obj4;
        int obj6;
        if (i3 < 1) {
        } else {
            if (i3 > 31) {
            } else {
                if (i3 > b.d(i, i2)) {
                } else {
                    i5 = i % 100;
                    if (i5 < 0) {
                        i5 += 100;
                    }
                    int i10 = 2;
                    if (i2 <= i10 && i5-- < 0) {
                        if (i5-- < 0) {
                            i5 = 99;
                            obj4--;
                        }
                    }
                    int obj5 = 4;
                    obj6 %= 7;
                    if (obj6 <= 0) {
                        obj6 += 7;
                    }
                    return obj6;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Day exceeds month length: ");
                stringBuilder.append(b.m(i, i2, i3));
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
        }
        obj5 = new StringBuilder();
        obj5.append("Day out of range: ");
        obj5.append(i3);
        obj4 = new IllegalArgumentException(obj5.toString());
        throw obj4;
    }

    public static int d(int i, int i2) {
        int obj2;
        switch (i2) {
            case 1:
                return 31;
            case 2:
                obj2 = 28;
                return obj2;
            case 3:
                return 30;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid month: ");
                stringBuilder.append(i2);
                obj2 = new IllegalArgumentException(stringBuilder.toString());
                throw obj2;
        }
        obj2 = 29;
    }

    public static boolean e(int i) {
        int i2;
        int i3;
        int i4;
        int obj3;
        i2 = 0;
        final int i5 = 1;
        if (i > 1900 && i < 2100 && i &= 3 == 0) {
            if (i < 2100) {
                if (i &= 3 == 0) {
                    i2 = i5;
                }
                return i2;
            }
        }
        if (i & 3 == 0) {
            if (i % 100 == 0) {
                if (i %= 400 == 0) {
                    i2 = i5;
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    public static boolean f(int i, int i2, int i3) {
        int i5;
        int i4;
        int obj2;
        i5 = 1;
        if (i >= -999999999 && i <= 999999999 && i2 >= i5 && i2 <= 12 && i3 >= i5 && i3 <= b.d(i, i2)) {
            if (i <= 999999999) {
                if (i2 >= i5) {
                    if (i2 <= 12) {
                        if (i3 >= i5) {
                            if (i3 <= b.d(i, i2)) {
                            } else {
                                i5 = 0;
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
        return i5;
    }

    public static int g(long l) {
        return (int)obj2;
    }

    public static int h(long l) {
        return (int)obj2;
    }

    public static int i(long l) {
        return (int)obj1;
    }

    public static long j(int i, int i2, int i3) {
        long l;
        int i4;
        int obj7;
        b.a(i, i2, i3);
        if (i2 < 3) {
            l -= i4;
            i2 += 12;
        }
        return i12 -= obj6;
    }

    public static long k(net.time4j.f1.a a) {
        return b.j(a.m(), a.o(), a.q());
    }

    public static long l(long l) {
        int i8;
        int i5;
        long i;
        int i4;
        int i2;
        int i7;
        int i6;
        int i3;
        int obj10;
        int obj11;
        obj10 = c.f(l, obj11);
        int i10 = 146097;
        long l2 = c.b(obj10, obj11);
        obj10 = c.d(obj10, obj11);
        obj11 = 29;
        i = 1;
        i2 = 400;
        if (obj10 == 146096) {
            i18 *= i2;
        } else {
            int i19 = 36524;
            int i22 = obj10 / i19;
            obj10 %= i19;
            int i20 = obj10 / 1461;
            obj10 %= 1461;
            if (obj10 == 1460) {
                i14 += i;
            } else {
                obj10 %= 365;
                i8 += obj11;
                obj11 = obj10 + 123;
                if (i8 > 12) {
                    i5 += i;
                    i8 += -12;
                }
            }
        }
        if (Long.compare(i5, i4) < 0) {
        } else {
            if (Long.compare(i5, i4) > 0) {
            } else {
                return obj10 |= i11;
            }
        }
        obj11 = new StringBuilder();
        obj11.append("Year out of range: ");
        obj11.append(i5);
        obj10 = new IllegalArgumentException(obj11.toString());
        throw obj10;
    }

    static String m(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        int obj3 = 45;
        stringBuilder.append(obj3);
        final int i4 = 48;
        final int i5 = 10;
        if (i2 < i5) {
            stringBuilder.append(i4);
        }
        stringBuilder.append(i2);
        stringBuilder.append(obj3);
        if (i3 < i5) {
            stringBuilder.append(i4);
        }
        stringBuilder.append(i3);
        return stringBuilder.toString();
    }
}
