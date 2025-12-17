package f.c.b.a.a.a;

/* loaded from: classes2.dex */
public final class a {
    public static int a(long l, long l2) {
        int obj0 = Long.compare(l, obj2);
        if (obj0 < 0) {
            return -1;
        }
        if (obj0 > 0) {
            return 1;
        }
        return 0;
    }

    public static int b(double d, long l2) {
        final int i2 = -1;
        if (Double.isNaN(d)) {
            return i2;
        }
        if (Double.compare(d, l4) < 0) {
            return i2;
        }
        if (Double.compare(d, l) >= 0) {
            return 1;
        }
        int i = a.a((long)d, i2);
        if (i != 0) {
            return i;
        }
        return a.c(d, l2);
    }

    public static int c(double d, double d2) {
        final int i = -1;
        if (Double.compare(d, obj6) < 0) {
            return i;
        }
        int cmp2 = Double.compare(d, obj6);
        final int i2 = 1;
        if (cmp2 > 0) {
            return i2;
        }
        final int i3 = 0;
        if (cmp2 == 0) {
            return i3;
        }
        if (!Double.isNaN(obj6)) {
            return i;
        }
        if (!Double.isNaN(d)) {
            return i2;
        }
        return i3;
    }
}
