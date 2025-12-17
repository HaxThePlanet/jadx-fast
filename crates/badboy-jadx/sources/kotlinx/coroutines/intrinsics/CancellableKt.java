package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00032\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0008H\u0082\u0008\u001a\u001e\u0010\t\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0003H\u0000\u001a>\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u000b*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c2\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ay\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u000f\"\u0004\u0008\u0001\u0010\u000b*\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00032%\u0008\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000cH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0017", d2 = {"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "onCancellation", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CancellableKt {
    private static final void dispatcherFailure(Continuation<?> completion, Throwable e) {
        kotlin.Result.Companion companion = Result.Companion;
        completion.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        throw e;
    }

    private static final void runSafely(Continuation<?> completion, Function0<Unit> block) {
        Throwable th;
        final int i = 0;
        block.invoke();
        try {
        }
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> $this$startCoroutineCancellable, Continuation<?> fatalCompletion) {
        int i;
        final int i2 = 0;
        i = 0;
        kotlin.Result.Companion companion = Result.Companion;
        final int i4 = 0;
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted($this$startCoroutineCancellable), Result.constructor-impl(Unit.INSTANCE), i4, 2, i4);
    }

    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineCancellable, Continuation<? super T> completion) {
        int i;
        final int i2 = 0;
        i = 0;
        kotlin.Result.Companion companion = Result.Companion;
        final int i4 = 0;
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutineCancellable, completion)), Result.constructor-impl(Unit.INSTANCE), i4, 2, i4);
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineCancellable, R receiver, Continuation<? super T> completion, Function1<? super Throwable, Unit> onCancellation) {
        int i;
        final int i2 = 0;
        i = 0;
        kotlin.Result.Companion companion = Result.Companion;
        DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutineCancellable, receiver, completion)), Result.constructor-impl(Unit.INSTANCE), onCancellation);
    }

    public static void startCoroutineCancellable$default(Function2 function2, Object object2, Continuation continuation3, Function1 function14, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        CancellableKt.startCoroutineCancellable(function2, object2, continuation3, obj3);
    }
}
