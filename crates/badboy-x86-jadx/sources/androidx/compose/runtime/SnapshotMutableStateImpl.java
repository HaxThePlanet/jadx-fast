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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001$B\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000cJ\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0\u001bH\u0096\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u000eH\u0016J\u0008\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\u0008\u001a\u00028\u00008G¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R*\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\u0008\u0015\u0010\n\u001a\u0004\u0008\u0016\u0010\u000c\"\u0004\u0008\u0017\u0010\u0018¨\u0006%", d2 = {"Landroidx/compose/runtime/SnapshotMutableStateImpl;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "next", "Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "getValue$annotations", "getValue", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "StateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SnapshotMutableStateImpl<T>  extends StateObjectImpl implements SnapshotMutableState<T> {

    public static final int $stable;
    private androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T> next;
    private final androidx.compose.runtime.SnapshotMutationPolicy<T> policy;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0008\u0010\u000c\u001a\u00020\u0002H\u0016R\u001c\u0010\u0005\u001a\u00028\u0001X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0004¨\u0006\r", d2 = {"Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "myValue", "(Ljava/lang/Object;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class StateStateRecord extends StateRecord {

        private T value;
        public StateStateRecord(T myValue) {
            super();
            this.value = myValue;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.value = obj.value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            SnapshotMutableStateImpl.StateStateRecord stateStateRecord = new SnapshotMutableStateImpl.StateStateRecord(this.value);
            return (StateRecord)stateStateRecord;
        }

        public final T getValue() {
            return this.value;
        }

        public final void setValue(T <set-?>) {
            this.value = <set-?>;
        }
    }
    static {
    }

    public SnapshotMutableStateImpl(T value, androidx.compose.runtime.SnapshotMutationPolicy<T> policy) {
        boolean stateStateRecord;
        androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord stateStateRecord2;
        int i2;
        int i;
        super();
        this.policy = policy;
        SnapshotMutableStateImpl.StateStateRecord stateStateRecord3 = new SnapshotMutableStateImpl.StateStateRecord(value);
        final int i3 = 0;
        if (Snapshot.Companion.isInSnapshot()) {
            stateStateRecord = new SnapshotMutableStateImpl.StateStateRecord(value);
            i2 = 0;
            stateStateRecord.setSnapshotId$runtime_release(1);
            stateStateRecord3.setNext$runtime_release((StateRecord)stateStateRecord);
        }
        this.next = stateStateRecord3;
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public static void getValue$annotations() {
    }

    public T component1() {
        return getValue();
    }

    public Function1<T, Unit> component2() {
        SnapshotMutableStateImpl.component2.1 anon = new SnapshotMutableStateImpl.component2.1(this);
        return (Function1)anon;
    }

    public final T getDebuggerDisplayValue() {
        final int i = 0;
        final int i2 = 0;
        return (SnapshotMutableStateImpl.StateStateRecord)SnapshotKt.current((StateRecord)this.next).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord getFirstStateRecord() {
        return (StateRecord)this.next;
    }

    public androidx.compose.runtime.SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        return (SnapshotMutableStateImpl.StateStateRecord)SnapshotKt.readable((StateRecord)this.next, (StateObject)this).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord mergeRecords(StateRecord previous, StateRecord current, StateRecord applied) {
        boolean equivalent;
        Object create;
        Object value2;
        int value;
        StateRecord stateRecord;
        String str = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>";
        Intrinsics.checkNotNull(previous, str);
        Intrinsics.checkNotNull(current, str);
        final Object obj3 = current;
        Intrinsics.checkNotNull(applied, str);
        Object obj = applied;
        if (getPolicy().equivalent((SnapshotMutableStateImpl.StateStateRecord)obj3.getValue(), (SnapshotMutableStateImpl.StateStateRecord)obj.getValue())) {
            create = current;
        } else {
            equivalent = getPolicy().merge((SnapshotMutableStateImpl.StateStateRecord)previous.getValue(), obj3.getValue(), obj.getValue());
            if (equivalent != null) {
                value2 = create;
                value = 0;
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.mergeRecords$lambda$4>");
                (SnapshotMutableStateImpl.StateStateRecord)value2.setValue(equivalent);
            } else {
                create = 0;
            }
        }
        return create;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.next = (SnapshotMutableStateImpl.StateStateRecord)value;
    }

    public void setValue(T value) {
        boolean equivalent;
        Object value2;
        Snapshot snapshot$iv;
        int i;
        Object obj;
        int i2;
        Throwable th;
        Unit $this$_set_value__u24lambda_u241_u24lambda_u240;
        int i3;
        final int i4 = 0;
        final StateRecord current = SnapshotKt.current((StateRecord)this.next);
        final int i5 = 0;
        if (!getPolicy().equivalent((SnapshotMutableStateImpl.StateStateRecord)current.getValue(), value)) {
            value2 = 0;
            int i6 = 0;
            Snapshot snapshot$iv2 = SnapshotKt.getSnapshotInitializer();
            int i7 = 0;
            Object lock = SnapshotKt.getLock();
            i2 = 0;
            th = 0;
            snapshot$iv = current2;
            i3 = 0;
            (SnapshotMutableStateImpl.StateStateRecord)SnapshotKt.overwritableRecord((StateRecord)this.next, (StateObject)this, snapshot$iv, (StateRecord)current).setValue(value);
            $this$_set_value__u24lambda_u241_u24lambda_u240 = Unit.INSTANCE;
            i = 0;
            SnapshotKt.notifyWrite(snapshot$iv, (StateObject)this);
            synchronized (lock) {
                value2 = 0;
                i6 = 0;
                snapshot$iv2 = SnapshotKt.getSnapshotInitializer();
                i7 = 0;
                lock = SnapshotKt.getLock();
                i2 = 0;
                th = 0;
                snapshot$iv = current2;
                i3 = 0;
                (SnapshotMutableStateImpl.StateStateRecord)SnapshotKt.overwritableRecord((StateRecord)this.next, (StateObject)this, snapshot$iv, (StateRecord)current).setValue(value);
                $this$_set_value__u24lambda_u241_u24lambda_u240 = Unit.INSTANCE;
                i = 0;
                SnapshotKt.notifyWrite(snapshot$iv, (StateObject)this);
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public String toString() {
        final int i = 0;
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MutableState(value=").append((SnapshotMutableStateImpl.StateStateRecord)SnapshotKt.current((StateRecord)this.next).getValue()).append(")@").append(hashCode()).toString();
    }
}
