package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002J\u0006\u0010\t\u001a\u00020\u0008J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J'\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0008\u0010\u0013\u001a\u00020\u0008H\u0002J\u0010\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u001bH\u0086\nJ\u0017\u0010\u001c\u001a\u00020\u00082\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001d\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00082\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010#J\u001b\u0010\"\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010%J\u0008\u0010&\u001a\u00020\u0008H\u0002J&\u0010'\u001a\u00020\u00082\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0)H\u0086\u0008ø\u0001\u0000J\u0017\u0010*\u001a\u0004\u0018\u00018\u00002\u0006\u0010+\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00082\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001e\u0010/\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0004J\u0019\u00102\u001a\u00020\u00082\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u000203H\u0082\u0008R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00064", d2 = {"Landroidx/collection/MutableFloatObjectMap;", "V", "Landroidx/collection/FloatObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/FloatList;", "Landroidx/collection/FloatSet;", "", "plusAssign", "from", "put", "value", "(FLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(F)Ljava/lang/Object;", "", "(FLjava/lang/Object;)Z", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(FLjava/lang/Object;)V", "trim", "writeMetadata", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableFloatObjectMap<V>  extends androidx.collection.FloatObjectMap<V> {

    private int growthLimit;
    public MutableFloatObjectMap() {
        super(0, 1, 0);
    }

    public MutableFloatObjectMap(int initialCapacity) {
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

    public MutableFloatObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(float key) {
        Object obj;
        int m;
        int m2;
        int index;
        int i;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i13;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i2;
        int i5;
        int cmp;
        int i8;
        int i9;
        long l;
        int i4;
        int i10;
        int i6;
        int i3;
        int i12;
        int i7;
        int i11;
        int numberOfTrailingZeros;
        int hash;
        int i19 = 0;
        i20 *= i23;
        int $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i25 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i46 = 0;
            int i50 = 0;
            i7 = 0;
            i11 = 1;
            while (Long.compare(i33, i50) != 0) {
                $this$hasNext$iv = i11;
                i5 = 0;
                i10 = 0;
                $this$get$iv &= i6;
                if (Float.compare(f, key) == 0) {
                }
                int i44 = m2;
                i8 = 0;
                m2 = $this$next$iv;
                i46 = 0;
                i50 = 0;
                i7 = 0;
                i11 = 1;
                $this$hasNext$iv = i7;
                i7 = i11;
            }
            $this$hasNext$iv = i7;
            int i34 = i12;
            i2 = 0;
            hash = $i$f$hash;
            i = i18 & i6;
            obj = this;
            m = i6;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i45 = i >> 3;
            i47 <<= 3;
            l4 >>>= i48;
            i6 = m;
            i3 = i;
            i28 |= i9;
            i5 = 0;
            long l6 = 72340172838076673L;
            i49 ^= i13;
            l = -9187201950435737472L;
            i30 &= l;
            i5 = 0;
            i10 = 0;
            $this$get$iv &= i6;
            if (Float.compare(f, key) == 0) {
            }
            i44 = m2;
            i8 = 0;
            m2 = $this$next$iv;
            i7 = i11;
            $this$hasNext$iv = i11;
        }
        return i13;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i5;
        int $this$maskEmptyOrDeleted$iv;
        int i7;
        int i6;
        int i2;
        int i;
        long l;
        int i3;
        int i4;
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

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr2;
        long[] lArr;
        long l;
        int i2;
        int i4;
        int i3;
        int i5;
        int i;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr2 = new long[i9 >>= 3];
            i = 0;
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
        this.values = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity2;
        int removedDeletes;
        int i6;
        int $i$f$readRawMetadata;
        int i8;
        Object cmp;
        int _capacity;
        int i9;
        int i;
        int i2;
        long[] metadata2;
        int i11;
        int i3;
        int i10;
        int i5;
        int i4;
        long[] m;
        int i7;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i6 = 0;
        while (i6 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i) == 0) {
            } else {
            }
            m = metadata;
            i7 = _capacity2;
            i6++;
            metadata = m;
            _capacity2 = i7;
            i = 128;
            cmp = this;
            i2 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i6 >> 3;
            i28 <<= 3;
            i4 = _capacity;
            metadata2[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i11 = 0;
            i3 = i9 >> 3;
            i30 <<= 3;
            m = metadata;
            i7 = _capacity2;
            metadata2[i3] = i14 |= i5;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj2;
        long[] metadata2;
        int i;
        int i7;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj;
        int metadata;
        int i5;
        int i3;
        int i2;
        int i10;
        int i6;
        int i9;
        long l;
        long[] previousMetadata;
        int i4;
        int i8;
        obj2 = this;
        metadata2 = obj2.metadata;
        initializeStorage(newCapacity);
        i = 0;
        while (i < obj2._capacity) {
            i7 = 0;
            int i20 = 0;
            metadata = 255;
            if (Long.compare($i$f$readRawMetadata, i3) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i++;
            obj2 = this;
            metadata2 = previousMetadata;
            i7 = obj2.keys[i];
            int i21 = 0;
            i23 *= i26;
            $i$f$hash = i24 ^ i27;
            int i25 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i28 = 0;
            i3 = (long)$i$f$h2;
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
            i5 = 0;
            i6 = metadata2 >> 3;
            i37 <<= 3;
            i4 = _capacity;
            i8 = metadata2;
            metadata[i6] = i16 |= i10;
            obj2.keys[firstAvailableSlot] = i7;
            obj2.values[firstAvailableSlot] = obj2.values[i];
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

    @Override // androidx.collection.FloatObjectMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i5;
        long l2;
        long l;
        int i;
        int i2;
        int i3;
        int i4;
        int i6;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i] = i13 |= i6;
        }
        ArraysKt.fill(this.values, 0, i7, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(float key, Function0<? extends V> defaultValue) {
        Object invoke;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i2 = 0;
        if (get(key) == null) {
            i = 0;
            set(key, defaultValue.invoke());
        }
        return invoke;
    }

    @Override // androidx.collection.FloatObjectMap
    public final void minusAssign(float key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.FloatObjectMap
    public final void minusAssign(androidx.collection.FloatList keys) {
        int i$iv;
        float f;
        int i;
        Object obj2;
        int i2;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i3 = 0;
        final Object obj = keys;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i = 0;
            i2 = 0;
            this.remove(obj.content[i$iv]);
            i$iv++;
        }
    }

    @Override // androidx.collection.FloatObjectMap
    public final void minusAssign(androidx.collection.FloatSet keys) {
        int cmp;
        int obj2;
        Object this_$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i;
        int $i$f$minusAssign;
        long l;
        int i2;
        int i6;
        int i4;
        Object obj;
        int i5;
        Object this_$iv2;
        Intrinsics.checkNotNullParameter(keys, "keys");
        this_$iv = keys;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv2 = this_$iv;
        }
    }

    @Override // androidx.collection.FloatObjectMap
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

    public final void plusAssign(androidx.collection.FloatObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    public final V put(float key, V value) {
        final int absoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[absoluteInsertIndex] = key;
        this.values[absoluteInsertIndex] = value;
        return this.values[absoluteInsertIndex];
    }

    public final void putAll(androidx.collection.FloatObjectMap<V> from) {
        int cmp;
        int obj;
        int $i$f$forEach2;
        Object k$iv2;
        float[] keys;
        Object k$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i5;
        Object this_$iv;
        long l;
        int i4;
        int i;
        int $i$f$forEach;
        int i2;
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
            k$iv2 = this;
        }
    }

    public final V remove(float key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i9;
        int i10;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i5;
        int i2;
        int i12;
        int i;
        long l;
        int i3;
        int i4;
        int i11;
        int i8;
        int i7;
        int i13;
        int i6;
        int numberOfTrailingZeros;
        final Object obj = this;
        Object obj2 = obj;
        m$iv = 0;
        int i20 = 0;
        i21 *= i24;
        $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int _capacity = obj2._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i32 = 0;
            int i36 = 0;
            i6 = 1;
            while (Long.compare(i27, i36) != 0) {
                $this$hasNext$iv$iv = i6;
                i5 = 0;
                i4 = 0;
                if (Float.compare(f, key) == 0) {
                }
                int i30 = m$iv2;
                i12 = 0;
                m$iv2 = $this$next$iv$iv;
                i32 = 0;
                i36 = 0;
                i6 = 1;
                $this$hasNext$iv$iv = i13;
                i13 = i6;
            }
            $this$hasNext$iv$iv = i13;
            int i28 = i7;
            i5 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i13) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i9 & _capacity;
            m$iv = i11;
            $i$f$hash = i8;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i31 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i;
            i5 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i10;
            l = -9187201950435737472L;
            i19 &= l;
            i5 = 0;
            i4 = 0;
            if (Float.compare(f, key) == 0) {
            }
            i30 = m$iv2;
            i12 = 0;
            m$iv2 = $this$next$iv$iv;
            i13 = i6;
            $this$hasNext$iv$iv = i6;
        }
        if (i10 >= 0) {
            return obj.removeValueAt(i10);
        }
        return 0;
    }

    public final boolean remove(float key, V value) {
        Object equal;
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i11;
        int i5;
        int $this$hasNext$iv$iv;
        Object obj;
        int $this$next$iv$iv;
        Object obj2;
        int i8;
        int i;
        int i9;
        int i10;
        long l;
        int i12;
        int i2;
        int i13;
        int i4;
        int i6;
        int i3;
        int i7;
        int numberOfTrailingZeros;
        final Object obj3 = this;
        equal = obj3;
        m$iv2 = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = equal._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i35 = 0;
            i3 = 0;
            i7 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i7;
                i8 = 0;
                i2 = 0;
                if (Float.compare(f, key) == 0) {
                } else {
                }
                $this$next$iv$iv = i3;
                int i29 = m$iv;
                i9 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i3 = 0;
                i7 = 1;
                $this$hasNext$iv$iv = i3;
                $this$next$iv$iv = i7;
            }
            $this$hasNext$iv$iv = i3;
            int i28 = i6;
            i8 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj = value;
            $i$f$h1 = i11 & _capacity;
            m$iv2 = i13;
            $i$f$hash = i4;
            long[] metadata = equal.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i10;
            i8 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i5;
            l = -9187201950435737472L;
            i18 &= l;
            i8 = 0;
            i2 = 0;
            if (Float.compare(f, key) == 0) {
            } else {
            }
            $this$next$iv$iv = i3;
            i29 = m$iv;
            i9 = 0;
            m$iv = $this$next$iv$iv;
            $this$next$iv$iv = i7;
            $this$hasNext$iv$iv = i7;
        }
        if (i5 >= 0) {
            if (Intrinsics.areEqual(obj3.values[i5], value)) {
                obj3.removeValueAt(i5);
                return i7;
            }
        } else {
            obj2 = value;
        }
        return i3;
    }

    public final void removeIf(Function2<? super Float, ? super V, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i2;
        int i3;
        long l;
        int i;
        int i4;
        int $i$f$removeIf;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        final int i5 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i6) {
        } else {
            $i$f$removeIf = $i$f$removeIf2;
        }
    }

    public final V removeValueAt(int index) {
        this._size = _size--;
        int i2 = 254;
        Object obj2 = this;
        final int i4 = 0;
        final long[] metadata = obj2.metadata;
        int i5 = 0;
        int i6 = index >> 3;
        i10 <<= 3;
        int i19 = 255;
        metadata[i6] = i14 |= i26;
        int $i$f$writeRawMetadata = obj2._capacity;
        i8 += i12;
        int i13 = 0;
        int i16 = i9 >> 3;
        i17 <<= 3;
        metadata[i16] = i22 |= i27;
        this.values[index] = 0;
        return this.values[index];
    }

    public final void set(float key, V value) {
        final int absoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[absoluteInsertIndex] = key;
        this.values[absoluteInsertIndex] = value;
    }

    @Override // androidx.collection.FloatObjectMap
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
