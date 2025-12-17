package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ7\u0010\u000c\u001a\u0002H\r\"\u0004\u0008\u0000\u0010\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u0002H\r0\u000fH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/runtime/PausableMonotonicFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameClock", "(Landroidx/compose/runtime/MonotonicFrameClock;)V", "isPaused", "", "()Z", "latch", "Landroidx/compose/runtime/Latch;", "pause", "", "resume", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PausableMonotonicFrameClock implements androidx.compose.runtime.MonotonicFrameClock {

    public static final int $stable = 8;
    private final androidx.compose.runtime.MonotonicFrameClock frameClock;
    private final androidx.compose.runtime.Latch latch;
    static {
        final int i = 8;
    }

    public PausableMonotonicFrameClock(androidx.compose.runtime.MonotonicFrameClock frameClock) {
        super();
        this.frameClock = frameClock;
        Latch latch = new Latch();
        this.latch = latch;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MonotonicFrameClock.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final boolean isPaused() {
        return open ^= 1;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final void pause() {
        this.latch.closeLatch();
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final void resume() {
        this.latch.openLatch();
    }

    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation2) {
        boolean anon;
        int i3;
        int i;
        Object label;
        Object frameClock;
        int i2;
        Object obj6;
        Object obj7;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof PausableMonotonicFrameClock.withFrameNanos.1 && label2 &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj7 -= i;
            } else {
                anon = new PausableMonotonicFrameClock.withFrameNanos.1(this, continuation2);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                label = this;
                anon.L$0 = label;
                anon.L$1 = function1;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj6 = anon.L$1;
                label = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            case 2:
                ResultKt.throwOnFailure(obj7);
                obj6 = obj7;
                return obj6;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        int i4 = 0;
        anon.L$0 = i4;
        anon.L$1 = i4;
        anon.label = 2;
        if (label.frameClock.withFrameNanos(obj6, anon) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
    }
}
