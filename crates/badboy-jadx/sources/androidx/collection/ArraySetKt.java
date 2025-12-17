package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u001a\u0015\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004H\u0086\u0008\u001a+\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00040\u0006\"\u0002H\u0004¢\u0006\u0002\u0010\u0007\u001a)\u0010\u0008\u001a\u00020\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0003H\u0080\u0008\u001a'\u0010\u0008\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\u0008\u001a&\u0010\u000f\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\u0080\u0008¢\u0006\u0002\u0010\u0011\u001a \u0010\u0012\u001a\u00020\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0016\u001a\u00020\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\u0008\u001a'\u0010\u0017\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\u0008\u001a&\u0010\u0018\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\u0080\u0008¢\u0006\u0002\u0010\u0011\u001a!\u0010\u0019\u001a\u00020\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u001a\u001a\u00020\u0001H\u0080\u0008\u001a#\u0010\u001b\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0080\u0008\u001a\u0019\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\u0008\u001a*\u0010\u001f\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0008\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a#\u0010!\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0008\u0010 \u001a\u0004\u0018\u00010\u001dH\u0080\u0008\u001a\u0018\u0010\"\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u0003H\u0000\u001a\u0019\u0010#\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\u0008\u001a)\u0010$\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0003H\u0080\u0008\u001a'\u0010$\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\u0008\u001a&\u0010%\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001a\u00020\u0001H\u0080\u0008¢\u0006\u0002\u0010'\u001a&\u0010(\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\u0080\u0008¢\u0006\u0002\u0010\u0011\u001a'\u0010)\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000eH\u0080\u0008\u001a\u0019\u0010*\u001a\u00020+\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\u0008\u001a&\u0010,\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001a\u00020\u0001H\u0080\u0008¢\u0006\u0002\u0010'\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"ARRAY_SET_BASE_SIZE", "", "arraySetOf", "Landroidx/collection/ArraySet;", "T", "values", "", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "addAllInternal", "", "E", "array", "", "elements", "", "addInternal", "element", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)Z", "allocArrays", "size", "binarySearchInternal", "hash", "clearInternal", "containsAllInternal", "containsInternal", "ensureCapacityInternal", "minimumCapacity", "equalsInternal", "other", "", "hashCodeInternal", "indexOf", "key", "indexOfInternal", "indexOfNull", "isEmptyInternal", "removeAllInternal", "removeAtInternal", "index", "(Landroidx/collection/ArraySet;I)Ljava/lang/Object;", "removeInternal", "retainAllInternal", "toStringInternal", "", "valueAtInternal", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArraySetKt {

    public static final int ARRAY_SET_BASE_SIZE = 4;
    public static final <E> void addAllInternal(androidx.collection.ArraySet<E> $this$addAllInternal, androidx.collection.ArraySet<? extends E> array) {
        int i;
        Object array$collection;
        int i3;
        int i5;
        int i2;
        int i4;
        Intrinsics.checkNotNullParameter($this$addAllInternal, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        int i6 = 0;
        final int i9 = array.get_size$collection();
        $this$addAllInternal.ensureCapacity(i7 += i9);
        if ($this$addAllInternal.get_size$collection() == 0) {
            if (i9 > 0) {
                i2 = 6;
                i4 = 0;
                i3 = 0;
                i5 = 0;
                ArraysKt.copyInto$default(array.getHashes$collection(), $this$addAllInternal.getHashes$collection(), i3, i5, i9, i2, i4);
                ArraysKt.copyInto$default(array.getArray$collection(), $this$addAllInternal.getArray$collection(), i3, i5, i9, i2, i4);
                if ($this$addAllInternal.get_size$collection() != 0) {
                } else {
                    $this$addAllInternal.set_size$collection(i9);
                }
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                throw concurrentModificationException;
            }
        } else {
            i = 0;
            while (i < i9) {
                $this$addAllInternal.add(array.valueAt(i));
                i++;
            }
        }
    }

    public static final <E> boolean addAllInternal(androidx.collection.ArraySet<E> $this$addAllInternal, Collection<? extends E> elements) {
        int added;
        Object next;
        boolean z;
        Intrinsics.checkNotNullParameter($this$addAllInternal, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        $this$addAllInternal.ensureCapacity(i2 += size);
        added = 0;
        Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            added |= z;
        }
        return added;
    }

    public static final <E> boolean addInternal(androidx.collection.ArraySet<E> $this$addInternal, E element) {
        int hash;
        int index;
        int oarray;
        int length2;
        int array$collection;
        int hashes$collection;
        Object[] array$collection3;
        Object[] array$collection2;
        int i3;
        int i2;
        int length;
        int i;
        int i4;
        final Object obj = $this$addInternal;
        final Object obj2 = element;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        int i5 = 0;
        final int i6 = obj.get_size$collection();
        int i7 = 0;
        int i8 = 0;
        if (obj2 == null) {
            hash = 0;
            index = ArraySetKt.indexOfNull(obj);
        } else {
            index = ArraySetKt.indexOf(obj, obj2, obj2.hashCode());
        }
        if (index >= 0) {
            return 0;
        }
        int index2 = ~index;
        int i12 = 1;
        if (i6 >= hashes$collection5.length) {
            if (i6 >= 8) {
                i11 += i6;
            } else {
                hashes$collection = 4;
                if (i6 >= hashes$collection) {
                } else {
                    array$collection = hashes$collection;
                }
            }
            hashes$collection = obj.getHashes$collection();
            array$collection3 = obj.getArray$collection();
            ArraySetKt.allocArrays(obj, array$collection);
            if (i6 != obj.get_size$collection()) {
            } else {
                if (hashes$collection8.length == 0) {
                    oarray = i12;
                }
                if (oarray == null) {
                    oarray = array$collection3;
                    i3 = 0;
                    ArraysKt.copyInto$default(hashes$collection, obj.getHashes$collection(), 0, i3, hashes$collection.length, 6, 0);
                    ArraysKt.copyInto$default(oarray, obj.getArray$collection(), i3, 0, oarray.length, 6, 0);
                } else {
                    oarray = array$collection3;
                }
            }
            ConcurrentModificationException concurrentModificationException2 = new ConcurrentModificationException();
            throw concurrentModificationException2;
        }
        if (index2 < i6) {
            ArraysKt.copyInto(obj.getHashes$collection(), obj.getHashes$collection(), index2 + 1, index2, i6);
            ArraysKt.copyInto(obj.getArray$collection(), obj.getArray$collection(), index2 + 1, index2, i6);
        }
        if (i6 != obj.get_size$collection()) {
        } else {
            if (index2 >= hashes$collection2.length) {
            } else {
                obj.getHashes$collection()[index2] = hash;
                obj.getArray$collection()[index2] = obj2;
                obj.set_size$collection(i9 += i12);
                return i12;
            }
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public static final <E> void allocArrays(androidx.collection.ArraySet<E> $this$allocArrays, int size) {
        Intrinsics.checkNotNullParameter($this$allocArrays, "<this>");
        $this$allocArrays.setHashes$collection(new int[size]);
        $this$allocArrays.setArray$collection(new Object[size]);
    }

    public static final <T> androidx.collection.ArraySet<T> arraySetOf() {
        final int i = 0;
        ArraySet arraySet = new ArraySet(0, 1, 0);
        return arraySet;
    }

    public static final <T> androidx.collection.ArraySet<T> arraySetOf(T... values) {
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(values, "values");
        ArraySet arraySet = new ArraySet(values.length);
        i = 0;
        while (i < values.length) {
            arraySet.add(values[i]);
            i++;
        }
        return arraySet;
    }

    public static final <E> int binarySearchInternal(androidx.collection.ArraySet<E> $this$binarySearchInternal, int hash) {
        Intrinsics.checkNotNullParameter($this$binarySearchInternal, "<this>");
        return ContainerHelpersKt.binarySearch($this$binarySearchInternal.getHashes$collection(), $this$binarySearchInternal.get_size$collection(), hash);
    }

    public static final <E> void clearInternal(androidx.collection.ArraySet<E> $this$clearInternal) {
        int i;
        Intrinsics.checkNotNullParameter($this$clearInternal, "<this>");
        int i2 = 0;
        if ($this$clearInternal.get_size$collection() != 0) {
            $this$clearInternal.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            $this$clearInternal.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            $this$clearInternal.set_size$collection(0);
        }
        if ($this$clearInternal.get_size$collection() != 0) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public static final <E> boolean containsAllInternal(androidx.collection.ArraySet<E> $this$containsAllInternal, Collection<? extends E> elements) {
        Object next;
        boolean contains;
        Intrinsics.checkNotNullParameter($this$containsAllInternal, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        Iterator iterator = elements.iterator();
        for (Object next : iterator) {
        }
        return 1;
    }

    public static final <E> boolean containsInternal(androidx.collection.ArraySet<E> $this$containsInternal, E element) {
        int i;
        Intrinsics.checkNotNullParameter($this$containsInternal, "<this>");
        int i2 = 0;
        i = $this$containsInternal.indexOf(element) >= 0 ? 1 : 0;
        return i;
    }

    public static final <E> void ensureCapacityInternal(androidx.collection.ArraySet<E> $this$ensureCapacityInternal, int minimumCapacity) {
        int array$collection2;
        int[] hashes$collection;
        Object[] oarray;
        Object[] array$collection;
        int i2;
        int i3;
        int i;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter($this$ensureCapacityInternal, "<this>");
        int i6 = 0;
        if (hashes$collection2.length < minimumCapacity) {
            array$collection2 = $this$ensureCapacityInternal.getArray$collection();
            ArraySetKt.allocArrays($this$ensureCapacityInternal, minimumCapacity);
            if ($this$ensureCapacityInternal.get_size$collection() > 0) {
                i2 = 0;
                ArraysKt.copyInto$default($this$ensureCapacityInternal.getHashes$collection(), $this$ensureCapacityInternal.getHashes$collection(), 0, i2, $this$ensureCapacityInternal.get_size$collection(), 6, 0);
                ArraysKt.copyInto$default(array$collection2, $this$ensureCapacityInternal.getArray$collection(), i2, 0, $this$ensureCapacityInternal.get_size$collection(), 6, 0);
            } else {
                oarray = array$collection2;
            }
        }
        if ($this$ensureCapacityInternal.get_size$collection() != $this$ensureCapacityInternal.get_size$collection()) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public static final <E> boolean equalsInternal(androidx.collection.ArraySet<E> $this$equalsInternal, Object other) {
        int i;
        Object valueAt;
        boolean contains;
        Intrinsics.checkNotNullParameter($this$equalsInternal, "<this>");
        int i2 = 0;
        final int i3 = 1;
        if ($this$equalsInternal == other) {
            return i3;
        }
        final int i4 = 0;
        if (other instanceof Set != null && $this$equalsInternal.size() != (Set)other.size()) {
            if ($this$equalsInternal.size() != (Set)other.size()) {
                return i4;
            }
            i = 0;
            while (i < $this$equalsInternal.get_size$collection()) {
                i++;
            }
            return i3;
        }
        return i4;
    }

    public static final <E> int hashCodeInternal(androidx.collection.ArraySet<E> $this$hashCodeInternal) {
        int result;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$hashCodeInternal, "<this>");
        int i3 = 0;
        result = 0;
        i = 0;
        while (i < $this$hashCodeInternal.get_size$collection()) {
            result += i2;
            i++;
        }
        return result;
    }

    public static final <E> int indexOf(androidx.collection.ArraySet<E> $this$indexOf, Object key, int hash) {
        int end;
        boolean equal2;
        int i;
        boolean equal;
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        int i2 = $this$indexOf.get_size$collection();
        if (i2 == 0) {
            return -1;
        }
        int binarySearchInternal = ArraySetKt.binarySearchInternal($this$indexOf, hash);
        if (binarySearchInternal < 0) {
            return binarySearchInternal;
        }
        if (Intrinsics.areEqual(key, $this$indexOf.getArray$collection()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        end = binarySearchInternal + 1;
        while (end < i2) {
            end++;
        }
        i = binarySearchInternal + -1;
        while (i >= 0) {
            i--;
        }
        return ~end;
    }

    public static final <E> int indexOfInternal(androidx.collection.ArraySet<E> $this$indexOfInternal, Object key) {
        int indexOfNull;
        Intrinsics.checkNotNullParameter($this$indexOfInternal, "<this>");
        int i = 0;
        if (key == null) {
            indexOfNull = ArraySetKt.indexOfNull($this$indexOfInternal);
        } else {
            indexOfNull = ArraySetKt.indexOf($this$indexOfInternal, key, key.hashCode());
        }
        return indexOfNull;
    }

    public static final <E> int indexOfNull(androidx.collection.ArraySet<E> $this$indexOfNull) {
        Intrinsics.checkNotNullParameter($this$indexOfNull, "<this>");
        return ArraySetKt.indexOf($this$indexOfNull, 0, 0);
    }

    public static final <E> boolean isEmptyInternal(androidx.collection.ArraySet<E> $this$isEmptyInternal) {
        int i;
        Intrinsics.checkNotNullParameter($this$isEmptyInternal, "<this>");
        int i2 = 0;
        i = $this$isEmptyInternal.get_size$collection() <= 0 ? 1 : 0;
        return i;
    }

    public static final <E> boolean removeAllInternal(androidx.collection.ArraySet<E> $this$removeAllInternal, androidx.collection.ArraySet<? extends E> array) {
        int i2;
        int i;
        Object valueAt;
        Intrinsics.checkNotNullParameter($this$removeAllInternal, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        int i3 = 0;
        i2 = 0;
        while (i2 < array.get_size$collection()) {
            $this$removeAllInternal.remove(array.valueAt(i2));
            i2++;
        }
        i = $this$removeAllInternal.get_size$collection() != $this$removeAllInternal.get_size$collection() ? 1 : 0;
        return i;
    }

    public static final <E> boolean removeAllInternal(androidx.collection.ArraySet<E> $this$removeAllInternal, Collection<? extends E> elements) {
        int removed;
        Object next;
        boolean remove;
        Intrinsics.checkNotNullParameter($this$removeAllInternal, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        removed = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            removed |= remove;
        }
        return removed;
    }

    public static final <E> E removeAtInternal(androidx.collection.ArraySet<E> $this$removeAtInternal, int index) {
        int array$collection4;
        Object[] ohashes;
        int array$collection2;
        int array$collection;
        int i5;
        int i;
        int i3;
        int i6;
        int i7;
        int i4;
        int i2;
        Object[] array$collection3;
        int[] iArr;
        Intrinsics.checkNotNullParameter($this$removeAtInternal, "<this>");
        final int i13 = 0;
        final int i14 = $this$removeAtInternal.get_size$collection();
        if (i14 <= 1) {
            $this$removeAtInternal.clear();
            i3 = index;
            return $this$removeAtInternal.getArray$collection()[index];
        } else {
            i4 = i14 + -1;
            i5 = 8;
            if (hashes$collection3.length > i5 && $this$removeAtInternal.get_size$collection() < length /= 3) {
                if ($this$removeAtInternal.get_size$collection() < length /= 3) {
                    if ($this$removeAtInternal.get_size$collection() > i5) {
                        i5 = array$collection2 + array$collection4;
                    } else {
                    }
                    int[] hashes$collection = $this$removeAtInternal.getHashes$collection();
                    array$collection3 = $this$removeAtInternal.getArray$collection();
                    ArraySetKt.allocArrays($this$removeAtInternal, i5);
                    if (index > 0) {
                        i6 = 6;
                        i7 = 0;
                        i5 = 0;
                        i = 0;
                        i3 = index;
                        ArraysKt.copyInto$default(hashes$collection, $this$removeAtInternal.getHashes$collection(), i5, i, i3, i6, i7);
                        iArr = hashes$collection;
                        ArraysKt.copyInto$default(array$collection3, $this$removeAtInternal.getArray$collection(), i5, i, i3, i6, i7);
                    } else {
                        i3 = index;
                        iArr = hashes$collection;
                        ohashes = array$collection3;
                    }
                    if (i3 < i4) {
                        ArraysKt.copyInto(iArr, $this$removeAtInternal.getHashes$collection(), index, i3 + 1, i4 + 1);
                        ArraysKt.copyInto(ohashes, $this$removeAtInternal.getArray$collection(), index, i3 + 1, i4 + 1);
                    }
                } else {
                    i3 = index;
                    if (i3 < i4) {
                        ArraysKt.copyInto($this$removeAtInternal.getHashes$collection(), $this$removeAtInternal.getHashes$collection(), index, i3 + 1, i4 + 1);
                        ArraysKt.copyInto($this$removeAtInternal.getArray$collection(), $this$removeAtInternal.getArray$collection(), index, i3 + 1, i4 + 1);
                    }
                    $this$removeAtInternal.getArray$collection()[i4] = 0;
                }
            } else {
            }
            if (i14 != $this$removeAtInternal.get_size$collection()) {
            } else {
                $this$removeAtInternal.set_size$collection(i4);
            }
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public static final <E> boolean removeInternal(androidx.collection.ArraySet<E> $this$removeInternal, E element) {
        Intrinsics.checkNotNullParameter($this$removeInternal, "<this>");
        int i = 0;
        final int indexOf = $this$removeInternal.indexOf(element);
        if (indexOf >= 0) {
            $this$removeInternal.removeAt(indexOf);
            return 1;
        }
        return 0;
    }

    public static final <E> boolean retainAllInternal(androidx.collection.ArraySet<E> $this$retainAllInternal, Collection<? extends E> elements) {
        int removed;
        int i;
        boolean contains;
        Object obj;
        Intrinsics.checkNotNullParameter($this$retainAllInternal, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i2 = 0;
        removed = 0;
        i3--;
        while (-1 < i) {
            if (!CollectionsKt.contains((Iterable)elements, $this$retainAllInternal.getArray$collection()[i])) {
            }
            i--;
            $this$retainAllInternal.removeAt(i);
            removed = 1;
        }
        return removed;
    }

    public static final <E> String toStringInternal(androidx.collection.ArraySet<E> $this$toStringInternal) {
        int i;
        Object valueAt;
        String str;
        Intrinsics.checkNotNullParameter($this$toStringInternal, "<this>");
        int i2 = 0;
        if ($this$toStringInternal.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(i3 *= 14);
        StringBuilder sb = stringBuilder;
        final int i5 = 0;
        sb.append('{');
        i = 0;
        while (i < $this$toStringInternal.get_size$collection()) {
            if (i > 0) {
            }
            valueAt = $this$toStringInternal.valueAt(i);
            if (valueAt != $this$toStringInternal) {
            } else {
            }
            sb.append("(this Set)");
            i++;
            sb.append(valueAt);
            sb.append(", ");
        }
        sb.append('}');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final <E> E valueAtInternal(androidx.collection.ArraySet<E> $this$valueAtInternal, int index) {
        Intrinsics.checkNotNullParameter($this$valueAtInternal, "<this>");
        int i = 0;
        return $this$valueAtInternal.getArray$collection()[index];
    }
}
