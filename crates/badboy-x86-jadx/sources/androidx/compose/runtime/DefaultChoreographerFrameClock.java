package androidx.compose.runtime;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0006\u001a\u0002H\u0007\"\u0004\u0008\u0000\u0010\u00072!\u0010\u0008\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u0002H\u00070\tH\u0096@¢\u0006\u0002\u0010\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/runtime/DefaultChoreographerFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "()V", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultChoreographerFrameClock implements androidx.compose.runtime.MonotonicFrameClock {

    public static final androidx.compose.runtime.DefaultChoreographerFrameClock INSTANCE;
    private static final Choreographer choreographer;
    static {
        DefaultChoreographerFrameClock defaultChoreographerFrameClock = new DefaultChoreographerFrameClock();
        DefaultChoreographerFrameClock.INSTANCE = defaultChoreographerFrameClock;
        DefaultChoreographerFrameClock.choreographer.1 anon = new DefaultChoreographerFrameClock.choreographer.1(0);
        DefaultChoreographerFrameClock.choreographer = (Choreographer)BuildersKt.runBlocking((CoroutineContext)Dispatchers.getMain().getImmediate(), (Function2)anon);
    }

    public static final Choreographer access$getChoreographer$p() {
        return DefaultChoreographerFrameClock.choreographer;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MonotonicFrameClock.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        final int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i4 = 0;
        DefaultChoreographerFrameClock.withFrameNanos.2.callback.1 anon = new DefaultChoreographerFrameClock.withFrameNanos.2.callback.1((CancellableContinuation)cancellableContinuationImpl2, onFrame);
        DefaultChoreographerFrameClock.access$getChoreographer$p().postFrameCallback((Choreographer.FrameCallback)anon);
        DefaultChoreographerFrameClock.withFrameNanos.2.1 anon2 = new DefaultChoreographerFrameClock.withFrameNanos.2.1(anon);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)anon2);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }
}
