package d.e;

/* loaded from: classes.dex */
public class h<E>  implements java.lang.Cloneable {

    private static final Object w;
    private boolean a;
    private int[] b;
    private Object[] c;
    private int v;
    static {
        Object object = new Object();
        h.w = object;
    }

    public h() {
        super(10);
    }

    public h(int i) {
        int iArr;
        Object[] obj2;
        super();
        this.a = false;
        if (i == 0) {
            this.b = c.a;
            this.c = c.c;
        } else {
            obj2 = c.e(i);
            this.b = new int[obj2];
            this.c = new Object[obj2];
        }
    }

    private void d() {
        int i2;
        int i;
        Object obj2;
        Object obj;
        final int[] iArr = this.b;
        final Object[] objArr = this.c;
        final int i4 = 0;
        i = i2;
        while (i2 < this.v) {
            obj2 = objArr[i2];
            if (obj2 != h.w && i2 != i) {
            }
            i2++;
            if (i2 != i) {
            }
            i++;
            iArr[i] = iArr[i2];
            objArr[i] = obj2;
            objArr[i2] = 0;
        }
        this.a = i4;
        this.v = i;
    }

    public void a(int i, E e2) {
        int i3;
        boolean length3;
        int length;
        int iArr;
        Object[] objArr;
        int length2;
        int i2;
        int i4 = this.v;
        if (i4 != 0 && i <= this.b[i4 + -1]) {
            if (i <= this.b[i4 + -1]) {
                j(i, e2);
            }
        }
        if (this.a && i4 >= iArr4.length) {
            if (i4 >= iArr4.length) {
                d();
            }
        }
        int i5 = this.v;
        if (i5 >= iArr2.length) {
            int i8 = c.e(i5 + 1);
            iArr = new int[i8];
            length = new Object[i8];
            int[] iArr6 = this.b;
            i2 = 0;
            System.arraycopy(iArr6, i2, iArr, i2, iArr6.length);
            objArr = this.c;
            System.arraycopy(objArr, i2, length, i2, objArr.length);
            this.b = iArr;
            this.c = length;
        }
        this.b[i5] = i;
        this.c[i5] = e2;
        this.v = i5++;
    }

    @Override // java.lang.Cloneable
    public void b() {
        int i2;
        int i;
        final int i4 = 0;
        i2 = i4;
        while (i2 < this.v) {
            this.c[i2] = 0;
            i2++;
        }
        this.v = i4;
        this.a = i4;
    }

    public d.e.h<E> c() {
        try {
            final Object clone = super.clone();
            clone.b = (int[])this.b.clone();
            clone.c = (Object[])this.c.clone();
            return (h)clone;
            AssertionError assertionError = new AssertionError(th);
            throw assertionError;
        }
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return c();
    }

    public E e(int i) {
        return f(i, 0);
    }

    public E f(int i, E e2) {
        int[] iArr;
        int i2;
        Object obj;
        int obj4 = c.a(this.b, this.v, i);
        iArr = this.c;
        if (obj4 >= 0 && iArr[obj4] == h.w) {
            iArr = this.c;
            if (iArr[obj4] == h.w) {
            }
            return iArr[obj4];
        }
        return e2;
    }

    public int g(E e) {
        int i;
        Object obj;
        if (this.a) {
            d();
        }
        i = 0;
        while (i < this.v) {
            i++;
        }
        return -1;
    }

    @Override // java.lang.Cloneable
    public int h(int i) {
        if (this.a) {
            d();
        }
        return this.b[i];
    }

    public void j(int i, E e2) {
        int i4;
        int i2;
        int arr;
        int i5;
        int[] i3;
        Object[] objArr;
        boolean length2;
        int iArr;
        Object obj;
        Object length;
        int i6;
        int obj7;
        i4 = c.a(this.b, this.v, i);
        if (i4 >= 0) {
            this.c[i4] = e2;
        } else {
            i4 = ~i4;
            i2 = this.v;
            objArr = this.c;
            if (i4 < i2 && objArr[i4] == h.w) {
                objArr = this.c;
                if (objArr[i4] == h.w) {
                    this.b[i4] = i;
                    objArr[i4] = e2;
                }
            }
            if (this.a && i2 >= iArr5.length) {
                if (i2 >= iArr5.length) {
                    d();
                    i4 = ~i7;
                }
            }
            arr = this.v;
            if (arr >= iArr6.length) {
                int i10 = c.e(arr++);
                iArr = new int[i10];
                arr = new Object[i10];
                int[] iArr8 = this.b;
                i6 = 0;
                System.arraycopy(iArr8, i6, iArr, i6, iArr8.length);
                obj = this.c;
                System.arraycopy(obj, i6, arr, i6, obj.length);
                this.b = iArr;
                this.c = arr;
            }
            i5 = this.v;
            if (i5 - i4 != 0) {
                int[] iArr7 = this.b;
                obj = i4 + 1;
                System.arraycopy(iArr7, i4, iArr7, obj, i5 -= i4);
                i5 = this.c;
                System.arraycopy(i5, i4, i5, obj, i11 -= i4);
            }
            this.b[i4] = i;
            this.c[i4] = e2;
            this.v = obj7++;
        }
    }

    @Override // java.lang.Cloneable
    public int k() {
        if (this.a) {
            d();
        }
        return this.v;
    }

    public E l(int i) {
        if (this.a) {
            d();
        }
        return this.c[i];
    }

    @Override // java.lang.Cloneable
    public String toString() {
        int i;
        Object str2;
        int str;
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(i3 *= 28);
        stringBuilder.append('{');
        i = 0;
        while (i < this.v) {
            if (i > 0) {
            }
            stringBuilder.append(h(i));
            stringBuilder.append('=');
            str2 = l(i);
            if (str2 != this) {
            } else {
            }
            stringBuilder.append("(this Map)");
            i++;
            stringBuilder.append(str2);
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
