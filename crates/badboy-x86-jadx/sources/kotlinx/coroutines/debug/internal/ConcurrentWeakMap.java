package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap.Entry;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0003()*B\u000f\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\u0008\u00030\u001cH\u0002J\u0008\u0010\u001d\u001a\u00020\u001aH\u0016J\u0008\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010$J!\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\u0008\u0010#\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010$J\u0017\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0006\u0010'\u001a\u00020\u001aR\t\u0010\u0008\u001a\u00020\tX\u0082\u0004R\u001f\u0010\n\u001a\u0018\u0012\u0014\u0012\u00120\u000cR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000bX\u0082\u0004R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+", d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "K", "", "V", "Lkotlin/collections/AbstractMutableMap;", "weakRefQueue", "", "(Z)V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "core", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "Ljava/lang/ref/ReferenceQueue;", "cleanWeakRef", "", "w", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "clear", "decrementSize", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentWeakMap<K, V>  extends AbstractMutableMap<K, V> {

    private static final AtomicIntegerFieldUpdater _size$FU;
    private static final AtomicReferenceFieldUpdater core$FU;
    @Volatile
    private volatile int _size;
    @Volatile
    private volatile Object core;
    private final ReferenceQueue<K> weakRefQueue;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u0007J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J,\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\u0008\u0002\u0010\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00170\u0019J1\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0008\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0010\u0008\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006X\u0082\u0004R\t\u0010\u0008\u001a\u00020\tX\u0082\u0004R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¨\u0006\"", d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "keys", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "load", "Lkotlinx/atomicfu/AtomicInt;", "shift", "threshold", "values", "cleanWeakRef", "", "weakRef", "getImpl", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "index", "hash", "keyValueIterator", "", "E", "factory", "Lkotlin/Function2;", "putImpl", "value", "weakKey0", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "rehash", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "removeCleanedAt", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class Core {

        private static final AtomicIntegerFieldUpdater load$FU;
        private final int allocated;
        private final AtomicReferenceArray keys;
        @Volatile
        private volatile int load;
        private final int shift;
        final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> this$0;
        private final int threshold;
        private final AtomicReferenceArray values;
        static {
            ConcurrentWeakMap.Core.load$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.Core.class, "load");
        }

        public Core(kotlinx.coroutines.debug.internal.ConcurrentWeakMap this$0, int allocated) {
            this.this$0 = this$0;
            super();
            this.allocated = allocated;
            this.shift = numberOfLeadingZeros++;
            this.threshold = i2 /= 3;
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(this.allocated);
            this.keys = atomicReferenceArray;
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(this.allocated);
            this.values = atomicReferenceArray2;
        }

        public static final int access$getAllocated$p(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core $this) {
            return $this.allocated;
        }

        public static final AtomicReferenceArray access$getKeys$p(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core $this) {
            return $this.keys;
        }

        public static final AtomicReferenceArray access$getValues$p(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core $this) {
            return $this.values;
        }

        private final int index(int hash) {
            return i2 >>>= shift;
        }

        public static Object putImpl$default(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core concurrentWeakMap$Core, Object object2, Object object3, kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef4, int i5, Object object6) {
            int obj3;
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            return core.putImpl(object2, object3, obj3);
        }

        private final void removeCleanedAt(int index) {
            Object obj;
            boolean z;
            int i;
            obj = this.values.get(index);
            while (obj == null) {
                obj = this.values.get(index);
            }
        }

        private final void update$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function12, Object object3) {
            boolean compareAndSet;
            int intValue;
            final int i = 0;
            int i2 = atomicIntegerFieldUpdater.get(object3);
            while (atomicIntegerFieldUpdater.compareAndSet(object3, i2, (Number)function12.invoke(Integer.valueOf(i2)).intValue())) {
                i2 = atomicIntegerFieldUpdater.get(object3);
            }
        }

        public final void cleanWeakRef(kotlinx.coroutines.debug.internal.HashedWeakRef<?> weakRef) {
            int index;
            Object obj;
            index = index(weakRef.hash);
            obj = this.keys.get(index);
            while ((HashedWeakRef)obj == null) {
                if (index == 0) {
                }
                index--;
                obj = this.keys.get(index);
                index = this.allocated;
            }
        }

        public final V getImpl(K key) {
            int index;
            Object obj2;
            Object obj;
            boolean equal;
            Object ref;
            index = index(key.hashCode());
            obj2 = this.keys.get(index);
            while ((HashedWeakRef)obj2 == null) {
                obj = (HashedWeakRef)obj2.get();
                if (obj == null) {
                }
                if (index == 0) {
                }
                index--;
                obj2 = this.keys.get(index);
                index = this.allocated;
                removeCleanedAt(index);
            }
            return 0;
        }

        public final <E> Iterator<E> keyValueIterator(Function2<? super K, ? super V, ? extends E> factory) {
            ConcurrentWeakMap.Core.KeyValueIterator keyValueIterator = new ConcurrentWeakMap.Core.KeyValueIterator(this, factory);
            return (Iterator)keyValueIterator;
        }

        public final Object putImpl(K key, V value, kotlinx.coroutines.debug.internal.HashedWeakRef<K> weakKey0) {
            int index;
            int loadIncremented2;
            int loadIncremented;
            kotlinx.coroutines.debug.internal.HashedWeakRef weakKey;
            Object obj;
            Object obj3;
            boolean hashedWeakRef;
            int i2;
            Object obj2;
            kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef2;
            int i;
            boolean compareAndSet;
            int n;
            int i3;
            int threshold;
            index = index(key.hashCode());
            loadIncremented2 = 0;
            weakKey = weakKey0;
            obj = this.keys.get(index);
            while ((HashedWeakRef)obj == null) {
                int i5 = 0;
                if (weakKey == null) {
                }
                obj = this.keys.get(index);
                obj3 = (HashedWeakRef)(HashedWeakRef)obj.get();
                if (obj3 == null) {
                }
                if (index == 0) {
                }
                index--;
                index = this.allocated;
                removeCleanedAt(index);
                hashedWeakRef = new HashedWeakRef(key, ConcurrentWeakMap.access$getWeakRefQueue$p(this.this$0));
                weakKey = hashedWeakRef;
                hashedWeakRef = ConcurrentWeakMap.Core.load$FU;
                obj2 = this;
                i = 0;
                int i6 = hashedWeakRef.get(this);
                int i7 = i6;
                i3 = 0;
                while (i7 >= this.threshold) {
                    i6 = hashedWeakRef.get(this);
                    i7 = i6;
                    i3 = 0;
                }
                loadIncremented2 = 1;
            }
            return i5;
        }

        public final kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core<K, V> rehash() {
            int i;
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core core;
            int index;
            int allocated;
            Object obj;
            Object obj2;
            Object value;
            Object impl;
            kotlinx.coroutines.internal.Symbol symbol;
            while (/* condition */) {
                while (index < allocated) {
                    obj = this.keys.get(index);
                    if ((HashedWeakRef)obj != null) {
                    } else {
                    }
                    obj2 = 0;
                    if ((HashedWeakRef)obj != null && obj2 == null) {
                    }
                    value = 0;
                    value = this.values.get(index);
                    while (value instanceof Marked) {
                        if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, index, value, ConcurrentWeakMapKt.access$mark(value))) {
                            break loop_10;
                        }
                        value = this.values.get(index);
                    }
                    if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, index, value, ConcurrentWeakMapKt.access$mark(value))) {
                    }
                    index++;
                    impl = core.putImpl(obj2, value, (HashedWeakRef)obj);
                    if (impl == null) {
                    } else {
                    }
                    symbol = 0;
                    symbol = 1;
                    value = impl.ref;
                    if (obj2 == null) {
                    }
                    removeCleanedAt(index);
                    obj2 = obj.get();
                }
                obj = this.keys.get(index);
                if ((HashedWeakRef)obj != null) {
                } else {
                }
                obj2 = 0;
                if ((HashedWeakRef)obj != null && obj2 == null) {
                }
                value = 0;
                value = this.values.get(index);
                while (value instanceof Marked) {
                    if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, index, value, ConcurrentWeakMapKt.access$mark(value))) {
                        break loop_10;
                    }
                    value = this.values.get(index);
                }
                if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, index, value, ConcurrentWeakMapKt.access$mark(value))) {
                }
                index++;
                impl = core.putImpl(obj2, value, (HashedWeakRef)obj);
                int i2 = 4;
                core = new ConcurrentWeakMap.Core(this.this$0, highestOneBit *= i2);
                index = 0;
                if (impl == null) {
                } else {
                }
                symbol = 0;
                symbol = 1;
                value = impl.ref;
                if (obj2 == null) {
                }
                removeCleanedAt(index);
                obj2 = obj.get();
            }
            return core;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010'\n\u0002\u0008\u000b\u0008\u0002\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00032\u0006\u0010\u000c\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Entry implements Map.Entry<K, V>, KMutableMap.Entry {

        private final K key;
        private final V value;
        public Entry(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V newValue) {
            ConcurrentWeakMapKt.access$noImpl();
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010)\n\u0000\u0008\u0082\u0004\u0018\u0000*\u0004\u0008\u0002\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00020\u000fH\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class KeyValueSet extends AbstractMutableSet<E> {

        private final Function2<K, V, E> factory;
        final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> this$0;
        public KeyValueSet(kotlinx.coroutines.debug.internal.ConcurrentWeakMap this$0, Function2 factory) {
            this.this$0 = this$0;
            super();
            this.factory = factory;
        }

        public boolean add(E element) {
            ConcurrentWeakMapKt.access$noImpl();
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return this.this$0.size();
        }

        public Iterator<E> iterator() {
            return (ConcurrentWeakMap.Core)ConcurrentWeakMap.access$getCore$FU$p().get(this.this$0).keyValueIterator(this.factory);
        }
    }
    static {
        final Class<kotlinx.coroutines.debug.internal.ConcurrentWeakMap> obj2 = ConcurrentWeakMap.class;
        ConcurrentWeakMap._size$FU = AtomicIntegerFieldUpdater.newUpdater(obj2, "_size");
        ConcurrentWeakMap.core$FU = AtomicReferenceFieldUpdater.newUpdater(obj2, Object.class, "core");
    }

    public ConcurrentWeakMap() {
        super(0, 1, 0);
    }

    public ConcurrentWeakMap(boolean weakRefQueue) {
        ReferenceQueue referenceQueue;
        super();
        ConcurrentWeakMap.Core core = new ConcurrentWeakMap.Core(this, 16);
        this.core = core;
        if (weakRefQueue) {
            referenceQueue = new ReferenceQueue();
        } else {
            referenceQueue = 0;
        }
        this.weakRefQueue = referenceQueue;
    }

    public ConcurrentWeakMap(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final void access$decrementSize(kotlinx.coroutines.debug.internal.ConcurrentWeakMap $this) {
        $this.decrementSize();
    }

    public static final AtomicReferenceFieldUpdater access$getCore$FU$p() {
        return ConcurrentWeakMap.core$FU;
    }

    public static final ReferenceQueue access$getWeakRefQueue$p(kotlinx.coroutines.debug.internal.ConcurrentWeakMap $this) {
        return $this.weakRefQueue;
    }

    private final void cleanWeakRef(kotlinx.coroutines.debug.internal.HashedWeakRef<?> w) {
        (ConcurrentWeakMap.Core)ConcurrentWeakMap.core$FU.get(this).cleanWeakRef(w);
    }

    private final void decrementSize() {
        ConcurrentWeakMap._size$FU.decrementAndGet(this);
    }

    private final V putSynchronized(K key, V value) {
        Object curCore;
        Object obj2;
        Object obj;
        int i;
        int i3;
        int i2;
        Object obj8;
        Object obj9;
        curCore = obj3;
        synchronized (this) {
            try {
                obj2 = obj8;
                obj = obj9;
                obj8 = ConcurrentWeakMap.Core.putImpl$default(curCore, obj2, obj, 0, 4, 0);
                while (obj8 != ConcurrentWeakMapKt.access$getREHASH$p()) {
                    ConcurrentWeakMap.core$FU.set(this, curCore.rehash());
                    obj8 = obj2;
                    obj9 = obj;
                    obj2 = obj8;
                    obj = obj9;
                    obj8 = ConcurrentWeakMap.Core.putImpl$default(curCore, obj2, obj, 0, 4, 0);
                }
                return obj8;
                ConcurrentWeakMap.core$FU.set(this, curCore.rehash());
                obj8 = obj2;
                obj9 = obj;
                key = th;
                throw key;
            }
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    public void clear() {
        Object next;
        Iterator iterator = keySet().iterator();
        for (Object next : iterator) {
            remove(next);
        }
    }

    public V get(Object key) {
        if (key == null) {
            return 0;
        }
        return (ConcurrentWeakMap.Core)ConcurrentWeakMap.core$FU.get(this).getImpl(key);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        ConcurrentWeakMap.KeyValueSet keyValueSet = new ConcurrentWeakMap.KeyValueSet(this, (Function2)ConcurrentWeakMap.entries.1.INSTANCE);
        return (Set)keyValueSet;
    }

    public Set<K> getKeys() {
        ConcurrentWeakMap.KeyValueSet keyValueSet = new ConcurrentWeakMap.KeyValueSet(this, (Function2)ConcurrentWeakMap.keys.1.INSTANCE);
        return (Set)keyValueSet;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return ConcurrentWeakMap._size$FU.get(this);
    }

    public V put(K key, V value) {
        Object obj8;
        Object obj9;
        final Object obj3 = key;
        final Object obj4 = value;
        if (ConcurrentWeakMap.Core.putImpl$default((ConcurrentWeakMap.Core)ConcurrentWeakMap.core$FU.get(this), obj3, obj4, 0, 4, 0) == ConcurrentWeakMapKt.access$getREHASH$p()) {
            obj8 = putSynchronized(obj3, obj4);
        }
        if (obj8 == null) {
            ConcurrentWeakMap._size$FU.incrementAndGet(this);
        }
        return obj8;
    }

    public V remove(Object key) {
        int _size$FU;
        Object obj9;
        _size$FU = 0;
        if (key == null) {
            return _size$FU;
        }
        final Object obj3 = key;
        if (ConcurrentWeakMap.Core.putImpl$default((ConcurrentWeakMap.Core)ConcurrentWeakMap.core$FU.get(this), obj3, 0, 0, 4, 0) == ConcurrentWeakMapKt.access$getREHASH$p()) {
            obj9 = putSynchronized(obj3, _size$FU);
        }
        if (obj9 != null) {
            ConcurrentWeakMap._size$FU.decrementAndGet(this);
        }
        return obj9;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        int remove;
        Object currentThread;
        remove = this.weakRefQueue != null ? 1 : 0;
        if (remove == 0) {
        } else {
            while (true) {
                remove = this.weakRefQueue.remove();
                Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                cleanWeakRef((HashedWeakRef)remove);
            }
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Must be created with weakRefQueue = true".toString());
        throw illegalStateException;
    }
}
