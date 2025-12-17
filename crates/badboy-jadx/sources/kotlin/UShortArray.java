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
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0017\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0011\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\u0008!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008#\u0010$J\u0016\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002¢\u0006\u0004\u0008'\u0010(J \u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\u00080\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00088\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\u0008\u0082\u0002\u0004\n\u0002\u0008!¨\u00063", d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([SLjava/lang/Object;)Z", "get", "index", "get-Mh2AYeg", "([SI)S", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "toString-impl", "([S)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UShortArray implements Collection<kotlin.UShort>, KMappedMarker {

    private final short[] storage;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0013\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\r", d2 = {"Lkotlin/UShortArray$Iterator;", "", "Lkotlin/UShort;", "array", "", "([S)V", "index", "", "hasNext", "", "next", "next-Mh2AYeg", "()S", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Iterator implements Iterator<kotlin.UShort>, KMappedMarker {

        private final short[] array;
        private int index;
        public Iterator(short[] array) {
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
            return UShort.box-impl(next-Mh2AYeg());
        }

        @Override // java.util.Iterator
        public short next-Mh2AYeg() {
            if (this.index >= array2.length) {
            } else {
                int index2 = this.index;
                this.index = index2 + 1;
                return UShort.constructor-impl(this.array[index2]);
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
    private UShortArray(short[] storage) {
        super();
        this.storage = storage;
    }

    public static final kotlin.UShortArray box-impl(short[] sArr) {
        UShortArray uShortArray = new UShortArray(sArr);
        return uShortArray;
    }

    public static short[] constructor-impl(int size) {
        return UShortArray.constructor-impl(new short[size]);
    }

    public static short[] constructor-impl(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "storage");
        return sArr;
    }

    public static boolean contains-xj2QHRw(short[] arg0, short element) {
        return ArraysKt.contains(arg0, element);
    }

    public static boolean containsAll-impl(short[] arg0, Collection<kotlin.UShort> elements) {
        Iterator iterator;
        int i2;
        boolean next;
        int it;
        int i;
        boolean contains;
        int i3;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i4 = 0;
        if ((Collection)(Iterable)obj.isEmpty()) {
        } else {
            iterator = obj.iterator();
            while (iterator.hasNext()) {
                Object obj3 = next;
                i = 0;
                i3 = 0;
                if (obj3 instanceof UShort && ArraysKt.contains(arg0, (UShort)obj3.unbox-impl())) {
                } else {
                }
                it = i3;
                if (ArraysKt.contains(arg0, (UShort)obj3.unbox-impl())) {
                } else {
                }
                it = i2;
            }
        }
        return i2;
    }

    public static boolean equals-impl(short[] sArr, Object object2) {
        final int i2 = 0;
        if (object2 instanceof UShortArray == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(sArr, (UShortArray)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(short[] sArr, short[] s2Arr2) {
        return Intrinsics.areEqual(sArr, s2Arr2);
    }

    public static final short get-Mh2AYeg(short[] arg0, int index) {
        return UShort.constructor-impl(arg0[index]);
    }

    public static int getSize-impl(short[] arg0) {
        return arg0.length;
    }

    public static void getStorage$annotations() {
    }

    public static int hashCode-impl(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean isEmpty-impl(short[] arg0) {
        int i;
        i = arg0.length == 0 ? 1 : 0;
        return i;
    }

    public static Iterator<kotlin.UShort> iterator-impl(short[] arg0) {
        UShortArray.Iterator iterator = new UShortArray.Iterator(arg0);
        return (Iterator)iterator;
    }

    public static final void set-01HTLdE(short[] arg0, int index, short value) {
        arg0[index] = value;
    }

    public static String toString-impl(short[] sArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("UShortArray(storage=").append(Arrays.toString(sArr)).append(')').toString();
    }

    @Override // java.util.Collection
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public boolean add-xj2QHRw(short s) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends kotlin.UShort> collection) {
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
        if (!element instanceof UShort) {
            return 0;
        }
        return contains-xj2QHRw((UShort)element.unbox-impl());
    }

    @Override // java.util.Collection
    public boolean contains-xj2QHRw(short element) {
        return UShortArray.contains-xj2QHRw(this.storage, element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UShortArray.containsAll-impl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object object) {
        return UShortArray.equals-impl(this.storage, object);
    }

    @Override // java.util.Collection
    public int getSize() {
        return UShortArray.getSize-impl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return UShortArray.hashCode-impl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return UShortArray.isEmpty-impl(this.storage);
    }

    public Iterator<kotlin.UShort> iterator() {
        return UShortArray.iterator-impl(this.storage);
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
        return UShortArray.toString-impl(this.storage);
    }

    @Override // java.util.Collection
    public final short[] unbox-impl() {
        return this.storage;
    }
}
