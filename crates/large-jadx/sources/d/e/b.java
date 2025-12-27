package d.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    private static Object[] A;
    private static int B;
    private static final int[] w;
    private static final Object[] x;
    private static Object[] y;
    private static int z;
    private int[] a;
    Object[] b;
    int c;
    private f<E, E> v;

    class a extends f<E, E> {

        final /* synthetic */ b d;
        a() {
            this.d = bVar;
            super();
        }

        @Override // d.e.f
        protected void a() {
            this.d.clear();
        }

        @Override // d.e.f
        protected Object b(int i, int i2) {
            return this.d.b[i];
        }

        @Override // d.e.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // d.e.f
        protected int d() {
            return this.d.c;
        }

        @Override // d.e.f
        protected int e(Object object) {
            return this.d.indexOf(object);
        }

        @Override // d.e.f
        protected int f(Object object) {
            return this.d.indexOf(object);
        }

        @Override // d.e.f
        protected void g(E e, E e2) {
            this.d.add(e);
        }

        @Override // d.e.f
        protected void h(int i) {
            this.d.m(i);
        }

        @Override // d.e.f
        protected E i(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }
    }
    static {
        int i = 0;
        b.w = new int[i];
        b.x = new Object[i];
    }

    public b() {
        this(0);
    }

    private void b(int i) {
        Object obj = null;
        final int i3 = 0;
        final int i4 = 1;
        if (i == 8) {
            Class<d.e.b> obj4 = b.class;
            synchronized (obj4) {
                try {
                    objArr = b.A;
                    if (b.A != null) {
                        this.b = b.A;
                        b.A = (Object[])b.A[i3];
                        this.a = (int[])objArr[i4];
                        objArr[i4] = obj;
                        objArr[i3] = obj;
                        b.B -= i4;
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
        } else {
            int i2 = 4;
            if (b.B == 4) {
                Class<d.e.b> obj3 = b.class;
                synchronized (obj3) {
                    try {
                        objArr = b.y;
                        if (b.y != null) {
                            this.b = b.y;
                            b.y = (Object[])b.y[i3];
                            this.a = (int[])objArr[i4];
                            objArr[i4] = obj;
                            objArr[i3] = obj;
                            b.z -= i4;
                            return;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
        this.a = new int[th];
        this.b = new Object[th];
    }

    private static void g(int[] iArr, Object[] objectArr, int i) {
        int i4;
        int i5;
        final Object[] objArr = null;
        final int i6 = 2;
        final int i7 = 0;
        i = 10;
        final int i8 = 1;
        if (iArr.length == 8) {
            obj = b.class;
            synchronized (obj) {
                try {
                    if (b.B < i) {
                        objectArr[i7] = b.A;
                        objectArr[i8] = iArr;
                        i5 = i - i8;
                        while (i5 >= i6) {
                            objectArr[i5] = objArr;
                            i5 = i5 - 1;
                        }
                        b.A = objectArr;
                        b.B += i8;
                    }
                } catch (Throwable unused) {
                }
            }
        } else {
            int i2 = 4;
            if (iArr.length == 4) {
                obj = b.class;
                synchronized (obj) {
                    try {
                        if (b.z < i) {
                            objectArr[i7] = b.y;
                            objectArr[i8] = iArr;
                            i5 = i - i8;
                            while (i5 >= i6) {
                                objectArr[i5] = objArr;
                                i5 = i5 - 1;
                            }
                            b.y = objectArr;
                            b.z += i8;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    private f<E, E> h() {
        if (this.v == null) {
            this.v = new b.a(this);
        }
        return this.v;
    }

    private int i(Object object, int i) {
        int i3;
        int i4;
        boolean equals;
        if (this.c == 0) {
            return -1;
        }
        int i5 = c.a(this.a, this.c, i);
        if (i5 < 0) {
            return i5;
        }
        if (object.equals(this.b[i5])) {
            return i5;
        }
        i4 = i5 + 1;
        while (this.b < this.c) {
            if (object.equals(this.b[i4])) {
                return i4;
            }
        }
        i3 = i5 - 1;
        while (this.a >= 0) {
            if (object.equals(this.b[i3])) {
                return i3;
            }
        }
        return ~i4;
    }

    private int l() {
        int i;
        int i2;
        int i3;
        Object obj;
        if (this.c == 0) {
            return -1;
        }
        int i7 = c.a(this.a, this.c, 0);
        if (i7 < 0) {
            return i7;
        }
        if (this.b[i7] == null) {
            return i7;
        }
        i3 = i7 + 1;
        while (this.b < this.c) {
            if (this.b[i3] == null) {
                return i3;
            }
        }
        i2 = i7 - 1;
        while (this.a >= 0) {
            if (this.b[i2] == 0) {
                return i2;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        int i3;
        int i;
        int i4;
        int i5 = 4;
        int[] iArr2;
        int length2;
        i = 0;
        if (e == null) {
            i3 = l();
        } else {
            i = e.hashCode();
        }
        if (i3 >= 0) {
            return false;
        }
        int i8 = ~i3;
        length = iArr.length;
        if (this.c >= iArr.length) {
            i5 = 4;
            i5 = 8;
            if (this.c >= i5) {
                i5 = (i4 >> 1) + i4;
            } else {
                if (this.c >= 4) {
                }
            }
            b(i5);
            length2 = iArr2.length;
            if (iArr2.length > 0) {
                System.arraycopy(this.a, i, this.a, i, iArr.length);
                length2 = objArr3.length;
                System.arraycopy(this.b, i, this.b, i, length2);
            }
            b.g(this.a, this.b, this.c);
        }
        if (i8 < this.c) {
            int i10 = i8 + 1;
            System.arraycopy(this.a, i8, this.a, i10, i2 - i8);
            i4 = this.c - i8;
            System.arraycopy(this.b, i8, this.b, i10, i4);
        }
        this.a[i8] = i;
        this.b[i8] = e;
        int i7 = 1;
        this.c += i7;
        return true;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        d(this.c + collection.size());
        final Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            z = z | add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        if (this.c != 0) {
            b.g(this.a, this.b, this.c);
            this.a = b.w;
            this.b = b.x;
            int i = 0;
            this.c = i;
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object object) {
        boolean z = true;
        object = indexOf(object) >= 0 ? 1 : 0;
        return (indexOf(object) >= 0 ? 1 : 0);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void d(int i) {
        int i2;
        int i3 = 0;
        length = iArr.length;
        if (iArr.length < i) {
            b(i);
            if (this.c > 0) {
                i3 = 0;
                System.arraycopy(this.a, i3, this.a, i3, this.c);
                System.arraycopy(this.b, i3, this.b, i3, this.c);
            }
            b.g(this.a, this.b, this.c);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        int i;
        final boolean z = true;
        if (this == object) {
            return true;
        }
        i = 0;
        if (object instanceof Set) {
            if (size() != object.size()) {
                return false;
            }
            while (i < this.c) {
                if (!object.contains(p(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        i = 0;
        while (i < this.c) {
            i = i + this.a[i];
            i = i + 1;
        }
        return i;
    }

    public int indexOf(Object object) {
        int i2;
        if (object == null) {
            i2 = l();
        } else {
            i2 = i(object, object.hashCode());
        }
        return i2;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean z = true;
        int r0 = this.c <= 0 ? 1 : 0;
        return (this.c <= 0 ? 1 : 0);
    }

    @Override // java.util.Collection
    public Iterator<E> iterator() {
        return h().m().iterator();
    }

    public E m(int i) {
        int i5 = 0;
        int length;
        int i7 = 8;
        i5 = 0;
        int i6 = 1;
        if (this.c <= i6) {
            b.g(this.a, this.b, this.c);
            this.a = b.w;
            this.b = b.x;
            this.c = i5;
        } else {
            length = iArr.length;
            i7 = 8;
            if (iArr.length > i7) {
                length = iArr.length / 3;
                if (this.c < iArr.length / 3) {
                    if (this.c > i7) {
                        length = i2 >> 1;
                        i7 = i2 + length;
                    }
                    b(i7);
                    this.c -= i6;
                    if (b.w > 0) {
                        System.arraycopy(this.a, i5, this.a, i5, i);
                        System.arraycopy(this.b, i5, this.b, i5, i);
                    }
                    if (b.w < this.c) {
                        i5 = i + 1;
                        System.arraycopy(this.a, i5, this.a, i, i2 - i);
                        i6 = this.c - i;
                        System.arraycopy(this.b, i5, this.b, i, i6);
                    }
                } else {
                    this.c -= i6;
                    if (b.w < this.c) {
                        int i8 = i + 1;
                        System.arraycopy(this.a, i8, this.a, i, i4 - i);
                        i5 = this.c - i;
                        System.arraycopy(this.b, i8, this.b, i, i5);
                    }
                    this.b[this.c] = null;
                }
            }
        }
        return objArr[i];
    }

    public E p(int i) {
        return this.b[i];
    }

    @Override // java.util.Collection
    public boolean remove(Object object) {
        int indexOf = indexOf(object);
        if (indexOf >= 0) {
            m(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        final Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            z = z | remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        int i;
        boolean z = false;
        final int i2 = 1;
        i = this.c - i2;
        int i4 = 0;
        while (i >= 0) {
            i = i - 1;
        }
        return z;
    }

    @Override // java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        final Object[] arr = new Object[i];
        final int i2 = 0;
        System.arraycopy(this.b, i2, arr, i2, this.c);
        return arr;
    }

    @Override // java.lang.Object
    public String toString() {
        int i = 0;
        Object obj;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.c * 14);
        stringBuilder.append('{');
        i = 0;
        while (i < this.c) {
            obj = p(i);
            i = i + 1;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public b(int i) {
        super();
        if (i == 0) {
            this.a = b.w;
            this.b = b.x;
        } else {
            b(i);
        }
        this.c = 0;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Object array;
        length = tArr.length;
        if (tArr.length < this.c) {
            array = Array.newInstance(tArr.getClass().getComponentType(), this.c);
        }
        final int i4 = 0;
        System.arraycopy(this.b, i4, array, i4, this.c);
        length2 = array.length;
        if (array.length > this.c) {
            array[this.c] = null;
        }
        return array;
    }
}
