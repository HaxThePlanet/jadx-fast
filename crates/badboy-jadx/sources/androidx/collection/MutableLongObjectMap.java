package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002J\u0006\u0010\t\u001a\u00020\u0008J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J'\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0008\u0010\u0013\u001a\u00020\u0008H\u0002J\u0010\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u001bH\u0086\nJ\u0017\u0010\u001c\u001a\u00020\u00082\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001d\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00082\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010#J\u001b\u0010\"\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010%J\u0008\u0010&\u001a\u00020\u0008H\u0002J&\u0010'\u001a\u00020\u00082\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0)H\u0086\u0008ø\u0001\u0000J\u0017\u0010*\u001a\u0004\u0018\u00018\u00002\u0006\u0010+\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00082\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001e\u0010/\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0004J\u0019\u00102\u001a\u00020\u00082\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000cH\u0082\u0008R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00063", d2 = {"Landroidx/collection/MutableLongObjectMap;", "V", "Landroidx/collection/LongObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", "from", "put", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(J)Ljava/lang/Object;", "", "(JLjava/lang/Object;)Z", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(JLjava/lang/Object;)V", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLongObjectMap<V>  extends androidx.collection.LongObjectMap<V> {

    private int growthLimit;
    public MutableLongObjectMap() {
        super(0, 1, 0);
    }

    public MutableLongObjectMap(int initialCapacity) {
        int i;
        super(0);
        i = initialCapacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            initializeStorage(ScatterMapKt.unloadedCapacity(initialCapacity));
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireMutableLongObjectMap$1 = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw $i$a$RequireMutableLongObjectMap$1;
    }

    public MutableLongObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(long key) {
        Object obj;
        int m;
        int m2;
        int index;
        int i12;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i13;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i8;
        int i6;
        int cmp;
        int i11;
        int i4;
        long l;
        int i;
        int i2;
        int i9;
        int i14;
        int i3;
        int i7;
        int i5;
        int i10;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i12 = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i51 = 0;
            i7 = 0;
            i5 = 1;
            while (Long.compare(i34, i51) != 0) {
                $this$hasNext$iv = i5;
                i6 = 0;
                i2 = 0;
                $this$get$iv &= i9;
                int i42 = m2;
                i11 = 0;
                m2 = $this$next$iv;
                i47 = 0;
                i51 = 0;
                i7 = 0;
                i5 = 1;
                $this$hasNext$iv = i7;
            }
            $this$hasNext$iv = i7;
            int i36 = i3;
            i8 = 0;
            hash = $i$f$hash;
            i12 = i19 & i9;
            obj = this;
            m = i9;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i46 = i12 >> 3;
            i48 <<= 3;
            l5 >>>= i49;
            i9 = m;
            i14 = i12;
            i29 |= i4;
            i6 = 0;
            long l7 = 72340172838076673L;
            i50 ^= i13;
            l = -9187201950435737472L;
            i31 &= l;
            i6 = 0;
            i2 = 0;
            $this$get$iv &= i9;
            i42 = m2;
            i11 = 0;
            m2 = $this$next$iv;
            $this$hasNext$iv = i5;
        }
        return i13;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i4;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int i;
        int i2;
        int i5;
        long l;
        int i6;
        int i7;
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
        $this$maskEmptyOrDeleted$iv = i2 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i & _capacity;
            metadata = this.metadata;
            i4 = 0;
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
        int i3;
        int i4;
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
        this.keys = new long[i];
        this.values = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity;
        int removedDeletes;
        int i8;
        int $i$f$readRawMetadata;
        int i5;
        Object cmp;
        int _capacity2;
        int i3;
        int i2;
        int i4;
        long[] metadata2;
        int i7;
        int i6;
        int i10;
        int i9;
        int i11;
        long[] m;
        int i;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i8 = 0;
        while (i8 < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i2) == 0) {
            } else {
            }
            m = metadata;
            i = _capacity;
            i8++;
            metadata = m;
            _capacity = i;
            i2 = 128;
            cmp = this;
            i4 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i8 >> 3;
            i28 <<= 3;
            i11 = _capacity2;
            metadata2[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i7 = 0;
            i6 = i3 >> 3;
            i30 <<= 3;
            m = metadata;
            i = _capacity;
            metadata2[i6] = i14 |= i9;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata;
        int i2;
        int i3;
        int i10;
        int $i$f$hash;
        int firstAvailableSlot;
        int i5;
        long[] metadata2;
        int $i$f$h2;
        int i9;
        int i11;
        int i7;
        int i4;
        int i;
        long l;
        long[] previousMetadata;
        int i6;
        int i8;
        obj = this;
        metadata = obj.metadata;
        initializeStorage(newCapacity);
        i2 = 0;
        while (i2 < obj._capacity) {
            i3 = 0;
            int i21 = 0;
            i5 = 255;
            if (Long.compare($i$f$readRawMetadata, $i$f$h2) < 0) {
            } else {
            }
            i10 = 0;
            if (i10 != 0) {
            } else {
            }
            previousMetadata = metadata;
            i2++;
            obj = this;
            metadata = previousMetadata;
            i3 = obj.keys[i2];
            int i23 = 0;
            i24 *= i29;
            $i$f$hash = i25 ^ i30;
            int i26 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i31 = 0;
            $i$f$h2 = (long)$i$f$h22;
            i11 = 0;
            int i34 = i5;
            i5 = obj2;
            metadata2 = i5.metadata;
            int i32 = 0;
            int i35 = firstAvailableSlot >> 3;
            i36 <<= 3;
            previousMetadata = metadata;
            metadata2[i35] = i14 |= i39;
            int _capacity = i5._capacity;
            i20 += i33;
            i9 = 0;
            i4 = metadata >> 3;
            i38 <<= 3;
            i6 = _capacity;
            i8 = metadata;
            metadata2[i4] = i17 |= i7;
            obj.keys[firstAvailableSlot] = i3;
            obj.values[firstAvailableSlot] = obj.values[i2];
            i10 = 1;
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

    @Override // androidx.collection.LongObjectMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i;
        long l;
        long l2;
        int i3;
        int i2;
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
            i3 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i3] = i13 |= i6;
        }
        ArraysKt.fill(this.values, 0, i7, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(long key, Function0<? extends V> defaultValue) {
        Object invoke;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(obj7, "defaultValue");
        int i2 = 0;
        if (get(key) == null) {
            i = 0;
            set(key, defaultValue);
        }
        return invoke;
    }

    @Override // androidx.collection.LongObjectMap
    public final void minusAssign(long key) {
        final int i = 0;
        remove(key);
    }

    @Override // androidx.collection.LongObjectMap
    public final void minusAssign(androidx.collection.LongList keys) {
        int i$iv;
        long l;
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

    @Override // androidx.collection.LongObjectMap
    public final void minusAssign(androidx.collection.LongSet keys) {
        int cmp;
        int obj2;
        Object obj;
        int $i$f$forEach;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i8;
        int i3;
        int $i$f$minusAssign;
        long l;
        Object this_$iv;
        int i7;
        int i2;
        int i;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj = keys;
        final int i15 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj;
            i6 = $i$f$forEach;
        }
    }

    @Override // androidx.collection.LongObjectMap
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

    public final void plusAssign(androidx.collection.LongObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    public final V put(long key, V value) {
        final int absoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[absoluteInsertIndex] = key;
        this.values[absoluteInsertIndex] = obj6;
        return this.values[absoluteInsertIndex];
    }

    public final void putAll(androidx.collection.LongObjectMap<V> from) {
        int cmp;
        int obj;
        int i2;
        long[] k$iv;
        Object v$iv2;
        Object[] values;
        Object v$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i6;
        Object this_$iv;
        long l;
        int $i$f$forEach;
        int i3;
        int i5;
        long[] lArr;
        int i4;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i13 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = i2;
            lArr = k$iv;
            objArr = values;
            v$iv2 = this;
        }
    }

    public final V remove(long key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i8;
        int i2;
        int $this$next$iv$iv;
        int i3;
        int i4;
        int i5;
        int i10;
        long l;
        int i11;
        int i6;
        int i7;
        int i12;
        int i9;
        int i;
        int numberOfTrailingZeros;
        final Object obj = this;
        Object obj2 = obj;
        m$iv = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj2._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i35 = 0;
            while (Long.compare(i26, i35) != 0) {
                i7 = 1;
                i3 = 0;
                i6 = 0;
                int i29 = m$iv2;
                i5 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i7 = 0;
            }
            i7 = 0;
            int i28 = i;
            i3 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i8 & _capacity;
            m$iv = i12;
            $i$f$hash = i9;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i10;
            i3 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i2;
            l = -9187201950435737472L;
            i18 &= l;
            i3 = 0;
            i6 = 0;
            i29 = m$iv2;
            i5 = 0;
            m$iv2 = $this$next$iv$iv;
            i7 = 1;
        }
        if (i2 >= 0) {
            return obj.removeValueAt(i2);
        }
        return 0;
    }

    public final boolean remove(long key, V value) {
        Object equal;
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i7;
        int i4;
        int $this$hasNext$iv$iv;
        Object obj;
        int $this$next$iv$iv;
        Object obj2;
        int i8;
        int i2;
        int i6;
        int i;
        long l;
        int i5;
        int i9;
        int i12;
        int i10;
        int i3;
        int i13;
        int i11;
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
            i13 = 0;
            i11 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i11;
                i8 = 0;
                i9 = 0;
                int i29 = m$iv2;
                i6 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i13 = 0;
                i11 = 1;
                $this$hasNext$iv$iv = i13;
            }
            $this$hasNext$iv$iv = i13;
            int i28 = i3;
            i8 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj = obj27;
            $i$f$h1 = i7 & _capacity;
            m$iv = i12;
            $i$f$hash = i10;
            long[] metadata = equal.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i;
            i8 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i4;
            l = -9187201950435737472L;
            i18 &= l;
            i8 = 0;
            i9 = 0;
            i29 = m$iv2;
            i6 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$hasNext$iv$iv = i11;
        }
        if (i4 >= 0) {
            if (Intrinsics.areEqual(obj3.values[i4], obj27)) {
                obj3.removeValueAt(i4);
                return i11;
            }
        } else {
            obj2 = obj27;
        }
        return i13;
    }

    public final void removeIf(Function2<? super Long, ? super V, Boolean> predicate) {
        int $i$f$removeIf;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i4;
        int i;
        long l;
        int i2;
        int i3;
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

    public final void set(long key, V value) {
        final int absoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[absoluteInsertIndex] = key;
        this.values[absoluteInsertIndex] = obj5;
    }

    @Override // androidx.collection.LongObjectMap
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
