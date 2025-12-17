package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class ImmutableList<E>  implements List<E>, RandomAccess {

    private final List<E> immutableList;
    private ImmutableList(List<E> list) {
        super();
        this.immutableList = Collections.unmodifiableList(list);
    }

    public static <E> com.google.firebase.crashlytics.internal.model.ImmutableList<E> from(List<E> list) {
        ImmutableList immutableList = new ImmutableList(list);
        return immutableList;
    }

    public static <E> com.google.firebase.crashlytics.internal.model.ImmutableList<E> from(E... eArr) {
        ImmutableList immutableList = new ImmutableList(Arrays.asList(eArr));
        return immutableList;
    }

    public void add(int i, E e2) {
        this.immutableList.add(i, e2);
    }

    public boolean add(E e) {
        return this.immutableList.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection2) {
        return this.immutableList.addAll(i, collection2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    @Override // java.util.List
    public void clear() {
        this.immutableList.clear();
    }

    @Override // java.util.List
    public boolean contains(Object object) {
        return this.immutableList.contains(object);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    @Override // java.util.List
    public boolean equals(Object object) {
        return this.immutableList.equals(object);
    }

    public E get(int i) {
        return this.immutableList.get(i);
    }

    @Override // java.util.List
    public int hashCode() {
        return this.immutableList.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object object) {
        return this.immutableList.indexOf(object);
    }

    @Override // java.util.List
    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object object) {
        return this.immutableList.lastIndexOf(object);
    }

    public ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return this.immutableList.listIterator(i);
    }

    public E remove(int i) {
        return this.immutableList.remove(i);
    }

    @Override // java.util.List
    public boolean remove(Object object) {
        return this.immutableList.remove(object);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    public E set(int i, E e2) {
        return this.immutableList.set(i, e2);
    }

    @Override // java.util.List
    public int size() {
        return this.immutableList.size();
    }

    public List<E> subList(int i, int i2) {
        return this.immutableList.subList(i, i2);
    }

    @Override // java.util.List
    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.immutableList.toArray(tArr);
    }
}
