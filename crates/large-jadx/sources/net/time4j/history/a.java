package net.time4j.history;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class a {

    private static final int[] c;
    private static final net.time4j.history.h d;
    private static final net.time4j.history.h e;
    public static final net.time4j.history.a f;
    private final int[] a;
    private final net.time4j.history.b b;

    class a implements net.time4j.history.b {

        final net.time4j.history.a a;
        a(net.time4j.history.a a) {
            this.a = a;
            super();
        }

        private int a(int i, int i2) {
            int obj3;
            switch (i2) {
                case 1:
                    return 31;
                case 2:
                    obj3 = 28;
                    return obj3;
                case 3:
                    return 30;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid month: ");
                    stringBuilder.append(i2);
                    obj3 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj3;
            }
            obj3 = 29;
        }

        private int b(net.time4j.history.h h) {
            return h.e().annoDomini(h.i());
        }

        private boolean c(int i) {
            int obj2;
            obj2 = Arrays.binarySearch(a.c(this.a), i) >= 0 ? 1 : 0;
            return obj2;
        }

        @Override // net.time4j.history.b
        public net.time4j.history.h fromMJD(long l) {
            int i;
            int i2;
            int cmp;
            int i3;
            int i4;
            net.time4j.history.j jVar;
            int cmp2;
            if (Long.compare(l, i) >= 0) {
                return c.JULIAN.fromMJD(l);
            }
            i2 = 7;
            while (i2 >= -44) {
                if (c(i2)) {
                } else {
                }
                i3 = 365;
                if (Long.compare(i, l) <= 0) {
                } else {
                }
                i2--;
                cmp = 1;
                while (cmp <= 12) {
                    l2 += i;
                    cmp++;
                    i = i4;
                }
                l2 += i;
                cmp++;
                i = i4;
                i3 = 366;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not valid before 45 BC: ");
            stringBuilder.append(l);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // net.time4j.history.b
        public int getMaximumDayOfMonth(net.time4j.history.h h) {
            if (h.a(a.a()) >= 0) {
                return c.JULIAN.getMaximumDayOfMonth(h);
            }
            if (h.a(a.b()) < 0) {
            } else {
                return a(b(h), h.f());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not valid before 45 BC: ");
            stringBuilder.append(h);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // net.time4j.history.b
        public boolean isValid(net.time4j.history.h h) {
            int i;
            int i2;
            int i3;
            net.time4j.history.h obj4;
            i = 0;
            i2 = b(h);
            if (h != null && i2 >= -44 && i2 >= 8) {
                i2 = b(h);
                if (i2 >= -44) {
                    if (i2 >= 8) {
                        return c.JULIAN.isValid(h);
                    }
                    if (h.c() <= a(i2, h.f())) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        @Override // net.time4j.history.b
        public long toMJD(net.time4j.history.h h) {
            int i4;
            int i;
            int i3;
            int i2;
            if (h.a(a.a()) >= 0) {
                return c.JULIAN.toMJD(h);
            }
            if (h.a(a.b()) < 0) {
            } else {
                i4 = -676021;
                int i9 = b(h);
                i = 7;
                while (i >= i9) {
                    if (c(i)) {
                    } else {
                    }
                    i2 = 365;
                    i4 -= i2;
                    i--;
                    i2 = 366;
                }
                i3 = 1;
                while (i3 < h.f()) {
                    i4 += i2;
                    i3++;
                }
                return i7 -= i10;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not valid before 45 BC: ");
            stringBuilder.append(h);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }
    static {
        int[] iArr = new int[12];
        iArr = new int[]{42, 39, 36, 33, 30, 27, 24, 21, 18, 15, 12, 9};
        a.c = iArr;
        final int i4 = 1;
        a.d = h.k(j.AD, 8, i4, i4);
        a.e = h.k(j.BC, 45, i4, i4);
        a aVar = new a(iArr);
        a.f = aVar;
    }

    private a(int... iArr) {
        int i5;
        int i6;
        int i4;
        int i7;
        int i;
        int i2;
        int i3;
        super();
        int[] iArr2 = new int[iArr.length];
        int i8 = 0;
        i6 = i8;
        i3 = 1;
        for (int i7 : iArr) {
            iArr2[i6] = i3 -= i7;
            i3 = 1;
        }
        Arrays.sort(iArr2);
        this.a = iArr2;
        if (iArr2.length == 0) {
        } else {
            if (iArr2[i8] < -44) {
            } else {
                if (iArr2[length3 -= i3] >= 8) {
                } else {
                    i5 = iArr2[i8];
                    while (i3 < iArr.length) {
                        i5 = iArr2[i3];
                        i3++;
                    }
                    a.a obj6 = new a.a(this);
                    this.b = obj6;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Out of range: ");
            stringBuilder2.append(Arrays.toString(iArr));
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException2;
        }
        obj6 = new IllegalArgumentException("Missing leap years.");
        throw obj6;
    }

    static net.time4j.history.h a() {
        return a.d;
    }

    static net.time4j.history.h b() {
        return a.e;
    }

    static int[] c(net.time4j.history.a a) {
        return a.a;
    }

    public static net.time4j.history.a f(int... iArr) {
        if (Arrays.equals(iArr, a.c)) {
            return a.f;
        }
        a aVar = new a(iArr);
        return aVar;
    }

    net.time4j.history.b d() {
        return this.b;
    }

    int[] e() {
        return this.a;
    }

    public boolean equals(Object object) {
        int i;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof a) {
            if (this.a == object.a) {
            } else {
                i = i2;
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        int i;
        int i2;
        int length;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        for (int i2 : obj2) {
            if (i > 0) {
            }
            i2 = i3 - 1;
            if (i2 > 0) {
            } else {
            }
            stringBuilder.append("AD ");
            stringBuilder.append(i2);
            stringBuilder.append("BC ");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
