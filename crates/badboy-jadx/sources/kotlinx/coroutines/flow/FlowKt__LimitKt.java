package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000323\u0008\u0004\u0010\u0004\u001a-\u0008\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u000c\u001a$\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\u0008\u001a\u0002H\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001ap\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032D\u0008\u0001\u0010\u001a\u001a>\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00190\u0013\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b¢\u0006\u0002\u0008\u001cø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001e", d2 = {"collectWhile", "", "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drop", "count", "", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "Lkotlinx/coroutines/flow/FlowCollector;", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__LimitKt {
    public static final Object access$emitAbort$FlowKt__LimitKt(kotlinx.coroutines.flow.FlowCollector $receiver, Object value, Continuation $completion) {
        return FlowKt__LimitKt.emitAbort$FlowKt__LimitKt($receiver, value, $completion);
    }

    public static final <T> Object collectWhile(kotlinx.coroutines.flow.Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        boolean anon;
        Throwable th;
        Object cOROUTINE_SUSPENDED;
        int $i$f$collectWhile;
        int label;
        Object anon2;
        int i;
        int obj5;
        Object obj6;
        Object obj7;
        anon = continuation3;
        $i$f$collectWhile = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__LimitKt.collectWhile.1 && label2 &= $i$f$collectWhile != 0) {
            anon = continuation3;
            $i$f$collectWhile = Integer.MIN_VALUE;
            if (label2 &= $i$f$collectWhile != 0) {
                anon.label = obj7 -= $i$f$collectWhile;
            } else {
                anon = new FlowKt__LimitKt.collectWhile.1(continuation3);
            }
        } else {
        }
        obj7 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                anon2 = new FlowKt__LimitKt.collectWhile.collector.1(function22);
                anon.L$0 = anon2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = label;
                obj6 = anon2;
                break;
            case 1:
                obj5 = 0;
                obj6 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object collectWhile$$forInline(kotlinx.coroutines.flow.Flow<? extends T> $this$collectWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, Continuation<? super Unit> $completion) {
        kotlinx.coroutines.flow.FlowKt__LimitKt.collectWhile.collector.1 anon;
        kotlinx.coroutines.flow.FlowCollector flowCollector;
        final int i = 0;
        FlowKt__LimitKt.collectWhile.collector.1 anon2 = new FlowKt__LimitKt.collectWhile.collector.1(predicate);
        $this$collectWhile.collect((FlowCollector)anon2, $completion);
        return Unit.INSTANCE;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> drop(kotlinx.coroutines.flow.Flow<? extends T> $this$drop, int count) {
        int i;
        i = count >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            int i3 = 0;
            FlowKt__LimitKt.drop$$inlined.unsafeFlow.1 anon = new FlowKt__LimitKt.drop$$inlined.unsafeFlow.1($this$drop, count);
            return (Flow)anon;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Drop count should be non-negative, but had ").append(count).toString().toString());
        throw illegalArgumentException;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> dropWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$dropWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        final int i = 0;
        FlowKt__LimitKt.dropWhile$$inlined.unsafeFlow.1 anon = new FlowKt__LimitKt.dropWhile$$inlined.unsafeFlow.1($this$dropWhile, predicate);
        return (Flow)anon;
    }

    private static final <T> Object emitAbort$FlowKt__LimitKt(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, T t2, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i2;
        int i;
        int label;
        Object obj3;
        Object obj4;
        Object obj5;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__LimitKt.emitAbort.1 && label2 &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj5 -= i;
            } else {
                anon = new FlowKt__LimitKt.emitAbort.1(continuation3);
            }
        } else {
        }
        obj5 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj5);
                anon.L$0 = flowCollector;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj3 = anon.L$0;
                ResultKt.throwOnFailure(obj5);
                break;
            default:
                obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj3;
        }
        obj4 = new AbortFlowException(obj3);
        throw obj4;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> take(kotlinx.coroutines.flow.Flow<? extends T> $this$take, int count) {
        int i;
        i = count > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            int i3 = 0;
            FlowKt__LimitKt.take$$inlined.unsafeFlow.1 anon = new FlowKt__LimitKt.take$$inlined.unsafeFlow.1($this$take, count);
            return (Flow)anon;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Requested element count ").append(count).append(" should be positive").toString().toString());
        throw illegalArgumentException;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> takeWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$takeWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        final int i = 0;
        FlowKt__LimitKt.takeWhile$$inlined.unsafeFlow.1 anon = new FlowKt__LimitKt.takeWhile$$inlined.unsafeFlow.1($this$takeWhile, predicate);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transformWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$transformWhile, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> transform) {
        FlowKt__LimitKt.transformWhile.1 anon = new FlowKt__LimitKt.transformWhile.1($this$transformWhile, transform, 0);
        return FlowKt.flow((Function2)anon);
    }
}
