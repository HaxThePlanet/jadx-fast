package d.h.k;

import java.io.PrintWriter;

/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public final class k {

    private static final Object a = new Object();
    private static char[] b;
    static {
        k.b = new char[24];
    }

    public static void b(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
            return;
        }
        k.d(j - j2, printWriter, 0);
    }

    public static void c(long j, PrintWriter printWriter) {
        k.d(j, printWriter, 0);
    }

    public static void d(long j, PrintWriter printWriter, int i) {
        final Object obj2 = k.a;
        synchronized (obj2) {
            try {
                printWriter.print(new String(k.b, 0, k.e(j, i)));
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private static int e(long j, int i) {
        int i3;
        int i4;
        int i7 = 45;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4;
        boolean z5;
        boolean z6;
        int i11 = 0;
        long j2 = j;
        int i6 = i;
        length = k.b.length;
        if (k.b.length < i6) {
            k.b = new char[i6];
        }
        char[] cArr = k.b;
        char c = ' ';
        i4 = 1;
        i4 = 0;
        if (j2 == 0) {
            while (i6 - 1 > 0) {
                k.b[i4] = c;
            }
            k.b[i4] = 48;
            return i4;
        }
        if (j2 > 0) {
            i7 = 43;
        } else {
            i7 = 45;
            i = -j2;
        }
        long l3 = 1000L;
        l = i % l3;
        final int i8 = (int)l;
        i3 = (int)(Math.floor((double)(i / l3)));
        int i5 = 86400;
        if (i3 > i5) {
            i4 = i3 / i5;
            i5 = i5 * i4;
            i3 = i3 - i5;
        } else {
        }
        if (i3 > 3600) {
            i4 = i3 / 3600;
            i9 = i4 * 3600;
            i3 = i3 - i9;
        } else {
        }
        i4 = 60;
        if (i3 > 60) {
            i4 = i3 / 60;
        } else {
        }
        i4 = 3;
        i11 = 2;
        if (i6 != 0) {
            int i29 = k.a(i4, i4, false, i4);
            int r8 = i4;
            i29 += r8;
            r8 = i4;
            int i31 = i30 + i4;
            r8 = i4;
            i31 += r8;
            r8 = i4;
            i4 = i32 + i4;
            while (i4 < i6) {
                k.b[i4] = c;
                i4 = i4 + 1;
                i4 = i4 + 1;
            }
        } else {
        }
        k.b[i4] = i7;
        int i10 = i4 + 1;
        int r2 = i4;
        int i25 = k.f(k.b, i4, 'd', i10, false, 0);
        r8 = i25 != i10 ? i4 : 0;
        int r9 = i4 != 0 ? i11 : 0;
        int i26 = k.f(k.b, i4, 'h', i25, z, (i4 != 0 ? i11 : 0));
        r8 = i26 != i10 ? i4 : 0;
        r9 = i4 != 0 ? i11 : 0;
        int i27 = k.f(k.b, i4, 'm', i26, z2, (i4 != 0 ? i11 : 0));
        r8 = i27 != i10 ? i4 : 0;
        r9 = i4 != 0 ? i11 : 0;
        int i28 = k.f(k.b, i3, 's', i27, z3, (i4 != 0 ? i11 : 0));
        r9 = i4 != 0 && i28 != i10 ? i4 : 0;
        int i14 = k.f(k.b, i8, 'm', i28, true, (i4 != 0 && i28 != i10 ? i4 : 0));
        k.b[i14] = 115;
        return i14 + i4;
    }

    private static int f(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i42;
        int i5;
        int i8;
        char c2 = 9;
        if (z || i > 0) {
            if (!z || i3 < 3) {
                i = 99;
                if (i > 99) {
                    int i10 = i / 100;
                    cArr[i2] = (char)(i10 + 48);
                    i42 = i2 + 1;
                    i = i10 * 100;
                    i5 = i - i;
                } else {
                    i42 = i2;
                }
            }
            if (!z || i3 < 2) {
                if (i5 > 9 || i2 != i42) {
                    int i13 = i5 / 10;
                    c2 = (char)(i13 + 48);
                    cArr[i42] = c2;
                    i42 = i42 + 1;
                    i7 = i13 * 10;
                    i5 = i5 - i7;
                }
            }
            c = (char)(i5 + 48);
            cArr[i42] = c;
            i3 = i42 + 1;
            cArr[i3] = c;
            i8 = i3 + 1;
        }
        return i8;
    }

    private static int a(int i, int i2, boolean z, int i3) {
        i3 = 3;
        return i2 + i3;
    }
}
