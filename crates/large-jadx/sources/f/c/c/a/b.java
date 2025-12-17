package f.c.c.a;

/* loaded from: classes2.dex */
public final class b {
    static {
    }

    public static long a(long l, long l2) {
        int i2;
        int i;
        final int i3 = l + obj12;
        int i5 = 0;
        int i7 = 0;
        i2 = Long.compare(i4, i5) < 0 ? i : i7;
        final int i9 = l ^ i3;
        if (Long.compare(i9, i5) >= 0) {
        } else {
            i = i7;
        }
        c.a(i2 | i, "checkedAdd", l, i9);
        return i3;
    }
}
