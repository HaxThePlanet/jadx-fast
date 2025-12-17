package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002J\u0006\u0010\t\u001a\u00020\u0008J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0015\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00028\u00002\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0008\u0010\u0014\u001a\u00020\u0008H\u0002J\u0010\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u0018\u001a\u00020\u00082\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\u00082\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\nJ\u001e\u0010\u0018\u001a\u00020\u00082\u000e\u0010\u001a\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u001cH\u0086\n¢\u0006\u0002\u0010\u001dJ\u0017\u0010\u0018\u001a\u00020\u00082\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\nJ\u0017\u0010\u0018\u001a\u00020\u00082\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0086\nJ\u0017\u0010 \u001a\u00020\u00082\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001b\u0010\"\u001a\u00020\u00082\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0010¢\u0006\u0002\u0010$J#\u0010\"\u001a\u00020\u00102\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020\u00082\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0013\u0010(\u001a\u00020\u00082\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u001b\u0010(\u001a\u00020)2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0010¢\u0006\u0002\u0010*J\u0008\u0010+\u001a\u00020\u0008H\u0002J&\u0010,\u001a\u00020\u00082\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J\u0010\u0010/\u001a\u00020\u00082\u0006\u00100\u001a\u00020\u0004H\u0001J\u0010\u00101\u001a\u00020\u00082\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u00020\u00082\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0002\u0010$J\u0006\u00104\u001a\u00020\u0004J\u0019\u00105\u001a\u00020\u00082\u0006\u00100\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0010H\u0082\u0008R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00066", d2 = {"Landroidx/collection/MutableObjectLongMap;", "K", "Landroidx/collection/ObjectLongMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findIndex", "key", "(Ljava/lang/Object;)I", "getOrPut", "", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)J", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", "from", "put", "value", "(Ljava/lang/Object;J)V", "default", "(Ljava/lang/Object;JJ)J", "putAll", "remove", "", "(Ljava/lang/Object;J)Z", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableObjectLongMap<K>  extends androidx.collection.ObjectLongMap<K> {

    private int growthLimit;
    public MutableObjectLongMap() {
        super(0, 1, 0);
    }

    public MutableObjectLongMap(int initialCapacity) {
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

    public MutableObjectLongMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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
        int i2;
        int i7;
        int i3;
        long l;
        int i5;
        int i4;
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
            probeOffset = i2 & _capacity;
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

    private final int findIndex(K key) {
        Object obj2;
        Object obj;
        int $i$f$hash;
        int m;
        int index;
        int i2;
        int metadata$iv;
        int i9;
        int $i$f$h1;
        int $i$f$hasNext;
        int probeOffset;
        int probeIndex;
        int $this$maskEmpty$iv;
        int $this$next$iv;
        int i11;
        int i4;
        int i10;
        int cmp;
        int i14;
        int i6;
        long l;
        int i12;
        int i3;
        int i8;
        int i;
        int i7;
        int i5;
        int numberOfTrailingZeros;
        int i13;
        obj = key;
        int i21 = 0;
        if (obj != null) {
            i9 = obj.hashCode();
        } else {
            i9 = 0;
        }
        i9 *= i34;
        $i$f$hash = i28 ^ i35;
        int i29 = 0;
        int i36 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        final int _capacity = obj2._capacity;
        probeOffset = $i$f$h1 & _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i30 = 0;
            int i50 = 0;
            numberOfTrailingZeros = 1;
            while (Long.compare(i37, i50) != 0) {
                $i$f$hasNext = numberOfTrailingZeros;
                int i31 = 0;
                i6 = 0;
                $i$f$h1 = i52 & _capacity;
                int i39 = m;
                i10 = 0;
                m = $this$next$iv;
                i30 = 0;
                i50 = 0;
                numberOfTrailingZeros = 1;
                $i$f$hasNext = 0;
            }
            $i$f$hasNext = 0;
            int i40 = i5;
            int i32 = 0;
            $i$f$h1 = i7;
            probeOffset = i15 & _capacity;
            obj2 = this;
            obj = key;
            $i$f$hash = i3;
            long[] metadata2 = obj2.metadata;
            i11 = 0;
            int i49 = probeOffset >> 3;
            i55 <<= 3;
            i7 = $i$f$h1;
            i25 |= i6;
            i10 = 0;
            long l7 = 72340172838076673L;
            i57 ^= $this$next$iv;
            l = -9187201950435737472L;
            i22 &= l;
            i31 = 0;
            i6 = 0;
            $i$f$h1 = i52 & _capacity;
            i39 = m;
            i10 = 0;
            m = $this$next$iv;
            $i$f$hasNext = numberOfTrailingZeros;
        }
        return $i$f$h1;
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
        this.keys = new Object[i];
        this.values = new long[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity;
        int removedDeletes;
        int i8;
        int $i$f$readRawMetadata;
        int i10;
        Object cmp;
        int _capacity2;
        int i11;
        int i4;
        int i6;
        long[] metadata;
        int i2;
        int i3;
        int i7;
        int i5;
        int i;
        long[] m;
        int i9;
        final Object obj = this;
        metadata2 = obj.metadata;
        _capacity = obj._capacity;
        removedDeletes = 0;
        i8 = 0;
        while (i8 < _capacity) {
            int i15 = 0;
            _capacity2 = 255;
            if (Long.compare($i$f$readRawMetadata, i4) == 0) {
            } else {
            }
            m = metadata2;
            i9 = _capacity;
            i8++;
            metadata2 = m;
            _capacity = i9;
            i4 = 128;
            cmp = this;
            i6 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i8 >> 3;
            i28 <<= 3;
            i = _capacity2;
            metadata[i27] = i21 |= i31;
            _capacity2 = cmp._capacity;
            i24 += i26;
            i2 = 0;
            i3 = i11 >> 3;
            i30 <<= 3;
            m = metadata2;
            i9 = _capacity;
            metadata[i3] = i14 |= i5;
            removedDeletes++;
        }
        long[] m4 = metadata2;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata;
        int i;
        Object obj2;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj3;
        long[] metadata2;
        int i7;
        long l;
        int i3;
        int i4;
        int i2;
        int i6;
        long l2;
        long[] previousMetadata;
        int i5;
        int i8;
        obj = this;
        metadata = obj.metadata;
        initializeStorage(newCapacity);
        i = 0;
        while (i < obj._capacity) {
            obj2 = 0;
            int i18 = 0;
            metadata2 = 255;
            if (Long.compare($i$f$readRawMetadata, l) < 0) {
            } else {
            }
            $i$f$hash = firstAvailableSlot;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata;
            i++;
            obj = this;
            metadata = previousMetadata;
            obj2 = obj.keys[i];
            int i19 = 0;
            if (obj2 != null) {
            }
            firstAvailableSlot *= i24;
            $i$f$hash = i22 ^ i25;
            int i23 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i26 = 0;
            l = (long)$i$f$h2;
            obj3 = this;
            i3 = 0;
            int i31 = metadata2;
            metadata2 = obj3.metadata;
            int i29 = 0;
            int i32 = firstAvailableSlot >> 3;
            i33 <<= 3;
            previousMetadata = metadata;
            metadata2[i32] = i11 |= i36;
            int _capacity = obj3._capacity;
            i17 += i30;
            i7 = 0;
            i2 = metadata >> 3;
            i35 <<= 3;
            i5 = _capacity;
            i8 = metadata;
            metadata2[i2] = i14 |= i4;
            obj.keys[firstAvailableSlot] = obj2;
            obj.values[firstAvailableSlot] = obj.values[i];
            firstAvailableSlot = obj2.hashCode();
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

    @Override // androidx.collection.ObjectLongMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i4;
        long l;
        long l2;
        int i6;
        int i;
        int i3;
        int i5;
        int i2;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i6 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i6] = i13 |= i2;
        }
        ArraysKt.fill(this.keys, 0, i7, this._capacity);
        initializeGrowth();
    }

    public final long getOrPut(K key, Function0<Long> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            return this.values[keyIndex];
        }
        long longValue = (Number)defaultValue.invoke().longValue();
        set(key, longValue);
        return longValue;
    }

    public final void minusAssign(androidx.collection.ScatterSet<K> keys) {
        int cmp;
        int obj2;
        Object this_$iv3;
        Object obj;
        Object this_$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i4;
        int $i$f$minusAssign;
        long l;
        int i;
        int i2;
        int i5;
        Object this_$iv2;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj = keys;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv2 = obj;
            this_$iv3 = this;
        }
    }

    public final void minusAssign(Iterable<? extends K> keys) {
        Object next;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i = 0;
        final Iterator iterator = keys.iterator();
        for (Object next : iterator) {
            remove(next);
        }
    }

    public final void minusAssign(K key) {
        final int i = 0;
        remove(key);
    }

    public final void minusAssign(Sequence<? extends K> keys) {
        Object next;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i = 0;
        final Iterator iterator = keys.iterator();
        for (Object next : iterator) {
            remove(next);
        }
    }

    public final void minusAssign(K[] keys) {
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i2 = 0;
        i = 0;
        while (i < keys.length) {
            remove(keys[i]);
            i++;
        }
    }

    public final void plusAssign(androidx.collection.ObjectLongMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    public final long put(K key, long value, long default) {
        int index;
        long previous;
        long[] values;
        index = findIndex(key);
        previous = obj8;
        if (index < 0) {
            index = ~index;
        } else {
            previous = this.values[index];
        }
        this.keys[index] = key;
        this.values[index] = value;
        return previous;
    }

    public final void put(K key, long value) {
        set(key, value);
    }

    public final void putAll(androidx.collection.ObjectLongMap<K> from) {
        int cmp;
        int obj;
        int $i$f$forEach;
        Object[] keys;
        Object v$iv;
        long[] values;
        Object v$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i4;
        Object this_$iv;
        long l;
        int i3;
        int i;
        int $i$f$forEach2;
        Object[] objArr;
        int i2;
        long[] lArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = cmp;
            $i$f$forEach2 = $i$f$forEach;
            objArr = keys;
            lArr = values;
            v$iv = this;
        }
    }

    public final void remove(K key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            removeValueAt(keyIndex);
        }
    }

    public final boolean remove(K key, long value) {
        int cmp;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0 && Long.compare(l, value) == 0) {
            if (Long.compare(l, value) == 0) {
                removeValueAt(keyIndex);
                return 1;
            }
        }
        return 0;
    }

    public final void removeIf(Function2<? super K, ? super Long, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int i2;
        int j$iv;
        int i4;
        int i3;
        long l;
        int i;
        int i5;
        int $i$f$removeIf;
        long l2;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        final int i6 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i7) {
        } else {
            $i$f$removeIf = $i$f$removeIf2;
        }
    }

    @Override // androidx.collection.ObjectLongMap
    public final void removeValueAt(int index) {
        this._size = _size--;
        int i2 = 254;
        final Object obj = this;
        final int i4 = 0;
        final long[] metadata = obj.metadata;
        int i5 = 0;
        int i6 = index >> 3;
        i10 <<= 3;
        int i19 = 255;
        metadata[i6] = i14 |= i26;
        int $i$f$writeRawMetadata = obj._capacity;
        i8 += i12;
        int i13 = 0;
        int i16 = i9 >> 3;
        i17 <<= 3;
        metadata[i16] = i22 |= i27;
        this.keys[index] = 0;
    }

    public final void set(K key, long value) {
        int index;
        index = findIndex(key);
        if (index < 0) {
            index = ~index;
        }
        this.keys[index] = key;
        this.values[index] = value;
    }

    @Override // androidx.collection.ObjectLongMap
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
