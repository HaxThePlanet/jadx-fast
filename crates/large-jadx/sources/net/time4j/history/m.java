package net.time4j.history;

import net.time4j.f1.c;

/* loaded from: classes3.dex */
class m {
    public static void a(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i < -999999999) {
        } else {
            if (i > 999999999) {
            } else {
                i5 = 1;
                if (i2 < i5) {
                } else {
                    if (i2 > 12) {
                    } else {
                        if (i3 < i5) {
                        } else {
                            if (i3 > 31) {
                            } else {
                                if (i3 > m.b(i, i2)) {
                                } else {
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("DAY_OF_MONTH exceeds month length in given year: ");
                                stringBuilder.append(m.j(i, i2, i3));
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

    public static int b(int i, int i2) {
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

    public static boolean c(int i) {
        int obj1;
        obj1 = c.c(i, 4) == 0 ? 1 : 0;
        return obj1;
    }

    public static boolean d(int i, int i2, int i3) {
        int i4;
        int i5;
        int obj2;
        i4 = 1;
        if (i >= -999999999 && i <= 999999999 && i2 >= i4 && i2 <= 12 && i3 >= i4 && i3 <= m.b(i, i2)) {
            if (i <= 999999999) {
                if (i2 >= i4) {
                    if (i2 <= 12) {
                        if (i3 >= i4) {
                            if (i3 <= m.b(i, i2)) {
                            } else {
                                i4 = 0;
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
        return i4;
    }

    public static int e(long l) {
        return (int)obj2;
    }

    public static int f(long l) {
        return (int)obj2;
    }

    public static int g(long l) {
        return (int)obj1;
    }

    public static long h(int i, int i2, int i3) {
        long l;
        int i4;
        int obj5;
        m.a(i, i2, i3);
        if (i2 < 3) {
            l -= i4;
            i2 += 12;
        }
        return i10 -= obj4;
    }

    public static long i(long l) {
        int i;
        int cmp;
        int i2;
        int i4;
        long i3;
        int obj7;
        int obj8;
        obj7 = c.f(l, obj8);
        int i6 = 1461;
        long l2 = c.b(obj7, obj8);
        obj7 = c.d(obj7, obj8);
        int i19 = 1;
        i3 = 4;
        if (obj7 == 1460) {
            i18 *= i3;
            obj7 = 29;
        } else {
            obj7 %= 365;
            obj8 += i10;
            obj7 += 123;
            if (obj8 > 12) {
                i2 += i19;
                obj8 += -12;
            }
        }
        if (Long.compare(i2, i4) < 0) {
        } else {
            if (Long.compare(i2, i4) > 0) {
            } else {
                return obj7 |= i16;
            }
        }
        obj8 = new StringBuilder();
        obj8.append("Year out of range: ");
        obj8.append(i2);
        obj7 = new IllegalArgumentException(obj8.toString());
        throw obj7;
    }

    private static String j(int i, int i2, int i3) {
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
