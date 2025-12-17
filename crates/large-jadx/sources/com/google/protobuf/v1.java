package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public class v1 extends AbstractList<String> implements com.google.protobuf.i0, RandomAccess {

    private final com.google.protobuf.i0 a;

    class a implements ListIterator<String> {

        ListIterator<String> a;
        final int b;
        final com.google.protobuf.v1 c;
        a(com.google.protobuf.v1 v1, int i2) {
            this.c = v1;
            this.b = i2;
            super();
            this.a = v1.b(v1).listIterator(i2);
        }

        @Override // java.util.ListIterator
        public void add(Object object) {
            b((String)object);
            throw 0;
        }

        @Override // java.util.ListIterator
        public void b(String string) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // java.util.ListIterator
        public String c() {
            return (String)this.a.next();
        }

        @Override // java.util.ListIterator
        public String d() {
            return (String)this.a.previous();
        }

        @Override // java.util.ListIterator
        public void e(String string) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // java.util.ListIterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public Object next() {
            return c();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a.nextIndex();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return d();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a.previousIndex();
        }

        @Override // java.util.ListIterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public void set(Object object) {
            e((String)object);
            throw 0;
        }
    }

    class b implements Iterator<String> {

        Iterator<String> a;
        final com.google.protobuf.v1 b;
        b(com.google.protobuf.v1 v1) {
            this.b = v1;
            super();
            this.a = v1.b(v1).iterator();
        }

        @Override // java.util.Iterator
        public String b() {
            return (String)this.a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
    public v1(com.google.protobuf.i0 i0) {
        super();
        this.a = i0;
    }

    static com.google.protobuf.i0 b(com.google.protobuf.v1 v1) {
        return v1.a;
    }

    @Override // java.util.AbstractList
    public Object O1(int i) {
        return this.a.O1(i);
    }

    @Override // java.util.AbstractList
    public void T(com.google.protobuf.j j) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // java.util.AbstractList
    public String d(int i) {
        return (String)this.a.get(i);
    }

    @Override // java.util.AbstractList
    public Object get(int i) {
        return d(i);
    }

    public Iterator<String> iterator() {
        v1.b bVar = new v1.b(this);
        return bVar;
    }

    public List<?> k() {
        return this.a.k();
    }

    public ListIterator<String> listIterator(int i) {
        v1.a aVar = new v1.a(this, i);
        return aVar;
    }

    @Override // java.util.AbstractList
    public com.google.protobuf.i0 n() {
        return this;
    }

    @Override // java.util.AbstractList
    public int size() {
        return this.a.size();
    }
}
