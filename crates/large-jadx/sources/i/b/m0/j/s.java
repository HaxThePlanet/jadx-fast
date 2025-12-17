package i.b.m0.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class s<T>  extends AtomicInteger implements List<T>, RandomAccess {

    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;
    public s() {
        super();
        ArrayList arrayList = new ArrayList();
        this.list = arrayList;
    }

    public void add(int i, T t2) {
        this.list.add(i, t2);
        lazySet(this.list.size());
    }

    public boolean add(T t) {
        lazySet(this.list.size());
        return this.list.add(t);
    }

    public boolean addAll(int i, Collection<? extends T> collection2) {
        lazySet(this.list.size());
        return this.list.addAll(i, collection2);
    }

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

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean equals(Object object) {
        if (object instanceof s) {
            return this.list.equals(object.list);
        }
        return this.list.equals((s)object);
    }

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
        int i;
        i = get() == 0 ? 1 : 0;
        return i;
    }

    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int lastIndexOf(Object object) {
        return this.list.lastIndexOf(object);
    }

    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<T> listIterator(int i) {
        return this.list.listIterator(i);
    }

    public T remove(int i) {
        lazySet(this.list.size());
        return this.list.remove(i);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean remove(Object object) {
        lazySet(this.list.size());
        return this.list.remove(object);
    }

    public boolean removeAll(Collection<?> collection) {
        lazySet(this.list.size());
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        lazySet(this.list.size());
        return this.list.retainAll(collection);
    }

    public T set(int i, T t2) {
        return this.list.set(i, t2);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int size() {
        return get();
    }

    public List<T> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public Object[] toArray() {
        return this.list.toArray();
    }

    public <E> E[] toArray(E[] eArr) {
        return this.list.toArray(eArr);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }
}
