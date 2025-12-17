package d.e;

/* loaded from: classes.dex */
public class d<E>  implements java.lang.Cloneable {

    private static final Object w;
    private boolean a;
    private long[] b;
    private Object[] c;
    private int v;
    static {
        Object object = new Object();
        d.w = object;
    }

    public d() {
        super(10);
    }

    public d(int i) {
        int lArr;
        Object[] obj2;
        super();
        this.a = false;
        if (i == 0) {
            this.b = c.b;
            this.c = c.c;
        } else {
            obj2 = c.f(i);
            this.b = new long[obj2];
            this.c = new Object[obj2];
        }
    }

    private void e() {
        int i;
        int i2;
        Object obj;
        Object obj2;
        final long[] lArr = this.b;
        final Object[] objArr = this.c;
        final int i4 = 0;
        i2 = i;
        while (i < this.v) {
            obj = objArr[i];
            if (obj != d.w && i != i2) {
            }
            i++;
            if (i != i2) {
            }
            i2++;
            lArr[i2] = lArr[i];
            objArr[i2] = obj;
            objArr[i] = 0;
        }
        this.a = i4;
        this.v = i2;
    }

    public void a(long l, E e2) {
        int cmp;
        boolean length;
        int length2;
        long lArr;
        Object[] objArr;
        int length3;
        int i;
        int i2 = this.v;
        if (i2 != 0 && Long.compare(l, lArr) <= 0) {
            if (Long.compare(l, lArr) <= 0) {
                k(l, e2);
            }
        }
        if (this.a && i2 >= lArr4.length) {
            if (i2 >= lArr4.length) {
                e();
            }
        }
        int i3 = this.v;
        if (i3 >= lArr2.length) {
            int i6 = c.f(i3 + 1);
            lArr = new long[i6];
            length2 = new Object[i6];
            long[] lArr6 = this.b;
            i = 0;
            System.arraycopy(lArr6, i, lArr, i, lArr6.length);
            objArr = this.c;
            System.arraycopy(objArr, i, length2, i, objArr.length);
            this.b = lArr;
            this.c = length2;
        }
        this.b[i3] = l;
        this.c[i3] = obj9;
        this.v = i3++;
    }

    @Override // java.lang.Cloneable
    public void b() {
        int i;
        int i2;
        final int i4 = 0;
        i = i4;
        while (i < this.v) {
            this.c[i] = 0;
            i++;
        }
        this.v = i4;
        this.a = i4;
    }

    public d.e.d<E> c() {
        try {
            final Object clone = super.clone();
            clone.b = (long[])this.b.clone();
            clone.c = (Object[])this.c.clone();
            return (d)clone;
            AssertionError assertionError = new AssertionError(th);
            throw assertionError;
        }
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return c();
    }

    @Override // java.lang.Cloneable
    public boolean d(long l) {
        int obj1;
        obj1 = h(l) >= 0 ? 1 : 0;
        return obj1;
    }

    public E f(long l) {
        return g(l, obj3);
    }

    public E g(long l, E e2) {
        long[] lArr;
        int i;
        long obj4;
        int obj3 = c.b(this.b, this.v, l);
        obj4 = this.c;
        if (obj3 >= 0 && obj4[obj3] == d.w) {
            obj4 = this.c;
            if (obj4[obj3] == d.w) {
            }
            return obj4[obj3];
        }
        return obj5;
    }

    @Override // java.lang.Cloneable
    public int h(long l) {
        if (this.a) {
            e();
        }
        return c.b(this.b, this.v, l);
    }

    @Override // java.lang.Cloneable
    public long j(int i) {
        if (this.a) {
            e();
        }
        return this.b[i];
    }

    public void k(long l, E e2) {
        int i3;
        int i5;
        int arr;
        int i;
        long[] i4;
        Object[] objArr;
        boolean length2;
        int lArr;
        Object obj;
        Object length;
        int i2;
        int obj7;
        i3 = c.b(this.b, this.v, l);
        if (i3 >= 0) {
            this.c[i3] = obj9;
        } else {
            i3 = ~i3;
            i5 = this.v;
            objArr = this.c;
            if (i3 < i5 && objArr[i3] == d.w) {
                objArr = this.c;
                if (objArr[i3] == d.w) {
                    this.b[i3] = l;
                    objArr[i3] = obj9;
                }
            }
            if (this.a && i5 >= lArr5.length) {
                if (i5 >= lArr5.length) {
                    e();
                    i3 = ~i6;
                }
            }
            arr = this.v;
            if (arr >= lArr6.length) {
                int i9 = c.f(arr++);
                lArr = new long[i9];
                arr = new Object[i9];
                long[] lArr8 = this.b;
                i2 = 0;
                System.arraycopy(lArr8, i2, lArr, i2, lArr8.length);
                obj = this.c;
                System.arraycopy(obj, i2, arr, i2, obj.length);
                this.b = lArr;
                this.c = arr;
            }
            i = this.v;
            if (i - i3 != 0) {
                long[] lArr7 = this.b;
                obj = i3 + 1;
                System.arraycopy(lArr7, i3, lArr7, obj, i -= i3);
                i = this.c;
                System.arraycopy(i, i3, i, obj, i10 -= i3);
            }
            this.b[i3] = l;
            this.c[i3] = obj9;
            this.v = obj7++;
        }
    }

    @Override // java.lang.Cloneable
    public void l(long l) {
        long[] lArr;
        int i;
        int obj3;
        long obj4;
        obj3 = c.b(this.b, this.v, l);
        obj4 = this.c;
        i = d.w;
        if (obj3 >= 0 && obj4[obj3] != i) {
            obj4 = this.c;
            i = d.w;
            if (obj4[obj3] != i) {
                obj4[obj3] = i;
                this.a = true;
            }
        }
    }

    @Override // java.lang.Cloneable
    public void m(int i) {
        int obj4;
        final Object[] objArr = this.c;
        final Object obj2 = d.w;
        if (objArr[i] != obj2) {
            objArr[i] = obj2;
            this.a = true;
        }
    }

    @Override // java.lang.Cloneable
    public int n() {
        if (this.a) {
            e();
        }
        return this.v;
    }

    public E o(int i) {
        if (this.a) {
            e();
        }
        return this.c[i];
    }

    @Override // java.lang.Cloneable
    public String toString() {
        int i;
        Object str;
        int str2;
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(i3 *= 28);
        stringBuilder.append('{');
        i = 0;
        while (i < this.v) {
            if (i > 0) {
            }
            stringBuilder.append(j(i));
            stringBuilder.append('=');
            str = o(i);
            if (str != this) {
            } else {
            }
            stringBuilder.append("(this Map)");
            i++;
            stringBuilder.append(str);
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
