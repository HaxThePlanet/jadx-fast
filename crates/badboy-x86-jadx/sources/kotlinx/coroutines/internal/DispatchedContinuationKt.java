package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a;\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\u0008\u00030\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00042\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cH\u0082\u0008\u001aU\u0010\u000e\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000f*\u0008\u0012\u0004\u0012\u0002H\u000f0\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u00122%\u0008\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\u0008\u0012\u0004\u0012\u00020\r0\u0005H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DispatchedContinuationKt {

    public static final kotlinx.coroutines.internal.Symbol REUSABLE_CLAIMED;
    private static final kotlinx.coroutines.internal.Symbol UNDEFINED;
    static {
        Symbol symbol = new Symbol("UNDEFINED");
        DispatchedContinuationKt.UNDEFINED = symbol;
        Symbol symbol2 = new Symbol("REUSABLE_CLAIMED");
        DispatchedContinuationKt.REUSABLE_CLAIMED = symbol2;
    }

    public static final kotlinx.coroutines.internal.Symbol access$getUNDEFINED$p() {
        return DispatchedContinuationKt.UNDEFINED;
    }

    private static final boolean executeUnconfined(kotlinx.coroutines.internal.DispatchedContinuation<?> $this$executeUnconfined, Object contState, int mode, boolean doYield, Function0<Unit> block) {
        int $i$a$AssertDispatchedContinuationKt$executeUnconfined$1;
        int i3;
        int unconfinedQueueEmpty;
        boolean unconfinedLoopActive;
        int i;
        Throwable unconfinedEvent;
        int i2;
        final int i4 = 0;
        i3 = 0;
        final int i6 = 1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i5 = 0;
            $i$a$AssertDispatchedContinuationKt$executeUnconfined$1 = mode != -1 ? i6 : i3;
            if ($i$a$AssertDispatchedContinuationKt$executeUnconfined$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
                return i3;
            }
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            $this$executeUnconfined._state = contState;
            $this$executeUnconfined.resumeMode = mode;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined((DispatchedTask)$this$executeUnconfined);
            i3 = i6;
        } else {
            unconfinedLoopActive = $this$executeUnconfined;
            i = 0;
            eventLoop$kotlinx_coroutines_core.incrementUseCount(i6);
            block.invoke();
            while (!eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
            eventLoop$kotlinx_coroutines_core.decrementUseCount(i6);
        }
        return i3;
    }

    static boolean executeUnconfined$default(kotlinx.coroutines.internal.DispatchedContinuation $this$executeUnconfined_u24default, Object contState, int mode, boolean doYield, Function0 block, int i6, Object object7) {
        int i;
        int unconfinedQueueEmpty;
        Object unconfinedLoopActive;
        int i3;
        Throwable unconfinedEvent;
        int i2;
        int obj9;
        int obj12;
        if (i6 &= 4 != 0) {
            obj9 = 0;
        }
        int obj11 = 0;
        i = 0;
        final int i4 = 1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            obj12 = 0;
            obj12 = mode != -1 ? i4 : i;
            if (obj12 == null) {
            } else {
            }
            obj12 = new AssertionError();
            throw obj12;
        }
        obj12 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (obj9 != null && obj12.isUnconfinedQueueEmpty()) {
            if (obj12.isUnconfinedQueueEmpty()) {
                return i;
            }
        }
        if (obj12.isUnconfinedLoopActive()) {
            $this$executeUnconfined_u24default._state = contState;
            $this$executeUnconfined_u24default.resumeMode = mode;
            obj12.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default);
            i = i4;
        } else {
            unconfinedLoopActive = $this$executeUnconfined_u24default;
            i3 = 0;
            obj12.incrementUseCount(i4);
            block.invoke();
            while (!obj12.processUnconfinedEvent()) {
            }
            obj12.decrementUseCount(i4);
        }
        return i;
    }

    public static final <T> void resumeCancellableWith(Continuation<? super T> $this$resumeCancellableWith, Object result, Function1<? super Throwable, Unit> onCancellation) {
        boolean aSSERTIONS_ENABLED;
        Object this_$iv$iv2;
        UndispatchedCoroutine undispatchedCompletion;
        Object obj3;
        Object this_$iv$iv;
        Object obj4;
        Object this_$iv;
        int $i$f$resumeCancellableWith$kotlinx_coroutines_core;
        Object state;
        int context2;
        Object obj5;
        int i5;
        int i2;
        int i3;
        EventLoop eventLoop$kotlinx_coroutines_core;
        Object obj;
        int i4;
        int i;
        int countOrElement;
        Object cancellationException;
        kotlinx.coroutines.Job.Key failure;
        Object obj6;
        CoroutineContext context;
        Object obj7;
        boolean clearThreadContext;
        Object obj2;
        obj4 = $this$resumeCancellableWith;
        if (obj4 instanceof DispatchedContinuation) {
            this_$iv = obj4;
            $i$f$resumeCancellableWith$kotlinx_coroutines_core = 0;
            state = CompletionStateKt.toState(result, onCancellation);
            context2 = 1;
            if (this_$iv.dispatcher.isDispatchNeeded((DispatchedContinuation)this_$iv.getContext())) {
                this_$iv._state = state;
                this_$iv.resumeMode = context2;
                this_$iv.dispatcher.dispatch(this_$iv.getContext(), (Runnable)this_$iv);
                this_$iv$iv = result;
                context = this_$iv;
                obj7 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
            } else {
                obj5 = this_$iv;
                i2 = 0;
                i3 = 0;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                }
                eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                    obj5._state = state;
                    obj5.resumeMode = 1;
                    eventLoop$kotlinx_coroutines_core.dispatchUnconfined((DispatchedTask)obj5);
                    this_$iv$iv = result;
                    context = this_$iv;
                    obj7 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
                } else {
                    obj = obj5;
                    i4 = 0;
                    eventLoop$kotlinx_coroutines_core.incrementUseCount(context2);
                    i = 0;
                    Object obj8 = this_$iv;
                    countOrElement = 0;
                    context2 = obj8.getContext().get((CoroutineContext.Key)Job.Key);
                    if (context2 != null && !(Job)context2.isActive()) {
                        if (!context2.isActive()) {
                            cancellationException = context2.getCancellationException();
                            obj8.cancelCompletedResult$kotlinx_coroutines_core(state, (Throwable)cancellationException);
                            kotlin.Result.Companion companion = Result.Companion;
                            obj6 = obj8;
                            (Continuation)obj8.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)cancellationException)));
                            this_$iv$iv2 = 1;
                        } else {
                            obj6 = obj8;
                            this_$iv$iv2 = 0;
                        }
                    } else {
                    }
                    if (this_$iv$iv2 == 0) {
                        Object obj9 = this_$iv;
                        context2 = 0;
                        cancellationException = continuation;
                        failure = 0;
                        context = this_$iv;
                        this_$iv = context5;
                        obj7 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
                        $i$f$resumeCancellableWith$kotlinx_coroutines_core = obj10;
                        if ($i$f$resumeCancellableWith$kotlinx_coroutines_core != ThreadContextKt.NO_THREAD_ELEMENTS) {
                            undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(cancellationException, this_$iv, $i$f$resumeCancellableWith$kotlinx_coroutines_core);
                        } else {
                            undispatchedCompletion = 0;
                        }
                        obj6 = undispatchedCompletion;
                        clearThreadContext = i7;
                        obj2 = obj9;
                        obj9.continuation.resumeWith(result);
                        this_$iv$iv2 = Unit.INSTANCE;
                        if (obj6 != null) {
                            if (obj6.clearThreadContext()) {
                                ThreadContextKt.restoreThreadContext(this_$iv, $i$f$resumeCancellableWith$kotlinx_coroutines_core);
                            }
                        } else {
                        }
                    } else {
                        this_$iv$iv = result;
                        context = this_$iv;
                        obj7 = $i$f$resumeCancellableWith$kotlinx_coroutines_core;
                    }
                    while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent() == 0) {
                    }
                    eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                }
            }
        } else {
            this_$iv$iv = result;
            $this$resumeCancellableWith.resumeWith(result);
        }
    }

    public static void resumeCancellableWith$default(Continuation continuation, Object object2, Function1 function13, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        DispatchedContinuationKt.resumeCancellableWith(continuation, object2, obj2);
    }

    public static final boolean yieldUndispatched(kotlinx.coroutines.internal.DispatchedContinuation<? super Unit> $this$yieldUndispatched) {
        boolean aSSERTIONS_ENABLED;
        boolean unconfinedQueueEmpty;
        int i3;
        int i4;
        int i;
        Throwable unconfinedEvent;
        int i2;
        final int i6 = 1;
        final Object obj = $this$yieldUndispatched;
        final int i7 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        i3 = 0;
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
        } else {
            i4 = 1;
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                obj._state = Unit.INSTANCE;
                obj.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined((DispatchedTask)obj);
                i3 = i4;
            } else {
                unconfinedQueueEmpty = obj;
                i = 0;
                eventLoop$kotlinx_coroutines_core.incrementUseCount(i4);
                unconfinedEvent = 0;
                $this$yieldUndispatched.run();
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent() == 0) {
                }
                eventLoop$kotlinx_coroutines_core.decrementUseCount(i4);
            }
        }
        return i3;
    }
}
