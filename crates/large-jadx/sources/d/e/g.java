package d.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g<K, V>  {

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

    public g(int i) {
        Object[] obj1;
        super();
        if (i == 0) {
            this.a = c.a;
            this.b = c.c;
        } else {
            a(i);
        }
        this.c = 0;
    }

    public g(d.e.g<K, V> g) {
        super();
        if (g != null) {
            k(g);
        }
    }

    private void a(int i) {
        int i2;
        Class<d.e.g> obj = g.class;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 1;
        if (i == 8) {
            i2 = g.x;
            synchronized (obj) {
                this.b = i2;
                g.x = (Object[])i2[i4];
                this.a = (int[])i2[i5];
                i2[i5] = i3;
                i2[i4] = i3;
                g.y = obj6 -= i5;
            }
        } else {
            i2 = g.v;
            if (i == 4 && i2 != null) {
                i2 = g.v;
                synchronized (obj) {
                    this.b = i2;
                    g.v = (Object[])i2[i4];
                    this.a = (int[])i2[i5];
                    i2[i5] = i3;
                    i2[i4] = i3;
                    g.w = obj6 -= i5;
                }
            }
        }
        try {
            this.a = new int[i];
            this.b = new Object[i <<= i5];
        } catch (Throwable th) {
        }
    }

    private static int c(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
            iArr = new ConcurrentModificationException();
            throw iArr;
        }
    }

    private static void e(int[] iArr, Object[] object2Arr2, int i3) {
        int length;
        int i;
        Object[] obj8;
        final Class<d.e.g> obj = g.class;
        final int i2 = 0;
        final int i4 = 2;
        final int i5 = 0;
        final int i6 = 10;
        final int i7 = 1;
        if (iArr.length == 8) {
            synchronized (obj) {
                object2Arr2[i5] = g.x;
                object2Arr2[i7] = iArr;
                obj8 -= i7;
                while (obj8 >= i4) {
                    object2Arr2[obj8] = i2;
                    obj8--;
                }
                g.x = object2Arr2;
                g.y = obj8 += i7;
            }
        } else {
            if (iArr.length == 4 && g.w < i6) {
                synchronized (obj) {
                    object2Arr2[i5] = g.v;
                    object2Arr2[i7] = iArr;
                    obj8 -= i7;
                    while (obj8 >= i4) {
                        object2Arr2[obj8] = i2;
                        obj8--;
                    }
                    g.v = object2Arr2;
                    g.w = obj8 += i7;
                    try {
                        throw iArr;
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public void clear() {
        int[] iArr;
        Object[] objArr;
        int i;
        int i2 = this.c;
        if (i2 > 0) {
            this.a = c.a;
            this.b = c.c;
            this.c = 0;
            g.e(this.a, this.b, i2);
        }
        if (this.c > 0) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean containsKey(Object object) {
        int obj1;
        obj1 = g(object) >= 0 ? 1 : 0;
        return obj1;
    }

    public boolean containsValue(Object object) {
        int obj1;
        obj1 = i(object) >= 0 ? 1 : 0;
        return obj1;
    }

    public void d(int i) {
        int length;
        int i3;
        int i2;
        int obj6;
        final int i4 = this.c;
        final int[] iArr = this.a;
        length = this.b;
        a(i);
        if (iArr.length < i && this.c > 0) {
            length = this.b;
            a(i);
            if (this.c > 0) {
                i3 = 0;
                System.arraycopy(iArr, i3, this.a, i3, i4);
                System.arraycopy(length, i3, this.b, i3, i4 << 1);
            }
            g.e(iArr, length, i4);
        }
        if (this.c != i4) {
        } else {
        }
        obj6 = new ConcurrentModificationException();
        throw obj6;
    }

    public boolean equals(Object object) {
        int i2;
        int i;
        int equals2;
        int equals;
        Object obj;
        Object obj2;
        final int i3 = 1;
        if (this == object) {
            return i3;
        }
        final int i4 = 0;
        if (object instanceof g && size() != (g)object.size()) {
            if (size() != (g)object.size()) {
                return i4;
            }
            i2 = i4;
            while (i2 < this.c) {
                equals2 = j(i2);
                obj = n(i2);
                obj2 = object.get(equals2);
                i2++;
            }
            return i3;
        }
        if (object instanceof Map != null && size() != (Map)object.size()) {
            if (size() != (Map)object.size()) {
                return i4;
            }
            i = i4;
            while (i < this.c) {
                equals = j(i);
                obj = n(i);
                obj2 = object.get(equals);
                i++;
            }
            return i3;
        }
        return i4;
    }

    int f(Object object, int i2) {
        int equals;
        int i;
        int i3;
        int equals2;
        int i4;
        equals = this.c;
        if (equals == 0) {
            return -1;
        }
        int i5 = g.c(this.a, equals, i2);
        if (i5 < 0) {
            return i5;
        }
        if (object.equals(this.b[i5 << 1])) {
            return i5;
        }
        i3 = i5 + 1;
        while (i3 < equals) {
            i3++;
        }
        i5--;
        while (i >= 0) {
            i--;
        }
        return ~i3;
    }

    public int g(Object object) {
        int i;
        int obj2;
        if (object == null) {
            obj2 = h();
        } else {
            obj2 = f(object, object.hashCode());
        }
        return obj2;
    }

    public V get(Object object) {
        return getOrDefault(object, 0);
    }

    public V getOrDefault(Object object, V v2) {
        int obj1;
        Object obj2;
        obj1 = g(object);
        if (obj1 >= 0) {
            obj2 = this.b[obj1++];
        }
        return obj2;
    }

    int h() {
        int i2;
        int i4;
        int i;
        int i5;
        int i3;
        i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int i8 = g.c(this.a, i2, 0);
        if (i8 < 0) {
            return i8;
        }
        if (this.b[i8 << 1] == null) {
            return i8;
        }
        i = i8 + 1;
        while (i < i2) {
            i++;
        }
        i8--;
        while (i4 >= 0) {
            i4--;
        }
        return ~i;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i;
        int i3;
        int i2;
        int i6;
        i4 = 1;
        final int i8 = 0;
        i = i5;
        while (i5 < this.c) {
            Object obj = this.b[i4];
            if (obj == null) {
            } else {
            }
            i2 = obj.hashCode();
            i += i3;
            i5++;
            i4 += 2;
            i2 = i8;
        }
        return i;
    }

    int i(Object object) {
        int i;
        boolean equals;
        int obj6;
        i2 *= 2;
        final Object[] objArr = this.b;
        final int i4 = 1;
        if (object == null) {
            obj6 = i4;
            while (obj6 < i3) {
                obj6 += 2;
            }
        } else {
            i = i4;
            while (i < i3) {
                i += 2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        int i;
        i = this.c <= 0 ? 1 : 0;
        return i;
    }

    public K j(int i) {
        return this.b[i <<= 1];
    }

    public void k(d.e.g<? extends K, ? extends V> g) {
        int i;
        int i2;
        Object obj;
        Object obj5;
        final int i3 = g.c;
        d(i4 += i3);
        i2 = 0;
        if (this.c == 0 && i3 > 0) {
            if (i3 > 0) {
                System.arraycopy(g.a, i2, this.a, i2, i3);
                System.arraycopy(g.b, i2, this.b, i2, i3 << 1);
                this.c = i3;
            }
        }
    }

    public V l(int i) {
        Object[] objArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr;
        int length;
        int i6;
        int obj11;
        objArr = this.b;
        i2 = i << 1;
        final int i10 = this.c;
        i3 = 0;
        i4 = 1;
        if (i10 <= i4) {
            g.e(this.a, objArr, i10);
            this.a = c.a;
            this.b = c.c;
        } else {
            i5 = i10 + -1;
            iArr = this.a;
            i6 = 8;
            if (iArr.length > i6 && i10 < length2 /= 3 && i10 > i6) {
                if (i10 < length2 /= 3) {
                    if (i10 > i6) {
                        i6 = i10 + length;
                    }
                    a(i6);
                    if (i10 != this.c) {
                    } else {
                        if (i > 0) {
                            System.arraycopy(iArr, i3, this.a, i3, i);
                            System.arraycopy(objArr, i3, this.b, i3, i2);
                        }
                        if (i < i5) {
                            int i11 = i + 1;
                            i6 = i5 - i;
                            System.arraycopy(iArr, i11, this.a, i, i6);
                            System.arraycopy(objArr, i11 << 1, this.b, i2, i6 << 1);
                        }
                        i3 = i5;
                    }
                    obj11 = new ConcurrentModificationException();
                    throw obj11;
                }
            }
            if (i < i5) {
                int i8 = i + 1;
                int i12 = i5 - i;
                System.arraycopy(iArr, i8, iArr, i, i12);
                obj11 = this.b;
                System.arraycopy(obj11, i8 <<= i4, obj11, i2, i12 <<= i4);
            }
            obj11 = this.b;
            int i7 = i5 << 1;
            i2 = 0;
            obj11[i7] = i2;
            obj11[i7 += i4] = i2;
        }
        if (i10 != this.c) {
        } else {
            this.c = i3;
            return objArr[i2 + 1];
        }
        obj11 = new ConcurrentModificationException();
        throw obj11;
    }

    public V m(int i, V v2) {
        obj3++;
        final Object[] objArr = this.b;
        objArr[obj3] = v2;
        return objArr[obj3];
    }

    public V n(int i) {
        return this.b[obj2++];
    }

    public V put(K k, V v2) {
        int i4;
        int i5;
        int i;
        int i2;
        int[] length;
        int i3;
        int[] length2;
        Object[] objArr;
        int length3;
        int i6;
        i4 = this.c;
        i5 = 0;
        if (k == null) {
            i = h();
            i2 = i5;
        } else {
            int i12 = k.hashCode();
            i2 = i12;
            i = i6;
        }
        if (i >= 0) {
            obj10++;
            Object[] objArr2 = this.b;
            objArr2[obj10] = v2;
            return objArr2[obj10];
        }
        int i9 = ~i;
        length = this.a;
        if (i4 >= length.length) {
            int i18 = 8;
            if (i4 >= i18) {
                i15 += i4;
            } else {
                if (i4 >= 4) {
                    i3 = i18;
                }
            }
            objArr = this.b;
            a(i3);
            if (i4 != this.c) {
            } else {
                length2 = this.a;
                if (length2.length > 0) {
                    System.arraycopy(length, i5, length2, i5, length.length);
                    System.arraycopy(objArr, i5, this.b, i5, objArr.length);
                }
                g.e(length, objArr, i4);
            }
            ConcurrentModificationException obj10 = new ConcurrentModificationException();
            throw obj10;
        }
        if (i9 < i4) {
            int[] iArr = this.a;
            int i14 = i9 + 1;
            System.arraycopy(iArr, i9, iArr, i14, i4 - i9);
            i5 = this.b;
            System.arraycopy(i5, i9 << 1, i5, i14 <<= 1, i20 <<= 1);
        }
        int i7 = this.c;
        if (i4 != i7) {
        } else {
            i4 = this.a;
            if (i9 >= i4.length) {
            } else {
                i4[i9] = i2;
                Object[] objArr3 = this.b;
                i9 <<= 1;
                objArr3[i10] = k;
                objArr3[i10++] = v2;
                this.c = i7++;
                return 0;
            }
        }
        obj10 = new ConcurrentModificationException();
        throw obj10;
    }

    public V putIfAbsent(K k, V v2) {
        Object obj;
        if (get(k) == null) {
            obj = put(k, v2);
        }
        return obj;
    }

    public V remove(Object object) {
        int obj1 = g(object);
        if (obj1 >= 0) {
            return l(obj1);
        }
        return 0;
    }

    public boolean remove(Object object, Object object2) {
        Object obj;
        Object obj3;
        int obj2 = g(object);
        obj = n(obj2);
        if (obj2 >= 0 && object2 != obj && object2 != null && object2.equals(obj)) {
            obj = n(obj2);
            if (object2 != obj) {
                if (object2 != null) {
                    if (object2.equals(obj)) {
                    }
                }
            }
            l(obj2);
            return 1;
        }
        return 0;
    }

    public V replace(K k, V v2) {
        int obj1 = g(k);
        if (obj1 >= 0) {
            return m(obj1, v2);
        }
        return 0;
    }

    public boolean replace(K k, V v2, V v3) {
        Object obj;
        Object obj3;
        int obj2 = g(k);
        obj = n(obj2);
        if (obj2 >= 0 && obj != v2 && v2 != null && v2.equals(obj)) {
            obj = n(obj2);
            if (obj != v2) {
                if (v2 != null) {
                    if (v2.equals(obj)) {
                    }
                }
            }
            m(obj2, v3);
            return 1;
        }
        return 0;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        int i;
        Object obj;
        int str2;
        String str;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(i2 *= 28);
        stringBuilder.append('{');
        i = 0;
        while (i < this.c) {
            if (i > 0) {
            }
            Object obj2 = j(i);
            str = "(this Map)";
            if (obj2 != this) {
            } else {
            }
            stringBuilder.append(str);
            stringBuilder.append('=');
            obj = n(i);
            if (obj != this) {
            } else {
            }
            stringBuilder.append(str);
            i++;
            stringBuilder.append(obj);
            stringBuilder.append(obj2);
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
