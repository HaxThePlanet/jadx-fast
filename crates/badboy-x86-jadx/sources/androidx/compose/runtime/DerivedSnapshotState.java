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
            int i2;
            int i;
            int validSnapshotWriteCount;
            int writeCount$runtime_release;
            int i3;
            int i4 = 0;
            Object lock = SnapshotKt.getLock();
            i2 = 0;
            int i5 = 0;
            final int i7 = 1;
            synchronized (lock) {
                if (this.validSnapshotWriteCount != snapshot.getWriteCount$runtime_release()) {
                    i = i7;
                } else {
                    i = i3;
                }
                if (this.result != DerivedSnapshotState.ResultRecord.Unset) {
                } else {
                }
                if (i3 != 0 && i != 0) {
                    if (i != 0) {
                        resultHash = 0;
                        readableHash = SnapshotKt.getLock();
                        i2 = 0;
                        int i6 = 0;
                        this.validSnapshotId = snapshot.getId();
                        this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                        validSnapshotWriteCount = Unit.INSTANCE;
                        synchronized (readableHash) {
                            resultHash = 0;
                            readableHash = SnapshotKt.getLock();
                            i2 = 0;
                            i6 = 0;
                            this.validSnapshotId = snapshot.getId();
                            this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                            validSnapshotWriteCount = Unit.INSTANCE;
                        }
                    }
                }
                return i3;
            }
            if (i != 0) {
                if (this.resultHash == readableHash(derivedState, snapshot)) {
                    try {
                        i3 = i7;
                        if (i3 != 0 && i != 0) {
                        }
                        if (i != 0) {
                        }
                        resultHash = 0;
                        readableHash = SnapshotKt.getLock();
                        i2 = 0;
                        i6 = 0;
                        this.validSnapshotId = snapshot.getId();
                        this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                        validSnapshotWriteCount = Unit.INSTANCE;
                        throw th;
                        return i3;
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
            int current;
            int i3;
            int bitCount$iv$iv;
            int $i$f$notifyObservers;
            int i4;
            int i11;
            int i6;
            Object lock;
            int j$iv$iv;
            int size;
            int i$iv$iv;
            int i$iv$iv4;
            Object[] i$iv$iv2;
            Object i$iv$iv3;
            int content;
            Object obj;
            int i10;
            long[] metadata;
            int i7;
            int i;
            long slot$iv$iv;
            int $this$maskEmptyOrDeleted$iv$iv$iv;
            ObjectIntMap map;
            int i8;
            int i2;
            int hash;
            long l;
            int readLevel;
            int i5;
            int stateObject;
            int i9;
            int i12;
            int snapshotId$runtime_release;
            final androidx.compose.runtime.DerivedState derivedState2 = derivedState;
            final Snapshot snapshot2 = snapshot;
            int i13 = 0;
            bitCount$iv$iv = 7;
            i4 = 0;
            lock = SnapshotKt.getLock();
            i$iv$iv = 0;
            int i14 = 0;
            final ObjectIntMap dependencies = getDependencies();
            synchronized (lock) {
                derivedState2 = derivedState;
                snapshot2 = snapshot;
                i13 = 0;
                bitCount$iv$iv = 7;
                i4 = 0;
                lock = SnapshotKt.getLock();
                i$iv$iv = 0;
                i14 = 0;
                dependencies = getDependencies();
            }
            j$iv$iv = SnapshotStateKt.derivedStateObservers();
            MutableVector mutableVector = j$iv$iv;
            int i20 = 0;
            int size2 = mutableVector.getSize();
            if (size2 > 0) {
                i$iv$iv3 = 0;
                i10 = 0;
                (DerivedStateObserver)mutableVector.getContent()[i$iv$iv3].start(derivedState2);
                while (i$iv$iv3 += i22 >= size2) {
                    i10 = 0;
                    (DerivedStateObserver)content[i$iv$iv3].start(derivedState2);
                }
            }
            i$iv$iv = dependencies;
            i$iv$iv4 = 0;
            i10 = 0;
            metadata = obj.metadata;
            length += -2;
            if (0 <= i7) {
            } else {
                stateObject = current;
                i2 = i11;
                $this$maskEmptyOrDeleted$iv$iv$iv = j$iv$iv;
                map = i$iv$iv;
            }
            Unit iNSTANCE = Unit.INSTANCE;
            notEmpty = $this$maskEmptyOrDeleted$iv$iv$iv;
            i4 = 0;
            lock = notEmpty.getSize();
            if (lock > 0) {
                i$iv$iv = 0;
                i$iv$iv3 = null;
                (DerivedStateObserver)notEmpty.getContent()[i$iv$iv].done(derivedState2);
                i = 1;
                while (i$iv$iv++ >= lock) {
                    i$iv$iv3 = null;
                    (DerivedStateObserver)i$iv$iv4[i$iv$iv].done(derivedState2);
                    i = 1;
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
        Object iNSTANCE;
        boolean valid;
        androidx.compose.runtime.DerivedState derivedState;
        Object[] objArr2;
        int i5;
        Object observe;
        Snapshot snapshot2;
        int m$iv$iv;
        int i;
        int i10;
        int i2;
        int size2;
        Object[] $this$maskEmptyOrDeleted$iv$iv$iv2;
        int size;
        int i$iv$iv2;
        int i$iv$iv3;
        Object lock;
        Object[] $i$f$isFull;
        int i11;
        Object dependencies;
        Snapshot current;
        int i12;
        Object result;
        StateRecord writableRecord;
        androidx.compose.runtime.DerivedState i$iv$iv4;
        Object writeCount$runtime_release;
        Object content;
        int i6;
        int element;
        ObjectIntMap size3;
        int i$iv$iv;
        Object[] content2;
        int i3;
        int i4;
        Object obj;
        Throwable th2;
        int this_$iv$iv;
        long[] lArr;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object[] objArr;
        int cmp;
        Object[] k$iv;
        int[] iArr;
        long l;
        int i7;
        int i9;
        Object obj2;
        int i8;
        int j$iv$iv;
        final int i18 = this;
        final StateRecord stateRecord = readable;
        i$iv$iv2 = 1;
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
                    i$iv$iv4 = 0;
                    element = 0;
                    (DerivedStateObserver)mutableVector2.getContent()[i$iv$iv4].start((DerivedState)i18);
                    while (i$iv$iv4 += i$iv$iv2 >= size4) {
                        element = 0;
                        (DerivedStateObserver)content[i$iv$iv4].start((DerivedState)i18);
                    }
                }
                i12 = 0;
                if ((IntRef)SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get() == null) {
                    i$iv$iv4 = new IntRef(0);
                    i6 = 0;
                    SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().set(i$iv$iv4);
                }
                content = i$iv$iv4;
                i6 = 0;
                element = content.getElement();
                size3 = dependencies;
                i$iv$iv = 0;
                th2 = 0;
                this_$iv$iv = i16;
                ObjectIntMap map = map5;
                long[] metadata = map.metadata;
                obj = map;
                this_$iv$iv3 += -2;
                if (0 <= i17) {
                } else {
                    k$iv = $this$maskEmptyOrDeleted$iv$iv$iv2;
                    iArr = i$iv$iv2;
                    $this$maskEmptyOrDeleted$iv$iv$iv = i$iv$iv3;
                    objArr = $i$f$isFull;
                }
                content.setElement(element);
                Unit iNSTANCE2 = Unit.INSTANCE;
                valid = objArr;
                snapshot2 = 0;
                size2 = valid.getSize();
                if (size2 > 0) {
                    i$iv$iv2 = 0;
                    dependencies = null;
                    (DerivedStateObserver)valid.getContent()[i$iv$iv2].done((DerivedState)i18);
                    while (i$iv$iv2++ >= size2) {
                        dependencies = null;
                        (DerivedStateObserver)i$iv$iv3[i$iv$iv2].done((DerivedState)i18);
                    }
                }
            }
            return stateRecord;
        }
        i4 = i$iv$iv2;
        i10 = 0;
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i10, i$iv$iv2, 0);
        MutableObjectIntMap map2 = mutableObjectIntMap;
        int i26 = 0;
        if ((IntRef)SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get() == null) {
            intRef = new IntRef(i10);
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
            obj = 0;
            (DerivedStateObserver)mutableVector.getContent()[i$iv$iv].start((DerivedState)i18);
            i4 = 1;
            while (i$iv$iv++ >= size5) {
                i5 = 0;
                i10 = 0;
                obj = 0;
                (DerivedStateObserver)content2[i$iv$iv].start((DerivedState)i18);
                i4 = 1;
            }
        }
        int i13 = 0;
        obj5.setElement(element2 + 1);
        DerivedSnapshotState.currentRecord.result.1.1.result.1 anon = new DerivedSnapshotState.currentRecord.result.1.1.result.1(i18, obj5, map2, element2);
        obj5.setElement(element2);
        this_$iv$iv2 = derivedStateObservers;
        int i20 = 0;
        int size6 = this_$iv$iv2.getSize();
        if (size6 > 0) {
            i$iv$iv = 0;
            obj = 0;
            (DerivedStateObserver)this_$iv$iv2.getContent()[i$iv$iv].done((DerivedState)i18);
            i4 = 1;
            while (i$iv$iv++ >= size6) {
                this_$iv$iv2 = this_$iv$iv;
                observe = lArr;
                obj = 0;
                (DerivedStateObserver)content2[i$iv$iv].done((DerivedState)i18);
                i4 = 1;
            }
        } else {
            this_$iv$iv = this_$iv$iv2;
            lArr = observe;
        }
        Object obj3 = lArr;
        int i21 = 0;
        lock = SnapshotKt.getLock();
        i11 = 0;
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
                    stateRecord.setDependencies((ObjectIntMap)map2);
                    stateRecord.setResultHash(stateRecord.readableHash((DerivedState)i18, current));
                    writableRecord = stateRecord;
                    writableRecord = SnapshotKt.newWritableRecord((StateRecord)i18.first, (StateObject)i18, current);
                    (DerivedSnapshotState.ResultRecord)writableRecord.setDependencies((ObjectIntMap)map2);
                    writableRecord.setResultHash(writableRecord.readableHash((DerivedState)i18, current));
                    writableRecord.setResult(obj3);
                    iNSTANCE = SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
                    if (iNSTANCE != null && (IntRef)iNSTANCE.getElement() == 0) {
                    } else {
                    }
                    if (iNSTANCE.getElement() == 0) {
                    } else {
                    }
                    i2 = 1;
                    i2 = 0;
                    if (i2 != 0) {
                    }
                    Snapshot.Companion.notifyObjectsInitialized();
                    i2 = 0;
                    lock = SnapshotKt.getLock();
                    i11 = 0;
                    int i15 = 0;
                    current = Snapshot.Companion.getCurrent();
                    writableRecord.setValidSnapshotId(current.getId());
                    writableRecord.setValidSnapshotWriteCount(current.getWriteCount$runtime_release());
                    iNSTANCE = Unit.INSTANCE;
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
