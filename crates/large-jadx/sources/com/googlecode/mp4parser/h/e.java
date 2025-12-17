package com.googlecode.mp4parser.h;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class e<E>  extends AbstractList<E> {

    private static final com.googlecode.mp4parser.h.f c;
    List<E> a;
    Iterator<E> b;

    class a implements Iterator<E> {

        int a = 0;
        final com.googlecode.mp4parser.h.e b;
        a(com.googlecode.mp4parser.h.e e) {
            this.b = e;
            super();
            final int obj1 = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int next;
            if (this.a >= eVar2.a.size() && !eVar.b.hasNext()) {
                if (!eVar.b.hasNext()) {
                    return 0;
                }
            }
            return 1;
        }

        public E next() {
            if (this.a < eVar3.a.size()) {
                int i2 = this.a;
                this.a = i2 + 1;
                return eVar.a.get(i2);
            }
            com.googlecode.mp4parser.h.e eVar2 = this.b;
            eVar2.a.add(eVar2.b.next());
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
    static {
        e.c = f.a(e.class);
    }

    public e(List<E> list, Iterator<E> iterator2) {
        super();
        this.a = list;
        this.b = iterator2;
    }

    private void b() {
        com.googlecode.mp4parser.h.f fVar;
        String next;
        e.c.b("blowup running");
        while (!this.b.hasNext()) {
            this.a.add(this.b.next());
        }
    }

    public E get(int i) {
        if (this.a.size() > i) {
            return this.a.get(i);
        }
        if (!this.b.hasNext()) {
        } else {
            this.a.add(this.b.next());
            return get(i);
        }
        NoSuchElementException obj3 = new NoSuchElementException();
        throw obj3;
    }

    public Iterator<E> iterator() {
        e.a aVar = new e.a(this);
        return aVar;
    }

    @Override // java.util.AbstractList
    public int size() {
        e.c.b("potentially expensive size() call");
        b();
        return this.a.size();
    }
}
