package net.time4j.f1;

/* loaded from: classes3.dex */
public final class c {
    public static int a(int i, int i2) {
        if (i >= 0) {
            return i /= i2;
        }
        return obj0--;
    }

    public static long b(long l, int i2) {
        if (Long.compare(l, i) >= 0) {
            return l /= l2;
        }
        int i3 = 1;
        return obj4 -= i3;
    }

    public static int c(int i, int i2) {
        return i -= obj2;
    }

    public static int d(long l, int i2) {
        return (int)obj4;
    }

    public static int e(int i, int i2) {
        int cmp;
        if (i2 == 0) {
            return i;
        }
        l += l2;
        if (Long.compare(i3, i5) < 0) {
        } else {
            if (Long.compare(i3, i6) > 0) {
            } else {
                return (int)i3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Integer overflow: (");
        stringBuilder.append(i);
        stringBuilder.append(',');
        stringBuilder.append(i2);
        stringBuilder.append(')');
        ArithmeticException obj4 = new ArithmeticException(stringBuilder.toString());
        throw obj4;
    }

    public static long f(long l, long l2) {
        int cmp;
        int cmp2 = Long.compare(obj4, i);
        if (cmp2 == 0) {
            return l;
        }
        if (cmp2 > 0) {
            if (Long.compare(l, i2) > 0) {
            } else {
                return l += obj4;
            }
        } else {
            if (Long.compare(l, i3) < 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Long overflow: (");
        stringBuilder.append(l);
        stringBuilder.append(',');
        stringBuilder.append(obj4);
        stringBuilder.append(')');
        ArithmeticException obj2 = new ArithmeticException(stringBuilder.toString());
        throw obj2;
    }

    public static int g(long l) {
        int cmp;
        if (Long.compare(l, i) < 0) {
        } else {
            if (Long.compare(l, i2) > 0) {
            } else {
                return (int)l;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(l);
        ArithmeticException arithmeticException = new ArithmeticException(stringBuilder.toString());
        throw arithmeticException;
    }

    public static int h(int i, int i2) {
        int cmp;
        if (i2 == 1) {
            return i;
        }
        l *= l2;
        if (Long.compare(i4, i6) < 0) {
        } else {
            if (Long.compare(i4, i7) > 0) {
            } else {
                return (int)i4;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Integer overflow: (");
        stringBuilder.append(i);
        stringBuilder.append(',');
        stringBuilder.append(i2);
        stringBuilder.append(')');
        ArithmeticException obj4 = new ArithmeticException(stringBuilder.toString());
        throw obj4;
    }

    public static long i(long l, long l2) {
        int cmp;
        int l4;
        int l3;
        int i;
        if (Long.compare(obj9, i2) == 0) {
            return l;
        }
        l4 = Long.MAX_VALUE;
        l3 = Long.MIN_VALUE;
        if (Long.compare(obj9, i3) > 0) {
            if (Long.compare(l, l4) > 0) {
            } else {
                if (Long.compare(l, l3) < 0) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Long overflow: (");
            stringBuilder.append(l);
            stringBuilder.append(',');
            stringBuilder.append(obj9);
            stringBuilder.append(')');
            ArithmeticException obj7 = new ArithmeticException(stringBuilder.toString());
            throw obj7;
        } else {
            cmp = Long.compare(obj9, i);
            if (cmp < 0) {
                if (Long.compare(l, l3) > 0) {
                } else {
                    if (Long.compare(l, l4) < 0) {
                    } else {
                    }
                }
            } else {
                if (cmp == 0) {
                    if (Long.compare(l, l3) == 0) {
                    } else {
                    }
                }
            }
        }
        return l *= obj9;
    }

    public static int j(int i) {
        if (i == Integer.MIN_VALUE) {
        } else {
            return -i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not negatable: ");
        stringBuilder.append(i);
        ArithmeticException arithmeticException = new ArithmeticException(stringBuilder.toString());
        throw arithmeticException;
    }

    public static long k(long l) {
        if (Long.compare(l, l2) == 0) {
        } else {
            return -l;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not negatable: ");
        stringBuilder.append(l);
        ArithmeticException arithmeticException = new ArithmeticException(stringBuilder.toString());
        throw arithmeticException;
    }

    public static int l(int i, int i2) {
        int cmp;
        if (i2 == 0) {
            return i;
        }
        l -= l2;
        if (Long.compare(i3, i5) < 0) {
        } else {
            if (Long.compare(i3, i6) > 0) {
            } else {
                return (int)i3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Integer overflow: (");
        stringBuilder.append(i);
        stringBuilder.append(',');
        stringBuilder.append(i2);
        stringBuilder.append(')');
        ArithmeticException obj4 = new ArithmeticException(stringBuilder.toString());
        throw obj4;
    }

    public static long m(long l, long l2) {
        int cmp;
        int cmp2 = Long.compare(obj4, i);
        if (cmp2 == 0) {
            return l;
        }
        if (cmp2 > 0) {
            if (Long.compare(l, i2) < 0) {
            } else {
                return l -= obj4;
            }
        } else {
            if (Long.compare(l, i3) > 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Long overflow: (");
        stringBuilder.append(l);
        stringBuilder.append(',');
        stringBuilder.append(obj4);
        stringBuilder.append(')');
        ArithmeticException obj2 = new ArithmeticException(stringBuilder.toString());
        throw obj2;
    }
}
