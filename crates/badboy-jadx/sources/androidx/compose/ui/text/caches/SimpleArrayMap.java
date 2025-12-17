package androidx.compose.ui.text.caches;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008'\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u0003B\u0011\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0008\u0016\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005J\u0013\u0010\u001f\u001a\u00020\u00182\u0008\u0010 \u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\"J\u001b\u0010#\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0008\u0010&\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0005H\u0004J\u0010\u0010)\u001a\u00020\u00052\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0008\u0010*\u001a\u00020\u0005H\u0004J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00028\u0001H\u0000¢\u0006\u0004\u0008,\u0010-J\u0006\u0010.\u001a\u00020\u0018J\u0013\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u00101J\u001d\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u001e\u00103\u001a\u00020\u00162\u0016\u00104\u001a\u0012\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0006\u0008\u0001\u0012\u00028\u00010\u0000J\u001d\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0015\u00106\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u001b\u00106\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u00107J\u0015\u00108\u001a\u0004\u0018\u00018\u00012\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u00101J\u001d\u00109\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010%J#\u00109\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010:\u001a\u00028\u00012\u0006\u0010;\u001a\u00028\u0001¢\u0006\u0002\u0010<J\u001b\u0010=\u001a\u00028\u00012\u0006\u00100\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010>J\u0008\u0010?\u001a\u00020@H\u0016J\u0013\u0010A\u001a\u00028\u00012\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u00101R\u001a\u0010\t\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00058G¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u000b¨\u0006B", d2 = {"Landroidx/compose/ui/text/caches/SimpleArrayMap;", "K", "V", "", "capacity", "", "(I)V", "map", "(Landroidx/compose/ui/text/caches/SimpleArrayMap;)V", "_size", "get_size", "()I", "set_size", "hashes", "", "keyValues", "", "[Ljava/lang/Object;", "size", "size$annotations", "()V", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "indexOf", "hash", "indexOfKey", "indexOfNull", "indexOfValue", "indexOfValue$ui_text_release", "(Ljava/lang/Object;)I", "isEmpty", "keyAt", "index", "(I)Ljava/lang/Object;", "put", "putAll", "array", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleArrayMap<K, V>  {

    public static final int $stable = 8;
    private int _size;
    private int[] hashes;
    private Object[] keyValues;
    static {
        final int i = 8;
    }

    public SimpleArrayMap() {
        super(0, 1, 0);
    }

    public SimpleArrayMap(int capacity) {
        Object[] eMPTY_OBJECTS;
        super();
        if (capacity == 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            this.hashes = new int[capacity];
            this.keyValues = new Object[capacity << 1];
        }
        this._size = 0;
    }

    public SimpleArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public SimpleArrayMap(androidx.compose.ui.text.caches.SimpleArrayMap<K, V> map) {
        super(0, 1, 0);
        if (map != null) {
            putAll(map);
        }
    }

    public static void size$annotations() {
    }

    public final void clear() {
        int _size;
        if (this._size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
            this._size = 0;
        }
        if (this._size > 0) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public final boolean containsKey(K key) {
        int i;
        i = indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public final boolean containsValue(V value) {
        int i;
        i = indexOfValue$ui_text_release(value) >= 0 ? 1 : 0;
        return i;
    }

    public final void ensureCapacity(int minimumCapacity) {
        int copyOf;
        String str;
        int i;
        if (hashes.length < minimumCapacity) {
            int[] copyOf2 = Arrays.copyOf(this.hashes, minimumCapacity);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            this.hashes = copyOf2;
            copyOf = Arrays.copyOf(this.keyValues, minimumCapacity << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            this.keyValues = copyOf;
        }
        if (this._size != this._size) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean equals(Object other) {
        int i;
        int i2;
        int i3;
        Object keyAt;
        Object valueAt;
        Object obj;
        boolean equal;
        i = 1;
        if (this == other) {
            return i;
        }
        final int i4 = 0;
        Object obj2 = other;
        if (other instanceof SimpleArrayMap != null && this._size != obj2._size) {
            obj2 = other;
            if (this._size != obj2._size) {
                return i4;
            }
            i2 = 0;
            try {
                while (i2 < this._size) {
                    keyAt = keyAt(i2);
                    valueAt = valueAt(i2);
                    obj = (SimpleArrayMap)(SimpleArrayMap)obj2.get(keyAt);
                    i2++;
                }
                keyAt = keyAt(i2);
                valueAt = valueAt(i2);
                obj = obj2.get(keyAt);
                if (valueAt == null) {
                } else {
                }
                if (obj == null) {
                }
                if (!obj2.containsKey(keyAt)) {
                } else {
                }
                return i4;
                if (!Intrinsics.areEqual(valueAt, obj)) {
                } else {
                }
                return i4;
                i2++;
                return i;
                Object obj3 = other;
                if (other instanceof Map != null && this._size != (Map)obj3.size()) {
                }
                obj3 = other;
                if (this._size != (Map)obj3.size()) {
                }
                return i4;
                i3 = 0;
                while (i3 < this._size) {
                    keyAt = keyAt(i3);
                    valueAt = valueAt(i3);
                    obj = (Map)obj3.get(keyAt);
                    i3++;
                }
                keyAt = keyAt(i3);
                valueAt = valueAt(i3);
                obj = (Map)obj3.get(keyAt);
                if (valueAt == null) {
                } else {
                }
                if (obj == null) {
                }
                if (!(Map)obj3.containsKey(keyAt)) {
                } else {
                }
                return i4;
                if (!Intrinsics.areEqual(valueAt, obj)) {
                } else {
                }
                return i4;
                i3++;
                return i;
                return i4;
            }
        }
    }

    public final V get(K key) {
        Object obj;
        int i;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = this.keyValues[i2++];
        } else {
            obj = 0;
        }
        return obj;
    }

    public final V getOrDefault(K key, V defaultValue) {
        Object obj;
        int i;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = this.keyValues[i2++];
        } else {
            obj = defaultValue;
        }
        return obj;
    }

    protected final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int result;
        int i;
        int v;
        Object obj;
        int i2;
        int i3;
        result = 0;
        i = 0;
        v = 1;
        while (i < this._size) {
            obj = this.keyValues[v];
            if (obj != null) {
            } else {
            }
            i3 = 0;
            result += i2;
            i++;
            v += 2;
            i3 = obj.hashCode();
        }
        return result;
    }

    protected final int indexOf(Object key, int hash) {
        int end;
        int equal2;
        int i;
        int equal;
        int i2;
        final int _size = this._size;
        if (_size == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, _size, hash);
        if (binarySearchInternal < 0) {
            return binarySearchInternal;
        }
        if (Intrinsics.areEqual(key, this.keyValues[binarySearchInternal << 1])) {
            return binarySearchInternal;
        }
        int i4 = 0;
        end = binarySearchInternal + 1;
        while (end < _size) {
            end++;
        }
        i = binarySearchInternal + -1;
        while (i >= 0) {
            i--;
        }
        return ~end;
    }

    public final int indexOfKey(Object key) {
        int indexOfNull;
        if (key == null) {
            indexOfNull = indexOfNull();
        } else {
            indexOfNull = indexOf(key, key.hashCode());
        }
        return indexOfNull;
    }

    protected final int indexOfNull() {
        int end;
        int i;
        int i3;
        int i2;
        int i4;
        final int _size = this._size;
        if (_size == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, _size, 0);
        if (binarySearchInternal < 0) {
            return binarySearchInternal;
        }
        if (this.keyValues[binarySearchInternal << 1] == null) {
            return binarySearchInternal;
        }
        int i7 = 0;
        end = binarySearchInternal + 1;
        while (end < _size) {
            end++;
        }
        i3 = binarySearchInternal + -1;
        while (i3 >= 0) {
            i3--;
        }
        return ~end;
    }

    public final int indexOfValue$ui_text_release(V value) {
        int i;
        boolean equal;
        _size <<= 1;
        final Object[] keyValues = this.keyValues;
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

    public final boolean isEmpty() {
        int i;
        i = this._size <= 0 ? 1 : 0;
        return i;
    }

    public final K keyAt(int index) {
        return this.keyValues[index << 1];
    }

    public final V put(K key, V value) {
        int hash;
        int index;
        int keyValues;
        int length;
        int keyValues2;
        String str;
        int i;
        int i2;
        final int _size = this._size;
        int i3 = 0;
        int i4 = 0;
        if (key == null) {
            hash = 0;
            index = indexOfNull();
        } else {
            index = indexOf(key, key.hashCode());
        }
        if (index >= 0) {
            i5++;
            this.keyValues[i6] = value;
            return this.keyValues[i6];
        }
        int old = ~index;
        if (_size >= hashes.length) {
            if (_size >= 8) {
                i9 += _size;
            } else {
                keyValues2 = 4;
                if (_size >= keyValues2) {
                } else {
                    keyValues = keyValues2;
                }
            }
            int[] copyOf = Arrays.copyOf(this.hashes, keyValues);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, keyValues << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            this.keyValues = copyOf2;
            if (_size != this._size) {
            } else {
            }
            ConcurrentModificationException concurrentModificationException2 = new ConcurrentModificationException();
            throw concurrentModificationException2;
        }
        if (old < _size) {
            ArraysKt.copyInto(this.hashes, this.hashes, old + 1, old, _size);
            ArraysKt.copyInto(this.keyValues, this.keyValues, i14 <<= 1, old << 1, _size3 <<= 1);
        }
        if (_size != this._size) {
        } else {
            if (old >= hashes3.length) {
            } else {
                this.hashes[old] = hash;
                this.keyValues[old << 1] = key;
                this.keyValues[i11++] = value;
                this._size = _size2++;
                return 0;
            }
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public final void putAll(androidx.compose.ui.text.caches.SimpleArrayMap<? extends K, ? extends V> array) {
        int i2;
        Object keyValues;
        Object valueAt;
        int i;
        final int _size = array._size;
        ensureCapacity(_size2 += _size);
        if (this._size == 0) {
            if (_size > 0) {
                valueAt = 0;
                ArraysKt.copyInto(array.hashes, this.hashes, valueAt, valueAt, _size);
                ArraysKt.copyInto(array.keyValues, this.keyValues, valueAt, valueAt, _size << 1);
                this._size = _size;
            }
        } else {
            i2 = 0;
            while (i2 < _size) {
                put(array.keyAt(i2), array.valueAt(i2));
                i2++;
            }
        }
    }

    public final V putIfAbsent(K key, V value) {
        Object mapValue;
        if (get(key) == null) {
            mapValue = put(key, value);
        }
        return mapValue;
    }

    public final V remove(K key) {
        Object obj;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            obj = removeAt(indexOfKey);
        } else {
            obj = 0;
        }
        return obj;
    }

    public final boolean remove(K key, V value) {
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

    public final V removeAt(int index) {
        int _size;
        int i4;
        int[] keyValues;
        int keyValues3;
        int keyValues2;
        Object[] keyValues4;
        int keyValues5;
        int i;
        int i2;
        int i3;
        _size = 1;
        int _size2 = this._size;
        if (_size2 <= _size) {
            clear();
            return this.keyValues[i5 += _size];
        } else {
            i4 = _size2 + -1;
            keyValues2 = 8;
            if (hashes.length > keyValues2 && _size2 < length /= 3 && _size2 > keyValues2) {
                if (_size2 < length /= 3) {
                    if (_size2 > keyValues2) {
                        keyValues2 = _size2 + keyValues3;
                    }
                    keyValues = this.hashes;
                    keyValues4 = this.keyValues;
                    this.hashes = new int[keyValues2];
                    this.keyValues = new Object[keyValues2 << 1];
                    if (_size2 != this._size) {
                    } else {
                        if (index > 0) {
                            i = 0;
                            ArraysKt.copyInto(keyValues, this.hashes, i, i, index);
                            ArraysKt.copyInto(keyValues4, this.keyValues, i, i, index << 1);
                        }
                        if (index < i4) {
                            ArraysKt.copyInto(keyValues, this.hashes, index, index + 1, i4 + 1);
                            ArraysKt.copyInto(keyValues4, this.keyValues, index << 1, i16 <<= _size, i3 << 1);
                        }
                        if (_size2 != this._size) {
                        } else {
                            this._size = i4;
                        }
                    }
                    ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                    throw concurrentModificationException;
                }
            }
            if (index < i4) {
                ArraysKt.copyInto(this.hashes, this.hashes, index, index + 1, i4 + 1);
                ArraysKt.copyInto(this.keyValues, this.keyValues, index << 1, i12 <<= _size, i14 <<= _size);
            }
            keyValues4 = 0;
            this.keyValues[i4 << 1] = keyValues4;
            this.keyValues[i8 += _size] = keyValues4;
        }
        ConcurrentModificationException concurrentModificationException2 = new ConcurrentModificationException();
        throw concurrentModificationException2;
    }

    public final V replace(K key, V value) {
        Object valueAt;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            valueAt = setValueAt(indexOfKey, value);
        } else {
            valueAt = 0;
        }
        return valueAt;
    }

    public final boolean replace(K key, V oldValue, V newValue) {
        Object valueAt;
        final int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0 && valueAt(indexOfKey) == oldValue) {
            if (valueAt(indexOfKey) == oldValue) {
                setValueAt(indexOfKey, newValue);
                return 1;
            }
        }
        return 0;
    }

    public final V setValueAt(int index, V value) {
        i++;
        this.keyValues[i2] = value;
        return this.keyValues[i2];
    }

    protected final void set_size(int <set-?>) {
        this._size = <set-?>;
    }

    public final int size() {
        return this._size;
    }

    public String toString() {
        int i;
        Object keyAt;
        String str;
        Object valueAt;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(_size *= 28);
        stringBuilder.append('{');
        i = 0;
        while (i < this._size) {
            if (i > 0) {
            }
            keyAt = keyAt(i);
            str = "(this Map)";
            if (keyAt != this) {
            } else {
            }
            stringBuilder.append(str);
            stringBuilder.append('=');
            valueAt = valueAt(i);
            if (valueAt != this) {
            } else {
            }
            stringBuilder.append(str);
            i++;
            stringBuilder.append(valueAt);
            stringBuilder.append(keyAt);
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final V valueAt(int index) {
        return this.keyValues[i++];
    }
}
