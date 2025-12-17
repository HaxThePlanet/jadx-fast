package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SafeIterableMap<K, V>  implements Iterable<Map.Entry<K, V>> {

    private androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mEnd;
    private final WeakHashMap<androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V>, Boolean> mIterators;
    private int mSize = 0;
    androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mStart;

    public static abstract class SupportRemove {
        abstract void supportRemove(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry);
    }

    private static abstract class ListIterator extends androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mExpectedEnd;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mNext;
        ListIterator(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry, androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry2) {
            super();
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        private androidx.arch.core.internal.SafeIterableMap.Entry<K, V> nextNode() {
            androidx.arch.core.internal.SafeIterableMap.Entry mExpectedEnd;
            if (this.mNext != this.mExpectedEnd && this.mExpectedEnd == null) {
                if (this.mExpectedEnd == null) {
                }
                return forward(this.mNext);
            }
            return 0;
        }

        abstract androidx.arch.core.internal.SafeIterableMap.Entry<K, V> backward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry);

        abstract androidx.arch.core.internal.SafeIterableMap.Entry<K, V> forward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry);

        @Override // androidx.arch.core.internal.SafeIterableMap$SupportRemove
        public boolean hasNext() {
            int i;
            i = this.mNext != null ? 1 : 0;
            return i;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap$SupportRemove
        public Object next() {
            return next();
        }

        public Map.Entry<K, V> next() {
            this.mNext = nextNode();
            return this.mNext;
        }

        public void supportRemove(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry) {
            androidx.arch.core.internal.SafeIterableMap.Entry mExpectedEnd;
            androidx.arch.core.internal.SafeIterableMap.Entry mExpectedEnd2;
            androidx.arch.core.internal.SafeIterableMap.Entry nextNode;
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                if (entry == this.mNext) {
                    mExpectedEnd = 0;
                    this.mNext = mExpectedEnd;
                    this.mExpectedEnd = mExpectedEnd;
                }
            }
            if (this.mExpectedEnd == entry) {
                this.mExpectedEnd = backward(this.mExpectedEnd);
            }
            if (this.mNext == entry) {
                this.mNext = nextNode();
            }
        }
    }

    static class AscendingIterator extends androidx.arch.core.internal.SafeIterableMap.ListIterator<K, V> {
        AscendingIterator(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry, androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry2) {
            super(entry, entry2);
        }

        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> backward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry) {
            return entry.mPrevious;
        }

        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> forward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry) {
            return entry.mNext;
        }
    }

    private static class DescendingIterator extends androidx.arch.core.internal.SafeIterableMap.ListIterator<K, V> {
        DescendingIterator(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry, androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry2) {
            super(entry, entry2);
        }

        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> backward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry) {
            return entry.mNext;
        }

        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> forward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry) {
            return entry.mPrevious;
        }
    }

    static class Entry implements Map.Entry<K, V> {

        final K mKey;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mNext;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mPrevious;
        final V mValue;
        Entry(K k, V v2) {
            super();
            this.mKey = k;
            this.mValue = v2;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object obj) {
            int i;
            boolean equals;
            Object mValue;
            if (obj == this) {
                return 1;
            }
            final int i2 = 0;
            if (!obj instanceof SafeIterableMap.Entry) {
                return i2;
            }
            Object obj2 = obj;
            if (this.mKey.equals(obj2.mKey) && this.mValue.equals(obj2.mValue)) {
                if (this.mValue.equals(obj2.mValue)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        public K getKey() {
            return this.mKey;
        }

        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            return i ^= i3;
        }

        public V setValue(V v) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("An entry modification is not supported");
            throw unsupportedOperationException;
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(this.mKey).append("=").append(this.mValue).toString();
        }
    }

    public class IteratorWithAdditions extends androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        private boolean mBeforeStart = true;
        private androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mCurrent;
        final androidx.arch.core.internal.SafeIterableMap this$0;
        IteratorWithAdditions(androidx.arch.core.internal.SafeIterableMap this$0) {
            this.this$0 = this$0;
            super();
            final int i = 1;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap$SupportRemove
        public boolean hasNext() {
            androidx.arch.core.internal.SafeIterableMap.Entry mCurrent;
            int i;
            i = 1;
            final int i2 = 0;
            if (this.mBeforeStart) {
                if (this$0.mStart != null) {
                } else {
                    i = i2;
                }
                return i;
            }
            if (this.mCurrent != null && mCurrent2.mNext != null) {
                if (mCurrent2.mNext != null) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap$SupportRemove
        public Object next() {
            return next();
        }

        public Map.Entry<K, V> next() {
            androidx.arch.core.internal.SafeIterableMap.Entry mStart;
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = this$0.mStart;
            } else {
                mStart = this.mCurrent != null ? mCurrent3.mNext : 0;
                this.mCurrent = mStart;
            }
            return this.mCurrent;
        }

        void supportRemove(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> safeIterableMap$Entry) {
            int mCurrent;
            if (entry == this.mCurrent) {
                this.mCurrent = mCurrent2.mPrevious;
                mCurrent = this.mCurrent == null ? 1 : 0;
                this.mBeforeStart = mCurrent;
            }
        }
    }
    public SafeIterableMap() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.mIterators = weakHashMap;
        int i = 0;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        SafeIterableMap.DescendingIterator descendingIterator = new SafeIterableMap.DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(descendingIterator, false);
        return descendingIterator;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object obj) {
        int i;
        Object next4;
        boolean next3;
        boolean next;
        Object next2;
        boolean equals;
        if (obj == this) {
            return 1;
        }
        final int i2 = 0;
        if (obj instanceof SafeIterableMap == null) {
            return i2;
        }
        Object obj2 = obj;
        if (size() != (SafeIterableMap)obj2.size()) {
            return i2;
        }
        Iterator iterator = iterator();
        Iterator iterator2 = obj2.iterator();
        while (iterator.hasNext()) {
            next4 = iterator.next();
            next2 = iterator2.next();
        }
        if (!iterator.hasNext() && !iterator2.hasNext()) {
            if (!iterator2.hasNext()) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    protected androidx.arch.core.internal.SafeIterableMap.Entry<K, V> get(K k) {
        androidx.arch.core.internal.SafeIterableMap.Entry currentNode;
        boolean equals;
        currentNode = this.mStart;
        while (currentNode != null) {
            if (currentNode.mKey.equals(k)) {
                break;
            } else {
            }
            currentNode = currentNode.mNext;
        }
        return currentNode;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int h;
        Object next;
        int i;
        h = 0;
        final Iterator iterator = iterator();
        for (Map.Entry next : iterator) {
            h += i;
        }
        return h;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        SafeIterableMap.AscendingIterator ascendingIterator = new SafeIterableMap.AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, false);
        return ascendingIterator;
    }

    public androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions<K, V> iteratorWithAdditions() {
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions(this);
        this.mIterators.put(iteratorWithAdditions, false);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    androidx.arch.core.internal.SafeIterableMap.Entry<K, V> put(K k, V v2) {
        SafeIterableMap.Entry entry = new SafeIterableMap.Entry(k, v2);
        this.mSize = mSize++;
        if (this.mEnd == null) {
            this.mStart = entry;
            this.mEnd = this.mStart;
            return entry;
        }
        mEnd2.mNext = entry;
        entry.mPrevious = this.mEnd;
        this.mEnd = entry;
        return entry;
    }

    public V putIfAbsent(K k, V v2) {
        final androidx.arch.core.internal.SafeIterableMap.Entry map = get(k);
        if (map != null) {
            return map.mValue;
        }
        put(k, v2);
        return 0;
    }

    public V remove(K k) {
        boolean iterator;
        androidx.arch.core.internal.SafeIterableMap.Entry mPrevious2;
        androidx.arch.core.internal.SafeIterableMap.Entry mPrevious;
        Object mPrevious3;
        final androidx.arch.core.internal.SafeIterableMap.Entry map = get(k);
        int i = 0;
        if (map == null) {
            return i;
        }
        this.mSize = mSize--;
        if (!this.mIterators.isEmpty()) {
            iterator = this.mIterators.keySet().iterator();
            for (SafeIterableMap.SupportRemove mPrevious3 : iterator) {
                mPrevious3.supportRemove(map);
            }
        }
        if (map.mPrevious != null) {
            mPrevious2.mNext = map.mNext;
        } else {
            this.mStart = map.mNext;
        }
        if (map.mNext != null) {
            mPrevious.mPrevious = map.mPrevious;
        } else {
            this.mEnd = map.mPrevious;
        }
        map.mNext = i;
        map.mPrevious = i;
        return map.mValue;
    }

    @Override // java.lang.Iterable
    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    public String toString() {
        boolean next;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            stringBuilder.append((Map.Entry)iterator.next().toString());
            if (iterator.hasNext()) {
            }
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
