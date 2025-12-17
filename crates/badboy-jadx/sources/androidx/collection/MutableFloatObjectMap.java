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
        IllegalArgumentException $i$a$RequireMutableFloatObjectMap$1 = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw $i$a$RequireMutableFloatObjectMap$1;
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
        int m2;
        int m;
        int index;
        int i10;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i4;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i11;
        int i2;
        int cmp;
        int i6;
        int i7;
        long l;
        int i8;
        int i13;
        int i3;
        int i;
        int i12;
        int i9;
        int i5;
        int numberOfTrailingZeros;
        int hash;
        int i19 = 0;
        i20 *= i23;
        int $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i25 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i10 = $i$f$h1 & m2;
        probeIndex = 0;
        while (/* condition */) {
            int i46 = 0;
            int i50 = 0;
            i9 = 0;
            i5 = 1;
            while (Long.compare(i33, i50) != 0) {
                $this$hasNext$iv = i5;
                i2 = 0;
                i13 = 0;
                $this$get$iv &= i3;
                if (Float.compare(f, key) == 0) {
                }
                int i44 = m;
                i6 = 0;
                m = $this$next$iv;
                i46 = 0;
                i50 = 0;
                i9 = 0;
                i5 = 1;
                $this$hasNext$iv = i9;
                i9 = i5;
            }
            $this$hasNext$iv = i9;
            int i34 = i12;
            i11 = 0;
            hash = $i$f$hash;
            i10 = i18 & i3;
            obj = this;
            m2 = i3;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i45 = i10 >> 3;
            i47 <<= 3;
            l4 >>>= i48;
            i3 = m2;
            i = i10;
            i28 |= i7;
            i2 = 0;
            long l6 = 72340172838076673L;
            i49 ^= i4;
            l = -9187201950435737472L;
            i30 &= l;
            i2 = 0;
            i13 = 0;
            $this$get$iv &= i3;
            if (Float.compare(f, key) == 0) {
            }
            i44 = m;
            i6 = 0;
            m = $this$next$iv;
            i9 = i5;
            $this$hasNext$iv = i5;
        }
        return i4;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i7;
        int $this$maskEmptyOrDeleted$iv;
        int i;
        int i6;
        int i5;
        int i3;
        long l;
        int i4;
        int i2;
        final int _capacity = this._capacity;
        probeOffset = hash1 & _capacity;
        probeIndex = 0;
        long[] metadata = this.metadata;
        i7 = 0;
        int i8 = probeOffset >> 3;
        i10 <<= 3;
        int i9 = metadata$iv;
        int i12 = 0;
        i17 &= i9;
        $this$maskEmptyOrDeleted$iv = i5 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i6 & _capacity;
            metadata = this.metadata;
            i7 = 0;
            i8 = probeOffset >> 3;
            i10 <<= 3;
            i9 = metadata$iv;
            i12 = 0;
            i17 &= i9;
            $this$maskEmptyOrDeleted$iv = i5 & l;
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
        int i3;
        int i5;
        int i4;
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
        this.values = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity2;
        int removedDeletes;
        int i3;
        int $i$f$readRawMetadata;
        int i7;
        Object cmp;
        int _capacity;
        int i5;
        int i8;
        int i10;
        long[] metadata2;
        int i9;
        int i;
        int i2;
        int i6;
        int i4;
        long[] m;
        int i11;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i3 = 0;
        while (i3 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i8) == 0) {
            } else {
            }
            m = metadata;
            i11 = _capacity2;
            i3++;
            metadata = m;
            _capacity2 = i11;
            i8 = 128;
            cmp = this;
            i10 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i3 >> 3;
            i28 <<= 3;
            i4 = _capacity;
            metadata2[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i9 = 0;
            i = i5 >> 3;
            i30 <<= 3;
            m = metadata;
            i11 = _capacity2;
            metadata2[i] = i14 |= i6;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata2;
        int i9;
        int i8;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj2;
        int metadata;
        int i2;
        int i6;
        int i3;
        int i7;
        int i;
        int i4;
        long l;
        long[] previousMetadata;
        int i5;
        int i10;
        obj = this;
        metadata2 = obj.metadata;
        initializeStorage(newCapacity);
        i9 = 0;
        while (i9 < obj._capacity) {
            i8 = 0;
            int i20 = 0;
            metadata = 255;
            if (Long.compare($i$f$readRawMetadata, i6) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i9++;
            obj = this;
            metadata2 = previousMetadata;
            i8 = obj.keys[i9];
            int i21 = 0;
            i23 *= i26;
            $i$f$hash = i24 ^ i27;
            int i25 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i28 = 0;
            i6 = (long)$i$f$h2;
            obj2 = this;
            i3 = 0;
            int i33 = metadata;
            metadata = obj2.metadata;
            int i31 = 0;
            int i34 = firstAvailableSlot >> 3;
            i35 <<= 3;
            previousMetadata = metadata2;
            metadata[i34] = i13 |= i38;
            int _capacity = obj2._capacity;
            i19 += i32;
            i2 = 0;
            i = metadata2 >> 3;
            i37 <<= 3;
            i5 = _capacity;
            i10 = metadata2;
            metadata[i] = i16 |= i7;
            obj.keys[firstAvailableSlot] = i8;
            obj.values[firstAvailableSlot] = obj.values[i9];
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
        int i2;
        long l2;
        long l;
        int i5;
        int i6;
        int i;
        int i3;
        int i4;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i5 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i5] = i13 |= i4;
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
        int i2;
        Object obj2;
        int i;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i3 = 0;
        final Object obj = keys;
        final int i4 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i2 = 0;
            i = 0;
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
        int i2;
        int i6;
        int $i$f$minusAssign;
        long l;
        int i;
        int i5;
        int i4;
        Object obj;
        int i3;
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
        int i2;
        int i4;
        Object this_$iv;
        long l;
        int i;
        int i3;
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
            k$iv2 = this;
        }
    }

    public final V remove(float key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i4;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i2;
        int i8;
        int i3;
        int i6;
        long l;
        int i7;
        int i12;
        int i10;
        int i9;
        int i11;
        int i13;
        int i5;
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
            i5 = 1;
            while (Long.compare(i27, i36) != 0) {
                $this$hasNext$iv$iv = i5;
                i2 = 0;
                i12 = 0;
                if (Float.compare(f, key) == 0) {
                }
                int i30 = m$iv2;
                i3 = 0;
                m$iv2 = $this$next$iv$iv;
                i32 = 0;
                i36 = 0;
                i5 = 1;
                $this$hasNext$iv$iv = i13;
                i13 = i5;
            }
            $this$hasNext$iv$iv = i13;
            int i28 = i11;
            i2 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i13) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i & _capacity;
            m$iv = i10;
            $i$f$hash = i9;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i31 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i6;
            i2 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i4;
            l = -9187201950435737472L;
            i19 &= l;
            i2 = 0;
            i12 = 0;
            if (Float.compare(f, key) == 0) {
            }
            i30 = m$iv2;
            i3 = 0;
            m$iv2 = $this$next$iv$iv;
            i13 = i5;
            $this$hasNext$iv$iv = i5;
        }
        if (i4 >= 0) {
            return obj.removeValueAt(i4);
        }
        return 0;
    }

    public final boolean remove(float key, V value) {
        Object equal;
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i9;
        int $this$hasNext$iv$iv;
        Object obj2;
        int $this$next$iv$iv;
        Object obj;
        int i10;
        int i12;
        int i11;
        int i8;
        long l;
        int i13;
        int i6;
        int i2;
        int i3;
        int i4;
        int i5;
        int i7;
        int numberOfTrailingZeros;
        final Object obj3 = this;
        equal = obj3;
        m$iv = 0;
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
            i5 = 0;
            i7 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i7;
                i10 = 0;
                i6 = 0;
                if (Float.compare(f, key) == 0) {
                } else {
                }
                $this$next$iv$iv = i5;
                int i29 = m$iv2;
                i11 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i5 = 0;
                i7 = 1;
                $this$hasNext$iv$iv = i5;
                $this$next$iv$iv = i7;
            }
            $this$hasNext$iv$iv = i5;
            int i28 = i4;
            i10 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj2 = value;
            $i$f$h1 = i & _capacity;
            m$iv = i2;
            $i$f$hash = i3;
            long[] metadata = equal.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i8;
            i10 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i9;
            l = -9187201950435737472L;
            i18 &= l;
            i10 = 0;
            i6 = 0;
            if (Float.compare(f, key) == 0) {
            } else {
            }
            $this$next$iv$iv = i5;
            i29 = m$iv2;
            i11 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$next$iv$iv = i7;
            $this$hasNext$iv$iv = i7;
        }
        if (i9 >= 0) {
            if (Intrinsics.areEqual(obj3.values[i9], value)) {
                obj3.removeValueAt(i9);
                return i7;
            }
        } else {
            obj = value;
        }
        return i5;
    }

    public final void removeIf(Function2<? super Float, ? super V, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i;
        int i3;
        long l;
        int i4;
        int i2;
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
