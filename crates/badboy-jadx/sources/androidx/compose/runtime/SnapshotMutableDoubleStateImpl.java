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
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u00020\u00040\u0003:\u0001!B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\u001b\u001a\u00020\u000c2\u0006\u0010\u001c\u001a\u00020\u000c2\u0006\u0010\u001d\u001a\u00020\u000cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u000cH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016R$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\"", d2 = {"Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableDoubleState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "(D)V", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "next", "Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl$DoubleStateStateRecord;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Double;", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "DoubleStateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SnapshotMutableDoubleStateImpl extends StateObjectImpl implements androidx.compose.runtime.MutableDoubleState, SnapshotMutableState<Double> {

    public static final int $stable;
    private androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord next;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0008\u0010\n\u001a\u00020\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl$DoubleStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", "", "(D)V", "getValue", "()D", "setValue", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DoubleStateStateRecord extends StateRecord {

        private double value;
        public DoubleStateStateRecord(double value) {
            super();
            this.value = value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
            this.value = obj.value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            SnapshotMutableDoubleStateImpl.DoubleStateStateRecord doubleStateStateRecord = new SnapshotMutableDoubleStateImpl.DoubleStateStateRecord(this.value, obj2);
            return (StateRecord)doubleStateStateRecord;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final double getValue() {
            return this.value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setValue(double <set-?>) {
            this.value = <set-?>;
        }
    }
    static {
    }

    public SnapshotMutableDoubleStateImpl(double value) {
        boolean doubleStateStateRecord;
        androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord num;
        int i;
        int i2;
        super();
        SnapshotMutableDoubleStateImpl.DoubleStateStateRecord doubleStateStateRecord2 = new SnapshotMutableDoubleStateImpl.DoubleStateStateRecord(value, obj9);
        final int i3 = 0;
        if (Snapshot.Companion.isInSnapshot()) {
            doubleStateStateRecord = new SnapshotMutableDoubleStateImpl.DoubleStateStateRecord(value, obj9);
            i = 0;
            doubleStateStateRecord.setSnapshotId$runtime_release(1);
            doubleStateStateRecord2.setNext$runtime_release((StateRecord)doubleStateStateRecord);
        }
        this.next = doubleStateStateRecord2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public Double component1() {
        return Double.valueOf(getDoubleValue());
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public Object component1() {
        return component1();
    }

    public Function1<Double, Unit> component2() {
        SnapshotMutableDoubleStateImpl.component2.1 anon = new SnapshotMutableDoubleStateImpl.component2.1(this);
        return (Function1)anon;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public double getDoubleValue() {
        return (SnapshotMutableDoubleStateImpl.DoubleStateStateRecord)SnapshotKt.readable((StateRecord)this.next, (StateObject)this).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord getFirstStateRecord() {
        return (StateRecord)this.next;
    }

    public androidx.compose.runtime.SnapshotMutationPolicy<Double> getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord mergeRecords(StateRecord previous, StateRecord current, StateRecord applied) {
        int i2;
        int i;
        String str = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord";
        Intrinsics.checkNotNull(current, str);
        Intrinsics.checkNotNull(applied, str);
        final int i3 = 0;
        i = Double.compare(value, value2) == 0 ? 1 : 0;
        i2 = i != 0 ? current : 0;
        return i2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        this.next = (SnapshotMutableDoubleStateImpl.DoubleStateStateRecord)value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public void setDoubleValue(double value) {
        double value2;
        int i3;
        int snapshot$iv;
        int i2;
        Object obj;
        int i4;
        Throwable th;
        Unit $this$_set_doubleValue__u24lambda_u243_u24lambda_u242;
        int i;
        final int i5 = 0;
        final StateRecord current = SnapshotKt.current((StateRecord)this.next);
        final int i6 = 0;
        snapshot$iv = 0;
        i2 = Double.compare(value2, value) == 0 ? 1 : 0;
        if (i2 == 0) {
            i3 = 0;
            int i7 = 0;
            Snapshot snapshot$iv2 = SnapshotKt.getSnapshotInitializer();
            int i8 = 0;
            Object lock = SnapshotKt.getLock();
            i4 = 0;
            th = 0;
            snapshot$iv = current2;
            i = 0;
            (SnapshotMutableDoubleStateImpl.DoubleStateStateRecord)SnapshotKt.overwritableRecord((StateRecord)this.next, (StateObject)this, snapshot$iv, (StateRecord)current).setValue(value);
            $this$_set_doubleValue__u24lambda_u243_u24lambda_u242 = Unit.INSTANCE;
            i2 = 0;
            SnapshotKt.notifyWrite(snapshot$iv, (StateObject)this);
            synchronized (lock) {
                i3 = 0;
                i7 = 0;
                snapshot$iv2 = SnapshotKt.getSnapshotInitializer();
                i8 = 0;
                lock = SnapshotKt.getLock();
                i4 = 0;
                th = 0;
                snapshot$iv = current2;
                i = 0;
                (SnapshotMutableDoubleStateImpl.DoubleStateStateRecord)SnapshotKt.overwritableRecord((StateRecord)this.next, (StateObject)this, snapshot$iv, (StateRecord)current).setValue(value);
                $this$_set_doubleValue__u24lambda_u243_u24lambda_u242 = Unit.INSTANCE;
                i2 = 0;
                SnapshotKt.notifyWrite(snapshot$iv, (StateObject)this);
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public String toString() {
        final int i = 0;
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MutableDoubleState(value=").append((SnapshotMutableDoubleStateImpl.DoubleStateStateRecord)SnapshotKt.current((StateRecord)this.next).getValue()).append(")@").append(hashCode()).toString();
    }
}
