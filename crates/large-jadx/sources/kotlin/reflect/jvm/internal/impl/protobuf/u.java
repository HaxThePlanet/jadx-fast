package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class u extends AbstractList<String> implements RandomAccess, kotlin.reflect.jvm.internal.impl.protobuf.m {

    private final kotlin.reflect.jvm.internal.impl.protobuf.m a;

    class a implements ListIterator<String> {

        ListIterator<String> a;
        final int b;
        final kotlin.reflect.jvm.internal.impl.protobuf.u c;
        a(kotlin.reflect.jvm.internal.impl.protobuf.u u, int i2) {
            this.c = u;
            this.b = i2;
            super();
            this.a = u.b(u).listIterator(i2);
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
        final kotlin.reflect.jvm.internal.impl.protobuf.u b;
        b(kotlin.reflect.jvm.internal.impl.protobuf.u u) {
            this.b = u;
            super();
            this.a = u.b(u).iterator();
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
    public u(kotlin.reflect.jvm.internal.impl.protobuf.m m) {
        super();
        this.a = m;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.m b(kotlin.reflect.jvm.internal.impl.protobuf.u u) {
        return u.a;
    }

    @Override // java.util.AbstractList
    public void X1(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
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
        u.b bVar = new u.b(this);
        return bVar;
    }

    public List<?> k() {
        return this.a.k();
    }

    public ListIterator<String> listIterator(int i) {
        u.a aVar = new u.a(this, i);
        return aVar;
    }

    @Override // java.util.AbstractList
    public kotlin.reflect.jvm.internal.impl.protobuf.m n() {
        return this;
    }

    @Override // java.util.AbstractList
    public kotlin.reflect.jvm.internal.impl.protobuf.d o1(int i) {
        return this.a.o1(i);
    }

    @Override // java.util.AbstractList
    public int size() {
        return this.a.size();
    }
}
