package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
abstract class c<E>  extends AbstractList<E> implements com.google.protobuf.c0.j<E> {

    private boolean a = true;
    c() {
        super();
        final int i = 1;
    }

    @Override // java.util.AbstractList
    public final void F() {
        this.a = false;
    }

    public boolean add(E e) {
        b();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection2) {
        b();
        return super.addAll(i, collection2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        b();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList
    protected void b() {
        if (!this.a) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.AbstractList
    public boolean c2() {
        return this.a;
    }

    @Override // java.util.AbstractList
    public void clear() {
        b();
        super.clear();
    }

    @Override // java.util.AbstractList
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj;
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        final int i3 = 0;
        if (object instanceof List == null) {
            return i3;
        }
        if (!object instanceof RandomAccess) {
            return super.equals(object);
        }
        int size = size();
        if (size != (List)object.size()) {
            return i3;
        }
        i = i3;
        while (i < size) {
            i++;
        }
        return i2;
    }

    @Override // java.util.AbstractList
    public int hashCode() {
        int i3;
        int i;
        int i2;
        i3 = 1;
        i = 0;
        while (i < size()) {
            i4 += i2;
            i++;
        }
        return i3;
    }

    public abstract E remove(int i);

    @Override // java.util.AbstractList
    public boolean remove(Object object) {
        b();
        int obj2 = indexOf(object);
        if (obj2 == -1) {
            return 0;
        }
        remove(obj2);
        return 1;
    }

    public boolean removeAll(Collection<?> collection) {
        b();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        b();
        return super.retainAll(collection);
    }
}
