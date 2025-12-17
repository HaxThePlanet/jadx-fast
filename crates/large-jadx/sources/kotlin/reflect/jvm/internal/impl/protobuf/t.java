package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
class t<K extends Comparable<K>, V>  extends AbstractMap<K, V> {

    private final int a;
    private List<kotlin.reflect.jvm.internal.impl.protobuf.t.c<K, V>> b;
    private Map<K, V> c;
    private boolean v;
    private volatile kotlin.reflect.jvm.internal.impl.protobuf.t.e<K, V> w;

    private static class b {

        private static final Iterator<Object> a;
        private static final Iterable<Object> b;
        static {
            t.b.a aVar = new t.b.a();
            t.b.a = aVar;
            t.b.b bVar = new t.b.b();
            t.b.b = bVar;
        }

        static Iterator a() {
            return t.b.a;
        }

        static <T> Iterable<T> b() {
            return t.b.b;
        }
    }

    private class c implements Comparable<kotlin.reflect.jvm.internal.impl.protobuf.t.c<K, V>>, Map.Entry<K, V> {

        private final K a;
        private V b;
        final kotlin.reflect.jvm.internal.impl.protobuf.t c;
        c(kotlin.reflect.jvm.internal.impl.protobuf.t t, Comparable comparable2, Object object3) {
            this.c = t;
            super();
            this.a = comparable2;
            this.b = object3;
        }

        c(kotlin.reflect.jvm.internal.impl.protobuf.t t, Map.Entry map$Entry2) {
            super(t, (Comparable)entry2.getKey(), entry2.getValue());
        }

        private boolean c(Object object, Object object2) {
            int obj1;
            if (object == null) {
                obj1 = object2 == null ? 1 : 0;
            } else {
                obj1 = object.equals(object2);
            }
            return obj1;
        }

        public int a(kotlin.reflect.jvm.internal.impl.protobuf.t.c<K, V> t.c) {
            return e().compareTo(t.c.e());
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((t.c)object);
        }

        public K e() {
            return this.a;
        }

        @Override // java.lang.Comparable
        public boolean equals(Object object) {
            int i;
            boolean z;
            Object obj5;
            if (object == this) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof Map.Entry) {
                return i2;
            }
            if (c(this.a, (Map.Entry)object.getKey()) && c(this.b, object.getValue())) {
                if (c(this.b, object.getValue())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // java.lang.Comparable
        public Object getKey() {
            return e();
        }

        public V getValue() {
            return this.b;
        }

        @Override // java.lang.Comparable
        public int hashCode() {
            int i;
            int i2;
            Comparable comparable = this.a;
            if (comparable == null) {
                i = i2;
            } else {
                i = comparable.hashCode();
            }
            final Object obj = this.b;
            if (obj == null) {
            } else {
                i2 = obj.hashCode();
            }
            return i ^= i2;
        }

        public V setValue(V v) {
            t.a(this.c);
            this.b = v;
            return this.b;
        }

        @Override // java.lang.Comparable
        public String toString() {
            String valueOf2 = String.valueOf(String.valueOf(this.a));
            String valueOf4 = String.valueOf(String.valueOf(this.b));
            StringBuilder stringBuilder = new StringBuilder(i += length2);
            stringBuilder.append(valueOf2);
            stringBuilder.append("=");
            stringBuilder.append(valueOf4);
            return stringBuilder.toString();
        }
    }

    private class d implements Iterator<Map.Entry<K, V>> {

        private int a;
        private boolean b;
        private Iterator<Map.Entry<K, V>> c;
        final kotlin.reflect.jvm.internal.impl.protobuf.t v;
        private d(kotlin.reflect.jvm.internal.impl.protobuf.t t) {
            this.v = t;
            super();
            this.a = -1;
        }

        d(kotlin.reflect.jvm.internal.impl.protobuf.t t, kotlin.reflect.jvm.internal.impl.protobuf.t.a t$a2) {
            super(t);
        }

        private Iterator<Map.Entry<K, V>> b() {
            Iterator iterator;
            if (this.c == null) {
                this.c = t.e(this.v).entrySet().iterator();
            }
            return this.c;
        }

        public Map.Entry<K, V> c() {
            int i = 1;
            this.b = i;
            i2 += i;
            this.a = i3;
            if (i3 < t.c(this.v).size()) {
                return (Map.Entry)t.c(this.v).get(this.a);
            }
            return (Map.Entry)b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int next;
            int i;
            if (i2 += i >= t.c(this.v).size()) {
                if (b().hasNext()) {
                } else {
                    i = 0;
                }
            }
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public void remove() {
            Object it;
            int size;
            int i;
            if (!this.b) {
            } else {
                this.b = false;
                t.a(this.v);
                if (this.a < t.c(this.v).size()) {
                    size = this.a;
                    this.a = size + -1;
                    t.d(this.v, size);
                } else {
                    b().remove();
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
            throw illegalStateException;
        }
    }

    private class e extends AbstractSet<Map.Entry<K, V>> {

        final kotlin.reflect.jvm.internal.impl.protobuf.t a;
        private e(kotlin.reflect.jvm.internal.impl.protobuf.t t) {
            this.a = t;
            super();
        }

        e(kotlin.reflect.jvm.internal.impl.protobuf.t t, kotlin.reflect.jvm.internal.impl.protobuf.t.a t$a2) {
            super(t);
        }

        @Override // java.util.AbstractSet
        public boolean add(Object object) {
            return b((Map.Entry)object);
        }

        public boolean b(Map.Entry<K, V> map$Entry) {
            if (!contains(entry)) {
                this.a.p((Comparable)entry.getKey(), entry.getValue());
                return 1;
            }
            return 0;
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            Object obj3;
            Object obj = this.a.get((Map.Entry)object.getKey());
            obj3 = object.getValue();
            if (obj != obj3) {
                if (obj != null && obj.equals(obj3)) {
                    if (obj.equals(obj3)) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            t.d dVar = new t.d(this.a, 0);
            return dVar;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            if (contains((Map.Entry)object)) {
                this.a.remove(object.getKey());
                return 1;
            }
            return 0;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.size();
        }
    }

    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.t<FieldDescriptorType, Object> {
        a(int i) {
            super(i, 0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.t
        public void n() {
            boolean iterator;
            int i;
            boolean next2;
            int next;
            boolean unmodifiableList;
            if (!m()) {
                i = 0;
                while (i < j()) {
                    next2 = i(i);
                    if ((g.b)next2.getKey().b()) {
                    }
                    i++;
                    next2.setValue(Collections.unmodifiableList((List)next2.getValue()));
                }
                iterator = k().iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((g.b)(Map.Entry)next.getKey().b()) {
                    }
                    next.setValue(Collections.unmodifiableList((List)next.getValue()));
                }
            }
            super.n();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.t
        public Object put(Object object, Object object2) {
            return super.p((g.b)object, object2);
        }
    }
    private t(int i) {
        super();
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
    }

    t(int i, kotlin.reflect.jvm.internal.impl.protobuf.t.a t$a2) {
        super(i);
    }

    static void a(kotlin.reflect.jvm.internal.impl.protobuf.t t) {
        t.g();
    }

    static List c(kotlin.reflect.jvm.internal.impl.protobuf.t t) {
        return t.b;
    }

    static Object d(kotlin.reflect.jvm.internal.impl.protobuf.t t, int i2) {
        return t.q(i2);
    }

    static Map e(kotlin.reflect.jvm.internal.impl.protobuf.t t) {
        return t.c;
    }

    private int f(K k) {
        int i2;
        int compareTo2;
        int i;
        int i3;
        int compareTo;
        size--;
        compareTo2 = k.compareTo((t.c)this.b.get(i2).e());
        if (i2 >= 0 && compareTo2 > 0) {
            compareTo2 = k.compareTo((t.c)this.b.get(i2).e());
            if (compareTo2 > 0) {
                return -i4;
            }
            if (compareTo2 == 0) {
                return i2;
            }
        }
        i = 0;
        while (i <= i2) {
            i6 /= 2;
            compareTo = k.compareTo((t.c)this.b.get(i7).e());
            i = i3;
            i2 = i3;
        }
        return -i5;
    }

    private void g() {
        if (this.v) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private void h() {
        boolean arrayList;
        int i;
        g();
        if (this.b.isEmpty() && list2 instanceof ArrayList == null) {
            if (list2 instanceof ArrayList == null) {
                arrayList = new ArrayList(this.a);
                this.b = arrayList;
            }
        }
    }

    private SortedMap<K, V> l() {
        boolean treeMap;
        g();
        if (this.c.isEmpty() && map3 instanceof TreeMap == null) {
            if (map3 instanceof TreeMap == null) {
                treeMap = new TreeMap();
                this.c = treeMap;
            }
        }
        return (SortedMap)this.c;
    }

    static <FieldDescriptorType extends kotlin.reflect.jvm.internal.impl.protobuf.g.b<FieldDescriptorType>> kotlin.reflect.jvm.internal.impl.protobuf.t<FieldDescriptorType, Object> o(int i) {
        t.a aVar = new t.a(i);
        return aVar;
    }

    private V q(int i) {
        boolean iterator;
        List list;
        kotlin.reflect.jvm.internal.impl.protobuf.t.c cVar;
        Object next;
        g();
        if (!this.c.isEmpty()) {
            iterator = l().entrySet().iterator();
            cVar = new t.c(this, (Map.Entry)iterator.next());
            this.b.add(cVar);
            iterator.remove();
        }
        return (t.c)this.b.remove(i).getValue();
    }

    @Override // java.util.AbstractMap
    public void clear() {
        boolean empty;
        boolean empty2;
        g();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        Map i;
        int obj2;
        if (f((Comparable)object) < 0) {
            if (this.c.containsKey(object)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        kotlin.reflect.jvm.internal.impl.protobuf.t.e eVar;
        int i;
        if (this.w == null) {
            eVar = new t.e(this, 0);
            this.w = eVar;
        }
        return this.w;
    }

    public V get(Object object) {
        int i = f((Comparable)object);
        if (i >= 0) {
            return (t.c)this.b.get(i).getValue();
        }
        return this.c.get(object);
    }

    public Map.Entry<K, V> i(int i) {
        return (Map.Entry)this.b.get(i);
    }

    @Override // java.util.AbstractMap
    public int j() {
        return this.b.size();
    }

    public Iterable<Map.Entry<K, V>> k() {
        Object entrySet;
        if (this.c.isEmpty()) {
            entrySet = t.b.b();
        } else {
            entrySet = this.c.entrySet();
        }
        return entrySet;
    }

    @Override // java.util.AbstractMap
    public boolean m() {
        return this.v;
    }

    @Override // java.util.AbstractMap
    public void n() {
        Map unmodifiableMap;
        boolean z;
        if (!this.v) {
            if (this.c.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.c);
            }
            this.c = unmodifiableMap;
            this.v = true;
        }
    }

    public V p(K k, V v2) {
        int value;
        int i;
        Comparable comparable;
        g();
        int i2 = f(k);
        if (i2 >= 0) {
            return (t.c)this.b.get(i2).setValue(v2);
        }
        h();
        int i4 = -i3;
        if (i4 >= this.a) {
            return l().put(k, v2);
        }
        i = this.a;
        if (this.b.size() == i) {
            Object remove = this.b.remove(i--);
            l().put((t.c)remove.e(), remove.getValue());
        }
        t.c cVar = new t.c(this, k, v2);
        this.b.add(i4, cVar);
        return 0;
    }

    public V remove(Object object) {
        g();
        int i = f((Comparable)object);
        if (i >= 0) {
            return q(i);
        }
        if (this.c.isEmpty()) {
            return 0;
        }
        return this.c.remove(object);
    }

    @Override // java.util.AbstractMap
    public int size() {
        return size += size2;
    }
}
