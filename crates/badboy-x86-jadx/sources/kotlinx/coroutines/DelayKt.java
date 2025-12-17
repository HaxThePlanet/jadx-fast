package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.Duration.Companion;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\rH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DelayKt {
    public static final Object awaitCancellation(Continuation<?> continuation) {
        boolean anon;
        int i3;
        int i;
        int i2;
        int label;
        Object result;
        Object cOROUTINE_SUSPENDED;
        int i4;
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl;
        Continuation intercepted;
        Object obj8;
        anon = continuation;
        i2 = Integer.MIN_VALUE;
        if (continuation instanceof DelayKt.awaitCancellation.1 && label2 &= i2 != 0) {
            anon = continuation;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj8 -= i2;
            } else {
                anon = new DelayKt.awaitCancellation.1(continuation);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                int i5 = 1;
                anon.label = i5;
                i4 = 0;
                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon), i5);
                cancellableContinuationImpl.initCancellability();
                kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                int i6 = 0;
                result = cancellableContinuationImpl.getResult();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
                return cOROUTINE_SUSPENDED2;
                i = label;
                break;
            case 1:
                i = 0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        KotlinNothingValueException $i$f$suspendCancellableCoroutine = new KotlinNothingValueException();
        throw $i$f$suspendCancellableCoroutine;
    }

    public static final Object delay(long timeMillis, Continuation<? super Unit> $completion) {
        int delay;
        if (Long.compare(timeMillis, i) <= 0) {
            return Unit.INSTANCE;
        }
        int i2 = 0;
        int i3 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(obj10), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i5 = 0;
        if (Long.compare(timeMillis, l) < 0) {
            DelayKt.getDelay((CancellableContinuation)cancellableContinuationImpl2.getContext()).scheduleResumeAfterDelay(timeMillis, $completion);
        }
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(obj10);
        }
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    public static final Object delay-VtjQ1oo(long duration, Continuation<? super Unit> $completion) {
        Object delay = DelayKt.delay(DelayKt.toDelayMillis-LRDsOJo(duration), obj1);
        if (delay == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return delay;
        }
        return Unit.INSTANCE;
    }

    public static final kotlinx.coroutines.Delay getDelay(CoroutineContext $this$delay) {
        kotlin.coroutines.CoroutineContext.Element defaultDelay;
        if (defaultDelay instanceof Delay) {
        } else {
            defaultDelay = 0;
        }
        if (defaultDelay == null) {
            defaultDelay = DefaultExecutorKt.getDefaultDelay();
        }
        return defaultDelay;
    }

    public static final long toDelayMillis-LRDsOJo(long $this$toDelayMillis_u2dLRDsOJo) {
        long coerceAtLeast;
        int i;
        if (Duration.compareTo-LRDsOJo($this$toDelayMillis_u2dLRDsOJo, obj5) > 0) {
            coerceAtLeast = RangesKt.coerceAtLeast(Duration.getInWholeMilliseconds-impl($this$toDelayMillis_u2dLRDsOJo), obj1);
        } else {
            coerceAtLeast = 0;
        }
        return coerceAtLeast;
    }
}
