package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¥\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010X\u001a\u00020\u001aH\u0016J\u0018\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020\u0013H\u0002J\u001e\u0010Y\u001a\u00020\u001a2\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020,0+2\u0006\u0010[\u001a\u00020\u0013H\u0002J\u0008\u0010]\u001a\u00020\u001aH\u0016J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0008\u0010_\u001a\u00020\u001aH\u0016J\u0008\u0010`\u001a\u00020\u001aH\u0016J\u0008\u0010a\u001a\u00020\u001aH\u0002J \u0010b\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\u0008\u001bH\u0016¢\u0006\u0002\u0010\u001fJ \u0010d\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\u0008\u001bH\u0002¢\u0006\u0002\u0010\u001fJ\r\u0010e\u001a\u00020:H\u0000¢\u0006\u0002\u0008fJ\u0008\u0010g\u001a\u00020\u001aH\u0016J3\u0010h\u001a\u0002Hi\"\u0004\u0008\u0000\u0010i2\u0008\u0010j\u001a\u0004\u0018\u00010\u00012\u0006\u0010k\u001a\u00020:2\u000c\u0010l\u001a\u0008\u0012\u0004\u0012\u0002Hi0\u0019H\u0016¢\u0006\u0002\u0010mJ\u0008\u0010n\u001a\u00020\u001aH\u0016J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020qH\u0016J\u0008\u0010r\u001a\u00020\u001aH\u0002J\u0008\u0010s\u001a\u00020\u001aH\u0002J#\u0010t\u001a\u0004\u0018\u0001Hu\"\u0004\u0008\u0000\u0010u2\u000c\u0010v\u001a\u0008\u0012\u0004\u0012\u0002Hu0wH\u0016¢\u0006\u0002\u0010xJ\"\u0010y\u001a\u0002Hu\"\u0004\u0008\u0000\u0010u2\u000c\u0010l\u001a\u0008\u0012\u0004\u0012\u0002Hu0\u0019H\u0082\u0008¢\u0006\u0002\u0010zJC\u0010{\u001a\u0002Hu\"\u0004\u0008\u0000\u0010u2-\u0010l\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00¢\u0006\u000c\u0008}\u0012\u0008\u0008~\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u0002Hu0|H\u0082\u0008¢\u0006\u0002\u0010\u007fJ)\u0010\u0080\u0001\u001a\u00020\u001a2\u001e\u0010\u0081\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010\u0082\u00010$H\u0016J\u001e\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020%2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u001aH\u0016J(\u0010\u0089\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020%2\u0008\u0010\u008a\u0001\u001a\u00030\u008b\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0002J\u000f\u0010\u008c\u0001\u001a\u00020\u001a2\u0006\u0010v\u001a\u00020:J\u0011\u0010\u008d\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0002J\u001a\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0000¢\u0006\u0003\u0008\u0092\u0001J\u000c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0002J\u0017\u0010\u0093\u0001\u001a\u00020\u00132\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020,0+H\u0016J\u0017\u0010\u0094\u0001\u001a\u00020\u001a2\u000c\u0010l\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\u001a2\u0007\u0010\u0086\u0001\u001a\u00020%H\u0016J\u0017\u0010\u0097\u0001\u001a\u00020\u001a2\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020,0+H\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u001b\u0010\u009a\u0001\u001a\u00020\u001a2\n\u0010p\u001a\u0006\u0012\u0002\u0008\u000301H\u0000¢\u0006\u0003\u0008\u009b\u0001J!\u0010\u009c\u0001\u001a\u00020\u001a2\u0007\u0010\u0087\u0001\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020%H\u0000¢\u0006\u0003\u0008\u009d\u0001J!\u0010\u009e\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\u0008\u001bH\u0016¢\u0006\u0002\u0010\u001fJ!\u0010\u009f\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\u0008\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00H\u0002J#\u0010¡\u0001\u001a\u0002Hu\"\u0004\u0008\u0000\u0010u2\u000c\u0010l\u001a\u0008\u0012\u0004\u0012\u0002Hu0\u0019H\u0082\u0008¢\u0006\u0002\u0010zJ\u001d\u0010¢\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020%2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0002J\u0011\u0010£\u0001\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020TH\u0002J\t\u0010¤\u0001\u001a\u00020\u001aH\u0016R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\u0008\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u0008\u0012\u0004\u0012\u00020%0$8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u0014\u0010(\u001a\u0008\u0012\u0004\u0012\u00020%0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u0008\u0012\u0004\u0012\u00020,0+8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030100X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00084\u0010\u0015R\u0014\u00105\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00086\u0010\u0015R\u0014\u00107\u001a\u0008\u0012\u0004\u0012\u00020%0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008<\u0010\u0015R\u0014\u0010=\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008=\u0010\u0015R\u0011\u0010>\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010\u0015R\u000e\u0010?\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u0008\u0012\u0004\u0012\u00020,0+8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008D\u0010.R\u0014\u0010E\u001a\u00020FX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010HR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010I\u001a\u00020\u0013X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008J\u0010\u0011\u001a\u0004\u0008K\u0010\u0015\"\u0004\u0008L\u0010MR\"\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,0Oj\n\u0012\u0006\u0012\u0004\u0018\u00010,`PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008Q\u0010RR\u001a\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008U\u0010\u0011\u001a\u0004\u0008V\u0010W¨\u0006¦\u0001", d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "Landroidx/collection/MutableScatterSet;", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidatedScopes", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "values", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "composeInitial", "composerStacksSizes", "composerStacksSizes$runtime_release", "deactivate", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompositionImpl implements androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.ReusableComposition, androidx.compose.runtime.RecomposeScopeOwner, androidx.compose.runtime.CompositionServices {

    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<androidx.compose.runtime.RememberObserver> abandonSet;
    private final androidx.compose.runtime.Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> composable;
    private final androidx.compose.runtime.ComposerImpl composer;
    private final MutableScatterSet<androidx.compose.runtime.RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<Object, androidx.compose.runtime.DerivedState<?>> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<androidx.compose.runtime.RecomposeScopeImpl> invalidatedScopes;
    private androidx.compose.runtime.CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final ScopeMap<Object, androidx.compose.runtime.RecomposeScopeImpl> observations;
    private final ScopeMap<Object, androidx.compose.runtime.RecomposeScopeImpl> observationsProcessed;
    private final androidx.compose.runtime.CompositionObserverHolder observerHolder;
    private final androidx.compose.runtime.CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final androidx.compose.runtime.SlotTable slotTable;

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00132\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "afters", "Landroidx/collection/MutableIntList;", "leaving", "", "", "pending", "priorities", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "endRelativeOrder", "", "priority", "endRelativeAfter", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "forgetting", "processPendingLeaving", "recordLeaving", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RememberEventDispatcher implements androidx.compose.runtime.RememberManager {

        private final Set<androidx.compose.runtime.RememberObserver> abandoning;
        private final MutableIntList afters;
        private final List<Object> leaving;
        private final List<Object> pending;
        private final MutableIntList priorities;
        private MutableScatterSet<androidx.compose.runtime.ComposeNodeLifecycleCallback> releasing;
        private final List<androidx.compose.runtime.RememberObserver> remembering;
        private final List<Function0<Unit>> sideEffects;
        public RememberEventDispatcher(Set<androidx.compose.runtime.RememberObserver> abandoning) {
            super();
            this.abandoning = abandoning;
            ArrayList arrayList = new ArrayList();
            this.remembering = (List)arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.leaving = (List)arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.sideEffects = (List)arrayList3;
            ArrayList arrayList4 = new ArrayList();
            this.pending = (List)arrayList4;
            final int i = 0;
            final int i2 = 1;
            final int i3 = 0;
            MutableIntList mutableIntList = new MutableIntList(i, i2, i3);
            this.priorities = mutableIntList;
            MutableIntList mutableIntList2 = new MutableIntList(i, i2, i3);
            this.afters = mutableIntList2;
        }

        private final void processPendingLeaving(int endRelativeOrder) {
            boolean index;
            int toAdd;
            int toAddAfter;
            int toAddPriority;
            int i5;
            int i;
            String mutableIntList;
            int j;
            int size;
            int i2;
            int i3;
            int i6;
            MutableIntList list;
            int i4;
            if (!(Collection)this.pending.isEmpty()) {
                index = 0;
                toAdd = 0;
                toAddAfter = 0;
                toAddPriority = 0;
                mutableIntList = "null cannot be cast to non-null type androidx.collection.MutableIntList";
                j = 1;
                while (index < this.afters.getSize()) {
                    if (endRelativeOrder <= this.afters.get(index)) {
                    } else {
                    }
                    index++;
                    mutableIntList = "null cannot be cast to non-null type androidx.collection.MutableIntList";
                    j = 1;
                    i5 = this.pending.remove(index);
                    size = this.afters.removeAt(index);
                    i2 = this.priorities.removeAt(index);
                    if (toAdd == 0) {
                    } else {
                    }
                    Intrinsics.checkNotNull(toAddPriority, mutableIntList);
                    Intrinsics.checkNotNull(toAddAfter, mutableIntList);
                    toAdd.add(i5);
                    toAddAfter.add(size);
                    toAddPriority.add(i2);
                    toAdd = CollectionsKt.mutableListOf(/* result */);
                    int i8 = 0;
                    i6 = 0;
                    MutableIntList mutableIntList2 = new MutableIntList(i8, j, i6);
                    i4 = 0;
                    mutableIntList2.add(size);
                    toAddAfter = mutableIntList2;
                    mutableIntList = new MutableIntList(i8, j, i6);
                    i3 = 0;
                    mutableIntList.add(i2);
                    toAddPriority = mutableIntList;
                }
                if (toAdd != 0) {
                    Intrinsics.checkNotNull(toAddPriority, mutableIntList);
                    Intrinsics.checkNotNull(toAddAfter, mutableIntList);
                    i = 0;
                    while (i < size2 -= j) {
                        j = i + 1;
                        while (j < toAdd.size()) {
                            i2 = toAddAfter.get(i);
                            i3 = toAddAfter.get(j);
                            if (i2 >= i3) {
                            } else {
                            }
                            CompositionKt.access$swap(toAdd, i, j);
                            CompositionKt.access$swap(toAddPriority, i, j);
                            CompositionKt.access$swap(toAddAfter, i, j);
                            j++;
                            if (i3 == i2 && toAddPriority.get(i) < toAddPriority.get(j)) {
                            }
                            if (toAddPriority.get(i) < toAddPriority.get(j)) {
                            }
                        }
                        i++;
                        i2 = toAddAfter.get(i);
                        i3 = toAddAfter.get(j);
                        if (i2 >= i3) {
                        } else {
                        }
                        CompositionKt.access$swap(toAdd, i, j);
                        CompositionKt.access$swap(toAddPriority, i, j);
                        CompositionKt.access$swap(toAddAfter, i, j);
                        j++;
                        if (i3 == i2 && toAddPriority.get(i) < toAddPriority.get(j)) {
                        }
                        if (toAddPriority.get(i) < toAddPriority.get(j)) {
                        }
                    }
                    this.leaving.addAll((Collection)toAdd);
                }
            }
        }

        private final void recordLeaving(Object instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            int i;
            Object leaving;
            processPendingLeaving(endRelativeOrder);
            i = 0;
            if (endRelativeAfter >= 0 && endRelativeAfter < endRelativeOrder) {
                if (endRelativeAfter < endRelativeOrder) {
                    i = 1;
                }
            }
            if (i != 0) {
                this.pending.add(instance);
                this.priorities.add(priority);
                this.afters.add(endRelativeAfter);
            } else {
                this.leaving.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(androidx.compose.runtime.ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void dispatchAbandons() {
            boolean empty;
            int i;
            Object beginSection;
            Object iNSTANCE;
            Object iNSTANCE2;
            Object next;
            if (!(Collection)this.abandoning.isEmpty()) {
                i = 0;
                int i2 = 0;
                iNSTANCE2 = this.abandoning.iterator();
                for (RememberObserver next : iNSTANCE2) {
                    iNSTANCE2.remove();
                    next.onAbandoned();
                }
                Unit iNSTANCE4 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:abandons"));
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void dispatchRememberObservers() {
            boolean empty2;
            boolean empty;
            int i;
            Object beginSection;
            Object iNSTANCE2;
            Object iNSTANCE;
            int i2;
            Object index$iv;
            boolean contains;
            boolean obj;
            Object obj2;
            Object obj3;
            int i3;
            Set abandoning;
            processPendingLeaving(Integer.MIN_VALUE);
            if (!(Collection)this.leaving.isEmpty()) {
                i = 0;
                int i5 = 0;
                iNSTANCE = this.releasing;
                size--;
                while (-1 < i2) {
                    index$iv = this.leaving.get(i2);
                    if (index$iv instanceof RememberObserver) {
                    }
                    if (index$iv instanceof ComposeNodeLifecycleCallback != null) {
                    }
                    i2--;
                    if (iNSTANCE != null && iNSTANCE.contains(index$iv)) {
                    } else {
                    }
                    (ComposeNodeLifecycleCallback)index$iv.onDeactivate();
                    if (iNSTANCE.contains(index$iv)) {
                    } else {
                    }
                    (ComposeNodeLifecycleCallback)index$iv.onRelease();
                    this.abandoning.remove(index$iv);
                    (RememberObserver)index$iv.onForgotten();
                }
                Unit iNSTANCE5 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:onForgotten"));
            }
            if (!(Collection)this.remembering.isEmpty()) {
                i = 0;
                int i6 = 0;
                iNSTANCE = this.remembering;
                i2 = 0;
                index$iv = 0;
                while (index$iv < iNSTANCE.size()) {
                    obj3 = obj2;
                    i3 = 0;
                    this.abandoning.remove((RememberObserver)obj3);
                    obj3.onRemembered();
                    index$iv++;
                }
                Unit iNSTANCE6 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:onRemembered"));
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public final void dispatchSideEffects() {
            boolean empty;
            int i3;
            Object beginSection;
            Object iNSTANCE;
            Object $this$fastForEach$iv;
            int i2;
            int index$iv;
            int size;
            Object obj;
            Object obj2;
            int i;
            if (!(Collection)this.sideEffects.isEmpty()) {
                i3 = 0;
                int i4 = 0;
                List sideEffects2 = this.sideEffects;
                i2 = 0;
                index$iv = 0;
                while (index$iv < sideEffects2.size()) {
                    i = 0;
                    (Function0)sideEffects2.get(index$iv).invoke();
                    index$iv++;
                }
                this.sideEffects.clear();
                Unit iNSTANCE3 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:sideeffects"));
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(androidx.compose.runtime.RememberObserver instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(androidx.compose.runtime.ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            MutableScatterSet mutableScatterSetOf;
            MutableScatterSet set;
            int i;
            if (this.releasing == null) {
                i = 0;
                this.releasing = ScatterSetKt.mutableScatterSetOf();
            }
            mutableScatterSetOf.plusAssign(instance);
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(androidx.compose.runtime.RememberObserver instance) {
            this.remembering.add(instance);
        }

        public void sideEffect(Function0<Unit> effect) {
            (Collection)this.sideEffects.add(effect);
        }
    }
    static {
        final int i = 8;
    }

    public CompositionImpl(androidx.compose.runtime.CompositionContext parent, androidx.compose.runtime.Applier<?> applier, CoroutineContext recomposeContext) {
        super();
        this.parent = parent;
        this.applier = applier;
        int i = 0;
        AtomicReference atomicReference = new AtomicReference(i);
        this.pendingModifications = atomicReference;
        Object object = new Object();
        this.lock = object;
        int i3 = 0;
        int i4 = 1;
        MutableScatterSet mutableScatterSet = new MutableScatterSet(i3, i4, i);
        this.abandonSet = mutableScatterSet.asMutableSet();
        SlotTable slotTable = new SlotTable();
        androidx.compose.runtime.SlotTable slotTable2 = slotTable;
        int i6 = 0;
        if (this.parent.getCollectingCallByInformation$runtime_release()) {
            slotTable2.collectCalledByInformation();
        }
        if (this.parent.getCollectingSourceInformation$runtime_release()) {
            slotTable2.collectSourceInformation();
        }
        this.slotTable = slotTable;
        ScopeMap scopeMap = new ScopeMap();
        this.observations = scopeMap;
        MutableScatterSet mutableScatterSet2 = new MutableScatterSet(i3, i4, i);
        this.invalidatedScopes = mutableScatterSet2;
        MutableScatterSet mutableScatterSet3 = new MutableScatterSet(i3, i4, i);
        this.conditionallyInvalidatedScopes = mutableScatterSet3;
        ScopeMap scopeMap2 = new ScopeMap();
        this.derivedStates = scopeMap2;
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        ScopeMap scopeMap3 = new ScopeMap();
        this.observationsProcessed = scopeMap3;
        ScopeMap scopeMap4 = new ScopeMap();
        this.invalidations = scopeMap4;
        CompositionObserverHolder compositionObserverHolder = new CompositionObserverHolder(i, i3, 3, i);
        this.observerHolder = compositionObserverHolder;
        ComposerImpl composerImpl3 = new ComposerImpl(this.applier, this.parent, this.slotTable, this.abandonSet, this.changes, this.lateChanges, (ControlledComposition)this);
        int i2 = 0;
        this.parent.registerComposer$runtime_release((Composer)composerImpl3);
        this.composer = composerImpl3;
        this._recomposeContext = recomposeContext;
        this.isRoot = parent2 instanceof Recomposer;
        this.composable = ComposableSingletons.CompositionKt.INSTANCE.getLambda-1$runtime_release();
    }

    public CompositionImpl(androidx.compose.runtime.CompositionContext compositionContext, androidx.compose.runtime.Applier applier2, CoroutineContext coroutineContext3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(compositionContext, applier2, obj3);
    }

    public static final Object access$getLock$p(androidx.compose.runtime.CompositionImpl $this) {
        return $this.lock;
    }

    public static final ScopeMap access$getObservations$p(androidx.compose.runtime.CompositionImpl $this) {
        return $this.observations;
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        ScopeMap $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i;
        Object conditionallyInvalidatedScopes;
        Object index$iv$iv$iv2;
        int i6;
        Object[] elements;
        Object obj2;
        int i8;
        long[] metadata;
        int i7;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        Object obj;
        int i5;
        ScopeMap this_$iv;
        int i2;
        long l;
        int i9;
        int i4;
        int i3;
        int index$iv$iv$iv;
        final Object obj3 = this;
        final Object obj4 = value;
        $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = obj3.observations;
        i = 0;
        conditionallyInvalidatedScopes = $this$maskEmptyOrDeleted$iv$iv$iv$iv2.getMap().get(obj4);
        if (conditionallyInvalidatedScopes != null) {
            if (conditionallyInvalidatedScopes instanceof MutableScatterSet != null) {
                index$iv$iv$iv2 = conditionallyInvalidatedScopes;
                i6 = 0;
                i8 = 0;
                metadata = obj2.metadata;
                length += -2;
                if (0 <= i7) {
                } else {
                    this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                    i2 = i;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv = conditionallyInvalidatedScopes;
                    obj = index$iv$iv$iv2;
                }
            } else {
                this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                i2 = i;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
                i = 0;
                if (!obj3.observationsProcessed.remove(obj4, (RecomposeScopeImpl)$this$maskEmptyOrDeleted$iv$iv$iv$iv2) && $this$maskEmptyOrDeleted$iv$iv$iv$iv2.invalidateForResult(obj4) != InvalidationResult.IGNORED) {
                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv2.invalidateForResult(obj4) != InvalidationResult.IGNORED) {
                        if ($this$maskEmptyOrDeleted$iv$iv$iv$iv2.isConditional() && !forgetConditionalScopes) {
                            if (!forgetConditionalScopes) {
                                obj3.conditionallyInvalidatedScopes.add($this$maskEmptyOrDeleted$iv$iv$iv$iv2);
                            } else {
                                obj3.invalidatedScopes.add($this$maskEmptyOrDeleted$iv$iv$iv$iv2);
                            }
                        } else {
                        }
                    }
                }
            }
        } else {
            this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            i2 = i;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = conditionallyInvalidatedScopes;
        }
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        Object scope2;
        String z;
        String str;
        Object $this$fastForEach$iv;
        MutableScatterSet conditionallyInvalidatedScopes;
        int $i$f$forEach;
        Object $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
        String m$iv$iv$iv;
        boolean $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
        int i2;
        int j$iv$iv$iv4;
        Object[] j$iv$iv$iv3;
        int i$iv$iv$iv2;
        int value$iv3;
        Object value$iv2;
        androidx.collection.ScatterSet scope;
        long[] index$iv$iv2;
        int m$iv$iv$iv2;
        int $i$f$isFull;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        Object this_$iv$iv$iv;
        Object j$iv$iv$iv2;
        long[] metadata;
        int index$iv$iv3;
        int scope3;
        int index$iv$iv;
        int i$iv$iv$iv;
        Object[] slot$iv$iv$iv4;
        Object $this$forEach$iv$iv;
        Object $this$forEach$iv$iv2;
        int i8;
        int cmp4;
        int i3;
        int i6;
        int slot$iv$iv$iv3;
        int cmp2;
        long l;
        ScopeMap $this$maskEmptyOrDeleted$iv$iv$iv$iv7;
        int i7;
        long l2;
        int i4;
        MutableScatterSet conditionallyInvalidatedScopes2;
        Object j$iv$iv$iv5;
        Object obj;
        int i;
        long slot$iv$iv$iv2;
        Object value$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i5;
        Object[] $i$f$isFull2;
        Object slot$iv$iv$iv5;
        long[] slot$iv$iv$iv;
        long $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
        Object[] $this$maskEmptyOrDeleted$iv$iv$iv$iv5;
        androidx.collection.ScatterSet j$iv$iv$iv6;
        int $i$f$removeIf;
        androidx.collection.ScatterSet this_$iv$iv;
        int cmp3;
        int cmp;
        int j$iv$iv$iv;
        scope2 = this;
        z = forgetConditionalScopes;
        $this$fastForEach$iv = values;
        $i$f$forEach = 0;
        if ($this$fastForEach$iv instanceof ScatterSetWrapper) {
            $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = (ScatterSetWrapper)$this$fastForEach$iv.getSet$runtime_release();
            $this$forEach$iv$iv = 0;
            i8 = 128;
            scope = $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
            cmp4 = 0;
            i3 = 255;
            index$iv$iv2 = scope.metadata;
            length += -2;
            i6 = 7;
            if (0 <= $i$f$isFull) {
            } else {
                j$iv$iv$iv5 = $this$fastForEach$iv;
                i = $i$f$forEach;
                this_$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = j$iv$iv$iv3;
                j$iv$iv$iv6 = scope;
                l2 = -9187201950435737472L;
            }
        } else {
            i = $i$f$forEach;
            l2 = -9187201950435737472L;
            $i$f$forEach = 0;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = (Iterable)$this$fastForEach$iv.iterator();
            while ($this$maskEmptyOrDeleted$iv$iv$iv$iv6.hasNext()) {
                $this$maskEmptyOrDeleted$iv$iv$iv$iv8 = $this$maskEmptyOrDeleted$iv$iv$iv$iv6.next();
                j$iv$iv$iv3 = $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
                scope = 0;
                if (j$iv$iv$iv3 instanceof RecomposeScopeImpl) {
                } else {
                }
                $i$f$isFull = 0;
                scope2.addPendingInvalidationsLocked(j$iv$iv$iv3, z);
                $this$maskEmptyOrDeleted$iv$iv$iv$iv = 0;
                this_$iv$iv$iv = scope2.derivedStates.getMap().get(j$iv$iv$iv3);
                if (this_$iv$iv$iv != null) {
                } else {
                }
                $this$forEach$iv$iv2 = $this$fastForEach$iv;
                slot$iv$iv$iv3 = $i$f$forEach;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv7 = $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
                i4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
                obj = j$iv$iv$iv3;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = scope;
                $this$fastForEach$iv = $this$forEach$iv$iv2;
                $i$f$forEach = slot$iv$iv$iv3;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = $this$maskEmptyOrDeleted$iv$iv$iv$iv7;
                if (this_$iv$iv$iv instanceof MutableScatterSet != null) {
                } else {
                }
                $this$forEach$iv$iv2 = $this$fastForEach$iv;
                slot$iv$iv$iv3 = $i$f$forEach;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv7 = $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
                i4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
                obj = j$iv$iv$iv3;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = scope;
                $i$f$forEach = 0;
                scope2.addPendingInvalidationsLocked((DerivedState)this_$iv$iv$iv, z);
                j$iv$iv$iv2 = this_$iv$iv$iv;
                i$iv$iv$iv = 0;
                cmp4 = 0;
                metadata = $i$f$isFull.metadata;
                $this$forEach$iv$iv2 = $this$fastForEach$iv;
                $this$forEach$iv$iv3 += -2;
                slot$iv$iv$iv3 = $i$f$forEach;
                if (0 <= $this$fastForEach$iv) {
                } else {
                }
                $this$maskEmptyOrDeleted$iv$iv$iv$iv7 = $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
                i4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
                obj = j$iv$iv$iv3;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = scope;
                cmp2 = 0;
                long l3 = l9;
                while (Long.compare($this$maskEmptyOrDeleted$iv$iv$iv$iv9, l2) != 0) {
                    i2 = 8;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = i11 - 8;
                    j$iv$iv$iv3 = 0;
                    while (j$iv$iv$iv3 < $this$maskEmptyOrDeleted$iv$iv$iv$iv6) {
                        int i34 = 0;
                        if (Long.compare(i5, i8) < 0) {
                        } else {
                        }
                        scope = 0;
                        if (scope != 0) {
                        }
                        slot$iv$iv$iv2 >>= i2;
                        j$iv$iv$iv3++;
                        i7 = 0;
                        i5 = 0;
                        scope2.addPendingInvalidationsLocked((DerivedState)j$iv$iv$iv2.elements[i35 += j$iv$iv$iv3], z);
                        scope = 1;
                    }
                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv6 == 8) {
                        break loop_51;
                    }
                    if ($i$f$forEach == $this$fastForEach$iv) {
                        break loop_51;
                    } else {
                    }
                    $i$f$forEach++;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = $this$maskEmptyOrDeleted$iv$iv$iv$iv7;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv8 = i4;
                    j$iv$iv$iv3 = obj;
                    scope = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                    cmp2 = 0;
                    l3 = l9;
                    i34 = 0;
                    if (Long.compare(i5, i8) < 0) {
                    } else {
                    }
                    scope = 0;
                    if (scope != 0) {
                    }
                    slot$iv$iv$iv2 >>= i2;
                    j$iv$iv$iv3++;
                    i7 = 0;
                    i5 = 0;
                    scope2.addPendingInvalidationsLocked((DerivedState)slot$iv$iv$iv4[i35 += j$iv$iv$iv3], z);
                    scope = 1;
                }
                if ($i$f$forEach != $this$fastForEach$iv) {
                } else {
                }
                $i$f$forEach++;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = $this$maskEmptyOrDeleted$iv$iv$iv$iv7;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv8 = i4;
                j$iv$iv$iv3 = obj;
                scope = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                i2 = 8;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = i11 - 8;
                j$iv$iv$iv3 = 0;
                while (j$iv$iv$iv3 < $this$maskEmptyOrDeleted$iv$iv$iv$iv6) {
                    i34 = 0;
                    if (Long.compare(i5, i8) < 0) {
                    } else {
                    }
                    scope = 0;
                    if (scope != 0) {
                    }
                    slot$iv$iv$iv2 >>= i2;
                    j$iv$iv$iv3++;
                    i7 = 0;
                    i5 = 0;
                    scope2.addPendingInvalidationsLocked((DerivedState)slot$iv$iv$iv4[i35 += j$iv$iv$iv3], z);
                    scope = 1;
                }
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv6 == 8) {
                }
                i34 = 0;
                if (Long.compare(i5, i8) < 0) {
                } else {
                }
                scope = 0;
                if (scope != 0) {
                }
                slot$iv$iv$iv2 >>= i2;
                j$iv$iv$iv3++;
                i7 = 0;
                i5 = 0;
                scope2.addPendingInvalidationsLocked((DerivedState)slot$iv$iv$iv4[i35 += j$iv$iv$iv3], z);
                scope = 1;
                (RecomposeScopeImpl)j$iv$iv$iv3.invalidateForResult(0);
                $this$forEach$iv$iv2 = $this$fastForEach$iv;
                slot$iv$iv$iv3 = $i$f$forEach;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv7 = $this$maskEmptyOrDeleted$iv$iv$iv$iv6;
                i4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
                obj = j$iv$iv$iv3;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = scope;
            }
            $this$forEach$iv$iv = $this$fastForEach$iv;
            slot$iv$iv$iv3 = $i$f$forEach;
        }
        conditionallyInvalidatedScopes = scope2.conditionallyInvalidatedScopes;
        MutableScatterSet invalidatedScopes = scope2.invalidatedScopes;
        if (z && conditionallyInvalidatedScopes.isNotEmpty()) {
            if (conditionallyInvalidatedScopes.isNotEmpty()) {
                scope = scope2.observations;
                $i$f$isFull = scope.getMap();
                this_$iv$iv$iv = $i$f$isFull;
                i$iv$iv$iv = this_$iv$iv$iv.metadata;
                slot$iv$iv$iv4 = length3 + -2;
                if (0 <= slot$iv$iv$iv4) {
                } else {
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv7 = scope;
                    i7 = index$iv$iv2;
                    $i$f$removeIf = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
                    this_$iv$iv = this_$iv$iv$iv;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = j$iv$iv$iv2;
                }
                conditionallyInvalidatedScopes.clear();
                scope2.cleanUpDerivedStateObservations();
                conditionallyInvalidatedScopes2 = conditionallyInvalidatedScopes;
            } else {
                if (invalidatedScopes.isNotEmpty()) {
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv8 = scope2.observations;
                    scope = $this$maskEmptyOrDeleted$iv$iv$iv$iv8.getMap();
                    $i$f$isFull = scope;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv = 0;
                    this_$iv$iv$iv = $i$f$isFull.metadata;
                    length2 += -2;
                    if (0 <= j$iv$iv$iv2) {
                    } else {
                        conditionallyInvalidatedScopes2 = conditionallyInvalidatedScopes;
                        slot$iv$iv$iv3 = $this$maskEmptyOrDeleted$iv$iv$iv$iv8;
                        cmp2 = i$iv$iv$iv2;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = index$iv$iv2;
                        $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = $i$f$isFull;
                    }
                    cleanUpDerivedStateObservations();
                    invalidatedScopes.clear();
                } else {
                    conditionallyInvalidatedScopes2 = conditionallyInvalidatedScopes;
                }
            }
        } else {
        }
    }

    private final void applyChangesInLocked(ChangeList changes) {
        int index$iv$iv;
        Object obj3;
        boolean pendingInvalidScopes;
        androidx.compose.runtime.Trace empty2;
        androidx.compose.runtime.CompositionImpl.RememberEventDispatcher $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
        String str2;
        int i2;
        Object obj2;
        int i$iv$iv$iv;
        ScopeMap m$iv$iv$iv;
        int $i$f$isFull;
        Object map2;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        MutableScatterMap j$iv$iv$iv;
        int j$iv$iv$iv2;
        int value$iv$iv$iv$iv;
        long[] metadata;
        androidx.compose.runtime.CompositionImpl.RememberEventDispatcher rememberEventDispatcher;
        Object obj7;
        long slot$iv$iv$iv;
        ScopeMap $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
        int i12;
        int cmp;
        androidx.compose.runtime.Trace trace;
        String str;
        int i11;
        long l;
        int i8;
        int i9;
        int i13;
        int i3;
        int empty;
        int i;
        int i6;
        int this_$iv$iv;
        int i5;
        Object obj4;
        int i7;
        int this_$iv$iv$iv;
        Object[] objArr;
        Object obj;
        long[] lArr;
        long slot$iv$iv$iv2;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        long[] lArr2;
        int i4;
        int $i$f$removeIf;
        MutableScatterMap map;
        int cmp2;
        int i10;
        boolean valid;
        final Object obj5 = this;
        CompositionImpl.RememberEventDispatcher rememberEventDispatcher2 = new CompositionImpl.RememberEventDispatcher(obj5.abandonSet);
        $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = rememberEventDispatcher2;
        if (changes.isEmpty() && obj5.lateChanges.isEmpty()) {
            if (obj5.lateChanges.isEmpty()) {
                $this$maskEmptyOrDeleted$iv$iv$iv$iv4.dispatchAbandons();
            }
        }
        i2 = 0;
        i$iv$iv$iv = 0;
        obj5.applier.onBeginChanges();
        $i$f$isFull = 0;
        map2 = writer;
        $this$maskEmptyOrDeleted$iv$iv$iv$iv = 0;
        j$iv$iv$iv = 0;
        int i24 = 0;
        changes.executeAndFlushAllPendingChanges(obj5.applier, map2, (RememberManager)$this$maskEmptyOrDeleted$iv$iv$iv$iv4);
        Unit slots = Unit.INSTANCE;
        value$iv$iv$iv$iv = 0;
        map2.close(true);
        obj5.applier.onEndChanges();
        Unit iNSTANCE2 = Unit.INSTANCE;
        Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:applyChanges"));
        $this$maskEmptyOrDeleted$iv$iv$iv$iv4.dispatchRememberObservers();
        $this$maskEmptyOrDeleted$iv$iv$iv$iv4.dispatchSideEffects();
        if (obj5.pendingInvalidScopes) {
            str2 = str4;
            obj5.pendingInvalidScopes = false;
            m$iv$iv$iv = obj5.observations;
            map2 = m$iv$iv$iv.getMap();
            j$iv$iv$iv = map2;
            metadata = j$iv$iv$iv.metadata;
            length += -2;
            if (0 <= rememberEventDispatcher) {
            } else {
                i6 = index$iv$iv;
                trace = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
                str = str2;
                this_$iv$iv = i2;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = m$iv$iv$iv;
                i12 = $i$f$isFull;
                $i$f$removeIf = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
                map = j$iv$iv$iv;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = value$iv$iv$iv$iv;
                lArr2 = metadata;
            }
            obj5.cleanUpDerivedStateObservations();
            Unit iNSTANCE5 = Unit.INSTANCE;
            Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection(str2));
        } else {
            trace = $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
        }
        if (obj5.lateChanges.isEmpty()) {
            trace.dispatchAbandons();
        }
    }

    private final void cleanUpDerivedStateObservations() {
        ScopeMap derivedState;
        boolean conditionallyInvalidatedScopes;
        int i13;
        MutableScatterMap elements;
        int m$iv$iv$iv2;
        MutableScatterMap $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int j$iv$iv$iv;
        int j$iv$iv$iv3;
        long[] metadata;
        int i$iv$iv;
        int i$iv$iv$iv;
        int i3;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int value$iv$iv$iv$iv;
        int value$iv$iv$iv$iv2;
        int index$iv$iv;
        int value$iv$iv$iv;
        int i12;
        Object obj2;
        long slot$iv$iv$iv;
        int i;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
        int conditional;
        int i8;
        int cmp;
        int i10;
        int i4;
        int this_$iv$iv;
        int i2;
        ScopeMap this_$iv;
        Object[] objArr;
        int i7;
        int i9;
        Object obj;
        long[] lArr;
        long slot$iv$iv$iv2;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv4;
        int i6;
        int i5;
        MutableScatterMap this_$iv$iv$iv;
        int i11;
        int cmp2;
        int j$iv$iv$iv2;
        long[] m$iv$iv$iv;
        final Object obj3 = this;
        derivedState = obj3.derivedStates;
        elements = derivedState.getMap();
        $this$maskEmptyOrDeleted$iv$iv$iv$iv = elements;
        metadata = $this$maskEmptyOrDeleted$iv$iv$iv$iv.metadata;
        length2 += -2;
        final long l3 = -9187201950435737472L;
        final int i34 = 128;
        i3 = 8;
        if (0 <= i$iv$iv) {
        } else {
            this_$iv = derivedState;
            this_$iv$iv = i13;
            i9 = m$iv$iv$iv2;
            this_$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            i11 = j$iv$iv$iv;
            m$iv$iv$iv = metadata;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = 7;
            i8 = 255;
        }
        if (obj3.conditionallyInvalidatedScopes.isNotEmpty()) {
            conditionallyInvalidatedScopes = obj3.conditionallyInvalidatedScopes;
            i13 = 0;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = 0;
            j$iv$iv$iv = m$iv$iv$iv2.metadata;
            length += -2;
            if (0 <= metadata) {
            } else {
            }
        }
    }

    private final void composeInitial(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        String str;
        int i2 = 0;
        if (disposed ^= 1 == 0) {
            int i3 = 0;
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release((ControlledComposition)this, this.composable);
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj2;
        int i;
        int length;
        int i2;
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.access$getPendingApplyNoModifications$p());
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.access$getPendingApplyNoModifications$p())) {
            } else {
                i = 1;
                if (andSet instanceof Set != null) {
                    addPendingInvalidationsLocked((Set)andSet, i);
                } else {
                    if (!andSet instanceof Object[]) {
                    } else {
                        obj2 = andSet;
                        i2 = 0;
                        while (i2 < obj2.length) {
                            addPendingInvalidationsLocked((Set[])obj2[i2], i);
                            i2++;
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                ComposerKt.composeRuntimeError(stringBuilder.append("corrupt pendingModifications drain: ").append(this.pendingModifications).toString());
                KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
                throw kotlinNothingValueException;
            }
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            KotlinNothingValueException kotlinNothingValueException2 = new KotlinNothingValueException();
            throw kotlinNothingValueException2;
        }
    }

    private final void drainPendingModificationsLocked() {
        boolean equal;
        int i2;
        int length;
        int i;
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(0);
        if (!Intrinsics.areEqual(andSet, CompositionKt.access$getPendingApplyNoModifications$p())) {
            i2 = 0;
            if (andSet instanceof Set != null) {
                addPendingInvalidationsLocked((Set)andSet, i2);
            } else {
                if (andSet instanceof Object[]) {
                    equal = andSet;
                    i = i2;
                    while (i < equal.length) {
                        addPendingInvalidationsLocked((Set[])equal[i], i2);
                        i++;
                    }
                } else {
                    if (andSet == null) {
                        ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                        KotlinNothingValueException kotlinNothingValueException2 = new KotlinNothingValueException();
                        throw kotlinNothingValueException2;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            ComposerKt.composeRuntimeError(stringBuilder.append("corrupt pendingModifications drain: ").append(this.pendingModifications).toString());
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
    }

    private static void getAbandonSet$annotations() {
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public static void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static void getSlotTable$runtime_release$annotations() {
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        Throwable th;
        Set rememberEventDispatcher;
        Set abandonSet;
        final int i = 0;
        final Object obj = this;
        final int i2 = 0;
        int i3 = 0;
        final Object invoke = block.invoke();
        final Object obj2 = invoke;
        final int i4 = 0;
        int success$iv = 1;
        return invoke;
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, Object>, ? extends T> block) {
        final int i = 0;
        return block.invoke(takeInvalidations());
    }

    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl scope, androidx.compose.runtime.Anchor anchor, Object instance) {
        int invalidations;
        androidx.compose.runtime.InvalidationResult sCHEDULED;
        int m$iv$iv$iv$iv;
        androidx.compose.runtime.CompositionImpl $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2;
        int i10;
        int j$iv$iv$iv$iv;
        boolean $i$f$isFull;
        int invalidationDelegateGroup;
        int i4;
        Object obj4;
        Object[] k$iv$iv$iv;
        Object obj2;
        int i9;
        int i12;
        Object obj11;
        int this_$iv$iv$iv$iv;
        int i5;
        int i11;
        Object obj;
        long[] lArr;
        long slot$iv$iv$iv$iv;
        ScopeMap $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv;
        int i8;
        int cmp;
        int i6;
        CompositionObserver observer;
        long l;
        Object obj5;
        int i3;
        Object obj3;
        int i7;
        int i2;
        int i;
        final Object obj7 = this;
        final androidx.compose.runtime.RecomposeScopeImpl recomposeScopeImpl = scope;
        final androidx.compose.runtime.Anchor anchor2 = anchor;
        final Object obj8 = instance;
        Object lock = obj7.lock;
        m$iv$iv$iv$iv = 0;
        invalidations = 0;
        $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = obj7.invalidationDelegate;
        i10 = 0;
        synchronized (lock) {
            j$iv$iv$iv$iv = 0;
            if (obj7.slotTable.groupContainsAnchor(obj7.invalidationDelegateGroup, anchor2)) {
                i10 = $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2;
            } else {
            }
            if (i10 == 0) {
                if (obj7.tryImminentInvalidation(recomposeScopeImpl, obj8)) {
                    return InvalidationResult.IMMINENT;
                }
                $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = obj7.observer();
                if (obj8 == null) {
                    obj7.invalidations.set(recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                    i11 = invalidations;
                    this_$iv$iv$iv$iv = m$iv$iv$iv$iv;
                    i6 = i10;
                } else {
                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 == null && !obj8 instanceof DerivedState) {
                        if (!obj8 instanceof DerivedState) {
                            try {
                                obj7.invalidations.set(recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                                i11 = invalidations;
                                this_$iv$iv$iv$iv = m$iv$iv$iv$iv;
                                i6 = i10;
                                j$iv$iv$iv$iv = obj7.invalidations;
                                $i$f$isFull = 0;
                                i4 = 0;
                                obj4 = j$iv$iv$iv$iv.getMap().get(recomposeScopeImpl);
                            } catch (Throwable th) {
                                cmp = 0;
                                long observer2 = l2;
                                l = -9187201950435737472L;
                                i10 = 8;
                                $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = i16 - 8;
                                j$iv$iv$iv$iv = 0;
                                int i18 = 0;
                                $i$f$isFull = i9;
                                $i$f$isFull = 0;
                                l = 0;
                                i3 = 0;
                                i7 = 0;
                                i2 = i10;
                                i = j$iv$iv$iv$iv;
                                i10 = i9;
                                i10 = 0;
                                k$iv$iv$iv = i9;
                                i2 = i10;
                                i = j$iv$iv$iv$iv;
                                slot$iv$iv$iv$iv >>= i2;
                                j$iv$iv$iv$iv = i + 1;
                                i10 = i2;
                                i2 = i10;
                                i = j$iv$iv$iv$iv;
                                m$iv$iv$iv$iv++;
                                j$iv$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv;
                                $i$f$isFull = i8;
                                i10 = i6;
                                $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = observer;
                                k$iv$iv$iv = 0;
                                obj7.invalidations.add(recomposeScopeImpl, obj8);
                                int i13 = i6;
                                return i13.invalidateChecked(recomposeScopeImpl, anchor2, obj8);
                                obj7.parent.invalidate$runtime_release((ControlledComposition)obj7);
                                sCHEDULED = InvalidationResult.DEFERRED;
                                sCHEDULED = InvalidationResult.SCHEDULED;
                                return sCHEDULED;
                            }
                            i9 = 1;
                            if (obj4 instanceof MutableScatterSet != null) {
                                obj2 = obj4;
                                i12 = 0;
                                i5 = 0;
                                i11 = invalidations;
                                Object obj6 = obj12;
                                this_$iv$iv$iv$iv = m$iv$iv$iv$iv;
                                long[] $i$f$synchronized = obj6.metadata;
                                obj = obj6;
                                this_$iv$iv$iv$iv2 += -2;
                                if (0 <= invalidations) {
                                } else {
                                    observer = $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2;
                                    i6 = i10;
                                    $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv = j$iv$iv$iv$iv;
                                    i8 = $i$f$isFull;
                                }
                            } else {
                                i11 = invalidations;
                                this_$iv$iv$iv$iv = m$iv$iv$iv$iv;
                                observer = $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2;
                                i6 = i10;
                                $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv = j$iv$iv$iv$iv;
                                i8 = $i$f$isFull;
                                m$iv$iv$iv$iv = 0;
                                i10 = 0;
                                $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = obj4 == ScopeInvalidated.INSTANCE ? i9 : 0;
                                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 != 0) {
                                    try {
                                        k$iv$iv$iv = i9;
                                        i11 = invalidations;
                                        this_$iv$iv$iv$iv = m$iv$iv$iv$iv;
                                        observer = $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2;
                                        i6 = i10;
                                        $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv = j$iv$iv$iv$iv;
                                        i8 = $i$f$isFull;
                                        k$iv$iv$iv = 0;
                                    } catch (Throwable th) {
                                        cmp = 0;
                                        observer2 = l2;
                                        l = -9187201950435737472L;
                                        i10 = 8;
                                        $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = i16 - 8;
                                        j$iv$iv$iv$iv = 0;
                                        i18 = 0;
                                        $i$f$isFull = i9;
                                        $i$f$isFull = 0;
                                        l = 0;
                                        i3 = 0;
                                        i7 = 0;
                                        i2 = i10;
                                        i = j$iv$iv$iv$iv;
                                        i10 = i9;
                                        i10 = 0;
                                        k$iv$iv$iv = i9;
                                        i2 = i10;
                                        i = j$iv$iv$iv$iv;
                                        slot$iv$iv$iv$iv >>= i2;
                                        j$iv$iv$iv$iv = i + 1;
                                        i10 = i2;
                                        i2 = i10;
                                        i = j$iv$iv$iv$iv;
                                        m$iv$iv$iv$iv++;
                                        j$iv$iv$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv;
                                        $i$f$isFull = i8;
                                        i10 = i6;
                                        $this$maskEmptyOrDeleted$iv$iv$iv$iv$iv2 = observer;
                                        obj7.invalidations.add(recomposeScopeImpl, obj8);
                                        i13 = i6;
                                        return i13.invalidateChecked(recomposeScopeImpl, anchor2, obj8);
                                        obj7.parent.invalidate$runtime_release((ControlledComposition)obj7);
                                        sCHEDULED = InvalidationResult.DEFERRED;
                                        sCHEDULED = InvalidationResult.SCHEDULED;
                                        return sCHEDULED;
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
                i11 = invalidations;
                this_$iv$iv$iv$iv = m$iv$iv$iv$iv;
                i6 = i10;
            }
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object this_$iv;
        int i9;
        androidx.compose.runtime.InvalidationResult observationsProcessed;
        Object index$iv$iv$iv;
        int i8;
        Object[] elements;
        Object obj;
        int i10;
        long[] metadata;
        int i4;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        Object obj2;
        int i2;
        ScopeMap this_$iv2;
        int i3;
        long l;
        int i7;
        int i;
        int i5;
        int i6;
        final Object obj3 = this;
        final Object obj4 = value;
        this_$iv = obj3.observations;
        i9 = 0;
        observationsProcessed = this_$iv.getMap().get(obj4);
        if (observationsProcessed != null) {
            if (observationsProcessed instanceof MutableScatterSet != null) {
                index$iv$iv$iv = observationsProcessed;
                i8 = 0;
                i10 = 0;
                metadata = obj.metadata;
                length += -2;
                if (0 <= i4) {
                } else {
                    this_$iv2 = this_$iv;
                    i3 = i9;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv = observationsProcessed;
                    obj2 = index$iv$iv$iv;
                }
            } else {
                this_$iv2 = this_$iv;
                i3 = i9;
                this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
                i9 = 0;
                if ((RecomposeScopeImpl)this_$iv.invalidateForResult(obj4) == InvalidationResult.IMMINENT) {
                    obj3.observationsProcessed.add(obj4, this_$iv);
                }
            }
        } else {
            this_$iv2 = this_$iv;
            i3 = i9;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = observationsProcessed;
        }
    }

    private final CompositionObserver observer() {
        CompositionObserver parentHolder;
        CompositionObserver observer;
        boolean equal;
        final androidx.compose.runtime.CompositionObserverHolder observerHolder = this.observerHolder;
        if (observerHolder.getRoot()) {
            parentHolder = observerHolder.getObserver();
        } else {
            androidx.compose.runtime.CompositionObserverHolder observerHolder$runtime_release = this.parent.getObserverHolder$runtime_release();
            if (observerHolder$runtime_release != null) {
                observer = observerHolder$runtime_release.getObserver();
            } else {
                observer = 0;
            }
            if (!Intrinsics.areEqual(observer, observerHolder.getObserver())) {
                observerHolder.setObserver(observer);
            }
            parentHolder = observer;
        }
        return parentHolder;
    }

    private final ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap scopeMap = new ScopeMap();
        this.invalidations = scopeMap;
        return this.invalidations;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        Throwable th;
        Set rememberEventDispatcher;
        Set abandonSet;
        final int i = 0;
        int i2 = 0;
        final Object invoke = block.invoke();
        final Object obj = invoke;
        final int i3 = 0;
        int success = 1;
        return invoke;
    }

    private final boolean tryImminentInvalidation(androidx.compose.runtime.RecomposeScopeImpl scope, Object instance) {
        boolean tryImminentInvalidation$runtime_release;
        int i;
        if (isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance)) {
            i = this.composer.tryImminentInvalidation$runtime_release(scope, instance) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final void validateRecomposeScopeAnchors(androidx.compose.runtime.SlotTable slotTable) {
        androidx.compose.runtime.SlotTable string;
        int index$iv;
        Object[] objArr;
        int i2;
        int length;
        int anchor;
        Object obj;
        Object contains;
        int i;
        Object obj2;
        int indexOf;
        Object str;
        int i3 = 0;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        objArr = objArr2;
        i2 = 0;
        anchor = 0;
        while (anchor < objArr.length) {
            i = 0;
            obj2 = contains;
            indexOf = 0;
            if (obj2 instanceof RecomposeScopeImpl) {
            } else {
            }
            str = 0;
            if (str != null) {
            }
            anchor++;
            obj2 = 0;
            (Collection)arrayList.add(str);
            str = obj2;
        }
        ArrayList list = arrayList;
        int i4 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            i2 = objArr;
            length = 0;
            anchor = (RecomposeScopeImpl)i2.getAnchor();
            obj = 0;
            i = 0;
            if (anchor != 0 && !string.slotsOf$runtime_release(anchor.toIndexFor(string)).contains(i2)) {
            }
            index$iv++;
            string = slotTable;
            obj = 0;
            i = 0;
            if (!string.slotsOf$runtime_release(anchor.toIndexFor(string)).contains(i2)) {
            }
            obj2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("Misaligned anchor ").append(anchor).append(" in scope ").append(i2).append(" encountered, scope found at ").append(ArraysKt.indexOf(string.getSlots(), i2)).toString());
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        boolean rememberEventDispatcher;
        int abandonSet;
        this.pendingModifications.set(0);
        this.changes.clear();
        this.lateChanges.clear();
        if (!(Collection)this.abandonSet.isEmpty()) {
            rememberEventDispatcher = new CompositionImpl.RememberEventDispatcher(this.abandonSet);
            rememberEventDispatcher.dispatchAbandons();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        Throwable th;
        Set rememberEventDispatcher;
        Set abandonSet;
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        final int i3 = 0;
        final Object obj3 = obj;
        final int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        applyChangesInLocked(this.changes);
        drainPendingModificationsLocked();
        Unit iNSTANCE2 = Unit.INSTANCE;
        int i7 = 0;
        int success$iv$iv = 1;
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            i3 = 0;
            obj3 = obj;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            applyChangesInLocked(this.changes);
            drainPendingModificationsLocked();
            iNSTANCE2 = Unit.INSTANCE;
            i7 = 0;
            success$iv$iv = 1;
            iNSTANCE = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        Throwable th;
        Set rememberEventDispatcher;
        boolean lateChanges;
        Set abandonSet;
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        final int i3 = 0;
        final Object obj3 = obj;
        final int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        synchronized (lock) {
            applyChangesInLocked(this.lateChanges);
            Unit iNSTANCE2 = Unit.INSTANCE;
            int i7 = 0;
            int success$iv$iv = 1;
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        Throwable th;
        Set rememberEventDispatcher2;
        boolean rememberEventDispatcher;
        Set abandonSet;
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        final int i3 = 0;
        final Object obj3 = obj;
        final int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        this.composer.changesApplied$runtime_release();
        synchronized (lock) {
            rememberEventDispatcher = new CompositionImpl.RememberEventDispatcher(this.abandonSet);
            rememberEventDispatcher.dispatchAbandons();
            Unit iNSTANCE2 = Unit.INSTANCE;
            int i7 = 0;
            int success$iv$iv = 1;
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    public void composeContent(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        Set rememberEventDispatcher;
        Object this_$iv2;
        int iNSTANCE;
        Function2 $i$f$guardChanges;
        Map map;
        Set abandonSet;
        String $i$f$trackAbandonedValues;
        Set set;
        Object this_$iv;
        Function2 function2;
        int i;
        Set set2;
        int i2;
        final Object obj = this;
        this_$iv2 = this;
        map = 0;
        final Object obj3 = this_$iv2;
        $i$f$trackAbandonedValues = 0;
        final int i5 = 0;
        final int i6 = 0;
        final Object obj4 = lock;
        final int i7 = 0;
        final int i8 = 0;
        obj.drainPendingModificationsForCompositionLocked();
        final int i9 = 0;
        ScopeMap map2 = map3;
        final int i10 = 0;
        final CompositionObserver observer = obj.observer();
        synchronized (obj4) {
            this_$iv = this_$iv2;
            i = map;
            map = map2.asMap();
            i2 = $i$f$trackAbandonedValues;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
            observer.onBeginComposition((Composition)obj, map);
            obj.composer.composeContent$runtime_release(map2, content);
            if (observer != null) {
                observer.onEndComposition((Composition)obj);
                iNSTANCE = Unit.INSTANCE;
            } else {
                iNSTANCE = 0;
            }
            int i3 = 0;
            int i4 = 1;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final int composerStacksSizes$runtime_release() {
        return this.composer.stacksSize$runtime_release();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void deactivate() {
        int iNSTANCE;
        Object rememberEventDispatcher;
        int i3;
        String str;
        int i2;
        Object obj;
        int i;
        androidx.compose.runtime.CompositionImpl.RememberEventDispatcher rememberEventDispatcher2;
        androidx.compose.runtime.SlotTable slotTable;
        int i4;
        androidx.compose.runtime.SlotWriter writer;
        int i5;
        boolean z;
        int i7;
        androidx.compose.runtime.Trace trace;
        int i6;
        final Object obj2 = this;
        final Object lock = obj2.lock;
        i3 = 0;
        final int i8 = 0;
        synchronized (lock) {
            iNSTANCE = 1;
            final int i9 = iNSTANCE;
            if (i9 == 0) {
                if (!(Collection)obj2.abandonSet.isEmpty()) {
                    i2 = 0;
                    i = 0;
                    rememberEventDispatcher = new CompositionImpl.RememberEventDispatcher(obj2.abandonSet);
                    rememberEventDispatcher2 = rememberEventDispatcher;
                    if (i9 != 0) {
                        obj2.applier.onBeginChanges();
                        i4 = 0;
                        writer = writer2;
                        i5 = 0;
                        z = 0;
                        i7 = 0;
                        i6 = i3;
                        ComposerKt.deactivateCurrentGroup(writer, (RememberManager)rememberEventDispatcher2);
                        Unit writer4 = Unit.INSTANCE;
                        i3 = 0;
                        writer.close(true);
                        obj2.applier.onEndChanges();
                        rememberEventDispatcher2.dispatchRememberObservers();
                    } else {
                        i6 = i3;
                    }
                    rememberEventDispatcher2.dispatchAbandons();
                    Unit iNSTANCE4 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:deactivate"));
                } else {
                    i6 = i3;
                }
            } else {
            }
            obj2.observations.clear();
            obj2.derivedStates.clear();
            obj2.invalidations.clear();
            obj2.changes.clear();
            obj2.lateChanges.clear();
            obj2.composer.deactivate$runtime_release();
            Unit iNSTANCE2 = Unit.INSTANCE;
        }
    }

    public <R> R delegateInvalidations(androidx.compose.runtime.ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        int equal;
        androidx.compose.runtime.CompositionImpl i;
        Object invoke;
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            if (!Intrinsics.areEqual(to, this)) {
                if (groupIndex >= 0) {
                    this.invalidationDelegate = (CompositionImpl)to;
                    this.invalidationDelegateGroup = groupIndex;
                    invoke = block.invoke();
                    this.invalidationDelegate = 0;
                    this.invalidationDelegateGroup = 0;
                } else {
                    invoke = block.invoke();
                }
            } else {
            }
        } else {
        }
        return invoke;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void dispose() {
        boolean value$iv;
        int i2;
        boolean rememberEventDispatcher;
        int manager;
        int abandonSet;
        String str;
        androidx.compose.runtime.SlotWriter writer;
        int i3;
        boolean normalClose$iv;
        Object writer2;
        int i;
        androidx.compose.runtime.CompositionImpl.RememberEventDispatcher rememberEventDispatcher2;
        Object lock = this.lock;
        int i4 = 0;
        int i5 = 0;
        i2 = 1;
        manager = 0;
        synchronized (lock) {
            abandonSet = 0;
            PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            this.disposed = i2;
            this.composable = ComposableSingletons.CompositionKt.INSTANCE.getLambda-2$runtime_release();
            value$iv = this.composer.getDeferredChanges$runtime_release();
            if (!this.disposed && value$iv != null) {
                this.disposed = i2;
                this.composable = ComposableSingletons.CompositionKt.INSTANCE.getLambda-2$runtime_release();
                value$iv = this.composer.getDeferredChanges$runtime_release();
                if (value$iv != null) {
                    applyChangesInLocked(value$iv);
                }
                try {
                    if (this.slotTable.getGroupsSize() > 0) {
                    } else {
                    }
                    i2 = 0;
                    if (i2 == 0) {
                    } else {
                    }
                    rememberEventDispatcher = new CompositionImpl.RememberEventDispatcher(this.abandonSet);
                    if (!(Collection)this.abandonSet.isEmpty() && i2 != 0) {
                    }
                    rememberEventDispatcher = new CompositionImpl.RememberEventDispatcher(this.abandonSet);
                    if (i2 != 0) {
                    }
                    this.applier.onBeginChanges();
                    str = 0;
                    writer = this.slotTable.openWriter();
                    i3 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    ComposerKt.removeCurrentGroup(writer, (RememberManager)rememberEventDispatcher);
                    writer2 = Unit.INSTANCE;
                    i = 0;
                    writer.close(true);
                    this.applier.clear();
                    this.applier.onEndChanges();
                    rememberEventDispatcher.dispatchRememberObservers();
                    obj8.close(obj10);
                    throw writer2;
                    rememberEventDispatcher.dispatchAbandons();
                    this.composer.dispose$runtime_release();
                    Unit iNSTANCE = Unit.INSTANCE;
                    this.parent.unregisterComposition$runtime_release((ControlledComposition)this);
                    throw th;
                } catch (Throwable th) {
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(androidx.compose.runtime.MovableContentState state) {
        CompositionImpl.RememberEventDispatcher rememberEventDispatcher = new CompositionImpl.RememberEventDispatcher(this.abandonSet);
        final int i = 0;
        final androidx.compose.runtime.SlotWriter writer = state.getSlotTable$runtime_release().openWriter();
        final int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        ComposerKt.removeCurrentGroup(writer, (RememberManager)rememberEventDispatcher);
        Unit writer3 = Unit.INSTANCE;
        int i5 = 0;
        writer.close(true);
        rememberEventDispatcher.dispatchRememberObservers();
    }

    public final Function2<androidx.compose.runtime.Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public <T> T getCompositionService(androidx.compose.runtime.CompositionServiceKey<T> key) {
        int i;
        if (Intrinsics.areEqual(key, CompositionKt.getCompositionImplServiceKey())) {
            i = this;
        } else {
            i = 0;
        }
        return i;
    }

    public final List<androidx.compose.runtime.RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList((Iterable)this.conditionallyInvalidatedScopes.asSet());
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasInvalidations() {
        int i;
        final Object lock = this.lock;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (lock) {
            i = 1;
            return i;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        final Object lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        return this.composer.getHasPendingChanges$runtime_release();
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            return this.composer.getHasPendingChanges$runtime_release();
        }
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final androidx.compose.runtime.CompositionObserverHolder getObserverHolder$runtime_release() {
        return this.observerHolder;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final CoroutineContext getRecomposeContext() {
        CoroutineContext recomposeCoroutineContext$runtime_release;
        if (this._recomposeContext == null) {
            recomposeCoroutineContext$runtime_release = this.parent.getRecomposeCoroutineContext$runtime_release();
        }
        return recomposeCoroutineContext$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final androidx.compose.runtime.SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public void insertMovableContent(List<Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> references) {
        int index$iv$iv;
        Throwable th;
        int i2;
        Set rememberEventDispatcher;
        Set abandonSet;
        int i;
        boolean it;
        int i3;
        androidx.compose.runtime.ControlledComposition composition$runtime_release;
        int i4 = 0;
        List list2 = list;
        int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i = 0;
            i3 = 0;
            index$iv$iv++;
        }
        i2 = 1;
        ComposerKt.runtimeCheck(i2);
        int i5 = 0;
        Object obj2 = obj;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        this.composer.insertMovableContentReferences(references);
        Unit iNSTANCE = Unit.INSTANCE;
        int i10 = 0;
        int success$iv$iv = 1;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public androidx.compose.runtime.InvalidationResult invalidate(androidx.compose.runtime.RecomposeScopeImpl scope, Object instance) {
        int i;
        boolean valid;
        int tryImminentInvalidation;
        i = 1;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(i);
        }
        androidx.compose.runtime.Anchor anchor = scope.getAnchor();
        if (anchor != null) {
            if (!anchor.getValid()) {
            } else {
                if (!this.slotTable.ownsAnchor(anchor)) {
                    Object lock = this.lock;
                    tryImminentInvalidation = 0;
                    final int i3 = 0;
                    final androidx.compose.runtime.CompositionImpl invalidationDelegate = this.invalidationDelegate;
                    synchronized (lock) {
                        lock = this.lock;
                        tryImminentInvalidation = 0;
                        i3 = 0;
                        invalidationDelegate = this.invalidationDelegate;
                    }
                    if (invalidationDelegate.tryImminentInvalidation(scope, instance) == i) {
                    } else {
                        i = i2;
                    }
                    if (i != 0) {
                        return InvalidationResult.IMMINENT;
                    }
                    return InvalidationResult.IGNORED;
                }
                if (!scope.getCanRecompose()) {
                    return InvalidationResult.IGNORED;
                }
            }
            return invalidateChecked(scope, anchor, instance);
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        int i;
        Object obj;
        Object obj3;
        int i2;
        Object obj2;
        final Object lock = this.lock;
        final int i3 = 0;
        int i4 = 0;
        Object[] slots = this.slotTable.getSlots();
        final int i5 = 0;
        i = 0;
        synchronized (lock) {
            while (i < slots.length) {
                obj3 = obj;
                i2 = 0;
                if (obj3 instanceof RecomposeScopeImpl) {
                } else {
                }
                obj2 = 0;
                if (obj2 != null) {
                }
                i++;
                obj2.invalidate();
                obj2 = obj3;
            }
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void invalidateGroupsWithKey(int key) {
        int i5;
        int i2;
        Object forceRecomposeScopes$runtime_release;
        int i4;
        int i;
        List list;
        int i6;
        int index$iv$iv;
        int size;
        androidx.compose.runtime.InvalidationResult iGNORED;
        Object obj;
        Object obj3;
        int i7;
        Object obj2;
        int i3;
        final Object obj4 = this;
        forceRecomposeScopes$runtime_release = obj4.lock;
        i4 = 0;
        i2 = 0;
        List invalidateGroupsWithKey$runtime_release = obj4.slotTable.invalidateGroupsWithKey$runtime_release(key);
        synchronized (forceRecomposeScopes$runtime_release) {
            obj4 = this;
            forceRecomposeScopes$runtime_release = obj4.lock;
            i4 = 0;
            i2 = 0;
            invalidateGroupsWithKey$runtime_release = obj4.slotTable.invalidateGroupsWithKey$runtime_release(key);
        }
        i4 = 0;
        list = forceRecomposeScopes$runtime_release;
        i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i7 = 0;
            i3 = 0;
            if ((RecomposeScopeImpl)list.get(index$iv$iv).invalidateForResult(0) == InvalidationResult.IGNORED) {
            } else {
            }
            i2 = 0;
            index$iv$iv++;
            i2 = 1;
        }
        i2 = 0;
        if (i2 != 0) {
            try {
                i5 = 0;
                i5 = 1;
            }
            if (obj4.composer.forceRecomposeScopes$runtime_release()) {
                obj4.parent.invalidate$runtime_release((ControlledComposition)obj4);
            }
        } else {
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final boolean isRoot() {
        return this.isRoot;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final CompositionObserverHandle observe$runtime_release(CompositionObserver observer) {
        Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        this.observerHolder.setObserver(observer);
        this.observerHolder.setRoot(true);
        Unit iNSTANCE = Unit.INSTANCE;
        CompositionImpl.observe.2 lock$iv = new CompositionImpl.observe.2(this, observer);
        return (CompositionObserverHandle)lock$iv;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            iNSTANCE = Unit.INSTANCE;
            lock$iv = new CompositionImpl.observe.2(this, observer);
            return (CompositionObserverHandle)lock$iv;
        }
    }

    public boolean observesAnyOf(Set<? extends Object> values) {
        Object $this$fastForEach$iv2;
        int i2;
        androidx.collection.ScatterSet set$runtime_release;
        int j$iv$iv$iv;
        Object $i$f$isFull;
        int i9;
        boolean contains;
        androidx.collection.ScatterSet set;
        int i8;
        long[] metadata;
        int i3;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        Object $this$fastForEach$iv;
        int i5;
        int cmp;
        int i4;
        int i;
        long l;
        int i6;
        int i7;
        androidx.collection.ScatterSet this_$iv$iv;
        final Object obj = this;
        $this$fastForEach$iv2 = values;
        i2 = 0;
        if ($this$fastForEach$iv2 instanceof ScatterSetWrapper) {
            set$runtime_release = (ScatterSetWrapper)$this$fastForEach$iv2.getSet$runtime_release();
            i9 = 0;
            i8 = 0;
            metadata = set.metadata;
            length += -2;
            if (0 <= i3) {
            } else {
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i5 = i2;
                this_$iv$iv = set$runtime_release;
                i4 = 0;
            }
        } else {
            i5 = i2;
            i4 = 0;
            i2 = 0;
            set$runtime_release = (Iterable)$this$fastForEach$iv2.iterator();
            for (Object j$iv$iv$iv : set$runtime_release) {
                $i$f$isFull = j$iv$iv$iv;
                i9 = 0;
            }
        }
        return i4;
    }

    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        Object invalidations2;
        Set rememberEventDispatcher;
        int $i$f$synchronized2;
        Set abandonSet;
        int map;
        Object this_$iv;
        Set set2;
        int $i$f$synchronized;
        Set set;
        int i;
        Object obj5;
        Object obj;
        ScopeMap invalidations;
        final Object obj2 = this;
        final Object lock = obj2.lock;
        $i$f$synchronized2 = 0;
        map = 0;
        obj2.drainPendingModificationsForCompositionLocked();
        this_$iv = this;
        final int i5 = 0;
        final Object obj3 = this_$iv;
        final int i6 = 0;
        final int i7 = 0;
        final int i8 = 0;
        final int i9 = 0;
        invalidations2 = map2;
        final int i10 = 0;
        final CompositionObserver observer = obj2.observer();
        synchronized (lock) {
            $i$f$synchronized = $i$f$synchronized2;
            i = map;
            map = invalidations2.asMap();
            obj = this_$iv;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
            observer.onBeginComposition((Composition)obj2, map);
            try {
                boolean recompose$runtime_release = obj2.composer.recompose$runtime_release(invalidations2);
                int i3 = 0;
                if (!recompose$runtime_release) {
                }
                obj2.drainPendingModificationsLocked();
            } catch (Throwable th) {
            }
            invalidations = invalidations2;
            observer.onEndComposition((Composition)obj2);
            boolean z = recompose$runtime_release;
            int i2 = 0;
            int i4 = 1;
            return recompose$runtime_release;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recomposeScopeReleased(androidx.compose.runtime.RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        boolean lock;
        int i2;
        Set[] plus;
        boolean equal;
        int i;
        Object iNSTANCE;
        obj = this.pendingModifications.get();
        i2 = 1;
        while (obj == null) {
            equal = i2;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
            plus = ArraysKt.plus((Set[])obj, values);
            obj = this.pendingModifications.get();
            i2 = 1;
            equal = Intrinsics.areEqual(obj, CompositionKt.access$getPendingApplyNoModifications$p());
            plus = new Set[2];
            plus[i2] = values;
            plus = values;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("corrupt pendingModifications: ").append(this.pendingModifications).toString().toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordReadOf(Object value) {
        boolean areChildrenComposing;
        Object derivedStates;
        Object obj;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        boolean recordRead;
        androidx.compose.runtime.DerivedState.Record currentRecord;
        boolean z2;
        androidx.collection.ObjectIntMap this_$iv;
        int i4;
        Object[] keys;
        androidx.collection.ObjectIntMap map2;
        int i7;
        long[] metadata;
        int i3;
        int i$iv$iv;
        long slot$iv$iv;
        androidx.compose.runtime.DerivedState.Record $this$maskEmptyOrDeleted$iv$iv$iv;
        androidx.collection.ObjectIntMap map;
        int i8;
        int i5;
        boolean z;
        long l;
        int i6;
        int i9;
        int i2;
        androidx.compose.runtime.snapshots.ReaderKind.Companion companion;
        int i;
        int j$iv$iv;
        final Object obj2 = this;
        final Object obj3 = value;
        areChildrenComposing = obj2.composer.getCurrentRecomposeScope$runtime_release();
        if (!obj2.getAreChildrenComposing() && areChildrenComposing != null) {
            areChildrenComposing = obj2.composer.getCurrentRecomposeScope$runtime_release();
            if (areChildrenComposing != null) {
                derivedStates = 0;
                $this$maskEmptyOrDeleted$iv$iv$iv2 = 1;
                areChildrenComposing.setUsed($this$maskEmptyOrDeleted$iv$iv$iv2);
                recordRead = areChildrenComposing.recordRead(obj3);
                if (!recordRead) {
                    if (obj3 instanceof StateObjectImpl) {
                        androidx.compose.runtime.snapshots.ReaderKind.Companion companion2 = ReaderKind.Companion;
                        i4 = 0;
                        (StateObjectImpl)obj3.recordReadIn-h_f27i8$runtime_release(ReaderKind.constructor-impl($this$maskEmptyOrDeleted$iv$iv$iv2));
                    }
                    obj2.observations.add(obj3, areChildrenComposing);
                    if (obj3 instanceof DerivedState) {
                        currentRecord = (DerivedState)obj3.getCurrentRecord();
                        obj2.derivedStates.removeScope(obj3);
                        this_$iv = currentRecord.getDependencies();
                        i4 = 0;
                        i7 = 0;
                        metadata = map2.metadata;
                        length += -2;
                        if (0 <= i3) {
                        } else {
                            i2 = derivedStates;
                            z = recordRead;
                            $this$maskEmptyOrDeleted$iv$iv$iv = currentRecord;
                            map = this_$iv;
                        }
                        areChildrenComposing.recordDerivedStateValue((DerivedState)obj3, $this$maskEmptyOrDeleted$iv$iv$iv.getCurrentValue());
                    } else {
                        i2 = derivedStates;
                        z = recordRead;
                    }
                } else {
                    i2 = derivedStates;
                    z = recordRead;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        ScopeMap derivedStates;
        int j$iv$iv$iv;
        Object obj3;
        Object obj;
        Object obj5;
        int i;
        Object[] elements;
        Object obj4;
        int i2;
        long[] metadata;
        int i3;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        Object obj2;
        int i4;
        int $i$f$synchronized;
        ScopeMap map;
        long l;
        int i5;
        int i7;
        int i6;
        final Object obj6 = this;
        final Object lock = obj6.lock;
        $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = 0;
        int i8 = 0;
        invalidateScopeOfLocked(value);
        derivedStates = obj6.derivedStates;
        j$iv$iv$iv = 0;
        obj3 = derivedStates.getMap().get(value);
        synchronized (lock) {
            if (obj3 instanceof MutableScatterSet != null) {
                obj5 = obj3;
                i = 0;
                i2 = 0;
                metadata = obj4.metadata;
                length += -2;
                if (0 <= i3) {
                } else {
                    $i$f$synchronized = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                    map = derivedStates;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
                    obj2 = obj3;
                }
            } else {
                try {
                    $i$f$synchronized = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                    map = derivedStates;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
                    derivedStates = 0;
                    obj6.invalidateScopeOfLocked((DerivedState)obj3);
                    $i$f$synchronized = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                    map = derivedStates;
                    $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
                    obj2 = obj3;
                    Unit iNSTANCE = Unit.INSTANCE;
                    obj = value;
                    $i$f$synchronized = obj3;
                    throw th;
                }
            }
        }
    }

    public final void removeDerivedStateObservation$runtime_release(androidx.compose.runtime.DerivedState<?> state) {
        boolean derivedStates;
        if (!this.observations.contains(state)) {
            this.derivedStates.removeScope(state);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void removeObservation$runtime_release(Object instance, androidx.compose.runtime.RecomposeScopeImpl scope) {
        this.observations.remove(instance, scope);
    }

    public final void setComposable(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> <set-?>) {
        this.composable = <set-?>;
    }

    public void setContent(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        composeInitial(content);
    }

    public void setContentWithReuse(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public final void setPendingInvalidScopes$runtime_release(boolean <set-?>) {
        this.pendingInvalidScopes = <set-?>;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        boolean slotTable;
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        synchronized (lock) {
            this.composer.verifyConsistent$runtime_release();
            this.slotTable.verifyWellFormed();
            validateRecomposeScopeAnchors(this.slotTable);
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }
}
