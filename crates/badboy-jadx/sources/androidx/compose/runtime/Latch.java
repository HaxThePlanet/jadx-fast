package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u0008H\u0086@¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0008J\u0006\u0010\u0010\u001a\u00020\u0008J\"\u0010\u0011\u001a\u0002H\u0012\"\u0004\u0008\u0000\u0010\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\u0008¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/Latch;", "", "()V", "_isOpen", "", "awaiters", "", "Lkotlin/coroutines/Continuation;", "", "isOpen", "()Z", "lock", "spareList", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeLatch", "openLatch", "withClosed", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Latch {

    public static final int $stable = 8;
    private boolean _isOpen = true;
    private List<Continuation<Unit>> awaiters;
    private final Object lock;
    private List<Continuation<Unit>> spareList;
    static {
        final int i = 8;
    }

    public Latch() {
        super();
        Object object = new Object();
        this.lock = object;
        ArrayList arrayList = new ArrayList();
        this.awaiters = (List)arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.spareList = (List)arrayList2;
        int i = 1;
    }

    public static final List access$getAwaiters$p(androidx.compose.runtime.Latch $this) {
        return $this.awaiters;
    }

    public static final Object access$getLock$p(androidx.compose.runtime.Latch $this) {
        return $this.lock;
    }

    public final Object await(Continuation<? super Unit> $completion) {
        if (isOpen()) {
            return Unit.INSTANCE;
        }
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i4 = 0;
        Object obj = Latch.access$getLock$p(this);
        final int i5 = 0;
        final int i6 = 0;
        Latch.access$getAwaiters$p(this).add((CancellableContinuation)cancellableContinuationImpl2);
        Latch.await.2.2 lock$iv = new Latch.await.2.2(this, cancellableContinuationImpl2);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)lock$iv);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        synchronized (obj) {
            i = 0;
            i2 = 0;
            cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellableContinuationImpl.initCancellability();
            cancellableContinuationImpl2 = cancellableContinuationImpl;
            i4 = 0;
            obj = Latch.access$getLock$p(this);
            i5 = 0;
            i6 = 0;
            Latch.access$getAwaiters$p(this).add((CancellableContinuation)cancellableContinuationImpl2);
            lock$iv = new Latch.await.2.2(this, cancellableContinuationImpl2);
            cancellableContinuationImpl2.invokeOnCancellation((Function1)lock$iv);
            uCont$iv = cancellableContinuationImpl.getResult();
        }
        DebugProbesKt.probeCoroutineSuspended($completion);
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    public final void closeLatch() {
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        this._isOpen = false;
        Unit $i$a$SynchronizedLatch$closeLatch$1 = Unit.INSTANCE;
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            this._isOpen = false;
            $i$a$SynchronizedLatch$closeLatch$1 = Unit.INSTANCE;
        }
    }

    public final boolean isOpen() {
        final Object lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        return this._isOpen;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            return this._isOpen;
        }
    }

    public final void openLatch() {
        int i;
        Object obj;
        Object constructor-impl;
        final Object lock = this.lock;
        final int i2 = 0;
        int i3 = 0;
        synchronized (lock) {
        }
    }

    public final <R> R withClosed(Function0<? extends R> block) {
        final int i = 0;
        closeLatch();
        openLatch();
        return block.invoke();
    }
}
