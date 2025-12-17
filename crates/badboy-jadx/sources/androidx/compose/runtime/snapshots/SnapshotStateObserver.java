package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedState.Record;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0001\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000cH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00150\u0003J\u0008\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\u0008\u0008\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\u0008J\u001e\u0010)\u001a\u00020\u00052\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\u0008\u0008\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000cH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\u0008J\u0008\u00101\u001a\u000202H\u0002J\u0008\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000c\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateObserver {

    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, androidx.compose.runtime.snapshots.Snapshot, Unit> applyObserver;
    private androidx.compose.runtime.snapshots.ObserverHandle applyUnsubscribe;
    private androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap currentMap;
    private long currentMapThreadId = -1;
    private boolean isPaused;
    private final MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap> observedScopeMaps;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges;
    private final Function1<Object, Unit> readObserver;
    private boolean sendingNotifications;

    @Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0008H\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u00083\u0012\u0008\u00084\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\u0008\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u00080\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ObservedScopeMap {

        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int currentToken = -1;
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private final MutableVector<DerivedState<?>> statesToReread;
        private final ScopeMap<Object, Object> valueToScopes;
        public ObservedScopeMap(Function1<Object, Unit> onChanged) {
            super();
            this.onChanged = onChanged;
            int i = -1;
            ScopeMap scopeMap = new ScopeMap();
            this.valueToScopes = scopeMap;
            final int i3 = 0;
            int i4 = 1;
            int i6 = 0;
            MutableScatterMap mutableScatterMap = new MutableScatterMap(i3, i4, i6);
            this.scopeToValues = mutableScatterMap;
            MutableScatterSet mutableScatterSet = new MutableScatterSet(i3, i4, i6);
            this.invalidated = mutableScatterSet;
            int i2 = 0;
            int i7 = 0;
            MutableVector mutableVector = new MutableVector(new DerivedState[16], i3);
            this.statesToReread = mutableVector;
            SnapshotStateObserver.ObservedScopeMap.derivedStateObserver.1 anon = new SnapshotStateObserver.ObservedScopeMap.derivedStateObserver.1(this);
            this.derivedStateObserver = (DerivedStateObserver)anon;
            ScopeMap scopeMap2 = new ScopeMap();
            this.dependencyToDerivedStates = scopeMap2;
            HashMap hashMap = new HashMap();
            this.recordedDerivedStateValues = hashMap;
        }

        public static final int access$getDeriveStateScopeCount$p(androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap $this) {
            return $this.deriveStateScopeCount;
        }

        public static final void access$setDeriveStateScopeCount$p(androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap $this, int <set-?>) {
            $this.deriveStateScopeCount = <set-?>;
        }

        private final void clearObsoleteStateReads(Object scope) {
            Object currentToken2;
            int currentToken;
            Object currentToken3;
            int $i$f$removeIf;
            MutableObjectIntMap map;
            int i9;
            long[] metadata;
            int i4;
            int i$iv$iv;
            long slot$iv$iv;
            int $this$maskEmptyOrDeleted$iv$iv$iv;
            int i;
            int j$iv$iv;
            int value$iv$iv$iv;
            int i8;
            long l;
            int i7;
            int i10;
            int i5;
            int i2;
            int i3;
            int i6;
            int currentToken4;
            final Object obj = this;
            currentToken = obj.currentToken;
            final MutableObjectIntMap currentScopeReads = obj.currentScopeReads;
            if (currentScopeReads != null) {
                i9 = 0;
                metadata = map.metadata;
                length += -2;
                if (0 <= i4) {
                } else {
                    currentToken4 = currentToken;
                    i2 = $i$f$removeIf;
                    currentToken2 = scope;
                }
            } else {
                currentToken4 = currentToken;
                currentToken2 = scope;
            }
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i10;
            boolean z;
            ScopeMap valueToScopes;
            int i$iv$iv;
            Object obj;
            int constructor-impl;
            DerivedState.Record currentRecord;
            int i9;
            androidx.collection.ObjectIntMap dependencies;
            ScopeMap dependencyToDerivedStates;
            int $this$maskEmptyOrDeleted$iv$iv$iv2;
            int i5;
            int j$iv$iv;
            androidx.collection.ObjectIntMap map;
            int i8;
            long[] metadata;
            int i4;
            long slot$iv$iv;
            Object[] $this$maskEmptyOrDeleted$iv$iv$iv;
            androidx.collection.ObjectIntMap map2;
            int i6;
            androidx.collection.ObjectIntMap this_$iv;
            int i7;
            long l;
            int i;
            int i3;
            androidx.compose.runtime.snapshots.ReaderKind.Companion companion;
            int i2;
            final Object obj2 = this;
            final Object obj3 = value;
            i10 = currentToken;
            if (obj2.deriveStateScopeCount > 0) {
            }
            final int i11 = recordedValues.put(obj3, i10, -1);
            if (obj3 instanceof DerivedState && i11 != i10) {
                if (i11 != i10) {
                    currentRecord = (DerivedState)obj3.getCurrentRecord();
                    (Map)obj2.recordedDerivedStateValues.put(obj3, currentRecord.getCurrentValue());
                    dependencyToDerivedStates = obj2.dependencyToDerivedStates;
                    dependencyToDerivedStates.removeScope(obj3);
                    $this$maskEmptyOrDeleted$iv$iv$iv2 = dependencies;
                    map = $this$maskEmptyOrDeleted$iv$iv$iv2;
                    i8 = 0;
                    metadata = map.metadata;
                    length += -2;
                    if (0 <= i9) {
                    } else {
                        this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv2;
                        i7 = i5;
                        $this$maskEmptyOrDeleted$iv$iv$iv = j$iv$iv;
                        map2 = map;
                    }
                } else {
                    i4 = 2;
                }
            } else {
            }
            if (i11 == -1) {
                if (obj3 instanceof StateObjectImpl) {
                    androidx.compose.runtime.snapshots.ReaderKind.Companion companion2 = ReaderKind.Companion;
                    constructor-impl = 0;
                    (StateObjectImpl)obj3.recordReadIn-h_f27i8$runtime_release(ReaderKind.constructor-impl(i4));
                }
                obj2.valueToScopes.add(obj3, currentScope);
            } else {
                obj = currentScope;
            }
        }

        private final void removeObservation(Object scope, Object value) {
            boolean recordedDerivedStateValues;
            this.valueToScopes.remove(value, scope);
            if (value instanceof DerivedState && !this.valueToScopes.contains(value)) {
                if (!this.valueToScopes.contains(value)) {
                    this.dependencyToDerivedStates.removeScope(value);
                    this.recordedDerivedStateValues.remove(value);
                }
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(Object scope) {
            Object remove;
            Object obj;
            int i$iv$iv;
            long slot$iv$iv;
            long j$iv$iv;
            int i3;
            int i4;
            Object recordedValues;
            Object obj2;
            long l;
            int i5;
            int i;
            int i2;
            final Object obj3 = this;
            final Object obj4 = scope;
            remove = obj3.scopeToValues.remove(obj4);
            if ((MutableObjectIntMap)remove == null) {
            }
            obj = remove;
            final int i12 = 0;
            final int i13 = 0;
            final long[] metadata = obj5.metadata;
            length += -2;
            if (0 <= i14) {
            } else {
                recordedValues = remove;
                obj2 = obj;
            }
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        public final void notifyInvalidatedScopes() {
            Object cmp;
            MutableScatterSet invalidated;
            int i$iv$iv;
            long slot$iv$iv;
            long j$iv$iv;
            int i4;
            int i2;
            MutableScatterSet invalidated2;
            long l;
            int i;
            int i3;
            cmp = this;
            invalidated = cmp.invalidated;
            final MutableScatterSet set = invalidated;
            final int i12 = 0;
            final int i13 = 0;
            final long[] metadata = set2.metadata;
            length += -2;
            if (0 <= i14) {
            } else {
                invalidated2 = invalidated;
            }
            invalidated2.clear();
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            int currentToken;
            this.currentScope = scope;
            this.currentScopeReads = (MutableObjectIntMap)this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            int i2 = 0;
            final MutableVector derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            derivedStateObservers.add(this.derivedStateObserver);
            int i3 = 0;
            Snapshot.Companion.observe(readObserver, 0, block);
            int i4 = 0;
            derivedStateObservers.removeAt(size--);
            Object observer$iv = this.currentScope;
            Intrinsics.checkNotNull(observer$iv);
            clearObsoleteStateReads(observer$iv);
            this.currentScope = this.currentScope;
            this.currentScopeReads = this.currentScopeReads;
            this.currentToken = this.currentToken;
        }

        public final boolean recordInvalidation(Set<? extends Object> changes) {
            int scope;
            int value;
            ScopeMap dependencyToDerivedStates;
            boolean this_$iv3;
            HashMap value$iv$iv$iv$iv2;
            Object valueToScopes;
            boolean value$iv2;
            int value$iv;
            Object obj6;
            Object i$iv;
            int j$iv$iv$iv4;
            androidx.collection.ScatterSet value$iv$iv$iv$iv;
            boolean element$iv$iv;
            String j$iv$iv$iv6;
            int j$iv$iv$iv;
            int $i$f$isFull;
            long elements;
            Object[] value$iv$iv$iv$iv3;
            androidx.collection.ScatterSet this_$iv;
            long[] m$iv$iv$iv;
            int lastIndex$iv$iv$iv;
            int i$iv$iv$iv;
            int i7;
            int this_$iv4;
            int i14;
            ScopeMap $i$f$forEachIndex;
            ScopeMap this_$iv$iv$iv;
            int i6;
            int i16;
            long slot$iv$iv$iv5;
            HashMap map;
            HashMap k$iv$iv;
            Object $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            int i15;
            int i4;
            int i5;
            Object[] slot$iv$iv$iv6;
            int hasValues;
            int i10;
            ScopeMap valueToScopes2;
            int value2;
            int j$iv$iv$iv7;
            int j$iv$iv$iv5;
            int slot$iv$iv$iv2;
            Object value$iv3;
            int $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
            int $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
            Object obj;
            long[] lArr;
            SnapshotMutationPolicy structuralEqualityPolicy2;
            long this_$iv2;
            long slot$iv$iv$iv;
            int previousValue;
            Object $this$maskEmptyOrDeleted$iv$iv$iv$iv5;
            int i3;
            int policy2;
            Object obj5;
            int index$iv$iv$iv;
            int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            int j$iv$iv$iv2;
            int i11;
            long[] slot$iv$iv$iv4;
            SnapshotMutationPolicy structuralEqualityPolicy;
            SnapshotMutationPolicy j$iv$iv$iv8;
            int $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
            Object obj3;
            ScopeMap map2;
            int i8;
            Object obj2;
            Object policy;
            int i12;
            Object[] objArr;
            Object obj4;
            long[] lArr2;
            long slot$iv$iv$iv3;
            String $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
            int i9;
            int i13;
            int i2;
            SnapshotMutationPolicy snapshotMutationPolicy;
            int j$iv$iv$iv3;
            int i;
            final Object obj7 = this;
            scope = 0;
            dependencyToDerivedStates = obj7.dependencyToDerivedStates;
            value$iv$iv$iv$iv2 = obj7.recordedDerivedStateValues;
            valueToScopes = obj7.valueToScopes;
            final MutableScatterSet invalidated = obj7.invalidated;
            i$iv = changes;
            j$iv$iv$iv4 = 0;
            final int i83 = 2;
            final long l = -9187201950435737472L;
            final int i84 = 1;
            if (i$iv instanceof ScatterSetWrapper) {
                value$iv$iv$iv$iv = (ScatterSetWrapper)i$iv.getSet$runtime_release();
                i7 = 0;
                i14 = 128;
                this_$iv = value$iv$iv$iv$iv;
                int i85 = 0;
                i6 = 255;
                m$iv$iv$iv = this_$iv.metadata;
                i16 = 7;
                if (0 <= length2 += -2) {
                } else {
                    valueToScopes2 = valueToScopes;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = i$iv;
                    i15 = j$iv$iv$iv4;
                    obj5 = value$iv$iv$iv$iv;
                    slot$iv$iv$iv6 = value$iv$iv$iv$iv3;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = this_$iv;
                    slot$iv$iv$iv4 = m$iv$iv$iv;
                }
                $i$f$forEachIndex = dependencyToDerivedStates;
                map = value$iv$iv$iv$iv2;
            } else {
                valueToScopes2 = valueToScopes;
                i15 = j$iv$iv$iv4;
                i14 = 128;
                i6 = 255;
                i16 = 7;
                i$iv = 0;
                j$iv$iv$iv4 = (Iterable)i$iv.iterator();
                while (j$iv$iv$iv4.hasNext()) {
                    element$iv$iv = j$iv$iv$iv4.next();
                    j$iv$iv$iv6 = element$iv$iv;
                    elements = 0;
                    androidx.compose.runtime.snapshots.ReaderKind.Companion companion = ReaderKind.Companion;
                    m$iv$iv$iv = 0;
                    if (j$iv$iv$iv6 instanceof StateObjectImpl && !(StateObjectImpl)j$iv$iv$iv6.isReadIn-h_f27i8$runtime_release(ReaderKind.constructor-impl(i83))) {
                    } else {
                    }
                    if (dependencyToDerivedStates.contains(j$iv$iv$iv6)) {
                    } else {
                    }
                    this_$iv4 = scope;
                    this_$iv$iv$iv = dependencyToDerivedStates;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    slot$iv$iv$iv2 = i$iv;
                    value$iv3 = j$iv$iv$iv4;
                    lArr = element$iv$iv;
                    value2 = elements;
                    dependencyToDerivedStates = valueToScopes2;
                    value$iv$iv$iv$iv2 = 0;
                    obj6 = dependencyToDerivedStates.getMap().get(j$iv$iv$iv6);
                    if (obj6 != null) {
                    } else {
                    }
                    this_$iv4 = dependencyToDerivedStates;
                    i4 = value$iv$iv$iv$iv2;
                    i10 = obj6;
                    value$iv = 8;
                    dependencyToDerivedStates = this_$iv$iv$iv;
                    value$iv$iv$iv$iv2 = k$iv$iv;
                    i$iv = slot$iv$iv$iv2;
                    j$iv$iv$iv4 = value$iv3;
                    valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                    if (obj6 instanceof MutableScatterSet != null) {
                    } else {
                    }
                    this_$iv4 = dependencyToDerivedStates;
                    i4 = value$iv$iv$iv$iv2;
                    value$iv = 8;
                    value$iv$iv$iv$iv2 = 0;
                    invalidated.add(obj6);
                    scope = 1;
                    i$iv = obj6;
                    j$iv$iv$iv4 = 0;
                    value$iv$iv$iv$iv3 = 0;
                    this_$iv = elements.metadata;
                    length += -2;
                    if (0 <= m$iv$iv$iv) {
                    } else {
                    }
                    this_$iv4 = dependencyToDerivedStates;
                    i4 = value$iv$iv$iv$iv2;
                    i10 = obj6;
                    value$iv = 8;
                    i$iv$iv$iv = 0;
                    long hasValues3 = j$iv$iv$iv7;
                    while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv7, l) != 0) {
                        i5 = 8;
                        int i20 = i19 - 8;
                        dependencyToDerivedStates = 0;
                        while (dependencyToDerivedStates < i20) {
                            i$iv$iv$iv = 0;
                            if (Long.compare(i23, i14) < 0) {
                            } else {
                            }
                            value$iv$iv$iv$iv2 = 0;
                            if (value$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            j$iv$iv$iv7 = dependencyToDerivedStates;
                            slot$iv$iv$iv6 >>= obj6;
                            dependencyToDerivedStates = j$iv$iv$iv7 + 1;
                            i$iv$iv$iv = 0;
                            j$iv$iv$iv7 = dependencyToDerivedStates;
                            j$iv$iv$iv5 = 0;
                            invalidated.add(i$iv.elements[i24 += dependencyToDerivedStates]);
                            slot$iv$iv$iv5 = 1;
                            value$iv$iv$iv$iv2 = i84;
                        }
                        j$iv$iv$iv7 = dependencyToDerivedStates;
                        scope = slot$iv$iv$iv5;
                        if (lastIndex$iv$iv$iv == m$iv$iv$iv) {
                            break loop_216;
                        } else {
                        }
                        lastIndex$iv$iv$iv++;
                        dependencyToDerivedStates = this_$iv4;
                        value$iv$iv$iv$iv2 = i4;
                        obj6 = i10;
                        i$iv$iv$iv = 0;
                        hasValues3 = j$iv$iv$iv7;
                        value$iv = 8;
                        scope = slot$iv$iv$iv5;
                        i$iv$iv$iv = 0;
                        if (Long.compare(i23, i14) < 0) {
                        } else {
                        }
                        value$iv$iv$iv$iv2 = 0;
                        if (value$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        j$iv$iv$iv7 = dependencyToDerivedStates;
                        slot$iv$iv$iv6 >>= obj6;
                        dependencyToDerivedStates = j$iv$iv$iv7 + 1;
                        i$iv$iv$iv = 0;
                        j$iv$iv$iv7 = dependencyToDerivedStates;
                        j$iv$iv$iv5 = 0;
                        invalidated.add(element$iv$iv[i24 += dependencyToDerivedStates]);
                        slot$iv$iv$iv5 = 1;
                        value$iv$iv$iv$iv2 = i84;
                    }
                    value$iv = 8;
                    scope = slot$iv$iv$iv5;
                    if (lastIndex$iv$iv$iv != m$iv$iv$iv) {
                    } else {
                    }
                    lastIndex$iv$iv$iv++;
                    dependencyToDerivedStates = this_$iv4;
                    value$iv$iv$iv$iv2 = i4;
                    obj6 = i10;
                    i5 = 8;
                    i20 = i19 - 8;
                    dependencyToDerivedStates = 0;
                    while (dependencyToDerivedStates < i20) {
                        i$iv$iv$iv = 0;
                        if (Long.compare(i23, i14) < 0) {
                        } else {
                        }
                        value$iv$iv$iv$iv2 = 0;
                        if (value$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        j$iv$iv$iv7 = dependencyToDerivedStates;
                        slot$iv$iv$iv6 >>= obj6;
                        dependencyToDerivedStates = j$iv$iv$iv7 + 1;
                        i$iv$iv$iv = 0;
                        j$iv$iv$iv7 = dependencyToDerivedStates;
                        j$iv$iv$iv5 = 0;
                        invalidated.add(element$iv$iv[i24 += dependencyToDerivedStates]);
                        slot$iv$iv$iv5 = 1;
                        value$iv$iv$iv$iv2 = i84;
                    }
                    j$iv$iv$iv7 = dependencyToDerivedStates;
                    if (i20 == 8) {
                    } else {
                    }
                    scope = slot$iv$iv$iv5;
                    scope = slot$iv$iv$iv5;
                    i$iv$iv$iv = 0;
                    if (Long.compare(i23, i14) < 0) {
                    } else {
                    }
                    value$iv$iv$iv$iv2 = 0;
                    if (value$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    j$iv$iv$iv7 = dependencyToDerivedStates;
                    slot$iv$iv$iv6 >>= obj6;
                    dependencyToDerivedStates = j$iv$iv$iv7 + 1;
                    i$iv$iv$iv = 0;
                    j$iv$iv$iv7 = dependencyToDerivedStates;
                    j$iv$iv$iv5 = 0;
                    invalidated.add(element$iv$iv[i24 += dependencyToDerivedStates]);
                    slot$iv$iv$iv5 = 1;
                    value$iv$iv$iv$iv2 = i84;
                    value$iv$iv$iv$iv3 = dependencyToDerivedStates;
                    this_$iv = 0;
                    m$iv$iv$iv = value$iv$iv$iv$iv3.getMap().get(j$iv$iv$iv6);
                    if (m$iv$iv$iv != null) {
                    } else {
                    }
                    this_$iv4 = scope;
                    this_$iv$iv$iv = dependencyToDerivedStates;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    slot$iv$iv$iv2 = i$iv;
                    value$iv3 = j$iv$iv$iv4;
                    lArr = element$iv$iv;
                    value2 = elements;
                    j$iv$iv$iv7 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    if (m$iv$iv$iv instanceof MutableScatterSet != null) {
                    } else {
                    }
                    this_$iv4 = scope;
                    this_$iv$iv$iv = dependencyToDerivedStates;
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    slot$iv$iv$iv2 = i$iv;
                    value$iv3 = j$iv$iv$iv4;
                    lArr = element$iv$iv;
                    value2 = elements;
                    j$iv$iv$iv7 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    Object hasValues5 = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                    dependencyToDerivedStates = 0;
                    valueToScopes = value$iv$iv$iv$iv2.get((DerivedState)hasValues5);
                    if (hasValues5.getPolicy() == null) {
                    }
                    if (!i$iv.equivalent(hasValues5.getCurrentRecord().getCurrentValue(), valueToScopes)) {
                    } else {
                    }
                    slot$iv$iv$iv5 = dependencyToDerivedStates;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    slot$iv$iv$iv = valueToScopes;
                    j$iv$iv$iv5 = i$iv;
                    obj7.statesToReread.add(hasValues5);
                    scope = this_$iv4;
                    j$iv$iv$iv4 = valueToScopes2;
                    element$iv$iv = 0;
                    elements = j$iv$iv$iv4.getMap().get(hasValues5);
                    if (elements != null) {
                    } else {
                    }
                    slot$iv$iv$iv5 = dependencyToDerivedStates;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    slot$iv$iv$iv = valueToScopes;
                    j$iv$iv$iv5 = i$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = j$iv$iv$iv4;
                    obj = elements;
                    if (elements instanceof MutableScatterSet != null) {
                    } else {
                    }
                    slot$iv$iv$iv5 = dependencyToDerivedStates;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    slot$iv$iv$iv = valueToScopes;
                    j$iv$iv$iv5 = i$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = j$iv$iv$iv4;
                    value$iv$iv$iv$iv2 = 0;
                    invalidated.add(elements);
                    this_$iv4 = valueToScopes;
                    value$iv$iv$iv$iv3 = elements;
                    this_$iv = 0;
                    i$iv$iv$iv = 0;
                    slot$iv$iv$iv5 = dependencyToDerivedStates;
                    long[] $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$12 = lastIndex$iv$iv$iv.metadata;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    recordedDerivedStateValues += -2;
                    if (0 <= value$iv$iv$iv$iv2) {
                    } else {
                    }
                    slot$iv$iv$iv = valueToScopes;
                    j$iv$iv$iv5 = i$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = j$iv$iv$iv4;
                    obj = elements;
                    this_$iv2 = value$iv$iv$iv$iv3;
                    i10 = 0;
                    long policy3 = l5;
                    while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv11, l) != 0) {
                        i5 = 8;
                        elements = i39 - 8;
                        i$iv = 0;
                        while (i$iv < elements) {
                            int i48 = 0;
                            if (Long.compare(i87, i14) < 0) {
                            } else {
                            }
                            j$iv$iv$iv4 = 0;
                            if (j$iv$iv$iv4 != 0) {
                            } else {
                            }
                            slot$iv$iv$iv = valueToScopes;
                            slot$iv$iv$iv6 >>= previousValue2;
                            i$iv++;
                            valueToScopes = slot$iv$iv$iv;
                            i10 = 0;
                            slot$iv$iv$iv = valueToScopes;
                            previousValue = 0;
                            invalidated.add(value$iv$iv$iv$iv3.elements[i49 += i$iv]);
                            this_$iv4 = 1;
                            j$iv$iv$iv4 = i84;
                        }
                        slot$iv$iv$iv = valueToScopes;
                        if (elements == 8) {
                            break loop_187;
                        }
                        if (dependencyToDerivedStates == value$iv$iv$iv$iv2) {
                            break loop_187;
                        } else {
                        }
                        dependencyToDerivedStates++;
                        i$iv = j$iv$iv$iv5;
                        j$iv$iv$iv4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
                        elements = obj;
                        value$iv$iv$iv$iv3 = this_$iv2;
                        valueToScopes = slot$iv$iv$iv;
                        i10 = 0;
                        policy3 = l5;
                        slot$iv$iv$iv = valueToScopes;
                        i48 = 0;
                        if (Long.compare(i87, i14) < 0) {
                        } else {
                        }
                        j$iv$iv$iv4 = 0;
                        if (j$iv$iv$iv4 != 0) {
                        } else {
                        }
                        slot$iv$iv$iv = valueToScopes;
                        slot$iv$iv$iv6 >>= previousValue2;
                        i$iv++;
                        valueToScopes = slot$iv$iv$iv;
                        i10 = 0;
                        slot$iv$iv$iv = valueToScopes;
                        previousValue = 0;
                        invalidated.add(m$iv$iv$iv[i49 += i$iv]);
                        this_$iv4 = 1;
                        j$iv$iv$iv4 = i84;
                    }
                    slot$iv$iv$iv = valueToScopes;
                    if (dependencyToDerivedStates != value$iv$iv$iv$iv2) {
                    } else {
                    }
                    dependencyToDerivedStates++;
                    i$iv = j$iv$iv$iv5;
                    j$iv$iv$iv4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
                    elements = obj;
                    value$iv$iv$iv$iv3 = this_$iv2;
                    valueToScopes = slot$iv$iv$iv;
                    i5 = 8;
                    elements = i39 - 8;
                    i$iv = 0;
                    while (i$iv < elements) {
                        i48 = 0;
                        if (Long.compare(i87, i14) < 0) {
                        } else {
                        }
                        j$iv$iv$iv4 = 0;
                        if (j$iv$iv$iv4 != 0) {
                        } else {
                        }
                        slot$iv$iv$iv = valueToScopes;
                        slot$iv$iv$iv6 >>= previousValue2;
                        i$iv++;
                        valueToScopes = slot$iv$iv$iv;
                        i10 = 0;
                        slot$iv$iv$iv = valueToScopes;
                        previousValue = 0;
                        invalidated.add(m$iv$iv$iv[i49 += i$iv]);
                        this_$iv4 = 1;
                        j$iv$iv$iv4 = i84;
                    }
                    slot$iv$iv$iv = valueToScopes;
                    if (elements == 8) {
                    }
                    i48 = 0;
                    if (Long.compare(i87, i14) < 0) {
                    } else {
                    }
                    j$iv$iv$iv4 = 0;
                    if (j$iv$iv$iv4 != 0) {
                    } else {
                    }
                    slot$iv$iv$iv = valueToScopes;
                    slot$iv$iv$iv6 >>= previousValue2;
                    i$iv++;
                    valueToScopes = slot$iv$iv$iv;
                    i10 = 0;
                    slot$iv$iv$iv = valueToScopes;
                    previousValue = 0;
                    invalidated.add(m$iv$iv$iv[i49 += i$iv]);
                    this_$iv4 = 1;
                    j$iv$iv$iv4 = i84;
                    i$iv = SnapshotStateKt.structuralEqualityPolicy();
                    lastIndex$iv$iv$iv = m$iv$iv$iv;
                    i$iv$iv$iv = 0;
                    this_$iv4 = scope;
                    slot$iv$iv$iv5 = 0;
                    Object k$iv$iv2 = obj14;
                    this_$iv$iv$iv = dependencyToDerivedStates;
                    long[] dependencyToDerivedStates2 = k$iv$iv2.metadata;
                    i4 = k$iv$iv2;
                    this_$iv$iv$iv2 += -2;
                    if (0 <= i21) {
                    } else {
                    }
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    slot$iv$iv$iv2 = i$iv;
                    value$iv3 = j$iv$iv$iv4;
                    lArr = element$iv$iv;
                    value2 = elements;
                    j$iv$iv$iv7 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    scope = this_$iv4;
                    j$iv$iv$iv5 = 0;
                    long $i$f$forEach = l3;
                    while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv10, l) != 0) {
                        i5 = 8;
                        elements = i36 - 8;
                        i$iv = 0;
                        while (i$iv < elements) {
                            int i45 = 0;
                            if (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv3, i14) < 0) {
                            } else {
                            }
                            j$iv$iv$iv4 = 0;
                            if (j$iv$iv$iv4 != 0) {
                            } else {
                            }
                            $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                            obj = i$iv;
                            lArr = element$iv$iv;
                            i8 = this_$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                            obj3 = lastIndex$iv$iv$iv;
                            hasValues >>= element$iv$iv2;
                            i$iv = obj + 1;
                            valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                            element$iv$iv = lArr;
                            m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                            lastIndex$iv$iv$iv = obj3;
                            this_$iv = i8;
                            i46 += i$iv;
                            value$iv$iv$iv$iv3 = i47;
                            j$iv$iv$iv5 = 0;
                            $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                            valueToScopes = obj16;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = 0;
                            obj = i$iv;
                            Intrinsics.checkNotNull((DerivedState)valueToScopes, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                            Object obj10 = value$iv$iv$iv$iv2.get(valueToScopes);
                            if (valueToScopes.getPolicy() == null) {
                            }
                            slot$iv$iv$iv = i47;
                            lArr = element$iv$iv;
                            element$iv$iv = this_$iv2;
                            if (!element$iv$iv.equivalent(valueToScopes.getCurrentRecord().getCurrentValue(), obj10)) {
                            } else {
                            }
                            previousValue = obj10;
                            policy = element$iv$iv;
                            obj2 = value$iv$iv$iv$iv3;
                            i8 = this_$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                            obj3 = lastIndex$iv$iv$iv;
                            obj7.statesToReread.add(valueToScopes);
                            j$iv$iv$iv4 = valueToScopes2;
                            this_$iv2 = 0;
                            previousValue = obj10;
                            i$iv = j$iv$iv$iv4.getMap().get(valueToScopes);
                            if (i$iv != null) {
                            } else {
                            }
                            policy2 = i$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                            policy = element$iv$iv;
                            obj2 = value$iv$iv$iv$iv3;
                            i8 = this_$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                            obj3 = lastIndex$iv$iv$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                            if (i$iv instanceof MutableScatterSet != null) {
                            } else {
                            }
                            policy2 = i$iv;
                            policy = element$iv$iv;
                            obj2 = value$iv$iv$iv$iv3;
                            i8 = this_$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                            obj3 = lastIndex$iv$iv$iv;
                            j$iv$iv$iv4 = 0;
                            invalidated.add(i$iv);
                            this_$iv4 = element$iv$iv;
                            Object obj11 = i$iv;
                            i3 = 0;
                            policy2 = i$iv;
                            index$iv$iv$iv = 0;
                            Object k$iv$iv4 = obj5;
                            long[] this_$iv$iv2 = k$iv$iv4.metadata;
                            j$iv$iv$iv2 = k$iv$iv4;
                            this_$iv$iv$iv5 += -2;
                            if (0 <= i$iv) {
                            } else {
                            }
                            policy = element$iv$iv;
                            obj2 = value$iv$iv$iv$iv3;
                            i8 = this_$iv;
                            $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                            obj3 = lastIndex$iv$iv$iv;
                            map2 = 0;
                            long index$iv$iv2 = l8;
                            while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv14, l) != 0) {
                                i5 = 8;
                                value$iv$iv$iv$iv3 = i76 - 8;
                                this_$iv = 0;
                                while (this_$iv < value$iv$iv$iv$iv3) {
                                    map2 = 0;
                                    if (Long.compare(i81, i14) < 0) {
                                    } else {
                                    }
                                    m$iv$iv$iv = 0;
                                    if (m$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    policy = element$iv$iv;
                                    slot$iv$iv$iv4 >>= policy5;
                                    this_$iv++;
                                    element$iv$iv = policy;
                                    map2 = 0;
                                    policy = element$iv$iv;
                                    i12 = 0;
                                    invalidated.add(obj11.elements[i82 += this_$iv]);
                                    this_$iv4 = 1;
                                    m$iv$iv$iv = i84;
                                }
                                policy = element$iv$iv;
                                if (value$iv$iv$iv$iv3 == 8) {
                                    break loop_148;
                                }
                                if (j$iv$iv$iv4 == i$iv) {
                                    break loop_148;
                                } else {
                                }
                                j$iv$iv$iv4++;
                                m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                                lastIndex$iv$iv$iv = obj3;
                                this_$iv = i8;
                                value$iv$iv$iv$iv3 = obj2;
                                element$iv$iv = policy;
                                map2 = 0;
                                index$iv$iv2 = l8;
                                policy = element$iv$iv;
                                map2 = 0;
                                if (Long.compare(i81, i14) < 0) {
                                } else {
                                }
                                m$iv$iv$iv = 0;
                                if (m$iv$iv$iv != 0) {
                                } else {
                                }
                                policy = element$iv$iv;
                                slot$iv$iv$iv4 >>= policy5;
                                this_$iv++;
                                element$iv$iv = policy;
                                map2 = 0;
                                policy = element$iv$iv;
                                i12 = 0;
                                invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                                this_$iv4 = 1;
                                m$iv$iv$iv = i84;
                            }
                            policy = element$iv$iv;
                            if (j$iv$iv$iv4 != i$iv) {
                            } else {
                            }
                            j$iv$iv$iv4++;
                            m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                            lastIndex$iv$iv$iv = obj3;
                            this_$iv = i8;
                            value$iv$iv$iv$iv3 = obj2;
                            element$iv$iv = policy;
                            i5 = 8;
                            value$iv$iv$iv$iv3 = i76 - 8;
                            this_$iv = 0;
                            while (this_$iv < value$iv$iv$iv$iv3) {
                                map2 = 0;
                                if (Long.compare(i81, i14) < 0) {
                                } else {
                                }
                                m$iv$iv$iv = 0;
                                if (m$iv$iv$iv != 0) {
                                } else {
                                }
                                policy = element$iv$iv;
                                slot$iv$iv$iv4 >>= policy5;
                                this_$iv++;
                                element$iv$iv = policy;
                                map2 = 0;
                                policy = element$iv$iv;
                                i12 = 0;
                                invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                                this_$iv4 = 1;
                                m$iv$iv$iv = i84;
                            }
                            policy = element$iv$iv;
                            if (value$iv$iv$iv$iv3 == 8) {
                            }
                            map2 = 0;
                            if (Long.compare(i81, i14) < 0) {
                            } else {
                            }
                            m$iv$iv$iv = 0;
                            if (m$iv$iv$iv != 0) {
                            } else {
                            }
                            policy = element$iv$iv;
                            slot$iv$iv$iv4 >>= policy5;
                            this_$iv++;
                            element$iv$iv = policy;
                            map2 = 0;
                            policy = element$iv$iv;
                            i12 = 0;
                            invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                            this_$iv4 = 1;
                            m$iv$iv$iv = i84;
                            structuralEqualityPolicy2 = SnapshotStateKt.structuralEqualityPolicy();
                            j$iv$iv$iv4 = i84;
                        }
                        $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                        obj = i$iv;
                        lArr = element$iv$iv;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        if (elements == 8) {
                            break loop_135;
                        }
                        if (dependencyToDerivedStates == i21) {
                            break loop_135;
                        } else {
                        }
                        dependencyToDerivedStates++;
                        elements = value2;
                        value$iv$iv$iv$iv3 = j$iv$iv$iv7;
                        i$iv = slot$iv$iv$iv2;
                        j$iv$iv$iv4 = value$iv3;
                        valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                        element$iv$iv = lArr;
                        m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                        lastIndex$iv$iv$iv = obj3;
                        this_$iv = i8;
                        j$iv$iv$iv5 = 0;
                        $i$f$forEach = l3;
                        $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                        lArr = element$iv$iv;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        i45 = 0;
                        if (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv3, i14) < 0) {
                        } else {
                        }
                        j$iv$iv$iv4 = 0;
                        if (j$iv$iv$iv4 != 0) {
                        } else {
                        }
                        $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                        obj = i$iv;
                        lArr = element$iv$iv;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        hasValues >>= element$iv$iv2;
                        i$iv = obj + 1;
                        valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                        element$iv$iv = lArr;
                        m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                        lastIndex$iv$iv$iv = obj3;
                        this_$iv = i8;
                        i46 += i$iv;
                        value$iv$iv$iv$iv3 = i47;
                        j$iv$iv$iv5 = 0;
                        $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                        valueToScopes = obj16;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = 0;
                        obj = i$iv;
                        Intrinsics.checkNotNull((DerivedState)valueToScopes, $this$maskEmptyOrDeleted$iv$iv$iv$iv6);
                        obj10 = value$iv$iv$iv$iv2.get(valueToScopes);
                        if (valueToScopes.getPolicy() == null) {
                        }
                        slot$iv$iv$iv = i47;
                        lArr = element$iv$iv;
                        element$iv$iv = this_$iv2;
                        if (!element$iv$iv.equivalent(valueToScopes.getCurrentRecord().getCurrentValue(), obj10)) {
                        } else {
                        }
                        previousValue = obj10;
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        obj7.statesToReread.add(valueToScopes);
                        j$iv$iv$iv4 = valueToScopes2;
                        this_$iv2 = 0;
                        previousValue = obj10;
                        i$iv = j$iv$iv$iv4.getMap().get(valueToScopes);
                        if (i$iv != null) {
                        } else {
                        }
                        policy2 = i$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                        if (i$iv instanceof MutableScatterSet != null) {
                        } else {
                        }
                        policy2 = i$iv;
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        j$iv$iv$iv4 = 0;
                        invalidated.add(i$iv);
                        this_$iv4 = element$iv$iv;
                        obj11 = i$iv;
                        i3 = 0;
                        policy2 = i$iv;
                        index$iv$iv$iv = 0;
                        k$iv$iv4 = obj5;
                        this_$iv$iv2 = k$iv$iv4.metadata;
                        j$iv$iv$iv2 = k$iv$iv4;
                        this_$iv$iv$iv5 += -2;
                        if (0 <= i$iv) {
                        } else {
                        }
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        map2 = 0;
                        index$iv$iv2 = l8;
                        while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv14, l) != 0) {
                            i5 = 8;
                            value$iv$iv$iv$iv3 = i76 - 8;
                            this_$iv = 0;
                            while (this_$iv < value$iv$iv$iv$iv3) {
                                map2 = 0;
                                if (Long.compare(i81, i14) < 0) {
                                } else {
                                }
                                m$iv$iv$iv = 0;
                                if (m$iv$iv$iv != 0) {
                                } else {
                                }
                                policy = element$iv$iv;
                                slot$iv$iv$iv4 >>= policy5;
                                this_$iv++;
                                element$iv$iv = policy;
                                map2 = 0;
                                policy = element$iv$iv;
                                i12 = 0;
                                invalidated.add(obj11.elements[i82 += this_$iv]);
                                this_$iv4 = 1;
                                m$iv$iv$iv = i84;
                            }
                            policy = element$iv$iv;
                            if (value$iv$iv$iv$iv3 == 8) {
                                break loop_148;
                            }
                            if (j$iv$iv$iv4 == i$iv) {
                                break loop_148;
                            } else {
                            }
                            j$iv$iv$iv4++;
                            m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                            lastIndex$iv$iv$iv = obj3;
                            this_$iv = i8;
                            value$iv$iv$iv$iv3 = obj2;
                            element$iv$iv = policy;
                            map2 = 0;
                            index$iv$iv2 = l8;
                            policy = element$iv$iv;
                            map2 = 0;
                            if (Long.compare(i81, i14) < 0) {
                            } else {
                            }
                            m$iv$iv$iv = 0;
                            if (m$iv$iv$iv != 0) {
                            } else {
                            }
                            policy = element$iv$iv;
                            slot$iv$iv$iv4 >>= policy5;
                            this_$iv++;
                            element$iv$iv = policy;
                            map2 = 0;
                            policy = element$iv$iv;
                            i12 = 0;
                            invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                            this_$iv4 = 1;
                            m$iv$iv$iv = i84;
                        }
                        policy = element$iv$iv;
                        if (j$iv$iv$iv4 != i$iv) {
                        } else {
                        }
                        j$iv$iv$iv4++;
                        m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                        lastIndex$iv$iv$iv = obj3;
                        this_$iv = i8;
                        value$iv$iv$iv$iv3 = obj2;
                        element$iv$iv = policy;
                        i5 = 8;
                        value$iv$iv$iv$iv3 = i76 - 8;
                        this_$iv = 0;
                        while (this_$iv < value$iv$iv$iv$iv3) {
                            map2 = 0;
                            if (Long.compare(i81, i14) < 0) {
                            } else {
                            }
                            m$iv$iv$iv = 0;
                            if (m$iv$iv$iv != 0) {
                            } else {
                            }
                            policy = element$iv$iv;
                            slot$iv$iv$iv4 >>= policy5;
                            this_$iv++;
                            element$iv$iv = policy;
                            map2 = 0;
                            policy = element$iv$iv;
                            i12 = 0;
                            invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                            this_$iv4 = 1;
                            m$iv$iv$iv = i84;
                        }
                        policy = element$iv$iv;
                        if (value$iv$iv$iv$iv3 == 8) {
                        }
                        map2 = 0;
                        if (Long.compare(i81, i14) < 0) {
                        } else {
                        }
                        m$iv$iv$iv = 0;
                        if (m$iv$iv$iv != 0) {
                        } else {
                        }
                        policy = element$iv$iv;
                        slot$iv$iv$iv4 >>= policy5;
                        this_$iv++;
                        element$iv$iv = policy;
                        map2 = 0;
                        policy = element$iv$iv;
                        i12 = 0;
                        invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                        this_$iv4 = 1;
                        m$iv$iv$iv = i84;
                        structuralEqualityPolicy2 = SnapshotStateKt.structuralEqualityPolicy();
                        j$iv$iv$iv4 = i84;
                    }
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    lArr = element$iv$iv;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    if (dependencyToDerivedStates != i21) {
                    } else {
                    }
                    dependencyToDerivedStates++;
                    elements = value2;
                    value$iv$iv$iv$iv3 = j$iv$iv$iv7;
                    i$iv = slot$iv$iv$iv2;
                    j$iv$iv$iv4 = value$iv3;
                    valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                    element$iv$iv = lArr;
                    m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                    lastIndex$iv$iv$iv = obj3;
                    this_$iv = i8;
                    i5 = 8;
                    elements = i36 - 8;
                    i$iv = 0;
                    while (i$iv < elements) {
                        i45 = 0;
                        if (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv3, i14) < 0) {
                        } else {
                        }
                        j$iv$iv$iv4 = 0;
                        if (j$iv$iv$iv4 != 0) {
                        } else {
                        }
                        $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                        obj = i$iv;
                        lArr = element$iv$iv;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        hasValues >>= element$iv$iv2;
                        i$iv = obj + 1;
                        valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                        element$iv$iv = lArr;
                        m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                        lastIndex$iv$iv$iv = obj3;
                        this_$iv = i8;
                        i46 += i$iv;
                        value$iv$iv$iv$iv3 = i47;
                        j$iv$iv$iv5 = 0;
                        $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                        valueToScopes = obj16;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = 0;
                        obj = i$iv;
                        Intrinsics.checkNotNull((DerivedState)valueToScopes, $this$maskEmptyOrDeleted$iv$iv$iv$iv6);
                        obj10 = value$iv$iv$iv$iv2.get(valueToScopes);
                        if (valueToScopes.getPolicy() == null) {
                        }
                        slot$iv$iv$iv = i47;
                        lArr = element$iv$iv;
                        element$iv$iv = this_$iv2;
                        if (!element$iv$iv.equivalent(valueToScopes.getCurrentRecord().getCurrentValue(), obj10)) {
                        } else {
                        }
                        previousValue = obj10;
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        obj7.statesToReread.add(valueToScopes);
                        j$iv$iv$iv4 = valueToScopes2;
                        this_$iv2 = 0;
                        previousValue = obj10;
                        i$iv = j$iv$iv$iv4.getMap().get(valueToScopes);
                        if (i$iv != null) {
                        } else {
                        }
                        policy2 = i$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                        if (i$iv instanceof MutableScatterSet != null) {
                        } else {
                        }
                        policy2 = i$iv;
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        j$iv$iv$iv4 = 0;
                        invalidated.add(i$iv);
                        this_$iv4 = element$iv$iv;
                        obj11 = i$iv;
                        i3 = 0;
                        policy2 = i$iv;
                        index$iv$iv$iv = 0;
                        k$iv$iv4 = obj5;
                        this_$iv$iv2 = k$iv$iv4.metadata;
                        j$iv$iv$iv2 = k$iv$iv4;
                        this_$iv$iv$iv5 += -2;
                        if (0 <= i$iv) {
                        } else {
                        }
                        policy = element$iv$iv;
                        obj2 = value$iv$iv$iv$iv3;
                        i8 = this_$iv;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                        obj3 = lastIndex$iv$iv$iv;
                        map2 = 0;
                        index$iv$iv2 = l8;
                        while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv14, l) != 0) {
                            i5 = 8;
                            value$iv$iv$iv$iv3 = i76 - 8;
                            this_$iv = 0;
                            while (this_$iv < value$iv$iv$iv$iv3) {
                                map2 = 0;
                                if (Long.compare(i81, i14) < 0) {
                                } else {
                                }
                                m$iv$iv$iv = 0;
                                if (m$iv$iv$iv != 0) {
                                } else {
                                }
                                policy = element$iv$iv;
                                slot$iv$iv$iv4 >>= policy5;
                                this_$iv++;
                                element$iv$iv = policy;
                                map2 = 0;
                                policy = element$iv$iv;
                                i12 = 0;
                                invalidated.add(obj11.elements[i82 += this_$iv]);
                                this_$iv4 = 1;
                                m$iv$iv$iv = i84;
                            }
                            policy = element$iv$iv;
                            if (value$iv$iv$iv$iv3 == 8) {
                                break loop_148;
                            }
                            if (j$iv$iv$iv4 == i$iv) {
                                break loop_148;
                            } else {
                            }
                            j$iv$iv$iv4++;
                            m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                            lastIndex$iv$iv$iv = obj3;
                            this_$iv = i8;
                            value$iv$iv$iv$iv3 = obj2;
                            element$iv$iv = policy;
                            map2 = 0;
                            index$iv$iv2 = l8;
                            policy = element$iv$iv;
                            map2 = 0;
                            if (Long.compare(i81, i14) < 0) {
                            } else {
                            }
                            m$iv$iv$iv = 0;
                            if (m$iv$iv$iv != 0) {
                            } else {
                            }
                            policy = element$iv$iv;
                            slot$iv$iv$iv4 >>= policy5;
                            this_$iv++;
                            element$iv$iv = policy;
                            map2 = 0;
                            policy = element$iv$iv;
                            i12 = 0;
                            invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                            this_$iv4 = 1;
                            m$iv$iv$iv = i84;
                        }
                        policy = element$iv$iv;
                        if (j$iv$iv$iv4 != i$iv) {
                        } else {
                        }
                        j$iv$iv$iv4++;
                        m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                        lastIndex$iv$iv$iv = obj3;
                        this_$iv = i8;
                        value$iv$iv$iv$iv3 = obj2;
                        element$iv$iv = policy;
                        i5 = 8;
                        value$iv$iv$iv$iv3 = i76 - 8;
                        this_$iv = 0;
                        while (this_$iv < value$iv$iv$iv$iv3) {
                            map2 = 0;
                            if (Long.compare(i81, i14) < 0) {
                            } else {
                            }
                            m$iv$iv$iv = 0;
                            if (m$iv$iv$iv != 0) {
                            } else {
                            }
                            policy = element$iv$iv;
                            slot$iv$iv$iv4 >>= policy5;
                            this_$iv++;
                            element$iv$iv = policy;
                            map2 = 0;
                            policy = element$iv$iv;
                            i12 = 0;
                            invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                            this_$iv4 = 1;
                            m$iv$iv$iv = i84;
                        }
                        policy = element$iv$iv;
                        if (value$iv$iv$iv$iv3 == 8) {
                        }
                        map2 = 0;
                        if (Long.compare(i81, i14) < 0) {
                        } else {
                        }
                        m$iv$iv$iv = 0;
                        if (m$iv$iv$iv != 0) {
                        } else {
                        }
                        policy = element$iv$iv;
                        slot$iv$iv$iv4 >>= policy5;
                        this_$iv++;
                        element$iv$iv = policy;
                        map2 = 0;
                        policy = element$iv$iv;
                        i12 = 0;
                        invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                        this_$iv4 = 1;
                        m$iv$iv$iv = i84;
                        structuralEqualityPolicy2 = SnapshotStateKt.structuralEqualityPolicy();
                        j$iv$iv$iv4 = i84;
                    }
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    obj = i$iv;
                    lArr = element$iv$iv;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    if (elements == 8) {
                    }
                    i45 = 0;
                    if (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv3, i14) < 0) {
                    } else {
                    }
                    j$iv$iv$iv4 = 0;
                    if (j$iv$iv$iv4 != 0) {
                    } else {
                    }
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    obj = i$iv;
                    lArr = element$iv$iv;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    hasValues >>= element$iv$iv2;
                    i$iv = obj + 1;
                    valueToScopes = $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1;
                    element$iv$iv = lArr;
                    m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                    lastIndex$iv$iv$iv = obj3;
                    this_$iv = i8;
                    i46 += i$iv;
                    value$iv$iv$iv$iv3 = i47;
                    j$iv$iv$iv5 = 0;
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    valueToScopes = obj16;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = 0;
                    obj = i$iv;
                    Intrinsics.checkNotNull((DerivedState)valueToScopes, $this$maskEmptyOrDeleted$iv$iv$iv$iv6);
                    obj10 = value$iv$iv$iv$iv2.get(valueToScopes);
                    if (valueToScopes.getPolicy() == null) {
                    }
                    slot$iv$iv$iv = i47;
                    lArr = element$iv$iv;
                    element$iv$iv = this_$iv2;
                    if (!element$iv$iv.equivalent(valueToScopes.getCurrentRecord().getCurrentValue(), obj10)) {
                    } else {
                    }
                    previousValue = obj10;
                    policy = element$iv$iv;
                    obj2 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    obj7.statesToReread.add(valueToScopes);
                    j$iv$iv$iv4 = valueToScopes2;
                    this_$iv2 = 0;
                    previousValue = obj10;
                    i$iv = j$iv$iv$iv4.getMap().get(valueToScopes);
                    if (i$iv != null) {
                    } else {
                    }
                    policy2 = i$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                    policy = element$iv$iv;
                    obj2 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv4;
                    if (i$iv instanceof MutableScatterSet != null) {
                    } else {
                    }
                    policy2 = i$iv;
                    policy = element$iv$iv;
                    obj2 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    j$iv$iv$iv4 = 0;
                    invalidated.add(i$iv);
                    this_$iv4 = element$iv$iv;
                    obj11 = i$iv;
                    i3 = 0;
                    policy2 = i$iv;
                    index$iv$iv$iv = 0;
                    k$iv$iv4 = obj5;
                    this_$iv$iv2 = k$iv$iv4.metadata;
                    j$iv$iv$iv2 = k$iv$iv4;
                    this_$iv$iv$iv5 += -2;
                    if (0 <= i$iv) {
                    } else {
                    }
                    policy = element$iv$iv;
                    obj2 = value$iv$iv$iv$iv3;
                    i8 = this_$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = m$iv$iv$iv;
                    obj3 = lastIndex$iv$iv$iv;
                    map2 = 0;
                    index$iv$iv2 = l8;
                    while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv14, l) != 0) {
                        i5 = 8;
                        value$iv$iv$iv$iv3 = i76 - 8;
                        this_$iv = 0;
                        while (this_$iv < value$iv$iv$iv$iv3) {
                            map2 = 0;
                            if (Long.compare(i81, i14) < 0) {
                            } else {
                            }
                            m$iv$iv$iv = 0;
                            if (m$iv$iv$iv != 0) {
                            } else {
                            }
                            policy = element$iv$iv;
                            slot$iv$iv$iv4 >>= policy5;
                            this_$iv++;
                            element$iv$iv = policy;
                            map2 = 0;
                            policy = element$iv$iv;
                            i12 = 0;
                            invalidated.add(obj11.elements[i82 += this_$iv]);
                            this_$iv4 = 1;
                            m$iv$iv$iv = i84;
                        }
                        policy = element$iv$iv;
                        if (value$iv$iv$iv$iv3 == 8) {
                            break loop_148;
                        }
                        if (j$iv$iv$iv4 == i$iv) {
                            break loop_148;
                        } else {
                        }
                        j$iv$iv$iv4++;
                        m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                        lastIndex$iv$iv$iv = obj3;
                        this_$iv = i8;
                        value$iv$iv$iv$iv3 = obj2;
                        element$iv$iv = policy;
                        map2 = 0;
                        index$iv$iv2 = l8;
                        policy = element$iv$iv;
                        map2 = 0;
                        if (Long.compare(i81, i14) < 0) {
                        } else {
                        }
                        m$iv$iv$iv = 0;
                        if (m$iv$iv$iv != 0) {
                        } else {
                        }
                        policy = element$iv$iv;
                        slot$iv$iv$iv4 >>= policy5;
                        this_$iv++;
                        element$iv$iv = policy;
                        map2 = 0;
                        policy = element$iv$iv;
                        i12 = 0;
                        invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                        this_$iv4 = 1;
                        m$iv$iv$iv = i84;
                    }
                    policy = element$iv$iv;
                    if (j$iv$iv$iv4 != i$iv) {
                    } else {
                    }
                    j$iv$iv$iv4++;
                    m$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                    lastIndex$iv$iv$iv = obj3;
                    this_$iv = i8;
                    value$iv$iv$iv$iv3 = obj2;
                    element$iv$iv = policy;
                    i5 = 8;
                    value$iv$iv$iv$iv3 = i76 - 8;
                    this_$iv = 0;
                    while (this_$iv < value$iv$iv$iv$iv3) {
                        map2 = 0;
                        if (Long.compare(i81, i14) < 0) {
                        } else {
                        }
                        m$iv$iv$iv = 0;
                        if (m$iv$iv$iv != 0) {
                        } else {
                        }
                        policy = element$iv$iv;
                        slot$iv$iv$iv4 >>= policy5;
                        this_$iv++;
                        element$iv$iv = policy;
                        map2 = 0;
                        policy = element$iv$iv;
                        i12 = 0;
                        invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                        this_$iv4 = 1;
                        m$iv$iv$iv = i84;
                    }
                    policy = element$iv$iv;
                    if (value$iv$iv$iv$iv3 == 8) {
                    }
                    map2 = 0;
                    if (Long.compare(i81, i14) < 0) {
                    } else {
                    }
                    m$iv$iv$iv = 0;
                    if (m$iv$iv$iv != 0) {
                    } else {
                    }
                    policy = element$iv$iv;
                    slot$iv$iv$iv4 >>= policy5;
                    this_$iv++;
                    element$iv$iv = policy;
                    map2 = 0;
                    policy = element$iv$iv;
                    i12 = 0;
                    invalidated.add($this$maskEmptyOrDeleted$iv$iv$iv$iv[i82 += this_$iv]);
                    this_$iv4 = 1;
                    m$iv$iv$iv = i84;
                    structuralEqualityPolicy2 = SnapshotStateKt.structuralEqualityPolicy();
                    j$iv$iv$iv4 = i84;
                    companion = ReaderKind.Companion;
                    m$iv$iv$iv = 0;
                    if (!(StateObjectImpl)j$iv$iv$iv6.isReadIn-h_f27i8$runtime_release(ReaderKind.constructor-impl(i83))) {
                    } else {
                    }
                    this_$iv$iv$iv = dependencyToDerivedStates;
                    k$iv$iv = value$iv$iv$iv$iv2;
                    $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                    slot$iv$iv$iv2 = i$iv;
                    value$iv3 = j$iv$iv$iv4;
                    lArr = element$iv$iv;
                    value$iv = 8;
                }
                i7 = scope;
                $i$f$forEachIndex = dependencyToDerivedStates;
                map = value$iv$iv$iv$iv2;
                $i$a$ForEachScopeOfSnapshotStateObserver$ObservedScopeMap$recordInvalidation$1$1 = valueToScopes;
                slot$iv$iv$iv2 = i$iv;
            }
            MutableVector statesToReread2 = obj7.statesToReread;
            value$iv$iv$iv$iv2 = 0;
            valueToScopes = statesToReread2.getSize();
            if (obj7.statesToReread.isNotEmpty() && valueToScopes > 0) {
                statesToReread2 = obj7.statesToReread;
                value$iv$iv$iv$iv2 = 0;
                valueToScopes = statesToReread2.getSize();
                if (valueToScopes > 0) {
                    i$iv = 0;
                    j$iv$iv$iv6 = null;
                    obj7.rereadDerivedState((DerivedState)statesToReread2.getContent()[i$iv]);
                    while (i$iv++ >= valueToScopes) {
                        j$iv$iv$iv6 = null;
                        obj7.rereadDerivedState((DerivedState)j$iv$iv$iv4[i$iv]);
                    }
                }
                obj7.statesToReread.clear();
            }
            return scope;
        }

        public final void recordRead(Object value) {
            MutableObjectIntMap mutableObjectIntMap;
            Unit it;
            int i;
            MutableScatterMap scopeToValues;
            final Object currentScope = this.currentScope;
            Intrinsics.checkNotNull(currentScope);
            if (this.currentScopeReads == null) {
                mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
                MutableObjectIntMap map = mutableObjectIntMap;
                i = 0;
                this.currentScopeReads = map;
                this.scopeToValues.set(currentScope, map);
                it = Unit.INSTANCE;
            }
            recordRead(value, this.currentToken, currentScope, mutableObjectIntMap);
        }

        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            int index$iv;
            MutableScatterMap m$iv$iv2;
            int $this$maskEmptyOrDeleted$iv$iv$iv2;
            int m$iv$iv;
            int j$iv$iv3;
            int i$iv$iv;
            long value$iv$iv$iv;
            int i14;
            int $this$maskEmptyOrDeleted$iv$iv$iv;
            int i8;
            int j$iv$iv;
            int i10;
            Object obj2;
            Object obj4;
            int i12;
            Object obj5;
            long l;
            int value$iv$iv$iv2;
            int i;
            int i3;
            int i17;
            int cmp;
            int i5;
            int i15;
            int i11;
            int i9;
            Object invoke;
            boolean booleanValue;
            int i13;
            int i16;
            int i7;
            int $i$f$removeIf;
            Object[] objArr;
            MutableScatterMap this_$iv$iv;
            int i4;
            int[] iArr;
            Object obj;
            long[] lArr2;
            long slot$iv$iv;
            long $this$maskEmptyOrDeleted$iv$iv$iv3;
            int i2;
            int $i$f$forEachIndexed;
            long[] lArr;
            int j$iv$iv2;
            int i6;
            final Object obj3 = this;
            final MutableScatterMap scopeToValues = obj3.scopeToValues;
            m$iv$iv2 = scopeToValues;
            m$iv$iv = m$iv$iv2.metadata;
            length += -2;
            if (0 <= i21) {
            } else {
                obj4 = predicate;
                $i$f$removeIf = index$iv;
                this_$iv$iv = m$iv$iv2;
                $i$f$forEachIndexed = $this$maskEmptyOrDeleted$iv$iv$iv2;
                lArr = m$iv$iv;
            }
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            ScopeMap this_$iv2;
            int i4;
            Object value$iv2;
            Object it;
            int i5;
            int i$iv$iv$iv;
            long l;
            int index$iv$iv$iv;
            Object[] elements;
            Object obj;
            int i8;
            long[] metadata;
            long slot$iv$iv$iv;
            ScopeMap this_$iv;
            int i6;
            int cmp;
            int i2;
            long l2;
            int i9;
            int i;
            Object obj3;
            Object value$iv;
            Object obj2;
            int i3;
            int i7;
            final Object obj4 = this;
            final Object obj5 = derivedState;
            final MutableScatterMap scopeToValues = obj4.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            this_$iv2 = obj4.valueToScopes;
            i4 = 0;
            value$iv2 = this_$iv2.getMap().get(obj5);
            if (value$iv2 != null) {
                if (value$iv2 instanceof MutableScatterSet != null) {
                    it = value$iv2;
                    i8 = 0;
                    metadata = obj.metadata;
                    length += -2;
                    if (0 <= i5) {
                    } else {
                        this_$iv = this_$iv2;
                        i6 = i4;
                        value$iv = value$iv2;
                        obj2 = it;
                        i2 = index$iv$iv$iv;
                    }
                } else {
                    this_$iv = this_$iv2;
                    i6 = i4;
                    this_$iv2 = value$iv;
                    i4 = 0;
                    if ((MutableObjectIntMap)scopeToValues.get(this_$iv2) == null) {
                        value$iv2 = new MutableObjectIntMap(0, 1, 0);
                        i5 = 0;
                        scopeToValues.set(this_$iv2, value$iv2);
                        it = Unit.INSTANCE;
                    }
                    obj4.recordRead(obj5, id, this_$iv2, value$iv2);
                }
            } else {
                this_$iv = this_$iv2;
                i6 = i4;
                value$iv = value$iv2;
            }
        }
    }
    static {
        final int i = 8;
    }

    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> onChangedExecutor) {
        super();
        this.onChangedExecutor = onChangedExecutor;
        AtomicReference atomicReference = new AtomicReference(0);
        this.pendingChanges = atomicReference;
        SnapshotStateObserver.applyObserver.1 anon = new SnapshotStateObserver.applyObserver.1(this);
        this.applyObserver = (Function2)anon;
        SnapshotStateObserver.readObserver.1 anon2 = new SnapshotStateObserver.readObserver.1(this);
        this.readObserver = (Function1)anon2;
        int i = 0;
        final int i5 = 0;
        MutableVector mutableVector = new MutableVector(new SnapshotStateObserver.ObservedScopeMap[16], 0);
        this.observedScopeMaps = mutableVector;
        int i2 = -1;
    }

    public static final void access$addChanges(androidx.compose.runtime.snapshots.SnapshotStateObserver $this, Set set) {
        $this.addChanges(set);
    }

    public static final boolean access$drainChanges(androidx.compose.runtime.snapshots.SnapshotStateObserver $this) {
        return $this.drainChanges();
    }

    public static final androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap access$getCurrentMap$p(androidx.compose.runtime.snapshots.SnapshotStateObserver $this) {
        return $this.currentMap;
    }

    public static final MutableVector access$getObservedScopeMaps$p(androidx.compose.runtime.snapshots.SnapshotStateObserver $this) {
        return $this.observedScopeMaps;
    }

    public static final boolean access$getSendingNotifications$p(androidx.compose.runtime.snapshots.SnapshotStateObserver $this) {
        return $this.sendingNotifications;
    }

    public static final boolean access$isPaused$p(androidx.compose.runtime.snapshots.SnapshotStateObserver $this) {
        return $this.isPaused;
    }

    public static final void access$sendNotifications(androidx.compose.runtime.snapshots.SnapshotStateObserver $this) {
        $this.sendNotifications();
    }

    public static final void access$setSendingNotifications$p(androidx.compose.runtime.snapshots.SnapshotStateObserver $this, boolean <set-?>) {
        $this.sendingNotifications = <set-?>;
    }

    private final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listOf2;
        List listOf;
        obj = this.pendingChanges.get();
        while (obj == null) {
            listOf2 = set;
            obj = this.pendingChanges.get();
            listOf2 = CollectionsKt.plus((Collection)obj, (Iterable)CollectionsKt.listOf(set));
            Set[] arr = new Set[2];
            listOf2 = CollectionsKt.listOf(obj, set);
        }
        report();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private final boolean drainChanges() {
        int hasValues;
        int changes;
        boolean sendingNotifications;
        int i5;
        MutableVector observedScopeMaps2;
        int i2;
        Unit $i$a$SynchronizedSnapshotStateObserver$forEachScopeMap$1$iv;
        MutableVector observedScopeMaps;
        int i;
        int size;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i3;
        int i4;
        final Object obj2 = this;
        MutableVector observedScopeMaps3 = obj2.observedScopeMaps;
        changes = 0;
        int i6 = 0;
        int i7 = 0;
        synchronized (observedScopeMaps3) {
            obj2 = this;
            observedScopeMaps3 = obj2.observedScopeMaps;
            changes = 0;
            i6 = 0;
            i7 = 0;
        }
        return i7;
    }

    private final <T> androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        int i$iv;
        Object[] content;
        Object obj2;
        Object obj;
        int i;
        int i2;
        MutableVector observedScopeMaps = this.observedScopeMaps;
        int i3 = 0;
        int size = observedScopeMaps.getSize();
        int i4 = 1;
        if (size > 0) {
            i$iv = 0;
            i = 0;
            while ((SnapshotStateObserver.ObservedScopeMap)observedScopeMaps.getContent()[i$iv].getOnChanged() == onChanged) {
                i2 = i4;
                i = 0;
                i2 = 0;
            }
        } else {
            obj2 = 0;
        }
        Object this_$iv = obj2;
        if ((SnapshotStateObserver.ObservedScopeMap)this_$iv == null) {
            Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
            SnapshotStateObserver.ObservedScopeMap observedScopeMap = new SnapshotStateObserver.ObservedScopeMap((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, i4));
            int i5 = 0;
            this.observedScopeMaps.add(observedScopeMap);
            return observedScopeMap;
        }
        return (SnapshotStateObserver.ObservedScopeMap)this_$iv;
    }

    private final void forEachScopeMap(Function1<? super androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap, Unit> block) {
        int i$iv;
        Object[] content;
        Object obj;
        final int i = 0;
        final MutableVector observedScopeMaps = this.observedScopeMaps;
        final int i2 = 0;
        int i3 = 0;
        final MutableVector observedScopeMaps2 = this.observedScopeMaps;
        final int i4 = 0;
        final int size = observedScopeMaps2.getSize();
        synchronized (observedScopeMaps) {
            i$iv = 0;
            block.invoke(observedScopeMaps2.getContent()[i$iv]);
            while (i$iv++ >= size) {
                block.invoke(content[i$iv]);
            }
            Unit $i$a$SynchronizedSnapshotStateObserver$forEachScopeMap$1 = Unit.INSTANCE;
        }
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object result;
        int _new;
        boolean z;
        int subList;
        boolean size;
        int i2;
        int i;
        obj = this.pendingChanges.get();
        int i3 = 0;
        int i4 = 0;
        while (obj == null) {
            result = obj5;
            i2 = 1;
            i = 2;
            if ((List)obj.size() == i) {
            } else {
            }
            if ((List)obj.size() > i) {
            } else {
            }
            _new = subList;
            obj = this.pendingChanges.get();
            i3 = 0;
            i4 = 0;
            subList = (List)obj.subList(i2, (List)obj.size());
            subList = (List)obj.get(i2);
            result = obj;
            _new = 0;
        }
        return 0;
    }

    private final void removeScopeMapIf(Function1<? super androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap, Boolean> block) {
        int gap$iv;
        int i$iv;
        boolean booleanValue;
        int i;
        Object obj;
        final int i2 = 0;
        final MutableVector observedScopeMaps = this.observedScopeMaps;
        final int i3 = 0;
        int i4 = 0;
        final MutableVector observedScopeMaps2 = this.observedScopeMaps;
        final int i5 = 0;
        gap$iv = 0;
        final int size = observedScopeMaps2.getSize();
        i$iv = 0;
        synchronized (observedScopeMaps) {
            while (i$iv < size) {
                if ((Boolean)block.invoke(observedScopeMaps2.getContent()[i$iv]).booleanValue()) {
                } else {
                }
                if (gap$iv > 0) {
                }
                i$iv++;
                observedScopeMaps2.getContent()[i$iv - gap$iv] = observedScopeMaps2.getContent()[i$iv];
                gap$iv++;
            }
            ArraysKt.fill(observedScopeMaps2.getContent(), 0, size - gap$iv, size);
            observedScopeMaps2.setSize(size - gap$iv);
            Unit $i$a$SynchronizedSnapshotStateObserver$removeScopeMapIf$1 = Unit.INSTANCE;
        }
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private final void sendNotifications() {
        SnapshotStateObserver.sendNotifications.1 anon = new SnapshotStateObserver.sendNotifications.1(this);
        this.onChangedExecutor.invoke(anon);
    }

    public final void clear() {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        final Object obj2 = this;
        final int i2 = 0;
        final MutableVector observedScopeMaps = obj2.observedScopeMaps;
        final int i3 = 0;
        int i4 = 0;
        final MutableVector observedScopeMaps2 = obj2.observedScopeMaps;
        final int i5 = 0;
        final int size = observedScopeMaps2.getSize();
        synchronized (observedScopeMaps) {
            i$iv$iv = 0;
            i = 0;
            (SnapshotStateObserver.ObservedScopeMap)observedScopeMaps2.getContent()[i$iv$iv].clear();
            while (i$iv$iv++ >= size) {
                i = 0;
                (SnapshotStateObserver.ObservedScopeMap)content[i$iv$iv].clear();
            }
            Unit $i$a$SynchronizedSnapshotStateObserver$forEachScopeMap$1$iv = Unit.INSTANCE;
        }
    }

    public final void clear(Object scope) {
        int gap$iv$iv;
        int i$iv$iv;
        Object content;
        int i;
        boolean scopeObservations;
        final Object obj = this;
        final int i2 = 0;
        final MutableVector observedScopeMaps = obj.observedScopeMaps;
        final int i3 = 0;
        int i4 = 0;
        final MutableVector observedScopeMaps2 = obj.observedScopeMaps;
        final int i5 = 0;
        gap$iv$iv = 0;
        final int size = observedScopeMaps2.getSize();
        i$iv$iv = 0;
        synchronized (observedScopeMaps) {
            while (i$iv$iv < size) {
                content = observedScopeMaps2.getContent()[i$iv$iv];
                i = 0;
                (SnapshotStateObserver.ObservedScopeMap)content.clearScopeObservations(scope);
                if (!content.hasScopeObservations()) {
                } else {
                }
                if (gap$iv$iv > 0) {
                }
                i$iv$iv++;
                observedScopeMaps2.getContent()[i$iv$iv - gap$iv$iv] = observedScopeMaps2.getContent()[i$iv$iv];
                gap$iv$iv++;
            }
            try {
                ArraysKt.fill(observedScopeMaps2.getContent(), 0, size - gap$iv$iv, size);
                observedScopeMaps2.setSize(size - gap$iv$iv);
                Unit $i$a$SynchronizedSnapshotStateObserver$removeScopeMapIf$1$iv = Unit.INSTANCE;
                throw th;
            }
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        int gap$iv$iv;
        int i$iv$iv;
        Object content;
        int i;
        boolean scopeObservations;
        final Object obj = this;
        final int i2 = 0;
        final MutableVector observedScopeMaps = obj.observedScopeMaps;
        final int i3 = 0;
        int i4 = 0;
        final MutableVector observedScopeMaps2 = obj.observedScopeMaps;
        final int i5 = 0;
        gap$iv$iv = 0;
        final int size = observedScopeMaps2.getSize();
        i$iv$iv = 0;
        synchronized (observedScopeMaps) {
            while (i$iv$iv < size) {
                content = observedScopeMaps2.getContent()[i$iv$iv];
                i = 0;
                (SnapshotStateObserver.ObservedScopeMap)content.removeScopeIf(predicate);
                if (!content.hasScopeObservations()) {
                } else {
                }
                if (gap$iv$iv > 0) {
                }
                i$iv$iv++;
                observedScopeMaps2.getContent()[i$iv$iv - gap$iv$iv] = observedScopeMaps2.getContent()[i$iv$iv];
                gap$iv$iv++;
            }
            try {
                ArraysKt.fill(observedScopeMaps2.getContent(), 0, size - gap$iv$iv, size);
                observedScopeMaps2.setSize(size - gap$iv$iv);
                Unit $i$a$SynchronizedSnapshotStateObserver$removeScopeMapIf$1$iv = Unit.INSTANCE;
                throw th;
            }
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, androidx.compose.runtime.snapshots.Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        int cmp;
        int i;
        String $i$a$RequirePreconditionSnapshotStateObserver$observeReads$1;
        StringBuilder append;
        String str;
        MutableVector observedScopeMaps = this.observedScopeMaps;
        int i2 = 0;
        int i3 = 0;
        final androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap ensureMap = ensureMap(onValueChangedForScope);
        final long currentMapThreadId = this.currentMapThreadId;
        int i5 = 0;
        synchronized (observedScopeMaps) {
            observedScopeMaps = this.observedScopeMaps;
            i2 = 0;
            i3 = 0;
            ensureMap = ensureMap(onValueChangedForScope);
            currentMapThreadId = this.currentMapThreadId;
            i5 = 0;
        }
        cmp = Long.compare(currentMapThreadId, currentThreadId2) == 0 ? 1 : i5;
        i = 0;
        if (cmp == 0) {
            try {
                int i6 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                PreconditionsKt.throwIllegalArgumentException(stringBuilder.append("Detected multithreaded access to SnapshotStateObserver: previousThreadId=").append(currentMapThreadId).append("), currentThread={id=").append(ActualJvm_jvmKt.currentThreadId()).append(", name=").append(ActualJvm_jvmKt.currentThreadName()).append("}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.").toString());
                this.isPaused = i5;
                this.currentMap = ensureMap;
                this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
                ensureMap.observe(scope, this.readObserver, block);
                this.currentMap = this.currentMap;
                this.isPaused = this.isPaused;
                this.currentMapThreadId = currentMapThreadId;
                this.currentMap = obj1;
                this.isPaused = obj0;
                this.currentMapThreadId = obj4;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        final androidx.compose.runtime.snapshots.ObserverHandle applyUnsubscribe = this.applyUnsubscribe;
        if (applyUnsubscribe != null) {
            applyUnsubscribe.dispose();
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(...))
    public final void withNoObservations(Function0<Unit> block) {
        this.isPaused = true;
        block.invoke();
        this.isPaused = this.isPaused;
    }
}
