package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0007\u0018\u0000 ½\u00012\u00020\u0001:\n½\u0001¾\u0001¿\u0001À\u0001Á\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010c\u001a\u00020dH\u0002J\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020_H\u0082@¢\u0006\u0002\u0010hJ\u0006\u0010j\u001a\u00020_J\u0008\u0010k\u001a\u00020_H\u0002J\u0006\u0010l\u001a\u00020_J*\u0010m\u001a\u00020_2\u0006\u0010a\u001a\u00020\u00072\u0011\u0010n\u001a\r\u0012\u0004\u0012\u00020_0o¢\u0006\u0002\u0008pH\u0010¢\u0006\u0004\u0008q\u0010rJ:\u0010s\u001a\u0002Ht\"\u0004\u0008\u0000\u0010t2\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010U2\u000c\u0010v\u001a\u0008\u0012\u0004\u0012\u0002Ht0oH\u0082\u0008¢\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\u0008zJ\u0010\u0010{\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0002J\u0008\u0010|\u001a\u00020_H\u0002J\u0015\u0010}\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\u0008~J\u0016\u0010\u007f\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\u0008\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020_2\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\u0008\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ \u0010\u0086\u0001\u001a\u00020_2\u0006\u0010y\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020#H\u0010¢\u0006\u0003\u0008\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0003\u0008\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020_J\u0011\u0010\u008c\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J.\u0010\u008d\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t2\r\u0010\u008e\u0001\u001a\u0008\u0012\u0004\u0012\u00020\"0\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J#\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J0\u0010\u0090\u0001\u001a\u00020_2\r\u0010\u0091\u0001\u001a\u00080\u0092\u0001j\u0003`\u0093\u00012\u000b\u0008\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00072\t\u0008\u0002\u0010\u0095\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u0007H\u0002JV\u0010\u0098\u0001\u001a\u00020_2D\u0010v\u001a@\u0008\u0001\u0012\u0005\u0012\u00030\u009a\u0001\u0012\u0017\u0012\u00150\u009b\u0001¢\u0006\u000f\u0008\u009c\u0001\u0012\n\u0008\u009d\u0001\u0012\u0005\u0008\u0008(\u009e\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020_0\u009f\u0001\u0012\u0006\u0012\u0004\u0018\u00010'0\u0099\u0001¢\u0006\u0003\u0008 \u0001H\u0082@¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0017H\u0002J \u0010¢\u0001\u001a\u00020_2\u0014\u0010£\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020_0\u0097\u0001H\u0082\u0008J\u0011\u0010¤\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u001f\u0010¥\u0001\u001a\u00020_2\u000e\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010*H\u0010¢\u0006\u0003\u0008¨\u0001J\u0017\u0010©\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\u0008ª\u0001J\u0012\u0010«\u0001\u001a\u00020_2\u0007\u0010¬\u0001\u001a\u00020QH\u0002J\u0011\u0010­\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0017\u0010®\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\u0008¯\u0001J\u000b\u0010°\u0001\u001a\u0004\u0018\u000109H\u0002J\u0007\u0010±\u0001\u001a\u00020_J\t\u0010²\u0001\u001a\u00020_H\u0002J$\u0010³\u0001\u001a\u00020_2\u0008\u0010\u009e\u0001\u001a\u00030\u009b\u00012\u0008\u0010´\u0001\u001a\u00030µ\u0001H\u0082@¢\u0006\u0003\u0010¶\u0001J\u000f\u0010·\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u0018\u0010¸\u0001\u001a\u00020_2\u0006\u0010L\u001a\u00020\u0003H\u0087@¢\u0006\u0003\u0010¹\u0001J\u0017\u0010º\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\u0008»\u0001J.\u0010¼\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\"0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u001c\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010'0&\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\"0\u00060!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u000e\u0010/\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u000c018F¢\u0006\u0006\u001a\u0004\u00082\u00103R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008?\u0010\u0019R\u0014\u0010@\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010\u0019R\u0014\u0010B\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008C\u0010\u0019R\u0011\u0010D\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\u0008E\u0010\u0019R\u0014\u0010F\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008G\u0010\u0019R\u000e\u0010H\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010KR\u0014\u0010L\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008M\u00105R\u0012\u0010N\u001a\u00060OR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008S\u0010\u0019R\u0014\u0010T\u001a\u0008\u0012\u0004\u0012\u00020'0UX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010V\u001a\u0008\u0012\u0004\u0012\u00020\u000c0W8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008X\u0010Y\u001a\u0004\u0008Z\u0010[R\u000e\u0010\\\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Â\u0001", d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingCallByInformation", "", "getCollectingCallByInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingParameterInformation$runtime_release", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addKnownCompositionLocked", "composition", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordFailedCompositionLocked", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Recomposer extends androidx.compose.runtime.CompositionContext {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.Recomposer.Companion Companion;
    private static final AtomicReference<Boolean> _hotReloadEnabled;
    private static final MutableStateFlow<PersistentSet<androidx.compose.runtime.Recomposer.RecomposerInfoImpl>> _runningRecomposers;
    private final List<androidx.compose.runtime.ControlledComposition> _knownCompositions;
    private List<? extends androidx.compose.runtime.ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<androidx.compose.runtime.Recomposer.State> _state;
    private final androidx.compose.runtime.BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<androidx.compose.runtime.ControlledComposition> compositionInvalidations;
    private final Map<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState> compositionValueStatesAvailable;
    private final List<androidx.compose.runtime.MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<androidx.compose.runtime.MovableContent<Object>, List<androidx.compose.runtime.MovableContentStateReference>> compositionValuesRemoved;
    private final List<androidx.compose.runtime.ControlledComposition> compositionsAwaitingApply;
    private Set<androidx.compose.runtime.ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private androidx.compose.runtime.Recomposer.RecomposerErrorState errorState;
    private List<androidx.compose.runtime.ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final androidx.compose.runtime.Recomposer.RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    @Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\u000cH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008\u0017J\u0013\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\u0008\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\u0008\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0008\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\u000cH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0008%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008(R.\u0010\u0003\u001a\"\u0012\u000c\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\u000c\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0008\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u00060\u000bR\u00020\u000c0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006)", d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final void access$addRunning(androidx.compose.runtime.Recomposer.Companion $this, androidx.compose.runtime.Recomposer.RecomposerInfoImpl info) {
            $this.addRunning(info);
        }

        public static final void access$removeRunning(androidx.compose.runtime.Recomposer.Companion $this, androidx.compose.runtime.Recomposer.RecomposerInfoImpl info) {
            $this.removeRunning(info);
        }

        private final void addRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl info) {
            Object value;
            PersistentSet set;
            boolean compareAndSet;
            value = Recomposer.access$get_runningRecomposers$cp().getValue();
            set = (PersistentSet)value.add(info);
            while (value != set) {
                if (!Recomposer.access$get_runningRecomposers$cp().compareAndSet(value, set)) {
                }
                value = Recomposer.access$get_runningRecomposers$cp().getValue();
                set = (PersistentSet)value.add(info);
            }
        }

        private final void removeRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl info) {
            Object value;
            PersistentSet remove;
            boolean compareAndSet;
            value = Recomposer.access$get_runningRecomposers$cp().getValue();
            remove = (PersistentSet)value.remove(info);
            while (value != remove) {
                if (!Recomposer.access$get_runningRecomposers$cp().compareAndSet(value, remove)) {
                }
                value = Recomposer.access$get_runningRecomposers$cp().getValue();
                remove = (PersistentSet)value.remove(info);
            }
        }

        public final void clearErrors$runtime_release() {
            Object next;
            Object obj;
            int i;
            androidx.compose.runtime.Recomposer.RecomposerErrorState it;
            int i2;
            final int i3 = 0;
            ArrayList arrayList = new ArrayList();
            final int i4 = 0;
            final int i5 = 0;
            final Iterator iterator = (Iterable)Recomposer.access$get_runningRecomposers$cp().getValue().iterator();
            while (iterator.hasNext()) {
                i = 0;
                i2 = 0;
                it = (Recomposer.RecomposerInfoImpl)iterator.next().resetErrorState();
                if (it != null) {
                }
                i2 = 0;
                (Collection)arrayList.add(it);
            }
        }

        public final List<androidx.compose.runtime.RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Object next;
            Object obj;
            int i2;
            androidx.compose.runtime.RecomposerErrorInfo it;
            int i;
            final int i3 = 0;
            ArrayList arrayList = new ArrayList();
            final int i4 = 0;
            final int i5 = 0;
            final Iterator iterator = (Iterable)Recomposer.access$get_runningRecomposers$cp().getValue().iterator();
            while (iterator.hasNext()) {
                i2 = 0;
                i = 0;
                it = (Recomposer.RecomposerInfoImpl)iterator.next().getCurrentError();
                if (it != null) {
                }
                i = 0;
                (Collection)arrayList.add(it);
            }
            return (List)arrayList;
        }

        public final StateFlow<Set<androidx.compose.runtime.RecomposerInfo>> getRunningRecomposers() {
            return (StateFlow)Recomposer.access$get_runningRecomposers$cp();
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Object next;
            Object obj;
            int i2;
            androidx.compose.runtime.RecomposerErrorInfo currentError;
            int i;
            final int i3 = 1;
            Recomposer.access$get_hotReloadEnabled$cp().set(Boolean.valueOf(i3));
            int i4 = 0;
            final Iterator iterator = (Iterable)Recomposer.access$get_runningRecomposers$cp().getValue().iterator();
            while (iterator.hasNext()) {
                obj = next;
                i2 = 0;
                currentError = (Recomposer.RecomposerInfoImpl)obj.getCurrentError();
                i = 0;
                if (currentError != null && !currentError.getRecoverable()) {
                }
                if (i != 0) {
                } else {
                }
                obj.resetErrorState();
                obj.invalidateGroupsWithKey(key);
                obj.retryFailedCompositions();
                if (!currentError.getRecoverable()) {
                }
                i = i3;
            }
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Object next;
            int index$iv2;
            int index$iv;
            Object obj2;
            int size;
            int i;
            Object obj;
            int i2;
            Recomposer.access$get_hotReloadEnabled$cp().set(true);
            int i4 = 0;
            Iterator iterator = (Iterable)Recomposer.access$get_runningRecomposers$cp().getValue().iterator();
            for (Object next : iterator) {
                i = 0;
                (Recomposer.RecomposerInfoImpl)next.resetErrorState();
            }
            Intrinsics.checkNotNull(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            Object obj3 = token;
            Object obj4 = obj3;
            int i5 = 0;
            index$iv2 = 0;
            while (index$iv2 < obj4.size()) {
                i2 = 0;
                (Recomposer.HotReloadable)obj4.get(index$iv2).resetContent();
                index$iv2++;
            }
            Object $this$fastForEach$iv = obj3;
            int i6 = 0;
            index$iv = 0;
            while (index$iv < $this$fastForEach$iv.size()) {
                i2 = 0;
                (Recomposer.HotReloadable)$this$fastForEach$iv.get(index$iv).recompose();
                index$iv++;
            }
            int i7 = 0;
            Iterator iterator2 = (Iterable)Recomposer.access$get_runningRecomposers$cp().getValue().iterator();
            for (Object size : iterator2) {
                obj = 0;
                (Recomposer.RecomposerInfoImpl)size.retryFailedCompositions();
            }
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Object next;
            List it;
            int i;
            Recomposer.access$get_hotReloadEnabled$cp().set(true);
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            final int i4 = 0;
            final Iterator iterator = (Iterable)Recomposer.access$get_runningRecomposers$cp().getValue().iterator();
            for (Object next : iterator) {
                i = 0;
                CollectionsKt.addAll((Collection)arrayList, (Iterable)(Recomposer.RecomposerInfoImpl)next.saveStateAndDisposeForHotReload());
            }
            return (List)arrayList;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer.access$get_hotReloadEnabled$cp().set(Boolean.valueOf(value));
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\u000c\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class HotReloadable {

        private Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> composable;
        private final androidx.compose.runtime.CompositionImpl composition;
        public HotReloadable(androidx.compose.runtime.CompositionImpl composition) {
            super();
            this.composition = composition;
            this.composable = this.composition.getComposable();
        }

        public final void clearContent() {
            boolean composition;
            Function2 lambda-1$runtime_release;
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons.RecomposerKt.INSTANCE.getLambda-1$runtime_release());
            }
        }

        public final void recompose() {
            boolean composition;
            Function2 composable;
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RecomposerErrorState implements androidx.compose.runtime.RecomposerErrorInfo {

        private final Exception cause;
        private final boolean recoverable;
        public RecomposerErrorState(boolean recoverable, Exception cause) {
            super();
            this.recoverable = recoverable;
            this.cause = cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001e", d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class RecomposerInfoImpl implements androidx.compose.runtime.RecomposerInfo {

        final androidx.compose.runtime.Recomposer this$0;
        public RecomposerInfoImpl(androidx.compose.runtime.Recomposer this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return this.this$0.getChangeCount();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public final androidx.compose.runtime.RecomposerErrorInfo getCurrentError() {
            Object obj = Recomposer.access$getStateLock$p(this.this$0);
            final int i = 0;
            final int i2 = 0;
            return (RecomposerErrorInfo)Recomposer.access$getErrorState$p(this.this$0);
            synchronized (obj) {
                obj = Recomposer.access$getStateLock$p(this.this$0);
                i = 0;
                i2 = 0;
                return (RecomposerErrorInfo)Recomposer.access$getErrorState$p(this.this$0);
            }
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return this.this$0.getHasPendingWork();
        }

        public Flow<androidx.compose.runtime.Recomposer.State> getState() {
            return (Flow)this.this$0.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public final void invalidateGroupsWithKey(int key) {
            int index$iv;
            int i;
            int index$iv$iv;
            int size;
            Object obj3;
            Object obj;
            int i3;
            Object obj2;
            int i2;
            Object obj4;
            Object obj5 = Recomposer.access$getStateLock$p(this.this$0);
            int i4 = 0;
            int i7 = 0;
            List list = list2;
            int i5 = 0;
            ArrayList arrayList = new ArrayList(list.size());
            List list3 = list;
            i = 0;
            index$iv$iv = 0;
            synchronized (obj5) {
                obj5 = Recomposer.access$getStateLock$p(this.this$0);
                i4 = 0;
                i7 = 0;
                list = list2;
                i5 = 0;
                arrayList = new ArrayList(list.size());
                list3 = list;
                i = 0;
                index$iv$iv = 0;
            }
            while (index$iv$iv < list3.size()) {
                i3 = 0;
                obj2 = obj;
                i2 = 0;
                if (obj2 instanceof CompositionImpl) {
                } else {
                }
                obj4 = 0;
                if (obj4 != null) {
                }
                index$iv$iv++;
                obj2 = 0;
                (Collection)arrayList.add(obj4);
                obj4 = obj2;
            }
            ArrayList $this$fastMapNotNull$iv = arrayList;
            int i6 = 0;
            index$iv = 0;
            while (index$iv < (List)$this$fastMapNotNull$iv.size()) {
                size = 0;
                (CompositionImpl)$this$fastMapNotNull$iv.get(index$iv).invalidateGroupsWithKey(key);
                index$iv++;
            }
            try {
                throw compositions;
            }
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public final androidx.compose.runtime.Recomposer.RecomposerErrorState resetErrorState() {
            return Recomposer.access$resetErrorState(this.this$0);
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public final void retryFailedCompositions() {
            Recomposer.access$retryFailedCompositions(this.this$0);
        }

        public final List<androidx.compose.runtime.Recomposer.HotReloadable> saveStateAndDisposeForHotReload() {
            int index$iv$iv2;
            int index$iv$iv;
            Object obj3;
            Object obj;
            int i;
            Object obj4;
            int i2;
            Object obj2;
            androidx.compose.runtime.Recomposer.HotReloadable hotReloadable;
            androidx.compose.runtime.Recomposer.HotReloadable hotReloadable2;
            int i3;
            final Object obj5 = this;
            Object obj6 = Recomposer.access$getStateLock$p(obj5.this$0);
            int i4 = 0;
            int i7 = 0;
            List list2 = list;
            int i5 = 0;
            ArrayList arrayList = new ArrayList(list2.size());
            List list3 = list2;
            int i8 = 0;
            index$iv$iv2 = 0;
            synchronized (obj6) {
                obj5 = this;
                obj6 = Recomposer.access$getStateLock$p(obj5.this$0);
                i4 = 0;
                i7 = 0;
                list2 = list;
                i5 = 0;
                arrayList = new ArrayList(list2.size());
                list3 = list2;
                i8 = 0;
                index$iv$iv2 = 0;
            }
            while (index$iv$iv2 < list3.size()) {
                i = 0;
                obj4 = obj;
                i2 = 0;
                if (obj4 instanceof CompositionImpl) {
                } else {
                }
                obj2 = 0;
                if (obj2 != null) {
                }
                index$iv$iv2++;
                obj4 = 0;
                (Collection)arrayList.add(obj2);
                obj2 = obj4;
            }
            ArrayList $this$fastMapNotNull$iv = arrayList;
            int i6 = 0;
            ArrayList arrayList2 = new ArrayList((List)$this$fastMapNotNull$iv.size());
            ArrayList list4 = $this$fastMapNotNull$iv;
            int i9 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list4.size()) {
                i = 0;
                obj2 = 0;
                hotReloadable = new Recomposer.HotReloadable((CompositionImpl)list4.get(index$iv$iv));
                i3 = 0;
                hotReloadable.clearContent();
                (Collection)arrayList2.add(hotReloadable);
                index$iv$iv++;
            }
            return (List)arrayList2;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum State {

        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork;
        private static final androidx.compose.runtime.Recomposer.State[] $values() {
            return /* result */;
        }
    }
    static {
        Recomposer.Companion companion = new Recomposer.Companion(0);
        Recomposer.Companion = companion;
        int i = 8;
        Recomposer._runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
        AtomicReference atomicReference = new AtomicReference(false);
        Recomposer._hotReloadEnabled = atomicReference;
    }

    public Recomposer(CoroutineContext effectCoroutineContext) {
        super();
        Recomposer.broadcastFrameClock.1 anon = new Recomposer.broadcastFrameClock.1(this);
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock((Function0)anon);
        this.broadcastFrameClock = broadcastFrameClock;
        Object object = new Object();
        this.stateLock = object;
        ArrayList arrayList = new ArrayList();
        this._knownCompositions = (List)arrayList;
        int i7 = 0;
        MutableScatterSet mutableScatterSet = new MutableScatterSet(i7, 1, 0);
        this.snapshotInvalidations = mutableScatterSet;
        int i = 0;
        int i5 = 0;
        MutableVector mutableVector = new MutableVector(new ControlledComposition[16], i7);
        this.compositionInvalidations = mutableVector;
        ArrayList arrayList2 = new ArrayList();
        this.compositionsAwaitingApply = (List)arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.compositionValuesAwaitingInsert = (List)arrayList3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.compositionValuesRemoved = (Map)linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.compositionValueStatesAvailable = (Map)linkedHashMap2;
        this._state = StateFlowKt.MutableStateFlow(Recomposer.State.Inactive);
        CompletableJob completableJob = JobKt.Job((Job)effectCoroutineContext.get((CoroutineContext.Key)Job.Key));
        int i6 = 0;
        Recomposer.effectJob.1.1 anon2 = new Recomposer.effectJob.1.1(this);
        completableJob.invokeOnCompletion((Function1)anon2);
        this.effectJob = completableJob;
        this.effectCoroutineContext = effectCoroutineContext.plus((CoroutineContext)this.broadcastFrameClock).plus((CoroutineContext)this.effectJob);
        Recomposer.RecomposerInfoImpl recomposerInfoImpl = new Recomposer.RecomposerInfoImpl(this);
        this.recomposerInfo = recomposerInfoImpl;
    }

    public static final Object access$awaitWorkAvailable(androidx.compose.runtime.Recomposer $this, Continuation $completion) {
        return $this.awaitWorkAvailable($completion);
    }

    public static final CancellableContinuation access$deriveStateLocked(androidx.compose.runtime.Recomposer $this) {
        return $this.deriveStateLocked();
    }

    public static final void access$discardUnusedValues(androidx.compose.runtime.Recomposer $this) {
        $this.discardUnusedValues();
    }

    public static final androidx.compose.runtime.BroadcastFrameClock access$getBroadcastFrameClock$p(androidx.compose.runtime.Recomposer $this) {
        return $this.broadcastFrameClock;
    }

    public static final Throwable access$getCloseCause$p(androidx.compose.runtime.Recomposer $this) {
        return $this.closeCause;
    }

    public static final MutableVector access$getCompositionInvalidations$p(androidx.compose.runtime.Recomposer $this) {
        return $this.compositionInvalidations;
    }

    public static final List access$getCompositionValuesAwaitingInsert$p(androidx.compose.runtime.Recomposer $this) {
        return $this.compositionValuesAwaitingInsert;
    }

    public static final List access$getCompositionsAwaitingApply$p(androidx.compose.runtime.Recomposer $this) {
        return $this.compositionsAwaitingApply;
    }

    public static final int access$getConcurrentCompositionsOutstanding$p(androidx.compose.runtime.Recomposer $this) {
        return $this.concurrentCompositionsOutstanding;
    }

    public static final androidx.compose.runtime.Recomposer.RecomposerErrorState access$getErrorState$p(androidx.compose.runtime.Recomposer $this) {
        return $this.errorState;
    }

    public static final boolean access$getHasBroadcastFrameClockAwaiters(androidx.compose.runtime.Recomposer $this) {
        return $this.getHasBroadcastFrameClockAwaiters();
    }

    public static final boolean access$getHasConcurrentFrameWorkLocked(androidx.compose.runtime.Recomposer $this) {
        return $this.getHasConcurrentFrameWorkLocked();
    }

    public static final boolean access$getHasSchedulingWork(androidx.compose.runtime.Recomposer $this) {
        return $this.getHasSchedulingWork();
    }

    public static final List access$getKnownCompositions(androidx.compose.runtime.Recomposer $this) {
        return $this.getKnownCompositions();
    }

    public static final androidx.compose.runtime.Recomposer.RecomposerInfoImpl access$getRecomposerInfo$p(androidx.compose.runtime.Recomposer $this) {
        return $this.recomposerInfo;
    }

    public static final Job access$getRunnerJob$p(androidx.compose.runtime.Recomposer $this) {
        return $this.runnerJob;
    }

    public static final boolean access$getShouldKeepRecomposing(androidx.compose.runtime.Recomposer $this) {
        return $this.getShouldKeepRecomposing();
    }

    public static final MutableScatterSet access$getSnapshotInvalidations$p(androidx.compose.runtime.Recomposer $this) {
        return $this.snapshotInvalidations;
    }

    public static final Object access$getStateLock$p(androidx.compose.runtime.Recomposer $this) {
        return $this.stateLock;
    }

    public static final CancellableContinuation access$getWorkContinuation$p(androidx.compose.runtime.Recomposer $this) {
        return $this.workContinuation;
    }

    public static final AtomicReference access$get_hotReloadEnabled$cp() {
        return Recomposer._hotReloadEnabled;
    }

    public static final MutableStateFlow access$get_runningRecomposers$cp() {
        return Recomposer._runningRecomposers;
    }

    public static final MutableStateFlow access$get_state$p(androidx.compose.runtime.Recomposer $this) {
        return $this._state;
    }

    public static final boolean access$isClosed$p(androidx.compose.runtime.Recomposer $this) {
        return $this.isClosed;
    }

    public static final List access$performInsertValues(androidx.compose.runtime.Recomposer $this, List references, MutableScatterSet modifiedValues) {
        return $this.performInsertValues(references, modifiedValues);
    }

    public static final androidx.compose.runtime.ControlledComposition access$performRecompose(androidx.compose.runtime.Recomposer $this, androidx.compose.runtime.ControlledComposition composition, MutableScatterSet modifiedValues) {
        return $this.performRecompose(composition, modifiedValues);
    }

    public static final Object access$recompositionRunner(androidx.compose.runtime.Recomposer $this, Function3 block, Continuation $completion) {
        return $this.recompositionRunner(block, $completion);
    }

    public static final boolean access$recordComposerModifications(androidx.compose.runtime.Recomposer $this) {
        return $this.recordComposerModifications();
    }

    public static final void access$recordFailedCompositionLocked(androidx.compose.runtime.Recomposer $this, androidx.compose.runtime.ControlledComposition composition) {
        $this.recordFailedCompositionLocked(composition);
    }

    public static final void access$registerRunnerJob(androidx.compose.runtime.Recomposer $this, Job callingJob) {
        $this.registerRunnerJob(callingJob);
    }

    public static final androidx.compose.runtime.Recomposer.RecomposerErrorState access$resetErrorState(androidx.compose.runtime.Recomposer $this) {
        return $this.resetErrorState();
    }

    public static final void access$retryFailedCompositions(androidx.compose.runtime.Recomposer $this) {
        $this.retryFailedCompositions();
    }

    public static final Object access$runFrameLoop(androidx.compose.runtime.Recomposer $this, androidx.compose.runtime.MonotonicFrameClock parentFrameClock, androidx.compose.runtime.ProduceFrameSignal frameSignal, Continuation $completion) {
        return $this.runFrameLoop(parentFrameClock, frameSignal, $completion);
    }

    public static final void access$setChangeCount$p(androidx.compose.runtime.Recomposer $this, long <set-?>) {
        $this.changeCount = <set-?>;
    }

    public static final void access$setCloseCause$p(androidx.compose.runtime.Recomposer $this, Throwable <set-?>) {
        $this.closeCause = <set-?>;
    }

    public static final void access$setCompositionsRemoved$p(androidx.compose.runtime.Recomposer $this, Set <set-?>) {
        $this.compositionsRemoved = <set-?>;
    }

    public static final void access$setConcurrentCompositionsOutstanding$p(androidx.compose.runtime.Recomposer $this, int <set-?>) {
        $this.concurrentCompositionsOutstanding = <set-?>;
    }

    public static final void access$setRunnerJob$p(androidx.compose.runtime.Recomposer $this, Job <set-?>) {
        $this.runnerJob = <set-?>;
    }

    public static final void access$setSnapshotInvalidations$p(androidx.compose.runtime.Recomposer $this, MutableScatterSet <set-?>) {
        $this.snapshotInvalidations = <set-?>;
    }

    public static final void access$setWorkContinuation$p(androidx.compose.runtime.Recomposer $this, CancellableContinuation <set-?>) {
        $this.workContinuation = <set-?>;
    }

    private final void addKnownCompositionLocked(androidx.compose.runtime.ControlledComposition composition) {
        (Collection)this._knownCompositions.add(composition);
        this._knownCompositionsCache = 0;
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        if (apply instanceof SnapshotApplyResult.Failure) {
        } else {
            try {
                snapshot.dispose();
                IllegalStateException illegalStateException = new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
                throw illegalStateException;
                snapshot.dispose();
                throw applyResult;
            }
        }
    }

    private final Object awaitWorkAvailable(Continuation<? super Unit> $completion) {
        Object constructor-impl;
        int i;
        if (!getHasSchedulingWork()) {
            int i2 = 0;
            int i3 = 0;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            int i5 = 0;
            constructor-impl = Recomposer.access$getStateLock$p(this);
            final int i6 = 0;
            final int i7 = 0;
            synchronized (constructor-impl) {
                i = cancellableContinuationImpl2;
                if (i != 0) {
                }
                Object uCont$iv = cancellableContinuationImpl.getResult();
                if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended($completion);
                }
                if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return uCont$iv;
                }
                return Unit.INSTANCE;
            }
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)i.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final <T> T composing(androidx.compose.runtime.ControlledComposition composition, MutableScatterSet<Object> modifiedValues, Function0<? extends T> block) {
        final int i = 0;
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        MutableSnapshot mutableSnapshot = takeMutableSnapshot;
        int i2 = 0;
        mutableSnapshot.restoreCurrent((Snapshot)mutableSnapshot.makeCurrent());
        applyAndCheck(takeMutableSnapshot);
        return block.invoke();
    }

    private final CancellableContinuation<Unit> deriveStateLocked() {
        boolean concurrentCompositionsOutstanding;
        androidx.compose.runtime.Recomposer.State inactivePendingWork;
        Object workContinuation;
        CancellableContinuation i3;
        CancellableContinuation i;
        int i2;
        int i4 = 0;
        i3 = 1;
        i = 0;
        clearKnownCompositionsLocked();
        MutableScatterSet mutableScatterSet = new MutableScatterSet(i4, i3, i);
        this.snapshotInvalidations = mutableScatterSet;
        this.compositionInvalidations.clear();
        this.compositionsAwaitingApply.clear();
        this.compositionValuesAwaitingInsert.clear();
        this.failedCompositions = i;
        CancellableContinuation workContinuation2 = this.workContinuation;
        if ((Recomposer.State)this._state.getValue().compareTo((Enum)Recomposer.State.ShuttingDown) <= 0 && workContinuation2 != null) {
            clearKnownCompositionsLocked();
            mutableScatterSet = new MutableScatterSet(i4, i3, i);
            this.snapshotInvalidations = mutableScatterSet;
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = i;
            workContinuation2 = this.workContinuation;
            if (workContinuation2 != null) {
                CancellableContinuation.DefaultImpls.cancel$default(workContinuation2, i, i3, i);
            }
            this.workContinuation = i;
            this.errorState = i;
            return i;
        }
        if (this.errorState != null) {
            inactivePendingWork = Recomposer.State.Inactive;
        } else {
            if (this.runnerJob == null) {
                MutableScatterSet mutableScatterSet2 = new MutableScatterSet(i4, i3, i);
                this.snapshotInvalidations = mutableScatterSet2;
                this.compositionInvalidations.clear();
                inactivePendingWork = getHasBroadcastFrameClockAwaitersLocked() ? Recomposer.State.InactivePendingWork : Recomposer.State.Inactive;
            } else {
                if (!this.compositionInvalidations.isNotEmpty() && !this.snapshotInvalidations.isNotEmpty() && (Collection)this.compositionsAwaitingApply.isEmpty() && (Collection)this.compositionValuesAwaitingInsert.isEmpty() && this.concurrentCompositionsOutstanding <= 0) {
                    if (!this.snapshotInvalidations.isNotEmpty()) {
                        if ((Collection)this.compositionsAwaitingApply.isEmpty()) {
                            if ((Collection)this.compositionValuesAwaitingInsert.isEmpty()) {
                                if (this.concurrentCompositionsOutstanding <= 0) {
                                    if (getHasBroadcastFrameClockAwaitersLocked()) {
                                        inactivePendingWork = Recomposer.State.PendingWork;
                                    } else {
                                        inactivePendingWork = Recomposer.State.Idle;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        this._state.setValue(inactivePendingWork);
        if (inactivePendingWork == Recomposer.State.PendingWork) {
            workContinuation = this.workContinuation;
            i3 = workContinuation;
            i2 = 0;
            this.workContinuation = i;
            i = workContinuation;
        } else {
        }
        return i;
    }

    private final void discardUnusedValues() {
        Object emptyList;
        int i7;
        int compositionValueStatesAvailable;
        boolean flatten;
        int index$iv;
        List list3;
        int i6;
        ArrayList arrayList;
        List list;
        int component1;
        int index$iv$iv;
        int size;
        Object obj3;
        Object obj;
        int i;
        ArrayList list2;
        int i3;
        Object obj2;
        int $i$a$SynchronizedRecomposer$discardUnusedValues$unusedValues$1;
        int i4;
        int i5;
        int i2;
        final Object obj5 = this;
        Object stateLock = obj5.stateLock;
        synchronized (stateLock) {
            obj5.compositionValuesRemoved.clear();
            list3 = flatten;
            i6 = 0;
            arrayList = new ArrayList(list3.size());
            list = list3;
            component1 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                i = 0;
                i3 = 0;
                Object $i$f$synchronized = obj2;
                (Collection)arrayList.add(TuplesKt.to($i$f$synchronized, obj5.compositionValueStatesAvailable.get($i$f$synchronized)));
                index$iv$iv++;
                i7 = i4;
                compositionValueStatesAvailable = i5;
            }
            $i$a$SynchronizedRecomposer$discardUnusedValues$unusedValues$1 = i7;
            i2 = compositionValueStatesAvailable;
            emptyList = arrayList;
            obj5.compositionValueStatesAvailable.clear();
            List list4 = emptyList;
            int i8 = 0;
            index$iv = 0;
        }
        try {
            while (index$iv < list4.size()) {
                int i9 = i6;
                list = null;
                arrayList = i9.component2();
                if ((MovableContentState)arrayList != null) {
                }
                index$iv++;
                (MovableContentStateReference)(Pair)i9.component1().getComposition$runtime_release().disposeUnusedMovableContent((MovableContentState)arrayList);
            }
            i9 = i6;
            list = null;
            arrayList = i9.component2();
            if ((MovableContentState)arrayList != null) {
            }
            (MovableContentStateReference)(Pair)i9.component1().getComposition$runtime_release().disposeUnusedMovableContent((MovableContentState)arrayList);
            index$iv++;
            i5 = obj3;
            throw th;
        } catch (Throwable th) {
        }
    }

    private final boolean getHasBroadcastFrameClockAwaiters() {
        final Object stateLock = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        return getHasBroadcastFrameClockAwaitersLocked();
        synchronized (stateLock) {
            stateLock = this.stateLock;
            i = 0;
            i2 = 0;
            return getHasBroadcastFrameClockAwaitersLocked();
        }
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        boolean frameClockPaused;
        int i;
        if (!this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters()) {
            i = this.broadcastFrameClock.getHasAwaiters() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean getHasConcurrentFrameWorkLocked() {
        int i;
        boolean hasBroadcastFrameClockAwaitersLocked;
        if ((Collection)this.compositionsAwaitingApply.isEmpty()) {
            if (getHasBroadcastFrameClockAwaitersLocked()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final boolean getHasFrameWorkLocked() {
        int i;
        boolean hasBroadcastFrameClockAwaitersLocked;
        if (!this.compositionInvalidations.isNotEmpty()) {
            if (getHasBroadcastFrameClockAwaitersLocked()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final boolean getHasSchedulingWork() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        int i;
        final Object stateLock = this.stateLock;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (stateLock) {
            if (!this.compositionInvalidations.isNotEmpty()) {
                if (getHasBroadcastFrameClockAwaitersLocked()) {
                    try {
                        i = 1;
                        return i;
                        throw th;
                    }
                } else {
                    i = 0;
                }
            } else {
            }
        }
    }

    private final List<androidx.compose.runtime.ControlledComposition> getKnownCompositions() {
        Object $this$_get_knownCompositions__u24lambda_u240;
        int i;
        List _knownCompositions;
        Object arrayList;
        List list;
        if (this._knownCompositionsCache == null) {
            Object obj = this;
            i = 0;
            _knownCompositions = obj._knownCompositions;
            if (_knownCompositions.isEmpty()) {
                arrayList = CollectionsKt.emptyList();
            } else {
                arrayList = new ArrayList((Collection)_knownCompositions);
            }
            obj._knownCompositionsCache = arrayList;
            $this$_get_knownCompositions__u24lambda_u240 = arrayList;
        }
        return $this$_get_knownCompositions__u24lambda_u240;
    }

    private final boolean getShouldKeepRecomposing() {
        int lock$iv;
        int $this$any$iv;
        int i;
        boolean isClosed;
        Object next;
        int i2;
        boolean it;
        int i3;
        Object stateLock = this.stateLock;
        $this$any$iv = 0;
        i = 0;
        synchronized (stateLock) {
            stateLock = this.stateLock;
            $this$any$iv = 0;
            i = 0;
        }
        i = 0;
        isClosed = this.effectJob.getChildren().iterator();
        i2 = 0;
        for (Object next : isClosed) {
            i3 = 0;
            i2 = 0;
        }
        try {
            $this$any$iv = i2;
        }
        return lock$iv;
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(...))
    public static void getState$annotations() {
    }

    private final void performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition composition) {
        int i;
        int i2;
        Object stateLock;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i3;
        Object obj3;
        int i4;
        int $i$a$SynchronizedRecomposer$performInitialMovableContentInserts$1;
        final Object obj4 = this;
        final Object obj5 = composition;
        stateLock = obj4.stateLock;
        final int i5 = 0;
        i = 0;
        final int i6 = 0;
        final List list2 = compositionValuesAwaitingInsert;
        final int i7 = 0;
        index$iv$iv = 0;
        synchronized (stateLock) {
            while (index$iv$iv < list2.size()) {
                i3 = 0;
                i4 = 0;
                index$iv$iv++;
                i = $i$a$SynchronizedRecomposer$performInitialMovableContentInserts$1;
            }
            $i$a$SynchronizedRecomposer$performInitialMovableContentInserts$1 = i;
            i2 = 0;
            if (i2 == 0) {
            }
            Unit iNSTANCE = Unit.INSTANCE;
            ArrayList arrayList = new ArrayList();
            Recomposer.performInitialMovableContentInserts$fillToInsert((List)arrayList, obj4, obj5);
        }
        try {
            while (!(Collection)arrayList.isEmpty()) {
                obj4.performInsertValues(arrayList, null);
                Recomposer.performInitialMovableContentInserts$fillToInsert(arrayList, obj4, obj5);
            }
            obj4.performInsertValues(arrayList, null);
            Recomposer.performInitialMovableContentInserts$fillToInsert(arrayList, obj4, obj5);
            throw toInsert;
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<androidx.compose.runtime.MovableContentStateReference> toInsert, androidx.compose.runtime.Recomposer this$0, androidx.compose.runtime.ControlledComposition $composition) {
        Object next;
        boolean equal;
        toInsert.clear();
        final Object stateLock = this$0.stateLock;
        final int i = 0;
        int i2 = 0;
        Iterator iterator = this$0.compositionValuesAwaitingInsert.iterator();
        synchronized (stateLock) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if (Intrinsics.areEqual((MovableContentStateReference)next.getComposition$runtime_release(), $composition)) {
                }
                toInsert.add(next);
                iterator.remove();
            }
            Unit $i$a$SynchronizedRecomposer$performInitialMovableContentInserts$fillToInsert$1 = Unit.INSTANCE;
        }
    }

    private final List<androidx.compose.runtime.ControlledComposition> performInsertValues(List<androidx.compose.runtime.MovableContentStateReference> references, MutableScatterSet<Object> modifiedValues) {
        Iterator iterator;
        Object obj3;
        Object obj5;
        int size;
        int size3;
        ArrayList list2;
        Object i2;
        Object index$iv$iv;
        HashMap $i$f$fastGroupBy;
        int size2;
        int pairs;
        ArrayList list;
        HashMap hashMap;
        int refs;
        Object key;
        int i7;
        int index$iv$iv3;
        int size4;
        Object takeMutableSnapshot;
        Object obj;
        int i12;
        androidx.compose.runtime.ControlledComposition it2;
        Object $this$getOrPut$iv$iv;
        int i8;
        Object obj2;
        ArrayList index$iv$iv2;
        ArrayList arrayList;
        int i5;
        Object obj6;
        int i4;
        Iterator it3;
        ArrayList pairs2;
        int i6;
        int i9;
        HashMap map;
        Object obj4;
        Object it;
        int i11;
        Object $this$fastForEach$iv$iv;
        int item;
        int i10;
        int first;
        int second;
        int i3;
        int i;
        i2 = this;
        Object obj7 = references;
        int i14 = 0;
        hashMap = new HashMap(obj7.size());
        key = obj7;
        i7 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < key.size()) {
            obj = takeMutableSnapshot;
            i12 = 0;
            int i20 = 0;
            it2 = (MovableContentStateReference)obj.getComposition$runtime_release();
            HashMap map2 = hashMap;
            i8 = 0;
            obj2 = (Map)map2.get(it2);
            if (obj2 == null) {
            } else {
            }
            index$iv$iv2 = obj2;
            (ArrayList)index$iv$iv2.add(obj);
            index$iv$iv3++;
            int i23 = 0;
            arrayList = new ArrayList();
            map2.put(it2, arrayList);
        }
        iterator = (Map)hashMap.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            key = next2.getKey();
            Object value = next2.getValue();
            ComposerKt.runtimeCheck(composing ^= i18);
            i7 = this;
            size4 = 0;
            takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(i7.readObserverOf(key), i7.writeObserverOf(key, modifiedValues));
            obj = takeMutableSnapshot;
            it2 = 0;
            i8 = 0;
            Object stateLock2 = i2.stateLock;
            int i21 = 0;
            int i24 = 0;
            obj6 = value;
            i4 = 0;
            ArrayList arrayList2 = new ArrayList(obj6.size());
            i6 = 0;
            size2 = obj6.size();
            obj4 = value;
            refs = i9;
            while (refs < size2) {
                i11 = 0;
                second = i28;
                i10 = 0;
                (Collection)arrayList2.add(TuplesKt.to(second, RecomposerKt.removeLastMultiValue(i2.compositionValuesRemoved, second.getContent$runtime_release())));
                refs = i + 1;
                obj3 = $this$fastForEach$iv$iv;
                size2 = i3;
            }
            $this$fastForEach$iv$iv = obj3;
            i = refs;
            ArrayList list4 = arrayList2;
            list = list4;
            hashMap = 0;
            index$iv$iv3 = list4;
            obj2 = 0;
            index$iv$iv2 = 0;
            arrayList = list4;
            obj6 = null;
            while (index$iv$iv2 < index$iv$iv3.size()) {
                i9 = 0;
                i11 = 0;
                if ((Pair)index$iv$iv3.get(index$iv$iv2).getSecond() == null) {
                } else {
                }
                it = obj6;
                index$iv$iv2++;
                obj6 = null;
                it = 1;
            }
            obj5 = 1;
            if (obj5 == null) {
            } else {
            }
            pairs2 = list;
            list2 = pairs2;
            key.insertMovableContent(list2);
            Unit toInsert = Unit.INSTANCE;
            obj.restoreCurrent((Snapshot)obj.makeCurrent());
            i7.applyAndCheck(takeMutableSnapshot);
            i2 = this;
            iterator = it3;
            $i$f$fastGroupBy = map;
            ArrayList list5 = list;
            hashMap = 0;
            index$iv$iv3 = list5;
            obj2 = 0;
            index$iv$iv2 = 0;
            arrayList = list5;
            while (index$iv$iv2 < index$iv$iv3.size()) {
                i9 = 0;
                i11 = 0;
                if ((Pair)index$iv$iv3.get(index$iv$iv2).getSecond() != null) {
                } else {
                }
                it = obj6;
                index$iv$iv2++;
                it = 1;
            }
            obj5 = 1;
            if (obj5 != null) {
            } else {
            }
            ArrayList list6 = list;
            int i15 = 0;
            ArrayList arrayList3 = new ArrayList(list6.size());
            ArrayList list9 = list6;
            int i22 = 0;
            ArrayList list11 = list6;
            size = list9.size();
            pairs = i5;
            while (pairs < size) {
                it = null;
                i11 = i9;
                $this$fastForEach$iv$iv = 0;
                if ((Pair)i11.getSecond() == null) {
                } else {
                }
                first = 0;
                if (first != 0) {
                } else {
                }
                i10 = size;
                second = pairs;
                pairs = second + 1;
                size = i10;
                $this$fastForEach$iv$iv = 0;
                i10 = size;
                second = pairs;
                (Collection)arrayList3.add(first);
                first = i11.getFirst();
            }
            second = pairs;
            Object obj8 = stateLock;
            int i19 = 0;
            int i13 = 0;
            CollectionsKt.addAll((Collection)i2.compositionValuesAwaitingInsert, (Iterable)(List)arrayList3);
            Unit $i$a$SynchronizedRecomposer$performInsertValues$1$toInsert$3 = Unit.INSTANCE;
            ArrayList list8 = pairs2;
            hashMap = 0;
            index$iv$iv3 = new ArrayList(list8.size());
            obj2 = list8;
            index$iv$iv2 = 0;
            i4 = list8;
            size3 = obj2.size();
            i2 = arrayList;
            while (i2 < size3) {
                i9 = i2;
                it = arrayList;
                i11 = 0;
                int i27 = 0;
                if ((Pair)it.getSecond() != 0) {
                } else {
                }
                item = obj6;
                if (item != null) {
                } else {
                }
                $this$fastForEach$iv$iv = size3;
                i10 = i2;
                index$iv$iv = it;
                i2 = i10 + 1;
                size3 = $this$fastForEach$iv$iv;
                $this$fastForEach$iv$iv = size3;
                i10 = i2;
                (Collection)index$iv$iv3.add(it);
                item = 1;
            }
            i10 = i2;
            list2 = index$iv$iv3;
            i9 = i2;
            it = arrayList;
            i11 = 0;
            i27 = 0;
            if ((Pair)it.getSecond() != 0) {
            } else {
            }
            item = obj6;
            if (item != null) {
            } else {
            }
            $this$fastForEach$iv$iv = size3;
            i10 = i2;
            index$iv$iv = it;
            i2 = i10 + 1;
            size3 = $this$fastForEach$iv$iv;
            $this$fastForEach$iv$iv = size3;
            i10 = i2;
            (Collection)index$iv$iv3.add(it);
            item = 1;
            it = null;
            i11 = i9;
            $this$fastForEach$iv$iv = 0;
            if ((Pair)i11.getSecond() == null) {
            } else {
            }
            first = 0;
            if (first != 0) {
            } else {
            }
            i10 = size;
            second = pairs;
            pairs = second + 1;
            size = i10;
            $this$fastForEach$iv$iv = 0;
            i10 = size;
            second = pairs;
            (Collection)arrayList3.add(first);
            first = i11.getFirst();
            pairs2 = list;
            i9 = 0;
            i11 = 0;
            if ((Pair)index$iv$iv3.get(index$iv$iv2).getSecond() != null) {
            } else {
            }
            it = obj6;
            if (it == null) {
            } else {
            }
            index$iv$iv2++;
            obj5 = obj6;
            it = 1;
            i9 = 0;
            i11 = 0;
            if ((Pair)index$iv$iv3.get(index$iv$iv2).getSecond() == null) {
            } else {
            }
            it = obj6;
            if (it == null) {
            } else {
            }
            index$iv$iv2++;
            obj5 = obj6;
            it = 1;
            i11 = 0;
            second = i28;
            i10 = 0;
            (Collection)arrayList2.add(TuplesKt.to(second, RecomposerKt.removeLastMultiValue(i2.compositionValuesRemoved, second.getContent$runtime_release())));
            refs = i + 1;
            obj3 = $this$fastForEach$iv$iv;
            size2 = i3;
        }
        return CollectionsKt.toList((Iterable)$i$f$fastGroupBy.keySet());
    }

    private final androidx.compose.runtime.ControlledComposition performRecompose(androidx.compose.runtime.ControlledComposition composition, MutableScatterSet<Object> modifiedValues) {
        int composing;
        Set compositionsRemoved;
        int i;
        int anon;
        int i2;
        boolean notEmpty;
        if (!composition.isComposing() && !composition.isDisposed()) {
            if (!composition.isDisposed()) {
                compositionsRemoved = this.compositionsRemoved;
                anon = 1;
                i2 = 0;
                if (compositionsRemoved != null && compositionsRemoved.contains(composition) == anon) {
                    composing = compositionsRemoved.contains(composition) == anon ? anon : i2;
                } else {
                }
                if (composing != 0) {
                } else {
                    Object obj = this;
                    final int i3 = 0;
                    MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(obj.readObserverOf(composition), obj.writeObserverOf(composition, modifiedValues));
                    MutableSnapshot mutableSnapshot = takeMutableSnapshot;
                    int i4 = 0;
                    final int i5 = 0;
                    if (modifiedValues != null && modifiedValues.isNotEmpty() == anon) {
                        if (modifiedValues.isNotEmpty() == anon) {
                        } else {
                            anon = i2;
                        }
                    } else {
                    }
                    if (anon != 0) {
                        anon = new Recomposer.performRecompose.1.1(modifiedValues, composition);
                        composition.prepareCompose((Function0)anon);
                    }
                    mutableSnapshot.restoreCurrent((Snapshot)mutableSnapshot.makeCurrent());
                    obj.applyAndCheck(takeMutableSnapshot);
                    if (composition.recompose()) {
                        i = composition;
                    } else {
                    }
                }
                return i;
            }
        }
        return null;
    }

    private final void processCompositionError(Exception e, androidx.compose.runtime.ControlledComposition failedInitialComposition, boolean recoverable) {
        boolean booleanValue;
        int i = 0;
        Object stateLock = this.stateLock;
        int i3 = 0;
        int i5 = 0;
        ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", (Throwable)e);
        this.compositionsAwaitingApply.clear();
        this.compositionInvalidations.clear();
        MutableScatterSet mutableScatterSet = new MutableScatterSet(i, 1, 0);
        this.snapshotInvalidations = mutableScatterSet;
        this.compositionValuesAwaitingInsert.clear();
        this.compositionValuesRemoved.clear();
        this.compositionValueStatesAvailable.clear();
        Recomposer.RecomposerErrorState recomposerErrorState = new Recomposer.RecomposerErrorState(recoverable, e);
        this.errorState = recomposerErrorState;
        if ((Boolean)Recomposer._hotReloadEnabled.get().booleanValue() && e instanceof ComposeRuntimeError == null && failedInitialComposition != null) {
            if (e instanceof ComposeRuntimeError == null) {
                stateLock = this.stateLock;
                i3 = 0;
                i5 = 0;
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", (Throwable)e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                mutableScatterSet = new MutableScatterSet(i, 1, 0);
                this.snapshotInvalidations = mutableScatterSet;
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                recomposerErrorState = new Recomposer.RecomposerErrorState(recoverable, e);
                this.errorState = recomposerErrorState;
                synchronized (stateLock) {
                    recordFailedCompositionLocked(failedInitialComposition);
                    deriveStateLocked();
                }
            }
        }
        Object lock$iv = this.stateLock;
        int i2 = 0;
        int i4 = 0;
        androidx.compose.runtime.Recomposer.RecomposerErrorState errorState = this.errorState;
        synchronized (lock$iv) {
            Recomposer.RecomposerErrorState recomposerErrorState2 = new Recomposer.RecomposerErrorState(i, e);
            this.errorState = recomposerErrorState2;
            Unit iNSTANCE = Unit.INSTANCE;
            throw e;
        }
    }

    static void processCompositionError$default(androidx.compose.runtime.Recomposer recomposer, Exception exception2, androidx.compose.runtime.ControlledComposition controlledComposition3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        recomposer.processCompositionError(exception2, obj2, obj3);
    }

    private final Function1<Object, Unit> readObserverOf(androidx.compose.runtime.ControlledComposition composition) {
        Recomposer.readObserverOf.1 anon = new Recomposer.readObserverOf.1(composition);
        return (Function1)anon;
    }

    private final Object recompositionRunner(Function3<? super CoroutineScope, ? super androidx.compose.runtime.MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Recomposer.recompositionRunner.2 anon = new Recomposer.recompositionRunner.2(this, block, MonotonicFrameClockKt.getMonotonicFrameClock($completion.getContext()), 0);
        Object context2 = BuildersKt.withContext((CoroutineContext)this.broadcastFrameClock, (Function2)anon, $completion);
        if (context2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return context2;
        }
        return Unit.INSTANCE;
    }

    private final void recordComposerModifications(Function1<? super androidx.compose.runtime.ControlledComposition, Unit> onEachInvalidComposition) {
        boolean empty;
        int i3;
        MutableScatterSet index$iv;
        MutableScatterSet i$iv;
        int content;
        boolean mutableScatterSet;
        int i2;
        int i;
        final int i4 = 0;
        Object obj = Recomposer.access$getStateLock$p(this);
        int i5 = 0;
        i3 = 0;
        index$iv = Recomposer.access$getSnapshotInvalidations$p(this);
        content = 0;
        final int i9 = 1;
        synchronized (obj) {
            mutableScatterSet = new MutableScatterSet(0, i9, 0);
            Recomposer.access$setSnapshotInvalidations$p(this, mutableScatterSet);
            Set wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet((ScatterSet)index$iv);
            if (!(Collection)wrapIntoSet.isEmpty()) {
            }
            MutableVector mutableVector = Recomposer.access$getCompositionInvalidations$p(this);
            int i6 = 0;
            int size = mutableVector.getSize();
            if (size > 0) {
                try {
                    i$iv = 0;
                    onEachInvalidComposition.invoke(mutableVector.getContent()[i$iv]);
                    while (i$iv += i9 >= size) {
                        onEachInvalidComposition.invoke(content[i$iv]);
                    }
                    Recomposer.access$getCompositionInvalidations$p(this).clear();
                    Object obj2 = Recomposer.access$getStateLock$p(this);
                    int i7 = 0;
                    int i8 = 0;
                    if (Recomposer.access$deriveStateLocked(this) != null) {
                    } else {
                    }
                    Unit $i$a$SynchronizedRecomposer$recordComposerModifications$62 = Unit.INSTANCE;
                    IllegalStateException illegalStateException = new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    throw illegalStateException;
                    throw $i$a$SynchronizedRecomposer$recordComposerModifications$6;
                    throw $i$f$synchronized;
                } catch (Throwable th) {
                }
            }
        }
        empty = Recomposer.access$getKnownCompositions(this);
        i3 = 0;
        index$iv = 0;
        while (index$iv < empty.size()) {
            i2 = 0;
            (ControlledComposition)empty.get(index$iv).recordModificationsOf(wrapIntoSet);
            index$iv++;
        }
    }

    private final boolean recordComposerModifications() {
        int compareTo;
        int i;
        int index$iv;
        Object obj;
        Object obj2;
        int i2;
        androidx.compose.runtime.Recomposer.State shuttingDown;
        final Object obj4 = this;
        Object stateLock2 = obj4.stateLock;
        int i8 = 0;
        int i3 = 0;
        synchronized (stateLock2) {
            return obj4.getHasFrameWorkLocked();
        }
        while (index$iv < size) {
            i2 = 0;
            (ControlledComposition)list.get(index$iv).recordModificationsOf(wrapIntoSet);
            if ((Recomposer.State)obj3._state.getValue().compareTo((Enum)Recomposer.State.ShuttingDown) > 0) {
                break;
            }
            index$iv++;
            compareTo = 0;
            i = 0;
        }
        Object obj5 = stateLock;
        int i13 = 0;
        int i5 = 0;
        MutableScatterSet mutableScatterSet2 = new MutableScatterSet(0, i19, 0);
        obj4.snapshotInvalidations = mutableScatterSet2;
        Unit $i$a$SynchronizedRecomposer$recordComposerModifications$2 = Unit.INSTANCE;
        int complete = 1;
        Object stateLock5 = obj4.stateLock;
        int i14 = 0;
        int i6 = 0;
        synchronized (obj5) {
            obj5 = stateLock;
            i13 = 0;
            i5 = 0;
            mutableScatterSet2 = new MutableScatterSet(0, i19, 0);
            obj4.snapshotInvalidations = mutableScatterSet2;
            $i$a$SynchronizedRecomposer$recordComposerModifications$2 = Unit.INSTANCE;
            complete = 1;
            stateLock5 = obj4.stateLock;
            i14 = 0;
            i6 = 0;
        }
        return obj4.getHasFrameWorkLocked();
    }

    private final void recordFailedCompositionLocked(androidx.compose.runtime.ControlledComposition composition) {
        Object failedCompositions;
        ArrayList list;
        boolean contains;
        int i;
        if (this.failedCompositions == null) {
            failedCompositions = new ArrayList();
            i = 0;
            this.failedCompositions = (List)failedCompositions;
        }
        if (!failedCompositions.contains(composition)) {
            (Collection)failedCompositions.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    private final void registerRunnerJob(Job callingJob) {
        final Object stateLock = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        Throwable closeCause = this.closeCause;
        synchronized (stateLock) {
            if ((Recomposer.State)this._state.getValue().compareTo((Enum)Recomposer.State.ShuttingDown) <= 0) {
            } else {
                if (this.runnerJob != null) {
                } else {
                    this.runnerJob = callingJob;
                    deriveStateLocked();
                }
                IllegalStateException illegalStateException2 = new IllegalStateException("Recomposer already running".toString());
                throw illegalStateException2;
            }
            try {
                IllegalStateException illegalStateException = new IllegalStateException("Recomposer shut down".toString());
                throw illegalStateException;
                int i3 = 0;
                throw closeCause;
                throw $i$a$SynchronizedRecomposer$registerRunnerJob$1;
            }
        }
    }

    private final void removeKnownCompositionLocked(androidx.compose.runtime.ControlledComposition composition) {
        (Collection)this._knownCompositions.remove(composition);
        this._knownCompositionsCache = 0;
    }

    private final androidx.compose.runtime.Recomposer.RecomposerErrorState resetErrorState() {
        int i;
        final Object stateLock = this.stateLock;
        final int i2 = 0;
        final int i3 = 0;
        final androidx.compose.runtime.Recomposer.RecomposerErrorState errorState = this.errorState;
        synchronized (stateLock) {
            this.errorState = 0;
            deriveStateLocked();
            return errorState;
        }
    }

    private final void retryFailedCompositions() {
        Object stateLock2;
        boolean stateLock;
        boolean stateLock3;
        int errorState;
        Throwable th2;
        int $i$a$SynchronizedRecomposer$retryFailedCompositions$1;
        int $i$a$SynchronizedRecomposer$retryFailedCompositions$12;
        List list;
        boolean z;
        int i;
        int i3;
        int index$iv;
        int index$iv2;
        int size;
        Object obj;
        Object obj2;
        int i2;
        stateLock2 = this.stateLock;
        errorState = 0;
        $i$a$SynchronizedRecomposer$retryFailedCompositions$1 = 0;
        final List failedCompositions = this.failedCompositions;
        list = failedCompositions;
        i = 0;
        this.failedCompositions = 0;
        synchronized (stateLock2) {
            stateLock2 = this.stateLock;
            errorState = 0;
            $i$a$SynchronizedRecomposer$retryFailedCompositions$1 = 0;
            failedCompositions = this.failedCompositions;
            list = failedCompositions;
            i = 0;
            this.failedCompositions = 0;
        }
    }

    private final Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock monotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal produceFrameSignal2, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i2;
        int i3;
        Object frameSignal;
        Object _this2;
        Object parentFrameClock;
        Object toRecompose;
        Object _this;
        Object toApply;
        Object awaitFrameRequest;
        int i;
        Object obj;
        Object obj9;
        Object obj10;
        Object obj11;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof Recomposer.runFrameLoop.1 && label &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj11 -= i3;
            } else {
                anon = new Recomposer.runFrameLoop.1(this, continuation3);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                frameSignal = this;
                parentFrameClock = new ArrayList();
                _this = new ArrayList();
                break;
            case 1:
                obj9 = anon.L$4;
                obj10 = anon.L$3;
                _this2 = anon.L$2;
                toRecompose = anon.L$1;
                toApply = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                Recomposer.runFrameLoop.2 anon2 = new Recomposer.runFrameLoop.2(toApply, obj10, obj9, _this2);
                anon.L$0 = toApply;
                anon.L$1 = toRecompose;
                anon.L$2 = _this2;
                anon.L$3 = obj10;
                anon.L$4 = obj9;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                _this = obj9;
                obj9 = toRecompose;
                parentFrameClock = obj10;
                obj10 = _this2;
                frameSignal = obj;
                break;
            case 2:
                ResultKt.throwOnFailure(obj11);
                _this = obj9;
                obj9 = l$1;
                parentFrameClock = obj10;
                obj10 = l$2;
                frameSignal = obj;
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        anon.L$0 = frameSignal;
        anon.L$1 = obj9;
        anon.L$2 = obj10;
        anon.L$3 = parentFrameClock;
        anon.L$4 = _this;
        anon.label = 1;
        if (obj10.awaitFrameRequest(frameSignal.stateLock, anon) != cOROUTINE_SUSPENDED) {
            toRecompose = obj9;
            obj9 = _this;
            toApply = frameSignal;
            _this2 = obj10;
            obj10 = obj;
        }
        return cOROUTINE_SUSPENDED;
    }

    private final Function1<Object, Unit> writeObserverOf(androidx.compose.runtime.ControlledComposition composition, MutableScatterSet<Object> modifiedValues) {
        Recomposer.writeObserverOf.1 anon = new Recomposer.writeObserverOf.1(composition, modifiedValues);
        return (Function1)anon;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final androidx.compose.runtime.RecomposerInfo asRecomposerInfo() {
        return (RecomposerInfo)this.recomposerInfo;
    }

    public final Object awaitIdle(Continuation<? super Unit> $completion) {
        Recomposer.awaitIdle.2 anon = new Recomposer.awaitIdle.2(0);
        Object collect = FlowKt.collect(FlowKt.takeWhile((Flow)getCurrentState(), (Function2)anon), $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void cancel() {
        int compareTo;
        androidx.compose.runtime.Recomposer.State shuttingDown;
        Object stateLock = this.stateLock;
        int i = 0;
        int i3 = 0;
        synchronized (stateLock) {
            this._state.setValue(Recomposer.State.ShuttingDown);
            Unit $i$a$SynchronizedRecomposer$cancel$1 = Unit.INSTANCE;
            int i4 = 0;
            Job.DefaultImpls.cancel$default((Job)this.effectJob, i4, 1, i4);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void close() {
        boolean stateLock;
        int i2;
        Object $i$a$SynchronizedRecomposer$close$1;
        int i;
        if (this.effectJob.complete()) {
            stateLock = this.stateLock;
            i2 = 0;
            int i3 = 0;
            this.isClosed = true;
            $i$a$SynchronizedRecomposer$close$1 = Unit.INSTANCE;
            synchronized (stateLock) {
                stateLock = this.stateLock;
                i2 = 0;
                i3 = 0;
                this.isClosed = true;
                $i$a$SynchronizedRecomposer$close$1 = Unit.INSTANCE;
            }
        }
    }

    public void composeInitial$runtime_release(androidx.compose.runtime.ControlledComposition composition, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        Object $i$a$ComposingRecomposer$composeInitial$1;
        Object $i$a$SynchronizedRecomposer$composeInitial$2;
        int compareTo;
        Object obj;
        final boolean composing = composition.isComposing();
        Object obj3 = this;
        int i7 = 0;
        final int i9 = 1;
        MutableSnapshot mutableSnapshot2 = takeMutableSnapshot;
        MutableSnapshot mutableSnapshot3 = mutableSnapshot;
        final int i12 = 0;
        int i2 = 0;
        composition.composeContent(content);
        $i$a$ComposingRecomposer$composeInitial$1 = Unit.INSTANCE;
        mutableSnapshot3.restoreCurrent(mutableSnapshot3.makeCurrent());
        obj3.applyAndCheck(mutableSnapshot2);
        if (!composing) {
            Snapshot.Companion.notifyObjectsInitialized();
        }
        Object stateLock = this.stateLock;
        int i5 = 0;
        int i3 = 0;
        synchronized (stateLock) {
            if (!getKnownCompositions().contains(composition)) {
                addKnownCompositionLocked(composition);
            }
            $i$a$SynchronizedRecomposer$composeInitial$2 = Unit.INSTANCE;
            performInitialMovableContentInserts(composition);
            composition.applyChanges();
            composition.applyLateChanges();
            if (!composing) {
            }
        }
        Snapshot.Companion.notifyObjectsInitialized();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(androidx.compose.runtime.MovableContentStateReference reference) {
        final Object stateLock = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        return;
        synchronized (stateLock) {
            stateLock = this.stateLock;
            i = 0;
            i2 = 0;
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return (Boolean)Recomposer._hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return 0;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime_release() {
        return 0;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public final StateFlow<androidx.compose.runtime.Recomposer.State> getCurrentState() {
        return (StateFlow)this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final boolean getHasPendingWork() {
        boolean concurrentCompositionsOutstanding;
        int i;
        final Object stateLock = this.stateLock;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (stateLock) {
            if (!this.compositionInvalidations.isNotEmpty()) {
                if (this.concurrentCompositionsOutstanding <= 0) {
                    if ((Collection)this.compositionsAwaitingApply.isEmpty()) {
                        if (getHasBroadcastFrameClockAwaitersLocked()) {
                            try {
                                i = 0;
                                i = 1;
                                return i;
                                throw th;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }

    public final Flow<androidx.compose.runtime.Recomposer.State> getState() {
        return (Flow)getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(androidx.compose.runtime.MovableContentStateReference reference) {
        Object constructor-impl;
        constructor-impl = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        (Collection)this.compositionValuesAwaitingInsert.add(reference);
        CancellableContinuation deriveStateLocked = deriveStateLocked();
        synchronized (constructor-impl) {
            constructor-impl = this.stateLock;
            i = 0;
            i2 = 0;
            (Collection)this.compositionValuesAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)deriveStateLocked.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
        Object constructor-impl;
        CancellableContinuation deriveStateLocked;
        int i;
        constructor-impl = this.stateLock;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (constructor-impl) {
            i = 0;
            this.compositionInvalidations.add(composition);
            deriveStateLocked = deriveStateLocked();
            if (deriveStateLocked != null) {
            }
        }
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)deriveStateLocked.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(androidx.compose.runtime.RecomposeScopeImpl scope) {
        Object constructor-impl;
        constructor-impl = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        this.snapshotInvalidations.add(scope);
        CancellableContinuation deriveStateLocked = deriveStateLocked();
        synchronized (constructor-impl) {
            constructor-impl = this.stateLock;
            i = 0;
            i2 = 0;
            this.snapshotInvalidations.add(scope);
            deriveStateLocked = deriveStateLocked();
        }
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)deriveStateLocked.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    public final Object join(Continuation<? super Unit> $completion) {
        Recomposer.join.2 anon = new Recomposer.join.2(0);
        Object first = FlowKt.first((Flow)getCurrentState(), (Function2)anon, $completion);
        if (first == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return first;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(androidx.compose.runtime.MovableContentStateReference reference, androidx.compose.runtime.MovableContentState data) {
        final Object stateLock = this.stateLock;
        final int i = 0;
        int i2 = 0;
        this.compositionValueStatesAvailable.put(reference, data);
        Unit $i$a$SynchronizedRecomposer$movableContentStateReleased$1 = Unit.INSTANCE;
        return;
        synchronized (stateLock) {
            stateLock = this.stateLock;
            i = 0;
            i2 = 0;
            this.compositionValueStatesAvailable.put(reference, data);
            $i$a$SynchronizedRecomposer$movableContentStateReleased$1 = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public androidx.compose.runtime.MovableContentState movableContentStateResolve$runtime_release(androidx.compose.runtime.MovableContentStateReference reference) {
        final Object stateLock = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        return (MovableContentState)this.compositionValueStatesAvailable.remove(reference);
        synchronized (stateLock) {
            stateLock = this.stateLock;
            i = 0;
            i2 = 0;
            return (MovableContentState)this.compositionValueStatesAvailable.remove(reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void pauseCompositionFrameClock() {
        final Object stateLock = this.stateLock;
        final int i = 0;
        int i2 = 0;
        this.frameClockPaused = true;
        Unit $i$a$SynchronizedRecomposer$pauseCompositionFrameClock$1 = Unit.INSTANCE;
        return;
        synchronized (stateLock) {
            stateLock = this.stateLock;
            i = 0;
            i2 = 0;
            this.frameClockPaused = true;
            $i$a$SynchronizedRecomposer$pauseCompositionFrameClock$1 = Unit.INSTANCE;
        }
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
        Object compositionsRemoved;
        LinkedHashSet set;
        int i;
        final Object stateLock = this.stateLock;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (stateLock) {
            compositionsRemoved = new LinkedHashSet();
            i = 0;
            this.compositionsRemoved = (Set)compositionsRemoved;
            compositionsRemoved.add(composition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void resumeCompositionFrameClock() {
        Object constructor-impl;
        CancellableContinuation deriveStateLocked;
        constructor-impl = this.stateLock;
        final int i = 0;
        final int i2 = 0;
        synchronized (constructor-impl) {
            this.frameClockPaused = false;
            deriveStateLocked = deriveStateLocked();
            if (deriveStateLocked != null) {
            }
        }
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)deriveStateLocked.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> $completion) {
        Recomposer.runRecomposeAndApplyChanges.2 anon = new Recomposer.runRecomposeAndApplyChanges.2(this, 0);
        Object recompositionRunner = recompositionRunner((Function3)anon, $completion);
        if (recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return recompositionRunner;
        }
        return Unit.INSTANCE;
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext recomposeCoroutineContext, Continuation<? super Unit> $completion) {
        Recomposer.runRecomposeConcurrentlyAndApplyChanges.2 anon = new Recomposer.runRecomposeConcurrentlyAndApplyChanges.2(recomposeCoroutineContext, this, 0);
        Object recompositionRunner = recompositionRunner((Function3)anon, $completion);
        if (recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return recompositionRunner;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
        final Object stateLock = this.stateLock;
        final int i = 0;
        int i2 = 0;
        removeKnownCompositionLocked(composition);
        final int i3 = 0;
        this.compositionInvalidations.remove(composition);
        (Collection)this.compositionsAwaitingApply.remove(composition);
        Unit $i$a$SynchronizedRecomposer$unregisterComposition$1 = Unit.INSTANCE;
        return;
        synchronized (stateLock) {
            stateLock = this.stateLock;
            i = 0;
            i2 = 0;
            removeKnownCompositionLocked(composition);
            i3 = 0;
            this.compositionInvalidations.remove(composition);
            (Collection)this.compositionsAwaitingApply.remove(composition);
            $i$a$SynchronizedRecomposer$unregisterComposition$1 = Unit.INSTANCE;
        }
    }
}
