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
        int m2;
        int m;
        int index;
        int i14;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i11;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i10;
        int i9;
        int cmp;
        int i12;
        int i8;
        long l;
        int i13;
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i14 = $i$f$h1 & m2;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i51 = 0;
            i5 = 0;
            i6 = 1;
            while (Long.compare(i34, i51) != 0) {
                $this$hasNext$iv = i6;
                i9 = 0;
                i2 = 0;
                $this$get$iv &= i;
                int i42 = m;
                i12 = 0;
                m = $this$next$iv;
                i47 = 0;
                i51 = 0;
                i5 = 0;
                i6 = 1;
                $this$hasNext$iv = i5;
            }
            $this$hasNext$iv = i5;
            int i36 = i4;
            i10 = 0;
            hash = $i$f$hash;
            i14 = i19 & i;
            obj = this;
            m2 = i;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i46 = i14 >> 3;
            i48 <<= 3;
            l5 >>>= i49;
            i = m2;
            i3 = i14;
            i29 |= i8;
            i9 = 0;
            long l7 = 72340172838076673L;
            i50 ^= i11;
            l = -9187201950435737472L;
            i31 &= l;
            i9 = 0;
            i2 = 0;
            $this$get$iv &= i;
            i42 = m;
            i12 = 0;
            m = $this$next$iv;
            $this$hasNext$iv = i6;
        }
        return i11;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i;
        int $this$maskEmptyOrDeleted$iv;
        int i2;
        int i4;
        int i5;
        int i7;
        long l;
        int i6;
        int i3;
        final int _capacity = this._capacity;
        probeOffset = hash1 & _capacity;
        probeIndex = 0;
        long[] metadata = this.metadata;
        i = 0;
        int i8 = probeOffset >> 3;
        i10 <<= 3;
        int i9 = metadata$iv;
        int i12 = 0;
        i17 &= i9;
        $this$maskEmptyOrDeleted$iv = i5 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i4 & _capacity;
            metadata = this.metadata;
            i = 0;
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
        long[] lArr;
        long[] lArr2;
        long l;
        int i;
        int i5;
        int i4;
        int i3;
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
        this.keys = new long[i];
        this.values = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity;
        int removedDeletes;
        int i;
        int $i$f$readRawMetadata;
        int i10;
        Object cmp;
        int _capacity2;
        int i5;
        int i7;
        int i11;
        long[] metadata;
        int i6;
        int i4;
        int i2;
        int i9;
        int i8;
        long[] m;
        int i3;
        final Object obj = this;
        metadata2 = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i = 0;
        while (i < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i7) == 0) {
            } else {
            }
            m = metadata2;
            i3 = _capacity;
            i++;
            metadata2 = m;
            _capacity = i3;
            i7 = 128;
            cmp = this;
            i11 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i >> 3;
            i28 <<= 3;
            i8 = _capacity2;
            metadata[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i6 = 0;
            i4 = i5 >> 3;
            i30 <<= 3;
            m = metadata2;
            i3 = _capacity;
            metadata[i4] = i14 |= i9;
            removedDeletes++;
        }
        long[] m4 = metadata2;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata2;
        int i10;
        int i11;
        int i7;
        int $i$f$hash;
        int firstAvailableSlot;
        int i8;
        long[] metadata;
        int $i$f$h2;
        int i6;
        int i;
        int i2;
        int i4;
        int i3;
        long l;
        long[] previousMetadata;
        int i9;
        int i5;
        obj = this;
        metadata2 = obj.metadata;
        initializeStorage(newCapacity);
        i10 = 0;
        while (i10 < obj._capacity) {
            i11 = 0;
            int i21 = 0;
            i8 = 255;
            if (Long.compare($i$f$readRawMetadata, $i$f$h2) < 0) {
            } else {
            }
            i7 = 0;
            if (i7 != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i10++;
            obj = this;
            metadata2 = previousMetadata;
            i11 = obj.keys[i10];
            int i23 = 0;
            i24 *= i29;
            $i$f$hash = i25 ^ i30;
            int i26 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i31 = 0;
            $i$f$h2 = (long)$i$f$h22;
            i = 0;
            int i34 = i8;
            i8 = obj2;
            metadata = i8.metadata;
            int i32 = 0;
            int i35 = firstAvailableSlot >> 3;
            i36 <<= 3;
            previousMetadata = metadata2;
            metadata[i35] = i14 |= i39;
            int _capacity = i8._capacity;
            i20 += i33;
            i6 = 0;
            i4 = metadata2 >> 3;
            i38 <<= 3;
            i9 = _capacity;
            i5 = metadata2;
            metadata[i4] = i17 |= i2;
            obj.keys[firstAvailableSlot] = i11;
            obj.values[firstAvailableSlot] = obj.values[i10];
            i7 = 1;
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
        int i6;
        int i5;
        int i2;
        int i3;
        int i4;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i6 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i6] = i13 |= i4;
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

    @Override // androidx.collection.LongObjectMap
    public final void minusAssign(androidx.collection.LongSet keys) {
        int cmp;
        int obj;
        Object obj2;
        int $i$f$forEach;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i6;
        int $i$f$minusAssign;
        long l;
        Object this_$iv;
        int i8;
        int i3;
        int i2;
        int i7;
        int i;
        int i4;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj2 = keys;
        final int i15 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj2;
            i4 = $i$f$forEach;
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
        int i3;
        long[] k$iv;
        Object v$iv2;
        Object[] values;
        Object v$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i2;
        int i5;
        Object this_$iv;
        long l;
        int $i$f$forEach;
        int i;
        int i4;
        long[] lArr;
        int i6;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i13 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = i3;
            lArr = k$iv;
            objArr = values;
            v$iv2 = this;
        }
    }

    public final V remove(long key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i9;
        int i8;
        int $this$next$iv$iv;
        int i11;
        int i3;
        int i7;
        int i4;
        long l;
        int i10;
        int i12;
        int i5;
        int i;
        int i6;
        int i2;
        int numberOfTrailingZeros;
        final Object obj = this;
        Object obj2 = obj;
        m$iv2 = 0;
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
                i5 = 1;
                i11 = 0;
                i12 = 0;
                int i29 = m$iv;
                i7 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i5 = 0;
            }
            i5 = 0;
            int i28 = i2;
            i11 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i9 & _capacity;
            m$iv2 = i;
            $i$f$hash = i6;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i4;
            i11 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i8;
            l = -9187201950435737472L;
            i18 &= l;
            i11 = 0;
            i12 = 0;
            i29 = m$iv;
            i7 = 0;
            m$iv = $this$next$iv$iv;
            i5 = 1;
        }
        if (i8 >= 0) {
            return obj.removeValueAt(i8);
        }
        return 0;
    }

    public final boolean remove(long key, V value) {
        Object equal;
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i10;
        int i13;
        int $this$hasNext$iv$iv;
        Object obj2;
        int $this$next$iv$iv;
        Object obj;
        int i9;
        int i7;
        int i11;
        int i8;
        long l;
        int i;
        int i12;
        int i3;
        int i6;
        int i2;
        int i4;
        int i5;
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
            i4 = 0;
            i5 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i5;
                i9 = 0;
                i12 = 0;
                int i29 = m$iv;
                i11 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i4 = 0;
                i5 = 1;
                $this$hasNext$iv$iv = i4;
            }
            $this$hasNext$iv$iv = i4;
            int i28 = i2;
            i9 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj2 = obj27;
            $i$f$h1 = i10 & _capacity;
            m$iv2 = i3;
            $i$f$hash = i6;
            long[] metadata = equal.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i8;
            i9 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i13;
            l = -9187201950435737472L;
            i18 &= l;
            i9 = 0;
            i12 = 0;
            i29 = m$iv;
            i11 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i5;
        }
        if (i13 >= 0) {
            if (Intrinsics.areEqual(obj3.values[i13], obj27)) {
                obj3.removeValueAt(i13);
                return i5;
            }
        } else {
            obj = obj27;
        }
        return i4;
    }

    public final void removeIf(Function2<? super Long, ? super V, Boolean> predicate) {
        int $i$f$removeIf;
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
