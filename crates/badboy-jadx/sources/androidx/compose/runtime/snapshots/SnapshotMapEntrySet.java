package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010)\n\u0002\u0008\u0004\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0008\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0018\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0096\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SnapshotMapEntrySet<K, V>  extends androidx.compose.runtime.snapshots.SnapshotMapSet<K, V, Map.Entry<K, V>> {
    public SnapshotMapEntrySet(androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map) {
        super(map);
    }

    public Void add(Map.Entry<K, V> element) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public boolean add(Object element) {
        return (Boolean)add((Map.Entry)element).booleanValue();
    }

    public Void addAll(Collection<? extends Map.Entry<K, V>> elements) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public boolean addAll(Collection elements) {
        return (Boolean)addAll(elements).booleanValue();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public final boolean contains(Object element) {
        if (!TypeIntrinsics.isMutableMapEntry(element)) {
            return 0;
        }
        return contains((Map.Entry)element);
    }

    public boolean contains(Map.Entry<K, V> element) {
        return Intrinsics.areEqual(getMap().get(element.getKey()), element.getValue());
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        boolean iterator;
        int i2;
        boolean next;
        boolean it;
        int i;
        final Object obj = elements;
        final int i3 = 0;
        i2 = 1;
        if (obj instanceof Collection != null && (Collection)(Iterable)obj.isEmpty()) {
            if ((Collection)obj.isEmpty()) {
            } else {
                iterator = obj.iterator();
                for (Object next : iterator) {
                    i = 0;
                }
            }
        } else {
        }
        return i2;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        StateMapMutableEntriesIterator stateMapMutableEntriesIterator = new StateMapMutableEntriesIterator(getMap(), (ImmutableSet)getMap().getReadable$runtime_release().getMap$runtime_release().entrySet().iterator());
        return (Iterator)stateMapMutableEntriesIterator;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public final boolean remove(Object element) {
        if (!TypeIntrinsics.isMutableMapEntry(element)) {
            return 0;
        }
        return remove((Map.Entry)element);
    }

    public boolean remove(Map.Entry<K, V> element) {
        int i;
        i = getMap().remove(element.getKey()) != null ? 1 : 0;
        return i;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        int removed;
        Object next;
        int i;
        Object key;
        removed = 0;
        final Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            if (getMap().remove((Map.Entry)iterator.next().getKey()) == null) {
            } else {
            }
            i = 1;
            removed = i;
            if (removed != 0) {
            } else {
            }
            i = 0;
        }
        return removed;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        int it$iv$iv$iv$iv;
        int modification$runtime_release;
        int this_$iv2;
        androidx.compose.runtime.snapshots.SnapshotStateMap this_$iv;
        int $i$f$removeIf$runtime_release3;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord $i$f$removeIf$runtime_release;
        int removed$iv;
        Object next2;
        int result$iv$iv;
        Object oldMap$iv$iv;
        Object currentModification$iv$iv;
        Object builder;
        Object build;
        androidx.compose.runtime.snapshots.SnapshotStateMap iterator;
        int next3;
        int next;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        boolean equal;
        int value;
        int current;
        int i8;
        int i7;
        int i5;
        Object lock;
        int i;
        int i6;
        androidx.compose.runtime.snapshots.SnapshotStateMap this_$iv3;
        int i3;
        Object obj;
        int i9;
        int i4;
        int $i$f$removeIf$runtime_release2;
        Iterable iterable = elements;
        int i14 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, 10)), 16));
        int i17 = 0;
        Iterator iterator2 = iterable.iterator();
        for (Object next2 : iterator2) {
            Object obj3 = next2;
            int i22 = 0;
            Pair it = TuplesKt.to((Map.Entry)obj3.getKey(), obj3.getValue());
            (Map)linkedHashMap.put(it.getFirst(), it.getSecond());
        }
        i2 = 0;
        androidx.compose.runtime.snapshots.SnapshotStateMap map3 = this_$iv;
        int i18 = 0;
        result$iv$iv = i19;
        removed$iv = it$iv$iv$iv$iv;
        int i20 = 0;
        int i21 = 0;
        Object obj4 = SnapshotStateMapKt.access$getSync$p();
        int i23 = 0;
        int i10 = 0;
        next = 0;
        firstStateRecord = map3.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        value = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        i8 = 0;
        oldMap$iv$iv = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1$iv$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap$iv$iv);
        builder = oldMap$iv$iv.builder();
        int i24 = 0;
        iterator = this_$iv.entrySet().iterator();
        synchronized (obj4) {
            i20 = 0;
            i21 = 0;
            obj4 = SnapshotStateMapKt.access$getSync$p();
            i23 = 0;
            i10 = 0;
            next = 0;
            firstStateRecord = map3.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            value = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            i8 = 0;
            oldMap$iv$iv = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1$iv$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap$iv$iv);
            builder = oldMap$iv$iv.builder();
            i24 = 0;
            iterator = this_$iv.entrySet().iterator();
        }
        while (iterator.hasNext()) {
            next = iterator.next();
            current = next;
            i8 = 0;
            if (linkedHashMap.containsKey(current.getKey())) {
            } else {
            }
            i5 = 1;
            firstStateRecord = i5;
            if (firstStateRecord != null) {
            }
            (Map)builder.remove((Map.Entry)next.getKey());
            removed$iv = 1;
            i5 = 1;
            if (!Intrinsics.areEqual(linkedHashMap.get(current.getKey()), current.getValue())) {
            } else {
            }
            firstStateRecord = 0;
        }
        result$iv$iv = it$iv;
        build = builder.build();
        if (!Intrinsics.areEqual(build, oldMap$iv$iv)) {
        } else {
            this_$iv3 = this_$iv;
            $i$f$removeIf$runtime_release2 = i2;
        }
        return removed$iv;
    }
}
