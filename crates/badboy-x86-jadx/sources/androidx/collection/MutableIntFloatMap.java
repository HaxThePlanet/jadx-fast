package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u00032\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\u0008ø\u0001\u0000J\u0008\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eJ\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eJ\u0008\u0010\"\u001a\u00020\u0007H\u0002J&\u0010#\u001a\u00020\u00072\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020!0%H\u0086\u0008ø\u0001\u0000J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0003H\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eH\u0086\u0002J\u0006\u0010+\u001a\u00020\u0003J\u0019\u0010,\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020-H\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006.", d2 = {"Landroidx/collection/MutableIntFloatMap;", "Landroidx/collection/IntFloatMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "getOrPut", "", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/IntList;", "Landroidx/collection/IntSet;", "", "plusAssign", "from", "put", "value", "default", "putAll", "remove", "", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableIntFloatMap extends androidx.collection.IntFloatMap {

    private int growthLimit;
    public MutableIntFloatMap() {
        super(0, 1, 0);
    }

    public MutableIntFloatMap(int initialCapacity) {
        int i;
        super(0);
        i = initialCapacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            initializeStorage(ScatterMapKt.unloadedCapacity(initialCapacity));
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireMutableIntFloatMap$1 = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw $i$a$RequireMutableIntFloatMap$1;
    }

    public MutableIntFloatMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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
        int i4;
        int $this$maskEmptyOrDeleted$iv;
        int i;
        int i3;
        int i6;
        int i2;
        long l;
        int i7;
        int i5;
        final int _capacity = this._capacity;
        probeOffset = hash1 & _capacity;
        probeIndex = 0;
        long[] metadata = this.metadata;
        i4 = 0;
        int i8 = probeOffset >> 3;
        i10 <<= 3;
        int i9 = metadata$iv;
        int i12 = 0;
        i17 &= i9;
        $this$maskEmptyOrDeleted$iv = i6 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i3 & _capacity;
            metadata = this.metadata;
            i4 = 0;
            i8 = probeOffset >> 3;
            i10 <<= 3;
            i9 = metadata$iv;
            i12 = 0;
            i17 &= i9;
            $this$maskEmptyOrDeleted$iv = i6 & l;
        }
        int i20 = 0;
        return $this$lowestBitSet$iv2 &= _capacity;
    }

    private final int findInsertIndex(int key) {
        Object obj;
        int m;
        int m2;
        int index;
        int i4;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i12;
        int $this$hasNext$iv;
        int i2;
        int i7;
        int i13;
        int i8;
        int $this$next$iv;
        int cmp;
        long l;
        int i;
        int i11;
        int i5;
        int i9;
        int i14;
        int i3;
        int i10;
        int i6;
        int hash;
        int i21 = 0;
        i22 *= i25;
        int $i$f$hash = i23 ^ i26;
        int i24 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i27 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i4 = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i48 = 0;
            int i53 = 0;
            i3 = 0;
            i10 = 1;
            while (Long.compare(i35, i53) != 0) {
                $this$hasNext$iv = i10;
                int i49 = 0;
                i11 = 0;
                $this$get$iv &= i5;
                int i55 = m2;
                i2 = 0;
                m2 = $this$next$iv;
                i48 = 0;
                i53 = 0;
                i3 = 0;
                i10 = 1;
                $this$hasNext$iv = i3;
            }
            $this$hasNext$iv = i3;
            i7 = key;
            int i37 = i14;
            i11 = 0;
            hash = $i$f$hash;
            i4 = i20 & i5;
            obj = this;
            m = i5;
            long[] metadata2 = obj.metadata;
            i2 = 0;
            int i47 = i4 >> 3;
            i50 <<= 3;
            l4 >>>= i51;
            i5 = m;
            i9 = i4;
            i30 |= cmp;
            i13 = 0;
            long l5 = 72340172838076673L;
            i52 ^= i12;
            l = -9187201950435737472L;
            i32 &= l;
            i49 = 0;
            i11 = 0;
            $this$get$iv &= i5;
            i55 = m2;
            i2 = 0;
            m2 = $this$next$iv;
            $this$hasNext$iv = i10;
        }
        return i12;
    }

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr;
        long[] lArr2;
        long l;
        int i5;
        int i2;
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
        this.keys = new int[i];
        this.values = new float[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity2;
        int removedDeletes;
        int i5;
        int $i$f$readRawMetadata;
        int i4;
        Object cmp;
        int _capacity;
        int i10;
        int i8;
        int i6;
        long[] metadata2;
        int i2;
        int i3;
        int i9;
        int i;
        int i11;
        long[] m;
        int i7;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i5 = 0;
        while (i5 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i8) == 0) {
            } else {
            }
            m = metadata;
            i7 = _capacity2;
            i5++;
            metadata = m;
            _capacity2 = i7;
            i8 = 128;
            cmp = this;
            i6 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i5 >> 3;
            i28 <<= 3;
            i11 = _capacity;
            metadata2[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i2 = 0;
            i3 = i10 >> 3;
            i30 <<= 3;
            m = metadata;
            i7 = _capacity2;
            metadata2[i3] = i14 |= i;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj2;
        long[] metadata2;
        int i10;
        int i3;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj;
        int metadata;
        int i9;
        int i4;
        int i2;
        int i;
        int i5;
        int i8;
        long l;
        long[] previousMetadata;
        int i7;
        int i6;
        obj2 = this;
        metadata2 = obj2.metadata;
        initializeStorage(newCapacity);
        i10 = 0;
        while (i10 < obj2._capacity) {
            i3 = 0;
            int i20 = 0;
            metadata = 255;
            if (Long.compare($i$f$readRawMetadata, i4) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i10++;
            obj2 = this;
            metadata2 = previousMetadata;
            i3 = obj2.keys[i10];
            int i21 = 0;
            i23 *= i26;
            $i$f$hash = i24 ^ i27;
            int i25 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i28 = 0;
            i4 = (long)$i$f$h2;
            obj = this;
            i2 = 0;
            int i33 = metadata;
            metadata = obj.metadata;
            int i31 = 0;
            int i34 = firstAvailableSlot >> 3;
            i35 <<= 3;
            previousMetadata = metadata2;
            metadata[i34] = i13 |= i38;
            int _capacity = obj._capacity;
            i19 += i32;
            i9 = 0;
            i5 = metadata2 >> 3;
            i37 <<= 3;
            i7 = _capacity;
            i6 = metadata2;
            metadata[i5] = i16 |= i;
            obj2.keys[firstAvailableSlot] = i3;
            obj2.values[firstAvailableSlot] = obj2.values[i10];
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

    @Override // androidx.collection.IntFloatMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i2;
        long l2;
        long l;
        int i;
        int i3;
        int i5;
        int i6;
        int i4;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i] = i12 |= i4;
        }
        initializeGrowth();
    }

    public final float getOrPut(int key, Function0<Float> defaultValue) {
        float floatValue;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
            put(key, (Number)defaultValue.invoke().floatValue());
        } else {
            floatValue = this.values[keyIndex];
        }
        return floatValue;
    }

    @Override // androidx.collection.IntFloatMap
    public final void minusAssign(int key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.IntFloatMap
    public final void minusAssign(androidx.collection.IntList keys) {
        int i$iv;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i3 = 0;
        final Object obj = keys;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            remove(obj.content[i$iv]);
            i$iv++;
        }
    }

    @Override // androidx.collection.IntFloatMap
    public final void minusAssign(androidx.collection.IntSet keys) {
        int cmp;
        int obj;
        Object this_$iv2;
        Object obj2;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i2;
        int i;
        int $i$f$minusAssign;
        long l;
        int i3;
        int i4;
        int i5;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj2 = keys;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj2;
            this_$iv2 = this;
        }
    }

    @Override // androidx.collection.IntFloatMap
    public final void minusAssign(int[] keys) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i3 = 0;
        i = 0;
        while (i < keys.length) {
            remove(keys[i]);
            i++;
        }
    }

    @Override // androidx.collection.IntFloatMap
    public final void plusAssign(androidx.collection.IntFloatMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    @Override // androidx.collection.IntFloatMap
    public final float put(int key, float value, float default) {
        int index;
        float previous;
        float[] values;
        index = findInsertIndex(key);
        previous = default;
        if (index < 0) {
            index = ~index;
        } else {
            previous = this.values[index];
        }
        this.keys[index] = key;
        this.values[index] = value;
        return previous;
    }

    @Override // androidx.collection.IntFloatMap
    public final void put(int key, float value) {
        set(key, value);
    }

    @Override // androidx.collection.IntFloatMap
    public final void putAll(androidx.collection.IntFloatMap from) {
        int cmp;
        int obj;
        int $i$f$forEach2;
        Object k$iv;
        int[] keys;
        Object k$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i3;
        Object this_$iv;
        long l;
        int i;
        int i4;
        int $i$f$forEach;
        int i2;
        int[] iArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = $i$f$forEach2;
            iArr = keys;
            k$iv = this;
        }
    }

    @Override // androidx.collection.IntFloatMap
    public final void remove(int key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            removeValueAt(keyIndex);
        }
    }

    @Override // androidx.collection.IntFloatMap
    public final boolean remove(int key, float value) {
        int i;
        int i2;
        final int keyIndex = findKeyIndex(key);
        final int i3 = 0;
        if (keyIndex >= 0) {
            i2 = 1;
            i = Float.compare(f, value) == 0 ? i2 : i3;
            if (i != 0) {
                removeValueAt(keyIndex);
                return i2;
            }
        }
        return i3;
    }

    public final void removeIf(Function2<? super Integer, ? super Float, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i3;
        int i;
        long l;
        int i2;
        int i4;
        int $i$f$removeIf;
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

    @Override // androidx.collection.IntFloatMap
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

    @Override // androidx.collection.IntFloatMap
    public final void set(int key, float value) {
        int index;
        index = findInsertIndex(key);
        if (index < 0) {
            index = ~index;
        }
        this.keys[index] = key;
        this.values[index] = value;
    }

    @Override // androidx.collection.IntFloatMap
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
