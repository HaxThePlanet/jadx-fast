package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\u000f2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0016¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapKeySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "addAll", "elements", "", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SnapshotMapKeySet<K, V>  extends androidx.compose.runtime.snapshots.SnapshotMapSet<K, V, K> {
    public SnapshotMapKeySet(androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map) {
        super(map);
    }

    public Void add(K element) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public boolean add(Object element) {
        return (Boolean)add(element).booleanValue();
    }

    public Void addAll(Collection<? extends K> elements) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public boolean addAll(Collection elements) {
        return (Boolean)addAll(elements).booleanValue();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public boolean contains(Object element) {
        return (Map)getMap().containsKey(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        boolean iterator;
        int i2;
        boolean next;
        Object obj;
        int i;
        boolean key;
        final Object obj2 = elements;
        final int i3 = 0;
        i2 = 1;
        if (obj2 instanceof Collection != null && (Collection)(Iterable)obj2.isEmpty()) {
            if ((Collection)obj2.isEmpty()) {
            } else {
                iterator = obj2.iterator();
                for (Object next : iterator) {
                    i = 0;
                }
            }
        } else {
        }
        return i2;
    }

    public androidx.compose.runtime.snapshots.StateMapMutableKeysIterator<K, V> iterator() {
        StateMapMutableKeysIterator stateMapMutableKeysIterator = new StateMapMutableKeysIterator(getMap(), (ImmutableSet)getMap().getReadable$runtime_release().getMap$runtime_release().entrySet().iterator());
        return stateMapMutableKeysIterator;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public Iterator iterator() {
        return (Iterator)iterator();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMapSet
    public boolean remove(Object element) {
        int i;
        i = getMap().remove(element) != null ? 1 : 0;
        return i;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        int removed;
        Object next;
        Object obj;
        int i;
        int i2;
        removed = 0;
        final int i3 = 0;
        final Iterator iterator = (Iterable)elements.iterator();
        while (iterator.hasNext()) {
            i = 0;
            if (getMap().remove(iterator.next()) == null) {
            } else {
            }
            i2 = 1;
            removed = i2;
            if (removed != 0) {
            } else {
            }
            i2 = 0;
        }
        return removed;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        int it$iv$iv$iv$iv;
        int modification$runtime_release;
        int set2;
        Set set3;
        androidx.compose.runtime.snapshots.StateRecord set;
        androidx.compose.runtime.snapshots.SnapshotStateMap newMap$iv$iv;
        int removed$iv;
        int result$iv$iv;
        PersistentMap oldMap$iv$iv;
        int currentModification$iv$iv;
        PersistentMap.Builder builder;
        androidx.compose.runtime.snapshots.SnapshotStateMap map;
        int iterator;
        androidx.compose.runtime.snapshots.StateRecord next2;
        int next;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv$iv;
        androidx.compose.runtime.snapshots.SnapshotStateMap this_$iv;
        androidx.compose.runtime.snapshots.StateRecord current;
        int i;
        Object lock;
        int i4;
        int i5;
        int $this$mutate_u24lambda_u2415$iv$iv;
        int i6;
        Object obj;
        int i3;
        int i2;
        int set4;
        set3 = CollectionsKt.toSet((Iterable)elements);
        final int i11 = 0;
        final androidx.compose.runtime.snapshots.SnapshotStateMap map4 = newMap$iv$iv;
        final int i12 = 0;
        result$iv$iv = i13;
        removed$iv = it$iv$iv$iv$iv;
        int i14 = 0;
        int i15 = 0;
        Object obj3 = SnapshotStateMapKt.access$getSync$p();
        int i16 = 0;
        int i7 = 0;
        next = 0;
        firstStateRecord = map4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        snapshot$iv$iv$iv$iv = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        i = 0;
        oldMap$iv$iv = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1$iv$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap$iv$iv);
        builder = oldMap$iv$iv.builder();
        map = 0;
        iterator = newMap$iv$iv.entrySet().iterator();
        synchronized (obj3) {
            i14 = 0;
            i15 = 0;
            obj3 = SnapshotStateMapKt.access$getSync$p();
            i16 = 0;
            i7 = 0;
            next = 0;
            firstStateRecord = map4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            snapshot$iv$iv$iv$iv = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            i = 0;
            oldMap$iv$iv = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1$iv$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap$iv$iv);
            builder = oldMap$iv$iv.builder();
            map = 0;
            iterator = newMap$iv$iv.entrySet().iterator();
        }
        while (iterator.hasNext()) {
            next = iterator.next();
            snapshot$iv$iv$iv$iv = 0;
            current = newMap$iv$iv;
            if (!set3.contains((Map.Entry)next.getKey())) {
            } else {
            }
            newMap$iv$iv = current;
            (Map)builder.remove(next.getKey());
            removed$iv = 1;
            newMap$iv$iv = current;
        }
        result$iv$iv = it$iv;
        PersistentMap build = builder.build();
        if (!Intrinsics.areEqual(build, oldMap$iv$iv)) {
        } else {
            set4 = set3;
        }
        return removed$iv;
    }
}
