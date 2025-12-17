package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a0\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u0007\u001a(\u0010\u0008\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\t\u001a(\u0010\n\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\t\u001a(\u0010\u000b\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\t\u001a0\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u000c2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\r\u001a(\u0010\u0008\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u000c2\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000e\u001a(\u0010\n\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u000c2\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000e\u001a(\u0010\u000b\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u000c2\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u000f\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0008\u0004\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0081H¢\u0006\u0002\u0010\u0007\u001a>\u0010\u0010\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0081@¢\u0006\u0002\u0010\u0015¨\u0006\u0016", d2 = {"withStateAtLeast", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "suspendWithStateAtLeastUnchecked", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WithLifecycleStateKt {
    public static final <R> Object suspendWithStateAtLeastUnchecked(androidx.lifecycle.Lifecycle $this$suspendWithStateAtLeastUnchecked, androidx.lifecycle.Lifecycle.State state, boolean dispatchNeeded, CoroutineDispatcher lifecycleDispatcher, Function0<? extends R> block, Continuation<? super R> $completion) {
        Object iNSTANCE;
        androidx.lifecycle.WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.1 anon;
        final int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i4 = 0;
        WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.observer.1 anon2 = new WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.observer.1(state, $this$suspendWithStateAtLeastUnchecked, (CancellableContinuation)cancellableContinuationImpl2, block);
        if (dispatchNeeded) {
            anon = new WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.1($this$suspendWithStateAtLeastUnchecked, anon2);
            lifecycleDispatcher.dispatch((CoroutineContext)EmptyCoroutineContext.INSTANCE, (Runnable)anon);
        } else {
            $this$suspendWithStateAtLeastUnchecked.addObserver((LifecycleObserver)anon2);
        }
        WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.2 anon3 = new WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.2(lifecycleDispatcher, $this$suspendWithStateAtLeastUnchecked, anon2);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)anon3);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }

    public static final <R> Object withCreated(androidx.lifecycle.Lifecycle $this$withCreated, Function0<? extends R> block, Continuation<? super R> $completion) {
        int compareTo;
        Object suspendWithStateAtLeastUnchecked;
        androidx.lifecycle.Lifecycle.State anon;
        Continuation continuation;
        final int i = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withCreated;
        final androidx.lifecycle.Lifecycle.State state = cREATED;
        int state$iv = 0;
        final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if (lifecycle.getCurrentState().compareTo((Enum)state) >= 0) {
                    suspendWithStateAtLeastUnchecked = block.invoke();
                    continuation = $completion;
                } else {
                }
                return suspendWithStateAtLeastUnchecked;
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        suspendWithStateAtLeastUnchecked = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, state, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    public static final <R> Object withCreated(androidx.lifecycle.LifecycleOwner $this$withCreated, Function0<? extends R> block, Continuation<? super R> $completion) {
        int compareTo;
        Object suspendWithStateAtLeastUnchecked;
        androidx.lifecycle.Lifecycle.State anon;
        Continuation continuation;
        final int i = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withCreated.getLifecycle();
        final androidx.lifecycle.Lifecycle.State cREATED = Lifecycle.State.CREATED;
        final int i2 = 0;
        final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if (lifecycle.getCurrentState().compareTo((Enum)cREATED) >= 0) {
                    suspendWithStateAtLeastUnchecked = block.invoke();
                    continuation = $completion;
                } else {
                }
                return suspendWithStateAtLeastUnchecked;
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        suspendWithStateAtLeastUnchecked = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, cREATED, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    private static final <R> Object withCreated$$forInline(androidx.lifecycle.Lifecycle $this$withCreated, Function0<? extends R> block, Continuation<? super R> $completion) {
        androidx.lifecycle.Lifecycle.State obj0 = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    private static final <R> Object withCreated$$forInline(androidx.lifecycle.LifecycleOwner $this$withCreated, Function0<? extends R> block, Continuation<? super R> $completion) {
        $this$withCreated.getLifecycle();
        androidx.lifecycle.Lifecycle.State obj0 = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    public static final <R> Object withResumed(androidx.lifecycle.Lifecycle $this$withResumed, Function0<? extends R> block, Continuation<? super R> $completion) {
        int compareTo;
        Object suspendWithStateAtLeastUnchecked;
        androidx.lifecycle.Lifecycle.State anon;
        Continuation continuation;
        final int i = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withResumed;
        final androidx.lifecycle.Lifecycle.State state = rESUMED;
        int state$iv = 0;
        final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if (lifecycle.getCurrentState().compareTo((Enum)state) >= 0) {
                    suspendWithStateAtLeastUnchecked = block.invoke();
                    continuation = $completion;
                } else {
                }
                return suspendWithStateAtLeastUnchecked;
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        suspendWithStateAtLeastUnchecked = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, state, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    public static final <R> Object withResumed(androidx.lifecycle.LifecycleOwner $this$withResumed, Function0<? extends R> block, Continuation<? super R> $completion) {
        int compareTo;
        Object suspendWithStateAtLeastUnchecked;
        androidx.lifecycle.Lifecycle.State anon;
        Continuation continuation;
        final int i = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withResumed.getLifecycle();
        final androidx.lifecycle.Lifecycle.State rESUMED = Lifecycle.State.RESUMED;
        final int i2 = 0;
        final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if (lifecycle.getCurrentState().compareTo((Enum)rESUMED) >= 0) {
                    suspendWithStateAtLeastUnchecked = block.invoke();
                    continuation = $completion;
                } else {
                }
                return suspendWithStateAtLeastUnchecked;
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        suspendWithStateAtLeastUnchecked = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, rESUMED, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    private static final <R> Object withResumed$$forInline(androidx.lifecycle.Lifecycle $this$withResumed, Function0<? extends R> block, Continuation<? super R> $completion) {
        androidx.lifecycle.Lifecycle.State obj0 = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    private static final <R> Object withResumed$$forInline(androidx.lifecycle.LifecycleOwner $this$withResumed, Function0<? extends R> block, Continuation<? super R> $completion) {
        $this$withResumed.getLifecycle();
        androidx.lifecycle.Lifecycle.State obj0 = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    public static final <R> Object withStarted(androidx.lifecycle.Lifecycle $this$withStarted, Function0<? extends R> block, Continuation<? super R> $completion) {
        int compareTo;
        Object suspendWithStateAtLeastUnchecked;
        androidx.lifecycle.Lifecycle.State anon;
        Continuation continuation;
        final int i = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withStarted;
        final androidx.lifecycle.Lifecycle.State state = sTARTED;
        int state$iv = 0;
        final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if (lifecycle.getCurrentState().compareTo((Enum)state) >= 0) {
                    suspendWithStateAtLeastUnchecked = block.invoke();
                    continuation = $completion;
                } else {
                }
                return suspendWithStateAtLeastUnchecked;
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        suspendWithStateAtLeastUnchecked = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, state, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    public static final <R> Object withStarted(androidx.lifecycle.LifecycleOwner $this$withStarted, Function0<? extends R> block, Continuation<? super R> $completion) {
        int compareTo;
        Object suspendWithStateAtLeastUnchecked;
        androidx.lifecycle.Lifecycle.State anon;
        Continuation continuation;
        final int i = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withStarted.getLifecycle();
        final androidx.lifecycle.Lifecycle.State sTARTED = Lifecycle.State.STARTED;
        final int i2 = 0;
        final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if (lifecycle.getCurrentState().compareTo((Enum)sTARTED) >= 0) {
                    suspendWithStateAtLeastUnchecked = block.invoke();
                    continuation = $completion;
                } else {
                }
                return suspendWithStateAtLeastUnchecked;
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        suspendWithStateAtLeastUnchecked = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, sTARTED, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    private static final <R> Object withStarted$$forInline(androidx.lifecycle.Lifecycle $this$withStarted, Function0<? extends R> block, Continuation<? super R> $completion) {
        androidx.lifecycle.Lifecycle.State obj0 = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    private static final <R> Object withStarted$$forInline(androidx.lifecycle.LifecycleOwner $this$withStarted, Function0<? extends R> block, Continuation<? super R> $completion) {
        $this$withStarted.getLifecycle();
        androidx.lifecycle.Lifecycle.State obj0 = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    public static final <R> Object withStateAtLeast(androidx.lifecycle.Lifecycle $this$withStateAtLeast, androidx.lifecycle.Lifecycle.State state, Function0<? extends R> block, Continuation<? super R> $completion) {
        int i;
        androidx.lifecycle.Lifecycle.State state2;
        kotlin.coroutines.CoroutineContext compareTo;
        Object obj;
        androidx.lifecycle.WithLifecycleStateKt.withStateAtLeastUnchecked.2 anon;
        Continuation continuation;
        Object obj10;
        final int i2 = 0;
        i = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            final androidx.lifecycle.Lifecycle lifecycle = $this$withStateAtLeast;
            int i3 = 0;
            final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            final boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
            if (!dispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                } else {
                    if (lifecycle.getCurrentState().compareTo((Enum)state) >= 0) {
                        state2 = state;
                        obj10 = obj2;
                        continuation = $completion;
                    } else {
                    }
                    return obj10;
                }
                LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                throw lifecycleDestroyedException;
            }
            WithLifecycleStateKt.withStateAtLeastUnchecked.2 anon2 = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
            obj10 = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, state, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon2, $completion);
        }
        Continuation continuation2 = $completion;
        obj10 = 0;
        StringBuilder obj12 = new StringBuilder();
        obj12 = new IllegalArgumentException(obj12.append("target state must be CREATED or greater, found ").append(state).toString().toString());
        throw obj12;
    }

    public static final <R> Object withStateAtLeast(androidx.lifecycle.LifecycleOwner $this$withStateAtLeast, androidx.lifecycle.Lifecycle.State state, Function0<? extends R> block, Continuation<? super R> $completion) {
        int i;
        androidx.lifecycle.Lifecycle.State state2;
        kotlin.coroutines.CoroutineContext compareTo;
        Object obj;
        androidx.lifecycle.WithLifecycleStateKt.withStateAtLeastUnchecked.2 anon;
        Continuation continuation;
        Object obj12;
        final int i2 = 0;
        final int i3 = 0;
        i = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            final androidx.lifecycle.Lifecycle lifecycle2 = lifecycle;
            int i4 = 0;
            final MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            final boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
            if (!dispatchNeeded) {
                if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
                } else {
                    if (lifecycle2.getCurrentState().compareTo((Enum)state) >= 0) {
                        state2 = state;
                        obj12 = obj2;
                        continuation = $completion;
                    } else {
                    }
                    return obj12;
                }
                LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                throw lifecycleDestroyedException;
            }
            WithLifecycleStateKt.withStateAtLeastUnchecked.2 anon2 = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
            obj12 = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle2, state, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon2, $completion);
        }
        Continuation continuation2 = $completion;
        obj12 = 0;
        StringBuilder obj14 = new StringBuilder();
        obj14 = new IllegalArgumentException(obj14.append("target state must be CREATED or greater, found ").append(state).toString().toString());
        throw obj14;
    }

    private static final <R> Object withStateAtLeast$$forInline(androidx.lifecycle.Lifecycle $this$withStateAtLeast, androidx.lifecycle.Lifecycle.State state, Function0<? extends R> block, Continuation<? super R> $completion) {
        int i;
        final int i2 = 0;
        i = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0 ? 1 : 0;
        if (i == 0) {
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException $i$a$RequireWithLifecycleStateKt$withStateAtLeast$2 = new IllegalArgumentException(stringBuilder.append("target state must be CREATED or greater, found ").append(state).toString().toString());
            throw $i$a$RequireWithLifecycleStateKt$withStateAtLeast$2;
        }
        Dispatchers.getMain().getImmediate();
        int obj4 = 0;
        obj4.getContext();
        throw obj4;
    }

    private static final <R> Object withStateAtLeast$$forInline(androidx.lifecycle.LifecycleOwner $this$withStateAtLeast, androidx.lifecycle.Lifecycle.State state, Function0<? extends R> block, Continuation<? super R> $completion) {
        int i;
        final int i2 = 0;
        final androidx.lifecycle.Lifecycle lifecycle = $this$withStateAtLeast.getLifecycle();
        final int i3 = 0;
        i = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0 ? 1 : 0;
        if (i == 0) {
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException $i$a$RequireWithLifecycleStateKt$withStateAtLeast$2$iv = new IllegalArgumentException(stringBuilder.append("target state must be CREATED or greater, found ").append(state).toString().toString());
            throw $i$a$RequireWithLifecycleStateKt$withStateAtLeast$2$iv;
        }
        Dispatchers.getMain().getImmediate();
        int obj6 = 0;
        obj6.getContext();
        throw obj6;
    }

    public static final <R> Object withStateAtLeastUnchecked(androidx.lifecycle.Lifecycle $this$withStateAtLeastUnchecked, androidx.lifecycle.Lifecycle.State state, Function0<? extends R> block, Continuation<? super R> $completion) {
        kotlin.coroutines.CoroutineContext compareTo;
        Enum obj;
        final int i = 0;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        final boolean dispatchNeeded = immediate.isDispatchNeeded($completion.getContext());
        if (!dispatchNeeded) {
            if ($this$withStateAtLeastUnchecked.getCurrentState() == Lifecycle.State.DESTROYED) {
            } else {
                if ($this$withStateAtLeastUnchecked.getCurrentState().compareTo((Enum)state) >= 0) {
                    return block.invoke();
                }
            }
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            throw lifecycleDestroyedException;
        }
        WithLifecycleStateKt.withStateAtLeastUnchecked.2 anon = new WithLifecycleStateKt.withStateAtLeastUnchecked.2(block);
        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked($this$withStateAtLeastUnchecked, state, dispatchNeeded, (CoroutineDispatcher)immediate, (Function0)anon, $completion);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(androidx.lifecycle.Lifecycle $this$withStateAtLeastUnchecked, androidx.lifecycle.Lifecycle.State state, Function0<? extends R> block, Continuation<? super R> $completion) {
        Dispatchers.getMain().getImmediate();
        int obj0 = 0;
        obj0.getContext();
        throw obj0;
    }
}
