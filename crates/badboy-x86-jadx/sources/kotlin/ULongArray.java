package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0011\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\u0008!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008#\u0010$J\u0016\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002¢\u0006\u0004\u0008'\u0010(J \u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\u00080\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00088\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\u0008\u0082\u0002\u0004\n\u0002\u0008!¨\u00063", d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class ULongArray implements Collection<kotlin.ULong>, KMappedMarker {

    private final long[] storage;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0013\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\r", d2 = {"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", "array", "", "([J)V", "index", "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Iterator implements Iterator<kotlin.ULong>, KMappedMarker {

        private final long[] array;
        private int index;
        public Iterator(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            super();
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.index < array.length ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return ULong.box-impl(next-s-VKNKU());
        }

        @Override // java.util.Iterator
        public long next-s-VKNKU() {
            if (this.index >= array2.length) {
            } else {
                int index2 = this.index;
                this.index = index2 + 1;
                return ULong.constructor-impl(this.array[index2]);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException(String.valueOf(this.index));
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }
    private ULongArray(long[] storage) {
        super();
        this.storage = storage;
    }

    public static final kotlin.ULongArray box-impl(long[] lArr) {
        ULongArray uLongArray = new ULongArray(lArr);
        return uLongArray;
    }

    public static long[] constructor-impl(int size) {
        return ULongArray.constructor-impl(new long[size]);
    }

    public static long[] constructor-impl(long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "storage");
        return lArr;
    }

    public static boolean contains-VKZWuLQ(long[] arg0, long element) {
        return ArraysKt.contains(arg0, element);
    }

    public static boolean containsAll-impl(long[] arg0, Collection<kotlin.ULong> elements) {
        Iterator iterator;
        int i3;
        boolean next;
        int it;
        int i2;
        boolean contains;
        int i;
        long unbox-impl;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i4 = 0;
        if ((Collection)(Iterable)obj.isEmpty()) {
        } else {
            iterator = obj.iterator();
            while (iterator.hasNext()) {
                Object obj3 = next;
                i2 = 0;
                i = 0;
                if (obj3 instanceof ULong && ArraysKt.contains(arg0, (ULong)obj3.unbox-impl())) {
                } else {
                }
                it = i;
                if (ArraysKt.contains(arg0, (ULong)obj3.unbox-impl())) {
                } else {
                }
                it = i3;
            }
        }
        return i3;
    }

    public static boolean equals-impl(long[] lArr, Object object2) {
        final int i2 = 0;
        if (object2 instanceof ULongArray == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(lArr, (ULongArray)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long[] lArr, long[] l2Arr2) {
        return Intrinsics.areEqual(lArr, l2Arr2);
    }

    public static final long get-s-VKNKU(long[] arg0, int index) {
        return ULong.constructor-impl(arg0[index]);
    }

    public static int getSize-impl(long[] arg0) {
        return arg0.length;
    }

    public static void getStorage$annotations() {
    }

    public static int hashCode-impl(long[] lArr) {
        return Arrays.hashCode(lArr);
    }

    public static boolean isEmpty-impl(long[] arg0) {
        int i;
        i = arg0.length == 0 ? 1 : 0;
        return i;
    }

    public static Iterator<kotlin.ULong> iterator-impl(long[] arg0) {
        ULongArray.Iterator iterator = new ULongArray.Iterator(arg0);
        return (Iterator)iterator;
    }

    public static final void set-k8EXiF4(long[] arg0, int index, long value) {
        arg0[index] = value;
    }

    public static String toString-impl(long[] lArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ULongArray(storage=").append(Arrays.toString(lArr)).append(')').toString();
    }

    @Override // java.util.Collection
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public boolean add-VKZWuLQ(long l) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends kotlin.ULong> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean contains(Object element) {
        if (!element instanceof ULong) {
            return 0;
        }
        return contains-VKZWuLQ((ULong)element.unbox-impl());
    }

    @Override // java.util.Collection
    public boolean contains-VKZWuLQ(long element) {
        return ULongArray.contains-VKZWuLQ(this.storage, element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ULongArray.containsAll-impl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object object) {
        return ULongArray.equals-impl(this.storage, object);
    }

    @Override // java.util.Collection
    public int getSize() {
        return ULongArray.getSize-impl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return ULongArray.hashCode-impl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return ULongArray.isEmpty-impl(this.storage);
    }

    public Iterator<kotlin.ULong> iterator() {
        return ULongArray.iterator-impl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray((Collection)this, tArr);
    }

    @Override // java.util.Collection
    public String toString() {
        return ULongArray.toString-impl(this.storage);
    }

    @Override // java.util.Collection
    public final long[] unbox-impl() {
        return this.storage;
    }
}
