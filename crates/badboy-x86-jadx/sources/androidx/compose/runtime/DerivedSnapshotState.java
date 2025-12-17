package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00132\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u0008\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0008\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0011¨\u0006(", d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DerivedSnapshotState<T>  extends StateObjectImpl implements androidx.compose.runtime.DerivedState<T> {

    private final Function0<T> calculation;
    private androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> first;
    private final androidx.compose.runtime.SnapshotMutationPolicy<T> policy;

    @Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 +*\u0004\u0008\u0001\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u0008\u0010#\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020%2\n\u0010&\u001a\u0006\u0012\u0002\u0008\u00030'2\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\u00020\u00152\n\u0010&\u001a\u0006\u0012\u0002\u0008\u00030'2\u0006\u0010(\u001a\u00020)R\u0014\u0010\u0005\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R \u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0007\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017\"\u0004\u0008\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0017\"\u0004\u0008\u001f\u0010\u0019¨\u0006,", d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "result", "", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ResultRecord extends StateRecord implements androidx.compose.runtime.DerivedState.Record<T> {

        public static final int $stable = 8;
        public static final androidx.compose.runtime.DerivedSnapshotState.ResultRecord.Companion Companion;
        private static final Object Unset;
        private ObjectIntMap<StateObject> dependencies;
        private Object result;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;
        static {
            DerivedSnapshotState.ResultRecord.Companion companion = new DerivedSnapshotState.ResultRecord.Companion(0);
            DerivedSnapshotState.ResultRecord.Companion = companion;
            int i = 8;
            Object object = new Object();
            DerivedSnapshotState.ResultRecord.Unset = object;
        }

        public ResultRecord() {
            super();
            this.dependencies = ObjectIntMapKt.emptyObjectIntMap();
            this.result = DerivedSnapshotState.ResultRecord.Unset;
        }

        public static final Object access$getUnset$cp() {
            return DerivedSnapshotState.ResultRecord.Unset;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            Object obj = value;
            setDependencies((DerivedSnapshotState.ResultRecord)obj.getDependencies());
            this.result = obj.result;
            this.resultHash = obj.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            DerivedSnapshotState.ResultRecord resultRecord = new DerivedSnapshotState.ResultRecord();
            return (StateRecord)resultRecord;
        }

        public T getCurrentValue() {
            return this.result;
        }

        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final Object getResult() {
            return this.result;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getResultHash() {
            return this.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final boolean isValid(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            Object resultHash;
            Object readableHash;
            int i;
            int $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1;
            int $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$1;
            int writeCount$runtime_release;
            int i2;
            int i3 = 0;
            Object lock = SnapshotKt.getLock();
            i = 0;
            int i4 = 0;
            final int i6 = 1;
            synchronized (lock) {
                if (this.validSnapshotWriteCount != snapshot.getWriteCount$runtime_release()) {
                    $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 = i6;
                } else {
                    $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 = i2;
                }
                if (this.result != DerivedSnapshotState.ResultRecord.Unset) {
                } else {
                }
                if (i2 != 0 && $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 != 0) {
                    if ($i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 != 0) {
                        resultHash = 0;
                        readableHash = SnapshotKt.getLock();
                        i = 0;
                        int i5 = 0;
                        this.validSnapshotId = snapshot.getId();
                        this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                        $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$1 = Unit.INSTANCE;
                        synchronized (readableHash) {
                            resultHash = 0;
                            readableHash = SnapshotKt.getLock();
                            i = 0;
                            i5 = 0;
                            this.validSnapshotId = snapshot.getId();
                            this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                            $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$1 = Unit.INSTANCE;
                        }
                    }
                }
                return i2;
            }
            if ($i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 != 0) {
                if (this.resultHash == readableHash(derivedState, snapshot)) {
                    try {
                        i2 = i6;
                        if (i2 != 0 && $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 != 0) {
                        }
                        if ($i$a$SyncDerivedSnapshotState$ResultRecord$isValid$snapshotChanged$1 != 0) {
                        }
                        resultHash = 0;
                        readableHash = SnapshotKt.getLock();
                        i = 0;
                        i5 = 0;
                        this.validSnapshotId = snapshot.getId();
                        this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                        $i$a$SyncDerivedSnapshotState$ResultRecord$isValid$1 = Unit.INSTANCE;
                        throw th;
                        return i2;
                        throw snapshotChanged;
                    } catch (Throwable th) {
                    }
                } else {
                }
            } else {
            }
        }

        public final int readableHash(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            boolean notEmpty;
            int $i$a$NotifyObserversDerivedSnapshotState$ResultRecord$readableHash$1;
            int i2;
            int bitCount$iv$iv;
            int $i$f$notifyObservers;
            int i9;
            int i6;
            int i8;
            Object lock;
            int j$iv$iv;
            int size;
            int i$iv$iv3;
            int i$iv$iv;
            Object[] i$iv$iv4;
            Object i$iv$iv2;
            int content;
            Object obj;
            int i11;
            long[] metadata;
            int i12;
            int i5;
            long slot$iv$iv;
            int $this$maskEmptyOrDeleted$iv$iv$iv;
            ObjectIntMap map;
            int i7;
            int i;
            int hash;
            long l;
            int readLevel;
            int i3;
            int $i$a$NotifyObserversDerivedSnapshotState$ResultRecord$readableHash$12;
            int i10;
            int i4;
            int snapshotId$runtime_release;
            final androidx.compose.runtime.DerivedState derivedState2 = derivedState;
            final Snapshot snapshot2 = snapshot;
            int i13 = 0;
            bitCount$iv$iv = 7;
            i9 = 0;
            lock = SnapshotKt.getLock();
            i$iv$iv3 = 0;
            int i14 = 0;
            final ObjectIntMap dependencies = getDependencies();
            synchronized (lock) {
                derivedState2 = derivedState;
                snapshot2 = snapshot;
                i13 = 0;
                bitCount$iv$iv = 7;
                i9 = 0;
                lock = SnapshotKt.getLock();
                i$iv$iv3 = 0;
                i14 = 0;
                dependencies = getDependencies();
            }
            j$iv$iv = SnapshotStateKt.derivedStateObservers();
            MutableVector mutableVector = j$iv$iv;
            int i20 = 0;
            int size2 = mutableVector.getSize();
            if (size2 > 0) {
                i$iv$iv2 = 0;
                i11 = 0;
                (DerivedStateObserver)mutableVector.getContent()[i$iv$iv2].start(derivedState2);
                while (i$iv$iv2 += i22 >= size2) {
                    i11 = 0;
                    (DerivedStateObserver)content[i$iv$iv2].start(derivedState2);
                }
            }
            i$iv$iv3 = dependencies;
            i$iv$iv = 0;
            i11 = 0;
            metadata = obj.metadata;
            length += -2;
            if (0 <= i12) {
            } else {
                $i$a$NotifyObserversDerivedSnapshotState$ResultRecord$readableHash$12 = $i$a$NotifyObserversDerivedSnapshotState$ResultRecord$readableHash$1;
                i = i6;
                $this$maskEmptyOrDeleted$iv$iv$iv = j$iv$iv;
                map = i$iv$iv3;
            }
            Unit iNSTANCE = Unit.INSTANCE;
            notEmpty = $this$maskEmptyOrDeleted$iv$iv$iv;
            i9 = 0;
            lock = notEmpty.getSize();
            if (lock > 0) {
                i$iv$iv3 = 0;
                i$iv$iv2 = null;
                (DerivedStateObserver)notEmpty.getContent()[i$iv$iv3].done(derivedState2);
                i5 = 1;
                while (i$iv$iv3++ >= lock) {
                    i$iv$iv2 = null;
                    (DerivedStateObserver)i$iv$iv[i$iv$iv3].done(derivedState2);
                    i5 = 1;
                }
            }
            return bitCount$iv$iv;
        }

        public void setDependencies(ObjectIntMap<StateObject> <set-?>) {
            this.dependencies = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setResult(Object <set-?>) {
            this.result = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setResultHash(int <set-?>) {
            this.resultHash = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setValidSnapshotId(int <set-?>) {
            this.validSnapshotId = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setValidSnapshotWriteCount(int <set-?>) {
            this.validSnapshotWriteCount = <set-?>;
        }
    }
    public DerivedSnapshotState(Function0<? extends T> calculation, androidx.compose.runtime.SnapshotMutationPolicy<T> policy) {
        super();
        this.calculation = calculation;
        this.policy = policy;
        DerivedSnapshotState.ResultRecord resultRecord = new DerivedSnapshotState.ResultRecord();
        this.first = resultRecord;
    }

    private final androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> currentRecord(androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        Object intRef;
        MutableVector this_$iv$iv2;
        Object $i$a$SyncDerivedSnapshotState$currentRecord$2;
        boolean valid;
        androidx.compose.runtime.DerivedState derivedState;
        Object[] objArr;
        int i4;
        Object observe;
        Snapshot snapshot2;
        int m$iv$iv;
        int i2;
        int i7;
        int i10;
        int size;
        Object[] $this$maskEmptyOrDeleted$iv$iv$iv2;
        int size3;
        int i$iv$iv4;
        int i$iv$iv3;
        Object lock;
        Object[] $i$f$isFull;
        int i3;
        Object dependencies;
        Snapshot current;
        int i;
        Object result;
        StateRecord writableRecord;
        androidx.compose.runtime.DerivedState i$iv$iv2;
        Object writeCount$runtime_release;
        Object content;
        int i6;
        int element;
        ObjectIntMap size2;
        int i$iv$iv;
        Object[] content2;
        int i12;
        int i9;
        Object obj2;
        Throwable th2;
        int this_$iv$iv;
        long[] lArr;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object[] objArr2;
        int cmp;
        Object[] k$iv;
        int[] iArr;
        long l;
        int i11;
        int i5;
        Object obj;
        int i8;
        int j$iv$iv;
        final int i18 = this;
        final StateRecord stateRecord = readable;
        i$iv$iv4 = 1;
        $i$f$isFull = SnapshotStateKt.derivedStateObservers();
        MutableVector mutableVector2 = $i$f$isFull;
        int i30 = 0;
        int size4 = mutableVector2.getSize();
        if (stateRecord.isValid((DerivedState)i18, snapshot) && forceDependencyReads && size4 > 0) {
            if (forceDependencyReads) {
                $i$f$isFull = SnapshotStateKt.derivedStateObservers();
                mutableVector2 = $i$f$isFull;
                i30 = 0;
                size4 = mutableVector2.getSize();
                if (size4 > 0) {
                    i$iv$iv2 = 0;
                    element = 0;
                    (DerivedStateObserver)mutableVector2.getContent()[i$iv$iv2].start((DerivedState)i18);
                    while (i$iv$iv2 += i$iv$iv4 >= size4) {
                        element = 0;
                        (DerivedStateObserver)content[i$iv$iv2].start((DerivedState)i18);
                    }
                }
                i = 0;
                if ((IntRef)SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get() == null) {
                    i$iv$iv2 = new IntRef(0);
                    i6 = 0;
                    SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(i$iv$iv2);
                }
                content = i$iv$iv2;
                i6 = 0;
                element = content.getElement();
                size2 = dependencies;
                i$iv$iv = 0;
                th2 = 0;
                this_$iv$iv = i16;
                ObjectIntMap $i$a$NotifyObserversDerivedSnapshotState$currentRecord$1 = map4;
                long[] metadata = $i$a$NotifyObserversDerivedSnapshotState$currentRecord$1.metadata;
                obj2 = $i$a$NotifyObserversDerivedSnapshotState$currentRecord$1;
                this_$iv$iv3 += -2;
                if (0 <= i17) {
                } else {
                    k$iv = $this$maskEmptyOrDeleted$iv$iv$iv2;
                    iArr = i$iv$iv4;
                    $this$maskEmptyOrDeleted$iv$iv$iv = i$iv$iv3;
                    objArr2 = $i$f$isFull;
                }
                content.setElement(element);
                Unit iNSTANCE = Unit.INSTANCE;
                valid = objArr2;
                snapshot2 = 0;
                size = valid.getSize();
                if (size > 0) {
                    i$iv$iv4 = 0;
                    dependencies = null;
                    (DerivedStateObserver)valid.getContent()[i$iv$iv4].done((DerivedState)i18);
                    while (i$iv$iv4++ >= size) {
                        dependencies = null;
                        (DerivedStateObserver)i$iv$iv3[i$iv$iv4].done((DerivedState)i18);
                    }
                }
            }
            return stateRecord;
        }
        i9 = i$iv$iv4;
        i7 = 0;
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i7, i$iv$iv4, 0);
        MutableObjectIntMap map = mutableObjectIntMap;
        int i26 = 0;
        if ((IntRef)SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get() == null) {
            intRef = new IntRef(i7);
            dependencies = 0;
            SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(intRef);
        }
        Object obj5 = obj4;
        int i31 = 0;
        int element2 = obj5.getElement();
        int i35 = 0;
        MutableVector derivedStateObservers = SnapshotStateKt.derivedStateObservers();
        MutableVector mutableVector = derivedStateObservers;
        int i36 = 0;
        int size5 = mutableVector.getSize();
        if (size5 > 0) {
            i$iv$iv = 0;
            obj2 = 0;
            (DerivedStateObserver)mutableVector.getContent()[i$iv$iv].start((DerivedState)i18);
            i9 = 1;
            while (i$iv$iv++ >= size5) {
                i4 = 0;
                i7 = 0;
                obj2 = 0;
                (DerivedStateObserver)content2[i$iv$iv].start((DerivedState)i18);
                i9 = 1;
            }
        }
        int i13 = 0;
        obj5.setElement(element2 + 1);
        DerivedSnapshotState.currentRecord.result.1.1.result.1 anon = new DerivedSnapshotState.currentRecord.result.1.1.result.1(i18, obj5, map, element2);
        obj5.setElement(element2);
        this_$iv$iv2 = derivedStateObservers;
        int i20 = 0;
        int size6 = this_$iv$iv2.getSize();
        if (size6 > 0) {
            i$iv$iv = 0;
            obj2 = 0;
            (DerivedStateObserver)this_$iv$iv2.getContent()[i$iv$iv].done((DerivedState)i18);
            i9 = 1;
            while (i$iv$iv++ >= size6) {
                this_$iv$iv2 = this_$iv$iv;
                observe = lArr;
                obj2 = 0;
                (DerivedStateObserver)content2[i$iv$iv].done((DerivedState)i18);
                i9 = 1;
            }
        } else {
            this_$iv$iv = this_$iv$iv2;
            lArr = observe;
        }
        Object obj3 = lArr;
        int i21 = 0;
        lock = SnapshotKt.getLock();
        i3 = 0;
        int i14 = 0;
        current = Snapshot.Companion.getCurrent();
        synchronized (lock) {
            androidx.compose.runtime.SnapshotMutationPolicy policy = i18.getPolicy();
            if (policy != null) {
                try {
                    if (policy.equivalent(obj3, stateRecord.getResult()) == 1) {
                    } else {
                    }
                    result = 1;
                    result = 0;
                    result = 0;
                    if (result != null) {
                    } else {
                    }
                    stateRecord.setDependencies((ObjectIntMap)map);
                    stateRecord.setResultHash(stateRecord.readableHash((DerivedState)i18, current));
                    writableRecord = stateRecord;
                    writableRecord = SnapshotKt.newWritableRecord((StateRecord)i18.first, (StateObject)i18, current);
                    (DerivedSnapshotState.ResultRecord)writableRecord.setDependencies((ObjectIntMap)map);
                    writableRecord.setResultHash(writableRecord.readableHash((DerivedState)i18, current));
                    writableRecord.setResult(obj3);
                    $i$a$SyncDerivedSnapshotState$currentRecord$2 = SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
                    if ($i$a$SyncDerivedSnapshotState$currentRecord$2 != null && (IntRef)$i$a$SyncDerivedSnapshotState$currentRecord$2.getElement() == 0) {
                    } else {
                    }
                    if ($i$a$SyncDerivedSnapshotState$currentRecord$2.getElement() == 0) {
                    } else {
                    }
                    i10 = 1;
                    i10 = 0;
                    if (i10 != 0) {
                    }
                    Snapshot.Companion.notifyObjectsInitialized();
                    i10 = 0;
                    lock = SnapshotKt.getLock();
                    i3 = 0;
                    int i15 = 0;
                    current = Snapshot.Companion.getCurrent();
                    writableRecord.setValidSnapshotId(current.getId());
                    writableRecord.setValidSnapshotWriteCount(current.getWriteCount$runtime_release());
                    $i$a$SyncDerivedSnapshotState$currentRecord$2 = Unit.INSTANCE;
                    throw th;
                    return writableRecord;
                } catch (Throwable th) {
                }
            } else {
            }
        }
    }

    private final String displayValue() {
        final int i = 0;
        final StateRecord current = SnapshotKt.current((StateRecord)this.first);
        final int i2 = 0;
        if ((DerivedSnapshotState.ResultRecord)current.isValid((DerivedState)this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(current.getResult());
        }
        return "<Not calculated>";
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public final StateRecord current(Snapshot snapshot) {
        return (StateRecord)currentRecord((DerivedSnapshotState.ResultRecord)SnapshotKt.current((StateRecord)this.first, snapshot), snapshot, false, this.calculation);
    }

    public androidx.compose.runtime.DerivedState.Record<T> getCurrentRecord() {
        Snapshot current = Snapshot.Companion.getCurrent();
        return (DerivedState.Record)currentRecord((DerivedSnapshotState.ResultRecord)SnapshotKt.current((StateRecord)this.first, current), current, false, this.calculation);
    }

    public final T getDebuggerDisplayValue() {
        Object result;
        final int i = 0;
        final StateRecord current = SnapshotKt.current((StateRecord)this.first);
        final int i2 = 0;
        if ((DerivedSnapshotState.ResultRecord)current.isValid((DerivedState)this, Snapshot.Companion.getCurrent())) {
            result = current.getResult();
        } else {
            result = 0;
        }
        return result;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public StateRecord getFirstStateRecord() {
        return (StateRecord)this.first;
    }

    public androidx.compose.runtime.SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        Function1 readObserver = Snapshot.Companion.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current2 = Snapshot.Companion.getCurrent();
        return currentRecord((DerivedSnapshotState.ResultRecord)SnapshotKt.current((StateRecord)this.first, current2), current2, true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (DerivedSnapshotState.ResultRecord)value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl
    public String toString() {
        final int i = 0;
        StateRecord current = SnapshotKt.current((StateRecord)this.first);
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DerivedState(value=").append(displayValue()).append(")@").append(hashCode()).toString();
    }
}
