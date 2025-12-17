package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\u0008\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u0016\u0010\u000f\u001a\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u001d\u0010\u0010\u001a\u00020\u0003*\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0008\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0019", d2 = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandlerDispatcherKt {

    private static final long MAX_DELAY = 4611686018427387903L;
    public static final kotlinx.coroutines.android.HandlerDispatcher Main;
    private static volatile Choreographer choreographer;
    public static void $r8$lambda$_-s4SOKmmdhN7PexQng1D-Olurw(CancellableContinuation cancellableContinuation, long l2) {
        HandlerDispatcherKt.postFrameCallback$lambda$6(cancellableContinuation, l2);
    }

    static {
        int i;
        Object constructor-impl;
        kotlinx.coroutines.android.HandlerContext handlerContext;
        i = 0;
        kotlin.Result.Companion companion = Result.Companion;
        int i2 = 0;
        handlerContext = new HandlerContext(HandlerDispatcherKt.asHandler(Looper.getMainLooper(), true), i, 2, i);
        constructor-impl = Result.constructor-impl(handlerContext);
        if (Result.isFailure-impl(constructor-impl)) {
        } else {
            i = constructor-impl;
        }
        HandlerDispatcherKt.Main = (HandlerDispatcher)i;
    }

    public static final Object access$awaitFrameSlowPath(Continuation $completion) {
        return HandlerDispatcherKt.awaitFrameSlowPath($completion);
    }

    public static final void access$postFrameCallback(Choreographer choreographer, CancellableContinuation cont) {
        HandlerDispatcherKt.postFrameCallback(choreographer, cont);
    }

    public static final void access$updateChoreographerAndPostFrameCallback(CancellableContinuation cont) {
        HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(cont);
    }

    public static final Handler asHandler(Looper $this$asHandler, boolean async) {
        if (async) {
            Class[] arr = new Class[1];
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(0, /* result */);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler)invoke;
        }
        Handler factoryMethod = new Handler($this$asHandler);
        return factoryMethod;
    }

    public static final Object awaitFrame(Continuation<? super Long> $completion) {
        final Choreographer choreographer = HandlerDispatcherKt.choreographer;
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        int i4 = 0;
        HandlerDispatcherKt.access$postFrameCallback(choreographer, (CancellableContinuation)cancellableContinuationImpl);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (choreographer != null && uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            i = 0;
            i2 = 0;
            cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellableContinuationImpl.initCancellability();
            i4 = 0;
            HandlerDispatcherKt.access$postFrameCallback(choreographer, (CancellableContinuation)cancellableContinuationImpl);
            uCont$iv = cancellableContinuationImpl.getResult();
            if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return uCont$iv;
        }
        return HandlerDispatcherKt.awaitFrameSlowPath($completion);
    }

    private static final Object awaitFrameSlowPath(Continuation<? super Long> $completion) {
        Object myLooper;
        Object mainLooper;
        int i;
        kotlinx.coroutines.android.HandlerDispatcherKt.awaitFrameSlowPath.lambda.3$$inlined.Runnable.1 anon;
        final int i2 = 0;
        int i3 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i5 = 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback((CancellableContinuation)cancellableContinuationImpl2);
        } else {
            i = 0;
            anon = new HandlerDispatcherKt.awaitFrameSlowPath.lambda.3$$inlined.Runnable.1(cancellableContinuationImpl2);
            Dispatchers.getMain().dispatch(cancellableContinuationImpl2.getContext(), (Runnable)anon);
        }
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }

    public static final kotlinx.coroutines.android.HandlerDispatcher from(Handler handler) {
        int i = 0;
        return HandlerDispatcherKt.from$default(handler, i, 1, i);
    }

    public static final kotlinx.coroutines.android.HandlerDispatcher from(Handler $this$asCoroutineDispatcher, String name) {
        HandlerContext handlerContext = new HandlerContext($this$asCoroutineDispatcher, name);
        return (HandlerDispatcher)handlerContext;
    }

    public static kotlinx.coroutines.android.HandlerDispatcher from$default(Handler handler, String string2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return HandlerDispatcherKt.from(handler, obj1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static void getMain$annotations() {
    }

    private static final void postFrameCallback(Choreographer choreographer, CancellableContinuation<? super Long> cont) {
        HandlerDispatcherKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new HandlerDispatcherKt$$ExternalSyntheticLambda0(cont);
        choreographer.postFrameCallback(externalSyntheticLambda0);
    }

    private static final void postFrameCallback$lambda$6(CancellableContinuation $cont, long nanos) {
        final int i = 0;
        $cont.resumeUndispatched((CoroutineDispatcher)Dispatchers.getMain(), Long.valueOf(nanos));
    }

    private static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cont) {
        Choreographer choreographer2;
        Choreographer choreographer;
        int i;
        if (HandlerDispatcherKt.choreographer == null) {
            choreographer2 = Choreographer.getInstance();
            Intrinsics.checkNotNull(choreographer2);
            i = 0;
            HandlerDispatcherKt.choreographer = choreographer2;
        }
        HandlerDispatcherKt.postFrameCallback(choreographer2, cont);
    }
}
