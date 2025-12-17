package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0014\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0008\u0010\u000c\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0008\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\u0003H\u0086\u0002J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\u0003H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0008\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0008\u0010\u001f\u001a\u00020\u0003H\u0007J\u0019\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/collection/MutableIntSet;", "Landroidx/collection/IntSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "addAll", "elements", "", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableIntSet extends androidx.collection.IntSet {

    private int growthLimit;
    public MutableIntSet() {
        super(0, 1, 0);
    }

    public MutableIntSet(int initialCapacity) {
        int i;
        super(0);
        i = initialCapacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            initializeStorage(ScatterMapKt.unloadedCapacity(initialCapacity));
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireMutableIntSet$1 = new IllegalArgumentException("Capacity must be a positive value.".toString());
        throw $i$a$RequireMutableIntSet$1;
    }

    public MutableIntSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(int element) {
        Object obj;
        int m;
        int m2;
        int index;
        int i13;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i7;
        int $this$hasNext$iv;
        int i14;
        int i4;
        int i5;
        int i8;
        int $this$next$iv;
        int cmp;
        long l;
        int i9;
        int i10;
        int i6;
        int i2;
        int i11;
        int i;
        int i12;
        int i3;
        int hash;
        int i20 = 0;
        i21 *= i24;
        int $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i26 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i13 = $i$f$h1 & m;
        probeIndex = 0;
        while (/* condition */) {
            int i47 = 0;
            int i52 = 0;
            i = 0;
            i12 = 1;
            while (Long.compare(i34, i52) != 0) {
                $this$hasNext$iv = i12;
                int i48 = 0;
                i10 = 0;
                $this$get$iv &= i6;
                int i54 = m2;
                i14 = 0;
                m2 = $this$next$iv;
                i47 = 0;
                i52 = 0;
                i = 0;
                i12 = 1;
                $this$hasNext$iv = i;
            }
            $this$hasNext$iv = i;
            i4 = element;
            int i36 = i11;
            i10 = 0;
            hash = $i$f$hash;
            i13 = i19 & i6;
            obj = this;
            m = i6;
            long[] metadata2 = obj.metadata;
            i14 = 0;
            int i46 = i13 >> 3;
            i49 <<= 3;
            l4 >>>= i50;
            i6 = m;
            i2 = i13;
            i29 |= cmp;
            i5 = 0;
            long l5 = 72340172838076673L;
            i51 ^= i7;
            l = -9187201950435737472L;
            i31 &= l;
            i48 = 0;
            i10 = 0;
            $this$get$iv &= i6;
            i54 = m2;
            i14 = 0;
            m2 = $this$next$iv;
            $this$hasNext$iv = i12;
        }
        return i7;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int i5;
        int i6;
        int i7;
        long l;
        int i4;
        int i2;
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
        $this$maskEmptyOrDeleted$iv = i6 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i5 & _capacity;
            metadata = this.metadata;
            i = 0;
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
        int i;
        int i2;
        int i5;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr2 = new long[i9 >>= 3];
            i5 = 0;
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
        this.elements = new int[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity2;
        int removedDeletes;
        int i4;
        int $i$f$readRawMetadata;
        int i3;
        Object cmp;
        int _capacity;
        int i2;
        int i7;
        int i11;
        long[] metadata2;
        int i6;
        int i8;
        int i5;
        int i10;
        int i9;
        long[] m;
        int i;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i4 = 0;
        while (i4 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i7) == 0) {
            } else {
            }
            m = metadata;
            i = _capacity2;
            i4++;
            metadata = m;
            _capacity2 = i;
            i7 = 128;
            cmp = this;
            i11 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i4 >> 3;
            i28 <<= 3;
            i9 = _capacity;
            metadata2[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i6 = 0;
            i8 = i2 >> 3;
            i30 <<= 3;
            m = metadata;
            i = _capacity2;
            metadata2[i8] = i14 |= i10;
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
        long[] metadata2;
        int i7;
        int i;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj;
        int _capacity;
        int i6;
        int i5;
        int i2;
        long[] metadata;
        int i10;
        int i3;
        int i9;
        int i8;
        int i4;
        long[] previousMetadata;
        obj2 = this;
        metadata2 = obj2.metadata;
        initializeStorage(newCapacity);
        i7 = 0;
        while (i7 < obj2._capacity) {
            i = 0;
            int i14 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i5) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i7++;
            obj2 = this;
            metadata2 = previousMetadata;
            i = obj2.elements[i7];
            int i15 = 0;
            i17 *= i20;
            $i$f$hash = i18 ^ i21;
            int i19 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i22 = 0;
            i5 = (long)$i$f$h2;
            obj = this;
            i2 = 0;
            metadata = obj.metadata;
            int i31 = 0;
            int i33 = firstAvailableSlot >> 3;
            i34 <<= 3;
            i4 = _capacity;
            metadata[i33] = i27 |= i37;
            _capacity = obj._capacity;
            i30 += i32;
            i10 = 0;
            i3 = i6 >> 3;
            i36 <<= 3;
            previousMetadata = metadata2;
            metadata[i3] = i13 |= i8;
            obj2.elements[firstAvailableSlot] = i;
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

    @Override // androidx.collection.IntSet
    public final boolean add(int element) {
        int i;
        this.elements[findAbsoluteInsertIndex(element)] = element;
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.IntSet
    public final boolean addAll(androidx.collection.IntSet elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.IntSet
    public final boolean addAll(int[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.IntSet
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i3;
        long l2;
        long l;
        int i5;
        int i;
        int i2;
        int i6;
        int i4;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i5 = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i5] = i12 |= i4;
        }
        initializeGrowth();
    }

    @Override // androidx.collection.IntSet
    public final void minusAssign(int element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i4;
        int i;
        int i7;
        int i12;
        int i8;
        int $this$next$iv$iv;
        int i9;
        long l;
        int i2;
        int i10;
        int i3;
        int i5;
        int i6;
        int i11;
        int numberOfTrailingZeros;
        int i13;
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
            int i30 = 0;
            int i35 = 0;
            while (Long.compare(i26, i35) != 0) {
                i3 = 1;
                int i31 = 0;
                i10 = 0;
                int i37 = m$iv;
                i7 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i3 = 0;
            }
            i3 = 0;
            i12 = element;
            int i28 = i11;
            i10 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i4 & _capacity;
            m$iv2 = i5;
            $i$f$hash = i6;
            long[] metadata = obj2.metadata;
            i7 = 0;
            int i29 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i9;
            i12 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i;
            l = -9187201950435737472L;
            i18 &= l;
            i31 = 0;
            i10 = 0;
            i37 = m$iv;
            i7 = 0;
            m$iv = $this$next$iv$iv;
            i3 = 1;
        }
        if (i >= 0) {
            obj.removeElementAt(i);
        }
    }

    @Override // androidx.collection.IntSet
    public final void minusAssign(androidx.collection.IntSet elements) {
        Object this_$iv2;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i5;
        int j$iv$iv;
        int i;
        int i2;
        long l;
        int i3;
        int i6;
        int i4;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(elements, "elements");
        obj = elements;
        final int i7 = 0;
        final int i8 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            this_$iv = obj;
            this_$iv2 = this;
        }
    }

    @Override // androidx.collection.IntSet
    public final void minusAssign(int[] elements) {
        int i3;
        int i;
        int i2;
        int i4;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i5 = 0;
        i3 = 0;
        while (i3 < obj.length) {
            i4 = 0;
            minusAssign(obj[i3]);
            i3++;
        }
    }

    @Override // androidx.collection.IntSet
    public final void plusAssign(int element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    @Override // androidx.collection.IntSet
    public final void plusAssign(androidx.collection.IntSet elements) {
        Object this_$iv2;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int j$iv$iv;
        int i5;
        int i4;
        long l;
        int i;
        int i6;
        int i2;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(elements, "elements");
        obj = elements;
        final int i7 = 0;
        final int i8 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            this_$iv = obj;
            this_$iv2 = this;
        }
    }

    @Override // androidx.collection.IntSet
    public final void plusAssign(int[] elements) {
        int i2;
        int i;
        int i4;
        int i3;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i5 = 0;
        i2 = 0;
        while (i2 < obj.length) {
            i3 = 0;
            plusAssign(obj[i2]);
            i2++;
        }
    }

    @Override // androidx.collection.IntSet
    public final boolean remove(int element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i14;
        int $this$hasNext$iv$iv;
        int i5;
        int i8;
        int i11;
        int $this$next$iv$iv;
        int i9;
        long l;
        int i7;
        int i2;
        int i10;
        int i12;
        int i13;
        int i3;
        int i4;
        int numberOfTrailingZeros;
        int i6;
        final Object obj = this;
        final Object obj2 = obj;
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
            i4 = 1;
            while (Long.compare(i27, i36) != 0) {
                $this$hasNext$iv$iv = i4;
                int i32 = 0;
                i2 = 0;
                int i38 = m$iv;
                i5 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i36 = 0;
                i4 = 1;
                $this$hasNext$iv$iv = i3;
            }
            $this$hasNext$iv$iv = i3;
            i8 = element;
            int i29 = i13;
            i2 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i & _capacity;
            m$iv2 = i10;
            $i$f$hash = i12;
            long[] metadata = obj2.metadata;
            i5 = 0;
            int i30 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i9;
            i8 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i14;
            l = -9187201950435737472L;
            i19 &= l;
            i32 = 0;
            i2 = 0;
            i38 = m$iv;
            i5 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i4;
        }
        if (i14 >= 0) {
            i3 = i4;
        }
        if (i3 != 0) {
            obj.removeElementAt(i14);
        }
        return i3;
    }

    @Override // androidx.collection.IntSet
    public final boolean removeAll(androidx.collection.IntSet elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.IntSet
    public final boolean removeAll(int[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.IntSet
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
