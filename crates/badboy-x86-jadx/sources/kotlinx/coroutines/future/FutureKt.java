package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0010\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005\u001a\u001c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\u001a!\u0010\u0008\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a[\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2'\u0010\u0010\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011¢\u0006\u0002\u0008\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0001H\u0002\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0017", d2 = {"asCompletableFuture", "Ljava/util/concurrent/CompletableFuture;", "T", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/Job;", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "setupCancellation", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FutureKt {
    public static Object $r8$lambda$CVsR10o-YJP4IN5741Ey9yO9s50(Function2 function2, Object object2, Throwable throwable3) {
        return FutureKt.asDeferred$lambda$4(function2, object2, throwable3);
    }

    public static Unit $r8$lambda$nhDb5E9NjAZTF31felWqlfP4Z1A(Job job, Object object2, Throwable throwable3) {
        return FutureKt.setupCancellation$lambda$2(job, object2, throwable3);
    }

    public static final <T> CompletableFuture<T> asCompletableFuture(Deferred<? extends T> $this$asCompletableFuture) {
        CompletableFuture completableFuture = new CompletableFuture();
        FutureKt.setupCancellation((Job)$this$asCompletableFuture, completableFuture);
        FutureKt.asCompletableFuture.1 anon = new FutureKt.asCompletableFuture.1(completableFuture, $this$asCompletableFuture);
        $this$asCompletableFuture.invokeOnCompletion((Function1)anon);
        return completableFuture;
    }

    public static final CompletableFuture<Unit> asCompletableFuture(Job $this$asCompletableFuture) {
        CompletableFuture completableFuture = new CompletableFuture();
        FutureKt.setupCancellation($this$asCompletableFuture, completableFuture);
        FutureKt.asCompletableFuture.2 anon = new FutureKt.asCompletableFuture.2(completableFuture);
        $this$asCompletableFuture.invokeOnCompletion((Function1)anon);
        return completableFuture;
    }

    public static final <T> Deferred<T> asDeferred(CompletionStage<T> $this$asDeferred) {
        CompletableDeferred completableDeferred;
        int i;
        int i3;
        boolean z;
        int i2;
        final CompletableFuture completableFuture = $this$asDeferred.toCompletableFuture();
        i3 = 0;
        if (completableFuture.isDone()) {
            completableDeferred = CompletableDeferredKt.CompletableDeferred(completableFuture.get());
            return completableDeferred;
        }
        CompletableDeferred completableDeferred2 = CompletableDeferredKt.CompletableDeferred$default(i3, 1, i3);
        FutureKt.asDeferred.2 anon = new FutureKt.asDeferred.2(completableDeferred2);
        FutureKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new FutureKt$$ExternalSyntheticLambda0((Function2)anon);
        $this$asDeferred.handle(externalSyntheticLambda0);
        JobKt.cancelFutureOnCompletion((Job)completableDeferred2, (Future)completableFuture);
        return (Deferred)completableDeferred2;
    }

    private static final Object asDeferred$lambda$4(Function2 $tmp0, Object p0, Throwable p1) {
        return $tmp0.invoke(p0, p1);
    }

    public static final <T> Object await(CompletionStage<T> $this$await, Continuation<? super T> $completion) {
        Throwable th;
        Throwable th2;
        final CompletableFuture completableFuture = $this$await.toCompletableFuture();
        if (completableFuture.isDone()) {
            return completableFuture.get();
        }
        int e = 0;
        int i = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i3 = 0;
        ContinuationHandler continuationHandler = new ContinuationHandler((Continuation)(CancellableContinuation)cancellableContinuationImpl2);
        $this$await.handle((BiFunction)continuationHandler);
        FutureKt.await.2.1 anon = new FutureKt.await.2.1(completableFuture, continuationHandler);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)anon);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }

    public static final <T> CompletableFuture<T> future(CoroutineScope $this$future, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        if (start.isLazy()) {
        } else {
            CompletableFuture completableFuture = new CompletableFuture();
            CompletableFutureCoroutine completableFutureCoroutine = new CompletableFutureCoroutine(CoroutineContextKt.newCoroutineContext($this$future, context), completableFuture);
            completableFuture.handle((BiFunction)completableFutureCoroutine);
            completableFutureCoroutine.start(start, completableFutureCoroutine, block);
            return completableFuture;
        }
        int newContext = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(start).append(" start is not supported").toString().toString());
        throw illegalArgumentException;
    }

    public static CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext2, CoroutineStart coroutineStart3, Function2 function24, int i5, Object object6) {
        EmptyCoroutineContext obj1;
        CoroutineStart obj2;
        if (i5 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i5 &= 2 != 0) {
            obj2 = CoroutineStart.DEFAULT;
        }
        return FutureKt.future(coroutineScope, obj1, obj2, function24);
    }

    private static final void setupCancellation(Job $this$setupCancellation, CompletableFuture<?> future) {
        FutureKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new FutureKt$$ExternalSyntheticLambda1($this$setupCancellation);
        future.handle(externalSyntheticLambda1);
    }

    private static final Unit setupCancellation$lambda$2(Job $this_setupCancellation, Object object2, Throwable exception) {
        Object obj;
        int i;
        boolean z;
        int obj4;
        obj4 = 0;
        obj = exception;
        i = 0;
        if (exception != null && obj instanceof CancellationException != null) {
            obj = exception;
            i = 0;
            if (obj instanceof CancellationException != null) {
                obj4 = obj;
            }
            if (obj4 == null) {
                obj4 = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", obj);
            }
        }
        $this_setupCancellation.cancel(obj4);
        return Unit.INSTANCE;
    }
}
