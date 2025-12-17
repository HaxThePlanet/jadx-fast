package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\u0016\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001SB\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00172\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0008\u0010&\u001a\u00020 H\u0016J3\u0010'\u001a\u00020\u001d2\u0008\u0008\u0002\u0010(\u001a\u00020\u001d2\u001e\u0010)\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000+\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000+0*H\u0082\u0008J\u0016\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0016\u0010-\u001a\u00020\u001d2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010.\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0017H\u0096\u0002¢\u0006\u0002\u0010/J\u0015\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0008\u00102\u001a\u00020\u001dH\u0016J\u000f\u00103\u001a\u0008\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u0000072\u0006\u0010!\u001a\u00020\u0017H\u0016J.\u00108\u001a\u0002H9\"\u0004\u0008\u0001\u001092\u0018\u0010)\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u0002H90*H\u0082\u0008¢\u0006\u0002\u0010:J\"\u0010;\u001a\u00020\u001d2\u0018\u0010)\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u001d0*H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\rH\u0016J\u0015\u0010>\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010?\u001a\u00020\u001d2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0015\u0010@\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010/J\u0016\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017J\u0016\u0010D\u001a\u00020\u001d2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J+\u0010E\u001a\u00020\u00172\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008HJ\u001e\u0010I\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017H\u0016J\u000c\u0010L\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008J\u0008\u0010M\u001a\u00020NH\u0016J3\u0010O\u001a\u00020 2\u0008\u0008\u0002\u0010(\u001a\u00020\u001d2\u001e\u0010)\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000+\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000+0*H\u0082\u0008J3\u0010P\u001a\u0002H9\"\u0004\u0008\u0001\u001092\u001d\u0010)\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u0002H90*¢\u0006\u0002\u0008QH\u0082\u0008¢\u0006\u0002\u0010:J3\u0010R\u001a\u0002H9\"\u0004\u0008\u0001\u001092\u001d\u0010)\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u0002H90*¢\u0006\u0002\u0008QH\u0082\u0008¢\u0006\u0002\u0010:R \u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00088AX\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00128@X\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0019¨\u0006T", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "", "getSize", "()I", "structure", "getStructure$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "structural", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "toString", "", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateList<T>  implements androidx.compose.runtime.snapshots.StateObject, List<T>, RandomAccess, KMutableList {

    public static final int $stable;
    private androidx.compose.runtime.snapshots.StateRecord firstStateRecord;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u00020\u0002B\u0015\u0008\u0000\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0008\u0010\u0015\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u000c\"\u0004\u0008\u0011\u0010\u000e¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "structuralChange", "getStructuralChange$runtime_release", "setStructuralChange$runtime_release", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StateListStateRecord extends androidx.compose.runtime.snapshots.StateRecord {

        public static final int $stable = 8;
        private PersistentList<? extends T> list;
        private int modification;
        private int structuralChange;
        static {
            final int i = 8;
        }

        public StateListStateRecord(PersistentList<? extends T> list) {
            super();
            this.list = list;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(androidx.compose.runtime.snapshots.StateRecord value) {
            final Object obj = SnapshotStateListKt.access$getSync$p();
            final int i = 0;
            int i2 = 0;
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
            this.list = obj2.list;
            this.modification = obj3.modification;
            this.structuralChange = obj4.structuralChange;
            Unit $i$a$SynchronizedSnapshotStateList$StateListStateRecord$assign$1 = Unit.INSTANCE;
            return;
            synchronized (obj) {
                obj = SnapshotStateListKt.access$getSync$p();
                i = 0;
                i2 = 0;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.list = obj2.list;
                this.modification = obj3.modification;
                this.structuralChange = obj4.structuralChange;
                $i$a$SynchronizedSnapshotStateList$StateListStateRecord$assign$1 = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public androidx.compose.runtime.snapshots.StateRecord create() {
            SnapshotStateList.StateListStateRecord stateListStateRecord = new SnapshotStateList.StateListStateRecord(this.list);
            return (StateRecord)stateListStateRecord;
        }

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getModification$runtime_release() {
            return this.modification;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getStructuralChange$runtime_release() {
            return this.structuralChange;
        }

        public final void setList$runtime_release(PersistentList<? extends T> <set-?>) {
            this.list = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setModification$runtime_release(int <set-?>) {
            this.modification = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setStructuralChange$runtime_release(int <set-?>) {
            this.structuralChange = <set-?>;
        }
    }
    static {
    }

    public SnapshotStateList() {
        boolean stateListStateRecord;
        androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord list;
        int i;
        int i2;
        super();
        final PersistentList persistentListOf = ExtensionsKt.persistentListOf();
        final int i3 = 0;
        SnapshotStateList.StateListStateRecord stateListStateRecord2 = new SnapshotStateList.StateListStateRecord(persistentListOf);
        final int i4 = 0;
        if (Snapshot.Companion.isInSnapshot()) {
            stateListStateRecord = new SnapshotStateList.StateListStateRecord(persistentListOf);
            i = 0;
            stateListStateRecord.setSnapshotId$runtime_release(1);
            stateListStateRecord2.setNext$runtime_release((StateRecord)stateListStateRecord);
        }
        this.firstStateRecord = (StateRecord)stateListStateRecord2;
    }

    private final boolean conditionalUpdate(boolean structural, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> block) {
        Throwable th;
        int modification$runtime_release;
        int i;
        androidx.compose.runtime.snapshots.StateRecord $i$f$conditionalUpdate3;
        int i8;
        androidx.compose.runtime.snapshots.StateRecord $i$f$conditionalUpdate;
        PersistentList oldList;
        int currentModification;
        Object obj;
        androidx.compose.runtime.snapshots.StateObject stateObject2;
        Object obj5;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i9;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv;
        int i3;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        int i10;
        int i4;
        androidx.compose.runtime.snapshots.StateRecord structuralChange$runtime_release;
        int i5;
        Object obj2;
        int i11;
        int i6;
        androidx.compose.runtime.snapshots.StateRecord $i$f$conditionalUpdate2;
        int i7;
        i8 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = this;
        final int i16 = 0;
        final int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        Object obj4 = SnapshotStateListKt.access$getSync$p();
        stateObject2 = 0;
        int i12 = 0;
        i2 = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i9 = 0;
        snapshot$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        i3 = 0;
        oldList = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1 = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList);
        obj = invoke;
        synchronized (obj4) {
            i18 = 0;
            i19 = 0;
            obj4 = SnapshotStateListKt.access$getSync$p();
            stateObject2 = 0;
            i12 = 0;
            i2 = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i9 = 0;
            snapshot$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            i3 = 0;
            oldList = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1 = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList);
            obj = invoke;
        }
        i = 0;
        $i$f$conditionalUpdate2 = i8;
        return i;
    }

    static boolean conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList $this, boolean structural, Function1 block, int i4, Object object5) {
        int i8;
        int i7;
        int i6;
        int modification$runtime_release;
        int structural2;
        int structural4;
        androidx.compose.runtime.snapshots.StateRecord structural3;
        PersistentList oldList;
        int currentModification;
        Object invoke;
        androidx.compose.runtime.snapshots.StateObject equal;
        Object obj4;
        int list$runtime_release;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int firstStateRecord2;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv;
        int current;
        Object lock;
        int i3;
        int i;
        int i2;
        Object obj;
        int i5;
        int structural5;
        int obj24;
        int obj26;
        int obj27;
        i8 = 1;
        structural4 = i4 & 1 != 0 ? 1 : structural;
        final int i12 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject3 = $this;
        final int i13 = 0;
        final int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        int i17 = 0;
        int i18 = 0;
        firstStateRecord = 0;
        firstStateRecord2 = stateObject3.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        snapshot$iv$iv = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord2);
        lock = 0;
        oldList = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1 = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList);
        invoke = block.invoke(oldList);
        synchronized (obj3) {
            i15 = 0;
            i16 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            i17 = 0;
            i18 = 0;
            firstStateRecord = 0;
            firstStateRecord2 = stateObject3.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            snapshot$iv$iv = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord2);
            lock = 0;
            oldList = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1 = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList);
            invoke = block.invoke(oldList);
        }
        i7 = 0;
        structural5 = structural4;
        return i7;
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public static void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> block) {
        int equal;
        int modification$runtime_release;
        int $i$f$mutate3;
        int i;
        androidx.compose.runtime.snapshots.StateRecord $i$f$mutate;
        int result;
        PersistentList oldList;
        int currentModification;
        PersistentList.Builder builder;
        PersistentList build;
        Object obj4;
        int i2;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int current;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i3;
        int i4;
        int $this$mutate_u24lambda_u2423;
        int i5;
        Object obj;
        int i7;
        int i6;
        int $i$f$mutate2;
        i = 0;
        result = equal;
        int i12 = 0;
        int i13 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        int i14 = 0;
        int i8 = 0;
        i2 = 0;
        firstStateRecord = this.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        stateRecord = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        snapshot$iv$iv = 0;
        oldList = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$mutate$1 = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList);
        builder = oldList.builder();
        build = builder.build();
        synchronized (obj3) {
            i12 = 0;
            i13 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            i14 = 0;
            i8 = 0;
            i2 = 0;
            firstStateRecord = this.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            stateRecord = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            snapshot$iv$iv = 0;
            oldList = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$mutate$1 = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList);
            builder = oldList.builder();
            build = builder.build();
        }
        i2 = this;
        firstStateRecord = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = i2.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        current = 0;
        int i9 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i16 = 0;
        lock = SnapshotKt.getLock();
        i3 = 0;
        i4 = 0;
        snapshot$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        i5 = 0;
        obj = obj2;
        i7 = 0;
        i6 = i10;
        synchronized (lock) {
            $i$f$mutate2 = i;
            $i$f$mutate = stateRecord2;
            $i$f$mutate.setList$runtime_release(build);
            $this$mutate_u24lambda_u2423 = 1;
            $i$f$mutate.setModification$runtime_release(modification$runtime_release2++);
            $i$f$mutate.setStructuralChange$runtime_release(structuralChange$runtime_release++);
            equal = $this$mutate_u24lambda_u2423;
            i = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv, (StateObject)i2);
            if ($this$mutate_u24lambda_u2423 != 0) {
            } else {
            }
            return block.invoke(builder);
        }
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> block) {
        int equal;
        int modification$runtime_release;
        int this_$iv2;
        int i;
        androidx.compose.runtime.snapshots.StateRecord this_$iv;
        int result$iv;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList.Builder builder;
        PersistentList build;
        Object obj4;
        int i2;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int current;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i3;
        int i4;
        int $this$mutate_u24lambda_u2423$iv;
        int i5;
        Object obj;
        int i6;
        int i7;
        int this_$iv3;
        i = this;
        final int i13 = 0;
        result$iv = equal;
        int i14 = 0;
        int i15 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        int i16 = 0;
        int i8 = 0;
        i2 = 0;
        firstStateRecord = i.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        stateRecord = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        snapshot$iv$iv$iv = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        builder = oldList$iv.builder();
        build = builder.build();
        synchronized (obj3) {
            i14 = 0;
            i15 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            i16 = 0;
            i8 = 0;
            i2 = 0;
            firstStateRecord = i.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            stateRecord = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            snapshot$iv$iv$iv = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            builder = oldList$iv.builder();
            build = builder.build();
        }
        i2 = i;
        firstStateRecord = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = i2.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        current = 0;
        int i9 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i18 = 0;
        lock = SnapshotKt.getLock();
        i3 = 0;
        i4 = 0;
        snapshot$iv$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        i5 = 0;
        obj = obj2;
        i6 = 0;
        i7 = i10;
        synchronized (lock) {
            this_$iv3 = i;
            this_$iv = stateRecord2;
            this_$iv.setList$runtime_release(build);
            $this$mutate_u24lambda_u2423$iv = 1;
            this_$iv.setModification$runtime_release(modification$runtime_release2++);
            this_$iv.setStructuralChange$runtime_release(structuralChange$runtime_release++);
            equal = $this$mutate_u24lambda_u2423$iv;
            i = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)i2);
            if ($this$mutate_u24lambda_u2423$iv != 0) {
            } else {
            }
            return (Boolean)block.invoke(builder).booleanValue();
        }
    }

    private final void update(boolean structural, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> block) {
        Object th;
        int i;
        int modification$runtime_release;
        int i3;
        int $i$f$update3;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord $i$f$update2;
        PersistentList oldList$iv;
        int currentModification$iv;
        Object obj;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object obj5;
        int i7;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i4;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        int i8;
        Object lock;
        int i11;
        int i5;
        int i12;
        androidx.compose.runtime.snapshots.StateRecord structuralChange$runtime_release;
        int i6;
        Object obj2;
        int i9;
        int i13;
        int $i$f$update;
        int i10;
        i2 = 0;
        final int i18 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = stateObject3;
        final int i19 = 0;
        final int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        Object obj4 = SnapshotStateListKt.access$getSync$p();
        stateObject = 0;
        int i14 = 0;
        i7 = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i4 = 0;
        snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        i8 = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        obj = invoke;
        synchronized (obj4) {
            i21 = 0;
            i22 = 0;
            obj4 = SnapshotStateListKt.access$getSync$p();
            stateObject = 0;
            i14 = 0;
            i7 = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i4 = 0;
            snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            i8 = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            obj = invoke;
        }
        i3 = 0;
        $i$f$update = i2;
    }

    static void update$default(androidx.compose.runtime.snapshots.SnapshotStateList $this, boolean structural, Function1 block, int i4, Object object5) {
        int i3;
        int i8;
        int i11;
        int modification$runtime_release;
        int structural2;
        int structural3;
        int $i$f$update3;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord $i$f$update2;
        PersistentList oldList$iv;
        int currentModification$iv;
        Object obj2;
        int i5;
        Object obj5;
        int i6;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int firstStateRecord;
        int current;
        int i9;
        Object lock;
        int i7;
        int i10;
        Object obj;
        int i12;
        int i;
        int $i$f$update;
        int obj26;
        int obj28;
        int obj29;
        i3 = 1;
        structural3 = i4 & 1 != 0 ? 1 : structural;
        i2 = 0;
        final int i19 = 0;
        final int i20 = i18;
        final int i21 = 0;
        final int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        Object obj4 = SnapshotStateListKt.access$getSync$p();
        i5 = 0;
        int i25 = 0;
        stateRecord = 0;
        firstStateRecord = i20.getFirstStateRecord();
        obj29 = i3;
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i13 = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        i9 = 0;
        oldList$iv = list$runtime_release;
        Unit iNSTANCE = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        obj2 = invoke;
        synchronized (obj4) {
            i23 = 0;
            i24 = 0;
            obj4 = SnapshotStateListKt.access$getSync$p();
            i5 = 0;
            i25 = 0;
            stateRecord = 0;
            firstStateRecord = i20.getFirstStateRecord();
            obj29 = i3;
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i13 = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            i9 = 0;
            oldList$iv = list$runtime_release;
            iNSTANCE = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            obj2 = invoke;
        }
        i8 = 0;
        obj28 = structural3;
        $i$f$update = i2;
    }

    private final <R> R withCurrent(Function1<? super androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T>, ? extends R> block) {
        final int i = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i2 = 0;
        return block.invoke(SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord));
    }

    private final <R> R writable(Function1<? super androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T>, ? extends R> block) {
        final int i = 0;
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i2 = 0;
        int i3 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv = SnapshotKt.getSnapshotInitializer();
        int i4 = 0;
        Object lock = SnapshotKt.getLock();
        int i6 = 0;
        final int i7 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv2 = current;
        Object invoke = block.invoke(SnapshotKt.writableRecord((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord, (StateObject)this, snapshot$iv2));
        Object $i$f$sync = invoke;
        int i5 = 0;
        SnapshotKt.notifyWrite(snapshot$iv2, (StateObject)this);
        return invoke;
        synchronized (lock) {
            i = 0;
            firstStateRecord = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i2 = 0;
            i3 = 0;
            snapshot$iv = SnapshotKt.getSnapshotInitializer();
            i4 = 0;
            lock = SnapshotKt.getLock();
            i6 = 0;
            i7 = 0;
            snapshot$iv2 = current;
            invoke = block.invoke(SnapshotKt.writableRecord((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord, (StateObject)this, snapshot$iv2));
            $i$f$sync = invoke;
            i5 = 0;
            SnapshotKt.notifyWrite(snapshot$iv2, (StateObject)this);
            return invoke;
        }
    }

    public void add(int index, T element) {
        Object it$iv$iv$iv$iv;
        int modification$runtime_release;
        int i5;
        int structural$iv;
        int structural$iv2;
        int $i$f$update2;
        int i4;
        androidx.compose.runtime.snapshots.StateRecord $i$f$update3;
        PersistentList oldList$iv$iv;
        int currentModification$iv$iv;
        PersistentList $i$a$Update$defaultSnapshotStateList$add$2;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        int i6;
        Object obj2;
        int firstStateRecord;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int current;
        int $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv;
        int i7;
        Object lock;
        int i8;
        int i9;
        int i3;
        int i10;
        Object obj;
        int i;
        int i2;
        int $i$f$update;
        structural$iv2 = 1;
        i4 = 0;
        final int i16 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = stateObject3;
        final int i17 = 0;
        final int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        Object obj4 = SnapshotStateListKt.access$getSync$p();
        stateObject = 0;
        int i11 = 0;
        int i22 = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        stateRecord = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv = 0;
        oldList$iv$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv$iv);
        int i21 = 0;
        $i$a$Update$defaultSnapshotStateList$add$2 = it;
        synchronized (obj4) {
            i19 = 0;
            i20 = 0;
            obj4 = SnapshotStateListKt.access$getSync$p();
            stateObject = 0;
            i11 = 0;
            i22 = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            stateRecord = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv = 0;
            oldList$iv$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv$iv);
            i21 = 0;
            $i$a$Update$defaultSnapshotStateList$add$2 = it;
        }
        i5 = 0;
        i3 = structural$iv2;
        $i$f$update = i4;
    }

    public boolean add(T element) {
        Throwable th;
        int modification$runtime_release;
        int i6;
        int structural$iv;
        int i5;
        androidx.compose.runtime.snapshots.StateRecord structural$iv3;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList $i$a$ConditionalUpdate$defaultSnapshotStateList$add$1;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object obj2;
        int i8;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i3;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject2;
        Object lock;
        int i9;
        int i;
        int $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv;
        int i2;
        Object obj;
        int i4;
        int i7;
        int structural$iv2;
        i5 = 1;
        final int i14 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = this;
        final int i15 = 0;
        final int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        Object obj4 = SnapshotStateListKt.access$getSync$p();
        stateObject = 0;
        int i10 = 0;
        i8 = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i3 = 0;
        snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        stateObject2 = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        int i19 = 0;
        $i$a$ConditionalUpdate$defaultSnapshotStateList$add$1 = it;
        synchronized (obj4) {
            i17 = 0;
            i18 = 0;
            obj4 = SnapshotStateListKt.access$getSync$p();
            stateObject = 0;
            i10 = 0;
            i8 = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i3 = 0;
            snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            stateObject2 = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            i19 = 0;
            $i$a$ConditionalUpdate$defaultSnapshotStateList$add$1 = it;
        }
        i6 = 0;
        structural$iv2 = i5;
        return i6;
    }

    public boolean addAll(int index, Collection<? extends T> elements) {
        SnapshotStateList.addAll.1 anon = new SnapshotStateList.addAll.1(index, elements);
        return mutateBoolean((Function1)anon);
    }

    public boolean addAll(Collection<? extends T> elements) {
        Throwable th;
        int modification$runtime_release;
        int i3;
        int structural$iv;
        int i5;
        androidx.compose.runtime.snapshots.StateRecord structural$iv2;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList $i$a$ConditionalUpdate$defaultSnapshotStateList$addAll$2;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Collection collection;
        int i7;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i4;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject2;
        Object lock;
        int i2;
        int i8;
        int $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv;
        int i6;
        Object obj;
        int i;
        int i9;
        int structural$iv3;
        i5 = 1;
        final int i14 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = this;
        final int i15 = 0;
        final int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        stateObject = 0;
        int i10 = 0;
        i7 = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i4 = 0;
        snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        stateObject2 = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        int i19 = 0;
        $i$a$ConditionalUpdate$defaultSnapshotStateList$addAll$2 = it;
        synchronized (obj3) {
            i17 = 0;
            i18 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            stateObject = 0;
            i10 = 0;
            i7 = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i4 = 0;
            snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            stateObject2 = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            i19 = 0;
            $i$a$ConditionalUpdate$defaultSnapshotStateList$addAll$2 = it;
        }
        i3 = 0;
        structural$iv3 = i5;
        return i3;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void clear() {
        final androidx.compose.runtime.snapshots.StateObject stateObject2 = this;
        final int i4 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = stateObject2.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        final int i5 = 0;
        int i = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i6 = 0;
        final Object lock = SnapshotKt.getLock();
        final int i7 = 0;
        final int i8 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv = current;
        final androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        final int i9 = 0;
        final Object obj2 = obj;
        final int i10 = 0;
        int i2 = 0;
        stateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
        stateRecord2.setModification$runtime_release(modification$runtime_release++);
        stateRecord2.setStructuralChange$runtime_release(structuralChange$runtime_release + 1);
        int i3 = 0;
        SnapshotKt.notifyWrite(snapshot$iv$iv, (StateObject)stateObject2);
        return;
        synchronized (lock) {
            stateObject2 = this;
            i4 = 0;
            firstStateRecord = stateObject2.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i5 = 0;
            i = 0;
            snapshotInitializer = SnapshotKt.getSnapshotInitializer();
            i6 = 0;
            lock = SnapshotKt.getLock();
            i7 = 0;
            i8 = 0;
            snapshot$iv$iv = current;
            stateRecord2 = writableRecord;
            i9 = 0;
            obj2 = obj;
            i10 = 0;
            i2 = 0;
            stateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
            stateRecord2.setModification$runtime_release(modification$runtime_release++);
            stateRecord2.setStructuralChange$runtime_release(structuralChange$runtime_release + 1);
            i3 = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv, (StateObject)stateObject2);
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    public T get(int index) {
        return getReadable$runtime_release().getList$runtime_release().get(index);
    }

    public final List<T> getDebuggerDisplayValue() {
        final int i = 0;
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = this.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i2 = 0;
        final int i3 = 0;
        return (List)(SnapshotStateList.StateListStateRecord)SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public androidx.compose.runtime.snapshots.StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T> getReadable$runtime_release() {
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (SnapshotStateList.StateListStateRecord)SnapshotKt.readable((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord, (StateObject)this);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final int getStructure$runtime_release() {
        final int i = 0;
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = this.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i2 = 0;
        final int i3 = 0;
        return (SnapshotStateList.StateListStateRecord)SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord).getStructuralChange$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    public Iterator<T> iterator() {
        return (Iterator)listIterator();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    public ListIterator<T> listIterator() {
        StateListIterator stateListIterator = new StateListIterator(this, 0);
        return (ListIterator)stateListIterator;
    }

    public ListIterator<T> listIterator(int index) {
        StateListIterator stateListIterator = new StateListIterator(this, index);
        return (ListIterator)stateListIterator;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(androidx.compose.runtime.snapshots.StateRecord value) {
        value.setNext$runtime_release(getFirstStateRecord());
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (StateRecord)(SnapshotStateList.StateListStateRecord)value;
    }

    public final T remove(int index) {
        return removeAt(index);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public boolean remove(Object element) {
        Throwable th;
        int modification$runtime_release;
        int i3;
        int structural$iv2;
        int i6;
        androidx.compose.runtime.snapshots.StateRecord structural$iv;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList $i$a$ConditionalUpdate$defaultSnapshotStateList$remove$1;
        androidx.compose.runtime.snapshots.StateObject stateObject2;
        Object obj2;
        int i;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i5;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i7;
        int i2;
        int $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv;
        int i8;
        Object obj;
        int i4;
        int i9;
        int structural$iv3;
        i6 = 1;
        final int i14 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = this;
        final int i15 = 0;
        final int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        Object obj4 = SnapshotStateListKt.access$getSync$p();
        stateObject2 = 0;
        int i10 = 0;
        i = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i5 = 0;
        snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        stateObject = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        int i19 = 0;
        $i$a$ConditionalUpdate$defaultSnapshotStateList$remove$1 = it;
        synchronized (obj4) {
            i17 = 0;
            i18 = 0;
            obj4 = SnapshotStateListKt.access$getSync$p();
            stateObject2 = 0;
            i10 = 0;
            i = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i5 = 0;
            snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            stateObject = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            i19 = 0;
            $i$a$ConditionalUpdate$defaultSnapshotStateList$remove$1 = it;
        }
        i3 = 0;
        structural$iv3 = i6;
        return i3;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Throwable th;
        int modification$runtime_release;
        int i9;
        int structural$iv2;
        int i6;
        androidx.compose.runtime.snapshots.StateRecord structural$iv3;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList $i$a$ConditionalUpdate$defaultSnapshotStateList$removeAll$1;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Collection collection;
        int i5;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int i4;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject2;
        Object lock;
        int i;
        int i3;
        int $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv;
        int i7;
        Object obj;
        int i2;
        int i8;
        int structural$iv;
        i6 = 1;
        final int i14 = 0;
        final androidx.compose.runtime.snapshots.StateObject stateObject4 = this;
        final int i15 = 0;
        final int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        stateObject = 0;
        int i10 = 0;
        i5 = 0;
        firstStateRecord = (SnapshotStateList)stateObject4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i4 = 0;
        snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        stateObject2 = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        int i19 = 0;
        $i$a$ConditionalUpdate$defaultSnapshotStateList$removeAll$1 = it;
        synchronized (obj3) {
            i17 = 0;
            i18 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            stateObject = 0;
            i10 = 0;
            i5 = 0;
            firstStateRecord = stateObject4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i4 = 0;
            snapshot$iv$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            stateObject2 = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$conditionalUpdate$1$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            i19 = 0;
            $i$a$ConditionalUpdate$defaultSnapshotStateList$removeAll$1 = it;
        }
        i9 = 0;
        structural$iv = i6;
        return i9;
    }

    public T removeAt(int index) {
        Object obj2;
        int modification$runtime_release;
        int i10;
        Object newList$iv$iv;
        int $i$a$AlsoSnapshotStateList$removeAt$12;
        int $i$a$AlsoSnapshotStateList$removeAt$1;
        int structural$iv;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord structural$iv2;
        PersistentList oldList$iv$iv;
        int currentModification$iv$iv;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int i12;
        int i11;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2;
        int i3;
        Object obj4;
        Object obj;
        int $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv;
        int i;
        Object lock;
        int i4;
        int i8;
        int i6;
        int i7;
        Object obj3;
        int i9;
        int i5;
        int structural$iv3;
        newList$iv$iv = obj2;
        $i$a$AlsoSnapshotStateList$removeAt$1 = 0;
        i2 = 1;
        final int i19 = 0;
        final int i20 = 0;
        final androidx.compose.runtime.snapshots.StateRecord stateRecord4 = stateRecord3;
        final int i21 = 0;
        final int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        stateRecord = SnapshotStateListKt.access$getSync$p();
        i12 = 0;
        int i25 = 0;
        i3 = 0;
        obj4 = obj2;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = (SnapshotStateList)stateRecord4.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i17 = 0;
        $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        i = 0;
        oldList$iv$iv = list$runtime_release;
        Unit iNSTANCE = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv$iv);
        int i18 = 0;
        PersistentList $i$a$Update$defaultSnapshotStateList$removeAt$1$1 = it;
        synchronized (stateRecord) {
            i23 = 0;
            i24 = 0;
            stateRecord = SnapshotStateListKt.access$getSync$p();
            i12 = 0;
            i25 = 0;
            i3 = 0;
            obj4 = obj2;
            firstStateRecord = stateRecord4.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i17 = 0;
            $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            i = 0;
            oldList$iv$iv = list$runtime_release;
            iNSTANCE = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv$iv);
            i18 = 0;
            $i$a$Update$defaultSnapshotStateList$removeAt$1$1 = it;
        }
        i10 = 0;
        i6 = $i$a$AlsoSnapshotStateList$removeAt$1;
        structural$iv3 = i2;
        return obj4;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void removeRange(int fromIndex, int toIndex) {
        int equal;
        int modification$runtime_release;
        int this_$iv3;
        List list;
        androidx.compose.runtime.snapshots.StateRecord this_$iv;
        int result$iv;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList.Builder builder;
        PersistentList build;
        int i7;
        int i8;
        List subList;
        int i4;
        androidx.compose.runtime.snapshots.StateRecord current;
        int i6;
        androidx.compose.runtime.snapshots.Snapshot snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateObject stateObject;
        Object lock;
        int i9;
        int i5;
        int $this$mutate_u24lambda_u2423$iv;
        int i2;
        Object obj;
        int i;
        int i3;
        int this_$iv2;
        list = this;
        final int i14 = 0;
        result$iv = equal;
        int i15 = 0;
        int i16 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        int i17 = 0;
        int i10 = 0;
        int i19 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = list.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i4 = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord2);
        i6 = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        builder = oldList$iv.builder();
        int i18 = 0;
        (List)builder.subList(fromIndex, toIndex).clear();
        result$iv = it;
        build = builder.build();
        synchronized (obj3) {
            i15 = 0;
            i16 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            i17 = 0;
            i10 = 0;
            i19 = 0;
            firstStateRecord2 = list.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i4 = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord2);
            i6 = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            builder = oldList$iv.builder();
            i18 = 0;
            (List)builder.subList(fromIndex, toIndex).clear();
            result$iv = it;
            build = builder.build();
        }
        subList = list;
        i4 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = subList.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i6 = 0;
        int i11 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i20 = 0;
        lock = SnapshotKt.getLock();
        i9 = 0;
        i5 = 0;
        snapshot$iv$iv$iv = current2;
        androidx.compose.runtime.snapshots.StateRecord stateRecord = writableRecord;
        i2 = 0;
        obj = obj2;
        i = 0;
        i3 = i12;
        synchronized (lock) {
            this_$iv2 = list;
            this_$iv = stateRecord;
            this_$iv.setList$runtime_release(build);
            $this$mutate_u24lambda_u2423$iv = 1;
            this_$iv.setModification$runtime_release(modification$runtime_release2++);
            this_$iv.setStructuralChange$runtime_release(structuralChange$runtime_release++);
            equal = $this$mutate_u24lambda_u2423$iv;
            list = 0;
            SnapshotKt.notifyWrite(snapshot$iv$iv$iv, (StateObject)subList);
            if ($this$mutate_u24lambda_u2423$iv != 0) {
            } else {
            }
        }
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        SnapshotStateList.retainAll.1 anon = new SnapshotStateList.retainAll.1(elements);
        return mutateBoolean((Function1)anon);
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> elements, int start, int end) {
        int it$iv$iv$iv;
        int modification$runtime_release;
        int startSize;
        int startSize3;
        int this_$iv3;
        int i5;
        androidx.compose.runtime.snapshots.StateRecord this_$iv;
        int result$iv;
        PersistentList oldList$iv;
        int currentModification$iv;
        PersistentList.Builder builder;
        PersistentList build;
        int i2;
        int i;
        int subList;
        Collection collection;
        int current;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int i9;
        int $this$mutate_u24lambda_u2423$iv;
        int i7;
        Object lock;
        int i4;
        int i6;
        int startSize2;
        int i3;
        Object obj;
        int i10;
        int i8;
        int this_$iv2;
        startSize3 = size();
        i5 = this;
        final int i17 = 0;
        result$iv = it$iv$iv$iv;
        int i18 = 0;
        int i19 = 0;
        Object obj3 = SnapshotStateListKt.access$getSync$p();
        int i20 = 0;
        int i11 = 0;
        int i23 = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord2 = i5.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i24 = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord2);
        stateRecord = 0;
        oldList$iv = list$runtime_release;
        Unit $i$a$SynchronizedSnapshotStateList$mutate$1$iv = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv);
        builder = oldList$iv.builder();
        int i21 = 0;
        (List)builder.subList(start, end).retainAll(elements);
        result$iv = it;
        build = builder.build();
        synchronized (obj3) {
            i18 = 0;
            i19 = 0;
            obj3 = SnapshotStateListKt.access$getSync$p();
            i20 = 0;
            i11 = 0;
            i23 = 0;
            firstStateRecord2 = i5.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i24 = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord2);
            stateRecord = 0;
            oldList$iv = list$runtime_release;
            $i$a$SynchronizedSnapshotStateList$mutate$1$iv = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv);
            builder = oldList$iv.builder();
            i21 = 0;
            (List)builder.subList(start, end).retainAll(elements);
            result$iv = it;
            build = builder.build();
        }
        subList = i5;
        current = 0;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = subList.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        i9 = 0;
        int i12 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        int i25 = 0;
        lock = SnapshotKt.getLock();
        i4 = 0;
        i6 = 0;
        startSize3 = snapshot$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2 = writableRecord;
        i3 = 0;
        obj = obj2;
        i10 = 0;
        i8 = i13;
        synchronized (lock) {
            this_$iv2 = i5;
            this_$iv = stateRecord2;
            this_$iv.setList$runtime_release(build);
            $this$mutate_u24lambda_u2423$iv = 1;
            this_$iv.setModification$runtime_release(modification$runtime_release2++);
            this_$iv.setStructuralChange$runtime_release(structuralChange$runtime_release++);
            i5 = 0;
            i7 = i15;
            SnapshotKt.notifyWrite(startSize3, (StateObject)subList);
            if ($this$mutate_u24lambda_u2423$iv != 0) {
            } else {
            }
            return startSize2 - size;
        }
    }

    public T set(int index, T element) {
        Object obj3;
        int modification$runtime_release;
        int i6;
        Object newList$iv$iv;
        androidx.compose.runtime.snapshots.StateRecord $this$writable$iv$iv$iv$iv2;
        int i3;
        androidx.compose.runtime.snapshots.StateRecord $this$writable$iv$iv$iv$iv;
        androidx.compose.runtime.snapshots.StateRecord structural$iv;
        int structural$iv2;
        PersistentList oldList$iv$iv;
        int currentModification$iv$iv;
        Object obj5;
        int i11;
        int i7;
        int i9;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        Object obj;
        Object obj2;
        int current;
        androidx.compose.runtime.snapshots.StateRecord $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv;
        int i4;
        Object lock;
        int i;
        int i10;
        androidx.compose.runtime.snapshots.StateRecord stateRecord2;
        int i8;
        Object obj4;
        int i5;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord $this$writable$iv$iv$iv$iv3;
        newList$iv$iv = obj3;
        i3 = 0;
        structural$iv2 = 0;
        final int i18 = 0;
        final int i20 = 0;
        final int i21 = i19;
        final int i22 = 0;
        final int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        Object obj7 = SnapshotStateListKt.access$getSync$p();
        i11 = 0;
        int i26 = 0;
        int i27 = 0;
        obj = obj3;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord = (SnapshotStateList)i21.getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i15 = 0;
        current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
        $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv = 0;
        oldList$iv$iv = list$runtime_release;
        Unit iNSTANCE = Unit.INSTANCE;
        Intrinsics.checkNotNull(oldList$iv$iv);
        int i16 = 0;
        PersistentList $i$a$UpdateSnapshotStateList$set$1$1 = it;
        synchronized (obj7) {
            i24 = 0;
            i25 = 0;
            obj7 = SnapshotStateListKt.access$getSync$p();
            i11 = 0;
            i26 = 0;
            i27 = 0;
            obj = obj3;
            firstStateRecord = i21.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            i15 = 0;
            current = SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord);
            $this$conditionalUpdate_u24lambda_u2428_u24lambda_u2427$iv$iv = 0;
            oldList$iv$iv = list$runtime_release;
            iNSTANCE = Unit.INSTANCE;
            Intrinsics.checkNotNull(oldList$iv$iv);
            i16 = 0;
            $i$a$UpdateSnapshotStateList$set$1$1 = it;
        }
        i6 = 0;
        stateRecord = i3;
        stateRecord2 = structural$iv2;
        return obj;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final int size() {
        return getSize();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        int i;
        int $i$a$RequirePreconditionSnapshotStateList$subList$1;
        int i2 = 0;
        if (fromIndex >= 0 && fromIndex <= toIndex) {
            $i$a$RequirePreconditionSnapshotStateList$subList$1 = fromIndex <= toIndex ? i : i2;
        } else {
        }
        if ($i$a$RequirePreconditionSnapshotStateList$subList$1 != 0 && toIndex <= size()) {
            if (toIndex <= size()) {
            } else {
                i = i2;
            }
        } else {
        }
        int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        SubList value$iv = new SubList(this, fromIndex, toIndex);
        return (List)value$iv;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }

    public final List<T> toList() {
        return (List)getReadable$runtime_release().getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public String toString() {
        final androidx.compose.runtime.snapshots.StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        int i = 0;
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SnapshotStateList(value=").append((SnapshotStateList.StateListStateRecord)SnapshotKt.current((StateRecord)(SnapshotStateList.StateListStateRecord)firstStateRecord).getList$runtime_release()).append(")@").append(hashCode()).toString();
    }
}
