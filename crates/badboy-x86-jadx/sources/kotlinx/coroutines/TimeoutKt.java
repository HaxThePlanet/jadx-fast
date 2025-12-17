package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a_\u0010\u0008\u001a\u0004\u0018\u00010\t\"\u0004\u0008\u0000\u0010\n\"\u0008\u0008\u0001\u0010\u000b*\u0002H\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\u000c2'\u0010\r\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\u0008\u0011H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aU\u0010\u0013\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\u0008\u0011H\u0086@ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0015\u001a]\u0010\u0013\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\u0008\u0011H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\u0008\u0018\u0010\u0015\u001aJ\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\u0008\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aR\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\u0008\u0011H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0015\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "delay", "Lkotlinx/coroutines/Delay;", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimeoutKt {
    public static final kotlinx.coroutines.TimeoutCancellationException TimeoutCancellationException(long time, kotlinx.coroutines.Delay delay, kotlinx.coroutines.Job coroutine) {
        Object timeoutMessage-LRDsOJo;
        long duration;
        if (coroutine instanceof DelayWithTimeoutDiagnostics) {
            timeoutMessage-LRDsOJo = coroutine;
        } else {
            timeoutMessage-LRDsOJo = 0;
        }
        if (timeoutMessage-LRDsOJo != null) {
            kotlin.time.Duration.Companion companion = Duration.Companion;
            if (timeoutMessage-LRDsOJo.timeoutMessage-LRDsOJo(DurationKt.toDuration(time, delay)) == null) {
                StringBuilder stringBuilder = new StringBuilder();
                timeoutMessage-LRDsOJo = stringBuilder.append("Timed out waiting for ").append(time).append(" ms").toString();
            }
        } else {
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(timeoutMessage-LRDsOJo, obj6);
        return timeoutCancellationException;
    }

    private static final <U, T extends U> Object setupTimeout(kotlinx.coroutines.TimeoutCoroutine<U, ? super T> coroutine, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        JobKt.disposeOnCompletion((Job)coroutine, DelayKt.getDelay(coroutine.uCont.getContext()).invokeOnTimeout(coroutine.time, obj5, (Runnable)coroutine));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout((ScopeCoroutine)coroutine, coroutine, block);
    }

    public static final <T> Object withTimeout(long timeMillis, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        if (Long.compare(timeMillis, i) <= 0) {
        } else {
            int i2 = 0;
            TimeoutCoroutine timeoutCoroutine = new TimeoutCoroutine(timeMillis, block, obj6);
            Object uCont = TimeoutKt.setupTimeout(timeoutCoroutine, $completion);
            if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(obj6);
            }
            return uCont;
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException("Timed out immediately");
        throw timeoutCancellationException;
    }

    public static final <T> Object withTimeout-KLykuaI(long timeout, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        return TimeoutKt.withTimeout(DelayKt.toDelayMillis-LRDsOJo(timeout), obj1, $completion);
    }

    public static final <T> Object withTimeoutOrNull(long l, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> function22, Continuation<? super T> continuation3) {
        boolean anon;
        int element;
        int i2;
        int objectRef;
        kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1 time;
        int i;
        kotlinx.coroutines.TimeoutCoroutine timeoutCoroutine;
        Object obj7;
        Object obj8;
        Object obj10;
        anon = obj10;
        i2 = Integer.MIN_VALUE;
        if (obj10 instanceof TimeoutKt.withTimeoutOrNull.1 && label &= i2 != 0) {
            anon = obj10;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj10 -= i2;
            } else {
                anon = new TimeoutKt.withTimeoutOrNull.1(obj10);
            }
        } else {
        }
        obj10 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                return null;
                objectRef = new Ref.ObjectRef();
                anon.L$0 = continuation3;
                anon.L$1 = objectRef;
                anon.J$0 = l;
                anon.label = 1;
                i = 0;
                timeoutCoroutine = new TimeoutCoroutine(l, function22, (Continuation)anon);
                objectRef.element = timeoutCoroutine;
                obj7 = TimeoutKt.setupTimeout(timeoutCoroutine, continuation3);
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
                return cOROUTINE_SUSPENDED;
                obj8 = obj7;
                obj7 = objectRef;
                break;
            case 1:
                obj7 = anon.J$0;
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                obj8 = obj10;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        return obj8;
    }

    public static final <T> Object withTimeoutOrNull-KLykuaI(long timeout, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        return TimeoutKt.withTimeoutOrNull(DelayKt.toDelayMillis-LRDsOJo(timeout), obj1, $completion);
    }
}
