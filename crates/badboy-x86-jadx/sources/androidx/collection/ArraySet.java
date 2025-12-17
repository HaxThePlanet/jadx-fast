package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010#\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\r\n\u0002\u0010)\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001?B\u0019\u0008\u0016\u0012\u0010\u0010\u0004\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0017\u0008\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\u0008\u0016\u0012\u0010\u0010\u0008\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0011\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020$2\u000e\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0000J\u0016\u0010#\u001a\u00020 2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0008\u0010&\u001a\u00020$H\u0016J\u0016\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\"J\u0016\u0010(\u001a\u00020 2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000cJ\u0013\u0010+\u001a\u00020 2\u0008\u0010,\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010-\u001a\u00020\u000cH\u0016J\u0010\u0010.\u001a\u00020\u000c2\u0008\u0010/\u001a\u0004\u0018\u00010\u0012J\u0008\u00100\u001a\u00020 H\u0016J\u000f\u00101\u001a\u0008\u0012\u0004\u0012\u00028\u000002H\u0096\u0002J\u0015\u00103\u001a\u00020 2\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u00104\u001a\u00020 2\u000e\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0000J\u0016\u00104\u001a\u00020 2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0013\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00020\u000c¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020 2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0013\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\u0002\u0010\u0014J%\u00109\u001a\u0008\u0012\u0004\u0012\u0002H:0\t\"\u0004\u0008\u0001\u0010:2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H:0\t¢\u0006\u0002\u0010;J\u0008\u0010<\u001a\u00020=H\u0016J\u0013\u0010>\u001a\u00028\u00002\u0006\u00106\u001a\u00020\u000c¢\u0006\u0002\u00107R\u001a\u0010\u000e\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\rR$\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0010¨\u0006@", d2 = {"Landroidx/collection/ArraySet;", "E", "", "", "set", "(Landroidx/collection/ArraySet;)V", "", "(Ljava/util/Collection;)V", "array", "", "([Ljava/lang/Object;)V", "capacity", "", "(I)V", "_size", "get_size$collection", "()I", "set_size$collection", "", "getArray$collection", "()[Ljava/lang/Object;", "setArray$collection", "[Ljava/lang/Object;", "hashes", "", "getHashes$collection", "()[I", "setHashes$collection", "([I)V", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "", "elements", "clear", "contains", "containsAll", "ensureCapacity", "minimumCapacity", "equals", "other", "hashCode", "indexOf", "key", "isEmpty", "iterator", "", "remove", "removeAll", "removeAt", "index", "(I)Ljava/lang/Object;", "retainAll", "toArray", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "valueAt", "ElementIterator", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ArraySet<E>  implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {

    private int _size;
    private Object[] array;
    private int[] hashes;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\t", d2 = {"Landroidx/collection/ArraySet$ElementIterator;", "Landroidx/collection/IndexBasedArrayIterator;", "(Landroidx/collection/ArraySet;)V", "elementAt", "index", "", "(I)Ljava/lang/Object;", "removeAt", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ElementIterator extends androidx.collection.IndexBasedArrayIterator<E> {

        final androidx.collection.ArraySet<E> this$0;
        public ElementIterator(androidx.collection.ArraySet this$0) {
            this.this$0 = this$0;
            super(this$0.get_size$collection());
        }

        protected E elementAt(int index) {
            return this.this$0.valueAt(index);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int index) {
            this.this$0.removeAt(index);
        }
    }
    public ArraySet() {
        super(0, 1, 0);
    }

    public ArraySet(int capacity) {
        super();
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (capacity > 0) {
            ArraySetKt.allocArrays(this, capacity);
        }
    }

    public ArraySet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public ArraySet(androidx.collection.ArraySet<? extends E> set) {
        super(0);
        if (set != null) {
            addAll(set);
        }
    }

    public ArraySet(Collection<? extends E> set) {
        super(0);
        if (set != null) {
            addAll(set);
        }
    }

    public ArraySet(E[] array) {
        int iterator;
        Object next;
        super(0);
        if (array != null) {
            iterator = ArrayIteratorKt.iterator(array);
            for (Object next : iterator) {
                add(next);
            }
        }
    }

    public boolean add(E element) {
        int hash$iv;
        int index$iv;
        int oarray$iv;
        int length;
        int array$collection2;
        int i;
        int[] hashes$collection;
        Object[] array$collection3;
        Object[] array$collection;
        int i4;
        int i2;
        int length2;
        int i3;
        int i5;
        final Object obj = element;
        final androidx.collection.ArraySet set = this;
        final int i6 = 0;
        final int i7 = set.get_size$collection();
        int i8 = 0;
        int i9 = 0;
        if (obj == null) {
            hash$iv = 0;
            index$iv = ArraySetKt.indexOfNull(set);
        } else {
            index$iv = ArraySetKt.indexOf(set, obj, obj.hashCode());
        }
        oarray$iv = 0;
        if (index$iv >= 0) {
            return oarray$iv;
        } else {
            index$iv = ~index$iv;
            i = 1;
            if (i7 >= hashes$collection5.length) {
                if (i7 >= 8) {
                    i12 += i7;
                } else {
                    hashes$collection = 4;
                    if (i7 >= hashes$collection) {
                    } else {
                        array$collection2 = hashes$collection;
                    }
                }
                hashes$collection = set.getHashes$collection();
                array$collection3 = set.getArray$collection();
                ArraySetKt.allocArrays(set, array$collection2);
                if (i7 != set.get_size$collection()) {
                } else {
                    if (hashes$collection8.length == 0) {
                        oarray$iv = i;
                    }
                    if (oarray$iv == 0) {
                        oarray$iv = array$collection3;
                        i4 = 0;
                        ArraysKt.copyInto$default(hashes$collection, set.getHashes$collection(), 0, i4, hashes$collection.length, 6, 0);
                        ArraysKt.copyInto$default(oarray$iv, set.getArray$collection(), i4, 0, oarray$iv.length, 6, 0);
                    } else {
                        oarray$iv = array$collection3;
                    }
                }
                ConcurrentModificationException concurrentModificationException2 = new ConcurrentModificationException();
                throw concurrentModificationException2;
            }
            if (index$iv < i7) {
                ArraysKt.copyInto(set.getHashes$collection(), set.getHashes$collection(), index$iv + 1, index$iv, i7);
                ArraysKt.copyInto(set.getArray$collection(), set.getArray$collection(), index$iv + 1, index$iv, i7);
            }
            if (i7 != set.get_size$collection()) {
            } else {
                if (index$iv >= hashes$collection2.length) {
                } else {
                    set.getHashes$collection()[index$iv] = hash$iv;
                    set.getArray$collection()[index$iv] = obj;
                    set.set_size$collection(i10 += i);
                    oarray$iv = i;
                }
            }
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public final void addAll(androidx.collection.ArraySet<? extends E> array) {
        int i$iv;
        Object array$collection;
        int i4;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(array, "array");
        Object obj = this;
        final int i5 = 0;
        final int i8 = array.get_size$collection();
        obj.ensureCapacity(i6 += i8);
        if (obj.get_size$collection() == 0) {
            if (i8 > 0) {
                i2 = 6;
                i3 = 0;
                i4 = 0;
                i = 0;
                ArraysKt.copyInto$default(array.getHashes$collection(), obj.getHashes$collection(), i4, i, i8, i2, i3);
                ArraysKt.copyInto$default(array.getArray$collection(), obj.getArray$collection(), i4, i, i8, i2, i3);
                if (obj.get_size$collection() != 0) {
                } else {
                    obj.set_size$collection(i8);
                }
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                throw concurrentModificationException;
            }
        } else {
            i$iv = 0;
            while (i$iv < i8) {
                obj.add(array.valueAt(i$iv));
                i$iv++;
            }
        }
    }

    public boolean addAll(Collection<? extends E> elements) {
        int added$iv;
        Object next;
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = this;
        final int i = 0;
        obj.ensureCapacity(i2 += size);
        added$iv = 0;
        Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            added$iv |= z;
        }
        return added$iv;
    }

    @Override // java.util.Collection
    public void clear() {
        int i;
        final Object obj = this;
        final int i2 = 0;
        if (obj.get_size$collection() != 0) {
            obj.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            obj.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            obj.set_size$collection(0);
        }
        if (obj.get_size$collection() != 0) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        int i;
        final int i2 = 0;
        i = this.indexOf(element) >= 0 ? 1 : 0;
        return i;
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        int i;
        Object next;
        boolean contains;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        Iterator iterator = elements.iterator();
        for (Object next : iterator) {
        }
        i = 1;
        return i;
    }

    @Override // java.util.Collection
    public final void ensureCapacity(int minimumCapacity) {
        int array$collection;
        int[] hashes$collection;
        Object[] oarray$iv;
        Object[] array$collection2;
        int i3;
        int i;
        int i5;
        int i2;
        int i4;
        final androidx.collection.ArraySet set = this;
        final int i6 = 0;
        if (hashes$collection2.length < minimumCapacity) {
            array$collection = set.getArray$collection();
            ArraySetKt.allocArrays(set, minimumCapacity);
            if (set.get_size$collection() > 0) {
                i3 = 0;
                ArraysKt.copyInto$default(set.getHashes$collection(), set.getHashes$collection(), 0, i3, set.get_size$collection(), 6, 0);
                ArraysKt.copyInto$default(array$collection, set.getArray$collection(), i3, 0, set.get_size$collection(), 6, 0);
            } else {
                oarray$iv = array$collection;
            }
        }
        if (set.get_size$collection() != set.get_size$collection()) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        int ignored$iv;
        int i$iv;
        int i;
        int size;
        Object valueAt;
        boolean contains;
        final Object obj = this;
        final int i2 = 0;
        ignored$iv = 1;
        if (obj == other) {
        } else {
            i = 0;
            if (other instanceof Set != null) {
                if (obj.size() != (Set)other.size()) {
                    ignored$iv = i;
                } else {
                    i$iv = 0;
                    while (i$iv < obj.get_size$collection()) {
                        i$iv++;
                    }
                }
            } else {
                ignored$iv = i;
            }
        }
        return ignored$iv;
    }

    @Override // java.util.Collection
    public final Object[] getArray$collection() {
        return this.array;
    }

    @Override // java.util.Collection
    public final int[] getHashes$collection() {
        return this.hashes;
    }

    @Override // java.util.Collection
    public int getSize() {
        return this._size;
    }

    @Override // java.util.Collection
    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int result$iv;
        int i$iv;
        int i;
        final Object obj = this;
        final int i2 = 0;
        result$iv = 0;
        i$iv = 0;
        while (i$iv < obj.get_size$collection()) {
            result$iv += i;
            i$iv++;
        }
        return result$iv;
    }

    @Override // java.util.Collection
    public final int indexOf(Object key) {
        int indexOfNull;
        final androidx.collection.ArraySet set = this;
        final int i = 0;
        if (key == null) {
            indexOfNull = ArraySetKt.indexOfNull(set);
        } else {
            indexOfNull = ArraySetKt.indexOf(set, key, key.hashCode());
        }
        return indexOfNull;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        int i;
        final int i2 = 0;
        i = this.get_size$collection() <= 0 ? 1 : 0;
        return i;
    }

    public Iterator<E> iterator() {
        ArraySet.ElementIterator elementIterator = new ArraySet.ElementIterator(this);
        return (Iterator)elementIterator;
    }

    @Override // java.util.Collection
    public boolean remove(Object element) {
        int i;
        final Object obj = this;
        final int i2 = 0;
        final int indexOf = obj.indexOf(element);
        i = indexOf >= 0 ? 1 : 0;
        return i;
    }

    public final boolean removeAll(androidx.collection.ArraySet<? extends E> array) {
        int i$iv;
        int i;
        Object valueAt;
        Intrinsics.checkNotNullParameter(array, "array");
        Object obj = this;
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < array.get_size$collection()) {
            obj.remove(array.valueAt(i$iv));
            i$iv++;
        }
        i = obj.get_size$collection() != obj.get_size$collection() ? 1 : 0;
        return i;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        int removed$iv;
        Object next;
        boolean remove;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i = 0;
        removed$iv = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            removed$iv |= remove;
        }
        return removed$iv;
    }

    public final E removeAt(int index) {
        int array$collection3;
        Object[] ohashes$iv;
        int array$collection;
        int array$collection2;
        int i4;
        int i7;
        int i5;
        int i6;
        int i;
        int i2;
        int i3;
        Object[] array$collection4;
        int[] iArr;
        final androidx.collection.ArraySet set = this;
        final int i13 = 0;
        final int i14 = set.get_size$collection();
        if (i14 <= 1) {
            set.clear();
            i5 = index;
            return set.getArray$collection()[index];
        } else {
            i2 = i14 + -1;
            i4 = 8;
            if (hashes$collection3.length > i4 && set.get_size$collection() < length /= 3) {
                if (set.get_size$collection() < length /= 3) {
                    if (set.get_size$collection() > i4) {
                        i4 = array$collection + array$collection3;
                    } else {
                    }
                    int[] hashes$collection = set.getHashes$collection();
                    array$collection4 = set.getArray$collection();
                    ArraySetKt.allocArrays(set, i4);
                    if (index > 0) {
                        i6 = 6;
                        i = 0;
                        i4 = 0;
                        i7 = 0;
                        i5 = index;
                        ArraysKt.copyInto$default(hashes$collection, set.getHashes$collection(), i4, i7, i5, i6, i);
                        iArr = hashes$collection;
                        ArraysKt.copyInto$default(array$collection4, set.getArray$collection(), i4, i7, i5, i6, i);
                    } else {
                        i5 = index;
                        iArr = hashes$collection;
                        ohashes$iv = array$collection4;
                    }
                    if (i5 < i2) {
                        ArraysKt.copyInto(iArr, set.getHashes$collection(), i5, i5 + 1, i2 + 1);
                        ArraysKt.copyInto(ohashes$iv, set.getArray$collection(), i5, i5 + 1, i2 + 1);
                    }
                } else {
                    i5 = index;
                    if (i5 < i2) {
                        ArraysKt.copyInto(set.getHashes$collection(), set.getHashes$collection(), i5, i5 + 1, i2 + 1);
                        ArraysKt.copyInto(set.getArray$collection(), set.getArray$collection(), i5, i5 + 1, i2 + 1);
                    }
                    set.getArray$collection()[i2] = 0;
                }
            } else {
            }
            if (i14 != set.get_size$collection()) {
            } else {
                set.set_size$collection(i2);
            }
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        int removed$iv;
        int i$iv;
        boolean contains;
        Object obj;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj2 = this;
        final int i = 0;
        removed$iv = 0;
        i2--;
        while (-1 < i$iv) {
            if (!CollectionsKt.contains((Iterable)elements, obj2.getArray$collection()[i$iv])) {
            }
            i$iv--;
            obj2.removeAt(i$iv);
            removed$iv = 1;
        }
        return removed$iv;
    }

    @Override // java.util.Collection
    public final void setArray$collection(Object[] <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.array = <set-?>;
    }

    @Override // java.util.Collection
    public final void setHashes$collection(int[] <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.hashes = <set-?>;
    }

    @Override // java.util.Collection
    public final void set_size$collection(int <set-?>) {
        this._size = <set-?>;
    }

    @Override // java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return ArraysKt.copyOfRange(this.array, 0, this._size);
    }

    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        Object[] resizeForToArray = ArraySetJvmUtil.resizeForToArray(array, this._size);
        final int i = 0;
        ArraysKt.copyInto(this.array, resizeForToArray, i, i, this._size);
        Intrinsics.checkNotNullExpressionValue(resizeForToArray, "result");
        return resizeForToArray;
    }

    @Override // java.util.Collection
    public String toString() {
        String string;
        String str2;
        int i;
        int i$iv2;
        int i$iv;
        int i2;
        Object valueAt;
        String str;
        final Object obj = this;
        final int i3 = 0;
        if (obj.isEmpty()) {
            string = "{}";
        } else {
            StringBuilder stringBuilder = new StringBuilder(i4 *= 14);
            StringBuilder sb = stringBuilder;
            i = 0;
            sb.append('{');
            i$iv = 0;
            while (i$iv < obj.get_size$collection()) {
                if (i$iv > 0) {
                }
                valueAt = obj.valueAt(i$iv);
                if (valueAt != obj) {
                } else {
                }
                sb.append("(this Set)");
                i$iv++;
                sb.append(valueAt);
                sb.append(", ");
            }
            sb.append('}');
            Intrinsics.checkNotNullExpressionValue(stringBuilder.toString(), "StringBuilder(capacity).…builderAction).toString()");
        }
        return string;
    }

    public final E valueAt(int index) {
        final int i = 0;
        return this.getArray$collection()[index];
    }
}
