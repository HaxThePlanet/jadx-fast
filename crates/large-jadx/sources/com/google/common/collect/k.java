package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import f.c.c.b.b;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
class k<K, V>  extends AbstractMap<K, V> implements Serializable {

    private static final Object B;
    private transient Collection<V> A;
    private transient Object a;
    transient int[] b;
    transient Object[] c;
    transient Object[] v;
    private transient int w;
    private transient int x;
    private transient Set<K> y;
    private transient Set<Map.Entry<K, V>> z;

    class d extends AbstractSet<Map.Entry<K, V>> {

        final com.google.common.collect.k a;
        d(com.google.common.collect.k k) {
            this.a = k;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            boolean i;
            int i3;
            int i2;
            Object obj4;
            Map map = this.a.r();
            if (map != null) {
                return map.entrySet().contains(object);
            }
            i3 = 0;
            i = k.e(this.a, (Map.Entry)object.getKey());
            if (object instanceof Map.Entry && i != -1 && k.a(kVar3.v[i], object.getValue())) {
                i = k.e(this.a, (Map.Entry)object.getKey());
                if (i != -1) {
                    if (k.a(kVar3.v[i], object.getValue())) {
                        i3 = 1;
                    }
                }
            }
            return i3;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return this.a.s();
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            Map map = this.a.r();
            if (map != null) {
                return map.entrySet().remove(object);
            }
            int i2 = 0;
            if (object instanceof Map.Entry && this.a.C()) {
                if (this.a.C()) {
                    return i2;
                }
                int i = k.f(this.a);
                com.google.common.collect.k obj10 = this.a;
                obj10 = l.f((Map.Entry)(Map.Entry)object.getKey(), object.getValue(), i, k.g(this.a), obj10.b, obj10.c, obj10.v);
                if (obj10 == -1) {
                    return i2;
                }
                this.a.B(obj10, i);
                k.h(this.a);
                this.a.w();
                return 1;
            }
            return i2;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.size();
        }
    }

    private abstract class e implements Iterator<T> {

        int a;
        int b;
        int c;
        final com.google.common.collect.k v;
        private e(com.google.common.collect.k k) {
            this.v = k;
            super();
            this.a = k.a(k);
            this.b = k.t();
            this.c = -1;
        }

        e(com.google.common.collect.k k, com.google.common.collect.k.a k$a2) {
            super(k);
        }

        private void b() {
            if (k.a(this.v) != this.a) {
            } else {
            }
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
            throw concurrentModificationException;
        }

        abstract T c(int i);

        @Override // java.util.Iterator
        void d() {
            this.a = i += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.b >= 0 ? 1 : 0;
            return i;
        }

        public T next() {
            b();
            if (!hasNext()) {
            } else {
                int i = this.b;
                this.c = i;
                this.b = this.v.u(this.b);
                return c(i);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i;
            b();
            i = this.c >= 0 ? 1 : 0;
            i.c(i);
            d();
            com.google.common.collect.k kVar = this.v;
            kVar.remove(kVar.c[this.c]);
            this.b = this.v.j(this.b, this.c);
            this.c = -1;
        }
    }

    class f extends AbstractSet<K> {

        final com.google.common.collect.k a;
        f(com.google.common.collect.k k) {
            this.a = k;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            return this.a.containsKey(object);
        }

        public Iterator<K> iterator() {
            return this.a.A();
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            Object keySet;
            boolean obj2;
            Map map = this.a.r();
            if (map != null) {
                obj2 = map.keySet().remove(object);
            } else {
                obj2 = k.c(this.a, object) != k.d() ? 1 : 0;
            }
            return obj2;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.size();
        }
    }

    class h extends AbstractCollection<V> {

        final com.google.common.collect.k a;
        h(com.google.common.collect.k k) {
            this.a = k;
            super();
        }

        @Override // java.util.AbstractCollection
        public void clear() {
            this.a.clear();
        }

        public Iterator<V> iterator() {
            return this.a.I();
        }

        @Override // java.util.AbstractCollection
        public int size() {
            return this.a.size();
        }
    }

    class a extends com.google.common.collect.k.e<K, V, K> {

        final com.google.common.collect.k w;
        a(com.google.common.collect.k k) {
            this.w = k;
            super(k, 0);
        }

        K c(int i) {
            return kVar.c[i];
        }
    }

    class b extends com.google.common.collect.k.e<K, V, Map.Entry<K, V>> {

        final com.google.common.collect.k w;
        b(com.google.common.collect.k k) {
            this.w = k;
            super(k, 0);
        }

        @Override // com.google.common.collect.k$e
        Object c(int i) {
            return e(i);
        }

        Map.Entry<K, V> e(int i) {
            k.g gVar = new k.g(this.w, i);
            return gVar;
        }
    }

    class c extends com.google.common.collect.k.e<K, V, V> {

        final com.google.common.collect.k w;
        c(com.google.common.collect.k k) {
            this.w = k;
            super(k, 0);
        }

        V c(int i) {
            return kVar.v[i];
        }
    }

    final class g extends com.google.common.collect.e<K, V> {

        private final K a;
        private int b;
        final com.google.common.collect.k c;
        g(com.google.common.collect.k k, int i2) {
            this.c = k;
            super();
            this.a = k.c[i2];
            this.b = i2;
        }

        private void a() {
            int i;
            int size;
            int i2;
            i = this.b;
            if (i != -1 && i < this.c.size()) {
                if (i < this.c.size()) {
                    if (!k.a(this.a, kVar3.c[this.b])) {
                        this.b = k.e(this.c, this.a);
                    }
                } else {
                }
            } else {
            }
        }

        public K getKey() {
            return this.a;
        }

        public V getValue() {
            int i2;
            int i;
            Map map = this.c.r();
            if (map != null) {
                return map.get(this.a);
            }
            a();
            int i3 = this.b;
            if (i3 == -1) {
                i2 = 0;
            } else {
                i2 = kVar2.v[i3];
            }
            return i2;
        }

        public V setValue(V v) {
            Map map = this.c.r();
            if (map != null) {
                return map.put(this.a, v);
            }
            a();
            int i = this.b;
            if (i == -1) {
                this.c.put(this.a, v);
                return 0;
            }
            Object[] objArr = kVar3.v;
            objArr[i] = v;
            return objArr[i];
        }
    }
    static {
        Object object = new Object();
        k.B = object;
    }

    k() {
        super();
        y(3);
    }

    private Object D(Object object) {
        if (C()) {
            return k.B;
        }
        final int i5 = v();
        int obj9 = l.f(object, 0, i5, this.a, this.b, this.c, 0);
        if (obj9 == -1) {
            return k.B;
        }
        B(obj9, i5);
        this.x = obj9--;
        w();
        return this.v[obj9];
    }

    private void F(int i) {
        int i2;
        int i3;
        int obj4;
        int length = iArr.length;
        i3 = 1;
        obj4 = Math.min(1073741823, i6 |= i3);
        if (i > length && obj4 != length) {
            i3 = 1;
            obj4 = Math.min(1073741823, i6 |= i3);
            if (obj4 != length) {
                E(obj4);
            }
        }
    }

    private int G(int i, int i2, int i3, int i4) {
        int i6;
        int i8;
        int i7;
        int i9;
        int i5;
        int i10;
        int i11;
        int obj11;
        int obj12;
        final Object obj = l.a(i2);
        i2--;
        if (i4 != 0) {
            l.i(obj, i3 &= obj10, i4++);
        }
        obj12 = this.b;
        i6 = 0;
        while (i6 <= i) {
            i8 = l.h(this.a, i6);
            while (i8 != 0) {
                i7 = i8 + -1;
                i9 = obj12[i7];
                i13 |= i6;
                i10 = i5 & obj10;
                l.i(obj, i10, i8);
                obj12[i7] = l.d(i5, l.h(obj, i10), obj10);
                i8 = l.c(i9, i);
            }
            i6++;
            i7 = i8 + -1;
            i9 = obj12[i7];
            i13 |= i6;
            i10 = i5 & obj10;
            l.i(obj, i10, i8);
            obj12[i7] = l.d(i5, l.h(obj, i10), obj10);
            i8 = l.c(i9, i);
        }
        this.a = obj;
        H(obj10);
        return obj10;
    }

    private void H(int i) {
        this.w = l.d(this.w, obj3 - 32, 31);
    }

    static int a(com.google.common.collect.k k) {
        return k.w;
    }

    static Object c(com.google.common.collect.k k, Object object2) {
        return k.D(object2);
    }

    static Object d() {
        return k.B;
    }

    static int e(com.google.common.collect.k k, Object object2) {
        return k.x(object2);
    }

    static int f(com.google.common.collect.k k) {
        return k.v();
    }

    static Object g(com.google.common.collect.k k) {
        return k.a;
    }

    static int h(com.google.common.collect.k k) {
        final int i = k.x;
        k.x = i + -1;
        return i;
    }

    public static <K, V> com.google.common.collect.k<K, V> m() {
        k kVar = new k();
        return kVar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int i;
        Object object2;
        Object object;
        objectInputStream.defaultReadObject();
        int int = objectInputStream.readInt();
        if (int < 0) {
        } else {
            y(int);
            i = 0;
            while (i < int) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append("Invalid size: ");
        stringBuilder.append(int);
        InvalidObjectException obj5 = new InvalidObjectException(stringBuilder.toString());
        throw obj5;
    }

    private int v() {
        final int i5 = 1;
        return i3 -= i5;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object value;
        Object key;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = s();
        for (Map.Entry next2 : it) {
            objectOutputStream.writeObject(next2.getKey());
            objectOutputStream.writeObject(next2.getValue());
        }
    }

    private int x(Object object) {
        int i;
        int i2;
        int i3;
        final int i6 = -1;
        if (C()) {
            return i6;
        }
        int i4 = s.c(object);
        final int i7 = v();
        if (l.h(this.a, i4 & i7) == 0) {
            return i6;
        }
        i--;
        i2 = this.b[i8];
        while (l.b(i2, i7) == l.b(i4, i7)) {
            i--;
            i2 = this.b[i8];
        }
        return i8;
    }

    Iterator<K> A() {
        Map map = r();
        if (map != null) {
            return map.keySet().iterator();
        }
        k.a aVar = new k.a(this);
        return aVar;
    }

    @Override // java.util.AbstractMap
    void B(int i, int i2) {
        int i5;
        int i4;
        int i6;
        int i3;
        Object obj2;
        Object[] objArr;
        Object obj;
        int obj8;
        int[] obj9;
        size--;
        i4 = 0;
        i6 = 0;
        if (i < i5) {
            Object[] objArr2 = this.c;
            obj2 = objArr2[i5];
            objArr2[i] = obj2;
            objArr = this.v;
            objArr[i] = objArr[i5];
            objArr2[i5] = i6;
            objArr[i5] = i6;
            int[] iArr2 = this.b;
            iArr2[i] = iArr2[i5];
            iArr2[i5] = i4;
            i7 &= i2;
            i5++;
            if (l.h(this.a, i4) == i5) {
                l.i(this.a, i4, i++);
            }
        } else {
            this.c[i] = i6;
            this.v[i] = i6;
            this.b[i] = i4;
        }
    }

    @Override // java.util.AbstractMap
    boolean C() {
        int i;
        i = this.a == null ? 1 : 0;
        return i;
    }

    @Override // java.util.AbstractMap
    void E(int i) {
        this.b = Arrays.copyOf(this.b, i);
        this.c = Arrays.copyOf(this.c, i);
        this.v = Arrays.copyOf(this.v, i);
    }

    Iterator<V> I() {
        Map map = r();
        if (map != null) {
            return map.values().iterator();
        }
        k.c cVar = new k.c(this);
        return cVar;
    }

    @Override // java.util.AbstractMap
    public void clear() {
        Map map;
        int i4;
        int i;
        int i2;
        int i3;
        if (C()) {
        }
        w();
        map = r();
        i4 = 0;
        final int i5 = 0;
        if (map != null) {
            this.w = b.e(size(), 3, 1073741823);
            map.clear();
            this.a = i4;
            this.x = i5;
        } else {
            Arrays.fill(this.c, i5, this.x, i4);
            Arrays.fill(this.v, i5, this.x, i4);
            l.g(this.a);
            Arrays.fill(this.b, i5, this.x, i5);
            this.x = i5;
        }
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        Map map;
        boolean obj2;
        map = r();
        if (map != null) {
            obj2 = map.containsKey(object);
        } else {
            obj2 = x(object) != -1 ? 1 : 0;
        }
        return obj2;
    }

    @Override // java.util.AbstractMap
    public boolean containsValue(Object object) {
        int i;
        boolean z;
        Map map = r();
        if (map != null) {
            return map.containsValue(object);
        }
        int i2 = 0;
        i = i2;
        while (i < this.x) {
            i++;
        }
        return i2;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set set;
        if (this.z == null) {
            this.z = n();
        }
        return set;
    }

    public V get(Object object) {
        Map map = r();
        if (map != null) {
            return map.get(object);
        }
        int obj2 = x(object);
        if (obj2 == -1) {
            return 0;
        }
        i(obj2);
        return this.v[obj2];
    }

    @Override // java.util.AbstractMap
    void i(int i) {
    }

    @Override // java.util.AbstractMap
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.AbstractMap
    int j(int i, int i2) {
        return i--;
    }

    @Override // java.util.AbstractMap
    int k() {
        n.v(C(), "Arrays already allocated");
        int i = this.w;
        int i2 = l.j(i);
        this.a = l.a(i2);
        H(i2--);
        this.b = new int[i];
        this.c = new Object[i];
        this.v = new Object[i];
        return i;
    }

    public Set<K> keySet() {
        Set set;
        if (this.y == null) {
            this.y = p();
        }
        return set;
    }

    Map<K, V> l() {
        int i;
        Object obj;
        Object obj2;
        Map map = o(i2++);
        i = t();
        while (i >= 0) {
            map.put(this.c[i], this.v[i]);
            i = u(i);
        }
        this.a = map;
        int i4 = 0;
        this.b = i4;
        this.c = i4;
        this.v = i4;
        w();
        return map;
    }

    Set<Map.Entry<K, V>> n() {
        k.d dVar = new k.d(this);
        return dVar;
    }

    Map<K, V> o(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(i, 1065353216);
        return linkedHashMap;
    }

    Set<K> p() {
        k.f fVar = new k.f(this);
        return fVar;
    }

    public V put(K k, V v2) {
        int iArr;
        Object[] objArr;
        int i6;
        int i3;
        int i2;
        int i5;
        int i4;
        int i;
        int i7;
        if (C()) {
            k();
        }
        Map map = r();
        if (map != null) {
            return map.put(k, v2);
        }
        iArr = this.b;
        final Object[] objArr2 = this.v;
        final int i11 = this.x;
        final int i13 = i11 + 1;
        final int i12 = s.c(k);
        int i10 = v();
        i6 = i12 & i10;
        if (l.h(this.a, i6) == 0) {
            if (i13 > i10) {
                iArr = G(i10, l.e(i10), i12, i11);
                i5 = iArr;
            } else {
                l.i(this.a, i6, i13);
                i5 = i10;
            }
            F(i13);
            this.z(i11, k, v2, i12, i5);
            this.x = i13;
            w();
            return 0;
        } else {
            i2 = 0;
            i3--;
            i4 = iArr[i3];
            while (l.b(i4, i10) == l.b(i12, i10)) {
                i = l.c(i4, i10);
                i3 = i;
                i3--;
                i4 = iArr[i3];
            }
        }
        objArr2[i3] = v2;
        i(i3);
        return objArr2[i3];
    }

    Collection<V> q() {
        k.h hVar = new k.h(this);
        return hVar;
    }

    Map<K, V> r() {
        Object obj = this.a;
        if (obj instanceof Map != null) {
            return (Map)obj;
        }
        return 0;
    }

    public V remove(Object object) {
        Object obj2;
        Map map = r();
        if (map != null) {
            return map.remove(object);
        }
        if (D(object) == k.B) {
            obj2 = 0;
        }
        return obj2;
    }

    Iterator<Map.Entry<K, V>> s() {
        Map map = r();
        if (map != null) {
            return map.entrySet().iterator();
        }
        k.b bVar = new k.b(this);
        return bVar;
    }

    @Override // java.util.AbstractMap
    public int size() {
        int size;
        Map map = r();
        if (map != null) {
            size = map.size();
        } else {
            size = this.x;
        }
        return size;
    }

    @Override // java.util.AbstractMap
    int t() {
        int i;
        i = isEmpty() ? -1 : 0;
        return i;
    }

    @Override // java.util.AbstractMap
    int u(int i) {
        int obj2;
        if (i++ < this.x) {
        } else {
            obj2 = -1;
        }
        return obj2;
    }

    public Collection<V> values() {
        Collection collection;
        if (this.A == null) {
            this.A = q();
        }
        return collection;
    }

    @Override // java.util.AbstractMap
    void w() {
        this.w = i += 32;
    }

    @Override // java.util.AbstractMap
    void y(int i) {
        int i2;
        final int i3 = 1;
        i2 = i >= 0 ? i3 : 0;
        n.e(i2, "Expected size must be >= 0");
        this.w = b.e(i, i3, 1073741823);
    }

    void z(int i, K k2, V v3, int i4, int i5) {
        this.b[i] = l.d(i4, 0, i5);
        this.c[i] = k2;
        this.v[i] = v3;
    }
}
