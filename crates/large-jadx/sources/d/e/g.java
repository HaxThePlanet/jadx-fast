package d.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap.java */
/* loaded from: classes.dex */
public class g<K, V> {

    static Object[] v;
    static int w;
    static Object[] x;
    static int y;
    int[] a;
    Object[] b;
    int c;
    public g() {
        super();
        this.a = c.a;
        this.b = c.c;
        this.c = 0;
    }

    private void a(int i) {
        Class<d.e.g> obj2 = g.class;
        final Object obj3 = null;
        final int i3 = 0;
        final int i4 = 1;
        if (i == 8) {
            synchronized (obj2) {
                try {
                    Object[] objArr2 = g.x;
                    if (g.x != null) {
                        this.b = g.x;
                        g.x = (Object[])g.x[i3];
                        this.a = (int[])objArr2[i4];
                        objArr2[i4] = obj3;
                        objArr2[i3] = obj3;
                        g.y -= i4;
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
        } else {
            int i2 = 4;
            if (g.y == 4) {
                synchronized (obj2) {
                    try {
                        Object[] objArr = g.v;
                        if (g.v != null) {
                            this.b = g.v;
                            g.v = (Object[])g.v[i3];
                            this.a = (int[])objArr[i4];
                            objArr[i4] = obj3;
                            objArr[i3] = obj3;
                            g.w -= i4;
                            return;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
        this.a = new int[th];
        this.b = new Object[th << i4];
    }

    private static int c(int[] iArr, int i, int i2) {
        try {
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            iArr = new ConcurrentModificationException();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) iArr;
        }
        return c.a(iArr, i, i2);
    }

    private static void e(int[] iArr, Object[] objectArr, int i) {
        int length;
        int i4;
        int i2;
        int i5;
        final Class<d.e.g> obj2 = g.class;
        final Object[] objArr3 = null;
        final int i6 = 2;
        final int i7 = 0;
        final int i8 = 10;
        final int i9 = 1;
        i = 8;
        if (iArr.length == 8) {
            synchronized (obj2) {
                try {
                    if (g.y < i8) {
                        objectArr[i7] = g.x;
                        objectArr[i9] = iArr;
                        i4 = (i << 1) - i9;
                        while (i4 >= i6) {
                            objectArr[i4] = objArr3;
                            i4 = i4 - 1;
                        }
                        g.x = objectArr;
                        g.y += i9;
                    }
                } catch (Throwable unused) {
                }
            }
        } else {
            length = iArr.length;
            i = 4;
            if (iArr.length == 4) {
                synchronized (obj2) {
                    try {
                        if (g.w < i8) {
                            objectArr[i7] = g.v;
                            objectArr[i9] = iArr;
                            i5 = (i << 1) - i9;
                            while (g.y >= i6) {
                                objectArr[i5] = objArr3;
                                i5 = i5 - 1;
                            }
                            g.v = objectArr;
                            g.w += i9;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public void clear() {
        if (this.c > 0) {
            this.a = c.a;
            this.b = c.c;
            int i = 0;
            this.c = i;
            g.e(this.a, this.b, this.c);
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object object) {
        boolean z = true;
        object = g(object) >= 0 ? 1 : 0;
        return (g(object) >= 0 ? 1 : 0);
    }

    public boolean containsValue(Object object) {
        boolean z = true;
        object = i(object) >= 0 ? 1 : 0;
        return (i(object) >= 0 ? 1 : 0);
    }

    public void d(int i) {
        int i2 = 0;
        int i3;
        int i4;
        length = iArr.length;
        if (iArr.length < i) {
            a(i);
            if (this.c > 0) {
                i2 = 0;
                System.arraycopy(this.a, i2, this.a, i2, this.c);
                i3 = i5 << 1;
                System.arraycopy(this.b, i2, this.b, i2, i3);
            }
            g.e(this.a, this.b, this.c);
        }
        if (this.c != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object object) {
        int i;
        int size;
        int size2;
        final boolean z = true;
        if (this == object) {
            return true;
        }
        i = 0;
        if (object instanceof g) {
            if (size() != object.size()) {
                return false;
            }
            while (i < this.c) {
                Object obj = j(i);
                Object obj3 = n(i);
                Object obj5 = object.get(obj);
                if (!obj3.equals(obj5)) {
                    return false;
                }
                if (obj5 == null && !object.containsKey(this.c)) {
                    return false;
                }
            }
            return true;
        }
        if (object instanceof Map) {
            if (size() != object.size()) {
                return false;
            }
            while (i < this.c) {
                Object obj2 = j(i);
                Object obj4 = n(i);
                Object value = object.get(obj2);
                if (!obj4.equals(value)) {
                    return false;
                }
                if (value == null && !object.containsKey(this.c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    int f(Object object, int i) {
        int i3;
        int i4;
        int i5;
        if (this.c == 0) {
            return -1;
        }
        int i7 = g.c(this.a, this.c, i);
        if (i7 < 0) {
            return i7;
        }
        i5 = i7 << 1;
        if (object.equals(this.b[i5])) {
            return i7;
        }
        i4 = i7 + 1;
        while (this.b < this.c) {
            i6 = i4 << 1;
            if (object.equals(this.b[i6])) {
                return i4;
            }
        }
        i3 = i7 - 1;
        while (this.a >= 0) {
            i5 = i3 << 1;
            if (object.equals(this.b[i5])) {
                return i3;
            }
        }
        return ~i4;
    }

    public int g(Object object) {
        int i2;
        if (object == null) {
            i2 = h();
        } else {
            i2 = f(object, object.hashCode());
        }
        return i2;
    }

    public V get(Object object) {
        return getOrDefault(object, null);
    }

    public V getOrDefault(Object object, V v) {
        Object obj;
        int i = g(object);
        if (i >= 0) {
            i = (i << 1) + 1;
            obj = this.b[i];
        }
        return obj;
    }

    int h() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.c == 0) {
            return -1;
        }
        int i8 = g.c(this.a, this.c, 0);
        if (i8 < 0) {
            return i8;
        }
        i4 = i8 << 1;
        if (this.b[i4] == null) {
            return i8;
        }
        i3 = i8 + 1;
        while (this.b < this.c) {
            i5 = i3 << 1;
            if (this.b[i5] == 0) {
                return i3;
            }
        }
        i2 = i8 - 1;
        while (this.a >= 0) {
            i4 = i2 << 1;
            if (this.b[i4] == 0) {
                return i2;
            }
        }
        return ~i3;
    }

    public int hashCode() {
        int i = 1;
        int i2;
        i = 1;
        i2 = 0;
        while (i2 < this.c) {
            Object obj = this.b[i];
            i3 = i2 ^ this.a[i2];
            i2 = i2 + i3;
            i2 = i2 + 1;
            i = i + 2;
        }
        return i2;
    }

    int i(Object object) {
        int i;
        boolean equals;
        int i3 = this.c * 2;
        i = 1;
        if (object == null) {
            while (i < this.c) {
                if (objArr[i] == null) {
                    return i >> i;
                }
            }
        } else {
            while (i < this.c) {
                if (object.equals(objArr[i])) {
                    return i >> 1;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        boolean z = true;
        int r0 = this.c <= 0 ? 1 : 0;
        return (this.c <= 0 ? 1 : 0);
    }

    public K j(int i) {
        return this.b[i << 1];
    }

    public void k(g<? extends K, ? extends V> gVar) {
        int i;
        int i2 = 0;
        Object obj;
        d(this.c + i3);
        i2 = 0;
        if (this.c != 0) {
            while (i2 < gVar.c) {
                put(gVar.j(i2), gVar.n(i2));
                i2 = i2 + 1;
            }
        } else {
            if (gVar.c > 0) {
                System.arraycopy(gVar.a, i2, this.a, i2, gVar.c);
                System.arraycopy(gVar.b, i2, this.b, i2, i3 << 1);
                this.c = gVar.c;
            }
        }
    }

    public V l(int i) {
        Object[] objArr;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        int length;
        int i5 = 8;
        int i6;
        i2 = i << 1;
        i3 = 0;
        i4 = 1;
        if (this.c > i4) {
            i3 = i12 - 1;
            length = iArr.length;
            i5 = 8;
            if (iArr.length > i5 && this.c < iArr.length / 3 && this.c > i5) {
                length = i12 >> 1;
                i5 = i12 + length;
                a(i5);
                if (this.c != this.c) {
                    throw new ConcurrentModificationException();
                } else {
                    if (i > 0) {
                        System.arraycopy(this.a, i3, this.a, i3, i);
                        System.arraycopy(this.b, i3, this.b, i3, i2);
                    }
                    if (i < i3) {
                        int i13 = i + 1;
                        i5 = i3 - i;
                        System.arraycopy(this.a, i13, this.a, i, i5);
                        i6 = i13 << 1;
                        i4 = i5 << 1;
                        System.arraycopy(this.b, i6, this.b, i2, i4);
                    }
                }
            }
            if (i < i3) {
                int i9 = i + 1;
                int i14 = i3 - i;
                System.arraycopy(this.a, i9, this.a, i, i14);
                i3 = i14 << i4;
                System.arraycopy(this.b, i9 << i4, this.b, i2, i3);
            }
            int i7 = i3 << 1;
            Object obj = null;
            this.b[i7] = obj;
            this.b[i7 + i4] = obj;
        } else {
            g.e(this.a, this.b, this.c);
            this.a = c.a;
            this.b = c.c;
        }
        if (this.c != this.c) {
            throw new ConcurrentModificationException();
        } else {
            this.c = i3;
            return objArr[i2 + 1];
        }
    }

    public V m(int i, V v) {
        int i3 = (i << 1) + 1;
        this.b[i3] = v;
        return objArr[i3];
    }

    public V n(int i) {
        return this.b[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i3;
        int i2;
        int[] iArr;
        int i4 = 4;
        int[] iArr2;
        int length;
        Object[] objArr;
        int length2;
        i2 = 0;
        if (k == null) {
            i3 = h();
        } else {
            i2 = k.hashCode();
        }
        if (i3 >= 0) {
            int i19 = (i3 << 1) + 1;
            this.b[i19] = v;
            return objArr2[i19];
        }
        int i7 = ~i3;
        length = iArr.length;
        if (this.c >= iArr.length) {
            i4 = 4;
            i4 = 8;
            if (this.c >= i4) {
                i4 = (i >> 1) + i;
            } else {
                if (this.c >= 4) {
                }
            }
            a(i4);
            if (this.c != this.c) {
                throw new ConcurrentModificationException();
            } else {
                length2 = iArr2.length;
                if (iArr2.length > 0) {
                    System.arraycopy(this.a, i2, this.a, i2, iArr.length);
                    length2 = objArr.length;
                    System.arraycopy(this.b, i2, this.b, i2, length2);
                }
                g.e(this.a, this.b, this.c);
            }
        }
        if (i7 < this.c) {
            int i10 = i7 + 1;
            System.arraycopy(this.a, i7, this.a, i10, i - i7);
            length = i7 << 1;
            System.arraycopy(this.b, length, this.b, i10 << 1, (this.c - i7) << 1);
        }
        if (this.c != this.c) {
            throw new ConcurrentModificationException();
        } else {
            if (i7 < iArr3.length) {
                this.a[i7] = i2;
                i7 <<= 1;
                this.b[i8] = k;
                this.b[i8 + 1] = v;
                this.c++;
                return null;
            }
        }
    }

    public V putIfAbsent(K k, V v) {
        Object obj;
        if (get(k) == null) {
            obj = put(k, v);
        }
        return obj;
    }

    public V remove(Object object) {
        int i = g(object);
        if (i >= 0) {
            return l(i);
        }
        return null;
    }

    public V replace(K k, V v) {
        int i = g(k);
        if (i >= 0) {
            return m(i, v);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        int i = 0;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.c * 28);
        stringBuilder.append('{');
        i = 0;
        while (i < this.c) {
            Object obj2 = j(i);
            str = "(this Map)";
            stringBuilder.append('=');
            Object obj = n(i);
            i = i + 1;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean remove(Object object, Object object2) {
        int i = g(object);
        if (i >= 0 && object2 != obj && object2 != null && object2.equals(obj)) {
            l(i);
            return true;
        }
        return false;
    }

    public boolean replace(K k, V v, V v2) {
        int i = g(k);
        if (i >= 0 && obj != v && v != null && v.equals(obj)) {
            m(i, v2);
            return true;
        }
        return false;
    }

    public g(int i) {
        super();
        if (i == 0) {
            this.a = c.a;
            this.b = c.c;
        } else {
            a(i);
        }
        this.c = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            k(gVar);
        }
    }
}
