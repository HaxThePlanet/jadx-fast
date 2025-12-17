package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.sequences.Sequence;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\t\n\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001EB\u000f\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0008\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bJ\u0006\u0010\u000c\u001a\u00020\tJS\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u000028\u0010\u000f\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u000e\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0018J'\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u00002\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001bH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0008\u0010\u001d\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010!\u001a\u00020\t2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000$H\u0086\nJ\u0017\u0010!\u001a\u00020\t2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0086\nJ\u001e\u0010!\u001a\u00020\t2\u000e\u0010#\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000&H\u0086\n¢\u0006\u0002\u0010'J\u0017\u0010!\u001a\u00020\t2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000(H\u0086\nJ\u0017\u0010!\u001a\u00020\t2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000)H\u0086\nJ\u001d\u0010*\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\nJ*\u0010*\u001a\u00020\t2\u001a\u0010,\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0&H\u0086\n¢\u0006\u0002\u0010.J\u001d\u0010*\u001a\u00020\t2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-H\u0086\nJ#\u0010*\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0(H\u0086\nJ\u001d\u0010*\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0086\nJ#\u0010*\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0)H\u0086\nJ\u001d\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00102J\u001a\u00103\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J'\u00103\u001a\u00020\t2\u001a\u0010,\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0&¢\u0006\u0002\u0010.J \u00103\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0(J\u001a\u00103\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100J \u00103\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0)J\u0015\u00104\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u00105J\u001b\u00104\u001a\u0002062\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00107J\u0008\u00108\u001a\u00020\tH\u0002J&\u00109\u001a\u00020\t2\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002060\u0010H\u0086\u0008ø\u0001\u0000J\u0017\u0010;\u001a\u0004\u0018\u00018\u00012\u0006\u0010<\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001e\u0010@\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010AJ\u0006\u0010B\u001a\u00020\u0005J\u0019\u0010C\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020DH\u0082\u0008R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006F", d2 = {"Landroidx/collection/MutableScatterMap;", "K", "V", "Landroidx/collection/ScatterMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "asMutableMap", "", "clear", "compute", "key", "computeBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "findFirstAvailableSlot", "hash1", "findInsertIndex", "(Ljava/lang/Object;)I", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", "from", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "pair", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeDeletedMarkers", "removeIf", "predicate", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "trim", "writeMetadata", "", "MutableMapWrapper", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableScatterMap<K, V>  extends androidx.collection.ScatterMap<K, V> {

    private int growthLimit;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0005\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00112\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR&\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tR\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001b", d2 = {"Landroidx/collection/MutableScatterMap$MutableMapWrapper;", "Landroidx/collection/ScatterMap$MapWrapper;", "Landroidx/collection/ScatterMap;", "", "(Landroidx/collection/MutableScatterMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class MutableMapWrapper extends androidx.collection.ScatterMap.MapWrapper<K, V> implements Map<K, V>, KMutableMap {

        final androidx.collection.MutableScatterMap<K, V> this$0;
        public MutableMapWrapper(androidx.collection.MutableScatterMap this$0) {
            this.this$0 = this$0;
            super((ScatterMap)this$0);
        }

        @Override // androidx.collection.ScatterMap$MapWrapper
        public void clear() {
            this.this$0.clear();
        }

        public Set<Map.Entry<K, V>> getEntries() {
            MutableScatterMap.MutableMapWrapper.entries.1 anon = new MutableScatterMap.MutableMapWrapper.entries.1(this.this$0);
            return (Set)anon;
        }

        public Set<K> getKeys() {
            MutableScatterMap.MutableMapWrapper.keys.1 anon = new MutableScatterMap.MutableMapWrapper.keys.1(this.this$0);
            return (Set)anon;
        }

        public Collection<V> getValues() {
            MutableScatterMap.MutableMapWrapper.values.1 anon = new MutableScatterMap.MutableMapWrapper.values.1(this.this$0);
            return (Collection)anon;
        }

        public V put(K key, V value) {
            return this.this$0.put(key, value);
        }

        public void putAll(Map<? extends K, ? extends V> from) {
            Object next;
            int i;
            Object key;
            Object value;
            Map map;
            Intrinsics.checkNotNullParameter(from, "from");
            final int i2 = 0;
            Iterator iterator = from.entrySet().iterator();
            for (Map.Entry next : iterator) {
                i = 0;
                (Map)this.put(next.getKey(), next.getValue());
            }
        }

        public V remove(Object key) {
            return this.this$0.remove(key);
        }
    }
    public MutableScatterMap() {
        super(0, 1, 0);
    }

    public MutableScatterMap(int initialCapacity) {
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

    public MutableScatterMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 6 : obj1;
        super(obj1);
    }

    private final void adjustStorage() {
        int compareUnsigned;
        int nextCapacity;
        long constructor-impl;
        int i;
        final int i3 = 8;
        if (this._capacity > i3 && Long.compareUnsigned(ULong.constructor-impl(constructor-impl2 *= i4), i3) <= 0) {
            if (Long.compareUnsigned(ULong.constructor-impl(constructor-impl2 *= i4), i3) <= 0) {
                resizeStorage(this._capacity);
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
        int i4;
        int $this$maskEmptyOrDeleted$iv;
        int i6;
        int i7;
        int i2;
        int i;
        long l;
        int i3;
        int i5;
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
            probeOffset = i7 & _capacity;
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
        long[] lArr;
        long[] lArr2;
        long l;
        int i4;
        int i2;
        int i;
        int i5;
        int i3;
        if (capacity == 0) {
            size = ScatterMapKt.EmptyGroup;
        } else {
            lArr = new long[i9 >>= 3];
            i3 = 0;
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
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    private final void removeDeletedMarkers() {
        long[] metadata;
        int _capacity2;
        int removedDeletes;
        int i3;
        int $i$f$readRawMetadata;
        int i9;
        Object cmp;
        int _capacity;
        int i7;
        int i11;
        int i10;
        long[] metadata2;
        int i4;
        int i2;
        int i5;
        int i8;
        int i;
        long[] m;
        int i6;
        final Object obj = this;
        metadata = obj.metadata;
        _capacity2 = obj._capacity;
        removedDeletes = 0;
        i3 = 0;
        while (i3 < _capacity2) {
            int i15 = 0;
            _capacity = 255;
            if (Long.compare($i$f$readRawMetadata, i11) == 0) {
            } else {
            }
            m = metadata;
            i6 = _capacity2;
            i3++;
            metadata = m;
            _capacity2 = i6;
            i11 = 128;
            cmp = this;
            i10 = 0;
            metadata2 = cmp.metadata;
            int i25 = 0;
            int i27 = i3 >> 3;
            i28 <<= 3;
            i = _capacity;
            metadata2[i27] = i21 |= i31;
            _capacity = cmp._capacity;
            i24 += i26;
            i4 = 0;
            i2 = i7 >> 3;
            i30 <<= 3;
            m = metadata;
            i6 = _capacity2;
            metadata2[i2] = i14 |= i8;
            removedDeletes++;
        }
        long[] m4 = metadata;
        obj.growthLimit = m2 += removedDeletes;
    }

    private final void resizeStorage(int newCapacity) {
        Object obj;
        long[] metadata;
        int i5;
        Object obj3;
        int $i$f$hash;
        int firstAvailableSlot;
        Object obj2;
        long[] metadata2;
        int i2;
        long l2;
        int i;
        int i3;
        int i8;
        int i7;
        long l;
        long[] previousMetadata;
        int i6;
        int i4;
        obj = this;
        metadata = obj.metadata;
        initializeStorage(newCapacity);
        i5 = 0;
        while (i5 < obj._capacity) {
            obj3 = 0;
            int i18 = 0;
            metadata2 = 255;
            if (Long.compare($i$f$readRawMetadata, l2) < 0) {
            } else {
            }
            $i$f$hash = firstAvailableSlot;
            if ($i$f$hash != 0) {
            } else {
            }
            previousMetadata = metadata;
            i5++;
            obj = this;
            metadata = previousMetadata;
            obj3 = obj.keys[i5];
            int i19 = 0;
            if (obj3 != null) {
            }
            firstAvailableSlot *= i24;
            $i$f$hash = i22 ^ i25;
            int i23 = 0;
            firstAvailableSlot = obj.findFirstAvailableSlot($i$f$hash >>> 7);
            int i26 = 0;
            l2 = (long)$i$f$h2;
            obj2 = this;
            i = 0;
            int i31 = metadata2;
            metadata2 = obj2.metadata;
            int i29 = 0;
            int i32 = firstAvailableSlot >> 3;
            i33 <<= 3;
            previousMetadata = metadata;
            metadata2[i32] = i11 |= i36;
            int _capacity = obj2._capacity;
            i17 += i30;
            i2 = 0;
            i8 = metadata >> 3;
            i35 <<= 3;
            i6 = _capacity;
            i4 = metadata;
            metadata2[i8] = i14 |= i3;
            obj.keys[firstAvailableSlot] = obj3;
            obj.values[firstAvailableSlot] = obj.values[i5];
            firstAvailableSlot = obj3.hashCode();
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

    public final Map<K, V> asMutableMap() {
        MutableScatterMap.MutableMapWrapper mutableMapWrapper = new MutableScatterMap.MutableMapWrapper(this);
        return (Map)mutableMapWrapper;
    }

    @Override // androidx.collection.ScatterMap
    public final void clear() {
        long[] metadata;
        long[] emptyGroup;
        int i5;
        long l;
        long l2;
        int i3;
        int i6;
        int i;
        int i4;
        int i2;
        final int i7 = 0;
        this._size = i7;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, obj5, 0, 0, 6);
            metadata = this.metadata;
            emptyGroup = this._capacity;
            l2 = 0;
            i3 = emptyGroup >> 3;
            i11 <<= 3;
            metadata[i3] = i13 |= i2;
        }
        int i8 = 0;
        ArraysKt.fill(this.values, i8, i7, this._capacity);
        ArraysKt.fill(this.keys, i8, i7, this._capacity);
        initializeGrowth();
    }

    public final V compute(K key, Function2<? super K, ? super V, ? extends V> computeBlock) {
        int i;
        Object obj;
        int values2;
        Object[] values;
        Intrinsics.checkNotNullParameter(computeBlock, "computeBlock");
        int i2 = 0;
        final int insertIndex = findInsertIndex(key);
        i = insertIndex < 0 ? 1 : 0;
        obj = i != 0 ? 0 : values3[insertIndex];
        Object invoke = computeBlock.invoke(key, obj);
        if (i != 0) {
            values2 = ~insertIndex;
            this.keys[values2] = key;
            this.values[values2] = invoke;
        } else {
            this.values[insertIndex] = invoke;
        }
        return invoke;
    }

    public final int findInsertIndex(K key) {
        Object obj;
        Object obj2;
        int $i$f$hash;
        int m;
        int index;
        int i8;
        int metadata$iv;
        int i9;
        int $i$f$h1;
        int $i$f$hasNext;
        int probeOffset;
        int probeIndex;
        int $this$maskEmpty$iv;
        int $this$next$iv;
        int i7;
        int i11;
        int i;
        int cmp;
        int i12;
        int i14;
        long l;
        int i5;
        int i13;
        int i2;
        int i6;
        int i3;
        int i4;
        int numberOfTrailingZeros;
        int i10;
        obj2 = key;
        int i21 = 0;
        if (obj2 != null) {
            i9 = obj2.hashCode();
        } else {
            i9 = 0;
        }
        i9 *= i34;
        $i$f$hash = i28 ^ i35;
        int i29 = 0;
        int i36 = 0;
        int $i$f$h2 = $i$f$hash & 127;
        final int _capacity = obj._capacity;
        probeOffset = $i$f$h1 & _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i30 = 0;
            int i50 = 0;
            numberOfTrailingZeros = 1;
            while (Long.compare(i37, i50) != 0) {
                $i$f$hasNext = numberOfTrailingZeros;
                int i31 = 0;
                i14 = 0;
                $i$f$h1 = i52 & _capacity;
                int i39 = m;
                i = 0;
                m = $this$next$iv;
                i30 = 0;
                i50 = 0;
                numberOfTrailingZeros = 1;
                $i$f$hasNext = 0;
            }
            $i$f$hasNext = 0;
            int i40 = i4;
            int i32 = 0;
            $i$f$h1 = i3;
            probeOffset = i15 & _capacity;
            obj = this;
            obj2 = key;
            $i$f$hash = i13;
            long[] metadata2 = obj.metadata;
            i7 = 0;
            int i49 = probeOffset >> 3;
            i55 <<= 3;
            i3 = $i$f$h1;
            i25 |= i14;
            i = 0;
            long l7 = 72340172838076673L;
            i57 ^= $this$next$iv;
            l = -9187201950435737472L;
            i22 &= l;
            i31 = 0;
            i14 = 0;
            $i$f$h1 = i52 & _capacity;
            i39 = m;
            i = 0;
            m = $this$next$iv;
            $i$f$hasNext = numberOfTrailingZeros;
        }
        return $i$f$h1;
    }

    public final V getOrPut(K key, Function0<? extends V> defaultValue) {
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

    public final void minusAssign(androidx.collection.ObjectList<K> keys) {
        int i$iv;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(keys, "keys");
        int i2 = 0;
        final Object obj2 = keys;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i = 0;
            remove(obj2.content[i$iv]);
            i$iv++;
        }
    }

    public final void minusAssign(androidx.collection.ScatterSet<K> keys) {
        int cmp;
        int obj;
        Object this_$iv2;
        Object obj2;
        Object this_$iv3;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i4;
        int i;
        int $i$f$minusAssign;
        long l;
        int i2;
        int i5;
        int i3;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(keys, "keys");
        obj2 = keys;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$minusAssign = cmp;
            this_$iv = obj2;
            this_$iv2 = this;
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

    public final void plusAssign(androidx.collection.ScatterMap<K, V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        int i = 0;
        putAll(pairs);
    }

    public final void plusAssign(Map<K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = 0;
        putAll(from);
    }

    public final void plusAssign(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        int i = 0;
        set(pair.getFirst(), pair.getSecond());
    }

    public final void plusAssign(Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        int i = 0;
        putAll(pairs);
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        int i = 0;
        putAll(pairs);
    }

    public final V put(K key, V value) {
        int index;
        int i;
        index = findInsertIndex(key);
        int i2 = 0;
        if (index < 0) {
            index = i;
        }
        this.keys[index] = key;
        this.values[index] = value;
        return this.values[index];
    }

    public final void putAll(androidx.collection.ScatterMap<K, V> from) {
        int cmp;
        int obj;
        int $i$f$forEach2;
        Object k$iv;
        Object[] keys;
        Object k$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i3;
        Object this_$iv;
        long l;
        int i5;
        int i4;
        int $i$f$forEach;
        int i2;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(from, "from");
        cmp = from;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = cmp;
            $i$f$forEach = $i$f$forEach2;
            objArr = keys;
            k$iv = this;
        }
    }

    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Object component2;
        Object component1;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator iterator = pairs.iterator();
        for (Pair next2 : iterator) {
            set(next2.component1(), next2.component2());
        }
    }

    public final void putAll(Map<K, ? extends V> from) {
        Object next;
        int i;
        Object key;
        Object value;
        Intrinsics.checkNotNullParameter(from, "from");
        final int i2 = 0;
        Iterator iterator = from.entrySet().iterator();
        for (Map.Entry next : iterator) {
            i = 0;
            set(next.getKey(), next.getValue());
        }
    }

    public final void putAll(Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Object component2;
        Object component1;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator iterator = pairs.iterator();
        for (Pair next2 : iterator) {
            set(next2.component1(), next2.component2());
        }
    }

    public final void putAll(Pair<? extends K, ? extends V>[] pairs) {
        int i;
        Object component2;
        Object component1;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        i = 0;
        while (i < pairs.length) {
            Object obj = pairs[i];
            set(obj.component1(), obj.component2());
            i++;
        }
    }

    public final V remove(K key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int i3;
        int i8;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i9;
        int i4;
        int $this$next$iv$iv;
        int i5;
        int i7;
        int i10;
        int i11;
        long l;
        int i14;
        int i2;
        int i12;
        int i13;
        int i6;
        int numberOfTrailingZeros;
        int i;
        final Object obj = this;
        final Object obj2 = key;
        Object obj3 = obj;
        m$iv = 0;
        int i17 = 0;
        if (obj2 != null) {
            i8 = obj2.hashCode();
        } else {
            i8 = 0;
        }
        i8 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj3._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i36 = 0;
            while (Long.compare(i26, i36) != 0) {
                i6 = 1;
                i5 = 0;
                i13 = 0;
                int i29 = m$iv2;
                i11 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i36 = 0;
                i6 = 0;
            }
            i6 = 0;
            int i28 = i3;
            i5 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i13) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i9 & _capacity;
            $i$f$h2 = i7;
            m$iv = i2;
            $i$f$hash = i12;
            long[] metadata = obj3.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            i20 |= i34;
            i5 = 0;
            i7 = i43;
            long l6 = 72340172838076673L;
            i35 ^= i4;
            l = -9187201950435737472L;
            i16 &= l;
            i5 = 0;
            i13 = 0;
            i29 = m$iv2;
            i11 = 0;
            m$iv2 = $this$next$iv$iv;
            i6 = 1;
        }
        if (i4 >= 0) {
            return obj.removeValueAt(i4);
        }
        return 0;
    }

    public final boolean remove(K key, V value) {
        Object equal;
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int i2;
        int i10;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i7;
        int i3;
        int $this$hasNext$iv$iv;
        Object obj2;
        int $this$next$iv$iv;
        Object obj;
        int i11;
        int i13;
        int i;
        int i8;
        long l;
        int i4;
        int i12;
        int i9;
        int i5;
        int i6;
        int numberOfTrailingZeros;
        final Object obj3 = this;
        final Object obj4 = key;
        equal = obj3;
        m$iv = 0;
        int i15 = 0;
        if (obj4 != null) {
            i10 = obj4.hashCode();
        } else {
            i10 = 0;
        }
        i10 *= i21;
        $i$f$hash = i19 ^ i22;
        int i20 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = equal._capacity;
        int i23 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i29 = 0;
            int i34 = 0;
            i6 = 1;
            while (Long.compare(i24, i34) != 0) {
                $this$hasNext$iv$iv = i6;
                i11 = 0;
                i5 = 0;
                int i27 = m$iv2;
                i8 = 0;
                m$iv2 = $this$next$iv$iv;
                i29 = 0;
                i34 = 0;
                i6 = 1;
                $this$hasNext$iv$iv = i4;
            }
            $this$hasNext$iv$iv = i4;
            int i26 = i2;
            i11 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj2 = value;
            $i$f$h1 = i7 & _capacity;
            $i$f$h2 = i13;
            m$iv = i12;
            $i$f$hash = i9;
            long[] metadata = equal.metadata;
            $this$next$iv$iv = 0;
            int i28 = $i$f$h1 >> 3;
            i30 <<= 3;
            i4 = 0;
            i18 |= i32;
            i11 = 0;
            i13 = i42;
            long l6 = 72340172838076673L;
            i33 ^= i3;
            l = -9187201950435737472L;
            i14 &= l;
            i11 = 0;
            i5 = 0;
            i27 = m$iv2;
            i8 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$hasNext$iv$iv = i6;
        }
        if (i3 >= 0) {
            if (Intrinsics.areEqual(obj3.values[i3], value)) {
                obj3.removeValueAt(i3);
                return i6;
            }
        } else {
            obj = value;
        }
        return i4;
    }

    public final void removeIf(Function2<? super K, ? super V, Boolean> predicate) {
        int $i$f$removeIf2;
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int i3;
        int j$iv;
        int i;
        int i2;
        long l;
        int i4;
        int i5;
        int $i$f$removeIf;
        final Object obj = this;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        final int i6 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i7) {
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
        final int i3 = 0;
        this.keys[index] = i3;
        this.values[index] = i3;
        return this.values[index];
    }

    public final void set(K key, V value) {
        int index;
        int i;
        index = findInsertIndex(key);
        int i2 = 0;
        if (index < 0) {
            index = i;
        }
        this.keys[index] = key;
        this.values[index] = value;
    }

    @Override // androidx.collection.ScatterMap
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
