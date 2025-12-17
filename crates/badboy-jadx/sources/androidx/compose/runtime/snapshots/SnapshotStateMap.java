package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001NB\u0005¢\u0006\u0002\u0010\u0005J.\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\u0080\u0008¢\u0006\u0002\u0008+J.\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\u0080\u0008¢\u0006\u0002\u0008-J\u0008\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00106J\u0008\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\u0008\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u0002H90)H\u0082\u0008¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J.\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\u0080\u0008¢\u0006\u0002\u0008CJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000¢\u0006\u0004\u0008E\u00102J\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007J\u0008\u0010G\u001a\u00020HH\u0016J5\u0010I\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010J\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010J0)H\u0082\u0008J9\u0010K\u001a\u0002H9\"\u0004\u0008\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\u0008LH\u0082\u0008¢\u0006\u0002\u0010;J9\u0010M\u001a\u0002H9\"\u0004\u0008\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\u0008LH\u0082\u0008¢\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0005\u001a\u0004\u0008\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u0005\u001a\u0004\u0008\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\u001aR\u001a\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00010#X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%¨\u0006O", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "Landroidx/compose/runtime/snapshots/StateObject;", "", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "toMap", "toString", "", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateMap<K, V>  implements androidx.compose.runtime.snapshots.StateObject, Map<K, V>, KMutableMap {

    public static final int $stable;
    private final Set<Map.Entry<K, V>> entries;
    private androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
    private final Set<K> keys;
    private final Collection<V> values;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u00020\u0003B\u001b\u0008\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0008\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0014", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StateMapStateRecord extends androidx.compose.runtime.snapshots.StateRecord {

        public static final int $stable = 8;
        private PersistentMap<K, ? extends V> map;
        private int modification;
        static {
            final int i = 8;
        }

        public StateMapStateRecord(PersistentMap<K, ? extends V> map) {
            super();
            this.map = map;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(androidx.compose.runtime.snapshots.StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            Object obj = value;
            final Object obj2 = SnapshotStateMapKt.access$getSync$p();
            final int i = 0;
            int i2 = 0;
            this.map = obj.map;
            this.modification = obj.modification;
            Unit $i$a$SynchronizedSnapshotStateMap$StateMapStateRecord$assign$1 = Unit.INSTANCE;
            return;
            synchronized (obj2) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
                obj = value;
                obj2 = SnapshotStateMapKt.access$getSync$p();
                i = 0;
                i2 = 0;
                this.map = obj.map;
                this.modification = obj.modification;
                $i$a$SynchronizedSnapshotStateMap$StateMapStateRecord$assign$1 = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public androidx.compose.runtime.snapshots.StateRecord create() {
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord = new SnapshotStateMap.StateMapStateRecord(this.map);
            return (StateRecord)stateMapStateRecord;
        }

        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> <set-?>) {
            this.map = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setModification$runtime_release(int <set-?>) {
            this.modification = <set-?>;
        }
    }
    static {
    }

    public SnapshotStateMap() {
        boolean stateMapStateRecord;
        androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord map;
        int i2;
        int i;
        super();
        PersistentMap persistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        final int i3 = 0;
        SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = new SnapshotStateMap.StateMapStateRecord(persistentHashMapOf);
        final int i4 = 0;
        if (Snapshot.Companion.isInSnapshot()) {
            stateMapStateRecord = new SnapshotStateMap.StateMapStateRecord(persistentHashMapOf);
            i2 = 0;
            stateMapStateRecord.setSnapshotId$runtime_release(1);
            stateMapStateRecord2.setNext$runtime_release((StateRecord)stateMapStateRecord);
        }
        this.firstStateRecord = (StateRecord)stateMapStateRecord2;
        SnapshotMapEntrySet snapshotMapEntrySet = new SnapshotMapEntrySet(this);
        this.entries = (Set)snapshotMapEntrySet;
        SnapshotMapKeySet snapshotMapKeySet = new SnapshotMapKeySet(this);
        this.keys = (Set)snapshotMapKeySet;
        SnapshotMapValueSet snapshotMapValueSet = new SnapshotMapValueSet(this);
        this.values = (Collection)snapshotMapValueSet;
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public static void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super Map<K, V>, ? extends R> block) {
        int equal;
        int modification$runtime_release;
        int $i$f$mutate3;
        int i7;
        androidx.compose.runtime.snapshots.StateRecord $i$f$mutate2;
        int result;
        PersistentMap oldMap;
        int currentModification;
        PersistentMap.Builder builder;
        PersistentMap build;
        Object obj4;
        int i2;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int current;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i6;
        int i5;
        int $this$mutate_u24lambda_u2415;
        int i;
        Object obj;
        int i3;
        int i4;
        int $i$f$mutate;
        i7 = 0;
        result = equal;
        int i11 = 0;
        int i12 = 0;
        Object obj3 = SnapshotStateMapKt.access$getSync$p();
        int i13 = 0;
        int i8 = 0;
        i2 = 0;
        firstStateRecord = this.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        stateRecord = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        snapshot$iv$iv = 0;
        oldMap = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1 = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap);
        builder = oldMap.builder();
        build = builder.build();
        synchronized (obj3) {
            i11 = 0;
            i12 = 0;
            obj3 = SnapshotStateMapKt.access$getSync$p();
            i13 = 0;
            i8 = 0;
            i2 = 0;
            firstStateRecord = this.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            stateRecord = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            snapshot$iv$iv = 0;
            oldMap = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1 = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap);
            builder = oldMap.builder();
            build = builder.build();
        }
        i2 = this;
        firstStateRecord = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = i2.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        current = 0;
        int i9 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i15 = 0;
        lock = SnapshotKt.getLock();
        i6 = 0;
        i5 = 0;
        snapshot$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        i = 0;
        obj = obj2;
        i3 = 0;
        i4 = i10;
        synchronized (lock) {
            $i$f$mutate = i7;
            $i$f$mutate2 = stateRecord2;
            $i$f$mutate2.setMap$runtime_release(build);
            $this$mutate_u24lambda_u2415 = 1;
            $i$f$mutate2.setModification$runtime_release(modification$runtime_release2++);
            equal = $this$mutate_u24lambda_u2415;
            i7 = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv, (StateObject)i2);
            if ($this$mutate_u24lambda_u2415 != 0) {
            } else {
            }
            return block.invoke(builder);
        }
    }

    private final void update(Function1<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> block) {
        int map$runtime_release;
        androidx.compose.runtime.snapshots.StateObject i5;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        int i4;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int i2;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv;
        int i3;
        Object lock;
        int i6;
        int i8;
        int modification$runtime_release;
        int i7;
        Object obj;
        int i9;
        Object obj5;
        int $i$f$update;
        int i;
        i5 = 0;
        final int i12 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = this.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        final int i13 = 0;
        final androidx.compose.runtime.snapshots.StateRecord stateRecord3 = current;
        final int i14 = 0;
        final Object obj4 = invoke;
        if ((PersistentMap)obj4 != stateRecord3.getMap$runtime_release()) {
            stateObject = this;
            i4 = 0;
            androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = stateObject.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            i2 = 0;
            int i10 = 0;
            androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
            i3 = 0;
            lock = SnapshotKt.getLock();
            i6 = 0;
            i8 = 0;
            snapshot$iv$iv = current2;
            i7 = 0;
            obj = obj2;
            i9 = 0;
            $i$f$update = i5;
            androidx.compose.runtime.snapshots.StateRecord $i$f$update2 = stateRecord4;
            $i$f$update2.setMap$runtime_release((PersistentMap)obj4);
            i = i11;
            $i$f$update2.setModification$runtime_release(modification$runtime_release + 1);
            map$runtime_release = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv, (StateObject)stateObject);
            synchronized (lock) {
                stateObject = this;
                i4 = 0;
                firstStateRecord2 = stateObject.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                i2 = 0;
                i10 = 0;
                snapshotInitializer = SnapshotKt.getSnapshotInitializer();
                i3 = 0;
                lock = SnapshotKt.getLock();
                i6 = 0;
                i8 = 0;
                snapshot$iv$iv = current2;
                i7 = 0;
                obj = obj2;
                i9 = 0;
                $i$f$update = i5;
                $i$f$update2 = stateRecord4;
                $i$f$update2.setMap$runtime_release(obj4);
                i = i11;
                $i$f$update2.setModification$runtime_release(modification$runtime_release + 1);
                map$runtime_release = 0;
                SnapshotKt.notifyWrite(snapshot$iv$iv, (StateObject)stateObject);
            }
        } else {
            $i$f$update = i5;
        }
    }

    private final <R> R withCurrent(Function1<? super androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K, V>, ? extends R> block) {
        final int i = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        int i2 = 0;
        return block.invoke(SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord));
    }

    private final <R> R writable(Function1<? super androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K, V>, ? extends R> block) {
        final int i = 0;
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        int i2 = 0;
        int i3 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv = SnapshotKt.getSnapshotInitializer();
        int i4 = 0;
        Object lock = SnapshotKt.getLock();
        int i6 = 0;
        final int i7 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv2 = current;
        Object invoke = block.invoke(SnapshotKt.writableRecord((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord, (StateObject)this, snapshot$iv2));
        Object $i$f$sync = invoke;
        int i5 = 0;
        SnapshotKt.notifyWrite(snapshot$iv2, (StateObject)this);
        return invoke;
        synchronized (lock) {
            i = 0;
            firstStateRecord = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            i2 = 0;
            i3 = 0;
            snapshot$iv = SnapshotKt.getSnapshotInitializer();
            i4 = 0;
            lock = SnapshotKt.getLock();
            i6 = 0;
            i7 = 0;
            snapshot$iv2 = current;
            invoke = block.invoke(SnapshotKt.writableRecord((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord, (StateObject)this, snapshot$iv2));
            $i$f$sync = invoke;
            i5 = 0;
            SnapshotKt.notifyWrite(snapshot$iv2, (StateObject)this);
            return invoke;
        }
    }

    public final boolean all$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        final int i = 0;
        Iterator iterator = (ImmutableSet)getReadable$runtime_release().getMap$runtime_release().entrySet().iterator();
        for (Map.Entry next : iterator) {
        }
        return 1;
    }

    public final boolean any$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        final int i = 0;
        Iterator iterator = (ImmutableSet)getReadable$runtime_release().getMap$runtime_release().entrySet().iterator();
        for (Map.Entry next : iterator) {
        }
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void clear() {
        int map$runtime_release;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        androidx.compose.runtime.snapshots.StateObject stateObject2;
        int i7;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int i6;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        int i5;
        Object lock;
        int i2;
        int i8;
        int modification$runtime_release;
        int i;
        Object obj;
        int i3;
        Object obj3;
        androidx.compose.runtime.snapshots.StateObject this_$iv;
        int i4;
        stateObject = this;
        final int i11 = 0;
        final int i12 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = stateObject.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        final int i13 = 0;
        final androidx.compose.runtime.snapshots.StateRecord stateRecord3 = current;
        final int i14 = 0;
        PersistentMap map$runtime_release2 = (SnapshotStateMap.StateMapStateRecord)stateRecord3.getMap$runtime_release();
        int i15 = 0;
        PersistentMap $i$a$UpdateSnapshotStateMap$clear$1 = it;
        if ($i$a$UpdateSnapshotStateMap$clear$1 != stateRecord3.getMap$runtime_release()) {
            stateObject2 = stateObject;
            i7 = 0;
            androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = stateObject2.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            i6 = 0;
            int i9 = 0;
            androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
            i5 = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i8 = 0;
            snapshot$iv$iv$iv = current2;
            i = 0;
            obj = obj2;
            i3 = 0;
            this_$iv = stateObject;
            androidx.compose.runtime.snapshots.StateRecord this_$iv2 = stateRecord4;
            this_$iv2.setMap$runtime_release($i$a$UpdateSnapshotStateMap$clear$1);
            i4 = i10;
            this_$iv2.setModification$runtime_release(modification$runtime_release + 1);
            map$runtime_release = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)stateObject2);
            synchronized (lock) {
                stateObject2 = stateObject;
                i7 = 0;
                firstStateRecord2 = stateObject2.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                i6 = 0;
                i9 = 0;
                snapshotInitializer = SnapshotKt.getSnapshotInitializer();
                i5 = 0;
                lock = SnapshotKt.getLock();
                i2 = 0;
                i8 = 0;
                snapshot$iv$iv$iv = current2;
                i = 0;
                obj = obj2;
                i3 = 0;
                this_$iv = stateObject;
                this_$iv2 = stateRecord4;
                this_$iv2.setMap$runtime_release($i$a$UpdateSnapshotStateMap$clear$1);
                i4 = i10;
                this_$iv2.setModification$runtime_release(modification$runtime_release + 1);
                map$runtime_release = 0;
                SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)stateObject2);
            }
        } else {
            this_$iv = stateObject;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public boolean containsKey(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(key);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public boolean containsValue(Object value) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(value);
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public V get(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().get(key);
    }

    public final Map<K, V> getDebuggerDisplayValue() {
        final int i = 0;
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = this.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        int i2 = 0;
        final int i3 = 0;
        return (Map)(SnapshotStateMap.StateMapStateRecord)SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord).getMap$runtime_release();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public androidx.compose.runtime.snapshots.StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    public final androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K, V> getReadable$runtime_release() {
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (SnapshotStateMap.StateMapStateRecord)SnapshotKt.readable((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord, (StateObject)this);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    public Collection<V> getValues() {
        return this.values;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    public final Set<K> keySet() {
        return getKeys();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(androidx.compose.runtime.snapshots.StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.firstStateRecord = (StateRecord)(SnapshotStateMap.StateMapStateRecord)value;
    }

    public V put(K key, V value) {
        int equal;
        int modification$runtime_release;
        int this_$iv;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        androidx.compose.runtime.snapshots.StateRecord this_$iv3;
        int result$iv;
        PersistentMap oldMap$iv;
        int currentModification$iv;
        PersistentMap.Builder builder;
        PersistentMap build;
        Object obj;
        Object obj3;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i3;
        androidx.compose.runtime.snapshots.StateRecord current;
        int i5;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i4;
        int i;
        int $this$mutate_u24lambda_u2415$iv;
        int i2;
        Object obj2;
        int i7;
        int i6;
        int this_$iv2;
        stateRecord = this;
        final int i11 = 0;
        result$iv = equal;
        int i12 = 0;
        int i13 = 0;
        Object obj5 = SnapshotStateMapKt.access$getSync$p();
        int i14 = 0;
        int i8 = 0;
        int i16 = 0;
        firstStateRecord = stateRecord.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        i3 = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        i5 = 0;
        oldMap$iv = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap$iv);
        builder = oldMap$iv.builder();
        int i15 = 0;
        build = builder.build();
        synchronized (obj5) {
            i12 = 0;
            i13 = 0;
            obj5 = SnapshotStateMapKt.access$getSync$p();
            i14 = 0;
            i8 = 0;
            i16 = 0;
            firstStateRecord = stateRecord.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            i3 = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            i5 = 0;
            oldMap$iv = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap$iv);
            builder = oldMap$iv.builder();
            i15 = 0;
            build = builder.build();
        }
        firstStateRecord = stateRecord;
        i3 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = firstStateRecord.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        i5 = 0;
        int i9 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i17 = 0;
        lock = SnapshotKt.getLock();
        i4 = 0;
        i = 0;
        snapshot$iv$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord3 = writableRecord;
        i2 = 0;
        obj2 = obj4;
        i7 = 0;
        i6 = i10;
        synchronized (lock) {
            this_$iv2 = stateRecord;
            this_$iv3 = stateRecord3;
            this_$iv3.setMap$runtime_release(build);
            $this$mutate_u24lambda_u2415$iv = 1;
            this_$iv3.setModification$runtime_release(modification$runtime_release2++);
            equal = $this$mutate_u24lambda_u2415$iv;
            stateRecord = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)firstStateRecord);
            if ($this$mutate_u24lambda_u2415$iv != 0) {
            } else {
            }
            return (Map)builder.put(key, value);
        }
    }

    public void putAll(Map<? extends K, ? extends V> from) {
        int equal;
        int modification$runtime_release;
        int this_$iv2;
        int i3;
        androidx.compose.runtime.snapshots.StateRecord this_$iv3;
        int result$iv;
        PersistentMap oldMap$iv;
        int currentModification$iv;
        PersistentMap.Builder builder;
        PersistentMap build;
        Map map;
        int i2;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int current;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i4;
        int i5;
        int $this$mutate_u24lambda_u2415$iv;
        int i7;
        Object obj;
        int i6;
        int i;
        int this_$iv;
        i3 = this;
        final int i11 = 0;
        result$iv = equal;
        int i12 = 0;
        int i13 = 0;
        Object obj3 = SnapshotStateMapKt.access$getSync$p();
        int i14 = 0;
        int i8 = 0;
        i2 = 0;
        firstStateRecord = i3.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        stateRecord = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        snapshot$iv$iv$iv = 0;
        oldMap$iv = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap$iv);
        builder = oldMap$iv.builder();
        int i15 = 0;
        (Map)builder.putAll(from);
        result$iv = it;
        build = builder.build();
        synchronized (obj3) {
            i12 = 0;
            i13 = 0;
            obj3 = SnapshotStateMapKt.access$getSync$p();
            i14 = 0;
            i8 = 0;
            i2 = 0;
            firstStateRecord = i3.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            stateRecord = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            snapshot$iv$iv$iv = 0;
            oldMap$iv = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap$iv);
            builder = oldMap$iv.builder();
            i15 = 0;
            (Map)builder.putAll(from);
            result$iv = it;
            build = builder.build();
        }
        i2 = i3;
        firstStateRecord = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = i2.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        current = 0;
        int i9 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i17 = 0;
        lock = SnapshotKt.getLock();
        i4 = 0;
        i5 = 0;
        snapshot$iv$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        i7 = 0;
        obj = obj2;
        i6 = 0;
        i = i10;
        synchronized (lock) {
            this_$iv = i3;
            this_$iv3 = stateRecord2;
            this_$iv3.setMap$runtime_release(build);
            $this$mutate_u24lambda_u2415$iv = 1;
            this_$iv3.setModification$runtime_release(modification$runtime_release2++);
            equal = $this$mutate_u24lambda_u2415$iv;
            i3 = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)i2);
            if ($this$mutate_u24lambda_u2415$iv != 0) {
            } else {
            }
        }
    }

    public V remove(Object key) {
        int equal;
        int modification$runtime_release;
        int this_$iv;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord this_$iv2;
        int result$iv;
        PersistentMap oldMap$iv;
        int currentModification$iv;
        PersistentMap.Builder builder;
        PersistentMap build;
        Object obj2;
        int i3;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int current;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i4;
        int i6;
        int $this$mutate_u24lambda_u2415$iv;
        int i5;
        Object obj;
        int i;
        int i7;
        int this_$iv3;
        i2 = this;
        final int i11 = 0;
        result$iv = equal;
        int i12 = 0;
        int i13 = 0;
        Object obj4 = SnapshotStateMapKt.access$getSync$p();
        int i14 = 0;
        int i8 = 0;
        i3 = 0;
        firstStateRecord = i2.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        stateRecord = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        snapshot$iv$iv$iv = 0;
        oldMap$iv = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap$iv);
        builder = oldMap$iv.builder();
        int i15 = 0;
        build = builder.build();
        synchronized (obj4) {
            i12 = 0;
            i13 = 0;
            obj4 = SnapshotStateMapKt.access$getSync$p();
            i14 = 0;
            i8 = 0;
            i3 = 0;
            firstStateRecord = i2.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            stateRecord = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            snapshot$iv$iv$iv = 0;
            oldMap$iv = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap$iv);
            builder = oldMap$iv.builder();
            i15 = 0;
            build = builder.build();
        }
        i3 = i2;
        firstStateRecord = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = i3.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        current = 0;
        int i9 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i17 = 0;
        lock = SnapshotKt.getLock();
        i4 = 0;
        i6 = 0;
        snapshot$iv$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        i5 = 0;
        obj = obj3;
        i = 0;
        i7 = i10;
        synchronized (lock) {
            this_$iv3 = i2;
            this_$iv2 = stateRecord2;
            this_$iv2.setMap$runtime_release(build);
            $this$mutate_u24lambda_u2415$iv = 1;
            this_$iv2.setModification$runtime_release(modification$runtime_release2++);
            equal = $this$mutate_u24lambda_u2415$iv;
            i2 = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)i3);
            if ($this$mutate_u24lambda_u2415$iv != 0) {
            } else {
            }
            return (Map)builder.remove(key);
        }
    }

    public final boolean removeIf$runtime_release(Function1<? super Map.Entry<K, V>, Boolean> predicate) {
        int it$iv$iv$iv;
        int modification$runtime_release;
        int $i$f$removeIf$runtime_release3;
        int i6;
        androidx.compose.runtime.snapshots.StateRecord $i$f$removeIf$runtime_release2;
        int removed;
        int result$iv;
        PersistentMap oldMap$iv;
        int currentModification$iv;
        PersistentMap.Builder builder;
        PersistentMap build;
        int iterator;
        int next;
        int next2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord booleanValue;
        int current;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        int i3;
        Object lock;
        int i;
        int i4;
        int $this$mutate_u24lambda_u2415$iv;
        int i2;
        Object obj;
        int i5;
        int i7;
        int $i$f$removeIf$runtime_release;
        i6 = 0;
        final int i12 = this;
        final int i13 = 0;
        result$iv = i14;
        removed = it$iv$iv$iv;
        int i15 = 0;
        int i16 = 0;
        Object obj3 = SnapshotStateMapKt.access$getSync$p();
        int i17 = 0;
        int i8 = 0;
        next2 = 0;
        firstStateRecord = i12.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        booleanValue = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
        snapshot$iv$iv$iv = 0;
        oldMap$iv = map$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldMap$iv);
        builder = oldMap$iv.builder();
        int i18 = 0;
        iterator = entrySet().iterator();
        synchronized (obj3) {
            i15 = 0;
            i16 = 0;
            obj3 = SnapshotStateMapKt.access$getSync$p();
            i17 = 0;
            i8 = 0;
            next2 = 0;
            firstStateRecord = i12.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            booleanValue = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord);
            snapshot$iv$iv$iv = 0;
            oldMap$iv = map$runtime_release;
            $i$a$SynchronizedSnapshotStateMap$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldMap$iv);
            builder = oldMap$iv.builder();
            i18 = 0;
            iterator = entrySet().iterator();
        }
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if ((Boolean)predicate.invoke((Map.Entry)next2).booleanValue() != 0) {
            }
            (Map)builder.remove(next2.getKey());
            removed = 1;
        }
        stateRecord = predicate;
        result$iv = it;
        build = builder.build();
        if (!Intrinsics.areEqual(build, oldMap$iv)) {
        } else {
            $i$f$removeIf$runtime_release = i6;
        }
        return removed;
    }

    public final boolean removeValue$runtime_release(V value) {
        int $i$a$LetSnapshotStateMap$removeValue$2;
        int key;
        Object element$iv;
        boolean it;
        int i;
        Object value2;
        key = 0;
        final Iterator iterator = (Iterable)entrySet().iterator();
        for (Object element$iv : iterator) {
            i = 0;
        }
        element$iv = 0;
        if ((Map.Entry)element$iv != null) {
            int i2 = 0;
            remove((Map.Entry)element$iv.getKey());
            $i$a$LetSnapshotStateMap$removeValue$2 = 1;
        } else {
            $i$a$LetSnapshotStateMap$removeValue$2 = 0;
        }
        return $i$a$LetSnapshotStateMap$removeValue$2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final int size() {
        return getSize();
    }

    public final Map<K, V> toMap() {
        return (Map)getReadable$runtime_release().getMap$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public String toString() {
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        int i = 0;
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SnapshotStateMap(value=").append((SnapshotStateMap.StateMapStateRecord)SnapshotKt.current((StateRecord)(SnapshotStateMap.StateMapStateRecord)firstStateRecord).getMap$runtime_release()).append(")@").append(hashCode()).toString();
    }

    public final Collection<V> values() {
        return getValues();
    }
}
