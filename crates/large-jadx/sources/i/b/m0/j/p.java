package i.b.m0.j;

/* loaded from: classes3.dex */
public final class p<T>  {

    final float a;
    int b;
    int c;
    int d;
    T[] e;
    public p() {
        super(16, 1061158912);
    }

    public p(int i, float f2) {
        super();
        this.a = f2;
        int obj2 = q.a(i);
        this.b = obj2 + -1;
        this.d = (int)obj3;
        this.e = new Object[obj2];
    }

    static int c(int i) {
        i *= i2;
        return obj1 ^= i3;
    }

    public boolean a(T t) {
        int i2;
        Object obj;
        boolean equals;
        int i;
        Object[] objArr = this.e;
        final int i4 = this.b;
        obj = objArr[i6 &= i4];
        final int i8 = 1;
        i = 0;
        if (obj != null && obj.equals(t)) {
            i = 0;
            if (obj.equals(t)) {
                return i;
            }
            obj = objArr[i7 &= i4];
            while (obj == null) {
                obj = objArr[i7 &= i4];
            }
        }
        objArr[i2] = t;
        obj7 += i8;
        this.c = obj7;
        if (obj7 >= this.d) {
            d();
        }
        return i8;
    }

    public Object[] b() {
        return this.e;
    }

    void d() {
        int length;
        int i2;
        int i3;
        int i;
        Object obj;
        Object obj2;
        Object[] objArr = this.e;
        final int i6 = length << 1;
        final int i7 = i6 + -1;
        final Object[] arr = new Object[i6];
        i2 = this.c;
        while (i2 != 0) {
            length--;
            while (objArr[length] == 0) {
                length--;
            }
            if (arr[i9 &= i7] != null) {
            }
            arr[i3] = objArr[length];
            i2 = i;
            while (arr[i10 &= i7] == null) {
            }
        }
        this.b = i7;
        this.d = (int)i4;
        this.e = arr;
    }

    public boolean e(T t) {
        int i;
        boolean equals;
        final Object[] objArr = this.e;
        final int i2 = this.b;
        i4 &= i2;
        Object obj = objArr[i];
        final int i6 = 0;
        if (obj == null) {
            return i6;
        }
        if (obj.equals(t)) {
            return f(i, objArr, i2);
        }
        i5 &= i2;
        Object obj2 = objArr[i];
        while (obj2 == null) {
            i5 &= i2;
            obj2 = objArr[i];
        }
        return i6;
    }

    boolean f(int i, T[] t2Arr2, int i3) {
        int i5;
        int i4;
        Object obj;
        int i2;
        int obj5;
        final int i7 = 1;
        this.c = i6 -= i7;
        while (/* condition */) {
            i4 &= i3;
            obj = t2Arr2[i5];
            while (obj == null) {
                i9 &= i3;
                if (obj5 >= i2) {
                    break loop_2;
                } else {
                }
                i5++;
                i4 &= i3;
                obj = t2Arr2[i5];
                if (i2 > i5) {
                    break loop_2;
                } else {
                }
                if (i2 > i5) {
                    break loop_2;
                } else {
                }
            }
            i9 &= i3;
            if (obj5 <= i5) {
            } else {
            }
            if (obj5 >= i2) {
            } else {
            }
            i5++;
            if (i2 > i5) {
            } else {
            }
            t2Arr2[obj5] = obj;
            obj5 = i5;
            i4 = obj5 + 1;
            if (obj5 < i2) {
            } else {
            }
            if (i2 > i5) {
            } else {
            }
        }
        t2Arr2[obj5] = 0;
        return i7;
    }

    public int g() {
        return this.c;
    }
}
