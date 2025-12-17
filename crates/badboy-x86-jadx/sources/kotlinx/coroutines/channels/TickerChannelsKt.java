package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TickerChannelsKt {
    public static final Object access$fixedDelayTicker(long delayMillis, long initialDelayMillis, kotlinx.coroutines.channels.SendChannel channel, Continuation $completion) {
        return TickerChannelsKt.fixedDelayTicker(delayMillis, initialDelayMillis, channel, $completion);
    }

    public static final Object access$fixedPeriodTicker(long delayMillis, long initialDelayMillis, kotlinx.coroutines.channels.SendChannel channel, Continuation $completion) {
        return TickerChannelsKt.fixedPeriodTicker(delayMillis, initialDelayMillis, channel, $completion);
    }

    private static final Object fixedDelayTicker(long l, long l2, kotlinx.coroutines.channels.SendChannel<? super Unit> sendChannel3, Continuation<? super Unit> continuation4) {
        boolean anon;
        int i;
        int i2;
        int label;
        long obj3;
        Object obj5;
        long obj6;
        Object obj7;
        Object obj8;
        anon = obj8;
        i2 = Integer.MIN_VALUE;
        if (obj8 instanceof TickerChannelsKt.fixedDelayTicker.1 && label2 &= i2 != 0) {
            anon = obj8;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj8 -= i2;
            } else {
                anon = new TickerChannelsKt.fixedDelayTicker.1(obj8);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                anon.L$0 = obj7;
                anon.J$0 = l;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = obj7;
                break;
            case 1:
                obj3 = anon.J$0;
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            case 2:
                obj3 = anon.J$0;
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                anon.L$0 = obj5;
                anon.J$0 = obj3;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                anon.L$0 = obj5;
                anon.J$0 = obj3;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                break;
            case 3:
                obj3 = anon.J$0;
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                anon.L$0 = obj5;
                anon.J$0 = obj3;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                anon.L$0 = obj5;
                anon.J$0 = obj3;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                break;
            default:
                obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj3;
        }
    }

    private static final Object fixedPeriodTicker(long l, long l2, kotlinx.coroutines.channels.SendChannel<? super Unit> sendChannel3, Continuation<? super Unit> continuation4) {
        boolean anon;
        int i2;
        int i3;
        long delayToNanos;
        long nanoTime2;
        long nanoTime;
        int coerceAtLeast;
        int i;
        int cmp;
        int cmp2;
        int obj9;
        int obj11;
        long obj12;
        Object obj13;
        Object obj14;
        anon = obj14;
        i3 = Integer.MIN_VALUE;
        if (obj14 instanceof TickerChannelsKt.fixedPeriodTicker.1 && label &= i3 != 0) {
            anon = obj14;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj14 -= i3;
            } else {
                anon = new TickerChannelsKt.fixedPeriodTicker.1(obj14);
            }
        } else {
        }
        obj14 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (delayToNanos) {
            case 0:
                ResultKt.throwOnFailure(obj14);
                AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                nanoTime = timeSource2.nanoTime();
                nanoTime = System.nanoTime();
                nanoTime += delayToNanos2;
                anon.L$0 = obj13;
                anon.J$0 = l;
                anon.J$1 = delayToNanos;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj11 = l;
                obj9 = delayToNanos;
                break;
            case 1:
                obj9 = anon.J$1;
                obj11 = anon.J$0;
                obj13 = anon.L$0;
                ResultKt.throwOnFailure(obj14);
                break;
            case 2:
                obj9 = anon.J$1;
                obj11 = anon.J$0;
                obj13 = anon.L$0;
                ResultKt.throwOnFailure(obj14);
                obj9 += delayToNanos;
                anon.L$0 = obj13;
                anon.J$0 = obj9;
                anon.J$1 = delayToNanos;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj11 = obj9;
                obj9 = delayToNanos;
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                nanoTime2 = timeSource.nanoTime();
                nanoTime2 = System.nanoTime();
                cmp = 0;
                coerceAtLeast = RangesKt.coerceAtLeast(obj11 - nanoTime2, obj5);
                coerceAtLeast = obj9 - i5;
                obj11 = nanoTime2 + coerceAtLeast;
                anon.L$0 = obj13;
                anon.J$0 = obj11;
                anon.J$1 = obj9;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                delayToNanos = obj9;
                obj9 = obj11;
                anon.L$0 = obj13;
                anon.J$0 = obj11;
                anon.J$1 = obj9;
                anon.label = 4;
                return cOROUTINE_SUSPENDED;
                delayToNanos = obj9;
                obj9 = obj11;
                break;
            case 3:
                obj13 = anon.L$0;
                ResultKt.throwOnFailure(obj14);
                delayToNanos = obj9;
                obj9 = obj11;
                obj9 += delayToNanos;
                anon.L$0 = obj13;
                anon.J$0 = obj9;
                anon.J$1 = delayToNanos;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj11 = obj9;
                obj9 = delayToNanos;
                timeSource = AbstractTimeSourceKt.getTimeSource();
                nanoTime2 = timeSource.nanoTime();
                nanoTime2 = System.nanoTime();
                cmp = 0;
                coerceAtLeast = RangesKt.coerceAtLeast(obj11 - nanoTime2, obj5);
                coerceAtLeast = obj9 - i5;
                obj11 = nanoTime2 + coerceAtLeast;
                anon.L$0 = obj13;
                anon.J$0 = obj11;
                anon.J$1 = obj9;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                delayToNanos = obj9;
                obj9 = obj11;
                anon.L$0 = obj13;
                anon.J$0 = obj11;
                anon.J$1 = obj9;
                anon.label = 4;
                return cOROUTINE_SUSPENDED;
                delayToNanos = obj9;
                obj9 = obj11;
                break;
            case 4:
                obj13 = anon.L$0;
                ResultKt.throwOnFailure(obj14);
                delayToNanos = obj9;
                obj9 = obj11;
                obj9 += delayToNanos;
                anon.L$0 = obj13;
                anon.J$0 = obj9;
                anon.J$1 = delayToNanos;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj11 = obj9;
                obj9 = delayToNanos;
                timeSource = AbstractTimeSourceKt.getTimeSource();
                nanoTime2 = timeSource.nanoTime();
                nanoTime2 = System.nanoTime();
                cmp = 0;
                coerceAtLeast = RangesKt.coerceAtLeast(obj11 - nanoTime2, obj5);
                coerceAtLeast = obj9 - i5;
                obj11 = nanoTime2 + coerceAtLeast;
                anon.L$0 = obj13;
                anon.J$0 = obj11;
                anon.J$1 = obj9;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                delayToNanos = obj9;
                obj9 = obj11;
                anon.L$0 = obj13;
                anon.J$0 = obj11;
                anon.J$1 = obj9;
                anon.label = 4;
                return cOROUTINE_SUSPENDED;
                delayToNanos = obj9;
                obj9 = obj11;
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(obj11);
    }

    public static final kotlinx.coroutines.channels.ReceiveChannel<Unit> ticker(long delayMillis, long initialDelayMillis, CoroutineContext context, kotlinx.coroutines.channels.TickerMode mode) {
        int i;
        int i2;
        int i3 = 0;
        int i12 = 0;
        i = Long.compare(delayMillis, i3) >= 0 ? i2 : i12;
        String str = " ms";
        if (i == 0) {
        } else {
            if (Long.compare(context, i3) >= 0) {
            } else {
                i2 = i12;
            }
            if (i2 == 0) {
            } else {
                int i8 = context;
                TickerChannelsKt.ticker.3 anon = new TickerChannelsKt.ticker.3(obj18, delayMillis, i2, i8, obj5, 0);
                int i6 = i13;
                return ProduceKt.produce((CoroutineScope)GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(obj17), i12, (Function2)anon);
            }
            CoroutineContext context3 = obj17;
            int i10 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Expected non-negative initial delay, but has ").append(context).append(str).toString().toString());
            throw illegalArgumentException2;
        }
        int i4 = context;
        CoroutineContext context2 = obj17;
        int i9 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected non-negative delay, but has ").append(delayMillis).append(str).toString().toString());
        throw illegalArgumentException;
    }

    public static kotlinx.coroutines.channels.ReceiveChannel ticker$default(long l, long l2, CoroutineContext coroutineContext3, kotlinx.coroutines.channels.TickerMode tickerMode4, int i5, Object object6) {
        long obj2;
        EmptyCoroutineContext obj4;
        kotlinx.coroutines.channels.TickerMode obj5;
        if (obj6 & 2 != 0) {
            obj2 = l;
        }
        if (obj6 & 4 != 0) {
            obj4 = EmptyCoroutineContext.INSTANCE;
        }
        if (obj6 &= 8 != 0) {
            obj5 = TickerMode.FIXED_PERIOD;
        }
        return TickerChannelsKt.ticker(l, l2, obj2, tickerMode4);
    }
}
