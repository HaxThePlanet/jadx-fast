package net.time4j.f1;

/* compiled from: GregorianMath.java */
/* loaded from: classes3.dex */
public final class b {
    public static void a(int i, int i2, int i3) {
        int i4 = -999999999;
        if (i < -999999999) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str = "YEAR out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            i4 = 999999999;
            if (i <= 999999999) {
                int i5 = 1;
                if (i2 < i5) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    String str3 = "MONTH out of range: ";
                    i2 = str3 + i2;
                    throw new IllegalArgumentException(i2);
                } else {
                    int i6 = 12;
                    if (i2 <= 12) {
                        if (i3 < i5) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String str2 = "DAY_OF_MONTH out of range: ";
                            i2 = str2 + i3;
                            throw new IllegalArgumentException(i2);
                        } else {
                            i5 = 31;
                            if (i3 <= 31) {
                                if (i3 > b.d(i, i2)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    final String str4 = "DAY_OF_MONTH exceeds month length in given year: ";
                                    String str5 = b.m(i, i2, i3);
                                    i = str4 + str5;
                                    throw new IllegalArgumentException(i);
                                }
                            }
                        }
                    }
                }
            }
        }
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
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Month out of range: ";
                i = str2 + i;
                throw new IllegalArgumentException(str2 + i);
        }
    }

    public static int c(int i, int i2, int i3) {
        int i5;
        int i6;
        int i7;
        int i4 = 1;
        if (i3 < 1) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str = "Day out of range: ";
            i2 = str + i3;
            throw new IllegalArgumentException(i2);
        } else {
            i4 = 31;
            if (i3 <= 31) {
                if (i3 > b.d(i, i2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Day exceeds month length: ";
                    String str3 = b.m(i, i2, i3);
                    i = str2 + str3;
                    throw new IllegalArgumentException(i);
                } else {
                    i5 = i % 100;
                    if (i5 < 0) {
                        i5 = i5 + 100;
                    }
                    int i12 = 2;
                    if (i2 <= i12) {
                        i5 = i5 - 1;
                        if (i5 - 1 < 0) {
                            i5 = 99;
                            i6 = (c.a(i, 100)) - 1;
                        }
                    }
                    int i15 = 4;
                    i7 = (i3 + b.b(i2)) + i5 + (i5 / i15) + (c.a(i6, i15)) - (i6 * i12) % 7;
                    if (i7 <= 0) {
                        i7 = i7 + 7;
                    }
                    return i7;
                }
            }
        }
    }

    public static int d(int i, int i2) {
        int i3 = 28;
        switch (i2) {
            case 1:
                return 31;
            case 2:
                i3 = 28;
                return i3;
            case 3:
                return 30;
            default:
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Invalid month: ";
                i2 = str2 + i2;
                throw new IllegalArgumentException(str2 + i2);
        }
        i3 = 29;
    }

    public static boolean e(int i) {
        boolean z = false;
        boolean z2 = false;
        int i4;
        int i5;
        int i6 = 0;
        final int i2 = 1;
        int i3 = 1900;
        if (i > 1900 && i < 2100) {
            if (i & 3 == 0) {
            }
            return z2;
        }
        i4 = i & 3;
        if (i & 3 == 0) {
            i4 = i % 100;
            if (i % 100 == 0) {
                i5 = i % 400;
                if (i % 400 == 0) {
                }
            }
        }
        return z;
    }

    public static boolean f(int i, int i2, int i3) {
        boolean z = false;
        int i4 = -999999999;
        int i5;
        int i6 = 1;
        i4 = -999999999;
        if (i < -999999999 || i > 999999999 || i2 < i6 || i2 > 12 || i3 < i6 || i3 > b.d(i, i2)) {
            int i7 = 0;
        }
        return z;
    }

    public static long j(int i, int i2, int i3) {
        long l;
        int i4;
        b.a(i, i2, i3);
        l = (long)i;
        if (i2 < 3) {
            long l2 = 1L;
            l = (long)i - l2;
            i4 = i2 + 12;
        }
        return (365L * l) + (c.b(l, 4)) - (c.b(l, 100)) + (c.b(l, 400)) + (long)(i4 + 1) * 153 / 5 - 123L + (long)i3 - 678881L;
    }

    public static long k(a aVar) {
        return b.j(aVar.m(), aVar.o(), aVar.q());
    }

    public static long l(long j) {
        int i = 2;
        long l;
        int i6 = 29;
        long l18 = c.f(j, 678881L);
        int i8 = 146097;
        long l6 = c.b(l18, i8);
        int i5 = c.d(l18, i8);
        i6 = 29;
        long l2 = 1L;
        i = 2;
        long l4 = 400L;
        int i2 = 146096;
        if (i5 == 146096) {
            l = (l6 + 1L) * 400L;
        } else {
            int i9 = 36524;
            int i12 = i5 / i9;
            i5 %= i9;
            int i10 = i15 / 1461;
            i5 = i15 % 1461;
            int i4 = 1460;
            if (i5 == 1460) {
                i3 = i12 * 100;
                i2 = (i10 + 1) * 4;
                l2 = (long)i2;
                l = (l6 * 400L) + (long)i3 + l2;
            } else {
                i5 %= 365;
                i3 = i12 * 100;
                i2 = i10 * 4;
                l4 = (long)(i5 / 365);
                l = (l6 * 400L) + (long)i3 + (long)i2 + l4;
                i = 2 + (i16 + 31) * 5 / 153;
                i6 = (i16 - (i + 1) * 153 / 5) + 123;
                i5 = 12;
                if (i > 12) {
                    l = (l6 * l4 + (long)i12 * 100 + (long)i10 * 4 + (long)i5 / 365) + 1L;
                    i = i - 12;
                }
            }
        }
        long l3 = -999999999L;
        if (l < l3) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Year out of range: ";
            r11 = str + l;
            throw new IllegalArgumentException(r11);
        } else {
            l3 = 999999999L;
            if (l <= l3) {
                return (long)i6 | (l << 32L) | (long)(i << 16);
            }
        }
    }

    static String m(int i, int i2, int i3) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        char c2 = '-';
        stringBuilder.append(c2);
        final char c = '0';
        final int i4 = 10;
        if (i2 < i4) {
            stringBuilder.append(c);
        }
        stringBuilder.append(i2);
        stringBuilder.append(c2);
        if (i3 < i4) {
            stringBuilder.append(c);
        }
        stringBuilder.append(i3);
        return stringBuilder.toString();
    }

    public static int g(long j) {
        return (int)(j & 255L);
    }

    public static int h(long j) {
        return (int)(j >> 16L) & 255L;
    }

    public static int i(long j) {
        return (int)(j >> 32L);
    }
}
