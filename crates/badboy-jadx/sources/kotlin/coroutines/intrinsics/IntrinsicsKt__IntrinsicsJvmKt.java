package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aF\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\u0008\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\u0008¢\u0006\u0002\u0008\u0008\u001a'\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0002¢\u0006\u0002\u0008\n\u001aA\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u0003*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007¢\u0006\u0002\u0010\u000c\u001aZ\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u0003*#\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e¢\u0006\u0002\u0008\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0003*\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001a>\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0003*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0008¢\u0006\u0002\u0010\u0014\u001aW\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u0003*#\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e¢\u0006\u0002\u0008\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0008¢\u0006\u0002\u0010\u0015\u001ak\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u0016\"\u0004\u0008\u0002\u0010\u0003*)\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017¢\u0006\u0002\u0008\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u0006\u0010\u0018\u001a\u0002H\u00162\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\u0008¢\u0006\u0002\u0010\u0019\u001a=\u0010\u001a\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0003*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0001¢\u0006\u0002\u0010\u0014\u001aV\u0010\u001a\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u0003*#\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e¢\u0006\u0002\u0008\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0001¢\u0006\u0002\u0010\u0015\u001aj\u0010\u001a\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u0016\"\u0004\u0008\u0002\u0010\u0003*)\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017¢\u0006\u0002\u0008\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u0006\u0010\u0018\u001a\u0002H\u00162\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001b", d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createSimpleCoroutineForSuspendFunction", "createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapWithContinuationImpl", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsJvmKt {
    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> completion, Function1<? super Continuation<? super T>, ? extends Object> block) {
        BaseContinuationImpl anon;
        final int i = 0;
        final kotlin.coroutines.CoroutineContext context = completion.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            anon = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineFromSuspendFunction.1(completion, block);
        } else {
            anon = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineFromSuspendFunction.2(completion, context, block);
        }
        return anon;
    }

    public static final <T> Continuation<Unit> createCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> $this$createCoroutineUnintercepted, Continuation<? super T> completion) {
        Continuation $i$f$createCoroutineFromSuspendFunction;
        kotlin.coroutines.CoroutineContext context;
        BaseContinuationImpl anon;
        Intrinsics.checkNotNullParameter($this$createCoroutineUnintercepted, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if ($this$createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            $i$f$createCoroutineFromSuspendFunction = (BaseContinuationImpl)$this$createCoroutineUnintercepted.create(probeCoroutineCreated);
        } else {
            int i = 0;
            context = probeCoroutineCreated.getContext();
            if (context == EmptyCoroutineContext.INSTANCE) {
                anon = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$$inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.1(probeCoroutineCreated, $this$createCoroutineUnintercepted);
            } else {
                anon = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$$inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.2(probeCoroutineCreated, context, $this$createCoroutineUnintercepted);
            }
            $i$f$createCoroutineFromSuspendFunction = anon;
        }
        return $i$f$createCoroutineFromSuspendFunction;
    }

    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$createCoroutineUnintercepted, R receiver, Continuation<? super T> completion) {
        Continuation $i$f$createCoroutineFromSuspendFunction;
        kotlin.coroutines.CoroutineContext context;
        BaseContinuationImpl anon;
        Intrinsics.checkNotNullParameter($this$createCoroutineUnintercepted, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if ($this$createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            $i$f$createCoroutineFromSuspendFunction = (BaseContinuationImpl)$this$createCoroutineUnintercepted.create(receiver, probeCoroutineCreated);
        } else {
            int i = 0;
            context = probeCoroutineCreated.getContext();
            if (context == EmptyCoroutineContext.INSTANCE) {
                anon = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$$inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.3(probeCoroutineCreated, $this$createCoroutineUnintercepted, receiver);
            } else {
                anon = new IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$$inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.4(probeCoroutineCreated, context, $this$createCoroutineUnintercepted, receiver);
            }
            $i$f$createCoroutineFromSuspendFunction = anon;
        }
        return $i$f$createCoroutineFromSuspendFunction;
    }

    private static final <T> Continuation<T> createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation<? super T> completion) {
        BaseContinuationImpl anon;
        final kotlin.coroutines.CoroutineContext context = completion.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            anon = new IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction.1(completion);
        } else {
            anon = new IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction.2(completion, context);
        }
        return anon;
    }

    public static final <T> Continuation<T> intercepted(Continuation<? super T> $this$intercepted) {
        Object intercepted;
        Intrinsics.checkNotNullParameter($this$intercepted, "<this>");
        if ($this$intercepted instanceof ContinuationImpl) {
            intercepted = $this$intercepted;
        } else {
            intercepted = 0;
        }
        if (intercepted != null) {
            if (intercepted.intercepted() == null) {
                intercepted = $this$intercepted;
            }
        } else {
        }
        return intercepted;
    }

    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineUninterceptedOrReturn, Continuation<? super T> completion) {
        Object wrapWithContinuationImpl;
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (!$this$startCoroutineUninterceptedOrReturn instanceof BaseContinuationImpl) {
            wrapWithContinuationImpl = IntrinsicsKt.wrapWithContinuationImpl($this$startCoroutineUninterceptedOrReturn, completion);
        } else {
            wrapWithContinuationImpl = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 1).invoke(completion);
        }
        return wrapWithContinuationImpl;
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUninterceptedOrReturn, R receiver, Continuation<? super T> completion) {
        Object wrapWithContinuationImpl;
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (!$this$startCoroutineUninterceptedOrReturn instanceof BaseContinuationImpl) {
            wrapWithContinuationImpl = IntrinsicsKt.wrapWithContinuationImpl($this$startCoroutineUninterceptedOrReturn, receiver, completion);
        } else {
            wrapWithContinuationImpl = (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 2).invoke(receiver, completion);
        }
        return wrapWithContinuationImpl;
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUninterceptedOrReturn, R receiver, P param, Continuation<? super T> completion) {
        Object wrapWithContinuationImpl;
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (!$this$startCoroutineUninterceptedOrReturn instanceof BaseContinuationImpl) {
            wrapWithContinuationImpl = IntrinsicsKt.wrapWithContinuationImpl($this$startCoroutineUninterceptedOrReturn, receiver, param, completion);
        } else {
            wrapWithContinuationImpl = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 3).invoke(receiver, param, completion);
        }
        return wrapWithContinuationImpl;
    }

    public static final <T> Object wrapWithContinuationImpl(Function1<? super Continuation<? super T>, ? extends Object> $this$wrapWithContinuationImpl, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$wrapWithContinuationImpl, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$wrapWithContinuationImpl, 1).invoke(IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(completion)));
    }

    public static final <R, T> Object wrapWithContinuationImpl(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$wrapWithContinuationImpl, R receiver, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$wrapWithContinuationImpl, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$wrapWithContinuationImpl, 2).invoke(receiver, IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(completion)));
    }

    public static final <R, P, T> Object wrapWithContinuationImpl(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> $this$wrapWithContinuationImpl, R receiver, P param, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$wrapWithContinuationImpl, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$wrapWithContinuationImpl, 3).invoke(receiver, param, IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(completion)));
    }
}
