package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\u0008ø\u0001\u0000J\u0008\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000fJ\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0008\u0010#\u001a\u00020\u0007H\u0002J&\u0010$\u001a\u00020\u00072\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"0&H\u0086\u0008ø\u0001\u0000J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0003H\u0001J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0003H\u0002J\u0019\u0010+\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000fH\u0086\u0002J\u0006\u0010,\u001a\u00020\u0003J\u0019\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006.", d2 = {"Landroidx/collection/MutableFloatLongMap;", "Landroidx/collection/FloatLongMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "", "getOrPut", "", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/FloatList;", "Landroidx/collection/FloatSet;", "", "plusAssign", "from", "put", "value", "default", "putAll", "remove", "", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableFloatLongMap extends androidx.collection.FloatLongMap {

    private int growthLimit;
    public MutableFloatLongMap() {
        super(0, 1, 0);
    }

    public MutableFloatLongMap(int initialCapacity) {
        int i;
        super(0);
        i = initialCapacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            initializeStorage(ScatterMapKt.unloadedCapacity(initialCapacity));
        }
        int i3 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw illegalArgumentException;
    }

    public MutableFloatLongMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 6 : obj1;
        super(obj1);
    }

    private final void adjustStorage() {
        int compareUnsigned;
        long constructor-impl;
        int i;
        final int i3 = 8;
        if (this._capacity > i3 && Long.compareUnsigned(ULong.constructor-impl(constructor-impl2 *= i4), i3) <= 0) {
            if (Long.compareUnsigned(ULong.constructor-impl(constructor-impl2 *= i4), i3) <= 0) {
                removeDeletedMarkers();
            } else {
                resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
            }
        } else {
        }
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i2;
        int $this$maskEmptyOrDeleted$iv;
        int i6;
        int i;
        int i4;
        int i7;
        long l;
        int i3;
        int i5;
        final int _capacity = this._capacity;
        probeOffset = hash1 & _capacity;
        probeIndex = 0;
        long[] metadata = this.metadata;
        i2 = 0;
        int i8 = probeOffset >> 3;
        i10 <<= 3;
        int i9 = metadata$iv;
        int i12 = 0;
        i17 &= i9;
        $this$maskEmptyOrDeleted$iv = i4 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i & _capacity;
            metadata = this.metadata;
            i2 = 0;
            i8 = probeOffset >> 3;
            i10 <<= 3;
            i9 = metadata$iv;
            i12 = 0;
            i17 &= i9;
            $this$maskEmptyOrDeleted$iv = i4 & l;
        }
        int i20 = 0;
        return $this$lowestBitSet$iv2 &= _capacity;
    }

    private final int findInsertIndex(float key) {
        Object obj;
        int m;
        int m2;
        int index;
        int i9;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i10;
        int i2;
        int cmp;
        int i3;
        int i12;
        long l;
        int i5;
        int i11;
        int i6;
        int i7;
        int i8;
        int i13;
        int i4;
        int numberOfTrailingZeros;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i9 = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i51 = 0;
            i13 = 0;
            i4 = 1;
            while (Long.compare(i34, i51) != 0) {
                $this$hasNext$iv = i4;
                i2 = 0;
                i11 = 0;
                $this$get$iv &= i6;
                if (Float.compare(f, key) == 0) {
                }
                int i45 = m2;
                i3 = 0;
                m2 = $this$next$iv;
                i47 = 0;
                i51 = 0;
                i13 = 0;
                i4 = 1;
                $this$hasNext$iv = i13;
                i13 = i4;
            }
            $this$hasNext$iv = i13;
            int i35 = i8;
            i10 = 0;
            hash = $i$f$hash;
            i9 = i19 & i6;
            obj = this;
            m = i6;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i46 = i9 >> 3;
            i48 <<= 3;
            l4 >>>= i49;
            i6 = m;
            i7 = i9;
            i29 |= i12;
            i2 = 0;
            long l6 = 72340172838076673L;
            i50 ^= i;
            l = -9187201950435737472L;
            i31 &= l;
            i2 = 0;
            i11 = 0;
            $this$get$iv &= i6;
            if (Float.compare(f, key) == 0) {
            }
            i45 = m2;
            i3 = 0;
            m2 = $this$next$iv;
            i13 = i4;
            $this$hasNext$iv = i4;
        }
        return i;
    }

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr2;
        long[] lArr;
        long l;
        int i4;
        int i3;
        int i5;
        int i;
        int i2;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr2 = new long[i9 >>= 3];
            i2 = 0;
            ArraysKt.fill$default(lArr2, -9187201950435737472L, obj4, 0, 0, 6);
            size = lArr2;
        }
        this.metadata = size;
        long[] metadata = this.metadata;
        int i12 = 0;
        final int i13 = capacity >> 3;
        i14 <<= 3;
        metadata[i13] = i16 |= i21;
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        int i;
        int normalizeCapacity;
        if (initialCapacity > 0) {
            i = Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity));
        } else {
            i = 0;
        }
        this._capacity = i;
        initializeMetadata(i);
        this.keys = new float[i];
        this.values = new long[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity2;
        int removedDeletes;
        int i10;
        int $i$f$readRawMetadata;
        int i11;
        Object cmp;
        int _capacity;
        int i9;
        int i8;
        int i;
        long[] metadata2;
        int i5;
        int i6;
        int i2;
        int i7;
        int i3;
        long[] m;
        int i4;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i10 = 0;
        while (i10 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i8) == 0) {
            } else {
            }
            m = metadata;
            i4 = _capacity2;
            i10++;
            metadata = m;
            _capacity2 = i4;
            i8 = 128;
            cmp = this;
            i = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i10 >> 3;
            i28 <<= 3;
            i3 = _capacity;
            metadata2[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i5 = 0;
            i6 = i9 >> 3;
            i30 <<= 3;
            m = metadata;
            i4 = _capacity2;
            metadata2[i6] = i14 |= i7;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj2;
        long[] metadata2;
        int i2;
        int i3;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj;
        int metadata;
        int i;
        int i7;
        int i4;
        int i5;
        int i10;
        int i6;
        long l;
        long[] previousMetadata;
        int i8;
        int i9;
        obj2 = this;
        metadata2 = obj2.metadata;
        initializeStorage(newCapacity);
        i2 = 0;
        while (i2 < obj2._capacity) {
            i3 = 0;
            int i20 = 0;
            metadata = 255;
            if (Long.compare($i$f$readRawMetadata, i7) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i2++;
            obj2 = this;
            metadata2 = previousMetadata;
            i3 = obj2.keys[i2];
            int i21 = 0;
            i23 *= i26;
            $i$f$hash = i24 ^ i27;
            int i25 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i28 = 0;
            i7 = (long)$i$f$h2;
            obj = this;
            i4 = 0;
            int i33 = metadata;
            metadata = obj.metadata;
            int i31 = 0;
            int i34 = firstAvailableSlot >> 3;
            i35 <<= 3;
            previousMetadata = metadata2;
            metadata[i34] = i13 |= i38;
            int _capacity = obj._capacity;
            i19 += i32;
            i = 0;
            i10 = metadata2 >> 3;
            i37 <<= 3;
            i8 = _capacity;
            i9 = metadata2;
            metadata[i10] = i16 |= i5;
            obj2.keys[firstAvailableSlot] = i3;
            obj2.values[firstAvailableSlot] = obj2.values[i2];
            $i$f$hash = 1;
        }
    }

    private final void writeMetadata(int index, long value) {
        final int i = 0;
        final long[] metadata = this.metadata;
        int i2 = 0;
        int i3 = index >> 3;
        i7 <<= 3;
        int i16 = 255;
        metadata[i3] = i11 |= i23;
        int $i$f$writeRawMetadata = this._capacity;
        i5 += i9;
        int i10 = 0;
        int i13 = i6 >> 3;
        i14 <<= 3;
        metadata[i13] = i19 |= i24;
    }

    @Override // androidx.collection.FloatLongMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i3;
        long l;
        long l2;
        int i;
        int i6;
        int i2;
        int i5;
        int i4;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i] = i12 |= i4;
        }
        initializeGrowth();
    }

    public final long getOrPut(float key, Function0<Long> defaultValue) {
        long longValue;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
            put(key, (Number)defaultValue.invoke().longValue());
        } else {
            longValue = this.values[keyIndex];
        }
        return longValue;
    }

    @Override // androidx.collection.FloatLongMap
    public final void minusAssign(float key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.FloatLongMap
    public final void minusAssign(androidx.collection.FloatList keys) {
        int i$iv;
        float f;
        int i;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i2 = 0;
        final Object obj = keys;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            remove(obj.content[i$iv]);
            i$iv++;
        }
    }

    @Override // androidx.collection.FloatLongMap
    public final void minusAssign(androidx.collection.FloatSet keys) {
        int cmp;
        int obj2;
        Object this_$iv2;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i;
        int $i$f$minusAssign;
        long l;
        int i5;
        int i2;
        int i4;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj = keys;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj;
            this_$iv2 = this;
        }
    }

    @Override // androidx.collection.FloatLongMap
    public final void minusAssign(float[] keys) {
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i3 = 0;
        i2 = 0;
        while (i2 < keys.length) {
            remove(keys[i2]);
            i2++;
        }
    }

    @Override // androidx.collection.FloatLongMap
    public final void plusAssign(androidx.collection.FloatLongMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    @Override // androidx.collection.FloatLongMap
    public final long put(float key, long value, long default) {
        int index;
        long previous;
        long[] values;
        index = findInsertIndex(key);
        previous = obj8;
        if (index < 0) {
            index = ~index;
        } else {
            previous = this.values[index];
        }
        this.keys[index] = key;
        this.values[index] = value;
        return previous;
    }

    @Override // androidx.collection.FloatLongMap
    public final void put(float key, long value) {
        set(key, value);
    }

    @Override // androidx.collection.FloatLongMap
    public final void putAll(androidx.collection.FloatLongMap from) {
        int cmp;
        int obj;
        int $i$f$forEach;
        float[] keys;
        Object v$iv2;
        long[] values;
        Object v$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i2;
        Object this_$iv;
        long l;
        int i4;
        int i5;
        int $i$f$forEach2;
        float[] fArr;
        int i;
        long[] lArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = cmp;
            $i$f$forEach2 = $i$f$forEach;
            fArr = keys;
            lArr = values;
            v$iv2 = this;
        }
    }

    @Override // androidx.collection.FloatLongMap
    public final void remove(float key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            removeValueAt(keyIndex);
        }
    }

    @Override // androidx.collection.FloatLongMap
    public final boolean remove(float key, long value) {
        int cmp;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0 && Long.compare(l, value) == 0) {
            if (Long.compare(l, value) == 0) {
                removeValueAt(keyIndex);
                return 1;
            }
        }
        return 0;
    }

    public final void removeIf(Function2<? super Float, ? super Long, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i4;
        int i;
        long l;
        int i3;
        int i2;
        int $i$f$removeIf;
        long l2;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        final int i5 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i6) {
        } else {
            $i$f$removeIf = $i$f$removeIf2;
        }
    }

    @Override // androidx.collection.FloatLongMap
    public final void removeValueAt(int index) {
        this._size = _size--;
        int i2 = 254;
        final Object obj = this;
        final int i3 = 0;
        final long[] metadata = obj.metadata;
        int i4 = 0;
        int i5 = index >> 3;
        i9 <<= 3;
        int i18 = 255;
        metadata[i5] = i13 |= i25;
        int $i$f$writeRawMetadata = obj._capacity;
        i7 += i11;
        int i12 = 0;
        int i15 = i8 >> 3;
        i16 <<= 3;
        metadata[i15] = i21 |= i26;
    }

    @Override // androidx.collection.FloatLongMap
    public final void set(float key, long value) {
        int index;
        index = findInsertIndex(key);
        if (index < 0) {
            index = ~index;
        }
        this.keys[index] = key;
        this.values[index] = value;
    }

    @Override // androidx.collection.FloatLongMap
    public final int trim() {
        final int _capacity = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity < _capacity) {
            resizeStorage(normalizeCapacity);
            return _capacity - _capacity2;
        }
        return 0;
    }
}
