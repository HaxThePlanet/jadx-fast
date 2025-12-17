package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0014\u001a\u00020\u00042\u000c\u0008\u0002\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ(\u0010\u001d\u001a\u0002H\u001e\"\u0004\u0008\u0000\u0010\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u0002H\u001e0 H\u0096@¢\u0006\u0002\u0010!R\u0018\u0010\u0006\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00080\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00080\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", "hasAwaitersUnlocked", "Landroidx/compose/runtime/AtomicInt;", "lock", "", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", "cause", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BroadcastFrameClock implements androidx.compose.runtime.MonotonicFrameClock {

    public static final int $stable = 8;
    private List<androidx.compose.runtime.BroadcastFrameClock.FrameAwaiter<?>> awaiters;
    private Throwable failureCause;
    private final androidx.compose.runtime.AtomicInt hasAwaitersUnlocked;
    private final Object lock;
    private final Function0<Unit> onNewAwaiters;
    private List<androidx.compose.runtime.BroadcastFrameClock.FrameAwaiter<?>> spareList;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FrameAwaiter {

        private final Continuation<R> continuation;
        private final Function1<Long, R> onFrame;
        public FrameAwaiter(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> continuation) {
            super();
            this.onFrame = onFrame;
            this.continuation = continuation;
        }

        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        public final Function1<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long timeNanos) {
            Object constructor-impl;
            int i;
            kotlin.Result.Companion companion = Result.Companion;
            i = 0;
            constructor-impl = Result.constructor-impl(obj.onFrame.invoke(Long.valueOf(timeNanos)));
            try {
                this.continuation.resumeWith(constructor-impl);
            }
        }
    }
    static {
        final int i = 8;
    }

    public BroadcastFrameClock() {
        final int i = 0;
        super(i, 1, i);
    }

    public BroadcastFrameClock(Function0<Unit> onNewAwaiters) {
        super();
        this.onNewAwaiters = onNewAwaiters;
        Object object = new Object();
        this.lock = object;
        ArrayList arrayList = new ArrayList();
        this.awaiters = (List)arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.spareList = (List)arrayList2;
        AtomicInt atomicInt = new AtomicInt(0);
        this.hasAwaitersUnlocked = atomicInt;
    }

    public BroadcastFrameClock(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final void access$fail(androidx.compose.runtime.BroadcastFrameClock $this, Throwable cause) {
        $this.fail(cause);
    }

    public static final List access$getAwaiters$p(androidx.compose.runtime.BroadcastFrameClock $this) {
        return $this.awaiters;
    }

    public static final Throwable access$getFailureCause$p(androidx.compose.runtime.BroadcastFrameClock $this) {
        return $this.failureCause;
    }

    public static final androidx.compose.runtime.AtomicInt access$getHasAwaitersUnlocked$p(androidx.compose.runtime.BroadcastFrameClock $this) {
        return $this.hasAwaitersUnlocked;
    }

    public static final Object access$getLock$p(androidx.compose.runtime.BroadcastFrameClock $this) {
        return $this.lock;
    }

    public static final Function0 access$getOnNewAwaiters$p(androidx.compose.runtime.BroadcastFrameClock $this) {
        return $this.onNewAwaiters;
    }

    public static void cancel$default(androidx.compose.runtime.BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException2, int i3, Object object4) {
        CancellationException obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(obj1);
    }

    private final void fail(Throwable cause) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        Continuation continuation;
        Object constructor-impl;
        final Object lock = this.lock;
        final int i2 = 0;
        int i3 = 0;
        synchronized (lock) {
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final void cancel(CancellationException cancellationException) {
        fail((Throwable)cancellationException);
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MonotonicFrameClock.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final boolean getHasAwaiters() {
        int i;
        i = this.hasAwaitersUnlocked.get() != 0 ? 1 : 0;
        return i;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final void sendFrame(long timeNanos) {
        int i;
        Object obj;
        final Object lock = this.lock;
        final int i2 = 0;
        int i3 = 0;
        final List awaiters = this.awaiters;
        this.awaiters = this.spareList;
        this.spareList = awaiters;
        this.hasAwaitersUnlocked.set(0);
        i = 0;
        synchronized (lock) {
            while (i < awaiters.size()) {
                (BroadcastFrameClock.FrameAwaiter)awaiters.get(i).resume(timeNanos);
                i++;
            }
            awaiters.clear();
            Unit $i$a$SynchronizedBroadcastFrameClock$sendFrame$1 = Unit.INSTANCE;
        }
    }

    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        int anon;
        CancellableContinuationImpl i;
        Object constructor-impl;
        Object obj;
        final androidx.compose.runtime.BroadcastFrameClock broadcastFrameClock = this;
        final int i2 = 0;
        final int i3 = 0;
        i = 1;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), i);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
        final int i4 = 0;
        BroadcastFrameClock.FrameAwaiter frameAwaiter = new BroadcastFrameClock.FrameAwaiter(onFrame, (Continuation)(CancellableContinuation)cancellableContinuationImpl3);
        androidx.compose.runtime.BroadcastFrameClock.FrameAwaiter frameAwaiter2 = frameAwaiter;
        final Object obj2 = BroadcastFrameClock.access$getLock$p(broadcastFrameClock);
        final int i5 = 0;
        anon = 0;
        final Throwable th2 = BroadcastFrameClock.access$getFailureCause$p(broadcastFrameClock);
        synchronized (obj2) {
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)cancellableContinuationImpl3.resumeWith(Result.constructor-impl(ResultKt.createFailure(th2)));
        }
        Object result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return result;
    }
}
