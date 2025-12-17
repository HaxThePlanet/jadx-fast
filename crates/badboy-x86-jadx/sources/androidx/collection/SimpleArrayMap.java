package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008)\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u0003B!\u0008\u0016\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0006\u0008\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0011\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0013\u0010\u0019\u001a\u00020\u00122\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00028\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u0002H!\"\n\u0008\u0002\u0010!*\u0004\u0018\u00018\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u0002H!H\u0082\u0008¢\u0006\u0002\u0010\u001fJ\u0008\u0010\"\u001a\u00020\u0007H\u0016J\u001d\u0010#\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\u0008\u0010(\u001a\u00020\u0007H\u0002J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0001¢\u0006\u0004\u0008*\u0010'J\u0008\u0010+\u001a\u00020\u0012H\u0016J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ \u00100\u001a\u00020\u00102\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0006\u0008\u0001\u0012\u00028\u00010\u0000H\u0016J\u001f\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001d\u00102\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ%\u00105\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u00012\u0006\u00107\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001d\u00109\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010:J\u0008\u0010\u000e\u001a\u00020\u0007H\u0016J\u0008\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>", d2 = {"Landroidx/collection/SimpleArrayMap;", "K", "V", "", "map", "(Landroidx/collection/SimpleArrayMap;)V", "capacity", "", "(I)V", "array", "", "[Ljava/lang/Object;", "hashes", "", "size", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefaultInternal", "T", "hashCode", "indexOf", "hash", "(Ljava/lang/Object;I)I", "indexOfKey", "(Ljava/lang/Object;)I", "indexOfNull", "indexOfValue", "__restricted$indexOfValue", "isEmpty", "keyAt", "index", "(I)Ljava/lang/Object;", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SimpleArrayMap<K, V>  {

    private Object[] array;
    private int[] hashes;
    private int size;
    public SimpleArrayMap() {
        super(0, 1, 0);
    }

    public SimpleArrayMap(int capacity) {
        int[] eMPTY_INTS;
        Object[] eMPTY_OBJECTS;
        super();
        eMPTY_INTS = capacity == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[capacity];
        this.hashes = eMPTY_INTS;
        eMPTY_OBJECTS = capacity == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i];
        this.array = eMPTY_OBJECTS;
    }

    public SimpleArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public SimpleArrayMap(androidx.collection.SimpleArrayMap<? extends K, ? extends V> map) {
        super(0, 1, 0);
        if (map != null) {
            putAll(map);
        }
    }

    private final <T extends V> T getOrDefaultInternal(Object key, T defaultValue) {
        Object obj;
        int i;
        final int i2 = 0;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = this.array[i3++];
        } else {
            obj = defaultValue;
        }
        return obj;
    }

    private final int indexOf(K key, int hash) {
        int end;
        int equal;
        int i2;
        int equal2;
        int i;
        final int size = this.size;
        if (size == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, size, hash);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (Intrinsics.areEqual(key, this.array[binarySearch << 1])) {
            return binarySearch;
        }
        end = binarySearch + 1;
        while (end < size) {
            end++;
        }
        i2 = binarySearch + -1;
        while (i2 >= 0) {
            i2--;
        }
        return ~end;
    }

    private final int indexOfNull() {
        int end;
        int i;
        int i4;
        int i2;
        int i3;
        final int size = this.size;
        if (size == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, size, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.array[binarySearch << 1] == null) {
            return binarySearch;
        }
        end = binarySearch + 1;
        while (end < size) {
            end++;
        }
        i4 = binarySearch + -1;
        while (i4 >= 0) {
            i4--;
        }
        return ~end;
    }

    public final int __restricted$indexOfValue(V value) {
        int i;
        boolean equal;
        size *= 2;
        final Object[] array = this.array;
        if (value == null) {
            i = 1;
            while (i < i2) {
                i += 2;
            }
        } else {
            i = 1;
            while (i < i2) {
                i += 2;
            }
        }
        return -1;
    }

    public void clear() {
        int size;
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean containsKey(K key) {
        int i;
        i = indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public boolean containsValue(V value) {
        int i;
        i = __restricted$indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public void ensureCapacity(int minimumCapacity) {
        int copyOf;
        String str;
        int i;
        if (hashes.length < minimumCapacity) {
            int[] copyOf2 = Arrays.copyOf(this.hashes, minimumCapacity);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            this.hashes = copyOf2;
            copyOf = Arrays.copyOf(this.array, minimumCapacity * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            this.array = copyOf;
        }
        if (this.size != this.size) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean equals(Object other) {
        int i;
        int i3;
        int i2;
        Object keyAt;
        Object valueAt;
        Object valueAt2;
        Object equal;
        boolean equal2;
        i = 1;
        if (this == other) {
            return i;
        }
        final int i4 = 0;
        if (other instanceof SimpleArrayMap != null && size() != (SimpleArrayMap)other.size()) {
            if (size() != (SimpleArrayMap)other.size()) {
                return i4;
            }
            Object obj = other;
            i2 = 0;
            try {
                while (i2 < this.size) {
                    valueAt = keyAt(i2);
                    valueAt2 = valueAt(i2);
                    equal = (SimpleArrayMap)obj.get(valueAt);
                    i2++;
                }
                valueAt = keyAt(i2);
                valueAt2 = valueAt(i2);
                equal = obj.get(valueAt);
                if (valueAt2 == null) {
                } else {
                }
                if (equal == null) {
                }
                if (!obj.containsKey(valueAt)) {
                } else {
                }
                return i4;
                if (!Intrinsics.areEqual(valueAt2, equal)) {
                } else {
                }
                return i4;
                i2++;
                return i;
                if (other instanceof Map != null && size() != (Map)other.size()) {
                }
                if (size() != (Map)other.size()) {
                }
                return i4;
                i3 = 0;
                while (i3 < this.size) {
                    keyAt = keyAt(i3);
                    valueAt = valueAt(i3);
                    valueAt2 = (Map)other.get(keyAt);
                    i3++;
                }
                keyAt = keyAt(i3);
                valueAt = valueAt(i3);
                valueAt2 = (Map)other.get(keyAt);
                if (valueAt == null) {
                } else {
                }
                if (valueAt2 == null) {
                }
                if (!(Map)other.containsKey(keyAt)) {
                } else {
                }
                return i4;
                if (!Intrinsics.areEqual(valueAt, valueAt2)) {
                } else {
                }
                return i4;
                i3++;
                return i;
                return i4;
            }
        }
    }

    public V get(K key) {
        Object obj;
        int i;
        final Object obj2 = this;
        final int i3 = 0;
        final int indexOfKey = obj2.indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = obj2.array[i4++];
        } else {
            obj = i2;
        }
        return obj;
    }

    public V getOrDefault(Object key, V defaultValue) {
        Object obj;
        int i;
        final Object obj2 = this;
        final int i2 = 0;
        final int indexOfKey = obj2.indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = obj2.array[i3++];
        } else {
            obj = defaultValue;
        }
        return obj;
    }

    public int hashCode() {
        int result;
        int i;
        int v;
        Object obj;
        int i3;
        int i2;
        result = 0;
        i = 0;
        v = 1;
        while (i < this.size) {
            obj = this.array[v];
            if (obj != null) {
            } else {
            }
            i2 = 0;
            result += i3;
            i++;
            v += 2;
            i2 = obj.hashCode();
        }
        return result;
    }

    public int indexOfKey(K key) {
        int indexOfNull;
        if (key == null) {
            indexOfNull = indexOfNull();
        } else {
            indexOfNull = indexOf(key, key.hashCode());
        }
        return indexOfNull;
    }

    public boolean isEmpty() {
        int i;
        i = this.size <= 0 ? 1 : 0;
        return i;
    }

    public K keyAt(int index) {
        int i;
        int size;
        i = 0;
        if (index >= 0 && index < this.size) {
            if (index < this.size) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            return this.array[index << 1];
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public V put(K key, V value) {
        int i;
        int it;
        int i2;
        int length;
        int length2;
        int array;
        String str;
        int i3;
        int i4;
        final int size = this.size;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        if (key != null) {
            i2 = 0;
            it = indexOf(key, i);
        } else {
            it = indexOfNull();
        }
        if (it >= 0) {
            i5++;
            this.array[i6] = value;
            return this.array[i6];
        }
        int old = ~it;
        if (size >= hashes.length) {
            if (size >= 8) {
                i9 += size;
            } else {
                array = 4;
                if (size >= array) {
                } else {
                    length = array;
                }
            }
            int[] copyOf = Arrays.copyOf(this.hashes, length);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, length << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            this.array = copyOf2;
            if (size != this.size) {
            } else {
            }
            ConcurrentModificationException concurrentModificationException2 = new ConcurrentModificationException();
            throw concurrentModificationException2;
        }
        if (old < size) {
            ArraysKt.copyInto(this.hashes, this.hashes, old + 1, old, size);
            ArraysKt.copyInto(this.array, this.array, i14 <<= 1, old << 1, size3 <<= 1);
        }
        if (size != this.size) {
        } else {
            if (old >= hashes3.length) {
            } else {
                this.hashes[old] = i;
                this.array[old << 1] = key;
                this.array[i11++] = value;
                this.size = size2++;
                return 0;
            }
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public void putAll(androidx.collection.SimpleArrayMap<? extends K, ? extends V> map) {
        int i;
        Object keyAt;
        Object valueAt;
        int i2;
        Intrinsics.checkNotNullParameter(map, "map");
        int size = map.size;
        ensureCapacity(size2 += size);
        if (this.size == 0) {
            if (size > 0) {
                valueAt = 0;
                ArraysKt.copyInto(map.hashes, this.hashes, valueAt, valueAt, size);
                ArraysKt.copyInto(map.array, this.array, valueAt, valueAt, size << 1);
                this.size = size;
            }
        } else {
            i = 0;
            while (i < size) {
                put(map.keyAt(i), map.valueAt(i));
                i++;
            }
        }
    }

    public V putIfAbsent(K key, V value) {
        Object mapValue;
        if (get(key) == null) {
            mapValue = put(key, value);
        }
        return mapValue;
    }

    public V remove(K key) {
        Object obj;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = removeAt(indexOfKey);
        } else {
            obj = 0;
        }
        return obj;
    }

    public boolean remove(K key, V value) {
        Object valueAt;
        boolean equal;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(value, valueAt(indexOfKey))) {
            if (Intrinsics.areEqual(value, valueAt(indexOfKey))) {
                removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public V removeAt(int index) {
        int array;
        int i;
        int size;
        int i3;
        int i2;
        int hashes;
        int length;
        int i4;
        int array3;
        int array2;
        String str;
        int i5;
        array = 0;
        i = 1;
        if (index >= 0 && index < this.size) {
            i3 = index < this.size ? i : array;
        } else {
        }
        if (i3 == 0) {
        } else {
            int size2 = this.size;
            if (size2 <= i) {
                clear();
                return this.array[i7 += i];
            } else {
                i2 = size2 + -1;
                i4 = 8;
                if (hashes4.length > i4 && size2 < length2 /= 3) {
                    if (size2 < length2 /= 3) {
                        if (size2 > i4) {
                            i4 = size2 + length;
                        } else {
                        }
                        hashes = this.hashes;
                        array3 = this.array;
                        int[] copyOf = Arrays.copyOf(this.hashes, i4);
                        str = "copyOf(this, newSize)";
                        Intrinsics.checkNotNullExpressionValue(copyOf, str);
                        this.hashes = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(this.array, i4 << 1);
                        Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                        this.array = copyOf2;
                        if (size2 != this.size) {
                        } else {
                            if (index > 0) {
                                ArraysKt.copyInto(hashes, this.hashes, array, array, index);
                                ArraysKt.copyInto(array3, this.array, array, array, index << 1);
                            }
                            if (index < i2) {
                                ArraysKt.copyInto(hashes, this.hashes, index, index + 1, i2 + 1);
                                ArraysKt.copyInto(array3, this.array, index << 1, i17 <<= i, i5 << 1);
                            }
                            if (size2 != this.size) {
                            } else {
                                this.size = i2;
                            }
                        }
                        ConcurrentModificationException concurrentModificationException2 = new ConcurrentModificationException();
                        throw concurrentModificationException2;
                    }
                }
                if (index < i2) {
                    ArraysKt.copyInto(this.hashes, this.hashes, index, index + 1, i2 + 1);
                    ArraysKt.copyInto(this.array, this.array, index << 1, i13 <<= i, i14 <<= i);
                }
                i4 = 0;
                this.array[i2 << 1] = i4;
                this.array[i10 += i] = i4;
            }
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
            throw concurrentModificationException;
        }
        int i6 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public V replace(K key, V value) {
        Object valueAt;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            valueAt = setValueAt(indexOfKey, value);
        } else {
            valueAt = 0;
        }
        return valueAt;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        Object valueAt;
        boolean equal;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(oldValue, valueAt(indexOfKey))) {
            if (Intrinsics.areEqual(oldValue, valueAt(indexOfKey))) {
                setValueAt(indexOfKey, newValue);
                return 1;
            }
        }
        return 0;
    }

    public V setValueAt(int index, V value) {
        int i;
        int size;
        i = 0;
        int i4 = 1;
        if (index >= 0 && index < this.size) {
            if (index < this.size) {
                i = i4;
            }
        }
        if (i == 0) {
        } else {
            i2 += i4;
            this.array[i3] = value;
            return this.array[i3];
        }
        int indexInArray = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i;
        Object keyAt;
        String str;
        Object valueAt;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(size *= 28);
        StringBuilder sb = stringBuilder;
        final int i3 = 0;
        sb.append('{');
        i = 0;
        while (i < this.size) {
            if (i > 0) {
            }
            keyAt = keyAt(i);
            str = "(this Map)";
            if (keyAt != sb) {
            } else {
            }
            sb.append(str);
            sb.append('=');
            valueAt = valueAt(i);
            if (valueAt != sb) {
            } else {
            }
            sb.append(str);
            i++;
            sb.append(valueAt);
            sb.append(keyAt);
            sb.append(", ");
        }
        sb.append('}');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public V valueAt(int index) {
        int i;
        int size;
        i = 0;
        int i3 = 1;
        if (index >= 0 && index < this.size) {
            if (index < this.size) {
                i = i3;
            }
        }
        if (i == 0) {
        } else {
            return this.array[i4 += i3];
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }
}
