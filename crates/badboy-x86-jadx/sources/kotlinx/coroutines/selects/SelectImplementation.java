package kotlinx.coroutines.selects;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0011\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001HB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\u000c0\nR\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0011\u0010\u001f\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0011\u0010$\u001a\u00028\u0000H\u0091@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010%\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001c\u0010&\u001a\u000e\u0018\u00010\nR\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0013\u0010'\u001a\u00020\u001b2\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\u001c\u0010*\u001a\u00020\u001b2\n\u0010+\u001a\u0006\u0012\u0002\u0008\u00030,2\u0006\u0010-\u001a\u00020\u0014H\u0016J-\u0010.\u001a\u00028\u00002\u0010\u0010/\u001a\u000c0\nR\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u00102\u001a\u00020\u001b2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u00103\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\u0008\u00104\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u00105\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u000e2\u0008\u00104\u001a\u0004\u0018\u00010\u000eJ\u001a\u00107\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000e2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u0011\u00108\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J3\u0010'\u001a\u00020\u001b*\u0002092\u001c\u0010:\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0;H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010=JE\u0010'\u001a\u00020\u001b\"\u0004\u0008\u0001\u0010>*\u0008\u0012\u0004\u0012\u0002H>0?2\"\u0010:\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010AJY\u0010'\u001a\u00020\u001b\"\u0004\u0008\u0001\u0010B\"\u0004\u0008\u0002\u0010>*\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H>0C2\u0006\u0010D\u001a\u0002HB2\"\u0010:\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u001b*\u000c0\nR\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010G\u001a\u00020\u0010H\u0001R \u0010\u0008\u001a\u0014\u0012\u000e\u0012\u000c0\nR\u0008\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0012R\u000f\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006I", d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposableHandleOrSegment", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "indexInSegment", "", "internalResult", "isCancelled", "isSelected", "state", "Lkotlinx/atomicfu/AtomicRef;", "checkClauseObject", "", "clauseObject", "cleanup", "selectedClause", "complete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "doSelect", "doSelectSuspend", "findClause", "invoke", "cause", "", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reregisterClause", "selectInRegistrationPhase", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "waitUntilSelected", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SelectImplementation<R>  extends CancelHandler implements kotlinx.coroutines.selects.SelectBuilder<R>, kotlinx.coroutines.selects.SelectInstanceInternal<R> {

    private static final AtomicReferenceFieldUpdater state$FU;
    private List<kotlinx.coroutines.selects.SelectImplementation.ClauseData<R>> clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment = -1;
    private Object internalResult;
    @Volatile
    private volatile Object state;

    @Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0004\u0018\u00002\u00020\u0001B¶\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0007¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b\u0012U\u0010\u000c\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000e\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0007¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014¢\u0006\u0002\u0010\u0015J*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001a\u001a\u00020\nJ\u001b\u0010\u001b\u001a\u00028\u00002\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0014\u0010 \u001a\u00020!2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\"R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000Rq\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0007¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\u000c\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0007¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006#", d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "createOnCancellationAction", "dispose", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "result", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ClauseData {

        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final Function3<kotlinx.coroutines.selects.SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        private final Object param;
        private final Function3<Object, Object, Object, Object> processResFunc;
        private final Function3<Object, kotlinx.coroutines.selects.SelectInstance<?>, Object, Unit> regFunc;
        final kotlinx.coroutines.selects.SelectImplementation<R> this$0;
        public ClauseData(kotlinx.coroutines.selects.SelectImplementation this$0, Object clauseObject, Function3 regFunc, Function3 processResFunc, Object param, Object block, Function3 onCancellationConstructor) {
            this.this$0 = this$0;
            super();
            this.clauseObject = clauseObject;
            this.regFunc = regFunc;
            this.processResFunc = processResFunc;
            this.param = param;
            this.block = block;
            this.onCancellationConstructor = onCancellationConstructor;
            final int i = -1;
        }

        public final Function1<Throwable, Unit> createOnCancellationAction(kotlinx.coroutines.selects.SelectInstance<?> select, Object internalResult) {
            Object invoke;
            Object param;
            Function3 onCancellationConstructor = this.onCancellationConstructor;
            if (onCancellationConstructor != null) {
                invoke = onCancellationConstructor.invoke(select, this.param, internalResult);
            } else {
                invoke = 0;
            }
            return invoke;
        }

        public final void dispose() {
            CoroutineContext context;
            Object obj;
            int i;
            int indexInSegment;
            final Object disposableHandleOrSegment = this.disposableHandleOrSegment;
            final int i2 = 0;
            if (disposableHandleOrSegment instanceof Segment) {
                (Segment)disposableHandleOrSegment.onCancellation(this.indexInSegment, 0, this.this$0.getContext());
            } else {
                if (disposableHandleOrSegment instanceof DisposableHandle) {
                    i = disposableHandleOrSegment;
                }
                if (i != 0) {
                    i.dispose();
                }
            }
        }

        public final Object invokeBlock(Object argument, Continuation<? super R> $completion) {
            Object invoke;
            final Object block = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                Object obj3 = block;
                invoke = (Function1)block.invoke($completion);
            } else {
                Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
                Object obj = block;
                invoke = (Function2)block.invoke(argument, $completion);
            }
            return invoke;
        }

        public final Object processResult(Object result) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result);
        }

        public final boolean tryRegisterAsWaiter(kotlinx.coroutines.selects.SelectImplementation<R> select) {
            boolean aSSERTIONS_ENABLED;
            int aSSERTIONS_ENABLED2;
            int i;
            boolean z;
            kotlinx.coroutines.internal.Symbol symbol;
            i = 0;
            final int i4 = 1;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                int i3 = 0;
                if (!SelectImplementation.access$getInRegistrationPhase(select)) {
                    if (SelectImplementation.access$isCancelled(select)) {
                        aSSERTIONS_ENABLED = i4;
                    } else {
                        aSSERTIONS_ENABLED = i;
                    }
                } else {
                }
                if (aSSERTIONS_ENABLED == 0) {
                } else {
                }
                AssertionError assertionError2 = new AssertionError();
                throw assertionError2;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                int i2 = 0;
                aSSERTIONS_ENABLED2 = SelectImplementation.access$getInternalResult$p(select) == SelectKt.access$getNO_RESULT$p() ? i4 : i;
                if (aSSERTIONS_ENABLED2 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            this.regFunc.invoke(this.clauseObject, select, this.param);
            if (SelectImplementation.access$getInternalResult$p(select) == SelectKt.access$getNO_RESULT$p()) {
                i = i4;
            }
            return i;
        }
    }
    static {
        SelectImplementation.state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    }

    public SelectImplementation(CoroutineContext context) {
        super();
        this.context = context;
        this.state = SelectKt.access$getSTATE_REG$p();
        ArrayList arrayList = new ArrayList(2);
        this.clauses = (List)arrayList;
        int i = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    public static final Object access$complete(kotlinx.coroutines.selects.SelectImplementation $this, Continuation $completion) {
        return $this.complete($completion);
    }

    public static final Object access$doSelectSuspend(kotlinx.coroutines.selects.SelectImplementation $this, Continuation $completion) {
        return $this.doSelectSuspend($completion);
    }

    public static final boolean access$getInRegistrationPhase(kotlinx.coroutines.selects.SelectImplementation $this) {
        return $this.getInRegistrationPhase();
    }

    public static final Object access$getInternalResult$p(kotlinx.coroutines.selects.SelectImplementation $this) {
        return $this.internalResult;
    }

    public static final AtomicReferenceFieldUpdater access$getState$FU$p() {
        return SelectImplementation.state$FU;
    }

    public static final boolean access$isCancelled(kotlinx.coroutines.selects.SelectImplementation $this) {
        return $this.isCancelled();
    }

    public static final Object access$processResultAndInvokeBlockRecoveringException(kotlinx.coroutines.selects.SelectImplementation $this, kotlinx.coroutines.selects.SelectImplementation.ClauseData clause, Object internalResult, Continuation $completion) {
        return $this.processResultAndInvokeBlockRecoveringException(clause, internalResult, $completion);
    }

    public static final void access$reregisterClause(kotlinx.coroutines.selects.SelectImplementation $this, Object clauseObject) {
        $this.reregisterClause(clauseObject);
    }

    public static final Object access$waitUntilSelected(kotlinx.coroutines.selects.SelectImplementation $this, Continuation $completion) {
        return $this.waitUntilSelected($completion);
    }

    private final void checkClauseObject(Object clauseObject) {
        boolean iterator;
        int i2;
        boolean next;
        int it;
        int i;
        Object clauseObject2;
        int i3;
        final List clauses = this.clauses;
        Intrinsics.checkNotNull(clauses);
        List list = clauses;
        int i5 = 0;
        if (list instanceof Collection != null && (Collection)(Iterable)list.isEmpty()) {
            if ((Collection)list.isEmpty()) {
            } else {
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    i = 0;
                    i3 = 0;
                    if (obj.clauseObject == clauseObject) {
                    } else {
                    }
                    it = i3;
                    it = i2;
                }
            }
        } else {
        }
        if (i2 == 0) {
        } else {
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Cannot use select clauses on the same object: ").append(clauseObject).toString().toString());
        throw illegalStateException;
    }

    private final void cleanup(kotlinx.coroutines.selects.SelectImplementation.ClauseData<R> selectedClause) {
        boolean aSSERTIONS_ENABLED;
        Object obj;
        Object next;
        Object obj2;
        int i;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i2 = 0;
            if (!Intrinsics.areEqual(SelectImplementation.state$FU.get(this), selectedClause)) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        List clauses = this.clauses;
        if (clauses == null) {
        }
        int i4 = 0;
        final Iterator iterator = (Iterable)clauses.iterator();
        while (iterator.hasNext()) {
            obj2 = next;
            i = 0;
            if ((SelectImplementation.ClauseData)obj2 != selectedClause) {
            }
            (SelectImplementation.ClauseData)obj2.dispose();
        }
        SelectImplementation.state$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = 0;
    }

    private final Object complete(Continuation<? super R> $completion) {
        boolean aSSERTIONS_ENABLED;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i = 0;
            if (!isSelected()) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        Object obj = SelectImplementation.state$FU.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        Object internalResult = this.internalResult;
        cleanup((SelectImplementation.ClauseData)obj);
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return obj.invokeBlock(obj.processResult(internalResult), $completion);
        }
        return processResultAndInvokeBlockRecoveringException(obj, internalResult, $completion);
    }

    static <R> Object doSelect$suspendImpl(kotlinx.coroutines.selects.SelectImplementation<R> $this, Continuation<? super R> $completion) {
        if ($this.isSelected()) {
            return $this.complete($completion);
        }
        return $this.doSelectSuspend($completion);
    }

    private final Object doSelectSuspend(Continuation<? super R> continuation) {
        boolean anon;
        int i;
        int i2;
        Object l$0;
        Object complete;
        Object waitUntilSelected;
        Object obj5;
        anon = continuation;
        i2 = Integer.MIN_VALUE;
        if (continuation instanceof SelectImplementation.doSelectSuspend.1 && label &= i2 != 0) {
            anon = continuation;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj5 -= i2;
            } else {
                anon = new SelectImplementation.doSelectSuspend.1(this, continuation);
            }
        } else {
        }
        obj5 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj5);
                l$0 = this;
                anon.L$0 = l$0;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj5);
                break;
            case 2:
                ResultKt.throwOnFailure(obj5);
                complete = obj5;
                return complete;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        anon.L$0 = 0;
        anon.label = 2;
        if (l$0.complete(anon) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
    }

    private final kotlinx.coroutines.selects.SelectImplementation.ClauseData<R> findClause(Object clauseObject) {
        int i3;
        Object next;
        Object obj;
        int i;
        int i2;
        final List clauses = this.clauses;
        if (clauses == null) {
            return 0;
        }
        Iterator iterator = (Iterable)clauses.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i = 0;
            if (obj.clauseObject == clauseObject) {
            } else {
            }
            i2 = 0;
            if (i2 != 0) {
                break;
            } else {
            }
            i2 = 1;
        }
        if ((SelectImplementation.ClauseData)i3 == 0) {
        } else {
            return (SelectImplementation.ClauseData)i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Clause with object ").append(clauseObject).append(" is not found").toString().toString());
        throw illegalStateException;
    }

    private final boolean getInRegistrationPhase() {
        int i;
        kotlinx.coroutines.internal.Symbol symbol;
        Object obj = SelectImplementation.state$FU.get(this);
        final int i2 = 0;
        if (obj != SelectKt.access$getSTATE_REG$p()) {
            if (obj instanceof List != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final boolean isCancelled() {
        int i;
        i = SelectImplementation.state$FU.get(this) == SelectKt.access$getSTATE_CANCELLED$p() ? 1 : 0;
        return i;
    }

    private final boolean isSelected() {
        return obj instanceof SelectImplementation.ClauseData;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final Object processResultAndInvokeBlockRecoveringException(kotlinx.coroutines.selects.SelectImplementation.ClauseData<R> selectImplementation.ClauseData, Object object2, Continuation<? super R> continuation3) {
        boolean anon;
        int z;
        int i;
        int result;
        Object obj6;
        Object obj7;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof SelectImplementation.processResultAndInvokeBlockRecoveringException.1 && label &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj7 -= i;
            } else {
                anon = new SelectImplementation.processResultAndInvokeBlockRecoveringException.1(this, continuation3);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (result) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj7);
                obj6 = obj7;
                break;
            default:
                IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return obj6;
    }

    public static void register$default(kotlinx.coroutines.selects.SelectImplementation selectImplementation, kotlinx.coroutines.selects.SelectImplementation.ClauseData selectImplementation$ClauseData2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            selectImplementation.register(clauseData2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        throw obj0;
    }

    private final void reregisterClause(Object clauseObject) {
        final kotlinx.coroutines.selects.SelectImplementation.ClauseData clause = findClause(clauseObject);
        Intrinsics.checkNotNull(clause);
        clause.disposableHandleOrSegment = 0;
        clause.indexInSegment = -1;
        register(clause, true);
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        Object obj;
        kotlinx.coroutines.selects.SelectImplementation.ClauseData clause;
        int i;
        int listOf;
        Function1 onCancellationAction;
        boolean z;
        obj = SelectImplementation.state$FU.get(this);
        listOf = 2;
        while (obj instanceof CancellableContinuation) {
            clause = findClause(clauseObject);
            obj = SelectImplementation.state$FU.get(this);
            listOf = 2;
            onCancellationAction = 1;
            if (Intrinsics.areEqual(obj, SelectKt.access$getSTATE_COMPLETED$p())) {
            } else {
            }
            i = obj instanceof SelectImplementation.ClauseData;
            i = onCancellationAction;
        }
        this.internalResult = internalResult;
        if (SelectKt.access$tryResume((CancellableContinuation)obj, clause.createOnCancellationAction((SelectInstance)this, internalResult))) {
            return 0;
        }
        this.internalResult = 0;
        return listOf;
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function12, Object object3) {
        boolean z;
        Object invoke;
        final int i = 0;
        Object obj = atomicReferenceFieldUpdater.get(object3);
        while (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object3, obj, function12.invoke(obj))) {
            obj = atomicReferenceFieldUpdater.get(object3);
        }
    }

    private final Object waitUntilSelected(Continuation<? super Unit> $completion) {
        int $i$f$suspendCancellableCoroutine3;
        Object obj2;
        int i;
        boolean z;
        Object onCancellationAction;
        kotlinx.coroutines.internal.Symbol symbol;
        int i3;
        Iterator iterator;
        boolean next;
        Object obj;
        int i2;
        int $i$f$suspendCancellableCoroutine;
        int $i$f$suspendCancellableCoroutine2;
        final Object obj3 = this;
        $i$f$suspendCancellableCoroutine3 = 0;
        final int i4 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i6 = 0;
        final Object obj4 = this;
        final int i7 = 0;
        obj2 = SelectImplementation.access$getState$FU$p().get(obj3);
        i = 0;
        while (obj2 == SelectKt.access$getSTATE_REG$p()) {
            $i$f$suspendCancellableCoroutine = $i$f$suspendCancellableCoroutine3;
            $i$f$suspendCancellableCoroutine3 = $i$f$suspendCancellableCoroutine;
            obj2 = field.get(obj3);
            i = 0;
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.access$getState$FU$p(), obj3, obj2, SelectKt.access$getSTATE_REG$p())) {
            } else {
            }
            $i$f$suspendCancellableCoroutine = $i$f$suspendCancellableCoroutine3;
            Object obj5 = obj2;
            symbol = 0;
            iterator = (Iterable)obj2.iterator();
            for (Object next : iterator) {
                i2 = 0;
                SelectImplementation.access$reregisterClause(obj3, next);
                $i$f$suspendCancellableCoroutine3 = $i$f$suspendCancellableCoroutine;
            }
            $i$f$suspendCancellableCoroutine = $i$f$suspendCancellableCoroutine3;
            i2 = 0;
            SelectImplementation.access$reregisterClause(obj3, iterator.next());
            $i$f$suspendCancellableCoroutine3 = $i$f$suspendCancellableCoroutine;
        }
        i3 = 0;
        cancellableContinuationImpl2.invokeOnCancellation((Function1)(CancelHandlerBase)obj3);
        $i$f$suspendCancellableCoroutine2 = $i$f$suspendCancellableCoroutine3;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    public Object doSelect(Continuation<? super R> continuation) {
        return SelectImplementation.doSelect$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.CancelHandler
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public Object invoke(Object p1) {
        invoke((Throwable)p1);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void invoke(Throwable cause) {
        boolean z;
        kotlinx.coroutines.internal.Symbol cur;
        int i;
        kotlinx.coroutines.internal.Symbol symbol;
        AtomicReferenceFieldUpdater state$FU = SelectImplementation.state$FU;
        Object obj = this;
        int i3 = 0;
        Object obj2 = state$FU.get(this);
        i = 0;
        while (obj2 == SelectKt.access$getSTATE_COMPLETED$p()) {
            obj2 = state$FU.get(this);
            i = 0;
        }
    }

    public void invoke(kotlinx.coroutines.selects.SelectClause0 $this$invoke, Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.ClauseData clauseData = new SelectImplementation.ClauseData(this, $this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), block, $this$invoke.getOnCancellationConstructor());
        SelectImplementation.register$default(this, clauseData, false, 1, 0);
    }

    public <Q> void invoke(kotlinx.coroutines.selects.SelectClause1<? extends Q> $this$invoke, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.ClauseData clauseData = new SelectImplementation.ClauseData(this, $this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), 0, block, $this$invoke.getOnCancellationConstructor());
        SelectImplementation.register$default(this, clauseData, false, 1, 0);
    }

    public <P, Q> void invoke(kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> $this$invoke, P param, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.ClauseData clauseData = new SelectImplementation.ClauseData(this, $this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), param, block, $this$invoke.getOnCancellationConstructor());
        SelectImplementation.register$default(this, clauseData, false, 1, 0);
    }

    public <P, Q> void invoke(kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> $this$invoke, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectBuilder.DefaultImpls.invoke(this, $this$invoke, block);
    }

    public void invokeOnCancellation(Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(...))
    public void onTimeout(long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectBuilder.DefaultImpls.onTimeout(this, timeMillis, block);
    }

    public final void register(kotlinx.coroutines.selects.SelectImplementation.ClauseData<R> $this$register, boolean reregister) {
        boolean aSSERTIONS_ENABLED;
        boolean it;
        boolean tryRegisterAsWaiter;
        int state$FU;
        int i;
        kotlinx.coroutines.internal.Symbol symbol;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = SelectImplementation.state$FU.get(this) != SelectKt.access$getSTATE_CANCELLED$p() ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        int i3 = 0;
        if (obj instanceof SelectImplementation.ClauseData != null) {
        }
        if (!reregister) {
            checkClauseObject($this$register.clauseObject);
        }
        if ($this$register.tryRegisterAsWaiter(this)) {
            if (!reregister) {
                tryRegisterAsWaiter = this.clauses;
                Intrinsics.checkNotNull(tryRegisterAsWaiter);
                (Collection)tryRegisterAsWaiter.add($this$register);
            }
            $this$register.disposableHandleOrSegment = this.disposableHandleOrSegment;
            $this$register.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = 0;
            this.indexInSegment = -1;
        } else {
            SelectImplementation.state$FU.set(this, $this$register);
        }
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void selectInRegistrationPhase(Object internalResult) {
        this.internalResult = internalResult;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public boolean trySelect(Object clauseObject, Object result) {
        int i;
        i = trySelectInternal(clauseObject, result) == 0 ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final kotlinx.coroutines.selects.TrySelectDetailedResult trySelectDetailed(Object clauseObject, Object result) {
        return SelectKt.access$TrySelectDetailedResult(trySelectInternal(clauseObject, result));
    }
}
