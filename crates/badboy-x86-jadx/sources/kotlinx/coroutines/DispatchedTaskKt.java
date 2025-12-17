package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u000c\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\u0008\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001dH\u0080\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0008\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\n¨\u0006\u001e", d2 = {"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DispatchedTaskKt {

    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;
    public static final <T> void dispatch(kotlinx.coroutines.DispatchedTask<? super T> $this$dispatch, int mode) {
        int aSSERTIONS_ENABLED;
        int i;
        kotlinx.coroutines.CoroutineDispatcher cancellableMode2;
        int i2;
        kotlin.coroutines.CoroutineContext cancellableMode;
        Object dispatchNeeded;
        cancellableMode2 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i3 = 0;
            aSSERTIONS_ENABLED = mode != -1 ? i : cancellableMode2;
            if (aSSERTIONS_ENABLED == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        Continuation delegate$kotlinx_coroutines_core = $this$dispatch.getDelegate$kotlinx_coroutines_core();
        if (mode == 4) {
        } else {
            i = cancellableMode2;
        }
        if (i == 0 && delegate$kotlinx_coroutines_core instanceof DispatchedContinuation && DispatchedTaskKt.isCancellableMode(mode) == DispatchedTaskKt.isCancellableMode($this$dispatch.resumeMode)) {
            if (delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) {
                if (DispatchedTaskKt.isCancellableMode(mode) == DispatchedTaskKt.isCancellableMode($this$dispatch.resumeMode)) {
                    cancellableMode2 = continuation.dispatcher;
                    cancellableMode = delegate$kotlinx_coroutines_core.getContext();
                    if (cancellableMode2.isDispatchNeeded(cancellableMode)) {
                        cancellableMode2.dispatch(cancellableMode, (Runnable)$this$dispatch);
                    } else {
                        DispatchedTaskKt.resumeUnconfined($this$dispatch);
                    }
                } else {
                    DispatchedTaskKt.resume($this$dispatch, delegate$kotlinx_coroutines_core, i);
                }
            } else {
            }
        } else {
        }
    }

    public static void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int $this$isCancellableMode) {
        int i;
        int i2;
        if ($this$isCancellableMode != 1) {
            if ($this$isCancellableMode == 2) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    public static final boolean isReusableMode(int $this$isReusableMode) {
        int i;
        i = $this$isReusableMode == 2 ? 1 : 0;
        return i;
    }

    public static final <T> void resume(kotlinx.coroutines.DispatchedTask<? super T> $this$resume, Continuation<? super T> delegate, boolean undispatched) {
        Object successfulResult$kotlinx_coroutines_core;
        Object obj;
        int i;
        Continuation continuation;
        Object countOrElement;
        int i2;
        kotlin.coroutines.CoroutineContext context;
        Object threadContext;
        int undispatchedCompletion;
        Throwable clearThreadContext2;
        boolean clearThreadContext;
        final Object takeState$kotlinx_coroutines_core = $this$resume.takeState$kotlinx_coroutines_core();
        final Throwable exceptionalResult$kotlinx_coroutines_core = $this$resume.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        kotlin.Result.Companion companion = Result.Companion;
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            successfulResult$kotlinx_coroutines_core = ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            successfulResult$kotlinx_coroutines_core = $this$resume.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object constructor-impl = Result.constructor-impl(successfulResult$kotlinx_coroutines_core);
        if (undispatched) {
            Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            obj = delegate;
            i = 0;
            continuation = obj.continuation;
            i2 = 0;
            context = continuation.getContext();
            threadContext = ThreadContextKt.updateThreadContext(context, obj.countOrElement);
            if (threadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, threadContext);
            } else {
                undispatchedCompletion = 0;
            }
            int i3 = 0;
            obj.continuation.resumeWith(constructor-impl);
            clearThreadContext2 = Unit.INSTANCE;
            if (undispatchedCompletion != 0) {
                if (undispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, threadContext);
                }
            } else {
            }
        } else {
            delegate.resumeWith(constructor-impl);
        }
    }

    private static final void resumeUnconfined(kotlinx.coroutines.DispatchedTask<?> $this$resumeUnconfined) {
        boolean unconfinedLoopActive;
        int i;
        int i2;
        Throwable unconfinedEvent;
        int delegate$kotlinx_coroutines_core;
        kotlinx.coroutines.EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined($this$resumeUnconfined);
        } else {
            unconfinedLoopActive = $this$resumeUnconfined;
            i = 0;
            i2 = 1;
            eventLoop$kotlinx_coroutines_core.incrementUseCount(i2);
            unconfinedEvent = 0;
            DispatchedTaskKt.resume($this$resumeUnconfined, $this$resumeUnconfined.getDelegate$kotlinx_coroutines_core(), i2);
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent() == 0) {
            }
            eventLoop$kotlinx_coroutines_core.decrementUseCount(i2);
        }
    }

    public static final void resumeWithStackTrace(Continuation<?> $this$resumeWithStackTrace, Throwable exception) {
        Throwable th;
        boolean rECOVER_STACK_TRACES;
        final int i = 0;
        kotlin.Result.Companion companion = Result.Companion;
        int i2 = 0;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            if (!$this$resumeWithStackTrace instanceof CoroutineStackFrame) {
                th = exception;
            } else {
                th = StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame)$this$resumeWithStackTrace);
            }
        } else {
        }
        $this$resumeWithStackTrace.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
    }

    public static final void runUnconfinedEventLoop(kotlinx.coroutines.DispatchedTask<?> $this$runUnconfinedEventLoop, kotlinx.coroutines.EventLoop eventLoop, Function0<Unit> block) {
        Throwable unconfinedEvent;
        int i;
        final int i2 = 0;
        final int i3 = 1;
        eventLoop.incrementUseCount(i3);
        block.invoke();
        while (!eventLoop.processUnconfinedEvent()) {
        }
        eventLoop.decrementUseCount(i3);
    }
}
