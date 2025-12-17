package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u000f\u0008!\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0008\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\u0008\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\u0008\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\u0008\u0001\u0010\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\u0008\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u000c2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\u0008\u001bJ\u0006\u0010\u001c\u001a\u00020\u000cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\u0008\u001eR\u0018\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008X \u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DispatchedTask<T>  extends Task {

    public int resumeMode;
    public DispatchedTask(int resumeMode) {
        super();
        this.resumeMode = resumeMode;
    }

    @Override // kotlinx.coroutines.scheduling.Task
    public void cancelCompletedResult$kotlinx_coroutines_core(Object takenState, Throwable cause) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    @Override // kotlinx.coroutines.scheduling.Task
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object state) {
        Object obj;
        int cause;
        if (state instanceof CompletedExceptionally) {
            obj = state;
        } else {
            obj = cause;
        }
        if (obj != null) {
            cause = obj.cause;
        }
        return cause;
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object state) {
        return state;
    }

    @Override // kotlinx.coroutines.scheduling.Task
    public final void handleFatalException$kotlinx_coroutines_core(Throwable exception, Throwable finallyException) {
        Throwable th2;
        Throwable th;
        int i;
        if (exception == null && finallyException == null) {
            if (finallyException == null) {
            }
        }
        if (exception != null && finallyException != null) {
            if (finallyException != null) {
                i = 0;
                ExceptionsKt.addSuppressed(exception, finallyException);
            }
        }
        th = exception == null ? finallyException : exception;
        StringBuilder stringBuilder = new StringBuilder();
        Intrinsics.checkNotNull(th);
        CoroutinesInternalError coroutinesInternalError = new CoroutinesInternalError(stringBuilder.append("Fatal exception in coroutines machinery for ").append(this).append(". Please read KDoc to 'handleFatalException' method and report this incident to maintainers").toString(), th);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), (Throwable)coroutinesInternalError);
    }

    @Override // kotlinx.coroutines.scheduling.Task
    public final void run() {
        boolean aSSERTIONS_ENABLED;
        kotlinx.coroutines.UndispatchedCoroutine undispatchedCompletion;
        Object constructor-impl2;
        Unit clearThreadContext;
        Object constructor-impl3;
        boolean companion;
        Object taskContext;
        int i4;
        Object taskContext2;
        int fatalException;
        int i3;
        Continuation delegate;
        int i5;
        boolean cancellationException;
        int i6;
        int i2;
        int i;
        boolean z;
        TaskContext taskContext3;
        Object obj5;
        Continuation continuation;
        final Object obj2 = this;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            companion = obj2.resumeMode != -1 ? 1 : 0;
            if (companion == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        taskContext = obj2.taskContext;
        i3 = 0;
        Continuation delegate$kotlinx_coroutines_core = obj2.getDelegate$kotlinx_coroutines_core();
        Intrinsics.checkNotNull(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
        delegate = delegate$kotlinx_coroutines_core;
        final Continuation continuation3 = continuation2;
        final int i8 = 0;
        final CoroutineContext context2 = context;
        final Object obj4 = threadContext;
        if (obj4 != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(continuation3, context2, obj4);
        } else {
            undispatchedCompletion = i5;
        }
        final kotlinx.coroutines.UndispatchedCoroutine undispatchedCoroutine = undispatchedCompletion;
        int i7 = 0;
        final Object takeState$kotlinx_coroutines_core = obj2.takeState$kotlinx_coroutines_core();
        final Throwable exceptionalResult$kotlinx_coroutines_core = obj2.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core == null && DispatchedTaskKt.isCancellableMode(obj2.resumeMode)) {
            if (DispatchedTaskKt.isCancellableMode(obj2.resumeMode)) {
                i5 = continuation3.getContext().get((CoroutineContext.Key)Job.Key);
            }
        }
        if (i5 != 0 && !i5.isActive()) {
            if (!i5.isActive()) {
                cancellationException = i5.getCancellationException();
                i6 = i7;
                obj2.cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, (Throwable)cancellationException);
                constructor-impl2 = continuation3;
                i2 = 0;
                kotlin.Result.Companion companion5 = Result.Companion;
                i = 0;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    taskContext3 = taskContext;
                    if (!constructor-impl2 instanceof CoroutineStackFrame) {
                        continuation = delegate;
                        taskContext2 = cancellationException;
                    } else {
                        continuation = delegate;
                        taskContext2 = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)cancellationException, (CoroutineStackFrame)constructor-impl2);
                    }
                } else {
                    taskContext3 = taskContext;
                    continuation = delegate;
                }
                constructor-impl2.resumeWith(Result.constructor-impl(ResultKt.createFailure(taskContext2)));
            } else {
                i6 = i7;
                taskContext3 = taskContext;
                continuation = delegate;
                if (exceptionalResult$kotlinx_coroutines_core != null) {
                    kotlin.Result.Companion companion3 = Result.Companion;
                    continuation3.resumeWith(Result.constructor-impl(ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    kotlin.Result.Companion companion2 = Result.Companion;
                    continuation3.resumeWith(Result.constructor-impl(obj2.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core)));
                }
            }
        } else {
        }
        clearThreadContext = Unit.INSTANCE;
        if (undispatchedCoroutine != null) {
            if (undispatchedCoroutine.clearThreadContext()) {
                try {
                    ThreadContextKt.restoreThreadContext(context2, obj4);
                    kotlin.Result.Companion companion4 = Result.Companion;
                    Object obj = obj2;
                    i4 = 0;
                    taskContext3.afterTask();
                    constructor-impl3 = Result.constructor-impl(Unit.INSTANCE);
                    obj5 = obj4;
                    companion = obj11.clearThreadContext();
                    if (obj11 != null && companion) {
                    } else {
                    }
                    companion = obj11.clearThreadContext();
                    if (!companion) {
                    } else {
                    }
                    ThreadContextKt.restoreThreadContext(obj8, obj9);
                    throw constructor-impl;
                    fatalException = constructor-impl;
                    Throwable constructor-impl = Result.Companion;
                    constructor-impl = this;
                    companion = false;
                    companion.afterTask();
                    constructor-impl = Unit.INSTANCE;
                    constructor-impl = Result.constructor-impl(constructor-impl);
                    companion = Result.Companion;
                    constructor-impl = ResultKt.createFailure(constructor-impl);
                    constructor-impl = Result.constructor-impl(constructor-impl);
                    obj2.handleFatalException$kotlinx_coroutines_core(i3, Result.exceptionOrNull-impl(constructor-impl3));
                } catch (Throwable th) {
                }
            }
        } else {
        }
    }

    @Override // kotlinx.coroutines.scheduling.Task
    public abstract Object takeState$kotlinx_coroutines_core();
}
