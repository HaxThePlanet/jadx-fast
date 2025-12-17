package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010H\u0086\u0008ø\u0001\u0000J\u0008\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003J\u001e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003J\u0008\u0010\"\u001a\u00020\u0007H\u0002J&\u0010#\u001a\u00020\u00072\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0%H\u0086\u0008ø\u0001\u0000J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0003H\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010+\u001a\u00020\u0003J\u0019\u0010,\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\rH\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006-", d2 = {"Landroidx/collection/MutableLongIntMap;", "Landroidx/collection/LongIntMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "", "getOrPut", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", "from", "put", "value", "default", "putAll", "remove", "", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLongIntMap extends androidx.collection.LongIntMap {

    private int growthLimit;
    public MutableLongIntMap() {
        super(0, 1, 0);
    }

    public MutableLongIntMap(int initialCapacity) {
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

    public MutableLongIntMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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
        int i6;
        int $this$maskEmptyOrDeleted$iv;
        int i;
        int i4;
        int i7;
        int i5;
        long l;
        int i2;
        int i3;
        final int _capacity = this._capacity;
        probeOffset = hash1 & _capacity;
        probeIndex = 0;
        long[] metadata = this.metadata;
        i6 = 0;
        int i8 = probeOffset >> 3;
        i10 <<= 3;
        int i9 = metadata$iv;
        int i12 = 0;
        i17 &= i9;
        $this$maskEmptyOrDeleted$iv = i7 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i4 & _capacity;
            metadata = this.metadata;
            i6 = 0;
            i8 = probeOffset >> 3;
            i10 <<= 3;
            i9 = metadata$iv;
            i12 = 0;
            i17 &= i9;
            $this$maskEmptyOrDeleted$iv = i7 & l;
        }
        int i20 = 0;
        return $this$lowestBitSet$iv2 &= _capacity;
    }

    private final int findInsertIndex(long key) {
        Object obj;
        int m2;
        int m;
        int index;
        int i8;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i6;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i;
        int i2;
        int cmp;
        int i7;
        int i3;
        long l;
        int i4;
        int i14;
        int i11;
        int i10;
        int i9;
        int i12;
        int i5;
        int i13;
        int hash;
        int i21 = 0;
        i22 *= i25;
        int $i$f$hash = i23 ^ i26;
        int i24 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i27 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i8 = $i$f$h1 & m2;
        probeIndex = 0;
        while (/* condition */) {
            int i48 = 0;
            int i52 = 0;
            i12 = 0;
            i5 = 1;
            while (Long.compare(i35, i52) != 0) {
                $this$hasNext$iv = i5;
                i2 = 0;
                i14 = 0;
                $this$get$iv &= i11;
                int i43 = m;
                i7 = 0;
                m = $this$next$iv;
                i48 = 0;
                i52 = 0;
                i12 = 0;
                i5 = 1;
                $this$hasNext$iv = i12;
            }
            $this$hasNext$iv = i12;
            int i37 = i9;
            i = 0;
            hash = $i$f$hash;
            i8 = i20 & i11;
            obj = this;
            m2 = i11;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i47 = i8 >> 3;
            i49 <<= 3;
            l5 >>>= i50;
            i11 = m2;
            i10 = i8;
            i30 |= i3;
            i2 = 0;
            long l7 = 72340172838076673L;
            i51 ^= i6;
            l = -9187201950435737472L;
            i32 &= l;
            i2 = 0;
            i14 = 0;
            $this$get$iv &= i11;
            i43 = m;
            i7 = 0;
            m = $this$next$iv;
            $this$hasNext$iv = i5;
        }
        return i6;
    }

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr;
        long[] lArr2;
        long l;
        int i3;
        int i;
        int i2;
        int i4;
        int i5;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr = new long[i9 >>= 3];
            i5 = 0;
            ArraysKt.fill$default(lArr, -9187201950435737472L, obj4, 0, 0, 6);
            size = lArr;
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
        this.keys = new long[i];
        this.values = new int[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity;
        int removedDeletes;
        int i11;
        int $i$f$readRawMetadata;
        int i10;
        Object cmp;
        int _capacity2;
        int i8;
        int i3;
        int i2;
        long[] metadata2;
        int i5;
        int i4;
        int i6;
        int i7;
        int i9;
        long[] m;
        int i;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i11 = 0;
        while (i11 < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i3) == 0) {
            } else {
            }
            m = metadata;
            i = _capacity;
            i11++;
            metadata = m;
            _capacity = i;
            i3 = 128;
            cmp = this;
            i2 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i11 >> 3;
            i28 <<= 3;
            i9 = _capacity2;
            metadata2[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i5 = 0;
            i4 = i8 >> 3;
            i30 <<= 3;
            m = metadata;
            i = _capacity;
            metadata2[i4] = i14 |= i7;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata2;
        int i10;
        int i6;
        int i8;
        int $i$f$hash;
        int firstAvailableSlot;
        int i2;
        long[] metadata;
        int $i$f$h2;
        int i4;
        int i7;
        int i;
        int i11;
        int i9;
        long l;
        long[] previousMetadata;
        int i3;
        int i5;
        obj = this;
        metadata2 = obj.metadata;
        initializeStorage(newCapacity);
        i10 = 0;
        while (i10 < obj._capacity) {
            i6 = 0;
            int i21 = 0;
            i2 = 255;
            if (Long.compare($i$f$readRawMetadata, $i$f$h2) < 0) {
            } else {
            }
            i8 = 0;
            if (i8 != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i10++;
            obj = this;
            metadata2 = previousMetadata;
            i6 = obj.keys[i10];
            int i23 = 0;
            i24 *= i29;
            $i$f$hash = i25 ^ i30;
            int i26 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i31 = 0;
            $i$f$h2 = (long)$i$f$h22;
            i7 = 0;
            int i34 = i2;
            i2 = obj2;
            metadata = i2.metadata;
            int i32 = 0;
            int i35 = firstAvailableSlot >> 3;
            i36 <<= 3;
            previousMetadata = metadata2;
            metadata[i35] = i14 |= i39;
            int _capacity = i2._capacity;
            i20 += i33;
            i4 = 0;
            i11 = metadata2 >> 3;
            i38 <<= 3;
            i3 = _capacity;
            i5 = metadata2;
            metadata[i11] = i17 |= i;
            obj.keys[firstAvailableSlot] = i6;
            obj.values[firstAvailableSlot] = obj.values[i10];
            i8 = 1;
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

    @Override // androidx.collection.LongIntMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i6;
        long l2;
        long l;
        int i;
        int i2;
        int i5;
        int i4;
        int i3;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i] = i12 |= i3;
        }
        initializeGrowth();
    }

    public final int getOrPut(long key, Function0<Integer> defaultValue) {
        int intValue;
        Intrinsics.checkNotNullParameter(obj6, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
            put(key, defaultValue);
        } else {
            intValue = this.values[keyIndex];
        }
        return intValue;
    }

    @Override // androidx.collection.LongIntMap
    public final void minusAssign(long key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.LongIntMap
    public final void minusAssign(androidx.collection.LongList keys) {
        int i$iv;
        long l;
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

    @Override // androidx.collection.LongIntMap
    public final void minusAssign(androidx.collection.LongSet keys) {
        int cmp;
        int obj2;
        Object obj;
        Object $i$f$forEach2;
        int i7;
        Object $i$f$forEach;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i2;
        int $i$f$minusAssign;
        long l;
        Object this_$iv;
        int i;
        int i6;
        int i5;
        int i4;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj = keys;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj;
            i4 = i7;
            $i$f$forEach2 = this;
        }
    }

    @Override // androidx.collection.LongIntMap
    public final void minusAssign(long[] keys) {
        int i;
        long l;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i2 = 0;
        i = 0;
        while (i < keys.length) {
            remove(keys[i]);
            i++;
        }
    }

    @Override // androidx.collection.LongIntMap
    public final void plusAssign(androidx.collection.LongIntMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    @Override // androidx.collection.LongIntMap
    public final int put(long key, int value, int default) {
        int index;
        int previous;
        int[] values;
        index = findInsertIndex(key);
        previous = obj7;
        if (index < 0) {
            index = ~index;
        } else {
            previous = this.values[index];
        }
        this.keys[index] = key;
        this.values[index] = default;
        return previous;
    }

    @Override // androidx.collection.LongIntMap
    public final void put(long key, int value) {
        set(key, value);
    }

    @Override // androidx.collection.LongIntMap
    public final void putAll(androidx.collection.LongIntMap from) {
        int cmp;
        int obj;
        int i6;
        long[] k$iv;
        Object v$iv;
        int[] values;
        Object v$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i4;
        int i;
        Object this_$iv;
        long l;
        int $i$f$forEach;
        int i2;
        int i5;
        long[] lArr;
        int i3;
        int[] iArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i13 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = i6;
            lArr = k$iv;
            iArr = values;
            v$iv = this;
        }
    }

    @Override // androidx.collection.LongIntMap
    public final void remove(long key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            removeValueAt(keyIndex);
        }
    }

    @Override // androidx.collection.LongIntMap
    public final boolean remove(long key, int value) {
        int i;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0 && this.values[keyIndex] == obj5) {
            if (this.values[keyIndex] == obj5) {
                removeValueAt(keyIndex);
                return 1;
            }
        }
        return 0;
    }

    public final void removeIf(Function2<? super Long, ? super Integer, Boolean> predicate) {
        int $i$f$removeIf;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i2;
        int i;
        long l;
        int i3;
        int i4;
        int $i$f$removeIf2;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        final int i6 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i7) {
        } else {
            $i$f$removeIf2 = $i$f$removeIf;
        }
    }

    @Override // androidx.collection.LongIntMap
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

    @Override // androidx.collection.LongIntMap
    public final void set(long key, int value) {
        int index;
        index = findInsertIndex(key);
        if (index < 0) {
            index = ~index;
        }
        this.keys[index] = key;
        this.values[index] = obj5;
    }

    @Override // androidx.collection.LongIntMap
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
