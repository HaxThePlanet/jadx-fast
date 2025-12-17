package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u00020\u00040\u0003:\u0001%B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cH\u0096\u0002J\"\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u0008\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0011\u0010\u000b\"\u0004\u0008\u0012\u0010\u0006R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006&", d2 = {"Landroidx/compose/runtime/SnapshotMutableIntStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "(I)V", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()I", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "intValue", "getIntValue", "setIntValue", "next", "Landroidx/compose/runtime/SnapshotMutableIntStateImpl$IntStateStateRecord;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Integer;", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "IntStateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SnapshotMutableIntStateImpl extends StateObjectImpl implements androidx.compose.runtime.MutableIntState, SnapshotMutableState<Integer> {

    public static final int $stable;
    private androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord next;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0008\u0010\n\u001a\u00020\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/SnapshotMutableIntStateImpl$IntStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", "", "(I)V", "getValue", "()I", "setValue", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class IntStateStateRecord extends StateRecord {

        private int value;
        public IntStateStateRecord(int value) {
            super();
            this.value = value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
            this.value = obj.value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            SnapshotMutableIntStateImpl.IntStateStateRecord intStateStateRecord = new SnapshotMutableIntStateImpl.IntStateStateRecord(this.value);
            return (StateRecord)intStateStateRecord;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getValue() {
            return this.value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setValue(int <set-?>) {
            this.value = <set-?>;
        }
    }
    static {
    }

    public SnapshotMutableIntStateImpl(int value) {
        boolean intStateStateRecord2;
        androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord intStateStateRecord;
        int i;
        int i2;
        super();
        SnapshotMutableIntStateImpl.IntStateStateRecord intStateStateRecord3 = new SnapshotMutableIntStateImpl.IntStateStateRecord(value);
        final int i3 = 0;
        if (Snapshot.Companion.isInSnapshot()) {
            intStateStateRecord2 = new SnapshotMutableIntStateImpl.IntStateStateRecord(value);
            i = 0;
            intStateStateRecord2.setSnapshotId$runtime_release(1);
            intStateStateRecord3.setNext$runtime_release((StateRecord)intStateStateRecord2);
        }
        this.next = intStateStateRecord3;
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public Integer component1() {
        return Integer.valueOf(getIntValue());
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public Object component1() {
        return component1();
    }

    public Function1<Integer, Unit> component2() {
        SnapshotMutableIntStateImpl.component2.1 anon = new SnapshotMutableIntStateImpl.component2.1(this);
        return (Function1)anon;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public final int getDebuggerDisplayValue() {
        final int i = 0;
        final int i2 = 0;
        return (SnapshotMutableIntStateImpl.IntStateStateRecord)SnapshotKt.current((StateRecord)this.next).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord getFirstStateRecord() {
        return (StateRecord)this.next;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public int getIntValue() {
        return (SnapshotMutableIntStateImpl.IntStateStateRecord)SnapshotKt.readable((StateRecord)this.next, (StateObject)this).getValue();
    }

    public androidx.compose.runtime.SnapshotMutationPolicy<Integer> getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord mergeRecords(StateRecord previous, StateRecord current, StateRecord applied) {
        Object obj;
        String str = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord";
        Intrinsics.checkNotNull(current, str);
        Intrinsics.checkNotNull(applied, str);
        obj = (SnapshotMutableIntStateImpl.IntStateStateRecord)current.getValue() == (SnapshotMutableIntStateImpl.IntStateStateRecord)applied.getValue() ? current : 0;
        return obj;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.next = (SnapshotMutableIntStateImpl.IntStateStateRecord)value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public void setIntValue(int value) {
        int value2;
        int i;
        Snapshot snapshot$iv;
        int i4;
        Object obj;
        int i3;
        Throwable th;
        Unit $this$_set_intValue__u24lambda_u243_u24lambda_u242;
        int i2;
        final int i5 = 0;
        final StateRecord current = SnapshotKt.current((StateRecord)this.next);
        final int i6 = 0;
        if ((SnapshotMutableIntStateImpl.IntStateStateRecord)current.getValue() != value) {
            i = 0;
            int i7 = 0;
            Snapshot snapshot$iv2 = SnapshotKt.getSnapshotInitializer();
            int i8 = 0;
            Object lock = SnapshotKt.getLock();
            i3 = 0;
            th = 0;
            snapshot$iv = current2;
            i2 = 0;
            (SnapshotMutableIntStateImpl.IntStateStateRecord)SnapshotKt.overwritableRecord((StateRecord)this.next, (StateObject)this, snapshot$iv, (StateRecord)current).setValue(value);
            $this$_set_intValue__u24lambda_u243_u24lambda_u242 = Unit.INSTANCE;
            i4 = 0;
            SnapshotKt.notifyWrite(snapshot$iv, (StateObject)this);
            synchronized (lock) {
                i = 0;
                i7 = 0;
                snapshot$iv2 = SnapshotKt.getSnapshotInitializer();
                i8 = 0;
                lock = SnapshotKt.getLock();
                i3 = 0;
                th = 0;
                snapshot$iv = current2;
                i2 = 0;
                (SnapshotMutableIntStateImpl.IntStateStateRecord)SnapshotKt.overwritableRecord((StateRecord)this.next, (StateObject)this, snapshot$iv, (StateRecord)current).setValue(value);
                $this$_set_intValue__u24lambda_u243_u24lambda_u242 = Unit.INSTANCE;
                i4 = 0;
                SnapshotKt.notifyWrite(snapshot$iv, (StateObject)this);
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public String toString() {
        final int i = 0;
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MutableIntState(value=").append((SnapshotMutableIntStateImpl.IntStateStateRecord)SnapshotKt.current((StateRecord)this.next).getValue()).append(")@").append(hashCode()).toString();
    }
}
