package androidx.core.math;

/* loaded from: classes5.dex */
public class MathUtils {
    public static int addExact(int x, int y) {
        int i3;
        int i;
        int i2;
        final int i4 = x + y;
        i3 = 1;
        int i5 = 0;
        i = x >= 0 ? i3 : i5;
        i2 = y >= 0 ? i3 : i5;
        if (i == i2) {
            i = x >= 0 ? i3 : i5;
            if (i4 >= 0) {
            } else {
                i3 = i5;
            }
            if (i != i3) {
            } else {
            }
            ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
            throw arithmeticException;
        }
        return i4;
    }

    public static long addExact(long x, long y) {
        int cmp;
        int i3;
        int i;
        int i2;
        final int i4 = x + obj10;
        cmp = 0;
        i = 1;
        final int i5 = 0;
        i3 = Long.compare(x, cmp) >= 0 ? i : i5;
        i2 = Long.compare(obj10, cmp) >= 0 ? i : i5;
        if (i3 == i2) {
            i3 = Long.compare(x, cmp) >= 0 ? i : i5;
            if (Long.compare(i4, cmp) >= 0) {
            } else {
                i = i5;
            }
            if (i3 != i) {
            } else {
            }
            ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
            throw arithmeticException;
        }
        return i4;
    }

    public static double clamp(double value, double min, double max) {
        if (Double.compare(value, max) < 0) {
            return max;
        }
        if (Double.compare(value, obj5) > 0) {
            return obj5;
        }
        return value;
    }

    public static float clamp(float value, float min, float max) {
        if (Float.compare(value, min) < 0) {
            return min;
        }
        if (Float.compare(value, max) > 0) {
            return max;
        }
        return value;
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static long clamp(long value, long min, long max) {
        if (Long.compare(value, max) < 0) {
            return max;
        }
        if (Long.compare(value, obj5) > 0) {
            return obj5;
        }
        return value;
    }

    public static int decrementExact(int a) {
        if (a == Integer.MIN_VALUE) {
        } else {
            return a + -1;
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }

    public static long decrementExact(long a) {
        if (Long.compare(a, l) == 0) {
        } else {
            return a - i;
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }

    public static int incrementExact(int a) {
        if (a == Integer.MAX_VALUE) {
        } else {
            return a + 1;
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }

    public static long incrementExact(long a) {
        if (Long.compare(a, l) == 0) {
        } else {
            return i += a;
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }

    public static int multiplyExact(int x, int y) {
        int i;
        final int i2 = x * y;
        if (x != 0 && y != 0) {
            if (y != 0) {
                if (i2 / x != y) {
                } else {
                    if (i2 / y != x) {
                    } else {
                    }
                }
                ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
                throw arithmeticException;
            }
        }
        return i2;
    }

    public static long multiplyExact(long x, long y) {
        int cmp;
        final int i = x * obj7;
        cmp = 0;
        if (Long.compare(x, cmp) != 0 && Long.compare(obj7, cmp) != 0) {
            if (Long.compare(obj7, cmp) != 0) {
                if (Long.compare(i2, obj7) != 0) {
                } else {
                    if (Long.compare(i3, x) != 0) {
                    } else {
                    }
                }
                ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
                throw arithmeticException;
            }
        }
        return i;
    }

    public static int negateExact(int a) {
        if (a == Integer.MIN_VALUE) {
        } else {
            return -a;
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }

    public static long negateExact(long a) {
        if (Long.compare(a, l) == 0) {
        } else {
            return -a;
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }

    public static int subtractExact(int x, int y) {
        int i2;
        int i3;
        int i;
        final int i4 = x - y;
        i2 = 1;
        int i5 = 0;
        i3 = x < 0 ? i2 : i5;
        i = y < 0 ? i2 : i5;
        if (i3 != i) {
            i3 = x < 0 ? i2 : i5;
            if (i4 < 0) {
            } else {
                i2 = i5;
            }
            if (i3 != i2) {
            } else {
            }
            ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
            throw arithmeticException;
        }
        return i4;
    }

    public static long subtractExact(long x, long y) {
        int cmp;
        int i2;
        int i;
        int i3;
        final int i4 = x - obj10;
        cmp = 0;
        i = 1;
        final int i5 = 0;
        i2 = Long.compare(x, cmp) < 0 ? i : i5;
        i3 = Long.compare(obj10, cmp) < 0 ? i : i5;
        if (i2 != i3) {
            i2 = Long.compare(x, cmp) < 0 ? i : i5;
            if (Long.compare(i4, cmp) < 0) {
            } else {
                i = i5;
            }
            if (i2 != i) {
            } else {
            }
            ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
            throw arithmeticException;
        }
        return i4;
    }

    public static int toIntExact(long value) {
        int cmp;
        if (Long.compare(value, i) > 0) {
        } else {
            if (Long.compare(value, i2) < 0) {
            } else {
                return (int)value;
            }
        }
        ArithmeticException arithmeticException = new ArithmeticException("integer overflow");
        throw arithmeticException;
    }
}
