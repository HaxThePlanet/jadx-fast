package com.googlecode.mp4parser.h;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: LazyList.java */
/* loaded from: classes2.dex */
public class e<E> extends AbstractList<E> {

    private static final f c;
    List<E> a;
    Iterator<E> b;

    class a implements Iterator<E> {

        int a = 0;
        final /* synthetic */ e b;
        a() {
            this.b = eVar;
            super();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a >= this.b.a.size()) {
                if (!this.b.b.hasNext()) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.a < this.b.a.size()) {
                this.a++;
                return this.b.a.get(this.a);
            }
            eVar2.a.add(eVar2.b.next());
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    static {
        e.c = f.a(e.class);
    }

    public e(List<E> list, Iterator<E> iterator) {
        super();
        this.a = list;
        this.b = iterator;
    }

    private void b() {
        item = "blowup running";
        e.c.b(item);
        while (!this.b.hasNext()) {
            this.a.add(this.b.next());
        }
    }

    @Override // java.util.AbstractList
    public E get(int i) {
        if (this.a.size() > i) {
            return this.a.get(i);
        }
        if (!this.b.hasNext()) {
            throw new NoSuchElementException();
        } else {
            this.a.add(this.b.next());
            return get(i);
        }
    }

    @Override // java.util.AbstractList
    public Iterator<E> iterator() {
        return new e.a(this);
    }

    @Override // java.util.AbstractList
    public int size() {
        e.c.b("potentially expensive size() call");
        b();
        return this.a.size();
    }
}
