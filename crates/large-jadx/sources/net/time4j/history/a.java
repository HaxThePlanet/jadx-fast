package net.time4j.history;

import java.util.Arrays;

/* compiled from: AncientJulianLeapYears.java */
/* loaded from: classes3.dex */
public final class a {

    private static final int[] c;
    private static final h d;
    private static final h e;
    public static final a f = new a();
    private final int[] a;
    private final b b = new a$a();

    class a implements b {

        final /* synthetic */ a a;
        a() {
            this.a = aVar;
            super();
        }

        private int a(int i, int i2) {
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

        private int b(h hVar) {
            return hVar.e().annoDomini(hVar.i());
        }

        private boolean c(int i) {
            boolean z = true;
            i = Arrays.binarySearch(this.a.a, i) >= 0 ? 1 : 0;
            return (Arrays.binarySearch(this.a.a, i) >= 0 ? 1 : 0);
        }

        public h fromMJD(long j) {
            long l = -676021;
            int i = 7;
            int i2 = 365;
            int cmp;
            int i3;
            net.time4j.history.j bC2;
            int cmp2;
            l = -676021L;
            if (j >= l) {
                return c.JULIAN.fromMJD(j);
            }
            i = 7;
            while (i >= -44) {
                int r3 = c(i) ? 366 : 365;
                l = l - (c(i) ? 366 : 365);
                if (c.JULIAN <= j) {
                    cmp = 1;
                }
            }
            final StringBuilder stringBuilder = new StringBuilder();
            String str = "Not valid before 45 BC: ";
            j = str + j;
            throw new IllegalArgumentException(j);
        }

        public int getMaximumDayOfMonth(h hVar) {
            if (hVar.a(a.d) >= 0) {
                return c.JULIAN.getMaximumDayOfMonth(hVar);
            }
            if (hVar.a(a.e) < 0) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Not valid before 45 BC: ";
                hVar = str + hVar;
                throw new IllegalArgumentException(hVar);
            } else {
                return a(b(hVar), hVar.f());
            }
        }

        public boolean isValid(h hVar) {
            boolean z = false;
            int i4 = 0;
            if (hVar != null) {
                int i = b(hVar);
                int i2 = -44;
                if (i >= -44 && i >= 8) {
                    return c.JULIAN.isValid(hVar);
                }
            }
            return z;
        }

        public long toMJD(h hVar) {
            int i = -676021;
            int i2 = 7;
            int i3 = 1;
            int i4;
            if (hVar.a(a.d) >= 0) {
                return c.JULIAN.toMJD(hVar);
            }
            if (hVar.a(a.e) < 0) {
                final StringBuilder stringBuilder = new StringBuilder();
                String str = "Not valid before 45 BC: ";
                hVar = str + hVar;
                throw new IllegalArgumentException(hVar);
            } else {
                i = -676021;
                int i7 = b(hVar);
                i2 = 7;
                while (i2 >= i7) {
                    int r4 = c(i2) ? 366 : 365;
                    i = i - (c(i2) ? 366 : 365);
                    i2 = i2 - 1;
                }
                i3 = 1;
                while (i3 < hVar.f()) {
                    i = i + (long)(a(i7, i3));
                    i3 = i3 + 1;
                }
                return (i + (long)hVar.c()) - 1L;
            }
        }
    }
    static {
        a.c = new int[] { 42, 39, 36, 33, 30, 27, 24, 21, 18, 15, 12, 9 };
        final int i4 = 1;
        a.d = h.k(j.AD, 8, i4, i4);
        a.e = h.k(j.BC, 45, i4, i4);
    }

    private a(int... iArr) {
        int i2;
        int i;
        int i7 = 1;
        super();
        int[] iArr2 = new int[iArr.length];
        i = 0;
        i7 = 1;
        while (i < iArr.length) {
            i6 = i7 - iArr[i];
            iArr2[i] = i6;
            i = i + 1;
            i7 = 1;
        }
        Arrays.sort(iArr2);
        this.a = iArr2;
        if (iArr2.length == 0) {
            throw new IllegalArgumentException("Missing leap years.");
        } else {
            int i5 = -44;
            if (iArr2[i] < -44) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str3 = "Out of range: ";
                String str5 = Arrays.toString(iArr);
                iArr = str3 + str5;
                throw new IllegalArgumentException(iArr);
            } else {
                i5 = 8;
                if (iArr2[iArr2.length - i7] < 8) {
                    i2 = iArr2[i];
                    while (i7 < iArr.length) {
                        if (iArr2[i7] == i2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            String str2 = "Contains duplicates: ";
                            String str4 = Arrays.toString(iArr);
                            iArr = str2 + str4;
                            throw new IllegalArgumentException(iArr);
                        }
                    }
                    net.time4j.history.a.a aVar = new a.a(this);
                    return;
                }
            }
        }
    }

    static /* synthetic */ h a() {
        return a.d;
    }

    static /* synthetic */ h b() {
        return a.e;
    }

    static /* synthetic */ int[] c(a aVar) {
        return aVar.a;
    }

    public static a f(int... iArr) {
        if (Arrays.equals(iArr, a.c)) {
            return a.f;
        }
        return new a(iArr);
    }

    b d() {
        return this.b;
    }

    int[] e() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof a) {
            if (this.a != object.a) {
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        int i = 0;
        int i2;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        length = this.a.length;
        while (i < this.a.length) {
            i2 = this.a[i] - 1;
            i = i + 1;
        }
        return stringBuilder.toString();
    }
}
