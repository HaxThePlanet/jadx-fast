package net.time4j.f1;

/* compiled from: MathUtils.java */
/* loaded from: classes3.dex */
public final class c {
    public static int a(int i, int i2) {
        if (i >= 0) {
            return i / i2;
        }
        return (i + 1) / i2 - 1;
    }

    public static long b(long j, int i) {
        if (j >= 0) {
            return j / (long)i;
        }
        long l2 = 1L;
        return (j + l2) / (long)i - l2;
    }

    public static int c(int i, int i2) {
        return i - (i2 * (c.a(i, i2)));
    }

    public static int d(long j, int i) {
        return (int)(j - (long)i * (c.b(j, i)));
    }

    public static int e(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        long l2 = (long)i + (long)i2;
        if (l2 < -2147483648) {
            StringBuilder stringBuilder = new StringBuilder(32);
            String str = "Integer overflow: (";
            i2 = 32 + str + i + 44 + i2 + 41;
            throw new ArithmeticException(i2);
        } else {
            if (l2 <= 0x7fffffff /* Unknown resource */) {
                return (int)l2;
            }
        }
    }

    public static long f(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        if (j2 > 0) {
            long l2 = Long.MAX_VALUE - j2;
            if (j <= l2) {
                return j + j2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        String str = "Long overflow: (";
        r3 = 32 + str + j + 44 + j2 + 41;
        throw new ArithmeticException(r3);
    }

    public static int g(long j) {
        if (j < -2147483648) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            j = str + j;
            throw new ArithmeticException(j);
        } else {
            if (j <= 0x7fffffff /* Unknown resource */) {
                return (int)j;
            }
        }
    }

    public static int h(int i, int i2) {
        if (i2 == 1) {
            return i;
        }
        long l2 = (long)i * (long)i2;
        if (l2 < -2147483648) {
            StringBuilder stringBuilder = new StringBuilder(32);
            String str = "Integer overflow: (";
            i2 = 32 + str + i + 44 + i2 + 41;
            throw new ArithmeticException(i2);
        } else {
            if (l2 <= 0x7fffffff /* Unknown resource */) {
                return (int)l2;
            }
        }
    }

    public static long i(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        long l = Long.MAX_VALUE;
        long l2 = Long.MIN_VALUE;
        if (j2 > 0) {
            l = l / j2;
            if (j > Long.MAX_VALUE) {
                StringBuilder stringBuilder = new StringBuilder(32);
                String str = "Long overflow: (";
                r8 = 32 + str + j + 44 + j2 + 41;
                throw new ArithmeticException(r8);
            }
        }
        return j * j2;
    }

    public static int j(int i) {
        if (i == -2147483648) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Not negatable: ";
            i = str + i;
            throw new ArithmeticException(i);
        } else {
            return -i;
        }
    }

    public static long k(long j) {
        if (j == -9223372036854775808L) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Not negatable: ";
            j = str + j;
            throw new ArithmeticException(j);
        } else {
            return -j;
        }
    }

    public static int l(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        long l2 = (long)i - (long)i2;
        if (l2 < -2147483648) {
            StringBuilder stringBuilder = new StringBuilder(32);
            String str = "Integer overflow: (";
            i2 = 32 + str + i + 44 + i2 + 41;
            throw new ArithmeticException(i2);
        } else {
            if (l2 <= 0x7fffffff /* Unknown resource */) {
                return (int)l2;
            }
        }
    }

    public static long m(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        if (j2 > 0) {
            long l2 = Long.MIN_VALUE + j2;
            if (j >= l2) {
                return j - j2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        String str = "Long overflow: (";
        r3 = 32 + str + j + 44 + j2 + 41;
        throw new ArithmeticException(r3);
    }
}
