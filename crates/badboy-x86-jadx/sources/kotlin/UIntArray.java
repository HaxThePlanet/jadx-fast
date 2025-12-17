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
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0011\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\u0008!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008#\u0010$J\u0016\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002¢\u0006\u0004\u0008'\u0010(J \u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\u00080\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00088\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\u0008\u0082\u0002\u0004\n\u0002\u0008!¨\u00063", d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([ILjava/lang/Object;)Z", "get", "index", "get-pVg5ArA", "([II)I", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UIntArray implements Collection<kotlin.UInt>, KMappedMarker {

    private final int[] storage;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0013\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\r", d2 = {"Lkotlin/UIntArray$Iterator;", "", "Lkotlin/UInt;", "array", "", "([I)V", "index", "", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Iterator implements Iterator<kotlin.UInt>, KMappedMarker {

        private final int[] array;
        private int index;
        public Iterator(int[] array) {
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
            return UInt.box-impl(next-pVg5ArA());
        }

        @Override // java.util.Iterator
        public int next-pVg5ArA() {
            if (this.index >= array2.length) {
            } else {
                int index2 = this.index;
                this.index = index2 + 1;
                return UInt.constructor-impl(this.array[index2]);
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
    private UIntArray(int[] storage) {
        super();
        this.storage = storage;
    }

    public static final kotlin.UIntArray box-impl(int[] iArr) {
        UIntArray uIntArray = new UIntArray(iArr);
        return uIntArray;
    }

    public static int[] constructor-impl(int size) {
        return UIntArray.constructor-impl(new int[size]);
    }

    public static int[] constructor-impl(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    public static boolean contains-WZ4Q5Ns(int[] arg0, int element) {
        return ArraysKt.contains(arg0, element);
    }

    public static boolean containsAll-impl(int[] arg0, Collection<kotlin.UInt> elements) {
        Iterator iterator;
        int i2;
        boolean next;
        int it;
        int i3;
        boolean contains;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i4 = 0;
        if ((Collection)(Iterable)obj.isEmpty()) {
        } else {
            iterator = obj.iterator();
            while (iterator.hasNext()) {
                Object obj3 = next;
                i3 = 0;
                i = 0;
                if (obj3 instanceof UInt && ArraysKt.contains(arg0, (UInt)obj3.unbox-impl())) {
                } else {
                }
                it = i;
                if (ArraysKt.contains(arg0, (UInt)obj3.unbox-impl())) {
                } else {
                }
                it = i2;
            }
        }
        return i2;
    }

    public static boolean equals-impl(int[] iArr, Object object2) {
        final int i2 = 0;
        if (object2 instanceof UIntArray == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(iArr, (UIntArray)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(int[] iArr, int[] i2Arr2) {
        return Intrinsics.areEqual(iArr, i2Arr2);
    }

    public static final int get-pVg5ArA(int[] arg0, int index) {
        return UInt.constructor-impl(arg0[index]);
    }

    public static int getSize-impl(int[] arg0) {
        return arg0.length;
    }

    public static void getStorage$annotations() {
    }

    public static int hashCode-impl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean isEmpty-impl(int[] arg0) {
        int i;
        i = arg0.length == 0 ? 1 : 0;
        return i;
    }

    public static Iterator<kotlin.UInt> iterator-impl(int[] arg0) {
        UIntArray.Iterator iterator = new UIntArray.Iterator(arg0);
        return (Iterator)iterator;
    }

    public static final void set-VXSXFK8(int[] arg0, int index, int value) {
        arg0[index] = value;
    }

    public static String toString-impl(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("UIntArray(storage=").append(Arrays.toString(iArr)).append(')').toString();
    }

    @Override // java.util.Collection
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public boolean add-WZ4Q5Ns(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends kotlin.UInt> collection) {
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
        if (!element instanceof UInt) {
            return 0;
        }
        return contains-WZ4Q5Ns((UInt)element.unbox-impl());
    }

    @Override // java.util.Collection
    public boolean contains-WZ4Q5Ns(int element) {
        return UIntArray.contains-WZ4Q5Ns(this.storage, element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UIntArray.containsAll-impl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object object) {
        return UIntArray.equals-impl(this.storage, object);
    }

    @Override // java.util.Collection
    public int getSize() {
        return UIntArray.getSize-impl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return UIntArray.hashCode-impl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return UIntArray.isEmpty-impl(this.storage);
    }

    public Iterator<kotlin.UInt> iterator() {
        return UIntArray.iterator-impl(this.storage);
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
        return UIntArray.toString-impl(this.storage);
    }

    @Override // java.util.Collection
    public final int[] unbox-impl() {
        return this.storage;
    }
}
