package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a2\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u001a:\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0008\u0008\u001a&\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0007\u001a3\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a7\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0008\r\u001a$\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0005H\u0000\u001a&\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0007\u001a3\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\n\u001a3\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\n\u001a3\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\n\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "Lkotlin/Function1;", "", "timeout", "Lkotlin/time/Duration;", "debounceDuration", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "period", "sample-HG0u8IE", "timeout-HG0u8IE", "timeoutInternal", "timeoutInternal-HG0u8IE$FlowKt__DelayKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DelayKt {
    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce, long timeoutMillis) {
        int i;
        int i2 = 0;
        i = Long.compare(timeoutMillis, i2) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            if (Long.compare(timeoutMillis, i2) == 0) {
                return $this$debounce;
            }
            FlowKt__DelayKt.debounce.2 anon = new FlowKt__DelayKt.debounce.2(timeoutMillis, obj5);
            return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt($this$debounce, (Function1)anon);
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireFlowKt__DelayKt$debounce$1 = new IllegalArgumentException("Debounce timeout should not be negative".toString());
        throw $i$a$RequireFlowKt__DelayKt$debounce$1;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce, Function1<? super T, Long> timeoutMillis) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt($this$debounce, timeoutMillis);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce-HG0u8IE(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce_u2dHG0u8IE, long timeout) {
        return FlowKt.debounce($this$debounce_u2dHG0u8IE, DelayKt.toDelayMillis-LRDsOJo(timeout));
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounceDuration(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce, Function1<? super T, Duration> timeout) {
        FlowKt__DelayKt.debounce.3 anon = new FlowKt__DelayKt.debounce.3(timeout);
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt($this$debounce, (Function1)anon);
    }

    private static final <T> kotlinx.coroutines.flow.Flow<T> debounceInternal$FlowKt__DelayKt(kotlinx.coroutines.flow.Flow<? extends T> $this$debounceInternal, Function1<? super T, Long> timeoutMillisSelector) {
        FlowKt__DelayKt.debounceInternal.1 anon = new FlowKt__DelayKt.debounceInternal.1(timeoutMillisSelector, $this$debounceInternal, 0);
        return FlowCoroutineKt.scopedFlow((Function3)anon);
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope $this$fixedPeriodTicker, long delayMillis, long initialDelayMillis) {
        int i;
        int i2;
        int i3 = 0;
        final int i8 = 0;
        i = Long.compare(delayMillis, i3) >= 0 ? i2 : i8;
        String str = " ms";
        if (i == 0) {
        } else {
            if (Long.compare(obj14, i3) >= 0) {
            } else {
                i2 = i8;
            }
            if (i2 == 0) {
            } else {
                FlowKt__DelayKt.fixedPeriodTicker.3 anon = new FlowKt__DelayKt.fixedPeriodTicker.3(obj14, i, delayMillis, i8, 0);
                return ProduceKt.produce$default($this$fixedPeriodTicker, 0, 0, (Function2)anon, 1, 0);
            }
            int i5 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Expected non-negative initial delay, but has ").append(obj14).append(str).toString().toString());
            throw illegalArgumentException2;
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected non-negative delay, but has ").append(delayMillis).append(str).toString().toString());
        throw illegalArgumentException;
    }

    public static ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long l2, long l3, int i4, Object object5) {
        long obj3;
        if (obj5 &= 2 != 0) {
            obj3 = l2;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, l2, l3);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> sample(kotlinx.coroutines.flow.Flow<? extends T> $this$sample, long periodMillis) {
        int i;
        i = Long.compare(periodMillis, i2) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            FlowKt__DelayKt.sample.2 anon = new FlowKt__DelayKt.sample.2(periodMillis, obj4, $this$sample, 0);
            return FlowCoroutineKt.scopedFlow((Function3)anon);
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireFlowKt__DelayKt$sample$1 = new IllegalArgumentException("Sample period should be positive".toString());
        throw $i$a$RequireFlowKt__DelayKt$sample$1;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> sample-HG0u8IE(kotlinx.coroutines.flow.Flow<? extends T> $this$sample_u2dHG0u8IE, long period) {
        return FlowKt.sample($this$sample_u2dHG0u8IE, DelayKt.toDelayMillis-LRDsOJo(period));
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> timeout-HG0u8IE(kotlinx.coroutines.flow.Flow<? extends T> $this$timeout_u2dHG0u8IE, long timeout) {
        return FlowKt__DelayKt.timeoutInternal-HG0u8IE$FlowKt__DelayKt($this$timeout_u2dHG0u8IE, timeout);
    }

    private static final <T> kotlinx.coroutines.flow.Flow<T> timeoutInternal-HG0u8IE$FlowKt__DelayKt(kotlinx.coroutines.flow.Flow<? extends T> $this$timeoutInternal_u2dHG0u8IE, long timeout) {
        FlowKt__DelayKt.timeoutInternal.1 anon = new FlowKt__DelayKt.timeoutInternal.1(timeout, obj4, $this$timeoutInternal_u2dHG0u8IE, 0);
        return FlowCoroutineKt.scopedFlow((Function3)anon);
    }
}
