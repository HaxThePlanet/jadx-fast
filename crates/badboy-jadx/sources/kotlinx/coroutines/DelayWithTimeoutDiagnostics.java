package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008a\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008\u0019¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "timeoutMessage", "", "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DelayWithTimeoutDiagnostics extends kotlinx.coroutines.Delay {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        public static Object delay(kotlinx.coroutines.DelayWithTimeoutDiagnostics $this, long time, Continuation<? super Unit> $completion) {
            Object delay2 = Delay.DefaultImpls.delay((Delay)$this, time, $completion);
            if (delay2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return delay2;
            }
            return Unit.INSTANCE;
        }

        public static kotlinx.coroutines.DisposableHandle invokeOnTimeout(kotlinx.coroutines.DelayWithTimeoutDiagnostics $this, long timeMillis, Runnable block, CoroutineContext context) {
            return Delay.DefaultImpls.invokeOnTimeout((Delay)$this, timeMillis, block, context);
        }
    }
    @Override // kotlinx.coroutines.Delay
    public abstract String timeoutMessage-LRDsOJo(long l);
}
