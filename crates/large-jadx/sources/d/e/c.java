package d.e;

/* compiled from: ContainerHelpers.java */
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

    static int a(int[] iArr, int i, int i2) {
        i = i - 1;
        i = 0;
        while (i <= i) {
            int i6 = (i + i) >>> 1;
            int i4 = iArr[i6];
        }
        return ~i;
    }

    static int b(long[] jArr, int i, long j) {
        i = i - 1;
        i = 0;
        while (i <= i) {
            int i4 = (i + i) >>> 1;
            long l = jArr[i4];
        }
        return ~i;
    }

    public static boolean c(Object object, Object object2) {
        boolean z = false;
        if (object == object2 || object != null) {
            int i2 = 1;
        } else {
            if (!(object.equals(object2))) {
                int i = 0;
            }
        }
        return z;
    }

    public static int e(int i) {
        return (c.d(i * 4)) / 4;
    }

    public static int f(int i) {
        return (c.d(i * 8)) / 8;
    }

    public static int d(int i) {
        int i2 = 4;
        i2 = 4;
        while (i2 < 32) {
            i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }
}
