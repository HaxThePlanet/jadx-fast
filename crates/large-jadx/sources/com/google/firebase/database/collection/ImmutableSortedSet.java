package com.google.firebase.database.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class ImmutableSortedSet<T>  implements Iterable<T> {

    private final com.google.firebase.database.collection.ImmutableSortedMap<T, Void> map;

    private static class WrappedEntryIterator implements Iterator<T> {

        final Iterator<Map.Entry<T, Void>> iterator;
        public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> iterator) {
            super();
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public T next() {
            return (Map.Entry)this.iterator.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }
    private ImmutableSortedSet(com.google.firebase.database.collection.ImmutableSortedMap<T, Void> immutableSortedMap) {
        super();
        this.map = immutableSortedMap;
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator2) {
        super();
        this.map = ImmutableSortedMap.Builder.buildFrom(list, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    public boolean contains(T t) {
        return this.map.containsKey(t);
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof ImmutableSortedSet == null) {
            return 0;
        }
        return this.map.equals(object.map);
    }

    public T getMaxEntry() {
        return this.map.getMaxKey();
    }

    public T getMinEntry() {
        return this.map.getMinKey();
    }

    public T getPredecessorEntry(T t) {
        return this.map.getPredecessorKey(t);
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        return this.map.hashCode();
    }

    public int indexOf(T t) {
        return this.map.indexOf(t);
    }

    public com.google.firebase.database.collection.ImmutableSortedSet<T> insert(T t) {
        ImmutableSortedSet immutableSortedSet = new ImmutableSortedSet(this.map.insert(t, 0));
        return immutableSortedSet;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Iterator<T> iterator() {
        ImmutableSortedSet.WrappedEntryIterator wrappedEntryIterator = new ImmutableSortedSet.WrappedEntryIterator(this.map.iterator());
        return wrappedEntryIterator;
    }

    public Iterator<T> iteratorFrom(T t) {
        ImmutableSortedSet.WrappedEntryIterator wrappedEntryIterator = new ImmutableSortedSet.WrappedEntryIterator(this.map.iteratorFrom(t));
        return wrappedEntryIterator;
    }

    public com.google.firebase.database.collection.ImmutableSortedSet<T> remove(T t) {
        Object immutableSortedSet;
        final com.google.firebase.database.collection.ImmutableSortedMap obj2 = this.map.remove(t);
        if (obj2 == this.map) {
            immutableSortedSet = this;
        } else {
            immutableSortedSet = new ImmutableSortedSet(obj2);
        }
        return immutableSortedSet;
    }

    public Iterator<T> reverseIterator() {
        ImmutableSortedSet.WrappedEntryIterator wrappedEntryIterator = new ImmutableSortedSet.WrappedEntryIterator(this.map.reverseIterator());
        return wrappedEntryIterator;
    }

    public Iterator<T> reverseIteratorFrom(T t) {
        ImmutableSortedSet.WrappedEntryIterator wrappedEntryIterator = new ImmutableSortedSet.WrappedEntryIterator(this.map.reverseIteratorFrom(t));
        return wrappedEntryIterator;
    }

    @Override // java.lang.Iterable
    public int size() {
        return this.map.size();
    }

    public com.google.firebase.database.collection.ImmutableSortedSet<T> unionWith(com.google.firebase.database.collection.ImmutableSortedSet<T> immutableSortedSet) {
        com.google.firebase.database.collection.ImmutableSortedSet insert;
        int size;
        com.google.firebase.database.collection.ImmutableSortedSet obj3;
        if (size() < immutableSortedSet.size()) {
            insert = immutableSortedSet;
            obj3 = this;
        } else {
            insert = this;
        }
        obj3 = obj3.iterator();
        for (Object size : obj3) {
            insert = insert.insert(size);
        }
        return insert;
    }
}
