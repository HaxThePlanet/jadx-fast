package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0002\u0008\u0004\u001a<\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u00082\u0006\u0010\t\u001a\u00020\u00012\u001a\u0008\u0004\u0010\n\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u000c\u0012\u0004\u0012\u00020\r0\u000bH\u0087\u0008ø\u0001\u0000\u001a=\u0010\u000e\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u00082\u001a\u0008\u0004\u0010\u000f\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0004\u0012\u00020\r0\u000bH\u0087H\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\u0008\u0000\u0010\u0008*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007¢\u0006\u0002\u0010\u0014\u001aZ\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\u0008\u0000\u0010\u0015\"\u0004\u0008\u0001\u0010\u0008*#\u0008\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\u0008\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007¢\u0006\u0002\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00072\u0006\u0010\u001b\u001a\u0002H\u0008H\u0087\u0008¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\u0008\u001a;\u0010 \u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0008*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007¢\u0006\u0002\u0010!\u001aT\u0010 \u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0015\"\u0004\u0008\u0001\u0010\u0008*#\u0008\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\u0008\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007¢\u0006\u0002\u0010\"\"\u001b\u0010\u0000\u001a\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006#", d2 = {"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", "T", "context", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ContinuationKt {
    private static final <T> kotlin.coroutines.Continuation<T> Continuation(kotlin.coroutines.CoroutineContext context, Function1<? super Result<? extends T>, Unit> resumeWith) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resumeWith, "resumeWith");
        ContinuationKt.Continuation.1 anon = new ContinuationKt.Continuation.1(context, resumeWith);
        return (Continuation)anon;
    }

    public static final <T> kotlin.coroutines.Continuation<Unit> createCoroutine(Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends Object> $this$createCoroutine, kotlin.coroutines.Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$createCoroutine, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$createCoroutine, completion)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
        return (Continuation)safeContinuation;
    }

    public static final <R, T> kotlin.coroutines.Continuation<Unit> createCoroutine(Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends Object> $this$createCoroutine, R receiver, kotlin.coroutines.Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$createCoroutine, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$createCoroutine, receiver, completion)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
        return (Continuation)safeContinuation;
    }

    private static final kotlin.coroutines.CoroutineContext getCoroutineContext() {
        NotImplementedError notImplementedError = new NotImplementedError("Implemented as intrinsic");
        throw notImplementedError;
    }

    public static void getCoroutineContext$annotations() {
    }

    private static final <T> void resume(kotlin.coroutines.Continuation<? super T> $this$resume, T value) {
        Intrinsics.checkNotNullParameter($this$resume, "<this>");
        kotlin.Result.Companion companion = Result.Companion;
        $this$resume.resumeWith(Result.constructor-impl(value));
    }

    private static final <T> void resumeWithException(kotlin.coroutines.Continuation<? super T> $this$resumeWithException, Throwable exception) {
        Intrinsics.checkNotNullParameter($this$resumeWithException, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        kotlin.Result.Companion companion = Result.Companion;
        $this$resumeWithException.resumeWith(Result.constructor-impl(ResultKt.createFailure(exception)));
    }

    public static final <T> void startCoroutine(Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends Object> $this$startCoroutine, kotlin.coroutines.Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutine, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        kotlin.Result.Companion companion = Result.Companion;
        IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutine, completion)).resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    public static final <R, T> void startCoroutine(Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends Object> $this$startCoroutine, R receiver, kotlin.coroutines.Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutine, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        kotlin.Result.Companion companion = Result.Companion;
        IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutine, receiver, completion)).resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    private static final <T> Object suspendCoroutine(Function1<? super kotlin.coroutines.Continuation<? super T>, Unit> block, kotlin.coroutines.Continuation<? super T> $completion) {
        Object cOROUTINE_SUSPENDED;
        final int i = 0;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted((Continuation)$completion));
        block.invoke(safeContinuation);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)$completion);
        }
        return orThrow;
    }
}
