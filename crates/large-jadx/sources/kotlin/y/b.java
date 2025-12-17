package kotlin.y;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\u0008\u0008'\u0018\u0000 \u001c*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\u0008\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006 ", d2 = {"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class b<E>  extends kotlin.y.a<E> implements List<E>, a {

    public static final kotlin.y.b.a a;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0005\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008\tJ\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008\u000cJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008\u000eJ%\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008\u0012J%\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u0016H\u0000¢\u0006\u0002\u0008\u0018J\u0019\u0010\u0019\u001a\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u0016H\u0000¢\u0006\u0002\u0008\u001a¨\u0006\u001b", d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final void a(int i, int i2) {
            if (i < 0) {
            } else {
                if (i >= i2) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("index: ");
            stringBuilder.append(i);
            stringBuilder.append(", size: ");
            stringBuilder.append(i2);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
            throw indexOutOfBoundsException;
        }

        public final void b(int i, int i2) {
            if (i < 0) {
            } else {
                if (i > i2) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("index: ");
            stringBuilder.append(i);
            stringBuilder.append(", size: ");
            stringBuilder.append(i2);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
            throw indexOutOfBoundsException;
        }

        public final void c(int i, int i2, int i3) {
            final String str = "fromIndex: ";
            if (i < 0) {
            } else {
                if (i2 > i3) {
                } else {
                    if (i > i2) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(i);
                    stringBuilder.append(" > toIndex: ");
                    stringBuilder.append(i2);
                    IllegalArgumentException obj6 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj6;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(i);
            stringBuilder2.append(", toIndex: ");
            stringBuilder2.append(i2);
            stringBuilder2.append(", size: ");
            stringBuilder2.append(i3);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.toString());
            throw indexOutOfBoundsException;
        }

        public final boolean d(Collection<?> collection, Collection<?> collection2) {
            int size;
            int size2;
            Object next;
            n.f(collection, "c");
            n.f(collection2, "other");
            final int i = 0;
            if (collection.size() != collection2.size()) {
                return i;
            }
            final Iterator obj5 = collection.iterator();
            size2 = 1;
            for (Object next3 : obj5) {
                size2 = 1;
            }
            return size2;
        }

        public final int e(Collection<?> collection) {
            int i2;
            int i;
            n.f(collection, "c");
            final Iterator obj3 = collection.iterator();
            i2 = 1;
            while (obj3.hasNext()) {
                Object next2 = obj3.next();
                if (next2 != null) {
                } else {
                }
                i = 0;
                i3 += i;
                i = next2.hashCode();
            }
            return i2;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0092\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private class b implements Iterator<E>, a {

        private int a;
        final kotlin.y.b b;
        public b(kotlin.y.b b) {
            this.b = b;
            super();
        }

        @Override // java.util.Iterator
        protected final int c() {
            return this.a;
        }

        @Override // java.util.Iterator
        protected final void d(int i) {
            this.a = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.a < this.b.size() ? 1 : 0;
            return i;
        }

        public E next() {
            if (!hasNext()) {
            } else {
                final int i = this.a;
                this.a = i + 1;
                return this.b.get(i);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0092\u0004\u0018\u00002\u000c0\u0001R\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0008\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u000c\u001a\u00020\u0005H\u0016¨\u0006\r", d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private class c extends kotlin.y.b.b<E> implements ListIterator<E>, a {

        final kotlin.y.b c;
        public c(kotlin.y.b b, int i2) {
            this.c = b;
            super(b);
            b.a.b(i2, b.size());
            d(i2);
        }

        public void add(E e) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw obj2;
        }

        @Override // kotlin.y.b$b
        public boolean hasPrevious() {
            int i;
            i = c() > 0 ? 1 : 0;
            return i;
        }

        @Override // kotlin.y.b$b
        public int nextIndex() {
            return c();
        }

        public E previous() {
            if (!hasPrevious()) {
            } else {
                d(i--);
                return this.c.get(c());
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // kotlin.y.b$b
        public int previousIndex() {
            return i--;
        }

        public void set(E e) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw obj2;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0011", d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private static final class d extends kotlin.y.b<E> implements RandomAccess {

        private int b;
        private final kotlin.y.b<E> c;
        private final int v;
        public d(kotlin.y.b<? extends E> b, int i2, int i3) {
            n.f(b, "list");
            super();
            this.c = b;
            this.v = i2;
            b.a.c(i2, i3, b.size());
            this.b = i3 -= i2;
        }

        @Override // kotlin.y.b
        public int d() {
            return this.b;
        }

        public E get(int i) {
            b.a.a(i, this.b);
            return this.c.get(i3 += i);
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.a = aVar;
    }

    public void add(int i, E e2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    public boolean addAll(int i, Collection<? extends E> collection2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    @Override // kotlin.y.a
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof List == null) {
            return 0;
        }
        return b.a.d(this, (Collection)object);
    }

    public abstract E get(int i);

    @Override // kotlin.y.a
    public int hashCode() {
        return b.a.e(this);
    }

    @Override // kotlin.y.a
    public int indexOf(Object object) {
        int i;
        boolean next;
        final Iterator iterator = iterator();
        i = 0;
        for (Object next2 : iterator) {
            i++;
        }
        i = -1;
        return i;
    }

    public Iterator<E> iterator() {
        b.b bVar = new b.b(this);
        return bVar;
    }

    @Override // kotlin.y.a
    public int lastIndexOf(Object object) {
        boolean previous;
        int obj3;
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
        }
        obj3 = -1;
        return obj3;
    }

    public ListIterator<E> listIterator() {
        b.c cVar = new b.c(this, 0);
        return cVar;
    }

    public ListIterator<E> listIterator(int i) {
        b.c cVar = new b.c(this, i);
        return cVar;
    }

    public E remove(int i) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    public E set(int i, E e2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    public List<E> subList(int i, int i2) {
        b.d dVar = new b.d(this, i, i2);
        return dVar;
    }
}
