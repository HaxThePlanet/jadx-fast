package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\u0008\u0008'\u0018\u0000 \u001c*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\u0008\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006 ", d2 = {"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractList<E>  extends kotlin.collections.AbstractCollection<E> implements List<E>, KMappedMarker {

    public static final kotlin.collections.AbstractList.Companion Companion = null;
    private static final int maxArraySize = 2147483639;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0005\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\nJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u000fJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u0017J%\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\u0008\u00030\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\u0008\u00030\u001bH\u0000¢\u0006\u0002\u0008\u001dJ\u0019\u0010\u001e\u001a\u00020\u00042\n\u0010\u001a\u001a\u0006\u0012\u0002\u0008\u00030\u001bH\u0000¢\u0006\u0002\u0008\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "maxArraySize", "", "checkBoundsIndexes", "", "startIndex", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int startIndex, int endIndex, int size) {
            String str = "startIndex: ";
            if (startIndex < 0) {
            } else {
                if (endIndex > size) {
                } else {
                    if (startIndex > endIndex) {
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append(str).append(startIndex).append(" > endIndex: ").append(endIndex).toString());
                    throw illegalArgumentException;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(str).append(startIndex).append(", endIndex: ").append(endIndex).append(", size: ").append(size).toString());
            throw indexOutOfBoundsException;
        }

        public final void checkElementIndex$kotlin_stdlib(int index, int size) {
            if (index < 0) {
            } else {
                if (index >= size) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("index: ").append(index).append(", size: ").append(size).toString());
            throw indexOutOfBoundsException;
        }

        public final void checkPositionIndex$kotlin_stdlib(int index, int size) {
            if (index < 0) {
            } else {
                if (index > size) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("index: ").append(index).append(", size: ").append(size).toString());
            throw indexOutOfBoundsException;
        }

        public final void checkRangeIndexes$kotlin_stdlib(int fromIndex, int toIndex, int size) {
            String str = "fromIndex: ";
            if (fromIndex < 0) {
            } else {
                if (toIndex > size) {
                } else {
                    if (fromIndex > toIndex) {
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append(str).append(fromIndex).append(" > toIndex: ").append(toIndex).toString());
                    throw illegalArgumentException;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(str).append(fromIndex).append(", toIndex: ").append(toIndex).append(", size: ").append(size).toString());
            throw indexOutOfBoundsException;
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int newCapacity;
            int i;
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            i = 2147483639;
            if (newCapacity - i > 0 && minCapacity > i) {
                if (minCapacity > i) {
                    i = Integer.MAX_VALUE;
                }
                newCapacity = i;
            }
            return newCapacity;
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> c, Collection<?> other) {
            Object next;
            Object next2;
            boolean equal;
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(other, "other");
            final int i2 = 0;
            if (c.size() != other.size()) {
                return i2;
            }
            Iterator iterator2 = c.iterator();
            for (Object next : iterator2) {
            }
            return 1;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> c) {
            int hashCode;
            Object next;
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(c, "c");
            hashCode = 1;
            final Iterator iterator = c.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (next != null) {
                } else {
                }
                i2 = 0;
                hashCode = i + i2;
                i2 = next.hashCode();
            }
            return hashCode;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0092\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private class IteratorImpl implements Iterator<E>, KMappedMarker {

        private int index;
        final kotlin.collections.AbstractList<E> this$0;
        public IteratorImpl(kotlin.collections.AbstractList this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // java.util.Iterator
        protected final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.index < this.this$0.size() ? 1 : 0;
            return i;
        }

        public E next() {
            if (!hasNext()) {
            } else {
                final int index = this.index;
                this.index = index + 1;
                return this.this$0.get(index);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Iterator
        protected final void setIndex(int <set-?>) {
            this.index = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0092\u0004\u0018\u00002\u000c0\u0001R\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0008\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u000c\u001a\u00020\u0005H\u0016¨\u0006\r", d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private class ListIteratorImpl extends kotlin.collections.AbstractList.IteratorImpl<E> implements ListIterator<E>, KMappedMarker {

        final kotlin.collections.AbstractList<E> this$0;
        public ListIteratorImpl(kotlin.collections.AbstractList this$0, int index) {
            this.this$0 = this$0;
            super(this$0);
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.this$0.size());
            setIndex(index);
        }

        public void add(E e) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // kotlin.collections.AbstractList$IteratorImpl
        public boolean hasPrevious() {
            int i;
            i = getIndex() > 0 ? 1 : 0;
            return i;
        }

        @Override // kotlin.collections.AbstractList$IteratorImpl
        public int nextIndex() {
            return getIndex();
        }

        public E previous() {
            if (!hasPrevious()) {
            } else {
                setIndex(index--);
                return this.this$0.get(getIndex());
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // kotlin.collections.AbstractList$IteratorImpl
        public int previousIndex() {
            return index--;
        }

        public void set(E e) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0011", d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class SubList extends kotlin.collections.AbstractList<E> implements RandomAccess {

        private int _size;
        private final int fromIndex;
        private final kotlin.collections.AbstractList<E> list;
        public SubList(kotlin.collections.AbstractList<? extends E> list, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(list, "list");
            super();
            this.list = list;
            this.fromIndex = fromIndex;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(this.fromIndex, toIndex, this.list.size());
            this._size = toIndex - fromIndex2;
        }

        public E get(int index) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this._size);
            return this.list.get(fromIndex += index);
        }

        @Override // kotlin.collections.AbstractList
        public int getSize() {
            return this._size;
        }
    }
    static {
        AbstractList.Companion companion = new AbstractList.Companion(0);
        AbstractList.Companion = companion;
    }

    public void add(int i, E e2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int i, Collection<? extends E> collection2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // kotlin.collections.AbstractCollection
    public boolean equals(Object other) {
        if (other == this) {
            return 1;
        }
        if (other instanceof List == null) {
            return 0;
        }
        return AbstractList.Companion.orderedEquals$kotlin_stdlib((Collection)this, (Collection)other);
    }

    public abstract E get(int i);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // kotlin.collections.AbstractCollection
    public int hashCode() {
        return AbstractList.Companion.orderedHashCode$kotlin_stdlib((Collection)this);
    }

    public int indexOf(E element) {
        int index$iv;
        int iterator;
        Object next;
        boolean it;
        int i;
        final int i2 = 0;
        index$iv = 0;
        iterator = (List)this.iterator();
        for (Object next : iterator) {
            i = 0;
            index$iv++;
        }
        index$iv = iterator;
        return index$iv;
    }

    public Iterator<E> iterator() {
        AbstractList.IteratorImpl iteratorImpl = new AbstractList.IteratorImpl(this);
        return (Iterator)iteratorImpl;
    }

    public int lastIndexOf(E element) {
        boolean it;
        int nextIndex;
        int i;
        final List list = this;
        final int i2 = 0;
        ListIterator listIterator = list.listIterator((List)list.size());
        while (listIterator.hasPrevious()) {
            i = 0;
        }
        nextIndex = -1;
        return nextIndex;
    }

    public ListIterator<E> listIterator() {
        AbstractList.ListIteratorImpl listIteratorImpl = new AbstractList.ListIteratorImpl(this, 0);
        return (ListIterator)listIteratorImpl;
    }

    public ListIterator<E> listIterator(int index) {
        AbstractList.ListIteratorImpl listIteratorImpl = new AbstractList.ListIteratorImpl(this, index);
        return (ListIterator)listIteratorImpl;
    }

    public E remove(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public E set(int i, E e2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.SubList subList = new AbstractList.SubList(this, fromIndex, toIndex);
        return (List)subList;
    }
}
