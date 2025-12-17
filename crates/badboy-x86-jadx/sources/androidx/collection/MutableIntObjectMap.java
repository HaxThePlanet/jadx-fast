package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002J\u0006\u0010\t\u001a\u00020\u0008J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J'\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0008\u0010\u0012\u001a\u00020\u0008H\u0002J\u0010\u0010\u0013\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u001aH\u0086\nJ\u0017\u0010\u001b\u001a\u00020\u00082\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001d\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\u00082\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010!\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\"J\u001b\u0010!\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010$J\u0008\u0010%\u001a\u00020\u0008H\u0002J&\u0010&\u001a\u00020\u00082\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0(H\u0086\u0008ø\u0001\u0000J\u0017\u0010)\u001a\u0004\u0018\u00018\u00002\u0006\u0010*\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\"J\u0010\u0010+\u001a\u00020\u00082\u0006\u0010,\u001a\u00020\u0004H\u0002J\u001e\u0010-\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0004J\u0019\u00100\u001a\u00020\u00082\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u000201H\u0082\u0008R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00062", d2 = {"Landroidx/collection/MutableIntObjectMap;", "V", "Landroidx/collection/IntObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "key", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/IntList;", "Landroidx/collection/IntSet;", "", "plusAssign", "from", "put", "value", "(ILjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(I)Ljava/lang/Object;", "", "(ILjava/lang/Object;)Z", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "(ILjava/lang/Object;)V", "trim", "writeMetadata", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableIntObjectMap<V>  extends androidx.collection.IntObjectMap<V> {

    private int growthLimit;
    public MutableIntObjectMap() {
        super(0, 1, 0);
    }

    public MutableIntObjectMap(int initialCapacity) {
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

    public MutableIntObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(int key) {
        Object obj;
        int m;
        int m2;
        int index;
        int i11;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i3;
        int $this$hasNext$iv;
        int i7;
        int i12;
        int i5;
        int i;
        int $this$next$iv;
        int cmp;
        long l;
        int i8;
        int i9;
        int i13;
        int i14;
        int i4;
        int i10;
        int i6;
        int i2;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i11 = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i52 = 0;
            i10 = 0;
            i6 = 1;
            while (Long.compare(i34, i52) != 0) {
                $this$hasNext$iv = i6;
                int i48 = 0;
                i9 = 0;
                $this$get$iv &= i13;
                int i54 = m2;
                i7 = 0;
                m2 = $this$next$iv;
                i47 = 0;
                i52 = 0;
                i10 = 0;
                i6 = 1;
                $this$hasNext$iv = i10;
            }
            $this$hasNext$iv = i10;
            i12 = key;
            int i36 = i4;
            i9 = 0;
            hash = $i$f$hash;
            i11 = i19 & i13;
            obj = this;
            m = i13;
            long[] metadata2 = obj.metadata;
            i7 = 0;
            int i46 = i11 >> 3;
            i49 <<= 3;
            l4 >>>= i50;
            i13 = m;
            i14 = i11;
            i29 |= cmp;
            i5 = 0;
            long l5 = 72340172838076673L;
            i51 ^= i3;
            l = -9187201950435737472L;
            i31 &= l;
            i48 = 0;
            i9 = 0;
            $this$get$iv &= i13;
            i54 = m2;
            i7 = 0;
            m2 = $this$next$iv;
            $this$hasNext$iv = i6;
        }
        return i3;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i6;
        int $this$maskEmptyOrDeleted$iv;
        int i7;
        int i5;
        int i4;
        int i;
        long l;
        int i3;
        int i2;
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
        $this$maskEmptyOrDeleted$iv = i4 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i5 & _capacity;
            metadata = this.metadata;
            i6 = 0;
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

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr;
        long[] lArr2;
        long l;
        int i4;
        int i5;
        int i3;
        int i;
        int i2;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr = new long[i9 >>= 3];
            i2 = 0;
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
        this.values = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity;
        int removedDeletes;
        int i2;
        int $i$f$readRawMetadata;
        int i3;
        Object cmp;
        int _capacity2;
        int i4;
        int i5;
        int i9;
        long[] metadata;
        int i;
        int i8;
        int i6;
        int i7;
        int i10;
        long[] m;
        int i11;
        final Object obj = this;
        metadata2 = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i2 = 0;
        while (i2 < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i5) == 0) {
            } else {
            }
            m = metadata2;
            i11 = _capacity;
            i2++;
            metadata2 = m;
            _capacity = i11;
            i5 = 128;
            cmp = this;
            i9 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i2 >> 3;
            i28 <<= 3;
            i10 = _capacity2;
            metadata[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i = 0;
            i8 = i4 >> 3;
            i30 <<= 3;
            m = metadata2;
            i11 = _capacity;
            metadata[i8] = i14 |= i7;
            removedDeletes++;
        }
        long[] m4 = metadata2;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj2;
        long[] metadata2;
        int i9;
        int i10;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj;
        int metadata;
        int i2;
        int i4;
        int i7;
        int i6;
        int i;
        int i3;
        long l;
        long[] previousMetadata;
        int i8;
        int i5;
        obj2 = this;
        metadata2 = obj2.metadata;
        initializeStorage(newCapacity);
        i9 = 0;
        while (i9 < obj2._capacity) {
            i10 = 0;
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
            i9++;
            obj2 = this;
            metadata2 = previousMetadata;
            i10 = obj2.keys[i9];
            int i21 = 0;
            i23 *= i26;
            $i$f$hash = i24 ^ i27;
            int i25 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i28 = 0;
            i4 = (long)$i$f$h2;
            obj = this;
            i7 = 0;
            int i33 = metadata;
            metadata = obj.metadata;
            int i31 = 0;
            int i34 = firstAvailableSlot >> 3;
            i35 <<= 3;
            previousMetadata = metadata2;
            metadata[i34] = i13 |= i38;
            int _capacity = obj._capacity;
            i19 += i32;
            i2 = 0;
            i = metadata2 >> 3;
            i37 <<= 3;
            i8 = _capacity;
            i5 = metadata2;
            metadata[i] = i16 |= i6;
            obj2.keys[firstAvailableSlot] = i10;
            obj2.values[firstAvailableSlot] = obj2.values[i9];
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

    @Override // androidx.collection.IntObjectMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i;
        long l;
        long l2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i2 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i2] = i13 |= i6;
        }
        ArraysKt.fill(this.values, 0, i7, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(int key, Function0<? extends V> defaultValue) {
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

    @Override // androidx.collection.IntObjectMap
    public final void minusAssign(int key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.IntObjectMap
    public final void minusAssign(androidx.collection.IntList keys) {
        int i$iv;
        int i2;
        int i3;
        Object obj2;
        int i;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i4 = 0;
        final Object obj = keys;
        final int i5 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i3 = 0;
            i = 0;
            this.remove(obj.content[i$iv]);
            i$iv++;
        }
    }

    @Override // androidx.collection.IntObjectMap
    public final void minusAssign(androidx.collection.IntSet keys) {
        int cmp;
        int obj;
        Object this_$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i2;
        int $i$f$minusAssign;
        long l;
        int i6;
        int i4;
        int i3;
        Object obj2;
        int i5;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(keys, "keys");
        this_$iv2 = keys;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = this_$iv2;
        }
    }

    @Override // androidx.collection.IntObjectMap
    public final void minusAssign(int[] keys) {
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

    public final void plusAssign(androidx.collection.IntObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    public final V put(int key, V value) {
        final int absoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[absoluteInsertIndex] = key;
        this.values[absoluteInsertIndex] = value;
        return this.values[absoluteInsertIndex];
    }

    public final void putAll(androidx.collection.IntObjectMap<V> from) {
        int cmp;
        int obj;
        int $i$f$forEach;
        Object k$iv;
        int[] keys;
        Object k$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i2;
        int i5;
        Object this_$iv;
        long l;
        int i;
        int i3;
        int $i$f$forEach2;
        int i4;
        int[] iArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = cmp;
            $i$f$forEach2 = $i$f$forEach;
            iArr = keys;
            k$iv = this;
        }
    }

    public final V remove(int key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i10;
        int i7;
        int i;
        int i12;
        int i11;
        int $this$next$iv$iv;
        int i9;
        long l;
        int i13;
        int i6;
        int i2;
        int i3;
        int i5;
        int i4;
        int numberOfTrailingZeros;
        int i8;
        final Object obj = this;
        Object obj2 = obj;
        m$iv2 = 0;
        int i20 = 0;
        i21 *= i24;
        $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int _capacity = obj2._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i36 = 0;
            while (Long.compare(i27, i36) != 0) {
                i2 = 1;
                int i32 = 0;
                i6 = 0;
                int i38 = m$iv;
                i = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i36 = 0;
                i2 = 0;
            }
            i2 = 0;
            i12 = key;
            int i29 = i4;
            i6 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i10 & _capacity;
            m$iv2 = i3;
            $i$f$hash = i5;
            long[] metadata = obj2.metadata;
            i = 0;
            int i30 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i9;
            i12 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i7;
            l = -9187201950435737472L;
            i19 &= l;
            i32 = 0;
            i6 = 0;
            i38 = m$iv;
            i = 0;
            m$iv = $this$next$iv$iv;
            i2 = 1;
        }
        if (i7 >= 0) {
            return obj.removeValueAt(i7);
        }
        return 0;
    }

    public final boolean remove(int key, V value) {
        Object equal;
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i11;
        int $this$hasNext$iv$iv;
        Object obj2;
        int i6;
        Object obj;
        int i13;
        int i9;
        int $this$next$iv$iv;
        int i5;
        long l;
        int i10;
        int i7;
        int i8;
        int i2;
        int i4;
        int i12;
        int i3;
        int numberOfTrailingZeros;
        int i14;
        final Object obj3 = this;
        equal = obj3;
        m$iv = 0;
        int i20 = 0;
        i21 *= i24;
        $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int _capacity = equal._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i36 = 0;
            i12 = 0;
            i3 = 1;
            while (Long.compare(i27, i36) != 0) {
                $this$hasNext$iv$iv = i3;
                int i32 = 0;
                i7 = 0;
                int i38 = m$iv2;
                i6 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i36 = 0;
                i12 = 0;
                i3 = 1;
                $this$hasNext$iv$iv = i12;
            }
            $this$hasNext$iv$iv = i12;
            i13 = key;
            int i29 = i4;
            i7 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj2 = value;
            $i$f$h1 = i & _capacity;
            m$iv = i8;
            $i$f$hash = i2;
            long[] metadata = equal.metadata;
            i6 = 0;
            int i30 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i5;
            i13 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i11;
            l = -9187201950435737472L;
            i19 &= l;
            i32 = 0;
            i7 = 0;
            i38 = m$iv2;
            i6 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$hasNext$iv$iv = i3;
        }
        if (i11 >= 0) {
            if (Intrinsics.areEqual(obj3.values[i11], value)) {
                obj3.removeValueAt(i11);
                return i3;
            }
        } else {
            obj = value;
        }
        return i12;
    }

    public final void removeIf(Function2<? super Integer, ? super V, Boolean> predicate) {
        int $i$f$removeIf;
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
        int $i$f$removeIf2;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        final int i5 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i6) {
        } else {
            $i$f$removeIf2 = $i$f$removeIf;
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

    public final void set(int key, V value) {
        final int absoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[absoluteInsertIndex] = key;
        this.values[absoluteInsertIndex] = value;
    }

    @Override // androidx.collection.IntObjectMap
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
