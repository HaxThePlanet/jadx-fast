package i.b.m0.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: VolatileSizeArrayList.java */
/* loaded from: classes3.dex */
public final class s<T> extends AtomicInteger implements List<T>, RandomAccess {

    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list = new ArrayList<>();
    public s() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean add(T t) {
        lazySet(this.list.size());
        return this.list.add(t);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean addAll(Collection<? extends T> collection) {
        lazySet(this.list.size());
        return this.list.addAll(collection);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean contains(Object object) {
        return this.list.contains(object);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean equals(Object object) {
        if (object instanceof s) {
            return this.list.equals(object.list);
        }
        return this.list.equals(object);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public T get(int i) {
        return this.list.get(i);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int indexOf(Object object) {
        return this.list.indexOf(object);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean isEmpty() {
        boolean z = true;
        int r0 = get() == 0 ? 1 : 0;
        return (get() == 0 ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int lastIndexOf(Object object) {
        return this.list.lastIndexOf(object);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean remove(Object object) {
        lazySet(this.list.size());
        return this.list.remove(object);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean removeAll(Collection<?> collection) {
        lazySet(this.list.size());
        return this.list.removeAll(collection);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean retainAll(Collection<?> collection) {
        lazySet(this.list.size());
        return this.list.retainAll(collection);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public T set(int i, T t) {
        return this.list.set(i, t);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int size() {
        return get();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public List<T> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public ListIterator<T> listIterator(int i) {
        return this.list.listIterator(i);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public <E> E[] toArray(E[] eArr) {
        return this.list.toArray(eArr);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void add(int i, T t) {
        this.list.add(i, t);
        lazySet(this.list.size());
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean addAll(int i, Collection<? extends T> collection) {
        lazySet(this.list.size());
        return this.list.addAll(i, collection);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public T remove(int i) {
        lazySet(this.list.size());
        return this.list.remove(i);
    }
}
