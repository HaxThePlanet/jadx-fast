package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0010H\u0086\u0008ø\u0001\u0000J\u0008\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0001J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ\u0008\u0010\"\u001a\u00020\u0007H\u0002J&\u0010#\u001a\u00020\u00072\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0%H\u0086\u0008ø\u0001\u0000J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0003H\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0086\u0002J\u0006\u0010+\u001a\u00020\u0003J\u0019\u0010,\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020-H\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006.", d2 = {"Landroidx/collection/MutableFloatFloatMap;", "Landroidx/collection/FloatFloatMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "", "getOrPut", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/FloatList;", "Landroidx/collection/FloatSet;", "", "plusAssign", "from", "put", "value", "default", "putAll", "remove", "", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableFloatFloatMap extends androidx.collection.FloatFloatMap {

    private int growthLimit;
    public MutableFloatFloatMap() {
        super(0, 1, 0);
    }

    public MutableFloatFloatMap(int initialCapacity) {
        int i;
        super(0);
        i = initialCapacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            initializeStorage(ScatterMapKt.unloadedCapacity(initialCapacity));
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireMutableFloatFloatMap$1 = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw $i$a$RequireMutableFloatFloatMap$1;
    }

    public MutableFloatFloatMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findInsertIndex(float key) {
        Object obj;
        int m2;
        int m;
        int index;
        int i6;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i13;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i10;
        int i4;
        int cmp;
        int i;
        int i5;
        long l;
        int i9;
        int i11;
        int i12;
        int i7;
        int i2;
        int i3;
        int i8;
        int numberOfTrailingZeros;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i6 = $i$f$h1 & m2;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i51 = 0;
            i3 = 0;
            i8 = 1;
            while (Long.compare(i34, i51) != 0) {
                $this$hasNext$iv = i8;
                i4 = 0;
                i11 = 0;
                $this$get$iv &= i12;
                if (Float.compare(f, key) == 0) {
                }
                int i45 = m;
                i = 0;
                m = $this$next$iv;
                i47 = 0;
                i51 = 0;
                i3 = 0;
                i8 = 1;
                $this$hasNext$iv = i3;
                i3 = i8;
            }
            $this$hasNext$iv = i3;
            int i35 = i2;
            i10 = 0;
            hash = $i$f$hash;
            i6 = i19 & i12;
            obj = this;
            m2 = i12;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i46 = i6 >> 3;
            i48 <<= 3;
            l4 >>>= i49;
            i12 = m2;
            i7 = i6;
            i29 |= i5;
            i4 = 0;
            long l6 = 72340172838076673L;
            i50 ^= i13;
            l = -9187201950435737472L;
            i31 &= l;
            i4 = 0;
            i11 = 0;
            $this$get$iv &= i12;
            if (Float.compare(f, key) == 0) {
            }
            i45 = m;
            i = 0;
            m = $this$next$iv;
            i3 = i8;
            $this$hasNext$iv = i8;
        }
        return i13;
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
        int i;
        int i5;
        int i3;
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
        this.values = new float[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity;
        int removedDeletes;
        int i3;
        int $i$f$readRawMetadata;
        int i2;
        Object cmp;
        int _capacity2;
        int i8;
        int i11;
        int i9;
        long[] metadata;
        int i;
        int i6;
        int i5;
        int i4;
        int i10;
        long[] m;
        int i7;
        final Object obj = this;
        metadata2 = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i3 = 0;
        while (i3 < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i11) == 0) {
            } else {
            }
            m = metadata2;
            i7 = _capacity;
            i3++;
            metadata2 = m;
            _capacity = i7;
            i11 = 128;
            cmp = this;
            i9 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i3 >> 3;
            i28 <<= 3;
            i10 = _capacity2;
            metadata[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i = 0;
            i6 = i8 >> 3;
            i30 <<= 3;
            m = metadata2;
            i7 = _capacity;
            metadata[i6] = i14 |= i4;
            removedDeletes++;
        }
        long[] m4 = metadata2;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata;
        int i10;
        int i5;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj2;
        int metadata2;
        int i9;
        int i6;
        int i7;
        int i2;
        int i8;
        int i3;
        long l;
        long[] previousMetadata;
        int i4;
        int i;
        obj = this;
        metadata = obj.metadata;
        initializeStorage(newCapacity);
        i10 = 0;
        while (i10 < obj._capacity) {
            i5 = 0;
            int i20 = 0;
            metadata2 = 255;
            if (Long.compare($i$f$readRawMetadata, i6) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata;
            i10++;
            obj = this;
            metadata = previousMetadata;
            i5 = obj.keys[i10];
            int i21 = 0;
            i23 *= i26;
            $i$f$hash = i24 ^ i27;
            int i25 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i28 = 0;
            i6 = (long)$i$f$h2;
            obj2 = this;
            i7 = 0;
            int i33 = metadata2;
            metadata2 = obj2.metadata;
            int i31 = 0;
            int i34 = firstAvailableSlot >> 3;
            i35 <<= 3;
            previousMetadata = metadata;
            metadata2[i34] = i13 |= i38;
            int _capacity = obj2._capacity;
            i19 += i32;
            i9 = 0;
            i8 = metadata >> 3;
            i37 <<= 3;
            i4 = _capacity;
            i = metadata;
            metadata2[i8] = i16 |= i2;
            obj.keys[firstAvailableSlot] = i5;
            obj.values[firstAvailableSlot] = obj.values[i10];
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

    @Override // androidx.collection.FloatFloatMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i4;
        long l2;
        long l;
        int i;
        int i6;
        int i5;
        int i2;
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

    public final float getOrPut(float key, Function0<Float> defaultValue) {
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

    @Override // androidx.collection.FloatFloatMap
    public final void minusAssign(float key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.FloatFloatMap
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

    @Override // androidx.collection.FloatFloatMap
    public final void minusAssign(androidx.collection.FloatSet keys) {
        int cmp;
        int obj2;
        Object this_$iv;
        Object obj;
        Object this_$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i4;
        int $i$f$minusAssign;
        long l;
        int i;
        int i3;
        int i2;
        Object this_$iv3;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj = keys;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv3 = obj;
            this_$iv = this;
        }
    }

    @Override // androidx.collection.FloatFloatMap
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

    @Override // androidx.collection.FloatFloatMap
    public final void plusAssign(androidx.collection.FloatFloatMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    @Override // androidx.collection.FloatFloatMap
    public final float put(float key, float value, float default) {
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

    @Override // androidx.collection.FloatFloatMap
    public final void put(float key, float value) {
        set(key, value);
    }

    @Override // androidx.collection.FloatFloatMap
    public final void putAll(androidx.collection.FloatFloatMap from) {
        int cmp;
        int obj;
        int $i$f$forEach2;
        Object k$iv;
        float[] keys;
        Object k$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i3;
        Object this_$iv;
        long l;
        int i4;
        int i2;
        int $i$f$forEach;
        int i5;
        float[] fArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = $i$f$forEach2;
            fArr = keys;
            k$iv = this;
        }
    }

    @Override // androidx.collection.FloatFloatMap
    public final void remove(float key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            removeValueAt(keyIndex);
        }
    }

    @Override // androidx.collection.FloatFloatMap
    public final boolean remove(float key, float value) {
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

    public final void removeIf(Function2<? super Float, ? super Float, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i;
        int i2;
        long l;
        int i3;
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

    @Override // androidx.collection.FloatFloatMap
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

    @Override // androidx.collection.FloatFloatMap
    public final void set(float key, float value) {
        int index;
        index = findInsertIndex(key);
        if (index < 0) {
            index = ~index;
        }
        this.keys[index] = key;
        this.values[index] = value;
    }

    @Override // androidx.collection.FloatFloatMap
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
