package d.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E>  implements Collection<E>, Set<E> {

    private static Object[] A;
    private static int B;
    private static final int[] w;
    private static final Object[] x;
    private static Object[] y;
    private static int z;
    private int[] a;
    Object[] b;
    int c;
    private d.e.f<E, E> v;

    class a extends d.e.f<E, E> {

        final d.e.b d;
        a(d.e.b b) {
            this.d = b;
            super();
        }

        @Override // d.e.f
        protected void a() {
            this.d.clear();
        }

        @Override // d.e.f
        protected Object b(int i, int i2) {
            return obj2.b[i];
        }

        protected Map<E, E> c() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("not a map");
            throw unsupportedOperationException;
        }

        @Override // d.e.f
        protected int d() {
            return bVar.c;
        }

        @Override // d.e.f
        protected int e(Object object) {
            return this.d.indexOf(object);
        }

        @Override // d.e.f
        protected int f(Object object) {
            return this.d.indexOf(object);
        }

        protected void g(E e, E e2) {
            this.d.add(e);
        }

        @Override // d.e.f
        protected void h(int i) {
            this.d.m(i);
        }

        protected E i(int i, E e2) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException("not a map");
            throw obj1;
        }
    }
    static {
        int i = 0;
        b.w = new int[i];
        b.x = new Object[i];
    }

    public b() {
        super(0);
    }

    public b(int i) {
        Object[] obj1;
        super();
        if (i == 0) {
            this.a = b.w;
            this.b = b.x;
        } else {
            b(i);
        }
        this.c = 0;
    }

    private void b(int i) {
        int i2;
        Object[] objArr;
        int i3 = 0;
        final int i4 = 0;
        final int i5 = 1;
        if (i == 8) {
            i2 = b.class;
            objArr = b.A;
            synchronized (i2) {
                this.b = objArr;
                b.A = (Object[])objArr[i4];
                this.a = (int[])objArr[i5];
                objArr[i5] = i3;
                objArr[i4] = i3;
                b.B = obj6 -= i5;
            }
        } else {
            i2 = b.class;
            objArr = b.y;
            if (i == 4 && objArr != null) {
                i2 = b.class;
                objArr = b.y;
                synchronized (i2) {
                    this.b = objArr;
                    b.y = (Object[])objArr[i4];
                    this.a = (int[])objArr[i5];
                    objArr[i5] = i3;
                    objArr[i4] = i3;
                    b.z = obj6 -= i5;
                }
            }
        }
        try {
            this.a = new int[i];
            this.b = new Object[i];
        } catch (Throwable th) {
        }
    }

    private static void g(int[] iArr, Object[] object2Arr2, int i3) {
        Class<d.e.b> length;
        int i2;
        int i;
        Object[] obj7;
        int obj9;
        final int i4 = 0;
        final int i5 = 2;
        final int i6 = 0;
        i2 = 10;
        final int i7 = 1;
        if (iArr.length == 8) {
            length = b.class;
            synchronized (length) {
                object2Arr2[i6] = b.A;
                object2Arr2[i7] = iArr;
                i3 -= i7;
                while (obj9 >= i5) {
                    object2Arr2[obj9] = i4;
                    obj9--;
                }
                b.A = object2Arr2;
                b.B = obj7 += i7;
            }
        } else {
            length = b.class;
            if (iArr.length == 4 && b.z < i2) {
                length = b.class;
                synchronized (length) {
                    object2Arr2[i6] = b.y;
                    object2Arr2[i7] = iArr;
                    i3 -= i7;
                    while (obj9 >= i5) {
                        object2Arr2[obj9] = i4;
                        obj9--;
                    }
                    b.y = object2Arr2;
                    b.z = obj7 += i7;
                    try {
                        throw iArr;
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    private d.e.f<E, E> h() {
        d.e.f aVar;
        if (this.v == null) {
            aVar = new b.a(this);
            this.v = aVar;
        }
        return this.v;
    }

    private int i(Object object, int i2) {
        int equals;
        int i;
        int i3;
        boolean equals2;
        equals = this.c;
        if (equals == 0) {
            return -1;
        }
        int i4 = c.a(this.a, equals, i2);
        if (i4 < 0) {
            return i4;
        }
        if (object.equals(this.b[i4])) {
            return i4;
        }
        i3 = i4 + 1;
        while (i3 < equals) {
            i3++;
        }
        i4--;
        while (i >= 0) {
            i--;
        }
        return ~i3;
    }

    private int l() {
        int i2;
        int i3;
        int i;
        Object obj;
        i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int i6 = c.a(this.a, i2, 0);
        if (i6 < 0) {
            return i6;
        }
        if (this.b[i6] == null) {
            return i6;
        }
        i = i6 + 1;
        while (i < i2) {
            i++;
        }
        i6--;
        while (i3 >= 0) {
            i3--;
        }
        return ~i;
    }

    public boolean add(E e) {
        int i4;
        int i2;
        int i7;
        int i6;
        int i5;
        int[] iArr;
        int i3;
        int[] length2;
        int length;
        int i;
        i4 = 0;
        if (e == null) {
            i7 = l();
            i6 = i4;
        } else {
            int i11 = e.hashCode();
            i6 = i11;
            i7 = i;
        }
        if (i7 >= 0) {
            return i4;
        }
        int i10 = ~i7;
        i5 = this.c;
        iArr = this.a;
        if (i5 >= iArr.length) {
            int i15 = 8;
            if (i5 >= i15) {
                i14 += i5;
            } else {
                if (i5 >= 4) {
                    i3 = i15;
                }
            }
            i5 = this.b;
            b(i3);
            length2 = this.a;
            if (length2.length > 0) {
                System.arraycopy(iArr, i4, length2, i4, iArr.length);
                System.arraycopy(i5, i4, this.b, i4, i5.length);
            }
            b.g(iArr, i5, this.c);
        }
        i2 = this.c;
        if (i10 < i2) {
            int[] iArr3 = this.a;
            iArr = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, iArr, i2 -= i10);
            i2 = this.b;
            System.arraycopy(i2, i10, i2, iArr, i13 -= i10);
        }
        this.a[i10] = i6;
        this.b[i10] = e;
        int i9 = 1;
        this.c = obj9 += i9;
        return i9;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int i;
        int size;
        d(i2 += size);
        final Iterator obj3 = collection.iterator();
        i = 0;
        for (Object next2 : obj3) {
            i |= size;
        }
        return i;
    }

    @Override // java.util.Collection
    public void clear() {
        int i;
        int[] iArr;
        Object[] objArr;
        i = this.c;
        if (i != 0) {
            b.g(this.a, this.b, i);
            this.a = b.w;
            this.b = b.x;
            this.c = 0;
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object object) {
        int obj1;
        obj1 = indexOf(object) >= 0 ? 1 : 0;
        return obj1;
    }

    public boolean containsAll(Collection<?> collection) {
        boolean contains;
        Iterator obj2 = collection.iterator();
        for (Object next2 : obj2) {
        }
        return 1;
    }

    @Override // java.util.Collection
    public void d(int i) {
        int length;
        int i2;
        int i3;
        int obj5;
        final int[] iArr = this.a;
        length = this.b;
        b(i);
        obj5 = this.c;
        if (iArr.length < i && obj5 > 0) {
            length = this.b;
            b(i);
            obj5 = this.c;
            if (obj5 > 0) {
                i3 = 0;
                System.arraycopy(iArr, i3, this.a, i3, obj5);
                System.arraycopy(length, i3, this.b, i3, this.c);
            }
            b.g(iArr, length, this.c);
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object object) {
        int i;
        int contains;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        final int i3 = 0;
        if (object instanceof Set != null && size() != (Set)object.size()) {
            if (size() != (Set)object.size()) {
                return i3;
            }
            i = i3;
            while (i < this.c) {
                i++;
            }
            return i2;
        }
        return i3;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int i2;
        int i3;
        int i;
        i3 = i2;
        while (i2 < this.c) {
            i3 += i;
            i2++;
        }
        return i3;
    }

    @Override // java.util.Collection
    public int indexOf(Object object) {
        int i;
        int obj2;
        if (object == null) {
            obj2 = l();
        } else {
            obj2 = i(object, object.hashCode());
        }
        return obj2;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        int i;
        i = this.c <= 0 ? 1 : 0;
        return i;
    }

    public Iterator<E> iterator() {
        return h().m().iterator();
    }

    public E m(int i) {
        Object[] objArr;
        int i3;
        int i2;
        int i7;
        int i4;
        int i6;
        int[] iArr;
        int length;
        int i5;
        int obj9;
        objArr = this.b;
        i7 = this.c;
        i4 = 0;
        i6 = 1;
        if (i7 <= i6) {
            b.g(this.a, objArr, i7);
            this.a = b.w;
            this.b = b.x;
            this.c = i4;
        } else {
            iArr = this.a;
            i5 = 8;
            if (iArr.length > i5 && i7 < length2 /= 3) {
                if (i7 < length2 /= 3) {
                    if (i7 > i5) {
                        i5 = i7 + length;
                    }
                    b(i5);
                    this.c = i8 -= i6;
                    if (i > 0) {
                        System.arraycopy(iArr, i4, this.a, i4, i);
                        System.arraycopy(objArr, i4, this.b, i4, i);
                    }
                    i7 = this.c;
                    if (i < i7) {
                        i4 = i + 1;
                        System.arraycopy(iArr, i4, this.a, i, i7 -= i);
                        System.arraycopy(objArr, i4, this.b, i, i12 -= i);
                    }
                } else {
                    i7 -= i6;
                    this.c = i2;
                    if (i < i2) {
                        objArr = i + 1;
                        System.arraycopy(iArr, objArr, iArr, i, i2 -= i);
                        i2 = this.b;
                        System.arraycopy(i2, objArr, i2, i, i11 -= i);
                    }
                    this.b[this.c] = 0;
                }
            } else {
            }
        }
        return objArr[i];
    }

    public E p(int i) {
        return this.b[i];
    }

    @Override // java.util.Collection
    public boolean remove(Object object) {
        int obj1 = indexOf(object);
        if (obj1 >= 0) {
            m(obj1);
            return 1;
        }
        return 0;
    }

    public boolean removeAll(Collection<?> collection) {
        int i;
        boolean remove;
        final Iterator obj3 = collection.iterator();
        i = 0;
        for (Object next2 : obj3) {
            i |= remove;
        }
        return i;
    }

    public boolean retainAll(Collection<?> collection) {
        int i2;
        int i;
        boolean contains;
        final int i4 = 1;
        i3 -= i4;
        i = 0;
        while (i2 >= 0) {
            if (!collection.contains(this.b[i2])) {
            }
            i2--;
            m(i2);
            i = i4;
        }
        return i;
    }

    @Override // java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        final int i = this.c;
        final Object[] arr = new Object[i];
        final int i2 = 0;
        System.arraycopy(this.b, i2, arr, i2, i);
        return arr;
    }

    public <T> T[] toArray(T[] tArr) {
        int length;
        int length2;
        Object obj4;
        if (tArr.length < this.c) {
            obj4 = Array.newInstance(tArr.getClass().getComponentType(), this.c);
        }
        final int i4 = 0;
        System.arraycopy(this.b, i4, obj4, i4, this.c);
        int i3 = this.c;
        if (obj4.length > i3) {
            obj4[i3] = 0;
        }
        return obj4;
    }

    @Override // java.util.Collection
    public String toString() {
        int i;
        Object str;
        int str2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(i2 *= 14);
        stringBuilder.append('{');
        i = 0;
        while (i < this.c) {
            if (i > 0) {
            }
            str = p(i);
            if (str != this) {
            } else {
            }
            stringBuilder.append("(this Set)");
            i++;
            stringBuilder.append(str);
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
