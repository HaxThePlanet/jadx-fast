package net.time4j.history;

import net.time4j.f1.c;

/* compiled from: JulianMath.java */
/* loaded from: classes3.dex */
class m {
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
                                if (i3 > m.b(i, i2)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    final String str4 = "DAY_OF_MONTH exceeds month length in given year: ";
                                    String str5 = m.j(i, i2, i3);
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

    public static int b(int i, int i2) {
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

    public static boolean c(int i) {
        boolean z = true;
        i = c.c(i, 4) == 0 ? 1 : 0;
        return (c.c(i, 4) == 0 ? 1 : 0);
    }

    public static boolean d(int i, int i2, int i3) {
        boolean z = false;
        int i4 = -999999999;
        int i5;
        int i6 = 1;
        i4 = -999999999;
        if (i < -999999999 || i > 999999999 || i2 < i6 || i2 > 12 || i3 < i6 || i3 > m.b(i, i2)) {
            int i7 = 0;
        }
        return z;
    }

    public static long h(int i, int i2, int i3) {
        long l;
        int i4;
        m.a(i, i2, i3);
        l = (long)i;
        if (i2 < 3) {
            long l2 = 1L;
            l = (long)i - l2;
            i4 = i2 + 12;
        }
        return (365L * l) + (c.b(l, 4)) + (long)(i4 + 1) * 153 / 5 - 123L + (long)i3 - 678883L;
    }

    public static long i(long j) {
        long l;
        int i2 = 29;
        int i3 = 2;
        long l11 = c.f(j, 678883L);
        int i5 = 1461;
        long l6 = c.b(l11, i5);
        int i14 = c.d(l11, i5);
        long l10 = 1L;
        i3 = 2;
        long l3 = 4L;
        int i = 1460;
        if (i14 == 1460) {
            l = (l6 + 1L) * 4L;
            i2 = 29;
        } else {
            i14 %= 365;
            l3 = (long)(i14 / 365);
            l = (l6 * 4L) + l3;
            i3 = 2 + (i15 + 31) * 5 / 153;
            i2 = (i15 - (i3 + 1) * 153 / 5) + 123;
            i = 12;
            if (i3 > 12) {
                l = (l6 * l3 + (long)i14 / 365) + 1L;
                i3 = i3 - 12;
            }
        }
        long l2 = -999999999L;
        if (l < l2) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Year out of range: ";
            r8 = str + l;
            throw new IllegalArgumentException(r8);
        } else {
            l2 = 999999999L;
            if (l <= l2) {
                return (long)i2 | (l << 32L) | (long)(i3 << 16);
            }
        }
    }

    private static String j(int i, int i2, int i3) {
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

    public static int e(long j) {
        return (int)(j & 255L);
    }

    public static int f(long j) {
        return (int)(j >> 16L) & 255L;
    }

    public static int g(long j) {
        return (int)(j >> 32L);
    }
}
