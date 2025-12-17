package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.Sequence;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u00011B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010\u000b\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010\u000b\u001a\u00020\u00082\u000e\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u000b\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010J\u0014\u0010\u000b\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0008\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0017\u0010\u001f\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010\u001f\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u001e\u0010\u001f\u001a\u00020\u00132\u000e\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0002\u0010!J\u0017\u0010\u001f\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\u0002J\u0017\u0010\u001f\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0016\u0010\"\u001a\u00020\u00132\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0017\u0010\"\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010\"\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u001e\u0010\"\u001a\u00020\u00132\u000e\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\u0002J\u0017\u0010\"\u001a\u00020\u00132\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0013\u0010#\u001a\u00020\u00082\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010$\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010$\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010$\u001a\u00020\u00082\u000e\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010$\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010J\u0014\u0010$\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011J\u0008\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0004H\u0001J \u0010(\u001a\u00020\u00132\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00080*H\u0086\u0008ø\u0001\u0000J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0008\u0010-\u001a\u00020\u0004H\u0007J\u0019\u0010.\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0082\u0008R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00062", d2 = {"Landroidx/collection/MutableScatterSet;", "E", "Landroidx/collection/ScatterSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "Landroidx/collection/ObjectList;", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "adjustStorage", "", "asMutableSet", "", "clear", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "removeIf", "predicate", "Lkotlin/Function1;", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "", "MutableSetWrapper", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableScatterSet<E>  extends androidx.collection.ScatterSet<E> {

    private int growthLimit;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u000c0\u0001R\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0008\u0012\u0004\u0012\u00028\u00000\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0008J\u0016\u0010\t\u001a\u00020\u00062\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0008J\u0016\u0010\u0011\u001a\u00020\u00062\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¨\u0006\u0013", d2 = {"Landroidx/collection/MutableScatterSet$MutableSetWrapper;", "Landroidx/collection/ScatterSet$SetWrapper;", "Landroidx/collection/ScatterSet;", "", "(Landroidx/collection/MutableScatterSet;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class MutableSetWrapper extends androidx.collection.ScatterSet.SetWrapper<E> implements Set<E>, KMutableSet {

        final androidx.collection.MutableScatterSet<E> this$0;
        public MutableSetWrapper(androidx.collection.MutableScatterSet this$0) {
            this.this$0 = this$0;
            super((ScatterSet)this$0);
        }

        public boolean add(E element) {
            return this.this$0.add(element);
        }

        public boolean addAll(Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.this$0.addAll((Iterable)elements);
        }

        @Override // androidx.collection.ScatterSet$SetWrapper
        public void clear() {
            this.this$0.clear();
        }

        public Iterator<E> iterator() {
            MutableScatterSet.MutableSetWrapper.iterator.1 anon = new MutableScatterSet.MutableSetWrapper.iterator.1(this.this$0);
            return (Iterator)anon;
        }

        @Override // androidx.collection.ScatterSet$SetWrapper
        public boolean remove(Object element) {
            return this.this$0.remove(element);
        }

        public boolean removeAll(Collection<? extends Object> elements) {
            int i;
            Object next;
            androidx.collection.MutableScatterSet this$0;
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator iterator = elements.iterator();
            for (Object next : iterator) {
                this.this$0.minusAssign(next);
            }
            i = this.this$0.getSize() != this.this$0.getSize() ? 1 : 0;
            return i;
        }

        public boolean retainAll(Collection<? extends Object> elements) {
            int changed;
            int i$iv;
            long slot$iv;
            int $this$maskEmptyOrDeleted$iv$iv;
            int i5;
            int j$iv;
            int i;
            int i2;
            long l;
            int i4;
            int i3;
            boolean contains;
            final Object obj = this;
            final Object obj2 = elements;
            Intrinsics.checkNotNullParameter(obj2, "elements");
            changed = 0;
            final androidx.collection.MutableScatterSet this$02 = obj.this$0;
            final int i6 = 0;
            final long[] metadata = this$0.metadata;
            length += -2;
            if (0 <= i7) {
            } else {
            }
            return changed;
        }
    }
    public MutableScatterSet() {
        super(0, 1, 0);
    }

    public MutableScatterSet(int initialCapacity) {
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

    public MutableScatterSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
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

    private final int findAbsoluteInsertIndex(E element) {
        Object obj2;
        Object obj;
        int $i$f$hash;
        int m;
        int index;
        int i4;
        int metadata$iv;
        int i14;
        int $i$f$h1;
        int $i$f$hasNext;
        int probeOffset;
        int probeIndex;
        int $this$maskEmpty$iv;
        int $this$next$iv;
        int i2;
        int i3;
        int i7;
        int cmp;
        int i10;
        int i6;
        long l;
        int i8;
        int i11;
        int i12;
        int i9;
        int i13;
        int i;
        int numberOfTrailingZeros;
        int i5;
        obj = element;
        int i20 = 0;
        if (obj != null) {
            i14 = obj.hashCode();
        } else {
            i14 = 0;
        }
        i14 *= i33;
        $i$f$hash = i27 ^ i34;
        int i28 = 0;
        int i35 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        final int _capacity = obj2._capacity;
        probeOffset = $i$f$h1 & _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i29 = 0;
            int i49 = 0;
            numberOfTrailingZeros = 1;
            while (Long.compare(i36, i49) != 0) {
                $i$f$hasNext = numberOfTrailingZeros;
                int i30 = 0;
                i6 = 0;
                $i$f$h1 = i51 & _capacity;
                int i38 = m;
                i7 = 0;
                m = $this$next$iv;
                i29 = 0;
                i49 = 0;
                numberOfTrailingZeros = 1;
                $i$f$hasNext = 0;
            }
            $i$f$hasNext = 0;
            int i39 = i;
            int i31 = 0;
            $i$f$h1 = i13;
            probeOffset = i15 & _capacity;
            obj2 = this;
            obj = element;
            $i$f$hash = i11;
            long[] metadata2 = obj2.metadata;
            i2 = 0;
            int i48 = probeOffset >> 3;
            i54 <<= 3;
            i13 = $i$f$h1;
            i24 |= i6;
            i7 = 0;
            long l7 = 72340172838076673L;
            i56 ^= $this$next$iv;
            l = -9187201950435737472L;
            i21 &= l;
            i30 = 0;
            i6 = 0;
            $i$f$h1 = i51 & _capacity;
            i38 = m;
            i7 = 0;
            m = $this$next$iv;
            $i$f$hasNext = numberOfTrailingZeros;
        }
        return $i$f$h1;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int probeOffset;
        int probeIndex;
        int metadata$iv;
        int i4;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int i2;
        int i7;
        int i;
        long l;
        int i5;
        int i6;
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
        $this$maskEmptyOrDeleted$iv = i7 & l;
        while (Long.compare($this$maskEmptyOrDeleted$iv, i13) != 0) {
            probeOffset = i2 & _capacity;
            metadata = this.metadata;
            i4 = 0;
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

    private final void initializeGrowth() {
        this.growthLimit = loadedCapacity -= _size;
    }

    private final void initializeMetadata(int capacity) {
        long[] size;
        long[] lArr2;
        long[] lArr;
        long l;
        int i5;
        int i;
        int i4;
        int i2;
        int i3;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr2 = new long[i9 >>= 3];
            i3 = 0;
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
        this.elements = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata2;
        int _capacity2;
        int removedDeletes;
        int i10;
        int $i$f$readRawMetadata;
        int i2;
        Object cmp;
        int _capacity;
        int i11;
        int i7;
        int i8;
        long[] metadata;
        int i9;
        int i6;
        int i4;
        int i3;
        int i;
        long[] m;
        int i5;
        final Object obj = this;
        metadata2 = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i10 = 0;
        while (i10 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i7) == 0) {
            } else {
            }
            m = metadata2;
            i5 = _capacity2;
            i10++;
            metadata2 = m;
            _capacity2 = i5;
            i7 = 128;
            cmp = this;
            i8 = 0;
            metadata = cmp.metadata;
            int i25 = 0;
            int i27 = i10 >> 3;
            i28 <<= 3;
            i = _capacity;
            metadata[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i9 = 0;
            i6 = i11 >> 3;
            i30 <<= 3;
            m = metadata2;
            i5 = _capacity2;
            metadata[i6] = i14 |= i3;
            removedDeletes++;
        }
        long[] m4 = metadata2;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj2;
        long[] metadata2;
        int i7;
        Object obj;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj3;
        int _capacity;
        int i6;
        long l;
        int i4;
        long[] metadata;
        int i;
        int i5;
        int i2;
        int i3;
        int i8;
        long[] previousMetadata;
        obj2 = this;
        metadata2 = obj2.metadata;
        initializeStorage(newCapacity);
        i7 = 0;
        while (i7 < obj2._capacity) {
            obj = 0;
            int i12 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, l) < 0) {
            } else {
            }
            $i$f$hash = firstAvailableSlot;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata2;
            i7++;
            obj2 = this;
            metadata2 = previousMetadata;
            obj = obj2.elements[i7];
            int i13 = 0;
            if (obj != null) {
            }
            firstAvailableSlot *= i18;
            $i$f$hash = i16 ^ i19;
            int i17 = 0;
            firstAvailableSlot = obj2.findFirstAvailableSlot($i$f$hash >>> 7);
            int i20 = 0;
            l = (long)$i$f$h2;
            obj3 = this;
            i4 = 0;
            metadata = obj3.metadata;
            int i29 = 0;
            int i31 = firstAvailableSlot >> 3;
            i32 <<= 3;
            i8 = _capacity;
            metadata[i31] = i25 |= i35;
            _capacity = obj3._capacity;
            i28 += i30;
            i = 0;
            i5 = i6 >> 3;
            i34 <<= 3;
            previousMetadata = metadata2;
            metadata[i5] = i11 |= i3;
            obj2.elements[firstAvailableSlot] = obj;
            firstAvailableSlot = obj.hashCode();
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

    public final boolean add(E element) {
        int i;
        this.elements[findAbsoluteInsertIndex(element)] = element;
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean addAll(androidx.collection.ObjectList<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean addAll(androidx.collection.ScatterSet<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean addAll(Sequence<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean addAll(E[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final Set<E> asMutableSet() {
        MutableScatterSet.MutableSetWrapper mutableSetWrapper = new MutableScatterSet.MutableSetWrapper(this);
        return (Set)mutableSetWrapper;
    }

    @Override // androidx.collection.ScatterSet
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i5;
        long l2;
        long l;
        int i4;
        int i;
        int i3;
        int i6;
        int i2;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l = 0;
            i4 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i4] = i13 |= i2;
        }
        ArraysKt.fill(this.elements, 0, i7, this._capacity);
        initializeGrowth();
    }

    public final void minusAssign(androidx.collection.ObjectList<E> elements) {
        int i$iv;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj2 = elements;
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            minusAssign(obj2.content[i$iv]);
            i$iv++;
        }
    }

    public final void minusAssign(androidx.collection.ScatterSet<E> elements) {
        Object this_$iv2;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        int j$iv$iv;
        int i4;
        int i3;
        long l;
        int i2;
        int i5;
        int i6;
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

    public final void minusAssign(Iterable<? extends E> elements) {
        Object next;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i = 0;
            minusAssign(next);
        }
    }

    public final void minusAssign(E element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int i10;
        int i7;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i11;
        int i12;
        int $this$next$iv$iv;
        int i13;
        int i6;
        int i14;
        int i;
        long l;
        int i9;
        int i5;
        int i2;
        int i3;
        int i8;
        int numberOfTrailingZeros;
        int i4;
        final Object obj = this;
        final Object obj2 = element;
        final Object obj3 = obj;
        m$iv2 = 0;
        int i16 = 0;
        if (obj2 != null) {
            i7 = obj2.hashCode();
        } else {
            i7 = 0;
        }
        i7 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj3._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            while (Long.compare(i25, i35) != 0) {
                i8 = 1;
                i13 = 0;
                i3 = 0;
                int i28 = m$iv;
                i = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i8 = 0;
            }
            i8 = 0;
            int i27 = i10;
            i13 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i3) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i11 & _capacity;
            $i$f$h2 = i6;
            m$iv2 = i5;
            $i$f$hash = i2;
            long[] metadata = obj3.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i13 = 0;
            i6 = i42;
            long l6 = 72340172838076673L;
            i34 ^= i12;
            l = -9187201950435737472L;
            i15 &= l;
            i13 = 0;
            i3 = 0;
            i28 = m$iv;
            i = 0;
            m$iv = $this$next$iv$iv;
            i8 = 1;
        }
        if (i12 >= 0) {
            obj.removeElementAt(i12);
        }
    }

    public final void minusAssign(Sequence<? extends E> elements) {
        Object next;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i = 0;
            minusAssign(next);
        }
    }

    public final void minusAssign(E[] elements) {
        int i2;
        Object obj;
        Object obj2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj3 = elements;
        final int i3 = 0;
        i2 = 0;
        while (i2 < obj3.length) {
            i = 0;
            minusAssign(obj3[i2]);
            i2++;
        }
    }

    public final void plusAssign(androidx.collection.ObjectList<E> elements) {
        int i$iv;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj2 = elements;
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            plusAssign(obj2.content[i$iv]);
            i$iv++;
        }
    }

    public final void plusAssign(androidx.collection.ScatterSet<E> elements) {
        Object this_$iv2;
        Object obj;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        int j$iv$iv;
        int i3;
        int i5;
        long l;
        int i;
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

    public final void plusAssign(Iterable<? extends E> elements) {
        Object next;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i = 0;
            plusAssign(next);
        }
    }

    public final void plusAssign(E element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    public final void plusAssign(Sequence<? extends E> elements) {
        Object next;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i = 0;
            plusAssign(next);
        }
    }

    public final void plusAssign(E[] elements) {
        int i;
        Object obj;
        Object obj2;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj3 = elements;
        final int i3 = 0;
        i = 0;
        while (i < obj3.length) {
            i2 = 0;
            plusAssign(obj3[i]);
            i++;
        }
    }

    public final boolean remove(E element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int i7;
        int i8;
        int i4;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i9;
        int i14;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i12;
        int i;
        int i2;
        int i10;
        long l;
        int i3;
        int i5;
        int i13;
        int i6;
        int i11;
        int numberOfTrailingZeros;
        final Object obj = this;
        final Object obj2 = element;
        final Object obj3 = obj;
        m$iv2 = 0;
        int i16 = 0;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        } else {
            i4 = 0;
        }
        i4 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj3._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            i11 = 1;
            while (Long.compare(i25, i35) != 0) {
                $this$hasNext$iv$iv = i11;
                i12 = 0;
                i6 = 0;
                int i28 = m$iv;
                i10 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i11 = 1;
                $this$hasNext$iv$iv = 0;
            }
            $this$hasNext$iv$iv = 0;
            int i27 = i7;
            i12 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i9 & _capacity;
            $i$f$h2 = i;
            m$iv2 = i5;
            $i$f$hash = i13;
            long[] metadata = obj3.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i12 = 0;
            i = i42;
            long l6 = 72340172838076673L;
            i34 ^= i14;
            l = -9187201950435737472L;
            i15 &= l;
            i12 = 0;
            i6 = 0;
            i28 = m$iv;
            i10 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i11;
        }
        i8 = i14 >= 0 ? i11 : 0;
        if (i8 != 0) {
            obj.removeElementAt(i14);
        }
        return i8;
    }

    public final boolean removeAll(androidx.collection.ObjectList<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean removeAll(androidx.collection.ScatterSet<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean removeAll(Sequence<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    public final boolean removeAll(E[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = getSize() != getSize() ? 1 : 0;
        return i;
    }

    @Override // androidx.collection.ScatterSet
    public final void removeElementAt(int index) {
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
        this.elements[index] = 0;
    }

    public final void removeIf(Function1<? super E, Boolean> predicate) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int booleanValue;
        int j$iv;
        int i3;
        int i2;
        long l;
        int i4;
        int i;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        int i5 = 0;
        final int i6 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i7) {
        } else {
        }
    }

    @Override // androidx.collection.ScatterSet
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
