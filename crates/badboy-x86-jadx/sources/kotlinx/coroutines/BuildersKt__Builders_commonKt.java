package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rH\u0086@ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\u0008\u0000\u0010\u0005*\u00020\n2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u0005*\u00020\u00152)\u0008\u0008\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rH\u0086Jø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"RESUMED", "", "SUSPENDED", "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final class BuildersKt__Builders_commonKt {

    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED;
    public static final <T> kotlinx.coroutines.Deferred<T> async(kotlinx.coroutines.CoroutineScope $this$async, CoroutineContext context, kotlinx.coroutines.CoroutineStart start, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        kotlinx.coroutines.DeferredCoroutine lazyDeferredCoroutine;
        int i;
        final CoroutineContext coroutineContext = CoroutineContextKt.newCoroutineContext($this$async, context);
        if (start.isLazy()) {
            lazyDeferredCoroutine = new LazyDeferredCoroutine(coroutineContext, block);
        } else {
            lazyDeferredCoroutine = new DeferredCoroutine(coroutineContext, 1);
        }
        lazyDeferredCoroutine.start(start, lazyDeferredCoroutine, block);
        return (Deferred)lazyDeferredCoroutine;
    }

    public static kotlinx.coroutines.Deferred async$default(kotlinx.coroutines.CoroutineScope coroutineScope, CoroutineContext coroutineContext2, kotlinx.coroutines.CoroutineStart coroutineStart3, Function2 function24, int i5, Object object6) {
        EmptyCoroutineContext obj1;
        kotlinx.coroutines.CoroutineStart obj2;
        if (i5 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i5 &= 2 != 0) {
            obj2 = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, obj1, obj2, function24);
    }

    public static final <T> Object invoke(kotlinx.coroutines.CoroutineDispatcher $this$invoke, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        final int i = 0;
        return BuildersKt.withContext((CoroutineContext)$this$invoke, block, $completion);
    }

    private static final <T> Object invoke$$forInline(kotlinx.coroutines.CoroutineDispatcher $this$invoke, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        final int i = 0;
        return BuildersKt.withContext((CoroutineContext)$this$invoke, block, $completion);
    }

    public static final kotlinx.coroutines.Job launch(kotlinx.coroutines.CoroutineScope $this$launch, CoroutineContext context, kotlinx.coroutines.CoroutineStart start, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        kotlinx.coroutines.StandaloneCoroutine lazyStandaloneCoroutine;
        int i;
        final CoroutineContext coroutineContext = CoroutineContextKt.newCoroutineContext($this$launch, context);
        if (start.isLazy()) {
            lazyStandaloneCoroutine = new LazyStandaloneCoroutine(coroutineContext, block);
        } else {
            lazyStandaloneCoroutine = new StandaloneCoroutine(coroutineContext, 1);
        }
        lazyStandaloneCoroutine.start(start, lazyStandaloneCoroutine, block);
        return (Job)lazyStandaloneCoroutine;
    }

    public static kotlinx.coroutines.Job launch$default(kotlinx.coroutines.CoroutineScope coroutineScope, CoroutineContext coroutineContext2, kotlinx.coroutines.CoroutineStart coroutineStart3, Function2 function24, int i5, Object object6) {
        EmptyCoroutineContext obj1;
        kotlinx.coroutines.CoroutineStart obj2;
        if (i5 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i5 &= 2 != 0) {
            obj2 = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, obj1, obj2, function24);
    }

    public static final <T> Object withContext(CoroutineContext context, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        int dispatchedCoroutine;
        Function2 coroutine;
        CoroutineContext context2;
        int i2;
        int i;
        Object threadContext;
        Object undispatchedOrReturn;
        Object obj;
        Object obj13;
        final Continuation continuation = $completion;
        final int i4 = 0;
        final CoroutineContext context4 = continuation.getContext();
        final CoroutineContext coroutineContext = CoroutineContextKt.newCoroutineContext(context4, context);
        JobKt.ensureActive(coroutineContext);
        if (coroutineContext == context4) {
            dispatchedCoroutine = new ScopeCoroutine(coroutineContext, continuation);
            coroutine = block;
            obj13 = obj;
        } else {
            if (Intrinsics.areEqual(coroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key), context4.get((CoroutineContext.Key)ContinuationInterceptor.Key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(coroutineContext, continuation);
                kotlinx.coroutines.UndispatchedCoroutine undispatchedCoroutine2 = undispatchedCoroutine;
                context2 = undispatchedCoroutine2.getContext();
                i = 0;
                dispatchedCoroutine = 0;
                ThreadContextKt.restoreThreadContext(context2, ThreadContextKt.updateThreadContext(context2, 0));
                coroutine = block;
                obj13 = undispatchedOrReturn;
            } else {
                dispatchedCoroutine = new DispatchedCoroutine(coroutineContext, continuation);
                context2 = dispatchedCoroutine;
                CancellableKt.startCoroutineCancellable$default(block, context2, (Continuation)context2, 0, 4, 0);
                obj13 = context2.getResult$kotlinx_coroutines_core();
            }
        }
        if (obj13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return obj13;
    }
}
