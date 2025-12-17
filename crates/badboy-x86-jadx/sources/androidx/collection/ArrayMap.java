package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class ArrayMap<K, V>  extends androidx.collection.SimpleArrayMap<K, V> implements Map<K, V> {

    androidx.collection.ArrayMap.EntrySet<K, V> mEntrySet;
    androidx.collection.ArrayMap.KeySet<K, V> mKeySet;
    androidx.collection.ArrayMap.ValueCollection<K, V> mValues;

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        final androidx.collection.ArrayMap this$0;
        EntrySet(androidx.collection.ArrayMap this$0) {
            this.this$0 = this$0;
            super();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            ArrayMap.MapIterator mapIterator = new ArrayMap.MapIterator(this.this$0);
            return mapIterator;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.this$0.size();
        }
    }

    final class KeyIterator extends androidx.collection.IndexBasedArrayIterator<K> {

        final androidx.collection.ArrayMap this$0;
        KeyIterator(androidx.collection.ArrayMap this$0) {
            this.this$0 = this$0;
            super(this$0.size());
        }

        protected K elementAt(int index) {
            return this.this$0.keyAt(index);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int index) {
            this.this$0.removeAt(index);
        }
    }

    final class KeySet implements Set<K> {

        final androidx.collection.ArrayMap this$0;
        KeySet(androidx.collection.ArrayMap this$0) {
            this.this$0 = this$0;
            super();
        }

        public boolean add(K k) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public boolean addAll(Collection<? extends K> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        @Override // java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Set
        public boolean contains(Object object) {
            return this.this$0.containsKey(object);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.this$0.containsAll(collection);
        }

        @Override // java.util.Set
        public boolean equals(Object object) {
            return ArrayMap.equalsSetHelper(this, object);
        }

        @Override // java.util.Set
        public int hashCode() {
            int result;
            int i;
            Object keyAt;
            int i2;
            result = 0;
            size--;
            while (i >= 0) {
                keyAt = this.this$0.keyAt(i);
                if (keyAt == null) {
                } else {
                }
                i2 = keyAt.hashCode();
                result += i2;
                i--;
                i2 = 0;
            }
            return result;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        public Iterator<K> iterator() {
            ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(this.this$0);
            return keyIterator;
        }

        @Override // java.util.Set
        public boolean remove(Object object) {
            int indexOfKey = this.this$0.indexOfKey(object);
            if (indexOfKey >= 0) {
                this.this$0.removeAt(indexOfKey);
                return 1;
            }
            return 0;
        }

        public boolean removeAll(Collection<?> collection) {
            return this.this$0.removeAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return this.this$0.retainAll(collection);
        }

        @Override // java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            int i;
            Object keyAt;
            int size = this.this$0.size();
            final Object[] arr = new Object[size];
            i = 0;
            while (i < size) {
                arr[i] = this.this$0.keyAt(i);
                i++;
            }
            return arr;
        }

        public <T> T[] toArray(T[] tArr) {
            int instance;
            int i;
            int i2;
            Object keyAt;
            Object obj4;
            final int size = size();
            if (tArr.length < size) {
                obj4 = instance;
            }
            i = 0;
            while (i < size) {
                obj4[i] = this.this$0.keyAt(i);
                i++;
            }
            if (obj4.length > size) {
                obj4[size] = 0;
            }
            return obj4;
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        int mEnd;
        boolean mEntryValid;
        int mIndex = -1;
        final androidx.collection.ArrayMap this$0;
        MapIterator(androidx.collection.ArrayMap this$0) {
            this.this$0 = this$0;
            super();
            this.mEnd = size--;
            int i2 = -1;
        }

        @Override // java.util.Iterator
        public boolean equals(Object o) {
            int i;
            boolean equal;
            Object valueAt;
            int mIndex;
            if (!this.mEntryValid) {
            } else {
                if (!o instanceof Map.Entry) {
                    return 0;
                }
                Object obj = o;
                if (ContainerHelpersKt.equal((Map.Entry)obj.getKey(), this.this$0.keyAt(this.mIndex)) && ContainerHelpersKt.equal(obj.getValue(), this.this$0.valueAt(this.mIndex))) {
                    if (ContainerHelpersKt.equal(obj.getValue(), this.this$0.valueAt(this.mIndex))) {
                        i = 1;
                    } else {
                    }
                } else {
                }
                return i;
            }
            IllegalStateException e = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw e;
        }

        public K getKey() {
            if (!this.mEntryValid) {
            } else {
                return this.this$0.keyAt(this.mIndex);
            }
            IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException;
        }

        public V getValue() {
            if (!this.mEntryValid) {
            } else {
                return this.this$0.valueAt(this.mIndex);
            }
            IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.mIndex < this.mEnd ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public int hashCode() {
            int i;
            int i2;
            if (!this.mEntryValid) {
            } else {
                Object keyAt = this.this$0.keyAt(this.mIndex);
                Object valueAt = this.this$0.valueAt(this.mIndex);
                if (keyAt == null) {
                    i2 = i;
                } else {
                    i2 = keyAt.hashCode();
                }
                if (valueAt == null) {
                } else {
                    i = valueAt.hashCode();
                }
                return i ^= i2;
            }
            IllegalStateException key = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw key;
        }

        @Override // java.util.Iterator
        public Object next() {
            return next();
        }

        public Map.Entry<K, V> next() {
            if (!hasNext()) {
            } else {
                final int i2 = 1;
                this.mIndex = mIndex += i2;
                this.mEntryValid = i2;
                return this;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mEntryValid) {
            } else {
                this.this$0.removeAt(this.mIndex);
                this.mIndex = mIndex--;
                this.mEnd = mEnd--;
                this.mEntryValid = false;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        public V setValue(V v) {
            if (!this.mEntryValid) {
            } else {
                return this.this$0.setValueAt(this.mIndex, v);
            }
            IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException;
        }

        @Override // java.util.Iterator
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(getKey()).append("=").append(getValue()).toString();
        }
    }

    final class ValueCollection implements Collection<V> {

        final androidx.collection.ArrayMap this$0;
        ValueCollection(androidx.collection.ArrayMap this$0) {
            this.this$0 = this$0;
            super();
        }

        public boolean add(V v) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public boolean addAll(Collection<? extends V> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        @Override // java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object object) {
            int i;
            i = this.this$0.__restricted$indexOfValue(object) >= 0 ? 1 : 0;
            return i;
        }

        public boolean containsAll(Collection<?> collection) {
            Object next;
            boolean contains;
            Iterator iterator = collection.iterator();
            for (Object next : iterator) {
            }
            return 1;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        public Iterator<V> iterator() {
            ArrayMap.ValueIterator valueIterator = new ArrayMap.ValueIterator(this.this$0);
            return valueIterator;
        }

        @Override // java.util.Collection
        public boolean remove(Object object) {
            int i = this.this$0.__restricted$indexOfValue(object);
            if (i >= 0) {
                this.this$0.removeAt(i);
                return 1;
            }
            return 0;
        }

        public boolean removeAll(Collection<?> collection) {
            int N;
            int changed;
            int i;
            Object valueAt;
            boolean contains;
            N = this.this$0.size();
            changed = 0;
            i = 0;
            while (i < N) {
                if (collection.contains(this.this$0.valueAt(i))) {
                }
                i++;
                this.this$0.removeAt(i);
                i--;
                N--;
                changed = 1;
            }
            return changed;
        }

        public boolean retainAll(Collection<?> collection) {
            int N;
            int changed;
            int i;
            Object valueAt;
            boolean contains;
            N = this.this$0.size();
            changed = 0;
            i = 0;
            while (i < N) {
                if (!collection.contains(this.this$0.valueAt(i))) {
                }
                i++;
                this.this$0.removeAt(i);
                i--;
                N--;
                changed = 1;
            }
            return changed;
        }

        @Override // java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int i;
            Object valueAt;
            int size = this.this$0.size();
            final Object[] arr = new Object[size];
            i = 0;
            while (i < size) {
                arr[i] = this.this$0.valueAt(i);
                i++;
            }
            return arr;
        }

        public <T> T[] toArray(T[] tArr) {
            int instance;
            int i2;
            int i;
            Object valueAt;
            Object obj4;
            final int size = size();
            if (tArr.length < size) {
                obj4 = instance;
            }
            i2 = 0;
            while (i2 < size) {
                obj4[i2] = this.this$0.valueAt(i2);
                i2++;
            }
            if (obj4.length > size) {
                obj4[size] = 0;
            }
            return obj4;
        }
    }

    final class ValueIterator extends androidx.collection.IndexBasedArrayIterator<V> {

        final androidx.collection.ArrayMap this$0;
        ValueIterator(androidx.collection.ArrayMap this$0) {
            this.this$0 = this$0;
            super(this$0.size());
        }

        protected V elementAt(int index) {
            return this.this$0.valueAt(index);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int index) {
            this.this$0.removeAt(index);
        }
    }
    public ArrayMap(int capacity) {
        super(capacity);
    }

    public ArrayMap(androidx.collection.SimpleArrayMap map) {
        super(map);
    }

    static <T> boolean equalsSetHelper(Set<T> set, Object object) {
        int i;
        int size;
        if (set == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof Set != null) {
            Object obj = object;
            if (set.size() == (Set)obj.size() && set.containsAll(obj)) {
                if (set.containsAll(obj)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public boolean containsAll(Collection<?> collection) {
        Object next;
        boolean key;
        Iterator iterator = collection.iterator();
        for (Object next : iterator) {
        }
        return 1;
    }

    @Override // androidx.collection.SimpleArrayMap
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    @Override // androidx.collection.SimpleArrayMap
    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        androidx.collection.ArrayMap.EntrySet entrySet;
        androidx.collection.ArrayMap.EntrySet entrySet2;
        if (this.mEntrySet == null) {
            entrySet2 = new ArrayMap.EntrySet(this);
            this.mEntrySet = entrySet2;
            entrySet = entrySet2;
        }
        return entrySet;
    }

    public V get(Object key) {
        return super.get(key);
    }

    public Set<K> keySet() {
        androidx.collection.ArrayMap.KeySet keySet;
        androidx.collection.ArrayMap.KeySet keySet2;
        if (this.mKeySet == null) {
            keySet2 = new ArrayMap.KeySet(this);
            this.mKeySet = keySet2;
            keySet = keySet2;
        }
        return keySet;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size;
        Object key;
        Object value;
        ensureCapacity(size2 += size);
        Iterator iterator = map.entrySet().iterator();
        for (Map.Entry size : iterator) {
            put(size.getKey(), size.getValue());
        }
    }

    public V remove(Object key) {
        return super.remove(key);
    }

    public boolean removeAll(Collection<?> collection) {
        int i;
        Object next;
        Iterator iterator = collection.iterator();
        for (Object next : iterator) {
            remove(next);
        }
        i = size() != size() ? 1 : 0;
        return i;
    }

    public boolean retainAll(Collection<?> collection) {
        int i2;
        int i;
        boolean contains;
        size2 -= i;
        while (i2 >= 0) {
            if (!collection.contains(keyAt(i2))) {
            }
            i2--;
            removeAt(i2);
        }
        if (size() != size()) {
        } else {
            i = 0;
        }
        return i;
    }

    public Collection<V> values() {
        androidx.collection.ArrayMap.ValueCollection values;
        androidx.collection.ArrayMap.ValueCollection valueCollection;
        if (this.mValues == null) {
            valueCollection = new ArrayMap.ValueCollection(this);
            this.mValues = valueCollection;
            values = valueCollection;
        }
        return values;
    }
}
