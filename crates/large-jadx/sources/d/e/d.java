package d.e;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements java.lang.Cloneable {

    private static final Object w = new Object();
    private boolean a;
    private long[] b;
    private Object[] c;
    private int v;

    public d() {
        this(10);
    }

    private void e() {
        int i;
        Object obj = null;
        Object obj2;
        final boolean z = false;
        while (i < this.v) {
            obj = objArr[i];
            i = i + 1;
        }
        this.a = z;
        this.v = i;
    }

    public void a(long j, E e) {
        long l;
        if (this.v != 0 && j <= l) {
            k(j, e);
            return;
        }
        if (this.a && this.v >= this.b.length) {
            e();
        }
        length = this.b.length;
        if (this.v >= this.b.length) {
            int i6 = c.f(i3 + 1);
            long[] lArr5 = new long[i6];
            Object[] arr = new Object[i6];
            int i = 0;
            System.arraycopy(this.b, i, lArr5, i, lArr6.length);
            length2 = objArr.length;
            System.arraycopy(this.c, i, arr, i, length2);
            this.b = lArr5;
            this.c = arr;
        }
        this.b[this.v] = j;
        this.c[this.v] = e;
        this.v++;
    }

    public void b() {
        int i;
        i = 0;
        while (i < this.v) {
            Object obj = null;
            this.c[i] = obj;
            i = i + 1;
        }
        this.v = i;
        this.a = false;
    }

    public d<E> c() {
        try {
            final Object clone = super.clone();
            clone.b = (long[])this.b.clone();
            clone.c = (Object[])this.c.clone();
        } catch (java.lang.CloneNotSupportedException cloneNotSupported) {
            throw new AssertionError(cloneNotSupported);
        }
        return clone;
    }

    public boolean d(long j) {
        boolean z = true;
        j = h(j) >= 0 ? 1 : 0;
        return (h(j) >= 0 ? 1 : 0);
    }

    public E f(long j) {
        return g(j, null);
    }

    public E g(long j, E e) {
        int i2 = c.b(this.b, this.v, j);
        if (i2 >= 0) {
            return objArr[i2];
        }
        return e;
    }

    public int h(long j) {
        if (this.a) {
            e();
        }
        return c.b(this.b, this.v, j);
    }

    public long j(int i) {
        if (this.a) {
            e();
        }
        return this.b[i];
    }

    public void k(long j, E e) {
        int i;
        int i5;
        Object obj;
        Object obj2;
        int i6 = 0;
        i = c.b(this.b, this.v, j);
        if (i < 0) {
            i = ~i;
            if (this.b < this.v && objArr[i] == d.w) {
                this.b[i] = j;
                this.c[i] = e;
                return;
            }
            if (this.a && this.v >= this.b.length) {
                e();
                i = ~(c.b(this.b, this.v, j));
            }
            length = this.b.length;
            if (this.v >= this.b.length) {
                int i12 = c.f(i3 + 1);
                long[] lArr8 = new long[i12];
                Object[] arr = new Object[i12];
                i6 = 0;
                System.arraycopy(this.b, i6, lArr8, i6, lArr9.length);
                System.arraycopy(this.c, i6, arr, i6, objArr3.length);
                this.b = lArr8;
                this.c = arr;
            }
            i5 = i4 - i;
            if (i4 - i != 0) {
                int i14 = i + 1;
                System.arraycopy(this.b, i, this.b, i14, i4 - i);
                i5 = this.v - i;
                System.arraycopy(this.c, i, this.c, i14, i5);
            }
            this.b[i] = j;
            this.c[i] = e;
            this.v++;
        } else {
            this.c[i] = e;
        }
    }

    public void l(long j) {
        int i2 = c.b(this.b, this.v, j);
        if (i2 >= 0) {
            Object obj2 = d.w;
            if (objArr[i2] != d.w) {
                this.c[i2] = d.w;
                this.a = true;
            }
        }
    }

    public void m(int i) {
        final Object obj2 = d.w;
        if (objArr[i] != d.w) {
            this.c[i] = d.w;
            boolean z = true;
            this.a = z;
        }
    }

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

    @Override // java.lang.Object
    public String toString() {
        int i = 0;
        Object obj;
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.v * 28);
        stringBuilder.append('{');
        i = 0;
        while (i < this.v) {
            stringBuilder.append(obj);
            stringBuilder.append("(this Map)");
            i = i + 1;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public d(int i) {
        super();
        boolean z = false;
        this.a = z;
        if (i == 0) {
            this.b = c.b;
            this.c = c.c;
        } else {
            int i2 = c.f(i);
            this.b = new long[i2];
            this.c = new Object[i2];
        }
    }
}
