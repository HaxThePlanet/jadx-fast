package d.e;

/* loaded from: classes.dex */
class c {

    static final int[] a;
    static final long[] b;
    static final Object[] c;
    static {
        int i = 0;
        c.a = new int[i];
        c.b = new long[i];
        c.c = new Object[i];
    }

    static int a(int[] iArr, int i2, int i3) {
        int i5;
        int i4;
        int i;
        int obj4;
        i2--;
        i5 = 0;
        while (i5 <= obj4) {
            i6 >>>= 1;
            i = iArr[i7];
            obj4 = i4;
            i5 = i4;
        }
        return ~i5;
    }

    static int b(long[] lArr, int i2, long l3) {
        int i;
        int i3;
        int cmp;
        int obj5;
        i2--;
        i = 0;
        while (i <= obj5) {
            i4 >>>= 1;
            cmp = Long.compare(l, l3);
            obj5 = i3;
            i = i3;
        }
        return ~i;
    }

    public static boolean c(Object object, Object object2) {
        boolean obj0;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj0 = 1;
                } else {
                    obj0 = 0;
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    public static int d(int i) {
        int i3;
        int i2;
        i3 = 4;
        while (i3 < 32) {
            i6 += -12;
            i3++;
        }
        return i;
    }

    public static int e(int i) {
        return obj0 /= 4;
    }

    public static int f(int i) {
        return obj0 /= 8;
    }
}
