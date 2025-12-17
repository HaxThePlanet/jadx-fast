package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000È\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0011\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001b\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0008\u00102\u001a\u0004\u0018\u000103J;\u0010.\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/04j\u0002`72\u0008\u00102\u001a\u0004\u0018\u000103H\u0002J\u0017\u00108\u001a\u00020/2\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u00020/0:H\u0082\u0008J1\u0010;\u001a\u00020/2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/042\u0006\u00102\u001a\u000203J\u001e\u0010=\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\u0008\u00030?2\u0008\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010@\u001a\u00020\u001d2\u0008\u00102\u001a\u0004\u0018\u000103H\u0016J\u001f\u0010A\u001a\u00020/2\u0008\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0010¢\u0006\u0002\u0008CJ\u0010\u0010D\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\u0012H\u0016J\r\u0010G\u001a\u00020/H\u0000¢\u0006\u0002\u0008HJ\u0008\u0010I\u001a\u00020/H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020NH\u0016J\u0019\u0010O\u001a\u0004\u0018\u0001032\u0008\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\u0008PJ\n\u0010Q\u001a\u0004\u0018\u00010\u0012H\u0001J\u0010\u0010R\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0016J\u001f\u0010U\u001a\u0002H\u0001\"\u0004\u0008\u0001\u0010\u00012\u0008\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0004\u0008V\u0010WJ\u0008\u0010X\u001a\u00020/H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0010H\u0002J1\u0010Z\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/04j\u0002`7H\u0016J\u001c\u0010Z\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\u0008\u00030?2\u0006\u0010[\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0008\u0010]\u001a\u00020\u001dH\u0002J1\u0010^\u001a\u0002012'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/04j\u0002`7H\u0002J\u001a\u0010_\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\u0008\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\u0008\u0010`\u001a\u00020(H\u0014J\u0015\u0010a\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\u0008bJ\r\u0010c\u001a\u00020/H\u0000¢\u0006\u0002\u0008dJ\u0008\u0010e\u001a\u00020\u001dH\u0001J:\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00028\u00002#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0016¢\u0006\u0002\u0010hJA\u0010i\u001a\u00020/2\u0008\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2%\u0008\u0002\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0002J\u001e\u0010j\u001a\u00020/2\u000c\u0010k\u001a\u0008\u0012\u0004\u0012\u00028\u00000lH\u0016ø\u0001\u0000¢\u0006\u0002\u0010mJS\u0010n\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020o2\u0008\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/\u0018\u0001042\u0008\u0010p\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010q\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\u0008rJ\u0008\u0010s\u001a\u00020(H\u0016J\u0008\u0010t\u001a\u00020\u001dH\u0002J!\u0010t\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00028\u00002\u0008\u0010p\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010uJF\u0010t\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00028\u00002\u0008\u0010p\u001a\u0004\u0018\u00010\u00122#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0016¢\u0006\u0002\u0010vJC\u0010w\u001a\u0004\u0018\u00010x2\u0008\u0010-\u001a\u0004\u0018\u00010\u00122\u0008\u0010p\u001a\u0004\u0018\u00010\u00122#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0002J\u0012\u0010y\u001a\u0004\u0018\u00010\u00122\u0006\u0010z\u001a\u000203H\u0016J\u0008\u0010{\u001a\u00020\u001dH\u0002J\u0019\u0010|\u001a\u00020/*\u00020}2\u0006\u0010g\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010~J\u0014\u0010\u007f\u001a\u00020/*\u00020}2\u0006\u0010z\u001a\u000203H\u0016R\t\u0010\u000c\u001a\u00020\rX\u0082\u0004R\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004R\u001c\u0010\u0013\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0080\u0001", d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/DisposableHandle;", "_state", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "alreadyResumedError", "", "proposedUpdate", "callCancelHandler", "", "handler", "Lkotlinx/coroutines/CancelHandler;", "cause", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callOnCancellation", "onCancellation", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "cancel", "cancelCompletedResult", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "completeResume", "token", "detachChild", "detachChild$kotlinx_coroutines_core", "detachChildIfNonResuable", "dispatchResume", "mode", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getResult", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "installParentHandle", "invokeOnCancellation", "index", "invokeOnCancellationImpl", "isReusable", "makeCancelHandler", "multipleHandlersError", "nameString", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resetStateReusable", "resume", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "takeState", "takeState$kotlinx_coroutines_core", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeWithException", "exception", "trySuspend", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class CancellableContinuationImpl<T>  extends kotlinx.coroutines.DispatchedTask<T> implements kotlinx.coroutines.CancellableContinuation<T>, CoroutineStackFrame, kotlinx.coroutines.Waiter {

    private static final AtomicIntegerFieldUpdater _decisionAndIndex$FU;
    private static final AtomicReferenceFieldUpdater _parentHandle$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    @Volatile
    private volatile int _decisionAndIndex;
    @Volatile
    private volatile Object _parentHandle;
    @Volatile
    private volatile Object _state = null;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    static {
        final Class<kotlinx.coroutines.CancellableContinuationImpl> obj3 = CancellableContinuationImpl.class;
        CancellableContinuationImpl._decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(obj3, "_decisionAndIndex");
        CancellableContinuationImpl._state$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_state");
        CancellableContinuationImpl._parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_parentHandle");
    }

    public CancellableContinuationImpl(Continuation<? super T> delegate, int resumeMode) {
        boolean aSSERTIONS_ENABLED;
        int i;
        super(resumeMode);
        this.delegate = delegate;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = resumeMode != -1 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        this.context = this.delegate.getContext();
        final int i5 = 0;
        this._decisionAndIndex = i6 += i3;
        kotlinx.coroutines.Active iNSTANCE = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object proposedUpdate) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Already resumed, but proposed with update ").append(proposedUpdate).toString().toString());
        throw illegalStateException;
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> handler, Throwable cause) {
        int i2;
        CoroutineContext obj2;
        int i;
        StringBuilder string;
        String str;
        final Object obj = this;
        final int i3 = 0;
        i2 = 0;
        i = 0;
        handler.invoke(cause);
    }

    private final void callCancelHandlerSafely(Function0<Unit> block) {
        Throwable th;
        CoroutineContext context;
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        StringBuilder string;
        String str;
        final int i = 0;
        block.invoke();
        try {
        }
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable cause) {
        int i;
        int i2;
        CoroutineContext context;
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        StringBuilder string;
        String str;
        int i4 = 0;
        int i6 = 536870911;
        i3 &= i6;
        i = $this$index$iv != i6 ? 1 : 0;
        if (i == 0) {
        } else {
            Object obj = this;
            int i7 = 0;
            i2 = 0;
            segment.onCancellation($this$index$iv, cause, getContext());
        }
        int i5 = 0;
        IllegalStateException $i$a$CheckCancellableContinuationImpl$callSegmentOnCancellation$1 = new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        throw $i$a$CheckCancellableContinuationImpl$callSegmentOnCancellation$1;
    }

    private final boolean cancelLater(Throwable cause) {
        if (!isReusable()) {
            return 0;
        }
        Continuation delegate = this.delegate;
        Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return (DispatchedContinuation)delegate.postponeCancellation$kotlinx_coroutines_core(cause);
    }

    private final void detachChildIfNonResuable() {
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int mode) {
        if (tryResume()) {
        }
        DispatchedTaskKt.dispatch((DispatchedTask)this, mode);
    }

    private final kotlinx.coroutines.DisposableHandle getParentHandle() {
        return (DisposableHandle)CancellableContinuationImpl._parentHandle$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        String str;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        str = state$kotlinx_coroutines_core instanceof NotCompleted ? "Active" : z ? "Cancelled" : "Completed";
        return str;
    }

    private final kotlinx.coroutines.DisposableHandle installParentHandle() {
        kotlin.coroutines.CoroutineContext.Element context2 = getContext().get((CoroutineContext.Key)Job.Key);
        int i = 0;
        if ((Job)context2 == null) {
            return i;
        }
        ChildContinuation childContinuation = new ChildContinuation(this);
        int i2 = 0;
        kotlinx.coroutines.DisposableHandle onCompletion$default = Job.DefaultImpls.invokeOnCompletion$default((Job)context2, true, false, (Function1)(CompletionHandlerBase)childContinuation, 2, 0);
        AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl._parentHandle$FU, this, i, onCompletion$default);
        return onCompletion$default;
    }

    private final void invokeOnCancellationImpl(Object handler) {
        boolean aSSERTIONS_ENABLED;
        int i8;
        boolean obj2;
        int i13;
        boolean z2;
        boolean completedContinuation;
        int cause;
        Object obj;
        boolean z;
        int i10;
        int i;
        int i3;
        int i9;
        int i4;
        int i12;
        Object obj3;
        int i14;
        Object obj4;
        int i6;
        int i2;
        int i5;
        int i7;
        int i11;
        final Object obj5 = this;
        final Object obj6 = handler;
        int i15 = 1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (obj6 instanceof CancelHandler == null) {
                if (obj6 instanceof Segment) {
                    i13 = i15;
                } else {
                    i13 = 0;
                }
            } else {
            }
            if (i13 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        Object obj9 = this;
        final int i16 = 0;
        obj = CancellableContinuationImpl._state$FU.get(obj5);
        i12 = 0;
        while (obj instanceof Active) {
            obj = _state$FU.get(obj5);
            i12 = 0;
            if (obj instanceof CancelHandler != null) {
            } else {
            }
            completedContinuation = obj instanceof Segment;
            String str2 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler";
            Intrinsics.checkNotNull(obj6, str2);
            Object obj10 = obj6;
            completedContinuation = new CompletedContinuation(obj, (CancelHandler)obj6, 0, 0, 0, 28, 0);
            if (obj11.cancelHandler != null) {
            }
            Intrinsics.checkNotNull(obj6, str2);
            Object obj12 = obj6;
            obj5.multipleHandlersError(obj6, obj);
            obj5.multipleHandlersError(obj6, obj);
            completedContinuation = i15;
        }
    }

    private final boolean isReusable() {
        boolean reusable$kotlinx_coroutines_core;
        int i;
        String str;
        Continuation delegate = this.delegate;
        Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (DispatchedTaskKt.isReusableMode(this.resumeMode) && (DispatchedContinuation)delegate.isReusable$kotlinx_coroutines_core()) {
            delegate = this.delegate;
            Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            i = (DispatchedContinuation)delegate.isReusable$kotlinx_coroutines_core() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function12, Object object3) {
        Integer valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(object3)));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final kotlinx.coroutines.CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> handler) {
        Object invokeOnCancel;
        if (handler instanceof CancelHandler != null) {
            invokeOnCancel = handler;
        } else {
            invokeOnCancel = new InvokeOnCancel(handler);
        }
        return invokeOnCancel;
    }

    private final void multipleHandlersError(Object handler, Object state) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("It's prohibited to register multiple handlers, tried to register ").append(handler).append(", already has ").append(state).toString().toString());
        throw illegalStateException;
    }

    private final void resumeImpl(Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation) {
        Object obj3;
        int i3;
        boolean z;
        Object obj4;
        Object obj;
        Object obj2;
        int i2;
        Function1 function1;
        int i;
        Object obj13;
        int obj14;
        Function1 obj15;
        final Object obj5 = this;
        final int i4 = 0;
        obj3 = CancellableContinuationImpl._state$FU.get(this);
        i3 = 0;
        while (obj3 instanceof NotCompleted) {
            obj2 = obj13;
            i2 = obj14;
            function1 = obj15;
            obj13 = obj2;
            obj14 = i2;
            obj15 = function1;
            obj3 = _state$FU.get(this);
            i3 = 0;
        }
        Object obj6 = this;
        int i5 = obj14;
        Function1 function12 = obj15;
        if (!obj3 instanceof CancelledContinuation) {
        } else {
            if (!(CancelledContinuation)obj3.makeResumed()) {
            } else {
                if (function12 != null) {
                    obj14 = 0;
                    callOnCancellation(function12, obj15.cause);
                }
            }
        }
        alreadyResumedError(obj13);
        obj13 = new KotlinNothingValueException();
        throw obj13;
    }

    static void resumeImpl$default(kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl, Object object2, int i3, Function1 function14, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            cancellableContinuationImpl.resumeImpl(object2, i3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        throw obj0;
    }

    private final Object resumedState(kotlinx.coroutines.NotCompleted state, Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation, Object idempotent) {
        boolean aSSERTIONS_ENABLED;
        int $i$a$AssertCancellableContinuationImpl$resumedState$1;
        int i2;
        Object completedContinuation;
        int i6;
        Object obj2;
        int i;
        Function1 function1;
        Object obj;
        int i4;
        int i3;
        int i5;
        if (proposedUpdate instanceof CompletedExceptionally) {
            i6 = 0;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                int i7 = 0;
                $i$a$AssertCancellableContinuationImpl$resumedState$1 = idempotent == null ? i2 : i6;
                if ($i$a$AssertCancellableContinuationImpl$resumedState$1 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                if (onCancellation == null) {
                } else {
                    i2 = i6;
                }
                if (i2 == 0) {
                } else {
                }
                AssertionError assertionError2 = new AssertionError();
                throw assertionError2;
            }
            obj2 = completedContinuation;
            function1 = onCancellation;
            obj = idempotent;
        } else {
            if (!DispatchedTaskKt.isCancellableMode(resumeMode) && idempotent == null) {
                if (idempotent == null) {
                } else {
                    if (onCancellation == null && state instanceof CancelHandler == null) {
                        if (state instanceof CancelHandler == null) {
                            if (idempotent != null) {
                                if (state instanceof CancelHandler != null) {
                                    aSSERTIONS_ENABLED = state;
                                } else {
                                    aSSERTIONS_ENABLED = 0;
                                }
                                completedContinuation = new CompletedContinuation(proposedUpdate, aSSERTIONS_ENABLED, onCancellation, idempotent, 0, 16, 0);
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        return completedContinuation;
    }

    private final boolean tryResume() {
        int i2;
        int i3;
        boolean compareAndSet;
        int $this$index$iv;
        int i4;
        int i5;
        int i;
        final Object obj = this;
        final int i6 = 0;
        while (/* condition */) {
            int i12 = 0;
            i5 = 0;
            i2 = CancellableContinuationImpl._decisionAndIndex$FU.get(this);
            i3 = 0;
            int i10 = 0;
        }
        return 0;
    }

    private final Symbol tryResumeImpl(Object proposedUpdate, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        Object obj;
        int i;
        boolean z;
        Object obj4;
        Object obj5;
        Object obj2;
        int resumeMode;
        Function1 function1;
        Object obj3;
        Object obj13;
        Object obj14;
        Function1 obj15;
        final Object obj6 = this;
        final int i2 = 0;
        obj = CancellableContinuationImpl._state$FU.get(this);
        i = 0;
        while (obj instanceof NotCompleted) {
            obj2 = obj13;
            obj3 = obj14;
            function1 = obj15;
            obj13 = obj2;
            obj15 = function1;
            obj14 = obj3;
            obj = _state$FU.get(this);
            i = 0;
        }
        Object obj7 = this;
        Object obj9 = obj14;
        Function1 function12 = obj15;
        if (obj instanceof CompletedContinuation) {
            if (obj9 != null && obj13.idempotentResume == obj9) {
                if (obj13.idempotentResume == obj9) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        obj13 = 0;
                        if (!Intrinsics.areEqual(obj14.result, obj13)) {
                        } else {
                        }
                        obj13 = new AssertionError();
                        throw obj13;
                    }
                    obj14 = CancellableContinuationImplKt.RESUME_TOKEN;
                } else {
                }
            } else {
            }
            return obj14;
        }
        return null;
    }

    private final boolean trySuspend() {
        int i;
        int i2;
        boolean compareAndSet;
        int $this$index$iv;
        int i6;
        int i3;
        int i5;
        int i4;
        final Object obj = this;
        final int i7 = 0;
        while (/* condition */) {
            int i12 = 0;
            i6 = 1;
            i5 = 0;
            i = CancellableContinuationImpl._decisionAndIndex$FU.get(this);
            i2 = 0;
            int i10 = 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already suspended".toString());
        throw illegalStateException;
    }

    private final void update$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function12, Object object3) {
        boolean compareAndSet;
        int intValue;
        final int i = 0;
        int i2 = atomicIntegerFieldUpdater.get(object3);
        while (atomicIntegerFieldUpdater.compareAndSet(object3, i2, (Number)function12.invoke(Integer.valueOf(i2)).intValue())) {
            i2 = atomicIntegerFieldUpdater.get(object3);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void callCancelHandler(kotlinx.coroutines.CancelHandler handler, Throwable cause) {
        int i;
        CoroutineContext context;
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        StringBuilder string;
        String str;
        final Object obj = this;
        final int i2 = 0;
        i = 0;
        handler.invoke(cause);
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> onCancellation, Throwable cause) {
        Throwable th;
        CoroutineContext context;
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        StringBuilder string;
        String str;
        onCancellation.invoke(cause);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public boolean cancel(Throwable cause) {
        Object obj2;
        int i2;
        kotlinx.coroutines.CancelledContinuation cancelledContinuation;
        boolean z3;
        int i;
        boolean z2;
        Object obj;
        boolean z;
        int i3;
        final Object obj3 = this;
        final int i4 = 0;
        obj2 = CancellableContinuationImpl._state$FU.get(this);
        i2 = 0;
        while (!obj2 instanceof NotCompleted) {
            i3 = 1;
            if (obj2 instanceof CancelHandler == null) {
            } else {
            }
            i = i3;
            cancelledContinuation = new CancelledContinuation((Continuation)this, cause, i);
            obj2 = _state$FU.get(this);
            i2 = 0;
            if (obj2 instanceof Segment) {
            }
        }
        return 0;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object takenState, Throwable cause) {
        boolean copy$default;
        Object obj;
        int i3;
        int i12;
        int i4;
        Throwable th;
        int i11;
        int i2;
        int i7;
        AtomicReferenceFieldUpdater _state$FU;
        int i8;
        int i6;
        int i;
        int i10;
        Throwable th2;
        int i5;
        int i9;
        final Object obj2 = this;
        final Object obj3 = this;
        final int i13 = 0;
        obj = CancellableContinuationImpl._state$FU.get(obj2);
        i7 = 0;
        while (!obj instanceof NotCompleted) {
            CompletedContinuation completedContinuation = new CompletedContinuation(obj, 0, 0, 0, cause, 14, 0);
            obj = _state$FU2.get(obj2);
            i7 = 0;
            th = cause;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not completed".toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void completeResume(Object token) {
        boolean aSSERTIONS_ENABLED;
        int i;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = token == CancellableContinuationImplKt.RESUME_TOKEN ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        dispatchResume(this.resumeMode);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void detachChild$kotlinx_coroutines_core() {
        final kotlinx.coroutines.DisposableHandle parentHandle = getParentHandle();
        if (parentHandle == null) {
        }
        parentHandle.dispose();
        CancellableContinuationImpl._parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public CoroutineStackFrame getCallerFrame() {
        Continuation delegate;
        if (delegate instanceof CoroutineStackFrame) {
        } else {
            delegate = 0;
        }
        return delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getContinuationCancellationCause(kotlinx.coroutines.Job parent) {
        return (Throwable)parent.getCancellationException();
    }

    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object state) {
        int i3;
        Continuation delegate;
        int i2;
        Throwable i;
        boolean rECOVER_STACK_TRACES;
        final Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            i3 = 0;
            delegate = this.delegate;
            i2 = 0;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                if (!delegate instanceof CoroutineStackFrame) {
                    i = exceptionalResult$kotlinx_coroutines_core;
                } else {
                    i = StackTraceRecoveryKt.access$recoverFromStackFrame(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame)delegate);
                }
            } else {
            }
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object getResult() {
        boolean cancellableMode;
        Throwable exception$iv;
        kotlinx.coroutines.Job.Key active;
        boolean rECOVER_STACK_TRACES;
        Object obj;
        boolean rECOVER_STACK_TRACES2;
        Object obj2;
        final boolean reusable = isReusable();
        if (trySuspend() && getParentHandle() == null) {
            if (getParentHandle() == null) {
                installParentHandle();
            }
            if (reusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (reusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            int i = 0;
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
            } else {
                if (!obj4 instanceof CoroutineStackFrame) {
                } else {
                    exception$iv = rECOVER_STACK_TRACES;
                }
            }
            throw exception$iv;
        }
        cancellableMode = getContext().get((CoroutineContext.Key)Job.Key);
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && cancellableMode != null && !(Job)cancellableMode.isActive()) {
            cancellableMode = getContext().get((CoroutineContext.Key)Job.Key);
            if ((Job)cancellableMode != null) {
                if (!(Job)cancellableMode.isActive()) {
                    java.util.concurrent.CancellationException cancellationException = cancellableMode.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, (Throwable)cancellationException);
                    int i2 = 0;
                    if (DebugKt.getRECOVER_STACK_TRACES()) {
                        if (!obj5 instanceof CoroutineStackFrame) {
                            obj = cancellationException;
                        } else {
                            obj = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)cancellationException, (CoroutineStackFrame)(Continuation)this);
                        }
                    } else {
                    }
                    throw obj;
                }
            }
        }
        return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object getState$kotlinx_coroutines_core() {
        return CancellableContinuationImpl._state$FU.get(this);
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object state) {
        Object result;
        if (state instanceof CompletedContinuation) {
            result = obj.result;
        } else {
            result = state;
        }
        return result;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void initCancellability() {
        boolean _parentHandle$FU;
        kotlinx.coroutines.NonDisposableHandle iNSTANCE;
        final kotlinx.coroutines.DisposableHandle installParentHandle = installParentHandle();
        if (installParentHandle == null) {
        }
        if (isCompleted()) {
            installParentHandle.dispose();
            CancellableContinuationImpl._parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    public void invokeOnCancellation(Function1<? super Throwable, Unit> handler) {
        invokeOnCancellationImpl(makeCancelHandler(handler));
    }

    public void invokeOnCancellation(Segment<?> segment, int index) {
        boolean compareAndSet;
        int i3;
        int i;
        int $this$decision$iv;
        int i2;
        int i4;
        int i5;
        final AtomicIntegerFieldUpdater _decisionAndIndex$FU = CancellableContinuationImpl._decisionAndIndex$FU;
        final Object obj = this;
        final int i6 = 0;
        int i7 = _decisionAndIndex$FU.get(this);
        i3 = i7;
        i = 0;
        int i11 = 0;
        int i13 = 536870911;
        while (i9 &= i13 == i13) {
            i2 = 1;
            int i12 = 0;
            i4 = 0;
            i7 = _decisionAndIndex$FU.get(this);
            i3 = i7;
            i = 0;
            i11 = 0;
            i13 = 536870911;
            i2 = 0;
        }
        int i8 = 0;
        IllegalStateException $i$a$CheckCancellableContinuationImpl$invokeOnCancellation$1$1 = new IllegalStateException("invokeOnCancellation should be called at most once".toString());
        throw $i$a$CheckCancellableContinuationImpl$invokeOnCancellation$1$1;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public boolean isActive() {
        return state$kotlinx_coroutines_core instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public boolean isCancelled() {
        return state$kotlinx_coroutines_core instanceof CancelledContinuation;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public boolean isCompleted() {
        return z ^= 1;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    protected String nameString() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void parentCancelled$kotlinx_coroutines_core(Throwable cause) {
        if (cancelLater(cause)) {
        }
        cancel(cause);
        detachChildIfNonResuable();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        int tryReleaseClaimedContinuation$kotlinx_coroutines_core;
        boolean z;
        if (tryReleaseClaimedContinuation$kotlinx_coroutines_core instanceof DispatchedContinuation) {
        } else {
            tryReleaseClaimedContinuation$kotlinx_coroutines_core = 0;
        }
        tryReleaseClaimedContinuation$kotlinx_coroutines_core = tryReleaseClaimedContinuation$kotlinx_coroutines_core.tryReleaseClaimedContinuation$kotlinx_coroutines_core((CancellableContinuation)this);
        if (tryReleaseClaimedContinuation$kotlinx_coroutines_core != 0 && tryReleaseClaimedContinuation$kotlinx_coroutines_core == null) {
            tryReleaseClaimedContinuation$kotlinx_coroutines_core = tryReleaseClaimedContinuation$kotlinx_coroutines_core.tryReleaseClaimedContinuation$kotlinx_coroutines_core((CancellableContinuation)this);
            if (tryReleaseClaimedContinuation$kotlinx_coroutines_core == null) {
            }
            detachChild$kotlinx_coroutines_core();
            cancel(tryReleaseClaimedContinuation$kotlinx_coroutines_core);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final boolean resetStateReusable() {
        int $i$a$AssertCancellableContinuationImpl$resetStateReusable$1;
        boolean $i$a$AssertCancellableContinuationImpl$resetStateReusable$2;
        int parentHandle;
        boolean aSSERTIONS_ENABLED;
        boolean idempotentResume;
        int iNSTANCE;
        int i3 = 1;
        int i4 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i = 0;
            $i$a$AssertCancellableContinuationImpl$resetStateReusable$1 = this.resumeMode == 2 ? i3 : i4;
            if ($i$a$AssertCancellableContinuationImpl$resetStateReusable$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i2 = 0;
            $i$a$AssertCancellableContinuationImpl$resetStateReusable$2 = getParentHandle() != NonDisposableHandle.INSTANCE ? i3 : i4;
            if ($i$a$AssertCancellableContinuationImpl$resetStateReusable$2 == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        Object obj = CancellableContinuationImpl._state$FU.get(this);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (obj instanceof NotCompleted) {
            } else {
            }
            AssertionError assertionError3 = new AssertionError();
            throw assertionError3;
        }
        if (obj instanceof CompletedContinuation && obj2.idempotentResume != null) {
            if (obj2.idempotentResume != null) {
                detachChild$kotlinx_coroutines_core();
                return i4;
            }
        }
        final int i7 = 0;
        CancellableContinuationImpl._decisionAndIndex$FU.set(this, i8 += i6);
        CancellableContinuationImpl._state$FU.set(this, Active.INSTANCE);
        return i3;
    }

    public void resume(T value, Function1<? super Throwable, Unit> onCancellation) {
        resumeImpl(value, this.resumeMode, onCancellation);
    }

    public void resumeUndispatched(kotlinx.coroutines.CoroutineDispatcher $this$resumeUndispatched, T value) {
        int delegate;
        int resumeMode;
        int dispatcher;
        if (delegate instanceof DispatchedContinuation) {
        } else {
            delegate = dispatcher;
        }
        if (delegate != 0) {
            dispatcher = delegate.dispatcher;
        }
        resumeMode = dispatcher == $this$resumeUndispatched ? 4 : this.resumeMode;
        CancellableContinuationImpl.resumeImpl$default(this, value, resumeMode, 0, 4, 0);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void resumeUndispatchedWithException(kotlinx.coroutines.CoroutineDispatcher $this$resumeUndispatchedWithException, Throwable exception) {
        int delegate;
        int resumeMode;
        int dispatcher;
        dispatcher = 0;
        if (delegate instanceof DispatchedContinuation) {
        } else {
            delegate = dispatcher;
        }
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(exception, 0, 2, dispatcher);
        if (delegate != 0) {
            dispatcher = delegate.dispatcher;
        }
        resumeMode = dispatcher == $this$resumeUndispatchedWithException ? 4 : this.resumeMode;
        CancellableContinuationImpl.resumeImpl$default(this, completedExceptionally, resumeMode, 0, 4, 0);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void resumeWith(Object result) {
        CancellableContinuationImpl.resumeImpl$default(this, CompletionStateKt.toState(result, (CancellableContinuation)this), this.resumeMode, 0, 4, 0);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(nameString()).append('(').append(DebugStringsKt.toDebugString(this.delegate)).append("){").append(getStateDebugRepresentation()).append("}@").append(DebugStringsKt.getHexAddress(this)).toString();
    }

    public Object tryResume(T value, Object idempotent) {
        return tryResumeImpl(value, idempotent, 0);
    }

    public Object tryResume(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        return tryResumeImpl(value, idempotent, onCancellation);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object tryResumeWithException(Throwable exception) {
        final int i3 = 0;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(exception, 0, 2, i3);
        return tryResumeImpl(completedExceptionally, i3, i3);
    }
}
