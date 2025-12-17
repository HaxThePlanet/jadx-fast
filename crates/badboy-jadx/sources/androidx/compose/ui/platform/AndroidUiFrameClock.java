package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.MonotonicFrameClock.DefaultImpls;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J(\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u000b0\rH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/compose/ui/platform/AndroidUiFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "choreographer", "Landroid/view/Choreographer;", "(Landroid/view/Choreographer;)V", "dispatcher", "Landroidx/compose/ui/platform/AndroidUiDispatcher;", "(Landroid/view/Choreographer;Landroidx/compose/ui/platform/AndroidUiDispatcher;)V", "getChoreographer", "()Landroid/view/Choreographer;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidUiFrameClock implements MonotonicFrameClock {

    public static final int $stable = 8;
    private final Choreographer choreographer;
    private final androidx.compose.ui.platform.AndroidUiDispatcher dispatcher;
    static {
        final int i = 8;
    }

    public AndroidUiFrameClock(Choreographer choreographer) {
        super(choreographer, 0);
    }

    public AndroidUiFrameClock(Choreographer choreographer, androidx.compose.ui.platform.AndroidUiDispatcher dispatcher) {
        super();
        this.choreographer = choreographer;
        this.dispatcher = dispatcher;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MonotonicFrameClock.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        androidx.compose.ui.platform.AndroidUiDispatcher dispatcher;
        boolean z;
        boolean equal;
        kotlin.jvm.internal.Lambda anon;
        Choreographer choreographer;
        if (this.dispatcher == null) {
            if (dispatcher instanceof AndroidUiDispatcher) {
            } else {
                dispatcher = 0;
            }
        }
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i4 = 0;
        AndroidUiFrameClock.withFrameNanos.2.callback.1 anon2 = new AndroidUiFrameClock.withFrameNanos.2.callback.1((CancellableContinuation)cancellableContinuationImpl2, this, onFrame);
        if (dispatcher != null && Intrinsics.areEqual(dispatcher.getChoreographer(), getChoreographer())) {
            if (Intrinsics.areEqual(dispatcher.getChoreographer(), getChoreographer())) {
                dispatcher.postFrameCallback$ui_release((Choreographer.FrameCallback)anon2);
                anon = new AndroidUiFrameClock.withFrameNanos.2.1(dispatcher, anon2);
                cancellableContinuationImpl2.invokeOnCancellation((Function1)anon);
            } else {
                getChoreographer().postFrameCallback(anon2);
                anon = new AndroidUiFrameClock.withFrameNanos.2.2(this, anon2);
                cancellableContinuationImpl2.invokeOnCancellation((Function1)anon);
            }
        } else {
        }
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }
}
