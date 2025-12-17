package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0014\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cJ\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0008\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000cH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000cH\u0086\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cJ\u0008\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0008\u0010 \u001a\u00020\u0003H\u0007J\u0019\u0010!\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0082\u0008R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Landroidx/collection/MutableFloatSet;", "Landroidx/collection/FloatSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "", "addAll", "elements", "", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableFloatSet extends androidx.collection.FloatSet {

    private int growthLimit;
    public MutableFloatSet() {
        super(0, 1, 0);
    }

    public MutableFloatSet(int initialCapacity) {
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

    public MutableFloatSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(float element) {
        Object obj;
        int m2;
        int m;
        int index;
        int i5;
        int metadata$iv;
        int probeIndex;
        int $this$maskEmpty$iv;
        int i8;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i6;
        int i10;
        int cmp;
        int i9;
        int i;
        long l;
        int i13;
        int i4;
        int i11;
        int i12;
        int i2;
        int i3;
        int i7;
        int numberOfTrailingZeros;
        int hash;
        int i19 = 0;
        i20 *= i23;
        int $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int $i$f$h1 = $i$f$hash >>> 7;
        int i25 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        i5 = $i$f$h1 & m2;
        probeIndex = 0;
        while (/* condition */) {
            int i46 = 0;
            int i50 = 0;
            i3 = 0;
            i7 = 1;
            while (Long.compare(i33, i50) != 0) {
                $this$hasNext$iv = i7;
                i10 = 0;
                i4 = 0;
                $this$get$iv &= i11;
                if (Float.compare(f, element) == 0) {
                }
                int i44 = m;
                i9 = 0;
                m = $this$next$iv;
                i46 = 0;
                i50 = 0;
                i3 = 0;
                i7 = 1;
                $this$hasNext$iv = i3;
                i3 = i7;
            }
            $this$hasNext$iv = i3;
            int i34 = i2;
            i6 = 0;
            hash = $i$f$hash;
            i5 = i18 & i11;
            obj = this;
            m2 = i11;
            long[] metadata2 = obj.metadata;
            $this$next$iv = 0;
            int i45 = i5 >> 3;
            i47 <<= 3;
            l4 >>>= i48;
            i11 = m2;
            i12 = i5;
            i28 |= i;
            i10 = 0;
            long l6 = 72340172838076673L;
            i49 ^= i8;
            l = -9187201950435737472L;
            i30 &= l;
            i10 = 0;
            i4 = 0;
            $this$get$iv &= i11;
            if (Float.compare(f, element) == 0) {
            }
            i44 = m;
            i9 = 0;
            m = $this$next$iv;
            i3 = i7;
            $this$hasNext$iv = i7;
        }
        return i8;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i6;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int i4;
        int i5;
        int i7;
        long l;
        int i;
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
        $this$maskEmptyOrDeleted$iv = i5 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i4 & _capacity;
            metadata = this.metadata;
            i6 = 0;
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
        int i;
        int i2;
        int i3;
        int i5;
        int i4;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr2 = new long[i9 >>= 3];
            i4 = 0;
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
        this.elements = new float[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity;
        int removedDeletes;
        int i3;
        int $i$f$readRawMetadata;
        int i6;
        Object cmp;
        int _capacity2;
        int i10;
        int i11;
        int i7;
        long[] metadata;
        int i4;
        int i5;
        int i9;
        int i2;
        int i;
        long[] m;
        int i8;
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
            i8 = _capacity;
            i3++;
            metadata2 = m;
            _capacity = i8;
            i11 = 128;
            cmp = this;
            i7 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i3 >> 3;
            i28 <<= 3;
            i = _capacity2;
            metadata[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i4 = 0;
            i5 = i10 >> 3;
            i30 <<= 3;
            m = metadata2;
            i8 = _capacity;
            metadata[i5] = i14 |= i2;
            removedDeletes++;
        }
        long[] m4 = metadata2;
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
        Object obj;
        long[] metadata;
        int i6;
        int i7;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj2;
        int _capacity;
        int i9;
        int i4;
        int i3;
        long[] metadata2;
        int i5;
        int i;
        int i2;
        int i8;
        int i10;
        long[] previousMetadata;
        obj = this;
        metadata = obj.metadata;
        initializeStorage(newCapacity);
        i6 = 0;
        while (i6 < obj._capacity) {
            i7 = 0;
            int i14 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i4) < 0) {
            } else {
            }
            $i$f$hash = 0;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata;
            i6++;
            obj = this;
            metadata = previousMetadata;
            i7 = obj.elements[i6];
            int i15 = 0;
            i17 *= i20;
            $i$f$hash = i18 ^ i21;
            int i19 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i22 = 0;
            i4 = (long)$i$f$h2;
            obj2 = this;
            i3 = 0;
            metadata2 = obj2.metadata;
            int i31 = 0;
            int i33 = firstAvailableSlot >> 3;
            i34 <<= 3;
            i10 = _capacity;
            metadata2[i33] = i27 |= i37;
            _capacity = obj2._capacity;
            i30 += i32;
            i5 = 0;
            i = i9 >> 3;
            i36 <<= 3;
            previousMetadata = metadata;
            metadata2[i] = i13 |= i8;
            obj.elements[firstAvailableSlot] = i7;
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

    @Override // androidx.collection.FloatSet
    public final boolean add(float element) {
        int i;
        this.elements[findAbsoluteInsertIndex(element)] = element;
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.FloatSet
    public final boolean addAll(androidx.collection.FloatSet elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.FloatSet
    public final boolean addAll(float[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.FloatSet
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i3;
        long l;
        long l2;
        int i5;
        int i4;
        int i;
        int i6;
        int i2;
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj4, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i5 = emptyGroup >> 3;
            i10 <<= 3;
            metadata[i5] = i12 |= i2;
        }
        initializeGrowth();
    }

    @Override // androidx.collection.FloatSet
    public final void minusAssign(float element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i2;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i4;
        int i7;
        int i8;
        int i5;
        long l;
        int i11;
        int i3;
        int i13;
        int i9;
        int i6;
        int i10;
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
                i4 = 0;
                i3 = 0;
                if (Float.compare(f, element) == 0) {
                }
                int i29 = m$iv;
                i8 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i12 = 1;
                $this$hasNext$iv$iv = i10;
                i10 = i12;
            }
            $this$hasNext$iv$iv = i10;
            int i27 = i6;
            i4 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i10) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i & _capacity;
            m$iv2 = i13;
            $i$f$hash = i9;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i5;
            i4 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i2;
            l = -9187201950435737472L;
            i18 &= l;
            i4 = 0;
            i3 = 0;
            if (Float.compare(f, element) == 0) {
            }
            i29 = m$iv;
            i8 = 0;
            m$iv = $this$next$iv$iv;
            i10 = i12;
            $this$hasNext$iv$iv = i12;
        }
        if (i2 >= 0) {
            obj.removeElementAt(i2);
        }
    }

    @Override // androidx.collection.FloatSet
    public final void minusAssign(androidx.collection.FloatSet elements) {
        Object this_$iv3;
        Object obj;
        Object this_$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i6;
        int j$iv$iv;
        int i3;
        int i2;
        long l;
        int i;
        int i4;
        int i5;
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
            this_$iv3 = this;
        }
    }

    @Override // androidx.collection.FloatSet
    public final void minusAssign(float[] elements) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i5 = 0;
        i = 0;
        while (i < obj.length) {
            i4 = 0;
            minusAssign(obj[i]);
            i++;
        }
    }

    @Override // androidx.collection.FloatSet
    public final void plusAssign(float element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    @Override // androidx.collection.FloatSet
    public final void plusAssign(androidx.collection.FloatSet elements) {
        Object this_$iv;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int j$iv$iv;
        int i2;
        int i6;
        long l;
        int i3;
        int i5;
        int i;
        Object this_$iv2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        obj = elements;
        final int i7 = 0;
        final int i8 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            this_$iv2 = obj;
            this_$iv = this;
        }
    }

    @Override // androidx.collection.FloatSet
    public final void plusAssign(float[] elements) {
        int i4;
        int i;
        int i3;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i5 = 0;
        i4 = 0;
        while (i4 < obj.length) {
            i2 = 0;
            plusAssign(obj[i4]);
            i4++;
        }
    }

    @Override // androidx.collection.FloatSet
    public final boolean remove(float element) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i13;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i8;
        int i9;
        int i2;
        int i3;
        long l;
        int i5;
        int i7;
        int i4;
        int i10;
        int i11;
        int i12;
        int i6;
        int numberOfTrailingZeros;
        final Object obj = this;
        final Object obj2 = obj;
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
            i12 = 0;
            i6 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i6;
                i8 = 0;
                i7 = 0;
                if (Float.compare(f, element) == 0) {
                } else {
                }
                $this$next$iv$iv = i12;
                int i29 = m$iv2;
                i2 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i12 = 0;
                i6 = 1;
                $this$hasNext$iv$iv = i12;
                $this$next$iv$iv = i6;
            }
            $this$hasNext$iv$iv = i12;
            int i28 = i11;
            i8 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i & _capacity;
            m$iv = i4;
            $i$f$hash = i10;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i3;
            i8 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i13;
            l = -9187201950435737472L;
            i18 &= l;
            i8 = 0;
            i7 = 0;
            if (Float.compare(f, element) == 0) {
            } else {
            }
            $this$next$iv$iv = i12;
            i29 = m$iv2;
            i2 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$next$iv$iv = i6;
            $this$hasNext$iv$iv = i6;
        }
        if (i13 >= 0) {
            i12 = i6;
        }
        if (i12 != 0) {
            obj.removeElementAt(i13);
        }
        return i12;
    }

    @Override // androidx.collection.FloatSet
    public final boolean removeAll(androidx.collection.FloatSet elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.FloatSet
    public final boolean removeAll(float[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.FloatSet
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
