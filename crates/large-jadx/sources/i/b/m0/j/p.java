package i.b.m0.j;

/* compiled from: OpenHashSet.java */
/* loaded from: classes3.dex */
public final class p<T> {

    final float a;
    int b;
    int c;
    int d;
    T[] e;
    public p() {
        this(16, 0.75f);
    }

    public boolean a(T t) {
        int i;
        i = p.c(t.hashCode()) & i4;
        Object obj = objArr[i];
        final int i8 = 1;
        if (obj != null) {
            int i2 = 0;
            if (obj.equals(t)) {
                return false;
            }
            i = (i + i8) & i4;
            obj = objArr[i];
            while (obj == null) {
                if (obj.equals(t)) {
                    return false;
                }
                i = (i + i8) & i4;
                obj = objArr[i + i8 & i4];
            }
        }
        this.e[i] = t;
        this.c += i8;
        if (this.c >= this.d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.e;
    }

    void d() {
        int length;
        int i;
        int i2;
        length = objArr.length;
        final int i4 = length << 1;
        final int i5 = i4 - 1;
        final Object[] arr = new Object[i4];
        i = i - 1;
        while (this.c != 0) {
            length = length - 1;
            while (objArr[length] == 0) {
                length = length - 1;
            }
            i2 = p.c(objArr[length].hashCode()) & i5;
            arr[i2] = objArr[length];
            i = i - 1;
        }
        this.b = i5;
        this.d = (int)(float)i4 * this.a;
        this.e = arr;
    }

    public boolean e(T t) {
        int i;
        i = p.c(t.hashCode()) & i2;
        Object obj = objArr[i];
        final boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj.equals(t)) {
            return f(i, this.e, this.b);
        }
        i = (i + 1) & i2;
        Object obj2 = objArr[i];
        while (obj2 == null) {
            if (obj2.equals(t)) {
                return f(i, this.e, this.b);
            }
            i = (i + 1) & i2;
            obj2 = objArr[i];
        }
        return false;
    }

    boolean f(int i, T[] tArr, int i2) {
        int i4;
        Object obj;
        int i5;
        final int i7 = 1;
        this.c -= i7;
        while (/* condition */) {
            i2 = i4 & i2;
            obj = tArr[i2];
            while (obj == null) {
                i5 = p.c(obj.hashCode()) & i2;
                if (i2 >= i5) {
                    break loop_2;
                }
                if (i5 > this.c) {
                    break loop_2;
                }
            }
            i5 = p.c(obj.hashCode()) & i2;
            int r0 = i2 + 1;
        }
        tArr[i2] = 0;
        return true;
    }

    public int g() {
        return this.c;
    }

    public p(int i, float f) {
        super();
        this.a = f;
        int i3 = q.a(i);
        this.b = i3 - 1;
        this.d = (int)(f * (float)i3);
        this.e = new Object[i3];
    }

    static int c(int i) {
        i *= -1640531527;
        return i4 ^ (i4 >>> 16);
    }
}
