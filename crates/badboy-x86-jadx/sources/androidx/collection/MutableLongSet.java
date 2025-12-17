package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cJ\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0008\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000cH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000cH\u0086\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cJ\u0008\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0008\u0010 \u001a\u00020\u0003H\u0007J\u0019\u0010!\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\tH\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/collection/MutableLongSet;", "Landroidx/collection/LongSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "", "addAll", "elements", "", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLongSet extends androidx.collection.LongSet {

    private int growthLimit;
    public MutableLongSet() {
        super(0, 1, 0);
    }

    public MutableLongSet(int initialCapacity) {
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

    public MutableLongSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(long element) {
        Object obj;
        int m;
        int m2;
        int index;
        int i10;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i9;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i14;
        int i8;
        int cmp;
        int i4;
        int i11;
        long l;
        int i;
        int i5;
        int i12;
        int i7;
        int i13;
        int i6;
        int i2;
        int i3;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i10 = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i51 = 0;
            i6 = 0;
            i2 = 1;
            while (Long.compare(i34, i51) != 0) {
                $this$hasNext$iv = i2;
                i8 = 0;
                i5 = 0;
                $this$get$iv &= i12;
                int i42 = m2;
                i4 = 0;
                m2 = $this$next$iv;
                i47 = 0;
                i51 = 0;
                i6 = 0;
                i2 = 1;
                $this$hasNext$iv = i6;
            }
            $this$hasNext$iv = i6;
            int i36 = i13;
            i14 = 0;
            hash = $i$f$hash;
            i10 = i19 & i12;
            obj = this;
            m = i12;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i46 = i10 >> 3;
            i48 <<= 3;
            l5 >>>= i49;
            i12 = m;
            i7 = i10;
            i29 |= i11;
            i8 = 0;
            long l7 = 72340172838076673L;
            i50 ^= i9;
            l = -9187201950435737472L;
            i31 &= l;
            i8 = 0;
            i5 = 0;
            $this$get$iv &= i12;
            i42 = m2;
            i4 = 0;
            m2 = $this$next$iv;
            $this$hasNext$iv = i2;
        }
        return i9;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i;
        int $this$maskEmptyOrDeleted$iv;
        int i7;
        int i4;
        int i5;
        int i6;
        long l;
        int i2;
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
        int i3;
        int i5;
        int i4;
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
        this.elements = new long[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity;
        int removedDeletes;
        int i7;
        int $i$f$readRawMetadata;
        int i;
        Object cmp;
        int _capacity2;
        int i10;
        int i8;
        int i6;
        long[] metadata2;
        int i9;
        int i3;
        int i4;
        int i11;
        int i5;
        long[] m;
        int i2;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i7 = 0;
        while (i7 < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i8) == 0) {
            } else {
            }
            m = metadata;
            i2 = _capacity;
            i7++;
            metadata = m;
            _capacity = i2;
            i8 = 128;
            cmp = this;
            i6 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i7 >> 3;
            i28 <<= 3;
            i5 = _capacity2;
            metadata2[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i9 = 0;
            i3 = i10 >> 3;
            i30 <<= 3;
            m = metadata;
            i2 = _capacity;
            metadata2[i3] = i14 |= i11;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void removeElementAt(int index) {
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

    private final void resizeStorage(int newCapacity) {
        Object obj2;
        long[] metadata;
        int i7;
        int i9;
        int i4;
        int $i$f$hash;
        int firstAvailableSlot;
        int metadata2;
        int i10;
        int $i$f$h2;
        Object obj;
        int i6;
        int i2;
        int i8;
        int i3;
        long l;
        long[] previousMetadata;
        int i5;
        int i;
        obj2 = this;
        metadata = obj2.metadata;
        initializeStorage(newCapacity);
        i7 = 0;
        while (i7 < obj2._capacity) {
            i9 = 0;
            int i19 = 0;
            metadata2 = 255;
            if (Long.compare($i$f$readRawMetadata, $i$f$h2) < 0) {
            } else {
            }
            i4 = 0;
            if (i4 != 0) {
            } else {
            }
            previousMetadata = metadata;
            i7++;
            obj2 = this;
            metadata = previousMetadata;
            i9 = obj2.elements[i7];
            int i21 = 0;
            i22 *= i29;
            $i$f$hash = i23 ^ i30;
            int i24 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i31 = 0;
            $i$f$h2 = (long)$i$f$h22;
            obj = this;
            i6 = 0;
            int i32 = metadata2;
            metadata2 = obj.metadata;
            int i27 = 0;
            int i33 = firstAvailableSlot >> 3;
            i34 <<= 3;
            previousMetadata = metadata;
            metadata2[i33] = i13 |= i37;
            int _capacity = obj._capacity;
            i18 += i28;
            i10 = 0;
            i8 = metadata >> 3;
            i36 <<= 3;
            i5 = _capacity;
            i = metadata;
            metadata2[i8] = i16 |= i2;
            obj2.elements[firstAvailableSlot] = i9;
            i4 = 1;
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

    @Override // androidx.collection.LongSet
    public final boolean add(long element) {
        int i;
        this.elements[findAbsoluteInsertIndex(element)] = element;
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.LongSet
    public final boolean addAll(androidx.collection.LongSet elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.LongSet
    public final boolean addAll(long[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.LongSet
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i2;
        long l2;
        long l;
        int i5;
        int i6;
        int i;
        int i4;
        int i3;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i5 = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i5] = i12 |= i3;
        }
        initializeGrowth();
    }

    @Override // androidx.collection.LongSet
    public final void minusAssign(long element) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i7;
        int i8;
        int $this$next$iv$iv;
        int i6;
        int i9;
        int i3;
        int i11;
        long l;
        int i10;
        int i5;
        int i12;
        int i4;
        int i2;
        int i;
        int numberOfTrailingZeros;
        final Object obj = this;
        final Object obj2 = obj;
        m$iv = 0;
        int i18 = 0;
        i19 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        int _capacity = obj2._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i34 = 0;
            while (Long.compare(i25, i34) != 0) {
                i12 = 1;
                i6 = 0;
                i5 = 0;
                int i28 = m$iv2;
                i3 = 0;
                m$iv2 = $this$next$iv$iv;
                i30 = 0;
                i34 = 0;
                i12 = 0;
            }
            i12 = 0;
            int i27 = i;
            i6 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i7 & _capacity;
            m$iv = i4;
            $i$f$hash = i2;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            l4 >>>= i32;
            i15 |= i11;
            i6 = 0;
            long l5 = 72340172838076673L;
            i33 ^= i8;
            l = -9187201950435737472L;
            i17 &= l;
            i6 = 0;
            i5 = 0;
            i28 = m$iv2;
            i3 = 0;
            m$iv2 = $this$next$iv$iv;
            i12 = 1;
        }
        if (i8 >= 0) {
            obj.removeElementAt(i8);
        }
    }

    @Override // androidx.collection.LongSet
    public final void minusAssign(androidx.collection.LongSet elements) {
        Object this_$iv2;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i7;
        int i8;
        int i4;
        int i3;
        long l;
        int i2;
        int i6;
        int i5;
        int i;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(elements, "elements");
        obj = elements;
        final int i9 = 0;
        final int i10 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i11) {
        } else {
            this_$iv = obj;
            this_$iv2 = this;
        }
    }

    @Override // androidx.collection.LongSet
    public final void minusAssign(long[] elements) {
        int i;
        long l2;
        long l;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i3 = 0;
        i = 0;
        while (i < obj.length) {
            i2 = 0;
            minusAssign(obj[i]);
            i++;
        }
    }

    @Override // androidx.collection.LongSet
    public final void plusAssign(long element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    @Override // androidx.collection.LongSet
    public final void plusAssign(androidx.collection.LongSet elements) {
        Object this_$iv;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int i3;
        int i;
        int i8;
        long l;
        int i7;
        int i6;
        int i5;
        int i2;
        Object this_$iv2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        obj = elements;
        final int i9 = 0;
        final int i10 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i11) {
        } else {
            this_$iv2 = obj;
            this_$iv = this;
        }
    }

    @Override // androidx.collection.LongSet
    public final void plusAssign(long[] elements) {
        int i;
        long l2;
        long l;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i3 = 0;
        i = 0;
        while (i < obj.length) {
            i2 = 0;
            plusAssign(obj[i]);
            i++;
        }
    }

    @Override // androidx.collection.LongSet
    public final boolean remove(long element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i9;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i11;
        int i6;
        int i13;
        int i10;
        long l;
        int i2;
        int i7;
        int i3;
        int i8;
        int i5;
        int i4;
        int i12;
        int numberOfTrailingZeros;
        final Object obj = this;
        final Object obj2 = obj;
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
            i12 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i12;
                i11 = 0;
                i7 = 0;
                int i29 = m$iv;
                i13 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i12 = 1;
                $this$hasNext$iv$iv = i4;
            }
            $this$hasNext$iv$iv = i4;
            int i28 = i5;
            i11 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i & _capacity;
            m$iv2 = i3;
            $i$f$hash = i8;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i10;
            i11 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i9;
            l = -9187201950435737472L;
            i18 &= l;
            i11 = 0;
            i7 = 0;
            i29 = m$iv;
            i13 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i12;
        }
        if (i9 >= 0) {
            i4 = i12;
        }
        if (i4 != 0) {
            obj.removeElementAt(i9);
        }
        return i4;
    }

    @Override // androidx.collection.LongSet
    public final boolean removeAll(androidx.collection.LongSet elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.LongSet
    public final boolean removeAll(long[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.LongSet
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
