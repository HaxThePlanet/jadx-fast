package f.c.b.a.a.a;

/* compiled from: NumberComparisonHelper.java */
/* loaded from: classes2.dex */
public final class a {
    public static int b(double d, long j) {
        final long l3 = -1L;
        if (Double.isNaN(d)) {
            return l3;
        }
        if (d < -4332462841530417152L) {
            return l3;
        }
        if (d >= 4890909195324358656L) {
            return 1;
        }
        int i = a.a((long)d, j);
        if (i != 0) {
            return i;
        }
        return a.c(d, (double)j);
    }

    public static int c(double d, double d2) {
        final int i = -1;
        if (d < d2) {
            return i;
        }
        final int i2 = 1;
        if (d > d2) {
            return i2;
        }
        final int i3 = 0;
        if (d == d2) {
            return i3;
        }
        if (!Double.isNaN(d2)) {
            return i;
        }
        return !Double.isNaN(d) ? i2 : i3;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        return 0;
    }
}
