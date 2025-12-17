package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a=\u0010\u0000\u001a\u0007H\u0001¢\u0006\u0002\u0008\u0002\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00032\u001e\u0008\u0004\u0010\u0004\u001a\u0018\u0012\t\u0012\u00070\u0006¢\u0006\u0002\u0008\u0002\u0012\t\u0012\u0007H\u0001¢\u0006\u0002\u0008\u00020\u0005H\u0086H¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"withContextAvailable", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(androidx.activity.contextaware.ContextAware $this$withContextAvailable, Function1<Context, R> onContextAvailable, Continuation<R> $completion) {
        final int i = 0;
        final Context peekAvailableContext = $this$withContextAvailable.peekAvailableContext();
        if (peekAvailableContext != null) {
            return onContextAvailable.invoke(peekAvailableContext);
        }
        int i2 = 0;
        int i3 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i5 = 0;
        ContextAwareKt.withContextAvailable.2.listener.1 anon = new ContextAwareKt.withContextAvailable.2.listener.1((CancellableContinuation)cancellableContinuationImpl2, onContextAvailable);
        $this$withContextAvailable.addOnContextAvailableListener((OnContextAvailableListener)anon);
        ContextAwareKt.withContextAvailable.2.1 anon2 = new ContextAwareKt.withContextAvailable.2.1($this$withContextAvailable, anon);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)anon2);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }

    private static final <R> Object withContextAvailable$$forInline(androidx.activity.contextaware.ContextAware $this$withContextAvailable, Function1<Context, R> onContextAvailable, Continuation<R> $completion) {
        Object cOROUTINE_SUSPENDED;
        final int i = 0;
        final Context peekAvailableContext = $this$withContextAvailable.peekAvailableContext();
        if (peekAvailableContext != null) {
            return onContextAvailable.invoke(peekAvailableContext);
        }
        int i2 = 0;
        final int i3 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)$completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i5 = 0;
        ContextAwareKt.withContextAvailable.2.listener.1 anon = new ContextAwareKt.withContextAvailable.2.listener.1((CancellableContinuation)cancellableContinuationImpl2, onContextAvailable);
        $this$withContextAvailable.addOnContextAvailableListener((OnContextAvailableListener)anon);
        ContextAwareKt.withContextAvailable.2.1 anon2 = new ContextAwareKt.withContextAvailable.2.1($this$withContextAvailable, anon);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)anon2);
        Unit co = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)$completion);
        }
        return result;
    }
}
