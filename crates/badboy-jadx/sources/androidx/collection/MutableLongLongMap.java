package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0010H\u0086\u0008ø\u0001\u0000J\u0008\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ\u0008\u0010\"\u001a\u00020\u0007H\u0002J&\u0010#\u001a\u00020\u00072\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0%H\u0086\u0008ø\u0001\u0000J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0003H\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0086\u0002J\u0006\u0010+\u001a\u00020\u0003J\u0019\u0010,\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\rH\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006-", d2 = {"Landroidx/collection/MutableLongLongMap;", "Landroidx/collection/LongLongMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "", "getOrPut", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", "from", "put", "value", "default", "putAll", "remove", "", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLongLongMap extends androidx.collection.LongLongMap {

    private int growthLimit;
    public MutableLongLongMap() {
        super(0, 1, 0);
    }

    public MutableLongLongMap(int initialCapacity) {
        int i;
        super(0);
        i = initialCapacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            initializeStorage(ScatterMapKt.unloadedCapacity(initialCapacity));
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireMutableLongLongMap$1 = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw $i$a$RequireMutableLongLongMap$1;
    }

    public MutableLongLongMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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
        int i5;
        int $this$maskEmptyOrDeleted$iv;
        int i;
        int i6;
        int i2;
        int i3;
        long l;
        int i4;
        int i7;
        final int _capacity = this._capacity;
        probeOffset = hash1 & _capacity;
        probeIndex = 0;
        long[] metadata = this.metadata;
        i5 = 0;
        int i8 = probeOffset >> 3;
        i10 <<= 3;
        int i9 = metadata$iv;
        int i12 = 0;
        i17 &= i9;
        $this$maskEmptyOrDeleted$iv = i2 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i6 & _capacity;
            metadata = this.metadata;
            i5 = 0;
            i8 = probeOffset >> 3;
            i10 <<= 3;
            i9 = metadata$iv;
            i12 = 0;
            i17 &= i9;
            $this$maskEmptyOrDeleted$iv = i2 & l;
        }
        int i20 = 0;
        return $this$lowestBitSet$iv2 &= _capacity;
    }

    private final int findInsertIndex(long key) {
        Object obj;
        int m2;
        int m;
        int index;
        int i11;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i7;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i13;
        int i14;
        int cmp;
        int i8;
        int i12;
        long l;
        int i;
        int i2;
        int i9;
        int i3;
        int i4;
        int i5;
        int i6;
        int i10;
        int hash;
        int i21 = 0;
        i22 *= i25;
        int $i$f$hash = i23 ^ i26;
        int i24 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i27 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i11 = $i$f$h1 & m2;
        probeIndex = 0;
        while (/* condition */) {
            int i48 = 0;
            int i52 = 0;
            i5 = 0;
            i6 = 1;
            while (Long.compare(i35, i52) != 0) {
                $this$hasNext$iv = i6;
                i14 = 0;
                i2 = 0;
                $this$get$iv &= i9;
                int i43 = m;
                i8 = 0;
                m = $this$next$iv;
                i48 = 0;
                i52 = 0;
                i5 = 0;
                i6 = 1;
                $this$hasNext$iv = i5;
            }
            $this$hasNext$iv = i5;
            int i37 = i4;
            i13 = 0;
            hash = $i$f$hash;
            i11 = i20 & i9;
            obj = this;
            m2 = i9;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i47 = i11 >> 3;
            i49 <<= 3;
            l5 >>>= i50;
            i9 = m2;
            i3 = i11;
            i30 |= i12;
            i14 = 0;
            long l7 = 72340172838076673L;
            i51 ^= i7;
            l = -9187201950435737472L;
            i32 &= l;
            i14 = 0;
            i2 = 0;
            $this$get$iv &= i9;
            i43 = m;
            i8 = 0;
            m = $this$next$iv;
            $this$hasNext$iv = i6;
        }
        return i7;
    }

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr;
        long[] lArr2;
        long l;
        int i2;
        int i5;
        int i3;
        int i;
        int i4;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr = new long[i9 >>= 3];
            i4 = 0;
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
        this.values = new long[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity2;
        int removedDeletes;
        int i4;
        int $i$f$readRawMetadata;
        int i8;
        Object cmp;
        int _capacity;
        int i2;
        int i11;
        int i6;
        long[] metadata;
        int i5;
        int i3;
        int i9;
        int i10;
        int i;
        long[] m;
        int i7;
        final Object obj = this;
        metadata2 = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i4 = 0;
        while (i4 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i11) == 0) {
            } else {
            }
            m = metadata2;
            i7 = _capacity2;
            i4++;
            metadata2 = m;
            _capacity2 = i7;
            i11 = 128;
            cmp = this;
            i6 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i4 >> 3;
            i28 <<= 3;
            i = _capacity;
            metadata[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i5 = 0;
            i3 = i2 >> 3;
            i30 <<= 3;
            m = metadata2;
            i7 = _capacity2;
            metadata[i3] = i14 |= i10;
            removedDeletes++;
        }
        long[] m4 = metadata2;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata2;
        int i;
        int i3;
        int i8;
        int $i$f$hash;
        int firstAvailableSlot;
        int i4;
        long[] metadata;
        int $i$f$h2;
        int i11;
        int i9;
        int i5;
        int i6;
        int i7;
        long l;
        long[] previousMetadata;
        int i10;
        int i2;
        obj = this;
        metadata2 = obj.metadata;
        initializeStorage(newCapacity);
        i = 0;
        while (i < obj._capacity) {
            i3 = 0;
            int i21 = 0;
            i4 = 255;
            if (Long.compare($i$f$readRawMetadata, $i$f$h2) < 0) {
            } else {
            }
            i8 = 0;
            if (i8 != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i++;
            obj = this;
            metadata2 = previousMetadata;
            i3 = obj.keys[i];
            int i23 = 0;
            i24 *= i29;
            $i$f$hash = i25 ^ i30;
            int i26 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i31 = 0;
            $i$f$h2 = (long)$i$f$h22;
            i9 = 0;
            int i34 = i4;
            i4 = obj2;
            metadata = i4.metadata;
            int i32 = 0;
            int i35 = firstAvailableSlot >> 3;
            i36 <<= 3;
            previousMetadata = metadata2;
            metadata[i35] = i14 |= i39;
            int _capacity = i4._capacity;
            i20 += i33;
            i11 = 0;
            i6 = metadata2 >> 3;
            i38 <<= 3;
            i10 = _capacity;
            i2 = metadata2;
            metadata[i6] = i17 |= i5;
            obj.keys[firstAvailableSlot] = i3;
            obj.values[firstAvailableSlot] = obj.values[i];
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

    @Override // androidx.collection.LongLongMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i;
        long l;
        long l2;
        int i5;
        int i2;
        int i3;
        int i4;
        int i6;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i5 = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i5] = i12 |= i6;
        }
        initializeGrowth();
    }

    public final long getOrPut(long key, Function0<Long> defaultValue) {
        long longValue;
        Intrinsics.checkNotNullParameter(obj7, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
            put(key, defaultValue);
        } else {
            longValue = this.values[keyIndex];
        }
        return longValue;
    }

    @Override // androidx.collection.LongLongMap
    public final void minusAssign(long key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.LongLongMap
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

    @Override // androidx.collection.LongLongMap
    public final void minusAssign(androidx.collection.LongSet keys) {
        int cmp;
        int obj;
        Object obj2;
        Object $i$f$forEach;
        int i;
        Object $i$f$forEach2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i7;
        int i2;
        int $i$f$minusAssign;
        long l;
        Object this_$iv;
        int i6;
        int i3;
        int i5;
        int i4;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj2 = keys;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj2;
            i4 = i;
            $i$f$forEach = this;
        }
    }

    @Override // androidx.collection.LongLongMap
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

    @Override // androidx.collection.LongLongMap
    public final void plusAssign(androidx.collection.LongLongMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    @Override // androidx.collection.LongLongMap
    public final long put(long key, long value, long default) {
        int index;
        long previous;
        long[] values;
        index = findInsertIndex(key);
        previous = obj9;
        if (index < 0) {
            index = ~index;
        } else {
            previous = this.values[index];
        }
        this.keys[index] = key;
        this.values[index] = default;
        return previous;
    }

    @Override // androidx.collection.LongLongMap
    public final void put(long key, long value) {
        set(key, value);
    }

    @Override // androidx.collection.LongLongMap
    public final void putAll(androidx.collection.LongLongMap from) {
        int cmp;
        int obj3;
        int i5;
        long[] k$iv;
        long[] values;
        Object this_$iv$iv2;
        Object obj2;
        Object this_$iv$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i2;
        int i6;
        Object this_$iv;
        long l;
        int $i$f$forEach;
        int i;
        int i4;
        long[] lArr;
        long[] lArr2;
        int i3;
        Object obj;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        obj2 = cmp;
        final int i13 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = i5;
            lArr = k$iv;
            lArr2 = values;
            obj = obj2;
            this_$iv$iv2 = this;
        }
    }

    @Override // androidx.collection.LongLongMap
    public final void remove(long key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            removeValueAt(keyIndex);
        }
    }

    @Override // androidx.collection.LongLongMap
    public final boolean remove(long key, long value) {
        int cmp;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0 && Long.compare(l, obj6) == 0) {
            if (Long.compare(l, obj6) == 0) {
                removeValueAt(keyIndex);
                return 1;
            }
        }
        return 0;
    }

    public final void removeIf(Function2<? super Long, ? super Long, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i;
        int i4;
        long l2;
        int i2;
        int i3;
        int $i$f$removeIf;
        long l;
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

    @Override // androidx.collection.LongLongMap
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

    @Override // androidx.collection.LongLongMap
    public final void set(long key, long value) {
        int index;
        index = findInsertIndex(key);
        if (index < 0) {
            index = ~index;
        }
        this.keys[index] = key;
        this.values[index] = obj5;
    }

    @Override // androidx.collection.LongLongMap
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
