package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\u0008!J\u001f\u0010\"\u001a\u00020 2\u0008\u0010#\u001a\u0004\u0018\u00010\u000c2\u0006\u0010$\u001a\u00020%H\u0010¢\u0006\u0002\u0008&J\u0015\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH\u0000¢\u0006\u0002\u0008(J\u001f\u0010)\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00028\u0000H\u0000¢\u0006\u0004\u0008+\u0010,J\u0010\u0010-\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/H\u0016J\r\u00100\u001a\u000201H\u0000¢\u0006\u0002\u00082J\u0015\u00103\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\u00084J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\u00086JH\u00107\u001a\u00020 2\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00028\u0000092%\u0008\u0008\u0010:\u001a\u001f\u0012\u0013\u0012\u00110%¢\u0006\u000c\u0008<\u0012\u0008\u0008=\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020 \u0018\u00010;H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u0018\u0010@\u001a\u0002012\u0008\u0010A\u001a\u0004\u0018\u00010\u000cH\u0080\u0008¢\u0006\u0002\u0008BJ!\u0010C\u001a\u00020 2\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00028\u000009H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u001e\u0010F\u001a\u00020 2\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00028\u000009H\u0016ø\u0001\u0000¢\u0006\u0002\u0010EJ\u000f\u0010G\u001a\u0004\u0018\u00010\u000cH\u0010¢\u0006\u0002\u0008HJ\u0008\u0010I\u001a\u00020JH\u0016J\u001b\u0010K\u001a\u0004\u0018\u00010%2\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030LH\u0000¢\u0006\u0002\u0008MR\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bX\u0082\u0004R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u000c8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006N", d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_reusableCancellableContinuation", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "reusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "awaitReusability", "", "awaitReusability$kotlinx_coroutines_core", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "claimReusableCancellableContinuation", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "dispatchYield", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "isReusable", "", "isReusable$kotlinx_coroutines_core", "postponeCancellation", "postponeCancellation$kotlinx_coroutines_core", "release", "release$kotlinx_coroutines_core", "resumeCancellableWith", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resumeCancellableWith$kotlinx_coroutines_core", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeCancelled", "state", "resumeCancelled$kotlinx_coroutines_core", "resumeUndispatchedWith", "resumeUndispatchedWith$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeWith", "takeState", "takeState$kotlinx_coroutines_core", "toString", "", "tryReleaseClaimedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DispatchedContinuation<T>  extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU;
    @Volatile
    private volatile Object _reusableCancellableContinuation;
    public Object _state;
    public final Continuation<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;
    static {
        DispatchedContinuation._reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    }

    public DispatchedContinuation(CoroutineDispatcher dispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = dispatcher;
        this.continuation = continuation;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(getContext());
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object obj;
        if (obj instanceof CancellableContinuationImpl) {
        } else {
            obj = 0;
        }
        return obj;
    }

    public static void get_state$kotlinx_coroutines_core$annotations() {
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void awaitReusability$kotlinx_coroutines_core() {
        Object obj;
        int i;
        kotlinx.coroutines.internal.Symbol rEUSABLE_CLAIMED;
        final Object obj2 = this;
        final int i2 = 0;
        i = 0;
        while (DispatchedContinuation._reusableCancellableContinuation$FU.get(this) != DispatchedContinuationKt.REUSABLE_CLAIMED) {
            i = 0;
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object takenState, Throwable cause) {
        boolean onCancellation;
        if (takenState instanceof CompletedWithCancellation) {
            obj.onCancellation.invoke(cause);
        }
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        Object obj;
        int i;
        kotlinx.coroutines.internal.Symbol rEUSABLE_CLAIMED2;
        kotlinx.coroutines.internal.Symbol rEUSABLE_CLAIMED;
        final Object obj2 = this;
        final int i2 = 0;
        obj = DispatchedContinuation._reusableCancellableContinuation$FU.get(this);
        i = 0;
        while (obj == null) {
            obj = _reusableCancellableContinuation$FU.get(this);
            i = 0;
        }
        DispatchedContinuation._reusableCancellableContinuation$FU.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
        return 0;
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, (Runnable)this);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation;
        if (continuation instanceof CoroutineStackFrame) {
        } else {
            continuation = 0;
        }
        return continuation;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return (Continuation)this;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final boolean isReusable$kotlinx_coroutines_core() {
        int i;
        i = DispatchedContinuation._reusableCancellableContinuation$FU.get(this) != null ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final boolean postponeCancellation$kotlinx_coroutines_core(Throwable cause) {
        Object obj;
        int i2;
        boolean z;
        int i;
        kotlinx.coroutines.internal.Symbol rEUSABLE_CLAIMED;
        final Object obj2 = this;
        final int i3 = 0;
        obj = DispatchedContinuation._reusableCancellableContinuation$FU.get(this);
        i2 = 0;
        i = 1;
        while (Intrinsics.areEqual(obj, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
            obj = _reusableCancellableContinuation$FU.get(this);
            i2 = 0;
            i = 1;
        }
        return i;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void release$kotlinx_coroutines_core() {
        awaitReusability$kotlinx_coroutines_core();
        final CancellableContinuationImpl reusableCancellableContinuation = getReusableCancellableContinuation();
        if (reusableCancellableContinuation != null) {
            reusableCancellableContinuation.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void resumeCancellableWith$kotlinx_coroutines_core(Object result, Function1<? super Throwable, Unit> onCancellation) {
        boolean aSSERTIONS_ENABLED;
        int this_$iv;
        int undispatchedCompletion;
        Object obj4;
        Object $i$f$resumeCancellableWith$kotlinx_coroutines_core;
        Object state2;
        Object state;
        int context;
        Object obj6;
        Object obj5;
        int i4;
        int i6;
        EventLoop eventLoop$kotlinx_coroutines_core;
        Object obj7;
        int i5;
        int i7;
        int i3;
        Object countOrElement;
        Object cancellationException;
        kotlinx.coroutines.Job.Key key;
        Object failure;
        int i;
        Object obj;
        int i2;
        boolean clearThreadContext;
        Object obj3;
        Object obj2;
        obj4 = this;
        $i$f$resumeCancellableWith$kotlinx_coroutines_core = 0;
        Object state3 = CompletionStateKt.toState(result, onCancellation);
        context = 1;
        if (obj4.dispatcher.isDispatchNeeded(obj4.getContext())) {
            obj4._state = state3;
            obj4.resumeMode = context;
            obj4.dispatcher.dispatch(obj4.getContext(), (Runnable)obj4);
            i2 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
            obj2 = state3;
            state = result;
        } else {
            obj5 = this;
            i4 = 0;
            i6 = 0;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
            }
            eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                obj5._state = state3;
                obj5.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined((DispatchedTask)obj5);
                i2 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
                obj2 = state3;
                state = result;
            } else {
                obj7 = obj5;
                i5 = 0;
                eventLoop$kotlinx_coroutines_core.incrementUseCount(context);
                i7 = 0;
                Object obj8 = this;
                i3 = 0;
                countOrElement = obj8.getContext().get((CoroutineContext.Key)Job.Key);
                if (countOrElement != null && !(Job)countOrElement.isActive()) {
                    if (!countOrElement.isActive()) {
                        cancellationException = countOrElement.getCancellationException();
                        obj8.cancelCompletedResult$kotlinx_coroutines_core(state3, (Throwable)cancellationException);
                        kotlin.Result.Companion companion = Result.Companion;
                        i = obj8;
                        (Continuation)obj8.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)cancellationException)));
                        this_$iv = 1;
                    } else {
                        i = obj8;
                        this_$iv = 0;
                    }
                } else {
                }
                if (this_$iv == 0) {
                    context = this;
                    i3 = 0;
                    cancellationException = continuation;
                    failure = 0;
                    obj4 = context5;
                    i2 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
                    $i$f$resumeCancellableWith$kotlinx_coroutines_core = obj9;
                    if ($i$f$resumeCancellableWith$kotlinx_coroutines_core != ThreadContextKt.NO_THREAD_ELEMENTS) {
                        undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(cancellationException, obj4, $i$f$resumeCancellableWith$kotlinx_coroutines_core);
                    } else {
                        undispatchedCompletion = 0;
                    }
                    i = undispatchedCompletion;
                    clearThreadContext = i8;
                    obj2 = state3;
                    context.continuation.resumeWith(result);
                    this_$iv = Unit.INSTANCE;
                    if (i != 0) {
                        if (i.clearThreadContext()) {
                            ThreadContextKt.restoreThreadContext(obj4, $i$f$resumeCancellableWith$kotlinx_coroutines_core);
                        }
                    } else {
                    }
                } else {
                    i2 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
                    obj2 = state3;
                    state = result;
                }
                while (!eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final boolean resumeCancelled$kotlinx_coroutines_core(Object state) {
        kotlinx.coroutines.Job.Key active;
        final int i = 0;
        kotlin.coroutines.CoroutineContext.Element context2 = getContext().get((CoroutineContext.Key)Job.Key);
        if (context2 != null && !(Job)context2.isActive()) {
            if (!context2.isActive()) {
                java.util.concurrent.CancellationException cancellationException = context2.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(state, (Throwable)cancellationException);
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)this.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)cancellationException)));
                return 1;
            }
        }
        return 0;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void resumeUndispatchedWith$kotlinx_coroutines_core(Object result) {
        UndispatchedCoroutine undispatchedCompletion;
        Throwable th;
        Unit $i$a$WithContinuationContextDispatchedContinuation$resumeUndispatchedWith$1;
        boolean clearThreadContext;
        final int i = 0;
        final Continuation continuation = this.continuation;
        final int i2 = 0;
        final CoroutineContext context = continuation.getContext();
        final Object threadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
        if (threadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, threadContext);
        } else {
            undispatchedCompletion = 0;
        }
        int i3 = 0;
        this.continuation.resumeWith(result);
        $i$a$WithContinuationContextDispatchedContinuation$resumeUndispatchedWith$1 = Unit.INSTANCE;
        if (undispatchedCompletion != null) {
            if (undispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, threadContext);
            }
        } else {
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void resumeWith(Object result) {
        boolean aSSERTIONS_ENABLED;
        Unit $i$a$WithCoroutineContextDispatchedContinuation$resumeWith$1$1;
        CoroutineContext context;
        int i4;
        Object i3;
        Object obj2;
        int i;
        int i5;
        int i2;
        EventLoop eventLoop$kotlinx_coroutines_core;
        Object obj;
        int i7;
        int i6;
        Object countOrElement;
        Object obj3;
        int i8;
        final Object obj4 = this;
        final Object obj5 = result;
        final CoroutineContext context3 = obj4.continuation.getContext();
        i4 = 0;
        i3 = 1;
        final Object state$default = CompletionStateKt.toState$default(obj5, i4, i3, i4);
        if (obj4.dispatcher.isDispatchNeeded(context3)) {
            obj4._state = state$default;
            obj4.resumeMode = 0;
            obj4.dispatcher.dispatch(context3, (Runnable)obj4);
        } else {
            obj2 = this;
            i5 = 0;
            i2 = 0;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
            }
            eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                obj2._state = state$default;
                obj2.resumeMode = 0;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined((DispatchedTask)obj2);
            } else {
                obj = obj2;
                i7 = 0;
                eventLoop$kotlinx_coroutines_core.incrementUseCount(i3);
                i6 = 0;
                i8 = 0;
                context = context5;
                int i10 = 0;
                obj4.continuation.resumeWith(obj5);
                $i$a$WithCoroutineContextDispatchedContinuation$resumeWith$1$1 = Unit.INSTANCE;
                ThreadContextKt.restoreThreadContext(context, ThreadContextKt.updateThreadContext(context, obj4.countOrElement));
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent() == null) {
                }
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        boolean aSSERTIONS_ENABLED;
        int i;
        final Object _state = this._state;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = _state != DispatchedContinuationKt.access$getUNDEFINED$p() ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return _state;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DispatchedContinuation[").append(this.dispatcher).append(", ").append(DebugStringsKt.toDebugString(this.continuation)).append(']').toString();
    }

    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(CancellableContinuation<?> continuation) {
        Object obj;
        int i;
        boolean z;
        int i2;
        kotlinx.coroutines.internal.Symbol rEUSABLE_CLAIMED;
        final Object obj2 = this;
        final int i3 = 0;
        obj = DispatchedContinuation._reusableCancellableContinuation$FU.get(this);
        i = 0;
        i2 = 0;
        while (obj == DispatchedContinuationKt.REUSABLE_CLAIMED) {
            obj = _reusableCancellableContinuation$FU.get(this);
            i = 0;
            i2 = 0;
        }
        if (!obj instanceof Throwable) {
        } else {
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(DispatchedContinuation._reusableCancellableContinuation$FU, this, obj, i2)) {
            } else {
                return (Throwable)obj;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Inconsistent state ").append(obj).toString().toString());
        throw illegalStateException;
    }
}
