package d.e;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements java.lang.Cloneable {

    private static final Object w = new Object();
    private boolean a;
    private int[] b;
    private Object[] c;
    private int v;

    public h() {
        this(10);
    }

    private void d() {
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

    public void a(int i, E e) {
        int i3;
        if (this.v != 0 && i <= this.b[i5 - 1]) {
            j(i, e);
            return;
        }
        if (this.a && this.v >= this.b.length) {
            d();
        }
        length = this.b.length;
        if (this.v >= this.b.length) {
            int i9 = c.e(i6 + 1);
            int[] iArr5 = new int[i9];
            Object[] arr = new Object[i9];
            int i4 = 0;
            System.arraycopy(this.b, i4, iArr5, i4, iArr6.length);
            length2 = objArr.length;
            System.arraycopy(this.c, i4, arr, i4, length2);
            this.b = iArr5;
            this.c = arr;
        }
        this.b[this.v] = i;
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

    public h<E> c() {
        try {
            final Object clone = super.clone();
            clone.b = (int[])this.b.clone();
            clone.c = (Object[])this.c.clone();
        } catch (java.lang.CloneNotSupportedException cloneNotSupported) {
            throw new AssertionError(cloneNotSupported);
        }
        return clone;
    }

    public E e(int i) {
        return f(i, null);
    }

    public E f(int i, E e) {
        int i3 = c.a(this.b, this.v, i);
        if (i3 >= 0) {
            return objArr[i3];
        }
        return e;
    }

    public int g(E e) {
        int i = 0;
        if (this.a) {
            d();
        }
        i = 0;
        while (this.a < this.v) {
            if (this.c[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int h(int i) {
        if (this.a) {
            d();
        }
        return this.b[i];
    }

    public void j(int i, E e) {
        int i2;
        int i6;
        Object obj;
        Object obj2;
        int i7 = 0;
        i2 = c.a(this.b, this.v, i);
        if (i2 < 0) {
            i2 = ~i2;
            if (this.b < this.v && objArr[i2] == h.w) {
                this.b[i2] = i;
                this.c[i2] = e;
                return;
            }
            if (this.a && this.v >= this.b.length) {
                d();
                i2 = ~(c.a(this.b, this.v, i));
            }
            length = this.b.length;
            if (this.v >= this.b.length) {
                int i13 = c.e(i4 + 1);
                int[] iArr8 = new int[i13];
                Object[] arr = new Object[i13];
                i7 = 0;
                System.arraycopy(this.b, i7, iArr8, i7, iArr9.length);
                System.arraycopy(this.c, i7, arr, i7, objArr3.length);
                this.b = iArr8;
                this.c = arr;
            }
            i6 = i5 - i2;
            if (i5 - i2 != 0) {
                int i15 = i2 + 1;
                System.arraycopy(this.b, i2, this.b, i15, i5 - i2);
                i6 = this.v - i2;
                System.arraycopy(this.c, i2, this.c, i15, i6);
            }
            this.b[i2] = i;
            this.c[i2] = e;
            this.v++;
        } else {
            this.c[i2] = e;
        }
    }

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

    @Override // java.lang.Object
    public String toString() {
        int i = 0;
        Object obj;
        if (k() <= 0) {
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

    public h(int i) {
        super();
        boolean z = false;
        this.a = z;
        if (i == 0) {
            this.b = c.a;
            this.c = c.c;
        } else {
            int i2 = c.e(i);
            this.b = new int[i2];
            this.c = new Object[i2];
        }
    }
}
