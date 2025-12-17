package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0004\u001a\u001a\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002\u001a6\u0010\u0011\u001a\u0002H\u0012\"\u0004\u0008\u0000\u0010\u0012*\u00020\t2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086Hø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0016", d2 = {"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED", "MAX_SPIN_CYCLES", "", "PERMIT", "SEGMENT_SIZE", "TAKEN", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemaphoreKt {

    private static final Symbol BROKEN;
    private static final Symbol CANCELLED;
    private static final int MAX_SPIN_CYCLES;
    private static final Symbol PERMIT;
    private static final int SEGMENT_SIZE;
    private static final Symbol TAKEN;
    static {
        SemaphoreKt.MAX_SPIN_CYCLES = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, 0);
        Symbol symbol = new Symbol("PERMIT");
        SemaphoreKt.PERMIT = symbol;
        Symbol symbol2 = new Symbol("TAKEN");
        SemaphoreKt.TAKEN = symbol2;
        Symbol symbol3 = new Symbol("BROKEN");
        SemaphoreKt.BROKEN = symbol3;
        Symbol symbol4 = new Symbol("CANCELLED");
        SemaphoreKt.CANCELLED = symbol4;
        SemaphoreKt.SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, 0);
    }

    public static final kotlinx.coroutines.sync.Semaphore Semaphore(int permits, int acquiredPermits) {
        SemaphoreImpl semaphoreImpl = new SemaphoreImpl(permits, acquiredPermits);
        return (Semaphore)semaphoreImpl;
    }

    public static kotlinx.coroutines.sync.Semaphore Semaphore$default(int i, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 0;
        }
        return SemaphoreKt.Semaphore(i, obj1);
    }

    public static final kotlinx.coroutines.sync.SemaphoreSegment access$createSegment(long id, kotlinx.coroutines.sync.SemaphoreSegment prev) {
        return SemaphoreKt.createSegment(id, prev);
    }

    public static final Symbol access$getBROKEN$p() {
        return SemaphoreKt.BROKEN;
    }

    public static final Symbol access$getCANCELLED$p() {
        return SemaphoreKt.CANCELLED;
    }

    public static final int access$getMAX_SPIN_CYCLES$p() {
        return SemaphoreKt.MAX_SPIN_CYCLES;
    }

    public static final Symbol access$getPERMIT$p() {
        return SemaphoreKt.PERMIT;
    }

    public static final int access$getSEGMENT_SIZE$p() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    public static final Symbol access$getTAKEN$p() {
        return SemaphoreKt.TAKEN;
    }

    private static final kotlinx.coroutines.sync.SemaphoreSegment createSegment(long id, kotlinx.coroutines.sync.SemaphoreSegment prev) {
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(id, prev, obj4, 0);
        return semaphoreSegment;
    }

    public static final <T> Object withPermit(kotlinx.coroutines.sync.Semaphore semaphore, Function0<? extends T> function02, Continuation<? super T> continuation3) {
        boolean anon;
        int i;
        Object l$0;
        int i2;
        int label;
        Object acquire;
        int obj4;
        Object obj5;
        Object obj6;
        anon = continuation3;
        i2 = Integer.MIN_VALUE;
        if (continuation3 instanceof SemaphoreKt.withPermit.1 && label2 &= i2 != 0) {
            anon = continuation3;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new SemaphoreKt.withPermit.1(continuation3);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                anon.L$0 = semaphore;
                anon.L$1 = function02;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = semaphore;
                obj4 = label;
                break;
            case 1:
                obj4 = 0;
                obj5 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
        }
        l$0.release();
        return obj5.invoke();
    }

    private static final <T> Object withPermit$$forInline(kotlinx.coroutines.sync.Semaphore $this$withPermit, Function0<? extends T> action, Continuation<? super T> $completion) {
        final int i = 0;
        $this$withPermit.acquire($completion);
        $this$withPermit.release();
        return action.invoke();
    }
}
