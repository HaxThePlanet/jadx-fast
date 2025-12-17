package androidx.recyclerview.widget;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class z<T>  {

    T[] a;
    private T[] b;
    private int c;
    private int d;
    private androidx.recyclerview.widget.z.a e;
    private int f;
    private final Class<T> g;

    public static abstract class a implements Comparator<T2>, androidx.recyclerview.widget.r {
        public abstract boolean a(T2 t2, T2 t22);

        public abstract boolean b(T2 t2, T2 t22);

        public abstract Object c(T2 t2, T2 t22);

        public abstract int compare(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract void onChanged(int i, int i2, Object object3);
    }
    public z(Class<T> class, androidx.recyclerview.widget.z.a<T> z$a2) {
        super(class, a2, 10);
    }

    public z(Class<T> class, androidx.recyclerview.widget.z.a<T> z$a2, int i3) {
        super();
        this.g = class;
        this.a = (Object[])Array.newInstance(class, i3);
        this.e = a2;
        this.f = 0;
    }

    private int b(T t, boolean z2) {
        int i;
        int i2;
        int i3;
        Object obj7;
        i = this.e(t, this.a, 0, this.f, 1);
        int i4 = 1;
        if (i == -1) {
            i = 0;
        } else {
            i2 = this.a[i];
            if (i < this.f && this.e.b(i2, t) && this.e.a(i2, t)) {
                i2 = this.a[i];
                if (this.e.b(i2, t)) {
                    if (this.e.a(i2, t)) {
                        this.a[i] = t;
                        return i;
                    }
                    this.a[i] = t;
                    androidx.recyclerview.widget.z.a obj8 = this.e;
                    obj8.onChanged(i, i4, obj8.c(i2, t));
                    return i;
                }
            }
        }
        c(i, t);
        if (z2) {
            this.e.onInserted(i, i4);
        }
        return i;
    }

    private void c(int i, T t2) {
        Object[] instance;
        Object[] objArr;
        int i2;
        Object obj5;
        int i3 = this.f;
        if (i > i3) {
        } else {
            objArr = this.a;
            if (i3 == objArr.length) {
                instance = Array.newInstance(this.g, length += 10);
                int i6 = 0;
                System.arraycopy(this.a, i6, (Object[])instance, i6, i);
                instance[i] = t2;
                System.arraycopy(this.a, i, instance, i + 1, i7 -= i);
                this.a = instance;
            } else {
                System.arraycopy(objArr, i, objArr, i + 1, i3 -= i);
                this.a[i] = t2;
            }
            this.f = obj4++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cannot add item to ");
        stringBuilder.append(i);
        stringBuilder.append(" because size is ");
        stringBuilder.append(this.f);
        obj5 = new IndexOutOfBoundsException(stringBuilder.toString());
        throw obj5;
    }

    private int e(T t, T[] t2Arr2, int i3, int i4, int i5) {
        int i;
        Object obj;
        int compare;
        int obj8;
        int obj9;
        final int i2 = -1;
        final int i6 = 1;
        while (obj8 < obj9) {
            i7 /= 2;
            obj = t2Arr2[i];
            compare = this.e.compare(obj, t);
            obj9 = i;
            i2 = -1;
            i6 = 1;
            obj8 = i;
        }
        if (i5 == i6) {
        } else {
            obj8 = i2;
        }
        return obj8;
    }

    private int g(T t, int i2, int i3, int i4) {
        int compare2;
        boolean z;
        androidx.recyclerview.widget.z.a compare;
        int obj5;
        int obj6;
        compare2 = i2 + -1;
        while (compare2 >= i3) {
            z = this.a[compare2];
            compare2--;
        }
        obj5++;
        while (obj5 < i4) {
            obj6 = this.a[obj5];
            obj5++;
        }
        return -1;
    }

    private boolean i(T t, boolean z2) {
        int obj7 = this.e(t, this.a, 0, this.f, 2);
        if (obj7 == -1) {
            return 0;
        }
        k(obj7, z2);
        return 1;
    }

    private void k(int i, boolean z2) {
        androidx.recyclerview.widget.z.a obj6;
        Object[] objArr = this.a;
        final int i9 = 1;
        System.arraycopy(objArr, i + 1, objArr, i, i6 -= i9);
        i2 -= i9;
        this.f = i3;
        this.a[i3] = 0;
        if (z2 != null) {
            this.e.onRemoved(i, i9);
        }
    }

    private void m() {
        if (this.b != null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        throw illegalStateException;
    }

    public int a(T t) {
        m();
        return b(t, true);
    }

    public void d() {
        m();
        final int i = this.f;
        if (i == 0) {
        }
        final int i3 = 0;
        Arrays.fill(this.a, i3, i, 0);
        this.f = i3;
        this.e.onRemoved(i3, i);
    }

    public T f(int i) {
        int i2;
        if (i >= this.f) {
        } else {
            if (i < 0) {
            } else {
                Object[] objArr = this.b;
                i2 = this.d;
                if (objArr != null && i >= i2) {
                    i2 = this.d;
                    if (i >= i2) {
                        return objArr[obj4 += i4];
                    }
                }
                return this.a[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asked to get item at ");
        stringBuilder.append(i);
        stringBuilder.append(" but size is ");
        stringBuilder.append(this.f);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    public boolean h(T t) {
        m();
        return i(t, true);
    }

    public T j(int i) {
        m();
        k(i, true);
        return f(i);
    }

    public int l() {
        return this.f;
    }

    public void n(int i, T t2) {
        Object obj;
        Object[] objArr;
        boolean z;
        int i2;
        int compare;
        Object obj7;
        m();
        obj = f(i);
        int i3 = 0;
        final int i4 = 1;
        if (obj != t2) {
            if (!this.e.a(obj, t2)) {
                i2 = i4;
            } else {
                i2 = i3;
            }
        } else {
        }
        this.a[i] = t2;
        if (obj != t2 && this.e.compare(obj, t2) == 0 && i2 != 0) {
            if (this.e.compare(obj, t2) == 0) {
                this.a[i] = t2;
                if (i2 != 0) {
                    objArr = this.e;
                    objArr.onChanged(i, i4, objArr.c(obj, t2));
                }
            }
        }
        if (i2 != 0) {
            i2 = this.e;
            i2.onChanged(i, i4, i2.c(obj, t2));
        }
        k(i, i3);
        obj7 = b(t2, i3);
        if (i != obj7) {
            this.e.onMoved(i, obj7);
        }
    }
}
