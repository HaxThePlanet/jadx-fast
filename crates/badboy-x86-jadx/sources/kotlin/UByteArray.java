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
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0011\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\u0008!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008#\u0010$J\u0016\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002¢\u0006\u0004\u0008'\u0010(J \u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\u00080\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00088\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\u0008\u0082\u0002\u0004\n\u0002\u0008!¨\u00063", d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([BLjava/lang/Object;)Z", "get", "index", "get-w2LRezQ", "([BI)B", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "set", "", "value", "set-VurrAj0", "([BIB)V", "toString", "", "toString-impl", "([B)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UByteArray implements Collection<kotlin.UByte>, KMappedMarker {

    private final byte[] storage;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0013\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\r", d2 = {"Lkotlin/UByteArray$Iterator;", "", "Lkotlin/UByte;", "array", "", "([B)V", "index", "", "hasNext", "", "next", "next-w2LRezQ", "()B", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Iterator implements Iterator<kotlin.UByte>, KMappedMarker {

        private final byte[] array;
        private int index;
        public Iterator(byte[] array) {
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
            return UByte.box-impl(next-w2LRezQ());
        }

        @Override // java.util.Iterator
        public byte next-w2LRezQ() {
            if (this.index >= array2.length) {
            } else {
                int index2 = this.index;
                this.index = index2 + 1;
                return UByte.constructor-impl(this.array[index2]);
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
    private UByteArray(byte[] storage) {
        super();
        this.storage = storage;
    }

    public static final kotlin.UByteArray box-impl(byte[] bArr) {
        UByteArray uByteArray = new UByteArray(bArr);
        return uByteArray;
    }

    public static byte[] constructor-impl(int size) {
        return UByteArray.constructor-impl(new byte[size]);
    }

    public static byte[] constructor-impl(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "storage");
        return bArr;
    }

    public static boolean contains-7apg3OU(byte[] arg0, byte element) {
        return ArraysKt.contains(arg0, element);
    }

    public static boolean containsAll-impl(byte[] arg0, Collection<kotlin.UByte> elements) {
        Iterator iterator;
        int i;
        boolean next;
        int it;
        int i3;
        boolean contains;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i4 = 0;
        if ((Collection)(Iterable)obj.isEmpty()) {
        } else {
            iterator = obj.iterator();
            while (iterator.hasNext()) {
                Object obj3 = next;
                i3 = 0;
                i2 = 0;
                if (obj3 instanceof UByte && ArraysKt.contains(arg0, (UByte)obj3.unbox-impl())) {
                } else {
                }
                it = i2;
                if (ArraysKt.contains(arg0, (UByte)obj3.unbox-impl())) {
                } else {
                }
                it = i;
            }
        }
        return i;
    }

    public static boolean equals-impl(byte[] bArr, Object object2) {
        final int i2 = 0;
        if (object2 instanceof UByteArray == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(bArr, (UByteArray)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(byte[] bArr, byte[] b2Arr2) {
        return Intrinsics.areEqual(bArr, b2Arr2);
    }

    public static final byte get-w2LRezQ(byte[] arg0, int index) {
        return UByte.constructor-impl(arg0[index]);
    }

    public static int getSize-impl(byte[] arg0) {
        return arg0.length;
    }

    public static void getStorage$annotations() {
    }

    public static int hashCode-impl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean isEmpty-impl(byte[] arg0) {
        int i;
        i = arg0.length == 0 ? 1 : 0;
        return i;
    }

    public static Iterator<kotlin.UByte> iterator-impl(byte[] arg0) {
        UByteArray.Iterator iterator = new UByteArray.Iterator(arg0);
        return (Iterator)iterator;
    }

    public static final void set-VurrAj0(byte[] arg0, int index, byte value) {
        arg0[index] = value;
    }

    public static String toString-impl(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("UByteArray(storage=").append(Arrays.toString(bArr)).append(')').toString();
    }

    @Override // java.util.Collection
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public boolean add-7apg3OU(byte b) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends kotlin.UByte> collection) {
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
        if (!element instanceof UByte) {
            return 0;
        }
        return contains-7apg3OU((UByte)element.unbox-impl());
    }

    @Override // java.util.Collection
    public boolean contains-7apg3OU(byte element) {
        return UByteArray.contains-7apg3OU(this.storage, element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UByteArray.containsAll-impl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object object) {
        return UByteArray.equals-impl(this.storage, object);
    }

    @Override // java.util.Collection
    public int getSize() {
        return UByteArray.getSize-impl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return UByteArray.hashCode-impl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return UByteArray.isEmpty-impl(this.storage);
    }

    public Iterator<kotlin.UByte> iterator() {
        return UByteArray.iterator-impl(this.storage);
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
        return UByteArray.toString-impl(this.storage);
    }

    @Override // java.util.Collection
    public final byte[] unbox-impl() {
        return this.storage;
    }
}
